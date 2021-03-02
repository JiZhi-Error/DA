package android.support.design.e;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.graphics.b;
import android.util.StateSet;

public final class a {
    private static final int[] FOCUSED_STATE_SET = {16842908};
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final int[] SELECTED_STATE_SET = {16842913};
    public static final boolean lH = (Build.VERSION.SDK_INT >= 21);
    private static final int[] lI = {16843623, 16842908};
    private static final int[] lJ = {16843623};
    private static final int[] lK = {16842913, 16842919};
    private static final int[] lL = {16842913, 16843623, 16842908};
    private static final int[] lM = {16842913, 16842908};
    private static final int[] lN = {16842913, 16843623};

    public static ColorStateList b(ColorStateList colorStateList) {
        if (lH) {
            return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{a(colorStateList, lK), a(colorStateList, PRESSED_STATE_SET)});
        }
        return new ColorStateList(new int[][]{lK, lL, lM, lN, SELECTED_STATE_SET, PRESSED_STATE_SET, lI, FOCUSED_STATE_SET, lJ, StateSet.NOTHING}, new int[]{a(colorStateList, lK), a(colorStateList, lL), a(colorStateList, lM), a(colorStateList, lN), 0, a(colorStateList, PRESSED_STATE_SET), a(colorStateList, lI), a(colorStateList, FOCUSED_STATE_SET), a(colorStateList, lJ), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int i2;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i2 = 0;
        }
        return lH ? E(i2) : i2;
    }

    @TargetApi(21)
    private static int E(int i2) {
        return b.x(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
