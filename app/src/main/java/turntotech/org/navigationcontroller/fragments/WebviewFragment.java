package turntotech.org.navigationcontroller.fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;

/**
 * Created by adityanarayan on 7/26/16.
 */
public class WebviewFragment extends Fragment {
    WebView webview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View mCustomView = inflater.inflate(R.layout.web_view, container, false);
        //View mCustomView = inflater.inflate(R.layout.web_activity, null);
        WebView webview = (WebView) mCustomView.findViewById(R.id.webview2);







        Bundle bundle = this.getArguments();
        int productPositions = bundle.getInt("ProductName");
        int companySelected = bundle.getInt("CompanySelected");

        String [][] urls = {{"http://www.apple.com/iphone/", "http://www.apple.com/ipad/", "http://www.apple.com/mac/"},{"http://www.samsung.com/global/galaxy/wearables/gear-vr/", "http://www.samsung.com/global/galaxy/gear-fit2/", "http://www.samsung.com/global/galaxy/galaxy-s7/"},
                {"http://www.lg.com/us/mobile-phones/g5#G5Modularity", "http://www.lg.com/us/tablets/lg-V940N-g-pad-ii-10.1", "http://www.lg.com/us/smart-watches"},{"http://consumer.huawei.com/en/mobile-phones/p9/index.html", "http://consumer.huawei.com/en/tablets/matebook/index.htm", "http://consumer.huawei.com/en/wearables/talkband-b3/index.html"}};


        webview.loadUrl (urls[companySelected][productPositions]);

        return mCustomView;

    }

}
