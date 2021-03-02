package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class s extends com.tencent.mm.plugin.fts.a.d.a.a {
    private static int xdU = (com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 116));
    public String contentType;
    private CharSequence jVL;
    public boolean kVq;
    private String thumbUrl;
    public long wVY;
    public fei xdP;
    public String xdQ;
    public boolean xdR;
    private CharSequence xdS;
    private CharSequence xdT;
    private b xdV = new b();
    a xdW = new a();

    public s(int i2) {
        super(14, i2);
        AppMethodBeat.i(112127);
        AppMethodBeat.o(112127);
    }

    static {
        AppMethodBeat.i(112129);
        AppMethodBeat.o(112129);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        AppMethodBeat.i(112128);
        super.a(context, aVar, objArr);
        try {
            JSONObject jSONObject = new JSONObject(this.xdP.NzC);
            String optString = jSONObject.optString("title", "");
            this.thumbUrl = jSONObject.optString("image", "");
            this.xdQ = jSONObject.optString("search_buffer", "");
            this.xdS = f.ayv(optString);
            this.contentType = jSONObject.optString(FirebaseAnalytics.b.CONTENT_TYPE, "");
            this.kVq = jSONObject.optInt("security_icon", 0) == 1;
            if (jSONObject.optInt("brand_official_label", 0) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.xdR = z;
        } catch (Exception e2) {
        }
        if ("HOME".equals(this.contentType)) {
            gE(2, 0);
        } else {
            gE(1, 0);
        }
        this.xdT = f.ayv(this.xdP.KHk);
        this.jVL = this.xdP.oUJ;
        this.wVY = System.currentTimeMillis();
        doe doe = new doe();
        doe.jfi = this.xdP.jfi;
        doe.Scene = 25;
        doe.MRu = e.wVn;
        doe.MRz = e.wVm;
        doe.MKf = this.wVY;
        doe.MRy = this.position;
        doe.Mnc = 0;
        doe.MRv = this.xdQ;
        doe.MRw = 1;
        g.azz().a(new com.tencent.mm.plugin.fts.ui.c.e(doe), 0);
        AppMethodBeat.o(112128);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdV;
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112124);
            View inflate = LayoutInflater.from(context).inflate(R.layout.anz, viewGroup, false);
            a aVar = s.this.xdW;
            aVar.xdX = inflate.findViewById(R.id.uu);
            aVar.xdY = (ImageView) inflate.findViewById(R.id.imb);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.xcs = (TextView) inflate.findViewById(R.id.ior);
            aVar.xdZ = (ImageView) inflate.findViewById(R.id.j57);
            aVar.xeb = inflate.findViewById(R.id.bcc);
            aVar.gvw = (TextView) inflate.findViewById(R.id.fzg);
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.xec = (TextView) inflate.findViewById(R.id.ba7);
            aVar.lrd = (ImageView) inflate.findViewById(R.id.iut);
            aVar.xea = (ImageView) inflate.findViewById(R.id.g36);
            inflate.setTag(aVar);
            AppMethodBeat.o(112124);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112125);
            a aVar3 = (a) aVar;
            if ("HOME".equals(s.this.contentType)) {
                aVar3.xdX.setVisibility(8);
                aVar3.xeb.setVisibility(0);
                n.a(context, aVar3.gvv, s.this.thumbUrl, null, R.raw.fts_weapp_search_default_icon, aVar3.xdY.getMeasuredWidth(), aVar3.xdY.getMeasuredHeight());
                aVar3.gvw.setText(s.this.xdS);
                aVar3.xec.setText(s.this.xdT);
                aVar3.lrd.setVisibility((!s.this.kVq || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_search_appbrand_search_result, 0) != 1) ? 8 : 0);
                aVar3.xea.setVisibility((!s.this.xdR || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_show_official_flag, 0) != 1) ? 8 : 0);
            } else {
                aVar3.xdX.setVisibility(0);
                aVar3.xeb.setVisibility(8);
                n.a(context, aVar3.xdY, s.this.thumbUrl, null, R.raw.fts_weapp_search_default_icon, aVar3.xdY.getMeasuredWidth(), aVar3.xdY.getMeasuredHeight());
                if (aVar3.jVO.getPaint().measureText(s.this.xdS.toString()) >= ((float) s.xdU)) {
                    aVar3.jVO.setMaxLines(2);
                    aVar3.jBR.setMaxLines(1);
                } else if (aVar3.jBR.getPaint().measureText(s.this.xdT.toString()) >= ((float) s.xdU)) {
                    aVar3.jVO.setMaxLines(1);
                    aVar3.jBR.setMaxLines(2);
                } else {
                    aVar3.jVO.setMaxLines(1);
                    aVar3.jBR.setMaxLines(1);
                }
                aVar3.jVO.setText(s.this.xdS);
                aVar3.jBR.setText(s.this.xdT);
                aVar3.xcs.setText(s.this.jVL);
            }
            if (ShareConstants.VIDEO_URL.equals(s.this.contentType)) {
                aVar3.xdZ.setVisibility(0);
                AppMethodBeat.o(112125);
                return;
            }
            aVar3.xdZ.setVisibility(8);
            AppMethodBeat.o(112125);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235407);
            s sVar = (s) aVar;
            doe doe = new doe();
            doe.jfi = sVar.xdP.jfi;
            doe.Scene = 25;
            doe.MRu = e.wVn;
            doe.MRz = e.wVm;
            doe.MKf = System.currentTimeMillis();
            doe.MRy = sVar.position;
            doe.Mnc = (int) (doe.MKf - sVar.wVY);
            doe.MRv = sVar.xdQ;
            doe.MRx = 1;
            g.azz().a(new com.tencent.mm.plugin.fts.ui.c.e(doe), 0);
            wq wqVar = new wq();
            wqVar.ecI.userName = s.this.xdP.UserName;
            wqVar.ecI.ecK = s.this.xdP.xut;
            wqVar.ecI.scene = TXLiteAVCode.EVT_HW_ENCODER_START_SUCC;
            wqVar.ecI.dCw = "$CASSP$B" + e.wVn + ":" + s.this.xdP.MUT + ":3";
            EventCenter.instance.publish(wqVar);
            AppMethodBeat.o(235407);
            return false;
        }
    }

    public class a extends a.AbstractC1374a {
        public ImageView gvv;
        public TextView gvw;
        public TextView jBR;
        public TextView jVO;
        public ImageView lrd;
        public TextView xcs;
        public View xdX;
        public ImageView xdY;
        public ImageView xdZ;
        public ImageView xea;
        public View xeb;
        public TextView xec;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final String getAppId() {
        return this.xdP.UserName;
    }
}
