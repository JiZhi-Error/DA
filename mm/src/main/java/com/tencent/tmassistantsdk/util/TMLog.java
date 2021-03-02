package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;

public class TMLog {
    protected static boolean mDebugFlagForSDK = true;
    protected static String mDebugFlagForSDKTag = "";
    protected static boolean mHardDebugFlag = true;
    protected static HashMap<String, ArrayList<Long>> mUseTimeLongList = new HashMap<>();
    protected static HashMap<String, ArrayList<String>> mUseTimeStringList = new HashMap<>();

    static {
        AppMethodBeat.i(102542);
        AppMethodBeat.o(102542);
    }

    public static void setDebugLog(boolean z, String str) {
        mDebugFlagForSDK = z;
        mDebugFlagForSDKTag = str;
    }

    public static void debugV(String str) {
        AppMethodBeat.i(102531);
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            Log.v(mDebugFlagForSDKTag, str);
        }
        AppMethodBeat.o(102531);
    }

    public static void debugE(String str) {
        AppMethodBeat.i(102532);
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            Log.e(mDebugFlagForSDKTag, str);
        }
        AppMethodBeat.o(102532);
    }

    public static boolean isForDebug() {
        return mHardDebugFlag;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(102533);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            Log.v(str, str2);
        }
        AppMethodBeat.o(102533);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(102534);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            Log.i(str, str2);
        }
        AppMethodBeat.o(102534);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(102535);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            Log.d(str, str2);
        }
        AppMethodBeat.o(102535);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(102536);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            Log.w(str, str2);
        }
        AppMethodBeat.o(102536);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(102537);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            Log.e(str, str2);
        }
        AppMethodBeat.o(102537);
    }

    public static void time(String str) {
        AppMethodBeat.i(102538);
        time("UseTime", str, false);
        AppMethodBeat.o(102538);
    }

    public static void time(String str, boolean z) {
        AppMethodBeat.i(102539);
        time("UseTime", str, z);
        AppMethodBeat.o(102539);
    }

    public static void time(String str, String str2) {
        AppMethodBeat.i(102540);
        time(str, str2, false);
        AppMethodBeat.o(102540);
    }

    public static void time(String str, String str2, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Long> arrayList2;
        AppMethodBeat.i(102541);
        if (!isForDebug()) {
            AppMethodBeat.o(102541);
            return;
        }
        ArrayList<String> arrayList3 = mUseTimeStringList.get(str);
        if (arrayList3 == null) {
            ArrayList<String> arrayList4 = new ArrayList<>();
            mUseTimeStringList.put(str, arrayList4);
            arrayList = arrayList4;
        } else {
            arrayList = arrayList3;
        }
        arrayList.add(str2);
        ArrayList<Long> arrayList5 = mUseTimeLongList.get(str);
        if (arrayList5 == null) {
            ArrayList<Long> arrayList6 = new ArrayList<>();
            mUseTimeLongList.put(str, arrayList6);
            arrayList2 = arrayList6;
        } else {
            arrayList2 = arrayList5;
        }
        arrayList2.add(Long.valueOf(System.currentTimeMillis()));
        if (z) {
            StringBuffer stringBuffer = new StringBuffer();
            long longValue = arrayList2.get(0).longValue();
            stringBuffer.append("total time:");
            stringBuffer.append(arrayList2.get(arrayList2.size() - 1).longValue() - longValue);
            stringBuffer.append(" ");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                stringBuffer.append(arrayList2.get(i2).longValue() - longValue);
                longValue = arrayList2.get(i2).longValue();
                stringBuffer.append(" ");
                stringBuffer.append(arrayList.get(i2));
                stringBuffer.append(" ");
            }
            Log.v(str, stringBuffer.toString());
            arrayList.clear();
            arrayList2.clear();
        }
        AppMethodBeat.o(102541);
    }
}
