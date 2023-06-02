package org.library.book;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ElectronicBook extends Book{
    private String readingLink;
    private String downloadLink;

}
