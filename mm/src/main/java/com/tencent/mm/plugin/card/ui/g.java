package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g extends BaseAdapter {
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.card.ui.g.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(113472);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            int intValue = ((Integer) view.getTag()).intValue();
            g gVar = g.this;
            if (gVar.qcw.get(intValue).booleanValue()) {
                gVar.qcw.set(intValue, Boolean.FALSE);
            } else {
                gVar.qcw.set(intValue, Boolean.TRUE);
            }
            gVar.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(113472);
        }
    };
    Context mContext;
    private boolean pTl = true;
    c pXo;
    List<CardInfo> pXz = new ArrayList();
    private boolean qcv = false;
    List<Boolean> qcw = new ArrayList();
    a qcx;

    public interface a {
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(113477);
        CardInfo Ep = Ep(i2);
        AppMethodBeat.o(113477);
        return Ep;
    }

    public g(Context context) {
        AppMethodBeat.i(113473);
        this.pXo = new l(context, this);
        this.mContext = context;
        AppMethodBeat.o(113473);
    }

    public final int getCount() {
        AppMethodBeat.i(113474);
        int size = this.pXz.size();
        AppMethodBeat.o(113474);
        return size;
    }

    public final CardInfo Ep(int i2) {
        AppMethodBeat.i(113475);
        CardInfo cardInfo = this.pXz.get(i2);
        AppMethodBeat.o(113475);
        return cardInfo;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(113476);
        CardInfo Ep = Ep(i2);
        Ep.pTl = this.pTl;
        View a2 = this.pXo.a(i2, view, Ep);
        if (!this.qcv || !Ep.csC()) {
            this.pXo.Z(a2, 8);
        } else {
            this.pXo.Z(a2, 0);
            if (this.qcw.get(i2).booleanValue()) {
                this.pXo.Y(a2, R.drawable.ky);
            } else {
                this.pXo.Y(a2, R.drawable.kz);
            }
            this.pXo.a(a2, i2, this.kuO);
        }
        AppMethodBeat.o(113476);
        return a2;
    }
}
