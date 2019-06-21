# Xfermode图层混合

* 图层混合几种模式

 <image src="https://user-gold-cdn.xitu.io/2019/6/21/16b7a5826e78d0ea?w=380&h=470&f=png&s=196265"/>
 
   - 根据图片可以看出共有16中模式
      
     #### 1.PorterDuff.Mode.CLEAR
     所绘制不会提交到画布上 
     #### 2.PorterDuff.Mode.SRC
     显示上层绘制图片
     #### 3.ProterDuff.Mode.DST
     显示下层绘制图片
     #### 4.PorterDuff.Mode.SRC_OVER
     正常绘制显示，上下层绘制叠盖
     #### 5.PorterDuff.Mode.DST_OVER
     上下层都显示。下层居上显示
     #### 6.PorterDuff.Mode.SRC_IN
     取两层绘制交集。显示上层。
     #### 7.PorterDuff.Mode.DST_IN
     取两层绘制交集。显示下层。
     #### 8.PorterDuff.Mode.SRC_OUT
     取上层绘制非交集部分
     #### 9.PorterDuff.Mode.DST_OUT
     取下层绘制非交集部分
     #### 10.PorterDuff.Mode.SRC_ATOP
     取下层非交集部分与上层交集部分
     #### 11.PorterDuff.Mode.DST_ATOP
     取上层非交集部分与下层交集部分
     #### 12.PorterDuff.Mode.XOR
     异或：去除两图层交集部分
     #### 13.PorterDuff.Mode.DARKEN
     取两图层全部区域，交集部分颜色加深
     #### 14.PorterDuff.Mode.LIGHTEN
     取两图层全部，点亮交集部分颜色
     #### 15.PorterDuff.Mode.MULTIPLY
     取两图层交集部分叠加后颜色
     #### 16.PorterDuff.Mode.SCREEN
     取两图层全部区域，交集部分变为透明色

* 根据图层混合模式实现圆角图片
  ```
  private Bitmap getRoundBitMap(Bitmap bitmap) {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        mPaint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        mPaint.setColor(0xff000000);
        canvas.drawRoundRect(new RectF(rect), 20, 20, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, mPaint);
        mPaint.setXfermode(null);
        return bitmap1;
    }
  ```
 
  ## 感谢
  感谢大家的阅读 点个赞呗  
  关注我 持续更新
  ### [Github](https://github.com/hunimeizi?tab=repositories)