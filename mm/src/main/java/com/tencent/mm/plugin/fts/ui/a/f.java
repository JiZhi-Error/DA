package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Util;

public class f extends k {
    public int dDG;
    public String wWS;
    protected CharSequence xcL;
    protected String xcM;
    protected CharSequence xcN;
    protected String xcO;
    public m xcP;
    private a xcQ = new a();
    b xcR = new b();

    public f(int i2) {
        super(i2);
        AppMethodBeat.i(112068);
        AppMethodBeat.o(112068);
    }

    public class a extends a.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112066);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an5, viewGroup, false);
            b bVar = f.this.xcR;
            bVar.xcT = (TextView) inflate.findViewById(R.id.dnx);
            bVar.xcU = (ImageView) inflate.findViewById(R.id.wp);
            bVar.xcV = (TextView) inflate.findViewById(R.id.dny);
            bVar.xcW = (ImageView) inflate.findViewById(R.id.wr);
            bVar.xcX = (TextView) inflate.findViewById(R.id.dy9);
            bVar.contentView = inflate.findViewById(R.id.hee);
            bVar.xcK = inflate.findViewById(R.id.g8b);
            inflate.setTag(bVar);
            AppMethodBeat.o(112066);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112067);
            b bVar = (b) aVar;
            n.a(f.this.xcL, bVar.xcT);
            a.b.c(bVar.xcU, f.this.xcM);
            n.a(f.this.xcN, bVar.xcV);
            if (!Util.isNullOrNil(f.this.xcO)) {
                bVar.xcW.setVisibility(0);
                a.b.c(bVar.xcW, f.this.xcO);
            } else {
                bVar.xcW.setVisibility(8);
            }
            n.s(bVar.contentView, f.this.wXK);
            if (f.this.position == 0) {
                bVar.xcK.setVisibility(8);
            } else {
                bVar.xcK.setVisibility(0);
            }
            bVar.xcX.setVisibility(0);
            AppMethodBeat.o(112067);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class b extends a.AbstractC1374a {
        public View contentView;
        public View xcK;
        public TextView xcT;
        public ImageView xcU;
        public TextView xcV;
        public ImageView xcW;
        public TextView xcX;

        public b() {
            super();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.k
    public void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        boolean z2;
        String arL;
        AppMethodBeat.i(112069);
        String str = this.xcP.wVX;
        boolean z3 = false;
        boolean z4 = false;
        String str2 = null;
        switch (this.xcP.wVW) {
            case 1:
                z = false;
                str2 = d.arL(str);
                arL = null;
                break;
            case 2:
                z2 = false;
                z4 = true;
                z = z2;
                str2 = d.arL(str);
                arL = null;
                break;
            case 3:
                z2 = true;
                z4 = true;
                z = z2;
                str2 = d.arL(str);
                arL = null;
                break;
            case 4:
            default:
                arL = null;
                z = false;
                break;
            case 5:
                str2 = ((l) g.af(l.class)).aSN().Kn(str).field_nickname;
                arL = d.arL(str);
                z = z3;
                break;
            case 6:
                z4 = true;
                str2 = ((l) g.af(l.class)).aSN().Kn(str).field_nickname;
                arL = d.arL(str);
                z = z3;
                break;
            case 7:
                z3 = true;
                z4 = true;
                str2 = ((l) g.af(l.class)).aSN().Kn(str).field_nickname;
                arL = d.arL(str);
                z = z3;
                break;
        }
        if (this.dDG == 2) {
            this.xcM = str;
            if (!Util.isNullOrNil(arL)) {
                this.xcL = com.tencent.mm.plugin.fts.a.f.a(e.a(str2, this.xcP.wWd, z4, z, b.c.wZU, arL + "(", ")")).wWu;
            } else {
                this.xcL = com.tencent.mm.plugin.fts.a.f.a(e.a(str2, this.xcP.wWd, z4, z, 400.0f, b.c.wZU)).wWu;
            }
            this.xcL = TextUtils.concat("\"", this.xcL, "\"");
            this.xcN = TextUtils.concat("\"", TextUtils.ellipsize(d.arL(this.wWS), b.c.wZW, 300.0f, TextUtils.TruncateAt.END), context.getString(R.string.gh6));
            this.xcO = this.wWS;
            AppMethodBeat.o(112069);
            return;
        }
        this.xcL = TextUtils.concat("\"", TextUtils.ellipsize(d.arL(this.wWS), b.c.wZW, 300.0f, TextUtils.TruncateAt.END), "\"");
        this.xcM = this.wWS;
        this.xcO = str;
        if (!Util.isNullOrNil(arL)) {
            this.xcN = com.tencent.mm.plugin.fts.a.f.a(e.a(str2, this.xcP.wWd, z4, z, b.c.wZU, arL + "(", ")")).wWu;
        } else {
            this.xcN = com.tencent.mm.plugin.fts.a.f.a(e.a(str2, this.xcP.wWd, z4, z, 400.0f, b.c.wZU)).wWu;
        }
        this.xcN = TextUtils.concat("\"", this.xcN, context.getString(R.string.gh6));
        AppMethodBeat.o(112069);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.k
    public a.b axc() {
        return this.xcQ;
    }

    @Override // com.tencent.mm.plugin.fts.ui.a.k
    public final a.AbstractC1374a dPz() {
        return this.xcR;
    }
}
