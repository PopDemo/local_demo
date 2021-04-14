package cn.combination.mode.kernel;

import cn.combination.mode.Cache.LogicFilter;
import cn.combination.mode.aggregates.TreeRich;
import cn.combination.mode.vo.EngineResult;
import cn.combination.mode.vo.TreeNode;
import cn.combination.mode.vo.TreeRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


// 决策 引擎
public abstract class EngineBase extends EngineConfig implements IEngine{
    Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String,
            String> decisionMatter);


    /**
     * 最重要的是抽象决策树中的对比 规则
     * @param treeRich    决策树
     * @param treeId      决策规则id
     * @param userId      用户id
     * @param decisionMatter 传入待对比参数
     * @return
     */
    protected TreeNode engineDecisionMaker(TreeRich treeRich,Long treeId,String userId,
                                           Map<String, String> decisionMatter){
        // 获取对应的 树节点信息
        TreeRoot treeRoot = treeRich.getTreeRoot();
        // 获取树节点详细配置信息
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 获取规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        // 获取 匹配对应 树节点 详细信息（匹配属性为 age 则去 获取所有的age详细配置节点信息）
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1⼦叶、2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            // 获取规则 key（到底对比元素是gender还是age）
            String ruleKey = treeNodeInfo.getRuleKey();
            // 获取对应的决策树规则
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            // 拿到决策属性
            String matterValue = logicFilter.matterValue(treeId, userId,
                    decisionMatter);
            // 匹配对应的决策和匹配逻辑并获取结果
            Long nextNode = logicFilter.filter(matterValue,
                    treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}",
                    treeRoot.getTreeName(), userId, treeId,treeNodeInfo.getTreeNodeId(),
                    ruleKey, matterValue);
        }
        return treeNodeInfo;
    }





}
