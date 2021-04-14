package cn.combination.mode.Cache;

import cn.combination.mode.Cache.LogicFilter;
import cn.combination.mode.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 1. 定义决策基础规则
 * 2. 对比决策
 */
public abstract class BaseLogin implements LogicFilter {
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkInfoList) {
        //循环 对比 传入属性与决策树内定义的属性
        for(TreeNodeLink nodeLine: treeNodeLinkInfoList){
            if (decisionLogic(matterValue, nodeLine)) return nodeLine.getNodeIdTo();
        }

        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    //查看树逻辑是否正常
    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink){
        //nodeLink.getRuleLimitType: 指定对比规则id     >、<、<=、>=、=
        switch (nodeLink.getRuleLimitType()){
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) <
                        Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) <=
                        Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) >=
                        Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }




    }
}
