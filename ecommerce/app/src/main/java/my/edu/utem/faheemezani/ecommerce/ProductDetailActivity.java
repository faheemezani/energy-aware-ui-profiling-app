package my.edu.utem.faheemezani.ecommerce;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView productTitle = findViewById(R.id.productTitle);
        Button addToCartButton = findViewById(R.id.addToCartButton);

        String productName = getIntent().getStringExtra("productName");
        productTitle.setText(productName);

        addToCartButton.setOnClickListener(v -> Toast.makeText(this, productName + " added to cart.", Toast.LENGTH_SHORT).show());
    }
}