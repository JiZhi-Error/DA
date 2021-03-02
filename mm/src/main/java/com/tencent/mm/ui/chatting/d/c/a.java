package com.tencent.mm.ui.chatting.d.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.op;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.appbrand.d;
import com.tencent.mm.ui.appbrand.e;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.y;

public final class a extends c {
    private WxaExposedParams PvP;
    private boolean PvQ;
    private IListener<op> PvR = new IListener<op>() {
        /* class com.tencent.mm.ui.chatting.d.c.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161535);
            this.__eventId = op.class.getName().hashCode();
            AppMethodBeat.o(161535);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(op opVar) {
            boolean z = false;
            AppMethodBeat.i(35794);
            op opVar2 = opVar;
            if (opVar2.dUD == null || opVar2.dUD.dCl == null) {
                Log.e("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent event is empty");
                AppMethodBeat.o(35794);
                return false;
            }
            Log.d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", a.this.dom.getTalkerUserName(), opVar2.dUD.dCl, Integer.valueOf(opVar2.dUD.dUE));
            if (opVar2.dUD.dCl.equals(a.this.dom.getTalkerUserName())) {
                a aVar = a.this;
                if ((opVar2.dUD.dUE & 2) > 0) {
                    z = true;
                }
                aVar.PvQ = z;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.c.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(35793);
                        if (a.this.PvQ) {
                            Log.d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", Boolean.valueOf(a.this.PvQ));
                            ((aa) a.this.dom.bh(aa.class)).amB(0);
                            AppMethodBeat.o(35793);
                            return;
                        }
                        Log.d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", Boolean.valueOf(a.this.PvQ));
                        ((aa) a.this.dom.bh(aa.class)).amB(8);
                        AppMethodBeat.o(35793);
                    }
                });
            }
            AppMethodBeat.o(35794);
            return true;
        }
    };
    private String PvS = "";
    private d appBrandServiceActionSheet;
    private String appId;
    private int gwE;
    private String lSu;
    private String lSv;
    private String lSw;
    private String lSx;
    private String lSy;
    private String mSceneId;

    public a() {
        AppMethodBeat.i(35797);
        AppMethodBeat.o(35797);
    }

    static /* synthetic */ void a(a aVar, Runnable runnable) {
        AppMethodBeat.i(233267);
        aVar.aM(runnable);
        AppMethodBeat.o(233267);
    }

    @Override // com.tencent.mm.ui.chatting.d.c.c, com.tencent.mm.ui.m
    public final void gIk() {
        AppMethodBeat.i(35798);
        this.gwE = this.dom.Pwc.getIntExtra("app_brand_chatting_from_scene", 1);
        this.PvP = (WxaExposedParams) this.dom.Pwc.getParcelableExtra("app_brand_chatting_expose_params");
        this.mSceneId = Util.nullAsNil(this.dom.Pwc.getStringExtra("key_scene_id"));
        Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", Integer.valueOf(this.gwE), this.PvP, this.mSceneId);
        this.lSu = this.dom.Pwc.getStringExtra("keyPrivateAppId");
        if (!Util.isNullOrNil(this.lSu)) {
            this.lSv = this.dom.Pwc.getStringExtra("keyPrivateUserName");
            this.lSw = this.dom.Pwc.getStringExtra("keyPrivateTitle");
            this.lSx = this.dom.Pwc.getStringExtra("keyPrivateSubTitle");
            this.lSy = this.dom.Pwc.getStringExtra("keyPrivateHeadImage");
            Log.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", this.lSu, this.lSv, this.lSw, this.lSx, this.lSy);
        }
        this.appBrandServiceActionSheet = new d(this.dom.Pwc.getContext());
        WxaAttributes Xk = ((q) g.af(q.class)).Xk(this.dom.getTalkerUserName());
        this.PvQ = Xk != null && (Xk.field_appOpt & 2) > 0;
        String talkerUserName = this.dom.getTalkerUserName();
        String appId2 = getAppId();
        d.a aVar = new d.a();
        aVar.funcId = 2912;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        bou bou = new bou();
        String blX = e.blX(talkerUserName);
        if (Util.isNullOrNil(blX)) {
            bou.dNI = appId2;
            bou.LWU = "";
        } else {
            bou.dNI = e.Xw(blX);
            bou.LWU = appId2;
        }
        aVar.iLN = bou;
        aVar.iLO = new bov();
        com.tencent.mm.ak.aa.a(aVar.aXF(), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x012c: INVOKE  
              (wrap: com.tencent.mm.ak.d : 0x0123: INVOKE  (r0v29 com.tencent.mm.ak.d) = (r3v10 'aVar' com.tencent.mm.ak.d$a) type: VIRTUAL call: com.tencent.mm.ak.d.a.aXF():com.tencent.mm.ak.d)
              (wrap: com.tencent.mm.ui.appbrand.e$2 : 0x0129: CONSTRUCTOR  (r1v2 com.tencent.mm.ui.appbrand.e$2) =  call: com.tencent.mm.ui.appbrand.e.2.<init>():void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.ak.aa.a(com.tencent.mm.ak.d, com.tencent.mm.ak.aa$a):com.tencent.mm.ak.d in method: com.tencent.mm.ui.chatting.d.c.a.gIk():void, file: classes5.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0129: CONSTRUCTOR  (r1v2 com.tencent.mm.ui.appbrand.e$2) =  call: com.tencent.mm.ui.appbrand.e.2.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.d.c.a.gIk():void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.appbrand.e, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 318
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.c.a.gIk():void");
    }

    @Override // com.tencent.mm.ui.chatting.d.c.c, com.tencent.mm.ui.m
    public final void cFx() {
        AppMethodBeat.i(35799);
        this.PvR.alive();
        AppMethodBeat.o(35799);
    }

    @Override // com.tencent.mm.ui.chatting.d.c.c, com.tencent.mm.ui.m
    public final void cFy() {
        AppMethodBeat.i(35800);
        this.PvR.dead();
        AppMethodBeat.o(35800);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.a
    public final void gPx() {
        boolean z;
        AppMethodBeat.i(35801);
        Log.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
        this.PvS = e.blY(e.blX(this.dom.getTalkerUserName()));
        if (!Util.isNullOrNil(this.lSw)) {
            this.dom.Pwc.setMMTitle(this.lSw);
        } else {
            this.dom.Pwc.setMMTitle(this.dom.gOZ());
        }
        if (!Util.isNullOrNil(this.lSx)) {
            this.dom.Pwc.setMMSubTitle(this.lSx);
            if (this.lSx.equals(this.PvS)) {
                z = true;
            } else {
                z = false;
            }
        } else if (Util.isNullOrNil(this.PvS)) {
            this.dom.Pwc.setMMSubTitle(R.string.rg);
            z = false;
        } else {
            this.dom.Pwc.setMMSubTitle(MMApplicationContext.getContext().getString(R.string.rg) + "-" + this.PvS);
            z = true;
        }
        aM(null);
        ((aa) this.dom.bh(aa.class)).a(z, new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.d.c.a.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(233261);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.AppBrandServiceComponent", "MMTitleGotoBtn onClick");
                a.a(a.this.dom.Pwc.getContext(), a.this.PvP);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/appbrand/AppBrandServiceComponent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233261);
            }
        });
        if (this.PvQ) {
            ((aa) this.dom.bh(aa.class)).amB(0);
            AppMethodBeat.o(35801);
            return;
        }
        ((aa) this.dom.bh(aa.class)).amB(8);
        AppMethodBeat.o(35801);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.a
    public final void gRG() {
        AppMethodBeat.i(35802);
        this.dom.Pwc.addIconOptionMenu(0, R.string.o1, R.raw.icons_outlined_more, new y() {
            /* class com.tencent.mm.ui.chatting.d.c.a.AnonymousClass3 */

            @Override // com.tencent.mm.ui.y
            public final void ane() {
                AppMethodBeat.i(233263);
                a.this.dom.hideVKB();
                a.a(a.this, new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.c.a.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233262);
                        a.this.appBrandServiceActionSheet.username = a.this.dom.getTalkerUserName();
                        a.this.appBrandServiceActionSheet.oDm = false;
                        a.this.appBrandServiceActionSheet.scene = a.this.gwE;
                        a.this.appBrandServiceActionSheet.OMW = a.this.mSceneId;
                        a.this.appBrandServiceActionSheet.nVO = a.this.PvP;
                        if (a.this.gwE != 2 && a.this.gwE != 3) {
                            a.this.appBrandServiceActionSheet.appId = a.this.getAppId();
                            if (a.this.PvQ) {
                                a.this.appBrandServiceActionSheet.show(5);
                                AppMethodBeat.o(233262);
                                return;
                            }
                            a.this.appBrandServiceActionSheet.show(6);
                            AppMethodBeat.o(233262);
                        } else if (a.this.PvQ) {
                            a.this.appBrandServiceActionSheet.show(1);
                            AppMethodBeat.o(233262);
                        } else {
                            a.this.appBrandServiceActionSheet.show(2);
                            AppMethodBeat.o(233262);
                        }
                    }
                });
                AppMethodBeat.o(233263);
            }
        });
        AppMethodBeat.o(35802);
    }

    /* access modifiers changed from: protected */
    public final String getAppId() {
        AppMethodBeat.i(35803);
        if (!Util.isNullOrNil(this.lSu)) {
            this.appId = this.lSu;
        }
        if (Util.isNullOrNil(this.appId)) {
            WxaAttributes Xk = ((q) g.af(q.class)).Xk(this.dom.getTalkerUserName());
            this.appId = Xk == null ? null : Xk.field_appId;
        }
        if (Util.isNullOrNil(this.appId)) {
            Log.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
        }
        String str = this.appId;
        AppMethodBeat.o(35803);
        return str;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.a
    public final String gRH() {
        return this.lSy;
    }

    private void aM(final Runnable runnable) {
        AppMethodBeat.i(233265);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.c.a.AnonymousClass4 */

            public final void run() {
                String blY;
                AppMethodBeat.i(233264);
                String blX = e.blX(a.this.dom.getTalkerUserName());
                if (Util.isNullOrNil(blX)) {
                    blX = a.this.dom.getTalkerUserName();
                    if (Util.isNullOrNil(a.this.dom.gOZ())) {
                        blY = e.blY(a.this.dom.getTalkerUserName());
                    } else {
                        blY = a.this.dom.gOZ();
                    }
                } else {
                    blY = e.blY(blX);
                }
                if (a.this.gwE == 3 && TextUtils.isEmpty(a.this.PvP.nickname)) {
                    a.this.PvP.nickname = blY;
                }
                if (!(a.this.gwE == 2 || a.this.gwE == 3)) {
                    WxaExposedParams.a aVar = new WxaExposedParams.a();
                    aVar.appId = e.Xw(blX);
                    aVar.from = 4;
                    aVar.username = blX;
                    aVar.nickname = blY;
                    a.this.PvP = aVar.bAv();
                }
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(233264);
            }
        });
        AppMethodBeat.o(233265);
    }

    static /* synthetic */ void a(Context context, WxaExposedParams wxaExposedParams) {
        AppMethodBeat.i(233266);
        if (wxaExposedParams == null) {
            Log.e("MicroMsg.AppBrandServiceComponent", "exportUrlParams is null");
            AppMethodBeat.o(233266);
            return;
        }
        Log.i("MicroMsg.AppBrandServiceComponent", "exportUrlParams : %s", wxaExposedParams.toString());
        if (!Util.isNullOrNil(wxaExposedParams.username)) {
            Intent intent = new Intent();
            intent.putExtra("key_username", wxaExposedParams.username);
            intent.putExtra("key_from_scene", 8);
            intent.putExtra("key_scene_exposed_params", wxaExposedParams);
            c.b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
        }
        AppMethodBeat.o(233266);
    }
}
