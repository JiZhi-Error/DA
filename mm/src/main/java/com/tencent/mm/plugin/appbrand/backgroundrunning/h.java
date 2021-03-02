package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.NotificationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.ball.service.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class h implements b, g {
    private static NotificationManager kYH = null;
    private LinkedHashMap<String, AppBrandBackgroundRunningApp> kYB;
    private final HashSet<g.a> kYC = new HashSet<>();
    private PhoneStatusWatcher kYD;
    private PhoneStatusWatcher.PhoneCallListener kYE = new PhoneStatusWatcher.PhoneCallListener() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.h.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener
        public final void onPhoneCall(int i2) {
            AppMethodBeat.i(226452);
            switch (i2) {
                case 0:
                    AppMethodBeat.o(226452);
                    return;
                case 1:
                case 2:
                    Log.i("MicroMsg.MMBackgroundRunningManagerService", "onPhoneCall, kill voip, state:%s", Integer.valueOf(i2));
                    h.this.bza();
                    h.this.bzb();
                    break;
            }
            AppMethodBeat.o(226452);
        }
    };
    private final AppBrandMainProcessService.a kYF = new AppBrandMainProcessService.a() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.h.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a
        public final void Uf(String str) {
            AppMethodBeat.i(226453);
            super.Uf(str);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "onConnected, process:%s", str);
            AppMethodBeat.o(226453);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a
        public final void onDisconnected(String str) {
            AppMethodBeat.i(226454);
            super.onDisconnected(str);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "onDisconnected, process:%s", str);
            AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel = new AppBrandBackgroundRunningOperationParcel();
            appBrandBackgroundRunningOperationParcel.process = str;
            appBrandBackgroundRunningOperationParcel.dDe = 3;
            h.this.c(appBrandBackgroundRunningOperationParcel);
            AppMethodBeat.o(226454);
        }
    };
    private IListener<zj> kYG = new IListener<zj>() {
        /* class com.tencent.mm.plugin.appbrand.backgroundrunning.h.AnonymousClass3 */

        {
            AppMethodBeat.i(226455);
            this.__eventId = zj.class.getName().hashCode();
            AppMethodBeat.o(226455);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(226456);
            zj zjVar2 = zjVar;
            if (zjVar2 != null) {
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "receive VoipEvent:[%s, %s]", Integer.valueOf(zjVar2.efx.eft), Integer.valueOf(zjVar2.efx.dKy));
                if (zjVar2.efx.dKy == 7 || zjVar2.efx.dKy == 3) {
                    h.this.bza();
                    h.this.bzb();
                }
            }
            AppMethodBeat.o(226456);
            return false;
        }
    };

    public h() {
        AppMethodBeat.i(44795);
        AppMethodBeat.o(44795);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g
    public final void bza() {
        AppMethodBeat.i(226457);
        for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : byZ()) {
            MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
            mMBackgroundRunningOperationParcel.appId = appBrandBackgroundRunningApp.appId;
            mMBackgroundRunningOperationParcel.beL = c.dQ(c.APPBRAND_VOIP.beL, c.APPBRAND_VOIP_1v1.beL);
            mMBackgroundRunningOperationParcel.dDe = 2;
            c(mMBackgroundRunningOperationParcel);
        }
        AppMethodBeat.o(226457);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g
    public final void bzb() {
        AppMethodBeat.i(226458);
        for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : byZ()) {
            MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel = new MMBackgroundRunningOperationParcel();
            mMBackgroundRunningOperationParcel.appId = appBrandBackgroundRunningApp.appId;
            mMBackgroundRunningOperationParcel.beL = c.AUDIO_OF_VIDEO_BACKGROUND_PLAY.beL;
            mMBackgroundRunningOperationParcel.dDe = 2;
            c(mMBackgroundRunningOperationParcel);
        }
        AppMethodBeat.o(226458);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(44796);
        Log.i("MicroMsg.MMBackgroundRunningManagerService", "onRegister MMBackgroundRunningManagerService");
        this.kYD = new PhoneStatusWatcher();
        this.kYD.begin(MMApplicationContext.getContext());
        this.kYD.addPhoneCallListener(this.kYE);
        this.kYB = new LinkedHashMap<>();
        Log.i("MicroMsg.AppBrandForegroundNotificationManager", "startListening");
        if (e.kYz == null) {
            e.kYz = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: SPUT  
                  (wrap: com.tencent.mm.plugin.appbrand.backgroundrunning.e$1 : 0x003c: CONSTRUCTOR  (r0v15 com.tencent.mm.plugin.appbrand.backgroundrunning.e$1) =  call: com.tencent.mm.plugin.appbrand.backgroundrunning.e.1.<init>():void type: CONSTRUCTOR)
                 com.tencent.mm.plugin.appbrand.backgroundrunning.e.kYz com.tencent.mm.plugin.appbrand.backgroundrunning.g$a in method: com.tencent.mm.plugin.appbrand.backgroundrunning.h.aBc():void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003c: CONSTRUCTOR  (r0v15 com.tencent.mm.plugin.appbrand.backgroundrunning.e$1) =  call: com.tencent.mm.plugin.appbrand.backgroundrunning.e.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.backgroundrunning.h.aBc():void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:439)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.backgroundrunning.e, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 23 more
                */
            /*
            // Method dump skipped, instructions count: 107
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.backgroundrunning.h.aBc():void");
        }

        @Override // com.tencent.mm.kernel.c.b
        public final void aBd() {
            AppMethodBeat.i(44797);
            Log.i("MicroMsg.MMBackgroundRunningManagerService", "onUnregister MMBackgroundRunningManagerService");
            bza();
            this.kYD.removePhoneCallListener(this.kYE);
            this.kYD.end();
            Log.i("MicroMsg.AppBrandForegroundNotificationManager", "stopListening");
            if (e.kYz != null) {
                if (com.tencent.mm.kernel.g.af(g.class) != null) {
                    ((g) com.tencent.mm.kernel.g.af(g.class)).b(e.kYz);
                }
                e.kYz = null;
            }
            AppBrandMainProcessService.b(this.kYF);
            b(d.ciB());
            this.kYG.dead();
            this.kYC.clear();
            this.kYB.clear();
            this.kYB = null;
            AppMethodBeat.o(44797);
        }

        private static void c(MMBackgroundRunningOperationParcel mMBackgroundRunningOperationParcel) {
            AppMethodBeat.i(226459);
            if (!Util.isNullOrNil(mMBackgroundRunningOperationParcel.appId)) {
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "sendOperation from MM process, operation:%s", mMBackgroundRunningOperationParcel);
                e.b(mMBackgroundRunningOperationParcel.appId, mMBackgroundRunningOperationParcel);
            }
            AppMethodBeat.o(226459);
        }

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g
        public final void c(AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel) {
            String sb;
            int i2;
            int i3 = 0;
            AppMethodBeat.i(44798);
            if (appBrandBackgroundRunningOperationParcel != null) {
                Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation in MM process, operation:%s", appBrandBackgroundRunningOperationParcel);
                if (Util.isNullOrNil(appBrandBackgroundRunningOperationParcel.kYe) || !appBrandBackgroundRunningOperationParcel.kYe.endsWith(AppBrandPluginUI.class.getSimpleName())) {
                    if (appBrandBackgroundRunningOperationParcel.dDe == 3) {
                        String str = appBrandBackgroundRunningOperationParcel.process;
                        if (!Util.isNullOrNil(str)) {
                            int i4 = 0;
                            for (Map.Entry<String, AppBrandBackgroundRunningApp> entry : this.kYB.entrySet()) {
                                AppBrandBackgroundRunningApp value = entry.getValue();
                                if (str.equalsIgnoreCase(value.process)) {
                                    if (Util.isNullOrNil(appBrandBackgroundRunningOperationParcel.kYe)) {
                                        appBrandBackgroundRunningOperationParcel.kYe = value.kYe;
                                    }
                                    appBrandBackgroundRunningOperationParcel.beL |= value.beL;
                                    appBrandBackgroundRunningOperationParcel.appId = value.appId;
                                    appBrandBackgroundRunningOperationParcel.iOo = value.iOo;
                                    this.kYB.remove(value.appId);
                                    Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill process:%s, app:%s", str, value.appId);
                                    if (!Util.isNullOrNil(value.kYf)) {
                                        Class<? extends CustomBackgroundRunningNotificationLogic> WB = d.WB(value.kYf);
                                        if (WB == null) {
                                            Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogicClass is null", value.appId);
                                            i4 = 3;
                                        } else {
                                            q TQ = a.TQ(value.appId);
                                            if (TQ == null) {
                                                Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, runtime is null", value.appId);
                                                i4 = 3;
                                            } else {
                                                CustomBackgroundRunningNotificationLogic customBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic) TQ.aw(WB);
                                                if (customBackgroundRunningNotificationLogic == null) {
                                                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "cancelCustomNotificationFallback for %s, customNotificationLogic is null", value.appId);
                                                    i4 = 3;
                                                } else {
                                                    if (kYH == null) {
                                                        kYH = (NotificationManager) MMApplicationContext.getContext().getSystemService("notification");
                                                    }
                                                    kYH.cancel(customBackgroundRunningNotificationLogic.getNotificationId());
                                                }
                                            }
                                        }
                                    }
                                    i2 = 3;
                                } else {
                                    i2 = i4;
                                }
                                i4 = i2;
                            }
                            i3 = i4;
                        } else {
                            Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, operation kill, no process");
                        }
                    } else {
                        AppBrandBackgroundRunningApp appBrandBackgroundRunningApp = this.kYB.get(appBrandBackgroundRunningOperationParcel.appId);
                        if (appBrandBackgroundRunningApp != null) {
                            if (appBrandBackgroundRunningOperationParcel.dDe == 1) {
                                if (!c.contains(appBrandBackgroundRunningApp.beL, appBrandBackgroundRunningOperationParcel.beL)) {
                                    appBrandBackgroundRunningApp.beL = c.dQ(appBrandBackgroundRunningApp.beL, appBrandBackgroundRunningOperationParcel.beL);
                                    Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) add new usage(%s)", appBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(appBrandBackgroundRunningOperationParcel.beL));
                                    i3 = 2;
                                } else {
                                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to add a same usage!!!");
                                }
                            } else if (appBrandBackgroundRunningOperationParcel.dDe == 2) {
                                if (c.contains(appBrandBackgroundRunningApp.beL, appBrandBackgroundRunningOperationParcel.beL)) {
                                    appBrandBackgroundRunningOperationParcel.iOo = appBrandBackgroundRunningApp.iOo;
                                    appBrandBackgroundRunningApp.beL = c.dR(appBrandBackgroundRunningApp.beL, appBrandBackgroundRunningOperationParcel.beL);
                                    Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) remove usage(%s)", appBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(appBrandBackgroundRunningOperationParcel.beL));
                                    if (appBrandBackgroundRunningApp.beL == 0) {
                                        if (Util.isNullOrNil(appBrandBackgroundRunningOperationParcel.kYe)) {
                                            appBrandBackgroundRunningOperationParcel.kYe = appBrandBackgroundRunningApp.kYe;
                                        }
                                        this.kYB.remove(appBrandBackgroundRunningOperationParcel.appId);
                                        Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, app(%s) has been removed", appBrandBackgroundRunningOperationParcel.appId);
                                        i3 = 3;
                                    } else {
                                        i3 = 4;
                                    }
                                } else {
                                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has been added before, but now it wants to remove not added usage!!!");
                                }
                            }
                        } else if (appBrandBackgroundRunningOperationParcel.dDe == 1) {
                            AppBrandBackgroundRunningApp appBrandBackgroundRunningApp2 = new AppBrandBackgroundRunningApp();
                            appBrandBackgroundRunningApp2.appId = appBrandBackgroundRunningOperationParcel.appId;
                            appBrandBackgroundRunningApp2.iOo = appBrandBackgroundRunningOperationParcel.iOo;
                            appBrandBackgroundRunningApp2.beL = appBrandBackgroundRunningOperationParcel.beL;
                            appBrandBackgroundRunningApp2.name = appBrandBackgroundRunningOperationParcel.name;
                            appBrandBackgroundRunningApp2.icon = appBrandBackgroundRunningOperationParcel.icon;
                            appBrandBackgroundRunningApp2.username = appBrandBackgroundRunningOperationParcel.username;
                            appBrandBackgroundRunningApp2.kYe = appBrandBackgroundRunningOperationParcel.kYe;
                            appBrandBackgroundRunningApp2.process = appBrandBackgroundRunningOperationParcel.process;
                            appBrandBackgroundRunningApp2.kYf = appBrandBackgroundRunningOperationParcel.kYf;
                            this.kYB.put(appBrandBackgroundRunningApp2.appId, appBrandBackgroundRunningApp2);
                            Log.i("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, add app(%s) with usage(%s)", appBrandBackgroundRunningOperationParcel.appId, Integer.valueOf(appBrandBackgroundRunningOperationParcel.beL));
                            i3 = 1;
                        } else if (appBrandBackgroundRunningOperationParcel.dDe == 2) {
                            Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, this app has not been added before, but now it wants to remove some usage!!!");
                        }
                    }
                    if (i3 != 0) {
                        synchronized (this.kYC) {
                            try {
                                List<AppBrandBackgroundRunningApp> byZ = byZ();
                                Iterator<g.a> it = this.kYC.iterator();
                                while (it.hasNext()) {
                                    it.next().a(byZ, appBrandBackgroundRunningOperationParcel, i3);
                                }
                                if (byZ.isEmpty()) {
                                    sb = null;
                                } else {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(String.valueOf(byZ.size())).append("|");
                                    Iterator<AppBrandBackgroundRunningApp> it2 = byZ.iterator();
                                    sb2.append(it2.next().appId);
                                    while (it2.hasNext()) {
                                        sb2.append("#").append(it2.next().appId);
                                    }
                                    sb = sb2.toString();
                                }
                                Log.i("MicroMsg.MMBackgroundRunningManagerService", "report background running app list changed, note:%s", sb);
                                b.a(null, 0, System.currentTimeMillis(), 6, sb);
                            } finally {
                                AppMethodBeat.o(44798);
                            }
                        }
                        return;
                    }
                } else {
                    Log.w("MicroMsg.MMBackgroundRunningManagerService", "receiveOperation, ignore fake native mini program");
                    AppMethodBeat.o(44798);
                    return;
                }
            }
            AppMethodBeat.o(44798);
        }

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g
        public final List<AppBrandBackgroundRunningApp> byZ() {
            AppMethodBeat.i(44799);
            ArrayList arrayList = new ArrayList(this.kYB.values());
            AppMethodBeat.o(44799);
            return arrayList;
        }

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g
        public final void a(g.a aVar) {
            AppMethodBeat.i(44800);
            if (aVar == null) {
                AppMethodBeat.o(44800);
                return;
            }
            synchronized (this.kYC) {
                try {
                    this.kYC.add(aVar);
                } finally {
                    AppMethodBeat.o(44800);
                }
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g
        public final void b(g.a aVar) {
            AppMethodBeat.i(44801);
            if (aVar == null) {
                AppMethodBeat.o(44801);
                return;
            }
            synchronized (this.kYC) {
                try {
                    this.kYC.remove(aVar);
                } finally {
                    AppMethodBeat.o(44801);
                }
            }
        }
    }
