package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ar;

public class SplashImageView extends ImageView {
    private ar OLl;
    private boolean hasDrawed;

    public SplashImageView(Context context) {
        super(context);
        AppMethodBeat.i(33760);
        etg();
        AppMethodBeat.o(33760);
    }

    public SplashImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33761);
        etg();
        AppMethodBeat.o(33761);
    }

    public SplashImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33762);
        etg();
        AppMethodBeat.o(33762);
    }

    private void etg() {
        AppMethodBeat.i(33763);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.cpd));
        AppMethodBeat.o(33763);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(33764);
        super.onDraw(canvas);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.cpd));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.OLl != null) {
                this.OLl.dSa();
            }
        }
        AppMethodBeat.o(33764);
    }

    public void setOnDrawListener(ar arVar) {
        this.OLl = arVar;
    }
}
