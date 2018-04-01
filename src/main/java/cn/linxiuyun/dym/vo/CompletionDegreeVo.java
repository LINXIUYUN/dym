package cn.linxiuyun.dym.vo;

public class CompletionDegreeVo {

    private int personalInfoDegree;

    private int joinApplyDegree;

    private int awardAndPunishDegree;

    private int relatedDegree;

    public int getPersonalInfoDegree() {
        return personalInfoDegree;
    }

    public void setPersonalInfoDegree(int personalInfoDegree) {
        this.personalInfoDegree = personalInfoDegree;
    }

    public int getJoinApplyDegree() {
        return joinApplyDegree;
    }

    public void setJoinApplyDegree(int joinApplyDegree) {
        this.joinApplyDegree = joinApplyDegree;
    }

    public int getAwardAndPunishDegree() {
        return awardAndPunishDegree;
    }

    public void setAwardAndPunishDegree(int awardAndPunishDegree) {
        this.awardAndPunishDegree = awardAndPunishDegree;
    }

    public int getRelatedDegree() {
        return relatedDegree;
    }

    public void setRelatedDegree(int relatedDegree) {
        this.relatedDegree = relatedDegree;
    }

    @Override
    public String toString() {
        return "CompletionDegreeVo{" +
                "personalInfoDegree=" + personalInfoDegree +
                ", joinApplyDegree=" + joinApplyDegree +
                ", awardAndPunishDegree=" + awardAndPunishDegree +
                ", relatedDegree=" + relatedDegree +
                '}';
    }
}
