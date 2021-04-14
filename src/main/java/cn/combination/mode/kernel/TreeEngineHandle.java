package cn.combination.mode.kernel;

import cn.combination.mode.aggregates.TreeRich;
import cn.combination.mode.vo.EngineResult;
import cn.combination.mode.vo.TreeNode;

import java.util.Map;

public class TreeEngineHandle extends EngineBase{
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        //决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich,treeId,userId,decisionMatter);

        //返回决策结果VO
        return new EngineResult(userId,treeId,treeNode.getTreeNodeId(),treeNode.getNodeValue());
    }
}
