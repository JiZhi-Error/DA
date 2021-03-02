package com.tencent.xweb.x5.export.external.extension.proxy;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;

public interface IProxySuperWrapper {
    boolean super_allowJavaScriptOpenWindowAutomatically(String str, String str2);

    void super_computeScroll(View view);

    void super_didFirstVisuallyNonEmptyPaint();

    boolean super_dispatchTouchEvent(MotionEvent motionEvent, View view);

    void super_documentAvailableInMainFrame();

    void super_handlePluginTag(String str, String str2, boolean z, String str3);

    void super_hideAddressBar();

    boolean super_notifyAutoAudioPlay(String str, JsResult jsResult);

    boolean super_notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z);

    void super_onDoubleTapStart();

    void super_onFlingScrollBegin(int i2, int i3, int i4);

    void super_onFlingScrollEnd();

    void super_onHideListBox();

    void super_onHistoryItemChanged();

    boolean super_onInterceptTouchEvent(MotionEvent motionEvent, View view);

    void super_onMetricsSavedCountReceived(String str, boolean z, long j2, String str2, int i2);

    Object super_onMiscCallBack(String str, Bundle bundle);

    Object super_onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4);

    void super_onMissingPluginClicked(String str, String str2, String str3, int i2);

    void super_onNativeCrashReport(int i2, String str);

    void super_onOverScrolled(int i2, int i3, boolean z, boolean z2, View view);

    void super_onPinchToZoomStart();

    void super_onPreReadFinished();

    void super_onPrefetchResourceHit(boolean z);

    void super_onPromptScaleSaved();

    void super_onReceivedSslErrorCancel();

    void super_onReceivedViewSource(String str);

    void super_onReportAdFilterInfo(int i2, int i3, String str, boolean z);

    void super_onReportHtmlInfo(int i2, String str);

    void super_onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i2);

    void super_onScrollChanged(int i2, int i3, int i4, int i5);

    void super_onScrollChanged(int i2, int i3, int i4, int i5, View view);

    void super_onSetButtonStatus(boolean z, boolean z2);

    void super_onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i2);

    boolean super_onShowLongClickPopupMenu();

    void super_onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3);

    void super_onSlidingTitleOffScreen(int i2, int i3);

    void super_onSoftKeyBoardHide(int i2);

    void super_onSoftKeyBoardShow();

    boolean super_onTouchEvent(MotionEvent motionEvent, View view);

    void super_onTransitionToCommitted();

    void super_onUploadProgressChange(int i2, int i3, String str);

    void super_onUploadProgressStart(int i2);

    void super_onUrlChange(String str, String str2);

    boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view);

    void super_showTranslateBubble(int i2, String str, String str2, int i3);
}
