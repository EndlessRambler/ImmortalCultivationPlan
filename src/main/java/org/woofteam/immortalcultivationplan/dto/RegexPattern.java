package org.woofteam.immortalcultivationplan.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public interface RegexPattern {

     String IMMORTAL_PASSWORD_REGEX = "^[0-9]{6}$";
}
