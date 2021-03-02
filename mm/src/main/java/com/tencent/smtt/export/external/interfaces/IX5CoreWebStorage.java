package com.tencent.smtt.export.external.interfaces;

import android.webkit.ValueCallback;
import java.util.Map;

public interface IX5CoreWebStorage {
    void deleteAllData();

    void deleteOrigin(String str);

    void getOrigins(ValueCallback<Map> valueCallback);

    void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback);

    void getUsageForOrigin(String str, ValueCallback<Long> valueCallback);

    void setQuotaForOrigin(String str, long j2);
}
