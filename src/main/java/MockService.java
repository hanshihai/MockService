import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Body;
import org.mockserver.model.HttpRequest;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.Parameter.param;

public class MockService {

    public static void main(String[] args) {
        if(null == args || args.length < 1) {
            System.out.println("*************** Usage ***********************");
            System.out.println("*** java -jar DefaultMockService.jar port ***");
            System.out.println("*********************************************");
            System.exit(0);
        }

        ClientAndServer server = new ClientAndServer(1080);

        server.when(
                request().withMethod("POST").withPath("/post")
        ).respond(
                response().withStatusCode(201).withBody(request().getBodyAsString())
        );

        server.when(
                request().withMethod("PATCH").withPath("/patch")
        ).respond(
                response().withStatusCode(200).withBody(request().getBodyAsString())
        );

        server.when(
                request().withMethod("PUT").withPath("/put")
        ).respond(
                response().withStatusCode(200).withBody(request().getBodyAsString())
        );

        server.when(
                request().withMethod("GET").withPath("/get")
        ).respond(
                response().withStatusCode(200).withBody("{\"name\":\"value\"}")
        );
    }
}
