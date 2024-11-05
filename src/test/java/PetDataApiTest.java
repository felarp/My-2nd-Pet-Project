import accertions.HttpAssertions;
import dto.PetResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class PetDataApiTest extends BaseApiTest{

    @Test
    public void GetPetByStatusTest() {
    Response response = apiProvider.get("/pet/findByStatus/", "available");
        new HttpAssertions(response, PetResponse.class)
                .statusCode(200);

    }
}
