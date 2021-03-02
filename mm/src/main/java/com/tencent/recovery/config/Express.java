package com.tencent.recovery.config;

import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.util.AttributeUtil;
import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> expressConditionList = new ArrayList();

    public String toString() {
        return this.expressConditionList.toString();
    }

    public void addCondition(List<ExpressItem> list) {
        this.expressConditionList.add(list);
    }

    public boolean getResult(List<RecoveryStatusItem> list) {
        for (List<ExpressItem> list2 : this.expressConditionList) {
            if (checkCondition(list2, list)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCondition(List<ExpressItem> list, List<RecoveryStatusItem> list2) {
        for (ExpressItem expressItem : list) {
            int i2 = 0;
            for (RecoveryStatusItem recoveryStatusItem : list2) {
                if (AttributeUtil.hasAttr(expressItem.getProcessStartFlag(), recoveryStatusItem.processStartFlag) && AttributeUtil.hasAttr(expressItem.getProcessStage(), recoveryStatusItem.processStage) && AttributeUtil.hasAttr(expressItem.getProcessStatus(), recoveryStatusItem.processStatus)) {
                    i2++;
                }
            }
            if (expressItem.getCount() > i2) {
                return false;
            }
        }
        return true;
    }
}
