package com.adobe.aem.learning.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "User Service Configuration")
public @interface UserServiceConfig {

    @AttributeDefinition(name = "Page Path") String pagePath() default "/content/learning/us/en";

}
