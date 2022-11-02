package Manager.comment;

public interface EducationCode {

    public static final String S200 = "200";

    public static final String S404 = "404";
    public static final String S500 = "500";
    public static final String S405 = "405";
    public static final String S406 = "406";


    public static final String NoDataMajorException = "NoDataMajorException";
    public static final String ValidateStudentNumException = "ValidateStudentNumException";
    public static final String OverlapStudentIdException = "OverlapStudentIdException";
    public static final String NoCourseDataException = "NoCourseDataException";
    public static final String OverlapCourseNumException="OverlapCourseNumException";
    String NoDataPrerequisiteException = "NoDataPrerequisiteException";
    String OverCourseCreditException = "OverCourseCreditException";
}
