package com.adobe.aem.learning.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Learning Class Configuration")
public @interface LearningConfigurations {

    @AttributeDefinition(name = "Course Name") String courseName() default "AEM - Adobe experience Manager";

    @AttributeDefinition(name = "Course Duration") String courseDuration() default "30 days";

    @AttributeDefinition(name = "Course Requirement") String courseRequirement() default "Core Java, HTML, CSS & Jquery";

}
