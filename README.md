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

### 如何配置网络库

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
         implementation 'com.github.shajinyang:ilvdo-http-android:1.0.8'
     }
```

### 如何使用

#### 初始化，推荐在application里进行初始化

快速初始化
```
IlvdoHttp.init(this)
            .withApiHost("https://api.apiopen.top/") //网络请求主域名
            .config()
```

初始化额外配置（可选）
```
IlvdoHttp.init(this)
            .withApiHost("https://api.apiopen.top/") //网络请求主域名
            .logEnable(true) //是否开启日志打印，默认关闭
            .withIntercept(intercept1)// 配置okhttp拦截器，可添加多个
            .withNetIntercept(intercept2)//配置okhttp拦截器，可添加多个
            .config()
```

#### 网络请求

快速发起一个get请求示例（java）
```
 RestClient
                .builder()
                .type(RestType.GET)
                .params("page", "1")
                .params("count", "5")
                .url("")
                .convertType(new TypeReference<CommonBean<List<ResponseBean>>>(){})
                .success(new IOnSuccess<CommonBean<List<ResponseBean>>>() {
                    @Override
                    public void onSuccess(CommonBean<List<ResponseBean>> responseBean) {
                        // todo  成功
                    }
                })
                .build();
```


详细使用方法api（kotlin）

网络请求（键值对传参）

```
RestClient
            .builder()
            .type(RestType.GET) //请求方式，可切换 get  post   json 等等
            .params("page","1") //键值对传参
            .params("count","5") //键值对传参
            .url("test/test/") //接口路径
            .convertType(object : TypeReference<CommonBean<List<ResponseBean>>>() {}) //接受的实体类
            .start(object :IOnStart{
                override fun onStart() {
                   // todo   请求开始前的逻辑处理
                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    // todo  成功
                }
            })

            .failure(object : IOnFailure {
                override fun onFailure(throwable: Throwable) {
                    // todo 失败
                }
            })
            .end(object : IOnEnd {
                override fun onEnd() {
                    // todo 结束
                }
            })
            .getDisposable(object :IGetDisposable{
                override fun getDisposable(disposable: Disposable) {
                    // 返回  该请求的 disposable 对象，可取消
                }
            })
            .build()
```

网络请求（对象传参）
可以直接传递对象请求参数，网络库会将对象转为键值对

```
RestClient
            .builder()
            .type(RestType.GET) //请求方式，可切换 get  post  json 等等
            .objParam(requestBean) //对象传参
            .url("test/test/") //接口路径
            .convertType(object : TypeReference<CommonBean<List<ResponseBean>>>() {}) //接受的实体类
            .start(object :IOnStart{
                override fun onStart() {
                   // todo   请求开始前的逻辑处理
                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    // todo  成功
                }
            })

            .failure(object : IOnFailure {
                override fun onFailure(throwable: Throwable) {
                    // todo 失败
                }
            })
            .end(object : IOnEnd {
                override fun onEnd() {
                    // todo 结束
                }
            })
            .getDisposable(object :IGetDisposable{
                override fun getDisposable(disposable: Disposable) {
                    // 返回  该请求的 disposable 对象，可取消
                }
            })
            .build()
```

网络请求（Json传参）

```
RestClient
            .builder()
            .type(RestType.JSON) //请求方式，可切换 get  post  json 等等
            .objParam(requestBean) //对象传参
            .url("test/test/") //接口路径
            .convertType(object : TypeReference<CommonBean<List<ResponseBean>>>() {}) //接受的实体类
            .start(object :IOnStart{
                override fun onStart() {
                   // todo   请求开始前的逻辑处理
                }
            })
            .success(object :IOnSuccess<ResponseBean>{
                override fun onSuccess(t: ResponseBean) {
                    // todo  成功
                }
            })

            .failure(object : IOnFailure {
                override fun onFailure(throwable: Throwable) {
                    // todo 失败
                }
            })
            .end(object : IOnEnd {
                override fun onEnd() {
                    // todo 结束
                }
            })
            .getDisposable(object :IGetDisposable{
                override fun getDisposable(disposable: Disposable) {
                    // 返回  该请求的 disposable 对象，可取消
                }
            })
            .build()
```

文件上传(kotlin)
```
RestClient
            .builder()
            .type(RestType.FILE)
            .file(File(Environment.getExternalStorageDirectory().absolutePath+"/letter.svg"))
            .file(File(Environment.getExternalStorageDirectory().absolutePath+"/bigger.svg"))
            .url("http://test.com/api/upload")
            .convertType(object : TypeReference<CommonBean<String>>() {

            })
            .success { _ ->

            }
            .build()

```



















