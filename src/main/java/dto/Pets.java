package dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pets {


        public static final int PET_ID = 0;
        public static final String PET_NAME = "doggie";
        public static final String PET_STATUS = "available";

        public static final PetCategory PET_CATEGORY = new PetCategory(0, "string");
        public static final List<String> PET_PHOTO_URLS = Collections.singletonList("string");
        public static final List<PetTag> PET_TAGS = Collections.singletonList(new PetTag(0, "string"));
    }

