package applifting.service;

/***
 *  Inspiration from these websites
 *
 *  https://www.baeldung.com/spring-scheduled-tasks
 *
 *  https://mkyong.com/java/apache-httpclient-examples/
 *
 *
 *
 *
 */





import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


@Service
public class SpringConfig {

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {

        HttpGet request = new HttpGet("https://t.co/calv72DH8f");

        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            

            // Get HttpResponse Status

            // HTTP/1.1
            System.out.println(response.getProtocolVersion());

            // 301
            System.out.println(response.getStatusLine().getStatusCode());

            // Moved Permanently
            System.out.println(response.getStatusLine().getReasonPhrase());

            // HTTP/1.1 301 Moved Permanently
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    public SpringConfig() throws IOException {




    }
}


