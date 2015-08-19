package cn.shell.com.xdadmin;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

import Data.Item;
import Data.Note;
import Data.NoteItem;

/**
 * Created by Administrator on 2015/8/15.
 */
public class XDApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AVObject.registerSubclass(Note.class);
        AVObject.registerSubclass(NoteItem.class);
        AVObject.registerSubclass(Item.class);
        AVOSCloud.initialize(this, "fkysmqq7764a492wojb24br0733f7umfwswj10q1rj7fx2lk", "asxf4ljb5incnjibn7axteh4u30hmcwxajhyjeiwqtd2ir1a");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
