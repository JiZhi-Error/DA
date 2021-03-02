package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic {
    ;

    public static AppBrandStickyBannerLogic valueOf(String str) {
        AppMethodBeat.i(49033);
        AppBrandStickyBannerLogic appBrandStickyBannerLogic = (AppBrandStickyBannerLogic) Enum.valueOf(AppBrandStickyBannerLogic.class, str);
        AppMethodBeat.o(49033);
        return appBrandStickyBannerLogic;
    }

    static /* synthetic */ boolean access$200() {
        AppMethodBeat.i(49034);
        AppMethodBeat.o(49034);
        return true;
    }

    static final class Watcher extends MainProcessTask {
        public static final Parcelable.Creator<Watcher> CREATOR = new Parcelable.Creator<Watcher>() {
            /* class com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Watcher[] newArray(int i2) {
                return new Watcher[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Watcher createFromParcel(Parcel parcel) {
                AppMethodBeat.i(49025);
                Watcher watcher = new Watcher();
                watcher.f(parcel);
                AppMethodBeat.o(49025);
                return watcher;
            }
        };
        private static final transient Map<String, f> oav = new HashMap();
        String oas;
        String oat;
        int oau;

        static /* synthetic */ boolean a(Watcher watcher) {
            AppMethodBeat.i(49030);
            boolean bDU = watcher.bDU();
            AppMethodBeat.o(49030);
            return bDU;
        }

        static {
            AppMethodBeat.i(49031);
            AppMethodBeat.o(49031);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(49026);
            if (Util.isNullOrNil(this.oas)) {
                AppMethodBeat.o(49026);
                return;
            }
            synchronized (oav) {
                try {
                    if (oav.containsKey(this.oas)) {
                        b.c(oav.get(this.oas));
                    }
                    AnonymousClass1 r0 = new f() {
                        /* class com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.Watcher.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.ui.banner.f
                        public final void bJ(String str, int i2) {
                            AppMethodBeat.i(49024);
                            Watcher.this.oat = str;
                            Watcher.this.oau = i2;
                            Watcher.a(Watcher.this);
                            AppMethodBeat.o(49024);
                        }
                    };
                    b.d(r0);
                    oav.put(this.oas, r0);
                } finally {
                    AppMethodBeat.o(49026);
                }
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(49027);
            a.cq(this.oat, this.oau);
            AppMethodBeat.o(49027);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(49028);
            parcel.writeString(this.oas);
            parcel.writeString(this.oat);
            parcel.writeInt(this.oau);
            AppMethodBeat.o(49028);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(49029);
            this.oas = parcel.readString();
            this.oat = parcel.readString();
            this.oau = parcel.readInt();
            AppMethodBeat.o(49029);
        }

        Watcher() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class OperateTask extends MainProcessTask {
        public static final Parcelable.Creator<OperateTask> CREATOR = new Parcelable.Creator<OperateTask>() {
            /* class com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OperateTask[] newArray(int i2) {
                return new OperateTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OperateTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(49018);
                OperateTask operateTask = new OperateTask();
                operateTask.f(parcel);
                AppMethodBeat.o(49018);
                return operateTask;
            }
        };
        boolean oao;
        String oap;
        int oaq;
        String oar;
        int op = 0;

        OperateTask() {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(49019);
            switch (this.op) {
                case 1:
                    this.oao = b.bYc();
                    bDU();
                    AppMethodBeat.o(49019);
                    return;
                case 2:
                    b.b(this);
                    break;
                case 3:
                    b.cr(this.oap, this.oaq);
                    AppMethodBeat.o(49019);
                    return;
            }
            AppMethodBeat.o(49019);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(49021);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.op);
            parcel.writeByte(this.oao ? (byte) 1 : 0);
            parcel.writeString(this.oap);
            parcel.writeInt(this.oaq);
            parcel.writeString(this.oar);
            AppMethodBeat.o(49021);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(49022);
            this.op = parcel.readInt();
            this.oao = parcel.readByte() != 0;
            this.oap = parcel.readString();
            this.oaq = parcel.readInt();
            this.oar = parcel.readString();
            AppMethodBeat.o(49022);
        }

        static {
            AppMethodBeat.i(49023);
            AppMethodBeat.o(49023);
        }
    }

    public static final class b {
        static final Set<f> listeners = new HashSet();

        static /* synthetic */ void access$100() {
            AppMethodBeat.i(49016);
            bYd();
            AppMethodBeat.o(49016);
        }

        static {
            AppMethodBeat.i(49017);
            AppMethodBeat.o(49017);
        }

        public static void R(final Intent intent) {
            AppMethodBeat.i(49008);
            if (intent == null || !g.aAc()) {
                AppMethodBeat.o(49008);
                return;
            }
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(49007);
                    if (b.Q(intent)) {
                        b.access$100();
                    }
                    AppMethodBeat.o(49007);
                }
            });
            AppMethodBeat.o(49008);
        }

        static void b(OperateTask operateTask) {
            AppMethodBeat.i(49009);
            if (b.a(operateTask)) {
                bYd();
            }
            AppMethodBeat.o(49009);
        }

        static void bXX() {
            AppMethodBeat.i(49010);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(49010);
        }

        private static void bYd() {
            AppMethodBeat.i(49011);
            BannerModel bYe = BannerModel.bYe();
            String str = bYe == null ? null : bYe.appId;
            int i2 = bYe == null ? -1 : bYe.iOo;
            synchronized (listeners) {
                try {
                    for (f fVar : listeners) {
                        fVar.bJ(str, i2);
                    }
                } finally {
                    AppMethodBeat.o(49011);
                }
            }
        }

        public static void d(f fVar) {
            AppMethodBeat.i(49012);
            if (fVar != null) {
                synchronized (listeners) {
                    try {
                        listeners.add(fVar);
                    } finally {
                        AppMethodBeat.o(49012);
                    }
                }
                return;
            }
            AppMethodBeat.o(49012);
        }

        public static void c(f fVar) {
            AppMethodBeat.i(49013);
            if (fVar != null) {
                synchronized (listeners) {
                    try {
                        listeners.remove(fVar);
                    } finally {
                        AppMethodBeat.o(49013);
                    }
                }
                return;
            }
            AppMethodBeat.o(49013);
        }

        public static boolean bYc() {
            AppMethodBeat.i(49014);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(49014);
            return false;
        }

        public static void cr(String str, int i2) {
            AppMethodBeat.i(227721);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(227721);
        }
    }

    public static final class a {
        private static final Watcher oai = new Watcher();
        private static final Set<f> oaj = new HashSet();
        private static final HashMap<String, Boolean> oak = new HashMap<>();
        private static final HashMap<String, f> oal = new HashMap<>();
        private static final c oam = new c();
        private static final Map<String, String> oan = new HashMap();

        static {
            AppMethodBeat.i(49006);
            AppMethodBeat.o(49006);
        }

        static void cq(String str, int i2) {
            AppMethodBeat.i(48999);
            synchronized (oaj) {
                try {
                    for (f fVar : oaj) {
                        fVar.bJ(str, i2);
                    }
                } finally {
                    AppMethodBeat.o(48999);
                }
            }
        }

        public static void a(Context context, String str, int i2, String str2, String str3) {
            Context context2;
            String str4;
            AppMethodBeat.i(49000);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(49000);
                return;
            }
            if (context == null) {
                context2 = MMApplicationContext.getContext();
            } else {
                context2 = context;
            }
            Intent addFlags = new Intent().setClassName(context2, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
            synchronized (oan) {
                try {
                    str4 = oan.get(str);
                } finally {
                    AppMethodBeat.o(49000);
                }
            }
            b.a(addFlags, str, i2, str2, str3, Util.nullAsNil(str4));
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(addFlags);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/ui/banner/AppBrandStickyBannerLogic$ClientLogic", "stickOnChatting", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (context2 instanceof Activity) {
                try {
                    ((Activity) context2).moveTaskToBack(false);
                    AppMethodBeat.o(49000);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", e2.getMessage());
                }
            }
        }

        public static boolean bYc() {
            AppMethodBeat.i(49001);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(49001);
            return false;
        }

        public static void c(f fVar) {
            AppMethodBeat.i(49002);
            if (fVar != null) {
                synchronized (oaj) {
                    try {
                        oaj.remove(fVar);
                    } finally {
                        AppMethodBeat.o(49002);
                    }
                }
                return;
            }
            AppMethodBeat.o(49002);
        }

        public static void d(f fVar) {
            AppMethodBeat.i(49003);
            oai.oas = MMApplicationContext.getProcessName();
            AppBrandMainProcessService.a(oai);
            if (fVar != null) {
                synchronized (oaj) {
                    try {
                        oaj.add(fVar);
                    } finally {
                        AppMethodBeat.o(49003);
                    }
                }
                return;
            }
            AppMethodBeat.o(49003);
        }
    }
}
