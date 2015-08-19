package Model;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

import Interface.NormalCallback;

/**
 * Created by Administrator on 2015/8/15.
 */
public class RegisterModel {
    public static void RegistAdmin(final NormalCallback callback)
    {
        final AVUser user = new AVUser();
        user.setUsername("zzky0020");
        user.setPassword("zouzijian");
        user.setEmail("51886937@qq.com");

        user.signUpInBackground(new SignUpCallback() {
            public void done(AVException e) {
                if (e == null) {
                    if(callback != null)
                    {
                        callback.OnCallBack(user.getUsername() +"注册成功！");
                    }
                    // successfully
                } else {
                    if(callback != null)
                    {
                        callback.OnCallBack(user.getUsername() +"注册失败！:" + e.getMessage());
                    }
                    // failed
                }
            }
        });

    }
}
