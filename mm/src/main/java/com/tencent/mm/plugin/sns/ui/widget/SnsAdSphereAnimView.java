package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdSphereAnimView extends FrameLayout {
    public static int Fes = 1;
    public static int Fet = 2;
    public static int Feu = 3;
    public static int Fev = 4;
    public Handler DAC = new Handler(Looper.getMainLooper());
    public a Few;
    public int Fex = 0;
    private long kZb = 0;
    public Context mContext;

    public SnsAdSphereAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(179378);
        this.mContext = context;
        AppMethodBeat.o(179378);
    }

    public SnsAdSphereAnimView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(179379);
        this.mContext = context;
        AppMethodBeat.o(179379);
    }

    public final void clear() {
        AppMethodBeat.i(179380);
        Log.i("SnsAdSphereAnimView", "clear");
        if (this.Few != null) {
            this.Few.clear();
            this.Few = null;
        }
        this.DAC.removeCallbacksAndMessages(null);
        AppMethodBeat.o(179380);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(179381);
        super.onDetachedFromWindow();
        clear();
        AppMethodBeat.o(179381);
    }
}
