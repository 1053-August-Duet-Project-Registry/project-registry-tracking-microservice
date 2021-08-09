package com.revature.registry.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An {@link Iteration} is a batch's iteration with a {@link Project}, bound by
 * the startDate and endDate.
 *
 * No two {@link Iteration}'s on a {@link Project} should have intersecting
 * startDate/endDate, as this is a violation of business rules.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Iteration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String batchId;

    
    /*
    * this will show the current projects that relates to this iteration. 
    * To prevent infinity loop in rendering json, JsonIgnoreProperties annotation is added so project will not show iteration key and its value
    */
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties("iterations")
    private Project project;

    /*
    * this will show the current phase of this iteration.
    * To prevent infinity loop in rendering json, JsonIgnoreProperties annotation is added so phase will not show iteration key and its value
    */
    @ManyToOne
    @JoinColumn(name = "phase")
    @JsonIgnoreProperties("iterations")
    private Phase phase;


}
