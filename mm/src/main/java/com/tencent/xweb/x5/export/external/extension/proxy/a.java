package com.tencent.xweb.x5.export.external.extension.proxy;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import org.xwalk.core.Log;

public class a {
    private static final String TAG = "ProxyWebViewClientExtension";
    IProxySuperWrapper mSuperProvider;

    public void setSuperProvider(IProxySuperWrapper iProxySuperWrapper) {
        this.mSuperProvider = iProxySuperWrapper;
    }

    public void onMissingPluginClicked(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(157088);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onMissingPluginClicked(str, str2, str3, i2);
        }
        AppMethodBeat.o(157088);
    }

    public void onHideListBox() {
        AppMethodBeat.i(157089);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onHideListBox();
        }
        AppMethodBeat.o(157089);
    }

    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i2) {
        AppMethodBeat.i(157090);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onShowListBox(strArr, iArr, iArr2, i2);
        }
        AppMethodBeat.o(157090);
    }

    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(157091);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        }
        AppMethodBeat.o(157091);
    }

    public void onFlingScrollBegin(int i2, int i3, int i4) {
        AppMethodBeat.i(157092);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onFlingScrollBegin(i2, i3, i4);
        }
        AppMethodBeat.o(157092);
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(157093);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onScrollChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(157093);
    }

    public void onTransitionToCommitted() {
        AppMethodBeat.i(157094);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onTransitionToCommitted();
        }
        AppMethodBeat.o(157094);
    }

    public void onUploadProgressStart(int i2) {
        AppMethodBeat.i(157095);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUploadProgressStart(i2);
        }
        AppMethodBeat.o(157095);
    }

    public void onUploadProgressChange(int i2, int i3, String str) {
        AppMethodBeat.i(157096);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUploadProgressChange(i2, i3, str);
        }
        AppMethodBeat.o(157096);
    }

    public void onSoftKeyBoardShow() {
        AppMethodBeat.i(157097);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSoftKeyBoardShow();
        }
        AppMethodBeat.o(157097);
    }

    public void onSoftKeyBoardHide(int i2) {
        AppMethodBeat.i(157098);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSoftKeyBoardHide(i2);
        }
        AppMethodBeat.o(157098);
    }

    public void onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.i(157099);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSetButtonStatus(z, z2);
        }
        AppMethodBeat.o(157099);
    }

    public void onHistoryItemChanged() {
        AppMethodBeat.i(157100);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onHistoryItemChanged();
        }
        AppMethodBeat.o(157100);
    }

    public void hideAddressBar() {
        AppMethodBeat.i(157101);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_hideAddressBar();
        }
        AppMethodBeat.o(157101);
    }

    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.i(157102);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_handlePluginTag(str, str2, z, str3);
        }
        AppMethodBeat.o(157102);
    }

    public void onDoubleTapStart() {
        AppMethodBeat.i(157103);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onDoubleTapStart();
        }
        AppMethodBeat.o(157103);
    }

    public void onPinchToZoomStart() {
        AppMethodBeat.i(157104);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPinchToZoomStart();
        }
        AppMethodBeat.o(157104);
    }

    public void onSlidingTitleOffScreen(int i2, int i3) {
        AppMethodBeat.i(157105);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onSlidingTitleOffScreen(i2, i3);
        }
        AppMethodBeat.o(157105);
    }

    public void onPreReadFinished() {
        AppMethodBeat.i(157106);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPreReadFinished();
        }
        AppMethodBeat.o(157106);
    }

    public void onPromptScaleSaved() {
        AppMethodBeat.i(157107);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPromptScaleSaved();
        }
        AppMethodBeat.o(157107);
    }

    public void onFlingScrollEnd() {
        AppMethodBeat.i(157108);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onFlingScrollEnd();
        }
        AppMethodBeat.o(157108);
    }

    public void onUrlChange(String str, String str2) {
        AppMethodBeat.i(157109);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onUrlChange(str, str2);
        }
        AppMethodBeat.o(157109);
    }

    public void onReportAdFilterInfo(int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(157110);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReportAdFilterInfo(i2, i3, str, z);
        }
        AppMethodBeat.o(157110);
    }

    public void onNativeCrashReport(int i2, String str) {
        AppMethodBeat.i(157111);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onNativeCrashReport(i2, str);
        }
        AppMethodBeat.o(157111);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(157112);
        if (this.mSuperProvider != null) {
            Object super_onMiscCallBack = this.mSuperProvider.super_onMiscCallBack(str, bundle);
            AppMethodBeat.o(157112);
            return super_onMiscCallBack;
        }
        AppMethodBeat.o(157112);
        return null;
    }

    public void onReportHtmlInfo(int i2, String str) {
        AppMethodBeat.i(157113);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReportHtmlInfo(i2, str);
        }
        AppMethodBeat.o(157113);
    }

    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(157114);
        if (this.mSuperProvider != null) {
            Object super_onMiscCallBack = this.mSuperProvider.super_onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
            AppMethodBeat.o(157114);
            return super_onMiscCallBack;
        }
        AppMethodBeat.o(157114);
        return null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(157115);
        if (this.mSuperProvider != null) {
            boolean super_onInterceptTouchEvent = this.mSuperProvider.super_onInterceptTouchEvent(motionEvent, view);
            AppMethodBeat.o(157115);
            return super_onInterceptTouchEvent;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157115);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(157116);
        if (this.mSuperProvider != null) {
            boolean super_onTouchEvent = this.mSuperProvider.super_onTouchEvent(motionEvent, view);
            AppMethodBeat.o(157116);
            return super_onTouchEvent;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157116);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(157117);
        if (this.mSuperProvider != null) {
            boolean super_dispatchTouchEvent = this.mSuperProvider.super_dispatchTouchEvent(motionEvent, view);
            AppMethodBeat.o(157117);
            return super_dispatchTouchEvent;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157117);
        return false;
    }

    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
        AppMethodBeat.i(157118);
        if (this.mSuperProvider != null) {
            boolean super_overScrollBy = this.mSuperProvider.super_overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, view);
            AppMethodBeat.o(157118);
            return super_overScrollBy;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157118);
        return false;
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(157119);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onScrollChanged(i2, i3, i4, i5, view);
            AppMethodBeat.o(157119);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157119);
    }

    public void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
        AppMethodBeat.i(157120);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onOverScrolled(i2, i3, z, z2, view);
            AppMethodBeat.o(157120);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157120);
    }

    public void computeScroll(View view) {
        AppMethodBeat.i(157121);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_computeScroll(view);
        }
        AppMethodBeat.o(157121);
    }

    public void onMetricsSavedCountReceived(String str, boolean z, long j2, String str2, int i2) {
        AppMethodBeat.i(157122);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onMetricsSavedCountReceived(str, z, j2, str2, i2);
            AppMethodBeat.o(157122);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157122);
    }

    public void showTranslateBubble(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(157123);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_showTranslateBubble(i2, str, str2, i3);
            AppMethodBeat.o(157123);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157123);
    }

    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        AppMethodBeat.i(157124);
        if (this.mSuperProvider != null) {
            boolean super_notifyAutoAudioPlay = this.mSuperProvider.super_notifyAutoAudioPlay(str, jsResult);
            AppMethodBeat.o(157124);
            return super_notifyAutoAudioPlay;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157124);
        return false;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(157125);
        if (this.mSuperProvider != null) {
            boolean super_onShowLongClickPopupMenu = this.mSuperProvider.super_onShowLongClickPopupMenu();
            AppMethodBeat.o(157125);
            return super_onShowLongClickPopupMenu;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157125);
        return false;
    }

    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i2) {
        AppMethodBeat.i(157126);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onResponseReceived(webResourceRequest, webResourceResponse, i2);
            AppMethodBeat.o(157126);
            return;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157126);
    }

    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.i(157127);
        if (this.mSuperProvider != null) {
            boolean super_allowJavaScriptOpenWindowAutomatically = this.mSuperProvider.super_allowJavaScriptOpenWindowAutomatically(str, str2);
            AppMethodBeat.o(157127);
            return super_allowJavaScriptOpenWindowAutomatically;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157127);
        return false;
    }

    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.i(157128);
        if (this.mSuperProvider != null) {
            boolean super_notifyJavaScriptOpenWindowsBlocked = this.mSuperProvider.super_notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
            AppMethodBeat.o(157128);
            return super_notifyJavaScriptOpenWindowsBlocked;
        }
        Log.e(TAG, "mSuperProvider Is null");
        AppMethodBeat.o(157128);
        return false;
    }

    public void documentAvailableInMainFrame() {
        AppMethodBeat.i(157129);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_documentAvailableInMainFrame();
        }
        AppMethodBeat.o(157129);
    }

    public void didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.i(157130);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_didFirstVisuallyNonEmptyPaint();
        }
        AppMethodBeat.o(157130);
    }

    public void onReceivedViewSource(String str) {
        AppMethodBeat.i(157131);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReceivedViewSource(str);
        }
        AppMethodBeat.o(157131);
    }

    public void onPrefetchResourceHit(boolean z) {
        AppMethodBeat.i(157132);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onPrefetchResourceHit(z);
        }
        AppMethodBeat.o(157132);
    }

    public void onReceivedSslErrorCancel() {
        AppMethodBeat.i(157133);
        if (this.mSuperProvider != null) {
            this.mSuperProvider.super_onReceivedSslErrorCancel();
        }
        AppMethodBeat.o(157133);
    }

    public void invalidate() {
    }

    public boolean shouldDiscardCurrentPage() {
        return false;
    }

    public void hasDiscardCurrentPage(boolean z) {
    }
}
