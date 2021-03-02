package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.lang.Thread;
import java.lang.reflect.Field;

public class WebSearchWebView extends MMWebView {
    private Context context;

    public WebSearchWebView(Context context2) {
        super(context2);
        AppMethodBeat.i(198079);
        this.context = context2;
        init();
        AppMethodBeat.o(198079);
    }

    public WebSearchWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(198080);
        this.context = context2;
        init();
        AppMethodBeat.o(198080);
    }

    public WebSearchWebView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(198081);
        this.context = context2;
        init();
        AppMethodBeat.o(198081);
    }

    private void init() {
        AppMethodBeat.i(198082);
        Log.i("MicroMsg.WebSearch.WebSearchWebView", "init WebSearchWebView");
        this.gKM = true;
        kI(this.context);
        bQp();
        AppMethodBeat.o(198082);
    }

    private void bQp() {
        AppMethodBeat.i(198083);
        if (getIsX5Kernel()) {
            AppMethodBeat.o(198083);
        } else if (d.oD(19)) {
            AppMethodBeat.o(198083);
        } else {
            try {
                Object obj = new c(this, "mSysWebView", null).get();
                Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", obj);
                Object obj2 = new c(obj, "mProvider", null).get();
                Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", obj2);
                Object obj3 = new c(obj2, "mWebViewCore", null).get();
                Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", obj3);
                Object obj4 = new c(obj3, "sWebCoreHandler", null).get();
                Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", obj4);
                Object obj5 = new c(obj4, "mLooper", null).get();
                Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", obj5);
                Object obj6 = new c(obj5, "mThread", null).get();
                Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj6);
                if (obj6 instanceof Thread) {
                    Thread thread = (Thread) obj6;
                    Log.i("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == Thread.State.WAITING) {
                        thread.interrupt();
                    }
                }
                AppMethodBeat.o(198083);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
                AppMethodBeat.o(198083);
            }
        }
    }

    public final void a(x xVar, ac acVar) {
        AppMethodBeat.i(198084);
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
        if (xVar != null) {
            super.setWebChromeClient(xVar);
        }
        super.setWebViewClient(acVar);
        Log.i("MicroMsg.WebSearch.WebSearchWebView", "current webview core %s", getWebCoreType());
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        gYW();
        float f2 = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.iX(getContext()));
        if (f2 >= a.jd(getContext())) {
            getSettings().setTextZoom(148);
        } else if (f2 >= a.jc(getContext())) {
            getSettings().setTextZoom(140);
        } else if (f2 >= a.jb(getContext())) {
            getSettings().setTextZoom(132);
        } else if (f2 >= a.ja(getContext())) {
            getSettings().setTextZoom(124);
        } else if (f2 >= a.iZ(getContext())) {
            getSettings().setTextZoom(116);
        } else if (f2 >= a.iY(getContext())) {
            getSettings().setTextZoom(108);
        } else if (f2 >= a.iX(getContext())) {
            getSettings().setTextZoom(100);
        } else if (f2 >= a.iW(getContext())) {
            getSettings().setTextZoom(92);
        } else {
            getSettings().setTextZoom(80);
        }
        Log.i("MicroMsg.WebSearch.WebSearchWebView", "SetFontSize, fontSize = %f", Float.valueOf(f2));
        AppMethodBeat.o(198084);
    }

    public final void onDestroy() {
        AppMethodBeat.i(198085);
        this.context = null;
        super.setWebChromeClient(null);
        super.setWebViewClient(null);
        destroy();
        removeJavascriptInterface("topStoryJSApi");
        try {
            destroy();
            AppMethodBeat.o(198085);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchWebView", e2, "onDestroy", new Object[0]);
            AppMethodBeat.o(198085);
        }
    }

    public void setConfigCallback(WindowManager windowManager) {
        AppMethodBeat.i(198086);
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj == null) {
                AppMethodBeat.o(198086);
                return;
            }
            Field declaredField2 = declaredField.getType().getDeclaredField("mWindowManager");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, windowManager);
            AppMethodBeat.o(198086);
        } catch (Exception e2) {
            AppMethodBeat.o(198086);
        }
    }
}
