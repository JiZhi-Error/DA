package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;

public class KeyBoardUtil {
    public static final int BOTTOM_PANEL_TIP_DP = 43;
    public static int CONTENT_HEIGHT = -1;
    public static final String KEYBORD_HEIGHT_PX_PREFS = "com.tencent.mm.compatible.util.keybord.height";
    private static int LAST_SAVE_KEYBORD_HEIGHT_PX = -1;
    private static int MAX_PANEL_HEIGHT_PX = -1;
    private static final int MAX_PANEL_HEIGH_DP = 380;
    private static int MIN_PANEL_HEIGHT_PX = -1;
    private static final int MIN_PANEL_HEIGH_DP = 230;
    private static final String TAG = "MicroMsg.KeyBordUtil";
    private static boolean isFixedHeight = false;

    public static void setFixedHeight(boolean z) {
        isFixedHeight = z;
    }

    public static final int getKeyBordHeightPx(Context context) {
        AppMethodBeat.i(125227);
        if (isFixedHeight) {
            int minPanelHeightPx = getMinPanelHeightPx(context);
            AppMethodBeat.o(125227);
            return minPanelHeightPx;
        } else if (!checkContextIsValid(context)) {
            int i2 = MMApplicationContext.getDefaultPreference().getInt(KEYBORD_HEIGHT_PX_PREFS, ab.CTRL_INDEX);
            AppMethodBeat.o(125227);
            return i2;
        } else {
            int i3 = MMApplicationContext.getDefaultPreference().getInt(KEYBORD_HEIGHT_PX_PREFS, dp2px(context, 230));
            LAST_SAVE_KEYBORD_HEIGHT_PX = i3;
            AppMethodBeat.o(125227);
            return i3;
        }
    }

    public static final int getKeyBordHeightPx(Context context, boolean z) {
        AppMethodBeat.i(200886);
        if (isFixedHeight) {
            int minPanelHeightPx = getMinPanelHeightPx(context);
            AppMethodBeat.o(200886);
            return minPanelHeightPx;
        } else if (LAST_SAVE_KEYBORD_HEIGHT_PX <= 0 || !z) {
            int keyBordHeightPx = getKeyBordHeightPx(context);
            AppMethodBeat.o(200886);
            return keyBordHeightPx;
        } else {
            int i2 = LAST_SAVE_KEYBORD_HEIGHT_PX;
            AppMethodBeat.o(200886);
            return i2;
        }
    }

    public static int getVisibleHeight(Activity activity) {
        AppMethodBeat.i(200887);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.bottom - rect.top;
        AppMethodBeat.o(200887);
        return i2;
    }

    public static final boolean saveKeyBordHeightPx(Context context, int i2) {
        AppMethodBeat.i(164122);
        if (LAST_SAVE_KEYBORD_HEIGHT_PX == i2) {
            AppMethodBeat.o(164122);
            return true;
        } else if (!checkContextIsValid(context)) {
            AppMethodBeat.o(164122);
            return false;
        } else if (i2 < 0) {
            AppMethodBeat.o(164122);
            return false;
        } else {
            LAST_SAVE_KEYBORD_HEIGHT_PX = i2;
            Log.d(TAG, "save keybord: %d", Integer.valueOf(i2));
            boolean commit = MMApplicationContext.getDefaultPreference().edit().putInt(KEYBORD_HEIGHT_PX_PREFS, i2).commit();
            AppMethodBeat.o(164122);
            return commit;
        }
    }

    public static final int getMaxPanelHeightPx(Context context) {
        AppMethodBeat.i(125229);
        if (isFixedHeight) {
            int minPanelHeightPx = getMinPanelHeightPx(context);
            AppMethodBeat.o(125229);
            return minPanelHeightPx;
        } else if (MAX_PANEL_HEIGHT_PX > 0) {
            int i2 = MAX_PANEL_HEIGHT_PX;
            AppMethodBeat.o(125229);
            return i2;
        } else if (!checkContextIsValid(context)) {
            AppMethodBeat.o(125229);
            return 1140;
        } else {
            int dp2px = dp2px(context, MAX_PANEL_HEIGH_DP);
            MAX_PANEL_HEIGHT_PX = dp2px;
            AppMethodBeat.o(125229);
            return dp2px;
        }
    }

    public static final int getMinPanelHeightPx(Context context) {
        AppMethodBeat.i(200888);
        int minPanelHeightPx = getMinPanelHeightPx(context, 0);
        AppMethodBeat.o(200888);
        return minPanelHeightPx;
    }

    public static final int getMinPanelHeightPx(Context context, int i2) {
        AppMethodBeat.i(125230);
        if (i2 > 0) {
            int i3 = i2 + 230;
            if (!checkContextIsValid(context)) {
                int i4 = i3 * 3;
                AppMethodBeat.o(125230);
                return i4;
            }
            int dp2px = dp2px(context, i3);
            MIN_PANEL_HEIGHT_PX = dp2px;
            AppMethodBeat.o(125230);
            return dp2px;
        } else if (MIN_PANEL_HEIGHT_PX > 0) {
            int i5 = MIN_PANEL_HEIGHT_PX;
            AppMethodBeat.o(125230);
            return i5;
        } else if (!checkContextIsValid(context)) {
            AppMethodBeat.o(125230);
            return ab.CTRL_INDEX;
        } else {
            int dp2px2 = dp2px(context, 230);
            MIN_PANEL_HEIGHT_PX = dp2px2;
            AppMethodBeat.o(125230);
            return dp2px2;
        }
    }

    public static final int getValidPanelHeight(Context context, int i2) {
        AppMethodBeat.i(125231);
        int validPanelHeight = getValidPanelHeight(context, i2, 0);
        AppMethodBeat.o(125231);
        return validPanelHeight;
    }

    public static final int getValidPanelHeight(Context context, int i2, int i3) {
        boolean z;
        AppMethodBeat.i(125232);
        int minPanelHeightPx = getMinPanelHeightPx(context, i3);
        Log.e(TAG, "getValidPanelHeight(): minPanelHeight= %d, isOpenIm=%b", Integer.valueOf(minPanelHeightPx), Integer.valueOf(i3));
        if (!d.oD(24) || !(context instanceof Activity)) {
            z = false;
        } else {
            z = ((Activity) context).isInMultiWindowMode();
        }
        if (!isPortOrientation(context) || z) {
            int i4 = (int) (((double) minPanelHeightPx) / 1.5d);
            int i5 = getScreenWH(context)[0];
            if (i4 > i5 / 2) {
                i4 = i5 / 2;
            }
            AppMethodBeat.o(125232);
            return i4;
        }
        if (i2 <= 0) {
            i2 = getKeyBordHeightPx(context, true);
        }
        int maxPanelHeightPx = getMaxPanelHeightPx(context);
        if (i2 > maxPanelHeightPx) {
            AppMethodBeat.o(125232);
            return maxPanelHeightPx;
        } else if (i2 < minPanelHeightPx) {
            AppMethodBeat.o(125232);
            return minPanelHeightPx;
        } else {
            AppMethodBeat.o(125232);
            return i2;
        }
    }

    public static final int getValidPanelHeight(Context context) {
        AppMethodBeat.i(125233);
        int validPanelHeight = getValidPanelHeight(context, -1);
        AppMethodBeat.o(125233);
        return validPanelHeight;
    }

    public static final boolean isValidPanelHeightDP(int i2) {
        return i2 <= MAX_PANEL_HEIGH_DP && i2 >= 230;
    }

    private static final boolean checkContextIsValid(Context context) {
        AppMethodBeat.i(125234);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        if (context != null) {
            AppMethodBeat.o(125234);
            return true;
        }
        AppMethodBeat.o(125234);
        return false;
    }

    private static final int dp2px(Context context, int i2) {
        AppMethodBeat.i(200889);
        int fromDPToPix = a.fromDPToPix(context, i2);
        AppMethodBeat.o(200889);
        return fromDPToPix;
    }

    public static boolean isPortOrientation(Context context) {
        AppMethodBeat.i(125235);
        if (getScreenOrientation(context) == 1) {
            AppMethodBeat.o(125235);
            return true;
        }
        AppMethodBeat.o(125235);
        return false;
    }

    public static int getScreenOrientation(Context context) {
        int i2 = 1;
        AppMethodBeat.i(125236);
        int[] screenWH = getScreenWH(context);
        if (screenWH[0] >= screenWH[1]) {
            i2 = 2;
        }
        AppMethodBeat.o(125236);
        return i2;
    }

    public static int[] getScreenWH(Context context) {
        Context context2;
        AppMethodBeat.i(125237);
        if (context == null) {
            context2 = MMApplicationContext.getContext();
        } else {
            context2 = context;
        }
        int[] iArr = new int[2];
        if (context2 instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.o(125237);
        return iArr;
    }

    public static int getStatusHeight(Activity activity) {
        AppMethodBeat.i(125238);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        AppMethodBeat.o(125238);
        return i2;
    }
}
