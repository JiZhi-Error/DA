package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class PLSysTextView extends SysTextView {
    public PLSysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLSysTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.widget.TextView, com.tencent.mm.kiss.widget.textview.SysTextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        boolean z;
        AppMethodBeat.i(141018);
        if (Util.isNullOrNil(charSequence)) {
            if (h.DEBUG) {
                Log.d("MicroMsg.PLSysTextView", "set null text");
            }
            AppMethodBeat.o(141018);
            return;
        }
        long j2 = 0;
        if (h.DEBUG) {
            j2 = System.currentTimeMillis();
        }
        if (getLayoutWrapper() != null && getLayoutWrapper().huF) {
            c.hue.a(getConfig(), getLayoutWrapper());
        }
        f a2 = c.hue.a(getConfig(), charSequence);
        if (a2 != null) {
            setTextLayout(a2);
            z = true;
        } else {
            super.setText$609c24db(charSequence);
            z = false;
        }
        if (h.DEBUG) {
            Log.d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", Double.valueOf(((double) (System.currentTimeMillis() - j2)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence);
        }
        AppMethodBeat.o(141018);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.kiss.widget.textview.SysTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141019);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(141019);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.kiss.widget.textview.SysTextView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141020);
        super.onDraw(canvas);
        AppMethodBeat.o(141020);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(141021);
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().huF = false;
        }
        AppMethodBeat.o(141021);
    }

    @Override // com.tencent.mm.kiss.widget.textview.SysTextView
    public boolean onPreDraw() {
        return true;
    }
}
