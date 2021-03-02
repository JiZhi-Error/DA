package com.tencent.mm.plugin.box.webview;

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

public class BoxWebView extends MMWebView {
    private Context context;

    public BoxWebView(Context context2) {
        super(context2);
        AppMethodBeat.i(76344);
        this.context = context2;
        init();
        AppMethodBeat.o(76344);
    }

    public BoxWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(76345);
        this.context = context2;
        init();
        AppMethodBeat.o(76345);
    }

    public BoxWebView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(76346);
        this.context = context2;
        init();
        AppMethodBeat.o(76346);
    }

    private void init() {
        AppMethodBeat.i(76347);
        Log.i("MicroMsg.Flight.FlightWebView", "init FlightWebView");
        this.gKM = true;
        kI(this.context);
        bQp();
        AppMethodBeat.o(76347);
    }

    private void bQp() {
        AppMethodBeat.i(76348);
        if (getIsX5Kernel()) {
            AppMethodBeat.o(76348);
        } else if (d.oD(19)) {
            AppMethodBeat.o(76348);
        } else {
            try {
                Object obj = new c(this, "mSysWebView", null).get();
                Log.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", obj);
                Object obj2 = new c(obj, "mProvider", null).get();
                Log.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", obj2);
                Object obj3 = new c(obj2, "mWebViewCore", null).get();
                Log.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", obj3);
                Object obj4 = new c(obj3, "sWebCoreHandler", null).get();
                Log.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", obj4);
                Object obj5 = new c(obj4, "mLooper", null).get();
                Log.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", obj5);
                Object obj6 = new c(obj5, "mThread", null).get();
                Log.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj6);
                if (obj6 instanceof Thread) {
                    Thread thread = (Thread) obj6;
                    Log.i("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == Thread.State.WAITING) {
                        thread.interrupt();
                    }
                }
                AppMethodBeat.o(76348);
            } catch (Exception e2) {
                Log.e("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
                AppMethodBeat.o(76348);
            }
        }
    }

    public final void a(a aVar, c cVar) {
        AppMethodBeat.i(76349);
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
        if (aVar != null) {
            super.setWebChromeClient(aVar);
        }
        if (cVar != null) {
            super.setWebViewClient(cVar);
        }
        Log.i("MicroMsg.Flight.FlightWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
        setBackgroundColor(-1);
        gYW();
        AppMethodBeat.o(76349);
    }

    @Override // com.tencent.mm.ui.widget.MMWebView, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void destroy() {
        AppMethodBeat.i(76350);
        this.context = null;
        super.setWebChromeClient(null);
        super.setWebViewClient(null);
        super.destroy();
        AppMethodBeat.o(76350);
    }

    public void setConfigCallback(WindowManager windowManager) {
        AppMethodBeat.i(76351);
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                AppMethodBeat.o(76351);
                return;
            }
            Field declaredField2 = declaredField.getType().getDeclaredField("mWindowManager");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, windowManager);
            AppMethodBeat.o(76351);
        } catch (Exception e2) {
            AppMethodBeat.o(76351);
        }
    }
}
