package com.adobe.aem.learning.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = LearningService.class, immediate = true)
@Designate(ocd = LearningConfigurations.class)
public class LearningServiceImpl implements LearningService {

    private LearningConfigurations config;

    @Activate
    protected void activate(final LearningConfigurations config) {
        this.config = config;
    }

    @Override
    public String getCourseName() {
        return this.config.courseName();
    }

    @Override
    public String getCourseDuration() {
        return this.config.courseDuration();
    }

    @Override
    public String getCourseRequirement() {
        return this.config.courseRequirement();
    }

}
