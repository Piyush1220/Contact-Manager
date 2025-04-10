package com.scm.backend;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return new RepositoryRestConfigurer() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

               //config AppConstants to this class
                //this is usefull when your all config write one class access to this class
                config.setBasePath(AppConstants.REST_BASE_PATH);
                config.exposeIdsFor(User.class,Contact.class);
              //  config.getProjectionConfiguration().addProjection(UserProjection.class);



            }
        };

    }
}
