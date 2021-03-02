package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResourcesUtils {
    public static final String JPG = ".jpg";
    private static final String RES_ANIM = "anim";
    private static final String RES_COLOR = "color";
    private static final String RES_DIMEN = "dimen";
    private static final String RES_DRABLE = "drawable";
    private static final String RES_ID = "id";
    private static final String RES_LAYOUT = "layout";
    private static final String RES_MENU = "menu";
    private static final String RES_STRING = "string";
    private static final String RES_STYLE = "style";

    private static String filter(String str) {
        AppMethodBeat.i(19392);
        if (str.endsWith(".jpg")) {
            String substring = str.substring(0, str.length() - 4);
            AppMethodBeat.o(19392);
            return substring;
        }
        AppMethodBeat.o(19392);
        return str;
    }

    public static int getId(Context context, String str) {
        AppMethodBeat.i(19393);
        int resId = getResId(context, filter(str), "id");
        AppMethodBeat.o(19393);
        return resId;
    }

    public static int getStringId(Context context, String str) {
        AppMethodBeat.i(19394);
        int resId = getResId(context, filter(str), RES_STRING);
        AppMethodBeat.o(19394);
        return resId;
    }

    public static int getDrawableId(Context context, String str) {
        AppMethodBeat.i(19395);
        int resId = getResId(context, filter(str), RES_DRABLE);
        AppMethodBeat.o(19395);
        return resId;
    }

    public static int getLayoutId(Context context, String str) {
        AppMethodBeat.i(19396);
        int resId = getResId(context, str, RES_LAYOUT);
        AppMethodBeat.o(19396);
        return resId;
    }

    public static int getStyleId(Context context, String str) {
        AppMethodBeat.i(19397);
        int resId = getResId(context, filter(str), "style");
        AppMethodBeat.o(19397);
        return resId;
    }

    public static int getColorId(Context context, String str) {
        AppMethodBeat.i(19398);
        int resId = getResId(context, filter(str), RES_COLOR);
        AppMethodBeat.o(19398);
        return resId;
    }

    public static int getDimenId(Context context, String str) {
        AppMethodBeat.i(19399);
        int resId = getResId(context, filter(str), RES_DIMEN);
        AppMethodBeat.o(19399);
        return resId;
    }

    public static int getAnimId(Context context, String str) {
        AppMethodBeat.i(19400);
        int resId = getResId(context, filter(str), RES_ANIM);
        AppMethodBeat.o(19400);
        return resId;
    }

    public static int getMenuId(Context context, String str) {
        AppMethodBeat.i(19401);
        int resId = getResId(context, filter(str), RES_MENU);
        AppMethodBeat.o(19401);
        return resId;
    }

    public static int getResId(Context context, String str, String str2) {
        AppMethodBeat.i(19402);
        int identifier = context.getResources().getIdentifier(filter(str), str2, context.getPackageName());
        AppMethodBeat.o(19402);
        return identifier;
    }
}
