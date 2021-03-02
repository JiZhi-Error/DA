package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class l extends ClickableSpan {
    public a IgH = null;
    private int mBgColor = -1;
    int mColor = -1;

    public interface a {
        void onClick(View view);
    }

    public l(Context context) {
        AppMethodBeat.i(70927);
        this.mColor = context.getResources().getColor(R.color.ae6);
        this.mBgColor = context.getResources().getColor(R.color.ac_);
        AppMethodBeat.o(70927);
    }

    public void onClick(View view) {
        AppMethodBeat.i(70928);
        if (this.IgH != null) {
            this.IgH.onClick(view);
        }
        AppMethodBeat.o(70928);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(70929);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.mBgColor;
        AppMethodBeat.o(70929);
    }
}
