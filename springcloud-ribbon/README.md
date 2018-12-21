## springcloud-ribbon

### 介绍

> Ribbon是一个客户端负载均衡器，它提供了对HTTP和TCP客户端的行为的大量控制。Feign已经使用了Ribbon，所以使用Feign，那么也可以使用这个功能。


### 使用


依次运行 springcloud-ribbon-eureka、springcloud-ribbon-consumer、springcloud-ribbon-consumer2和springcloud-ribbon-consumer3 这几个项目。启动成功之后，在浏览器输入 `http://localhost:8003/` 进行查看相关信息！


**负载均衡测试**

启动成功之后在浏览器输入:
>  http://localhost:9006//hello/pancm

然后重复进行访问，若出现的结果交叉打印则表示已成功实现负载均衡功能。

    pancm,Hello World!
    pancm,Hello World! 这是另一个服务！
    pancm,Hello World!
    pancm,Hello World! 这是另一个服务！
    pancm,Hello World!
    pancm,Hello World! 这是另一个服务！


