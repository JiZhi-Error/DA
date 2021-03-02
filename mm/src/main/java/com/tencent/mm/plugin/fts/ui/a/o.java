package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;

public final class o extends f {
    private a xdE = new a();

    public o(int i2) {
        super(i2);
        AppMethodBeat.i(112108);
        AppMethodBeat.o(112108);
    }

    public class a extends f.a {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.f.a, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112107);
            super.a(context, aVar, aVar2, objArr);
            ((f.b) aVar).xcX.setVisibility(8);
            AppMethodBeat.o(112107);
        }
    }

    @Override // com.tencent.mm.plugin.fts.ui.a.f, com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.k
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        String arL;
        boolean z6;
        AppMethodBeat.i(112109);
        String str2 = this.xcP.wVX;
        switch (this.xcP.wVW) {
            case 1:
                z4 = false;
                z2 = false;
                str = d.arL(str2);
                arL = null;
                z6 = z4;
                break;
            case 2:
                z5 = false;
                z4 = true;
                z2 = z5;
                str = d.arL(str2);
                arL = null;
                z6 = z4;
                break;
            case 3:
                z5 = true;
                z4 = true;
                z2 = z5;
                str = d.arL(str2);
                arL = null;
                z6 = z4;
                break;
            case 4:
            default:
                arL = null;
                str = null;
                z6 = false;
                z2 = false;
                break;
            case 5:
                z = false;
                z2 = false;
                str = ((l) g.af(l.class)).aSN().Kn(str2).field_nickname;
                arL = d.arL(str2);
                z6 = z;
                break;
            case 6:
                z3 = false;
                z = true;
                z2 = z3;
                str = ((l) g.af(l.class)).aSN().Kn(str2).field_nickname;
                arL = d.arL(str2);
                z6 = z;
                break;
            case 7:
                z3 = true;
                z = true;
                z2 = z3;
                str = ((l) g.af(l.class)).aSN().Kn(str2).field_nickname;
                arL = d.arL(str2);
                z6 = z;
                break;
        }
        this.xcM = str2;
        if (!Util.isNullOrNil(arL)) {
            this.xcL = com.tencent.mm.plugin.fts.a.f.a(e.a(str, this.xcP.wWd, z6, z2, b.c.wZU, arL + "(", ")")).wWu;
        } else {
            this.xcL = com.tencent.mm.plugin.fts.a.f.a(e.a(str, this.xcP.wWd, z6, z2, 400.0f, b.c.wZU)).wWu;
        }
        this.xcL = TextUtils.concat("\"", this.xcL, context.getString(R.string.gh6));
        AppMethodBeat.o(112109);
    }

    @Override // com.tencent.mm.plugin.fts.ui.a.f, com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.k
    public final a.b axc() {
        return this.xdE;
    }
}
