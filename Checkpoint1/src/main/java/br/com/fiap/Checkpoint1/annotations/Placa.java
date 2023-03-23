package br.com.fiap.Checkpoint1.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Size(max = 7, min = 7)
@Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}$")
public @interface Placa {

    String message() default "Campo placa deve ter no máximo 7 caracteres, pode conter somente números e letras sem caracteres especiais";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


