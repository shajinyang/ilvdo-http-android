# 安卓网络请求库

### 介绍

基于 Okhttp+retrofit 进行封装,减少,模板代码的使用,简洁的链式调用方式,使用更灵活.

- 简洁的链式调用
- 支持自定义添加公共参数,headers等
- 支持自定义拦截器
- 支持键值对参数
- 支持java对象参数(当参数为java对象时,网络库默认自动将java对象解析为键值对)
- 支持json参数(json支持直接请求json格式的参数,或者java对象,当请求参数为java对象时,网络库会自动将对象转成json数据)
- 文件上传,下载
- 支持异步同步请求
- 底层库基于Okhttp 和 retrofit

### 如何使用

第一步：在项目的gradle里配置

```
      allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
      }
```

第二步：在module的gradle里配置
```
     dependencies {
         implementation 'com.github.shajinyang:akita:1.2.1'
     }
```
















