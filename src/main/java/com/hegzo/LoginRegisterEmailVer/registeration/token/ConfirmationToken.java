package com.hegzo.LoginRegisterEmailVer.registeration.token;

import com.hegzo.LoginRegisterEmailVer.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {


    @Id
    @SequenceGenerator(allocationSize = 1,
            sequenceName = "confirmation_token_sequence",
            name = "confirmation_token_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence")
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

//    @Column(nullable = false)
    private LocalDateTime confirmedAt;


    @ManyToOne
    @JoinColumn(nullable = false,
    name = "app_user_id"
    )
    private AppUser appUser;


    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiredAt,
//                             LocalDateTime confirmedAt,
                             AppUser appuser
    ) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
//        this.confirmedAt = confirmedAt;
        this.appUser = appuser;

    }



}
