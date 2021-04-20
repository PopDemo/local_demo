package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.MemberBind;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
//@SpringBootTest
class ApplicationTests {


	private final static String JD ="jd";


	// stream流操作
	@Test
	void contextLoads() {

		List<MemberBind> memberInfoList = new ArrayList<>();


		List<MemberBind> jdbindingList = memberInfoList.stream().filter(s ->(s.getPlatCode().equals(JD))).sorted().collect(Collectors.toList());
		if (jdbindingList.size() == 1){
			return;
		}
		log.info("绑定信息排序后的数据:{}", JSONObject.toJSONString(jdbindingList));

		// first去对一个
		MemberBind unbind = jdbindingList.stream().filter(s -> (!s.getStatus())).sorted().findFirst().orElse(null);

		List<MemberBind> needDelBindingList = new ArrayList<>();
		if(null != unbind){
			int unbindIndex = jdbindingList.indexOf(unbind);
			for (int i = 0; i < jdbindingList.size(); i++) {
				if (i==(unbindIndex-1) || i==(unbindIndex) || i==(unbindIndex+1)){
					continue;
				}
				needDelBindingList.add(jdbindingList.get(i));
			}
		}else{
			needDelBindingList.addAll(jdbindingList.subList(1,jdbindingList.size()));
		}

		jdbindingList.removeAll(needDelBindingList);

		log.info("绑定信息<需要删除>的数据:{}", JSONObject.toJSONString(needDelBindingList));
		log.info("绑定信息<进行保留>的数据:{}", JSONObject.toJSONString(jdbindingList));
	}

}
