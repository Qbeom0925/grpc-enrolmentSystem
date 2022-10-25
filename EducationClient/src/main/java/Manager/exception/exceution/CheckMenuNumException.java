package Manager.exception.exceution;


import Manager.exception.ManagerException;

import static Manager.exception.ManagerExceptionList.CHECK_NUM;


public class CheckMenuNumException extends ManagerException {

    public CheckMenuNumException() {
        super(CHECK_NUM.getErrorCode(),
                CHECK_NUM.getMessage());
    }
}
