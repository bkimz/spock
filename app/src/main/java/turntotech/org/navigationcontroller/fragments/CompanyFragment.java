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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import turntotech.org.navigationcontroller.R;


public class CompanyFragment extends ListFragment {

    ProductFragment productFragment;
    AwesomeAdapter adapter;
    private List <Companies> companiesList;


    public CompanyFragment() {
        productFragment = new ProductFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView)mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setVisibility(View.INVISIBLE);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);
        title.setText("Watch List");

        String[] companies = new String[] { "Apple", "Samsung", "LG", "Huawei" };
        String[] companyStockPrice = new String[]{"$120", "$1200", "$600", "$40"};
        int [] icons = new int[]{R.drawable.apple, R.drawable.samsung, R.drawable.lg, R.drawable.huawei};


        companiesList = new ArrayList<Companies>();


        for (int i = 0; i < companies.length; i++){
            Companies addcompany = new Companies(icons[i], companies[i], companyStockPrice[i]);
            companiesList.add(addcompany);

        }

        adapter = new AwesomeAdapter(getActivity(), companiesList);
        setListAdapter(adapter);




            return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);



        //TextView title = (TextView)v.findViewById(android.R.id.text1);
        TextView companyText = (TextView) v.findViewById(R.id.CompanyName);

        Bundle bundle = new Bundle();
        bundle.putInt("CompanyIndex", position);
        bundle.putString("CompanyTitle", companyText.getText().toString());

        productFragment.setArguments(bundle);


        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_container, productFragment);
        transaction.commit();



    }


}
