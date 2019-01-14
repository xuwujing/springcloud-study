## springcloud-eureka

### 介绍

> Eureka是Netflix开源的一款提供服务注册和发现的产品，它提供了完整的Service Registry和Service Discovery实现。也是springcloud体系中最重要最核心的组件之一。


### 使用


先运行 springboot-eureka-server 项目，启动成功之后在浏览器输入 `http://localhost:8000/` 即可查看springcloud界面。然后在启动springboot-eureka-client 项目，刷新界面，在` Instances currently registered with Eureka` 查看该服务信息。


### 高可用注册中心使用

在当前的系统的host文件中添加如下配置:
	
	127.0.0.1     server2
	127.0.0.1     server3


**hosts文件地址:**

 Windows 系统地址:`C:\Windows\System32\drivers\etc\hosts`

 Linux系统地址: `/etc/hosts`


配置完成之后，启动`springboot-eureka-server2`和`springboot-eureka-server3`这两个服务，然后在浏览器输入: 
`http://server2:8002/` 
或
`http://server3:8003/` 
即可查看信息.

