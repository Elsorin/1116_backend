package com.project.bank.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id; // 회원번호
	
	@Column(nullable = false, length = 20, unique = true)
	private String username; // 아이디
	
	@Column(nullable = false)
	private String password; // 비밀번호
	
	@Column(nullable = false, length = 20)
	private String fname; // 이름
	
	@Enumerated(EnumType.STRING)
	private RoleType role; // 권한
	
	@Column(length = 20)
	private String idNo; // 주민번호
	
	@Column(length = 50)
	private String email; // 이메일
	
	@Column(length = 20)
	private String phone; // 휴대폰 번호
	
	@Column(length = 50)
	private String country; // 국적
	
	@Column(length = 100)
	private String address; // 집주소
	
	@Column(length = 100)
	private String addressDetail; // 집상세주소
	
	@Column(length = 100)
	private String jobName; // 직장명
	
	@Column(length = 100)
	private String teamName; // 팀명

	@Column(length = 100)
	private String jobAddress; // 직장주소
	
	@Column(length = 100)
	private String jobAddressDetail; // 직장상세주소

	@Column(length = 100)
	private String jobPhone; // 직장연락처

	private String agree; // 내정보동의보기, 정보동의여부
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("id desc")
	private List<Account> accountList; // 계좌 목록	
}