package fr.wildcodeschool.uijava;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static float dpTopixel(Context c, float dp) {
        float density = c.getResources().getDisplayMetrics().density;
        float pixel = dp * density;
        return pixel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout lMainLayout = this.findViewById(R.id.mainLinearLayout);
        LinearLayout lName = new LinearLayout(this);
        LinearLayout lLName = new LinearLayout(this);
        TextView title = new TextView(this);
        final CheckBox isWilder = new CheckBox(this);
        final EditText firstname = new EditText(this);
        Space spaceName = new Space(this);
        final EditText lastname = new EditText(this);
        Space spaceLastName = new Space(this);
        final Button button = new Button(this);
        final TextView validation = new TextView(this);

        lName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        lLName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        title.setText(getString(R.string.welcome));
        title.setBackgroundColor(getColor(R.color.title));
        title.setTextColor(getColor(R.color.text));
        title.setTextSize(20);
        title.setPadding((int)dpTopixel(this, 10), (int)dpTopixel(this, 5), (int)dpTopixel(this, 10), (int)dpTopixel(this, 5));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,(int)dpTopixel(this,10),0, (int)dpTopixel(this, 10));
        title.setLayoutParams(layoutParams);

        lName.setOrientation(LinearLayout.HORIZONTAL);
        lLName.setOrientation(LinearLayout.HORIZONTAL);
        lName.setWeightSum(2);
        lLName.setWeightSum(2);
        firstname.setHint(R.string.firstname);
        lastname.setHint(R.string.lastname);
        firstname.setEms(10);
        lastname.setEms(10);
        firstname.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        lastname.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        firstname.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        spaceName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
        lastname.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        spaceLastName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));

        firstname.setEnabled(false);
        lastname.setEnabled(false);

        button.setEnabled(false);
        button.setText(R.string.button);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        isWilder.setText(getString(R.string.isWilder));
        LinearLayout.LayoutParams isParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        isParams.gravity = Gravity.CENTER_HORIZONTAL;
        isWilder.setLayoutParams(isParams);
        validation.setGravity(Gravity.CENTER_HORIZONTAL);

        lMainLayout.addView(title);
        lMainLayout.addView(isWilder);
        lMainLayout.addView(lName);
        lName.addView(firstname);
        lName.addView(spaceName);
        lMainLayout.addView(lLName);
        lLName.addView(lastname);
        lLName.addView(spaceLastName);
        lMainLayout.addView(button);
        lMainLayout.addView(validation);


        isWilder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    firstname.setEnabled(true);
                    lastname.setEnabled(true);
                    button.setEnabled(true);
                }else{
                    firstname.setEnabled(false);
                    lastname.setEnabled(false);
                    button.setEnabled(false);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goodText = getString(R.string.congratulation) + " " + firstname.getText().toString() + " " + lastname.getText().toString();
                if (TextUtils.isEmpty(firstname.getText().toString()) || TextUtils.isEmpty(lastname.getText().toString()))
                    Toast.makeText(getApplicationContext(), R.string.empty, Toast.LENGTH_SHORT).show();
                else
                    validation.setText(goodText);

            }
        });
    }
}
