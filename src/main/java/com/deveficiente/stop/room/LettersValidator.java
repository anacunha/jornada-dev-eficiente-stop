package com.deveficiente.stop.room;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LettersValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return CreateRoomRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        final CreateRoomRequest request = (CreateRoomRequest) target;
        for (Character letter : request.getLetters()) {
            // Não funfou, considera coisas como ø, å, letras
            if (!Character.isAlphabetic(letter)) {
                errors.rejectValue("letters", null, letter + " is not a valid letter.");
            }
        }

    }
}
