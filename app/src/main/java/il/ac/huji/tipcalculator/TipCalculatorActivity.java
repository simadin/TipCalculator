package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        final EditText edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
        final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
        final Button btnCalculate = (Button)findViewById(R.id.btnCalculate);
        final TextView txtTipResult = (TextView)findViewById(R.id.txtTipResult);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bill = Double.parseDouble(edtBillAmount.getText().toString());
                String tip = "";
                if (chkRound.isChecked()) {
                    tip = String.format("%d", Math.round(bill * 12 / 100));
                } else {
                    tip = String.format("%.2f", Math.round(bill * 12) / 100.0);
                }
                txtTipResult.setText("Tip: $" + tip);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
