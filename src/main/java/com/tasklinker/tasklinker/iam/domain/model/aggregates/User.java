package com.tasklinker.tasklinker.iam.domain.model.aggregates;

import java.time.LocalDate;

import com.tasklinker.tasklinker.iam.domain.model.commands.SignInCommand;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignUpCommand;
import com.tasklinker.tasklinker.iam.domain.model.entities.PaymentCard;
import com.tasklinker.tasklinker.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {
    /*
     * @NotBlank
     * private String name;
     */

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    /*
     * @NotNull
     * 
     * @AttributeOverrides({
     * 
     * @AttributeOverride(name = "number", column = @Column(name = "phone_number")),
     * })
     * private PhoneNumber phoneNumber;
     */

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_card_id", referencedColumnName = "id")
    private PaymentCard paymentCard;

    public User() {
    }

    public User(String email, String password, String cardNumber,
            LocalDate expirementDate, String securityCode) {
        // this.name = name;
        this.email = email;
        this.password = password;
        // this.phoneNumber = new PhoneNumber(phoneNumber);
        this.paymentCard = new PaymentCard(cardNumber, expirementDate, securityCode);
    }

    public User(SignUpCommand command, String hashedPassword) {
        // this.name = command.name();
        this.email = command.email();
        this.password = hashedPassword;
        // this.phoneNumber = new PhoneNumber(command.phoneNumber());
        this.paymentCard = new PaymentCard(command.cardNumber(), command.expirementDate(), command.securityCode());
    }

    public User(SignInCommand command) {
        this.email = command.email();
        this.password = command.password();
    }

    /*
     * public String getPhoneNumber() {
     * return phoneNumber.number();
     * }
     */

    public String getCardNumber() {
        return paymentCard.getCardNumber();
    }
}
