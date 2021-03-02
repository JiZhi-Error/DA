package com.tencent.kinda.framework.widget.tools;

import android.util.Pair;
import com.tencent.kinda.framework.widget.base.MMKView;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public class ColorUtil {
    public static long MergeColors(long j2, long j3) {
        AppMethodBeat.i(19320);
        if (j2 < 0) {
            j2 = absColor(j2);
        }
        if (j3 < 0) {
            j3 = absColor(j3);
        }
        long alpha = getAlpha(j2);
        if (alpha == 0) {
            alpha = 255;
        }
        long red = getRed(j2);
        long green = getGreen(j2);
        long blue = getBlue(j2);
        long alpha2 = getAlpha(j3);
        double d2 = (double) (((float) alpha2) / 255.0f);
        double d3 = ((double) alpha) * (1.0d - d2);
        double d4 = ((double) red) * (1.0d - d2);
        double d5 = ((double) green) * (1.0d - d2);
        long red2 = (((long) (d3 + ((double) alpha2))) << 24) | (((long) (d4 + (((double) getRed(j3)) * d2))) << 16) | (((long) (d5 + (((double) getGreen(j3)) * d2))) << 8);
        long blue2 = red2 | ((long) ((((double) blue) * (1.0d - d2)) + (((double) getBlue(j3)) * d2)));
        AppMethodBeat.o(19320);
        return blue2;
    }

    private static long getAlpha(long j2) {
        return j2 >> 24;
    }

    private static long getRed(long j2) {
        return (j2 >> 16) - ((j2 >> 24) << 8);
    }

    private static long getGreen(long j2) {
        return (j2 >> 8) - ((j2 >> 16) << 8);
    }

    private static long getBlue(long j2) {
        return j2 - ((j2 >> 8) << 8);
    }

    public static long absColor(long j2) {
        AppMethodBeat.i(19321);
        if (j2 >= 0) {
            AppMethodBeat.o(19321);
        } else {
            long abs = Math.abs(1 + j2);
            ArrayList arrayList = new ArrayList();
            while (abs > 16) {
                arrayList.add(Integer.valueOf((int) (abs - ((abs >> 4) << 4))));
                abs >>= 4;
            }
            arrayList.add(Integer.valueOf((int) abs));
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(15 - ((Integer) it.next()).intValue()));
            }
            j2 = 0;
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                j2 = (j2 * 16) + ((long) ((Integer) arrayList2.get(size)).intValue());
            }
            AppMethodBeat.o(19321);
        }
        return j2;
    }

    public static long getColorByModeNoCompat(DynamicColor dynamicColor) {
        AppMethodBeat.i(19322);
        if (dynamicColor == null) {
            if (BuildInfo.DEBUG) {
                Log.d(MMKView.TAG, "getColorByModeNoCompat() dynamicColor == null");
            }
            AppMethodBeat.o(19322);
            return 0;
        } else if (ao.isDarkMode()) {
            long darkmodeColor = dynamicColor.getDarkmodeColor();
            AppMethodBeat.o(19322);
            return darkmodeColor;
        } else {
            long normalColor = dynamicColor.getNormalColor();
            AppMethodBeat.o(19322);
            return normalColor;
        }
    }

    public static long getColorByMode(String str) {
        AppMethodBeat.i(19323);
        DynamicColor dynamicColor = new DynamicColor();
        dynamicColor.mNormalColor = Long.parseLong(str, 16);
        dynamicColor.mDarkmodeColor = Long.parseLong(str, 16);
        long colorByMode = getColorByMode(dynamicColor);
        AppMethodBeat.o(19323);
        return colorByMode;
    }

    public static long getColorByMode(DynamicColor dynamicColor, boolean z) {
        AppMethodBeat.i(162116);
        long colorByMode = getColorByMode(dynamicColor, MMViewType.NONE);
        if (!z || colorByMode != -1 || !ao.isDarkMode()) {
            AppMethodBeat.o(162116);
            return colorByMode;
        }
        long hT = (long) ao.hT((int) dynamicColor.mNormalColor);
        AppMethodBeat.o(162116);
        return hT;
    }

    public static long getColorByMode(DynamicColor dynamicColor) {
        AppMethodBeat.i(19324);
        long colorByMode = getColorByMode(dynamicColor, true);
        AppMethodBeat.o(19324);
        return colorByMode;
    }

    public static long getColorByMode(DynamicColor dynamicColor, MMViewType mMViewType) {
        AppMethodBeat.i(19325);
        if (dynamicColor == null) {
            if (BuildInfo.DEBUG) {
                Log.d(MMKView.TAG, "getColorByMode() dynamicColor == null");
            }
            AppMethodBeat.o(19325);
            return 0;
        }
        if (BuildInfo.DEBUG) {
            Log.d(MMKView.TAG, "getColorByMode(mNormalColor:%s mDarkmodeColor:%s) %s", Long.toHexString(absColor(dynamicColor.mNormalColor)), Long.toHexString(absColor(dynamicColor.mDarkmodeColor)), Util.getStack());
        }
        if (ao.isDarkMode()) {
            long darkmodeColor = compatKindaDarkMode(dynamicColor, mMViewType).getDarkmodeColor();
            AppMethodBeat.o(19325);
            return darkmodeColor;
        }
        long j2 = dynamicColor.mNormalColor;
        AppMethodBeat.o(19325);
        return j2;
    }

    public static DynamicColor compatKindaDarkMode(DynamicColor dynamicColor, MMViewType mMViewType) {
        Pair<Boolean, Long> darkModeColorMMKLabelViewText;
        AppMethodBeat.i(19326);
        if (dynamicColor == null) {
            AppMethodBeat.o(19326);
        } else {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_kinda_dark_mode_sw, 1);
            if (a2 == 1) {
                switch (mMViewType) {
                    case MMKButtonText:
                        darkModeColorMMKLabelViewText = ColorCompatUtil.getDarkModeColorMMKButtonText(dynamicColor.getNormalColor());
                        break;
                    case MMKRichLabelView:
                        darkModeColorMMKLabelViewText = ColorCompatUtil.getDarkModeColorMMKRichLabelView(dynamicColor.getNormalColor());
                        break;
                    case MMKLabelViewText:
                        darkModeColorMMKLabelViewText = ColorCompatUtil.getDarkModeColorMMKLabelViewText(dynamicColor.getNormalColor());
                        break;
                    default:
                        darkModeColorMMKLabelViewText = new Pair<>(Boolean.FALSE, 0L);
                        break;
                }
                if (((Boolean) darkModeColorMMKLabelViewText.first).booleanValue()) {
                    dynamicColor.mDarkmodeColor = ((Long) darkModeColorMMKLabelViewText.second).longValue();
                } else if (dynamicColor.getDarkmodeColor() == -1 || dynamicColor.getNormalColor() == dynamicColor.getDarkmodeColor()) {
                    dynamicColor.mDarkmodeColor = ColorCompatUtil.getDarkModeColor(dynamicColor.getNormalColor(), dynamicColor.getDarkmodeColor());
                } else if (dynamicColor.getNormalColor() == -1 && dynamicColor.getDarkmodeColor() == 0) {
                    dynamicColor.mDarkmodeColor = Long.parseLong("ffFFFFFF", 16);
                }
            }
            if (BuildInfo.DEBUG) {
                Log.i(MMKView.TAG, "compatKindaDarkMode() swt:%s. (mNormalColor:%s mDarkmodeColor:%s)", Integer.valueOf(a2), Long.toHexString(absColor(dynamicColor.mNormalColor)), Long.toHexString(absColor(dynamicColor.mDarkmodeColor)));
            }
            AppMethodBeat.o(19326);
        }
        return dynamicColor;
    }

    private static boolean compatKindaDarkModeDefaultColorSw() {
        AppMethodBeat.i(19327);
        if (((b) g.af(b.class)).a(b.a.clicfg_android_kinda_dark_mode_default_color_sw, 1) == 1) {
            AppMethodBeat.o(19327);
            return true;
        }
        AppMethodBeat.o(19327);
        return false;
    }

    public static boolean ifCompatKindaDarkModeDefaultColor() {
        AppMethodBeat.i(19328);
        if (!ao.isDarkMode() || !compatKindaDarkModeDefaultColorSw()) {
            AppMethodBeat.o(19328);
            return false;
        }
        AppMethodBeat.o(19328);
        return true;
    }

    public enum MMViewType {
        NONE,
        MMKButtonText,
        MMKEditText,
        MMKImageView,
        MMKLabelViewText,
        MMKRichLabelView;

        public static MMViewType valueOf(String str) {
            AppMethodBeat.i(19318);
            MMViewType mMViewType = (MMViewType) Enum.valueOf(MMViewType.class, str);
            AppMethodBeat.o(19318);
            return mMViewType;
        }

        static {
            AppMethodBeat.i(19319);
            AppMethodBeat.o(19319);
        }
    }
}
