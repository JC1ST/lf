package kr.co.lovefans.devel.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter @Setter
public class MemberForm {

    private Long mi_seq;
    /**
     *  id = email
     * */
    @Email
    @NotBlank(message = "이메일 입력 필수")
    private String mi_id;
    @NotBlank(message = "비밀번호 입력 필수")
    private String mi_pwd;
    @NotBlank(message = "닉네임 입력 필수")
    private String mi_nick;

}
