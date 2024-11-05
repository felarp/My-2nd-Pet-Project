import accertions.PetSchemaValidator;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import providers.ApiProvider;

public class BaseApiTest {

    protected static ApiProvider apiProvider = new ApiProvider();
    private static final ProjectConfig projectConfig = ConfigFactory.create((ProjectConfig.class));
    protected static final PetSchemaValidator validator = new PetSchemaValidator();

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = projectConfig.baseUrl();
        RestAssured.basePath= "";
        ApiProvider.filters();
    }
}
