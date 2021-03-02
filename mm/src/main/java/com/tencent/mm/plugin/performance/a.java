package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.sdk.crash.ICrashReporter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a implements Application.ActivityLifecycleCallbacks, o, ICrashReporter.ICrashReportExtraMessageGetter {
    private static a ARU;
    MultiProcessMMKV cQe;
    String mProcessName;
    volatile int mState = 0;

    private a(String str) {
        AppMethodBeat.i(176886);
        String concat = "fg_killed_state_".concat(String.valueOf(str));
        this.mProcessName = str;
        this.cQe = MultiProcessMMKV.getSingleMMKV(concat);
        Log.d("MicroMsg.ForegroundKilledDetect", "MMKV stg :%s", concat);
        AppMethodBeat.o(176886);
    }

    public static a aJO(String str) {
        AppMethodBeat.i(176887);
        if (ARU == null) {
            ARU = new a(str.replace(":", "_"));
        }
        a aVar = ARU;
        AppMethodBeat.o(176887);
        return aVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    /* access modifiers changed from: package-private */
    public final boolean eBw() {
        return (this.mState & 1) == 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean eBx() {
        return (this.mState & 2) == 2;
    }

    /* access modifiers changed from: package-private */
    public final boolean eBy() {
        return (this.mState & 4) == 4;
    }

    private void setState(int i2) {
        this.mState |= i2;
    }

    /* access modifiers changed from: package-private */
    public final void Uo(int i2) {
        this.mState &= i2 ^ -1;
    }

    /* access modifiers changed from: package-private */
    public final void eBz() {
        AppMethodBeat.i(176892);
        this.cQe.encode("state", this.mState);
        AppMethodBeat.o(176892);
    }

    @Override // com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter
    public final String getCrashReportExtraMessage() {
        AppMethodBeat.i(176893);
        Log.d("MicroMsg.ForegroundKilledDetect", "%s : crash was caught! DO NOT report this case", this.mProcessName);
        int i2 = this.mState;
        if (!eBy()) {
            setState(4);
            eBz();
        }
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateCrashCaught state = %s -> %s", this.mProcessName, Integer.toBinaryString(i2), Integer.toBinaryString(this.mState));
        AppMethodBeat.o(176893);
        return "";
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(176888);
        int i2 = this.mState;
        if (!eBx()) {
            setState(2);
            eBz();
        }
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityForeground state = %s -> %s", this.mProcessName, Integer.toBinaryString(i2), Integer.toBinaryString(this.mState));
        AppMethodBeat.o(176888);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(176889);
        int i2 = this.mState;
        if (eBx()) {
            Uo(2);
            eBz();
        }
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateActivityBackground state = %s -> %s", this.mProcessName, Integer.toBinaryString(i2), Integer.toBinaryString(this.mState));
        AppMethodBeat.o(176889);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
        AppMethodBeat.i(176890);
        int i2 = this.mState;
        if (!eBw()) {
            setState(1);
            eBz();
        }
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppForeground state = %s -> %s", this.mProcessName, Integer.toBinaryString(i2), Integer.toBinaryString(this.mState));
        AppMethodBeat.o(176890);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(176891);
        int i2 = this.mState;
        if (eBw()) {
            Uo(1);
            eBz();
        }
        Log.d("MicroMsg.ForegroundKilledDetect", "%s: setStateAppBackground state = %s -> %s", this.mProcessName, Integer.toBinaryString(i2), Integer.toBinaryString(this.mState));
        AppMethodBeat.o(176891);
    }

    static /* synthetic */ int eBA() {
        AppMethodBeat.i(176894);
        if (MMApplicationContext.isMainProcess()) {
            if (BuildInfo.IS_ARM64) {
                AppMethodBeat.o(176894);
                return 12;
            }
            AppMethodBeat.o(176894);
            return 2;
        } else if (MMApplicationContext.isAppBrandProcess()) {
            if (BuildInfo.IS_ARM64) {
                AppMethodBeat.o(176894);
                return 13;
            }
            AppMethodBeat.o(176894);
            return 3;
        } else if (MMApplicationContext.isToolsProcess()) {
            if (BuildInfo.IS_ARM64) {
                AppMethodBeat.o(176894);
                return 14;
            }
            AppMethodBeat.o(176894);
            return 4;
        } else if (!MMApplicationContext.isToolsMpProcess()) {
            AppMethodBeat.o(176894);
            return -1;
        } else if (BuildInfo.IS_ARM64) {
            AppMethodBeat.o(176894);
            return 15;
        } else {
            AppMethodBeat.o(176894);
            return 5;
        }
    }
}
