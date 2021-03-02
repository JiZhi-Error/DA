package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.contact.a.a;

public final class k extends a {
    private a QaN = new a();
    b QaO = new b();

    public k(int i2) {
        super(7, i2);
        AppMethodBeat.i(102970);
        AppMethodBeat.o(102970);
    }

    public class a extends a.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(102968);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bq5, viewGroup, false);
            b bVar = k.this.QaO;
            bVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            bVar.contentView = inflate.findViewById(R.id.hi1);
            bVar.QaQ = (ImageView) inflate.findViewById(R.id.his);
            inflate.setTag(bVar);
            AppMethodBeat.o(102968);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102969);
            b bVar = (b) aVar;
            bVar.jVO.setText(R.string.ght);
            if (z2) {
                bVar.QaQ.setVisibility(0);
            } else {
                bVar.QaQ.setVisibility(8);
            }
            bVar.contentView.setBackgroundResource(R.drawable.qd);
            AppMethodBeat.o(102969);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            return false;
        }
    }

    public class b extends a.C2110a {
        public ImageView QaQ;
        public View contentView;
        public TextView jVO;

        public b() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.QaN;
    }
}
