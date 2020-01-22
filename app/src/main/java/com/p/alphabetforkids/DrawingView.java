package com.p.alphabetforkids;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;



import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DrawingView extends View {
    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private int paintColor = 0xFF660000;
    private Canvas drawcanvas;
    private Bitmap canvasBitmap;
    private  float brushSize,lastBrushSize;
    private boolean erase = false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupDrawing() {
        brushSize = getResources().getInteger(R.integer.medium_size);
        lastBrushSize = brushSize;
        drawPath = (Path) new android.graphics.Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(brushSize);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        drawcanvas = new Canvas(canvasBitmap);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);
        canvas.drawPath((android.graphics.Path) drawPath,drawPaint);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       float touchX = event.getX();
       float touchY = event.getY();
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               drawPath.moveTo(touchX,touchY);
               break;
               case MotionEvent.ACTION_MOVE:
                   drawPath.lineTo(touchX,touchY);
                   break;
                   case MotionEvent.ACTION_UP:
                       drawcanvas.drawPath(drawPath,drawPaint);
                       drawPath.reset();
                       break;
                       default:
                           return false;

       }
       invalidate();
       return true;

    }
    public void setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);

    }
    public void setBrushSize(float newSize){
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,newSize,getResources().getDisplayMetrics());
        brushSize = pixelAmount;
        drawPaint.setStrokeWidth(brushSize);



    }
    public void setLastBrushSize(float lastSize){
        lastBrushSize = lastSize;
    }
    public float getLastBrushSize(){
        return lastBrushSize;
    }
    public void setErase(boolean isErase){
        erase = isErase;
        if (erase)
            drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else
            drawPaint.setXfermode(null);
    }

    public void startnew(){
        drawcanvas.drawColor(0,PorterDuff.Mode.CLEAR);
        invalidate();
    }
}
