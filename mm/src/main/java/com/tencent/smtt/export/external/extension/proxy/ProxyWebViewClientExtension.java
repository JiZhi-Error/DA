package com.tencent.smtt.export.external.extension.proxy;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class ProxyWebViewClientExtension implements IX5WebViewClientExtension {
    private static boolean sCompatibleOnMetricsSavedCountReceived = true;
    private static boolean sCompatibleOnPageLoadingStartedAndFinished = true;
    protected IX5WebViewClientExtension mWebViewClientExt;

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPreReadFinished() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onPreReadFinished();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPromptScaleSaved() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onPromptScaleSaved();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUrlChange(String str, String str2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onUrlChange(str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHideListBox() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onHideListBox();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onShowListBox(strArr, iArr, iArr2, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onInputBoxTextChanged(iX5WebViewExtension, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onTransitionToCommitted() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onTransitionToCommitted();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void showTranslateBubble(int i2, String str, String str2, int i3) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.showTranslateBubble(i2, str, str2, i3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSupportReadMode() {
        if (this.mWebViewClientExt != null) {
            try {
                this.mWebViewClientExt.onSupportReadMode();
            } catch (NoSuchMethodError e2) {
            }
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUploadProgressStart(int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onUploadProgressStart(i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUploadProgressChange(int i2, int i3, String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onUploadProgressChange(i2, i3, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFlingScrollBegin(int i2, int i3, int i4) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onFlingScrollBegin(i2, i3, i4);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFlingScrollEnd() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onFlingScrollEnd();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onScrollChanged(i2, i3, i4, i5);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSoftKeyBoardShow() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onSoftKeyBoardShow();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSoftKeyBoardHide(int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onSoftKeyBoardHide(i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSetButtonStatus(boolean z, boolean z2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onSetButtonStatus(z, z2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHistoryItemChanged() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onHistoryItemChanged();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void hideAddressBar() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.hideAddressBar();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.handlePluginTag(str, str2, z, str3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onDoubleTapStart() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onDoubleTapStart();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPinchToZoomStart() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onPinchToZoomStart();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSlidingTitleOffScreen(int i2, int i3) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onSlidingTitleOffScreen(i2, i3);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.preShouldOverrideUrlLoading(iX5WebViewExtension, str);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onMissingPluginClicked(String str, String str2, String str3, int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onMissingPluginClicked(str, str2, str3, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportAdFilterInfo(int i2, int i3, String str, boolean z) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onReportAdFilterInfo(i2, i3, str, z);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportHtmlInfo(int i2, String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onReportHtmlInfo(i2, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onNativeCrashReport(int i2, String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onNativeCrashReport(i2, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public Object onMiscCallBack(String str, Bundle bundle) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.onMiscCallBack(str, bundle);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.onInterceptTouchEvent(motionEvent, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.onTouchEvent(motionEvent, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.dispatchTouchEvent(motionEvent, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, view);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onScrollChanged(i2, i3, i4, i5, view);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onOverScrolled(i2, i3, z, z2, view);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void computeScroll(View view) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.computeScroll(view);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onMetricsSavedCountReceived(String str, boolean z, long j2, String str2, int i2) {
        if (this.mWebViewClientExt != null && sCompatibleOnMetricsSavedCountReceived) {
            try {
                this.mWebViewClientExt.onMetricsSavedCountReceived(str, z, j2, str2, i2);
            } catch (NoSuchMethodError e2) {
                if (e2.getMessage() == null || !e2.getMessage().contains("onMetricsSavedCountReceived")) {
                    throw e2;
                }
                sCompatibleOnMetricsSavedCountReceived = false;
            }
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        if (this.mWebViewClientExt != null) {
            try {
                return this.mWebViewClientExt.notifyAutoAudioPlay(str, jsResult);
            } catch (NoSuchMethodError e2) {
            }
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean requestVibration(String str, JsResult jsResult) {
        if (this.mWebViewClientExt != null) {
            try {
                return this.mWebViewClientExt.requestVibration(str, jsResult);
            } catch (NoSuchMethodError e2) {
            }
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.allowJavaScriptOpenWindowAutomatically(str, str2);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onShowLongClickPopupMenu() {
        if (this.mWebViewClientExt != null) {
            try {
                return this.mWebViewClientExt.onShowLongClickPopupMenu();
            } catch (NoSuchMethodError e2) {
            }
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean reportFingerSearchRequestInfo(String str) {
        if (this.mWebViewClientExt != null) {
            try {
                return this.mWebViewClientExt.reportFingerSearchRequestInfo(str);
            } catch (NoSuchMethodError e2) {
            }
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean reportFingerSearchAdjustInfo(String str) {
        if (this.mWebViewClientExt != null) {
            try {
                return this.mWebViewClientExt.reportFingerSearchAdjustInfo(str);
            } catch (NoSuchMethodError e2) {
            }
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onResponseReceived(webResourceRequest, webResourceResponse, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void didFirstVisuallyNonEmptyPaint() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.didFirstVisuallyNonEmptyPaint();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void documentAvailableInMainFrame() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.documentAvailableInMainFrame();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedViewSource(String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onReceivedViewSource(str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPrefetchResourceHit(boolean z) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onPrefetchResourceHit(z);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedSslErrorCancel() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onReceivedSslErrorCancel();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void didNavigateWithinPage(IX5WebViewBase iX5WebViewBase, String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.didNavigateWithinPage(iX5WebViewBase, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean shouldDiscardCurrentPage() {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.shouldDiscardCurrentPage();
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void hasDiscardCurrentPage(boolean z) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.hasDiscardCurrentPage(z);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean shouldRestoreCurrentPage() {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.shouldRestoreCurrentPage();
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedQNovel(String str, String str2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onReceivedQNovel(str, str2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void hasRestoreCurrentPage(boolean z) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.hasRestoreCurrentPage(z);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void didFailLoad(String str, int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.didFailLoad(str, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHideAdSuccess() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onHideAdSuccess();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onGetTtsText(String str, int i2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onGetTtsText(str, i2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowTtsBar() {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onShowTtsBar();
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSpecialSiteDetectedResult(Set<String> set, Set<String> set2) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onSpecialSiteDetectedResult(set, set2);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void invalidate() {
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPreloadCallback(int i2, String str) {
        if (this.mWebViewClientExt != null) {
            this.mWebViewClientExt.onPreloadCallback(i2, str);
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public HashMap<String, String> onGetExtraHeadersForPreloading(String str) {
        if (this.mWebViewClientExt != null) {
            return this.mWebViewClientExt.onGetExtraHeadersForPreloading(str);
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFakeLoginRecognised(Bundle bundle) {
        if (this.mWebViewClientExt != null) {
            try {
                this.mWebViewClientExt.onFakeLoginRecognised(bundle);
            } catch (NoSuchMethodError e2) {
            }
        }
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public int getHostByName(String str, List<String> list) {
        if (this.mWebViewClientExt == null) {
            return 0;
        }
        try {
            return this.mWebViewClientExt.getHostByName(str, list);
        } catch (NoSuchMethodError e2) {
            return 0;
        }
    }
}
