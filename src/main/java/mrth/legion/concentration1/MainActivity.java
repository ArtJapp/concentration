package mrth.legion.concentration1;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    GameEngine game;
    private int score = 0;

    private final int COUNT = 12;

    private String picked1 = "0", picked2 = "0";
    private int idpicked1 = 0, idpicked2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new GameEngine(COUNT);
    }

    public void firer()
    {
        if (idpicked1!=0 && idpicked2!=0)
        {
            boolean success = this.game.fire(picked1, picked2);

            Button b1 = (Button) findViewById(idpicked1);
            Button b2 = (Button) findViewById(idpicked2);

            if (success)
            {
                b1.setClickable(false);
                b2.setClickable(false);
                b1.setBackgroundColor(0);
                b1.setTextColor(0);
                b2.setTextColor(0);
                b2.setBackgroundColor(0);

            }
            this.score++;
            TextView score_text = (TextView) findViewById(R.id.textView);
            score_text.setText("SCORE: " + this.score);
        }

    }

    public void check(View view) {
        if (idpicked2>0 && idpicked1 > 0)
        {
            Button b1 = (Button) findViewById(idpicked1);
            Button b2 = (Button) findViewById(idpicked2);
            b1.setText(" ");
            b2.setText(" ");
            this.idpicked1 = this.idpicked2 = 0;
        }

        int id = view.getId();
        String text = getResources().getResourceEntryName(view.getId());
        text = text.substring(4);
        Button b = (Button) findViewById(id);
        b.setText(""+this.game.cards.get(text).openCard());

//        TextView t = findViewById(R.id.textView);
//        t.setText(""+id);

        if (idpicked1 == 0) {
            idpicked1 = id;
            picked1 = text;

        } else {
            idpicked2 = id;
            picked2 = text;
            if (idpicked2 == idpicked1)
            {
                picked2 = "0";
                idpicked2 = 0;
            }
            else {
                firer();
            }
        }
    }

    public void renova(View view) {
        this.game = new GameEngine(COUNT);
        int id = R.id.card11;
        this.score = 0;

        for (int i = 0; i < COUNT; i++)
        {
            Button temp = (Button) findViewById(id + i);
            temp.setText("");
            temp.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            temp.setBackgroundColor(getResources().getColor(R.color.colorCard));
            temp.setClickable(true);
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("SCORE: 0");
    }
}
