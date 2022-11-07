package com.examly.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.examly.dao.IUserModel;
import com.examly.model.UserModel;
import com.examly.dao.ILoginModel;
import com.examly.model.LoginModel;
import com.examly.dao.IMusicModel;
import com.examly.model.MusicModel;
import com.examly.dao.ILikeModel;
import com.examly.model.LikeModel;
@RestController
public class UserController {
	@Autowired
	IUserModel user;

	@Autowired
	ILoginModel login;

	@Autowired
	IMusicModel music;

	@Autowired
	ILikeModel like;

	// @GetMapping("/")
	// public String arrayOfUser() {
	// 	return "Welcome SpringBoot LMS";
	// }

	@PostMapping("login")
	public boolean loginRes(@RequestBody LoginModel lm){
		login.saveAndFlush(lm);
            return true;
	} 

	@PostMapping("signup")
	public boolean signUp(@RequestBody UserModel um) {
        user.saveAndFlush(um);
            return true;
	}

	@GetMapping("music")
	public List<MusicModel> arryOfMusic(){
		return music.findAll();
	}

	@GetMapping("music/{id}")
	public String musicDetais(@PathVariable("id")String id) {
		return music.findById(id).get().getMusicName();
         
	}

	@PostMapping("like/{id}")
	public String addLike(@RequestBody LikeModel li,@PathVariable("id")String id) {
        like.saveAndFlush(li);
            return "like added to User";
	}
    @DeleteMapping("like/{id}")
	public String deleteLike(@PathVariable("id")String id) {
		like.deleteById(id);
		return "Like removed";
	}

	// @PostMapping("likedtest/{id}")
	// public String changes(@RequestBody LikeModel li,@PathVariable("id")String id) {
	// 	like.findById(id).map(l -> {
	// 		li.setId(id);
	// 		li.setNoOfLike(l.getNoOfLike());
	// 		li.setLikedUser(l.getLikedUser());
			
	// 		return like.save(li);

	// 	});
	// 	return "like addedd user";
	// }

}
