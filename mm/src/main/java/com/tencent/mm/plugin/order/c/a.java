package com.tencent.mm.plugin.order.c;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends ClickableSpan {
    public AbstractC1567a AQT = null;
    private int mBgColor = -1;
    private int mColor = -1;
    private Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.order.c.a$a  reason: collision with other inner class name */
    public interface AbstractC1567a {
        void onClick(View view);
    }

    public a(Context context) {
        AppMethodBeat.i(66834);
        this.mContext = context;
        this.mColor = this.mContext.getResources().getColor(R.color.zf);
        this.mBgColor = -1;
        AppMethodBeat.o(66834);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(66835);
        if (this.AQT != null) {
            this.AQT.onClick(view);
        }
        AppMethodBeat.o(66835);
    }

    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(66836);
        super.updateDrawState(textPaint);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(this.mColor);
        textPaint.setUnderlineText(false);
        textPaint.bgColor = this.mBgColor;
        AppMethodBeat.o(66836);
    }
}
