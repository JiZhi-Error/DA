package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ak implements ad {
    private int DPi = 1;
    private int EpG;
    private CdnImageView EpH = null;
    private TextView EpI = null;
    private k EpM = null;
    private String EpN = "";
    private boolean Ero = false;
    private boolean Erp = false;
    WXMediaMessage Erq = null;
    private Bitmap EsL;
    ImageView EsM;
    private String appName = "";
    String dNI = "";
    boolean gVd = false;
    MMActivity gte;
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.sns.ui.ak.AnonymousClass1 */

        {
            AppMethodBeat.i(160698);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(160698);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(97977);
            switch (mxVar.dSE.action) {
                case 0:
                case 1:
                    ak.this.EsM.setImageResource(R.drawable.alq);
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    ak.this.EsM.setImageResource(R.drawable.am5);
                    break;
            }
            AppMethodBeat.o(97977);
            return false;
        }
    };
    String mediaId;
    private View sc;
    private TextView titleTv = null;

    public ak(MMActivity mMActivity) {
        AppMethodBeat.i(97981);
        this.gte = mMActivity;
        EventCenter.instance.addListener(this.lEl);
        AppMethodBeat.o(97981);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aC(Bundle bundle) {
        AppMethodBeat.i(97982);
        this.Erq = new SendMessageToWX.Req(this.gte.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        this.mediaId = this.gte.getIntent().getStringExtra("Ksnsupload_musicid");
        this.EpM = k.w(this.gte.getIntent());
        this.dNI = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
        this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
        this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
        if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true)) {
            this.DPi = 1;
        } else {
            this.DPi = 0;
        }
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        AppMethodBeat.o(97982);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final void aD(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffA() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void ffY() {
        AppMethodBeat.i(97983);
        new MMHandler(this.gte.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.ak.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(97978);
                a.bea();
                ak.this.gVd = false;
                AppMethodBeat.o(97978);
            }
        });
        AppMethodBeat.o(97983);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final View ffB() {
        AppMethodBeat.i(97984);
        this.sc = aa.jQ(this.gte).inflate(R.layout.c4x, (ViewGroup) null);
        this.EpH = (CdnImageView) this.sc.findViewById(R.id.dw4);
        this.titleTv = (TextView) this.sc.findViewById(R.id.ir7);
        this.EpI = (TextView) this.sc.findViewById(R.id.h7r);
        this.sc.findViewById(R.id.i4t).setVisibility(8);
        this.titleTv.setText(this.Erq.title);
        if (this.Erq.thumbData != null) {
            this.EsL = BitmapUtil.decodeByteArray(this.Erq.thumbData);
        }
        this.EpH.setImageBitmap(this.EsL);
        if (!Util.isNullOrNil(this.Erq.description)) {
            this.EpI.setText(this.Erq.description);
            this.EpI.setVisibility(0);
        } else {
            this.EpI.setVisibility(8);
        }
        this.EsM = (ImageView) this.sc.findViewById(R.id.i4t);
        this.EsM.setVisibility(0);
        if (!a.bec() || !this.gVd) {
            this.EsM.setImageResource(R.drawable.am5);
        } else {
            this.EsM.setImageResource(R.drawable.alq);
        }
        this.EsM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.ak.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(97980);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (a.bec()) {
                    ak.this.ffY();
                } else {
                    ak akVar = ak.this;
                    if (akVar.Erq == null) {
                        Log.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
                    } else {
                        new MMHandler(akVar.gte.getMainLooper()).post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.ak.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(97979);
                                if (3 == ak.this.Erq.getType()) {
                                    ak.this.gVd = true;
                                    WXMusicObject wXMusicObject = (WXMusicObject) ak.this.Erq.mediaObject;
                                    String nullAs = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                                    String nullAs2 = Util.nullAs(!Util.isNullOrNil(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                                    if (Util.isNullOrNil(ak.this.mediaId)) {
                                        ak.this.mediaId = new StringBuilder().append(System.currentTimeMillis()).toString();
                                    }
                                    f fVar = new f();
                                    fVar.jeT = 1;
                                    fVar.jeV = ak.this.mediaId;
                                    fVar.jeW = 0.0f;
                                    fVar.jeZ = "";
                                    fVar.jff = null;
                                    fVar.jeU = 1;
                                    fVar.jfe = null;
                                    fVar.jeX = ak.this.Erq.title;
                                    fVar.jeY = ak.this.Erq.description;
                                    fVar.jfd = nullAs;
                                    fVar.jfc = nullAs2;
                                    fVar.jfb = nullAs2;
                                    fVar.jfl = "";
                                    fVar.jfg = aj.getAccPath();
                                    fVar.jfi = ak.this.dNI;
                                    a.c(fVar);
                                }
                                AppMethodBeat.o(97979);
                            }
                        });
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/MusicWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97980);
            }
        });
        r.b(this.EpH, this.gte);
        View view = this.sc;
        AppMethodBeat.o(97984);
        return view;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffC() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffD() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6) {
        AppMethodBeat.i(97985);
        aj.faK();
        bf c2 = be.c(this.Erq, str, this.dNI, this.appName);
        if (c2 == null) {
            Log.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", this.dNI, this.appName);
            AppMethodBeat.o(97985);
            return false;
        }
        pInt.value = c2.beK;
        if (i4 > com.tencent.mm.plugin.sns.c.a.DCT) {
            c2.YF(4);
        }
        c2.YK(this.EpG);
        if (this.Ero) {
            c2.YK(5);
        }
        LinkedList<ebm> linkedList2 = new LinkedList<>();
        if (list != null) {
            new LinkedList();
            List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
            for (String str3 : list) {
                if (!gnq.contains(str3)) {
                    ebm ebm = new ebm();
                    ebm.UserName = str3;
                    linkedList2.add(ebm);
                }
            }
        }
        c2.bq(linkedList2);
        if (iVar != null) {
            c2.kl(iVar.token, iVar.Mte);
        }
        c2.a(cjy);
        if (z) {
            c2.YL(1);
        } else {
            c2.YL(0);
        }
        c2.gR(list2).YI(i2);
        c2.g(null, null, null, i5, i6);
        c2.ct(this.DPi, this.EpN);
        if (this.Erp && this.Erq != null) {
            c2.aPx(this.Erq.mediaTagName);
            c2.aO(this.dNI, this.Erq.messageExt, this.Erq.messageAction);
        }
        int commit = c2.commit();
        if (this.EpM != null) {
            this.EpM.tQ(commit);
            g.DVR.c(this.EpM);
        }
        aj.faK().eZn();
        this.gte.finish();
        AppMethodBeat.o(97985);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean k(int i2, Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ad
    public final boolean ffE() {
        AppMethodBeat.i(97986);
        if (this.EsL != null && !this.EsL.isRecycled()) {
            this.EsL.recycle();
        }
        EventCenter.instance.removeListener(this.lEl);
        if (a.bec() && this.gVd) {
            ffY();
        }
        boolean bec = a.bec();
        AppMethodBeat.o(97986);
        return bec;
    }
}
