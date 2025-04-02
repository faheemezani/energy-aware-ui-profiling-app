package my.edu.utem.faheemezani.ecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] products = {"Laptop", "Smartphone", "Headphones", "Smartwatch", "Camera"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView productList = findViewById(R.id.productList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        productList.setAdapter(adapter);

        productList.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            intent.putExtra("productName", products[position]);
            startActivity(intent);
        });
    }
}
