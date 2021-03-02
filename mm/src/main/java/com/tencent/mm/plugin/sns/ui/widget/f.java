package com.tencent.mm.plugin.sns.ui.widget;

import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f {
    private static f FfF = new f();
    private static final int FfI = a.aH(MMApplicationContext.getContext(), R.dimen.t);
    private com.tencent.mm.kiss.widget.textview.a.a FfG = null;
    private com.tencent.mm.kiss.widget.textview.a.a FfH = null;
    public int Fff = 0;

    static {
        AppMethodBeat.i(100557);
        AppMethodBeat.o(100557);
    }

    public static f fll() {
        return FfF;
    }

    public final com.tencent.mm.kiss.widget.textview.a.a getTextViewConfig() {
        AppMethodBeat.i(100553);
        int ez = (int) (((float) FfI) * a.ez(MMApplicationContext.getContext()));
        if (this.FfG == null || ((int) this.FfG.textSize) != ez) {
            if (Build.VERSION.SDK_INT == 28) {
                this.FfG = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(R.color.a2x)).as((float) ez).aBs().huK;
            } else {
                this.FfG = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(R.color.a2x)).as((float) ez).huK;
            }
        }
        com.tencent.mm.kiss.widget.textview.a.a aVar = this.FfG;
        AppMethodBeat.o(100553);
        return aVar;
    }

    public final com.tencent.mm.kiss.widget.textview.a.a flm() {
        AppMethodBeat.i(100554);
        int ez = (int) (((float) FfI) * a.ez(MMApplicationContext.getContext()));
        if (Build.VERSION.SDK_INT == 28) {
            this.FfH = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(R.color.a2x)).as((float) ez).aBr().aBs().huK;
        } else {
            this.FfH = b.aBq().qk(8388627).ql(MMApplicationContext.getContext().getResources().getColor(R.color.a2x)).as((float) ez).aBr().huK;
        }
        com.tencent.mm.kiss.widget.textview.a.a aVar = this.FfH;
        AppMethodBeat.o(100554);
        return aVar;
    }

    public final int getViewWidth() {
        AppMethodBeat.i(100555);
        if (this.Fff <= 0) {
            int i2 = aj.ejr().x;
            int dimension = (int) (MMApplicationContext.getResources().getDimension(R.dimen.ir) + MMApplicationContext.getResources().getDimension(R.dimen.ir));
            int dimension2 = (int) MMApplicationContext.getResources().getDimension(R.dimen.ak9);
            int dimension3 = (int) MMApplicationContext.getResources().getDimension(R.dimen.ir);
            this.Fff = (i2 - dimension2) - dimension;
            if (this.Fff <= 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                this.Fff = (i2 - dimension2) - dimension;
                Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "try again, screenWidth " + i2 + " textViewWidth " + this.Fff + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
            }
            Log.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "finally, screenWidth " + i2 + " textViewWidth " + this.Fff + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        int i3 = this.Fff;
        AppMethodBeat.o(100555);
        return i3;
    }

    public static float getTextSize() {
        AppMethodBeat.i(100556);
        float ez = (float) ((int) (((float) FfI) * a.ez(MMApplicationContext.getContext())));
        AppMethodBeat.o(100556);
        return ez;
    }

    public static void resetConfig() {
        f fVar = FfF;
        fVar.FfG = null;
        fVar.FfH = null;
    }
}
