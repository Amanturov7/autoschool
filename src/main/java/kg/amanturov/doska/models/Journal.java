package kg.amanturov.doska.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "journal")
@NoArgsConstructor
@AllArgsConstructor
public class Journal extends BaseModel {
}
