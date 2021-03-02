package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.m;
import com.tencent.mm.g.a.s;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.appbrand.f;
import com.tencent.mm.ui.chatting.d.c.b;
import java.io.ByteArrayOutputStream;

public class AppBrandServiceChattingUI extends ChattingUI {
    @Override // com.tencent.mm.ui.chatting.ChattingUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.chatting.ChattingUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34218);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        AppMethodBeat.o(34218);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.ChattingUI
    public final ChattingUIFragment gMI() {
        AppMethodBeat.i(34219);
        AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI((byte) 0);
        AppMethodBeat.o(34219);
        return appBrandServiceChattingFmUI;
    }

    @SuppressLint({"ValidFragment"})
    public static class AppBrandServiceChattingFmUI extends ChattingUIFragment {
        private byte[] PdQ;
        private final ChatFooter.g PdR = new ChatFooter.g() {
            /* class com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.g
            public final boolean An(boolean z) {
                AppMethodBeat.i(34199);
                if (AppBrandServiceChattingFmUI.this.lgs != null) {
                    WxaAttributes.b.a aVar = AppBrandServiceChattingFmUI.this.lgs.lgB.get(0);
                    if (AppBrandServiceChattingFmUI.this.fromScene != 2 || !AppBrandServiceChattingFmUI.this.nVO.username.equals(aVar.userName)) {
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1080;
                        ((r) g.af(r.class)).a(AppBrandServiceChattingFmUI.this.getContext(), aVar.userName, "", 0, aVar.version, aVar.dCx, appBrandStatObject, AppBrandServiceChattingFmUI.d(AppBrandServiceChattingFmUI.this));
                        AppMethodBeat.o(34199);
                    } else {
                        Log.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", aVar.userName, aVar.dCx);
                        AppBrandServiceChattingFmUI.a(AppBrandServiceChattingFmUI.this, aVar.dCx);
                        AppMethodBeat.o(34199);
                    }
                } else {
                    Log.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
                    AppMethodBeat.o(34199);
                }
                return true;
            }
        };
        private f PdS;
        private b PdT = new b(new com.tencent.mm.ui.chatting.d.c.a());
        private String appId;
        private int fromScene;
        private String lSf;
        private String lSg;
        private String lSh;
        private boolean lSi;
        private String lSj;
        private boolean lSk;
        private WxaAttributes.b lgs;
        private String mSceneId;
        private WxaExposedParams nVO;
        private i ptq = new i() {
            /* class com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.span.i
            public final Object a(u uVar) {
                AppMethodBeat.i(34200);
                switch (uVar.type) {
                    case 1:
                    case 25:
                    case 30:
                    case 31:
                        String talkerUserName = AppBrandServiceChattingFmUI.this.dom.getTalkerUserName();
                        AppMethodBeat.o(34200);
                        return talkerUserName;
                    default:
                        AppMethodBeat.o(34200);
                        return null;
                }
            }

            @Override // com.tencent.mm.pluginsdk.ui.span.i
            public final Object b(u uVar) {
                AppMethodBeat.i(34201);
                if (uVar.type == 45) {
                    String str = new String(Base64.decode(uVar.url, 0));
                    String str2 = new String(Base64.decode(Util.nullAs((String) uVar.ba(String.class), ""), 0));
                    Log.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", str, str2);
                    if (AppBrandServiceChattingFmUI.this.fromScene != 2 || !AppBrandServiceChattingFmUI.this.nVO.appId.equals(str)) {
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1081;
                        ((r) g.af(r.class)).a(AppBrandServiceChattingFmUI.this.getContext(), (String) null, str, 0, 0, str2, appBrandStatObject);
                    } else {
                        Log.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", str, str2);
                        AppBrandServiceChattingFmUI.a(AppBrandServiceChattingFmUI.this, str2);
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.o(34201);
                        return bool;
                    }
                }
                AppMethodBeat.o(34201);
                return null;
            }
        };

        static /* synthetic */ String d(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI) {
            AppMethodBeat.i(34217);
            String appId2 = appBrandServiceChattingFmUI.getAppId();
            AppMethodBeat.o(34217);
            return appId2;
        }

        public AppBrandServiceChattingFmUI() {
            AppMethodBeat.i(34205);
            AppMethodBeat.o(34205);
        }

        public AppBrandServiceChattingFmUI(byte b2) {
            super((byte) 0);
            AppMethodBeat.i(34206);
            AppMethodBeat.o(34206);
        }

        private static byte[] gMK() {
            AppMethodBeat.i(232831);
            try {
                Bitmap createBitmap = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap).drawColor(-1);
                byte[] Bitmap2Bytes = BitmapUtil.Bitmap2Bytes(createBitmap);
                AppMethodBeat.o(232831);
                return Bitmap2Bytes;
            } catch (Exception e2) {
                Log.i("MicroMsg.AppBrandServiceChattingUI", "obtainMessageDefaultImg fail:%s", e2);
                byte[] bArr = new byte[0];
                AppMethodBeat.o(232831);
                return bArr;
            }
        }

        @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment, com.tencent.mm.ui.chatting.ChattingUIFragment
        public final void doResume() {
            AppMethodBeat.i(34208);
            super.doResume();
            l.a(this.ptq);
            AppMethodBeat.o(34208);
        }

        @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment, com.tencent.mm.ui.chatting.ChattingUIFragment
        public final void onEnterBegin() {
            WxaAttributes.b bVar;
            byte[] bArr = null;
            AppMethodBeat.i(34209);
            super.onEnterBegin();
            String talkerUserName = this.dom.getTalkerUserName();
            if (TextUtils.isEmpty(talkerUserName)) {
                bVar = null;
            } else {
                WxaAttributes Xk = ((q) g.af(q.class)).Xk(talkerUserName);
                if (Xk != null) {
                    bVar = Xk.bAr();
                } else {
                    Log.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", talkerUserName);
                    bVar = null;
                }
            }
            this.lgs = bVar;
            if (this.lgs != null && this.lgs.lgB.size() == 1) {
                ChatFooter gPO = ((com.tencent.mm.ui.chatting.d.b.u) this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
                gPO.setSwitchButtonMode(1);
                gPO.setOnFooterSwitchListener(this.PdR);
            } else if (this.lgs == null || this.lgs.lgB == null) {
                Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
            } else {
                Log.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", Integer.valueOf(this.lgs.lgB.size()));
            }
            if (this.fromScene == 2) {
                bg.azz().a(new k(this.dom.getTalkerUserName(), 19, getStringExtra("key_temp_session_from"), null), 0);
            } else if (this.fromScene == 3) {
                String stringExtra = getStringExtra("sns_landing_pages_ux_info");
                if (!TextUtils.isEmpty(stringExtra)) {
                    bArr = stringExtra.getBytes();
                }
                bg.azz().a(new k(this.dom.getTalkerUserName(), 20, getStringExtra("key_temp_session_from"), bArr), 0);
            }
            String appId2 = getAppId();
            String talkerUserName2 = this.dom.getTalkerUserName();
            int i2 = this.fromScene;
            bg.aVF();
            az bjY = c.aST().bjY(talkerUserName2);
            if (bjY == null) {
                Log.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", talkerUserName2);
            } else {
                int i3 = bjY.field_unReadCount;
                String nullAsNil = Util.nullAsNil(this.mSceneId);
                Log.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", 13799, appId2, Integer.valueOf(i2), Integer.valueOf(i3), nullAsNil);
                h.INSTANCE.a(13799, appId2, Integer.valueOf(i2), Integer.valueOf(i3), nullAsNil, Long.valueOf(Util.nowSecond()));
            }
            Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            AppMethodBeat.o(34209);
        }

        private String getAppId() {
            AppMethodBeat.i(34210);
            if (Util.isNullOrNil(this.appId)) {
                WxaAttributes Xk = ((q) g.af(q.class)).Xk(this.dom.getTalkerUserName());
                this.appId = Xk == null ? null : Xk.field_appId;
            }
            if (Util.isNullOrNil(this.appId)) {
                Log.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
            }
            String str = this.appId;
            AppMethodBeat.o(34210);
            return str;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.ChattingUIFragment
        public final void gML() {
            AppMethodBeat.i(34211);
            super.gML();
            ly lyVar = new ly();
            lyVar.dRv.dRq = 0;
            lyVar.dRv.language = LocaleUtil.getApplicationLanguage();
            if (ab.Eq(this.dom.getTalkerUserName())) {
                lyVar.dRv.dRx = true;
            } else {
                lyVar.dRv.dRx = false;
            }
            EventCenter.instance.publish(lyVar);
            AppMethodBeat.o(34211);
        }

        @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment, com.tencent.mm.ui.chatting.ChattingUIFragment
        public final void eGg() {
            AppMethodBeat.i(34212);
            if (this.fromScene == 2 || this.fromScene == 3) {
                bg.aVF();
                az bjY = c.aST().bjY("appbrandcustomerservicemsg");
                if (bjY == null || Util.isNullOrNil(bjY.field_username)) {
                    Log.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i2 = bjY.field_unReadCount;
                    m mVar = new m();
                    mVar.dCj.dCl = this.dom.getTalkerUserName();
                    EventCenter.instance.publish(mVar);
                    int i3 = mVar.dCk.dCm;
                    Log.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    bjY.nt(Math.max(0, i2 - i3));
                    bg.aVF();
                    if (c.aST().a(bjY, bjY.field_username) == -1) {
                        Log.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        s sVar = new s();
                        sVar.dCF.dCl = this.dom.getTalkerUserName();
                        sVar.dCF.dCm = 0;
                        EventCenter.instance.publish(sVar);
                    }
                }
            } else {
                Log.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", this.dom.getTalkerUserName());
                s sVar2 = new s();
                sVar2.dCF.dCl = this.dom.getTalkerUserName();
                sVar2.dCF.dCm = 0;
                EventCenter.instance.publish(sVar2);
            }
            super.eGg();
            AppMethodBeat.o(34212);
        }

        @Override // com.tencent.mm.ui.MMFragment
        public void onViewAttachedToWindow(View view) {
            AppMethodBeat.i(34213);
            super.onViewAttachedToWindow(view);
            if ((this.fromScene == 2 || this.fromScene == 3) && this.lSi) {
                if (this.PdS == null) {
                    ChatFooter gPO = ((com.tencent.mm.ui.chatting.d.b.u) this.dom.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
                    this.PdS = new f(getActivity(), gPO, gPO);
                    this.PdS.Knj = false;
                }
                if (!Util.isNullOrNil(this.lSj)) {
                    com.tencent.mm.modelappbrand.a.b.aXY().a(this.PdS, "file://" + this.lSj, (b.h) null, ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).m10do((int) aiE(75), (int) aiE(60)));
                } else {
                    com.tencent.mm.modelappbrand.a.b.aXY().a(this.PdS, this.lSh, (b.h) null, ((com.tencent.mm.modelappbrand.k) g.af(com.tencent.mm.modelappbrand.k.class)).m10do((int) aiE(75), (int) aiE(60)));
                }
                this.PdS.ONf = new f.a() {
                    /* class com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.appbrand.f.a
                    public final void gKm() {
                        AppMethodBeat.i(34203);
                        AppBrandServiceChattingFmUI.this.hideVKB();
                        k.b bVar = new k.b();
                        bVar.title = AppBrandServiceChattingFmUI.this.lSf;
                        bVar.type = 33;
                        bVar.izi = AppBrandServiceChattingFmUI.this.nVO.username;
                        bVar.izh = Util.isNullOrNil(AppBrandServiceChattingFmUI.this.lSg) ? AppBrandServiceChattingFmUI.this.nVO.pageId : AppBrandServiceChattingFmUI.this.lSg;
                        bVar.izj = AppBrandServiceChattingFmUI.this.nVO.appId;
                        bVar.izz = AppBrandServiceChattingFmUI.this.nVO.kNW;
                        bVar.izA = AppBrandServiceChattingFmUI.this.nVO.pkgVersion;
                        bVar.izl = AppBrandServiceChattingFmUI.this.nVO.lhn;
                        bVar.izk = 2;
                        bVar.url = AppBrandServiceChattingFmUI.this.nVO.lho;
                        bVar.izB = AppBrandServiceChattingFmUI.this.nVO.iconUrl;
                        bVar.eam = "wxapp_" + AppBrandServiceChattingFmUI.this.nVO.appId + AppBrandServiceChattingFmUI.this.nVO.pageId;
                        bVar.eag = AppBrandServiceChattingFmUI.this.nVO.username;
                        bVar.eah = AppBrandServiceChattingFmUI.this.nVO.nickname;
                        a aVar = new a((byte) 0);
                        aVar.dNI = AppBrandServiceChattingFmUI.d(AppBrandServiceChattingFmUI.this);
                        aVar.dXm = bVar;
                        aVar.lSh = AppBrandServiceChattingFmUI.this.lSh;
                        aVar.lSj = AppBrandServiceChattingFmUI.this.lSj;
                        aVar.PdV = AppBrandServiceChattingFmUI.this.dom.getTalkerUserName();
                        aVar.lSf = AppBrandServiceChattingFmUI.this.lSf;
                        aVar.lSk = AppBrandServiceChattingFmUI.this.lSk;
                        aVar.PdQ = AppBrandServiceChattingFmUI.this.PdQ;
                        bg.aAk().postToWorker(aVar);
                        AppMethodBeat.o(34203);
                    }
                };
                f fVar = this.PdS;
                Log.d("MicroMsg.AppBrandServiceImageBubble", "show");
                bg.aAk().postToWorker(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0094: INVOKE  
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x008b: INVOKE  (r1v4 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.model.bg.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                      (wrap: com.tencent.mm.ui.appbrand.f$4 : 0x0091: CONSTRUCTOR  (r2v2 com.tencent.mm.ui.appbrand.f$4) = (r0v10 'fVar' com.tencent.mm.ui.appbrand.f) call: com.tencent.mm.ui.appbrand.f.4.<init>(com.tencent.mm.ui.appbrand.f):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.onViewAttachedToWindow(android.view.View):void, file: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0091: CONSTRUCTOR  (r2v2 com.tencent.mm.ui.appbrand.f$4) = (r0v10 'fVar' com.tencent.mm.ui.appbrand.f) call: com.tencent.mm.ui.appbrand.f.4.<init>(com.tencent.mm.ui.appbrand.f):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.onViewAttachedToWindow(android.view.View):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.appbrand.f, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                // Method dump skipped, instructions count: 189
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.onViewAttachedToWindow(android.view.View):void");
            }

            private float aiE(int i2) {
                AppMethodBeat.i(34214);
                float applyDimension = TypedValue.applyDimension(1, (float) i2, getContext().getResources().getDisplayMetrics());
                AppMethodBeat.o(34214);
                return applyDimension;
            }

            @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment, com.tencent.mm.ui.chatting.ChattingUIFragment
            public final void doPause() {
                AppMethodBeat.i(34215);
                super.doPause();
                l.b(this.ptq);
                AppMethodBeat.o(34215);
            }

            static class a implements Runnable {
                private byte[] PdQ;
                private String PdV;
                private String dNI;
                private k.b dXm;
                private String lSf;
                private String lSh;
                private String lSj;
                private boolean lSk;

                private a() {
                }

                /* synthetic */ a(byte b2) {
                    this();
                }

                public final void run() {
                    Bitmap a2;
                    byte[] bArr;
                    boolean z = true;
                    AppMethodBeat.i(34204);
                    if (!Util.isNullOrNil(this.lSj)) {
                        a2 = com.tencent.mm.modelappbrand.a.b.aXY().a("file://" + this.lSj, (b.f) null);
                        if (a2 == null || a2.isRecycled()) {
                            a2 = BitmapUtil.getBitmapNative(this.lSh);
                            if (this.lSk) {
                                Log.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", this.lSh, Boolean.valueOf(com.tencent.mm.vfs.s.deleteFile(this.lSj)));
                            }
                        }
                    } else {
                        a2 = com.tencent.mm.modelappbrand.a.b.aXY().a(this.lSh, (b.f) null);
                    }
                    if (a2 == null || a2.isRecycled()) {
                        Object[] objArr = new Object[1];
                        if (this.PdQ == null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        Log.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null sendMessageDefaultImg:%b", objArr);
                        bArr = this.PdQ;
                    } else {
                        Log.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        a2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    com.tencent.mm.pluginsdk.model.app.m.a(this.dXm, this.dNI, this.lSf, this.PdV, (String) null, bArr);
                    AppMethodBeat.o(34204);
                }
            }

            @Override // com.tencent.mm.ui.chatting.BaseChattingUIFragment, com.tencent.mm.ui.chatting.ChattingUIFragment
            public final void gMJ() {
                AppMethodBeat.i(34207);
                if (!this.dom.PvZ.PDU.containsKey(com.tencent.mm.ui.chatting.d.b.a.class)) {
                    this.dom.a(com.tencent.mm.ui.chatting.d.b.a.class, this.PdT);
                }
                super.gMJ();
                this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
                this.nVO = (WxaExposedParams) getParcelableExtra("app_brand_chatting_expose_params");
                this.mSceneId = Util.nullAsNil(getStringExtra("key_scene_id"));
                this.lSf = getStringExtra("sendMessageTitle");
                this.lSg = getStringExtra("sendMessagePath");
                this.lSh = getStringExtra("sendMessageImg");
                this.PdQ = gMK();
                this.lSj = getStringExtra("sendMessageLocalImg");
                this.lSi = getBooleanExtra("showMessageCard", false).booleanValue();
                this.lSk = getBooleanExtra("needDelThumb", false).booleanValue();
                Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", Integer.valueOf(this.fromScene));
                Log.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", this.nVO);
                Log.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", this.mSceneId, this.lSf, this.lSg, this.lSh, Boolean.valueOf(this.lSi), Boolean.valueOf(this.lSk));
                AppMethodBeat.o(34207);
            }

            static /* synthetic */ void a(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI, String str) {
                AppMethodBeat.i(34216);
                Intent intent = new Intent();
                intent.putExtra("keyOutPagePath", str);
                appBrandServiceChattingFmUI.thisActivity().setResult(-1, intent);
                appBrandServiceChattingFmUI.finish();
                AppMethodBeat.o(34216);
            }
        }
    }
