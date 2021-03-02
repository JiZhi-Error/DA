package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class PLTextView extends StaticTextView {
    private static int gRJ = 0;
    private static long hug = 0;
    private static int huh = 0;
    private static long hui = -2147483648L;
    private static long huj = 0;
    private static int huk = 0;
    private static long hul = -2147483648L;
    private static long hum = 0;
    private static long hun = -2147483648L;
    private static boolean huo = false;

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public void setText(CharSequence charSequence) {
        boolean z;
        AppMethodBeat.i(141022);
        if (Util.isNullOrNil(charSequence)) {
            if (h.DEBUG) {
                Log.d("MicroMsg.PLTextView", "set null text");
            }
            AppMethodBeat.o(141022);
            return;
        }
        long j2 = 0;
        long j3 = 0;
        if (h.DEBUG) {
            j2 = System.currentTimeMillis();
        }
        if (getLayoutWrapper() != null && getLayoutWrapper().huF) {
            c.hue.a(getConfig(), getLayoutWrapper());
        }
        f a2 = c.hue.a(getConfig(), charSequence);
        if (a2 != null) {
            z = true;
            B(charSequence);
            setTextLayout(a2);
        } else {
            z = false;
            A(charSequence);
        }
        if (h.DEBUG) {
            j3 = System.currentTimeMillis();
            Log.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", Double.valueOf(((double) (j3 - j2)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z));
        }
        if (huo) {
            long j4 = j3 - j2;
            hug += j4;
            huh++;
            if (j4 > hui) {
                hui = j4;
            }
        }
        AppMethodBeat.o(141022);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141023);
        long j2 = 0;
        if (huo) {
            j2 = System.currentTimeMillis();
        }
        super.onMeasure(i2, i3);
        if (huo) {
            long currentTimeMillis = System.currentTimeMillis() - j2;
            huj += currentTimeMillis;
            huk++;
            if (currentTimeMillis > hul) {
                hul = currentTimeMillis;
            }
        }
        AppMethodBeat.o(141023);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141024);
        long j2 = 0;
        if (huo) {
            j2 = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (huo) {
            long currentTimeMillis = System.currentTimeMillis() - j2;
            hum += currentTimeMillis;
            gRJ++;
            if (currentTimeMillis > hun) {
                hun = currentTimeMillis;
            }
        }
        AppMethodBeat.o(141024);
    }

    /* access modifiers changed from: protected */
    public void A(CharSequence charSequence) {
        AppMethodBeat.i(141025);
        super.setText(charSequence, false);
        AppMethodBeat.o(141025);
    }

    /* access modifiers changed from: protected */
    public void B(CharSequence charSequence) {
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(141026);
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().huF = false;
        }
        AppMethodBeat.o(141026);
    }
}
