package com.urbanlt.reservation.dto.member;

public class MemberRequestDTO {

    public static class GetList {
        private String memberName;
        private String phoneNumber;
        private String birtDate;
        private String gender;
        private String email;
        private boolean smsEnabled;
        private boolean emailEnabled;
    }

    public static class Login {
        private Long loginId;
        private String password;
    }
}
