package global.exception;

import global.log.MyLogger;

public abstract class ApplicationException extends Exception{

    final String errorCode;
    final String message;
    public static final String RESET = "\u001B[0m";
    public static final String FONT_RED = "\u001B[31m";

    private MyLogger Logger = MyLogger.getLogger();


    public ApplicationException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        System.out.println(FONT_RED+"*******************************"+RESET);
        System.out.println(FONT_RED+"에러코드: "+ errorCode +"    "+ message+RESET);
    }
}
