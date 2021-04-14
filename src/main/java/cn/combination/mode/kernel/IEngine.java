package cn.combination.mode.kernel;

import cn.combination.mode.aggregates.TreeRich;
import cn.combination.mode.vo.EngineResult;

import java.util.Map;

//决策接口
public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich
            treeRich, final Map<String, String> decisionMatter);
}
