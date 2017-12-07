package gsi.reyst.bottom.nav;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;


public class Fragment1 extends Fragment implements View.OnClickListener {

//    public static final String KEY_NAME = "name";
//    public static final String KEY_VISIBLE = "visible";
    private String _name = "";
    private boolean _visible = false;

//    public static Fragment getInstance(String name, boolean b) {
//        Fragment f = new Fragment1();
//        Bundle params = new Bundle(1);
//        params.putString(KEY_NAME, name);
//        params.putBoolean(KEY_VISIBLE, b);
//        f.setArguments(params);
//
//        return f;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _name = "name";//getArguments().getString(KEY_NAME);
        _visible = true; //getArguments().getBoolean(KEY_VISIBLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MainActivity) getActivity()).setText(_name);
        ((MainActivity) getActivity()).setBarVisibility(_visible);
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
        view.findViewById(R.id.btn3).setOnClickListener(this);
        view.findViewById(R.id.btn4).setOnClickListener(this);
        view.findViewById(R.id.btn5).setOnClickListener(this);
        view.findViewById(R.id.btn6).setOnClickListener(this);

        //(MeasureSpec.makeMeasureSpec(parentView.getWidth(), MeasureSpec.EXACTLY),
        // MeasureSpec.makeMeasureSpec(MAX_HEIGHT, MeasureSpec.AT_MOST));

        view.findViewById(R.id.nested_scroll).measure(
                View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), View.MeasureSpec.EXACTLY));
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("TEST", "Restored: " + _name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                ((MainActivity) getActivity()).onTabSelected(R.id.nav1);
                break;
            case R.id.btn2:
                ((MainActivity) getActivity()).onTabSelected(R.id.nav2);
                break;
            case R.id.btn3:
                ((MainActivity) getActivity()).onTabSelected(R.id.nav3);
                break;
            case R.id.btn4:
                ((MainActivity) getActivity()).onTabSelected(R.id.nav4);
                break;
            case R.id.btn5:
                ((MainActivity) getActivity()).onTabSelected(R.id.nav5);
                break;
            case R.id.btn6:
                ((MainActivity) getActivity()).onShowAllChildren();
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("CHECK", String.valueOf(getView().getMeasuredHeight()));

    }
}
