# 安卓网络请求库

### 介绍

基于 Okhttp+retrofit 进行封装,减少,模板代码的使用,简洁的链式调用方式,使用更灵活.

- 简洁的链式调用
- 支持自定义添加公共参数,headers等
- 支持自定义拦截器
- 支持多种常用参数上传支持
- 文件上传,下载
- 支持异步同步
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
















