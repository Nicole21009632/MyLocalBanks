package sg.edu.rp.c346.id21009632.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;
    String bankClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbsText);
        ocbc = findViewById(R.id.ocbcText);
        uob = findViewById(R.id.uobText);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == dbs) {
            bankClicked = "dbs";

        } else if ( v == ocbc) {
            bankClicked = "ocbc";

        } else if ( v == uob) {
            bankClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            if (bankClicked == "dbs") {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

            } else if (bankClicked == "ocbc") {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com.sg"));
                startActivity(intent);

            } else if (bankClicked == "uob") {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }
            return true;

        } else if (item.getItemId() == 1) {
            if (bankClicked == "dbs") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+1800"+1111111));
                startActivity(intentCall);

            } else if (bankClicked == "ocbc") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+1800"+3633333));
                startActivity(intentCall);

            } else if (bankClicked == "uob") {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+1800"+2222121));
                startActivity(intentCall);
            }

            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText(" D B S  ");
            ocbc.setText(" O C B C ");
            uob.setText(" U O B  ");
            return true;

        } else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;

        } else {
            dbs.setText("Error translation");
            ocbc.setText("Error translation");
            uob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}