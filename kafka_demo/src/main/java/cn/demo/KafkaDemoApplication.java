package cn.demo;

import cn.demo.service.ProduceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


// TODO 1. 进行剔除SpringBoot集成Kakfa 本身的config;(防止自动配置使用)
@SpringBootApplication(exclude = {KafkaAutoConfiguration.class})
public class KafkaDemoApplication implements CommandLineRunner{
	@Resource
	private ProduceService produceService;
	private final static String topicName="test";


	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		String jsondata = "{\"subjectId\":\"SKECHERS会员\",\"distinct\":true,\"skip\":0,\"take\":50,\"sortVOList\":[],\"select\":[{\"id\":\"model@plt_skx_member.vipcode\",\"attributeType\":\"normal\",\"alias\":\"会员卡号\"},{\"id\":\"model@plt_skx_member.customer_name\",\"attributeType\":\"normal\",\"alias\":\"姓名\"},{\"id\":\"model@plt_skx_member.nick_name\",\"attributeType\":\"normal\",\"alias\":\"淘宝nick_name\"},{\"id\":\"model@plt_skx_member.mobilephone\",\"attributeType\":\"normal\",\"alias\":\"手机号\"},{\"id\":\"model@plt_skx_member.email\",\"attributeType\":\"normal\",\"alias\":\"邮箱\"},{\"id\":\"model@func_skx_gender\",\"attributeType\":\"function\",\"alias\":\"性别\"},{\"id\":\"model@fun_skx_member.birthday\",\"attributeType\":\"function\",\"alias\":\"生日\"},{\"id\":\"model@plt_skx_member.province\",\"attributeType\":\"normal\",\"alias\":\"省份\"},{\"id\":\"model@plt_skx_member.city\",\"attributeType\":\"normal\",\"alias\":\"城市\"},{\"id\":\"model@plt_skx_member.reg_type\",\"attributeType\":\"normal\",\"alias\":\"注册渠道\"},{\"id\":\"model@fun_skx_member.reg_store_name\",\"attributeType\":\"function\",\"alias\":\"注册门店\"},{\"id\":\"model@fun_skx_member.reg_time\",\"attributeType\":\"function\",\"alias\":\"注册时间\"},{\"id\":\"model@tb_member_grade_point_1.point\",\"attributeType\":\"normal\",\"alias\":\"积分\"},{\"id\":\"model@tb_member_grade_point_1.grade_name\",\"attributeType\":\"normal\",\"alias\":\"等级\"},{\"id\":\"model@tb_member_grade_point_1.card_plan_id\",\"attributeType\":\"normal\",\"alias\":\"lp3CardPlanId\"},{\"id\":\"model@plt_skx_member.member_id\",\"attributeType\":\"normal\",\"alias\":\"_ID\"}],\"wheres\":[],\"concat\":[],\"except\":[],\"intersect\":[],\"union\":[],\"staticSQL\":[],\"joinMode\":\"inner\"}";
		produceService.Send(topicName, UUID.randomUUID().toString(),jsondata);



	}
}
