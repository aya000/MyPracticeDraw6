package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

import static android.os.Build.VERSION.SDK_INT;
import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

public class Practice01Translation extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    int translationState = 0;
    int translationCount = SDK_INT > Build.VERSION_CODES.LOLLIPOP ? 4 : 3;

    public Practice01Translation(Context context) {
        super(context);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01Translation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
//        if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            // 给音乐图标加上合适的阴影
//            imageView.setOutlineProvider(new MusicOutlineProvider());
//        }

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().translationX/Y/Z() 来让 View 平移
                /**
                 * 其中带有 -By() 后缀的是增量版本的方法，
                 * 例如，translationX(100) 表示用动画把 View 的 translationX 值渐变为 100，
                 * 而  translationXBy(100) 则表示用动画把 View 的 translationX 值渐变地增加 100。
                 * */
                switch (translationState) {
                    case 0:
                        imageView.animate().translationXBy(dpToPixel(100));
                        break;
                    case 1:
                        imageView.animate().translationXBy(-dpToPixel(100));
                        break;
                    case 2:
                        imageView.animate().translationYBy(dpToPixel(50));
                        break;
                    case 3:
                        imageView.animate().translationYBy(-dpToPixel(50));
                        break;

                }
                translationState++;
                if (translationState == translationCount) {
                    translationState = 0;
                }

            }
        });
    }

    /**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }
}