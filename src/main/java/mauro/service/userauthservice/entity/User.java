package mauro.service.userauthservice.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String username;
  private String password;

  @ManyToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinTable(
      name = "user_roles",
      joinColumns = {
          @JoinColumn(name = "user_id")
      },
      inverseJoinColumns = {
          @JoinColumn(name = "role_id")
      }
  )
  private Set<Role> roles;
}
