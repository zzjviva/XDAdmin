package Model;

import android.os.Handler;
import android.os.Message;

import com.avos.avoscloud.AVACL;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;

import java.util.logging.LogRecord;

import Data.Item;
import Data.Note;
import Data.NoteItem;
import Interface.NormalCallback;

/**
 * Created by Administrator on 2015/8/16.
 */
public class NoteModel {
    private NormalCallback mCallback;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mCallback != null)
            {
                mCallback.OnCallBack(String.valueOf(msg.obj));
            }
        }
    };
    public void CreateNote(final  NormalCallback callback)
    {

    }
    public void Create_InsetNote(final NormalCallback callback){
        mCallback = callback;
       new Thread(new Runnable() {
           @Override
           public void run() {
//               AVACL acl = new AVACL();
//               acl.setPublicWriteAccess(false);
//               acl.setPublicReadAccess(true);
//               acl.setRoleWriteAccess("publisher",true);
               Note note = new Note();
               note.SetName("今天的");
               note.SetDate("2015-08-16");
               note.SetMMUrl("wwww.baidu.com");

               for(int i = 0 ; i < 5;i++)
               {
                   final NoteItem noteItem = new NoteItem();
                   noteItem.SetName(String.valueOf(i));
                   for(int j = 0 ; j < 5;j++)
                   {
                       final Item item = new Item();
                       item.SetName(j + "item");
                       item.SetURL("j" + "wwww");
                       try {
                           //item.setACL(acl);
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   try {
                      // note.setACL(acl);
                       noteItem.save();
                   } catch (AVException e) {
                       Message msg = new Message();
                       msg.obj = "创建失败：" + e.getMessage();
                       mHandler.sendMessage(msg);
                   }
                   note.AddNoteItem(noteItem);
               }
               try {
                  // note.setACL(acl);
                   note.save();
                   Message msg = new Message();
                   msg.obj = "创建成功！";
                   mHandler.sendMessage(msg);
               } catch (AVException e) {
                   Message msg = new Message();
                   msg.obj = "创建失败：" + e.getMessage();
                   mHandler.sendMessage(msg);
               }

           }
       }).start();

    }
}
