package com.tencent.mm.appbrand.v8;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public interface IJSRuntime {
    String LP();

    Config Xr();

    boolean Xw();

    void a(int i2, h hVar);

    void a(Runnable runnable, long j2, boolean z);

    void cS(boolean z);

    boolean doInnerLoopTask();

    void e(Runnable runnable, long j2);

    long getIsolatePtr();

    long getUVLoopPtr();

    m iP(int i2);

    void pause();

    void quit();

    void r(Runnable runnable);

    void resume();

    void resumeLoopTasks();

    void s(Runnable runnable);

    void setThreadPriority(int i2);

    void t(Runnable runnable);

    void waitForDebugger(String str);

    public static class Config {
        public String dpj = null;
        public byte[] dpk = null;
        public String dpl = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        public boolean dpm;
        public boolean dpn;
        public boolean dpo = false;
        public boolean dpp = false;
        public String dpq = null;
        public String dpr = "";
        public WeakReference<g> dps = null;
        public e opR;

        public boolean useNativeBufferJNI() {
            AppMethodBeat.i(143994);
            boolean equalsIgnoreCase = "1".equalsIgnoreCase(this.dpl);
            AppMethodBeat.o(143994);
            return equalsIgnoreCase;
        }

        public Config(String str, byte[] bArr) {
            this.dpj = str;
            this.dpk = bArr;
        }

        public Config() {
        }

        public String toString() {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(143995);
            StringBuilder append = new StringBuilder("Config{codeCache='").append(this.dpj).append('\'').append(", snapShot=").append(Util.isNullOrNil(this.dpk) ? BuildConfig.COMMAND : "not null").append(", nativeBuffer='").append(this.dpl).append('\'').append(", supportDirectEvaluation=").append(this.dpm).append(", enableNativeTrans=").append(this.dpn).append(", hasGlobalTimer=").append(this.dpo).append(", ignoreRemainingTaskWhenLoopEnd=").append(this.dpp).append(", globalAlias=").append(this.dpq).append(", hasComponent=");
            if (this.dps == null || this.dps.get() == null) {
                z = false;
            } else {
                z = true;
            }
            StringBuilder append2 = append.append(z).append(", hasBufferStore=");
            if (this.opR == null) {
                z2 = false;
            }
            String sb = append2.append(z2).append('}').toString();
            AppMethodBeat.o(143995);
            return sb;
        }
    }
}
