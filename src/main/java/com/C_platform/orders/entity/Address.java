package com.C_platform.orders.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Column(name = "postal_code", length = 10, nullable = false)
    private String zip; //우편번호

    @Column(length = 255, nullable = false)
    private String roadAddress; //도로명

    @Column(length =  255, nullable = false)
    private String detailAddress; //사용자가 적는 상세주소(동/호/층/호수)

    @Column(length = 255)
    private String extraAddress; //검색 API가 내려주는 부가정보(건물명, 법정동명)

    @Builder
    private Address(String zip, String roadAddress, String detailAddress, String extraAddress) {
        this.zip = zip;
        this.roadAddress = roadAddress;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
    }
}
