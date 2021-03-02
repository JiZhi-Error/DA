package com.tencent.mm.plugin.expt.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.plugin.expt.ui.KvInfoUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.b.g;

public final class a implements Application.ActivityLifecycleCallbacks, c, com.tencent.mm.plugin.expt.b.a {
    private static a sJN;
    private IListener<ln> kvQ = new IListener<ln>() {
        /* class com.tencent.mm.plugin.expt.e.a.AnonymousClass2 */

        {
            AppMethodBeat.i(220603);
            this.__eventId = ln.class.getName().hashCode();
            AppMethodBeat.o(220603);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ln lnVar) {
            AppMethodBeat.i(220604);
            ln lnVar2 = lnVar;
            if (!MMApplicationContext.isMainProcess()) {
                AppMethodBeat.o(220604);
            } else if (lnVar2 == null || lnVar2.dQQ == null) {
                AppMethodBeat.o(220604);
            } else {
                com.tencent.mm.plugin.expt.d.d.a aVar = com.tencent.mm.plugin.expt.d.a.cMI().sxs;
                String str = lnVar2.dQQ.content;
                int i2 = (int) lnVar2.dQQ.dQR;
                if (b.cML()) {
                    if (i2 <= 0 || g.eP(str)) {
                        Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendKV data or reportID isEmpty!");
                    } else {
                        aVar.sxy.execute(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006c: INVOKE  
                              (wrap: java.util.concurrent.ThreadPoolExecutor : 0x0065: IGET  (r0v11 java.util.concurrent.ThreadPoolExecutor) = (r2v0 'aVar' com.tencent.mm.plugin.expt.d.d.a) com.tencent.mm.plugin.expt.d.d.a.sxy java.util.concurrent.ThreadPoolExecutor)
                              (wrap: com.tencent.mm.plugin.expt.d.d.a$1 : 0x0069: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.expt.d.d.a$1) = 
                              (r2v0 'aVar' com.tencent.mm.plugin.expt.d.d.a)
                              (r3v0 'i2' int)
                              (wrap: long : 0x0061: INVOKE  (r4v0 long) =  type: STATIC call: java.lang.System.currentTimeMillis():long)
                              (r6v0 'str' java.lang.String)
                             call: com.tencent.mm.plugin.expt.d.d.a.1.<init>(com.tencent.mm.plugin.expt.d.d.a, int, long, java.lang.String):void type: CONSTRUCTOR)
                             type: VIRTUAL call: java.util.concurrent.ThreadPoolExecutor.execute(java.lang.Runnable):void in method: com.tencent.mm.plugin.expt.e.a.2.callback(com.tencent.mm.g.a.ln):boolean, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.expt.d.d.a$1) = 
                              (r2v0 'aVar' com.tencent.mm.plugin.expt.d.d.a)
                              (r3v0 'i2' int)
                              (wrap: long : 0x0061: INVOKE  (r4v0 long) =  type: STATIC call: java.lang.System.currentTimeMillis():long)
                              (r6v0 'str' java.lang.String)
                             call: com.tencent.mm.plugin.expt.d.d.a.1.<init>(com.tencent.mm.plugin.expt.d.d.a, int, long, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.expt.e.a.2.callback(com.tencent.mm.g.a.ln):boolean, file: classes7.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 31 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.expt.d.d.a, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 37 more
                            */
                        /*
                        // Method dump skipped, instructions count: 112
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.e.a.AnonymousClass2.callback(com.tencent.mm.sdk.event.IEvent):boolean");
                    }
                };
                private IListener oVk = new IListener<ak>() {
                    /* class com.tencent.mm.plugin.expt.e.a.AnonymousClass1 */

                    {
                        AppMethodBeat.i(220601);
                        this.__eventId = ak.class.getName().hashCode();
                        AppMethodBeat.o(220601);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ak akVar) {
                        AppMethodBeat.i(220602);
                        Log.i("MicroMsg.ExptReportService", "%d banner on init ", Integer.valueOf(a.this.hashCode()));
                        al alVar = new al();
                        alVar.dDm.dDn = new com.tencent.mm.plugin.expt.ui.a(akVar.dDl.activity);
                        EventCenter.instance.publish(alVar);
                        AppMethodBeat.o(220602);
                        return false;
                    }
                };
                public String sJO;
                public boolean sJP = false;
                public HashMap<String, List<b>> sJQ = new HashMap<>();

                public a() {
                    AppMethodBeat.i(220605);
                    AppMethodBeat.o(220605);
                }

                public static a cRf() {
                    AppMethodBeat.i(220606);
                    if (sJN == null) {
                        sJN = new a();
                    }
                    a aVar = sJN;
                    AppMethodBeat.o(220606);
                    return aVar;
                }

                public final boolean cRg() {
                    AppMethodBeat.i(220607);
                    if (!Util.isNullOrNil(this.sJO)) {
                        AppMethodBeat.o(220607);
                        return true;
                    }
                    AppMethodBeat.o(220607);
                    return false;
                }

                @Override // com.tencent.mm.kernel.api.c
                public final void onAccountRelease() {
                    AppMethodBeat.i(220609);
                    cMC();
                    EventCenter.instance.removeListener(this.kvQ);
                    EventCenter.instance.removeListener(this.oVk);
                    if (this.sJQ != null) {
                        this.sJQ.clear();
                    }
                    this.sJP = false;
                    AppMethodBeat.o(220609);
                }

                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public final void onActivityStarted(Activity activity) {
                }

                public final void onActivityResumed(Activity activity) {
                    AppMethodBeat.i(220610);
                    String className = activity.getComponentName().getClassName();
                    if (MMApplicationContext.isMMProcess() && cRg()) {
                        c cVar = new c();
                        cVar.content = className;
                        cVar.type = 10002;
                        cVar.key = 1;
                        com.tencent.mm.kernel.g.azz().a(cVar, 0);
                    }
                    AppMethodBeat.o(220610);
                }

                public final void onActivityPaused(Activity activity) {
                    AppMethodBeat.i(220611);
                    String className = activity.getComponentName().getClassName();
                    if (MMApplicationContext.isMMProcess() && cRg()) {
                        c cVar = new c();
                        cVar.content = className;
                        cVar.type = 10002;
                        cVar.key = 2;
                        com.tencent.mm.kernel.g.azz().a(cVar, 0);
                    }
                    AppMethodBeat.o(220611);
                }

                public final void onActivityStopped(Activity activity) {
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public final void onActivityDestroyed(Activity activity) {
                }

                private void cRh() {
                    AppMethodBeat.i(220612);
                    Log.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", Integer.valueOf(hashCode()), this.sJO);
                    if (MMApplicationContext.isMMProcess() && !Util.isNullOrNil(this.sJO)) {
                        c cVar = new c();
                        cVar.content = this.sJO;
                        cVar.type = 10000;
                        cVar.key = 2;
                        com.tencent.mm.kernel.g.azz().a(cVar, 0);
                    }
                    this.sJO = null;
                    AppMethodBeat.o(220612);
                }

                @Override // com.tencent.mm.plugin.expt.b.a
                public final void aod(String str) {
                    AppMethodBeat.i(220613);
                    long currentTicks = Util.currentTicks();
                    if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || WeChatEnvironment.hasDebugger()) && !Util.isNullOrNil(str) && str.startsWith(":exptdebug/")) {
                        String substring = str.substring(11);
                        Log.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", Integer.valueOf(hashCode()), substring);
                        this.sJO = substring;
                        if (MMApplicationContext.isMMProcess()) {
                            c cVar = new c();
                            cVar.content = substring;
                            cVar.type = 10000;
                            cVar.key = 1;
                            com.tencent.mm.kernel.g.azz().a(cVar, 0);
                        }
                        wt wtVar = new wt();
                        wtVar.edh.edi = substring;
                        EventCenter.instance.publish(wtVar);
                        this.sJP = true;
                    }
                    Log.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", Long.valueOf(Util.ticksToNow(currentTicks)));
                    AppMethodBeat.o(220613);
                }

                @Override // com.tencent.mm.plugin.expt.b.a
                public final void cMC() {
                    AppMethodBeat.i(220614);
                    cRh();
                    wt wtVar = new wt();
                    wtVar.edh.edi = "";
                    EventCenter.instance.publish(wtVar);
                    AppMethodBeat.o(220614);
                }

                @Override // com.tencent.mm.plugin.expt.b.a
                public final void r(Context context, Intent intent) {
                    AppMethodBeat.i(220615);
                    intent.setClass(context, KvInfoUI.class);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(220615);
                }

                @Override // com.tencent.mm.kernel.api.c
                public final void onAccountInitialized(e.c cVar) {
                    AppMethodBeat.i(220608);
                    if (MMApplicationContext.isMainProcess()) {
                        EventCenter.instance.add(this.kvQ);
                        EventCenter.instance.add(this.oVk);
                    }
                    AppMethodBeat.o(220608);
                }

                static /* synthetic */ void a(a aVar, long j2, String str) {
                    AppMethodBeat.i(220616);
                    if (j2 == 11110 || j2 == 11108) {
                        AppMethodBeat.o(220616);
                        return;
                    }
                    if (MMApplicationContext.isMMProcess() && aVar.cRg()) {
                        c cVar = new c();
                        cVar.content = str;
                        cVar.type = 10001;
                        cVar.key = (int) j2;
                        com.tencent.mm.kernel.g.azz().a(cVar, 0);
                    }
                    AppMethodBeat.o(220616);
                }

                static /* synthetic */ void b(a aVar, long j2, String str) {
                    boolean z;
                    LinkedList linkedList;
                    AppMethodBeat.i(220617);
                    if (aVar.sJP && aVar.sJQ != null) {
                        List<b> list = aVar.sJQ.get(String.valueOf(j2));
                        if (list == null) {
                            z = false;
                            linkedList = new LinkedList();
                        } else {
                            b bVar = list.get(list.size() - 1);
                            if (Util.milliSecondsToNow(bVar.sJT) < 1000) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                bVar.sJV = true;
                            }
                            linkedList = list;
                        }
                        linkedList.add(0, new b(j2, str, Util.nowMilliSecond(), z));
                        aVar.sJQ.put(String.valueOf(j2), linkedList);
                    }
                    AppMethodBeat.o(220617);
                }
            }
