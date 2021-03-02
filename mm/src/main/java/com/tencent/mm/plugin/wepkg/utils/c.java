package com.tencent.mm.plugin.wepkg.utils;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.model.k;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.HashSet;

public final class c {
    public IListener JOf = new IListener<tu>() {
        /* class com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass2 */

        {
            AppMethodBeat.i(161764);
            this.__eventId = tu.class.getName().hashCode();
            AppMethodBeat.o(161764);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tu tuVar) {
            AppMethodBeat.i(110789);
            boolean a2 = a(tuVar);
            AppMethodBeat.o(110789);
            return a2;
        }

        private boolean a(tu tuVar) {
            AppMethodBeat.i(110788);
            boolean z = tuVar.eao.dOs;
            Log.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", Boolean.valueOf(z));
            if (z && Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_WEPKG_ENTRANCE_TRIGGER_DOWNLOAD_TIME_LONG, (Object) 0L))) > 60) {
                g.aAh().azQ().set(ar.a.USERINFO_WEPKG_ENTRANCE_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(Util.nowSecond()));
                c.a(c.this, 2);
            }
            AppMethodBeat.o(110788);
            return false;
        }
    };
    public final IListener JOg = new IListener<aaz>() {
        /* class com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass3 */

        {
            AppMethodBeat.i(161765);
            this.__eventId = aaz.class.getName().hashCode();
            AppMethodBeat.o(161765);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaz aaz) {
            AppMethodBeat.i(110792);
            boolean a2 = a(aaz);
            AppMethodBeat.o(110792);
            return a2;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private boolean a(aaz aaz) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(110791);
            boolean dSV = com.tencent.mm.plugin.game.commlib.a.dSV();
            Log.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", Integer.valueOf(aaz.eif.dDe));
            switch (aaz.eif.dDe) {
                case 0:
                    if (!dSV) {
                        com.tencent.mm.plugin.game.commlib.c.a.dTf().a("wepkg_download_retry", new a.AbstractC1395a() {
                            /* class com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
                            public final void cBm() {
                                AppMethodBeat.i(200177);
                                d.cyh().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(200176);
                                        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                        wepkgCrossProcessTask.EX = 2003;
                                        if (MMApplicationContext.isMMProcess()) {
                                            wepkgCrossProcessTask.bjj();
                                        } else {
                                            AppBrandMainProcessService.b(wepkgCrossProcessTask);
                                        }
                                        WepkgVersion wepkgVersion = wepkgCrossProcessTask.JNh;
                                        if (wepkgVersion != null && !Util.isNullOrNil(wepkgVersion.hhD)) {
                                            k.gkU().cW(wepkgVersion.hhD, true);
                                        }
                                        AppMethodBeat.o(200176);
                                    }
                                });
                                AppMethodBeat.o(200177);
                            }
                        });
                        AppMethodBeat.o(110791);
                        break;
                    } else {
                        AppMethodBeat.o(110791);
                        break;
                    }
                case 1:
                    if (!dSV) {
                        String str = aaz.eif.eig;
                        int i2 = aaz.eif.eij;
                        int i3 = aaz.eif.eik;
                        HashSet hashSet = new HashSet();
                        if (!Util.isNullOrNil(str)) {
                            if (i3 == 0) {
                                hashSet.add(str);
                            } else if (i3 == 1 && j.bcH(str) != null) {
                                hashSet.add(str);
                            }
                        }
                        WepkgVersionUpdater.a(hashSet, 1, i2, false);
                        AppMethodBeat.o(110791);
                        break;
                    } else {
                        AppMethodBeat.o(110791);
                        break;
                    }
                case 2:
                    if (!dSV) {
                        aaz.a aVar = aaz.eif;
                        f gkF = f.gkF();
                        String str2 = aaz.eif.eig;
                        if (!gkF.lsb || Util.isNullOrNil(str2)) {
                            z2 = false;
                        } else {
                            e bcm = gkF.bcm(str2);
                            if (bcm == null || !bcm.field_bigPackageReady || !bcm.field_preloadFilesReady) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        }
                        aVar.eih = z2;
                        AppMethodBeat.o(110791);
                        break;
                    } else {
                        AppMethodBeat.o(110791);
                        break;
                    }
                    break;
                case 3:
                    if (MMApplicationContext.isMMProcess()) {
                        com.tencent.mm.plugin.wepkg.model.c.gkN().gkO();
                    }
                    AppMethodBeat.o(110791);
                    break;
                case 4:
                    if (!dSV) {
                        WepkgVersion bcI = j.bcI(aaz.eif.eig);
                        if (bcI != null) {
                            aaz.eif.eii = bcI.JNY;
                            Log.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", Integer.valueOf(aaz.eif.eii));
                        }
                        AppMethodBeat.o(110791);
                        break;
                    } else {
                        AppMethodBeat.o(110791);
                        break;
                    }
                case 5:
                    if (!dSV) {
                        if (Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_WEPKG_FRONT_TRIGGER_DOWNLOAD_TIME_LONG, (Object) 0L))) > 60) {
                            g.aAh().azQ().set(ar.a.USERINFO_WEPKG_FRONT_TRIGGER_DOWNLOAD_TIME_LONG, Long.valueOf(Util.nowSecond()));
                            z = c.a(c.this, 1);
                        } else {
                            z = false;
                        }
                        if (!z && Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, (Object) 0L))) > 1800) {
                            g.aAh().azQ().set(ar.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(Util.nowSecond()));
                            aaz aaz2 = new aaz();
                            aaz2.eif.dDe = 0;
                            EventCenter.instance.publish(aaz2);
                        }
                        AppMethodBeat.o(110791);
                        break;
                    } else {
                        AppMethodBeat.o(110791);
                        break;
                    }
                case 6:
                    if (Util.isNullOrNil(aaz.eif.eig)) {
                        com.tencent.mm.plugin.wepkg.model.c gkN = com.tencent.mm.plugin.wepkg.model.c.gkN();
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            d.cyh().postToWorker(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0195: INVOKE  
                                  (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x018c: INVOKE  (r1v6 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.wepkg.utils.d.cyh():com.tencent.mm.sdk.platformtools.MMHandler)
                                  (wrap: com.tencent.mm.plugin.wepkg.model.c$2 : 0x0192: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.wepkg.model.c$2) = (r0v10 'gkN' com.tencent.mm.plugin.wepkg.model.c) call: com.tencent.mm.plugin.wepkg.model.c.2.<init>(com.tencent.mm.plugin.wepkg.model.c):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.wepkg.utils.c.3.a(com.tencent.mm.g.a.aaz):boolean, file: classes6.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0192: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.wepkg.model.c$2) = (r0v10 'gkN' com.tencent.mm.plugin.wepkg.model.c) call: com.tencent.mm.plugin.wepkg.model.c.2.<init>(com.tencent.mm.plugin.wepkg.model.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wepkg.utils.c.3.a(com.tencent.mm.g.a.aaz):boolean, file: classes6.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 29 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wepkg.model.c, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 35 more
                                */
                            /*
                            // Method dump skipped, instructions count: 500
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass3.a(com.tencent.mm.g.a.aaz):boolean");
                        }
                    };
                    public o.a appForegroundListener = new o.a() {
                        /* class com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass1 */

                        @Override // com.tencent.mm.app.o
                        public final void onAppForeground(String str) {
                            AppMethodBeat.i(110786);
                            if (g.aAc() && g.aAf().hpY) {
                                g.aAf();
                                if (!com.tencent.mm.kernel.a.azj()) {
                                    aaz aaz = new aaz();
                                    aaz.eif.dDe = 5;
                                    EventCenter.instance.publish(aaz);
                                }
                            }
                            AppMethodBeat.o(110786);
                        }

                        @Override // com.tencent.mm.app.o
                        public final void onAppBackground(String str) {
                            AppMethodBeat.i(110787);
                            if (g.aAc() && g.aAf().hpY) {
                                g.aAf();
                                if (!com.tencent.mm.kernel.a.azj()) {
                                    aaz aaz = new aaz();
                                    aaz.eif.dDe = 3;
                                    EventCenter.instance.publish(aaz);
                                }
                            }
                            AppMethodBeat.o(110787);
                        }
                    };

                    public c() {
                        AppMethodBeat.i(110795);
                        AppMethodBeat.o(110795);
                    }

                    /* access modifiers changed from: package-private */
                    public static class a implements b {
                        private a() {
                        }

                        @Override // com.tencent.mm.ipcinvoker.b
                        public void invoke(Object obj, d dVar) {
                            AppMethodBeat.i(110794);
                            com.tencent.mm.plugin.wepkg.d.gku();
                            AppMethodBeat.o(110794);
                        }
                    }

                    static /* synthetic */ boolean a(c cVar, int i2) {
                        HashSet hashSet;
                        AppMethodBeat.i(110796);
                        if (!com.tencent.mm.plugin.game.commlib.a.dSV()) {
                            Log.i("MicroMsg.Wepkg.WepkgListener", "triggerDownload downloadTriggerType:%d", Integer.valueOf(i2));
                            f gkF = f.gkF();
                            if (!gkF.lsb) {
                                hashSet = null;
                            } else if (i2 == -1) {
                                hashSet = null;
                            } else {
                                hashSet = new HashSet();
                                Cursor rawQuery = gkF.rawQuery(String.format("select distinct %s from %s where %s=?", "pkgId", "WepkgVersion", "downloadTriggerType"), String.valueOf(i2));
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        do {
                                            String string = rawQuery.getString(0);
                                            if (!Util.isNullOrNil(string)) {
                                                hashSet.add(string);
                                            }
                                        } while (rawQuery.moveToNext());
                                    }
                                    rawQuery.close();
                                }
                                HashSet hashSet2 = new HashSet();
                                Cursor rawQuery2 = gkF.rawQuery(String.format("select distinct %s from %s where (%s=0 or %s=0) and %s=? and %s<?", "pkgId", "WepkgVersion", "bigPackageReady", "preloadFilesReady", "downloadTriggerType", "packageDownloadCount"), String.valueOf(i2), "1");
                                if (rawQuery2 != null) {
                                    if (rawQuery2.moveToFirst()) {
                                        do {
                                            String string2 = rawQuery2.getString(0);
                                            if (!Util.isNullOrNil(string2)) {
                                                hashSet2.add(string2);
                                            }
                                        } while (rawQuery2.moveToNext());
                                    }
                                    rawQuery2.close();
                                }
                                HashSet hashSet3 = new HashSet();
                                Cursor rawQuery3 = gkF.rawQuery(String.format("select distinct %s from %s where %s=0 and %s<?", "pkgId", "WepkgPreloadFiles", "completeDownload", "fileDownloadCount"), "1");
                                if (rawQuery3 != null) {
                                    if (rawQuery3.moveToFirst()) {
                                        do {
                                            String string3 = rawQuery3.getString(0);
                                            if (!Util.isNullOrNil(string3)) {
                                                hashSet3.add(string3);
                                            }
                                        } while (rawQuery3.moveToNext());
                                    }
                                    rawQuery3.close();
                                }
                                hashSet2.addAll(hashSet3);
                                hashSet.retainAll(hashSet2);
                                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "trigger Predownload size:%d, List:%s", Integer.valueOf(hashSet.size()), hashSet.toString());
                            }
                            if (!(hashSet == null || hashSet.size() == 0)) {
                                final ArrayList arrayList = new ArrayList(hashSet);
                                d.cyh().postToWorker(new Runnable() {
                                    /* class com.tencent.mm.plugin.wepkg.utils.c.AnonymousClass4 */

                                    public final void run() {
                                        AppMethodBeat.i(110793);
                                        int i2 = 0;
                                        while (i2 < arrayList.size() && i2 < 5) {
                                            k.gkU().cW((String) arrayList.get(i2), false);
                                            i2++;
                                        }
                                        AppMethodBeat.o(110793);
                                    }
                                });
                                AppMethodBeat.o(110796);
                                return true;
                            }
                        }
                        AppMethodBeat.o(110796);
                        return false;
                    }
                }
