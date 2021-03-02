package com.tencent.xweb.sys;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z;
import java.util.Map;

public final class g extends z {
    String SEA = "";
    WebView SEz;

    public g(WebView webView) {
        AppMethodBeat.i(153778);
        this.SEz = webView;
        getUserAgentString();
        AppMethodBeat.o(153778);
    }

    @Override // com.tencent.xweb.z
    public final void setSupportZoom(boolean z) {
        AppMethodBeat.i(153779);
        this.SEz.getSettings().setSupportZoom(z);
        AppMethodBeat.o(153779);
    }

    @Override // com.tencent.xweb.z
    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(153780);
        if (Build.VERSION.SDK_INT >= 17) {
            this.SEz.getSettings().setMediaPlaybackRequiresUserGesture(z);
        }
        AppMethodBeat.o(153780);
    }

    @Override // com.tencent.xweb.z
    public final void setAudioPlaybackRequiresUserGesture(boolean z) {
    }

    @Override // com.tencent.xweb.z
    public final void setVideoPlaybackRequiresUserGesture(boolean z) {
    }

    @Override // com.tencent.xweb.z
    public final void enableCustomizedLongPressTimeout(int i2) {
    }

    @Override // com.tencent.xweb.z
    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(153781);
        this.SEz.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.o(153781);
    }

    @Override // com.tencent.xweb.z
    public final void hsK() {
        AppMethodBeat.i(153782);
        this.SEz.getSettings().setDisplayZoomControls(false);
        AppMethodBeat.o(153782);
    }

    @Override // com.tencent.xweb.z
    public final void hsL() {
        AppMethodBeat.i(153783);
        this.SEz.getSettings().setAllowFileAccess(true);
        AppMethodBeat.o(153783);
    }

    @Override // com.tencent.xweb.z
    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(153784);
        this.SEz.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.o(153784);
    }

    @Override // com.tencent.xweb.z
    public final void hsM() {
        AppMethodBeat.i(153785);
        this.SEz.getSettings().setSaveFormData(false);
        AppMethodBeat.o(153785);
    }

    @Override // com.tencent.xweb.z
    public final void hsN() {
        AppMethodBeat.i(153786);
        this.SEz.getSettings().setSavePassword(false);
        AppMethodBeat.o(153786);
    }

    @Override // com.tencent.xweb.z
    public final void setTextZoom(int i2) {
        AppMethodBeat.i(153787);
        this.SEz.getSettings().setTextZoom(i2);
        AppMethodBeat.o(153787);
    }

    @Override // com.tencent.xweb.z
    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(153788);
        this.SEz.getSettings().setUseWideViewPort(z);
        AppMethodBeat.o(153788);
    }

    @Override // com.tencent.xweb.z
    public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(153789);
        this.SEz.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        AppMethodBeat.o(153789);
    }

    @Override // com.tencent.xweb.z
    public final void hsO() {
        AppMethodBeat.i(153790);
        this.SEz.getSettings().setDefaultFontSize(8);
        AppMethodBeat.o(153790);
    }

    @Override // com.tencent.xweb.z
    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(153791);
        this.SEz.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.o(153791);
    }

    @Override // com.tencent.xweb.z
    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(153792);
        this.SEz.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.o(153792);
    }

    @Override // com.tencent.xweb.z
    public final boolean getBlockNetworkImage() {
        AppMethodBeat.i(153793);
        boolean blockNetworkImage = this.SEz.getSettings().getBlockNetworkImage();
        AppMethodBeat.o(153793);
        return blockNetworkImage;
    }

    @Override // com.tencent.xweb.z
    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(153794);
        this.SEz.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.o(153794);
    }

    @Override // com.tencent.xweb.z
    public final void hsP() {
        AppMethodBeat.i(153795);
        this.SEz.getSettings().setAllowUniversalAccessFromFileURLs(true);
        AppMethodBeat.o(153795);
    }

    @Override // com.tencent.xweb.z
    public final void hsQ() {
        AppMethodBeat.i(153796);
        this.SEz.getSettings().setAllowFileAccessFromFileURLs(true);
        AppMethodBeat.o(153796);
    }

    @Override // com.tencent.xweb.z
    public final void setPluginsEnabled(boolean z) {
        AppMethodBeat.i(153797);
        com.tencent.xweb.util.g.c(this.SEz.getSettings(), "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(153797);
    }

    @Override // com.tencent.xweb.z
    public final void setDatabasePath(String str) {
        AppMethodBeat.i(153798);
        this.SEz.getSettings().setDatabasePath(str);
        AppMethodBeat.o(153798);
    }

    @Override // com.tencent.xweb.z
    public final void hsR() {
        AppMethodBeat.i(153799);
        this.SEz.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.o(153799);
    }

    @Override // com.tencent.xweb.z
    public final void setAppCachePath(String str) {
        AppMethodBeat.i(153800);
        this.SEz.getSettings().setAppCachePath(str);
        AppMethodBeat.o(153800);
    }

    @Override // com.tencent.xweb.z
    public final void hsS() {
        AppMethodBeat.i(153801);
        this.SEz.getSettings().setAppCacheMaxSize(10485760);
        AppMethodBeat.o(153801);
    }

    @Override // com.tencent.xweb.z
    public final void hsT() {
        AppMethodBeat.i(153802);
        this.SEz.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.o(153802);
    }

    @Override // com.tencent.xweb.z
    public final void hsU() {
        AppMethodBeat.i(153803);
        this.SEz.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.o(153803);
    }

    @Override // com.tencent.xweb.z
    public final void setGeolocationEnabled(boolean z) {
        AppMethodBeat.i(153804);
        this.SEz.getSettings().setGeolocationEnabled(z);
        AppMethodBeat.o(153804);
    }

    @Override // com.tencent.xweb.z
    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(153805);
        this.SEz.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.o(153805);
    }

    @Override // com.tencent.xweb.z
    public final void setDefaultTextEncodingName(String str) {
        AppMethodBeat.i(153806);
        this.SEz.getSettings().setDefaultTextEncodingName(str);
        AppMethodBeat.o(153806);
    }

    @Override // com.tencent.xweb.z
    public final void setUserAgentString(String str) {
        AppMethodBeat.i(153807);
        this.SEA = str;
        this.SEz.getSettings().setUserAgentString(str);
        AppMethodBeat.o(153807);
    }

    @Override // com.tencent.xweb.z
    public final String getUserAgentString() {
        AppMethodBeat.i(153808);
        if (this.SEA == null || this.SEA.isEmpty()) {
            try {
                this.SEA = this.SEz.getSettings().getUserAgentString();
            } catch (Exception e2) {
            }
        }
        String str = this.SEA;
        AppMethodBeat.o(153808);
        return str;
    }

    @Override // com.tencent.xweb.z
    public final void setRenderPriority(WebSettings.RenderPriority renderPriority) {
        AppMethodBeat.i(153809);
        this.SEz.getSettings().setRenderPriority(renderPriority);
        AppMethodBeat.o(153809);
    }

    @Override // com.tencent.xweb.z
    public final void hsV() {
        AppMethodBeat.i(153810);
        this.SEz.getSettings().setCacheMode(-1);
        AppMethodBeat.o(153810);
    }

    @Override // com.tencent.xweb.z
    public final void hsW() {
        AppMethodBeat.i(153811);
        if (Build.VERSION.SDK_INT >= 21) {
            this.SEz.getSettings().setMixedContentMode(0);
        }
        AppMethodBeat.o(153811);
    }

    @Override // com.tencent.xweb.z
    public final void setUsingForAppBrand(int i2) {
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
