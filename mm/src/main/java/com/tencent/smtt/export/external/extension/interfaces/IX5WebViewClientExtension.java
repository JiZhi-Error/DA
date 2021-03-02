package com.tencent.smtt.export.external.extension.interfaces;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IX5WebViewClientExtension {
    public static final int FRAME_LOADTYPE_BACK = 1;
    public static final int FRAME_LOADTYPE_BACKWMLDECKNOTACCESSIBLE = 10;
    public static final int FRAME_LOADTYPE_FORWARD = 2;
    public static final int FRAME_LOADTYPE_INDEXEDBACKFORWARD = 3;
    public static final int FRAME_LOADTYPE_PREREAD = 11;
    public static final int FRAME_LOADTYPE_REDIRECT = 7;
    public static final int FRAME_LOADTYPE_RELOAD = 4;
    public static final int FRAME_LOADTYPE_RELOADALLOWINGSTALEDATA = 5;
    public static final int FRAME_LOADTYPE_RELOADFROMORIGIN = 9;
    public static final int FRAME_LOADTYPE_REPLACE = 8;
    public static final int FRAME_LOADTYPE_SAME = 6;
    public static final int FRAME_LOADTYPE_STANDARD = 0;
    public static final int HTMLTYPE_JS_SCROLLTO = 1;

    boolean allowJavaScriptOpenWindowAutomatically(String str, String str2);

    void computeScroll(View view);

    void didFailLoad(String str, int i2);

    void didFirstVisuallyNonEmptyPaint();

    void didNavigateWithinPage(IX5WebViewBase iX5WebViewBase, String str);

    boolean dispatchTouchEvent(MotionEvent motionEvent, View view);

    void documentAvailableInMainFrame();

    int getHostByName(String str, List<String> list);

    void handlePluginTag(String str, String str2, boolean z, String str3);

    void hasDiscardCurrentPage(boolean z);

    void hasRestoreCurrentPage(boolean z);

    void hideAddressBar();

    void invalidate();

    boolean notifyAutoAudioPlay(String str, JsResult jsResult);

    boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z);

    void onDoubleTapStart();

    void onFakeLoginRecognised(Bundle bundle);

    void onFlingScrollBegin(int i2, int i3, int i4);

    void onFlingScrollEnd();

    HashMap<String, String> onGetExtraHeadersForPreloading(String str);

    void onGetTtsText(String str, int i2);

    void onHideAdSuccess();

    void onHideListBox();

    void onHistoryItemChanged();

    void onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str);

    boolean onInterceptTouchEvent(MotionEvent motionEvent, View view);

    void onMetricsSavedCountReceived(String str, boolean z, long j2, String str2, int i2);

    Object onMiscCallBack(String str, Bundle bundle);

    Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4);

    void onMissingPluginClicked(String str, String str2, String str3, int i2);

    void onNativeCrashReport(int i2, String str);

    void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view);

    void onPinchToZoomStart();

    void onPreReadFinished();

    void onPrefetchResourceHit(boolean z);

    void onPreloadCallback(int i2, String str);

    void onPromptScaleSaved();

    void onReceivedQNovel(String str, String str2);

    void onReceivedSslErrorCancel();

    void onReceivedViewSource(String str);

    void onReportAdFilterInfo(int i2, int i3, String str, boolean z);

    void onReportHtmlInfo(int i2, String str);

    void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i2);

    void onScrollChanged(int i2, int i3, int i4, int i5);

    void onScrollChanged(int i2, int i3, int i4, int i5, View view);

    void onSetButtonStatus(boolean z, boolean z2);

    void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i2);

    boolean onShowLongClickPopupMenu();

    void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3);

    void onShowTtsBar();

    void onSlidingTitleOffScreen(int i2, int i3);

    void onSoftKeyBoardHide(int i2);

    void onSoftKeyBoardShow();

    void onSpecialSiteDetectedResult(Set<String> set, Set<String> set2);

    void onSupportReadMode();

    boolean onTouchEvent(MotionEvent motionEvent, View view);

    void onTransitionToCommitted();

    void onUploadProgressChange(int i2, int i3, String str);

    void onUploadProgressStart(int i2);

    void onUrlChange(String str, String str2);

    boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view);

    boolean preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str);

    boolean reportFingerSearchAdjustInfo(String str);

    boolean reportFingerSearchRequestInfo(String str);

    boolean requestVibration(String str, JsResult jsResult);

    boolean shouldDiscardCurrentPage();

    boolean shouldRestoreCurrentPage();

    void showTranslateBubble(int i2, String str, String str2, int i3);
}
