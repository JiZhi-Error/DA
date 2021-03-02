package com.tencent.mm.appbrand.v8;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class v {
    private final AtomicInteger dqY = new AtomicInteger(0);
    public final ConcurrentHashMap<Integer, m> dqZ = new ConcurrentHashMap<>();
    w dra;
    private e drb = new e() {
        /* class com.tencent.mm.appbrand.v8.v.AnonymousClass7 */

        @Override // com.tencent.mm.appbrand.v8.e
        public final int generateId() {
            AppMethodBeat.i(216915);
            int XN = v.this.dra.XN();
            AppMethodBeat.o(216915);
            return XN;
        }

        @Override // com.tencent.mm.appbrand.v8.e
        public final ByteBuffer getBuffer(int i2, boolean z) {
            AppMethodBeat.i(216916);
            ByteBuffer iU = v.this.dra.iU(i2);
            AppMethodBeat.o(216916);
            return iU;
        }

        @Override // com.tencent.mm.appbrand.v8.e
        public final void setBuffer(int i2, ByteBuffer byteBuffer) {
            AppMethodBeat.i(216917);
            v.this.dra.setBuffer(i2, byteBuffer);
            AppMethodBeat.o(216917);
        }

        @Override // com.tencent.mm.appbrand.v8.e
        public final boolean supportBufferStoreBindTo() {
            AppMethodBeat.i(216918);
            boolean supportBufferStoreBindTo = v.this.dra.supportBufferStoreBindTo();
            AppMethodBeat.o(216918);
            return supportBufferStoreBindTo;
        }

        @Override // com.tencent.mm.appbrand.v8.e
        public final void bufferStoreBindTo(long j2, long j3) {
            AppMethodBeat.i(216919);
            v.this.dra.bufferStoreBindTo(j2, j3);
            AppMethodBeat.o(216919);
        }

        @Override // com.tencent.mm.appbrand.v8.e
        public final void releaseDirectByteBuffer(ByteBuffer byteBuffer) {
        }
    };

    public v(w wVar) {
        AppMethodBeat.i(144116);
        this.dra = wVar;
        AppMethodBeat.o(144116);
    }

    public static class a {
        public String filePath;
        public String script;

        public a(String str, String str2) {
            this.filePath = str;
            this.script = str2;
        }
    }

    static void a(m mVar, String str, String str2) {
        AppMethodBeat.i(175404);
        Log.e("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", str, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, str2);
        } catch (JSONException e2) {
            Log.e("MicroMsg.V8EngineWorkerManager", android.util.Log.getStackTraceString(e2));
        }
        mVar.a(String.format("WeixinWorker.errorHandler(%s)", jSONObject), (m.b) null);
        AppMethodBeat.o(175404);
    }

    public final int a(ArrayList<a> arrayList, g gVar, final List<String> list) {
        boolean z;
        AppMethodBeat.i(216920);
        final int addAndGet = this.dqY.addAndGet(1);
        IJSRuntime.Config config = new IJSRuntime.Config();
        config.dpl = "1";
        config.dpm = true;
        config.dpo = true;
        config.dpp = true;
        config.dps = new WeakReference<>(gVar);
        config.opR = this.drb;
        x xVar = new x(config);
        final m mVar = xVar.mNC;
        a(arrayList, xVar, gVar);
        this.dqZ.put(Integer.valueOf(addAndGet), mVar);
        gVar.getContext();
        a(addAndGet, gVar);
        final WeakReference<g> weakReference = config.dps;
        final WeakReference weakReference2 = new WeakReference(mVar);
        mVar.dpQ.r(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0057: INVOKE  
              (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x0050: IGET  (r7v0 com.tencent.mm.appbrand.v8.IJSRuntime) = (r4v0 'mVar' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
              (wrap: com.tencent.mm.appbrand.v8.m$2 : 0x0054: CONSTRUCTOR  (r8v0 com.tencent.mm.appbrand.v8.m$2) = 
              (r4v0 'mVar' com.tencent.mm.appbrand.v8.m)
              (wrap: com.tencent.mm.appbrand.v8.v$2 : 0x004d: CONSTRUCTOR  (r6v0 com.tencent.mm.appbrand.v8.v$2) = (r10v0 'this' com.tencent.mm.appbrand.v8.v A[IMMUTABLE_TYPE, THIS]), (r3v0 'addAndGet' int A[SKIP_ARG]) call: com.tencent.mm.appbrand.v8.v.2.<init>(com.tencent.mm.appbrand.v8.v, int):void type: CONSTRUCTOR)
              ("postMessage")
             call: com.tencent.mm.appbrand.v8.m.2.<init>(com.tencent.mm.appbrand.v8.m, com.eclipsesource.v8.JavaVoidCallback, java.lang.String):void type: CONSTRUCTOR)
             type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.appbrand.v8.v.a(java.util.ArrayList<com.tencent.mm.appbrand.v8.v$a>, com.tencent.mm.plugin.appbrand.jsapi.g, java.util.List<java.lang.String>):int, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: CONSTRUCTOR  (r8v0 com.tencent.mm.appbrand.v8.m$2) = 
              (r4v0 'mVar' com.tencent.mm.appbrand.v8.m)
              (wrap: com.tencent.mm.appbrand.v8.v$2 : 0x004d: CONSTRUCTOR  (r6v0 com.tencent.mm.appbrand.v8.v$2) = (r10v0 'this' com.tencent.mm.appbrand.v8.v A[IMMUTABLE_TYPE, THIS]), (r3v0 'addAndGet' int A[SKIP_ARG]) call: com.tencent.mm.appbrand.v8.v.2.<init>(com.tencent.mm.appbrand.v8.v, int):void type: CONSTRUCTOR)
              ("postMessage")
             call: com.tencent.mm.appbrand.v8.m.2.<init>(com.tencent.mm.appbrand.v8.m, com.eclipsesource.v8.JavaVoidCallback, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.appbrand.v8.v.a(java.util.ArrayList<com.tencent.mm.appbrand.v8.v$a>, com.tencent.mm.plugin.appbrand.jsapi.g, java.util.List<java.lang.String>):int, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.appbrand.v8.m, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.appbrand.v8.v.a(java.util.ArrayList, com.tencent.mm.plugin.appbrand.jsapi.g, java.util.List):int");
    }

    /* access modifiers changed from: protected */
    public void a(ArrayList<a> arrayList, i iVar, g gVar) {
        AppMethodBeat.i(216921);
        Log.w("MicroMsg.V8EngineWorkerManager", "hy: do noting in base worker manager");
        AppMethodBeat.o(216921);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, g gVar) {
        AppMethodBeat.i(216922);
        Log.e("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
        AppMethodBeat.o(216922);
    }

    /* access modifiers changed from: protected */
    public void a(m mVar, a aVar) {
        AppMethodBeat.i(144118);
        Log.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", aVar.filePath);
        mVar.a(aVar.filePath, aVar.script, (m.b) null);
        AppMethodBeat.o(144118);
    }

    public void terminate(int i2) {
        AppMethodBeat.i(216923);
        m remove = this.dqZ.remove(Integer.valueOf(i2));
        if (remove != null) {
            remove.destroy();
        }
        AppMethodBeat.o(216923);
    }

    public final m iT(int i2) {
        AppMethodBeat.i(144121);
        m mVar = this.dqZ.get(Integer.valueOf(i2));
        AppMethodBeat.o(144121);
        return mVar;
    }

    static /* synthetic */ void a(v vVar, m mVar, String str, final ValueCallback valueCallback) {
        AppMethodBeat.i(216924);
        if (mVar == null) {
            Log.w("MicroMsg.V8EngineWorkerManager", "hy: engine context released");
            AppMethodBeat.o(216924);
        } else if (valueCallback != null) {
            mVar.a(str, new m.b() {
                /* class com.tencent.mm.appbrand.v8.v.AnonymousClass4 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(216911);
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(216911);
                }
            });
            AppMethodBeat.o(216924);
        } else {
            mVar.a(str, (m.b) null);
            AppMethodBeat.o(216924);
        }
    }
}
