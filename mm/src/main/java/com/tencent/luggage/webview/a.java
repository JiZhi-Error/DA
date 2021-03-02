package com.tencent.luggage.webview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.s;
import com.tencent.luggage.d.p;
import java.util.Map;

public interface a extends s {

    /* renamed from: com.tencent.luggage.webview.a$a  reason: collision with other inner class name */
    public interface AbstractC0187a {
        WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle);

        boolean cU(String str);

        void cV(String str);

        void cW(String str);

        WebResourceResponse cX(String str);

        String cY(String str);
    }

    void a(AbstractC0187a aVar);

    boolean canGoBack();

    void destroy();

    @Override // com.tencent.luggage.bridge.s
    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    View getView();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void setContext(Context context);

    void setWebCore(p pVar);

    void stopLoading();
}
