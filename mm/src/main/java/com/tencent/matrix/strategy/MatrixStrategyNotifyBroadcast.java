package com.tencent.matrix.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.d;
import com.tencent.matrix.e;
import com.tencent.matrix.g.c;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import java.util.ArrayList;
import java.util.HashMap;

public class MatrixStrategyNotifyBroadcast extends BroadcastReceiver {
    public static final String dag = WeChatPermissions.PERMISSION_MATRIX_STRATEGYNOTIFY();

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        if (intent == null) {
            c.e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
            return;
        }
        String action = intent.getAction();
        String stringExtra = IntentUtil.getStringExtra(intent, "strategy");
        c.i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s action:%s", MMApplicationContext.getProcessName(), stringExtra, action);
        if (!TextUtils.isEmpty(stringExtra)) {
            b.Tn();
        } else if (action.equals("statusNotify")) {
            HashMap hashMap = new HashMap();
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("StatusChangeKey");
            ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("StatusChangeValue");
            if (stringArrayListExtra == null || integerArrayListExtra == null) {
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(stringArrayListExtra == null);
                if (integerArrayListExtra == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                Log.w("Matrix.StrategyNotifyBroadcast", "keys=%s values=%s", objArr);
            } else if (stringArrayListExtra.size() != integerArrayListExtra.size()) {
                Log.w("Matrix.StrategyNotifyBroadcast", "keys.size(%s) != values.size(%s)", Integer.valueOf(stringArrayListExtra.size()), Integer.valueOf(integerArrayListExtra.size()));
            } else {
                for (int i2 = 0; i2 < stringArrayListExtra.size(); i2++) {
                    hashMap.put(stringArrayListExtra.get(i2), Boolean.valueOf(integerArrayListExtra.get(i2).intValue() == 1));
                }
                d.INSTANCE.cPM.p(hashMap);
            }
        } else {
            e.j(intent);
        }
    }
}
