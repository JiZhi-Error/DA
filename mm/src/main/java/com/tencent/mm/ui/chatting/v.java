package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.s;

public final class v extends s<ca> {
    private String EFT;
    private boolean Pdm;
    public a Pit;
    public String talker;
    private String xay;

    public interface a {
        void amk(int i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ ca a(ca caVar, Cursor cursor) {
        AppMethodBeat.i(34633);
        ca caVar2 = caVar;
        if (caVar2 == null) {
            caVar2 = new ca();
        }
        caVar2.convertFrom(cursor);
        AppMethodBeat.o(34633);
        return caVar2;
    }

    public v(Context context, ca caVar, String str, String str2, boolean z) {
        super(context, caVar);
        this.talker = str;
        this.EFT = str2;
        this.Pdm = z;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(34628);
        if (view == null) {
            view = View.inflate(this.context, R.layout.bov, null);
            bVar = new b((byte) 0);
            bVar.gvv = (ImageView) view.findViewById(R.id.x1);
            bVar.gvw = (TextView) view.findViewById(R.id.fzg);
            bVar.pld = (TextView) view.findViewById(R.id.j0l);
            bVar.Piu = (TextView) view.findViewById(R.id.fn8);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ca caVar = (ca) getItem(i2);
        if (caVar != null) {
            if (!this.Pdm || caVar.field_isSend != 0) {
                a.b.c(bVar.gvv, bx(caVar));
                bVar.gvw.setText(l.b(this.context, aa.getDisplayName(bx(caVar)), bVar.gvw.getTextSize()));
                bVar.pld.setText(by(caVar));
                bVar.Piu.setText(l.b(this.context, caVar.field_content, bVar.Piu.getTextSize()));
            } else {
                String str = caVar.field_content;
                String Ks = bp.Ks(str);
                if (!Util.isNullOrNil(Ks)) {
                    a.b.c(bVar.gvv, Ks);
                    bVar.gvw.setText(l.b(this.context, aa.getDisplayName(Ks), bVar.gvw.getTextSize()));
                }
                bVar.pld.setText(by(caVar));
                bVar.Piu.setText(l.b(this.context, bp.Kt(str), bVar.Piu.getTextSize()));
            }
        }
        AppMethodBeat.o(34628);
        return view;
    }

    public final void SM(String str) {
        AppMethodBeat.i(34629);
        this.xay = str;
        if (!Util.isNullOrNil(this.xay)) {
            ebf();
            anp();
        }
        AppMethodBeat.o(34629);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(34630);
        bg.aVF();
        setCursor(c.aSQ().iH(this.talker, this.xay));
        if (this.Pit != null && !Util.isNullOrNil(this.xay)) {
            this.Pit.amk(getCount());
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(34630);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(34631);
        ebf();
        anp();
        AppMethodBeat.o(34631);
    }

    static class b {
        public TextView Piu;
        public ImageView gvv;
        public TextView gvw;
        public TextView pld;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    private String bx(ca caVar) {
        return caVar.field_isSend == 1 ? this.EFT : this.talker;
    }

    private CharSequence by(ca caVar) {
        AppMethodBeat.i(34632);
        if (caVar.field_createTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(34632);
            return "";
        }
        CharSequence c2 = f.c(this.context, caVar.field_createTime, true);
        AppMethodBeat.o(34632);
        return c2;
    }
}
