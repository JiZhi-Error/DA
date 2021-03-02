package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c {
    private static c Ffh = new c();
    private a Ffe = null;
    private int Fff = 0;

    static {
        AppMethodBeat.i(100505);
        AppMethodBeat.o(100505);
    }

    public static c flh() {
        return Ffh;
    }

    public final a getTextViewConfig() {
        AppMethodBeat.i(100503);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) (15.0f * com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
        if (this.Ffe == null || ((int) this.Ffe.textSize) != fromDPToPix) {
            this.Ffe = b.aBq().as((float) fromDPToPix).ql(MMApplicationContext.getContext().getResources().getColor(R.color.a8v)).qk(16).b(TextUtils.TruncateAt.END).huK;
        }
        a aVar = this.Ffe;
        AppMethodBeat.o(100503);
        return aVar;
    }

    public final int getViewWidth() {
        AppMethodBeat.i(100504);
        if (this.Fff <= 0) {
            int i2 = aj.ejr().x;
            int dimension = (int) (MMApplicationContext.getResources().getDimension(R.dimen.ir) + MMApplicationContext.getResources().getDimension(R.dimen.ir));
            int dimension2 = (int) MMApplicationContext.getResources().getDimension(R.dimen.ak9);
            int dimension3 = (int) MMApplicationContext.getResources().getDimension(R.dimen.ir);
            this.Fff = ((i2 - dimension2) - dimension) - dimension3;
            if (this.Fff <= 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                this.Fff = ((i2 - dimension2) - dimension) - dimension3;
                Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "try again, screenWidth " + i2 + " textViewWidth " + this.Fff + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
            }
            Log.i("MicroMsg.SnsComment2LinePreloadTextViewConfig", "finally, screenWidth " + i2 + " textViewWidth " + this.Fff + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        int i3 = this.Fff;
        AppMethodBeat.o(100504);
        return i3;
    }
}
