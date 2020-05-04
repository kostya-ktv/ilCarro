package co.il.telran.ilcarro.application.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
