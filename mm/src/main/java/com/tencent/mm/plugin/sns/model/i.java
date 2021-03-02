package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class i extends h<String, Integer, Boolean> {
    private int DHX;
    private String DHY;
    private List<cnb> DHZ;
    private String dPI;
    private n iuI = null;
    private String key = "";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.sns.model.h
    public final /* synthetic */ void onPostExecute(Boolean bool) {
        AppMethodBeat.i(95559);
        super.onPostExecute(bool);
        aj.faL().DHr.remove(this.key);
        aj.faL().b(this.key, this.iuI);
        AppMethodBeat.o(95559);
    }

    public i(String str, String str2, List<cnb> list) {
        AppMethodBeat.i(95556);
        aj.faL().DHr.add(str);
        this.dPI = str2;
        this.DHY = aj.getAccSnsPath();
        this.DHX = aj.fbb();
        this.DHZ = list;
        this.key = str;
        AppMethodBeat.o(95556);
    }

    @Override // com.tencent.mm.plugin.sns.model.h
    public final ExecutorService eGk() {
        AppMethodBeat.i(179085);
        ExecutorService faz = aj.faz();
        AppMethodBeat.o(179085);
        return faz;
    }

    private boolean b(String str, String str2, List<cnb> list) {
        String str3;
        AppMethodBeat.i(95558);
        Log.i("MicroMsg.MutiImageLoader", "makeMutilMedia " + str + " " + str2);
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        for (cnb cnb : list) {
            String f2 = r.f(cnb);
            String e2 = r.e(cnb);
            String ki = ar.ki(this.DHY, cnb.Id);
            if (!s.YS(ki + f2)) {
                if (!s.YS(ki + e2)) {
                    String l = r.l(cnb);
                    if (!s.YS(ki + l)) {
                        str3 = r.m(cnb);
                    } else {
                        str3 = l;
                    }
                    com.tencent.mm.plugin.sns.storage.r.a(ki, str3, e2, (float) aj.fbc());
                }
                com.tencent.mm.plugin.sns.storage.r.b(ki, e2, f2, (float) aj.fbb());
            }
            n aOq = r.aOq(ki + f2);
            if (aOq == null) {
                s.deleteFile(ki + f2);
                Log.e("MicroMsg.MutiImageLoader", "userThumb decode fail !! ".concat(String.valueOf(f2)));
                AppMethodBeat.o(95558);
                return false;
            }
            linkedList.add(aOq);
            Log.i("MicroMsg.MutiImageLoader", "getbitmap from bm " + aOq + " " + ki + f2);
            int i3 = i2 + 1;
            if (i3 < 4) {
                i2 = i3;
            }
        }
        try {
            String ki2 = ar.ki(this.DHY, str);
            s.boN(ki2);
            BitmapUtil.saveBitmapToImage(r.z(linkedList, this.DHX), 100, Bitmap.CompressFormat.JPEG, ki2 + str2, false);
            AppMethodBeat.o(95558);
            return true;
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.MutiImageLoader", e3, "makeMutilMedia failed: ".concat(String.valueOf(str2)), new Object[0]);
            AppMethodBeat.o(95558);
            return false;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.plugin.sns.model.h
    public final /* synthetic */ Boolean doInBackground(String[] strArr) {
        AppMethodBeat.i(259441);
        String aOf = r.aOf(this.dPI);
        String ki = ar.ki(this.DHY, this.dPI);
        if (!s.YS(ki + aOf)) {
            b(this.dPI, aOf, this.DHZ);
        }
        this.iuI = r.aOq(ki + aOf);
        aj.dRd().post(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005a: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0051: INVOKE  (r5v0 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.dRd():com.tencent.mm.sdk.platformtools.MMHandler)
              (wrap: com.tencent.mm.plugin.sns.model.g$3 : 0x0057: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.sns.model.g$3) = 
              (wrap: com.tencent.mm.plugin.sns.model.g : 0x0049: INVOKE  (r2v11 com.tencent.mm.plugin.sns.model.g) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.faL():com.tencent.mm.plugin.sns.model.g)
              (wrap: java.lang.String : 0x004d: IGET  (r3v0 java.lang.String) = (r8v0 'this' com.tencent.mm.plugin.sns.model.i A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.sns.model.i.dPI java.lang.String)
              (wrap: com.tencent.mm.memory.n : 0x004f: IGET  (r4v0 com.tencent.mm.memory.n) = (r8v0 'this' com.tencent.mm.plugin.sns.model.i A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.sns.model.i.iuI com.tencent.mm.memory.n)
             call: com.tencent.mm.plugin.sns.model.g.3.<init>(com.tencent.mm.plugin.sns.model.g, java.lang.String, com.tencent.mm.memory.n):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.sns.model.i.doInBackground(java.lang.String[]):java.lang.Boolean, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0057: CONSTRUCTOR  (r6v0 com.tencent.mm.plugin.sns.model.g$3) = 
              (wrap: com.tencent.mm.plugin.sns.model.g : 0x0049: INVOKE  (r2v11 com.tencent.mm.plugin.sns.model.g) =  type: STATIC call: com.tencent.mm.plugin.sns.model.aj.faL():com.tencent.mm.plugin.sns.model.g)
              (wrap: java.lang.String : 0x004d: IGET  (r3v0 java.lang.String) = (r8v0 'this' com.tencent.mm.plugin.sns.model.i A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.sns.model.i.dPI java.lang.String)
              (wrap: com.tencent.mm.memory.n : 0x004f: IGET  (r4v0 com.tencent.mm.memory.n) = (r8v0 'this' com.tencent.mm.plugin.sns.model.i A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.sns.model.i.iuI com.tencent.mm.memory.n)
             call: com.tencent.mm.plugin.sns.model.g.3.<init>(com.tencent.mm.plugin.sns.model.g, java.lang.String, com.tencent.mm.memory.n):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.model.i.doInBackground(java.lang.String[]):java.lang.Boolean, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.model.g, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.i.doInBackground(java.lang.Object[]):java.lang.Object");
    }
}
