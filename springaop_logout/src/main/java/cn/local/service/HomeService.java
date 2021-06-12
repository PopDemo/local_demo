package cn.local.service;

import cn.local.support.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HomeService {

    @LogAspect
    public void userQueryHomeInfo() {
        log.info("查询homeId为：{},相关的info为Null","111");
    }

}
