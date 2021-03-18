package com.codegym.service.appuser;

import com.codegym.model.AppUser;


public interface IAppUserService {
    AppUser getUserByName(String name);
}
