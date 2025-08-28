package com.C_platform.orders.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id; //주문 ID

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrdersStaus ordersStaus = OrdersStaus.PAID; //주문 상태

    @Column(name = "member_id", nullable = false)
    private int member_id; //멤버 ID

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate = LocalDateTime.now(); //주문 일시

    @Builder
    private Orders(int member_id){
        this.member_id = member_id;

    }

    //상태 전이 메서드 => 결제 라이프 사이클 바꾸는 도메인 메서드
    //전이 시 "검증"도 추가해 줘야 함 (아직 x)
    public void markPaid(){
        this.ordersStaus = OrdersStaus.PAID;
    } //주문 완료 전이
    public void markCanseled(){
        this.ordersStaus = OrdersStaus.CANCELED;
    } //취소 전이

}
