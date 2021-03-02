package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.contact.a.a;

public class f extends a {
    a QaA = new a();
    public CharSequence Qax;
    public int Qay = 0;
    private b Qaz = new b();
    public CharSequence jVL;
    public String username;

    public f(int i2) {
        super(4, i2);
        AppMethodBeat.i(102952);
        AppMethodBeat.o(102952);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(102950);
            if (com.tencent.mm.cb.a.jk(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.bq0, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.bpz, viewGroup, false);
            }
            a aVar = f.this.QaA;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.gvw = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.jBR.setVisibility(8);
            aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
            inflate.setTag(aVar);
            AppMethodBeat.o(102950);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102951);
            f fVar = (f) aVar2;
            a aVar3 = (a) aVar;
            aVar3.gvw.setCompoundDrawables(null, null, null, null);
            if (f.this.Qay == 0 || f.this.Qax == null) {
                n.a(fVar.jVL, aVar3.gvw);
                if (as.bjp(fVar.username)) {
                    g.aAi();
                    as Kn = ((l) g.af(l.class)).aSN().Kn(fVar.username);
                    ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(context, aVar3.gvw, fVar.jVL, Kn.field_openImAppid, Kn.field_descWordingId, (int) aVar3.gvw.getTextSize());
                }
                a.b.c(aVar3.gvv, fVar.username);
                if (ab.Iz(fVar.username)) {
                    Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    aVar3.gvw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                } else {
                    aVar3.gvw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (f.this.PWh) {
                    if (z) {
                        aVar3.jVQ.setChecked(true);
                        aVar3.jVQ.setEnabled(false);
                        aVar3.jVQ.setBackgroundResource(ao.isDarkMode() ? R.raw.checkbox_selected_grey_dark : R.raw.checkbox_selected_grey);
                    } else {
                        aVar3.jVQ.setChecked(z2);
                        aVar3.jVQ.setEnabled(true);
                    }
                    aVar3.jVQ.setVisibility(0);
                    AppMethodBeat.o(102951);
                    return;
                }
                aVar3.jVQ.setVisibility(8);
                AppMethodBeat.o(102951);
                return;
            }
            aVar3.gvv.setImageResource(f.this.Qay);
            aVar3.gvw.setText(f.this.Qax);
            AppMethodBeat.o(102951);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            return false;
        }
    }

    public class a extends a.C2110a {
        public ImageView gvv;
        public TextView gvw;
        public TextView jBR;
        public CheckBox jVQ;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public void a(Context context, a.C2110a aVar) {
        AppMethodBeat.i(102953);
        if (this.Qay != 0 && this.Qax != null) {
            AppMethodBeat.o(102953);
        } else if (this.contact == null) {
            this.jVL = "";
            this.username = "";
            AppMethodBeat.o(102953);
        } else {
            this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact), com.tencent.mm.cb.a.aG(context, R.dimen.is));
            this.username = this.contact.field_username;
            AppMethodBeat.o(102953);
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public a.b bmx() {
        return this.Qaz;
    }
}
