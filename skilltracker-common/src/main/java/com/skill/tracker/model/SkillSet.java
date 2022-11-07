package com.skill.tracker.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SkillSet implements Serializable{

	public static final long serialVersionUID = 1L;
	
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer htmlCSSJavascript;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer angular;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer react;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer spring;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer restful;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer hibernate;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer git;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer docker;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer jenkins;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer aws;
	
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer spoken;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer communication;
	@NotNull
	@Min(value=0, message= "Expertise level should be between 0-20")
	@Max(value=20, message= "Expertise level should be between 0-20")
	public Integer aptitude;
	
	public Integer getHtmlCSSJavascript() {
		return htmlCSSJavascript;
	}
	public void setHtmlCSSJavascript(Integer htmlCSSJavascript) {
		this.htmlCSSJavascript = htmlCSSJavascript;
	}
	public Integer getAngular() {
		return angular;
	}
	public void setAngular(Integer angular) {
		this.angular = angular;
	}
	public Integer getReact() {
		return react;
	}
	public void setReact(Integer react) {
		this.react = react;
	}
	public Integer getSpring() {
		return spring;
	}
	public void setSpring(Integer spring) {
		this.spring = spring;
	}
	public Integer getRestful() {
		return restful;
	}
	public void setRestful(Integer restful) {
		this.restful = restful;
	}
	public Integer getHibernate() {
		return hibernate;
	}
	public void setHibernate(Integer hibernate) {
		this.hibernate = hibernate;
	}
	public Integer getGit() {
		return git;
	}
	public void setGit(Integer git) {
		this.git = git;
	}
	public Integer getDocker() {
		return docker;
	}
	public void setDocker(Integer docker) {
		this.docker = docker;
	}
	public Integer getJenkins() {
		return jenkins;
	}
	public void setJenkins(Integer jenkins) {
		this.jenkins = jenkins;
	}
	public Integer getAws() {
		return aws;
	}
	public void setAws(Integer aws) {
		this.aws = aws;
	}
	public Integer getSpoken() {
		return spoken;
	}
	public void setSpoken(Integer spoken) {
		this.spoken = spoken;
	}
	public Integer getCommunication() {
		return communication;
	}
	public void setCommunication(Integer communication) {
		this.communication = communication;
	}
	public Integer getAptitude() {
		return aptitude;
	}
	public void setAptitude(Integer aptitude) {
		this.aptitude = aptitude;
	}
}