package com.codegym.service.appuser;


import com.codegym.model.AppUser;
import com.codegym.repository.AppUserRepository;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AppUserService implements UserDetailsService , IAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser getUserByName(String name) {
        return appUserRepository.getAppUsersByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser= this.getUserByName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(appUser.getRole());
        UserDetails userDetails = new User(
                appUser.getName(),
                appUser.getPassword(),
                authorities
        );
        return userDetails;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

}
