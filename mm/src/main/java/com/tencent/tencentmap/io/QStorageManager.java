package com.tencent.tencentmap.io;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class QStorageManager {
    public static final String DATA = "data/";
    private static QStorageManager mInstance = null;

    public static QStorageManager getInstance(Context context) {
        AppMethodBeat.i(180970);
        if (mInstance == null) {
            mInstance = new QStorageManager(context);
        }
        QStorageManager qStorageManager = mInstance;
        AppMethodBeat.o(180970);
        return qStorageManager;
    }

    private QStorageManager(Context context) {
    }

    public void clearOldConfig(Context context, String str) {
    }

    public File getDataDir() {
        return null;
    }

    public File getCacheDir() {
        return null;
    }

    public String getMapPath() {
        return null;
    }

    public String getSatPath() {
        return null;
    }

    public String getRouteBlockPath() {
        return null;
    }

    public String getConfigPath(String str) {
        return null;
    }

    public String getAssetsLoadPath(String str) {
        return null;
    }

    public String getAssetsDynamicPath() {
        return null;
    }

    public String getConfigTempPath(String str) {
        return null;
    }
}
