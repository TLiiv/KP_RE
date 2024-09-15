package dev.tliiv.real_estate;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
       return new ResponseEntity<List<User>>(userService.allUsers(),HttpStatus.OK);
    }

    @GetMapping("/{userId}/owned-residencies")
    public List<Residency> getUserOwnedResidencies(@PathVariable ObjectId userId){
        return userService.getUserOwnedResidencies(userId);
    }

    @GetMapping("/{userId}/fav-residencies")
    public List<Residency> getUserFavResidencies(@PathVariable ObjectId userId){
        return userService.getUserFavResidencies(userId);
    }
}
