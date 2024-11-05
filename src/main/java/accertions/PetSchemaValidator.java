package accertions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetSchemaValidator {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final JsonSchema schema = loadSchema();


    private static JsonSchema loadSchema() {
        try {
            JsonNode schemaNode = mapper.readTree(new File("src/test/resources/pet-schema.json"));
            return JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
        } catch (IOException | ProcessingException e) {
            throw new RuntimeException("Ошибка загрузки схемы: " + e.getMessage(), e);
        }
    }

    public void validateResponse(Response response) {
        try {
            ProcessingReport report = schema.validate(mapper.readTree(response.getBody().asString()));
            assertTrue(report.isSuccess(), "JSON не соответствует схеме: " + report);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка валидации JSON: " + e.getMessage(), e);
        }
    }
}


