package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.StateMachine;

public abstract class i extends StateMachine {
    protected i(String str, Looper looper) {
        super(str, looper);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void log(String str) {
        Log.d(getName(), str);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void logd(String str) {
        Log.d(getName(), str);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void logv(String str) {
        Log.v(getName(), str);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void logi(String str) {
        Log.i(getName(), str);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void logw(String str) {
        Log.w(getName(), str);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void loge(String str) {
        Log.e(getName(), str);
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void loge(String str, Throwable th) {
        Log.printErrStackTrace(getName(), th, str, new Object[0]);
    }
}
