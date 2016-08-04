package turntotech.org.navigationcontroller.fragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
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

import turntotech.org.navigationcontroller.MainActivity;
import turntotech.org.navigationcontroller.R;


public class CompanyFragment extends ListFragment  {

    ProductFragment productFragment;
    AwesomeAdapter adapter;


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



        adapter = new AwesomeAdapter(getActivity(), MainActivity.companiesList);
        setListAdapter(adapter);





        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        registerForContextMenu(this.getListView());
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Edit");
        menu.add("Delete");




    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String menuString = String.valueOf(item.getTitle());
        int position = info.position;



        switch (menuString) {

            case "Delete": // <-- your custom menu item id here
                MainActivity.companiesList.remove(position);
                //companiesList.remove(getSelectedItemPosition());

                 // companiesList.remove(getListAdapter().getItem(getSelectedItemPosition()));


                Log.d("position" , " " + position);

                adapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }



}
