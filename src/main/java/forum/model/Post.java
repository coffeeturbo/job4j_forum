package forum.model;

import lombok.*;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Post {
    private int id;
    private String name;
    private String desc;
    private Calendar created;
}
