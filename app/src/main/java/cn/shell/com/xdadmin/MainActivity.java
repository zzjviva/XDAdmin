package cn.shell.com.xdadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

import Interface.NormalCallback;
import Model.LoginModel;
import Model.NoteModel;
import Model.QueryModel;
import Model.RegisterModel;
import Model.RoleModel;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.text);
        mTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginModel.Login(new NormalCallback() {
                    @Override
                    public void OnCallBack(String msg) {
                        OnShowMessage(msg);
                        QueryModel.QueryAllNotes();
                    }
                });

//                RegisterModel.RegistAdmin(new NormalCallback() {
//                    @Override
//                    public void OnCallBack(String msg) {
//                        OnShowMessage(msg);
//
//                    }
//                });
//                NoteModel noteModel = new NoteModel();
//                noteModel.Create_InsetNote(new NormalCallback() {
//                    @Override
//                    public void OnCallBack(String msg) {
//                        OnShowMessage(msg);
//                    }
//                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void OnShowMessage(String msg)
    {
        String con = mTextView.getText().toString();
        con += msg + "\r\n";
        mTextView.setText(con);
    }
}
