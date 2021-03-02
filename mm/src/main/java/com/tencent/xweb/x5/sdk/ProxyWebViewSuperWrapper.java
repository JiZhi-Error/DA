package com.tencent.xweb.x5.sdk;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.x5.X5WebFactory;
import com.tencent.xweb.x5.a;
import com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import com.tencent.xweb.x5.g;
import java.util.List;

public class ProxyWebViewSuperWrapper extends ProxyWebViewClientExtension implements IProxySuperWrapper {
    a mXWebProxyImp;

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void invalidate() {
    }

    public ProxyWebViewSuperWrapper(a aVar) {
        AppMethodBeat.i(154024);
        this.mXWebProxyImp = aVar;
        this.mXWebProxyImp.setSuperProvider(this);
        AppMethodBeat.o(154024);
    }

    public ProxyWebViewSuperWrapper() {
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPreReadFinished() {
        AppMethodBeat.i(154025);
        this.mXWebProxyImp.onPreReadFinished();
        AppMethodBeat.o(154025);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPromptScaleSaved() {
        AppMethodBeat.i(154026);
        this.mXWebProxyImp.onPromptScaleSaved();
        AppMethodBeat.o(154026);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUrlChange(String str, String str2) {
        AppMethodBeat.i(154027);
        this.mXWebProxyImp.onUrlChange(str, str2);
        AppMethodBeat.o(154027);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHideListBox() {
        AppMethodBeat.i(154028);
        this.mXWebProxyImp.onHideListBox();
        AppMethodBeat.o(154028);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i2) {
        AppMethodBeat.i(154029);
        this.mXWebProxyImp.onShowListBox(strArr, iArr, iArr2, i2);
        AppMethodBeat.o(154029);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(154030);
        this.mXWebProxyImp.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        AppMethodBeat.o(154030);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onTransitionToCommitted() {
        AppMethodBeat.i(154031);
        this.mXWebProxyImp.onTransitionToCommitted();
        AppMethodBeat.o(154031);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void showTranslateBubble(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(154032);
        this.mXWebProxyImp.showTranslateBubble(i2, str, str2, i3);
        AppMethodBeat.o(154032);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUploadProgressStart(int i2) {
        AppMethodBeat.i(154033);
        this.mXWebProxyImp.onUploadProgressStart(i2);
        AppMethodBeat.o(154033);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onUploadProgressChange(int i2, int i3, String str) {
        AppMethodBeat.i(154034);
        this.mXWebProxyImp.onUploadProgressChange(i2, i3, str);
        AppMethodBeat.o(154034);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFlingScrollBegin(int i2, int i3, int i4) {
        AppMethodBeat.i(154035);
        this.mXWebProxyImp.onFlingScrollBegin(i2, i3, i4);
        AppMethodBeat.o(154035);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onFlingScrollEnd() {
        AppMethodBeat.i(154036);
        this.mXWebProxyImp.onFlingScrollEnd();
        AppMethodBeat.o(154036);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(154037);
        this.mXWebProxyImp.onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(154037);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSoftKeyBoardShow() {
        AppMethodBeat.i(154038);
        this.mXWebProxyImp.onSoftKeyBoardShow();
        AppMethodBeat.o(154038);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSoftKeyBoardHide(int i2) {
        AppMethodBeat.i(154039);
        this.mXWebProxyImp.onSoftKeyBoardHide(i2);
        AppMethodBeat.o(154039);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.i(154040);
        this.mXWebProxyImp.onSetButtonStatus(z, z2);
        AppMethodBeat.o(154040);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onHistoryItemChanged() {
        AppMethodBeat.i(154041);
        this.mXWebProxyImp.onHistoryItemChanged();
        AppMethodBeat.o(154041);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void hideAddressBar() {
        AppMethodBeat.i(154042);
        this.mXWebProxyImp.hideAddressBar();
        AppMethodBeat.o(154042);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.i(154043);
        this.mXWebProxyImp.handlePluginTag(str, str2, z, str3);
        AppMethodBeat.o(154043);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onDoubleTapStart() {
        AppMethodBeat.i(154044);
        this.mXWebProxyImp.onDoubleTapStart();
        AppMethodBeat.o(154044);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPinchToZoomStart() {
        AppMethodBeat.i(154045);
        this.mXWebProxyImp.onPinchToZoomStart();
        AppMethodBeat.o(154045);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onSlidingTitleOffScreen(int i2, int i3) {
        AppMethodBeat.i(154046);
        this.mXWebProxyImp.onSlidingTitleOffScreen(i2, i3);
        AppMethodBeat.o(154046);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onMissingPluginClicked(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(154047);
        this.mXWebProxyImp.onMissingPluginClicked(str, str2, str3, i2);
        AppMethodBeat.o(154047);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportAdFilterInfo(int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(154048);
        this.mXWebProxyImp.onReportAdFilterInfo(i2, i3, str, z);
        AppMethodBeat.o(154048);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReportHtmlInfo(int i2, String str) {
        AppMethodBeat.i(154049);
        this.mXWebProxyImp.onReportHtmlInfo(i2, str);
        AppMethodBeat.o(154049);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onNativeCrashReport(int i2, String str) {
        AppMethodBeat.i(154050);
        this.mXWebProxyImp.onNativeCrashReport(i2, str);
        AppMethodBeat.o(154050);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(154051);
        Object onMiscCallBack = this.mXWebProxyImp.onMiscCallBack(str, bundle);
        AppMethodBeat.o(154051);
        return onMiscCallBack;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(154052);
        Object onMiscCallBack = this.mXWebProxyImp.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        AppMethodBeat.o(154052);
        return onMiscCallBack;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(154053);
        boolean onInterceptTouchEvent = this.mXWebProxyImp.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.o(154053);
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(154054);
        boolean onTouchEvent = this.mXWebProxyImp.onTouchEvent(motionEvent, view);
        AppMethodBeat.o(154054);
        return onTouchEvent;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(154055);
        boolean dispatchTouchEvent = this.mXWebProxyImp.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.o(154055);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
        AppMethodBeat.i(154056);
        boolean overScrollBy = this.mXWebProxyImp.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, view);
        AppMethodBeat.o(154056);
        return overScrollBy;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(154057);
        this.mXWebProxyImp.onScrollChanged(i2, i3, i4, i5, view);
        AppMethodBeat.o(154057);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
        AppMethodBeat.i(154058);
        this.mXWebProxyImp.onOverScrolled(i2, i3, z, z2, view);
        AppMethodBeat.o(154058);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void computeScroll(View view) {
        AppMethodBeat.i(154059);
        this.mXWebProxyImp.computeScroll(view);
        AppMethodBeat.o(154059);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onMetricsSavedCountReceived(String str, boolean z, long j2, String str2, int i2) {
        AppMethodBeat.i(154060);
        this.mXWebProxyImp.onMetricsSavedCountReceived(str, z, j2, str2, i2);
        AppMethodBeat.o(154060);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean notifyAutoAudioPlay(String str, JsResult jsResult) {
        AppMethodBeat.i(154061);
        boolean notifyAutoAudioPlay = this.mXWebProxyImp.notifyAutoAudioPlay(str, new g.C2234g(jsResult));
        AppMethodBeat.o(154061);
        return notifyAutoAudioPlay;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.i(154062);
        boolean allowJavaScriptOpenWindowAutomatically = this.mXWebProxyImp.allowJavaScriptOpenWindowAutomatically(str, str2);
        AppMethodBeat.o(154062);
        return allowJavaScriptOpenWindowAutomatically;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.i(154063);
        boolean notifyJavaScriptOpenWindowsBlocked = this.mXWebProxyImp.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        AppMethodBeat.o(154063);
        return notifyJavaScriptOpenWindowsBlocked;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(154064);
        boolean onShowLongClickPopupMenu = this.mXWebProxyImp.onShowLongClickPopupMenu();
        AppMethodBeat.o(154064);
        return onShowLongClickPopupMenu;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i2) {
        AppMethodBeat.i(154065);
        this.mXWebProxyImp.onResponseReceived(new g.b(webResourceRequest), g.a(webResourceResponse), i2);
        AppMethodBeat.o(154065);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.i(154066);
        this.mXWebProxyImp.didFirstVisuallyNonEmptyPaint();
        AppMethodBeat.o(154066);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void documentAvailableInMainFrame() {
        AppMethodBeat.i(154067);
        this.mXWebProxyImp.documentAvailableInMainFrame();
        AppMethodBeat.o(154067);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedViewSource(String str) {
        AppMethodBeat.i(154068);
        this.mXWebProxyImp.onReceivedViewSource(str);
        AppMethodBeat.o(154068);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onPrefetchResourceHit(boolean z) {
        AppMethodBeat.i(154069);
        this.mXWebProxyImp.onPrefetchResourceHit(z);
        AppMethodBeat.o(154069);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedSslErrorCancel() {
        AppMethodBeat.i(154070);
        this.mXWebProxyImp.onReceivedSslErrorCancel();
        AppMethodBeat.o(154070);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean shouldDiscardCurrentPage() {
        AppMethodBeat.i(154071);
        boolean shouldDiscardCurrentPage = this.mXWebProxyImp.shouldDiscardCurrentPage();
        AppMethodBeat.o(154071);
        return shouldDiscardCurrentPage;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void hasDiscardCurrentPage(boolean z) {
        AppMethodBeat.i(154072);
        this.mXWebProxyImp.hasDiscardCurrentPage(z);
        AppMethodBeat.o(154072);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public int getHostByName(String str, List<String> list) {
        AppMethodBeat.i(207239);
        if (X5WebFactory.getInstance().getExtensionCallback() != null) {
            int hostByName = X5WebFactory.getInstance().getExtensionCallback().getHostByName(str, list);
            AppMethodBeat.o(207239);
            return hostByName;
        }
        int hostByName2 = super.getHostByName(str, list);
        AppMethodBeat.o(207239);
        return hostByName2;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onPreReadFinished() {
        AppMethodBeat.i(154073);
        super.onPreReadFinished();
        AppMethodBeat.o(154073);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onPromptScaleSaved() {
        AppMethodBeat.i(154074);
        super.onPromptScaleSaved();
        AppMethodBeat.o(154074);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onUrlChange(String str, String str2) {
        AppMethodBeat.i(154075);
        super.onUrlChange(str, str2);
        AppMethodBeat.o(154075);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onHideListBox() {
        AppMethodBeat.i(154076);
        super.onHideListBox();
        AppMethodBeat.o(154076);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onShowListBox(String[] strArr, int[] iArr, int[] iArr2, int i2) {
        AppMethodBeat.i(154077);
        super.onShowListBox(strArr, iArr, iArr2, i2);
        AppMethodBeat.o(154077);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onShowMutilListBox(String[] strArr, int[] iArr, int[] iArr2, int[] iArr3) {
        AppMethodBeat.i(154078);
        super.onShowMutilListBox(strArr, iArr, iArr2, iArr3);
        AppMethodBeat.o(154078);
    }

    public void super_onInputBoxTextChanged(IX5WebViewExtension iX5WebViewExtension, String str) {
        AppMethodBeat.i(154079);
        super.onInputBoxTextChanged(iX5WebViewExtension, str);
        AppMethodBeat.o(154079);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onTransitionToCommitted() {
        AppMethodBeat.i(154080);
        super.onTransitionToCommitted();
        AppMethodBeat.o(154080);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_showTranslateBubble(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(154081);
        super.showTranslateBubble(i2, str, str2, i3);
        AppMethodBeat.o(154081);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onUploadProgressStart(int i2) {
        AppMethodBeat.i(154082);
        super.onUploadProgressStart(i2);
        AppMethodBeat.o(154082);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onUploadProgressChange(int i2, int i3, String str) {
        AppMethodBeat.i(154083);
        super.onUploadProgressChange(i2, i3, str);
        AppMethodBeat.o(154083);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onFlingScrollBegin(int i2, int i3, int i4) {
        AppMethodBeat.i(154084);
        super.onFlingScrollBegin(i2, i3, i4);
        AppMethodBeat.o(154084);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onFlingScrollEnd() {
        AppMethodBeat.i(154085);
        super.onFlingScrollEnd();
        AppMethodBeat.o(154085);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(154086);
        super.onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(154086);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onSoftKeyBoardShow() {
        AppMethodBeat.i(154087);
        super.onSoftKeyBoardShow();
        AppMethodBeat.o(154087);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onSoftKeyBoardHide(int i2) {
        AppMethodBeat.i(154088);
        super.onSoftKeyBoardHide(i2);
        AppMethodBeat.o(154088);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onSetButtonStatus(boolean z, boolean z2) {
        AppMethodBeat.i(154089);
        super.onSetButtonStatus(z, z2);
        AppMethodBeat.o(154089);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onHistoryItemChanged() {
        AppMethodBeat.i(154090);
        super.onHistoryItemChanged();
        AppMethodBeat.o(154090);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_hideAddressBar() {
        AppMethodBeat.i(154091);
        super.hideAddressBar();
        AppMethodBeat.o(154091);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_handlePluginTag(String str, String str2, boolean z, String str3) {
        AppMethodBeat.i(154092);
        super.handlePluginTag(str, str2, z, str3);
        AppMethodBeat.o(154092);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onDoubleTapStart() {
        AppMethodBeat.i(154093);
        super.onDoubleTapStart();
        AppMethodBeat.o(154093);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onPinchToZoomStart() {
        AppMethodBeat.i(154094);
        super.onPinchToZoomStart();
        AppMethodBeat.o(154094);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onSlidingTitleOffScreen(int i2, int i3) {
        AppMethodBeat.i(154095);
        super.onSlidingTitleOffScreen(i2, i3);
        AppMethodBeat.o(154095);
    }

    public boolean super_preShouldOverrideUrlLoading(IX5WebViewExtension iX5WebViewExtension, String str) {
        AppMethodBeat.i(154096);
        boolean preShouldOverrideUrlLoading = super.preShouldOverrideUrlLoading(iX5WebViewExtension, str);
        AppMethodBeat.o(154096);
        return preShouldOverrideUrlLoading;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onMissingPluginClicked(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(154097);
        super.onMissingPluginClicked(str, str2, str3, i2);
        AppMethodBeat.o(154097);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onReportAdFilterInfo(int i2, int i3, String str, boolean z) {
        AppMethodBeat.i(154098);
        super.onReportAdFilterInfo(i2, i3, str, z);
        AppMethodBeat.o(154098);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onReportHtmlInfo(int i2, String str) {
        AppMethodBeat.i(154099);
        super.onReportHtmlInfo(i2, str);
        AppMethodBeat.o(154099);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onNativeCrashReport(int i2, String str) {
        AppMethodBeat.i(154100);
        super.onNativeCrashReport(i2, str);
        AppMethodBeat.o(154100);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public Object super_onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(154101);
        Object onMiscCallBack = super.onMiscCallBack(str, bundle);
        AppMethodBeat.o(154101);
        return onMiscCallBack;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public Object super_onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.i(154102);
        Object onMiscCallBack = super.onMiscCallBack(str, bundle, obj, obj2, obj3, obj4);
        AppMethodBeat.o(154102);
        return onMiscCallBack;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(154103);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.o(154103);
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(154104);
        boolean onTouchEvent = super.onTouchEvent(motionEvent, view);
        AppMethodBeat.o(154104);
        return onTouchEvent;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(154105);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.o(154105);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
        AppMethodBeat.i(154106);
        boolean overScrollBy = super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, view);
        AppMethodBeat.o(154106);
        return overScrollBy;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(154107);
        super.onScrollChanged(i2, i3, i4, i5, view);
        AppMethodBeat.o(154107);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
        AppMethodBeat.i(154108);
        super.onOverScrolled(i2, i3, z, z2, view);
        AppMethodBeat.o(154108);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_computeScroll(View view) {
        AppMethodBeat.i(154109);
        super.computeScroll(view);
        AppMethodBeat.o(154109);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onMetricsSavedCountReceived(String str, boolean z, long j2, String str2, int i2) {
        AppMethodBeat.i(154110);
        super.onMetricsSavedCountReceived(str, z, j2, str2, i2);
        AppMethodBeat.o(154110);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_notifyAutoAudioPlay(String str, com.tencent.xweb.JsResult jsResult) {
        AppMethodBeat.i(154111);
        boolean notifyAutoAudioPlay = super.notifyAutoAudioPlay(str, new a.c(jsResult));
        AppMethodBeat.o(154111);
        return notifyAutoAudioPlay;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_allowJavaScriptOpenWindowAutomatically(String str, String str2) {
        AppMethodBeat.i(154112);
        boolean allowJavaScriptOpenWindowAutomatically = super.allowJavaScriptOpenWindowAutomatically(str, str2);
        AppMethodBeat.o(154112);
        return allowJavaScriptOpenWindowAutomatically;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_notifyJavaScriptOpenWindowsBlocked(String str, String[] strArr, ValueCallback<Boolean> valueCallback, boolean z) {
        AppMethodBeat.i(154113);
        boolean notifyJavaScriptOpenWindowsBlocked = super.notifyJavaScriptOpenWindowsBlocked(str, strArr, valueCallback, z);
        AppMethodBeat.o(154113);
        return notifyJavaScriptOpenWindowsBlocked;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public boolean super_onShowLongClickPopupMenu() {
        AppMethodBeat.i(154114);
        boolean onShowLongClickPopupMenu = super.onShowLongClickPopupMenu();
        AppMethodBeat.o(154114);
        return onShowLongClickPopupMenu;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onResponseReceived(com.tencent.xweb.WebResourceRequest webResourceRequest, com.tencent.xweb.WebResourceResponse webResourceResponse, int i2) {
        AppMethodBeat.i(154115);
        super.onResponseReceived(a.e.a(webResourceRequest), com.tencent.xweb.x5.a.b(webResourceResponse), i2);
        AppMethodBeat.o(154115);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_didFirstVisuallyNonEmptyPaint() {
        AppMethodBeat.i(154116);
        super.didFirstVisuallyNonEmptyPaint();
        AppMethodBeat.o(154116);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_documentAvailableInMainFrame() {
        AppMethodBeat.i(154117);
        super.documentAvailableInMainFrame();
        AppMethodBeat.o(154117);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onReceivedViewSource(String str) {
        AppMethodBeat.i(154118);
        super.onReceivedViewSource(str);
        AppMethodBeat.o(154118);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onPrefetchResourceHit(boolean z) {
        AppMethodBeat.i(154119);
        super.onPrefetchResourceHit(z);
        AppMethodBeat.o(154119);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.IProxySuperWrapper
    public void super_onReceivedSslErrorCancel() {
        AppMethodBeat.i(154120);
        super.onReceivedSslErrorCancel();
        AppMethodBeat.o(154120);
    }
}
