package com.tencent.mm.plugin.mall.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.Iterator;

public final class a {
    public static final int zjP = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    public static final int zjQ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 140);
    public static final int zjR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 85);
    private static int zjS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 39);
    private static int zjT = 40;
    private static int zjU = 95;
    private static int zjV = 0;
    private static int zjW = 0;
    private static int zjX = 0;
    private static int zjY = 70;
    private static int zjZ = 38;
    private static float zka = 1.0f;

    static {
        AppMethodBeat.i(66032);
        AppMethodBeat.o(66032);
    }

    public static void b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(66030);
        if (z) {
            k(mMActivity);
            AppMethodBeat.o(66030);
            return;
        }
        k(mMActivity);
        Log.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", Integer.valueOf(zjV), Integer.valueOf(zjX));
        AppMethodBeat.o(66030);
    }

    public static int egM() {
        return zjV;
    }

    public static int egN() {
        return zjX;
    }

    public static int egO() {
        return zjS;
    }

    public static int egP() {
        return zjW;
    }

    public static float egQ() {
        return zka;
    }

    private static void k(MMActivity mMActivity) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(66031);
        Point az = ao.az(mMActivity);
        int i5 = az.x;
        int i6 = az.y;
        if (ao.aA(mMActivity)) {
            i2 = i6 - ao.aD(mMActivity);
        } else {
            i2 = i6;
        }
        if (mMActivity.getSupportActionBar() != null) {
            i3 = mMActivity.getSupportActionBar().getHeight();
            if (i3 <= 0) {
                i3 = mMActivity.getResources().getDimensionPixelSize(R.dimen.b9);
            }
        } else {
            i3 = 0;
        }
        int statusBarHeight = (i2 - i3) - ao.getStatusBarHeight(mMActivity);
        if (((double) (i6 / i5)) * 1.0d > 2.0d) {
            i4 = (statusBarHeight - (zjP * 3)) / 20;
        } else {
            i4 = (statusBarHeight - (zjP * 3)) / 17;
        }
        zjX = Math.max(i4 * 4, zjQ);
        zjS = (int) (((double) i4) * 1.5d);
        zjV = Math.max(i4 * 3, zjR);
        Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", Integer.valueOf(i4), Integer.valueOf(zjX));
        AppMethodBeat.o(66031);
    }

    public static void j(MMActivity mMActivity) {
        int i2;
        AppMethodBeat.i(213543);
        Rect rect = new Rect();
        mMActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i3 = rect.right - rect.left;
        int i4 = zjP;
        int i5 = i4 * 11;
        int i6 = (i3 - (i5 * 4)) / 5;
        Log.i("MicroMsg.FunctionGridSizeCalculator", "screenWidth，：%s , defaultGapWidth: %s", Integer.valueOf(i3), Integer.valueOf(i5));
        Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA：%s , tempGridGapSize: %s", Integer.valueOf(i4), Integer.valueOf(i6));
        if (i6 >= i4) {
            zjS = i6;
            zjW = i5;
        } else {
            zjS = i4;
            zjW = (i3 - (zjS * 5)) / 4;
        }
        Iterator<bfv> it = b.fSd().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            bfv next = it.next();
            if (next != null) {
                TextPaint textPaint = new TextPaint(1);
                float ez = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
                zka = ez;
                if (ao.as(ez, com.tencent.mm.cb.a.jc(MMApplicationContext.getContext())) || ao.as(zka, com.tencent.mm.cb.a.jd(MMApplicationContext.getContext()))) {
                    zka = com.tencent.mm.cb.a.jb(MMApplicationContext.getContext());
                }
                textPaint.setTextSize(((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 14)) * zka);
                int height = new StaticLayout(next.LPr.Name, textPaint, zjW, Layout.Alignment.ALIGN_NORMAL, 1.0f, (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight();
                if (!Util.isNullOrNil(next.LPx)) {
                    textPaint.setTextSize(((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10)) * zka);
                    i2 = new StaticLayout(next.LPx, textPaint, zjW, Layout.Alignment.ALIGN_NORMAL, 1.0f, (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight() + height + com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
                } else {
                    i2 = height;
                }
                if (i7 >= i2) {
                    i2 = i7;
                }
                i7 = i2;
            }
        }
        Log.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", Integer.valueOf(i7));
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12);
        int fromDPToPix2 = fromDPToPix + com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32) + fromDPToPix + com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10) + i7;
        zjV = fromDPToPix2;
        if (fromDPToPix2 < zjW) {
            Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", Integer.valueOf(zjW));
            zjV = zjW;
        }
        Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", Integer.valueOf(zjS), Integer.valueOf(zjW), Integer.valueOf(zjV));
        AppMethodBeat.o(213543);
    }
}
