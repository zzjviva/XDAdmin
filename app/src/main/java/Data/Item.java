package Data;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by Administrator on 2015/8/16.
 */
@AVClassName("Item")
public class Item extends AVObject {
    public Item()
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
    public String getURL()
    {
        return getString("URL");
    }
    public void SetURL(String url)
    {
        put("URL",url);
    }
}
