package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a.a;
import java.util.concurrent.Executors;

public class FlutterMain {
    private static boolean isRunningInRobolectricTest = false;

    public static class a {
        String logTag;
    }

    public static void startInitialization(Context context) {
        AppMethodBeat.i(9740);
        if (isRunningInRobolectricTest) {
            AppMethodBeat.o(9740);
            return;
        }
        io.flutter.embedding.engine.a.a.hwT().startInitialization(context);
        AppMethodBeat.o(9740);
    }

    public static void startInitialization(Context context, a aVar) {
        AppMethodBeat.i(9741);
        if (isRunningInRobolectricTest) {
            AppMethodBeat.o(9741);
            return;
        }
        a.b bVar = new a.b();
        bVar.logTag = aVar.logTag;
        io.flutter.embedding.engine.a.a.hwT().a(context, bVar);
        AppMethodBeat.o(9741);
    }

    public static void ensureInitializationComplete(Context context, String[] strArr) {
        AppMethodBeat.i(9742);
        if (isRunningInRobolectricTest) {
            AppMethodBeat.o(9742);
            return;
        }
        io.flutter.embedding.engine.a.a.hwT().ensureInitializationComplete(context, strArr);
        AppMethodBeat.o(9742);
    }

    public static void ensureInitializationCompleteAsync(Context context, String[] strArr, Handler handler, Runnable runnable) {
        AppMethodBeat.i(9743);
        if (isRunningInRobolectricTest) {
            AppMethodBeat.o(9743);
            return;
        }
        io.flutter.embedding.engine.a.a hwT = io.flutter.embedding.engine.a.a.hwT();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
            AppMethodBeat.o(9743);
            throw illegalStateException;
        } else if (hwT.SPf == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
            AppMethodBeat.o(9743);
            throw illegalStateException2;
        } else if (hwT.SPe) {
            handler.post(runnable);
            AppMethodBeat.o(9743);
        } else {
            Executors.newSingleThreadExecutor().execute(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004f: INVOKE  
                  (wrap: java.util.concurrent.ExecutorService : 0x0042: INVOKE  (r6v0 java.util.concurrent.ExecutorService) =  type: STATIC call: java.util.concurrent.Executors.newSingleThreadExecutor():java.util.concurrent.ExecutorService)
                  (wrap: io.flutter.embedding.engine.a.a$2 : 0x004c: CONSTRUCTOR  (r0v4 io.flutter.embedding.engine.a.a$2) = 
                  (r1v0 'hwT' io.flutter.embedding.engine.a.a)
                  (r8v0 'context' android.content.Context)
                  (r9v0 'strArr' java.lang.String[])
                  (r10v0 'handler' android.os.Handler)
                  (r11v0 'runnable' java.lang.Runnable)
                 call: io.flutter.embedding.engine.a.a.2.<init>(io.flutter.embedding.engine.a.a, android.content.Context, java.lang.String[], android.os.Handler, java.lang.Runnable):void type: CONSTRUCTOR)
                 type: INTERFACE call: java.util.concurrent.ExecutorService.execute(java.lang.Runnable):void in method: io.flutter.view.FlutterMain.ensureInitializationCompleteAsync(android.content.Context, java.lang.String[], android.os.Handler, java.lang.Runnable):void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: CONSTRUCTOR  (r0v4 io.flutter.embedding.engine.a.a$2) = 
                  (r1v0 'hwT' io.flutter.embedding.engine.a.a)
                  (r8v0 'context' android.content.Context)
                  (r9v0 'strArr' java.lang.String[])
                  (r10v0 'handler' android.os.Handler)
                  (r11v0 'runnable' java.lang.Runnable)
                 call: io.flutter.embedding.engine.a.a.2.<init>(io.flutter.embedding.engine.a.a, android.content.Context, java.lang.String[], android.os.Handler, java.lang.Runnable):void type: CONSTRUCTOR in method: io.flutter.view.FlutterMain.ensureInitializationCompleteAsync(android.content.Context, java.lang.String[], android.os.Handler, java.lang.Runnable):void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 27 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.flutter.embedding.engine.a.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 33 more
                */
            /*
                r7 = 9743(0x260f, float:1.3653E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
                boolean r0 = io.flutter.view.FlutterMain.isRunningInRobolectricTest
                if (r0 == 0) goto L_0x000d
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            L_0x000c:
                return
            L_0x000d:
                io.flutter.embedding.engine.a.a r1 = io.flutter.embedding.engine.a.a.hwT()
                android.os.Looper r0 = android.os.Looper.myLooper()
                android.os.Looper r2 = android.os.Looper.getMainLooper()
                if (r0 == r2) goto L_0x0027
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "ensureInitializationComplete must be called on the main thread"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                throw r0
            L_0x0027:
                io.flutter.embedding.engine.a.a$b r0 = r1.SPf
                if (r0 != 0) goto L_0x0037
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "ensureInitializationComplete must be called after startInitialization"
                r0.<init>(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                throw r0
            L_0x0037:
                boolean r0 = r1.SPe
                if (r0 == 0) goto L_0x0042
                r10.post(r11)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                goto L_0x000c
            L_0x0042:
                java.util.concurrent.ExecutorService r6 = java.util.concurrent.Executors.newSingleThreadExecutor()
                io.flutter.embedding.engine.a.a$2 r0 = new io.flutter.embedding.engine.a.a$2
                r2 = r8
                r3 = r9
                r4 = r10
                r5 = r11
                r0.<init>(r2, r3, r4, r5)
                r6.execute(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                goto L_0x000c
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.FlutterMain.ensureInitializationCompleteAsync(android.content.Context, java.lang.String[], android.os.Handler, java.lang.Runnable):void");
        }

        public static String findAppBundlePath() {
            AppMethodBeat.i(214930);
            String str = io.flutter.embedding.engine.a.a.hwT().SPc;
            AppMethodBeat.o(214930);
            return str;
        }

        @Deprecated
        public static String findAppBundlePath(Context context) {
            AppMethodBeat.i(214931);
            String str = io.flutter.embedding.engine.a.a.hwT().SPc;
            AppMethodBeat.o(214931);
            return str;
        }

        public static String getLookupKeyForAsset(String str) {
            AppMethodBeat.i(9747);
            String btd = io.flutter.embedding.engine.a.a.hwT().btd(str);
            AppMethodBeat.o(9747);
            return btd;
        }

        public static String getLookupKeyForAsset(String str, String str2) {
            AppMethodBeat.i(9748);
            String lookupKeyForAsset = io.flutter.embedding.engine.a.a.hwT().getLookupKeyForAsset(str, str2);
            AppMethodBeat.o(9748);
            return lookupKeyForAsset;
        }

        static {
            AppMethodBeat.i(9749);
            AppMethodBeat.o(9749);
        }

        @Deprecated
        public static void setIsRunningInRobolectricTest(boolean z) {
            isRunningInRobolectricTest = z;
        }
    }
