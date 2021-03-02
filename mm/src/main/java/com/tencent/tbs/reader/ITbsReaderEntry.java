package com.tencent.tbs.reader;

import android.content.Context;
import java.util.Map;

public interface ITbsReaderEntry {
    boolean canAutoUpdate();

    Object createTbsReader(Context context, Integer num, Object obj);

    void initRuntimeEnvironment();

    void initSettings(Map map);

    boolean isSupportCurrentPlatform();

    boolean isSupportExt(int i2, String str);

    void setSdkVersionCode(int i2);

    void setSdkVersionName(String str);
}
