package bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
public class Drink extends VoceMenu {


}
