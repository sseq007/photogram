package com.cos.photogramstart.domain.subscribe;

import com.cos.photogramstart.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "subscribe_uk",
                        columnNames = {"fromUserId","toUserId"}
                )
        }
)
public class Subscribe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fromUserId")
    private User fromUser;

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser;


    private LocalDateTime createDate;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
