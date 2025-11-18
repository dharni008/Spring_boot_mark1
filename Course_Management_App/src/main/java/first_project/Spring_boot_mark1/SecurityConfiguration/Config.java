package first_project.Spring_boot_mark1.SecurityConfiguration;

import first_project.Spring_boot_mark1.Service.StudentsUserDetails;
import first_project.Spring_boot_mark1.Service.StudentsUserDetailsService;
import first_project.Spring_boot_mark1.Utils.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Config {

    @Autowired
    private StudentsUserDetailsService studentsUserDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

   @Bean
    public SecurityFilterChain authentication(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(customizer -> customizer
                        .requestMatchers("register","Login","RegisterMentor","LoginMentor")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(customizer -> customizer.disable())
                .httpBasic(customizer -> customizer.disable())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                //.sessionManagement(Customizer -> Customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        daoAuthenticationProvider.setUserDetailsService(studentsUserDetailsService);
        return daoAuthenticationProvider;
    }


}
