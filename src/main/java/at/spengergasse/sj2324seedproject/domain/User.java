package at.spengergasse.sj2324seedproject.domain;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long>{
=======
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User extends AbstractPersistable<Long> {

    private static final int EMAIL_MAX_LENGTH = 320;
    private static final String DATE_TIME_FORMAT = "dd-mm-yyyy HH:mm:ss";


    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") @Length(max = EMAIL_MAX_LENGTH)
    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Length(max = 1)
    private Role role;

    @DateTimeFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime lastLogin;

    private boolean isActivated;

    @Embedded
    @Valid
    private Profile profile;



>>>>>>> groupOf4Classes
}
