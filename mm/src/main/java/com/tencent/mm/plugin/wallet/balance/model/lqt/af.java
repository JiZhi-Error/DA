package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class af implements com.tencent.mm.vending.c.b<ae> {
    protected ae HuL;
    public final d HuM;
    public final a HuN;
    public final b HuO;
    public final e HuP;
    public final c HuQ;

    public af() {
        this(new ae());
        AppMethodBeat.i(68545);
        AppMethodBeat.o(68545);
    }

    public af(ae aeVar) {
        AppMethodBeat.i(68546);
        this.HuM = new d();
        this.HuN = new a();
        this.HuO = new b();
        this.HuP = new e();
        this.HuQ = new c();
        this.HuL = aeVar;
        AppMethodBeat.o(68546);
    }

    public class d implements com.tencent.mm.vending.h.e<dhj, com.tencent.mm.vending.j.d<Integer, Integer, Bankcard>> {
        public d() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68542);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            ae aeVar = af.this.HuL;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            Bankcard bankcard = (Bankcard) dVar.get(2);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(intValue2);
            objArr[1] = bankcard != null ? bankcard.field_bindSerial : "";
            Log.i("MicroMsg.LqtSaveFetchLogic", "saveLqt, accountType: %s, bankcard: %s", objArr);
            Log.d("MicroMsg.LqtSaveFetchLogic", "saveLqt, amount: %s", Integer.valueOf(intValue));
            String stringExtra = aeVar.Huz.getIntent().getStringExtra("lqt_save_fund_code");
            String stringExtra2 = aeVar.Huz.getIntent().getStringExtra("lqt_fund_spid");
            String stringExtra3 = aeVar.Huz.getIntent().getStringExtra("operate_id");
            aeVar.HuB = intValue;
            aeVar.accountType = intValue2;
            String str = bankcard.field_bankcardType;
            String str2 = bankcard.field_bindSerial;
            aeVar.Huz.showLoading(true);
            g.a(g.a(stringExtra, stringExtra2, Integer.valueOf(intValue), Integer.valueOf(intValue2), stringExtra3, Integer.valueOf(aeVar.HuF), str, str2).c(aeVar.Huy.Hup).c(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00bb: INVOKE  
                  (wrap: com.tencent.mm.vending.g.d : 0x00b7: INVOKE  (r0v17 com.tencent.mm.vending.g.d) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x00ae: INVOKE  (r0v16 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x00a5: INVOKE  (r0v15 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x009c: INVOKE  (r0v14 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0094: INVOKE  (r0v13 com.tencent.mm.vending.g.c) = 
                  (r0v12 'stringExtra' java.lang.String)
                  (r1v5 'stringExtra2' java.lang.String)
                  (wrap: java.lang.Integer : 0x0086: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x008a: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r4v5 'stringExtra3' java.lang.String)
                  (wrap: java.lang.Integer : 0x0090: INVOKE  (r5v6 java.lang.Integer) = 
                  (wrap: int : 0x008e: IGET  (r5v5 int) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.HuF int)
                 type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r6v1 'str' java.lang.String)
                  (r7v0 'str2' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.a(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d : 0x009a: IGET  (r1v7 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0098: IGET  (r1v6 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hup com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7 : 0x00a2: CONSTRUCTOR  (r1v8 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.7.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$6 : 0x00ab: CONSTRUCTOR  (r1v9 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$6) = 
                  (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae)
                  (r8v1 'bankcard' com.tencent.mm.plugin.wallet_core.model.Bankcard)
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.6.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae, com.tencent.mm.plugin.wallet_core.model.Bankcard):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$1 : 0x00b4: CONSTRUCTOR  (r1v10 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$1) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.a(com.tencent.mm.vending.g.d$a):com.tencent.mm.vending.g.d)
                 type: STATIC call: com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.d):void in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b7: INVOKE  (r0v17 com.tencent.mm.vending.g.d) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x00ae: INVOKE  (r0v16 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x00a5: INVOKE  (r0v15 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x009c: INVOKE  (r0v14 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0094: INVOKE  (r0v13 com.tencent.mm.vending.g.c) = 
                  (r0v12 'stringExtra' java.lang.String)
                  (r1v5 'stringExtra2' java.lang.String)
                  (wrap: java.lang.Integer : 0x0086: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x008a: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r4v5 'stringExtra3' java.lang.String)
                  (wrap: java.lang.Integer : 0x0090: INVOKE  (r5v6 java.lang.Integer) = 
                  (wrap: int : 0x008e: IGET  (r5v5 int) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.HuF int)
                 type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r6v1 'str' java.lang.String)
                  (r7v0 'str2' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.a(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d : 0x009a: IGET  (r1v7 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0098: IGET  (r1v6 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hup com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7 : 0x00a2: CONSTRUCTOR  (r1v8 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.7.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$6 : 0x00ab: CONSTRUCTOR  (r1v9 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$6) = 
                  (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae)
                  (r8v1 'bankcard' com.tencent.mm.plugin.wallet_core.model.Bankcard)
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.6.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae, com.tencent.mm.plugin.wallet_core.model.Bankcard):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$1 : 0x00b4: CONSTRUCTOR  (r1v10 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$1) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.a(com.tencent.mm.vending.g.d$a):com.tencent.mm.vending.g.d in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ae: INVOKE  (r0v16 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x00a5: INVOKE  (r0v15 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x009c: INVOKE  (r0v14 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0094: INVOKE  (r0v13 com.tencent.mm.vending.g.c) = 
                  (r0v12 'stringExtra' java.lang.String)
                  (r1v5 'stringExtra2' java.lang.String)
                  (wrap: java.lang.Integer : 0x0086: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x008a: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r4v5 'stringExtra3' java.lang.String)
                  (wrap: java.lang.Integer : 0x0090: INVOKE  (r5v6 java.lang.Integer) = 
                  (wrap: int : 0x008e: IGET  (r5v5 int) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.HuF int)
                 type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r6v1 'str' java.lang.String)
                  (r7v0 'str2' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.a(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d : 0x009a: IGET  (r1v7 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0098: IGET  (r1v6 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hup com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7 : 0x00a2: CONSTRUCTOR  (r1v8 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.7.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$6 : 0x00ab: CONSTRUCTOR  (r1v9 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$6) = 
                  (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae)
                  (r8v1 'bankcard' com.tencent.mm.plugin.wallet_core.model.Bankcard)
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.6.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae, com.tencent.mm.plugin.wallet_core.model.Bankcard):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a5: INVOKE  (r0v15 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x009c: INVOKE  (r0v14 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0094: INVOKE  (r0v13 com.tencent.mm.vending.g.c) = 
                  (r0v12 'stringExtra' java.lang.String)
                  (r1v5 'stringExtra2' java.lang.String)
                  (wrap: java.lang.Integer : 0x0086: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x008a: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r4v5 'stringExtra3' java.lang.String)
                  (wrap: java.lang.Integer : 0x0090: INVOKE  (r5v6 java.lang.Integer) = 
                  (wrap: int : 0x008e: IGET  (r5v5 int) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.HuF int)
                 type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r6v1 'str' java.lang.String)
                  (r7v0 'str2' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.a(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d : 0x009a: IGET  (r1v7 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0098: IGET  (r1v6 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hup com.tencent.mm.plugin.wallet.balance.model.lqt.ad$d)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7 : 0x00a2: CONSTRUCTOR  (r1v8 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.7.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 26 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a2: CONSTRUCTOR  (r1v8 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$7) = (r9v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.7.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 32 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ae, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 38 more
                */
            /*
            // Method dump skipped, instructions count: 200
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.af.d.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class a implements com.tencent.mm.vending.h.e<dlv, com.tencent.mm.vending.j.e<Integer, Integer, Integer, ja>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68540);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            ae aeVar = af.this.HuL;
            int intValue = ((Integer) eVar.get(0)).intValue();
            int intValue2 = ((Integer) eVar.get(1)).intValue();
            int intValue3 = ((Integer) eVar.get(2)).intValue();
            Log.i("MicroMsg.LqtSaveFetchLogic", "fetchLqt, accountType: %s, %s", Integer.valueOf(intValue2), Integer.valueOf(intValue3));
            Log.d("MicroMsg.LqtSaveFetchLogic", "fetchLqt, amount: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            aeVar.HuC = intValue;
            String stringExtra = aeVar.Huz.getIntent().getStringExtra("operate_id");
            aeVar.accountType = intValue2;
            aeVar.Huz.showLoading(true);
            g.a(g.b(Integer.valueOf(intValue), (ja) eVar.get(3), Integer.valueOf(intValue2), Integer.valueOf(intValue3), stringExtra).c(aeVar.Huy.Hus).c(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a2: INVOKE  
                  (wrap: com.tencent.mm.vending.g.d : 0x009e: INVOKE  (r0v13 com.tencent.mm.vending.g.d) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0095: INVOKE  (r0v12 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x008c: INVOKE  (r0v11 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0084: INVOKE  (r0v10 com.tencent.mm.vending.g.c) = 
                  (wrap: java.lang.Integer : 0x0078: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: com.tencent.mm.protocal.protobuf.ja : 0x0032: CHECK_CAST (r0v9 com.tencent.mm.protocal.protobuf.ja) = (com.tencent.mm.protocal.protobuf.ja) (wrap: java.lang.Object : 0x002e: INVOKE  (r0v8 java.lang.Object) = (r14v1 'eVar' com.tencent.mm.vending.j.e), (3 int) type: VIRTUAL call: com.tencent.mm.vending.j.e.get(int):java.lang.Object))
                  (wrap: java.lang.Integer : 0x007c: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x0080: INVOKE  (r4v1 java.lang.Integer) = (r4v0 'intValue3' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r5v4 'stringExtra' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.b(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a : 0x008a: IGET  (r2v3 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0088: IGET  (r2v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hus com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10 : 0x0092: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.10.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$9 : 0x009b: CONSTRUCTOR  (r2v5 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$9) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.9.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.a(com.tencent.mm.vending.g.d$a):com.tencent.mm.vending.g.d)
                 type: STATIC call: com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.d):void in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009e: INVOKE  (r0v13 com.tencent.mm.vending.g.d) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0095: INVOKE  (r0v12 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x008c: INVOKE  (r0v11 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0084: INVOKE  (r0v10 com.tencent.mm.vending.g.c) = 
                  (wrap: java.lang.Integer : 0x0078: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: com.tencent.mm.protocal.protobuf.ja : 0x0032: CHECK_CAST (r0v9 com.tencent.mm.protocal.protobuf.ja) = (com.tencent.mm.protocal.protobuf.ja) (wrap: java.lang.Object : 0x002e: INVOKE  (r0v8 java.lang.Object) = (r14v1 'eVar' com.tencent.mm.vending.j.e), (3 int) type: VIRTUAL call: com.tencent.mm.vending.j.e.get(int):java.lang.Object))
                  (wrap: java.lang.Integer : 0x007c: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x0080: INVOKE  (r4v1 java.lang.Integer) = (r4v0 'intValue3' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r5v4 'stringExtra' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.b(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a : 0x008a: IGET  (r2v3 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0088: IGET  (r2v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hus com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10 : 0x0092: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.10.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$9 : 0x009b: CONSTRUCTOR  (r2v5 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$9) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.9.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.a(com.tencent.mm.vending.g.d$a):com.tencent.mm.vending.g.d in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0095: INVOKE  (r0v12 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x008c: INVOKE  (r0v11 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x0084: INVOKE  (r0v10 com.tencent.mm.vending.g.c) = 
                  (wrap: java.lang.Integer : 0x0078: INVOKE  (r2v1 java.lang.Integer) = (r2v0 'intValue' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: com.tencent.mm.protocal.protobuf.ja : 0x0032: CHECK_CAST (r0v9 com.tencent.mm.protocal.protobuf.ja) = (com.tencent.mm.protocal.protobuf.ja) (wrap: java.lang.Object : 0x002e: INVOKE  (r0v8 java.lang.Object) = (r14v1 'eVar' com.tencent.mm.vending.j.e), (3 int) type: VIRTUAL call: com.tencent.mm.vending.j.e.get(int):java.lang.Object))
                  (wrap: java.lang.Integer : 0x007c: INVOKE  (r3v1 java.lang.Integer) = (r3v0 'intValue2' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (wrap: java.lang.Integer : 0x0080: INVOKE  (r4v1 java.lang.Integer) = (r4v0 'intValue3' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r5v4 'stringExtra' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.b(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a : 0x008a: IGET  (r2v3 com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ad : 0x0088: IGET  (r2v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ad) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.Huy com.tencent.mm.plugin.wallet.balance.model.lqt.ad)
                 com.tencent.mm.plugin.wallet.balance.model.lqt.ad.Hus com.tencent.mm.plugin.wallet.balance.model.lqt.ad$a)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10 : 0x0092: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.10.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0092: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$10) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.10.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 26 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ae, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 32 more
                */
            /*
            // Method dump skipped, instructions count: 170
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.af.a.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<dlv> a(int i2, int i3, int i4, ja jaVar) {
            AppMethodBeat.i(213866);
            com.tencent.mm.vending.g.c<dlv> c2 = g.a(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jaVar).c(this);
            AppMethodBeat.o(213866);
            return c2;
        }
    }

    public class b implements com.tencent.mm.vending.h.e<ad, Integer> {
        public b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            AppMethodBeat.i(68541);
            ae aeVar = af.this.HuL;
            int intValue = ((Integer) obj).intValue();
            aeVar.jSi = g.hdx();
            aeVar.jSi.hdw();
            WalletBaseUI walletBaseUI = aeVar.Huz;
            if (intValue == 1) {
                i2 = 24;
            } else {
                i2 = 25;
            }
            walletBaseUI.doSceneProgress(new ad(null, i2), true);
            AppMethodBeat.o(68541);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class e implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<Integer, Integer, Integer>> {
        public e() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68544);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            af.this.HuL.aI(((Integer) dVar.get(0)).intValue(), ((Integer) dVar.get(1)).intValue(), ((Integer) dVar.get(2)).intValue());
            Void r0 = QZL;
            AppMethodBeat.o(68544);
            return r0;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<Void> jQ(int i2, int i3) {
            AppMethodBeat.i(68543);
            com.tencent.mm.vending.g.c<Void> c2 = g.h(Integer.valueOf(i2), Integer.valueOf(i3), 1).c(this);
            AppMethodBeat.o(68543);
            return c2;
        }
    }

    public class c implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(213868);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            ae aeVar = af.this.HuL;
            int intValue = ((Integer) cVar.get(0)).intValue();
            int intValue2 = ((Integer) cVar.get(1)).intValue();
            Log.i("MicroMsg.LqtSaveFetchLogic", "reportLqtSaveShowingAndClickState, clickState: %s, showingState: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            aeVar.jSi = g.hdx();
            aeVar.jSi.hdw();
            new s(intValue, intValue2).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0053: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x004a: INVOKE  (r0v6 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.s : 0x0047: CONSTRUCTOR  (r3v3 com.tencent.mm.plugin.wallet.balance.model.lqt.s) = (r2v0 'intValue' int), (r0v5 'intValue2' int) call: com.tencent.mm.plugin.wallet.balance.model.lqt.s.<init>(int, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.s.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$5 : 0x0050: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$5) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.5.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.c.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$5) = (r1v0 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.5.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.af.c.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ae, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r9 = 213868(0x3436c, float:2.99693E-40)
                r8 = 1
                r7 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r9)
                com.tencent.mm.vending.j.c r11 = (com.tencent.mm.vending.j.c) r11
                com.tencent.mm.plugin.wallet.balance.model.lqt.af r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.af.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.ae r1 = r0.HuL
                java.lang.Object r0 = r11.get(r7)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r2 = r0.intValue()
                java.lang.Object r0 = r11.get(r8)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.lang.String r3 = "MicroMsg.LqtSaveFetchLogic"
                java.lang.String r4 = "reportLqtSaveShowingAndClickState, clickState: %s, showingState: %s"
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
                r5[r7] = r6
                java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
                r5[r8] = r6
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)
                com.tencent.mm.vending.g.b r3 = com.tencent.mm.vending.g.g.hdx()
                r1.jSi = r3
                com.tencent.mm.vending.g.b r3 = r1.jSi
                r3.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.s r3 = new com.tencent.mm.plugin.wallet.balance.model.lqt.s
                r3.<init>(r2, r0)
                com.tencent.mm.co.f r0 = r3.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.ae$5 r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.ae$5
                r2.<init>()
                r0.b(r2)
                java.lang.Void r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.af.c.QZL
                com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.af.c.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<Void> jP(int i2, int i3) {
            AppMethodBeat.i(213867);
            com.tencent.mm.vending.g.c<Void> c2 = g.O(Integer.valueOf(i2), Integer.valueOf(i3)).c(this);
            AppMethodBeat.o(213867);
            return c2;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ ae bmc() {
        return this.HuL;
    }
}
