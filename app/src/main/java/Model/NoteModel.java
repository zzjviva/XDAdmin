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
               Note note = new Note();
               note.SetName("酷日炎炎的一天");
               note.SetDate("2015-08-19");
               note.SetMMUrl("http://ac-fkysmqq7.clouddn.com/52c57ab96843408d.jpg");
               {//Android
                   NoteItem noteItem = new NoteItem();
                   noteItem.SetName("Android");
                   {
                       Item item = new Item();
                       item.SetName("一款基于Google Material Design设计开发的Android客户端，包括新闻简读，图片浏览，视频爽看 ，音乐轻听以及二维码扫描五个子模块，项目采取的是MVP架构开发");
                       item.SetURL("https://github.com/SkillCollege/SimplifyReader");
                       try {
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   {
                       Item item = new Item();
                       item.SetName("一组资源组成背景动画");
                       item.SetURL("https://github.com/tslamic/FancyBackground");
                       try {
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   {
                       Item item = new Item();
                       item.SetName("有一个漂亮的城市选择组件");
                       item.SetURL("https://github.com/gugalor/citylist");
                       try {
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   try {
                       noteItem.save();
                   } catch (AVException e) {
                       Message msg = new Message();
                       msg.obj = "创建失败：" + e.getMessage();
                       mHandler.sendMessage(msg);
                   }
                   note.AddNoteItem(noteItem);
               }
               {//IOS

                   NoteItem noteItem = new NoteItem();
                   noteItem.SetName("IOS");
                   {
                       Item item = new Item();
                       item.SetName("Swift 语言指南－Issue 37");
                       item.SetURL("https://github.com/ipader/SwiftGuide/blob/master/weekly/Issue-37.md");
                       try {
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   {
                       Item item = new Item();
                       item.SetName("4个你应该知道的 Asset Catalog 小技巧");
                       item.SetURL("http://krakendev.io/blog/4-xcode-asset-catalog-secrets-you-need-to-know");
                       try {
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   {
                       Item item = new Item();
                       item.SetName("When to Use Swift Structs and Classes");
                       item.SetURL("http://yulingtianxia.com/blog/2015/08/12/When-to-Use-Swift-Structs-and-Classes/");
                       try {
                           item.save();
                       } catch (AVException e) {
                           Message msg = new Message();
                           msg.obj = "创建失败：" + e.getMessage();
                           mHandler.sendMessage(msg);
                       }
                       noteItem.AddItem(item);
                   }
                   try {
                       noteItem.save();
                   } catch (AVException e) {
                       Message msg = new Message();
                       msg.obj = "创建失败：" + e.getMessage();
                       mHandler.sendMessage(msg);
                   }
                   note.AddNoteItem(noteItem);
               }
               try {
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
