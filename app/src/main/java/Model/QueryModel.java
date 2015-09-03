package Model;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;

import java.util.List;

import Data.Item;
import Data.Note;
import Data.NoteItem;

/**
 * Created by Administrator on 2015/8/20.
 */
public class QueryModel {
    public static void QueryAllNotes()
    {
//        AVQuery<NoteItem> innerQuery = AVQuery.getQuery(NoteItem.class);
//        innerQuery.include("Items");
        AVQuery<Note> query =AVQuery.getQuery(Note.class);
        //query.whereMatchesQuery("Note", innerQuery);
        query.include("NoteItems.Items");
        query.include("Items");
        query.findInBackground(new FindCallback<Note>() {
            @Override
            public void done(final List<Note> list, AVException e) {
                if(e == null)
                {
                    for(Note note :list)
                    {
                        for (NoteItem noteItem:note.getNoteItems())
                        {
                            for (final Item item :noteItem.getItems())
                            {
                                item.fetchInBackground(new GetCallback<AVObject>() {
                                    @Override
                                    public void done(AVObject avObject, AVException e) {
                                       Log.d("query","成功！！！！！" + item.getName());
                                    }
                                });
                            }
                        }
                    }
//                    NoteItem item = list.get(0).getNoteItems().get(0);
//                    String name2 = item.getName();
//                    String name = item.getItems().get(0).getName();
//                    Log.d("query","查找成功"+ name2 + name);
                }
                else
                {
                    Log.d("query","查找失败"+e.getMessage());
                }
            }
        });
    }
}
