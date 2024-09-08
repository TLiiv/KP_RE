package dev.tliiv.real_estate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
public class User {
    @Id
    private ObjectId id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String image;
    private List<Object> bookedVisits;
    private List<ObjectId> favResidenciesID;

    public User(ObjectId id, String name, String email, String image, List<Object> bookedVisits, List<ObjectId> favResidenciesID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.bookedVisits = bookedVisits;
        this.favResidenciesID = favResidenciesID;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Object> getBookedVisits() {
        return bookedVisits;
    }

    public void setBookedVisits(List<Object> bookedVisits) {
        this.bookedVisits = bookedVisits;
    }

    public List<ObjectId> getFavResidenciesID() {
        return favResidenciesID;
    }

    public void setFavResidenciesID(List<ObjectId> favResidenciesID) {
        this.favResidenciesID = favResidenciesID;
    }
}

