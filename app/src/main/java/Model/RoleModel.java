package Model;

import com.avos.avoscloud.AVACL;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRole;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;

import Interface.NormalCallback;

/**
 * Created by Administrator on 2015/8/16.
 */
public class RoleModel {
    public static void SetRole(final NormalCallback callback)
    {
        AVACL acl = new AVACL();
        acl.setRoleReadAccess("publisher",true);
        acl.setRoleWriteAccess("publisher", true);
        AVRole publisher = new AVRole("publisher",acl);
        publisher.getUsers().add(AVUser.getCurrentUser());
        publisher.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null)
                {
                    if(callback != null)
                    {
                        callback.OnCallBack(AVUser.getCurrentUser().getUsername() + "设置为publisher");
                    }
                }
                else {
                    if(callback != null)
                    {
                        callback.OnCallBack(AVUser.getCurrentUser().getUsername() + "设置publisher失败：" + e.getMessage());
                    }
                }
            }
        });
    }
}
