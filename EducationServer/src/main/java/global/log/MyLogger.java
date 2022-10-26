package global.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
    // String을 기준으로 Logger 클래스 인스턴스 할당
    Logger logger = Logger.getLogger("EducationService");
    private static MyLogger instance = new MyLogger();

    // Level별 Log를 생성할 파일 지정
    public static final String errorLog = "src/main/log/log.log";
    public static final String warningLog = "src/main/log/warning.log";

    private FileHandler logFile = null;
    private FileHandler warningFile = null;

    private MyLogger() {
        try {
            // path, append 방식으로 생성
            logFile = new FileHandler(errorLog, true);
            warningFile = new FileHandler(warningLog, true);
        }catch(SecurityException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }

        logFile.setFormatter(new SimpleFormatter());
        warningFile.setFormatter(new SimpleFormatter());

        logFile.setLevel(Level.ALL);
        warningFile.setLevel(Level.WARNING);

        logger.addHandler(logFile);
        logger.addHandler(warningFile);
    }

    public static MyLogger getLogger() {
        return instance;
    }

    public void log(String msg, String className, String methodName) {
//        logger.finest(msg);
//        logger.finer(msg);
//        logger.fine(msg);
//        logger.config(msg);
        logger.info(" ClassName : "+className+"  MethodName : "+methodName+"  Message: "+msg);
//        logger.warning(msg);
//        logger.severe(msg);
    }

    public void fine(String msg) {
        logger.fine(msg);
    }

    public void warning(String msg, String className, String methodName) {
        logger.warning(" ClassName : "+className+"  MethodName : "+methodName+"  Message: "+msg);
    }

    public static String getClassName(){
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }

    public static String getMethodName(){
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
