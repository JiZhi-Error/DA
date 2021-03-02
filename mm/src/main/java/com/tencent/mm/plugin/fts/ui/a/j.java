package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;

public final class j extends com.tencent.mm.plugin.fts.a.d.a.a {
    public int actionType = -1;
    public String jgI;
    public m lqW;
    public CharSequence tjG;
    public String tjJ;
    public CharSequence xdk;
    public d xdl;
    private b xdm = new b();
    a xdn = new a();

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112084);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an2, viewGroup, false);
            a aVar = j.this.xdn;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.contentView = inflate.findViewById(R.id.hee);
            inflate.setTag(aVar);
            AppMethodBeat.o(112084);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112085);
            a aVar3 = (a) aVar;
            n.r(aVar3.contentView, j.this.wXK);
            n.a(j.this.tjG, aVar3.jVO);
            n.a(j.this.xdk, aVar3.jBR);
            n.a(context, aVar3.gvv, null, ((j) aVar2).tjJ, R.raw.fts_default_img, true);
            AppMethodBeat.o(112085);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235401);
            boolean a2 = ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(j.this.qcr).a(context, view, aVar);
            AppMethodBeat.o(235401);
            return a2;
        }
    }

    public class a extends a.AbstractC1374a {
        public View contentView;
        public ImageView gvv;
        public TextView jBR;
        public TextView jVO;

        public a() {
            super();
        }
    }

    public j(int i2) {
        super(3, i2);
        AppMethodBeat.i(112087);
        AppMethodBeat.o(112087);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(112088);
        super.a(context, aVar, objArr);
        this.xdl = (d) this.lqW.userData;
        if (this.xdl == null) {
            AppMethodBeat.o(112088);
            return;
        }
        this.tjG = this.xdl.field_title;
        this.xdk = this.xdl.field_tag;
        this.tjJ = this.xdl.field_iconPath;
        this.jgI = this.xdl.field_androidUrl;
        this.actionType = this.xdl.field_actionType;
        switch (this.lqW.wVW) {
            case 1:
                z2 = false;
                z = false;
                this.tjG = f.a(e.a(this.tjG, this.wWd, z2, z)).wWu;
                AppMethodBeat.o(112088);
                return;
            case 2:
                z = false;
                this.tjG = f.a(e.a(this.tjG, this.wWd, z2, z)).wWu;
                AppMethodBeat.o(112088);
                return;
            case 3:
                z = true;
                this.tjG = f.a(e.a(this.tjG, this.wWd, z2, z)).wWu;
                AppMethodBeat.o(112088);
                return;
            case 4:
                this.xdk = f.a(e.a(this.xdk, this.wWd)).wWu;
                AppMethodBeat.o(112088);
                return;
            default:
                AppMethodBeat.o(112088);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdm;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final String bCR() {
        return this.xdl.field_title;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }
}
