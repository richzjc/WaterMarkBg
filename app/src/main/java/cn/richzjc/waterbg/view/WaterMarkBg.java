package cn.richzjc.waterbg.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

/**
 * Created by fulushan on 18/4/5.
 */

public class WaterMarkBg extends Drawable {

    private Paint paint = new Paint();
    private Context context;
    private int degress;//角度
    private int drawableId;

    public WaterMarkBg(Context context, int degress, int drawableId) {
        this.context = context;
        this.degress = degress;
        this.drawableId = drawableId;
    }

    @Override
    public void draw(Canvas canvas) {
        int width = getBounds().right;
        int height = getBounds().bottom;

        canvas.drawColor(Color.TRANSPARENT);
        canvas.save();
        Drawable drawable = context.getResources().getDrawable(drawableId);
        BitmapDrawable bd = (BitmapDrawable) drawable;
        if (bd == null) return;
        Bitmap bitmap = bd.getBitmap();
        if (bitmap == null) return;
        bitmap = rotate(bitmap, degress);
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        int index = 0;
        for (int positionY = -(h / 3); positionY <= height; positionY += h + 80) {
            float fromX = -w + (index++ % 2) * w;
            for (float positionX = fromX; positionX < width; positionX += w * 1.5) {
                canvas.drawBitmap(bitmap, positionX, positionY, paint);
            }
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    private static Bitmap rotate(Bitmap b, int degrees) {
        if (degrees == 0) {
            return b;
        }
        if (degrees != 0 && b != null) {
            Matrix m = new Matrix();
            m.setRotate(degrees, (float) b.getWidth(), (float) b.getHeight());
            try {
                Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true);
                if (b != b2) {
                    b.recycle();
                    b = b2;
                }
            } catch (OutOfMemoryError ex) {
            }
        }
        return b;
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
