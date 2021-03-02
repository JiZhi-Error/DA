package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.h;
import com.tencent.mm.vending.j.i;

public class ad implements com.tencent.mm.vending.c.b<ac> {
    protected ac Huo;
    public final d Hup;
    public final b Huq;
    public final c Hur;
    public final a Hus;

    public ad() {
        this(new ac());
        AppMethodBeat.i(68521);
        AppMethodBeat.o(68521);
    }

    private ad(ac acVar) {
        AppMethodBeat.i(68522);
        this.Hup = new d();
        this.Huq = new b();
        this.Hur = new c();
        this.Hus = new a();
        this.Huo = acVar;
        AppMethodBeat.o(68522);
    }

    public class d implements e<dgc, i<String, String, Integer, Integer, String, Integer, String, String>> {
        public d() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68520);
            i iVar = (i) obj;
            ac acVar = ad.this.Huo;
            String str = (String) iVar.get(0);
            String str2 = (String) iVar.get(1);
            int intValue = ((Integer) iVar.get(2)).intValue();
            int intValue2 = ((Integer) iVar.get(3)).intValue();
            int intValue3 = ((Integer) iVar.get(5)).intValue();
            Log.i("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, accountType: %s, spid: %s, purchaseScene: %s", str, Integer.valueOf(intValue2), str2, Integer.valueOf(intValue3));
            Log.d("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, purchaseFee: %s", str, Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new m(str, str2, intValue, intValue2, (String) iVar.get(4), intValue3, (String) iVar.get(6), (String) iVar.get(7)).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009b: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x0092: INVOKE  (r0v19 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.m : 0x008f: CONSTRUCTOR  (r0v18 com.tencent.mm.plugin.wallet.balance.model.lqt.m) = 
                  (r1v1 'str' java.lang.String)
                  (r2v1 'str2' java.lang.String)
                  (r3v0 'intValue' int)
                  (r4v0 'intValue2' int)
                  (wrap: java.lang.String : 0x0035: CHECK_CAST (r5v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0031: INVOKE  (r5v0 java.lang.Object) = (r15v1 'iVar' com.tencent.mm.vending.j.i), (4 int) type: VIRTUAL call: com.tencent.mm.vending.j.f.get(int):java.lang.Object))
                  (r6v0 'intValue3' int)
                  (wrap: java.lang.String : 0x0047: CHECK_CAST (r7v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0043: INVOKE  (r7v0 java.lang.Object) = (r15v1 'iVar' com.tencent.mm.vending.j.i), (6 int) type: VIRTUAL call: com.tencent.mm.vending.j.h.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x004e: CHECK_CAST (r8v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x004a: INVOKE  (r8v0 java.lang.Object) = (r15v1 'iVar' com.tencent.mm.vending.j.i), (7 int) type: VIRTUAL call: com.tencent.mm.vending.j.i.get(int):java.lang.Object))
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.m.<init>(java.lang.String, java.lang.String, int, int, java.lang.String, int, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.m.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ac$1 : 0x0098: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$1) = (r9v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r10v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0098: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$1) = (r9v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r10v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ac, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 166
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.d.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class b implements e<dhj, h<String, String, Integer, Integer, String, Integer, Integer>> {
        public b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68518);
            h hVar = (h) obj;
            ac acVar = ad.this.Huo;
            String str = (String) hVar.get(0);
            String str2 = (String) hVar.get(1);
            int intValue = ((Integer) hVar.get(2)).intValue();
            int intValue2 = ((Integer) hVar.get(3)).intValue();
            int intValue3 = ((Integer) hVar.get(5)).intValue();
            int intValue4 = ((Integer) hVar.get(6)).intValue();
            Log.i("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, accountType: %s", str, str2, Integer.valueOf(intValue2));
            Log.d("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, purchaseFee: %s", str, str2, Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new n(str, str2, intValue, intValue2, (String) hVar.get(4), intValue3, intValue4).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0094: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x008b: INVOKE  (r0v20 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.n : 0x0088: CONSTRUCTOR  (r0v19 com.tencent.mm.plugin.wallet.balance.model.lqt.n) = 
                  (r1v1 'str' java.lang.String)
                  (r2v1 'str2' java.lang.String)
                  (r3v0 'intValue' int)
                  (r4v0 'intValue2' int)
                  (wrap: java.lang.String : 0x0035: CHECK_CAST (r5v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0031: INVOKE  (r5v0 java.lang.Object) = (r14v1 'hVar' com.tencent.mm.vending.j.h), (4 int) type: VIRTUAL call: com.tencent.mm.vending.j.f.get(int):java.lang.Object))
                  (r6v0 'intValue3' int)
                  (r7v0 'intValue4' int)
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.n.<init>(java.lang.String, java.lang.String, int, int, java.lang.String, int, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.n.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ac$2 : 0x0091: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$2) = (r8v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r9v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.b.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0091: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$2) = (r8v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r9v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.b.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ac, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 159
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.b.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<dhj> a(String str, String str2, int i2, int i3, String str3, int i4, int i5) {
            AppMethodBeat.i(213855);
            com.tencent.mm.vending.g.c<dhj> c2 = g.a(str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3, Integer.valueOf(i4), Integer.valueOf(i5)).c(this);
            AppMethodBeat.o(213855);
            return c2;
        }
    }

    public class c implements e<dlv, f<Integer, String, String, Integer, String>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68519);
            f fVar = (f) obj;
            ac acVar = ad.this.Huo;
            int intValue = ((Integer) fVar.get(0)).intValue();
            String str = (String) fVar.get(1);
            String str2 = (String) fVar.get(2);
            int intValue2 = ((Integer) fVar.get(3)).intValue();
            Log.i("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemListId: %s, accountType: %s", str2, Integer.valueOf(intValue2));
            Log.d("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemFee: %s, payPasswdEnc: %s, redeemListId: %s", Integer.valueOf(intValue), str, str2);
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new p(intValue, str, str2, intValue2, (String) fVar.get(4)).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007b: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x0072: INVOKE  (r0v14 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.p : 0x006f: CONSTRUCTOR  (r0v13 com.tencent.mm.plugin.wallet.balance.model.lqt.p) = 
                  (r1v0 'intValue' int)
                  (r2v1 'str' java.lang.String)
                  (r3v1 'str2' java.lang.String)
                  (r4v0 'intValue2' int)
                  (wrap: java.lang.String : 0x0035: CHECK_CAST (r5v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0031: INVOKE  (r5v0 java.lang.Object) = (r12v1 'fVar' com.tencent.mm.vending.j.f), (4 int) type: VIRTUAL call: com.tencent.mm.vending.j.f.get(int):java.lang.Object))
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.p.<init>(int, java.lang.String, java.lang.String, int, java.lang.String):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.p.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ac$3 : 0x0078: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$3) = (r6v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r7v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.3.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.c.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0078: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$3) = (r6v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r7v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.3.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.c.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ac, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 134
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.c.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class a implements e<dec, f<Integer, ja, Integer, Integer, String>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68517);
            f fVar = (f) obj;
            ac acVar = ad.this.Huo;
            int intValue = ((Integer) fVar.get(0)).intValue();
            int intValue2 = ((Integer) fVar.get(2)).intValue();
            Log.i("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, accountType: %s", Integer.valueOf(intValue2));
            Log.d("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, redeemFee: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new l(intValue, (ja) fVar.get(1), intValue2, ((Integer) fVar.get(3)).intValue(), (String) fVar.get(4)).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0072: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x0069: INVOKE  (r0v13 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.l : 0x0066: CONSTRUCTOR  (r0v12 com.tencent.mm.plugin.wallet.balance.model.lqt.l) = 
                  (r1v0 'intValue' int)
                  (wrap: com.tencent.mm.protocal.protobuf.ja : 0x001c: CHECK_CAST (r2v1 com.tencent.mm.protocal.protobuf.ja) = (com.tencent.mm.protocal.protobuf.ja) (wrap: java.lang.Object : 0x0018: INVOKE  (r2v0 java.lang.Object) = (r14v1 'fVar' com.tencent.mm.vending.j.f), (1 int) type: VIRTUAL call: com.tencent.mm.vending.j.c.get(int):java.lang.Object))
                  (r3v0 'intValue2' int)
                  (wrap: int : 0x0030: INVOKE  (r4v0 int) = 
                  (wrap: java.lang.Integer : 0x002e: CHECK_CAST (r0v8 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x002a: INVOKE  (r0v7 java.lang.Object) = (r14v1 'fVar' com.tencent.mm.vending.j.f), (3 int) type: VIRTUAL call: com.tencent.mm.vending.j.e.get(int):java.lang.Object))
                 type: VIRTUAL call: java.lang.Integer.intValue():int)
                  (wrap: java.lang.String : 0x0039: CHECK_CAST (r5v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0035: INVOKE  (r5v0 java.lang.Object) = (r14v1 'fVar' com.tencent.mm.vending.j.f), (4 int) type: VIRTUAL call: com.tencent.mm.vending.j.f.get(int):java.lang.Object))
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.l.<init>(int, com.tencent.mm.protocal.protobuf.ja, int, int, java.lang.String):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.l.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ac$4 : 0x006f: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$4) = (r6v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r7v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.4.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006f: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.balance.model.lqt.ac$4) = (r6v0 'acVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ac), (r7v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ac.4.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ac, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ac, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 122
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.ad.a.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ ac bmc() {
        return this.Huo;
    }
}
