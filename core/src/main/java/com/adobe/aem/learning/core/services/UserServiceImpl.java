package com.adobe.aem.learning.core.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = UserService.class, immediate = true)
@Designate(ocd = UserServiceConfig.class)
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String SERVICE_USER = "pageServiceUser";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    private String pagePath;

    @Override
    public List<String> getChildPages() {
        final List<String> paths = new ArrayList<>();
        try (final ResourceResolver resourceResolver = this.resourceResolverFactory.getServiceResourceResolver(
          Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, SERVICE_USER))) {
            final Resource resource = resourceResolver.getResource(this.pagePath);
            final PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            if (pageManager != null) {
                final Page page = pageManager.getContainingPage(resource);
                if (page != null) {
                    final Iterator<Page> pages = page.listChildren();
                    pages.forEachRemaining(p -> paths.add(p.getPath()));

                }
            }
        } catch (final LoginException e) {
            logger.error("Failed to get resource resolver, login failed.", e);
        }
        return paths;
    }

    @Activate
    protected void activate(final UserServiceConfig config) {
        this.pagePath = config.pagePath();
        logger.info("activate");
    }

}