package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;

public final class c extends n {
    public int resId;
    public boolean wke;
    private b xcy = new b();
    a xcz = new a();

    public c(int i2) {
        super(i2);
        AppMethodBeat.i(112058);
        AppMethodBeat.o(112058);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112056);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an1, viewGroup, false);
            a aVar = c.this.xcz;
            aVar.vui = (TextView) inflate.findViewById(R.id.fl3);
            aVar.xcA = (ImageView) inflate.findViewById(R.id.fjt);
            inflate.setTag(aVar);
            AppMethodBeat.o(112056);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112057);
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            Resources resources = context.getResources();
            if (c.this.wke) {
                n.b(resources.getString(R.string.ggv, resources.getString(cVar.resId)), aVar3.vui);
                aVar3.xcA.setRotation(0.0f);
                AppMethodBeat.o(112057);
                return;
            }
            n.b(resources.getString(R.string.ggw), aVar3.vui);
            aVar3.xcA.setRotation(180.0f);
            AppMethodBeat.o(112057);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public class a extends a.AbstractC1374a {
        public TextView vui;
        public ImageView xcA;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.n
    public final a.b axc() {
        return this.xcy;
    }
}
