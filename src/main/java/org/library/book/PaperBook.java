package org.library.book;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaperBook extends Book implements Readable{
    private int numberOfAvailableCopies;
    private int totalNumberOfCopies;
}
