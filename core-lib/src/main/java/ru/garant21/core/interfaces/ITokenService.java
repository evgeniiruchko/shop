package ru.garant21.core.interfaces;

import ru.garant21.core.models.UserInfo;

public interface ITokenService {
    String generateToken(UserInfo user);
    UserInfo parseToken(String token);
}
