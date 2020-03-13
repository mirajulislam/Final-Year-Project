package com.example.demo.configuration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;
 
 @Autowired
	private CustomLoginSuccessHandler sucessHandler;

 @Autowired
 private DataSource dataSource;
 
 private final String teacher_QUERY = "select user_name, password ,'1' as enabled  from create_teacher where user_name=?";
 private final String  teacher_role_query = "select u.user_name, r.role_name from create_teacher u inner join teacher_role ur on(u.teacher_id=ur.teacher_id) inner join user_roled r on(ur.role_id=r.role_id) where u.user_name=?";
// 
 private final String  student_QUERY = "select user_name, password ,'1' as enabled  from create_student where user_name=?";
 private final String  student_role_query = "select u.user_name, r.role_name from create_student u inner join student_role ur on(u.student_id=ur.student_id) inner join user_roled r on(ur.role_id=r.role_id) where u.user_name=?";

 
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  auth.jdbcAuthentication()

   .usersByUsernameQuery(teacher_QUERY) 
   .authoritiesByUsernameQuery(teacher_role_query)
   .dataSource(dataSource)
   .passwordEncoder(bCryptPasswordEncoder);
  
 }
 
// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//  auth.jdbcAuthentication()
//
//   .usersByUsernameQuery(student_QUERY) 
//   .authoritiesByUsernameQuery(student_role_query)
//   .dataSource(dataSource)
//   .passwordEncoder(bCryptPasswordEncoder);
//  
// }
 
 
 @Override
 protected void configure(HttpSecurity http) throws Exception{
  http.authorizeRequests()
   .antMatchers("/").permitAll()
	.antMatchers("/").permitAll()
	.antMatchers("/confirm").permitAll()
	.antMatchers("/teacherProfile/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/Teacher-register/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/Student-register/**").hasAnyAuthority("TEACHER_USER")	
	.antMatchers("/teacherProfile/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/deparmentInsertView/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/courseInsertView/**").hasAnyAuthority("TEACHER_USER")	
	.antMatchers("/courseAssignView/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/searchAttendance/**").hasAnyAuthority("TEACHER_USER","STUDENT_USER")
	.antMatchers("/stdSearchAttendance/**").hasAnyAuthority("STUDENT_USER")	
	.antMatchers("/takePhotoExample/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/teacherCourseAssignView/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/addAttendance/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/TakeAttendance/**").hasAnyAuthority("TEACHER_USER")	
	.antMatchers("/uploadAttendance/**").hasAnyAuthority("TEACHER_USER")	
	.antMatchers("/courseAssignView/**").hasAnyAuthority("TEACHER_USER")
	.antMatchers("/studentProfile/**").hasAnyAuthority("STUDENT_USER")
    .and().csrf().disable()
   .formLogin().loginPage("/loginsubmit").failureUrl("/login?error=true")
   .successHandler(sucessHandler)
   .usernameParameter("userName")
   .passwordParameter("password") 
   .and().logout()
   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
   .logoutSuccessUrl("/")
   .and().rememberMe().rememberMeParameter("remember-me")
   .tokenRepository(persistentTokenRepository())
   .tokenValiditySeconds(600*60)
   .and().exceptionHandling().accessDeniedPage("/access_denied");

 }
 
 @Bean
 public PersistentTokenRepository persistentTokenRepository() {
  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
  db.setDataSource(dataSource);
  
  return db;
 }
}