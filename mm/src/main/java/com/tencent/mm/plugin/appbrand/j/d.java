package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public final class d extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence gCf;
    public boolean kVq;
    public boolean kVr;
    public m lqW;
    public AppBrandRecentTaskInfo lqX;
    private b lqY = new b();
    a lqZ = new a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(45024);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ds, viewGroup, false);
            a aVar = d.this.lqZ;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.contentView = inflate.findViewById(R.id.hee);
            aVar.lra = (TextView) inflate.findViewById(R.id.hfo);
            aVar.lrb = (TextView) inflate.findViewById(R.id.iha);
            aVar.lrc = inflate.findViewById(R.id.brt);
            aVar.lrd = (ImageView) inflate.findViewById(R.id.ius);
            aVar.lre = (ImageView) inflate.findViewById(R.id.g36);
            inflate.setTag(aVar);
            AppMethodBeat.o(45024);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(45025);
            d dVar = (d) aVar2;
            a aVar3 = (a) aVar;
            n.q(aVar3.lrc, d.this.wXK);
            if (dVar.lqX == null) {
                aVar3.contentView.setVisibility(8);
                AppMethodBeat.o(45025);
                return;
            }
            aVar3.contentView.setVisibility(0);
            aVar3.jVO.setText(d.this.gCf);
            if (d.this.rjr == -8) {
                aVar3.lra.setText(R.string.gfh);
                aVar3.lra.setVisibility(0);
            } else {
                aVar3.lra.setVisibility(8);
            }
            String vO = e.vO(d.this.lqX.eix);
            if (Util.isNullOrNil(vO)) {
                aVar3.lrb.setVisibility(8);
            } else {
                aVar3.lrb.setText(vO);
                aVar3.lrb.setVisibility(0);
            }
            if (!d.this.kVq || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_search_appbrand_have_been_used, 0) != 1) {
                aVar3.lrd.setVisibility(8);
            } else {
                aVar3.lrd.setVisibility(0);
            }
            if (!d.this.kVr || ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_show_official_flag, 0) != 1) {
                aVar3.lre.setVisibility(8);
            } else {
                aVar3.lre.setVisibility(0);
            }
            com.tencent.mm.modelappbrand.a.b.aXY().a(aVar3.gvv, dVar.lqX.kVo, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
            AppMethodBeat.o(45025);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(226608);
            if (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(view.getContext())) {
                AppMethodBeat.o(226608);
            } else {
                d dVar = (d) aVar;
                wq wqVar = new wq();
                wqVar.ecI.userName = dVar.lqX.dCl;
                wqVar.ecI.ecL = dVar.lqX.eix;
                wqVar.ecI.ecP = true;
                wqVar.ecI.scene = TXLiteAVCode.EVT_HW_ENCODER_START_SUCC;
                wqVar.ecI.dCw = "1";
                EventCenter.instance.publish(wqVar);
                a(d.this.wWd.wWB, d.this.lqW);
                AppMethodBeat.o(226608);
            }
            return true;
        }
    }

    public class a extends a.AbstractC1374a {
        public View contentView;
        public ImageView gvv;
        public TextView jVO;
        public TextView lra;
        public TextView lrb;
        public View lrc;
        public ImageView lrd;
        public ImageView lre;

        public a() {
            super();
        }
    }

    public d(int i2) {
        super(9, i2);
        AppMethodBeat.i(45027);
        AppMethodBeat.o(45027);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        AppMethodBeat.i(45028);
        super.a(context, aVar, objArr);
        this.lqX = i.YG(this.lqW.wVX);
        if (this.lqX == null) {
            AppMethodBeat.o(45028);
            return;
        }
        switch (this.lqW.wVW) {
            case 3:
                z3 = true;
            case 2:
                z = z3;
                break;
            default:
                z2 = false;
                z = false;
                break;
        }
        this.gCf = f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.lqX.appName, this.wWd, z2, z)).wWu;
        this.info = this.lqX.dCl;
        this.kVq = this.lqX.kVq;
        this.kVr = this.lqX.kVq;
        AppMethodBeat.o(45028);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.lqY;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final String bCR() {
        return this.lqX.appName;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final String getAppId() {
        return this.lqX.dCl;
    }
}
