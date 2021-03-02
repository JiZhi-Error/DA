package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.s;

public class c extends s<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    private com.tencent.mm.plugin.card.base.c pXo;
    private n.a pYR;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ CardInfo a(CardInfo cardInfo, Cursor cursor) {
        AppMethodBeat.i(113179);
        CardInfo cardInfo2 = cardInfo;
        if (cardInfo2 == null) {
            cardInfo2 = new CardInfo();
        }
        if (cursor.isClosed()) {
            Log.e("MicroMsg.CardAdapter", "cursor is closed!");
            AppMethodBeat.o(113179);
        } else {
            cardInfo2.convertFrom(cursor);
            AppMethodBeat.o(113179);
        }
        return cardInfo2;
    }

    public c(Context context, n.a aVar) {
        super(context, new CardInfo());
        AppMethodBeat.i(113174);
        this.pYR = aVar;
        Bh(true);
        this.pXo = new l(context, this);
        AppMethodBeat.o(113174);
    }

    @Override // com.tencent.mm.ui.s
    public void anp() {
        AppMethodBeat.i(113175);
        Log.v("MicroMsg.CardAdapter", "resetCursor");
        ebf();
        Cursor a2 = am.ctQ().a(this.pYR);
        if (a2 != null) {
            this.count = a2.getCount();
            Log.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(a2);
        notifyDataSetChanged();
        AppMethodBeat.o(113175);
    }

    @Override // com.tencent.mm.ui.s
    public void anq() {
        AppMethodBeat.i(113176);
        ebf();
        anp();
        AppMethodBeat.o(113176);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(113177);
        View a2 = this.pXo.a(i2, view, (CardInfo) getItem(i2));
        AppMethodBeat.o(113177);
        return a2;
    }

    public void release() {
        AppMethodBeat.i(113178);
        ebf();
        this.pXo.release();
        this.pXo = null;
        AppMethodBeat.o(113178);
    }
}
