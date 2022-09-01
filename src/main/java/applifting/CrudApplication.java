package applifting;


/**
 *
 * Java task
 *
 * Endpoints monitoring service
 * The task is to create a REST API JSON Java microservice which allows you to monitor
 * particular http/https URLs.
 * The service should allow you to
 * - create, edit and delete monitored URLs and list them for a particular user (CRUD),
 * - monitor URLs in the background and log status codes + the returned payload,
 * - and to list the last 10 monitored results for each particular monitored URL.
 *
 **/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

}
