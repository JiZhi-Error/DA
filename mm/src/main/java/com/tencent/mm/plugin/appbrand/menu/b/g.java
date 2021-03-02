package com.tencent.mm.plugin.appbrand.menu.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.game.d.a.a.c;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements b<ag> {
    boolean nfS = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47694);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) agVar.av(AppBrandSysConfigWC.class);
        if (appBrandSysConfigWC.leE.kNW == 1 || appBrandSysConfigWC.leE.kNW == 2 || WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv() || BuildInfo.IS_FLAVOR_RED || p.Un(str).kDe) {
            AppMethodBeat.o(47694);
            return true;
        } else if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(47694);
            return true;
        } else {
            AppMethodBeat.o(47694);
            return false;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    @SuppressLint({"DefaultLocale"})
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        AppMethodBeat.i(47693);
        ag agVar2 = agVar;
        q runtime = agVar2.getRuntime();
        if (runtime == null || runtime.bsE() == null) {
            AppMethodBeat.o(47693);
        } else if (this.nfS) {
            long currentTimeMillis = System.currentTimeMillis();
            a(runtime.bsE().getJsRuntime(), d(agVar2.bsE()), context, String.format("CPU_%s_%d.cpuprofile", str, Long.valueOf(currentTimeMillis)));
            List<o> aa = aa(runtime);
            if (aa != null) {
                int i2 = 0;
                for (o oVar : aa) {
                    String format = String.format("CPU_%s_%d_worker_%d.cpuprofile", str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2));
                    if (oVar instanceof com.tencent.mm.plugin.appbrand.ag.b) {
                        a(oVar, ((com.tencent.mm.plugin.appbrand.ag.b) oVar).bCX(), context, format);
                    } else {
                        Log.w("MiroMsg.GameCpuProfile", "hy: not worker instance");
                        a(oVar, null, context, format);
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(47693);
        } else {
            com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKJ() + "appbrand/trace/");
            if (!oVar2.exists()) {
                oVar2.mkdirs();
            }
            a(runtime.bsE().getJsRuntime(), d(agVar2.bsE()), context);
            List<o> aa2 = aa(runtime);
            if (aa2 != null) {
                Log.i("MiroMsg.GameCpuProfile", "hy: trigger worker cpu profiling: %d", Integer.valueOf(aa2.size()));
                for (o oVar3 : aa2) {
                    a(oVar3, (MBRuntime) null, context);
                }
            }
            AppMethodBeat.o(47693);
        }
    }

    private static e d(d dVar) {
        AppMethodBeat.i(227182);
        c cVar = (c) dVar.S(c.class);
        if (cVar != null) {
            e magicBrush = cVar.getMagicBrush();
            AppMethodBeat.o(227182);
            return magicBrush;
        }
        AppMethodBeat.o(227182);
        return null;
    }

    private static List<o> aa(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(227183);
        if (appBrandRuntime.NY() == null) {
            Log.e("MiroMsg.GameCpuProfile", "hy: service released. abort walking through workers");
            AppMethodBeat.o(227183);
            return null;
        }
        x btd = appBrandRuntime.NY().btd();
        if (btd != null) {
            ConcurrentHashMap<Integer, m> concurrentHashMap = btd.kEz.dqZ;
            if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                AppMethodBeat.o(227183);
                return null;
            }
            ArrayList arrayList = new ArrayList(5);
            for (Integer num : concurrentHashMap.keySet()) {
                arrayList.add(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005b: INVOKE  
                      (r1v4 'arrayList' java.util.ArrayList)
                      (wrap: com.tencent.mm.appbrand.v8.v$5 : 0x0058: CONSTRUCTOR  (r6v0 com.tencent.mm.appbrand.v8.v$5) = 
                      (wrap: com.tencent.mm.appbrand.v8.v : 0x0054: IGET  (r5v0 com.tencent.mm.appbrand.v8.v) = (r2v0 'btd' com.tencent.mm.plugin.appbrand.x) com.tencent.mm.plugin.appbrand.x.kEz com.tencent.mm.appbrand.v8.v)
                      (wrap: com.tencent.mm.appbrand.v8.m : 0x004e: INVOKE  (r0v7 com.tencent.mm.appbrand.v8.m) = 
                      (r3v0 'concurrentHashMap' java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.mm.appbrand.v8.m>)
                      (r0v5 'num' java.lang.Integer)
                     type: VIRTUAL call: java.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object)
                     call: com.tencent.mm.appbrand.v8.v.5.<init>(com.tencent.mm.appbrand.v8.v, com.tencent.mm.appbrand.v8.m):void type: CONSTRUCTOR)
                     type: INTERFACE call: java.util.List.add(java.lang.Object):boolean in method: com.tencent.mm.plugin.appbrand.menu.b.g.aa(com.tencent.mm.plugin.appbrand.AppBrandRuntime):java.util.List<com.tencent.mm.plugin.appbrand.m.o>, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0058: CONSTRUCTOR  (r6v0 com.tencent.mm.appbrand.v8.v$5) = 
                      (wrap: com.tencent.mm.appbrand.v8.v : 0x0054: IGET  (r5v0 com.tencent.mm.appbrand.v8.v) = (r2v0 'btd' com.tencent.mm.plugin.appbrand.x) com.tencent.mm.plugin.appbrand.x.kEz com.tencent.mm.appbrand.v8.v)
                      (wrap: com.tencent.mm.appbrand.v8.m : 0x004e: INVOKE  (r0v7 com.tencent.mm.appbrand.v8.m) = 
                      (r3v0 'concurrentHashMap' java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.mm.appbrand.v8.m>)
                      (r0v5 'num' java.lang.Integer)
                     type: VIRTUAL call: java.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object)
                     call: com.tencent.mm.appbrand.v8.v.5.<init>(com.tencent.mm.appbrand.v8.v, com.tencent.mm.appbrand.v8.m):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.menu.b.g.aa(com.tencent.mm.plugin.appbrand.AppBrandRuntime):java.util.List<com.tencent.mm.plugin.appbrand.m.o>, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 34 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.appbrand.v8.v, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 40 more
                    */
                /*
                // Method dump skipped, instructions count: 104
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.menu.b.g.aa(com.tencent.mm.plugin.appbrand.AppBrandRuntime):java.util.List");
            }

            private void a(o oVar, MBRuntime mBRuntime, final Context context) {
                AppMethodBeat.i(227184);
                oVar.evaluateJavascript(";var __debug_v8_cpu_profiler = (function(profiler) {if (typeof profiler === 'undefined') { profiler = new NativeGlobal.CpuProfiler();} profiler.startProfiling(); return profiler;})(__debug_v8_cpu_profiler);", new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.appbrand.menu.b.g.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(47689);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.menu.b.g.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(47687);
                                Toast.makeText(context, "start cpu profiling...", 1).show();
                                Log.i("MiroMsg.GameCpuProfile", "start cpu profiling...");
                                AppMethodBeat.o(47687);
                            }
                        });
                        g.this.nfS = true;
                        AppMethodBeat.o(47689);
                    }
                });
                if (mBRuntime != null) {
                    mBRuntime.cn(true);
                }
                AppMethodBeat.o(227184);
            }

            private void a(o oVar, MBRuntime mBRuntime, final Context context, final String str) {
                AppMethodBeat.i(227185);
                oVar.evaluateJavascript(";(function(profiler) {return JSON.stringify(profiler.stopProfiling());})(__debug_v8_cpu_profiler);", new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.appbrand.menu.b.g.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(47691);
                        if (g.eu(str, str)) {
                            final String str2 = com.tencent.mm.loader.j.b.aKJ() + "appbrand/trace/" + str;
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.menu.b.g.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(47690);
                                    Toast.makeText(context, str2 + " exported.", 1).show();
                                    Log.i("MiroMsg.GameCpuProfile", str2 + " exported.");
                                    AppMethodBeat.o(47690);
                                }
                            });
                            g.this.nfS = false;
                            AppMethodBeat.o(47691);
                            return;
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.menu.b.g.AnonymousClass2.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(227181);
                                Toast.makeText(context, str + " export failed!", 1).show();
                                Log.e("MiroMsg.GameCpuProfile", str + " export failed!");
                                AppMethodBeat.o(227181);
                            }
                        });
                        AppMethodBeat.o(47691);
                    }
                });
                if (mBRuntime != null) {
                    mBRuntime.cn(false);
                }
                AppMethodBeat.o(227185);
            }

            /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[SYNTHETIC, Splitter:B:23:0x007e] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0098 A[SYNTHETIC, Splitter:B:29:0x0098] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            static boolean eu(java.lang.String r6, java.lang.String r7) {
                /*
                // Method dump skipped, instructions count: 184
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.menu.b.g.eu(java.lang.String, java.lang.String):boolean");
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
            @Override // com.tencent.mm.plugin.appbrand.menu.a.b
            public final /* bridge */ /* synthetic */ String b(Context context, ag agVar, String str) {
                if (this.nfS) {
                    return "Stop CPU Profile";
                }
                return "Start CPU Profile";
            }
        }
