package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;

public class m extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence hXr;
    public CharSequence jVL;
    public com.tencent.mm.plugin.fts.a.a.m lqW;
    public String username;
    public int xdw;
    public CharSequence xdx;
    private b xdy = new b();
    a xdz = new a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112097);
            View inflate = LayoutInflater.from(context).inflate(R.layout.anr, viewGroup, false);
            a aVar = m.this.xdz;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.gvw = (TextView) inflate.findViewById(R.id.fzg);
            aVar.gBb = (TextView) inflate.findViewById(R.id.fn8);
            aVar.timeTV = (TextView) inflate.findViewById(R.id.in3);
            aVar.lrc = inflate.findViewById(R.id.brt);
            inflate.setTag(aVar);
            AppMethodBeat.o(112097);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112098);
            m mVar = (m) aVar2;
            a aVar3 = (a) aVar;
            n.q(aVar3.lrc, m.this.wXK);
            a.b.c(aVar3.gvv, mVar.username);
            n.a(mVar.hXr, aVar3.gBb);
            n.a(mVar.xdx, aVar3.timeTV);
            if (ab.Iz(mVar.username)) {
                n.a(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(context, mVar.jVL), aVar3.gvw);
                AppMethodBeat.o(112098);
            } else if (as.bjp(mVar.username)) {
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(mVar.username);
                ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(aVar3.gvw.getContext(), aVar3.gvw, mVar.jVL, Kn.field_openImAppid, Kn.field_descWordingId, (int) aVar3.gvw.getTextSize());
                AppMethodBeat.o(112098);
            } else {
                n.a(mVar.jVL, aVar3.gvw);
                AppMethodBeat.o(112098);
            }
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235402);
            boolean a2 = ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(m.this.qcr).a(context, view, aVar);
            AppMethodBeat.o(235402);
            return a2;
        }
    }

    public class a extends a.AbstractC1374a {
        public TextView gBb;
        public ImageView gvv;
        public TextView gvw;
        public View lrc;
        public TextView timeTV;

        public a() {
            super();
        }
    }

    public m(int i2) {
        super(5, i2);
        AppMethodBeat.i(112100);
        AppMethodBeat.o(112100);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        String str;
        AppMethodBeat.i(112101);
        super.a(context, aVar, objArr);
        this.username = this.lqW.wVX;
        this.jVL = com.tencent.mm.pluginsdk.ui.span.l.d(context, d.arL(this.username), ((a) aVar).gvw.getTextSize());
        if (this.lqW.userData instanceof Integer) {
            this.xdw = ((Integer) this.lqW.userData).intValue();
        }
        if (this.xdw > 1) {
            this.hXr = context.getResources().getString(R.string.ggt, Integer.valueOf(this.xdw));
            AppMethodBeat.o(112101);
            return;
        }
        if (this.xdw == 1) {
            String str2 = "";
            String str3 = "";
            ca Hb = ((l) g.af(l.class)).eiy().Hb(this.lqW.wXe);
            switch (this.lqW.wVW) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    str3 = Hb.field_content;
                    if (ab.Iw(this.username)) {
                        str3 = bp.Kt(str3);
                        break;
                    }
                    break;
                case 42:
                    k.b HD = k.b.HD(Hb.field_content);
                    if (HD != null) {
                        str = HD.title;
                    } else {
                        str = str3;
                    }
                    str2 = context.getString(R.string.dk8);
                    str3 = str;
                    break;
                case 43:
                    k.b HD2 = k.b.HD(Hb.field_content);
                    if (HD2 != null) {
                        str3 = HD2.title;
                    }
                    str2 = context.getString(R.string.dk9);
                    break;
                case 44:
                    k.b HD3 = k.b.HD(Hb.field_content);
                    if (HD3 != null) {
                        str3 = HD3.description;
                        str2 = HD3.title + ": ";
                        break;
                    }
                    break;
                case 45:
                    k.b HD4 = k.b.HD(Hb.field_content);
                    if (HD4 != null) {
                        str3 = Util.nullAs(HD4.title, "") + ": " + Util.nullAs(HD4.description, "");
                        break;
                    }
                    break;
                case 46:
                case 47:
                    k.b HD5 = k.b.HD(Hb.field_content);
                    if (HD5 != null) {
                        if (Hb.field_isSend != 1) {
                            str3 = Util.nullAs(HD5.iyo, "") + ": " + Util.nullAs(HD5.iyk, "");
                            break;
                        } else {
                            str3 = Util.nullAs(HD5.iyo, "") + ": " + Util.nullAs(HD5.iyl, "");
                            break;
                        }
                    } else {
                        str3 = "";
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    k.b HD6 = k.b.HD(Hb.field_content);
                    if (HD6 != null) {
                        str3 = HD6.title;
                    }
                    str2 = context.getString(R.string.dk7);
                    break;
                case 49:
                    k.b HD7 = k.b.HD(Hb.field_content);
                    if (HD7 != null) {
                        str3 = HD7.description;
                    }
                    str2 = context.getString(R.string.dka);
                    break;
                case 50:
                    String str4 = Hb.field_content;
                    if (ab.Eq(this.username)) {
                        str3 = bp.Kt(str4);
                    } else {
                        str3 = str4;
                    }
                    if (!Util.isNullOrNil(str3)) {
                        ca.b aEL = ((l) g.af(l.class)).eiy().aEL(str3);
                        if (aEL.gEa()) {
                            str3 = aEL.kHV;
                        }
                    }
                    str2 = context.getString(R.string.dk_);
                    break;
                case 52:
                    k.b HD8 = k.b.HD(Hb.field_content);
                    if (HD8 == null) {
                        str3 = "";
                        break;
                    } else {
                        str3 = Util.nullAs(HD8.getTitle(), "");
                        break;
                    }
                case 53:
                    k.b HD9 = k.b.HD(Hb.field_content);
                    if (HD9 == null) {
                        str3 = "";
                        break;
                    } else {
                        bcj bcj = ((f) HD9.as(f.class)).jlg;
                        if (Util.isNullOrNil(bcj.nickname)) {
                            str3 = "";
                            break;
                        } else {
                            str3 = context.getString(R.string.dk0, Util.nullAs(bcj.nickname, ""));
                            break;
                        }
                    }
            }
            this.hXr = com.tencent.mm.pluginsdk.ui.span.l.d(context, Util.nullAs(str3, "").replace('\n', ' '), (float) b.c.wZX);
            if (!Util.isNullOrNil((CharSequence) str2)) {
                this.hXr = com.tencent.mm.plugin.fts.a.f.a(e.a(this.hXr, this.wWd, ((float) b.a.wZP) - b.c.wZY.measureText(str2.toString()), b.c.wZY)).wWu;
                this.hXr = TextUtils.concat(str2, this.hXr);
            } else {
                this.hXr = com.tencent.mm.plugin.fts.a.f.a(e.a(this.hXr, this.wWd, (float) b.a.wZP, b.c.wZY)).wWu;
            }
            this.xdx = com.tencent.mm.pluginsdk.i.f.c(context, this.lqW.timestamp, true);
        }
        AppMethodBeat.o(112101);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public a.b axc() {
        return this.xdy;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public int dOM() {
        if (this.xdw < 2) {
            return 0;
        }
        return 1;
    }
}
