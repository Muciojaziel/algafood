package com.algaworks.algafood.core.validation;

import org.springframework.http.MediaType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { FileContentTypeValidator.class })
public @interface FileContentType {
    String message() default "Arquivo inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] allowed();

}
