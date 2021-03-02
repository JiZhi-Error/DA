package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.xweb.u;

public interface b extends u {
    void Em(boolean z);

    void bk(boolean z, boolean z2);

    void eJ(Object obj);

    boolean eK(Object obj);

    void onHideCustomView();

    void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback);
}
