package turntotech.org.navigationcontroller;

//import android.support.v4.app.FragmentTransaction;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import turntotech.org.navigationcontroller.fragments.Companies;
import turntotech.org.navigationcontroller.fragments.CompanyFragment;

public class MainActivity extends AppCompatActivity {
    public static List<Companies> companiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] companies = new String[] { "Apple", "Samsung", "LG", "Huawei" };
        String[] companyStockPrice = new String[]{"$120", "$1200", "$600", "$40"};
        int [] icons = new int[]{R.drawable.apple, R.drawable.samsung, R.drawable.lg, R.drawable.huawei};


        companiesList = new ArrayList<Companies>();


        for (int i = 0; i < companies.length; i++){
            Companies addcompany = new Companies(icons[i], companies[i], companyStockPrice[i]);
            companiesList.add(addcompany);
            Log.i("david" , "&Goliath");

        }


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new CompanyFragment()).commit();

    }
}
