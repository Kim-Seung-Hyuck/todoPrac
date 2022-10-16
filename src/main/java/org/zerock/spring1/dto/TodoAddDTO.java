package org.zerock.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoAddDTO {
    private Integer tno;
    private String title,memo, writer;
    private LocalDate dueDate;
}
