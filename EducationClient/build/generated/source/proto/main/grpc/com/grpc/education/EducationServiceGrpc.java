package com.grpc.education;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.1)",
    comments = "Source: EducationService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EducationServiceGrpc {

  private EducationServiceGrpc() {}

  public static final String SERVICE_NAME = "education.EducationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.GetAllStudentsDataResponse> getGetAllStudentsDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllStudentsData",
      requestType = com.grpc.education.BasicRequest.class,
      responseType = com.grpc.education.GetAllStudentsDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.GetAllStudentsDataResponse> getGetAllStudentsDataMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.BasicRequest, com.grpc.education.GetAllStudentsDataResponse> getGetAllStudentsDataMethod;
    if ((getGetAllStudentsDataMethod = EducationServiceGrpc.getGetAllStudentsDataMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getGetAllStudentsDataMethod = EducationServiceGrpc.getGetAllStudentsDataMethod) == null) {
          EducationServiceGrpc.getGetAllStudentsDataMethod = getGetAllStudentsDataMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.BasicRequest, com.grpc.education.GetAllStudentsDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllStudentsData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.GetAllStudentsDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("getAllStudentsData"))
              .build();
        }
      }
    }
    return getGetAllStudentsDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.GetAllCoursesDataResponse> getGetAllCoursesDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCoursesData",
      requestType = com.grpc.education.BasicRequest.class,
      responseType = com.grpc.education.GetAllCoursesDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.GetAllCoursesDataResponse> getGetAllCoursesDataMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.BasicRequest, com.grpc.education.GetAllCoursesDataResponse> getGetAllCoursesDataMethod;
    if ((getGetAllCoursesDataMethod = EducationServiceGrpc.getGetAllCoursesDataMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getGetAllCoursesDataMethod = EducationServiceGrpc.getGetAllCoursesDataMethod) == null) {
          EducationServiceGrpc.getGetAllCoursesDataMethod = getGetAllCoursesDataMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.BasicRequest, com.grpc.education.GetAllCoursesDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllCoursesData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.GetAllCoursesDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("getAllCoursesData"))
              .build();
        }
      }
    }
    return getGetAllCoursesDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.AddStudentRequest,
      com.grpc.education.BasicResponse> getAddStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStudent",
      requestType = com.grpc.education.AddStudentRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.AddStudentRequest,
      com.grpc.education.BasicResponse> getAddStudentMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.AddStudentRequest, com.grpc.education.BasicResponse> getAddStudentMethod;
    if ((getAddStudentMethod = EducationServiceGrpc.getAddStudentMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getAddStudentMethod = EducationServiceGrpc.getAddStudentMethod) == null) {
          EducationServiceGrpc.getAddStudentMethod = getAddStudentMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.AddStudentRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.AddStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("addStudent"))
              .build();
        }
      }
    }
    return getAddStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.AddCourseRequest,
      com.grpc.education.BasicResponse> getAddCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCourse",
      requestType = com.grpc.education.AddCourseRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.AddCourseRequest,
      com.grpc.education.BasicResponse> getAddCourseMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.AddCourseRequest, com.grpc.education.BasicResponse> getAddCourseMethod;
    if ((getAddCourseMethod = EducationServiceGrpc.getAddCourseMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getAddCourseMethod = EducationServiceGrpc.getAddCourseMethod) == null) {
          EducationServiceGrpc.getAddCourseMethod = getAddCourseMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.AddCourseRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.AddCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("addCourse"))
              .build();
        }
      }
    }
    return getAddCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.DeleteStudentRequest,
      com.grpc.education.BasicResponse> getDeleteStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteStudent",
      requestType = com.grpc.education.DeleteStudentRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.DeleteStudentRequest,
      com.grpc.education.BasicResponse> getDeleteStudentMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.DeleteStudentRequest, com.grpc.education.BasicResponse> getDeleteStudentMethod;
    if ((getDeleteStudentMethod = EducationServiceGrpc.getDeleteStudentMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getDeleteStudentMethod = EducationServiceGrpc.getDeleteStudentMethod) == null) {
          EducationServiceGrpc.getDeleteStudentMethod = getDeleteStudentMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.DeleteStudentRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.DeleteStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("deleteStudent"))
              .build();
        }
      }
    }
    return getDeleteStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.DeleteCourseRequest,
      com.grpc.education.BasicResponse> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCourse",
      requestType = com.grpc.education.DeleteCourseRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.DeleteCourseRequest,
      com.grpc.education.BasicResponse> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.DeleteCourseRequest, com.grpc.education.BasicResponse> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = EducationServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getDeleteCourseMethod = EducationServiceGrpc.getDeleteCourseMethod) == null) {
          EducationServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.DeleteCourseRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.DeleteCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("deleteCourse"))
              .build();
        }
      }
    }
    return getDeleteCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.AddStudentRequest,
      com.grpc.education.BasicResponse> getUpdateStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStudent",
      requestType = com.grpc.education.AddStudentRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.AddStudentRequest,
      com.grpc.education.BasicResponse> getUpdateStudentMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.AddStudentRequest, com.grpc.education.BasicResponse> getUpdateStudentMethod;
    if ((getUpdateStudentMethod = EducationServiceGrpc.getUpdateStudentMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getUpdateStudentMethod = EducationServiceGrpc.getUpdateStudentMethod) == null) {
          EducationServiceGrpc.getUpdateStudentMethod = getUpdateStudentMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.AddStudentRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.AddStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("updateStudent"))
              .build();
        }
      }
    }
    return getUpdateStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.AddCourseRequest,
      com.grpc.education.BasicResponse> getUpdateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateCourse",
      requestType = com.grpc.education.AddCourseRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.AddCourseRequest,
      com.grpc.education.BasicResponse> getUpdateCourseMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.AddCourseRequest, com.grpc.education.BasicResponse> getUpdateCourseMethod;
    if ((getUpdateCourseMethod = EducationServiceGrpc.getUpdateCourseMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getUpdateCourseMethod = EducationServiceGrpc.getUpdateCourseMethod) == null) {
          EducationServiceGrpc.getUpdateCourseMethod = getUpdateCourseMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.AddCourseRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.AddCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("updateCourse"))
              .build();
        }
      }
    }
    return getUpdateCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.StudentResponse> getGetStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudent",
      requestType = com.grpc.education.BasicRequest.class,
      responseType = com.grpc.education.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.StudentResponse> getGetStudentMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.BasicRequest, com.grpc.education.StudentResponse> getGetStudentMethod;
    if ((getGetStudentMethod = EducationServiceGrpc.getGetStudentMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getGetStudentMethod = EducationServiceGrpc.getGetStudentMethod) == null) {
          EducationServiceGrpc.getGetStudentMethod = getGetStudentMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.BasicRequest, com.grpc.education.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("getStudent"))
              .build();
        }
      }
    }
    return getGetStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.CourseResponse> getGetCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCourse",
      requestType = com.grpc.education.BasicRequest.class,
      responseType = com.grpc.education.CourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.CourseResponse> getGetCourseMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.BasicRequest, com.grpc.education.CourseResponse> getGetCourseMethod;
    if ((getGetCourseMethod = EducationServiceGrpc.getGetCourseMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getGetCourseMethod = EducationServiceGrpc.getGetCourseMethod) == null) {
          EducationServiceGrpc.getGetCourseMethod = getGetCourseMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.BasicRequest, com.grpc.education.CourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.CourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("getCourse"))
              .build();
        }
      }
    }
    return getGetCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.EnrolmentRequest,
      com.grpc.education.BasicResponse> getEnrolmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "enrolment",
      requestType = com.grpc.education.EnrolmentRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.EnrolmentRequest,
      com.grpc.education.BasicResponse> getEnrolmentMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.EnrolmentRequest, com.grpc.education.BasicResponse> getEnrolmentMethod;
    if ((getEnrolmentMethod = EducationServiceGrpc.getEnrolmentMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getEnrolmentMethod = EducationServiceGrpc.getEnrolmentMethod) == null) {
          EducationServiceGrpc.getEnrolmentMethod = getEnrolmentMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.EnrolmentRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "enrolment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.EnrolmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("enrolment"))
              .build();
        }
      }
    }
    return getEnrolmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.BasicResponse> getBasicReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "basicRead",
      requestType = com.grpc.education.BasicRequest.class,
      responseType = com.grpc.education.BasicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.BasicRequest,
      com.grpc.education.BasicResponse> getBasicReadMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.BasicRequest, com.grpc.education.BasicResponse> getBasicReadMethod;
    if ((getBasicReadMethod = EducationServiceGrpc.getBasicReadMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getBasicReadMethod = EducationServiceGrpc.getBasicReadMethod) == null) {
          EducationServiceGrpc.getBasicReadMethod = getBasicReadMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.BasicRequest, com.grpc.education.BasicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "basicRead"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.BasicResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("basicRead"))
              .build();
        }
      }
    }
    return getBasicReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.education.StudentLoginRequest,
      com.grpc.education.StudentResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.grpc.education.StudentLoginRequest.class,
      responseType = com.grpc.education.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.education.StudentLoginRequest,
      com.grpc.education.StudentResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.grpc.education.StudentLoginRequest, com.grpc.education.StudentResponse> getLoginMethod;
    if ((getLoginMethod = EducationServiceGrpc.getLoginMethod) == null) {
      synchronized (EducationServiceGrpc.class) {
        if ((getLoginMethod = EducationServiceGrpc.getLoginMethod) == null) {
          EducationServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<com.grpc.education.StudentLoginRequest, com.grpc.education.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.StudentLoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.education.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EducationServiceMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EducationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EducationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EducationServiceStub>() {
        @java.lang.Override
        public EducationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EducationServiceStub(channel, callOptions);
        }
      };
    return EducationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EducationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EducationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EducationServiceBlockingStub>() {
        @java.lang.Override
        public EducationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EducationServiceBlockingStub(channel, callOptions);
        }
      };
    return EducationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EducationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EducationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EducationServiceFutureStub>() {
        @java.lang.Override
        public EducationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EducationServiceFutureStub(channel, callOptions);
        }
      };
    return EducationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class EducationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllStudentsData(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.GetAllStudentsDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllStudentsDataMethod(), responseObserver);
    }

    /**
     */
    public void getAllCoursesData(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.GetAllCoursesDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCoursesDataMethod(), responseObserver);
    }

    /**
     */
    public void addStudent(com.grpc.education.AddStudentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStudentMethod(), responseObserver);
    }

    /**
     */
    public void addCourse(com.grpc.education.AddCourseRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCourseMethod(), responseObserver);
    }

    /**
     */
    public void deleteStudent(com.grpc.education.DeleteStudentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteStudentMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourse(com.grpc.education.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }

    /**
     */
    public void updateStudent(com.grpc.education.AddStudentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStudentMethod(), responseObserver);
    }

    /**
     */
    public void updateCourse(com.grpc.education.AddCourseRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseMethod(), responseObserver);
    }

    /**
     */
    public void getStudent(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.StudentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentMethod(), responseObserver);
    }

    /**
     */
    public void getCourse(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.CourseResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseMethod(), responseObserver);
    }

    /**
     */
    public void enrolment(com.grpc.education.EnrolmentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnrolmentMethod(), responseObserver);
    }

    /**
     */
    public void basicRead(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBasicReadMethod(), responseObserver);
    }

    /**
     */
    public void login(com.grpc.education.StudentLoginRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.StudentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllStudentsDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.BasicRequest,
                com.grpc.education.GetAllStudentsDataResponse>(
                  this, METHODID_GET_ALL_STUDENTS_DATA)))
          .addMethod(
            getGetAllCoursesDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.BasicRequest,
                com.grpc.education.GetAllCoursesDataResponse>(
                  this, METHODID_GET_ALL_COURSES_DATA)))
          .addMethod(
            getAddStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.AddStudentRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_ADD_STUDENT)))
          .addMethod(
            getAddCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.AddCourseRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_ADD_COURSE)))
          .addMethod(
            getDeleteStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.DeleteStudentRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_DELETE_STUDENT)))
          .addMethod(
            getDeleteCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.DeleteCourseRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_DELETE_COURSE)))
          .addMethod(
            getUpdateStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.AddStudentRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_UPDATE_STUDENT)))
          .addMethod(
            getUpdateCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.AddCourseRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_UPDATE_COURSE)))
          .addMethod(
            getGetStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.BasicRequest,
                com.grpc.education.StudentResponse>(
                  this, METHODID_GET_STUDENT)))
          .addMethod(
            getGetCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.BasicRequest,
                com.grpc.education.CourseResponse>(
                  this, METHODID_GET_COURSE)))
          .addMethod(
            getEnrolmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.EnrolmentRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_ENROLMENT)))
          .addMethod(
            getBasicReadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.BasicRequest,
                com.grpc.education.BasicResponse>(
                  this, METHODID_BASIC_READ)))
          .addMethod(
            getLoginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.education.StudentLoginRequest,
                com.grpc.education.StudentResponse>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   */
  public static final class EducationServiceStub extends io.grpc.stub.AbstractAsyncStub<EducationServiceStub> {
    private EducationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EducationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EducationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllStudentsData(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.GetAllStudentsDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllStudentsDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCoursesData(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.GetAllCoursesDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCoursesDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addStudent(com.grpc.education.AddStudentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCourse(com.grpc.education.AddCourseRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteStudent(com.grpc.education.DeleteStudentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(com.grpc.education.DeleteCourseRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStudent(com.grpc.education.AddStudentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourse(com.grpc.education.AddCourseRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudent(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.StudentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourse(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.CourseResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void enrolment(com.grpc.education.EnrolmentRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnrolmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void basicRead(com.grpc.education.BasicRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBasicReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.grpc.education.StudentLoginRequest request,
        io.grpc.stub.StreamObserver<com.grpc.education.StudentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EducationServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<EducationServiceBlockingStub> {
    private EducationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EducationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EducationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.education.GetAllStudentsDataResponse getAllStudentsData(com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllStudentsDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.GetAllCoursesDataResponse getAllCoursesData(com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCoursesDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse addStudent(com.grpc.education.AddStudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse addCourse(com.grpc.education.AddCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse deleteStudent(com.grpc.education.DeleteStudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse deleteCourse(com.grpc.education.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse updateStudent(com.grpc.education.AddStudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse updateCourse(com.grpc.education.AddCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.StudentResponse getStudent(com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.CourseResponse getCourse(com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse enrolment(com.grpc.education.EnrolmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnrolmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.BasicResponse basicRead(com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBasicReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.education.StudentResponse login(com.grpc.education.StudentLoginRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EducationServiceFutureStub extends io.grpc.stub.AbstractFutureStub<EducationServiceFutureStub> {
    private EducationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EducationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EducationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.GetAllStudentsDataResponse> getAllStudentsData(
        com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllStudentsDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.GetAllCoursesDataResponse> getAllCoursesData(
        com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCoursesDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> addStudent(
        com.grpc.education.AddStudentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> addCourse(
        com.grpc.education.AddCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> deleteStudent(
        com.grpc.education.DeleteStudentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> deleteCourse(
        com.grpc.education.DeleteCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> updateStudent(
        com.grpc.education.AddStudentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> updateCourse(
        com.grpc.education.AddCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.StudentResponse> getStudent(
        com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.CourseResponse> getCourse(
        com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> enrolment(
        com.grpc.education.EnrolmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnrolmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.BasicResponse> basicRead(
        com.grpc.education.BasicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBasicReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.education.StudentResponse> login(
        com.grpc.education.StudentLoginRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_STUDENTS_DATA = 0;
  private static final int METHODID_GET_ALL_COURSES_DATA = 1;
  private static final int METHODID_ADD_STUDENT = 2;
  private static final int METHODID_ADD_COURSE = 3;
  private static final int METHODID_DELETE_STUDENT = 4;
  private static final int METHODID_DELETE_COURSE = 5;
  private static final int METHODID_UPDATE_STUDENT = 6;
  private static final int METHODID_UPDATE_COURSE = 7;
  private static final int METHODID_GET_STUDENT = 8;
  private static final int METHODID_GET_COURSE = 9;
  private static final int METHODID_ENROLMENT = 10;
  private static final int METHODID_BASIC_READ = 11;
  private static final int METHODID_LOGIN = 12;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EducationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EducationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_STUDENTS_DATA:
          serviceImpl.getAllStudentsData((com.grpc.education.BasicRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.GetAllStudentsDataResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES_DATA:
          serviceImpl.getAllCoursesData((com.grpc.education.BasicRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.GetAllCoursesDataResponse>) responseObserver);
          break;
        case METHODID_ADD_STUDENT:
          serviceImpl.addStudent((com.grpc.education.AddStudentRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_ADD_COURSE:
          serviceImpl.addCourse((com.grpc.education.AddCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_DELETE_STUDENT:
          serviceImpl.deleteStudent((com.grpc.education.DeleteStudentRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((com.grpc.education.DeleteCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_UPDATE_STUDENT:
          serviceImpl.updateStudent((com.grpc.education.AddStudentRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE:
          serviceImpl.updateCourse((com.grpc.education.AddCourseRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT:
          serviceImpl.getStudent((com.grpc.education.BasicRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.StudentResponse>) responseObserver);
          break;
        case METHODID_GET_COURSE:
          serviceImpl.getCourse((com.grpc.education.BasicRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.CourseResponse>) responseObserver);
          break;
        case METHODID_ENROLMENT:
          serviceImpl.enrolment((com.grpc.education.EnrolmentRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_BASIC_READ:
          serviceImpl.basicRead((com.grpc.education.BasicRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.BasicResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.grpc.education.StudentLoginRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.education.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EducationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EducationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.education.EducationServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EducationService");
    }
  }

  private static final class EducationServiceFileDescriptorSupplier
      extends EducationServiceBaseDescriptorSupplier {
    EducationServiceFileDescriptorSupplier() {}
  }

  private static final class EducationServiceMethodDescriptorSupplier
      extends EducationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EducationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EducationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EducationServiceFileDescriptorSupplier())
              .addMethod(getGetAllStudentsDataMethod())
              .addMethod(getGetAllCoursesDataMethod())
              .addMethod(getAddStudentMethod())
              .addMethod(getAddCourseMethod())
              .addMethod(getDeleteStudentMethod())
              .addMethod(getDeleteCourseMethod())
              .addMethod(getUpdateStudentMethod())
              .addMethod(getUpdateCourseMethod())
              .addMethod(getGetStudentMethod())
              .addMethod(getGetCourseMethod())
              .addMethod(getEnrolmentMethod())
              .addMethod(getBasicReadMethod())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
