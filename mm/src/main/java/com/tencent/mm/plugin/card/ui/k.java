package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class k extends c {
    private final String TAG = "MicroMsg.CardTicketAdapter";
    private int count = 0;
    private c pXo;
    private n.a pYR;
    private final String qee = "PRIVATE_TICKET_TITLE";
    private final String qef = "PRIVATE_INVOICE_TITLE";
    private ArrayList<CardInfo> qeg;
    private ArrayList<CardInfo> qeh;
    private ArrayList<CardInfo> qei;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ CardInfo getItem(int i2) {
        AppMethodBeat.i(113590);
        CardInfo Ep = Ep(i2);
        AppMethodBeat.o(113590);
        return Ep;
    }

    public k(Context context, n.a aVar) {
        super(context, aVar);
        AppMethodBeat.i(113581);
        this.pYR = aVar;
        this.pXo = new aa(context, this);
        this.qeg = new ArrayList<>();
        this.qeh = new ArrayList<>();
        this.qei = new ArrayList<>();
        AppMethodBeat.o(113581);
    }

    private void cwo() {
        AppMethodBeat.i(113582);
        this.qeg.clear();
        this.qeh.clear();
        this.qei.clear();
        for (int i2 = 0; i2 < this.count; i2++) {
            CardInfo cardInfo = (CardInfo) super.getItem(i2);
            if (cardInfo != null) {
                if (cardInfo.csB()) {
                    this.qei.add(cardInfo);
                } else {
                    this.qeh.add(cardInfo);
                }
            }
        }
        if (!this.qeh.isEmpty()) {
            CardInfo cardInfo2 = new CardInfo();
            cardInfo2.field_card_id = "PRIVATE_TICKET_TITLE";
            this.qeg.add(cardInfo2);
            this.qeg.addAll(this.qeh);
        }
        if (!this.qei.isEmpty()) {
            CardInfo cardInfo3 = new CardInfo();
            cardInfo3.field_card_id = "PRIVATE_INVOICE_TITLE";
            this.qeg.add(cardInfo3);
            this.qeg.addAll(this.qei);
        }
        this.count = this.qeg.size();
        AppMethodBeat.o(113582);
    }

    @Override // com.tencent.mm.ui.s, com.tencent.mm.plugin.card.ui.c
    public final void anp() {
        AppMethodBeat.i(113583);
        Log.v("MicroMsg.CardTicketAdapter", "resetCursor");
        ebf();
        Cursor a2 = am.ctQ().a(this.pYR);
        if (a2 != null) {
            this.count = a2.getCount();
            Log.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
        }
        setCursor(a2);
        cwo();
        notifyDataSetChanged();
        AppMethodBeat.o(113583);
    }

    @Override // com.tencent.mm.ui.s, com.tencent.mm.plugin.card.ui.c
    public final void anq() {
        AppMethodBeat.i(113584);
        ebf();
        anp();
        AppMethodBeat.o(113584);
    }

    private CardInfo Ep(int i2) {
        AppMethodBeat.i(113585);
        CardInfo cardInfo = this.qeg.get(i2);
        AppMethodBeat.o(113585);
        return cardInfo;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(113586);
        CardInfo Ep = Ep(i2);
        if (Ep.field_card_id.equals("PRIVATE_TICKET_TITLE") || Ep.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            AppMethodBeat.o(113586);
            return 0;
        } else if (Ep.csB()) {
            AppMethodBeat.o(113586);
            return 2;
        } else {
            AppMethodBeat.o(113586);
            return 1;
        }
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(113587);
        if (this.qeg.isEmpty()) {
            int count2 = super.getCount();
            AppMethodBeat.o(113587);
            return count2;
        }
        int size = this.qeg.size();
        AppMethodBeat.o(113587);
        return size;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.card.ui.c
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(113588);
        View a2 = this.pXo.a(i2, view, Ep(i2));
        AppMethodBeat.o(113588);
        return a2;
    }

    @Override // com.tencent.mm.plugin.card.ui.c
    public final void release() {
        AppMethodBeat.i(113589);
        ebf();
        this.pXo.release();
        this.pXo = null;
        AppMethodBeat.o(113589);
    }
}
