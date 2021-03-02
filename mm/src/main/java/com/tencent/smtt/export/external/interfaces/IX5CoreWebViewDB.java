package com.tencent.smtt.export.external.interfaces;

import android.content.Context;

public interface IX5CoreWebViewDB {
    void clearFormData(Context context);

    void clearHttpAuthUsernamePassword(Context context);

    void clearUsernamePassword(Context context);

    boolean hasFormData(Context context);

    boolean hasHttpAuthUsernamePassword(Context context);

    boolean hasUsernamePassword(Context context);
}
