package sg.edu.np.WhackAMole;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttonLeft;
    private Button buttonMiddle;
    private Button buttonRight;

    private Integer scoreCount;

    private static final String TAG="Whack-a-mole";
    TextView score;

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=(TextView)findViewById(R.id.text);
        buttonLeft=findViewById(R.id.Button1);
        buttonMiddle=findViewById(R.id.Button2);
        buttonRight=findViewById(R.id.Button3);
        scoreCount =0 ;

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 1 Clicked");
                if (buttonLeft.getText().toString() == "*") {
                    scoreCount = scoreCount + 1;
                    score.setText(Integer.toString(scoreCount));
                } else {
                    scoreCount = scoreCount - 1;
                    score.setText(Integer.toString(scoreCount));
                }
                setNewMole();
            }
        });
        buttonMiddle.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
            Log.v(TAG, "Button 2 Clicked");
            if (buttonMiddle.getText().toString() == "*") {
                scoreCount = scoreCount + 1;
                score.setText(Integer.toString(scoreCount));
            } else {
                scoreCount = scoreCount - 1;
                score.setText(Integer.toString(scoreCount));
            }
            setNewMole();
        }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
            Log.v(TAG, "Button 3 Clicked");
            if (buttonRight.getText().toString() == "*") {
                scoreCount = scoreCount + 1;
                score.setText(Integer.toString(scoreCount));
            } else {
                scoreCount = scoreCount - 1;
                score.setText(Integer.toString(scoreCount));
            }
            setNewMole();
        }
        });






        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if(randomLocation ==0)
        {
            buttonLeft.setText("*");
            buttonMiddle.setText("O");
            buttonRight.setText("O");
        }
        else if(randomLocation ==1)
        {
            buttonLeft.setText("O");
            buttonMiddle.setText("*");
            buttonRight.setText("O");
        }
        else
        {
            buttonLeft.setText("O");
            buttonMiddle.setText("O");
            buttonRight.setText("*");
        }
    }
}
