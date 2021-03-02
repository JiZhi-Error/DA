package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;

public final class b {
    private static DisplayMetrics Pfp = null;

    public static a a(Context context, int i2, int i3, int i4, int i5, int i6, boolean z) {
        DisplayMetrics displayMetrics;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(159490);
        a aVar = new a();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        if (context instanceof Activity) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            displayMetrics = displayMetrics2;
        } else {
            if (Pfp == null) {
                Pfp = context.getResources().getDisplayMetrics();
            }
            displayMetrics = Pfp;
        }
        int fromDPToPix = at.fromDPToPix(context, 95);
        if (i2 < fromDPToPix) {
            i2 = fromDPToPix;
        }
        if (i3 < 0) {
            aVar.oxq = 0;
            aVar.oxr = displayMetrics.widthPixels - ((i6 * 2) + i2);
            z2 = false;
            z3 = true;
        } else if (displayMetrics.widthPixels - ((i3 + i2) + (i6 * 2)) < 0) {
            aVar.oxq = (i3 - i2) - i6;
            aVar.oxr = (displayMetrics.widthPixels - i3) - i6;
            z2 = true;
            z3 = false;
        } else {
            aVar.oxq = i3;
            aVar.oxr = displayMetrics.widthPixels - (i3 + i2);
            z2 = false;
            z3 = true;
        }
        if (i4 < 0 || i4 > displayMetrics.heightPixels) {
            i4 = (int) (((float) displayMetrics.heightPixels) / 2.0f);
        }
        if (z) {
            if (i4 >= i5 + i6) {
                aVar.ERI = (i4 - i6) - i5;
                z4 = false;
                z5 = true;
            }
            aVar.ERI = i4 - i6;
            z4 = true;
            z5 = false;
        } else {
            if (displayMetrics.heightPixels - i4 < (i6 * 3) + i5) {
                aVar.ERI = (i4 - i6) - i5;
                z4 = false;
                z5 = true;
            }
            aVar.ERI = i4 - i6;
            z4 = true;
            z5 = false;
        }
        if (z5) {
            aVar.ERI -= i6 * 2;
        } else if (z4) {
            aVar.ERI += i6 * 2;
        }
        if (!z3 || !z4) {
            if (z2 && z4) {
                aVar.QSG = R.style.s_;
                AppMethodBeat.o(159490);
                return aVar;
            } else if (z3 && z5) {
                aVar.QSG = R.style.s7;
                AppMethodBeat.o(159490);
                return aVar;
            } else if (z2 && z5) {
                aVar.QSG = R.style.s9;
                AppMethodBeat.o(159490);
                return aVar;
            }
        }
        aVar.QSG = R.style.s8;
        AppMethodBeat.o(159490);
        return aVar;
    }

    public static class a {
        public int ERI;
        public int QSG;
        public int oxq;
        public int oxr;

        public final String toString() {
            AppMethodBeat.i(159489);
            String str = " marginLeft:" + this.oxq + " marginRight:" + this.oxr;
            AppMethodBeat.o(159489);
            return str;
        }
    }
}
