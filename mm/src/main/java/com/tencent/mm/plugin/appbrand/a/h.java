package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import android.text.TextUtils;

public abstract class h extends i {
    private final String[] kRG = {"invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit"};
    boolean kRH = false;

    public abstract void a(g gVar);

    public h(String str, Looper looper) {
        super(str, looper);
        super.setDbg(true);
    }

    @Override // com.tencent.mm.plugin.appbrand.a.i, com.tencent.mm.sdk.statemachine.StateMachine
    public void log(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = this.kRG;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (str.startsWith(strArr[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                super.logi(str);
            } else {
                super.logv(str);
            }
            if (str.startsWith("handleMessage: E")) {
                this.kRH = true;
            }
            if (str.startsWith("handleMessage: X")) {
                this.kRH = false;
            }
        }
    }
}
