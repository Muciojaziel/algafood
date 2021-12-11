package com.algaworks.algafood.api.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {

    private Integer status;
    private String title;
    private String type;
    private String detail;
}
