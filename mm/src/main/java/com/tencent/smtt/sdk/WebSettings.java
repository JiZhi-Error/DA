package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.utils.k;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    /* renamed from: a  reason: collision with root package name */
    private IX5WebSettings f1907a;

    /* renamed from: b  reason: collision with root package name */
    private android.webkit.WebSettings f1908b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1909c;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS;

        public static LayoutAlgorithm valueOf(String str) {
            AppMethodBeat.i(55043);
            LayoutAlgorithm layoutAlgorithm = (LayoutAlgorithm) Enum.valueOf(LayoutAlgorithm.class, str);
            AppMethodBeat.o(55043);
            return layoutAlgorithm;
        }

        static {
            AppMethodBeat.i(55044);
            AppMethodBeat.o(55044);
        }
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF;

        public static PluginState valueOf(String str) {
            AppMethodBeat.i(55187);
            PluginState pluginState = (PluginState) Enum.valueOf(PluginState.class, str);
            AppMethodBeat.o(55187);
            return pluginState;
        }

        static {
            AppMethodBeat.i(55188);
            AppMethodBeat.o(55188);
        }
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        public static RenderPriority valueOf(String str) {
            AppMethodBeat.i(54365);
            RenderPriority renderPriority = (RenderPriority) Enum.valueOf(RenderPriority.class, str);
            AppMethodBeat.o(54365);
            return renderPriority;
        }

        static {
            AppMethodBeat.i(54366);
            AppMethodBeat.o(54366);
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
            AppMethodBeat.i(55359);
            TextSize textSize = (TextSize) Enum.valueOf(TextSize.class, str);
            AppMethodBeat.o(55359);
            return textSize;
        }

        static {
            AppMethodBeat.i(55360);
            AppMethodBeat.o(55360);
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
            AppMethodBeat.i(54627);
            ZoomDensity zoomDensity = (ZoomDensity) Enum.valueOf(ZoomDensity.class, str);
            AppMethodBeat.o(54627);
            return zoomDensity;
        }

        static {
            AppMethodBeat.i(54628);
            AppMethodBeat.o(54628);
        }

        private ZoomDensity(int i2) {
            this.value = i2;
        }
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.f1907a = null;
        this.f1908b = null;
        this.f1909c = false;
        this.f1907a = iX5WebSettings;
        this.f1908b = null;
        this.f1909c = true;
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.f1907a = null;
        this.f1908b = null;
        this.f1909c = false;
        this.f1907a = null;
        this.f1908b = webSettings;
        this.f1909c = false;
    }

    public void setNavDump(boolean z) {
        AppMethodBeat.i(54388);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setNavDump(z);
            AppMethodBeat.o(54388);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54388);
        } else {
            k.a(this.f1908b, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54388);
        }
    }

    public synchronized int getMixedContentMode() {
        int intValue;
        AppMethodBeat.i(54389);
        if (this.f1909c && this.f1907a != null) {
            try {
                intValue = this.f1907a.getMixedContentMode();
                AppMethodBeat.o(54389);
            } catch (Throwable th) {
                AppMethodBeat.o(54389);
                intValue = -1;
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54389);
            intValue = -1;
        } else {
            Object a2 = k.a(this.f1908b, "getMixedContentMode", new Class[0], new Object[0]);
            if (a2 == null) {
                AppMethodBeat.o(54389);
                intValue = -1;
            } else {
                intValue = ((Integer) a2).intValue();
                AppMethodBeat.o(54389);
            }
        }
        return intValue;
    }

    public boolean getNavDump() {
        AppMethodBeat.i(54390);
        if (this.f1909c && this.f1907a != null) {
            boolean navDump = this.f1907a.getNavDump();
            AppMethodBeat.o(54390);
            return navDump;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54390);
            return false;
        } else {
            Object a2 = k.a(this.f1908b, "getNavDump");
            if (a2 == null) {
                AppMethodBeat.o(54390);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54390);
            return booleanValue;
        }
    }

    public void setSupportZoom(boolean z) {
        AppMethodBeat.i(54391);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setSupportZoom(z);
            AppMethodBeat.o(54391);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54391);
        } else {
            this.f1908b.setSupportZoom(z);
            AppMethodBeat.o(54391);
        }
    }

    public boolean supportZoom() {
        AppMethodBeat.i(54392);
        if (this.f1909c && this.f1907a != null) {
            boolean supportZoom = this.f1907a.supportZoom();
            AppMethodBeat.o(54392);
            return supportZoom;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54392);
            return false;
        } else {
            boolean supportZoom2 = this.f1908b.supportZoom();
            AppMethodBeat.o(54392);
            return supportZoom2;
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(54393);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setBuiltInZoomControls(z);
            AppMethodBeat.o(54393);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54393);
        } else {
            this.f1908b.setBuiltInZoomControls(z);
            AppMethodBeat.o(54393);
        }
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        AppMethodBeat.i(54394);
        if (this.f1909c && this.f1907a != null) {
            boolean builtInZoomControls = this.f1907a.getBuiltInZoomControls();
            AppMethodBeat.o(54394);
            return builtInZoomControls;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54394);
            return false;
        } else {
            boolean builtInZoomControls2 = this.f1908b.getBuiltInZoomControls();
            AppMethodBeat.o(54394);
            return builtInZoomControls2;
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        AppMethodBeat.i(54395);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDisplayZoomControls(z);
            AppMethodBeat.o(54395);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54395);
        } else if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(54395);
        } else {
            k.a(this.f1908b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54395);
        }
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        AppMethodBeat.i(54396);
        if (this.f1909c && this.f1907a != null) {
            boolean displayZoomControls = this.f1907a.getDisplayZoomControls();
            AppMethodBeat.o(54396);
            return displayZoomControls;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54396);
            return false;
        } else if (Build.VERSION.SDK_INT >= 11) {
            Object a2 = k.a(this.f1908b, "getDisplayZoomControls");
            if (a2 == null) {
                AppMethodBeat.o(54396);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54396);
            return booleanValue;
        } else {
            AppMethodBeat.o(54396);
            return false;
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        AppMethodBeat.i(54397);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAllowFileAccess(z);
            AppMethodBeat.o(54397);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54397);
        } else {
            this.f1908b.setAllowFileAccess(z);
            AppMethodBeat.o(54397);
        }
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        AppMethodBeat.i(54398);
        if (this.f1909c && this.f1907a != null) {
            boolean allowFileAccess = this.f1907a.getAllowFileAccess();
            AppMethodBeat.o(54398);
            return allowFileAccess;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54398);
            return false;
        } else {
            boolean allowFileAccess2 = this.f1908b.getAllowFileAccess();
            AppMethodBeat.o(54398);
            return allowFileAccess2;
        }
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        AppMethodBeat.i(54399);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAllowContentAccess(z);
            AppMethodBeat.o(54399);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54399);
        } else if (Build.VERSION.SDK_INT < 11) {
            AppMethodBeat.o(54399);
        } else {
            k.a(this.f1908b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54399);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i2) {
        AppMethodBeat.i(54400);
        if (this.f1909c && this.f1907a != null) {
            AppMethodBeat.o(54400);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54400);
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54400);
        } else {
            k.a(this.f1908b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
            AppMethodBeat.o(54400);
        }
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        AppMethodBeat.i(54401);
        if (this.f1909c && this.f1907a != null) {
            boolean allowContentAccess = this.f1907a.getAllowContentAccess();
            AppMethodBeat.o(54401);
            return allowContentAccess;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54401);
            return false;
        } else if (Build.VERSION.SDK_INT >= 11) {
            Object a2 = k.a(this.f1908b, "getAllowContentAccess");
            if (a2 == null) {
                AppMethodBeat.o(54401);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54401);
            return booleanValue;
        } else {
            AppMethodBeat.o(54401);
            return false;
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(54402);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setLoadWithOverviewMode(z);
            AppMethodBeat.o(54402);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54402);
        } else {
            this.f1908b.setLoadWithOverviewMode(z);
            AppMethodBeat.o(54402);
        }
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        AppMethodBeat.i(54403);
        if (this.f1909c && this.f1907a != null) {
            boolean loadWithOverviewMode = this.f1907a.getLoadWithOverviewMode();
            AppMethodBeat.o(54403);
            return loadWithOverviewMode;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54403);
            return false;
        } else {
            boolean loadWithOverviewMode2 = this.f1908b.getLoadWithOverviewMode();
            AppMethodBeat.o(54403);
            return loadWithOverviewMode2;
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        AppMethodBeat.i(54404);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setEnableSmoothTransition(z);
            AppMethodBeat.o(54404);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54404);
        } else if (Build.VERSION.SDK_INT >= 11) {
            k.a(this.f1908b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54404);
        } else {
            AppMethodBeat.o(54404);
        }
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        AppMethodBeat.i(54405);
        if (this.f1909c && this.f1907a != null) {
            boolean enableSmoothTransition = this.f1907a.enableSmoothTransition();
            AppMethodBeat.o(54405);
            return enableSmoothTransition;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54405);
            return false;
        } else if (Build.VERSION.SDK_INT >= 11) {
            Object a2 = k.a(this.f1908b, "enableSmoothTransition");
            if (a2 == null) {
                AppMethodBeat.o(54405);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54405);
            return booleanValue;
        } else {
            AppMethodBeat.o(54405);
            return false;
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        AppMethodBeat.i(54406);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setUseWebViewBackgroundForOverscrollBackground(z);
            AppMethodBeat.o(54406);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54406);
        } else {
            k.a(this.f1908b, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54406);
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        AppMethodBeat.i(54407);
        if (this.f1909c && this.f1907a != null) {
            boolean useWebViewBackgroundForOverscrollBackground = this.f1907a.getUseWebViewBackgroundForOverscrollBackground();
            AppMethodBeat.o(54407);
            return useWebViewBackgroundForOverscrollBackground;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54407);
            return false;
        } else {
            Object a2 = k.a(this.f1908b, "getUseWebViewBackgroundForOverscrollBackground");
            if (a2 == null) {
                AppMethodBeat.o(54407);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54407);
            return booleanValue;
        }
    }

    public void setSaveFormData(boolean z) {
        AppMethodBeat.i(54408);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setSaveFormData(z);
            }
            AppMethodBeat.o(54408);
            return;
        }
        this.f1907a.setSaveFormData(z);
        AppMethodBeat.o(54408);
    }

    public boolean getSaveFormData() {
        AppMethodBeat.i(54409);
        if (this.f1909c && this.f1907a != null) {
            boolean saveFormData = this.f1907a.getSaveFormData();
            AppMethodBeat.o(54409);
            return saveFormData;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54409);
            return false;
        } else {
            boolean saveFormData2 = this.f1908b.getSaveFormData();
            AppMethodBeat.o(54409);
            return saveFormData2;
        }
    }

    public void setSavePassword(boolean z) {
        AppMethodBeat.i(54410);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setSavePassword(z);
            }
            AppMethodBeat.o(54410);
            return;
        }
        this.f1907a.setSavePassword(z);
        AppMethodBeat.o(54410);
    }

    public boolean getSavePassword() {
        AppMethodBeat.i(54411);
        if (this.f1909c && this.f1907a != null) {
            boolean savePassword = this.f1907a.getSavePassword();
            AppMethodBeat.o(54411);
            return savePassword;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54411);
            return false;
        } else {
            boolean savePassword2 = this.f1908b.getSavePassword();
            AppMethodBeat.o(54411);
            return savePassword2;
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i2) {
        AppMethodBeat.i(54412);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                if (Build.VERSION.SDK_INT < 14) {
                    AppMethodBeat.o(54412);
                } else {
                    try {
                        this.f1908b.setTextZoom(i2);
                        AppMethodBeat.o(54412);
                    } catch (Exception e2) {
                        k.a(this.f1908b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
                    }
                }
            }
            AppMethodBeat.o(54412);
        } else {
            this.f1907a.setTextZoom(i2);
            AppMethodBeat.o(54412);
        }
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        int i2;
        AppMethodBeat.i(54413);
        if (this.f1909c && this.f1907a != null) {
            i2 = this.f1907a.getTextZoom();
            AppMethodBeat.o(54413);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54413);
            i2 = 0;
        } else if (Build.VERSION.SDK_INT < 14) {
            AppMethodBeat.o(54413);
            i2 = 0;
        } else {
            try {
                i2 = this.f1908b.getTextZoom();
                AppMethodBeat.o(54413);
            } catch (Exception e2) {
                Object a2 = k.a(this.f1908b, "getTextZoom");
                if (a2 == null) {
                    AppMethodBeat.o(54413);
                    i2 = 0;
                } else {
                    i2 = ((Integer) a2).intValue();
                    AppMethodBeat.o(54413);
                }
            }
        }
        return i2;
    }

    public void setTextSize(TextSize textSize) {
        AppMethodBeat.i(54414);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
            }
            AppMethodBeat.o(54414);
            return;
        }
        this.f1907a.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        AppMethodBeat.o(54414);
    }

    public TextSize getTextSize() {
        AppMethodBeat.i(54415);
        if (this.f1909c && this.f1907a != null) {
            TextSize valueOf = TextSize.valueOf(this.f1907a.getTextSize().name());
            AppMethodBeat.o(54415);
            return valueOf;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54415);
            return null;
        } else {
            TextSize valueOf2 = TextSize.valueOf(this.f1908b.getTextSize().name());
            AppMethodBeat.o(54415);
            return valueOf2;
        }
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        AppMethodBeat.i(54416);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            AppMethodBeat.o(54416);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54416);
        } else {
            this.f1908b.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            AppMethodBeat.o(54416);
        }
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        AppMethodBeat.i(54417);
        if (this.f1909c && this.f1907a != null) {
            ZoomDensity valueOf = ZoomDensity.valueOf(this.f1907a.getDefaultZoom().name());
            AppMethodBeat.o(54417);
            return valueOf;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54417);
            return null;
        } else {
            ZoomDensity valueOf2 = ZoomDensity.valueOf(this.f1908b.getDefaultZoom().name());
            AppMethodBeat.o(54417);
            return valueOf2;
        }
    }

    public void setLightTouchEnabled(boolean z) {
        AppMethodBeat.i(54418);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setLightTouchEnabled(z);
            AppMethodBeat.o(54418);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54418);
        } else {
            this.f1908b.setLightTouchEnabled(z);
            AppMethodBeat.o(54418);
        }
    }

    public boolean getLightTouchEnabled() {
        AppMethodBeat.i(54419);
        if (this.f1909c && this.f1907a != null) {
            boolean lightTouchEnabled = this.f1907a.getLightTouchEnabled();
            AppMethodBeat.o(54419);
            return lightTouchEnabled;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54419);
            return false;
        } else {
            boolean lightTouchEnabled2 = this.f1908b.getLightTouchEnabled();
            AppMethodBeat.o(54419);
            return lightTouchEnabled2;
        }
    }

    public void setUserAgent(String str) {
        AppMethodBeat.i(54420);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setUserAgentString(str);
            }
            AppMethodBeat.o(54420);
            return;
        }
        this.f1907a.setUserAgent(str);
        AppMethodBeat.o(54420);
    }

    @TargetApi(3)
    public String getUserAgentString() {
        AppMethodBeat.i(54421);
        if (this.f1909c && this.f1907a != null) {
            String userAgentString = this.f1907a.getUserAgentString();
            AppMethodBeat.o(54421);
            return userAgentString;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54421);
            return "";
        } else {
            String userAgentString2 = this.f1908b.getUserAgentString();
            AppMethodBeat.o(54421);
            return userAgentString2;
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        AppMethodBeat.i(54422);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setUserAgentString(str);
            }
            AppMethodBeat.o(54422);
            return;
        }
        this.f1907a.setUserAgentString(str);
        AppMethodBeat.o(54422);
    }

    public void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(54423);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setUseWideViewPort(z);
            }
            AppMethodBeat.o(54423);
            return;
        }
        this.f1907a.setUseWideViewPort(z);
        AppMethodBeat.o(54423);
    }

    public synchronized boolean getUseWideViewPort() {
        boolean z;
        AppMethodBeat.i(54424);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getUseWideViewPort();
            AppMethodBeat.o(54424);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54424);
        } else {
            z = this.f1908b.getUseWideViewPort();
            AppMethodBeat.o(54424);
        }
        return z;
    }

    public void setSupportMultipleWindows(boolean z) {
        AppMethodBeat.i(54425);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setSupportMultipleWindows(z);
            AppMethodBeat.o(54425);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54425);
        } else {
            this.f1908b.setSupportMultipleWindows(z);
            AppMethodBeat.o(54425);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        boolean z;
        AppMethodBeat.i(54426);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.supportMultipleWindows();
            AppMethodBeat.o(54426);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54426);
        } else {
            z = this.f1908b.supportMultipleWindows();
            AppMethodBeat.o(54426);
        }
        return z;
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(54427);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
            }
            AppMethodBeat.o(54427);
            return;
        }
        this.f1907a.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        AppMethodBeat.o(54427);
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm layoutAlgorithm;
        AppMethodBeat.i(54428);
        if (this.f1909c && this.f1907a != null) {
            layoutAlgorithm = LayoutAlgorithm.valueOf(this.f1907a.getLayoutAlgorithm().name());
            AppMethodBeat.o(54428);
        } else if (this.f1909c || this.f1908b == null) {
            layoutAlgorithm = null;
            AppMethodBeat.o(54428);
        } else {
            layoutAlgorithm = LayoutAlgorithm.valueOf(this.f1908b.getLayoutAlgorithm().name());
            AppMethodBeat.o(54428);
        }
        return layoutAlgorithm;
    }

    public synchronized void setStandardFontFamily(String str) {
        AppMethodBeat.i(54429);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setStandardFontFamily(str);
            AppMethodBeat.o(54429);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54429);
        } else {
            this.f1908b.setStandardFontFamily(str);
            AppMethodBeat.o(54429);
        }
    }

    public synchronized String getStandardFontFamily() {
        String str;
        AppMethodBeat.i(54430);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getStandardFontFamily();
            AppMethodBeat.o(54430);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54430);
        } else {
            str = this.f1908b.getStandardFontFamily();
            AppMethodBeat.o(54430);
        }
        return str;
    }

    public synchronized void setFixedFontFamily(String str) {
        AppMethodBeat.i(54431);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setFixedFontFamily(str);
            AppMethodBeat.o(54431);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54431);
        } else {
            this.f1908b.setFixedFontFamily(str);
            AppMethodBeat.o(54431);
        }
    }

    public synchronized String getFixedFontFamily() {
        String str;
        AppMethodBeat.i(54432);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getFixedFontFamily();
            AppMethodBeat.o(54432);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54432);
        } else {
            str = this.f1908b.getFixedFontFamily();
            AppMethodBeat.o(54432);
        }
        return str;
    }

    public synchronized void setSansSerifFontFamily(String str) {
        AppMethodBeat.i(54433);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setSansSerifFontFamily(str);
            AppMethodBeat.o(54433);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54433);
        } else {
            this.f1908b.setSansSerifFontFamily(str);
            AppMethodBeat.o(54433);
        }
    }

    public synchronized String getSansSerifFontFamily() {
        String str;
        AppMethodBeat.i(54434);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getSansSerifFontFamily();
            AppMethodBeat.o(54434);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54434);
        } else {
            str = this.f1908b.getSansSerifFontFamily();
            AppMethodBeat.o(54434);
        }
        return str;
    }

    public synchronized void setSerifFontFamily(String str) {
        AppMethodBeat.i(54435);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setSerifFontFamily(str);
            AppMethodBeat.o(54435);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54435);
        } else {
            this.f1908b.setSerifFontFamily(str);
            AppMethodBeat.o(54435);
        }
    }

    public synchronized String getSerifFontFamily() {
        String str;
        AppMethodBeat.i(54436);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getSerifFontFamily();
            AppMethodBeat.o(54436);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54436);
        } else {
            str = this.f1908b.getSerifFontFamily();
            AppMethodBeat.o(54436);
        }
        return str;
    }

    public synchronized void setCursiveFontFamily(String str) {
        AppMethodBeat.i(54437);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setCursiveFontFamily(str);
            AppMethodBeat.o(54437);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54437);
        } else {
            this.f1908b.setCursiveFontFamily(str);
            AppMethodBeat.o(54437);
        }
    }

    public synchronized String getCursiveFontFamily() {
        String str;
        AppMethodBeat.i(54438);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getCursiveFontFamily();
            AppMethodBeat.o(54438);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54438);
        } else {
            str = this.f1908b.getCursiveFontFamily();
            AppMethodBeat.o(54438);
        }
        return str;
    }

    public synchronized void setFantasyFontFamily(String str) {
        AppMethodBeat.i(54439);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setFantasyFontFamily(str);
            AppMethodBeat.o(54439);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54439);
        } else {
            this.f1908b.setFantasyFontFamily(str);
            AppMethodBeat.o(54439);
        }
    }

    public synchronized String getFantasyFontFamily() {
        String str;
        AppMethodBeat.i(54440);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getFantasyFontFamily();
            AppMethodBeat.o(54440);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54440);
        } else {
            str = this.f1908b.getFantasyFontFamily();
            AppMethodBeat.o(54440);
        }
        return str;
    }

    public synchronized void setMinimumFontSize(int i2) {
        AppMethodBeat.i(54441);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setMinimumFontSize(i2);
            AppMethodBeat.o(54441);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54441);
        } else {
            this.f1908b.setMinimumFontSize(i2);
            AppMethodBeat.o(54441);
        }
    }

    public synchronized int getMinimumFontSize() {
        int i2;
        AppMethodBeat.i(54442);
        if (this.f1909c && this.f1907a != null) {
            i2 = this.f1907a.getMinimumFontSize();
            AppMethodBeat.o(54442);
        } else if (this.f1909c || this.f1908b == null) {
            i2 = 0;
            AppMethodBeat.o(54442);
        } else {
            i2 = this.f1908b.getMinimumFontSize();
            AppMethodBeat.o(54442);
        }
        return i2;
    }

    public synchronized void setMinimumLogicalFontSize(int i2) {
        AppMethodBeat.i(54443);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setMinimumLogicalFontSize(i2);
            AppMethodBeat.o(54443);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54443);
        } else {
            this.f1908b.setMinimumLogicalFontSize(i2);
            AppMethodBeat.o(54443);
        }
    }

    public synchronized int getMinimumLogicalFontSize() {
        int i2;
        AppMethodBeat.i(54444);
        if (this.f1909c && this.f1907a != null) {
            i2 = this.f1907a.getMinimumLogicalFontSize();
            AppMethodBeat.o(54444);
        } else if (this.f1909c || this.f1908b == null) {
            i2 = 0;
            AppMethodBeat.o(54444);
        } else {
            i2 = this.f1908b.getMinimumLogicalFontSize();
            AppMethodBeat.o(54444);
        }
        return i2;
    }

    public synchronized void setDefaultFontSize(int i2) {
        AppMethodBeat.i(54445);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDefaultFontSize(i2);
            AppMethodBeat.o(54445);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54445);
        } else {
            this.f1908b.setDefaultFontSize(i2);
            AppMethodBeat.o(54445);
        }
    }

    public synchronized int getDefaultFontSize() {
        int i2;
        AppMethodBeat.i(54446);
        if (this.f1909c && this.f1907a != null) {
            i2 = this.f1907a.getDefaultFontSize();
            AppMethodBeat.o(54446);
        } else if (this.f1909c || this.f1908b == null) {
            i2 = 0;
            AppMethodBeat.o(54446);
        } else {
            i2 = this.f1908b.getDefaultFontSize();
            AppMethodBeat.o(54446);
        }
        return i2;
    }

    public synchronized void setDefaultFixedFontSize(int i2) {
        AppMethodBeat.i(54447);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDefaultFixedFontSize(i2);
            AppMethodBeat.o(54447);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54447);
        } else {
            this.f1908b.setDefaultFixedFontSize(i2);
            AppMethodBeat.o(54447);
        }
    }

    public synchronized int getDefaultFixedFontSize() {
        int i2;
        AppMethodBeat.i(54448);
        if (this.f1909c && this.f1907a != null) {
            i2 = this.f1907a.getDefaultFixedFontSize();
            AppMethodBeat.o(54448);
        } else if (this.f1909c || this.f1908b == null) {
            i2 = 0;
            AppMethodBeat.o(54448);
        } else {
            i2 = this.f1908b.getDefaultFixedFontSize();
            AppMethodBeat.o(54448);
        }
        return i2;
    }

    public void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(54449);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setLoadsImagesAutomatically(z);
            AppMethodBeat.o(54449);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54449);
        } else {
            this.f1908b.setLoadsImagesAutomatically(z);
            AppMethodBeat.o(54449);
        }
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        boolean z;
        AppMethodBeat.i(54450);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getLoadsImagesAutomatically();
            AppMethodBeat.o(54450);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54450);
        } else {
            z = this.f1908b.getLoadsImagesAutomatically();
            AppMethodBeat.o(54450);
        }
        return z;
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(54451);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setBlockNetworkImage(z);
            AppMethodBeat.o(54451);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54451);
        } else {
            this.f1908b.setBlockNetworkImage(z);
            AppMethodBeat.o(54451);
        }
    }

    public synchronized boolean getBlockNetworkImage() {
        boolean z;
        AppMethodBeat.i(54452);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getBlockNetworkImage();
            AppMethodBeat.o(54452);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54452);
        } else {
            z = this.f1908b.getBlockNetworkImage();
            AppMethodBeat.o(54452);
        }
        return z;
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        AppMethodBeat.i(54453);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setBlockNetworkLoads(z);
            AppMethodBeat.o(54453);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54453);
        } else if (Build.VERSION.SDK_INT >= 8) {
            this.f1908b.setBlockNetworkLoads(z);
            AppMethodBeat.o(54453);
        } else {
            AppMethodBeat.o(54453);
        }
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(54454);
            if (this.f1909c && this.f1907a != null) {
                z = this.f1907a.getBlockNetworkLoads();
                AppMethodBeat.o(54454);
            } else if (this.f1909c || this.f1908b == null) {
                AppMethodBeat.o(54454);
            } else if (Build.VERSION.SDK_INT >= 8) {
                z = this.f1908b.getBlockNetworkLoads();
                AppMethodBeat.o(54454);
            } else {
                AppMethodBeat.o(54454);
            }
        }
        return z;
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(54455);
        try {
            if (this.f1909c && this.f1907a != null) {
                this.f1907a.setJavaScriptEnabled(z);
                AppMethodBeat.o(54455);
            } else if (this.f1909c || this.f1908b == null) {
                AppMethodBeat.o(54455);
            } else {
                this.f1908b.setJavaScriptEnabled(z);
                AppMethodBeat.o(54455);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(54455);
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        AppMethodBeat.i(54456);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAllowUniversalAccessFromFileURLs(z);
            AppMethodBeat.o(54456);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54456);
        } else {
            k.a(this.f1908b, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54456);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        AppMethodBeat.i(54457);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAllowFileAccessFromFileURLs(z);
            AppMethodBeat.o(54457);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54457);
        } else {
            k.a(this.f1908b, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54457);
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        AppMethodBeat.i(54458);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setPluginsEnabled(z);
            AppMethodBeat.o(54458);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54458);
        } else {
            k.a(this.f1908b, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54458);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        AppMethodBeat.i(54459);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
            AppMethodBeat.o(54459);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54459);
        } else if (Build.VERSION.SDK_INT >= 8) {
            WebSettings.PluginState valueOf = WebSettings.PluginState.valueOf(pluginState.name());
            k.a(this.f1908b, "setPluginState", new Class[]{WebSettings.PluginState.class}, valueOf);
            AppMethodBeat.o(54459);
        } else {
            AppMethodBeat.o(54459);
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        AppMethodBeat.i(54460);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setPluginsPath(str);
            AppMethodBeat.o(54460);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54460);
        } else {
            k.a(this.f1908b, "setPluginsPath", new Class[]{String.class}, str);
            AppMethodBeat.o(54460);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        AppMethodBeat.i(54461);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDatabasePath(str);
            AppMethodBeat.o(54461);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54461);
        } else {
            k.a(this.f1908b, "setDatabasePath", new Class[]{String.class}, str);
            AppMethodBeat.o(54461);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        AppMethodBeat.i(54462);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setGeolocationDatabasePath(str);
            AppMethodBeat.o(54462);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54462);
        } else {
            this.f1908b.setGeolocationDatabasePath(str);
            AppMethodBeat.o(54462);
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        AppMethodBeat.i(54463);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAppCacheEnabled(z);
            AppMethodBeat.o(54463);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54463);
        } else {
            this.f1908b.setAppCacheEnabled(z);
            AppMethodBeat.o(54463);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        AppMethodBeat.i(54464);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAppCachePath(str);
            AppMethodBeat.o(54464);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54464);
        } else {
            this.f1908b.setAppCachePath(str);
            AppMethodBeat.o(54464);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j2) {
        AppMethodBeat.i(54465);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setAppCacheMaxSize(j2);
            AppMethodBeat.o(54465);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54465);
        } else {
            this.f1908b.setAppCacheMaxSize(j2);
            AppMethodBeat.o(54465);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        AppMethodBeat.i(54466);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDatabaseEnabled(z);
            AppMethodBeat.o(54466);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54466);
        } else {
            this.f1908b.setDatabaseEnabled(z);
            AppMethodBeat.o(54466);
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        AppMethodBeat.i(54467);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDomStorageEnabled(z);
            AppMethodBeat.o(54467);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54467);
        } else {
            this.f1908b.setDomStorageEnabled(z);
            AppMethodBeat.o(54467);
        }
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        boolean z;
        AppMethodBeat.i(54468);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getDomStorageEnabled();
            AppMethodBeat.o(54468);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54468);
        } else {
            z = this.f1908b.getDomStorageEnabled();
            AppMethodBeat.o(54468);
        }
        return z;
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        String str;
        AppMethodBeat.i(54469);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getDatabasePath();
            AppMethodBeat.o(54469);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54469);
        } else {
            str = this.f1908b.getDatabasePath();
            AppMethodBeat.o(54469);
        }
        return str;
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        boolean z;
        AppMethodBeat.i(54470);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getDatabaseEnabled();
            AppMethodBeat.o(54470);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54470);
        } else {
            z = this.f1908b.getDatabaseEnabled();
            AppMethodBeat.o(54470);
        }
        return z;
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        AppMethodBeat.i(54471);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setGeolocationEnabled(z);
            AppMethodBeat.o(54471);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54471);
        } else {
            this.f1908b.setGeolocationEnabled(z);
            AppMethodBeat.o(54471);
        }
    }

    public synchronized boolean getJavaScriptEnabled() {
        boolean z;
        AppMethodBeat.i(54472);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getJavaScriptEnabled();
            AppMethodBeat.o(54472);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54472);
        } else {
            z = this.f1908b.getJavaScriptEnabled();
            AppMethodBeat.o(54472);
        }
        return z;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean z;
        AppMethodBeat.i(54473);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getPluginsEnabled();
            AppMethodBeat.o(54473);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54473);
            z = false;
        } else if (Build.VERSION.SDK_INT <= 17) {
            Object a2 = k.a(this.f1908b, "getPluginsEnabled");
            if (a2 == null) {
                AppMethodBeat.o(54473);
                z = false;
            } else {
                z = ((Boolean) a2).booleanValue();
                AppMethodBeat.o(54473);
            }
        } else if (Build.VERSION.SDK_INT == 18) {
            if (WebSettings.PluginState.ON == this.f1908b.getPluginState()) {
                z = true;
                AppMethodBeat.o(54473);
            } else {
                AppMethodBeat.o(54473);
                z = false;
            }
        } else {
            AppMethodBeat.o(54473);
            z = false;
        }
        return z;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        PluginState pluginState;
        AppMethodBeat.i(54474);
        if (this.f1909c && this.f1907a != null) {
            pluginState = PluginState.valueOf(this.f1907a.getPluginState().name());
            AppMethodBeat.o(54474);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54474);
            pluginState = null;
        } else if (Build.VERSION.SDK_INT >= 8) {
            Object a2 = k.a(this.f1908b, "getPluginState");
            if (a2 == null) {
                AppMethodBeat.o(54474);
                pluginState = null;
            } else {
                pluginState = PluginState.valueOf(((WebSettings.PluginState) a2).name());
                AppMethodBeat.o(54474);
            }
        } else {
            AppMethodBeat.o(54474);
            pluginState = null;
        }
        return pluginState;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String str;
        AppMethodBeat.i(54475);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getPluginsPath();
            AppMethodBeat.o(54475);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54475);
        } else if (Build.VERSION.SDK_INT <= 17) {
            Object a2 = k.a(this.f1908b, "getPluginsPath");
            if (a2 == null) {
                str = null;
                AppMethodBeat.o(54475);
            } else {
                str = (String) a2;
                AppMethodBeat.o(54475);
            }
        } else {
            str = "";
            AppMethodBeat.o(54475);
        }
        return str;
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(54476);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setJavaScriptCanOpenWindowsAutomatically(z);
            AppMethodBeat.o(54476);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54476);
        } else {
            this.f1908b.setJavaScriptCanOpenWindowsAutomatically(z);
            AppMethodBeat.o(54476);
        }
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean z;
        AppMethodBeat.i(54477);
        if (this.f1909c && this.f1907a != null) {
            z = this.f1907a.getJavaScriptCanOpenWindowsAutomatically();
            AppMethodBeat.o(54477);
        } else if (this.f1909c || this.f1908b == null) {
            z = false;
            AppMethodBeat.o(54477);
        } else {
            z = this.f1908b.getJavaScriptCanOpenWindowsAutomatically();
            AppMethodBeat.o(54477);
        }
        return z;
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        AppMethodBeat.i(54478);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setDefaultTextEncodingName(str);
            AppMethodBeat.o(54478);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54478);
        } else {
            this.f1908b.setDefaultTextEncodingName(str);
            AppMethodBeat.o(54478);
        }
    }

    public synchronized String getDefaultTextEncodingName() {
        String str;
        AppMethodBeat.i(54479);
        if (this.f1909c && this.f1907a != null) {
            str = this.f1907a.getDefaultTextEncodingName();
            AppMethodBeat.o(54479);
        } else if (this.f1909c || this.f1908b == null) {
            str = "";
            AppMethodBeat.o(54479);
        } else {
            str = this.f1908b.getDefaultTextEncodingName();
            AppMethodBeat.o(54479);
        }
        return str;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        AppMethodBeat.i(54480);
        if (x.a().b()) {
            String defaultUserAgent = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getDefaultUserAgent(context);
            AppMethodBeat.o(54480);
            return defaultUserAgent;
        } else if (Build.VERSION.SDK_INT < 17) {
            AppMethodBeat.o(54480);
            return null;
        } else {
            Object a2 = k.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context);
            if (a2 == null) {
                AppMethodBeat.o(54480);
                return null;
            }
            String str = (String) a2;
            AppMethodBeat.o(54480);
            return str;
        }
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        AppMethodBeat.i(54481);
        if (this.f1909c && this.f1907a != null) {
            boolean mediaPlaybackRequiresUserGesture = this.f1907a.getMediaPlaybackRequiresUserGesture();
            AppMethodBeat.o(54481);
            return mediaPlaybackRequiresUserGesture;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54481);
            return false;
        } else if (Build.VERSION.SDK_INT < 17) {
            AppMethodBeat.o(54481);
            return false;
        } else {
            Object a2 = k.a(this.f1908b, "getMediaPlaybackRequiresUserGesture");
            if (a2 == null) {
                AppMethodBeat.o(54481);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54481);
            return booleanValue;
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(54482);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setMediaPlaybackRequiresUserGesture(z);
            AppMethodBeat.o(54482);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54482);
        } else if (Build.VERSION.SDK_INT < 17) {
            AppMethodBeat.o(54482);
        } else {
            k.a(this.f1908b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(54482);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        AppMethodBeat.i(54483);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setNeedInitialFocus(z);
            AppMethodBeat.o(54483);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54483);
        } else {
            this.f1908b.setNeedInitialFocus(z);
            AppMethodBeat.o(54483);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        AppMethodBeat.i(54484);
        if (this.f1909c && this.f1907a != null) {
            this.f1907a.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
            AppMethodBeat.o(54484);
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54484);
        } else {
            this.f1908b.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
            AppMethodBeat.o(54484);
        }
    }

    public void setCacheMode(int i2) {
        AppMethodBeat.i(54485);
        if (!this.f1909c || this.f1907a == null) {
            if (!this.f1909c && this.f1908b != null) {
                this.f1908b.setCacheMode(i2);
            }
            AppMethodBeat.o(54485);
            return;
        }
        this.f1907a.setCacheMode(i2);
        AppMethodBeat.o(54485);
    }

    public int getCacheMode() {
        AppMethodBeat.i(54486);
        if (this.f1909c && this.f1907a != null) {
            int cacheMode = this.f1907a.getCacheMode();
            AppMethodBeat.o(54486);
            return cacheMode;
        } else if (this.f1909c || this.f1908b == null) {
            AppMethodBeat.o(54486);
            return 0;
        } else {
            int cacheMode2 = this.f1908b.getCacheMode();
            AppMethodBeat.o(54486);
            return cacheMode2;
        }
    }
}
