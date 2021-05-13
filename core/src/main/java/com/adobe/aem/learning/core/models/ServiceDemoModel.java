package com.adobe.aem.learning.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.learning.core.services.LearningService;
import com.adobe.aem.learning.core.services.QueryBuilderService;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceDemoModel {

    private static final Logger logger = LoggerFactory.getLogger(ServiceDemoModel.class);

    @ValueMapValue
    @Default(values = StringUtils.EMPTY)
    private String heading;

    @OSGiService
    private LearningService learningService;

    private String courseName;

    private String courseDuration;

    private String courseRequirement;

    private List<String> paths;

    @Self
    private SlingHttpServletRequest request;

    @OSGiService
    private QueryBuilderService queryBuilderService;

    @SlingObject
    private ResourceResolver resourceResolver;

    @PostConstruct
    protected void init() {
        try {
            this.courseName = this.learningService.getCourseName().toUpperCase();
            this.courseDuration = this.learningService.getCourseDuration().toUpperCase();
            this.courseRequirement = this.learningService.getCourseRequirement().toUpperCase();
            this.paths = this.queryBuilderService.getListPages();
        } catch (final Exception e) {
            logger.error("Exception in post construct", e);
        }
    }

    public String getHeading() {
        return this.heading;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseDuration() {
        return this.courseDuration;
    }

    public String getCourseRequirement() {
        return this.courseRequirement;
    }

    public List<String> getPaths() {
        return this.paths;
    }

}
