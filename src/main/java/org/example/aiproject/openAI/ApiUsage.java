package org.example.aiproject.openAI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class ApiUsage {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String promptTokens;
    private int completionTokens;
    private int totalTokens;
    private String prompt;
    @CreationTimestamp
    LocalDate created;

}
