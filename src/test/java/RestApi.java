import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestApi {

    private final static String getUrl = "https://postman-echo.com";

    @Test
    public void verifiedRequestWoops() {

        given()
                .baseUri(getUrl)
                .basePath("/get")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-request-start", (matchesPattern("\\w{1,}[\\.]{1}\\w{1,3}")))
                .and().body("headers.connection", equalTo("close"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.x-amzn-trace-id", matchesPattern("\\w{1,4}[\\=]+\\w+[\\-]+\\w{1,}[\\-]+\\w{1,}"))
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", any(String.class))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void givenRequest() {
        given()
                .baseUri(getUrl)
                .basePath("/get")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .contentType(ContentType.JSON)
                .when().get()
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.x-request-start", (matchesPattern("\\w{1,}[\\.]+\\w{1,}")))
                .and().body("headers.connection", equalTo("close"))
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.x-amzn-trace-id", matchesPattern("\\w{1,4}[\\=]+\\w+[\\-]+\\w{1,}[\\-]+\\w{1,}"))
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", any(String.class))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void verifiedPostRowText() {
        String l = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(getUrl)
                .basePath("/post")
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when().post()
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
//                .and().body("$", hasKey("args"))
//                .and().body("$", hasKey("files"))
//                .and().body("$", hasKey("form"))
//                .and().body("headers.host", containsString("postman-echo.com"))
//                .and().body("headers.x-request-start", (matchesPattern("\\w{1,}[\\.]+\\w{1,}")))
//                .and().body("headers.connection", equalTo("close"))
//                .and().body("headers.content-length", equalTo(l.length()))
//                .and().body("headers.x-forwarded-proto", equalTo("https"))
//                .and().body("headers.x-forwarded-port", equalTo("443"))
//                .and().body("headers.x-amzn-trace-id", matchesPattern("\\w{1,4}[\\=]+\\w+[\\-]+\\w{1,}[\\-]+\\w{1,}"))
//                .and().body("headers.content-type", equalTo("application/json"))
//                .and().body("headers.accept", equalTo("*/*"))
//                .and().body("headers.user-agent", any(String.class))
//                .and().body("headers.accept-encoding", equalTo("gzip,deflate"))
                .and().body("json",is(null))
                .and().body("url", equalTo(getUrl+"/post"));
    }

    @Test
    public void verifiedPatch(){

    }


    @Test
    public void verifiedDelete(){
        given()
                .baseUri(getUrl)
                .basePath("/delete")
                .log().body().contentType("application/json")
                .when().delete()
                .then().log().body().statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo("This is expected to be sent back as part of response body."));

    }
}
