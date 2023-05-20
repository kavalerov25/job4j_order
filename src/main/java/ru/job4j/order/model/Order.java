package ru.job4j.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "ORDERS")
public class Order {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ORDER_NAME")
    private String name;
    @Column(name = "ORDER_DESCRIPTION")
    private String description;
    @ManyToOne()
    @JoinColumn(name = "STATUS_ID", foreignKey = @ForeignKey(name = "FK_STATUS_ID"))
    private Status status;
}
