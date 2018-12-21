## springcloud-hystrix

### 介绍

> Netflix创建了一个名为Hystrix的库，它实现了断路器模式。主要的目的是为了解决服务雪崩效应的一个组件，是保护服务高可用的最后一道防线。


### 使用


依次运行 springcloud-eureka-hystrix、springcloud-hystrix-consumer和springcloud-hystrix-consumer2项目。启动成功之后，在浏览器输入 `http://localhost:8002/` 进行查看相关信息！


**断路器测试**

启动成功之后在浏览器输入:
>  http://localhost:9004/hello/pancm

然后再输入:

>  http://localhost:9005/hello/pancm?name=pancm

查看是否正常！
然后再停止运行 springcloud-hystrix-consumer2项目！

在浏览器输入:
>  http://localhost:9004/hello/pancm

进行查看返回信息，最后在启动springcloud-hystrix-consumer2项目！然后再次在浏览器输入 `http://localhost:9004/hello/pancm `
，查看信息。

    pancm,Hello World
    pancm,Hello World
    pancm, 请求另一个服务失败!
    pancm,Hello World


若出现以上结果，则表示断路器已成功生效！

