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