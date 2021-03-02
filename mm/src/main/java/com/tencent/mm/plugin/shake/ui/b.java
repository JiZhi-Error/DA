package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.s;

/* access modifiers changed from: package-private */
public final class b extends s<cl> {
    protected MMSlideDelView.f AAA;
    private cm Djk;
    private MMActivity gte;
    private int limit = -1;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ cl a(cl clVar, Cursor cursor) {
        AppMethodBeat.i(28376);
        cl clVar2 = clVar;
        if (clVar2 == null) {
            clVar2 = new cl();
        }
        clVar2.convertFrom(cursor);
        AppMethodBeat.o(28376);
        return clVar2;
    }

    public b(Context context, cm cmVar, int i2) {
        super(context, new cl());
        AppMethodBeat.i(28371);
        this.gte = (MMActivity) context;
        this.limit = i2;
        this.Djk = cmVar;
        AppMethodBeat.o(28371);
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.AAA = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    public final void XB(int i2) {
        AppMethodBeat.i(28372);
        ebf();
        this.limit = i2;
        anp();
        AppMethodBeat.o(28372);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(28373);
        anp();
        AppMethodBeat.o(28373);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(28374);
        setCursor(this.Djk.Pf(this.limit));
        super.notifyDataSetChanged();
        AppMethodBeat.o(28374);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(28375);
        cl clVar = (cl) getItem(i2);
        if (view == null) {
            MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.gte, R.layout.is, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.gte, R.layout.bnj, null);
            aVar2.gyr = (ImageView) inflate.findViewById(R.id.bdp);
            aVar2.kcS = (TextView) inflate.findViewById(R.id.bro);
            aVar2.znW = (TextView) inflate.findViewById(R.id.h_o);
            aVar2.plg = mMSlideDelView.findViewById(R.id.hsk);
            aVar2.plh = (TextView) mMSlideDelView.findViewById(R.id.hsm);
            mMSlideDelView.setView(inflate);
            mMSlideDelView.setPerformItemClickListener(this.pkY);
            mMSlideDelView.setGetViewPositionCallback(this.pkZ);
            mMSlideDelView.setItemStatusCallBack(this.plb);
            mMSlideDelView.setEnable(false);
            mMSlideDelView.setTag(aVar2);
            aVar = aVar2;
            view = mMSlideDelView;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.plg.setTag(Long.valueOf(clVar.field_svrid));
        aVar.plg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(28370);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
                b.this.plb.ebp();
                if (b.this.AAA != null) {
                    b.this.AAA.cZ(view.getTag());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(28370);
            }
        });
        aVar.kcS.setText(l.b(this.gte, ca.d.bkD(clVar.field_content).getDisplayName(), aVar.kcS.getTextSize()));
        aVar.znW.setText(clVar.field_sayhicontent);
        a.b.c(aVar.gyr, clVar.field_sayhiuser);
        AppMethodBeat.o(28375);
        return view;
    }

    static class a {
        ImageView gyr;
        TextView kcS;
        View plg;
        TextView plh;
        TextView znW;

        a() {
        }
    }
}
