package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.backgroundrunning.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged;
import com.tencent.mm.plugin.appbrand.jsapi.i.t;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandBackgroundRunningMonitor {
    private static MMToClientEvent.c kYj;
    private static f.a kYk;
    private static IListener kYl = new IListener<com.tencent.mm.plugin.appbrand.jsapi.ag.c.a>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.AnonymousClass1 */

        {
            AppMethodBeat.i(226426);
            this.__eventId = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.class.getName().hashCode();
            AppMethodBeat.o(226426);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.plugin.appbrand.jsapi.ag.c.a aVar) {
            q TQ;
            s NY;
            AppMethodBeat.i(226427);
            com.tencent.mm.plugin.appbrand.jsapi.ag.c.a aVar2 = aVar;
            if (!(aVar2 == null || aVar2.mJH == null || (TQ = com.tencent.mm.plugin.appbrand.a.TQ(aVar2.mJH.appId)) == null || (NY = TQ.NY()) == null)) {
                AppBrandBackgroundRunningMonitor.b(NY, aVar2.mJH.dDe, aVar2.mJH.beL, AppBrandBackgroundRunningMonitor.a(TQ, aVar2.mJH.dDe, aVar2.mJH.beL));
            }
            AppMethodBeat.o(226427);
            return false;
        }
    };
    private static Set<String> kYm = new HashSet();

    static /* synthetic */ void am(String str, boolean z) {
        AppMethodBeat.i(226442);
        ak(str, z);
        AppMethodBeat.o(226442);
    }

    static /* synthetic */ void b(s sVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(226435);
        a(sVar, i2, i3, z);
        AppMethodBeat.o(226435);
    }

    static {
        AppMethodBeat.i(226443);
        AppMethodBeat.o(226443);
    }

    public static void a(q qVar, AppBrandAuthorizeUI.AuthStateChangedByUserEvent authStateChangedByUserEvent) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(226431);
        if (qVar != null) {
            com.tencent.mm.plugin.appbrand.jsapi.i.s sVar = (com.tencent.mm.plugin.appbrand.jsapi.i.s) qVar.aw(com.tencent.mm.plugin.appbrand.jsapi.i.s.class);
            if (!(sVar instanceof t)) {
                Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
                AppMethodBeat.o(226431);
                return;
            }
            t tVar = (t) sVar;
            boolean z3 = authStateChangedByUserEvent.nSk;
            boolean z4 = authStateChangedByUserEvent.nSl;
            if (tVar.lXu || z3) {
                z = false;
            } else {
                z = true;
            }
            if (!tVar.lXu || (z4 && z3)) {
                z2 = false;
            } else {
                z2 = true;
            }
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (z || z2) {
                tVar.bGK();
                tVar.X(qVar);
            }
            if (z2) {
                u(qVar);
            }
        }
        AppMethodBeat.o(226431);
    }

    public static void a(s sVar, int i2, int i3) {
        AppMethodBeat.i(44781);
        a(sVar, i2, i3, false);
        AppMethodBeat.o(44781);
    }

    private static void a(s sVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(226432);
        if (g.af(f.class) != null) {
            AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
            appBrandBackgroundRunningOperationParcel.appId = sVar.getAppId();
            appBrandBackgroundRunningOperationParcel.iOo = sVar.getRuntime().kAq.eix;
            appBrandBackgroundRunningOperationParcel.beL = i3;
            appBrandBackgroundRunningOperationParcel.dDe = i2;
            appBrandBackgroundRunningOperationParcel.kYe = sVar.getContext().getClass().getName();
            appBrandBackgroundRunningOperationParcel.process = MMApplicationContext.getProcessName();
            appBrandBackgroundRunningOperationParcel.kYo = z;
            if (i3 == c.AUDIO_OF_VIDEO_BACKGROUND_PLAY.beL) {
                appBrandBackgroundRunningOperationParcel.kYf = AppBrandAudioOfVideoBackgroundPlayNotificationLogic.class.getName();
            }
            if (!(!(sVar instanceof c) || sVar.getRuntime() == null || sVar.getRuntime().OU() == null)) {
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) sVar.getRuntime().OU();
                appBrandBackgroundRunningOperationParcel.name = appBrandInitConfigWC.brandName;
                appBrandBackgroundRunningOperationParcel.icon = appBrandInitConfigWC.iconUrl;
                appBrandBackgroundRunningOperationParcel.username = appBrandInitConfigWC.username;
            }
            ((f) g.af(f.class)).a(appBrandBackgroundRunningOperationParcel);
        }
        AppMethodBeat.o(226432);
    }

    public static void t(q qVar) {
        AppMethodBeat.i(226433);
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor");
        if (!kYm.add(qVar.mAppId)) {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, already start, return");
            AppMethodBeat.o(226433);
            return;
        }
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationReceivedIfNeed");
        if (kYk == null) {
            kYk = new f.a() {
                /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.f.a
                public final void b(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel) {
                    AppMethodBeat.i(226429);
                    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, operation:%s", mMBackgroundRunningOperationParcel);
                    q TQ = com.tencent.mm.plugin.appbrand.a.TQ(mMBackgroundRunningOperationParcel.appId);
                    if (TQ == null) {
                        Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onBackgroundRunningOperationReceived, runtime is null");
                        AppMethodBeat.o(226429);
                        return;
                    }
                    if (mMBackgroundRunningOperationParcel.dDe == 2) {
                        AppBrandBackgroundRunningMonitor.a(mMBackgroundRunningOperationParcel, TQ);
                        AppBrandBackgroundRunningMonitor.b(mMBackgroundRunningOperationParcel, TQ);
                        AppBrandBackgroundRunningMonitor.c(mMBackgroundRunningOperationParcel, TQ);
                        AppBrandBackgroundRunningMonitor.d(mMBackgroundRunningOperationParcel, TQ);
                    }
                    AppMethodBeat.o(226429);
                }
            };
            if (g.af(f.class) != null) {
                ((f) g.af(f.class)).a(kYk);
            }
        }
        String str = qVar.mAppId;
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startListeningOperationEvent, appId:%s", str);
        if (kYj == null) {
            kYj = new MMToClientEvent.c() {
                /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
                public final void cq(Object obj) {
                    AppMethodBeat.i(226430);
                    if (obj instanceof MMBackgroundRunningOperationParcel) {
                        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "app received data, operation:%s", (MMBackgroundRunningOperationParcel) obj);
                        if (g.af(f.class) != null) {
                            ((f) g.af(f.class)).a((MMBackgroundRunningOperationParcel) obj);
                        }
                    }
                    AppMethodBeat.o(226430);
                }
            };
        }
        MMToClientEvent.a(str, kYj);
        if (1 == kYm.size()) {
            Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "startRuntimeStateMonitor, first start, alive listener");
            kYl.alive();
        }
        qVar.kAH.a(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, b bVar) {
                q TQ;
                AppMethodBeat.i(226428);
                if (bVar == b.DESTROYED) {
                    Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "AppBrandRuntime state changed to destroyed");
                    if (g.af(f.class) != null) {
                        AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
                        appBrandBackgroundRunningOperationParcel.appId = str;
                        appBrandBackgroundRunningOperationParcel.beL = c.kYt.beL;
                        appBrandBackgroundRunningOperationParcel.dDe = 2;
                        if (!(com.tencent.mm.plugin.appbrand.a.TQ(str) == null || (TQ = com.tencent.mm.plugin.appbrand.a.TQ(str)) == null)) {
                            appBrandBackgroundRunningOperationParcel.iOo = TQ.kAq.eix;
                            if (AndroidContextUtil.castActivityOrNull(TQ.mContext) != null) {
                                appBrandBackgroundRunningOperationParcel.kYe = AndroidContextUtil.castActivityOrNull(TQ.mContext).getClass().getName();
                            }
                        }
                        ((f) g.af(f.class)).a(appBrandBackgroundRunningOperationParcel);
                    }
                    if (!AppBrandBackgroundRunningMonitor.kYm.remove(str)) {
                        Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, not start, return");
                        AppMethodBeat.o(226428);
                        return;
                    }
                    boolean isEmpty = AppBrandBackgroundRunningMonitor.kYm.isEmpty();
                    if (isEmpty) {
                        AppBrandBackgroundRunningMonitor.access$300();
                    }
                    AppBrandBackgroundRunningMonitor.al(str, isEmpty);
                    if (isEmpty) {
                        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "onRunningStateChanged, last stop, dead listener");
                        AppBrandBackgroundRunningMonitor.kYl.dead();
                    }
                }
                AppMethodBeat.o(226428);
            }
        });
        AppMethodBeat.o(226433);
    }

    private static void u(q qVar) {
        AppMethodBeat.i(44782);
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveLocationUsageOperation, runtime:%s", qVar.mAppId);
        if (g.af(f.class) != null) {
            AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
            appBrandBackgroundRunningOperationParcel.appId = qVar.mAppId;
            appBrandBackgroundRunningOperationParcel.iOo = qVar.kAq.eix;
            appBrandBackgroundRunningOperationParcel.beL = c.kYp.beL;
            appBrandBackgroundRunningOperationParcel.dDe = 2;
            if (AndroidContextUtil.castActivityOrNull(qVar.mContext) != null) {
                appBrandBackgroundRunningOperationParcel.kYe = AndroidContextUtil.castActivityOrNull(qVar.mContext).getClass().getName();
            }
            ((f) g.af(f.class)).a(appBrandBackgroundRunningOperationParcel);
        }
        WA(qVar.mAppId);
        AppMethodBeat.o(44782);
    }

    private static void WA(String str) {
        AppMethodBeat.i(44783);
        if (MMApplicationContext.isMMProcess()) {
            ak(str, false);
            AppMethodBeat.o(44783);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, new NotifyLocationBackgroundChanged(str), a.class, null);
        AppMethodBeat.o(44783);
    }

    private static void ak(String str, boolean z) {
        AppMethodBeat.i(44784);
        e.b(str, new EventLocationBackgroundStateChanged(z));
        AppMethodBeat.o(44784);
    }

    /* access modifiers changed from: package-private */
    public static class NotifyLocationBackgroundChanged implements Parcelable {
        public static final Parcelable.Creator<NotifyLocationBackgroundChanged> CREATOR = new Parcelable.Creator<NotifyLocationBackgroundChanged>() {
            /* class com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor.NotifyLocationBackgroundChanged.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ NotifyLocationBackgroundChanged[] newArray(int i2) {
                return new NotifyLocationBackgroundChanged[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NotifyLocationBackgroundChanged createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44777);
                NotifyLocationBackgroundChanged notifyLocationBackgroundChanged = new NotifyLocationBackgroundChanged(parcel);
                AppMethodBeat.o(44777);
                return notifyLocationBackgroundChanged;
            }
        };
        public String appId;
        public boolean kYn;

        public NotifyLocationBackgroundChanged(String str) {
            this.appId = str;
            this.kYn = false;
        }

        protected NotifyLocationBackgroundChanged(Parcel parcel) {
            AppMethodBeat.i(44778);
            this.appId = parcel.readString();
            this.kYn = parcel.readByte() != 0;
            AppMethodBeat.o(44778);
        }

        static {
            AppMethodBeat.i(44780);
            AppMethodBeat.o(44780);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44779);
            parcel.writeString(this.appId);
            parcel.writeByte((byte) (this.kYn ? 1 : 0));
            AppMethodBeat.o(44779);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements com.tencent.mm.ipcinvoker.b<NotifyLocationBackgroundChanged, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(NotifyLocationBackgroundChanged notifyLocationBackgroundChanged, d<IPCVoid> dVar) {
            AppMethodBeat.i(44776);
            NotifyLocationBackgroundChanged notifyLocationBackgroundChanged2 = notifyLocationBackgroundChanged;
            if (notifyLocationBackgroundChanged2 != null) {
                AppBrandBackgroundRunningMonitor.am(notifyLocationBackgroundChanged2.appId, notifyLocationBackgroundChanged2.kYn);
            }
            AppMethodBeat.o(44776);
        }
    }

    static /* synthetic */ boolean a(AppBrandRuntime appBrandRuntime, int i2, int i3) {
        AppMethodBeat.i(226434);
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "interceptBackgroundRunningOperationEvent4NotificationLogic, operation: %d, usage: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == c.AUDIO_OF_VIDEO_BACKGROUND_PLAY.beL && i2 == 2) {
            com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) appBrandRuntime.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
            if (aVar == null) {
                Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "interceptBackgroundRunningOperationEvent4NotificationLogic, audioOfVideoBackgroundPlayManager is null");
            } else if (aVar.bLS()) {
                Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "interceptBackgroundRunningOperationEvent4NotificationLogic, audioOfVideoBackgroundPlayManager isBackgroundAudioPlayPaused");
                AppMethodBeat.o(226434);
                return true;
            }
        }
        AppMethodBeat.o(226434);
        return false;
    }

    static /* synthetic */ void access$300() {
        AppMethodBeat.i(226436);
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "stopListeningOperationReceivedIfNeed");
        if (kYk != null) {
            if (g.af(f.class) != null) {
                ((f) g.af(f.class)).b(kYk);
            }
            kYk = null;
        }
        AppMethodBeat.o(226436);
    }

    static /* synthetic */ void al(String str, boolean z) {
        AppMethodBeat.i(226437);
        Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "stopListeningOperationEvent, appId:%s, lastStop: %b", str, Boolean.valueOf(z));
        if (kYj != null) {
            MMToClientEvent.b(str, kYj);
            if (z) {
                kYj = null;
            }
        }
        AppMethodBeat.o(226437);
    }

    static /* synthetic */ void a(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel, q qVar) {
        AppMethodBeat.i(226438);
        if (c.contains(mMBackgroundRunningOperationParcel.beL, c.kYp.beL)) {
            com.tencent.mm.plugin.appbrand.jsapi.i.s sVar = (com.tencent.mm.plugin.appbrand.jsapi.i.s) qVar.aw(com.tencent.mm.plugin.appbrand.jsapi.i.s.class);
            if (!(sVar instanceof t)) {
                Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "disableBackgroundLocationIfNeed, invalid location state manager");
                AppMethodBeat.o(226438);
                return;
            }
            t tVar = (t) sVar;
            if (tVar.lXu) {
                tVar.bGK();
                tVar.X(qVar);
                u(qVar);
                AppMethodBeat.o(226438);
                return;
            }
            Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "disableBackgroundLocationIfNeed, location state manager not in background mode");
        }
        AppMethodBeat.o(226438);
    }

    static /* synthetic */ void b(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel, q qVar) {
        AppMethodBeat.i(226439);
        if (c.contains(mMBackgroundRunningOperationParcel.beL, c.APPBRAND_VOIP.beL)) {
            com.tencent.mm.plugin.appbrand.jsapi.ag.c.e eVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.c.e) qVar.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.c.e.class);
            if (eVar == null || !eVar.bzd()) {
                Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "disableBackgroundVOIPIfNeed, voip state manager not running");
            } else {
                eVar.bCO();
                Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveVOIPUsageOperation, runtime:%s", qVar.mAppId);
                if (g.af(f.class) != null) {
                    AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
                    appBrandBackgroundRunningOperationParcel.appId = qVar.mAppId;
                    appBrandBackgroundRunningOperationParcel.iOo = qVar.kAq.eix;
                    appBrandBackgroundRunningOperationParcel.beL = c.APPBRAND_VOIP.beL;
                    appBrandBackgroundRunningOperationParcel.dDe = 2;
                    if (AndroidContextUtil.castActivityOrNull(qVar.mContext) != null) {
                        appBrandBackgroundRunningOperationParcel.kYe = AndroidContextUtil.castActivityOrNull(qVar.mContext).getClass().getName();
                    }
                    ((f) g.af(f.class)).a(appBrandBackgroundRunningOperationParcel);
                }
                if (qVar != null) {
                    qVar.kAH.kQM.a(d.a.ON_STOP_BACKGROUND_LIVE_VOIP);
                }
                AppMethodBeat.o(226439);
                return;
            }
        }
        AppMethodBeat.o(226439);
    }

    static /* synthetic */ void c(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel, q qVar) {
        AppMethodBeat.i(226440);
        if (c.contains(mMBackgroundRunningOperationParcel.beL, c.AUDIO_OF_VIDEO_BACKGROUND_PLAY.beL)) {
            com.tencent.mm.plugin.appbrand.jsapi.ag.a aVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.a) qVar.aw(com.tencent.mm.plugin.appbrand.jsapi.ag.a.class);
            if (aVar == null) {
                Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "disableBackgroundAudioPlayIfNeed, audioOfVideoBackgroundPlayManager not running");
            } else if (!aVar.bLS()) {
                aVar.bLV();
                Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveAudioOfVideoBackgroundPlayUsageOperation, runtime:%s", qVar.mAppId);
                if (g.af(f.class) != null) {
                    AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
                    appBrandBackgroundRunningOperationParcel.appId = qVar.mAppId;
                    appBrandBackgroundRunningOperationParcel.iOo = qVar.kAq.eix;
                    appBrandBackgroundRunningOperationParcel.beL = c.AUDIO_OF_VIDEO_BACKGROUND_PLAY.beL;
                    appBrandBackgroundRunningOperationParcel.dDe = 2;
                    if (AndroidContextUtil.castActivityOrNull(qVar.mContext) != null) {
                        appBrandBackgroundRunningOperationParcel.kYe = AndroidContextUtil.castActivityOrNull(qVar.mContext).getClass().getName();
                    }
                    ((f) g.af(f.class)).a(appBrandBackgroundRunningOperationParcel);
                }
                if (qVar != null) {
                    qVar.kAH.kQM.a(d.a.ON_STOP_AUDIO_BACKGROUND_PLAY);
                }
                AppMethodBeat.o(226440);
                return;
            } else {
                Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "disableBackgroundAudioPlayIfNeed, audioOfVideoBackgroundPlayManager isBackgroundAudioPlayPaused");
                AppMethodBeat.o(226440);
                return;
            }
        }
        AppMethodBeat.o(226440);
    }

    static /* synthetic */ void d(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel, q qVar) {
        AppMethodBeat.i(226441);
        if (c.contains(mMBackgroundRunningOperationParcel.beL, c.APPBRAND_VOIP_1v1.beL)) {
            k kVar = (k) qVar.aw(k.class);
            if (kVar == null || !kVar.bze()) {
                Log.w("MicroMsg.AppBrandBackgroundRunningMonitor", "disableBackgroundVoIP1v1IfNeed, voip 1v1 state manager not running");
            } else {
                kVar.bzf();
                Log.i("MicroMsg.AppBrandBackgroundRunningMonitor", "sendRemoveVoIP1v1UsageOperation, runtime:%s", qVar.mAppId);
                if (g.af(f.class) != null) {
                    AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
                    appBrandBackgroundRunningOperationParcel.appId = qVar.mAppId;
                    appBrandBackgroundRunningOperationParcel.iOo = qVar.kAq.eix;
                    appBrandBackgroundRunningOperationParcel.beL = c.APPBRAND_VOIP_1v1.beL;
                    appBrandBackgroundRunningOperationParcel.dDe = 2;
                    if (AndroidContextUtil.castActivityOrNull(qVar.mContext) != null) {
                        appBrandBackgroundRunningOperationParcel.kYe = AndroidContextUtil.castActivityOrNull(qVar.mContext).getClass().getName();
                    }
                    ((f) g.af(f.class)).a(appBrandBackgroundRunningOperationParcel);
                }
                if (qVar != null) {
                    qVar.kAH.kQM.a(d.a.ON_STOP_BACKGROUND_VOIP_1v1);
                }
                AppMethodBeat.o(226441);
                return;
            }
        }
        AppMethodBeat.o(226441);
    }
}
