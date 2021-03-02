package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;

public final class j extends a {
    a.C2110a QaJ = new a();
    private b QaL = new b();
    public int resId;
    public boolean wke;

    public j(int i2) {
        super(1, i2);
        AppMethodBeat.i(102967);
        AppMethodBeat.o(102967);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(102965);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bq4, viewGroup, false);
            a aVar = (a) j.this.QaJ;
            aVar.vui = (TextView) inflate.findViewById(R.id.fl3);
            aVar.xcA = (ImageView) inflate.findViewById(R.id.fjt);
            inflate.setTag(aVar);
            AppMethodBeat.o(102965);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102966);
            a aVar3 = (a) aVar;
            j jVar = (j) aVar2;
            Resources resources = context.getResources();
            if (j.this.wke) {
                n.b(resources.getString(R.string.ggv, resources.getString(jVar.resId)), aVar3.vui);
                aVar3.xcA.setRotation(0.0f);
                AppMethodBeat.o(102966);
                return;
            }
            n.b(resources.getString(R.string.ggw), aVar3.vui);
            aVar3.xcA.setRotation(180.0f);
            AppMethodBeat.o(102966);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            return false;
        }
    }

    public class a extends a.C2110a {
        public TextView vui;
        public ImageView xcA;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.QaL;
    }
}
