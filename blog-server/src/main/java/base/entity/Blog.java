package base.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Blog {

    private String title;
    private int wordCount;
    private String updateTime;
    private int watchedPeople;
    private String writer;
    private String contentPreview;
}
