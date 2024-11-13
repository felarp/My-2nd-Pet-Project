package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PetRequest {

    private int id;
    private PetClassification category;
    private String name;
    private List<String> photoUrls;
    private List<PetTag> tags;
    private String status;


    public PetRequest(int id, PetClassification category, String name, List<String> photoUrls, List<PetTag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}