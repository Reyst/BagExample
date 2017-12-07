package gsi.reyst.bottom.nav;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
//import static gsi.reyst.bottom.nav.Fragment1.KEY_NAME;
//import static gsi.reyst.bottom.nav.Fragment1.KEY_VISIBLE;

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

//        Fragment f = new Fragment1();
//        Bundle params = new Bundle(2);


//        switch (tabId) {
//            case R.id.nav1:
//                //f = Fragment1.getInstance("1", true);
//                params.putString(KEY_NAME, "1");
//                params.putBoolean(KEY_VISIBLE, true);
//                break;
//            case R.id.nav2:
////                f = Fragment1.getInstance("2", true);
//                params.putString(KEY_NAME, "2");
//                params.putBoolean(KEY_VISIBLE, true);
//                break;
//            case R.id.nav3:
////                f = Fragment1.getInstance("3", true);
//                params.putString(KEY_NAME, "3");
//                params.putBoolean(KEY_VISIBLE, true);
//                break;
//            case R.id.nav4:
////                f = Fragment1.getInstance("4", false);
//                params.putString(KEY_NAME, "4");
//                params.putBoolean(KEY_VISIBLE, false);
//                break;
//            case R.id.nav5:
////                f = Fragment1.getInstance("5", false);
//                params.putString(KEY_NAME, "5");
//                params.putBoolean(KEY_VISIBLE, false);
//                break;
//        }
//        f.setArguments(params);

//        if (f != null)
            getFragmentManager().beginTransaction()
                    .replace(R.id.content_main, new Fragment1())
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
        findViewById(R.id.spacer).setVisibility(visible ? VISIBLE : GONE);
    }


    public void onShowAllChildren() {
        ViewGroup rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        print(rootView, 0);
    }

    private void print(View rootView, int level) {

        String prefix = createPrefix(level);
        Log.d("CHECK", prefix + rootView.getClass().getSimpleName() + ": " + rootView.getMeasuredHeight());

        if (rootView instanceof ViewGroup) {
            ViewGroup rootViewGroup = (ViewGroup) rootView;
            for (int i = 0; i < rootViewGroup.getChildCount(); i++)
                print(rootViewGroup.getChildAt(i), level + 1);
        }
    }

    private String createPrefix(int level) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < level; i++) result.append("-");
        return result.toString();
    }
}
