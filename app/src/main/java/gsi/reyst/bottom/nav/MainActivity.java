package gsi.reyst.bottom.nav;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(this);
        bottomBar.setDefaultTab(R.id.nav3);
    }

    @Override
    public void onTabSelected(int tabId) {

        Fragment f = null;
        switch (tabId) {
            case R.id.nav1:
                f = Fragment1.getInstance("1", true);
                break;
            case R.id.nav2:
                f = Fragment1.getInstance("2", true);
                break;
            case R.id.nav3:
                f = Fragment1.getInstance("3", true);
                break;
            case R.id.nav4:
                f = Fragment1.getInstance("4", false);
                break;
            case R.id.nav5:
                f = Fragment1.getInstance("5", false);
                break;
        }

        if (f != null)
            getFragmentManager().beginTransaction()
                    .replace(R.id.content_main, f, null)
                    .commit();

    }

    public void setText(String name) {
        TextView txt = (TextView) findViewById(R.id.tv_name);
        txt.setText(name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(name);
    }

    public void setBarVisibility(boolean visible) {
        bottomBar.setVisibility(visible ? VISIBLE : GONE);
    }
}
