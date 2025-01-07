package com.mindhub.sprint_one.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api"))
public class MyController {

    @Operation(
            summary = "Get a greeting",
            description = "Returns a greeting message."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User was greeted."),
            @ApiResponse(responseCode = "500", description = "Sorry, unable to greet you. Internal server error.")
    })
    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Welcome to Steve's server!");
    }

    @Operation(
            summary = "Post string data",
            description = "Receives data and returns a confirmation message.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The data to be submitted",
                    content = @Content(mediaType = "application/json", schema = @Schema(type = "string", example = "Sample data")))
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    })
    @PostMapping("/submit")
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }

    @Operation(
            summary = "Get user by id",
            description = "Handles GET requests to /api/user/{id} and returns the user ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Data successfully received."),
            @ApiResponse(responseCode = "404", description = "User Not Found."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid id or bad URI format.")
    })
    @GetMapping("/user/{id}")
    public String getUserById(@Parameter(description = "ID of the user to retrieve", required = true, example = "12345")
                                  @PathVariable("id") Long id) {
        return "User ID: " + id;
    }


    @Operation(
            summary = "Search for data using a query param",
            description = "Searches for items based on a query parameter and returns search results."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search was successful."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid parameter.")
    })
    @GetMapping("/search")
    public String search(@Parameter(description = "The value used to perform the search operation", required = true, example = "Steve")
                             @RequestParam(name = "query", defaultValue = "") String query) {
        return "Search results for: " + query;
    }
}
