## springcloud-feign

### 介绍

> Feign是一个声明式Web Service客户端。使用Feign能让编写Web Service客户端更加简单, 它的使用方法是定义一个接口，然后在上面添加注解，同时也支持JAX-RS标准的注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。


### 使用


依次运行 springcloud-feign-eureka、springcloud-feign-consumer和springcloud-feign-consumer2项目。启动成功之后，在浏览器输入 `http://localhost:8001/` 进行查看相关信息！


**服务调用测试**


启动成功之后在浏览器先输入：
> http://localhost:9003/hello?name=pancm 

查询是否能够成功启动,
然后再输入:
> http://localhost:9002/hello/pancm 

返回结果:

    pancm,Hello World
    pancm,Hello World


出现以上结果说明客户端已经成功的通过feign调用了远程服务hello，并且将结果返回到了浏览器。


