package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.s;

/* access modifiers changed from: package-private */
@Deprecated
public final class e extends s<g> {
    private String kcL;
    a kkM;
    private int[] pt;

    public interface a {
        void ve(int i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ g a(g gVar, Cursor cursor) {
        AppMethodBeat.i(127957);
        g gVar2 = gVar;
        if (gVar2 == null) {
            gVar2 = new g();
        }
        gVar2.convertFrom(cursor);
        AppMethodBeat.o(127957);
        return gVar2;
    }

    public e(Context context, s.a aVar) {
        super(context, new g());
        AppMethodBeat.i(127952);
        super.a(aVar);
        AppMethodBeat.o(127952);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(127953);
        anp();
        AppMethodBeat.o(127953);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(127954);
        setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().SY(this.kcL));
        this.pt = new int[getCount()];
        if (!(this.kkM == null || this.kcL == null)) {
            this.kkM.ve(getCursor().getCount());
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(127954);
    }

    public final void SM(String str) {
        AppMethodBeat.i(127955);
        this.kcL = Util.escapeSqlValue(str.trim());
        ebf();
        anp();
        AppMethodBeat.o(127955);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(127956);
        g gVar = (g) getItem(i2);
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.context, R.layout.a6m, null);
            bVar.gyr = (ImageView) view.findViewById(R.id.bdp);
            bVar.kcS = (TextView) view.findViewById(R.id.gmo);
            bVar.keD = (TextView) view.findViewById(R.id.gmj);
            bVar.kkN = (TextView) view.findViewById(R.id.gmk);
            bVar.kkO = (TextView) view.findViewById(R.id.gmm);
            bVar.kkP = (ImageView) view.findViewById(R.id.gmr);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.kcS.setText(l.b(this.context, gVar.bnT(), bVar.kcS.getTextSize()));
        bVar.kkO.setVisibility(8);
        bVar.kkP.setVisibility(0);
        switch (this.pt[i2]) {
            case 0:
                if (gVar.status == 102 || ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjG(gVar.getUsername())) {
                    if (gVar.status != 102) {
                        bVar.keD.setVisibility(0);
                        bVar.keD.setText(R.string.diy);
                        bVar.keD.setTextColor(this.context.getResources().getColor(R.color.c2));
                        bVar.kkN.setVisibility(8);
                        break;
                    } else {
                        bVar.keD.setVisibility(8);
                        bVar.kkN.setVisibility(8);
                        bVar.kkP.setVisibility(8);
                        break;
                    }
                } else {
                    bVar.keD.setVisibility(8);
                    bVar.kkN.setVisibility(0);
                    break;
                }
                break;
            case 2:
                bVar.kkN.setVisibility(8);
                bVar.keD.setVisibility(0);
                bVar.keD.setText(R.string.dj2);
                bVar.keD.setTextColor(this.context.getResources().getColor(R.color.c3));
                break;
        }
        Bitmap LY = c.LY(new StringBuilder().append(gVar.fuC).toString());
        if (LY == null) {
            bVar.gyr.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.raw.default_avatar));
        } else {
            bVar.gyr.setImageBitmap(LY);
        }
        AppMethodBeat.o(127956);
        return view;
    }

    static class b {
        ImageView gyr;
        TextView kcS;
        TextView keD;
        TextView kkN;
        TextView kkO;
        ImageView kkP;

        b() {
        }
    }
}
