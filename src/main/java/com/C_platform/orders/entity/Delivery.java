package com.C_platform.orders.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity @Table(name = "delivery")
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long delivery_id; //배달 ID

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus delivery_status =  DeliveryStatus.READY; //배달 상태

    @Embedded
    private Address address; //주소

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "order_id", unique = true, nullable = false)
    private Orders order; //주문 엔티티 참조(FK: delivery.order_id -> orders.order_id)

    @Builder
    private Delivery(Address address, Orders order) {
        this.address = address;
        this.order = order;
    }
}
