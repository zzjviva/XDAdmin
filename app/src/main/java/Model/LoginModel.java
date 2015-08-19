package Model;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

import Interface.NormalCallback;

/**
 * Created by Administrator on 2015/8/15.
 */
public class LoginModel {
    public static void Login(final NormalCallback callback)
    {
        AVUser.logInInBackground("zzky0010", "zouzijian", new LogInCallback() {
            public void done(AVUser user, AVException e) {
                if (user != null) {
                    // 登录成功
                    if(callback != null)
                    {
                        callback.OnCallBack(user.getUsername() + "登录成功!");
                    }
                } else {
                    // 登录失败
                    if(callback != null)
                    {
                        callback.OnCallBack("zzky0010(admin)登录失败!："+ e.getMessage());
                    }
                }
            }
        });
    }
}
