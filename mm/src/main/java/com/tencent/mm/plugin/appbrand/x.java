package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x {
    protected w dra = new w() {
        /* class com.tencent.mm.plugin.appbrand.x.AnonymousClass1 */

        @Override // com.tencent.mm.appbrand.v8.w
        public final int XN() {
            AppMethodBeat.i(134606);
            if (x.this.kEy != null) {
                int nativeBufferId = x.this.kEy.getNativeBufferId();
                AppMethodBeat.o(134606);
                return nativeBufferId;
            }
            AppMethodBeat.o(134606);
            return 0;
        }

        @Override // com.tencent.mm.appbrand.v8.w
        public final ByteBuffer iU(int i2) {
            AppMethodBeat.i(134607);
            if (x.this.kEy != null) {
                ByteBuffer N = x.this.kEy.N(i2, false);
                AppMethodBeat.o(134607);
                return N;
            }
            AppMethodBeat.o(134607);
            return null;
        }

        @Override // com.tencent.mm.appbrand.v8.w
        public final void setBuffer(int i2, ByteBuffer byteBuffer) {
            AppMethodBeat.i(134608);
            if (x.this.kEy != null) {
                x.this.kEy.setNativeBuffer(i2, byteBuffer);
            }
            AppMethodBeat.o(134608);
        }

        @Override // com.tencent.mm.appbrand.v8.w
        public final boolean supportBufferStoreBindTo() {
            AppMethodBeat.i(134609);
            if (x.this.kEy != null) {
                boolean supportBufferStoreBindTo = x.this.kEy.supportBufferStoreBindTo();
                AppMethodBeat.o(134609);
                return supportBufferStoreBindTo;
            }
            AppMethodBeat.o(134609);
            return false;
        }

        @Override // com.tencent.mm.appbrand.v8.w
        public final void bufferStoreBindTo(long j2, long j3) {
            AppMethodBeat.i(134610);
            if (x.this.kEy != null) {
                x.this.kEy.bufferStoreBindTo(j2, j3);
            }
            AppMethodBeat.o(134610);
        }

        @Override // com.tencent.mm.appbrand.v8.w
        public final void p(int i2, String str) {
            AppMethodBeat.i(134611);
            x.this.kAr.getJsRuntime().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", Integer.valueOf(i2), str), null);
            AppMethodBeat.o(134611);
        }
    };
    protected s kAr;
    private ArrayList<v.a> kEA;
    k kEy;
    public v kEz;

    public x(s sVar) {
        AppMethodBeat.i(134612);
        this.kAr = sVar;
        this.kEy = (k) sVar.getJsRuntime().R(k.class);
        this.kEz = bti();
        this.kEA = new ArrayList<>();
        this.kEA.add(new v.a(this.kAr.Ou() + "wxa_library/bootstrap_j2v8_worker.js", d.afA("wxa_library/bootstrap_j2v8_worker.js")));
        sVar.getJsRuntime().addJavascriptInterface(this, "WeixinWorker");
        AppMethodBeat.o(134612);
    }

    /* access modifiers changed from: protected */
    public v bti() {
        AppMethodBeat.i(134613);
        v vVar = new v(this.dra);
        AppMethodBeat.o(134613);
        return vVar;
    }

    @JavascriptInterface
    public int createWithParams(String str, String str2) {
        ArrayList arrayList;
        JSONException e2;
        AppMethodBeat.i(219271);
        Log.d("MicroMsg.AppBrandWorkerContainer", "hy: create worker: %s, %s", str, str2);
        ArrayList<v.a> arrayList2 = new ArrayList<>(this.kEA);
        a(arrayList2, str);
        arrayList2.add(Us(str));
        if (str2 != null) {
            try {
                JSONArray optJSONArray = new JSONObject(str2).optJSONArray("APIList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    arrayList = new ArrayList(10);
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        try {
                            arrayList.add(optJSONArray.getString(i2));
                        } catch (JSONException e3) {
                            e2 = e3;
                            Log.printErrStackTrace("MicroMsg.AppBrandWorkerContainer", e2, "hy: json format error! %s", str2);
                            int a2 = this.kEz.a(arrayList2, this.kAr, arrayList);
                            AppMethodBeat.o(219271);
                            return a2;
                        }
                    }
                    int a22 = this.kEz.a(arrayList2, this.kAr, arrayList);
                    AppMethodBeat.o(219271);
                    return a22;
                }
            } catch (JSONException e4) {
                e2 = e4;
                arrayList = null;
                Log.printErrStackTrace("MicroMsg.AppBrandWorkerContainer", e2, "hy: json format error! %s", str2);
                int a222 = this.kEz.a(arrayList2, this.kAr, arrayList);
                AppMethodBeat.o(219271);
                return a222;
            }
        }
        arrayList = null;
        int a2222 = this.kEz.a(arrayList2, this.kAr, arrayList);
        AppMethodBeat.o(219271);
        return a2222;
    }

    @JavascriptInterface
    public int create(String str) {
        AppMethodBeat.i(134614);
        int createWithParams = createWithParams(str, null);
        AppMethodBeat.o(134614);
        return createWithParams;
    }

    /* access modifiers changed from: protected */
    public v.a Us(String str) {
        AppMethodBeat.i(134615);
        v.a aVar = new v.a(this.kAr.Ot() + str, bg.d(this.kAr.getRuntime(), str) + this.kAr.dG(str));
        AppMethodBeat.o(134615);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void a(ArrayList<v.a> arrayList, String str) {
        AppMethodBeat.i(134616);
        arrayList.add(new v.a(this.kAr.Ou() + "config", String.format("var __wxConfig = %s;", this.kAr.Or().toString())));
        AppMethodBeat.o(134616);
    }

    @JavascriptInterface
    public void terminate(int i2) {
        AppMethodBeat.i(134617);
        this.kEz.terminate(i2);
        AppMethodBeat.o(134617);
    }

    @JavascriptInterface
    public void postMsgToWorker(int i2, String str) {
        AppMethodBeat.i(134618);
        v vVar = this.kEz;
        m mVar = vVar.dqZ.get(Integer.valueOf(i2));
        if (mVar != null) {
            mVar.dpQ.r(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE  
                  (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x0016: IGET  (r2v1 com.tencent.mm.appbrand.v8.IJSRuntime) = (r0v2 'mVar' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
                  (wrap: com.tencent.mm.appbrand.v8.v$6 : 0x001a: CONSTRUCTOR  (r3v0 com.tencent.mm.appbrand.v8.v$6) = (r1v0 'vVar' com.tencent.mm.appbrand.v8.v), (r0v2 'mVar' com.tencent.mm.appbrand.v8.m), (r7v0 'str' java.lang.String) call: com.tencent.mm.appbrand.v8.v.6.<init>(com.tencent.mm.appbrand.v8.v, com.tencent.mm.appbrand.v8.m, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.x.postMsgToWorker(int, java.lang.String):void, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: CONSTRUCTOR  (r3v0 com.tencent.mm.appbrand.v8.v$6) = (r1v0 'vVar' com.tencent.mm.appbrand.v8.v), (r0v2 'mVar' com.tencent.mm.appbrand.v8.m), (r7v0 'str' java.lang.String) call: com.tencent.mm.appbrand.v8.v.6.<init>(com.tencent.mm.appbrand.v8.v, com.tencent.mm.appbrand.v8.m, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.x.postMsgToWorker(int, java.lang.String):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.appbrand.v8.v, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r4 = 134618(0x20dda, float:1.8864E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.appbrand.v8.v r1 = r5.kEz
                java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.tencent.mm.appbrand.v8.m> r0 = r1.dqZ
                java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
                java.lang.Object r0 = r0.get(r2)
                com.tencent.mm.appbrand.v8.m r0 = (com.tencent.mm.appbrand.v8.m) r0
                if (r0 == 0) goto L_0x0020
                com.tencent.mm.appbrand.v8.IJSRuntime r2 = r0.dpQ
                com.tencent.mm.appbrand.v8.v$6 r3 = new com.tencent.mm.appbrand.v8.v$6
                r3.<init>(r0, r7)
                r2.r(r3)
            L_0x0020:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.x.postMsgToWorker(int, java.lang.String):void");
        }
    }
