package posCarRental.utils;

import lombok.Data;

@Data
public class BaseResponse {
    private Boolean success;
    private Object data;
    private String message;
}
