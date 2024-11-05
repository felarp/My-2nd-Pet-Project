package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class PetTag {

    private int id;
    private String name;

    public PetTag(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
