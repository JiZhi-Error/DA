package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Util;

public class DialNumberButton extends RelativeLayout {
    private TextView ysN;
    private TextView ysO;
    private boolean ysP = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25568);
        LayoutInflater.from(getContext()).inflate(R.layout.zo, this);
        this.ysN = (TextView) findViewById(R.id.bq4);
        this.ysO = (TextView) findViewById(R.id.bq5);
        if (d.oD(16)) {
            this.ysN.setTypeface(Typeface.create("sans-serif-light", 0));
            this.ysO.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
        AppMethodBeat.o(25568);
    }

    public final void setNumberTextSize$255e752(float f2) {
        AppMethodBeat.i(25569);
        this.ysN.setTextSize(0, f2);
        AppMethodBeat.o(25569);
    }

    public String getNumberText() {
        AppMethodBeat.i(25570);
        String charSequence = this.ysN.getText().toString();
        AppMethodBeat.o(25570);
        return charSequence;
    }

    public String getOtherText() {
        AppMethodBeat.i(25571);
        String charSequence = this.ysO.getText().toString();
        AppMethodBeat.o(25571);
        return charSequence;
    }

    public final void il(String str, String str2) {
        AppMethodBeat.i(25572);
        if (!Util.isNullOrNil(str) && str.length() == 1) {
            this.ysN.setText(str);
        }
        if (!Util.isNullOrNil(str2) || "1".equals(str)) {
            this.ysO.setText(str2);
            this.ysO.setVisibility(0);
            AppMethodBeat.o(25572);
            return;
        }
        this.ysO.setVisibility(8);
        AppMethodBeat.o(25572);
    }

    public void setInTalkUIMode(boolean z) {
        AppMethodBeat.i(25573);
        this.ysP = z;
        if (this.ysP) {
            if ("#".equals(this.ysN.getText()) || "*".equals(this.ysN.getText())) {
                this.ysN.setTextColor(getContext().getResources().getColor(R.color.lo));
            } else {
                this.ysN.setTextColor(getContext().getResources().getColor(R.color.lq));
            }
            this.ysO.setTextColor(getContext().getResources().getColor(R.color.lo));
            setBackgroundDrawable(getResources().getDrawable(R.drawable.rq));
            AppMethodBeat.o(25573);
            return;
        }
        if ("#".equals(this.ysN.getText()) || "*".equals(this.ysN.getText())) {
            this.ysN.setTextColor(getContext().getResources().getColor(R.color.lo));
        } else {
            this.ysN.setTextColor(getContext().getResources().getColor(R.color.lp));
        }
        this.ysO.setTextColor(getContext().getResources().getColor(R.color.lo));
        setBackgroundDrawable(getResources().getDrawable(R.drawable.rr));
        AppMethodBeat.o(25573);
    }
}
