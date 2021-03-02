package com.tencent.mm.plugin.multitask;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020%H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0010\u0010\u0015\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u000e\u0010!\u001a\u00020\"XT¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskFBViewConstants;", "", "()V", "DECODE_BITMAP_SCALE", "", "DURATION_ENTER_TRANSFORMATION", "", "DURATION_EXIT_TRANSFORMATION", "DURATION_FOR_PAGE_TRANSFORMATION", "FLOAT_BALL_DEFAULT_POSITION_X", "FLOAT_BALL_DEFAULT_POSITION_Y", "FLOAT_BALL_MARGIN_LEFT", "FLOAT_BALL_MARGIN_TOP", "FLOAT_BALL_MAX_X", "getFLOAT_BALL_MAX_X", "()I", "FLOAT_BALL_MAX_Y", "FLOAT_BALL_MIN_X", "FLOAT_BALL_MIN_Y", "FLOAT_BALL_OUTER_MARGIN", "getFLOAT_BALL_OUTER_MARGIN", "FLOAT_BALL_SHADOW_BOTTOM", "FLOAT_BALL_SHADOW_HORIZONTAL", "FLOAT_BALL_SHADOW_TOP", "FLOAT_BALL_VIEW_SIZE", "FLOAT_CORNER_SCALE_SIZE", "FLOAT_CORNER_SIZE", "FLOAT_CORNER_ZOOM_OUT_FACTOR", "INVALID_ICON_RES_ID", "NAVIGATION_BAR_HEIGHT", "SHOW_INDICATOR_VIEW_ANIMATION_DURATION", "STATUS_BAR_HEIGHT", "getSTATUS_BAR_HEIGHT", "TAG", "", "getNavigationBarHeight", "context", "Landroid/content/Context;", "updateNavigationBarHeight", "", "BallPosition", "plugin-multitask_release"})
public final class f {
    public static final int Iaf = a.aH(MMApplicationContext.getContext(), R.dimen.aqf);
    public static final int Iag = a.aH(MMApplicationContext.getContext(), R.dimen.aqg);
    private static final int oYI = au.getStatusBarHeight(MMApplicationContext.getContext());
    private static final int oYJ;
    public static final int oYK;
    public static final int oYL = a.aH(MMApplicationContext.getContext(), R.dimen.a6i);
    public static final int oYM = a.aH(MMApplicationContext.getContext(), R.dimen.a6f);
    public static final int oYN = a.aH(MMApplicationContext.getContext(), R.dimen.a6g);
    public static final int oYO;
    public static final int oYP;
    public static final float oYQ;
    private static final int oYR = (a.jn(MMApplicationContext.getContext()) - (oYK + oYN));
    public static final int oYS = (oYJ + oYI);
    public static final int oYT = ((a.jo(MMApplicationContext.getContext()) - oYJ) - ((oYK + oYL) + oYM));
    public static int oYU;
    public static final int oYW = oYI;
    public static final f zZi = new f();

    static {
        AppMethodBeat.i(200289);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        oYJ = context.getResources().getDimensionPixelSize(R.dimen.a6e);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        oYK = context2.getResources().getDimensionPixelSize(R.dimen.a6j);
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        oYO = context3.getResources().getDimensionPixelSize(R.dimen.a7g);
        Context context4 = MMApplicationContext.getContext();
        p.g(context4, "MMApplicationContext.getContext()");
        int dimensionPixelSize = context4.getResources().getDimensionPixelSize(R.dimen.a7f);
        oYP = dimensionPixelSize;
        oYQ = ((float) dimensionPixelSize) / ((float) oYO);
        Context context5 = MMApplicationContext.getContext();
        p.g(context5, "MMApplicationContext.getContext()");
        oYU = aD(context5);
        AppMethodBeat.o(200289);
    }

    private f() {
    }

    private static int aD(Context context) {
        int i2 = 0;
        AppMethodBeat.i(200287);
        try {
            i2 = au.aD(context);
        } catch (Exception e2) {
            Log.e("MicroMsg.FloatBallViewConstants", "getNavigationBarHeight exception:%s", e2);
        }
        AppMethodBeat.o(200287);
        return i2;
    }

    public static final void eG(Context context) {
        AppMethodBeat.i(200288);
        p.h(context, "context");
        oYU = aD(context);
        AppMethodBeat.o(200288);
    }
}
