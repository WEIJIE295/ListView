package edu.fjnu.cse.listview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String [] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int [] imageIds = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("animalname",names[i]);
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }

        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"animalname","image"},
                new int[]{R.id.name,R.id.imageAn});
        ListView list = (ListView) findViewById(R.id.mylistview);
        list.setAdapter(simpleAdapter);
        list.setItemsCanFocus(true);
        simpleAdapter.notifyDataSetInvalidated();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.BLUE);
                Map<String,Object> listItem = listItems.get(position);
                Toast.makeText(MainActivity.this,listItem.get("animalname").toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
