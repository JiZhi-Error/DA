package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Objects;

public final class AppBrandPreInitTask extends MainProcessTask {
    public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR = new Parcelable.Creator<AppBrandPreInitTask>() {
        /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppBrandPreInitTask[] newArray(int i2) {
            return new AppBrandPreInitTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppBrandPreInitTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(47070);
            AppBrandPreInitTask appBrandPreInitTask = new AppBrandPreInitTask(parcel, (byte) 0);
            AppMethodBeat.o(47070);
            return appBrandPreInitTask;
        }
    };
    private Context context;
    private transient a mQt;
    private ActivityStarterIpcDelegate mQu;
    private LaunchParcel mQv;
    private boolean mQw;
    private AppBrandInitConfigWC mQx;
    private boolean mQy;

    public interface a {
        void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject);
    }

    /* synthetic */ AppBrandPreInitTask(Parcel parcel, byte b2) {
        this(parcel);
    }

    static /* synthetic */ boolean b(AppBrandPreInitTask appBrandPreInitTask) {
        AppMethodBeat.i(47078);
        boolean z = appBrandPreInitTask.mQy;
        AppMethodBeat.o(47078);
        return z;
    }

    static /* synthetic */ boolean c(AppBrandPreInitTask appBrandPreInitTask) {
        AppMethodBeat.i(227055);
        boolean bDU = appBrandPreInitTask.bDU();
        AppMethodBeat.o(227055);
        return bDU;
    }

    public AppBrandPreInitTask(Context context2, LaunchParcel launchParcel, a aVar) {
        this(context2, launchParcel, false, aVar);
    }

    public AppBrandPreInitTask(Context context2, LaunchParcel launchParcel, boolean z, a aVar) {
        AppMethodBeat.i(227054);
        this.context = context2;
        this.mQv = launchParcel;
        this.mQw = z;
        this.mQt = aVar;
        if (context2 instanceof Activity) {
            this.mQu = new ActivityStarterIpcDelegate((Activity) context2);
        } else {
            this.mQu = null;
        }
        this.mQv.mQC = this.mQu;
        AppMethodBeat.o(227054);
    }

    public final void bNf() {
        AppMethodBeat.i(47072);
        if (this.mQv.mYM == 0) {
            this.mQv.mYM = Util.nowMilliSecond();
        }
        bDJ();
        AppBrandMainProcessService.a(this);
        AppMethodBeat.o(47072);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(47073);
        if (this.mQt != null) {
            if (this.mQy) {
                this.mQt.a(null, null);
                ((b) g.af(b.class)).hr(this.context);
            } else {
                this.mQt.a(this.mQx, this.mQv.mYK);
            }
        }
        bDK();
        AppMethodBeat.o(47073);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(47074);
        String c2 = com.tencent.mm.plugin.appbrand.report.quality.g.c(this.mQv, (String) Objects.requireNonNull(this.mQv.appId));
        w wVar = w.nHZ;
        w.b(this.mQv, c2);
        if (o.bVk()) {
            o oVar = o.nMe;
            o.eI(this.mQv.appId, c2);
            c.e(KSProcessWeAppLaunch.class, this.mQv.appId);
            c.a(KSProcessWeAppLaunch.class, this.mQv.appId, String.format("Network:%s", NetStatusUtil.getNetTypeString(this.context)));
        }
        final f fVar = new f(this.mQv, c2, this.mQw, new e.a<AppBrandInitConfigWC>() {
            /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.config.AppBrandInitConfigLU, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject, int] */
            @Override // com.tencent.mm.plugin.appbrand.launching.e.a
            public final /* synthetic */ void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i2) {
                int i3;
                AppMethodBeat.i(227052);
                AppBrandInitConfigWC appBrandInitConfigWC2 = appBrandInitConfigWC;
                AppBrandPreInitTask.this.mQx = appBrandInitConfigWC2;
                AppBrandPreInitTask.this.mQv.mYK = appBrandStatObject;
                if (appBrandInitConfigWC2 != null) {
                    AppBrandPreInitTask.this.mQv.f(appBrandInitConfigWC2);
                    c.b(appBrandInitConfigWC2, appBrandStatObject);
                    AppBrandPreInitTask appBrandPreInitTask = AppBrandPreInitTask.this;
                    if (appBrandStatObject != null) {
                        i3 = appBrandStatObject.scene;
                    } else {
                        i3 = -1;
                    }
                    appBrandPreInitTask.mQy = !com.tencent.mm.plugin.appbrand.launching.f.b.a(appBrandInitConfigWC2, Integer.valueOf(i3), appBrandInitConfigWC2.username, appBrandInitConfigWC2.eix);
                    if (AppBrandPreInitTask.b(AppBrandPreInitTask.this)) {
                        com.tencent.mm.plugin.appbrand.launching.f.a.aco(appBrandInitConfigWC2.username);
                    }
                }
                AppBrandPreInitTask.c(AppBrandPreInitTask.this);
                h.bzT().a(appBrandInitConfigWC2.username, appBrandInitConfigWC2.bzU());
                AppMethodBeat.o(227052);
            }
        });
        final String str = this.mQv.appId;
        final int i2 = this.mQv.iOo;
        com.tencent.f.h.RTc.aZ(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(47069);
                fVar.run();
                AppMethodBeat.o(47069);
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                AppMethodBeat.i(227053);
                String format = String.format(Locale.US, "AppBrandPreInitTask-%s|%d", str, Integer.valueOf(i2));
                AppMethodBeat.o(227053);
                return format;
            }
        });
        AppMethodBeat.o(47074);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void writeToParcel(Parcel parcel, int i2) {
        byte b2 = 1;
        AppMethodBeat.i(47075);
        parcel.writeParcelable(this.mQv, i2);
        parcel.writeByte((byte) (this.mQw ? 1 : 0));
        parcel.writeParcelable(this.mQx, i2);
        parcel.writeParcelable(this.mQu, i2);
        if (!this.mQy) {
            b2 = 0;
        }
        parcel.writeByte(b2);
        AppMethodBeat.o(47075);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(47076);
        this.mQv = (LaunchParcel) parcel.readParcelable(LaunchParcel.class.getClassLoader());
        this.mQw = parcel.readByte() > 0;
        this.mQx = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
        this.mQu = (ActivityStarterIpcDelegate) parcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader());
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.mQy = z;
        AppMethodBeat.o(47076);
    }

    private AppBrandPreInitTask(Parcel parcel) {
        AppMethodBeat.i(47077);
        f(parcel);
        AppMethodBeat.o(47077);
    }

    static {
        AppMethodBeat.i(47079);
        AppMethodBeat.o(47079);
    }
}
