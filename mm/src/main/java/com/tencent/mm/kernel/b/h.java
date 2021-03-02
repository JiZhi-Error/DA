package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.co.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.b.b;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public final class h extends g {
    public d gmN;
    public a<ApplicationLifeCycle> htA = new a<>();
    public ApplicationLike htz;
    public com.tencent.mm.compatible.loader.d mProfileCompat;

    @Override // com.tencent.mm.kernel.b.g
    public final String getPackageName() {
        AppMethodBeat.i(259563);
        String packageName = MMApplicationContext.getPackageName();
        AppMethodBeat.o(259563);
        return packageName;
    }

    public h(String str, Application application, ApplicationLike applicationLike) {
        super(str, application);
        AppMethodBeat.i(132220);
        this.htz = applicationLike;
        AppMethodBeat.o(132220);
    }

    public final void onCreate() {
        AppMethodBeat.i(132221);
        this.htA.a(new a.AbstractC0297a<ApplicationLifeCycle>() {
            /* class com.tencent.mm.kernel.b.h.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.co.a.AbstractC0297a
            public final /* synthetic */ void bw(ApplicationLifeCycle applicationLifeCycle) {
                AppMethodBeat.i(132213);
                applicationLifeCycle.onCreate();
                AppMethodBeat.o(132213);
            }
        });
        AppMethodBeat.o(132221);
    }

    public final void onLowMemory() {
        AppMethodBeat.i(132222);
        this.htA.a(new a.AbstractC0297a<ApplicationLifeCycle>() {
            /* class com.tencent.mm.kernel.b.h.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.co.a.AbstractC0297a
            public final /* synthetic */ void bw(ApplicationLifeCycle applicationLifeCycle) {
                AppMethodBeat.i(132214);
                applicationLifeCycle.onLowMemory();
                AppMethodBeat.o(132214);
            }
        });
        AppMethodBeat.o(132222);
    }

    public final void onTrimMemory(final int i2) {
        AppMethodBeat.i(132223);
        this.htA.a(new a.AbstractC0297a<ApplicationLifeCycle>() {
            /* class com.tencent.mm.kernel.b.h.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.co.a.AbstractC0297a
            public final /* synthetic */ void bw(ApplicationLifeCycle applicationLifeCycle) {
                AppMethodBeat.i(132215);
                applicationLifeCycle.onTrimMemory(i2);
                AppMethodBeat.o(132215);
            }
        });
        AppMethodBeat.o(132223);
    }

    public final void onTerminate() {
        AppMethodBeat.i(132224);
        this.htA.a(new a.AbstractC0297a<ApplicationLifeCycle>() {
            /* class com.tencent.mm.kernel.b.h.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.co.a.AbstractC0297a
            public final /* synthetic */ void bw(ApplicationLifeCycle applicationLifeCycle) {
                AppMethodBeat.i(132216);
                applicationLifeCycle.onTerminate();
                AppMethodBeat.o(132216);
            }
        });
        AppMethodBeat.o(132224);
    }

    public final void onConfigurationChanged(final Configuration configuration) {
        AppMethodBeat.i(132225);
        this.htA.a(new a.AbstractC0297a<ApplicationLifeCycle>() {
            /* class com.tencent.mm.kernel.b.h.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.co.a.AbstractC0297a
            public final /* synthetic */ void bw(ApplicationLifeCycle applicationLifeCycle) {
                AppMethodBeat.i(132217);
                applicationLifeCycle.onConfigurationChanged(configuration);
                AppMethodBeat.o(132217);
            }
        });
        AppMethodBeat.o(132225);
    }

    public final b a(ApplicationLifeCycle applicationLifeCycle) {
        AppMethodBeat.i(132226);
        b<ApplicationLifeCycle> add = this.htA.add(applicationLifeCycle);
        AppMethodBeat.o(132226);
        return add;
    }
}
