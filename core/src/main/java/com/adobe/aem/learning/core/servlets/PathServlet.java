package com.adobe.aem.learning.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Servlet.class)
@SlingServletPaths("/learning/pathServlet")
@ServiceDescription("Register servlet using path")
public class PathServlet extends SlingSafeMethodsServlet {

    private static final Logger logger = LoggerFactory.getLogger(PathServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            final ResourceResolver resourceResolver = request.getResourceResolver();
            final Resource resource = resourceResolver.getResource("/content/learning/us/en/learning/jcr:content");

            final String path = resource.getPath();
            final String name = resource.getName();
            final String resourceType = resource.getResourceType();

            logger.info("Hari --- resource path -- " + path);
            final ValueMap valueMap = resource.getValueMap();

            final Iterable<Resource> childRes = resource.getChildren();

            final String property = valueMap.get("cq:template", String.class);
            final boolean isContainsKey = valueMap.containsKey("cq:template");
            final boolean isContainsValue = valueMap.containsValue("");

            final String empty = valueMap.getOrDefault("title", "This field is empty").toString();

            final Resource res = resourceResolver.getResource("/content/learning/us/en/learning/jcr:content/root/responsivegrid");
            final Iterable<Resource> iterator = resourceResolver.getChildren(res);

            final PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

            final Page containginPage = pageManager.getContainingPage(res);

            final String language = containginPage.getLanguage().getLanguage();

            final Page page = containginPage.getAbsoluteParent(2);
            final int depth = containginPage.getDepth();
            response.getWriter().println("This is an example of path servlet");
        } catch (final Exception e) {
            logger.error("Exception in doGet method", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}