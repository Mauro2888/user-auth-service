package mauro.service.userauthservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
public class Role {
  @Id
  private String roleName;
}
