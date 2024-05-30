package com.example.demo.docx;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.members.Members;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Docx {
	@Id
	@SequenceGenerator(name="seq_gen", sequenceName="seq_docx", allocationSize=1)//시퀀스 생성
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_docx")//num에 시퀀스로 값 자동할당
	private int formnum;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Members writer;
	
	private Members senior;
	private Date startdt;
	private Date enddt;
	private String title;
	private String content;
	private String note; // 비고 작성
	private int taskclasf; //업무 구분 
	private String taskplan; // 업무 계획내용 , 휴가구분
	private String taskprocs; // 업무 진행과정 , 회의일시
	private String taskprocsres; // 업무 진행 결과, 회의장소
	private String deptandmeetloc; //회의 진행 장소
	private String	dayoffclasf; //휴가 구분
	ArrayList<String> participant; //참석자
	private String formtype; //문서 타입 구분
	private int aprovdoc; // 결제서류 승인 여부 : 거절 보류 승인
	
	@PrePersist
	public void setDate() {
		startdt = new Date();
		enddt = new Date();
	}
	
	
}
