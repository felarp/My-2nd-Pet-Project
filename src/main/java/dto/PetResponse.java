package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Tag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class PetResponse extends ResponseType{

    private long id;
    private PetClassification category;
    private String name;
    private List<String> photoUrls;
    private List <PetTag> tags;
    private String status;
}
