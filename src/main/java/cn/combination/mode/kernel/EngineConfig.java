package cn.combination.mode.kernel;

import cn.combination.mode.Cache.LogicFilter;
import cn.combination.mode.materiel.UserAgeFilter;
import cn.combination.mode.materiel.UserGenderFilter;

import java.util.Map;

//决策节点配置
public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap.put("userAge",new UserAgeFilter());
        logicFilterMap.put("userAge",new UserGenderFilter());
    }

    public Map<String,LogicFilter> getLogicFilterMap(){
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap){
        this.logicFilterMap = logicFilterMap;
    }






}
