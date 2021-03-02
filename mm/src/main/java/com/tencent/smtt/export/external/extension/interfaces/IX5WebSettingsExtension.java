package com.tencent.smtt.export.external.extension.interfaces;

import java.util.List;
import java.util.Map;

public interface IX5WebSettingsExtension {
    public static final int PicModel_NORMAL = 1;
    public static final int PicModel_NetNoPic = 3;
    public static final int PicModel_NoPic = 2;

    void customDiskCachePathEnabled(boolean z, String str);

    void enableHSTSIgnore(String str);

    boolean getFeedsReadingEnabled();

    boolean getPageSolarEnableFlag();

    boolean getShowTtsBar();

    boolean getUseWebViewBackgroundForOverscrollBackground();

    boolean getWebTranslation();

    boolean isFitScreen();

    boolean isReadModeWebView();

    boolean isWapSitePreferred();

    boolean isWebViewInBackground();

    boolean isWrapLineLayoutEnabled();

    void setARModeEnable(boolean z);

    void setAcceptCookie(boolean z);

    void setAdditionalHttpHeaders(Map<String, String> map);

    void setAutoDetectToOpenFitScreenEnabled(boolean z);

    void setAutoRecoredAndRestoreScaleEnabled(boolean z);

    void setContentCacheEnable(boolean z);

    void setContentCacheFrameworkEnable(boolean z);

    void setDayOrNight(boolean z);

    void setDiskCahceSize(int i2);

    void setDisplayCutoutEnable(boolean z);

    void setDoNotTrackEnabled(boolean z);

    void setDynamicPageSaveEnabled(boolean z);

    void setEnableUnderLine(boolean z);

    void setFeedsReadingEnabled(boolean z);

    void setFingerSearchEnable(boolean z);

    void setFirstScreenDetect(boolean z);

    void setFirstScreenSoftwareTextureDraw(boolean z);

    void setFitScreen(boolean z);

    void setForcePinchScaleEnabled(boolean z);

    void setFramePerformanceRecordEnable(boolean z);

    void setGifControl(boolean z);

    boolean setHttpDnsDomains(List<String> list);

    void setImageScanEnable(boolean z);

    void setImgAsDownloadFile(boolean z);

    void setImgBrowser(boolean z);

    void setIsViewSourceMode(boolean z);

    void setJSPerformanceRecordEnable(boolean z);

    void setJavaScriptOpenWindowsBlockedNotifyEnabled(boolean z);

    void setMSEEnable(boolean z);

    void setOnContextMenuEnable(boolean z);

    void setOnlyDomTreeBuild(boolean z);

    void setPageCacheCapacity(int i2);

    void setPageSolarEnableFlag(boolean z);

    void setPicModel(int i2);

    void setPreFectch(boolean z);

    void setPreFectchEnableWhenHasMedia(boolean z);

    void setReadModeWebView(boolean z);

    void setRecordRequestEnabled(boolean z);

    void setRememberScaleValue(boolean z);

    void setSelectionColorEnabled(boolean z);

    void setShouldRequestFavicon(boolean z);

    void setShouldTrackVisitedLinks(boolean z);

    void setShowTtsBarEnable(boolean z);

    void setSmartFullScreenEnabled(boolean z);

    void setTbsARShareType(int i2);

    void setTextDecorationUnlineEnabled(boolean z);

    void setUseQProxy(boolean z);

    void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    void setVrImageEnable(boolean z);

    void setWapSitePreferred(boolean z);

    void setWebTranslationEnabled(boolean z);

    void setWebViewInBackground(boolean z);

    void setWrapLineLayoutEnabled(boolean z);
}
