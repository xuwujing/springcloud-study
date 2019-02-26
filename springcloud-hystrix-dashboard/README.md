## springcloud-hystrix-dashboard

### 介绍

> Hystrix-dashboard是一款针对Hystrix进行实时监控的工具，通过Hystrix Dashboard我们可以在直观地看到各Hystrix Command的请求响应时间, 请求成功率等数据。Turbine服务，专门监控所有断路器状态，从而掌握整个系统中所有微服务的状态。


### 使用

依次运行springcloud-hystrix-dashboard-eureka和springcloud-hystrix-dashboard-consumer项目。启动成功之后，在浏览器输入 `http://localhost:9010/hystrix` ，然后在界面中的输入框中输入:`http://localhost:9010/hystrix.stream`，即可查看hystrix界面的信息，如果提示loading，那么在浏览器中输入:`http://localhost:9010/hello/pancm`进行访问，然后再刷新该界面即可查看信息！



