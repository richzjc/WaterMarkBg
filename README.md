# 给背景添加水印的效果

## 首先看看效果图

![](/pic/device-2019-04-28-085926.png)

## 在项目的build目录下面添加
    implementation 'com.richzjc:waterMark:1.0.0'

## 具体的使用
    findViewById(R.id.bg).setBackground(new WaterMarkBg(this, -30, R.mipmap.app_logo_black));