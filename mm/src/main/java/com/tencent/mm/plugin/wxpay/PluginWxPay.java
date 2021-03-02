package com.tencent.mm.plugin.wxpay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.co.h;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.b.a.j;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_payu.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.soter.core.biometric.FingerprintManagerProxy;
import java.util.HashMap;

public class PluginWxPay extends f implements a, c, com.tencent.mm.plugin.wxpay.a.a {
    private IListener<on> IuY = new IListener<on>() {
        /* class com.tencent.mm.plugin.wxpay.PluginWxPay.AnonymousClass2 */

        {
            AppMethodBeat.i(160905);
            this.__eventId = on.class.getName().hashCode();
            AppMethodBeat.o(160905);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(on onVar) {
            AppMethodBeat.i(72399);
            on onVar2 = onVar;
            Log.d("MicroMsg.PluginWxPay", "soter initialized: %s, %s", Integer.valueOf(onVar2.dUC.errCode), onVar2.dUC.errMsg);
            g.b(i.class, PluginWxPay.access$000(PluginWxPay.this, onVar2.dUC.errCode));
            PluginWxPay.this.JQT = true;
            AppMethodBeat.o(72399);
            return false;
        }
    };
    private boolean JQT = false;
    private h<aa> JQU = new h<>(new com.tencent.mm.co.c<aa>() {
        /* class com.tencent.mm.plugin.wxpay.PluginWxPay.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ aa get() {
            AppMethodBeat.i(72398);
            aa aaVar = new aa(g.aAh().hqK);
            AppMethodBeat.o(72398);
            return aaVar;
        }
    });

    public PluginWxPay() {
        AppMethodBeat.i(72400);
        AppMethodBeat.o(72400);
    }

    static /* synthetic */ i access$000(PluginWxPay pluginWxPay, int i2) {
        AppMethodBeat.i(72409);
        i biometricPayManager = pluginWxPay.biometricPayManager(i2);
        AppMethodBeat.o(72409);
        return biometricPayManager;
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-wxpay";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(72401);
        alias(com.tencent.mm.plugin.wxpay.a.a.class);
        com.tencent.mm.plugin.fingerprint.b.c cVar = new com.tencent.mm.plugin.fingerprint.b.c();
        com.tencent.mm.plugin.fingerprint.b.a.g gVar = new com.tencent.mm.plugin.fingerprint.b.a.g();
        cVar.a(gVar);
        g.b(com.tencent.mm.plugin.fingerprint.d.a.class, cVar);
        g.b(i.class, gVar);
        g.b(com.tencent.mm.plugin.wallet.wecoin.a.c.class, new com.tencent.mm.plugin.wallet.wecoin.model.g());
        this.IuY.alive();
        AppMethodBeat.o(72401);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void uninstalled() {
        AppMethodBeat.i(72402);
        super.uninstalled();
        this.IuY.dead();
        AppMethodBeat.o(72402);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(72403);
        if (gVar.aBb()) {
            pin(new y(b.class));
            pin(new y(com.tencent.mm.plugin.collect.a.a.class));
            pin(new y(com.tencent.mm.plugin.luckymoney.b.a.class));
            pin(new y(k.class));
            pin(new y(com.tencent.mm.plugin.offline.k.class));
            pin(new y(com.tencent.mm.plugin.order.a.b.class));
            pin(new y(com.tencent.mm.plugin.product.a.a.class));
            pin(new y(com.tencent.mm.plugin.recharge.a.a.class));
            pin(new y(com.tencent.mm.plugin.remittance.a.c.class));
            pin(new y(s.class));
            pin(new y(t.class));
            pin(new y(com.tencent.mm.plugin.wallet_index.a.a.class));
            pin(new y(d.class));
            pin(new y(com.tencent.mm.plugin.wxcredit.a.class));
            pin(new y(com.tencent.mm.plugin.fingerprint.a.class));
            pin(new y(com.tencent.mm.plugin.wallet_ecard.a.class));
            pin(new y(com.tencent.mm.plugin.honey_pay.a.class));
            com.tencent.mm.vfs.y.at("wallet", "wallet", 7);
        }
        g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
        g.a(com.tencent.mm.plugin.luckymoney.a.a.class, new e(new r()));
        g.a(com.tencent.mm.plugin.wxpaysdk.api.b.class, new e(new com.tencent.mm.plugin.remittance.a.b()));
        g.a(com.tencent.mm.plugin.wxpaysdk.api.c.class, new e(new com.tencent.mm.plugin.wallet_core.a()));
        AppMethodBeat.o(72403);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(72404);
        if (gVar.aBb()) {
            com.tencent.mm.br.b.bfQ("wallet");
            com.tencent.mm.br.b.bfQ("mall");
            com.tencent.mm.br.b.bfQ("wxcredit");
            com.tencent.mm.br.b.bfQ("offline");
            com.tencent.mm.br.b.bfQ("recharge");
            com.tencent.mm.br.b.bfQ("wallet_index");
            com.tencent.mm.br.b.bfQ("order");
            com.tencent.mm.br.b.bfQ("product");
            com.tencent.mm.br.b.bfQ("remittance");
            com.tencent.mm.br.b.bfQ("collect");
            com.tencent.mm.br.b.bfQ("wallet_payu");
            com.tencent.mm.br.b.bfQ("luckymoney");
            com.tencent.mm.br.b.bfQ(FingerprintManagerProxy.FINGERPRINT_SERVICE);
        }
        AppMethodBeat.o(72404);
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public aa getWalletCacheStg() {
        AppMethodBeat.i(72405);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(72405);
            throw bVar;
        }
        aa aaVar = this.JQU.get();
        AppMethodBeat.o(72405);
        return aaVar;
    }

    private i biometricPayManager(int i2) {
        AppMethodBeat.i(72406);
        j jVar = new j();
        if (jVar.dKp()) {
            jVar.prepare();
            AppMethodBeat.o(72406);
            return jVar;
        }
        com.tencent.mm.plugin.fingerprint.b.a.h hVar = new com.tencent.mm.plugin.fingerprint.b.a.h();
        if (hVar.dKp()) {
            hVar.prepare();
            AppMethodBeat.o(72406);
            return hVar;
        }
        com.tencent.mm.plugin.fingerprint.b.a.g gVar = new com.tencent.mm.plugin.fingerprint.b.a.g();
        AppMethodBeat.o(72406);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public void triggerSoterReInit() {
        AppMethodBeat.i(72407);
        Log.d("MicroMsg.PluginWxPay", "re init soter");
        i iVar = (i) g.af(i.class);
        if (iVar.dKu() == 0) {
            iVar.prepare();
        }
        AppMethodBeat.o(72407);
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public boolean hasInitBiometricManager() {
        return this.JQT;
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public void onExitRedPacketPreviewChatting() {
        AppMethodBeat.i(163878);
        com.tencent.mm.plugin.luckymoney.a.b.ees();
        AppMethodBeat.o(163878);
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public void gotoLuckyMoneyReceiveUI(Context context, Bundle bundle, k.b bVar) {
        AppMethodBeat.i(258761);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("key_way", 0);
        intent.putExtra("key_native_url", bVar.iyr);
        intent.putExtra("scene_id", Integer.parseInt(bVar.iyq));
        intent.putExtra("key_invalidtime", bVar.ixR);
        com.tencent.mm.ag.c cVar = (com.tencent.mm.ag.c) bVar.as(com.tencent.mm.ag.c.class);
        com.tencent.mm.ag.g gVar = (com.tencent.mm.ag.g) bVar.as(com.tencent.mm.ag.g.class);
        intent.putExtra("key_exclusive_username", cVar.iwa);
        intent.putExtra("key_cropname", cVar.ivR);
        intent.putExtra("key_receive_envelope_url", cVar.ivW);
        intent.putExtra("key_receive_envelope_md5", cVar.ivX);
        intent.putExtra("key_detail_envelope_url", cVar.ivY);
        intent.putExtra("key_detail_envelope_md5", cVar.ivZ);
        intent.putExtra("key_about_url", gVar.iwt);
        intent.putExtra("key_packet_id", gVar.iwu);
        intent.putExtra("key_has_story", gVar.iwx);
        intent.putExtra("key_material_flag", gVar.iwy);
        com.tencent.mm.br.c.b(context, "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", intent);
        AppMethodBeat.o(258761);
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(72408);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("WALLET_CACHE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wxpay.PluginWxPay.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return aa.SQL_CREATE;
            }
        });
        AppMethodBeat.o(72408);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public void doRedPacketPreviewLoading(Context context, String str) {
        AppMethodBeat.i(163876);
        Log.i("MicroMsg.LuckyMoneyEnvelopePreview", "do get red packet preview: %s", str);
        com.tencent.mm.plugin.luckymoney.model.f fVar = new com.tencent.mm.plugin.luckymoney.model.f(str);
        fVar.aYI().h(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0038: INVOKE  
              (wrap: com.tencent.mm.co.f : 0x002f: INVOKE  (r1v2 com.tencent.mm.co.f) = (r6v0 'fVar' com.tencent.mm.plugin.luckymoney.model.f) type: VIRTUAL call: com.tencent.mm.plugin.luckymoney.model.f.aYI():com.tencent.mm.co.f)
              (wrap: com.tencent.mm.plugin.luckymoney.model.s$2 : 0x0035: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.luckymoney.model.s$2) = 
              (wrap: com.tencent.mm.ui.base.q : 0x002b: INVOKE  (r0v3 com.tencent.mm.ui.base.q) = 
              (r9v0 'context' android.content.Context)
              (3 int)
              (wrap: int : ?: CAST (int) (wrap: ?? : ?: SGET   com.tencent.mm.R.style.lj int))
              (wrap: java.lang.String : 0x0021: INVOKE  (r3v1 java.lang.String) = (r9v0 'context' android.content.Context), (wrap: int : ?: SGET   com.tencent.mm.R.string.ekc int) type: VIRTUAL call: android.content.Context.getString(int):java.lang.String)
              true
              (wrap: android.content.DialogInterface$OnCancelListener : ?: CAST (android.content.DialogInterface$OnCancelListener) (wrap: com.tencent.mm.plugin.luckymoney.model.s$1 : 0x0027: CONSTRUCTOR  (r5v0 com.tencent.mm.plugin.luckymoney.model.s$1) = (r6v0 'fVar' com.tencent.mm.plugin.luckymoney.model.f) call: com.tencent.mm.plugin.luckymoney.model.s.1.<init>(com.tencent.mm.plugin.luckymoney.model.f):void type: CONSTRUCTOR))
             type: STATIC call: com.tencent.mm.ui.base.h.a(android.content.Context, int, int, java.lang.String, boolean, android.content.DialogInterface$OnCancelListener):com.tencent.mm.ui.base.q)
              (r9v0 'context' android.content.Context)
             call: com.tencent.mm.plugin.luckymoney.model.s.2.<init>(com.tencent.mm.ui.base.q, android.content.Context):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wxpay.PluginWxPay.doRedPacketPreviewLoading(android.content.Context, java.lang.String):void, file: classes5.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.luckymoney.model.s$2) = 
              (wrap: com.tencent.mm.ui.base.q : 0x002b: INVOKE  (r0v3 com.tencent.mm.ui.base.q) = 
              (r9v0 'context' android.content.Context)
              (3 int)
              (wrap: int : ?: CAST (int) (wrap: ?? : ?: SGET   com.tencent.mm.R.style.lj int))
              (wrap: java.lang.String : 0x0021: INVOKE  (r3v1 java.lang.String) = (r9v0 'context' android.content.Context), (wrap: int : ?: SGET   com.tencent.mm.R.string.ekc int) type: VIRTUAL call: android.content.Context.getString(int):java.lang.String)
              true
              (wrap: android.content.DialogInterface$OnCancelListener : ?: CAST (android.content.DialogInterface$OnCancelListener) (wrap: com.tencent.mm.plugin.luckymoney.model.s$1 : 0x0027: CONSTRUCTOR  (r5v0 com.tencent.mm.plugin.luckymoney.model.s$1) = (r6v0 'fVar' com.tencent.mm.plugin.luckymoney.model.f) call: com.tencent.mm.plugin.luckymoney.model.s.1.<init>(com.tencent.mm.plugin.luckymoney.model.f):void type: CONSTRUCTOR))
             type: STATIC call: com.tencent.mm.ui.base.h.a(android.content.Context, int, int, java.lang.String, boolean, android.content.DialogInterface$OnCancelListener):com.tencent.mm.ui.base.q)
              (r9v0 'context' android.content.Context)
             call: com.tencent.mm.plugin.luckymoney.model.s.2.<init>(com.tencent.mm.ui.base.q, android.content.Context):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wxpay.PluginWxPay.doRedPacketPreviewLoading(android.content.Context, java.lang.String):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.luckymoney.model.s, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            r7 = 163876(0x28024, float:2.29639E-40)
            r4 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            java.lang.String r0 = "MicroMsg.LuckyMoneyEnvelopePreview"
            java.lang.String r1 = "do get red packet preview: %s"
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r3 = 0
            r2[r3] = r10
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
            com.tencent.mm.plugin.luckymoney.model.f r6 = new com.tencent.mm.plugin.luckymoney.model.f
            r6.<init>(r10)
            r1 = 3
            r2 = 2131821007(0x7f1101cf, float:1.9274745E38)
            r0 = 2131762446(0x7f101d0e, float:1.915597E38)
            java.lang.String r3 = r9.getString(r0)
            com.tencent.mm.plugin.luckymoney.model.s$1 r5 = new com.tencent.mm.plugin.luckymoney.model.s$1
            r5.<init>(r6)
            r0 = r9
            com.tencent.mm.ui.base.q r0 = com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4, r5)
            com.tencent.mm.co.f r1 = r6.aYI()
            com.tencent.mm.plugin.luckymoney.model.s$2 r2 = new com.tencent.mm.plugin.luckymoney.model.s$2
            r2.<init>(r0, r9)
            r1.h(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wxpay.PluginWxPay.doRedPacketPreviewLoading(android.content.Context, java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public void gotoRedPacketPreviewUI(Context context, String str) {
        AppMethodBeat.i(163877);
        com.tencent.mm.plugin.luckymoney.model.s.hWd();
        com.tencent.mm.plugin.luckymoney.model.s.hWc();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", "1@fackuser");
        intent.putExtra("finish_direct", false);
        intent.putExtra("key_red_packet_preview_url", str);
        com.tencent.mm.br.c.f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(163877);
    }

    @Override // com.tencent.mm.plugin.wxpay.a.a
    public void beforeJumpRedPacketPreviewUI() {
        AppMethodBeat.i(258760);
        com.tencent.mm.plugin.luckymoney.model.s.hWd();
        com.tencent.mm.plugin.luckymoney.model.s.hWc();
        AppMethodBeat.o(258760);
    }
}
