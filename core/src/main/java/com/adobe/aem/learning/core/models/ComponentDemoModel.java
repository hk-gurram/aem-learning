package com.adobe.aem.learning.core.models;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ComponentDemoModel {

    private static final Logger logger = LoggerFactory.getLogger(ComponentDemoModel.class);

    @ValueMapValue
    @Default(values = StringUtils.EMPTY)
    private String myTitle;

    @ChildResource
    private List<LinkModel> links;

    public String getMyTitle() {
        return this.myTitle;
    }

    public List<LinkModel> getLinks() {
        return this.links;
    }

}
