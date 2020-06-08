package sg.edu.rp.c346.id19045346.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    EditText etIndexElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        final ArrayList<String> alColours = new ArrayList<>();

        alColours.addAll(Arrays.asList("Red","Orange"));


        final ArrayAdapter<String> aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,alColours);

        lvColour.setAdapter(aaColour);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etElement.getText().toString().isEmpty()) {
                    String colour = etElement.getText().toString();
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColours.add(pos,colour);
                    aaColour.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(MainActivity.this,"Please enter text",Toast.LENGTH_SHORT).show();
                }

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = "";

                for(int i = 0; i < alColours.size(); i++) {
                    if(position == i) {
                        colour = alColours.get(i);

                    }
                }

                Toast.makeText(MainActivity.this,colour,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
