/**
 * @apiDefine 6user 用户模块
 */

/**
 * @api {post} /user/sendCode.htm 1.1发送验证码
 *
 * @apiVersion 0.0.1
 *
 * @apiName sendCode
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} catalog 类型(register,login，binding,reset,changePhone)
 *
 *
 * @apiPermission none
 *
 * @apiDescription 发送验证码
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {Array} list 集合数据
 *
 * @apiSuccess {Int} id 该条数据id
 *
 * @apiSuccess {String} name 该条数据名称
 *
 */


/**
 * @api {post} /user/checkPhoneCode.htm 1.11 验证码校验
 *
 * @apiVersion 0.0.1
 *
 * @apiName checkPhoneCode
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 验证码
 *
 * @apiParam {String} type 类型(register,login，binding,reset,changePhone)
 *
 *
 * @apiPermission none
 *
 * @apiDescription 验证码校验
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 * @apiSuccess {String} msg 消息
 *
 */


/**
 * @api {post} /user/loginByCode.htm 1.2 通过验证码登陆
 *
 * @apiVersion 0.0.1
 *
 * @apiName loginByCode
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 验证码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 发送验证码
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 * @apiSuccess {Array} list 集合数据
 *
 * @apiSuccess {Int} id 该条数据id
 *
 * @apiSuccess {String} name 该条数据名称
 *
 */


/**
 * @api {post} /user/login.htm 1.3 通过手机号密码登陆
 *
 * @apiVersion 0.0.1
 *
 * @apiName login
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} password 密码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 通过手机号密码登陆
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */


/**
 * @api {post} /user/registerByCode.htm 1.4 通过手机号密码进行注册
 *
 * @apiVersion 0.0.1
 *
 * @apiName registerByCode
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 密码
 *
 * @apiParam {String} password 密码
 *
 *
 * @apiPermission none
 *
 * @apiDescription 通过手机号密码登陆
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */



/**
 * @api {get} /member/loginOauth.htm 1.5 通过第三方登陆
 *
 * @apiVersion 0.0.1
 *
 * @apiName loginOauth
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} type 第三方类型（weixin，qq，iosqq,weiapp）
 *
 * @apiParam {String} openId openId
 *
 * @apiParam {String} accessToken accessToken
 *
 *
 * @apiPermission none
 *
 * @apiDescription 通过第三方登陆,要是没有用户信息，系统会创建一份用户信息
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */


/**
 * @api {get} /member/binding.htm 1.5.1 绑定手机号码
 *
 * @apiVersion 0.0.1
 *
 * @apiName binding
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 * @apiParam {String} userToken 用户令牌
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 验证码
 *
 * @apiPermission none
 *
 * @apiDescription 通过第三方登陆,要是没有用户信息，系统会创建一份用户信息
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */


/**
 * @api {post} /user/registerOauth.htm 1.6 通过第三方进行注册
 *
 * @apiVersion 0.0.1
 *
 * @apiName registerOauth
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} type 第三方类型（weixin，qq，iosqq）
 *
 * @apiParam {String} openId openId
 *
 * @apiParam {String} accessToken accessToken
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 验证码

 * @apiPermission none
 *
 * @apiDescription 通过第三方登陆
 *
 *
 *
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 *
 */




/**
 * @api {post} /user/resetPassword.htm 1.7 重置密码
 *
 * @apiVersion 0.0.1
 *
 * @apiName resetPassword
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 验证码
 *
 * @apiParam {String} password 密码
 * @apiPermission none
 *
 * @apiDescription 重置密码
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 */


/**
 * @api {post} /user/changePhone.htm 1.8 更换手机号
 *
 * @apiVersion 0.0.1
 *
 * @apiName changePhone
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} phone 手机号码
 *
 * @apiParam {String} code 验证码
 *
 * @apiParam {String} userToken 用户token
 * @apiPermission none
 *
 * @apiDescription 更换手机号
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 */


/**
 * @api {post} /user/changePassword.htm 1.9 更新密码
 *
 * @apiVersion 0.0.1
 *
 * @apiName changePassword
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} oldPassword 老密码
 *
 * @apiParam {String} password 新密码
 *
 * @apiParam {String} userToken 用户token
 * @apiPermission none
 *
 * @apiDescription 更新密码
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 */


/**
 * @api {post} /user/update.htm 2.1 更新用户信息
 *
 * @apiVersion 0.0.1
 *
 * @apiName update
 *
 * @apiGroup 6user
 *
 * @apiParam {String} token 令牌
 *
 * @apiParam {String} userToken 用户token
 *
 * @apiParam {String} name 昵称
 *
 * @apiParam {String} avatar 头像
 *
 * @apiPermission none
 *
 * @apiDescription 更新密码
 *
 * @apiSuccess {Int} code 状态码(默认为0)
 *
 */




