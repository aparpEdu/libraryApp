package org.library.book;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DownloadableBook extends ElectronicBook{
    private String downloadLink;
}
