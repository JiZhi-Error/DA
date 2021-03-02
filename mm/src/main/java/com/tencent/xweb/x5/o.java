package com.tencent.xweb.x5;

import android.os.Bundle;
import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.z;
import java.util.Map;
import org.a.a;
import org.xwalk.core.Log;

public final class o extends z {
    WebView SFE;
    private int SFF = 0;

    public o(WebView webView) {
        this.SFE = webView;
    }

    @Override // com.tencent.xweb.z
    public final void setSupportZoom(boolean z) {
        AppMethodBeat.i(153989);
        this.SFE.getSettings().setSupportZoom(z);
        AppMethodBeat.o(153989);
    }

    @Override // com.tencent.xweb.z
    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(153990);
        this.SFE.getSettings().setMediaPlaybackRequiresUserGesture(z);
        AppMethodBeat.o(153990);
    }

    @Override // com.tencent.xweb.z
    public final void setAudioPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(183739);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("require", z);
            this.SFE.getX5WebViewExtension().invokeMiscMethod("setAudioPlaybackRequiresUserGestureV2", bundle);
            AppMethodBeat.o(183739);
        } catch (Exception e2) {
            AppMethodBeat.o(183739);
        }
    }

    @Override // com.tencent.xweb.z
    public final void setVideoPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(153991);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("require", z);
            a.gG(this.SFE.getX5WebViewExtension()).u("invokeMiscMethod", "setVideoPlaybackRequiresUserGesture", bundle);
            AppMethodBeat.o(153991);
        } catch (Exception e2) {
            AppMethodBeat.o(153991);
        }
    }

    @Override // com.tencent.xweb.z
    public final void enableCustomizedLongPressTimeout(int i2) {
    }

    @Override // com.tencent.xweb.z
    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(153992);
        this.SFE.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.o(153992);
    }

    @Override // com.tencent.xweb.z
    public final void hsK() {
        AppMethodBeat.i(153993);
        this.SFE.getSettings().setDisplayZoomControls(false);
        AppMethodBeat.o(153993);
    }

    @Override // com.tencent.xweb.z
    public final void hsL() {
        AppMethodBeat.i(153994);
        this.SFE.getSettings().setAllowFileAccess(true);
        AppMethodBeat.o(153994);
    }

    @Override // com.tencent.xweb.z
    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(153995);
        this.SFE.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.o(153995);
    }

    @Override // com.tencent.xweb.z
    public final void hsM() {
        AppMethodBeat.i(153996);
        this.SFE.getSettings().setSaveFormData(false);
        AppMethodBeat.o(153996);
    }

    @Override // com.tencent.xweb.z
    public final void hsN() {
        AppMethodBeat.i(153997);
        this.SFE.getSettings().setSavePassword(false);
        AppMethodBeat.o(153997);
    }

    @Override // com.tencent.xweb.z
    public final void setTextZoom(int i2) {
        AppMethodBeat.i(153998);
        this.SFE.getSettings().setTextZoom(i2);
        AppMethodBeat.o(153998);
    }

    @Override // com.tencent.xweb.z
    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(153999);
        this.SFE.getSettings().setUseWideViewPort(z);
        AppMethodBeat.o(153999);
    }

    @Override // com.tencent.xweb.z
    public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(154000);
        this.SFE.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
        AppMethodBeat.o(154000);
    }

    @Override // com.tencent.xweb.z
    public final void hsO() {
        AppMethodBeat.i(154001);
        this.SFE.getSettings().setDefaultFontSize(8);
        AppMethodBeat.o(154001);
    }

    @Override // com.tencent.xweb.z
    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(154002);
        this.SFE.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.o(154002);
    }

    @Override // com.tencent.xweb.z
    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(154003);
        this.SFE.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.o(154003);
    }

    @Override // com.tencent.xweb.z
    public final boolean getBlockNetworkImage() {
        AppMethodBeat.i(154004);
        boolean blockNetworkImage = this.SFE.getSettings().getBlockNetworkImage();
        AppMethodBeat.o(154004);
        return blockNetworkImage;
    }

    @Override // com.tencent.xweb.z
    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(154005);
        this.SFE.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.o(154005);
    }

    @Override // com.tencent.xweb.z
    public final void hsP() {
        AppMethodBeat.i(154006);
        this.SFE.getSettings().setAllowUniversalAccessFromFileURLs(true);
        AppMethodBeat.o(154006);
    }

    @Override // com.tencent.xweb.z
    public final void hsQ() {
        AppMethodBeat.i(154007);
        this.SFE.getSettings().setAllowFileAccessFromFileURLs(true);
        AppMethodBeat.o(154007);
    }

    @Override // com.tencent.xweb.z
    public final void setPluginsEnabled(boolean z) {
        AppMethodBeat.i(154008);
        this.SFE.getSettings().setPluginsEnabled(z);
        AppMethodBeat.o(154008);
    }

    @Override // com.tencent.xweb.z
    public final void setDatabasePath(String str) {
        AppMethodBeat.i(154009);
        this.SFE.getSettings().setDatabasePath(str);
        AppMethodBeat.o(154009);
    }

    @Override // com.tencent.xweb.z
    public final void hsR() {
        AppMethodBeat.i(154010);
        this.SFE.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.o(154010);
    }

    @Override // com.tencent.xweb.z
    public final void setAppCachePath(String str) {
        AppMethodBeat.i(154011);
        this.SFE.getSettings().setAppCachePath(str);
        AppMethodBeat.o(154011);
    }

    @Override // com.tencent.xweb.z
    public final void hsS() {
        AppMethodBeat.i(154012);
        this.SFE.getSettings().setAppCacheMaxSize(10485760);
        AppMethodBeat.o(154012);
    }

    @Override // com.tencent.xweb.z
    public final void hsT() {
        AppMethodBeat.i(154013);
        this.SFE.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.o(154013);
    }

    @Override // com.tencent.xweb.z
    public final void hsU() {
        AppMethodBeat.i(154014);
        this.SFE.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.o(154014);
    }

    @Override // com.tencent.xweb.z
    public final void setGeolocationEnabled(boolean z) {
        AppMethodBeat.i(154015);
        this.SFE.getSettings().setGeolocationEnabled(z);
        AppMethodBeat.o(154015);
    }

    @Override // com.tencent.xweb.z
    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(154016);
        this.SFE.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.o(154016);
    }

    @Override // com.tencent.xweb.z
    public final void setDefaultTextEncodingName(String str) {
        AppMethodBeat.i(154017);
        this.SFE.getSettings().setDefaultTextEncodingName(str);
        AppMethodBeat.o(154017);
    }

    @Override // com.tencent.xweb.z
    public final void setUserAgentString(String str) {
        AppMethodBeat.i(154018);
        this.SFE.getSettings().setUserAgentString(str);
        AppMethodBeat.o(154018);
    }

    @Override // com.tencent.xweb.z
    public final String getUserAgentString() {
        AppMethodBeat.i(154019);
        String userAgentString = this.SFE.getSettings().getUserAgentString();
        AppMethodBeat.o(154019);
        return userAgentString;
    }

    @Override // com.tencent.xweb.z
    public final void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        AppMethodBeat.i(154020);
        this.SFE.getSettings().setRenderPriority(WebSettings.RenderPriority.values()[renderPriority.ordinal()]);
        AppMethodBeat.o(154020);
    }

    @Override // com.tencent.xweb.z
    public final void hsV() {
        AppMethodBeat.i(154021);
        this.SFE.getSettings().setCacheMode(-1);
        AppMethodBeat.o(154021);
    }

    @Override // com.tencent.xweb.z
    public final void hsW() {
        AppMethodBeat.i(154022);
        this.SFE.getSettings().setMixedContentMode(0);
        AppMethodBeat.o(154022);
    }

    @Override // com.tencent.xweb.z
    public final void setUsingForAppBrand(int i2) {
        AppMethodBeat.i(154023);
        this.SFF = i2;
        if (this.SFE.getX5WebViewExtension() == null) {
            AppMethodBeat.o(154023);
            return;
        }
        switch (this.SFF) {
            case 1:
                Bundle bundle = new Bundle(1);
                bundle.putInt("flag", 1);
                this.SFE.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", bundle);
                try {
                    a.gG(this.SFE.getX5WebViewExtension()).u("setEnableAutoPageDiscarding", Boolean.FALSE);
                    a.gG(this.SFE.getX5WebViewExtension()).u("setEnableAutoPageRestoration", Boolean.FALSE);
                    AppMethodBeat.o(154023);
                    return;
                } catch (Exception e2) {
                    Log.e("XWEB.X5WebViewSettings", "DisableAutoPageDiscarding error ".concat(String.valueOf(e2)));
                    AppMethodBeat.o(154023);
                    return;
                }
            case 2:
                Bundle bundle2 = new Bundle(1);
                bundle2.putInt("flag", 2);
                this.SFE.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", bundle2);
                break;
        }
        AppMethodBeat.o(154023);
    }

    @Override // com.tencent.xweb.z
    public final void setForceDarkMode(int i2) {
    }

    @Override // com.tencent.xweb.z
    public final int getForceDarkMode() {
        return 0;
    }

    @Override // com.tencent.xweb.z
    public final void setForceDarkBehavior(int i2) {
    }

    @Override // com.tencent.xweb.z
    public final int getForceDarkBehavior() {
        return 0;
    }

    @Override // com.tencent.xweb.z
    public final void setAppBrandInfo(Map<String, String> map) {
    }

    @Override // com.tencent.xweb.z
    public final void hsX() {
    }
}
