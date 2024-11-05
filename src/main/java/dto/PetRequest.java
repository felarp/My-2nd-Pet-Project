package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter

@AllArgsConstructor

public class PetRequest {

    private int id;
    private PetCategory category;
    private String name;
    private List<String> photoUrls;
    private List<PetTag> tags;
    private String status;


}