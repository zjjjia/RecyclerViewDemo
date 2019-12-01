package com.example.recyclerviewdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDecorationSimple extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    public ItemDecorationSimple() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    public void getItemOffsets(@NonNull Rect onRect, @NonNull View view, @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        super.getItemOffsets(onRect, view, parent, state);

        onRect.set(50, 50, 50, 50);
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);

            int left = view.getLeft();
            int top = view.getBottom();

            int right = view.getRight();

            c.drawRect(left, top, right, top + 5, mPaint);
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        for(int i = 0; i < parent.getChildCount(); i++){
            View view = parent.getChildAt(i);
            int x = view.getRight();
            int y = view.getTop();

            c.drawCircle(x, y, 20, mPaint);
        }
    }
}
