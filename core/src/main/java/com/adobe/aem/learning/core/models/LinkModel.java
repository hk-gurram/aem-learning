package com.adobe.aem.learning.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {

    private static final Logger logger = LoggerFactory.getLogger(LinkModel.class);

    @ValueMapValue
    @Default(values = StringUtils.EMPTY)
    private String label;

    @ValueMapValue
    private String linkPath;

    @ValueMapValue
    private String target;

    @ValueMapValue
    private String external;

    public String getLabel() {
        return this.label;
    }

    public String getLinkPath() {
        return this.linkPath;
    }

    public String getTarget() {
        return this.target;
    }

    public String getExternal() {
        return this.external;
    }

}
