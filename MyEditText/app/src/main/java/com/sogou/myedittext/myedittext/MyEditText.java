package com.sogou.myedittext.myedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

/**
 * Created by lianghenghui on 2016/5/13.
 */
public class MyEditText extends EditText {
    private int line_color;
    private int line_height;

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        this(context,attrs,R.attr.editTextStyle);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,R.styleable.edittext_bg,defStyleAttr,0);
        int n = typedArray.getIndexCount();
        for (int i = 0;i < n;i++){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.edittext_bg_line_color:
                    line_color = typedArray.getColor(attr,Color.GREEN);
                    break;
                case R.styleable.edittext_bg_line_height:
                    line_height = typedArray.getDimensionPixelSize(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,1,getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(line_color);
        paint.setStrokeWidth(line_height);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0,this.getHeight()-1,this.getWidth(),this.getHeight()-1,paint);
    }
}
