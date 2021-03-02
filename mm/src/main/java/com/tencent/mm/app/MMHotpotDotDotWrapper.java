package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.aa;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.vfs.y;
import com.tencent.mm.xlog.app.a;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMHotpotDotDotWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMHotpotDotDotWrapper";
    private final Application mApp;
    private final ApplicationLike mAppLike;
    private final String mCurrentProcessName;
    private final long mProcessInitTimestamp = System.currentTimeMillis();
    private h profile = null;

    public MMHotpotDotDotWrapper(ApplicationLike applicationLike, String str) {
        AppMethodBeat.i(257904);
        this.mApp = applicationLike.getApplication();
        this.mAppLike = applicationLike;
        this.mCurrentProcessName = str;
        AppMethodBeat.o(257904);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
        AppMethodBeat.i(257905);
        AndroidOSafety.replaceTargetVersion(context.getApplicationInfo());
        this.profile = new h(this.mCurrentProcessName, this.mApp, this.mAppLike);
        this.profile.htp.htq = this.mProcessInitTimestamp;
        y.f(this.profile);
        context.getClassLoader();
        j.Ed("stlport_shared");
        context.getClassLoader();
        j.Ed("c++_shared");
        String str = a.Rza;
        context.getClassLoader();
        j.Ed(str);
        this.profile.gmN = d.cg(this.profile.ca);
        this.profile.gmN.CN("HOTPOT..");
        g.a(this.profile.ca, new aa());
        com.tencent.mm.splash.a.n(this.mApp);
        com.tencent.mm.bu.a.a.gtp();
        aj.a(this.profile, null);
        AppMethodBeat.o(257905);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
        AppMethodBeat.i(257906);
        if (this.profile != null) {
            this.profile.onCreate();
        }
        AppMethodBeat.o(257906);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(257907);
        if (this.profile != null) {
            this.profile.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(257907);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        AppMethodBeat.i(257908);
        if (this.profile != null) {
            this.profile.onLowMemory();
        }
        AppMethodBeat.o(257908);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i2) {
        AppMethodBeat.i(257909);
        if (this.profile != null) {
            this.profile.onTrimMemory(i2);
        }
        AppMethodBeat.o(257909);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
        AppMethodBeat.i(257910);
        if (this.profile != null) {
            this.profile.onTerminate();
        }
        AppMethodBeat.o(257910);
    }
}
