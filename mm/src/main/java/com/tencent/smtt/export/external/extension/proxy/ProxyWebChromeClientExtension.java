package com.tencent.smtt.export.external.extension.proxy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.CorePermissionRequest;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.HashMap;

public class ProxyWebChromeClientExtension implements IX5WebChromeClientExtension {
    private static boolean sCompatibleNewOnSavePassword = true;
    private static boolean sCompatibleOpenFileChooser = true;
    protected IX5WebChromeClientExtension mWebChromeClient;

    public IX5WebChromeClientExtension getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void setWebChromeClientExtend(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        this.mWebChromeClient = iX5WebChromeClientExtension;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(53175);
        if (this.mWebChromeClient != null) {
            View videoLoadingProgressView = this.mWebChromeClient.getVideoLoadingProgressView();
            AppMethodBeat.o(53175);
            return videoLoadingProgressView;
        }
        AppMethodBeat.o(53175);
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onBackforwardFinished(int i2) {
        AppMethodBeat.i(53176);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onBackforwardFinished(i2);
        }
        AppMethodBeat.o(53176);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onHitTestResultForPluginFinished(IX5WebViewExtension iX5WebViewExtension, IX5WebViewBase.HitTestResult hitTestResult, Bundle bundle) {
        AppMethodBeat.i(53177);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHitTestResultForPluginFinished(iX5WebViewExtension, hitTestResult, bundle);
        }
        AppMethodBeat.o(53177);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onHitTestResultFinished(IX5WebViewExtension iX5WebViewExtension, IX5WebViewBase.HitTestResult hitTestResult) {
        AppMethodBeat.i(53178);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHitTestResultFinished(iX5WebViewExtension, hitTestResult);
        }
        AppMethodBeat.o(53178);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onAddFavorite(IX5WebViewExtension iX5WebViewExtension, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(53179);
        if (this.mWebChromeClient != null) {
            boolean onAddFavorite = this.mWebChromeClient.onAddFavorite(iX5WebViewExtension, str, str2, jsResult);
            AppMethodBeat.o(53179);
            return onAddFavorite;
        }
        AppMethodBeat.o(53179);
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap) {
        AppMethodBeat.i(53180);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPrepareX5ReadPageDataFinished(iX5WebViewExtension, hashMap);
        }
        AppMethodBeat.o(53180);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPromptScaleSaved(IX5WebViewExtension iX5WebViewExtension) {
        AppMethodBeat.i(53181);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPromptScaleSaved(iX5WebViewExtension);
        }
        AppMethodBeat.o(53181);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPromptNotScalable(IX5WebViewExtension iX5WebViewExtension) {
        AppMethodBeat.i(53182);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onPromptNotScalable(iX5WebViewExtension);
        }
        AppMethodBeat.o(53182);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onSavePassword(String str, String str2, String str3, boolean z, Message message) {
        AppMethodBeat.i(53183);
        if (this.mWebChromeClient != null) {
            try {
                boolean onSavePassword = this.mWebChromeClient.onSavePassword(str, str2, str3, z, message);
                AppMethodBeat.o(53183);
                return onSavePassword;
            } catch (NoSuchMethodError e2) {
            }
        }
        AppMethodBeat.o(53183);
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onSavePassword(ValueCallback<String> valueCallback, String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.i(53184);
        if (this.mWebChromeClient != null && sCompatibleNewOnSavePassword) {
            try {
                boolean onSavePassword = this.mWebChromeClient.onSavePassword(valueCallback, str, str2, str3, str4, str5, z);
                AppMethodBeat.o(53184);
                return onSavePassword;
            } catch (NoSuchMethodError e2) {
                if (e2.getMessage() == null || !e2.getMessage().contains("onSavePassword")) {
                    AppMethodBeat.o(53184);
                    throw e2;
                }
                sCompatibleNewOnSavePassword = false;
            }
        }
        AppMethodBeat.o(53184);
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onX5ReadModeAvailableChecked(HashMap<String, String> hashMap) {
        AppMethodBeat.i(53185);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onX5ReadModeAvailableChecked(hashMap);
        }
        AppMethodBeat.o(53185);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public Object getX5WebChromeClientInstance() {
        return this.mWebChromeClient;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void addFlashView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(53186);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.addFlashView(view, layoutParams);
        }
        AppMethodBeat.o(53186);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void requestFullScreenFlash() {
        AppMethodBeat.i(53187);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.requestFullScreenFlash();
        }
        AppMethodBeat.o(53187);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void exitFullScreenFlash() {
        AppMethodBeat.i(53188);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.exitFullScreenFlash();
        }
        AppMethodBeat.o(53188);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void jsRequestFullScreen() {
        AppMethodBeat.i(53189);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.jsRequestFullScreen();
        }
        AppMethodBeat.o(53189);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void jsExitFullScreen() {
        AppMethodBeat.i(53190);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.jsExitFullScreen();
        }
        AppMethodBeat.o(53190);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void h5videoRequestFullScreen(String str) {
        AppMethodBeat.i(53191);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.h5videoRequestFullScreen(str);
        }
        AppMethodBeat.o(53191);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void h5videoExitFullScreen(String str) {
        AppMethodBeat.i(53192);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.h5videoExitFullScreen(str);
        }
        AppMethodBeat.o(53192);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void acquireWakeLock() {
        AppMethodBeat.i(53193);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.acquireWakeLock();
        }
        AppMethodBeat.o(53193);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void releaseWakeLock() {
        AppMethodBeat.i(53194);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.releaseWakeLock();
        }
        AppMethodBeat.o(53194);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public Context getApplicationContex() {
        AppMethodBeat.i(53195);
        if (this.mWebChromeClient != null) {
            Context applicationContex = this.mWebChromeClient.getApplicationContex();
            AppMethodBeat.o(53195);
            return applicationContex;
        }
        AppMethodBeat.o(53195);
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onAllMetaDataFinished(IX5WebViewExtension iX5WebViewExtension, HashMap<String, String> hashMap) {
        AppMethodBeat.i(53196);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onAllMetaDataFinished(iX5WebViewExtension, hashMap);
        }
        AppMethodBeat.o(53196);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onPageNotResponding(Runnable runnable) {
        AppMethodBeat.i(53197);
        if (this.mWebChromeClient != null) {
            boolean onPageNotResponding = this.mWebChromeClient.onPageNotResponding(runnable);
            AppMethodBeat.o(53197);
            return onPageNotResponding;
        }
        AppMethodBeat.o(53197);
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(53198);
        if (this.mWebChromeClient != null) {
            Object onMiscCallBack = this.mWebChromeClient.onMiscCallBack(str, bundle);
            AppMethodBeat.o(53198);
            return onMiscCallBack;
        }
        AppMethodBeat.o(53198);
        return null;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2) {
        AppMethodBeat.i(53199);
        if (this.mWebChromeClient != null && sCompatibleOpenFileChooser) {
            try {
                this.mWebChromeClient.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.o(53199);
                return;
            } catch (NoSuchMethodError e2) {
                if (e2.getMessage() == null || !e2.getMessage().contains("openFileChooser")) {
                    AppMethodBeat.o(53199);
                    throw e2;
                }
                sCompatibleOpenFileChooser = false;
            }
        }
        AppMethodBeat.o(53199);
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onPrintPage() {
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public void onColorModeChanged(long j2) {
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onGoToEntryOffset(int i2) {
        AppMethodBeat.i(53200);
        if (this.mWebChromeClient != null) {
            boolean onGoToEntryOffset = this.mWebChromeClient.onGoToEntryOffset(i2);
            AppMethodBeat.o(53200);
            return onGoToEntryOffset;
        }
        AppMethodBeat.o(53200);
        return true;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean onPermissionRequest(String str, long j2, MediaAccessPermissionsCallback mediaAccessPermissionsCallback) {
        return false;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public int checkPermission(String str) {
        return -1;
    }

    @Override // com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension
    public boolean requestAPPPermission(CorePermissionRequest corePermissionRequest, CorePermissionRequest.CorePermissionRequestCallback corePermissionRequestCallback) {
        return false;
    }
}
