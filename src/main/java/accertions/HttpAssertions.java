package accertions;

import dto.ResponseType;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

public class HttpAssertions {

    private final ValidatableResponse validatableResponse;
//    private final Response response;
//    private final ResponseType obj;
    @Getter
    private List <? extends ResponseType> list;


    public HttpAssertions(Response response, Class<?extends ResponseType>cl) {
        this.validatableResponse = response.then();
        this.list = response.jsonPath().getList("",cl);
}
//    public HttpAssertions(Response response, Class<? extends ResponseType>cl, boolean isArray) {
//        this.validatableResponse = response.then();
//        this.response = response;
//        this.obj = null;
//      if (isArray) {
//          this.list = response.jsonPath().getList(".", cl);
//      }else{
//          this.list=null;
//      }
//    }
    @Step("Проверяем, что статус код равен '{expectedStatus}'")

    public HttpAssertions statusCode(int expectedStatus) {
        validatableResponse.statusCode(expectedStatus);
        return this;
    }
    @Step("Проверяем, что коллекция не пуста")
    public HttpAssertions assertListNotEmpty() {
        if(list != null)
            Assertions.assertFalse(list.isEmpty(), "Коллекция пуста");
            return this;

    }
    @Step("Проверяем,что ответ не пустой")
    public HttpAssertions assertJsonPathValueNotEmpty(String path) {
        validatableResponse.body(path,not(emptyOrNullString()));
        return this;
    }
//    @Step("Проверяем сообщение '{expectedMessage}'")
//    public HttpAssertions assertionMessage(String expectedMessage) {
//        Assertions.assertEquals(.getMessage(), expectedMessage, "Сообщение не совпадает");
//        return this;
//    }

}
