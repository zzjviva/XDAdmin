package Data;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;

import java.util.List;

/**
 * Created by Administrator on 2015/8/15.
 */
@AVClassName("Note")
public class Note extends AVObject{
    public Note(){
        super();
    }
    public String getName()
    {
        return getString("Name");
    }
    public void SetName(String name)
    {
        put("Name",name);
    }
    public String getDate()
    {
        return getString("Date");
    }
    public void SetDate(String date)
    {
        put("Date",date);
    }
    public String getMMUrl()
    {
        return getString("MMURL");
    }
    public void SetMMUrl(String url)
    {
        put("MMURL",url);
    }
    public List<NoteItem> getNoteItems()
    {
        return getList("NoteItems",NoteItem.class);
    }
    public void AddNoteItem(NoteItem item)
    {
        add("NoteItems", item);
    }

}
