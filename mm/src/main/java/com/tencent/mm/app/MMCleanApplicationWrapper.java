package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.a;
import com.tencent.mm.booter.aa;
import com.tencent.mm.cc.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect;
import com.tencent.mm.sdk.platformtools.AndroidOSafety;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.splash.a;
import com.tencent.mm.vfs.y;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMCleanApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final ApplicationLike lifeCycle;
    private final long processInitTimestamp = System.currentTimeMillis();
    private h profile = null;
    private String thisProcess;

    public MMCleanApplicationWrapper(ApplicationLike applicationLike, String str) {
        AppMethodBeat.i(257898);
        this.app = applicationLike.getApplication();
        this.lifeCycle = applicationLike;
        this.thisProcess = str;
        AppMethodBeat.o(257898);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
        AppMethodBeat.i(257899);
        AndroidOSafety.replaceTargetVersion(context.getApplicationInfo());
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        this.profile.htp.htq = this.processInitTimestamp;
        y.f(this.profile);
        g.a(this.profile.ca, new aa());
        a.n(this.app);
        AppForegroundDelegate.INSTANCE.d(this.app);
        DataPackageFrequencyDetect.CxA.d(this.app);
        com.tencent.mm.bu.a.a.gtp();
        aj.a(this.profile, null);
        Application application = this.app;
        MMApplicationContext.setResources(b.a(application.getResources(), (Context) application, true));
        ab.ab(a.C0281a.class);
        ab.gm("com.tencent.mm.boot");
        ai.init(this.app);
        AppMethodBeat.o(257899);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
        AppMethodBeat.i(257900);
        if (this.profile != null) {
            this.profile.onTerminate();
        }
        AppMethodBeat.o(257900);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(257901);
        if (this.profile != null) {
            this.profile.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(257901);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        AppMethodBeat.i(257902);
        if (this.profile != null) {
            this.profile.onLowMemory();
        }
        AppMethodBeat.o(257902);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i2) {
        AppMethodBeat.i(257903);
        if (this.profile != null) {
            this.profile.onTrimMemory(i2);
        }
        AppMethodBeat.o(257903);
    }
}
