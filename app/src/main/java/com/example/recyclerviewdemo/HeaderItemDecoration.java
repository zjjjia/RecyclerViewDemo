package com.example.recyclerviewdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private Paint mPaint2;

    public HeaderItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);

        if (position % 5 == 0) {
            outRect.set(0, 50, 0, 0);
        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        //getChildCount()得到的是这个屏幕里有多少个子view，不是总的子view
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);


            if (position % 5 == 0) {
                int item = position / 5;

                int left = 0;
                int top = 0;
                int right = 0;
                int bottom = 0;
                if (i < 5) {
                    if (i == 1 && view.getTop() < 100) {
                        left = 0;
                        right = view.getTop() - 100;
                        top = 0;
                        bottom = view.getTop() - 50;

                        c.drawRect(left, top, right, bottom, mPaint);
                        c.drawText("这里是第" + item + "个item的头部", (left + right) / 2,
                                top + 25, mPaint2);

                    } else {
                        left = 0;
                        top = 0;
                        right = view.getRight();
                        bottom = 50;
                        c.drawRect(left, top, right, bottom, mPaint);
                        c.drawText("这里是第" + item + "个item的头部", (left + right) / 2,
                                top + 25, mPaint2);
                    }
                }
                if (i != 0) {
                    left = 0;
                    top = view.getTop() - 50;
                    right = view.getRight();
                    bottom = view.getTop();
                    c.drawRect(left, top, right, bottom, mPaint);
                }
                c.drawText("这里是第" + item + "个item的头部", (left + right) / 2,
                        top + 25, mPaint2);

            }
        }
    }
}
