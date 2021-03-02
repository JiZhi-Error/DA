package com.tencent.mm.sdk.crash;

import android.content.Context;

public interface ICrashReporter {

    public interface ICrashReportExtraMessageGetter {
        String getCrashReportExtraMessage();
    }

    public interface ICrashReportListener {
        void onCrashDumped(String str);
    }

    void addCrashReportListener(ICrashReportListener iCrashReportListener);

    void addExtraMessageGetter(ICrashReportExtraMessageGetter iCrashReportExtraMessageGetter);

    void init(Context context, boolean z);

    void removeCrashReportListener(ICrashReportListener iCrashReportListener);

    void reportCrashMessage(String str, String str2);

    void reportJniCrash(int i2, String str, String str2);

    void reportRawMessage(String str, String str2);

    void setCallbackForReset(CallbackForReset callbackForReset);

    void setReportID(String str);

    void setupSubReporter(ISubReporter iSubReporter);
}
