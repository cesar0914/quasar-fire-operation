package co.com.mercadolibre.quasarfireoperation.utils;

public class DocumentationConstant {
    public static final String GET_TOP_SECRET_OK_EXAMPLE = "{\"position\":{\"x\":-100,\"y\":75.5},\"message\":\"este es un mensaje secreto\"}";
    public static final String GET_TOP_SECRET_BAD_REQUEST_EXAMPLE = "{\"code\":400,\"httpStatus\":\"BAD_REQUEST\",\"message\":\"El valor de la distancia debe ser positivo.\"}";
    public static final String GET_TOP_SECRET_POSITION_NOT_FOUND_EXAMPLE = "{\"code\":404,\"httpStatus\":\"NOT_FOUND\",\"message\":\"No fue posible determinar la posición del emisor.\"}";
    public static final String GET_TOP_SECRET_MESSAGE_NOT_FOUND_EXAMPLE = "{\"code\":404,\"httpStatus\":\"NOT_FOUND\",\"message\":\"No fue posible determinar el mensaje.\"}";
    public static final String INTERNAL_SERVER_ERROR_EXAMPLE = "{\"code\":500,\"httpStatus\":\"INTERNAL_SERVER_ERROR\",\"message\":\"Se ha presentado un error interno.\"}";
    public static final String GET_TOP_SECRET_SPLIT_NOT_FOUND_INFO_EXAMPLE = "{\"code\":404,\"httpStatus\":\"NOT_FOUND\",\"message\":\"No existe suficiente información para determinar la posición y el mensaje del emisor.\"}";
}
