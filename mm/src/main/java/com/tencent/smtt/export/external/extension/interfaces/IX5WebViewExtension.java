package com.tencent.smtt.export.external.extension.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import com.tencent.smtt.export.external.interfaces.IX5ScrollListener;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardListClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IX5WebViewExtension {
    public static final int HANDLEVIEW_ALIGNMENT_CENTER = 1;
    public static final int HANDLEVIEW_ALIGNMENT_RIGHT = 2;
    public static final int HANDLEVIEW_POSITION_CENTER = 1;
    public static final int HANDLEVIEW_POSITION_RIGHT = 2;
    public static final int HANLDEVIEW_ALIGNMENT_LEFT = 0;
    public static final int HANLDEVIEW_POSITION_LEFT = 0;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int RENDER_MODE_DEFAULT = 0;
    public static final int RENDER_MODE_SMOOTHNESS_AGGRESSIVE = 2;
    public static final int RENDER_MODE_SMOOTHNESS_NORMAL = 1;
    public static final int USER_SETTINGS_COPY = 16;
    public static final int USER_SETTINGS_OPEN_IN_BROWSER = 32;
    public static final int USER_SETTINGS_SEARCH = 1;
    public static final int USER_SETTINGS_TRANSLATE = 8;

    void active();

    void canEnterReadMode(ValueCallback<Boolean> valueCallback);

    void cancelLongPress();

    boolean capturePageToFile(Bitmap.Config config, String str, boolean z, int i2, int i3);

    void clearMemoryCache();

    void clearServiceWorkerCache();

    void clearTextEntry();

    void clearTextFieldLongPressStatus();

    void copyText();

    void cutText(CharSequence charSequence);

    void deactive();

    void discardCurrentHiddenPage();

    void doFingerSearchIfNeed();

    void doTranslateAction(int i2);

    void documentAsText(Message message);

    void documentDumpRenderTree(Message message);

    boolean drawPreReadBaseLayer(Canvas canvas, boolean z);

    void dumpDisplayTree();

    void dumpViewportForLayoutTest(Message message);

    void enterReadMode(ValueCallback<Boolean> valueCallback, Runnable runnable);

    void enterSelectionMode(boolean z);

    void enterSelectionModeWaitFS(boolean z);

    void exitPluginFullScreen();

    void exitReadMode();

    void focusAndPopupIM(String str);

    void focusTtsNode(int i2);

    void focusTtsNode(int i2, boolean z);

    void forceSyncOffsetToCore();

    ArrayList<IX5WebViewBase.ImageInfo> getAllImageInfo();

    Bitmap getBitmapByIndex(int i2);

    int getCurrentHistoryItemIndex();

    String getDocumentOuterHTML();

    boolean getDrawWithBuffer();

    void getFakeLoginStatus(Bundle bundle, ValueCallback<Bundle> valueCallback);

    String getFocusCandidateText();

    int getGoBackOrForwardToDesiredSteps(int i2);

    IX5WebHistoryItem getHistoryItem(int i2);

    String getMiniProgramPkgName();

    int getQQBrowserVersion();

    int getScrollX();

    int getScrollY();

    Bundle getSdkQBStatisticsInfo();

    String getSelectionText();

    IX5WebSettingsExtension getSettingsExtension();

    int getSharedVideoTime();

    Point getSinglePressPoint();

    int getSniffVideoID();

    String getSniffVideoRefer();

    boolean getSolarMode();

    int getTitleHeight();

    void getTtsTextAsync(int i2);

    List<String> getUserSelectedHiddenDomains();

    IX5WebChromeClient getWebChromeClient();

    IX5WebChromeClientExtension getWebChromeClientExtension();

    int getWebTextScrollDis();

    IX5WebViewClient getWebViewClient();

    IX5WebViewClientExtension getWebViewClientExtension();

    void hideUserSelectedElement();

    boolean inFullScreenMode();

    boolean inputNodeIsPasswordType();

    boolean inputNodeIsPhoneType();

    void invalidateContent();

    Object invokeMiscMethod(String str, Bundle bundle);

    boolean isActive();

    boolean isEditingMode();

    boolean isEnableSetFont();

    boolean isHorizontalScrollBarEnabled();

    boolean isMobileSite();

    boolean isOverScrollEnable();

    boolean isPluginFullScreen();

    boolean isPreReadCanGoForward();

    boolean isSelectionMode();

    boolean isVerticalScrollBarEnabled();

    boolean isX5CoreSandboxMode();

    void leaveSelectionMode();

    void loadDataWithBaseURLWithHeaders(String str, String str2, String str3, String str4, String str5, Map<String, String> map);

    void loadUrl(String str, Map<String, String> map, boolean z);

    void loaddataWithHeaders(String str, String str2, String str3, Map<String, String> map);

    boolean needSniff();

    void notifyMemoryPressure(int i2);

    void onAppExit();

    void onFingerSearchResult(String str, int i2, int i3);

    void onPageTransFormationSettingChanged(boolean z);

    void onPauseActiveDomObject();

    void onPauseNativeVideo();

    void onResumeActiveDomObject();

    void pasteText(CharSequence charSequence);

    void pauseAudio();

    void playAudio();

    void preConnectQProxy();

    void preLoad(String str, int i2, int i3, Map<String, String> map);

    void pruneMemoryCache();

    void registerServiceWorkerBackground(String str, String str2);

    void registerServiceWorkerOffline(String str, List<String> list, boolean z);

    void reloadCustomMetaData();

    void removeHistoryItem(int i2);

    void removeUserSelectedAdInfoByDomain(String str);

    void replaceAllInputText(String str);

    void replyListBox(int i2);

    void replyMultiListBox(int i2, boolean[] zArr);

    boolean requestFocusForInputNode(int i2);

    void retrieveFingerSearchContext(int i2);

    void saveDynamicPageToDisk(String str, Message message);

    void savePageToDisk(String str, Message message);

    void savePageToDisk(String str, Boolean bool, Message message);

    void savePageToDisk(String str, boolean z, int i2, ValueCallback<String> valueCallback);

    void scrollBy(int i2, int i3);

    void scrollTo(int i2, int i3);

    int seletionStatus();

    void sendNeverRememberMsg(String str, String str2, String str3, Message message);

    void sendRememberMsg(String str, String str2, String str3, Message message);

    void sendRememberMsg(String str, String str2, String str3, String str4, String str5);

    void sendResumeMsg(String str, String str2, String str3, Message message);

    void setAudioAutoPlayNotify(boolean z);

    void setBackFromSystem();

    void setDisableDrawingWhileLosingFocus(boolean z);

    void setDrawWithBuffer(boolean z);

    void setEmbTitleView(View view, ViewGroup.LayoutParams layoutParams);

    void setEnableAutoPageDiscarding(boolean z);

    void setEnableAutoPageRestoration(boolean z);

    void setEntryDataForSearchTeam(String str);

    void setFakeLoginParams(Bundle bundle);

    void setForceEnableZoom(boolean z);

    void setHandleViewBitmap(Bitmap bitmap, Bitmap bitmap2, int i2, int i3);

    void setHandleViewLineColor(int i2, int i3);

    void setHandleViewLineIsShowing(boolean z, int i2);

    void setHandleViewSelectionColor(int i2, int i3);

    void setHorizontalScrollBarDrawable(Drawable drawable);

    void setHorizontalScrollBarEnabled(boolean z);

    void setHorizontalTrackDrawable(Drawable drawable);

    void setIsForVideoSniff(boolean z);

    void setLongPressTextExtensionMenu(int i2);

    void setMiniProgramPkgName(String str);

    void setOrientation(int i2);

    void setOverScrollEnable(boolean z);

    void setOverScrollParams(int i2, int i3, int i4, int i5, int i6, int i7, Drawable drawable, Drawable drawable2, Drawable drawable3);

    void setRenderMode(int i2);

    void setScreenState(int i2);

    void setScrollBarDefaultDelayBeforeFade(int i2);

    void setScrollBarFadeDuration(int i2);

    void setScrollBarFadingEnabled(boolean z);

    void setScrollBarSize(int i2);

    void setScrollListener(IX5ScrollListener iX5ScrollListener);

    void setSelectListener(ISelectionInterface iSelectionInterface);

    void setSharedVideoTime(int i2);

    void setSiteSecurityInfo(String str, String str2);

    void setSkvDataForSearchTeam(String str);

    void setSniffVideoInfo(String str, int i2, String str2, String str3);

    void setTextFieldInLongPressStatus(boolean z);

    void setVerticalScrollBarDrawable(Drawable drawable);

    void setVerticalScrollBarEnabled(boolean z);

    void setVerticalTrackDrawable(Drawable drawable);

    void setWebBackForwardListClient(IX5WebBackForwardListClient iX5WebBackForwardListClient);

    void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension);

    void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension);

    boolean shouldFitScreenLayout();

    boolean shouldPopupHideAdDialog(String str);

    void showImage(int i2, int i3);

    Drawable snapshot(int i2, boolean z);

    void snapshotVisible(Bitmap bitmap, boolean z, boolean z2, boolean z3, boolean z4, float f2, float f3, Runnable runnable);

    void snapshotVisible(Canvas canvas, boolean z, boolean z2, boolean z3, boolean z4);

    void snapshotWholePage(Canvas canvas, boolean z, boolean z2);

    void snapshotWholePage(Canvas canvas, boolean z, boolean z2, Runnable runnable);

    void stopPreLoad(String str);

    void trimMemory(int i2);

    void unRegisterServiceWorker(String str, boolean z);

    void updateContext(Context context);

    void updateImageList(int i2, int i3, boolean z);

    void updateImageList2(int i2, int i3, boolean z, ValueCallback<Integer> valueCallback);

    void updateSelectionPosition();

    void updateServiceWorkerBackground(String str);

    void waitSWInstalled(String str, Message message);

    @Deprecated
    Drawable wrapDrawableWithNativeBitmap(Drawable drawable, int i2, Bitmap.Config config);
}
