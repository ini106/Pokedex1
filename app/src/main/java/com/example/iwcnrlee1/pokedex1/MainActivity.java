package com.example.iwcnrlee1.pokedex1;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<LinearLayout> layouts = new ArrayList<>();
     LinearLayout layout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText search = (EditText)findViewById(R.id.etSearch);
        layout = (LinearLayout)findViewById(R.id.layout);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                layout.removeAllViews();
                if(editable.length()>0){
                    for(Button b: buttons){
                        if(b.getText().toString().toLowerCase().contains(editable.toString())){
                            layout.addView((View) b.getParent());
                        }
                    }
                }
            }
        });

        Resources res = getResources();
         String[] pokemon_name ={"Bulbasaur","Ivysaur","Venusaur","Charmander","Charmeleon","Charizard","Squirtle","Wartortle","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill","Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu","Raichu","Sandshrew","Sandslash","Nidoranm","Nidorina","Nidoqueen","Nidoranf","Nidorino","Nidoking"};
        Toast.makeText(this,pokemon_name.length+"",Toast.LENGTH_SHORT);
        for(String name:pokemon_name){
            LinearLayout sublayout = new LinearLayout(this);
            sublayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            sublayout.setOrientation(LinearLayout.HORIZONTAL);
            ImageView image = new ImageView(this);
            int drawableID = this.getResources().getIdentifier(name.toLowerCase(),"mipmap",getPackageName());
            image.setImageResource(drawableID);
            Button btnName = new Button(this);
            btnName.setText(name);
            btnName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            sublayout.addView(image);
            sublayout.addView(btnName);
            layout.addView(sublayout);
            buttons.add(btnName);
            layouts.add(sublayout);
            btnName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String clicked = ((Button)v).getText().toString();
                    Toast.makeText(MainActivity.this, clicked, Toast.LENGTH_LONG).show();

                }
            });
        }

    }
    public void onClick(View v){
        String clicked = ((Button)v).getText().toString();
        Toast.makeText(this, clicked, Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.exit:
                finish();
                return true;
            default:
                    return super.onOptionsItemSelected(item);
        }
    }

}
