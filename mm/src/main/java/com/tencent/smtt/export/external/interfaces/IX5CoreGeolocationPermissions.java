package com.tencent.smtt.export.external.interfaces;

import android.webkit.ValueCallback;
import java.util.Set;

public interface IX5CoreGeolocationPermissions {
    void allow(String str);

    void clear(String str);

    void clearAll();

    void getAllowed(String str, ValueCallback<Boolean> valueCallback);

    void getOrigins(ValueCallback<Set<String>> valueCallback);
}
