package tw.com.pcschool.dd2018010804;

import android.content.Context;
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

//把MyAdapter extends BaseAdapter寫在分開寫,寫成單獨的class的時候
/*要改哪裡
    1.public MyAdapter(Context context, ArrayList<Map<String, Object>> mylist)
    2. LayoutInflater inflater = LayoutInflater.from(context);
    好處是可以不同人來寫比較方便
     */
public class MyAdapter extends BaseAdapter {
    ArrayList<Map<String, Object>> mylist = new ArrayList();
    boolean chks[] ;
    Context context;
    //建構式
    public MyAdapter(Context context, ArrayList<Map<String, Object>> mylist,boolean chks[])
    {
        this.context = context;
        this.mylist = mylist;
        this.chks = chks;
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
    //讓getView不需要一直去findViewById的動作    增加效能
    public View getView(final int position, View v, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        //當v這個view是不存在的時候,表示是第一次產生的時候
        if (v == null)
        {
            //把context這個view解出來
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.myitem, null);
            //new ViewHolder 來用
            viewHolder = new ViewHolder();
            //下面用的元件都是從ViewHolder拿來的
            viewHolder.tv = v.findViewById(R.id.textView);
            viewHolder.tv2 = v.findViewById(R.id.textView2);
            viewHolder.img = v.findViewById(R.id.imageView);
            viewHolder.chk = (CheckBox) v.findViewById(R.id.checkBox);
            //把已經設定好的viewHolder 放到setTag裡面 之後可以再用
            v.setTag(viewHolder);
        }
        //如果 v這個view存在的話,表示是回收再用的view
        else
        {
            //就直接將tag裡面的來用 ,不用再findViewById
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.tv.setText(mylist.get(position).get("city").toString());
        viewHolder.tv2.setText(mylist.get(position).get("code").toString());
        viewHolder.img.setImageResource((Integer) mylist.get(position).get("img"));
        viewHolder.chk.setOnCheckedChangeListener(null);
        viewHolder.chk.setChecked(chks[position]);
        viewHolder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chks[position] = b;
            }
        });


        return v;
    }
    //產生一個class放重複使用的元件
    static class ViewHolder
    {
        TextView tv;
        TextView tv2;
        ImageView img;
        CheckBox chk;
    }
}
