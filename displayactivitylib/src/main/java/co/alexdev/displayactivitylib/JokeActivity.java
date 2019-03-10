package co.alexdev.displayactivitylib;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private TextView tvJoke;
    private Intent intent;
    private String intentJokeKey;
    private String saveInstanceStateKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        tvJoke = findViewById(R.id.tv_joke);

        intent = getIntent();
        intentJokeKey = getResources().getString(R.string.intent_extra_joke);
        saveInstanceStateKey = getString(R.string.save_key);

        showJoke();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString(saveInstanceStateKey, tvJoke.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey(saveInstanceStateKey)) {
            String joke = savedInstanceState.getString(saveInstanceStateKey);
            tvJoke.setText(joke);
        }
    }

    private void showJoke() {
        if (intent != null && intent.hasExtra(intentJokeKey)) {
            String joke = intent.getStringExtra(intentJokeKey);
            tvJoke.setText(joke);
        }
    }
}
