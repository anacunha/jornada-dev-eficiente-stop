package com.deveficiente.stop.room;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final LettersValidator validLettersValidator;

    public RoomController(final LettersValidator validLettersValidator) {
        this.validLettersValidator = validLettersValidator;
    }

    @InitBinder
    public void init(final WebDataBinder binder) {
        binder.addValidators(validLettersValidator);
    }

    @PostMapping
    public String create(@RequestBody @Valid final CreateRoomRequest request) {
        return request.toString();
    }
}
