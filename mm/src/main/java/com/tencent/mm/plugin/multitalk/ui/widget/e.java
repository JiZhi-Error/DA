package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;

public final class e extends com.tencent.mm.ui.contact.a.e {
    private a zRS = new a();

    static /* synthetic */ a.C2110a a(e eVar) {
        AppMethodBeat.i(114719);
        a.C2110a eOf = eVar.eOf();
        AppMethodBeat.o(114719);
        return eOf;
    }

    public e(int i2) {
        super(i2);
        AppMethodBeat.i(114718);
        AppMethodBeat.o(114718);
    }

    public class a extends e.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b, com.tencent.mm.ui.contact.a.e.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(114716);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bcp, viewGroup, false);
            e.a aVar = (e.a) e.a(e.this);
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.contentView = inflate.findViewById(R.id.hi1);
            aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
            inflate.setTag(aVar);
            AppMethodBeat.o(114716);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b, com.tencent.mm.ui.contact.a.e.b
        public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(114717);
            e.a aVar3 = (e.a) aVar;
            com.tencent.mm.ui.contact.a.e eVar = (com.tencent.mm.ui.contact.a.e) aVar2;
            if (eVar.username == null || eVar.username.length() <= 0) {
                aVar3.gvv.setImageResource(R.drawable.bca);
            } else {
                a.b.c(aVar3.gvv, eVar.username);
            }
            n.a(eVar.jVL, aVar3.jVO);
            if (e.this.PWh) {
                if (z) {
                    aVar3.jVQ.setChecked(true);
                    aVar3.jVQ.setEnabled(false);
                    aVar3.jVQ.setBackgroundResource(R.raw.checkbox_selected_grey_dark);
                } else {
                    aVar3.jVQ.setChecked(z2);
                    aVar3.jVQ.setEnabled(true);
                    if (z2) {
                        aVar3.jVQ.setBackgroundResource(R.raw.checkbox_selected);
                    } else {
                        aVar3.jVQ.setBackgroundResource(R.drawable.p7);
                    }
                }
                aVar3.jVQ.setVisibility(0);
                AppMethodBeat.o(114717);
                return;
            }
            aVar3.jVQ.setVisibility(8);
            AppMethodBeat.o(114717);
        }
    }

    @Override // com.tencent.mm.ui.contact.a.e, com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.zRS;
    }
}
