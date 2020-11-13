package se.iths.rest;

import se.iths.entity.Student;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
      //  return Response.noContent().build();
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
}
