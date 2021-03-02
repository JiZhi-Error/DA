package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class av implements View.OnClickListener {
    private ADXml.AdCardActionBtnInfo DCW;
    private SnsInfo DqO;
    private int DxM;
    public k DzW;
    private RoundedCornerFrameLayout EwE;
    private ImageView EwF;
    private TextView EwG;
    private TextView EwH;
    public Button EwI;
    private View EwJ;
    private b EwK;
    private a EwL = new a() {
        /* class com.tencent.mm.plugin.sns.ui.av.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.sns.ui.av.a
        public final void a(ADXml.AdCardActionBtnInfo adCardActionBtnInfo) {
            AppMethodBeat.i(179160);
            if (adCardActionBtnInfo == null || av.this.EwI == null) {
                Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "adCardActionBtnInfo or mActionBtn is null, can not updateActionBtnTitle");
                AppMethodBeat.o(179160);
                return;
            }
            switch (adCardActionBtnInfo.clickActionType) {
                case 6:
                    if (!Util.isNullOrNil(adCardActionBtnInfo.btnTitleAfterOrder)) {
                        av.this.EwI.setTextColor(-7829368);
                        av.this.EwI.setText(adCardActionBtnInfo.btnTitleAfterOrder);
                        av.this.EwI.setEnabled(false);
                        AppMethodBeat.o(179160);
                        return;
                    }
                    break;
                case 7:
                    String str = adCardActionBtnInfo.btnTitleAfterAddBrand;
                    if (!Util.isNullOrNil(str)) {
                        av.this.EwI.setText(str);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(179160);
        }
    };
    private String adExtInfo = "";
    private String dRS = "";
    private bv iFD;
    private View mContentView;
    public Context mContext;
    private as rjX;
    private String uxInfo = "";

    public interface a {
        void a(ADXml.AdCardActionBtnInfo adCardActionBtnInfo);
    }

    public interface b {
        void fgP();
    }

    public av(Context context, View view, int i2, k kVar, b bVar) {
        AppMethodBeat.i(98296);
        Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + i2 + ", context=" + context + ", static=" + kVar);
        this.mContext = context;
        this.DxM = i2;
        this.DzW = kVar;
        this.EwK = bVar;
        this.mContentView = view;
        this.EwJ = this.mContentView.findViewById(R.id.fbg);
        this.EwE = (RoundedCornerFrameLayout) view.findViewById(R.id.cx);
        this.EwF = (ImageView) view.findViewById(R.id.cw);
        this.EwG = (TextView) view.findViewById(R.id.dm);
        this.EwH = (TextView) view.findViewById(R.id.cr);
        this.EwI = (Button) view.findViewById(R.id.ck);
        this.EwI.setOnClickListener(this);
        this.EwE.setRadius((float) com.tencent.mm.cb.a.fromDPToPix(this.mContext, 4));
        this.iFD = ((l) g.af(l.class)).aSN();
        AppMethodBeat.o(98296);
    }

    public final void V(SnsInfo snsInfo) {
        AppMethodBeat.i(98297);
        if (snsInfo == null) {
            Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
            AppMethodBeat.o(98297);
            return;
        }
        this.DqO = snsInfo;
        this.DCW = snsInfo.getAdXml().adCardActionBtnInfo;
        try {
            this.adExtInfo = Util.nullAsNil(snsInfo.getAdXml().adExtInfo);
            this.dRS = String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(Util.nullAsNil(snsInfo.getSnsId())));
        } catch (Throwable th) {
            Log.e("MicroMsg.SnsAdCardActionBtnCtrl", th.toString());
        }
        if (this.DCW != null) {
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(snsInfo.getAdXml().adCardTitle)) {
                this.EwG.setText(com.tencent.mm.ce.g.gxZ().a(this.EwG.getContext(), snsInfo.getAdXml().adCardTitle, this.EwG.getTextSize()));
                this.EwG.setVisibility(0);
                this.EwG.setTypeface(Typeface.defaultFromStyle(1));
                if (!TextUtils.isEmpty(snsInfo.getAdXml().adCardDesc)) {
                    this.EwH.setText(com.tencent.mm.ce.g.gxZ().a(this.EwH.getContext(), snsInfo.getAdXml().adCardDesc, this.EwH.getTextSize()));
                    this.EwH.setVisibility(0);
                } else {
                    this.EwH.setVisibility(8);
                }
            } else {
                if (!TextUtils.isEmpty(snsInfo.getAdXml().adCardDesc)) {
                    this.EwG.setText(com.tencent.mm.ce.g.gxZ().a(this.EwG.getContext(), snsInfo.getAdXml().adCardDesc, this.EwG.getTextSize()));
                    this.EwG.setVisibility(0);
                    this.EwG.setTypeface(Typeface.defaultFromStyle(0));
                } else {
                    this.EwG.setVisibility(8);
                }
                this.EwH.setVisibility(8);
            }
            try {
                this.EwI.setTextColor(this.mContext.getResources().getColor(R.color.fx));
                this.EwI.setEnabled(true);
            } catch (Throwable th2) {
                Log.e("MicroMsg.SnsAdCardActionBtnCtrl", th2.toString());
            }
            if (this.DCW.clickActionType == 2) {
                if (TextUtils.isEmpty(this.EwI.getText().toString())) {
                    this.EwI.setText(this.DCW.btnTitle);
                }
                new c(this.EwI, this.DCW.downloadApkPkgName, this.DCW.downloadApkAppId, this.DCW.btnTitle).execute(new Void[0]);
            } else if (this.DCW.clickActionType == 6) {
                try {
                    String Jb = r.Jb(snsInfo.field_snsId);
                    if (!Util.isNullOrNil(Jb)) {
                        if ("1".equals(y.aQL(Jb))) {
                            this.EwI.setTextColor(-7829368);
                            this.EwI.setText(this.DCW.btnTitleAfterOrder);
                            this.EwI.setEnabled(false);
                        } else {
                            this.EwI.setText(this.DCW.btnTitle);
                        }
                    }
                } catch (Throwable th3) {
                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", th3.toString());
                }
            } else if (this.DCW.clickActionType == 7) {
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.av.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(203403);
                        if (av.this.iFD != null && !Util.isNullOrNil(av.this.DCW.brandUsername)) {
                            av.this.rjX = av.this.iFD.Kn(av.this.DCW.brandUsername);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.ui.av.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(203402);
                                    if (av.this.rjX == null || !com.tencent.mm.contact.c.oR(av.this.rjX.field_type)) {
                                        av.this.EwI.setText(av.this.DCW.btnTitle);
                                        AppMethodBeat.o(203402);
                                        return;
                                    }
                                    av.this.EwI.setText(av.this.DCW.btnTitleAfterAddBrand);
                                    AppMethodBeat.o(203402);
                                }
                            });
                        }
                        AppMethodBeat.o(203403);
                    }
                });
            } else {
                this.EwI.setText(this.DCW.btnTitle);
            }
            if (!TextUtils.isEmpty(this.DCW.iconUrl)) {
                this.EwE.setVisibility(0);
                com.tencent.mm.plugin.sns.ad.i.b.j(this.DCW.iconUrl, this.EwF);
                AppMethodBeat.o(98297);
                return;
            }
            this.EwE.setVisibility(8);
        }
        AppMethodBeat.o(98297);
    }

    public final void onClick(View view) {
        String str;
        AppMethodBeat.i(98298);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.DCW == null) {
            Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick mActionBtnInfo==null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98298);
            return;
        }
        try {
            final SnsAdClick snsAdClick = new SnsAdClick(this.DxM, this.DxM == 0 ? 1 : 2, this.DqO.field_snsId, 26, 0);
            com.tencent.mm.plugin.sns.data.k.a(snsAdClick, this.DzW, this.DqO, 26);
            try {
                Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "onClick, type=" + this.DCW.clickActionType + ", snsId=" + r.Jb(this.DqO.field_snsId));
                switch (this.DCW.clickActionType) {
                    case 0:
                        snsAdClick.jkV = 0;
                        a(this.DCW.clickActionLink, this.DqO, snsAdClick, this.DxM, this.mContext);
                        break;
                    case 1:
                        snsAdClick.jkV = 11;
                        ADInfo adInfo = this.DqO.getAdInfo();
                        String str2 = "";
                        if (!(adInfo == null || adInfo.mappedCanvasCardExt == null)) {
                            str2 = adInfo.mappedCanvasCardExt.get(this.DCW.cardTpId);
                        }
                        if (TextUtils.isEmpty(str2)) {
                            Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "cardExt is not found in adInfo, tpid=" + this.DCW.cardTpId);
                            str = this.DCW.cardExt;
                        } else {
                            str = str2;
                        }
                        String str3 = this.DCW.cardTpId;
                        Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpCardDetail, cardTpId=" + str3 + ", cardExt=" + str);
                        Intent intent = new Intent();
                        intent.putExtra("key_card_id", str3);
                        intent.putExtra("key_card_ext", str);
                        intent.putExtra("key_from_scene", 21);
                        intent.putExtra("key_stastic_scene", 15);
                        com.tencent.mm.br.c.b((Activity) this.mContext, "card", ".ui.CardDetailUI", intent);
                        break;
                    case 2:
                        snsAdClick.jkV = a(this.DCW.downloadApkAppId, this.DCW.downloadApkPkgName, this.DCW.appPageUrl, snsAdClick);
                        break;
                    case 3:
                        snsAdClick.jkV = 21;
                        SnsInfo snsInfo = this.DqO;
                        Activity activity = (Activity) this.mContext;
                        int i2 = this.DxM;
                        View view2 = this.EwJ;
                        Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI, snsId=" + (snsInfo == null ? 0 : snsInfo.field_snsId));
                        Intent a2 = a(snsInfo, activity, i2, view2);
                        if (a2 == null) {
                            a(this.DqO, snsAdClick, this.DxM, this.mContext);
                            break;
                        } else {
                            this.EwK.fgP();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(a2);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUI", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.overridePendingTransition(0, 0);
                            break;
                        }
                    case 4:
                        snsAdClick.jkV = 31;
                        com.tencent.mm.plugin.sns.ui.d.c.a(this.DCW.weappUserName, this.DCW.weappPath, new StringBuilder().append(this.DCW.weappVersion).toString(), this.DqO, this.DxM);
                        try {
                            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(this.DxM, this.DqO);
                            break;
                        } catch (Throwable th) {
                            break;
                        }
                    case 5:
                        snsAdClick.jkV = 32;
                        a(this.DCW.clickActionLink, this.DqO, snsAdClick, this.DxM, this.mContext);
                        break;
                    case 6:
                        snsAdClick.jkV = 33;
                        try {
                            long j2 = this.DCW.subscribeExpiredTime;
                            long aWy = cl.aWy() / 1000;
                            if (j2 > 0 && aWy > j2) {
                                u.cH(this.mContext, this.DCW.subscribeExpiredTip);
                                break;
                            } else {
                                final Context context = this.mContext;
                                final ADXml.AdCardActionBtnInfo adCardActionBtnInfo = this.DCW;
                                final SnsInfo snsInfo2 = this.DqO;
                                final int i3 = this.DxM;
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.sns.ui.av.AnonymousClass3 */

                                    public final void run() {
                                        AppMethodBeat.i(203404);
                                        try {
                                            if (context != null) {
                                                e eVar = new e(context, true, 0);
                                                com.tencent.mm.plugin.sns.e.b bVar = new com.tencent.mm.plugin.sns.e.b();
                                                Context context = context;
                                                ADXml.AdCardActionBtnInfo adCardActionBtnInfo = adCardActionBtnInfo;
                                                SnsInfo snsInfo = snsInfo2;
                                                int i2 = i3;
                                                a aVar = av.this.EwL;
                                                bv bvVar = av.this.iFD;
                                                String str = adCardActionBtnInfo.weappUserName;
                                                String str2 = adCardActionBtnInfo.tempId;
                                                View a2 = com.tencent.mm.plugin.sns.e.b.a(context, adCardActionBtnInfo, snsInfo, bvVar);
                                                WeImageView weImageView = (WeImageView) a2.findViewById(R.id.b3z);
                                                Button button = (Button) a2.findViewById(R.id.idg);
                                                bVar.DDe = false;
                                                eVar.PGl = 
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: IPUT  
                                                      (wrap: com.tencent.mm.plugin.sns.e.b$1 : 0x0063: CONSTRUCTOR  (r1v15 com.tencent.mm.plugin.sns.e.b$1) = 
                                                      (r2v2 'bVar' com.tencent.mm.plugin.sns.e.b)
                                                      (r3v1 'str2' java.lang.String)
                                                      (r4v0 'str' java.lang.String)
                                                      (r5v0 'snsInfo' com.tencent.mm.plugin.sns.storage.SnsInfo)
                                                      (r6v0 'i2' int)
                                                     call: com.tencent.mm.plugin.sns.e.b.1.<init>(com.tencent.mm.plugin.sns.e.b, java.lang.String, java.lang.String, com.tencent.mm.plugin.sns.storage.SnsInfo, int):void type: CONSTRUCTOR)
                                                      (r14v0 'eVar' com.tencent.mm.ui.widget.a.e)
                                                     com.tencent.mm.ui.widget.a.e.PGl com.tencent.mm.ui.widget.a.e$b in method: com.tencent.mm.plugin.sns.ui.av.3.run():void, file: classes3.dex
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
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0063: CONSTRUCTOR  (r1v15 com.tencent.mm.plugin.sns.e.b$1) = 
                                                      (r2v2 'bVar' com.tencent.mm.plugin.sns.e.b)
                                                      (r3v1 'str2' java.lang.String)
                                                      (r4v0 'str' java.lang.String)
                                                      (r5v0 'snsInfo' com.tencent.mm.plugin.sns.storage.SnsInfo)
                                                      (r6v0 'i2' int)
                                                     call: com.tencent.mm.plugin.sns.e.b.1.<init>(com.tencent.mm.plugin.sns.e.b, java.lang.String, java.lang.String, com.tencent.mm.plugin.sns.storage.SnsInfo, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.sns.ui.av.3.run():void, file: classes3.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                    	... 24 more
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.sns.e.b, state: GENERATED_AND_UNLOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                    	... 28 more
                                                    */
                                                /*
                                                // Method dump skipped, instructions count: 173
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.av.AnonymousClass3.run():void");
                                            }
                                        });
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", th2.toString());
                                    break;
                                }
                                break;
                            case 7:
                                try {
                                    if (this.rjX == null || !com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
                                        snsAdClick.jkV = 38;
                                    } else {
                                        snsAdClick.jkV = 39;
                                    }
                                    final Context context2 = this.mContext;
                                    final ADXml.AdCardActionBtnInfo adCardActionBtnInfo2 = this.DCW;
                                    final SnsInfo snsInfo3 = this.DqO;
                                    final int i4 = this.DxM;
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.plugin.sns.ui.av.AnonymousClass4 */

                                        public final void run() {
                                            AppMethodBeat.i(203405);
                                            try {
                                                if (context2 == null || adCardActionBtnInfo2 == null || snsInfo3 == null) {
                                                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "mContext or mActionBtnInfo or mSnsInfo is null");
                                                    AppMethodBeat.o(203405);
                                                } else if (av.this.rjX == null || !com.tencent.mm.contact.c.oR(av.this.rjX.field_type)) {
                                                    com.tencent.mm.plugin.sns.e.a aVar = new com.tencent.mm.plugin.sns.e.a();
                                                    Context context = context2;
                                                    SnsInfo snsInfo = snsInfo3;
                                                    ADXml.AdCardActionBtnInfo adCardActionBtnInfo = adCardActionBtnInfo2;
                                                    int i2 = i4;
                                                    bv bvVar = av.this.iFD;
                                                    as asVar = av.this.rjX;
                                                    a aVar2 = av.this.EwL;
                                                    aVar.DCW = adCardActionBtnInfo;
                                                    aVar.mContext = context;
                                                    aVar.DxM = i2;
                                                    aVar.iFD = bvVar;
                                                    aVar.rjX = asVar;
                                                    aVar.DCV = aVar2;
                                                    aVar.dRS = String.valueOf(com.tencent.mm.plugin.sns.data.k.aOa(snsInfo.getSnsId()));
                                                    aVar.uxInfo = snsInfo.getUxinfo();
                                                    aVar.adExtInfo = snsInfo.getAdXml().adExtInfo;
                                                    d dVar = new d();
                                                    if (adCardActionBtnInfo != null) {
                                                        dVar.brandUsername = Util.nullAs(adCardActionBtnInfo.brandUsername, "");
                                                        dVar.brandHead = Util.nullAs(adCardActionBtnInfo.brandHead, "");
                                                        dVar.brandName = Util.nullAs(adCardActionBtnInfo.brandName, "");
                                                        dVar.brandDesc = Util.nullAs(adCardActionBtnInfo.brandDesc, "");
                                                        dVar.btnTitleAfterAddBrand = Util.nullAs(adCardActionBtnInfo.btnTitleAfterAddBrand, "");
                                                    }
                                                    aVar.DCX = dVar;
                                                    aVar.eZo();
                                                    AppMethodBeat.o(203405);
                                                } else {
                                                    Context context2 = context2;
                                                    SnsInfo snsInfo2 = snsInfo3;
                                                    SnsAdClick snsAdClick = snsAdClick;
                                                    int i3 = i4;
                                                    ADXml.AdCardActionBtnInfo adCardActionBtnInfo2 = adCardActionBtnInfo2;
                                                    if (context2 == null || snsInfo2 == null || adCardActionBtnInfo2 == null || Util.isNullOrNil(adCardActionBtnInfo2.brandUsername)) {
                                                        AppMethodBeat.o(203405);
                                                        return;
                                                    }
                                                    Intent intent = new Intent();
                                                    intent.putExtra("Contact_User", adCardActionBtnInfo2.brandUsername);
                                                    intent.putExtra("KSnsAdTag", snsAdClick);
                                                    intent.putExtra("Contact_Scene", 181);
                                                    intent.putExtra("CONTACT_INFO_UI_SOURCE", i3 == 0 ? 6 : 1);
                                                    com.tencent.mm.plugin.sns.c.a.jRt.c(intent, context2);
                                                    AppMethodBeat.o(203405);
                                                }
                                            } catch (Throwable th) {
                                                Log.e("MicroMsg.SnsAdCardActionBtnCtrl", th.toString());
                                                AppMethodBeat.o(203405);
                                            }
                                        }
                                    });
                                    break;
                                } catch (Throwable th3) {
                                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", th3.toString());
                                    break;
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            default:
                                com.tencent.mm.plugin.sns.ad.timeline.a.c d2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(3, this.mContext);
                                if (d2 != null) {
                                    d2.a(view, this.DxM, this.DqO, new com.tencent.mm.plugin.sns.ad.timeline.a.d("snsAdClick", snsAdClick));
                                    break;
                                }
                                break;
                            case 12:
                                com.tencent.mm.plugin.sns.ad.e.h.a(this.mContext, this.DqO.getAdXml(), this.DqO.getAdInfo(), this.DqO.field_snsId, 4);
                                snsAdClick.jkV = 37;
                                break;
                        }
                        Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "clickAction=" + snsAdClick.jkV);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick exp=" + e2.toString());
                    }
                    r.a(snsAdClick);
                } catch (Exception e3) {
                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "onClick report exp=" + e3.toString());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98298);
            }

            private static void a(SnsInfo snsInfo, SnsAdClick snsAdClick, int i2, Context context) {
                AppMethodBeat.i(98299);
                String adInfoLink = snsInfo.getAdInfoLink();
                if (TextUtils.isEmpty(adInfoLink)) {
                    adInfoLink = snsInfo.getAdLink();
                }
                if (TextUtils.isEmpty(adInfoLink)) {
                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "jumpUpdateWebUI both url is empty");
                    AppMethodBeat.o(98299);
                    return;
                }
                a(adInfoLink, snsInfo, snsAdClick, i2, context);
                AppMethodBeat.o(98299);
            }

            private int a(String str, String str2, String str3, SnsAdClick snsAdClick) {
                ADInfo adInfo;
                AppMethodBeat.i(203406);
                Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "handleDownload, appPageUrl=" + str3 + ", pkg=" + str2 + ", appId=" + str);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bz(MMApplicationContext.getContext(), str2)) {
                    Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "isPkgInstalled==true");
                    if (!(this.DqO == null || (adInfo = this.DqO.getAdInfo(this.DxM)) == null)) {
                        this.uxInfo = Util.nullAsNil(adInfo.uxInfo);
                    }
                    com.tencent.mm.plugin.sns.data.k.a(this.mContext, str, str2, "", str3, this.uxInfo, this.adExtInfo, this.dRS, 0, 0);
                    if (!TextUtils.isEmpty(str3)) {
                        AppMethodBeat.o(203406);
                        return 34;
                    }
                } else {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar2 = a.e.DXp;
                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(str)) {
                        Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "isApkExist==true");
                        com.tencent.mm.plugin.sns.data.k.jZ(str2, str3);
                        AdLandingPagesProxy.getInstance().installApp(this.mContext, str, str2, "", "");
                    } else {
                        boolean z = false;
                        if (this.DqO != null) {
                            try {
                                z = com.tencent.mm.plugin.sns.data.k.b(this.mContext, this.DqO, this.DqO.getAdInfo(this.DxM));
                            } catch (Throwable th) {
                            }
                        }
                        if (!z) {
                            SnsInfo snsInfo = this.DqO;
                            Activity activity = (Activity) this.mContext;
                            int i2 = this.DxM;
                            View view = this.EwJ;
                            Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload, snsId=" + (snsInfo == null ? "" : r.Jb(snsInfo.field_snsId)));
                            Intent a2 = a(snsInfo, activity, i2, view);
                            if (a2 != null) {
                                this.EwK.fgP();
                                a2.putExtra("sns_landing_pages_auto_download_for_action_btn", true);
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(a2);
                                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                activity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "jumpNativeLandingPageUIForDownload", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/app/Activity;ILandroid/view/View;Lcom/tencent/mm/modelsns/SnsAdClick;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                activity.overridePendingTransition(0, 0);
                            } else {
                                a(snsInfo, snsAdClick, i2, activity);
                            }
                        } else {
                            com.tencent.mm.plugin.sns.data.k.jZ(str2, str3);
                            AppMethodBeat.o(203406);
                            return 36;
                        }
                    }
                }
                AppMethodBeat.o(203406);
                return 21;
            }

            private static void a(String str, SnsInfo snsInfo, SnsAdClick snsAdClick, int i2, Context context) {
                ADInfo adInfo;
                boolean z = false;
                AppMethodBeat.i(98300);
                Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "jumpWebUI, url=" + str + ", source=" + i2 + ", snsInfo=" + snsInfo);
                if (TextUtils.isEmpty(str) || snsInfo == null) {
                    AppMethodBeat.o(98300);
                    return;
                }
                Intent intent = new Intent();
                boolean z2 = snsInfo.getAdXml().webrightBar == 0;
                if (!ac.jOL) {
                    z = z2;
                }
                if (!(snsInfo == null || !snsInfo.isAd() || (adInfo = snsInfo.getAdInfo(i2)) == null)) {
                    intent.putExtra("KsnsViewId", adInfo.viewId);
                    str = com.tencent.mm.plugin.sns.ad.d.a.a.aND(r.kb(str, adInfo.uxInfo));
                    r.h(intent, adInfo.uxInfo);
                }
                intent.putExtra("KRightBtn", z);
                Bundle bundle = new Bundle();
                if (snsAdClick != null) {
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                }
                bundle.putString("key_snsad_statextstr", snsInfo.getTimeLine().statExtStr);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", str);
                intent.putExtra("useJs", true);
                intent.putExtra("srcUsername", snsInfo.field_userName);
                intent.putExtra("stastic_scene", 15);
                intent.putExtra("KPublisherId", "sns_" + r.Jb(snsInfo.field_snsId));
                intent.putExtra("pre_username", snsInfo.field_userName);
                intent.putExtra("prePublishId", "sns_" + r.Jb(snsInfo.field_snsId));
                intent.putExtra("preUsername", snsInfo.field_userName);
                com.tencent.mm.plugin.sns.c.a.jRt.i(intent, context);
                AppMethodBeat.o(98300);
            }

            private static Intent a(SnsInfo snsInfo, Activity activity, int i2, View view) {
                int i3 = 2;
                boolean z = true;
                AppMethodBeat.i(98301);
                if (i.aQg(snsInfo.getAdSnsInfo().field_adxml)) {
                    Intent intent = new Intent();
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int width = view.getWidth();
                    int height = view.getHeight();
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    intent.putExtra("sns_landing_pages_share_sns_id", snsInfo.getSnsId());
                    intent.putExtra("sns_landing_pages_rawSnsId", snsInfo.getTimeLine().Id);
                    intent.putExtra("sns_landing_pages_ux_info", snsInfo.getUxinfo());
                    intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                    if (i2 == 2) {
                        i3 = 16;
                    } else if (i2 != 1) {
                        i3 = 1;
                    }
                    intent.putExtra("sns_landig_pages_from_source", i3);
                    intent.putExtra("sns_landing_pages_xml", snsInfo.getAdSnsInfo().field_adxml);
                    intent.putExtra("sns_landing_pages_rec_src", snsInfo.getAdRecSrc());
                    intent.putExtra("sns_landing_pages_xml_prefix", f.COL_ADXML);
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    TimeLineObject timeLine = snsInfo.getTimeLine();
                    if (timeLine.ContentObj.LoU != 15 || timeLine.sightFolded == 1) {
                        z = false;
                    }
                    intent.putExtra("sns_landing_is_native_sight_ad", z);
                    AppMethodBeat.o(98301);
                    return intent;
                }
                Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "adxml is invalid, snsId=" + r.Jb(snsInfo.field_snsId));
                AppMethodBeat.o(98301);
                return null;
            }

            public static class c extends AsyncTask<Void, Void, Integer> {
                Button Edp;
                String EwQ;
                String LG;
                String dNI;

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.os.AsyncTask
                public final /* synthetic */ void onPostExecute(Integer num) {
                    AppMethodBeat.i(98294);
                    Integer num2 = num;
                    if (num2.intValue() == 1) {
                        this.Edp.setText(R.string.h38);
                        AppMethodBeat.o(98294);
                    } else if (num2.intValue() == 2) {
                        this.Edp.setText(R.string.h37);
                        AppMethodBeat.o(98294);
                    } else {
                        this.Edp.setText(this.EwQ);
                        AppMethodBeat.o(98294);
                    }
                }

                public c(Button button, String str, String str2, String str3) {
                    this.LG = str;
                    this.dNI = str2;
                    this.Edp = button;
                    this.EwQ = str3;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                /* access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public final /* synthetic */ Integer doInBackground(Void[] voidArr) {
                    AppMethodBeat.i(98295);
                    int i2 = 0;
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
                    if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.bz(MMApplicationContext.getContext(), this.LG)) {
                        i2 = 1;
                    } else {
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar2 = a.e.DXp;
                        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.isApkExist(this.dNI)) {
                            i2 = 2;
                        }
                    }
                    Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "apkbtn state=".concat(String.valueOf(i2)));
                    Integer valueOf = Integer.valueOf(i2);
                    AppMethodBeat.o(98295);
                    return valueOf;
                }
            }
        }
