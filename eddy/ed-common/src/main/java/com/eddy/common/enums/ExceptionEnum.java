package com.eddy.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_BE_NULL(400, "Price cannot be null"),
    CATEGORY_NOT_FOUND(400, "Category not found!"),
    BRAND_NOT_FOUND(404, "Brand not found!"),
    BRAND_SAVE_ERROR(500, "Brand save error"),
    CATEGORY_BRAND_SAVE_ERROR(500, "Brand Category save error"),
    UPLOAD_ERROR(500, "Upload error"),
    INVALID_FILE_TYPE(400, "Invalid file type")
    ;
    private int code;
    private String msg;
}
