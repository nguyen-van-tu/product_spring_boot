package com.codegym.config;


import com.codegym.service.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IAppUserService appUserService;


//    @Bean
//    public UserDetailsService userDetailsService(){
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
//        memoryUserDetailsManager.createUser(userBuilder.username("hung").password("123456").roles("USER").build());
//        memoryUserDetailsManager.createUser(userBuilder.username("vohung").password("123456").roles("ADMIN").build());
//        return memoryUserDetailsManager;
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/index").permitAll()
                .and()
                .authorizeRequests().antMatchers("/category").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/products/user").hasRole("USER")
                .and()
                .authorizeRequests().antMatchers("/products/admin").hasRole("ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.csrf().disable();
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/seller").access("hasRole('ROLE_SELLER')")
//                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
////                .antMatchers("/templates/customer").access("hasRole('CUSTOMER')")
//                .and().formLogin()
////                .loginPage("/login")//
////                .loginProcessingUrl("/check_login") // Submit URL
//////                .defaultSuccessUrl("/userAccountInfo")//
////                .failureUrl("/login?error=true")//
////                .usernameParameter("username")//
////                .passwordParameter("password")
//                .successHandler(customerSuccessHandle)
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//    }
}
