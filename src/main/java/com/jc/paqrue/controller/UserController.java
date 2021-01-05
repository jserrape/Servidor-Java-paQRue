package com.jc.paqrue.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.paqrue.model.User;
import com.jc.paqrue.repository.UserRepository;
import com.jc.paqrue.response.BaseResponse;
import com.jc.paqrue.response.ElementResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository repoUser;

	@GetMapping(path = "/rest/user", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Get all users", notes = "Method that get all users", response = User.class)
	public ResponseEntity<BaseResponse> getCatalog() {
		log.debug("REST request to get User get /v1/user");

		HttpStatus status;
		BaseResponse response;

		response = new ElementResponse(repoUser.findAll(), "The list of users");
		status = HttpStatus.OK;

		return new ResponseEntity<>(response, status);
	}

	@PostMapping(path = "/rest/user", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "New user", notes = "Method that saves a new user", response = User.class)
	public ResponseEntity<BaseResponse> newCatalog(@RequestBody User newUser) {
		log.debug("REST request to post /v1/user");

		BaseResponse response;
		HttpStatus status;

		// TODO A�adir try catch
		response = new ElementResponse(repoUser.save(newUser), "Usuario creado");
		status = HttpStatus.OK;

		return new ResponseEntity<>(response, status);
	}
	// @RequestBody User fullName

	@PostMapping(path = "/rest/user/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Login a user", notes = "Method that log a user", response = User.class)
	public ResponseEntity<BaseResponse> loginUser(@RequestBody User userLog) {
		log.debug("REST request to post /rest/user/login");

		BaseResponse response;
		HttpStatus status;

		User user = repoUser.logInUser(userLog.getEmail(), userLog.getPassword());
		if (user == null) { // Usuario o contrase�a incorrectos
			System.out.println("Usuario o contrase�a incorrectos");
			response = new ElementResponse(null, "Error log in");
			status = HttpStatus.BAD_REQUEST;
		} else { // Login ok
			System.out.println("Login ok");
			response = new ElementResponse(user, "Log in OK");
			status = HttpStatus.OK;
		}
		return new ResponseEntity<>(response, status);
	}

	@PostMapping(path = "/rest/user/change_user_name", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Change the user name", notes = "Change the user name", response = User.class)
	public ResponseEntity<BaseResponse> changeUserName(@RequestBody User userDate) {
		log.debug("REST request to post /rest/user/change_user_name");
		System.out.println(userDate);

		BaseResponse response;
		HttpStatus status;

		User user = repoUser.findByEmail(userDate.getEmail());
		System.out.println(user);
		if (user != null) {
			user.setNombre(userDate.getNombre());
			repoUser.save(user);
			System.out.println("Change name ok");
			response = new ElementResponse(null, "Change name ok");
			status = HttpStatus.OK;
		} else {
			System.out.println("Error change name");
			response = new ElementResponse(null, "Error change name");
			status = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, status);
	}

	@PostMapping(path = "/rest/user/change_user_email", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Login a user", notes = "Method that log a user", response = User.class)
	public ResponseEntity<BaseResponse> changeUserEmail(@RequestBody String userEmail) {
		log.debug("REST request to post /rest/user/change_user_email");
		System.out.println(userEmail);

		BaseResponse response;
		HttpStatus status;

		try {
			JSONObject jsonObject = new JSONObject(userEmail);
			System.out.println(jsonObject.get("initEmail"));
			System.out.println(jsonObject.get("finalEmail"));
			User user = repoUser.findByEmail((String) jsonObject.get("initEmail"));
			if(user != null) {
				System.out.println("Change email OK");
				user.setEmail((String) jsonObject.get("finalEmail"));
				repoUser.save(user);
				response = new ElementResponse(null, "Change email OK");
				status = HttpStatus.OK;
			}else {
				System.out.println("Error change email");
				response = new ElementResponse(null, "Error change email");
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = new ElementResponse(null, "Internal server error");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, status);
	}
}
