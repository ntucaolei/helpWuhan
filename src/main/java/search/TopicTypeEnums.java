package main.java.search;

import main.java.Entity.ContributorItemEntity;
import main.java.Entity.DemandItemEntity;
import main.java.Entity.FakeNewsItemEntity;

import java.util.ArrayList;
import java.util.List;

//主题枚举
public enum TopicTypeEnums {
    FAKE_NEWS("fackNews", "虚假信息"),
    CONTRIBUTOR("contributor","捐助者"),
    DEMAND("demand", "需求方");

    private String code;
    private String desc;
    private TopicTypeEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<Object> queryByCondition(String topicType, String topicStatus, String itemType, String content) {
        List<Object> objectList = new ArrayList<>();
        if (TopicTypeEnums.CONTRIBUTOR.getCode().equals(topicType)) {
            List<DemandItemEntity> demandList = SearchDBHelper.getLocalDBHelper().queryDemandListByCondition(topicStatus, itemType, content);
            objectList.addAll(demandList);
        }
        if (TopicTypeEnums.DEMAND.getCode().equals(topicType)) {
            List<ContributorItemEntity> contributorList = SearchDBHelper.getLocalDBHelper().queryContributorListByCondition(topicStatus, itemType, content);
            objectList.addAll(contributorList);
        }
        if (TopicTypeEnums.FAKE_NEWS.getCode().equals(topicType)) {
            List<FakeNewsItemEntity> fakeNewsList = SearchDBHelper.getLocalDBHelper().queryFakeNewsListByCondition(itemType, content);
            objectList.addAll(fakeNewsList);
        }
        return objectList;
    }
}
