package com.pay.tool;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class APMidasCommMethod {
    private static Stack<Activity> activityStack = null;

    public static String MaptoString(HashMap<String, String> hashMap) {
        AppMethodBeat.i(193319);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(entry.getValue());
            stringBuffer.append("&");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193319);
        return stringBuffer2;
    }

    public static String MaptoString(HashMap<String, String> hashMap, String str) {
        AppMethodBeat.i(193320);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            stringBuffer.append(entry.getValue());
            stringBuffer.append(str);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193320);
        return stringBuffer2;
    }

    public static String dealString(String str) {
        AppMethodBeat.i(193321);
        String rawString = rawString(str);
        if (rawString.length() <= 3) {
            AppMethodBeat.o(193321);
            return str;
        } else if (rawString.length() > 3 && rawString.length() <= 6) {
            String str2 = str.substring(0, 3) + " " + str.substring(4, str.length());
            AppMethodBeat.o(193321);
            return str2;
        } else if (rawString.length() > 6 && rawString.length() <= 9) {
            String str3 = str.substring(3, 6) + " " + str.substring(7, str.length());
            AppMethodBeat.o(193321);
            return str3;
        } else if (rawString.length() <= 9 || rawString.length() > 12) {
            AppMethodBeat.o(193321);
            return str;
        } else {
            String str4 = str.substring(6, 9) + " " + str.substring(10, str.length());
            AppMethodBeat.o(193321);
            return str4;
        }
    }

    public static String rawString(String str) {
        AppMethodBeat.i(193322);
        String replace = str.replace(" ", "");
        AppMethodBeat.o(193322);
        return replace;
    }

    public static void transformStrToMap(String str, TreeMap<String, String> treeMap) {
        AppMethodBeat.i(193323);
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() == 0) {
                treeMap.clear();
                AppMethodBeat.o(193323);
                return;
            }
            String[] split = substring.split(",");
            int length = split.length;
            if (length > 0 && length % 2 == 0) {
                treeMap.clear();
                for (int i2 = 0; i2 < length / 2; i2++) {
                    treeMap.put(split[i2 * 2], split[(i2 * 2) + 1]);
                }
            }
        }
        AppMethodBeat.o(193323);
    }

    public static void transformStrToMpInfoList(String str, List<String> list, List<String> list2) {
        AppMethodBeat.i(193324);
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() == 0) {
                list.clear();
                list2.clear();
                AppMethodBeat.o(193324);
                return;
            }
            String[] split = substring.split(",");
            int length = split.length;
            if (length > 0 && length % 2 == 0) {
                list.clear();
                list2.clear();
                for (int i2 = 0; i2 < length / 2; i2++) {
                    String str2 = split[i2 * 2];
                    String str3 = split[(i2 * 2) + 1];
                    list.add(str2);
                    list2.add(str3);
                }
            }
        }
        AppMethodBeat.o(193324);
    }

    public static void transformStrToList(String str, List<String> list) {
        AppMethodBeat.i(193325);
        int indexOf = str.indexOf("[");
        int indexOf2 = str.indexOf("]");
        list.clear();
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
            String substring = str.substring(indexOf + 1, indexOf2);
            if (substring.length() != 0) {
                String[] split = substring.split(",");
                for (String str2 : split) {
                    list.add(str2);
                }
            }
        }
        AppMethodBeat.o(193325);
    }

    public static String fenToYuan(String str, int i2) {
        String str2;
        AppMethodBeat.i(193326);
        DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance();
        if (i2 == 0) {
            decimalFormat.applyPattern(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else if (i2 == 1) {
            decimalFormat.applyPattern("0.0");
        } else if (i2 == 2) {
            decimalFormat.applyPattern("0.00");
        }
        try {
            str2 = decimalFormat.format((double) (Float.valueOf(str).floatValue() / 100.0f));
        } catch (Exception e2) {
            str2 = "";
        }
        AppMethodBeat.o(193326);
        return str2;
    }

    public static int getLayoutId(Context context, String str) {
        AppMethodBeat.i(193327);
        int identifier = context.getResources().getIdentifier(str, "layout", context.getPackageName());
        AppMethodBeat.o(193327);
        return identifier;
    }

    public static String getStringId(Context context, String str) {
        AppMethodBeat.i(193328);
        String string = context.getResources().getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
        AppMethodBeat.o(193328);
        return string;
    }

    public static int getDrawableId(Context context, String str) {
        AppMethodBeat.i(193329);
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        AppMethodBeat.o(193329);
        return identifier;
    }

    public static Drawable getDrawable(Context context, String str) {
        AppMethodBeat.i(193330);
        Drawable drawable = context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
        AppMethodBeat.o(193330);
        return drawable;
    }

    public static int getStyleId(Context context, String str) {
        AppMethodBeat.i(193331);
        int identifier = context.getResources().getIdentifier(str, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName());
        AppMethodBeat.o(193331);
        return identifier;
    }

    public static int getId(Context context, String str) {
        AppMethodBeat.i(193332);
        int identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
        AppMethodBeat.o(193332);
        return identifier;
    }

    public static int getColorId(Context context, String str) {
        AppMethodBeat.i(193333);
        int color = context.getResources().getColor(context.getResources().getIdentifier(str, "color", context.getPackageName()));
        AppMethodBeat.o(193333);
        return color;
    }

    public static int getAnimId(Context context, String str) {
        AppMethodBeat.i(193334);
        int identifier = context.getApplicationContext().getResources().getIdentifier(str, "anim", context.getApplicationContext().getPackageName());
        AppMethodBeat.o(193334);
        return identifier;
    }

    public static int dip2px(Context context, float f2) {
        AppMethodBeat.i(193335);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(193335);
        return i2;
    }

    public static int px2dip(Context context, float f2) {
        AppMethodBeat.i(193336);
        int i2 = (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
        AppMethodBeat.o(193336);
        return i2;
    }

    public static void pushActivity(Activity activity) {
        AppMethodBeat.i(193337);
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.push(activity);
        AppMethodBeat.o(193337);
    }

    public static void popActivity() {
        AppMethodBeat.i(193338);
        APLog.i("jar popActivity", "1");
        try {
            if (activityStack == null) {
                AppMethodBeat.o(193338);
                return;
            }
            for (int i2 = 0; i2 < activityStack.size(); i2++) {
                if (activityStack.get(i2) != null) {
                    activityStack.get(i2).finish();
                }
            }
            releaseActivityStack();
            AppMethodBeat.o(193338);
        } catch (Exception e2) {
            APLog.i("jar popActivity ex", e2.toString());
        }
    }

    public static void releaseActivityStack() {
        AppMethodBeat.i(193339);
        if (activityStack != null) {
            activityStack.clear();
        }
        activityStack = null;
        AppMethodBeat.o(193339);
    }

    public static String getApplicationPackageName() {
        PackageManager packageManager;
        AppMethodBeat.i(193340);
        String str = "";
        try {
            Context context = APMidasPayAPI.fromContext;
            if (!(context == null || (packageManager = context.getPackageManager()) == null)) {
                str = packageManager.getPackageInfo(context.getPackageName(), 0).packageName;
            }
            AppMethodBeat.o(193340);
        } catch (Exception e2) {
            APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + e2.toString());
            AppMethodBeat.o(193340);
        }
        return str;
    }

    public static String getApplicationVersion() {
        AppMethodBeat.i(193341);
        String str = "";
        try {
            str = APMidasPayAPI.fromContext.getPackageManager().getPackageInfo(APMidasPayAPI.fromContext.getPackageName(), 0).versionName;
            AppMethodBeat.o(193341);
        } catch (Exception e2) {
            APLog.i("APMidasCommMethod", "getApplicationVersion error:" + e2.toString());
            AppMethodBeat.o(193341);
        }
        return str;
    }
}
