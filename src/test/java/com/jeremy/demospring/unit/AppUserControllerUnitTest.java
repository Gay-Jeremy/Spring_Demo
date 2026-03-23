package com.jeremy.demospring.unit;

import com.jeremy.demospring.controller.AppUserController;
import com.jeremy.demospring.mock.MockAppUserDao;
import com.jeremy.demospring.model.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AppUserControllerUnitTest {

    @Test
    public void getUserByExistingId_shouldReturnCode200() {

        AppUserController userController = new AppUserController(new MockAppUserDao());
        ResponseEntity<AppUser> response = userController.get(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getUserByNotExistingId_shouldReturnCode404() {

        AppUserController userController = new AppUserController(new MockAppUserDao());
        ResponseEntity<AppUser> response = userController.get(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());


    }
}
