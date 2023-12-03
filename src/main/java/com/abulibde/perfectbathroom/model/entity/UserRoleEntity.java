package com.abulibde.perfectbathroom.model.entity;

import com.abulibde.perfectbathroom.model.enums.UserRolesEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Table(name = "user_role")
@Entity
public class UserRoleEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private UserRolesEnum role;

    public UserRolesEnum getRole() {
        return role;
    }

    public void setRole(UserRolesEnum role) {
        this.role = role;
    }
}
