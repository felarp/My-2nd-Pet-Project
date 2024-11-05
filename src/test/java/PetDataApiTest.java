import accertions.HttpAssertions;
import dto.PetRequest;
import dto.PetResponse;
import dto.Pets;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class PetDataApiTest extends BaseApiTest{

    @Test
    public void GetPetByStatusTest() {
    Response response = apiProvider.get("/pet/findByStatus/", "available");
        new HttpAssertions(response, PetResponse.class)
                .statusCode(200);

    }

    @Test
    public void addNewPet() {
        PetRequest pet = new PetRequest(
                Pets.PET_ID,
                Pets.PET_CATEGORY,
                Pets.PET_NAME,
                Pets.PET_PHOTO_URLS,
                Pets.PET_TAGS,
                Pets.PET_STATUS);


        Response response = apiProvider.post("/pet", pet);
        validator.validateResponse(response);
    }
}
