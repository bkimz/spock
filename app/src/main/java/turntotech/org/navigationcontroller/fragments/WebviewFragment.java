package turntotech.org.navigationcontroller.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;

/**
 * Created by adityanarayan on 7/26/16.
 */
public class WebviewFragment extends Fragment {
    WebView productWebview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView)mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

        Bundle bundle = this.getArguments();
        int productPositions = bundle.getInt("ProductName");
        int companySelected = bundle.getInt("CompanySelected");

        String [][] urls = {{WebURLs.iphone, WebURLs.ipad, WebURLs.mac},{WebURLs.galaxyvr, WebURLs.gearfit, WebURLs.galaxys7},
                {WebURLs.huaweip9, WebURLs.huaweimatebook, WebURLs.huaweitalkband}};

        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
