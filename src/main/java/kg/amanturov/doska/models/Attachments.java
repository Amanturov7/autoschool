package kg.amanturov.doska.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attachments")
public class Attachments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    private String type;

    private String extension;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cars_id")
    private Cars cars;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groups_id")
    private Groups groups;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tickets_id")
    private Tickets tickets;

}
