package com.whiskeytangoapps.torqueconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class ConvertTorque extends AppCompatActivity {

    EditText inLbsEditText;
    EditText ftLbsEditText;
    EditText nMEditText;
    EditText kgfCmEditText;

    final double INLBS_TO_FTLBS = 12.0; //inlbs / 12 = ftlbs
    final double INLBS_TO_NM = 8.850745791327185; //inlbs / 8.507 = nm
    final double INLBS_TO_KGFCM = 0.8679616597966708; //inlbs / 0.867

    final double FTLBS_TO_INBLS = 12.0; //ftlbs * 12 = inbls
    final double FTLBS_TO_NM = 0.7375621492772656; //ftlbs / 0.737 = nm
    final double FTLBS_TO_KGFCM = 0.07233013851209893; //ftlbs / 0.07 = kgcm

    final double NM_TO_INLBS = 0.1129848293333328; //nm / 0.1129 = inlbs
    final double NM_TO_FTLBS = 1.355817948331392; //nm * 1.3558 = ftlbs
    final double NM_TO_KGFCM = 0.09806650000000271; //nm / 0.098 = kgfcm

    final double KGFCM_TO_INLBS = 0.0720077889323413; //kgfcm / 0.072 = inlbs
    final double KGFCM_TO_FLLBS = 13.825495437599988; //kgfcm * 13.83 = ftlbs
    final double KGFCM_TO_NM = 10.197162129779283; //kgfcm * 10.197 = nm

    double inlbs;
    double ftlbs;
    double nm;
    double kgfcm;

    boolean inlbsLastEdit = false;
    boolean ftlbsLastEdit = false;
    boolean nMLastEdit = false;
    boolean kgfcmLastEdit = false;

    TextWatcher inlbsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (charSequence.length() != 0) {

                clearAllEditTexts(false, true, true, true);
                setLastEdit(true, false, false, false);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

            inLbsEditText.addTextChangedListener(inlbsTextWatcher);

        }
    };
    TextWatcher ftlbsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (charSequence.length() != 0) {

                clearAllEditTexts(true, false, true, true);
                setLastEdit(false, true, false, false);

            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    TextWatcher nmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (charSequence.length() != 0) {

                clearAllEditTexts(true, true, false, true);
                setLastEdit(false, false, true, false);

            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    TextWatcher kgfcmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (charSequence.length() != 0) {

                clearAllEditTexts(true, true, true, false);
                setLastEdit(false, false, false, true);

            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void clearAllEditTexts(boolean a, boolean b, boolean c, boolean d) {

        if (a) { inLbsEditText.setText(null); }
        if (b) { ftLbsEditText.setText(null); }
        if (c) { nMEditText.setText(null); }
        if (d) { kgfCmEditText.setText(null); }

        return;
    }

    public void setLastEdit(boolean a, boolean b, boolean c, boolean d) {

        inlbsLastEdit = a;
        ftlbsLastEdit = b;
        nMLastEdit = c;
        kgfcmLastEdit = d;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_torque);

        inLbsEditText = findViewById(R.id.inLbsEditText);
        ftLbsEditText = findViewById(R.id.ftLbsEditText);
        nMEditText = findViewById(R.id.nMEditText);
        kgfCmEditText = findViewById(R.id.kgfCmEditText);

        Button convertButton = findViewById(R.id.convertButton);
        Button backButton = findViewById(R.id.backButton);

        inLbsEditText.addTextChangedListener(inlbsTextWatcher);
        ftLbsEditText.addTextChangedListener(ftlbsTextWatcher);
        nMEditText.addTextChangedListener(nmTextWatcher);
        kgfCmEditText.addTextChangedListener(kgfcmTextWatcher);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inlbsLastEdit) {

                    inlbs = Double.parseDouble(inLbsEditText.getText().toString());
                    ftlbs = inlbs / INLBS_TO_FTLBS;
                    nm = inlbs / INLBS_TO_NM;
                    kgfcm = inlbs / INLBS_TO_KGFCM;

                }
                if (ftlbsLastEdit) {

                    ftlbs = Double.parseDouble(ftLbsEditText.getText().toString());
                    inlbs = ftlbs * FTLBS_TO_INBLS;
                    nm = ftlbs / FTLBS_TO_NM;
                    kgfcm = ftlbs / FTLBS_TO_KGFCM;

                }
                if (nMLastEdit) {

                    nm = Double.parseDouble(nMEditText.getText().toString());
                    inlbs = nm / NM_TO_INLBS;
                    ftlbs = nm * NM_TO_FTLBS;
                    kgfcm = nm / NM_TO_KGFCM;

                }
                if (kgfcmLastEdit) {

                    kgfcm = Double.parseDouble(kgfCmEditText.getText().toString());
                    inlbs = kgfcm / KGFCM_TO_INLBS;
                    ftlbs = kgfcm * KGFCM_TO_FLLBS;
                    nm = kgfcm * KGFCM_TO_NM;

                }

                DecimalFormat df = new DecimalFormat("#.##");
                String inlbsString = df.format(inlbs);
                String ftlbsString = df.format(ftlbs);
                String nMString = df.format(nm);
                String kgfCmString = df.format(kgfcm);

                inLbsEditText.removeTextChangedListener(inlbsTextWatcher);
                ftLbsEditText.removeTextChangedListener(ftlbsTextWatcher);
                nMEditText.removeTextChangedListener(nmTextWatcher);
                kgfCmEditText.removeTextChangedListener(kgfcmTextWatcher);

                inLbsEditText.setText(inlbsString);
                ftLbsEditText.setText(ftlbsString);
                nMEditText.setText(nMString);
                kgfCmEditText.setText(kgfCmString);

                inLbsEditText.addTextChangedListener(inlbsTextWatcher);
                ftLbsEditText.addTextChangedListener(ftlbsTextWatcher);
                nMEditText.addTextChangedListener(nmTextWatcher);
                kgfCmEditText.addTextChangedListener(kgfcmTextWatcher);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConvertTorque.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
