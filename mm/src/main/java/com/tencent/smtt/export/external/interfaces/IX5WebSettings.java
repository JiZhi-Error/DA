package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IX5WebSettings {
    public static final int DEFAULT_CACHE_CAPACITY = 15;
    public static final int LOAD_CACHE_AD = 100;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    boolean enableSmoothTransition();

    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkImage();

    boolean getBlockNetworkLoads();

    boolean getBuiltInZoomControls();

    int getCacheMode();

    String getCursiveFontFamily();

    boolean getDatabaseEnabled();

    String getDatabasePath();

    int getDefaultFixedFontSize();

    int getDefaultFontSize();

    String getDefaultTextEncodingName();

    ZoomDensity getDefaultZoom();

    boolean getDisplayZoomControls();

    boolean getDomStorageEnabled();

    String getFantasyFontFamily();

    String getFixedFontFamily();

    boolean getJavaScriptCanOpenWindowsAutomatically();

    boolean getJavaScriptEnabled();

    LayoutAlgorithm getLayoutAlgorithm();

    boolean getLightTouchEnabled();

    boolean getLoadWithOverviewMode();

    boolean getLoadsImagesAutomatically();

    boolean getMediaPlaybackRequiresUserGesture();

    int getMinimumFontSize();

    int getMinimumLogicalFontSize();

    int getMixedContentMode();

    boolean getNavDump();

    PluginState getPluginState();

    boolean getPluginsEnabled();

    String getPluginsPath();

    boolean getSafeBrowsingEnabled();

    String getSansSerifFontFamily();

    boolean getSaveFormData();

    boolean getSavePassword();

    String getSerifFontFamily();

    String getStandardFontFamily();

    TextSize getTextSize();

    int getTextZoom();

    boolean getUseWebViewBackgroundForOverscrollBackground();

    boolean getUseWideViewPort();

    String getUserAgent();

    String getUserAgentString();

    void setAllowContentAccess(boolean z);

    void setAllowFileAccess(boolean z);

    void setAllowFileAccessFromFileURLs(boolean z);

    void setAllowUniversalAccessFromFileURLs(boolean z);

    void setAppCacheEnabled(boolean z);

    void setAppCacheMaxSize(long j2);

    void setAppCachePath(String str);

    void setBlockNetworkImage(boolean z);

    void setBlockNetworkLoads(boolean z);

    void setBuiltInZoomControls(boolean z);

    void setCacheMode(int i2);

    void setCursiveFontFamily(String str);

    void setDatabaseEnabled(boolean z);

    void setDatabasePath(String str);

    void setDefaultDatabasePath(boolean z);

    void setDefaultFixedFontSize(int i2);

    void setDefaultFontSize(int i2);

    void setDefaultTextEncodingName(String str);

    void setDefaultZoom(ZoomDensity zoomDensity);

    void setDisplayZoomControls(boolean z);

    void setDomStorageEnabled(boolean z);

    void setEnableSmoothTransition(boolean z);

    void setFantasyFontFamily(String str);

    void setFixedFontFamily(String str);

    void setGeolocationDatabasePath(String str);

    void setGeolocationEnabled(boolean z);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    void setJavaScriptEnabled(boolean z);

    void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    void setLightTouchEnabled(boolean z);

    void setLoadWithOverviewMode(boolean z);

    void setLoadsImagesAutomatically(boolean z);

    void setMediaPlaybackRequiresUserGesture(boolean z);

    void setMinimumFontSize(int i2);

    void setMinimumLogicalFontSize(int i2);

    void setNavDump(boolean z);

    void setNeedInitialFocus(boolean z);

    void setPluginEnabled(boolean z);

    void setPluginState(PluginState pluginState);

    void setPluginsEnabled(boolean z);

    void setPluginsPath(String str);

    void setRenderPriority(RenderPriority renderPriority);

    void setSafeBrowsingEnabled(boolean z);

    void setSansSerifFontFamily(String str);

    void setSaveFormData(boolean z);

    void setSavePassword(boolean z);

    void setSerifFontFamily(String str);

    void setStandardFontFamily(String str);

    void setSupportMultipleWindows(boolean z);

    void setSupportZoom(boolean z);

    void setTextSize(TextSize textSize);

    void setTextZoom(int i2);

    void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    void setUseWideViewPort(boolean z);

    void setUserAgent(String str);

    void setUserAgent(String str, boolean z);

    void setUserAgentString(String str);

    boolean supportMultipleWindows();

    boolean supportZoom();

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING;

        public static LayoutAlgorithm valueOf(String str) {
            AppMethodBeat.i(53205);
            LayoutAlgorithm layoutAlgorithm = (LayoutAlgorithm) Enum.valueOf(LayoutAlgorithm.class, str);
            AppMethodBeat.o(53205);
            return layoutAlgorithm;
        }

        static {
            AppMethodBeat.i(53206);
            AppMethodBeat.o(53206);
        }
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF;

        public static PluginState valueOf(String str) {
            AppMethodBeat.i(53208);
            PluginState pluginState = (PluginState) Enum.valueOf(PluginState.class, str);
            AppMethodBeat.o(53208);
            return pluginState;
        }

        static {
            AppMethodBeat.i(53209);
            AppMethodBeat.o(53209);
        }
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        public static RenderPriority valueOf(String str) {
            AppMethodBeat.i(53211);
            RenderPriority renderPriority = (RenderPriority) Enum.valueOf(RenderPriority.class, str);
            AppMethodBeat.o(53211);
            return renderPriority;
        }

        static {
            AppMethodBeat.i(53212);
            AppMethodBeat.o(53212);
        }
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        int value;

        public static TextSize valueOf(String str) {
            AppMethodBeat.i(53214);
            TextSize textSize = (TextSize) Enum.valueOf(TextSize.class, str);
            AppMethodBeat.o(53214);
            return textSize;
        }

        static {
            AppMethodBeat.i(53215);
            AppMethodBeat.o(53215);
        }

        private TextSize(int i2) {
            this.value = i2;
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        public static ZoomDensity valueOf(String str) {
            AppMethodBeat.i(53217);
            ZoomDensity zoomDensity = (ZoomDensity) Enum.valueOf(ZoomDensity.class, str);
            AppMethodBeat.o(53217);
            return zoomDensity;
        }

        static {
            AppMethodBeat.i(53218);
            AppMethodBeat.o(53218);
        }

        private ZoomDensity(int i2) {
            this.value = i2;
        }
    }
}
