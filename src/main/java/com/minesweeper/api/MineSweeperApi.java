package com.minesweeper.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;

@Path("/")
@Api(value = "/")
public interface MineSweeperApi {

    @GET
    @Path("/create/{rows}/{columns}/{mines}")
    @Produces({"application/json"})
    @ApiOperation(value = "create game", tags = {"create",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = String.class)})
    public String createGame(@PathParam("rows") int rows, @PathParam("columns") int columns, @PathParam("mines") int mines);

    @GET
    @Path("/reveal-square/{gameId}/{row}/{column}")
    @Produces({"application/json"})
    @ApiOperation(value = "reveal square", tags = {"reveal",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Void.class)})
    public void revealSquareAt(@PathParam("row") int row, @PathParam("column") int column, @PathParam("gameId") int gameId);

    @GET
    @Path("/is-over/{gameId}")
    @Produces({"application/json"})
    @ApiOperation(value = "is over", tags = {"is over",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = boolean.class)})
    public boolean isOver(int gameId);


    @GET
    @Path("/flag/{gameId}/{row}/{column}")
    @Produces({"application/json"})
    @ApiOperation(value = "flag square", tags = {"flag",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Void.class)})
    public void flagSquareAt(@PathParam("row") int row, @PathParam("column") int column, @PathParam("gameId") int gameId);

    @GET
    @Path("/board/{gameId}")
    @Produces({"application/json"})
    @ApiOperation(value = "board", tags = {"flag",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = String.class)})
    public String getBoard(@PathParam("gameId") int gameId);
}

