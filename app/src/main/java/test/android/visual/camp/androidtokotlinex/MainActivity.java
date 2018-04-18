package test.android.visual.camp.androidtokotlinex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText input_et;
    private Button input_btn;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_et = findViewById(R.id.editText);
        input_btn = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recycler_view);
        final RecyclerAdapter adapter = new RecyclerAdapter(R.layout.activity_recycler_item);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        input_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contents = input_et.getText().toString();
                if(contents.length() > 0){
                    adapter.addContents(contents);
                    adapter.notifyDataSetChanged();
                    input_et.setText("");
                }else {
                    Toast.makeText(getApplicationContext(),"내용입력하고 버튼 누르세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
