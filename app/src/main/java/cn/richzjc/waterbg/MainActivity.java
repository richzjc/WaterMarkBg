package cn.richzjc.waterbg;

import android.app.Activity;
import android.os.Bundle;

import com.richzjc.library.WaterMarkBg;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bg).setBackground(new WaterMarkBg(this, -30, R.mipmap.app_logo_black));
    }
}
