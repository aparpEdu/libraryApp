package org.library.author;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
public class DeceasedAuthor extends Author{
    private LocalDate dateOfPassing;
}
