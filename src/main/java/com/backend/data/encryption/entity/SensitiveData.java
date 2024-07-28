package com.backend.data.encryption.entity;

import com.backend.data.encryption.util.EncryptionConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_sensitive_data")
public class SensitiveData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = EncryptionConverter.class)
    @Column(name = "user_document", nullable = false)
    private String userDocument;

    @Convert(converter = EncryptionConverter.class)
    @Column(name = "credit_card_token", nullable = false)
    private String creditCardToken;

    @Column(name = "value_credit", nullable = false)
    private Long value;

}
