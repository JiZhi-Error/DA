package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.lang.Thread;
import java.lang.reflect.Field;

public class OpenMaterialWebView extends MMWebView {
    private Context context;

    public OpenMaterialWebView(Context context2) {
        super(context2);
        AppMethodBeat.i(227259);
        this.context = context2;
        init();
        AppMethodBeat.o(227259);
    }

    public OpenMaterialWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(227260);
        this.context = context2;
        init();
        AppMethodBeat.o(227260);
    }

    public OpenMaterialWebView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(227261);
        this.context = context2;
        init();
        AppMethodBeat.o(227261);
    }

    private void init() {
        AppMethodBeat.i(227262);
        Log.printInfoStack("MicroMsg.AppBrand.OpenMaterialWebView", "init OpenMaterialWebView", new Object[0]);
        this.gKM = true;
        kI(this.context);
        bQp();
        AppMethodBeat.o(227262);
    }

    private void bQp() {
        AppMethodBeat.i(227263);
        if (getIsX5Kernel()) {
            AppMethodBeat.o(227263);
        } else if (d.oD(19)) {
            AppMethodBeat.o(227263);
        } else {
            try {
                Object obj = new c(this, "mSysWebView", null).get();
                Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", obj);
                Object obj2 = new c(obj, "mProvider", null).get();
                Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", obj2);
                Object obj3 = new c(obj2, "mWebViewCore", null).get();
                Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", obj3);
                Object obj4 = new c(obj3, "sWebCoreHandler", null).get();
                Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", obj4);
                Object obj5 = new c(obj4, "mLooper", null).get();
                Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", obj5);
                Object obj6 = new c(obj5, "mThread", null).get();
                Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj6);
                if (obj6 instanceof Thread) {
                    Thread thread = (Thread) obj6;
                    Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == Thread.State.WAITING) {
                        thread.interrupt();
                    }
                }
                AppMethodBeat.o(227263);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
                AppMethodBeat.o(227263);
            }
        }
    }

    public final void bQq() {
        AppMethodBeat.i(227264);
        getSettings().hsU();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setPluginsEnabled(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().hsW();
        getSettings().setUserAgentString(z.cr(getContext(), getSettings().getUserAgentString()));
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().hsN();
        getSettings().hsM();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().hsW();
        getSettings().hsS();
        getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
        getSettings().hsR();
        getSettings().hsT();
        getSettings().setDatabasePath(b.aKA() + "databases/");
        com.tencent.xweb.c.hsp().hsq();
        com.tencent.xweb.c.hsp().e(this);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(true);
        setConfigCallback((WindowManager) MMApplicationContext.getContext().getSystemService("window"));
        super.setWebChromeClient(null);
        super.setWebViewClient(null);
        Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        gYW();
        AppMethodBeat.o(227264);
    }

    @Override // com.tencent.mm.ui.widget.MMWebView, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void destroy() {
        AppMethodBeat.i(227265);
        this.context = null;
        super.setWebChromeClient(null);
        super.setWebViewClient(null);
        super.destroy();
        AppMethodBeat.o(227265);
    }

    public void setConfigCallback(WindowManager windowManager) {
        AppMethodBeat.i(227266);
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                AppMethodBeat.o(227266);
                return;
            }
            Field declaredField2 = declaredField.getType().getDeclaredField("mWindowManager");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, windowManager);
            AppMethodBeat.o(227266);
        } catch (Exception e2) {
            AppMethodBeat.o(227266);
        }
    }
}
