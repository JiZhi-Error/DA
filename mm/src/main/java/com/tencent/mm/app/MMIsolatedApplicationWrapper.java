package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.blink.a;
import com.tencent.mm.boot.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.splash.m;
import com.tencent.mm.vfs.g;
import com.tencent.smtt.sandbox.SandboxListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMIsolatedApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMIsolatedApplicationWrapper";
    public Application app;
    private final ApplicationLike lifeCycle;
    private final long processInitTimestamp = System.currentTimeMillis();
    private h profile = null;
    private String thisProcess;

    public MMIsolatedApplicationWrapper(ApplicationLike applicationLike, String str) {
        AppMethodBeat.i(160050);
        a.r(applicationLike.getApplicationStartMillisTime(), applicationLike.getApplicationStartElapsedTime());
        this.app = applicationLike.getApplication();
        this.lifeCycle = applicationLike;
        this.thisProcess = str;
        AppMethodBeat.o(160050);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
        AppMethodBeat.i(160051);
        com.tencent.mm.kernel.a.a.hrO = SystemClock.elapsedRealtime();
        com.tencent.mm.kernel.a.a.hrN = System.currentTimeMillis();
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        this.profile.htp.htq = this.processInitTimestamp;
        g.setContext(this.profile.ca);
        context.getClassLoader();
        j.Ed("stlport_shared");
        context.getClassLoader();
        j.Ed("c++_shared");
        QbSdk.setSandboxListener(new SandboxListener() {
            /* class com.tencent.mm.app.MMIsolatedApplicationWrapper.AnonymousClass1 */

            @Override // com.tencent.smtt.sandbox.SandboxListener
            public final void setCrashRecordFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2) {
                AppMethodBeat.i(160134);
                u.a(parcelFileDescriptor, parcelFileDescriptor2, MMIsolatedApplicationWrapper.this.thisProcess);
                AppMethodBeat.o(160134);
            }
        });
        com.tencent.mm.splash.a.n(this.app);
        com.tencent.mm.bu.a.a.gtp();
        Log.i(TAG, "is plain process. load nothing");
        aj.a(this.profile, null);
        ab.ab(a.C0281a.class);
        ab.gm("com.tencent.mm.boot");
        AppMethodBeat.o(160051);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
        AppMethodBeat.i(160052);
        c.g(this.app);
        m.gyz();
        AppMethodBeat.o(160052);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
        AppMethodBeat.i(160053);
        if (this.profile != null) {
            this.profile.onTerminate();
        }
        AppMethodBeat.o(160053);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(160054);
        if (this.profile != null) {
            this.profile.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(160054);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        AppMethodBeat.i(160055);
        if (this.profile != null) {
            this.profile.onLowMemory();
        }
        AppMethodBeat.o(160055);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i2) {
        AppMethodBeat.i(160056);
        if (this.profile != null) {
            this.profile.onTrimMemory(i2);
        }
        AppMethodBeat.o(160056);
    }
}
