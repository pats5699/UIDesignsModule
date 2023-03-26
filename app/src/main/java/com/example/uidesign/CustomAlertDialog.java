package com.example.uidesign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAlertDialog extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_alert_dialog);

        findViewById(R.id.btnSuccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessDialog();
            }
        });

        findViewById(R.id.btnWarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWarningDialog();
            }
        });

        findViewById(R.id.btnError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showErrorDialog();
            }
        });

        findViewById(R.id.btnRegular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegularDialog();
            }
        });

    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlertDialog.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(CustomAlertDialog.this).inflate(
                R.layout.success_custom_dialog,
                (RelativeLayout) findViewById(R.id.dialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.title)).setText(getResources().getString(R.string.success_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.btnOkay)).setText(getResources().getString(R.string.okay));

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        alertDialog.show();

    }

    private void showWarningDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlertDialog.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(CustomAlertDialog.this).inflate(
                R.layout.warning_custom_dialog,
                (RelativeLayout) findViewById(R.id.dialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.title)).setText(getResources().getString(R.string.warning_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.btnYes)).setText(getResources().getString(R.string.yes));
        ((Button) view.findViewById(R.id.btnNo)).setText(getResources().getString(R.string.no));

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.btnYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(CustomAlertDialog.this, "YES", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.btnNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(CustomAlertDialog.this, "NO", Toast.LENGTH_SHORT).show();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        alertDialog.show();
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomAlertDialog.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(CustomAlertDialog.this).inflate(
                R.layout.error_custom_dialog,
                (RelativeLayout) findViewById(R.id.dialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.title)).setText(getResources().getString(R.string.error_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((Button) view.findViewById(R.id.btnOkay)).setText(getResources().getString(R.string.okay));

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        alertDialog.show();

    }

    private void showRegularDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(CustomAlertDialog.this, R.style.AlertDialogTheme);
        builder1.setCancelable(true);
        builder1.setTitle("Sign In");
        builder1.setMessage("Please sign in to create or update progress of your task. \n");

        builder1.setPositiveButton("Sign In",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton("Not Now",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

        Button btnSignIn = alert11.getButton(DialogInterface.BUTTON_POSITIVE);
        btnSignIn.setTextColor(getResources().getColor(R.color.white));
        btnSignIn.setTypeface(Typeface.DEFAULT, Typeface.BOLD );
        btnSignIn.setPadding(50, 0, 50, 0);
        btnSignIn.setBackground(getResources().getDrawable(R.drawable.butoon_follow_background, null));
        btnSignIn.setGravity(Gravity.CENTER);
        btnSignIn.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWarning)));
        btnSignIn.setAllCaps(false);

        Button btnNotNow = alert11.getButton(DialogInterface.BUTTON_NEGATIVE);
        btnNotNow.setTextColor(getResources().getColor(R.color.colorWarning));
//        btnNotNow.setBackground(getResources().getDrawable(R.drawable.login6_btn_create_account, null));
        btnNotNow.setTypeface(Typeface.DEFAULT, Typeface.BOLD );
        btnNotNow.setPadding(50, 0, 50, 0);
        btnNotNow.setAllCaps(false);

    }
}
