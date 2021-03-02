package com.tencent.mm.plugin.appbrand.m;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.eclipsesource.v8.ScriptPartObject;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandJsBridgeBinding;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public abstract class d implements g, k, l, n, q, s, u, v {
    private y mNJ;
    private AppBrandJsBridgeBinding mNK;

    /* access modifiers changed from: protected */
    public abstract m bMA();

    public abstract IJSRuntime bMz();

    d() {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.g
    public void b(g gVar, String str) {
        String name;
        if (gVar instanceof d) {
            m bMA = bMA();
            bMA.dpQ.r(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                  (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x000e: IGET  (r2v1 com.tencent.mm.appbrand.v8.IJSRuntime) = (r0v6 'bMA' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
                  (wrap: com.tencent.mm.appbrand.v8.m$5 : 0x0012: CONSTRUCTOR  (r3v1 com.tencent.mm.appbrand.v8.m$5) = 
                  (r0v6 'bMA' com.tencent.mm.appbrand.v8.m)
                  (r7v0 'str' java.lang.String)
                  (wrap: com.tencent.mm.appbrand.v8.m : 0x000a: INVOKE  (r1v1 com.tencent.mm.appbrand.v8.m) = 
                  (wrap: com.tencent.mm.plugin.appbrand.m.d : 0x0008: CHECK_CAST (r6v1 com.tencent.mm.plugin.appbrand.m.d) = (com.tencent.mm.plugin.appbrand.m.d) (r6v0 'gVar' com.tencent.mm.plugin.appbrand.m.g))
                 type: VIRTUAL call: com.tencent.mm.plugin.appbrand.m.d.bMA():com.tencent.mm.appbrand.v8.m)
                 call: com.tencent.mm.appbrand.v8.m.5.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String, com.tencent.mm.appbrand.v8.m):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.m.d.b(com.tencent.mm.plugin.appbrand.m.g, java.lang.String):void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r3v1 com.tencent.mm.appbrand.v8.m$5) = 
                  (r0v6 'bMA' com.tencent.mm.appbrand.v8.m)
                  (r7v0 'str' java.lang.String)
                  (wrap: com.tencent.mm.appbrand.v8.m : 0x000a: INVOKE  (r1v1 com.tencent.mm.appbrand.v8.m) = 
                  (wrap: com.tencent.mm.plugin.appbrand.m.d : 0x0008: CHECK_CAST (r6v1 com.tencent.mm.plugin.appbrand.m.d) = (com.tencent.mm.plugin.appbrand.m.d) (r6v0 'gVar' com.tencent.mm.plugin.appbrand.m.g))
                 type: VIRTUAL call: com.tencent.mm.plugin.appbrand.m.d.bMA():com.tencent.mm.appbrand.v8.m)
                 call: com.tencent.mm.appbrand.v8.m.5.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String, com.tencent.mm.appbrand.v8.m):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.m.d.b(com.tencent.mm.plugin.appbrand.m.g, java.lang.String):void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.appbrand.v8.m, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                this = this;
                boolean r0 = r6 instanceof com.tencent.mm.plugin.appbrand.m.d
                if (r0 == 0) goto L_0x0019
                com.tencent.mm.appbrand.v8.m r0 = r5.bMA()
                com.tencent.mm.plugin.appbrand.m.d r6 = (com.tencent.mm.plugin.appbrand.m.d) r6
                com.tencent.mm.appbrand.v8.m r1 = r6.bMA()
                com.tencent.mm.appbrand.v8.IJSRuntime r2 = r0.dpQ
                com.tencent.mm.appbrand.v8.m$5 r3 = new com.tencent.mm.appbrand.v8.m$5
                r3.<init>(r7, r1)
                r2.r(r3)
            L_0x0018:
                return
            L_0x0019:
                java.lang.String r1 = "MicroMsg.AppBrandJ2V8Context"
                java.lang.String r2 = "shareObject with unsupported implementation %s"
                r0 = 1
                java.lang.Object[] r3 = new java.lang.Object[r0]
                r4 = 0
                if (r6 != 0) goto L_0x002c
                r0 = 0
            L_0x0026:
                r3[r4] = r0
                com.tencent.mm.sdk.platformtools.Log.e(r1, r2, r3)
                goto L_0x0018
            L_0x002c:
                java.lang.Class r0 = r6.getClass()
                java.lang.String r0 = r0.getName()
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.d.b(com.tencent.mm.plugin.appbrand.m.g, java.lang.String):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.m.i
        public void addJavascriptInterface(Object obj, String str) {
            bMA().a(obj, str, JavascriptInterface.class);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.o
        public void evaluateJavascript(String str, final ValueCallback<String> valueCallback) {
            bMA().a(str, valueCallback == null ? null : new m.b() {
                /* class com.tencent.mm.plugin.appbrand.m.d.AnonymousClass1 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(144162);
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(144162);
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.m.i
        public void a(URL url, String str, final ValueCallback<String> valueCallback) {
            if (url == null) {
                evaluateJavascript(str, valueCallback);
            } else {
                bMA().a(url.toString(), str, valueCallback == null ? null : new m.b() {
                    /* class com.tencent.mm.plugin.appbrand.m.d.AnonymousClass2 */

                    @Override // com.tencent.mm.appbrand.v8.m.b
                    public final void a(String str, m.c cVar) {
                        AppMethodBeat.i(144163);
                        valueCallback.onReceiveValue(str);
                        AppMethodBeat.o(144163);
                    }
                });
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.m.i
        public void a(URL url, String str, String str2, int i2, String str3, final ValueCallback<String> valueCallback) {
            String str4 = null;
            AnonymousClass3 r3 = valueCallback == null ? null : new m.b() {
                /* class com.tencent.mm.plugin.appbrand.m.d.AnonymousClass3 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(144164);
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(144164);
                }
            };
            m bMA = bMA();
            if (url != null) {
                str4 = url.toString();
            }
            bMA.a(str4, str3, r3, str, str2, i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.m.g
        public void destroy() {
            bMz().r(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.m.d.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(144165);
                    if (d.this.mNK != null) {
                        d.this.mNK.destroyRuntime();
                        d.this.mNK = null;
                    }
                    AppMethodBeat.o(144165);
                }
            });
            bMA().destroy();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.i
        public <T extends j> T R(Class<T> cls) {
            if (cls.isInstance(this)) {
                return this;
            }
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public int getNativeBufferId() {
            return bMA().doV.generateId();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public void setNativeBuffer(int i2, ByteBuffer byteBuffer) {
            bMA().doV.setBuffer(i2, byteBuffer);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public ByteBuffer N(int i2, boolean z) {
            return bMA().doV.getBuffer(i2, z);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public void releaseDirectByteBuffer(ByteBuffer byteBuffer) {
            bMA().doV.releaseDirectByteBuffer(byteBuffer);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public void a(y yVar) {
            this.mNJ = yVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public y bMF() {
            return this.mNJ;
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public boolean supportBufferStoreBindTo() {
            return bMA().doV.supportBufferStoreBindTo();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.k
        public void bufferStoreBindTo(long j2, long j3) {
            bMA().doV.bufferStoreBindTo(j2, j3);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.s
        public int yb(int i2) {
            return bMA().dpR.iQ(i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.s
        public ByteBuffer ya(int i2) {
            return bMA().dpR.iS(i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.s
        public void xZ(int i2) {
            bMA().dpR.destroy(i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.u
        public void pause() {
            bMz().pause();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.u
        public void resume() {
            bMz().resume();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public void post(Runnable runnable) {
            a(runnable, false);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public void a(Runnable runnable, boolean z) {
            bMz().a(runnable, 0, z);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public String LP() {
            return bMz().LP();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public void cS(boolean z) {
            bMz().cS(z);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public void setThreadPriority(int i2) {
            bMz().setThreadPriority(i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public boolean LO() {
            return bMz().Xw();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.v
        public long getIsolatePtr() {
            return bMz().getIsolatePtr();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.v
        public long XK() {
            return bMA().XK();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.v
        public long getUVLoopPtr() {
            return bMz().getUVLoopPtr();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.v
        public void a(URL url, String str, String str2, int i2, String str3, m.b bVar) {
            bMA().a(url == null ? null : url.toString(), str3, bVar, str, str2, i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.v
        public void a(ArrayList<ScriptPartObject> arrayList, URL url, String str, String str2, m.b bVar) {
            String url2;
            m bMA = bMA();
            if (url == null) {
                url2 = null;
            } else {
                url2 = url.toString();
            }
            bMA.dpQ.r(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                  (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x0007: IGET  (r7v0 com.tencent.mm.appbrand.v8.IJSRuntime) = (r1v0 'bMA' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
                  (wrap: com.tencent.mm.appbrand.v8.m$13 : 0x000f: CONSTRUCTOR  (r0v0 com.tencent.mm.appbrand.v8.m$13) = 
                  (r1v0 'bMA' com.tencent.mm.appbrand.v8.m)
                  (r2v1 'url2' java.lang.String)
                  (r13v0 'bVar' com.tencent.mm.appbrand.v8.m$b)
                  (r9v0 'arrayList' java.util.ArrayList<com.eclipsesource.v8.ScriptPartObject>)
                  (r11v0 'str' java.lang.String)
                  (r12v0 'str2' java.lang.String)
                 call: com.tencent.mm.appbrand.v8.m.13.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String, com.tencent.mm.appbrand.v8.m$b, java.util.ArrayList, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.m.d.a(java.util.ArrayList<com.eclipsesource.v8.ScriptPartObject>, java.net.URL, java.lang.String, java.lang.String, com.tencent.mm.appbrand.v8.m$b):void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: CONSTRUCTOR  (r0v0 com.tencent.mm.appbrand.v8.m$13) = 
                  (r1v0 'bMA' com.tencent.mm.appbrand.v8.m)
                  (r2v1 'url2' java.lang.String)
                  (r13v0 'bVar' com.tencent.mm.appbrand.v8.m$b)
                  (r9v0 'arrayList' java.util.ArrayList<com.eclipsesource.v8.ScriptPartObject>)
                  (r11v0 'str' java.lang.String)
                  (r12v0 'str2' java.lang.String)
                 call: com.tencent.mm.appbrand.v8.m.13.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String, com.tencent.mm.appbrand.v8.m$b, java.util.ArrayList, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.m.d.a(java.util.ArrayList<com.eclipsesource.v8.ScriptPartObject>, java.net.URL, java.lang.String, java.lang.String, com.tencent.mm.appbrand.v8.m$b):void, file: classes8.dex
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
                this = this;
                com.tencent.mm.appbrand.v8.m r1 = r8.bMA()
                if (r10 != 0) goto L_0x0016
                r2 = 0
            L_0x0007:
                com.tencent.mm.appbrand.v8.IJSRuntime r7 = r1.dpQ
                com.tencent.mm.appbrand.v8.m$13 r0 = new com.tencent.mm.appbrand.v8.m$13
                r3 = r13
                r4 = r9
                r5 = r11
                r6 = r12
                r0.<init>(r2, r3, r4, r5, r6)
                r7.r(r0)
                return
            L_0x0016:
                java.lang.String r2 = r10.toString()
                goto L_0x0007
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.d.a(java.util.ArrayList, java.net.URL, java.lang.String, java.lang.String, com.tencent.mm.appbrand.v8.m$b):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.m.n
        public final void invokeCallbackHandler(final int i2, final String str) {
            bMz().r(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.m.d.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(144166);
                    if (d.this.mNK == null) {
                        d.this.mNK = new AppBrandJsBridgeBinding();
                        Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by invokeCallbackHandler callbackId[%d]", Integer.valueOf(i2));
                        d.this.mNK.createRuntime(d.this.getIsolatePtr(), d.this.XK());
                    }
                    d.this.mNK.invokeCallbackHandler(i2, str);
                    AppMethodBeat.o(144166);
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.m.n
        public final void subscribeHandler(String str, String str2, int i2, String str3) {
            a(str, str2, i2, str3, (n.a) null);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.n
        public final void a(final String str, final String str2, final int i2, final String str3, final n.a aVar) {
            bMz().r(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.m.d.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(144167);
                    n.b bVar = null;
                    if (aVar != null) {
                        bVar = new n.b();
                    }
                    if (bVar != null) {
                        bVar.dqk = System.currentTimeMillis();
                    }
                    if (d.this.mNK == null) {
                        d.this.mNK = new AppBrandJsBridgeBinding();
                        Log.i("MicroMsg.AppBrandJ2V8Context", "nativeCreateRuntime triggered by subscribeHandler");
                        d.this.mNK.createRuntime(d.this.getIsolatePtr(), d.this.XK());
                    }
                    d.this.mNK.subscribeHandler(Util.nullAsNil(str), Util.nullAsNil(str2), i2, Util.nullAsNil(str3));
                    if (bVar != null) {
                        bVar.dql = System.currentTimeMillis();
                        aVar.a(bVar);
                    }
                    AppMethodBeat.o(144167);
                }
            });
        }

        @Override // com.tencent.mm.plugin.appbrand.m.l
        public void abQ(String str) {
            m bMA = bMA();
            bMA.dpQ.r(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                  (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x0004: IGET  (r1v0 com.tencent.mm.appbrand.v8.IJSRuntime) = (r0v0 'bMA' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
                  (wrap: com.tencent.mm.appbrand.v8.m$6 : 0x0008: CONSTRUCTOR  (r2v0 com.tencent.mm.appbrand.v8.m$6) = (r0v0 'bMA' com.tencent.mm.appbrand.v8.m), (r4v0 'str' java.lang.String) call: com.tencent.mm.appbrand.v8.m.6.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.m.d.abQ(java.lang.String):void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r2v0 com.tencent.mm.appbrand.v8.m$6) = (r0v0 'bMA' com.tencent.mm.appbrand.v8.m), (r4v0 'str' java.lang.String) call: com.tencent.mm.appbrand.v8.m.6.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.m.d.abQ(java.lang.String):void, file: classes8.dex
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
                this = this;
                com.tencent.mm.appbrand.v8.m r0 = r3.bMA()
                com.tencent.mm.appbrand.v8.IJSRuntime r1 = r0.dpQ
                com.tencent.mm.appbrand.v8.m$6 r2 = new com.tencent.mm.appbrand.v8.m$6
                r2.<init>(r4)
                r1.r(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.d.abQ(java.lang.String):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.m.l
        public void a(String str, String str2, ValueCallback<String> valueCallback) {
            m bMA = bMA();
            bMA.dpQ.r(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                  (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x0004: IGET  (r1v0 com.tencent.mm.appbrand.v8.IJSRuntime) = (r0v0 'bMA' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
                  (wrap: com.tencent.mm.appbrand.v8.m$7 : 0x0008: CONSTRUCTOR  (r2v0 com.tencent.mm.appbrand.v8.m$7) = (r0v0 'bMA' com.tencent.mm.appbrand.v8.m), (r4v0 'str' java.lang.String), (r5v0 'str2' java.lang.String) call: com.tencent.mm.appbrand.v8.m.7.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.m.d.a(java.lang.String, java.lang.String, android.webkit.ValueCallback<java.lang.String>):void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONSTRUCTOR  (r2v0 com.tencent.mm.appbrand.v8.m$7) = (r0v0 'bMA' com.tencent.mm.appbrand.v8.m), (r4v0 'str' java.lang.String), (r5v0 'str2' java.lang.String) call: com.tencent.mm.appbrand.v8.m.7.<init>(com.tencent.mm.appbrand.v8.m, java.lang.String, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.m.d.a(java.lang.String, java.lang.String, android.webkit.ValueCallback<java.lang.String>):void, file: classes8.dex
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
                this = this;
                com.tencent.mm.appbrand.v8.m r0 = r3.bMA()
                com.tencent.mm.appbrand.v8.IJSRuntime r1 = r0.dpQ
                com.tencent.mm.appbrand.v8.m$7 r2 = new com.tencent.mm.appbrand.v8.m$7
                r2.<init>(r4, r5)
                r1.r(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.d.a(java.lang.String, java.lang.String, android.webkit.ValueCallback):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public void resumeLoopTasks() {
            bMz().resumeLoopTasks();
        }

        @Override // com.tencent.mm.plugin.appbrand.m.q
        public boolean doInnerLoopTask() {
            return bMz().doInnerLoopTask();
        }
    }
