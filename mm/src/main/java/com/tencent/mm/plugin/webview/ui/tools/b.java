package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.webview.c;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public class b extends a {
    private final WeakReference<WebViewUI> Jbp;

    public b(WebViewUI webViewUI) {
        AppMethodBeat.i(79575);
        this.Jbp = new WeakReference<>(webViewUI);
        AppMethodBeat.o(79575);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public Object onMiscCallBack(String str, Bundle bundle) {
        boolean z;
        boolean z2;
        Bundle bundle2;
        AppMethodBeat.i(79576);
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(bundle == null);
        if (geo() == null || geo().mHh == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.WebViewLongClickHelper", "method = %s, bundler == null ? %b, invoker == null ? %b", objArr);
        if (!Util.isNullOrNil(str) && bundle != null) {
            if (geo() == null || geo().isFinishing()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && geo().mHh != null) {
                if (str.equals(JsApiAddDownloadTask.NAME)) {
                    try {
                        Bundle j2 = geo().mHh.j(14, bundle);
                        if (j2 != null) {
                            Long valueOf = Long.valueOf(j2.getLong("download_id", 0));
                            AppMethodBeat.o(79576);
                            return valueOf;
                        }
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the add downloadtask failed");
                    }
                }
                if (str.equals(JsApiCancelDownloadTask.NAME)) {
                    try {
                        Bundle j3 = geo().mHh.j(16, bundle);
                        if (j3 != null) {
                            Boolean valueOf2 = Boolean.valueOf(j3.getBoolean("cancel_result", false));
                            AppMethodBeat.o(79576);
                            return valueOf2;
                        }
                    } catch (RemoteException e3) {
                        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the cancel downloadtask failed");
                    }
                }
                if (str.equals(JsApiQueryDownloadTask.NAME)) {
                    try {
                        Bundle j4 = geo().mHh.j(15, bundle);
                        if (j4 != null) {
                            Integer valueOf3 = Integer.valueOf(j4.getInt("download_state", 0));
                            AppMethodBeat.o(79576);
                            return valueOf3;
                        }
                    } catch (RemoteException e4) {
                        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the queryDownloadTask downloadtask failed");
                    }
                }
                if (str.equals(JsApiInstallDownloadTask.NAME)) {
                    try {
                        Bundle j5 = geo().mHh.j(17, bundle);
                        if (j5 != null) {
                            Boolean valueOf4 = Boolean.valueOf(j5.getBoolean("install_result"));
                            AppMethodBeat.o(79576);
                            return valueOf4;
                        }
                    } catch (RemoteException e5) {
                        Log.e("MicroMsg.WebViewLongClickHelper", "invoke the install downloadtask failed");
                    }
                }
                if (str.equals("getDrawable")) {
                    String string = bundle.getString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                    int i2 = bundle.getInt("resourceId");
                    if (!Util.isNullOrNil(string) && i2 > 0) {
                        try {
                            Drawable g2 = com.tencent.mm.cc.b.g(MMApplicationContext.getContext().getPackageManager().getResourcesForApplication(string), i2);
                            AppMethodBeat.o(79576);
                            return g2;
                        } catch (Exception e6) {
                            Log.e("MicroMsg.WebViewLongClickHelper", "get resource for package : %s, fail, : %s", string, e6.getMessage());
                        }
                    }
                }
                if (str.equals("getShareUrl")) {
                    try {
                        String aZj = geo().mHh.aZj(geo().pGj.getUrl());
                        Log.i("MicroMsg.WebViewLongClickHelper", "getShareUrl by x5 core, shareurl = %s", aZj);
                        AppMethodBeat.o(79576);
                        return aZj;
                    } catch (Exception e7) {
                        Log.e("MicroMsg.WebViewLongClickHelper", "getShare url failed");
                    }
                }
                if (str.equals("smartPickWord")) {
                    Bundle b2 = f.b(bundle, geo().fZM(), geo().getMMTitle() != null ? geo().getMMTitle().toString() : "");
                    AppMethodBeat.o(79576);
                    return b2;
                } else if (str.equals("jumpToSos")) {
                    try {
                        f.aP(bundle);
                        Bundle j6 = geo().mHh.j(104, bundle);
                        f.mc(bundle.getString(SearchIntents.EXTRA_QUERY), geo().fZM());
                        if (j6 != null) {
                            Boolean valueOf5 = Boolean.valueOf(j6.getBoolean("open_result"));
                            AppMethodBeat.o(79576);
                            return valueOf5;
                        }
                    } catch (RemoteException e8) {
                        Log.e("MicroMsg.WebViewLongClickHelper", "jumpToSos failed");
                    }
                    AppMethodBeat.o(79576);
                    return null;
                } else if (str.equals("supportSmartPickWord")) {
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(79576);
                    return bool;
                } else if (str.equals("onShowSos")) {
                    f.q(geo().fZM(), bundle);
                    AppMethodBeat.o(79576);
                    return null;
                } else if (str.equals("supportImagePreview")) {
                    Boolean bool2 = Boolean.TRUE;
                    AppMethodBeat.o(79576);
                    return bool2;
                } else if (str.equals("onClickCopyBtn")) {
                    f.aZr(geo().fZM());
                    AppMethodBeat.o(79576);
                    return null;
                } else if (str.equals("imagePreview")) {
                    try {
                        bundle2 = geo().ISw.j(18, new Bundle());
                    } catch (Exception e9) {
                        bundle2 = null;
                    }
                    j.a(bundle, geo().pGj, bundle2, geo().Jig);
                    Boolean bool3 = Boolean.TRUE;
                    AppMethodBeat.o(79576);
                    return bool3;
                } else if (str.equals("closeImagePreview")) {
                    j.c(geo().mHh);
                    Boolean bool4 = Boolean.TRUE;
                    AppMethodBeat.o(79576);
                    return bool4;
                } else if (str.equals("onTranslateFinish")) {
                    geo().Jjp.fZn();
                    AppMethodBeat.o(79576);
                    return null;
                } else if (str.equals("onTranslateStart")) {
                    c cVar = geo().Jjp;
                    WebViewUI geo = geo();
                    if (cVar.tipDialog != null && cVar.tipDialog.isShowing()) {
                        cVar.tipDialog.dismiss();
                        cVar.tipDialog = null;
                    }
                    geo.getString(R.string.zb);
                    cVar.tipDialog = h.a((Context) geo, geo.getString(R.string.j05), true, (DialogInterface.OnCancelListener) null);
                    AppMethodBeat.o(79576);
                    return null;
                } else if (str.equals("onGetTranslateString")) {
                    geo().Jjp.a(geo().pGj, (HashMap) bundle.getSerializable("translate_hashmap"));
                    Boolean bool5 = Boolean.TRUE;
                    AppMethodBeat.o(79576);
                    return bool5;
                } else if (str.equals("onGetSampleString")) {
                    c cVar2 = geo().Jjp;
                    geo();
                    Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString in");
                    cVar2.IJx = new LinkedList<>();
                    cVar2.IJx.addAll(((HashMap) bundle.getSerializable("sample_hashmap")).values());
                    cVar2.IJC.countDown();
                    Log.i("MicroMsg.WebViewTranslateHelper", "getTranslateSampleString end");
                    Boolean bool6 = Boolean.TRUE;
                    AppMethodBeat.o(79576);
                    return bool6;
                } else {
                    AppMethodBeat.o(79576);
                    return null;
                }
            }
        }
        AppMethodBeat.o(79576);
        return null;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(79577);
        boolean B = geo().Jjw.B(motionEvent);
        AppMethodBeat.o(79577);
        return B;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(79578);
        boolean D = geo().Jjw.D(motionEvent);
        AppMethodBeat.o(79578);
        return D;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(79579);
        boolean C = geo().Jjw.C(motionEvent);
        AppMethodBeat.o(79579);
        return C;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
        AppMethodBeat.i(79580);
        boolean b2 = geo().Jjw.b(i2, i3, i4, i5, i6, i7, i8, i9, z);
        AppMethodBeat.o(79580);
        return b2;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(79581);
        geo().Jjw.onScrollChanged(i2, i3, i4, i5, view);
        AppMethodBeat.o(79581);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
        AppMethodBeat.i(79582);
        geo().Jjw.d(i2, i3, z, z2);
        AppMethodBeat.o(79582);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void computeScroll(View view) {
        AppMethodBeat.i(79583);
        geo().Jjw.bLv();
        AppMethodBeat.o(79583);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void invalidate() {
    }

    private WebViewUI geo() {
        AppMethodBeat.i(79585);
        WebViewUI webViewUI = this.Jbp.get();
        AppMethodBeat.o(79585);
        return webViewUI;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(79584);
        if (geo().getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
            AppMethodBeat.o(79584);
            return false;
        }
        AppMethodBeat.o(79584);
        return true;
    }
}
