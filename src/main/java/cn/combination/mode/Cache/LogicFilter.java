package cn.combination.mode.Cache;

import cn.combination.mode.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

// 树节点逻辑过滤器接口
public interface LogicFilter {

    /**
     * 逻辑决策器
     * @param matterValue           决策值
     * @param treeNodeLinkInfoList  决策节点
     * @return                      下一个节点id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkInfoList);


    /**
     * 获取决策值
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料
     * @return
     */
    String matterValue(Long treeId, String userId, Map<String,String>
            decisionMatter);


}
