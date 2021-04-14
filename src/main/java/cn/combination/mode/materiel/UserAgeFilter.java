package cn.combination.mode.materiel;

import cn.combination.mode.Cache.BaseLogin;

import java.util.Map;

public class UserAgeFilter extends BaseLogin {
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
