package turntotech.org.navigationcontroller.fragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;


public class ProductFragment extends ListFragment {

    WebviewFragment webviewFragment;
    int companyPosition;

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


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
        companyPosition = bundle.getInt("CompanyIndex");
        title.setText(bundle.getString("CompanyTitle") + " Products");



        String[] products = null;

        if(companyPosition==0){
            products = new String[] { Apple.iphone, Apple.ipad, Apple.mac };
        }
        if(companyPosition==1){
            products = new String[] {Samsung.gearvr, Samsung.gearfit, Samsung.s7};
        }
        if(companyPosition==2){
            products = new String[] { LG.g5, LG.gpad2, LG.smartwatch };
        }
        if(companyPosition==3){
            products = new String[] { Huawei.p9, Huawei.matebook, Huawei.talkband };
        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, products);
        setListAdapter(arrayAdapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bundle = new Bundle();
        bundle.putInt("CompanySelected", companyPosition);
        bundle.putInt("ProductName", position);

        webviewFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_container, webviewFragment);
        transaction.commit();

    }


}
