package com.quhaodian.umall.data.entity;


import com.quhaodian.user.data.entity.AbstractUser;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 网站用户
 */

@Entity
@Table(name = "user_info")
public class Member extends AbstractUser {

}
