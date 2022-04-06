package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Step 2
    ConstraintLayout myLayout;
    ArrayAdapter<String> adt;
    ListView lvList;
    int position;
    ArrayList<String> userSelection = new ArrayList<>();
    ArrayList<String> FRUITS = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        FRUITS.add("Kiwi");
        FRUITS.add("Mango");
        FRUITS.add("Cherry");
        FRUITS.add("Grapes");
        FRUITS.add("Banana");


        //Step 3

        myLayout = findViewById(R.id.myLayout);
        lvList = findViewById(R.id.my_listview);

        //    lvList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        lvList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        lvList.setMultiChoiceModeListener(modeListener);

        adt = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, FRUITS);
        lvList.setAdapter(adt);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_options_menu, menu);
        return true;
    }

    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
            position = i;
            if(userSelection.contains(FRUITS.get(i))){
                userSelection.remove(FRUITS.get(i));
            }
            else {
                userSelection.add(FRUITS.get(i));
            }
            actionMode.setTitle(userSelection.size()+"items selected");
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.my_context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
            switch (menuItem.getItemId()){
                case R.id.menuDEL:
                    removeItems(userSelection);
                    actionMode.finish();
                    return true;

                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            userSelection.clear();

        }
    };
    public void removeItems(List<String> items){
        for (String i:items){
          FRUITS.remove(i);
        }
        adt.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuBlack:
                myLayout.setBackgroundColor(Color.BLACK);
                break;
            case R.id.menuRed:
                myLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.menuGreen:
                myLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.menuBlue:
                myLayout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuYellow:
                myLayout.setBackgroundColor(Color.YELLOW);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}