package com.adobe.aem.learning.core.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.resource.api.JcrResourceConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;

@Component(service = QueryBuilderService.class, immediate = true)
public class QueryBuilderServiceImpl implements QueryBuilderService {

    private static final Logger logger = LoggerFactory.getLogger(QueryBuilderServiceImpl.class);
    private static final String SERVICE_USER = "pageServiceUser";

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Reference
    private QueryBuilder queryBuilder;

    @Override
    public List<String> getListPages() {
        final List<String> paths = new ArrayList<>();
        try (final ResourceResolver resourceResolver = this.resourceResolverFactory.getServiceResourceResolver(
          Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, SERVICE_USER))) {
            final Session session = resourceResolver.adaptTo(Session.class);
            if (Objects.nonNull(this.queryBuilder)) {

                // Create Query Parameters
                final Map<String, String> queryParameterMap = new HashMap<>();
                queryParameterMap.put("path", "/content/learning/us");
                queryParameterMap.put("type", JcrConstants.NT_UNSTRUCTURED);
                queryParameterMap.put("property", JcrResourceConstants.SLING_RESOURCE_TYPE_PROPERTY);
                queryParameterMap.put("property.value", "learning/components/title");
                queryParameterMap.put("p.limit", "-1");

                // Create Query builder for the above parameters
                final PredicateGroup predicateGroup = PredicateGroup.create(queryParameterMap);

                // Execute the Query
                final Query query = this.queryBuilder.createQuery(predicateGroup, session);

                // Get the Result or Verify the result
                final Iterator<Resource> resourceIterator = query.getResult().getResources();

                resourceIterator.forEachRemaining(resource -> paths.add(resource.getPath()));
            }
        } catch (final LoginException e) {
            logger.error("Failed to get resource resolver, login failed.", e);
        }

        return paths;
    }

}
