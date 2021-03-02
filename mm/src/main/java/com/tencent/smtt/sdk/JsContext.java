package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext {

    /* renamed from: a  reason: collision with root package name */
    private final JsVirtualMachine f1683a;

    /* renamed from: b  reason: collision with root package name */
    private final IX5JsContext f1684b;

    /* renamed from: c  reason: collision with root package name */
    private ExceptionHandler f1685c;

    /* renamed from: d  reason: collision with root package name */
    private String f1686d;

    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
        AppMethodBeat.i(55066);
        AppMethodBeat.o(55066);
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        AppMethodBeat.i(55067);
        if (jsVirtualMachine == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The virtualMachine value can not be null");
            AppMethodBeat.o(55067);
            throw illegalArgumentException;
        }
        this.f1683a = jsVirtualMachine;
        this.f1684b = this.f1683a.a();
        try {
            this.f1684b.setPerContextData(this);
            AppMethodBeat.o(55067);
        } catch (AbstractMethodError e2) {
            AppMethodBeat.o(55067);
        }
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(55068);
        this.f1684b.addJavascriptInterface(obj, str);
        AppMethodBeat.o(55068);
    }

    public final void destroy() {
        AppMethodBeat.i(55069);
        this.f1684b.destroy();
        AppMethodBeat.o(55069);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(55070);
        evaluateJavascript(str, valueCallback, null);
        AppMethodBeat.o(55070);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.i(55071);
        this.f1684b.evaluateJavascript(str, valueCallback, url);
        AppMethodBeat.o(55071);
    }

    public final JsValue evaluateScript(String str) {
        AppMethodBeat.i(55072);
        JsValue evaluateScript = evaluateScript(str, null);
        AppMethodBeat.o(55072);
        return evaluateScript;
    }

    public final JsValue evaluateScript(String str, URL url) {
        AppMethodBeat.i(55073);
        IX5JsValue evaluateScript = this.f1684b.evaluateScript(str, url);
        if (evaluateScript == null) {
            AppMethodBeat.o(55073);
            return null;
        }
        JsValue jsValue = new JsValue(this, evaluateScript);
        AppMethodBeat.o(55073);
        return jsValue;
    }

    public final void evaluateScriptAsync(String str, final ValueCallback<JsValue> valueCallback, URL url) {
        AnonymousClass1 r0;
        AppMethodBeat.i(55074);
        if (valueCallback == null) {
            r0 = null;
        } else {
            r0 = new ValueCallback<IX5JsValue>() {
                /* class com.tencent.smtt.sdk.JsContext.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public /* synthetic */ void onReceiveValue(IX5JsValue iX5JsValue) {
                    AppMethodBeat.i(55319);
                    a(iX5JsValue);
                    AppMethodBeat.o(55319);
                }

                public void a(IX5JsValue iX5JsValue) {
                    AppMethodBeat.i(55318);
                    valueCallback.onReceiveValue(iX5JsValue == null ? null : new JsValue(JsContext.this, iX5JsValue));
                    AppMethodBeat.o(55318);
                }
            };
        }
        this.f1684b.evaluateScriptAsync(str, r0, url);
        AppMethodBeat.o(55074);
    }

    public final ExceptionHandler exceptionHandler() {
        return this.f1685c;
    }

    public final String name() {
        return this.f1686d;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(55075);
        this.f1684b.removeJavascriptInterface(str);
        AppMethodBeat.o(55075);
    }

    public final void setExceptionHandler(ExceptionHandler exceptionHandler) {
        AppMethodBeat.i(55076);
        this.f1685c = exceptionHandler;
        if (exceptionHandler == null) {
            this.f1684b.setExceptionHandler(null);
            AppMethodBeat.o(55076);
            return;
        }
        this.f1684b.setExceptionHandler(new ValueCallback<IX5JsError>() {
            /* class com.tencent.smtt.sdk.JsContext.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public /* synthetic */ void onReceiveValue(IX5JsError iX5JsError) {
                AppMethodBeat.i(55022);
                a(iX5JsError);
                AppMethodBeat.o(55022);
            }

            public void a(IX5JsError iX5JsError) {
                AppMethodBeat.i(55021);
                JsContext.this.f1685c.handleException(JsContext.this, new JsError(iX5JsError));
                AppMethodBeat.o(55021);
            }
        });
        AppMethodBeat.o(55076);
    }

    public final void setName(String str) {
        AppMethodBeat.i(55077);
        this.f1686d = str;
        this.f1684b.setName(str);
        AppMethodBeat.o(55077);
    }

    public final void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        AppMethodBeat.i(55078);
        this.f1684b.stealValueFromOtherCtx(str, jsContext.f1684b, str2);
        AppMethodBeat.o(55078);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.i(55079);
        int nativeBufferId = this.f1684b.getNativeBufferId();
        AppMethodBeat.o(55079);
        return nativeBufferId;
    }

    public final byte[] getNativeBuffer(int i2) {
        AppMethodBeat.i(55080);
        byte[] nativeBuffer = this.f1684b.getNativeBuffer(i2);
        AppMethodBeat.o(55080);
        return nativeBuffer;
    }

    public final int setNativeBuffer(int i2, byte[] bArr) {
        AppMethodBeat.i(55081);
        int nativeBuffer = this.f1684b.setNativeBuffer(i2, bArr);
        AppMethodBeat.o(55081);
        return nativeBuffer;
    }

    public final JsVirtualMachine virtualMachine() {
        return this.f1683a;
    }

    public static JsContext current() {
        AppMethodBeat.i(55082);
        JsContext jsContext = (JsContext) X5JsCore.a();
        AppMethodBeat.o(55082);
        return jsContext;
    }
}
