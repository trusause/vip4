package com.trusause.dubbodemoprovider.service;

import com.trusause.dubbodemointerface.DemoService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @Author weicl
 * @Date 2022/7/7 下午3:51
 * @Version 1.0
 * @Description
 */
@Service(interfaceClass = DemoService.class)
public class DefaultDemoService implements DemoService {

//    private final Map<String, DemoServiceListener> listeners = new ConcurrentHashMap<>();

    @Override
    public String sayHello(String name) {
        System.out.println("执行了");
        URL url = RpcContext.getContext().getUrl();
        return String.format("s%: s%，Hello，s%", url.getProtocol(), url.getPort(), name);
    }

}
