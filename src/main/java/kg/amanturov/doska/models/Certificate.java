package kg.amanturov.doska.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "certificate")
public class Certificate extends BaseModel {

}
