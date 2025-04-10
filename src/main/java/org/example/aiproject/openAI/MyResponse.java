package org.example.aiproject.openAI;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyResponse {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    String answer;
    List<Map<String, String>> messages;

    //***CONSTRUCTORS***------------------------------------------------------------------------------------------------
    public MyResponse(String answer) {
        this.answer = answer;
    }

    public MyResponse(String answer, List<Map<String,String>> messages) {
        this.answer = answer;
        this.messages = messages;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
