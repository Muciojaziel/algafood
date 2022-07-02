package com.algaworks.algafood.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { FileSizeValidator.class })
public @interface FileSize {
    String message() default "Tamanho do arquivo inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String max();

}
