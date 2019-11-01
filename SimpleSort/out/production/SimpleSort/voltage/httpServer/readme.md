###第一章Web分布式应用框架
#### 1.1 Web的概念
- web运作过程：浏览器采用HTTP协议与Web服务器通信，就能访问到Web服务器上的各种信息。
- web服务器存放的东西：（html文档、图片文件、声音文件、视频文件） -->  超文本技术（超级链接）连接起来。
- web特征：
    1. 表达信息：超文本技术html
    2. 定位到网络信息：统一资源定位技术URL
    3. 浏览器与Web服务器之间的通信规范：网络应用层协议HTTP
#### 1.2 HTML简介（略）
#### 1.3 URL简介
统一资源定位器（uniform resource locator）：
    应用层协议://主机IP地址或域名/资源所在路径/文件名
统一资源标识符（uniform resource identifier）   
   /资源所在路径/文件名
#### 1.4 HTTP协议简介
不同的HTTP客户程序和HTTP服务器能够通信的原理：遵循HTTP协议
- HTTP客户程序：IE、Firefox、Opera、Netscape
- HTTP服务器：IIS、Apache
#####1.4.1 HTTP请求格式
- 请求方法、URI、HTTP协议的版本
POST /hello.jsp HTTP/1.1
- 请求头
```java
Accept:image/gif,image/jpeg,*/*
Referer:http://localhost/login.htm
Content-Type:en,zh-cn;q=0.5
Accept-Encoding:application/x-www-form-urlencoded
Host:localhost
Connection:Keep-Alive
Cache-Control:no-cache
```
- 请求正文
请求头和请求正文之间必须以空行分隔
#####1.4.2 HTTP响应格式
- HTTP协议的版本、状态代码、描述
HTTP/1.1 200 OK
```java
3xx:重定向
4xx:客户端问题
5xx:服务端问题

400:错误请求
404：文件不存在
405：服务器不支持客户的请求方式
500：服务器内部（代码有误）
```
- 响应头
```java
服务器类型、正文类型、正文长度
Server:Apache-Coyote/1.1
Content-Type:text/html;charset=GBK
Content-length:102
```
- 响应正文
#####1.4.3 正文部分的MIME类型
- HTTP协议采用MIME协议：规范（请求正文、响应正文）的数据格式
- 请求头、响应头content-type：指定（请求正文、响应正文）的MIME类型
```java
EncType表明提交数据的格式
MIME类型
application/x-www-form-urlencoded： 窗体数据被编码为名称/值对。这是标准的编码格式。 
multipart/form-data： 窗体数据被编码为一条消息，页上的每个控件对应消息中的一个部分，这个一般文件上传时用。 
text/plain： 窗体数据以纯文本形式进行编码，其中不含任何控件或格式字符                
```
#####1.4.4 cmd手动编译Java文件
1. HTTPClient客户程序访问HTTPServer程序
- 编译Java文件为类class文件
```java
cd 进入到你的java项目下
//javac 源文件的相对路径 -d class文件存放的相对路径
javac src/voltage/httpServer/HTTPServer.java -d out/production/SimpleSort
//资源文件：HTTPServer.class文件相对路径/resource/hello.htm --> out/production/SimpleSort/resource/hello.htm
```
- 运行类文件
```java
//打开一个cmd 开启http服务器
cd out/production/SimpleSort
java voltage.httpServer.HTTPServer
//打开第二个cmd 开启http客户程序
cd out/production/SimpleSort
java voltage.httpServer.HTTPClient hello.htm
```
2. 浏览器访问HTTPServer程序
```java
http://localhost:8080/hello.htm
```
3. HTTPClient客户程序访问Tomcat服务器
```java
//Tomcat主页
java voltage.httpClient /
或者
java voltage.httpClient /index.jsp
```
4. 浏览器访问Tomcat服务器
```java
//Tomcat主页
http://localhost:8080/index.jsp
``` 
###第二章Tomcat简介
###2.1Tomcat作为Servlet容器的基本功能
####Servlet的用途:
- 扩展Web服务器的功能
- 非常安全的、可移植的、易于使用的CGI替代品
####Servlet的特点：
- 提供可被服务器动态加载并执行的程序代码
- Servlet完全用java语言编写，要求运行Servlet服务器必须支持java语言
- Servlet完全在服务器端运行，因此它的运行不依赖浏览器
###2.2Tomcat的组成结构
- 核心组件：Servlet容器组件，也是其他Tomcat组件的顶层容器
> Tips:Tomcat组成结构是由自身的实现决定的，与Servlet规范无关，不同的服务器开发商可以用不同的实现方式实现符合Servlet规范的Servlet容器。
```xml
<Server port="8005" shutdown="SHUTDOWN">
  <Service name="Catalina">
    <Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
    <Engine name="Catalina" defaultHost="localhost" jvmRoute="jvm1">
        <Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true">
            <Context></Context>
        </Host>
    </Engine>
  </Service>
</Server>
```
###2.3Tomcat的工作模式
1. 独立的Servlet容器（tomcat默认的工作模式）
- Tomcat作为独立Web服务器运行，Servlet容器组件作为Web服务器中的一部分
2. 其他Web服务器进程内的Servlet容器
- Tomcat分为Web服务器插件和Servlet容器组件
3. 其他Web服务器进程外的Servlet容器
- Tomcat分为Web服务器插件和Servlet容器组件
###2.4安装、启动、关闭Tomcat
1. 下载相应版本的tomcat压缩包，但是注意tomcat的版本和jdk版本（需要补充)，解压
2. 配置tomcat的环境变量，与配置jdk的环境变量原理一样
3. 启动命令：catalina startup
4. 关闭命令：catalina shutdown
5.检验开启是否成功：localhost:8080/index.jsp
  