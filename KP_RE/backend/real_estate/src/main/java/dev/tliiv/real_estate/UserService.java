package dev.tliiv.real_estate;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResidencyRepository residencyRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    //fetch user owned residencies
    public List<Residency> getUserOwnedResidencies(ObjectId userId){
        //find user by id
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        //fetch residencies based on stored ID-s
        return residencyRepository.findByIdIn(user.getOwnedResidenciesID());
    }

    //fetch user favorite residencies
    public List<Residency> getUserFavResidencies(ObjectId userId){
        //find user by id
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        //fetch residencies based on stored ID-s
        return residencyRepository.findByIdIn(user.getFavResidenciesID());
    }
}
