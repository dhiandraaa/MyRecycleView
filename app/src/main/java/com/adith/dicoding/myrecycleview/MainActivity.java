package com.adith.dicoding.myrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.adith.dicoding.myrecycleview.Adapter.CardViewPresidenAdapter;
import com.adith.dicoding.myrecycleview.Adapter.GridPresidenAdapter;
import com.adith.dicoding.myrecycleview.Adapter.ListPresidenAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Presiden>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(DataPresiden.getListData());

        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPresidenAdapter listPresidenAdapter = new ListPresidenAdapter(this);
        listPresidenAdapter.setListPresident(list);
        rvCategory.setAdapter(listPresidenAdapter);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridPresidenAdapter gridPresidentAdapter = new GridPresidenAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidenAdapter cardViewPresidentAdapter = new CardViewPresidenAdapter(this);
        cardViewPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_card_view:
                showRecyclerCardView();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
