package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1693a;

    /* renamed from: b  reason: collision with root package name */
    private final IX5JsVirtualMachine f1694b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<WeakReference<a>> f1695c;

    static class a implements IX5JsContext {

        /* renamed from: a  reason: collision with root package name */
        private WebView f1696a;

        public a(Context context) {
            AppMethodBeat.i(54487);
            this.f1696a = new WebView(context);
            this.f1696a.getSettings().setJavaScriptEnabled(true);
            AppMethodBeat.o(54487);
        }

        public void a() {
            AppMethodBeat.i(54488);
            if (this.f1696a == null) {
                AppMethodBeat.o(54488);
                return;
            }
            this.f1696a.onPause();
            AppMethodBeat.o(54488);
        }

        public void b() {
            AppMethodBeat.i(54489);
            if (this.f1696a == null) {
                AppMethodBeat.o(54489);
                return;
            }
            this.f1696a.onResume();
            AppMethodBeat.o(54489);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(Object obj, String str) {
            AppMethodBeat.i(54490);
            if (this.f1696a == null) {
                AppMethodBeat.o(54490);
                return;
            }
            this.f1696a.addJavascriptInterface(obj, str);
            this.f1696a.loadUrl("about:blank");
            AppMethodBeat.o(54490);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            AppMethodBeat.i(54491);
            if (this.f1696a == null) {
                AppMethodBeat.o(54491);
                return;
            }
            this.f1696a.clearHistory();
            this.f1696a.clearCache(true);
            this.f1696a.loadUrl("about:blank");
            this.f1696a.freeMemory();
            this.f1696a.pauseTimers();
            this.f1696a.destroy();
            this.f1696a = null;
            AppMethodBeat.o(54491);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(String str, final ValueCallback<String> valueCallback, URL url) {
            AppMethodBeat.i(54492);
            if (this.f1696a == null) {
                AppMethodBeat.o(54492);
                return;
            }
            this.f1696a.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() {
                /* class com.tencent.smtt.sdk.JsVirtualMachine.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
                public /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(54497);
                    a(str);
                    AppMethodBeat.o(54497);
                }

                public void a(String str) {
                    AppMethodBeat.i(54496);
                    valueCallback.onReceiveValue(str);
                    AppMethodBeat.o(54496);
                }
            });
            AppMethodBeat.o(54492);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public IX5JsValue evaluateScript(String str, URL url) {
            AppMethodBeat.i(54493);
            if (this.f1696a == null) {
                AppMethodBeat.o(54493);
            } else {
                this.f1696a.evaluateJavascript(str, null);
                AppMethodBeat.o(54493);
            }
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(String str, final ValueCallback<IX5JsValue> valueCallback, URL url) {
            AppMethodBeat.i(54494);
            if (this.f1696a == null) {
                AppMethodBeat.o(54494);
                return;
            }
            this.f1696a.evaluateJavascript(str, valueCallback == null ? null : new ValueCallback<String>() {
                /* class com.tencent.smtt.sdk.JsVirtualMachine.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback, com.tencent.smtt.sdk.ValueCallback
                public /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(54386);
                    a(str);
                    AppMethodBeat.o(54386);
                }

                public void a(String str) {
                    AppMethodBeat.i(54385);
                    valueCallback.onReceiveValue(null);
                    AppMethodBeat.o(54385);
                }
            });
            AppMethodBeat.o(54494);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(String str) {
            AppMethodBeat.i(54495);
            if (this.f1696a == null) {
                AppMethodBeat.o(54495);
                return;
            }
            this.f1696a.removeJavascriptInterface(str);
            AppMethodBeat.o(54495);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(ValueCallback<IX5JsError> valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i2) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i2, byte[] bArr) {
            return -1;
        }
    }

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    public JsVirtualMachine(Context context, Looper looper) {
        AppMethodBeat.i(55060);
        this.f1695c = new HashSet<>();
        this.f1693a = context;
        this.f1694b = X5JsCore.a(context, looper);
        AppMethodBeat.o(55060);
    }

    public final boolean isFallback() {
        return this.f1694b == null;
    }

    /* access modifiers changed from: protected */
    public final IX5JsContext a() {
        IX5JsContext createJsContext;
        AppMethodBeat.i(55061);
        if (this.f1694b == null) {
            createJsContext = new a(this.f1693a);
            this.f1695c.add(new WeakReference<>(createJsContext));
        } else {
            createJsContext = this.f1694b.createJsContext();
        }
        AppMethodBeat.o(55061);
        return createJsContext;
    }

    public final void destroy() {
        AppMethodBeat.i(55062);
        if (this.f1694b != null) {
            this.f1694b.destroy();
            AppMethodBeat.o(55062);
            return;
        }
        Iterator<WeakReference<a>> it = this.f1695c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().destroy();
            }
        }
        AppMethodBeat.o(55062);
    }

    public final Looper getLooper() {
        AppMethodBeat.i(55063);
        if (this.f1694b != null) {
            Looper looper = this.f1694b.getLooper();
            AppMethodBeat.o(55063);
            return looper;
        }
        Looper myLooper = Looper.myLooper();
        AppMethodBeat.o(55063);
        return myLooper;
    }

    public final void onPause() {
        AppMethodBeat.i(55064);
        if (this.f1694b != null) {
            this.f1694b.onPause();
            AppMethodBeat.o(55064);
            return;
        }
        Iterator<WeakReference<a>> it = this.f1695c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().a();
            }
        }
        AppMethodBeat.o(55064);
    }

    public final void onResume() {
        AppMethodBeat.i(55065);
        if (this.f1694b != null) {
            this.f1694b.onResume();
            AppMethodBeat.o(55065);
            return;
        }
        Iterator<WeakReference<a>> it = this.f1695c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().b();
            }
        }
        AppMethodBeat.o(55065);
    }
}
