package triplec.com;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class RouteActivity extends FragmentActivity {

    private static final int LIST = 0;
    private static final int MAP = 1;

    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        SwitchFragment(MAP);
        addButton = (FloatingActionButton) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToMyList();
            }
        });
    }

    public void ShowList(View v) {
        SwitchFragment(LIST);
    }

    public void ShowMap(View  v) {
        SwitchFragment(MAP);
    }

    public void SwitchFragment(int frag) {
        Fragment fragment = null;
        switch (frag) {
            case LIST:
                fragment = new ListFragment();
                break;
            case MAP:
                fragment = new MapFragment();
                break;
        }
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.show, fragment).commit();
    }

    public void AddToMyList(){
        Toast.makeText(RouteActivity.this, "Added to My Favorites", Toast.LENGTH_LONG).show();
    }

}
