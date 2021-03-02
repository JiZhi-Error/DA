package com.tencent.tbs.one.optional;

import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public abstract class TBSOneRuntimeExtension {
    public void cancel(int i2) {
    }

    public int shouldInterceptComponentResponse(String str, String str2, int i2, Map<String, Object> map, InputStream inputStream, File file, TBSOneCallback<Void> tBSOneCallback) {
        return 0;
    }

    public int shouldInterceptDEPSResponse(String str, Map<String, Object> map, InputStream inputStream, File file, TBSOneCallback<Void> tBSOneCallback) {
        return 0;
    }

    public int shouldOverrideInstallationJob(String str, String str2, int i2, Map<String, Object> map, File file, TBSOneCallback<Void> tBSOneCallback) {
        return 0;
    }
}
