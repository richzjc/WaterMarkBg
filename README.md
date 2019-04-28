# 给背景添加水印的效果

## 首先看看效果图

![](/pic/device-2019-04-28-085926.png)

## 在项目的build目录下面添加
    implementation 'com.richzjc:waterMark:1.0.0' 
    并且在项目的根目录的build.gralde文件中的allProjects节点添加如下代码：
    maven { url 'https://dl.bintray.com/richzjc/maven' }

## 具体的使用
    findViewById(R.id.bg).setBackground(new WaterMarkBg(this, -30, R.mipmap.app_logo_black));
    
> 参数详解
>> 第一个参数是context 

>> 第二个参数是旋转的角度 

>> 第三个参数，水印的图片

## 实现思路

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