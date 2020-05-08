package projek.dirumahaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import projek.dirumahaja.model.User;
import projek.dirumahaja.util.PrefUtil;

public class MainActivity extends AppCompatActivity {

    private TextView greeting;
    private TextView email;
    private Button btnLogout;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.dashboard);

        greeting = (TextView) findViewById(R.id.greeting);
        email = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        User user = PrefUtil.getUser(this, PrefUtil.USER_SESSION);

        greeting.setText(user.getData().getNama());
        email.setText(user.getData().getEmail());
//        email.setText("cococo");

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutAct();

                LoginActivity.start(MainActivity.this);
                MainActivity.this.finish();
            }
        });

    }

    void logoutAct() {
        PrefUtil.clear(this);
    }

    public void dashboard(View view) {
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
    }
}
