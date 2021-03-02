package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.extension.XWalkExternalExtensionManagerImpl;

public class XWalkView extends AbsoluteLayout {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkView.class.desiredAssertionStatus());
    private static final String ANIMATABLE = "animatable";
    public static final int RELOAD_IGNORE_CACHE = 1;
    public static final int RELOAD_NORMAL = 0;
    public static final String SURFACE_VIEW = "SurfaceView";
    private static final String TAG = "XWalkView";
    public static final String TEXTURE_VIEW = "TextureView";
    private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private LazyReflectMethod addJavascriptInterfaceObjectStringMethod;
    private LazyReflectMethod adjustSelectPositionlongStringintintMethod;
    private Object bridge;
    private LazyReflectMethod canZoomInMethod;
    private LazyReflectMethod canZoomOutMethod;
    private LazyReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod;
    private LazyReflectMethod clearCacheForSingleFileStringMethod;
    private LazyReflectMethod clearCachebooleanMethod;
    private LazyReflectMethod clearClientCertPreferencesRunnableMethod;
    private LazyReflectMethod clearFormDataMethod;
    private LazyReflectMethod clearMatchesMethod;
    private LazyReflectMethod clearSslPreferencesMethod;
    private LazyReflectMethod computeHorizontalScrollOffsetMethod;
    private LazyReflectMethod computeHorizontalScrollRangeMethod;
    private LazyReflectMethod computeVerticalScrollExtentMethod;
    private LazyReflectMethod computeVerticalScrollOffsetMethod;
    private LazyReflectMethod computeVerticalScrollRangeMethod;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private LazyReflectMethod evaluateJavascriptStringValueCallbackMethod;
    private LazyReflectMethod findAllAsyncStringMethod;
    private LazyReflectMethod findNextbooleanMethod;
    private LazyReflectMethod getAPIVersionMethod;
    private LazyReflectMethod getCertificateMethod;
    private LazyReflectMethod getCompositingSurfaceTypeMethod;
    private LazyReflectMethod getContentHeightMethod;
    private LazyReflectMethod getExtensionManagerMethod;
    private LazyReflectMethod getFaviconMethod;
    private LazyReflectMethod getHitTestResultMethod;
    private LazyReflectMethod getImageBitmapToFileMethod;
    private LazyReflectMethod getNavigationHistoryMethod;
    private LazyReflectMethod getOriginalUrlMethod;
    private LazyReflectMethod getRefererUrlMethod;
    private LazyReflectMethod getRemoteDebuggingUrlMethod;
    private LazyReflectMethod getScalenMethod;
    private LazyReflectMethod getSettingsMethod;
    private LazyReflectMethod getTitleMethod;
    private LazyReflectMethod getTranslateSampleStringintMethod;
    private LazyReflectMethod getUrlMethod;
    private LazyReflectMethod getUserAgentStringMethod;
    private LazyReflectMethod getXWalkContentViewMethod;
    private LazyReflectMethod getXWalkVersionMethod;
    private LazyReflectMethod hasEnteredFullscreenMethod;
    private LazyReflectMethod invokeExtensionMethod;
    boolean isInitedBottomHeightMethod;
    private LazyReflectMethod isSupportExtendPluginForAppbrandMethod;
    private LazyReflectMethod leaveFullscreenMethod;
    private LazyReflectMethod loadAppFromManifestStringStringMethod;
    private LazyReflectMethod loadDataStringStringStringMethod;
    private LazyReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod;
    private LazyReflectMethod loadStringStringMapMethod;
    private LazyReflectMethod loadStringStringMethod;
    private LazyReflectMethod loadUrlStringMapMethod;
    private LazyReflectMethod loadUrlStringMethod;
    private String mAnimatable;
    private OverScrolledListener mOverScrolledListener;
    private ScrollChangedListener mScrollChangedListener;
    private LazyReflectMethod onActivityResultintintIntentMethod;
    private LazyReflectMethod onCreateInputConnectionEditorInfoMethod;
    private LazyReflectMethod onDestroyMethod;
    private LazyReflectMethod onHideMethod;
    private LazyReflectMethod onNewIntentIntentMethod;
    private LazyReflectMethod onPauseMethod;
    private LazyReflectMethod onResumeMethod;
    private LazyReflectMethod onShowMethod;
    private LazyReflectMethod onTouchEventMotionEventMethod;
    private LazyReflectMethod pauseTimersMethod;
    private LazyReflectMethod postWrapperMethod;
    private LazyReflectMethod preInitViewSizeMethod;
    private LazyReflectMethod reloadintMethod;
    private LazyReflectMethod removeJavascriptInterfaceStringMethod;
    private LazyReflectMethod replaceTranslatedStringMethod;
    private LazyReflectMethod restoreStateBundleMethod;
    private LazyReflectMethod resumeTimersMethod;
    private LazyReflectMethod savePageMethod;
    private LazyReflectMethod saveStateBundleMethod;
    private LazyReflectMethod scrollByintintMethod;
    private LazyReflectMethod scrollTointintMethod;
    private LazyReflectMethod setAcceptLanguagesStringMethod;
    private LazyReflectMethod setBackgroundColorintMethod;
    private LazyReflectMethod setBottomHeightMethod;
    private LazyReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod;
    private LazyReflectMethod setExtendCanvasClientXWalkExtendCanvasClientInternalMethod;
    private LazyReflectMethod setExtendPluginClientXWalkExtendPluginClientInternalMethod;
    private LazyReflectMethod setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod;
    private LazyReflectMethod setFindListenerXWalkFindListenerInternalMethod;
    private LazyReflectMethod setHorizontalScrollBarEnablebooleanMethod;
    private LazyReflectMethod setInitialScaleintMethod;
    private LazyReflectMethod setNetworkAvailablebooleanMethod;
    private LazyReflectMethod setOnTouchListenerOnTouchListenerMethod;
    private LazyReflectMethod setOriginAccessWhitelistStringStringArrayMethod;
    private LazyReflectMethod setProxyWebViewClientExtensionInternalMethod;
    private LazyReflectMethod setResourceClientXWalkResourceClientInternalMethod;
    private LazyReflectMethod setSurfaceViewVisibilityintMethod;
    private LazyReflectMethod setTranslateModebooleanMethod;
    private LazyReflectMethod setUIClientXWalkUIClientInternalMethod;
    private LazyReflectMethod setUserAgentStringStringMethod;
    private LazyReflectMethod setVerticalScrollBarEnablebooleanMethod;
    private LazyReflectMethod setXWalkViewInternalVisibilityintMethod;
    private LazyReflectMethod setZOrderOnTopbooleanMethod;
    private LazyReflectMethod smoothScrollintintMethod;
    private LazyReflectMethod startActivityForResultIntentintBundleMethod;
    private LazyReflectMethod stopLoadingMethod;
    private LazyReflectMethod zoomByfloatMethod;
    private LazyReflectMethod zoomInMethod;
    private LazyReflectMethod zoomOutMethod;

    public interface OverScrolledListener {
        void onOverScrolled(boolean z);
    }

    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    static {
        AppMethodBeat.i(155157);
        AppMethodBeat.o(155157);
    }

    public Object getBridge() {
        return this.bridge;
    }

    public XWalkView(Context context) {
        super(context, null);
        AppMethodBeat.i(155043);
        this.preInitViewSizeMethod = new LazyReflectMethod((Class<?>) null, "preInitViewSize", (Class<?>[]) new Class[0]);
        this.isSupportExtendPluginForAppbrandMethod = new LazyReflectMethod((Class<?>) null, "isSupportExtendPluginForAppbrand", (Class<?>[]) new Class[0]);
        this.getXWalkContentViewMethod = new LazyReflectMethod((Class<?>) null, "getXWalkContentView", (Class<?>[]) new Class[0]);
        this.loadStringStringMethod = new LazyReflectMethod((Class<?>) null, "load", (Class<?>[]) new Class[0]);
        this.loadStringStringMapMethod = new LazyReflectMethod((Class<?>) null, "load", (Class<?>[]) new Class[0]);
        this.loadDataStringStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadData", (Class<?>[]) new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadDataWithBaseURL", (Class<?>[]) new Class[0]);
        this.loadUrlStringMethod = new LazyReflectMethod((Class<?>) null, "loadUrl", (Class<?>[]) new Class[0]);
        this.loadUrlStringMapMethod = new LazyReflectMethod((Class<?>) null, "loadUrl", (Class<?>[]) new Class[0]);
        this.loadAppFromManifestStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadAppFromManifest", (Class<?>[]) new Class[0]);
        this.reloadintMethod = new LazyReflectMethod((Class<?>) null, "reload", (Class<?>[]) new Class[0]);
        this.stopLoadingMethod = new LazyReflectMethod((Class<?>) null, "stopLoading", (Class<?>[]) new Class[0]);
        this.getRefererUrlMethod = new LazyReflectMethod((Class<?>) null, "getRefererUrl", (Class<?>[]) new Class[0]);
        this.getUrlMethod = new LazyReflectMethod((Class<?>) null, "getUrl", (Class<?>[]) new Class[0]);
        this.savePageMethod = new LazyReflectMethod((Class<?>) null, "savePage", (Class<?>[]) new Class[0]);
        this.isInitedBottomHeightMethod = false;
        this.setBottomHeightMethod = new LazyReflectMethod((Class<?>) null, "setBottomHeight", (Class<?>[]) new Class[0]);
        this.getHitTestResultMethod = new LazyReflectMethod((Class<?>) null, "getHitTestResult", (Class<?>[]) new Class[0]);
        this.getContentHeightMethod = new LazyReflectMethod((Class<?>) null, "getContentHeight", (Class<?>[]) new Class[0]);
        this.getTitleMethod = new LazyReflectMethod((Class<?>) null, "getTitle", (Class<?>[]) new Class[0]);
        this.getOriginalUrlMethod = new LazyReflectMethod((Class<?>) null, "getOriginalUrl", (Class<?>[]) new Class[0]);
        this.getNavigationHistoryMethod = new LazyReflectMethod((Class<?>) null, "getNavigationHistory", (Class<?>[]) new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod((Class<?>) null, "addJavascriptInterface", (Class<?>[]) new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new LazyReflectMethod((Class<?>) null, "removeJavascriptInterface", (Class<?>[]) new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod((Class<?>) null, "evaluateJavascript", (Class<?>[]) new Class[0]);
        this.clearCachebooleanMethod = new LazyReflectMethod((Class<?>) null, "clearCache", (Class<?>[]) new Class[0]);
        this.clearCacheForSingleFileStringMethod = new LazyReflectMethod((Class<?>) null, "clearCacheForSingleFile", (Class<?>[]) new Class[0]);
        this.hasEnteredFullscreenMethod = new LazyReflectMethod((Class<?>) null, "hasEnteredFullscreen", (Class<?>[]) new Class[0]);
        this.leaveFullscreenMethod = new LazyReflectMethod((Class<?>) null, "leaveFullscreen", (Class<?>[]) new Class[0]);
        this.pauseTimersMethod = new LazyReflectMethod((Class<?>) null, "pauseTimers", (Class<?>[]) new Class[0]);
        this.resumeTimersMethod = new LazyReflectMethod((Class<?>) null, "resumeTimers", (Class<?>[]) new Class[0]);
        this.onPauseMethod = new LazyReflectMethod((Class<?>) null, "onPause", (Class<?>[]) new Class[0]);
        this.onResumeMethod = new LazyReflectMethod((Class<?>) null, "onResume", (Class<?>[]) new Class[0]);
        this.onHideMethod = new LazyReflectMethod((Class<?>) null, "onHide", (Class<?>[]) new Class[0]);
        this.onShowMethod = new LazyReflectMethod((Class<?>) null, "onShow", (Class<?>[]) new Class[0]);
        this.onDestroyMethod = new LazyReflectMethod((Class<?>) null, "onDestroy", (Class<?>[]) new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new LazyReflectMethod((Class<?>) null, "startActivityForResult", (Class<?>[]) new Class[0]);
        this.onActivityResultintintIntentMethod = new LazyReflectMethod((Class<?>) null, "onActivityResult", (Class<?>[]) new Class[0]);
        this.onNewIntentIntentMethod = new LazyReflectMethod((Class<?>) null, "onNewIntent", (Class<?>[]) new Class[0]);
        this.saveStateBundleMethod = new LazyReflectMethod((Class<?>) null, "saveState", (Class<?>[]) new Class[0]);
        this.restoreStateBundleMethod = new LazyReflectMethod((Class<?>) null, "restoreState", (Class<?>[]) new Class[0]);
        this.getAPIVersionMethod = new LazyReflectMethod((Class<?>) null, "getAPIVersion", (Class<?>[]) new Class[0]);
        this.getXWalkVersionMethod = new LazyReflectMethod((Class<?>) null, "getXWalkVersion", (Class<?>[]) new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setUIClient", (Class<?>[]) new Class[0]);
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendPluginClient", (Class<?>[]) new Class[0]);
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendCanvasClient", (Class<?>[]) new Class[0]);
        this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendTextAreaClient", (Class<?>[]) new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setResourceClient", (Class<?>[]) new Class[0]);
        this.setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod((Class<?>) null, "setProxyWebViewClientExtension", (Class<?>[]) new Class[0]);
        this.setBackgroundColorintMethod = new LazyReflectMethod((Class<?>) null, u.NAME, (Class<?>[]) new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod((Class<?>) null, "setOriginAccessWhitelist", (Class<?>[]) new Class[0]);
        this.setUserAgentStringStringMethod = new LazyReflectMethod((Class<?>) null, "setUserAgentString", (Class<?>[]) new Class[0]);
        this.getUserAgentStringMethod = new LazyReflectMethod((Class<?>) null, "getUserAgentString", (Class<?>[]) new Class[0]);
        this.setAcceptLanguagesStringMethod = new LazyReflectMethod((Class<?>) null, "setAcceptLanguages", (Class<?>[]) new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new LazyReflectMethod((Class<?>) null, "captureBitmapAsync", (Class<?>[]) new Class[0]);
        this.getSettingsMethod = new LazyReflectMethod((Class<?>) null, "getSettings", (Class<?>[]) new Class[0]);
        this.setNetworkAvailablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setNetworkAvailable", (Class<?>[]) new Class[0]);
        this.getRemoteDebuggingUrlMethod = new LazyReflectMethod((Class<?>) null, "getRemoteDebuggingUrl", (Class<?>[]) new Class[0]);
        this.zoomInMethod = new LazyReflectMethod((Class<?>) null, "zoomIn", (Class<?>[]) new Class[0]);
        this.getScalenMethod = new LazyReflectMethod((Class<?>) null, "getScale", (Class<?>[]) new Class[0]);
        this.zoomOutMethod = new LazyReflectMethod((Class<?>) null, "zoomOut", (Class<?>[]) new Class[0]);
        this.zoomByfloatMethod = new LazyReflectMethod((Class<?>) null, "zoomBy", (Class<?>[]) new Class[0]);
        this.canZoomInMethod = new LazyReflectMethod((Class<?>) null, "canZoomIn", (Class<?>[]) new Class[0]);
        this.canZoomOutMethod = new LazyReflectMethod((Class<?>) null, "canZoomOut", (Class<?>[]) new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod((Class<?>) null, "onCreateInputConnection", (Class<?>[]) new Class[0]);
        this.setInitialScaleintMethod = new LazyReflectMethod((Class<?>) null, "setInitialScale", (Class<?>[]) new Class[0]);
        this.getFaviconMethod = new LazyReflectMethod((Class<?>) null, "getFavicon", (Class<?>[]) new Class[0]);
        this.setZOrderOnTopbooleanMethod = new LazyReflectMethod((Class<?>) null, "setZOrderOnTop", (Class<?>[]) new Class[0]);
        this.clearFormDataMethod = new LazyReflectMethod((Class<?>) null, "clearFormData", (Class<?>[]) new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new LazyReflectMethod((Class<?>) null, "setSurfaceViewVisibility", (Class<?>[]) new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod((Class<?>) null, "setXWalkViewInternalVisibility", (Class<?>[]) new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "setDownloadListener", (Class<?>[]) new Class[0]);
        this.onTouchEventMotionEventMethod = new LazyReflectMethod((Class<?>) null, "onTouchEvent", (Class<?>[]) new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod((Class<?>) null, "setOnTouchListener", (Class<?>[]) new Class[0]);
        this.smoothScrollintintMethod = new LazyReflectMethod((Class<?>) null, "smoothScroll", (Class<?>[]) new Class[0]);
        this.scrollTointintMethod = new LazyReflectMethod((Class<?>) null, "scrollTo", (Class<?>[]) new Class[0]);
        this.scrollByintintMethod = new LazyReflectMethod((Class<?>) null, "scrollBy", (Class<?>[]) new Class[0]);
        this.computeHorizontalScrollRangeMethod = new LazyReflectMethod((Class<?>) null, "computeHorizontalScrollRange", (Class<?>[]) new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new LazyReflectMethod((Class<?>) null, "computeHorizontalScrollOffset", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollRangeMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollRange", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollOffsetMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollOffset", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollExtentMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollExtent", (Class<?>[]) new Class[0]);
        this.getExtensionManagerMethod = new LazyReflectMethod((Class<?>) null, "getExtensionManager", (Class<?>[]) new Class[0]);
        this.clearSslPreferencesMethod = new LazyReflectMethod((Class<?>) null, "clearSslPreferences", (Class<?>[]) new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new LazyReflectMethod((Class<?>) null, "clearClientCertPreferences", (Class<?>[]) new Class[0]);
        this.getCertificateMethod = new LazyReflectMethod((Class<?>) null, "getCertificate", (Class<?>[]) new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "setFindListener", (Class<?>[]) new Class[0]);
        this.findAllAsyncStringMethod = new LazyReflectMethod((Class<?>) null, "findAllAsync", (Class<?>[]) new Class[0]);
        this.findNextbooleanMethod = new LazyReflectMethod((Class<?>) null, "findNext", (Class<?>[]) new Class[0]);
        this.clearMatchesMethod = new LazyReflectMethod((Class<?>) null, "clearMatches", (Class<?>[]) new Class[0]);
        this.setTranslateModebooleanMethod = new LazyReflectMethod((Class<?>) null, "setTranslateMode", (Class<?>[]) new Class[0]);
        this.getTranslateSampleStringintMethod = new LazyReflectMethod((Class<?>) null, "getTranslateSampleString", (Class<?>[]) new Class[0]);
        this.replaceTranslatedStringMethod = new LazyReflectMethod((Class<?>) null, "replaceTranslatedString", (Class<?>[]) new Class[0]);
        this.getCompositingSurfaceTypeMethod = new LazyReflectMethod((Class<?>) null, "getCompositingSurfaceType", (Class<?>[]) new Class[0]);
        this.adjustSelectPositionlongStringintintMethod = new LazyReflectMethod((Class<?>) null, "adjustSelectPosition", (Class<?>[]) new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setVerticalScrollBarEnable", (Class<?>[]) new Class[0]);
        this.setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setHorizontalScrollBarEnable", (Class<?>[]) new Class[0]);
        this.getImageBitmapToFileMethod = new LazyReflectMethod((Class<?>) null, "getImageBitmapToFile", (Class<?>[]) new Class[0]);
        this.invokeExtensionMethod = new LazyReflectMethod((Class<?>) null, "invokeExtension", (Class<?>[]) new Class[0]);
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList<>();
        this.constructorTypes.add(Context.class);
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(context);
        this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
        reflectionInit();
        AppMethodBeat.o(155043);
    }

    public void postXWalkViewInternalContextConstructor() {
        AppMethodBeat.i(155044);
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        new XWalkExternalExtensionManagerImpl(this);
        AppMethodBeat.o(155044);
    }

    public XWalkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(155045);
        this.preInitViewSizeMethod = new LazyReflectMethod((Class<?>) null, "preInitViewSize", (Class<?>[]) new Class[0]);
        this.isSupportExtendPluginForAppbrandMethod = new LazyReflectMethod((Class<?>) null, "isSupportExtendPluginForAppbrand", (Class<?>[]) new Class[0]);
        this.getXWalkContentViewMethod = new LazyReflectMethod((Class<?>) null, "getXWalkContentView", (Class<?>[]) new Class[0]);
        this.loadStringStringMethod = new LazyReflectMethod((Class<?>) null, "load", (Class<?>[]) new Class[0]);
        this.loadStringStringMapMethod = new LazyReflectMethod((Class<?>) null, "load", (Class<?>[]) new Class[0]);
        this.loadDataStringStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadData", (Class<?>[]) new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadDataWithBaseURL", (Class<?>[]) new Class[0]);
        this.loadUrlStringMethod = new LazyReflectMethod((Class<?>) null, "loadUrl", (Class<?>[]) new Class[0]);
        this.loadUrlStringMapMethod = new LazyReflectMethod((Class<?>) null, "loadUrl", (Class<?>[]) new Class[0]);
        this.loadAppFromManifestStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadAppFromManifest", (Class<?>[]) new Class[0]);
        this.reloadintMethod = new LazyReflectMethod((Class<?>) null, "reload", (Class<?>[]) new Class[0]);
        this.stopLoadingMethod = new LazyReflectMethod((Class<?>) null, "stopLoading", (Class<?>[]) new Class[0]);
        this.getRefererUrlMethod = new LazyReflectMethod((Class<?>) null, "getRefererUrl", (Class<?>[]) new Class[0]);
        this.getUrlMethod = new LazyReflectMethod((Class<?>) null, "getUrl", (Class<?>[]) new Class[0]);
        this.savePageMethod = new LazyReflectMethod((Class<?>) null, "savePage", (Class<?>[]) new Class[0]);
        this.isInitedBottomHeightMethod = false;
        this.setBottomHeightMethod = new LazyReflectMethod((Class<?>) null, "setBottomHeight", (Class<?>[]) new Class[0]);
        this.getHitTestResultMethod = new LazyReflectMethod((Class<?>) null, "getHitTestResult", (Class<?>[]) new Class[0]);
        this.getContentHeightMethod = new LazyReflectMethod((Class<?>) null, "getContentHeight", (Class<?>[]) new Class[0]);
        this.getTitleMethod = new LazyReflectMethod((Class<?>) null, "getTitle", (Class<?>[]) new Class[0]);
        this.getOriginalUrlMethod = new LazyReflectMethod((Class<?>) null, "getOriginalUrl", (Class<?>[]) new Class[0]);
        this.getNavigationHistoryMethod = new LazyReflectMethod((Class<?>) null, "getNavigationHistory", (Class<?>[]) new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod((Class<?>) null, "addJavascriptInterface", (Class<?>[]) new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new LazyReflectMethod((Class<?>) null, "removeJavascriptInterface", (Class<?>[]) new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod((Class<?>) null, "evaluateJavascript", (Class<?>[]) new Class[0]);
        this.clearCachebooleanMethod = new LazyReflectMethod((Class<?>) null, "clearCache", (Class<?>[]) new Class[0]);
        this.clearCacheForSingleFileStringMethod = new LazyReflectMethod((Class<?>) null, "clearCacheForSingleFile", (Class<?>[]) new Class[0]);
        this.hasEnteredFullscreenMethod = new LazyReflectMethod((Class<?>) null, "hasEnteredFullscreen", (Class<?>[]) new Class[0]);
        this.leaveFullscreenMethod = new LazyReflectMethod((Class<?>) null, "leaveFullscreen", (Class<?>[]) new Class[0]);
        this.pauseTimersMethod = new LazyReflectMethod((Class<?>) null, "pauseTimers", (Class<?>[]) new Class[0]);
        this.resumeTimersMethod = new LazyReflectMethod((Class<?>) null, "resumeTimers", (Class<?>[]) new Class[0]);
        this.onPauseMethod = new LazyReflectMethod((Class<?>) null, "onPause", (Class<?>[]) new Class[0]);
        this.onResumeMethod = new LazyReflectMethod((Class<?>) null, "onResume", (Class<?>[]) new Class[0]);
        this.onHideMethod = new LazyReflectMethod((Class<?>) null, "onHide", (Class<?>[]) new Class[0]);
        this.onShowMethod = new LazyReflectMethod((Class<?>) null, "onShow", (Class<?>[]) new Class[0]);
        this.onDestroyMethod = new LazyReflectMethod((Class<?>) null, "onDestroy", (Class<?>[]) new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new LazyReflectMethod((Class<?>) null, "startActivityForResult", (Class<?>[]) new Class[0]);
        this.onActivityResultintintIntentMethod = new LazyReflectMethod((Class<?>) null, "onActivityResult", (Class<?>[]) new Class[0]);
        this.onNewIntentIntentMethod = new LazyReflectMethod((Class<?>) null, "onNewIntent", (Class<?>[]) new Class[0]);
        this.saveStateBundleMethod = new LazyReflectMethod((Class<?>) null, "saveState", (Class<?>[]) new Class[0]);
        this.restoreStateBundleMethod = new LazyReflectMethod((Class<?>) null, "restoreState", (Class<?>[]) new Class[0]);
        this.getAPIVersionMethod = new LazyReflectMethod((Class<?>) null, "getAPIVersion", (Class<?>[]) new Class[0]);
        this.getXWalkVersionMethod = new LazyReflectMethod((Class<?>) null, "getXWalkVersion", (Class<?>[]) new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setUIClient", (Class<?>[]) new Class[0]);
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendPluginClient", (Class<?>[]) new Class[0]);
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendCanvasClient", (Class<?>[]) new Class[0]);
        this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendTextAreaClient", (Class<?>[]) new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setResourceClient", (Class<?>[]) new Class[0]);
        this.setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod((Class<?>) null, "setProxyWebViewClientExtension", (Class<?>[]) new Class[0]);
        this.setBackgroundColorintMethod = new LazyReflectMethod((Class<?>) null, u.NAME, (Class<?>[]) new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod((Class<?>) null, "setOriginAccessWhitelist", (Class<?>[]) new Class[0]);
        this.setUserAgentStringStringMethod = new LazyReflectMethod((Class<?>) null, "setUserAgentString", (Class<?>[]) new Class[0]);
        this.getUserAgentStringMethod = new LazyReflectMethod((Class<?>) null, "getUserAgentString", (Class<?>[]) new Class[0]);
        this.setAcceptLanguagesStringMethod = new LazyReflectMethod((Class<?>) null, "setAcceptLanguages", (Class<?>[]) new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new LazyReflectMethod((Class<?>) null, "captureBitmapAsync", (Class<?>[]) new Class[0]);
        this.getSettingsMethod = new LazyReflectMethod((Class<?>) null, "getSettings", (Class<?>[]) new Class[0]);
        this.setNetworkAvailablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setNetworkAvailable", (Class<?>[]) new Class[0]);
        this.getRemoteDebuggingUrlMethod = new LazyReflectMethod((Class<?>) null, "getRemoteDebuggingUrl", (Class<?>[]) new Class[0]);
        this.zoomInMethod = new LazyReflectMethod((Class<?>) null, "zoomIn", (Class<?>[]) new Class[0]);
        this.getScalenMethod = new LazyReflectMethod((Class<?>) null, "getScale", (Class<?>[]) new Class[0]);
        this.zoomOutMethod = new LazyReflectMethod((Class<?>) null, "zoomOut", (Class<?>[]) new Class[0]);
        this.zoomByfloatMethod = new LazyReflectMethod((Class<?>) null, "zoomBy", (Class<?>[]) new Class[0]);
        this.canZoomInMethod = new LazyReflectMethod((Class<?>) null, "canZoomIn", (Class<?>[]) new Class[0]);
        this.canZoomOutMethod = new LazyReflectMethod((Class<?>) null, "canZoomOut", (Class<?>[]) new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod((Class<?>) null, "onCreateInputConnection", (Class<?>[]) new Class[0]);
        this.setInitialScaleintMethod = new LazyReflectMethod((Class<?>) null, "setInitialScale", (Class<?>[]) new Class[0]);
        this.getFaviconMethod = new LazyReflectMethod((Class<?>) null, "getFavicon", (Class<?>[]) new Class[0]);
        this.setZOrderOnTopbooleanMethod = new LazyReflectMethod((Class<?>) null, "setZOrderOnTop", (Class<?>[]) new Class[0]);
        this.clearFormDataMethod = new LazyReflectMethod((Class<?>) null, "clearFormData", (Class<?>[]) new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new LazyReflectMethod((Class<?>) null, "setSurfaceViewVisibility", (Class<?>[]) new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod((Class<?>) null, "setXWalkViewInternalVisibility", (Class<?>[]) new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "setDownloadListener", (Class<?>[]) new Class[0]);
        this.onTouchEventMotionEventMethod = new LazyReflectMethod((Class<?>) null, "onTouchEvent", (Class<?>[]) new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod((Class<?>) null, "setOnTouchListener", (Class<?>[]) new Class[0]);
        this.smoothScrollintintMethod = new LazyReflectMethod((Class<?>) null, "smoothScroll", (Class<?>[]) new Class[0]);
        this.scrollTointintMethod = new LazyReflectMethod((Class<?>) null, "scrollTo", (Class<?>[]) new Class[0]);
        this.scrollByintintMethod = new LazyReflectMethod((Class<?>) null, "scrollBy", (Class<?>[]) new Class[0]);
        this.computeHorizontalScrollRangeMethod = new LazyReflectMethod((Class<?>) null, "computeHorizontalScrollRange", (Class<?>[]) new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new LazyReflectMethod((Class<?>) null, "computeHorizontalScrollOffset", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollRangeMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollRange", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollOffsetMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollOffset", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollExtentMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollExtent", (Class<?>[]) new Class[0]);
        this.getExtensionManagerMethod = new LazyReflectMethod((Class<?>) null, "getExtensionManager", (Class<?>[]) new Class[0]);
        this.clearSslPreferencesMethod = new LazyReflectMethod((Class<?>) null, "clearSslPreferences", (Class<?>[]) new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new LazyReflectMethod((Class<?>) null, "clearClientCertPreferences", (Class<?>[]) new Class[0]);
        this.getCertificateMethod = new LazyReflectMethod((Class<?>) null, "getCertificate", (Class<?>[]) new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "setFindListener", (Class<?>[]) new Class[0]);
        this.findAllAsyncStringMethod = new LazyReflectMethod((Class<?>) null, "findAllAsync", (Class<?>[]) new Class[0]);
        this.findNextbooleanMethod = new LazyReflectMethod((Class<?>) null, "findNext", (Class<?>[]) new Class[0]);
        this.clearMatchesMethod = new LazyReflectMethod((Class<?>) null, "clearMatches", (Class<?>[]) new Class[0]);
        this.setTranslateModebooleanMethod = new LazyReflectMethod((Class<?>) null, "setTranslateMode", (Class<?>[]) new Class[0]);
        this.getTranslateSampleStringintMethod = new LazyReflectMethod((Class<?>) null, "getTranslateSampleString", (Class<?>[]) new Class[0]);
        this.replaceTranslatedStringMethod = new LazyReflectMethod((Class<?>) null, "replaceTranslatedString", (Class<?>[]) new Class[0]);
        this.getCompositingSurfaceTypeMethod = new LazyReflectMethod((Class<?>) null, "getCompositingSurfaceType", (Class<?>[]) new Class[0]);
        this.adjustSelectPositionlongStringintintMethod = new LazyReflectMethod((Class<?>) null, "adjustSelectPosition", (Class<?>[]) new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setVerticalScrollBarEnable", (Class<?>[]) new Class[0]);
        this.setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setHorizontalScrollBarEnable", (Class<?>[]) new Class[0]);
        this.getImageBitmapToFileMethod = new LazyReflectMethod((Class<?>) null, "getImageBitmapToFile", (Class<?>[]) new Class[0]);
        this.invokeExtensionMethod = new LazyReflectMethod((Class<?>) null, "invokeExtension", (Class<?>[]) new Class[0]);
        if (isInEditMode()) {
            AppMethodBeat.o(155045);
            return;
        }
        if (attributeSet != null) {
            this.mAnimatable = attributeSet.getAttributeValue(XWALK_ATTRS_NAMESPACE, ANIMATABLE);
        }
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList<>();
        this.constructorTypes.add(Context.class);
        this.constructorTypes.add(AttributeSet.class);
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(context);
        this.constructorParams.add(attributeSet);
        this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
        reflectionInit();
        AppMethodBeat.o(155045);
    }

    public void postXWalkViewInternalContextAttributeSetConstructor() {
        AppMethodBeat.i(155046);
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        new XWalkExternalExtensionManagerImpl(this);
        AppMethodBeat.o(155046);
    }

    @Deprecated
    public XWalkView(Context context, Activity activity) {
        super(context, null);
        AppMethodBeat.i(155047);
        this.preInitViewSizeMethod = new LazyReflectMethod((Class<?>) null, "preInitViewSize", (Class<?>[]) new Class[0]);
        this.isSupportExtendPluginForAppbrandMethod = new LazyReflectMethod((Class<?>) null, "isSupportExtendPluginForAppbrand", (Class<?>[]) new Class[0]);
        this.getXWalkContentViewMethod = new LazyReflectMethod((Class<?>) null, "getXWalkContentView", (Class<?>[]) new Class[0]);
        this.loadStringStringMethod = new LazyReflectMethod((Class<?>) null, "load", (Class<?>[]) new Class[0]);
        this.loadStringStringMapMethod = new LazyReflectMethod((Class<?>) null, "load", (Class<?>[]) new Class[0]);
        this.loadDataStringStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadData", (Class<?>[]) new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadDataWithBaseURL", (Class<?>[]) new Class[0]);
        this.loadUrlStringMethod = new LazyReflectMethod((Class<?>) null, "loadUrl", (Class<?>[]) new Class[0]);
        this.loadUrlStringMapMethod = new LazyReflectMethod((Class<?>) null, "loadUrl", (Class<?>[]) new Class[0]);
        this.loadAppFromManifestStringStringMethod = new LazyReflectMethod((Class<?>) null, "loadAppFromManifest", (Class<?>[]) new Class[0]);
        this.reloadintMethod = new LazyReflectMethod((Class<?>) null, "reload", (Class<?>[]) new Class[0]);
        this.stopLoadingMethod = new LazyReflectMethod((Class<?>) null, "stopLoading", (Class<?>[]) new Class[0]);
        this.getRefererUrlMethod = new LazyReflectMethod((Class<?>) null, "getRefererUrl", (Class<?>[]) new Class[0]);
        this.getUrlMethod = new LazyReflectMethod((Class<?>) null, "getUrl", (Class<?>[]) new Class[0]);
        this.savePageMethod = new LazyReflectMethod((Class<?>) null, "savePage", (Class<?>[]) new Class[0]);
        this.isInitedBottomHeightMethod = false;
        this.setBottomHeightMethod = new LazyReflectMethod((Class<?>) null, "setBottomHeight", (Class<?>[]) new Class[0]);
        this.getHitTestResultMethod = new LazyReflectMethod((Class<?>) null, "getHitTestResult", (Class<?>[]) new Class[0]);
        this.getContentHeightMethod = new LazyReflectMethod((Class<?>) null, "getContentHeight", (Class<?>[]) new Class[0]);
        this.getTitleMethod = new LazyReflectMethod((Class<?>) null, "getTitle", (Class<?>[]) new Class[0]);
        this.getOriginalUrlMethod = new LazyReflectMethod((Class<?>) null, "getOriginalUrl", (Class<?>[]) new Class[0]);
        this.getNavigationHistoryMethod = new LazyReflectMethod((Class<?>) null, "getNavigationHistory", (Class<?>[]) new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod((Class<?>) null, "addJavascriptInterface", (Class<?>[]) new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new LazyReflectMethod((Class<?>) null, "removeJavascriptInterface", (Class<?>[]) new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod((Class<?>) null, "evaluateJavascript", (Class<?>[]) new Class[0]);
        this.clearCachebooleanMethod = new LazyReflectMethod((Class<?>) null, "clearCache", (Class<?>[]) new Class[0]);
        this.clearCacheForSingleFileStringMethod = new LazyReflectMethod((Class<?>) null, "clearCacheForSingleFile", (Class<?>[]) new Class[0]);
        this.hasEnteredFullscreenMethod = new LazyReflectMethod((Class<?>) null, "hasEnteredFullscreen", (Class<?>[]) new Class[0]);
        this.leaveFullscreenMethod = new LazyReflectMethod((Class<?>) null, "leaveFullscreen", (Class<?>[]) new Class[0]);
        this.pauseTimersMethod = new LazyReflectMethod((Class<?>) null, "pauseTimers", (Class<?>[]) new Class[0]);
        this.resumeTimersMethod = new LazyReflectMethod((Class<?>) null, "resumeTimers", (Class<?>[]) new Class[0]);
        this.onPauseMethod = new LazyReflectMethod((Class<?>) null, "onPause", (Class<?>[]) new Class[0]);
        this.onResumeMethod = new LazyReflectMethod((Class<?>) null, "onResume", (Class<?>[]) new Class[0]);
        this.onHideMethod = new LazyReflectMethod((Class<?>) null, "onHide", (Class<?>[]) new Class[0]);
        this.onShowMethod = new LazyReflectMethod((Class<?>) null, "onShow", (Class<?>[]) new Class[0]);
        this.onDestroyMethod = new LazyReflectMethod((Class<?>) null, "onDestroy", (Class<?>[]) new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new LazyReflectMethod((Class<?>) null, "startActivityForResult", (Class<?>[]) new Class[0]);
        this.onActivityResultintintIntentMethod = new LazyReflectMethod((Class<?>) null, "onActivityResult", (Class<?>[]) new Class[0]);
        this.onNewIntentIntentMethod = new LazyReflectMethod((Class<?>) null, "onNewIntent", (Class<?>[]) new Class[0]);
        this.saveStateBundleMethod = new LazyReflectMethod((Class<?>) null, "saveState", (Class<?>[]) new Class[0]);
        this.restoreStateBundleMethod = new LazyReflectMethod((Class<?>) null, "restoreState", (Class<?>[]) new Class[0]);
        this.getAPIVersionMethod = new LazyReflectMethod((Class<?>) null, "getAPIVersion", (Class<?>[]) new Class[0]);
        this.getXWalkVersionMethod = new LazyReflectMethod((Class<?>) null, "getXWalkVersion", (Class<?>[]) new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setUIClient", (Class<?>[]) new Class[0]);
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendPluginClient", (Class<?>[]) new Class[0]);
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendCanvasClient", (Class<?>[]) new Class[0]);
        this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setExtendTextAreaClient", (Class<?>[]) new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod((Class<?>) null, "setResourceClient", (Class<?>[]) new Class[0]);
        this.setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod((Class<?>) null, "setProxyWebViewClientExtension", (Class<?>[]) new Class[0]);
        this.setBackgroundColorintMethod = new LazyReflectMethod((Class<?>) null, u.NAME, (Class<?>[]) new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod((Class<?>) null, "setOriginAccessWhitelist", (Class<?>[]) new Class[0]);
        this.setUserAgentStringStringMethod = new LazyReflectMethod((Class<?>) null, "setUserAgentString", (Class<?>[]) new Class[0]);
        this.getUserAgentStringMethod = new LazyReflectMethod((Class<?>) null, "getUserAgentString", (Class<?>[]) new Class[0]);
        this.setAcceptLanguagesStringMethod = new LazyReflectMethod((Class<?>) null, "setAcceptLanguages", (Class<?>[]) new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new LazyReflectMethod((Class<?>) null, "captureBitmapAsync", (Class<?>[]) new Class[0]);
        this.getSettingsMethod = new LazyReflectMethod((Class<?>) null, "getSettings", (Class<?>[]) new Class[0]);
        this.setNetworkAvailablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setNetworkAvailable", (Class<?>[]) new Class[0]);
        this.getRemoteDebuggingUrlMethod = new LazyReflectMethod((Class<?>) null, "getRemoteDebuggingUrl", (Class<?>[]) new Class[0]);
        this.zoomInMethod = new LazyReflectMethod((Class<?>) null, "zoomIn", (Class<?>[]) new Class[0]);
        this.getScalenMethod = new LazyReflectMethod((Class<?>) null, "getScale", (Class<?>[]) new Class[0]);
        this.zoomOutMethod = new LazyReflectMethod((Class<?>) null, "zoomOut", (Class<?>[]) new Class[0]);
        this.zoomByfloatMethod = new LazyReflectMethod((Class<?>) null, "zoomBy", (Class<?>[]) new Class[0]);
        this.canZoomInMethod = new LazyReflectMethod((Class<?>) null, "canZoomIn", (Class<?>[]) new Class[0]);
        this.canZoomOutMethod = new LazyReflectMethod((Class<?>) null, "canZoomOut", (Class<?>[]) new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod((Class<?>) null, "onCreateInputConnection", (Class<?>[]) new Class[0]);
        this.setInitialScaleintMethod = new LazyReflectMethod((Class<?>) null, "setInitialScale", (Class<?>[]) new Class[0]);
        this.getFaviconMethod = new LazyReflectMethod((Class<?>) null, "getFavicon", (Class<?>[]) new Class[0]);
        this.setZOrderOnTopbooleanMethod = new LazyReflectMethod((Class<?>) null, "setZOrderOnTop", (Class<?>[]) new Class[0]);
        this.clearFormDataMethod = new LazyReflectMethod((Class<?>) null, "clearFormData", (Class<?>[]) new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new LazyReflectMethod((Class<?>) null, "setSurfaceViewVisibility", (Class<?>[]) new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod((Class<?>) null, "setXWalkViewInternalVisibility", (Class<?>[]) new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "setDownloadListener", (Class<?>[]) new Class[0]);
        this.onTouchEventMotionEventMethod = new LazyReflectMethod((Class<?>) null, "onTouchEvent", (Class<?>[]) new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod((Class<?>) null, "setOnTouchListener", (Class<?>[]) new Class[0]);
        this.smoothScrollintintMethod = new LazyReflectMethod((Class<?>) null, "smoothScroll", (Class<?>[]) new Class[0]);
        this.scrollTointintMethod = new LazyReflectMethod((Class<?>) null, "scrollTo", (Class<?>[]) new Class[0]);
        this.scrollByintintMethod = new LazyReflectMethod((Class<?>) null, "scrollBy", (Class<?>[]) new Class[0]);
        this.computeHorizontalScrollRangeMethod = new LazyReflectMethod((Class<?>) null, "computeHorizontalScrollRange", (Class<?>[]) new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new LazyReflectMethod((Class<?>) null, "computeHorizontalScrollOffset", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollRangeMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollRange", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollOffsetMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollOffset", (Class<?>[]) new Class[0]);
        this.computeVerticalScrollExtentMethod = new LazyReflectMethod((Class<?>) null, "computeVerticalScrollExtent", (Class<?>[]) new Class[0]);
        this.getExtensionManagerMethod = new LazyReflectMethod((Class<?>) null, "getExtensionManager", (Class<?>[]) new Class[0]);
        this.clearSslPreferencesMethod = new LazyReflectMethod((Class<?>) null, "clearSslPreferences", (Class<?>[]) new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new LazyReflectMethod((Class<?>) null, "clearClientCertPreferences", (Class<?>[]) new Class[0]);
        this.getCertificateMethod = new LazyReflectMethod((Class<?>) null, "getCertificate", (Class<?>[]) new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod((Class<?>) null, "setFindListener", (Class<?>[]) new Class[0]);
        this.findAllAsyncStringMethod = new LazyReflectMethod((Class<?>) null, "findAllAsync", (Class<?>[]) new Class[0]);
        this.findNextbooleanMethod = new LazyReflectMethod((Class<?>) null, "findNext", (Class<?>[]) new Class[0]);
        this.clearMatchesMethod = new LazyReflectMethod((Class<?>) null, "clearMatches", (Class<?>[]) new Class[0]);
        this.setTranslateModebooleanMethod = new LazyReflectMethod((Class<?>) null, "setTranslateMode", (Class<?>[]) new Class[0]);
        this.getTranslateSampleStringintMethod = new LazyReflectMethod((Class<?>) null, "getTranslateSampleString", (Class<?>[]) new Class[0]);
        this.replaceTranslatedStringMethod = new LazyReflectMethod((Class<?>) null, "replaceTranslatedString", (Class<?>[]) new Class[0]);
        this.getCompositingSurfaceTypeMethod = new LazyReflectMethod((Class<?>) null, "getCompositingSurfaceType", (Class<?>[]) new Class[0]);
        this.adjustSelectPositionlongStringintintMethod = new LazyReflectMethod((Class<?>) null, "adjustSelectPosition", (Class<?>[]) new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setVerticalScrollBarEnable", (Class<?>[]) new Class[0]);
        this.setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod((Class<?>) null, "setHorizontalScrollBarEnable", (Class<?>[]) new Class[0]);
        this.getImageBitmapToFileMethod = new LazyReflectMethod((Class<?>) null, "getImageBitmapToFile", (Class<?>[]) new Class[0]);
        this.invokeExtensionMethod = new LazyReflectMethod((Class<?>) null, "invokeExtension", (Class<?>[]) new Class[0]);
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList<>();
        this.constructorTypes.add(Context.class);
        this.constructorTypes.add(Activity.class);
        this.constructorParams = new ArrayList<>();
        this.constructorParams.add(context);
        this.constructorParams.add(activity);
        this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
        reflectionInit();
        AppMethodBeat.o(155047);
    }

    public boolean preInitViewSize(int i2, int i3, boolean z) {
        AppMethodBeat.i(155048);
        try {
            boolean booleanValue = ((Boolean) this.preInitViewSizeMethod.invoke(Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
            AppMethodBeat.o(155048);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155048);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155048);
            return false;
        } catch (Exception e3) {
            Log.e(TAG, "fakeViewSizeForPreload error exception:".concat(String.valueOf(e3)));
            AppMethodBeat.o(155048);
            return false;
        }
    }

    public boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.i(155049);
        try {
            boolean booleanValue = ((Boolean) this.isSupportExtendPluginForAppbrandMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155049);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155049);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155049);
            return false;
        }
    }

    public ViewGroup getXWalkContentView() {
        AppMethodBeat.i(155050);
        try {
            ViewGroup viewGroup = (ViewGroup) this.getXWalkContentViewMethod.invoke(new Object[0]);
            AppMethodBeat.o(155050);
            return viewGroup;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155050);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155050);
            return null;
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        AppMethodBeat.i(155051);
        if (!z) {
            setDescendantFocusability(393216);
            super.setFocusable(false);
            AppMethodBeat.o(155051);
            return;
        }
        setDescendantFocusability(131072);
        super.setFocusable(false);
        AppMethodBeat.o(155051);
    }

    public void setFocusableInTouchMode(boolean z) {
        AppMethodBeat.i(155052);
        if (!z) {
            setDescendantFocusability(393216);
            super.setFocusableInTouchMode(false);
            AppMethodBeat.o(155052);
            return;
        }
        setDescendantFocusability(131072);
        super.setFocusableInTouchMode(false);
        AppMethodBeat.o(155052);
    }

    public void postXWalkViewInternalContextActivityConstructor() {
        AppMethodBeat.i(155053);
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        new XWalkExternalExtensionManagerImpl(this);
        AppMethodBeat.o(155053);
    }

    @Deprecated
    public void load(String str, String str2) {
        AppMethodBeat.i(155054);
        try {
            this.loadStringStringMethod.invoke(str, str2);
            AppMethodBeat.o(155054);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155054);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155054);
        }
    }

    @Deprecated
    public void load(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(155055);
        try {
            this.loadStringStringMapMethod.invoke(str, str2, map);
            AppMethodBeat.o(155055);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155055);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155055);
        }
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(155056);
        try {
            this.loadDataStringStringStringMethod.invoke(str, str2, str3);
            AppMethodBeat.o(155056);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155056);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155056);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(155057);
        try {
            this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(str, str2, str3, str4, str5);
            AppMethodBeat.o(155057);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155057);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155057);
        }
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(155058);
        try {
            this.loadUrlStringMethod.invoke(str);
            AppMethodBeat.o(155058);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155058);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155058);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(155059);
        try {
            this.loadUrlStringMapMethod.invoke(str, map);
            AppMethodBeat.o(155059);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155059);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155059);
        }
    }

    public void loadAppFromManifest(String str, String str2) {
        AppMethodBeat.i(155060);
        try {
            this.loadAppFromManifestStringStringMethod.invoke(str, str2);
            AppMethodBeat.o(155060);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155060);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155060);
        }
    }

    public void reload(int i2) {
        AppMethodBeat.i(155061);
        try {
            this.reloadintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155061);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155061);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155061);
        }
    }

    public void stopLoading() {
        AppMethodBeat.i(155062);
        try {
            this.stopLoadingMethod.invoke(new Object[0]);
            AppMethodBeat.o(155062);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155062);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155062);
        }
    }

    public String getRefererUrl() {
        AppMethodBeat.i(155063);
        try {
            String str = (String) this.getRefererUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(155063);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155063);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155063);
            return null;
        }
    }

    public String getUrl() {
        AppMethodBeat.i(155064);
        try {
            String str = (String) this.getUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(155064);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155064);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155064);
            return null;
        }
    }

    public boolean savePage(String str, String str2, int i2) {
        AppMethodBeat.i(155065);
        try {
            boolean booleanValue = ((Boolean) this.savePageMethod.invoke(str, str2, Integer.valueOf(i2))).booleanValue();
            AppMethodBeat.o(155065);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155065);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155065);
            return false;
        }
    }

    public void setBottomHeight(int i2) {
        AppMethodBeat.i(155066);
        if (!this.isInitedBottomHeightMethod) {
            this.isInitedBottomHeightMethod = true;
            this.setBottomHeightMethod.init(this.bridge, null, "setBottomHeightSuper", Integer.TYPE);
        }
        if (this.setBottomHeightMethod == null || this.setBottomHeightMethod.isNull()) {
            AppMethodBeat.o(155066);
            return;
        }
        try {
            this.setBottomHeightMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155066);
        } catch (Exception e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155066);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155066);
        }
    }

    public XWalkHitTestResult getHitTestResult() {
        AppMethodBeat.i(155067);
        try {
            XWalkHitTestResult xWalkHitTestResult = (XWalkHitTestResult) this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
            AppMethodBeat.o(155067);
            return xWalkHitTestResult;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155067);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155067);
            return null;
        }
    }

    public int getContentHeight() {
        AppMethodBeat.i(155068);
        try {
            int intValue = ((Integer) this.getContentHeightMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155068);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155068);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155068);
            return 0;
        }
    }

    public String getTitle() {
        AppMethodBeat.i(155069);
        try {
            String str = (String) this.getTitleMethod.invoke(new Object[0]);
            AppMethodBeat.o(155069);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155069);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155069);
            return null;
        }
    }

    public String getOriginalUrl() {
        AppMethodBeat.i(155070);
        try {
            String str = (String) this.getOriginalUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(155070);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155070);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155070);
            return null;
        }
    }

    public XWalkNavigationHistory getNavigationHistory() {
        AppMethodBeat.i(155071);
        try {
            XWalkNavigationHistory xWalkNavigationHistory = (XWalkNavigationHistory) this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
            AppMethodBeat.o(155071);
            return xWalkNavigationHistory;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155071);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155071);
            return null;
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(155072);
        try {
            this.addJavascriptInterfaceObjectStringMethod.invoke(obj, str);
            AppMethodBeat.o(155072);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.addJavascriptInterfaceObjectStringMethod.setArguments(obj, str);
                XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
                AppMethodBeat.o(155072);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155072);
        }
    }

    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(155073);
        try {
            this.removeJavascriptInterfaceStringMethod.invoke(str);
            AppMethodBeat.o(155073);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.removeJavascriptInterfaceStringMethod.setArguments(str);
                XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
                AppMethodBeat.o(155073);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155073);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(155074);
        try {
            this.evaluateJavascriptStringValueCallbackMethod.invoke(str, valueCallback);
            AppMethodBeat.o(155074);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155074);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155074);
        }
    }

    public void clearCache(boolean z) {
        AppMethodBeat.i(155075);
        try {
            this.clearCachebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155075);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155075);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155075);
        }
    }

    public void clearCacheForSingleFile(String str) {
        AppMethodBeat.i(155076);
        try {
            this.clearCacheForSingleFileStringMethod.invoke(str);
            AppMethodBeat.o(155076);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155076);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155076);
        }
    }

    public boolean hasEnteredFullscreen() {
        AppMethodBeat.i(155077);
        try {
            boolean booleanValue = ((Boolean) this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155077);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155077);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155077);
            return false;
        }
    }

    public void leaveFullscreen() {
        AppMethodBeat.i(155078);
        try {
            this.leaveFullscreenMethod.invoke(new Object[0]);
            AppMethodBeat.o(155078);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155078);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155078);
        }
    }

    public void pauseTimers() {
        AppMethodBeat.i(155079);
        try {
            this.pauseTimersMethod.invoke(new Object[0]);
            AppMethodBeat.o(155079);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155079);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155079);
        }
    }

    public void resumeTimers() {
        AppMethodBeat.i(155080);
        try {
            this.resumeTimersMethod.invoke(new Object[0]);
            AppMethodBeat.o(155080);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155080);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155080);
        }
    }

    public void onPause() {
        AppMethodBeat.i(155081);
        if (!XWalkCoreWrapper.getInstance().hasFeature(1)) {
            AppMethodBeat.o(155081);
            return;
        }
        try {
            this.onPauseMethod.invoke(new Object[0]);
            AppMethodBeat.o(155081);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155081);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155081);
        }
    }

    public void onResume() {
        AppMethodBeat.i(155082);
        if (!XWalkCoreWrapper.getInstance().hasFeature(1)) {
            AppMethodBeat.o(155082);
            return;
        }
        try {
            this.onResumeMethod.invoke(new Object[0]);
            AppMethodBeat.o(155082);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155082);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155082);
        }
    }

    public void onHide() {
        AppMethodBeat.i(155083);
        try {
            this.onHideMethod.invoke(new Object[0]);
            AppMethodBeat.o(155083);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155083);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155083);
        }
    }

    public void onShow() {
        AppMethodBeat.i(155084);
        try {
            this.onShowMethod.invoke(new Object[0]);
            AppMethodBeat.o(155084);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155084);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155084);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(155085);
        try {
            this.onDestroyMethod.invoke(new Object[0]);
            AppMethodBeat.o(155085);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155085);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155085);
        }
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(155086);
        try {
            this.startActivityForResultIntentintBundleMethod.invoke(intent, Integer.valueOf(i2), bundle);
            AppMethodBeat.o(155086);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155086);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155086);
        }
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(155087);
        try {
            this.onActivityResultintintIntentMethod.invoke(Integer.valueOf(i2), Integer.valueOf(i3), intent);
            AppMethodBeat.o(155087);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155087);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155087);
        }
    }

    public boolean onNewIntent(Intent intent) {
        AppMethodBeat.i(155088);
        try {
            boolean booleanValue = ((Boolean) this.onNewIntentIntentMethod.invoke(intent)).booleanValue();
            AppMethodBeat.o(155088);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155088);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155088);
            return false;
        }
    }

    public boolean saveState(Bundle bundle) {
        AppMethodBeat.i(155089);
        try {
            boolean booleanValue = ((Boolean) this.saveStateBundleMethod.invoke(bundle)).booleanValue();
            AppMethodBeat.o(155089);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155089);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155089);
            return false;
        }
    }

    public boolean restoreState(Bundle bundle) {
        AppMethodBeat.i(155090);
        try {
            boolean booleanValue = ((Boolean) this.restoreStateBundleMethod.invoke(bundle)).booleanValue();
            AppMethodBeat.o(155090);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155090);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155090);
            return false;
        }
    }

    public String getAPIVersion() {
        AppMethodBeat.i(155091);
        try {
            String str = (String) this.getAPIVersionMethod.invoke(new Object[0]);
            AppMethodBeat.o(155091);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155091);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155091);
            return null;
        }
    }

    public String getXWalkVersion() {
        AppMethodBeat.i(155092);
        try {
            String str = (String) this.getXWalkVersionMethod.invoke(new Object[0]);
            AppMethodBeat.o(155092);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155092);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155092);
            return null;
        }
    }

    public void setUIClient(XWalkUIClient xWalkUIClient) {
        AppMethodBeat.i(155093);
        try {
            this.setUIClientXWalkUIClientInternalMethod.invoke(xWalkUIClient.getBridge());
            AppMethodBeat.o(155093);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setUIClientXWalkUIClientInternalMethod.setArguments(new LazyReflectMethod(xWalkUIClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
                AppMethodBeat.o(155093);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155093);
        }
    }

    public void setExtendPluginClient(XWalkExtendPluginClient xWalkExtendPluginClient) {
        AppMethodBeat.i(155094);
        try {
            this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.invoke(xWalkExtendPluginClient.getBridge());
            AppMethodBeat.o(155094);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.setArguments(new LazyReflectMethod(xWalkExtendPluginClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setExtendPluginClientXWalkExtendPluginClientInternalMethod);
                AppMethodBeat.o(155094);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155094);
        }
    }

    public void setExtendCanvasClient(XWalkExtendCanvasClient xWalkExtendCanvasClient) {
        AppMethodBeat.i(155095);
        try {
            this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.invoke(xWalkExtendCanvasClient.getBridge());
            AppMethodBeat.o(155095);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.setArguments(new LazyReflectMethod(xWalkExtendCanvasClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod);
                AppMethodBeat.o(155095);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155095);
        }
    }

    public void setExtendTextAreaClient(XWalkExtendTextAreaClient xWalkExtendTextAreaClient) {
        AppMethodBeat.i(155096);
        try {
            this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.invoke(xWalkExtendTextAreaClient.getBridge());
            AppMethodBeat.o(155096);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.setArguments(new LazyReflectMethod(xWalkExtendTextAreaClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod);
                AppMethodBeat.o(155096);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155096);
        }
    }

    public void setResourceClient(XWalkResourceClient xWalkResourceClient) {
        AppMethodBeat.i(155097);
        try {
            this.setResourceClientXWalkResourceClientInternalMethod.invoke(xWalkResourceClient.getBridge());
            AppMethodBeat.o(155097);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new LazyReflectMethod(xWalkResourceClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
                AppMethodBeat.o(155097);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155097);
        }
    }

    public void setProxyWebViewClientExtension(XWalkProxyWebViewClientExtension xWalkProxyWebViewClientExtension) {
        AppMethodBeat.i(155098);
        try {
            this.setProxyWebViewClientExtensionInternalMethod.invoke(xWalkProxyWebViewClientExtension.getBridge());
            AppMethodBeat.o(155098);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setProxyWebViewClientExtensionInternalMethod.setArguments(new LazyReflectMethod(xWalkProxyWebViewClientExtension, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setProxyWebViewClientExtensionInternalMethod);
                AppMethodBeat.o(155098);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155098);
        }
    }

    public void setBackgroundColor(int i2) {
        AppMethodBeat.i(155099);
        try {
            this.setBackgroundColorintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155099);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155099);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155099);
        }
    }

    public void setOriginAccessWhitelist(String str, String[] strArr) {
        AppMethodBeat.i(155100);
        try {
            this.setOriginAccessWhitelistStringStringArrayMethod.invoke(str, strArr);
            AppMethodBeat.o(155100);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155100);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155100);
        }
    }

    public void setLayerType(int i2, Paint paint) {
    }

    public void setUserAgentString(String str) {
        AppMethodBeat.i(155101);
        try {
            this.setUserAgentStringStringMethod.invoke(str);
            AppMethodBeat.o(155101);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155101);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155101);
        }
    }

    public String getUserAgentString() {
        AppMethodBeat.i(155102);
        try {
            String str = (String) this.getUserAgentStringMethod.invoke(new Object[0]);
            AppMethodBeat.o(155102);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155102);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155102);
            return null;
        }
    }

    public void setAcceptLanguages(String str) {
        AppMethodBeat.i(155103);
        try {
            this.setAcceptLanguagesStringMethod.invoke(str);
            AppMethodBeat.o(155103);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155103);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155103);
        }
    }

    public void captureBitmapAsync(XWalkGetBitmapCallback xWalkGetBitmapCallback) {
        AppMethodBeat.i(155104);
        try {
            this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(xWalkGetBitmapCallback.getBridge());
            AppMethodBeat.o(155104);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155104);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155104);
        }
    }

    public XWalkSettings getSettings() {
        AppMethodBeat.i(155105);
        try {
            XWalkSettings xWalkSettings = (XWalkSettings) this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
            AppMethodBeat.o(155105);
            return xWalkSettings;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155105);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155105);
            return null;
        }
    }

    public void setNetworkAvailable(boolean z) {
        AppMethodBeat.i(155106);
        try {
            this.setNetworkAvailablebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155106);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155106);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155106);
        }
    }

    public Uri getRemoteDebuggingUrl() {
        AppMethodBeat.i(155107);
        try {
            Uri uri = (Uri) this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(155107);
            return uri;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155107);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155107);
            return null;
        }
    }

    public boolean zoomIn() {
        AppMethodBeat.i(155108);
        try {
            boolean booleanValue = ((Boolean) this.zoomInMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155108);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155108);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155108);
            return false;
        }
    }

    public float getScale() {
        AppMethodBeat.i(155109);
        try {
            float floatValue = ((Float) this.getScalenMethod.invoke(new Object[0])).floatValue();
            AppMethodBeat.o(155109);
            return floatValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155109);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155109);
            return 1.0f;
        }
    }

    public boolean zoomOut() {
        AppMethodBeat.i(155110);
        try {
            boolean booleanValue = ((Boolean) this.zoomOutMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155110);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155110);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155110);
            return false;
        }
    }

    public void zoomBy(float f2) {
        AppMethodBeat.i(155111);
        try {
            this.zoomByfloatMethod.invoke(Float.valueOf(f2));
            AppMethodBeat.o(155111);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155111);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155111);
        }
    }

    public boolean canZoomIn() {
        AppMethodBeat.i(155112);
        try {
            boolean booleanValue = ((Boolean) this.canZoomInMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155112);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155112);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155112);
            return false;
        }
    }

    public boolean canZoomOut() {
        AppMethodBeat.i(155113);
        try {
            boolean booleanValue = ((Boolean) this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(155113);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155113);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155113);
            return false;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(155114);
        try {
            InputConnection inputConnection = (InputConnection) this.onCreateInputConnectionEditorInfoMethod.invoke(editorInfo);
            AppMethodBeat.o(155114);
            return inputConnection;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155114);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155114);
            return null;
        }
    }

    public void setInitialScale(int i2) {
        AppMethodBeat.i(155115);
        try {
            this.setInitialScaleintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155115);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155115);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155115);
        }
    }

    public Bitmap getFavicon() {
        AppMethodBeat.i(155116);
        try {
            Bitmap bitmap = (Bitmap) this.getFaviconMethod.invoke(new Object[0]);
            AppMethodBeat.o(155116);
            return bitmap;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155116);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155116);
            return null;
        }
    }

    public void setZOrderOnTop(boolean z) {
        AppMethodBeat.i(155117);
        try {
            this.setZOrderOnTopbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155117);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155117);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155117);
        }
    }

    public void clearFormData() {
        AppMethodBeat.i(155118);
        try {
            this.clearFormDataMethod.invoke(new Object[0]);
            AppMethodBeat.o(155118);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155118);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155118);
        }
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(155119);
        super.setVisibility(i2);
        setXWalkViewInternalVisibility(i2);
        setSurfaceViewVisibility(i2);
        AppMethodBeat.o(155119);
    }

    public void setSurfaceViewVisibility(int i2) {
        AppMethodBeat.i(155120);
        try {
            this.setSurfaceViewVisibilityintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155120);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setSurfaceViewVisibilityintMethod.setArguments(Integer.valueOf(i2));
                XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
                AppMethodBeat.o(155120);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155120);
        }
    }

    public void setXWalkViewInternalVisibility(int i2) {
        AppMethodBeat.i(155121);
        try {
            this.setXWalkViewInternalVisibilityintMethod.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(155121);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setXWalkViewInternalVisibilityintMethod.setArguments(Integer.valueOf(i2));
                XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
                AppMethodBeat.o(155121);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155121);
        }
    }

    public void setDownloadListener(XWalkDownloadListener xWalkDownloadListener) {
        AppMethodBeat.i(155122);
        try {
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(xWalkDownloadListener.getBridge());
            AppMethodBeat.o(155122);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new LazyReflectMethod(xWalkDownloadListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
                AppMethodBeat.o(155122);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155122);
        }
    }

    private boolean performLongClickDelegate() {
        AppMethodBeat.i(155123);
        boolean performLongClick = performLongClick();
        AppMethodBeat.o(155123);
        return performLongClick;
    }

    private boolean onTouchEventDelegate(MotionEvent motionEvent) {
        AppMethodBeat.i(155124);
        boolean onTouchEvent = onTouchEvent(motionEvent);
        AppMethodBeat.o(155124);
        return onTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(155125);
        try {
            boolean booleanValue = ((Boolean) this.onTouchEventMotionEventMethod.invoke(motionEvent)).booleanValue();
            AppMethodBeat.o(155125);
            return booleanValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155125);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155125);
            return false;
        }
    }

    public void setCustomOnScrollChangedListener(ScrollChangedListener scrollChangedListener) {
        this.mScrollChangedListener = scrollChangedListener;
    }

    public void onScrollChangedDelegate(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(155126);
        onScrollChanged(i2, i3, i4, i5);
        if (this.mScrollChangedListener != null) {
            this.mScrollChangedListener.onScrollChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(155126);
    }

    private void onFocusChangedDelegate(boolean z, int i2, Rect rect) {
        AppMethodBeat.i(155127);
        onFocusChanged(z, i2, rect);
        AppMethodBeat.o(155127);
    }

    public void setCustomOnOverScrolledListener(OverScrolledListener overScrolledListener) {
        this.mOverScrolledListener = overScrolledListener;
    }

    private void onOverScrolledDelegate(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(155128);
        onOverScrolled(i2, i3, z, z2);
        AppMethodBeat.o(155128);
    }

    private void onOverscrollRefresh(boolean z) {
        AppMethodBeat.i(155129);
        if (this.mOverScrolledListener != null) {
            this.mOverScrolledListener.onOverScrolled(z);
        }
        AppMethodBeat.o(155129);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(155130);
        try {
            this.setOnTouchListenerOnTouchListenerMethod.invoke(onTouchListener);
            AppMethodBeat.o(155130);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155130);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155130);
        }
    }

    public void smoothScroll(int i2, int i3, long j2) {
        AppMethodBeat.i(155131);
        try {
            this.smoothScrollintintMethod.invoke(Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
            AppMethodBeat.o(155131);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155131);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155131);
        }
    }

    public void scrollTo(int i2, int i3) {
        AppMethodBeat.i(155132);
        try {
            this.scrollTointintMethod.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(155132);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155132);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155132);
        }
    }

    public void scrollBy(int i2, int i3) {
        AppMethodBeat.i(155133);
        try {
            this.scrollByintintMethod.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(155133);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155133);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155133);
        }
    }

    public int computeHorizontalScrollRange() {
        AppMethodBeat.i(155134);
        try {
            int intValue = ((Integer) this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155134);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155134);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155134);
            return 0;
        }
    }

    public int computeHorizontalScrollOffset() {
        AppMethodBeat.i(155135);
        try {
            int intValue = ((Integer) this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155135);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155135);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155135);
            return 0;
        }
    }

    public int computeVerticalScrollRange() {
        AppMethodBeat.i(155136);
        try {
            int intValue = ((Integer) this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155136);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155136);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155136);
            return 0;
        }
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.i(155137);
        try {
            int intValue = ((Integer) this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155137);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155137);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155137);
            return 0;
        }
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(155138);
        try {
            int intValue = ((Integer) this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(155138);
            return intValue;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155138);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155138);
            return 0;
        }
    }

    public XWalkExternalExtensionManager getExtensionManager() {
        AppMethodBeat.i(155139);
        try {
            XWalkExternalExtensionManager xWalkExternalExtensionManager = (XWalkExternalExtensionManager) this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
            AppMethodBeat.o(155139);
            return xWalkExternalExtensionManager;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155139);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155139);
            return null;
        }
    }

    public void clearSslPreferences() {
        AppMethodBeat.i(155140);
        try {
            this.clearSslPreferencesMethod.invoke(new Object[0]);
            AppMethodBeat.o(155140);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155140);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155140);
        }
    }

    public void clearClientCertPreferences(Runnable runnable) {
        AppMethodBeat.i(155141);
        try {
            this.clearClientCertPreferencesRunnableMethod.invoke(runnable);
            AppMethodBeat.o(155141);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155141);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155141);
        }
    }

    public SslCertificate getCertificate() {
        AppMethodBeat.i(155142);
        try {
            SslCertificate sslCertificate = (SslCertificate) this.getCertificateMethod.invoke(new Object[0]);
            AppMethodBeat.o(155142);
            return sslCertificate;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155142);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155142);
            return null;
        }
    }

    public void setFindListener(XWalkFindListener xWalkFindListener) {
        AppMethodBeat.i(155143);
        try {
            this.setFindListenerXWalkFindListenerInternalMethod.invoke(xWalkFindListener.getBridge());
            AppMethodBeat.o(155143);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new LazyReflectMethod(xWalkFindListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
                AppMethodBeat.o(155143);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155143);
        }
    }

    public void findAllAsync(String str) {
        AppMethodBeat.i(155144);
        try {
            this.findAllAsyncStringMethod.invoke(str);
            AppMethodBeat.o(155144);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155144);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155144);
        }
    }

    public void findNext(boolean z) {
        AppMethodBeat.i(155145);
        try {
            this.findNextbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155145);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155145);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155145);
        }
    }

    public void clearMatches() {
        AppMethodBeat.i(155146);
        try {
            this.clearMatchesMethod.invoke(new Object[0]);
            AppMethodBeat.o(155146);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155146);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155146);
        }
    }

    public String getCompositingSurfaceType() {
        AppMethodBeat.i(155147);
        try {
            String str = (String) this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
            AppMethodBeat.o(155147);
            return str;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155147);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155147);
            return null;
        }
    }

    public void setTranslateMode(boolean z) {
        AppMethodBeat.i(155148);
        try {
            this.setTranslateModebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155148);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155148);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155148);
        }
    }

    public void getTranslateSampleString(int i2) {
        AppMethodBeat.i(155149);
        try {
            this.getTranslateSampleStringintMethod.invoke(Integer.valueOf(i2));
            h.mO(d.CTRL_INDEX, 103);
            AppMethodBeat.o(155149);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155149);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155149);
        }
    }

    public void replaceTranslatedString(Map<String, String> map) {
        AppMethodBeat.i(155150);
        try {
            this.replaceTranslatedStringMethod.invoke(map);
            AppMethodBeat.o(155150);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155150);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155150);
        }
    }

    public void adjustSelectPosition(long j2, String str, int i2, int i3) {
        AppMethodBeat.i(155151);
        try {
            this.adjustSelectPositionlongStringintintMethod.invoke(Long.valueOf(j2), str, Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(155151);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155151);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155151);
        }
    }

    public void setVerticalScrollBarEnable(boolean z) {
        AppMethodBeat.i(155152);
        try {
            this.setVerticalScrollBarEnablebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155152);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155152);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155152);
        }
    }

    public void setHorizontalScrollBarEnable(boolean z) {
        AppMethodBeat.i(155153);
        try {
            this.setHorizontalScrollBarEnablebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(155153);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155153);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.o(155153);
        }
    }

    public boolean getImageBitmapToFile(String str, String str2, String str3, XWalkGetImageBitmapToFileFinishedCallback xWalkGetImageBitmapToFileFinishedCallback) {
        AppMethodBeat.i(155154);
        try {
            Object invoke = this.getImageBitmapToFileMethod.invoke(str, str2, str3, xWalkGetImageBitmapToFileFinishedCallback.getBridge());
            if (invoke instanceof Boolean) {
                boolean booleanValue = ((Boolean) invoke).booleanValue();
                AppMethodBeat.o(155154);
                return booleanValue;
            }
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(155154);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
        } catch (Exception e3) {
            Log.e(TAG, "getImageBitmapToFile error:" + e3.getMessage());
        }
        AppMethodBeat.o(155154);
        return false;
    }

    public Object invokeExtension(int i2, Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(155155);
        if (this.invokeExtensionMethod == null) {
            Log.e(TAG, "invokeExtension not support this feature:");
            AppMethodBeat.o(155155);
        } else {
            try {
                obj2 = this.invokeExtensionMethod.invoke(Integer.valueOf(i2), obj);
                AppMethodBeat.o(155155);
            } catch (UnsupportedOperationException e2) {
                if (this.coreWrapper == null) {
                    RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                    AppMethodBeat.o(155155);
                    throw runtimeException;
                }
                XWalkCoreWrapper.handleRuntimeError(e2);
                AppMethodBeat.o(155155);
                return obj2;
            } catch (Exception e3) {
                Log.e(TAG, "invokeExtension error:" + e3.getMessage());
                AppMethodBeat.o(155155);
                return obj2;
            }
        }
        return obj2;
    }

    /* access modifiers changed from: package-private */
    public void reflectionInit() {
        AppMethodBeat.i(155156);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(155156);
            return;
        }
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = this.constructorTypes.get(i2);
            if (obj instanceof String) {
                clsArr[i2] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i2, this.coreWrapper.getBridgeObject(this.constructorParams.get(i2)));
            } else if (obj instanceof Class) {
                clsArr[i2] = (Class) obj;
            } else if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(155156);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.loadStringStringMethod.init(this.bridge, null, "loadSuper", String.class, String.class);
            this.loadStringStringMapMethod.init(this.bridge, null, "loadSuper", String.class, String.class, Map.class);
            this.loadDataStringStringStringMethod.init(this.bridge, null, "loadDataSuper", String.class, String.class, String.class);
            this.loadDataWithBaseURLStringStringStringStringStringMethod.init(this.bridge, null, "loadDataWithBaseURLSuper", String.class, String.class, String.class, String.class, String.class);
            this.loadUrlStringMethod.init(this.bridge, null, "loadUrlSuper", String.class);
            this.loadUrlStringMapMethod.init(this.bridge, null, "loadUrlSuper", String.class, Map.class);
            this.loadAppFromManifestStringStringMethod.init(this.bridge, null, "loadAppFromManifestSuper", String.class, String.class);
            this.reloadintMethod.init(this.bridge, null, "reloadSuper", Integer.TYPE);
            this.stopLoadingMethod.init(this.bridge, null, "stopLoadingSuper", new Class[0]);
            this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
            this.savePageMethod.init(this.bridge, null, "savePageSuper", String.class, String.class, Integer.TYPE);
            this.getHitTestResultMethod.init(this.bridge, null, "getHitTestResultSuper", new Class[0]);
            this.getContentHeightMethod.init(this.bridge, null, "getContentHeightSuper", new Class[0]);
            this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
            this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
            this.getNavigationHistoryMethod.init(this.bridge, null, "getNavigationHistorySuper", new Class[0]);
            this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", Object.class, String.class);
            this.removeJavascriptInterfaceStringMethod.init(this.bridge, null, "removeJavascriptInterfaceSuper", String.class);
            this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", String.class, ValueCallback.class);
            this.clearCachebooleanMethod.init(this.bridge, null, "clearCacheSuper", Boolean.TYPE);
            this.clearCacheForSingleFileStringMethod.init(this.bridge, null, "clearCacheForSingleFileSuper", String.class);
            this.hasEnteredFullscreenMethod.init(this.bridge, null, "hasEnteredFullscreenSuper", new Class[0]);
            this.leaveFullscreenMethod.init(this.bridge, null, "leaveFullscreenSuper", new Class[0]);
            this.pauseTimersMethod.init(this.bridge, null, "pauseTimersSuper", new Class[0]);
            this.resumeTimersMethod.init(this.bridge, null, "resumeTimersSuper", new Class[0]);
            this.onHideMethod.init(this.bridge, null, "onHideSuper", new Class[0]);
            this.onShowMethod.init(this.bridge, null, "onShowSuper", new Class[0]);
            if (XWalkCoreWrapper.getInstance().hasFeature(1)) {
                this.onPauseMethod.init(this.bridge, null, "onPauseSuper", new Class[0]);
                this.onResumeMethod.init(this.bridge, null, "onResumeSuper", new Class[0]);
            }
            this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
            this.startActivityForResultIntentintBundleMethod.init(this.bridge, null, "startActivityForResultSuper", Intent.class, Integer.TYPE, Bundle.class);
            this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", Integer.TYPE, Integer.TYPE, Intent.class);
            this.onNewIntentIntentMethod.init(this.bridge, null, "onNewIntentSuper", Intent.class);
            this.saveStateBundleMethod.init(this.bridge, null, "saveStateSuper", Bundle.class);
            this.restoreStateBundleMethod.init(this.bridge, null, "restoreStateSuper", Bundle.class);
            this.getAPIVersionMethod.init(this.bridge, null, "getAPIVersionSuper", new Class[0]);
            this.getXWalkVersionMethod.init(this.bridge, null, "getXWalkVersionSuper", new Class[0]);
            this.setUIClientXWalkUIClientInternalMethod.init(this.bridge, null, "setUIClientSuper", this.coreWrapper.getBridgeClass("XWalkUIClientBridge"));
            this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.init(this.bridge, null, "setExtendPluginClientSuper", this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge"));
            this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.init(this.bridge, null, "setExtendCanvasClientSuper", this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge"));
            this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.init(this.bridge, null, "setExtendTextAreaClientSuper", this.coreWrapper.getBridgeClass("XWalkExtendTextAreaClientBridge"));
            this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"));
            this.setProxyWebViewClientExtensionInternalMethod.init(this.bridge, null, "setProxyWebViewClientExtensionSuper", this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge"));
            this.setBackgroundColorintMethod.init(this.bridge, null, "setBackgroundColorSuper", Integer.TYPE);
            this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, null, "setOriginAccessWhitelistSuper", String.class, String[].class);
            this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", String.class);
            this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
            this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", String.class);
            this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.init(this.bridge, null, "captureBitmapAsyncSuper", this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge"));
            this.getSettingsMethod.init(this.bridge, null, "getSettingsSuper", new Class[0]);
            this.setNetworkAvailablebooleanMethod.init(this.bridge, null, "setNetworkAvailableSuper", Boolean.TYPE);
            this.getRemoteDebuggingUrlMethod.init(this.bridge, null, "getRemoteDebuggingUrlSuper", new Class[0]);
            this.getScalenMethod.init(this.bridge, null, "getScaleSuper", new Class[0]);
            this.zoomInMethod.init(this.bridge, null, "zoomInSuper", new Class[0]);
            this.zoomOutMethod.init(this.bridge, null, "zoomOutSuper", new Class[0]);
            this.zoomByfloatMethod.init(this.bridge, null, "zoomBySuper", Float.TYPE);
            this.canZoomInMethod.init(this.bridge, null, "canZoomInSuper", new Class[0]);
            this.canZoomOutMethod.init(this.bridge, null, "canZoomOutSuper", new Class[0]);
            this.onCreateInputConnectionEditorInfoMethod.init(this.bridge, null, "onCreateInputConnectionSuper", EditorInfo.class);
            this.setInitialScaleintMethod.init(this.bridge, null, "setInitialScaleSuper", Integer.TYPE);
            this.getFaviconMethod.init(this.bridge, null, "getFaviconSuper", new Class[0]);
            this.setZOrderOnTopbooleanMethod.init(this.bridge, null, "setZOrderOnTopSuper", Boolean.TYPE);
            this.clearFormDataMethod.init(this.bridge, null, "clearFormDataSuper", new Class[0]);
            this.setSurfaceViewVisibilityintMethod.init(this.bridge, null, "setSurfaceViewVisibilitySuper", Integer.TYPE);
            this.setXWalkViewInternalVisibilityintMethod.init(this.bridge, null, "setXWalkViewInternalVisibilitySuper", Integer.TYPE);
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.init(this.bridge, null, "setDownloadListenerSuper", this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge"));
            this.onTouchEventMotionEventMethod.init(this.bridge, null, "onTouchEventSuper", MotionEvent.class);
            this.setOnTouchListenerOnTouchListenerMethod.init(this.bridge, null, "setOnTouchListenerSuper", View.OnTouchListener.class);
            this.smoothScrollintintMethod.init(this.bridge, null, "smoothScrollSuper", Integer.TYPE, Integer.TYPE, Long.TYPE);
            this.scrollTointintMethod.init(this.bridge, null, "scrollToSuper", Integer.TYPE, Integer.TYPE);
            this.scrollByintintMethod.init(this.bridge, null, "scrollBySuper", Integer.TYPE, Integer.TYPE);
            this.computeHorizontalScrollRangeMethod.init(this.bridge, null, "computeHorizontalScrollRangeSuper", new Class[0]);
            this.computeHorizontalScrollOffsetMethod.init(this.bridge, null, "computeHorizontalScrollOffsetSuper", new Class[0]);
            this.computeVerticalScrollRangeMethod.init(this.bridge, null, "computeVerticalScrollRangeSuper", new Class[0]);
            this.computeVerticalScrollOffsetMethod.init(this.bridge, null, "computeVerticalScrollOffsetSuper", new Class[0]);
            this.computeVerticalScrollExtentMethod.init(this.bridge, null, "computeVerticalScrollExtentSuper", new Class[0]);
            this.getExtensionManagerMethod.init(this.bridge, null, "getExtensionManagerSuper", new Class[0]);
            this.clearSslPreferencesMethod.init(this.bridge, null, "clearSslPreferencesSuper", new Class[0]);
            this.clearClientCertPreferencesRunnableMethod.init(this.bridge, null, "clearClientCertPreferencesSuper", Runnable.class);
            this.getCertificateMethod.init(this.bridge, null, "getCertificateSuper", new Class[0]);
            this.setFindListenerXWalkFindListenerInternalMethod.init(this.bridge, null, "setFindListenerSuper", this.coreWrapper.getBridgeClass("XWalkFindListenerBridge"));
            this.findAllAsyncStringMethod.init(this.bridge, null, "findAllAsyncSuper", String.class);
            this.findNextbooleanMethod.init(this.bridge, null, "findNextSuper", Boolean.TYPE);
            this.clearMatchesMethod.init(this.bridge, null, "clearMatchesSuper", new Class[0]);
            this.getCompositingSurfaceTypeMethod.init(this.bridge, null, "getCompositingSurfaceTypeSuper", new Class[0]);
            this.getXWalkContentViewMethod.init(this.bridge, null, "getXWalkContentViewSuper", new Class[0]);
            this.adjustSelectPositionlongStringintintMethod.init(this.bridge, null, "adjustSelectPositionSuper", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
            this.getRefererUrlMethod.init(this.bridge, null, "getRefererUrlSuper", new Class[0]);
            this.isSupportExtendPluginForAppbrandMethod.init(this.bridge, null, "isSupportExtendPluginForAppbrandSuper", new Class[0]);
            this.setVerticalScrollBarEnablebooleanMethod.init(this.bridge, null, "setVerticalScrollBarEnableSuper", Boolean.TYPE);
            this.setHorizontalScrollBarEnablebooleanMethod.init(this.bridge, null, "setHorizontalScrollBarEnableSuper", Boolean.TYPE);
            this.replaceTranslatedStringMethod.init(this.bridge, null, "replaceTranslatedStringSuper", Map.class);
            this.setTranslateModebooleanMethod.init(this.bridge, null, "setTranslateModeSuper", Boolean.TYPE);
            this.getTranslateSampleStringintMethod.init(this.bridge, null, "getTranslateSampleStringSuper", Integer.TYPE);
            this.getImageBitmapToFileMethod.init(this.bridge, null, "getImageBitmapToFileSuper", String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkGetImageBitmapToFileFinishedCallbackBridge"));
            if (XWalkCoreWrapper.getInstance().hasFeature(9)) {
                this.invokeExtensionMethod.init(this.bridge, null, "invokeExtension", Integer.TYPE, Object.class);
            } else {
                this.invokeExtensionMethod = null;
            }
            this.preInitViewSizeMethod.init(this.bridge, null, "preInitViewSizeSuper", Integer.TYPE, Integer.TYPE, Boolean.TYPE);
            AppMethodBeat.o(155156);
        } catch (UnsupportedOperationException e2) {
            AppMethodBeat.o(155156);
        }
    }
}
