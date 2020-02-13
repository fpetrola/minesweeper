package com.minesweeper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
@Api(value = "/")
public interface MineSweeperApi {

    @POST
    @Path("/create/{rows}/{columns}")
    @Produces({"application/json"})
    @ApiOperation(value = "create game", tags = {"create",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Void.class)})
    public void createGame(@PathParam("rows") int rows, @PathParam("columns") int columns);
}

