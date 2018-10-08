package eecs1022.lab6;

import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.*;
import java.lang.String;

public class lab6Activity extends AppCompatActivity
{
    Game newGame;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);
    }
    private void setContentsOfTextView(int id, String newContents)
    {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);

    }

    private String getInputOfTextField(int id)
    {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;

    }

    private String getItemSelected(int id)
    {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        return spinner.getSelectedItem().toString();
    }

    public void newGame(View view){
        newGame = new Game(getInputOfTextField(R.id.px), getInputOfTextField(R.id.po), getItemSelected(R.id.firstPlayer));
        newGame.initGame();
        setContentsOfTextView(R.id.output, newGame.toString());

    }
    public void play(View view){
        newGame.turn(Integer.parseInt(getItemSelected(R.id.spinner2)), Integer.parseInt(getItemSelected(R.id.spinner)));
        setContentsOfTextView(R.id.output, newGame.toString());
    }
}
