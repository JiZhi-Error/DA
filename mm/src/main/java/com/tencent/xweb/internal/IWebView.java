package com.tencent.xweb.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ae;
import com.tencent.xweb.i;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.util.Map;

public interface IWebView {

    public interface a {
    }

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoForward();

    Bitmap captureBitmap();

    void captureBitmap(a aVar);

    void clearHistory();

    void clearMatches();

    void clearSslPreferences();

    void clearView();

    WebBackForwardList copyBackForwardList();

    void destroy();

    void disableVideoJsCallback(boolean z);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void findAllAsync(String str);

    void findNext(boolean z);

    String getAbstractInfo();

    int getContentHeight();

    x getCurWebChromeClient();

    ac getCurWebviewClient();

    e getDefalutOpProvider();

    WebView.a getFullscreenVideoKind();

    WebView.b getHitTestResult();

    String[] getHttpAuthUsernamePassword(String str, String str2);

    boolean getImageBitmapToFile(String str, String str2, String str3, i iVar);

    float getScale();

    int getScrollHeight();

    z getSettings();

    String getTitle();

    ViewGroup getTopView();

    String getUrl();

    String getVersionInfo();

    View getView();

    int getVisibleTitleHeight();

    int getWebScrollX();

    int getWebScrollY();

    View getWebViewUI();

    Object getX5WebViewExtension();

    void goBack();

    void goForward();

    boolean hasEnteredFullscreen();

    Bundle invokeMiscMethod(String str, Bundle bundle);

    boolean isOverScrollStart();

    boolean isSupportExtendPluginForAppbrand();

    void leaveFullscreen();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    @TargetApi(8)
    void loadUrl(String str, Map<String, String> map);

    void onHide();

    void onPause();

    void onResume();

    void onShow();

    boolean overlayHorizontalScrollbar();

    void reload();

    void removeJavascriptInterface(String str);

    boolean savePage(String str, String str2, int i2);

    void setBottomHeight(int i2);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(WebView.FindListener findListener);

    void setHorizontalScrollBarEnabled(boolean z);

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setJSExceptionListener(ae aeVar);

    void setVerticalScrollBarEnabled(boolean z);

    u setVideoJsCallback(v vVar);

    void setWebChromeClient(x xVar);

    void setWebViewCallbackClient(ab abVar);

    void setWebViewClient(ac acVar);

    void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a aVar);

    void smoothScroll(int i2, int i3, long j2);

    void stopLoading();

    void super_computeScroll();

    boolean super_dispatchTouchEvent(MotionEvent motionEvent);

    boolean super_onInterceptTouchEvent(MotionEvent motionEvent);

    void super_onOverScrolled(int i2, int i3, boolean z, boolean z2);

    void super_onScrollChanged(int i2, int i3, int i4, int i5);

    boolean super_onTouchEvent(MotionEvent motionEvent);

    boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z);

    boolean supportFeature(int i2);

    boolean zoomIn();

    boolean zoomOut();
}
