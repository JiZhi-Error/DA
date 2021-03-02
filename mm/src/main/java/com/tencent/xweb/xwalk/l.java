package com.tencent.xweb.xwalk;

import android.webkit.WebSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z;
import java.util.Map;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class l extends z {
    XWalkView SHF;

    public l(XWalkView xWalkView) {
        this.SHF = xWalkView;
    }

    @Override // com.tencent.xweb.z
    public final void setSupportZoom(boolean z) {
        AppMethodBeat.i(154421);
        this.SHF.getSettings().setSupportZoom(z);
        AppMethodBeat.o(154421);
    }

    @Override // com.tencent.xweb.z
    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(154422);
        this.SHF.getSettings().setMediaPlaybackRequiresUserGesture(z);
        AppMethodBeat.o(154422);
    }

    @Override // com.tencent.xweb.z
    public final void setAudioPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(183741);
        this.SHF.getSettings().setAudioPlaybackRequiresUserGesture(z);
        AppMethodBeat.o(183741);
    }

    @Override // com.tencent.xweb.z
    public final void setVideoPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(154423);
        this.SHF.getSettings().setVideoPlaybackRequiresUserGesture(z);
        AppMethodBeat.o(154423);
    }

    @Override // com.tencent.xweb.z
    public final void enableCustomizedLongPressTimeout(int i2) {
        AppMethodBeat.i(207307);
        this.SHF.getSettings().enableCustomizedLongPressTimeout(i2);
        AppMethodBeat.o(207307);
    }

    @Override // com.tencent.xweb.z
    public final void setUsingForAppBrand(int i2) {
        AppMethodBeat.i(154424);
        this.SHF.getSettings().setUsingForAppBrand(i2);
        AppMethodBeat.o(154424);
    }

    @Override // com.tencent.xweb.z
    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(154425);
        this.SHF.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.o(154425);
    }

    @Override // com.tencent.xweb.z
    public final void hsK() {
    }

    @Override // com.tencent.xweb.z
    public final void hsL() {
        AppMethodBeat.i(154426);
        this.SHF.getSettings().setAllowFileAccess(true);
        AppMethodBeat.o(154426);
    }

    @Override // com.tencent.xweb.z
    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(154427);
        this.SHF.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.o(154427);
    }

    @Override // com.tencent.xweb.z
    public final void hsM() {
        AppMethodBeat.i(154428);
        this.SHF.getSettings().setSaveFormData(false);
        AppMethodBeat.o(154428);
    }

    @Override // com.tencent.xweb.z
    public final void hsN() {
    }

    @Override // com.tencent.xweb.z
    public final void setTextZoom(int i2) {
        AppMethodBeat.i(154429);
        this.SHF.getSettings().setTextZoom(i2);
        AppMethodBeat.o(154429);
    }

    @Override // com.tencent.xweb.z
    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(154430);
        this.SHF.getSettings().setUseWideViewPort(z);
        AppMethodBeat.o(154430);
    }

    @Override // com.tencent.xweb.z
    public final void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(154431);
        this.SHF.getSettings().setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
        AppMethodBeat.o(154431);
    }

    @Override // com.tencent.xweb.z
    public final void hsO() {
        AppMethodBeat.i(154432);
        this.SHF.getSettings().setDefaultFontSize(8);
        AppMethodBeat.o(154432);
    }

    @Override // com.tencent.xweb.z
    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(154433);
        this.SHF.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.o(154433);
    }

    @Override // com.tencent.xweb.z
    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(154434);
        this.SHF.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.o(154434);
    }

    @Override // com.tencent.xweb.z
    public final boolean getBlockNetworkImage() {
        AppMethodBeat.i(154435);
        boolean blockNetworkImage = this.SHF.getSettings().getBlockNetworkImage();
        AppMethodBeat.o(154435);
        return blockNetworkImage;
    }

    @Override // com.tencent.xweb.z
    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(154436);
        this.SHF.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.o(154436);
    }

    @Override // com.tencent.xweb.z
    public final void hsP() {
        AppMethodBeat.i(154437);
        this.SHF.getSettings().setAllowUniversalAccessFromFileURLs(true);
        AppMethodBeat.o(154437);
    }

    @Override // com.tencent.xweb.z
    public final void hsQ() {
        AppMethodBeat.i(154438);
        this.SHF.getSettings().setAllowFileAccessFromFileURLs(true);
        AppMethodBeat.o(154438);
    }

    @Override // com.tencent.xweb.z
    public final void setPluginsEnabled(boolean z) {
    }

    @Override // com.tencent.xweb.z
    public final void setDatabasePath(String str) {
    }

    @Override // com.tencent.xweb.z
    public final void hsR() {
        AppMethodBeat.i(154439);
        this.SHF.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.o(154439);
    }

    @Override // com.tencent.xweb.z
    public final void setAppCachePath(String str) {
        AppMethodBeat.i(154440);
        this.SHF.getSettings().setAppCachePath(str);
        AppMethodBeat.o(154440);
    }

    @Override // com.tencent.xweb.z
    public final void hsS() {
    }

    @Override // com.tencent.xweb.z
    public final void hsT() {
        AppMethodBeat.i(154441);
        this.SHF.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.o(154441);
    }

    @Override // com.tencent.xweb.z
    public final void hsU() {
        AppMethodBeat.i(154442);
        this.SHF.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.o(154442);
    }

    @Override // com.tencent.xweb.z
    public final void setGeolocationEnabled(boolean z) {
    }

    @Override // com.tencent.xweb.z
    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(154443);
        this.SHF.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.o(154443);
    }

    @Override // com.tencent.xweb.z
    public final void setDefaultTextEncodingName(String str) {
    }

    @Override // com.tencent.xweb.z
    public final void setUserAgentString(String str) {
        AppMethodBeat.i(154444);
        this.SHF.getSettings().setUserAgentString(str);
        AppMethodBeat.o(154444);
    }

    @Override // com.tencent.xweb.z
    public final String getUserAgentString() {
        AppMethodBeat.i(154445);
        String userAgentString = this.SHF.getSettings().getUserAgentString();
        AppMethodBeat.o(154445);
        return userAgentString;
    }

    @Override // com.tencent.xweb.z
    public final void setRenderPriority(WebSettings.RenderPriority renderPriority) {
    }

    @Override // com.tencent.xweb.z
    public final void hsV() {
        AppMethodBeat.i(154446);
        this.SHF.getSettings().setCacheMode(-1);
        AppMethodBeat.o(154446);
    }

    @Override // com.tencent.xweb.z
    public final void hsW() {
    }

    @Override // com.tencent.xweb.z
    public final void setForceDarkMode(int i2) {
        AppMethodBeat.i(154447);
        this.SHF.getSettings().setForceDarkMode(i2);
        AppMethodBeat.o(154447);
    }

    @Override // com.tencent.xweb.z
    public final int getForceDarkMode() {
        AppMethodBeat.i(154448);
        int forceDarkMode = this.SHF.getSettings().getForceDarkMode();
        AppMethodBeat.o(154448);
        return forceDarkMode;
    }

    @Override // com.tencent.xweb.z
    public final void setForceDarkBehavior(int i2) {
        AppMethodBeat.i(154449);
        this.SHF.getSettings().setForceDarkBehavior(i2);
        AppMethodBeat.o(154449);
    }

    @Override // com.tencent.xweb.z
    public final int getForceDarkBehavior() {
        AppMethodBeat.i(154450);
        int forceDarkBehavior = this.SHF.getSettings().getForceDarkBehavior();
        AppMethodBeat.o(154450);
        return forceDarkBehavior;
    }

    @Override // com.tencent.xweb.z
    public final void setAppBrandInfo(Map<String, String> map) {
        AppMethodBeat.i(207308);
        this.SHF.getSettings().setAppBrandInfo(map);
        AppMethodBeat.o(207308);
    }

    @Override // com.tencent.xweb.z
    public final void hsX() {
        AppMethodBeat.i(207309);
        this.SHF.getSettings().setBackgroundAudioPause(true);
        AppMethodBeat.o(207309);
    }
}
