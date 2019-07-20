package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice04Alpha extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    int alphaState = 0;
    int alphaCount = 3;

    public Practice04Alpha(Context context) {
        super(context);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04Alpha(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
                switch (alphaState) {
                    case 0:
                        imageView.animate().alpha(0.5f);
                        break;
                    case 1:
                        imageView.animate().alpha(0.8f);
                        break;

                    case 2:
                        imageView.animate().alpha(0);//变没
                        break;

                    case 3:
                        imageView.animate().alpha(1);//出现
                        break;
                }

                alphaState++;
                if (alphaState == alphaCount) {
                    alphaState = 0;
                }


            }
        });
    }
}