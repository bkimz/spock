package turntotech.org.navigationcontroller.fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import turntotech.org.navigationcontroller.R;

/**
 * Created by adityanarayan on 7/26/16.
 */
public class AwesomeAdapter extends BaseAdapter {
    Context ctx;
    List<Companies> companies;

    AwesomeAdapter(Context ctx, List<Companies> companies){
        this.ctx = ctx;
        this.companies = companies;
    }
    @Override
    public int getCount() {
        companies.size();
        return companies.size();
    }

    @Override
    public Object getItem(int position) {
        return companies.get(position);
    }

    @Override
    public long getItemId(int position) {
       return companies.indexOf(getItem(position));

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater mInflater = (LayoutInflater) ctx.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_row, null);
        }
        ImageView imageicon = (ImageView) convertView.findViewById(R.id.list_image);
        TextView companyName = (TextView) convertView.findViewById(R.id.CompanyName);
        TextView stockPrice = (TextView) convertView.findViewById(R.id.StockPrice);


        Companies company_position = companies.get(position);
        imageicon.setImageResource(company_position.getImageId());
        companyName.setText(company_position.getCompanyName());
        stockPrice.setText(company_position.getCompanyStockPrice());

        return convertView;
    }
}
