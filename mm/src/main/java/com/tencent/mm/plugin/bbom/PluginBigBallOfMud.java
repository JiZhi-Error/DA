package com.tencent.mm.plugin.bbom;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.MMReceivers;
import com.tencent.mm.booter.e;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.memory.a.a.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.auth.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.ui.widget.m;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.voip.ui.VoipViewFragment;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.d;
import com.tencent.mm.ui.widget.MMWebView;
import org.xwalk.core.XWalkEnvironment;

public class PluginBigBallOfMud extends f implements ApplicationLifeCycleBucket {
    private static final String TAG = "MicroMsg.PluginBigBallOfMud";
    public Application app;
    private final MMAppMgr appMgr = new MMAppMgr();
    private j deleteContactService = new j();
    private d mProfileCompat;

    public PluginBigBallOfMud() {
        AppMethodBeat.i(22412);
        AppMethodBeat.o(22412);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-big-ball-of-mud";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(22413);
        if (MMApplicationContext.isMainProcess()) {
            dependsOn(c.class);
            dependsOn(s.class);
        }
        AppMethodBeat.o(22413);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        String str;
        d dVar;
        int i2;
        int hashCode;
        int hashCode2;
        AppMethodBeat.i(22414);
        com.tencent.mm.ui.d.a(new d.a() {
            /* class com.tencent.mm.plugin.bbom.PluginBigBallOfMud.AnonymousClass1 */

            @Override // com.tencent.mm.ui.d.a
            public final void c(long j2, String str, String str2) {
                AppMethodBeat.i(22384);
                e.INSTANCE.a(14976, Long.valueOf(j2), str, str2);
                AppMethodBeat.o(22384);
            }
        });
        MMReceivers.ToolsProcessReceiver.a(new e.c());
        MMReceivers.ToolsMpProcessReceiver.a(new e.a());
        MMReceivers.SandBoxProcessReceiver.a(new e.b());
        com.tencent.mm.plugin.zero.a.d dVar2 = (com.tencent.mm.plugin.zero.a.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.zero.a.d.class);
        dVar2.setILightPushDelegate(new l());
        dVar2.addNotifyReceiverCallback(new q());
        dVar2.addICoreServiceLifecycleCallback(new g());
        Log.i(TAG, "zero %s", dVar2);
        this.app = gVar.ca;
        Log.i(TAG, "app. %s", this.app);
        com.tencent.mm.modelstat.d.h(this.app);
        Log.i(TAG, "ClickFlowStatSender registerActivityLifeCycle");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.compatible.loader.e eVar = new com.tencent.mm.compatible.loader.e();
        Application application = this.app;
        String str2 = gVar.mProcessName;
        if (str2 == null || str2.length() <= 0) {
            a bqt = a.bqt("ProfileFactoryImp_handlerThread");
            bqt.RUS.quit();
            str = (String) 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a9: CHECK_CAST (r3v112 'str' java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x009e: INVOKE  (r0v250 java.lang.Object) = 
                  (wrap: com.tencent.mm.compatible.loader.e$1 : 0x0096: CONSTRUCTOR  (r0v249 com.tencent.mm.compatible.loader.e$1) = (r3v6 'eVar' com.tencent.mm.compatible.loader.e) call: com.tencent.mm.compatible.loader.e.1.<init>(com.tencent.mm.compatible.loader.e):void type: CONSTRUCTOR)
                  (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x009b: CONSTRUCTOR  (r3v110 com.tencent.mm.sdk.platformtools.MMHandler) = (r7v24 'bqt' com.tencent.f.j.a) call: com.tencent.mm.sdk.platformtools.MMHandler.<init>(com.tencent.f.j.a):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.compatible.loader.e.1.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object) in method: com.tencent.mm.plugin.bbom.PluginBigBallOfMud.configure(com.tencent.mm.kernel.b.g):void, file: classes4.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009e: INVOKE  (r0v250 java.lang.Object) = 
                  (wrap: com.tencent.mm.compatible.loader.e$1 : 0x0096: CONSTRUCTOR  (r0v249 com.tencent.mm.compatible.loader.e$1) = (r3v6 'eVar' com.tencent.mm.compatible.loader.e) call: com.tencent.mm.compatible.loader.e.1.<init>(com.tencent.mm.compatible.loader.e):void type: CONSTRUCTOR)
                  (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x009b: CONSTRUCTOR  (r3v110 com.tencent.mm.sdk.platformtools.MMHandler) = (r7v24 'bqt' com.tencent.f.j.a) call: com.tencent.mm.sdk.platformtools.MMHandler.<init>(com.tencent.f.j.a):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.compatible.loader.e.1.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object in method: com.tencent.mm.plugin.bbom.PluginBigBallOfMud.configure(com.tencent.mm.kernel.b.g):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0096: CONSTRUCTOR  (r0v249 com.tencent.mm.compatible.loader.e$1) = (r3v6 'eVar' com.tencent.mm.compatible.loader.e) call: com.tencent.mm.compatible.loader.e.1.<init>(com.tencent.mm.compatible.loader.e):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.bbom.PluginBigBallOfMud.configure(com.tencent.mm.kernel.b.g):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 23 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.compatible.loader.e, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                */
            /*
            // Method dump skipped, instructions count: 3172
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.bbom.PluginBigBallOfMud.configure(com.tencent.mm.kernel.b.g):void");
        }

        @Override // com.tencent.mm.kernel.a.c.b
        public void execute(g gVar) {
        }

        @Override // com.tencent.tinker.entry.ApplicationLifeCycle
        public void onTerminate() {
            AppMethodBeat.i(22415);
            Log.i(TAG, "onTerminate(%s)", MMApplicationContext.getProcessName());
            if (this.mProfileCompat != null) {
                this.mProfileCompat.onTerminate();
            }
            MMAppMgr mMAppMgr = this.appMgr;
            Application application = this.app;
            if (mMAppMgr.OHn != null) {
                application.unregisterReceiver(mMAppMgr.OHn);
            }
            AppMethodBeat.o(22415);
        }

        @Override // com.tencent.tinker.entry.ApplicationLifeCycle
        public void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(22416);
            if (ao.awS() && ao.awN()) {
                XWalkEnvironment.setForceDarkMode(ao.i(configuration));
                MMWebView.CU(ao.i(configuration));
                if (MMApplicationContext.isMainProcess()) {
                    if (com.tencent.mm.cc.c.h(configuration)) {
                        Log.i(TAG, "dancy test uiModeChange true, uimode:%s", Integer.valueOf(configuration.uiMode));
                        com.tencent.mm.plugin.sns.ui.widget.f.resetConfig();
                        b.aXY().clearCache();
                        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
                            ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).onAccountRelease();
                            ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chL();
                            if (com.tencent.mm.kernel.g.aAf().azp()) {
                                com.tencent.mm.plugin.voip.ui.d fFh = com.tencent.mm.plugin.voip.c.fFh();
                                if (fFh.HeX != null) {
                                    VoipViewFragment voipViewFragment = fFh.HeX;
                                    BaseSmallView baseSmallView = voipViewFragment.HfC;
                                    if (baseSmallView != null) {
                                        baseSmallView.eoM();
                                    }
                                    BaseSmallView baseSmallView2 = voipViewFragment.HfB;
                                    if (baseSmallView2 != null) {
                                        baseSmallView2.eoM();
                                    }
                                }
                                m mVar = ac.eon().zTM;
                                if (mVar != null) {
                                    mVar.eoM();
                                }
                            }
                        }
                    }
                    com.tencent.mm.cc.c.a(configuration, ao.isDarkMode());
                    if (MMApplicationContext.getContext().getResources() != null) {
                        MMApplicationContext.getContext().getResources().getConfiguration().updateFrom(configuration);
                    }
                }
            }
            Resources resources = MMApplicationContext.getResources();
            if (resources instanceof com.tencent.mm.cc.b) {
                ((com.tencent.mm.cc.b) resources).onConfigurationChanged(configuration);
            }
            if (this.mProfileCompat != null) {
                this.mProfileCompat.onConfigurationChanged(configuration);
            }
            AppMethodBeat.o(22416);
        }

        @Override // com.tencent.tinker.entry.ApplicationLifeCycle
        public void onLowMemory() {
        }

        @Override // com.tencent.tinker.entry.ApplicationLifeCycle
        public void onTrimMemory(int i2) {
            AppMethodBeat.i(22417);
            Log.i(TAG, "onTrimMemory, level = %d, process = %s", Integer.valueOf(i2), MMApplicationContext.getProcessName());
            if (this.mProfileCompat != null) {
                this.mProfileCompat.onTrimMemory(i2);
            }
            com.tencent.mm.memory.a.a.b aSk = com.tencent.mm.memory.a.a.b.aSk();
            Log.i("MicroMsg.CacheInvoke", "CacheInvoke onTrimMemory");
            for (b.AbstractC0442b bVar : aSk.itH.values()) {
                bVar.aSl();
            }
            AppMethodBeat.o(22417);
        }

        @Override // com.tencent.tinker.entry.ApplicationLifeCycle
        public void onCreate() {
        }

        @Override // com.tencent.tinker.entry.ApplicationLifeCycle
        public void onBaseContextAttached(Context context) {
        }
    }
