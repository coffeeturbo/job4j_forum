package forum.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Calendar created;
}
