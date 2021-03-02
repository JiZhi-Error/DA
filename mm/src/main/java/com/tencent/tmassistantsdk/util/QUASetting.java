package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QUASetting {
    protected static final String APP_VERSION = "100";
    protected static final String BUILD_NO = "100";
    public static final int ROOT_STATUS_UNKNOWN = 0;
    protected static final String UN_DEFINED = "NA";
    protected static String mChannelId = UN_DEFINED;
    protected Context mContext = null;

    public QUASetting(Context context) {
        this.mContext = context;
    }

    public String buildQUA() {
        AppMethodBeat.i(102517);
        QUABuilder qUABuilder = new QUABuilder();
        qUABuilder.mBuildNo = getBuildNo();
        qUABuilder.mChannel = "";
        qUABuilder.mChannelId = mChannelId;
        qUABuilder.mAdrRelease = getAndroidVersion();
        qUABuilder.mDeviceHeight = getDeviceHeight();
        qUABuilder.mDeviceWidth = getDeviceWidth();
        qUABuilder.mRootStatus = getRootStatus();
        qUABuilder.mUA = getUA();
        qUABuilder.mVersionName = "100";
        String str = qUABuilder.get();
        AppMethodBeat.o(102517);
        return str;
    }

    private int getDeviceWidth() {
        AppMethodBeat.i(102518);
        int i2 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(102518);
        return i2;
    }

    private int getDeviceHeight() {
        AppMethodBeat.i(102519);
        int i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(102519);
        return i2;
    }

    public static String getBuildNo() {
        AppMethodBeat.i(102520);
        if ("100".contains("BuildNo")) {
            AppMethodBeat.o(102520);
            return "0000";
        }
        AppMethodBeat.o(102520);
        return "100";
    }

    private int getRootStatus() {
        return 0;
    }

    private String getUA() {
        AppMethodBeat.i(102521);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(filter(Build.BRAND));
        stringBuffer.append("_");
        stringBuffer.append(filter(Build.MODEL));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(102521);
        return stringBuffer2;
    }

    private String getAndroidVersion() {
        AppMethodBeat.i(102522);
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append(UN_DEFINED);
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append("_");
        stringBuffer.append(Build.VERSION.SDK_INT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(102522);
        return stringBuffer2;
    }

    private StringBuffer filter(String str) {
        AppMethodBeat.i(102523);
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append(UN_DEFINED);
            AppMethodBeat.o(102523);
            return stringBuffer;
        }
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (!(charArray[i2] <= ' ' || charArray[i2] == '/' || charArray[i2] == '_' || charArray[i2] == '&' || charArray[i2] == '|' || charArray[i2] == '-')) {
                stringBuffer.append(charArray[i2]);
            }
        }
        AppMethodBeat.o(102523);
        return stringBuffer;
    }
}
