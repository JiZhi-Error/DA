package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.j;

public final class ad extends LinearLayout implements j.a {
    private TextView COX = ((TextView) findViewById(R.id.j1l));
    private HeaderContainer OIA;
    private ImageView OIB = ((ImageView) findViewById(R.id.goh));
    private ImageView gvv = ((ImageView) findViewById(R.id.x1));
    private TextView pvG = ((TextView) findViewById(R.id.fz_));

    public ad(Context context) {
        super(context);
        AppMethodBeat.i(33518);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.bbj, (ViewGroup) this, true);
        AppMethodBeat.o(33518);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(33519);
        super.onDraw(canvas);
        AppMethodBeat.o(33519);
    }

    public final void setHeaderContainer(HeaderContainer headerContainer) {
        this.OIA = headerContainer;
    }

    public final void setAccountName(String str) {
        AppMethodBeat.i(33520);
        if (this.COX != null) {
            this.COX.setText(getResources().getString(R.string.h5, str));
        }
        AppMethodBeat.o(33520);
    }

    public final void setNickNameTV(SpannableString spannableString) {
        AppMethodBeat.i(33521);
        if (this.pvG != null) {
            this.pvG.setText(spannableString);
        }
        AppMethodBeat.o(33521);
    }

    public final ImageView getQrCodeIv() {
        return this.OIB;
    }

    public final TextView getNickNameTV() {
        return this.pvG;
    }
}
