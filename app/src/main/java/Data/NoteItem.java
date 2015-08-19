package Data;

import android.preference.ListPreference;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;

import java.util.List;

/**
 * Created by Administrator on 2015/8/16.
 */
@AVClassName("NoteItem")
public class NoteItem extends AVObject{
    public NoteItem()
    {
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
    public List<Item> getItems()
    {
        return getList("Items",Item.class);
    }
    public void AddItem(Item item)
    {
        add("Items",item);
    }
}
