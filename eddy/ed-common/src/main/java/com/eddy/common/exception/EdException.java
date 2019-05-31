package com.eddy.common.exception;

import com.eddy.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EdException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
}
