package com.example.madhu.inradius;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
RatingBar ratingBar1,ratingBar2,ratingBar3;
    Dialog feedbackDialog;
    Integer userRatingValue1=5;
    Integer userRatingValue2=3;
    Integer userRatingValue3=4;
    Button cancel,cancel2,done,submit;
    LinearLayout rate,review;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rankBtn = (Button) findViewById(R.id.add_review);

        rankBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                rankDialog = new Dialog(MainActivity.this, R.style.FullHeightDialog);
                feedbackDialog = new Dialog(MainActivity.this);
                feedbackDialog.setContentView(R.layout.activity_review_page);

                feedbackDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ratingBar1 = (RatingBar)feedbackDialog.findViewById(R.id.ratingbar1);
                ratingBar1.setRating(userRatingValue1);

                ratingBar2 = (RatingBar)feedbackDialog.findViewById(R.id.ratingbar2);
                ratingBar2.setRating(userRatingValue2);

                ratingBar3 = (RatingBar)feedbackDialog.findViewById(R.id.ratingbar3);
                ratingBar3.setRating(userRatingValue3);

                cancel = (Button)feedbackDialog.findViewById(R.id.cancel);
                cancel2 = (Button)feedbackDialog.findViewById(R.id.cancel2);
                done=(Button)feedbackDialog.findViewById(R.id.done);
                rate=(LinearLayout)feedbackDialog.findViewById(R.id.rate);
                review=(LinearLayout)feedbackDialog.findViewById(R.id.review);

                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        rate.setVisibility(View.GONE);
//                        rate.animate().alpha(1.0f);
//                        review.animate().alpha(1.0f).setDuration(2000);
                        review.setVisibility(View.VISIBLE);

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        feedbackDialog.dismiss();
                    }
                });
                cancel2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        feedbackDialog.dismiss();
                    }
                });
                //now that the dialog is set up, it's time to show it
                feedbackDialog.show();
            }
        });
    }
}
