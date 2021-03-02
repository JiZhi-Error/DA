package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;

public final class b {
    public static final int JkA;
    public static final float JkB;
    public static final int JkC = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap2);
    public static final int JkD;
    public static final float JkE;
    public static final int Jkw = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.b9);
    public static final int Jkx = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap9);
    public static final int Jky = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap8);
    public static final int Jkz = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap6);
    public static final int oYI = au.getStatusBarHeight(MMApplicationContext.getContext());
    public static int oYU = aD(MMApplicationContext.getContext());

    static {
        AppMethodBeat.i(80415);
        int dimensionPixelSize = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap5);
        JkA = dimensionPixelSize;
        JkB = ((float) dimensionPixelSize) / ((float) Jkz);
        int dimensionPixelSize2 = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ap1);
        JkD = dimensionPixelSize2;
        JkE = ((float) dimensionPixelSize2) / ((float) JkC);
        AppMethodBeat.o(80415);
    }

    private static int aD(Context context) {
        AppMethodBeat.i(80413);
        int aD = au.aD(context);
        Log.i("MicroMsg.BagIndicatorController", "getNavigationBarHeight height:%d", Integer.valueOf(aD));
        AppMethodBeat.o(80413);
        return aD;
    }

    public static void eG(Context context) {
        AppMethodBeat.i(80414);
        oYU = aD(context);
        AppMethodBeat.o(80414);
    }
}
