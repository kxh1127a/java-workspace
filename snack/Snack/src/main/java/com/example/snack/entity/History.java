package com.example.snack.entity;

import com.example.snack.interfaces.CommonModelBuilder;
import com.example.snack.model.HistoryCreateRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name="snackId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Snack snack;

    @Column(nullable = false)
    private Integer amount;

    private LocalDate dateIn;
    private LocalDate dateOut = null;
    private Boolean isSoldOut;



    private History(Builder builder) {
        this.snack = builder.snack;
        this.amount = builder.amount;
        this.dateIn = builder.dateIn;
//        this.dateOut = builder.dateOut;
        this.isSoldOut = builder.isSoldOut;
    }

    public static class Builder implements CommonModelBuilder<History> {
        private final Snack snack;
        private final Integer amount;
        private final LocalDate dateIn;
//        private LocalDate dateOut;
        private final boolean isSoldOut;


        public Builder(Snack snack, HistoryCreateRequest request) {
            this.snack = snack;
            this.amount = request.getAmount();
            this.dateIn = LocalDate.now();
            this.isSoldOut = false;
        }

        @Override
        public History build() {
            return new History(this);
        }
    }

}
