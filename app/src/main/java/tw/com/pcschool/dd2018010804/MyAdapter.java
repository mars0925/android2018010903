package tw.com.pcschool.dd2018010804;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Map<String, Object>> mylist = new ArrayList();
    boolean chks[] = new boolean[8];
    public MyAdapter(ArrayList<Map<String, Object>> mylist)
    {
        this.mylist = mylist;
    }
    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        Log.d("GetView", "position:" + position);
        View v = inflater.inflate(R.layout.myitem, null);

        TextView tv = v.findViewById(R.id.textView);
        tv.setText(mylist.get(position).get("city").toString());
        TextView tv2 = v.findViewById(R.id.textView2);
        tv2.setText(mylist.get(position).get("code").toString());
        ImageView img = v.findViewById(R.id.imageView);
        img.setImageResource((Integer) mylist.get(position).get("img"));
        CheckBox chk = (CheckBox) v.findViewById(R.id.checkBox);
        chk.setChecked(chks[position]);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position] = b;
            }
        });
        return v;
    }
}
