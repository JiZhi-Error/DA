package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

public final class t {
    byte[] frameData = new byte[((m.czd().defaultHeight * m.czd().defaultWidth) * 4)];
    int mHeight = 480;
    boolean mStarted = false;
    private HandlerThread mThread = null;
    Timer mTimer = null;
    int mWidth = 640;
    private k qrJ = null;
    int qve = 0;
    int qvf = 0;
    final Map<String, c> qvg = new HashMap();
    private boolean qvh = true;

    public t(k kVar) {
        AppMethodBeat.i(90942);
        this.qrJ = kVar;
        AppMethodBeat.o(90942);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r9.mTimer == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r9.mTimer.cancel();
        r9.mTimer = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r9.mTimer = new java.util.Timer();
        r9.mTimer.schedule(new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t.AnonymousClass1(r9), 0, 20);
        com.tencent.matrix.trace.core.AppMethodBeat.o(90943);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean czm() {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t.czm():boolean");
    }

    public final c a(Context context, JSONObject jSONObject, boolean z) {
        v vVar = null;
        AppMethodBeat.i(186786);
        if (q.INSTANCE.qth != q.d.InRoom) {
            Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not in room, data:" + jSONObject.toString());
            AppMethodBeat.o(186786);
        } else {
            String optString = jSONObject.optString("openId", "");
            b akJ = akJ(optString);
            if (akJ == null) {
                Log.w("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "newView failed, not found member, data:" + jSONObject.toString());
                AppMethodBeat.o(186786);
            } else {
                Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "new View, mid:" + akJ.qrD + " data:" + jSONObject.toString());
                if (!jSONObject.optString("type", "camera").equals("camera")) {
                    vVar = new u(context, akJ, jSONObject);
                } else if (z) {
                    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: isSameLayer: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
                    vVar = new v(context, akJ, this.mWidth, this.mHeight);
                } else if (this.qvh) {
                    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: isUseNewPlayMode: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
                    vVar = new o(context, akJ, this.mWidth, this.mHeight);
                } else {
                    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "anlin: mWidth: " + this.mWidth + ", mHeight: " + this.mHeight);
                    vVar = new j(context, akJ, this.mWidth, this.mHeight);
                }
                if (vVar.cyX()) {
                    q qVar = q.INSTANCE;
                    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStart");
                    qVar.aj(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00dc: INVOKE  
                          (r0v15 'qVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q)
                          (wrap: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q$16 : 0x00d9: CONSTRUCTOR  (r3v3 com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q$16) = (r0v15 'qVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q) call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.16.<init>(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t.a(android.content.Context, org.json.JSONObject, boolean):com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c, file: classes7.dex
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
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00d9: CONSTRUCTOR  (r3v3 com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q$16) = (r0v15 'qVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q) call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.16.<init>(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t.a(android.content.Context, org.json.JSONObject, boolean):com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c, file: classes7.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 370
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t.a(android.content.Context, org.json.JSONObject, boolean):com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c");
                }

                public final void a(c cVar) {
                    AppMethodBeat.i(186787);
                    if (cVar.cyX()) {
                        q.INSTANCE.czi();
                    }
                    synchronized (this.qvg) {
                        try {
                            cVar.uint();
                            this.qvg.remove(cVar.getOpenId());
                        } catch (Throwable th) {
                            AppMethodBeat.o(186787);
                            throw th;
                        }
                    }
                    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "del View, viewId:" + cVar.getViewId() + " memberId:" + cVar.getMemberId());
                    AppMethodBeat.o(186787);
                }

                public final boolean isStarted() {
                    boolean z;
                    synchronized (this) {
                        z = this.mStarted;
                    }
                    return z;
                }

                /* access modifiers changed from: package-private */
                public final efj akI(String str) {
                    c cVar;
                    AppMethodBeat.i(186788);
                    Log.d("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "getVideoSize");
                    synchronized (this.qvg) {
                        try {
                            cVar = this.qvg.get(str);
                        } catch (Throwable th) {
                            AppMethodBeat.o(186788);
                            throw th;
                        }
                    }
                    if (cVar == null) {
                        AppMethodBeat.o(186788);
                        return null;
                    }
                    efj efj = new efj();
                    efj.Lnt = cVar.getMemberId();
                    efj.NfF = Math.max(cVar.getLogicWidth(), cVar.getLogicHeight());
                    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "video_length:%d", Integer.valueOf(efj.NfF));
                    AppMethodBeat.o(186788);
                    return efj;
                }

                private b akJ(String str) {
                    AppMethodBeat.i(90945);
                    if (this.qrJ == null) {
                        AppMethodBeat.o(90945);
                        return null;
                    }
                    ArrayList<b> arrayList = this.qrJ.qsr;
                    if (arrayList == null) {
                        AppMethodBeat.o(90945);
                        return null;
                    }
                    Iterator<b> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.openId.equals(str)) {
                            AppMethodBeat.o(90945);
                            return next;
                        }
                    }
                    AppMethodBeat.o(90945);
                    return null;
                }
            }
