// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EducationService.proto

package com.grpc.education;

public interface GetAllCoursesDataResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:education.GetAllCoursesDataResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .education.GetAllCoursesDataResponse.Course courses = 2;</code>
   */
  java.util.List<com.grpc.education.GetAllCoursesDataResponse.Course> 
      getCoursesList();
  /**
   * <code>repeated .education.GetAllCoursesDataResponse.Course courses = 2;</code>
   */
  com.grpc.education.GetAllCoursesDataResponse.Course getCourses(int index);
  /**
   * <code>repeated .education.GetAllCoursesDataResponse.Course courses = 2;</code>
   */
  int getCoursesCount();
  /**
   * <code>repeated .education.GetAllCoursesDataResponse.Course courses = 2;</code>
   */
  java.util.List<? extends com.grpc.education.GetAllCoursesDataResponse.CourseOrBuilder> 
      getCoursesOrBuilderList();
  /**
   * <code>repeated .education.GetAllCoursesDataResponse.Course courses = 2;</code>
   */
  com.grpc.education.GetAllCoursesDataResponse.CourseOrBuilder getCoursesOrBuilder(
      int index);
}