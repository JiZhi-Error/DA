package com.tencent.recovery;

import android.content.SharedPreferences;
import com.tencent.recovery.ConstantsRecovery;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryStatusItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class RecoveryContext {
    private static final String TAG = "Recovery.RecoveryContext";
    public ArrayList<RecoveryStatusItem> exceptionItemList = new ArrayList<>();

    /* access modifiers changed from: protected */
    public final void clear() {
        RecoveryLog.i(TAG, "clear", new Object[0]);
        this.exceptionItemList.clear();
    }

    /* access modifiers changed from: protected */
    public final void readFromSp(SharedPreferences sharedPreferences) {
        String[] split;
        if (sharedPreferences.contains(ConstantsRecovery.SpKeys.KeyHistoryExceptionTypeList) && (split = sharedPreferences.getString(ConstantsRecovery.SpKeys.KeyHistoryExceptionTypeList, "").split(";")) != null && split.length > 0) {
            for (String str : split) {
                RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
                if (recoveryStatusItem.parseFromString(str)) {
                    this.exceptionItemList.add(recoveryStatusItem);
                }
            }
        }
        RecoveryLog.i(TAG, "RecoveryContext readFromSp %s", toString());
    }

    /* access modifiers changed from: protected */
    public final void saveToSp(SharedPreferences.Editor editor) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<RecoveryStatusItem> it = this.exceptionItemList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toSaveString());
            stringBuffer.append(";");
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() > 0) {
            editor.putString(ConstantsRecovery.SpKeys.KeyHistoryExceptionTypeList, stringBuffer.toString());
        } else {
            editor.remove(ConstantsRecovery.SpKeys.KeyHistoryExceptionTypeList);
        }
        RecoveryLog.i(TAG, "RecoveryContext saveToSp %s", toString());
    }

    public final String toString() {
        return this.exceptionItemList.toString();
    }

    /* access modifiers changed from: protected */
    public final void addExceptionItem(RecoveryStatusItem recoveryStatusItem) {
        if (this.exceptionItemList.size() > 15) {
            this.exceptionItemList.remove(0);
        }
        this.exceptionItemList.add(recoveryStatusItem);
    }
}
