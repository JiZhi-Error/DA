package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public class X5JsCore extends z {

    /* renamed from: a  reason: collision with root package name */
    private static a f1942a = a.UNINITIALIZED;

    /* renamed from: b  reason: collision with root package name */
    private static a f1943b = a.UNINITIALIZED;

    /* renamed from: c  reason: collision with root package name */
    private static a f1944c = a.UNINITIALIZED;

    /* renamed from: d  reason: collision with root package name */
    private final Context f1945d;

    /* renamed from: e  reason: collision with root package name */
    private Object f1946e = null;

    /* renamed from: f  reason: collision with root package name */
    private WebView f1947f = null;

    /* access modifiers changed from: package-private */
    public enum a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE;

        public static a valueOf(String str) {
            AppMethodBeat.i(55110);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(55110);
            return aVar;
        }

        static {
            AppMethodBeat.i(55111);
            AppMethodBeat.o(55111);
        }
    }

    public static boolean canUseX5JsCoreNewAPI(Context context) {
        AppMethodBeat.i(54537);
        if (f1944c == a.UNINITIALIZED) {
            f1944c = a.UNAVAILABLE;
            if (b() == null ? false : b().canUseX5JsCoreNewAPI(context)) {
                f1944c = a.AVAILABLE;
                AppMethodBeat.o(54537);
                return true;
            }
            AppMethodBeat.o(54537);
            return false;
        } else if (f1944c == a.AVAILABLE) {
            AppMethodBeat.o(54537);
            return true;
        } else {
            AppMethodBeat.o(54537);
            return false;
        }
    }

    private static IX5CoreJsCore b() {
        AppMethodBeat.i(54538);
        if (x.a().b()) {
            IX5CoreJsCore jSCoreImpl = getJSCoreImpl();
            AppMethodBeat.o(54538);
            return jSCoreImpl;
        }
        AppMethodBeat.o(54538);
        return null;
    }

    public static boolean canUseX5JsCore(Context context) {
        AppMethodBeat.i(54539);
        if (f1942a == a.UNINITIALIZED) {
            f1942a = a.UNAVAILABLE;
            if (b() == null ? false : b().canUseX5JsCore(context)) {
                b().setJsValueFactory(JsValue.factory());
                f1942a = a.AVAILABLE;
                AppMethodBeat.o(54539);
                return true;
            }
            AppMethodBeat.o(54539);
            return false;
        } else if (f1942a == a.AVAILABLE) {
            AppMethodBeat.o(54539);
            return true;
        } else {
            AppMethodBeat.o(54539);
            return false;
        }
    }

    public static boolean canX5JsCoreUseNativeBuffer(Context context) {
        AppMethodBeat.i(54540);
        if (f1943b == a.UNINITIALIZED) {
            f1943b = a.UNAVAILABLE;
            if (!canUseX5JsCore(context)) {
                AppMethodBeat.o(54540);
                return false;
            } else if (b().canX5JsCoreUseBuffer(context)) {
                f1943b = a.AVAILABLE;
                AppMethodBeat.o(54540);
                return true;
            } else {
                AppMethodBeat.o(54540);
                return false;
            }
        } else if (f1943b == a.AVAILABLE) {
            AppMethodBeat.o(54540);
            return true;
        } else {
            AppMethodBeat.o(54540);
            return false;
        }
    }

    protected static IX5JsVirtualMachine a(Context context, Looper looper) {
        AppMethodBeat.i(54541);
        if (canUseX5JsCore(context)) {
            IX5JsVirtualMachine createX5JsVirtualMachine = b().createX5JsVirtualMachine(context, looper);
            AppMethodBeat.o(54541);
            return createX5JsVirtualMachine;
        }
        AppMethodBeat.o(54541);
        return null;
    }

    protected static Object a() {
        AppMethodBeat.i(54542);
        Object currentContextData = b().currentContextData();
        AppMethodBeat.o(54542);
        return currentContextData;
    }

    @Deprecated
    public X5JsCore(Context context) {
        Object createX5JavaBridge;
        AppMethodBeat.i(54543);
        this.f1945d = context;
        if (!canUseX5JsCore(context) || (createX5JavaBridge = b().createX5JavaBridge(context)) == null) {
            this.f1947f = new WebView(context);
            this.f1947f.getSettings().setJavaScriptEnabled(true);
            AppMethodBeat.o(54543);
            return;
        }
        this.f1946e = createX5JavaBridge;
        AppMethodBeat.o(54543);
    }

    @Deprecated
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(54544);
        if (this.f1946e != null) {
            b().addJavascriptInterface(obj, str, this.f1946e);
            AppMethodBeat.o(54544);
            return;
        }
        if (this.f1947f != null) {
            this.f1947f.addJavascriptInterface(obj, str);
            this.f1947f.loadUrl("about:blank");
        }
        AppMethodBeat.o(54544);
    }

    @Deprecated
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(54545);
        if (this.f1946e != null) {
            b().removeJavascriptInterface(str, this.f1946e);
            AppMethodBeat.o(54545);
            return;
        }
        if (this.f1947f != null) {
            this.f1947f.removeJavascriptInterface(str);
        }
        AppMethodBeat.o(54545);
    }

    @Deprecated
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(54546);
        if (this.f1946e != null) {
            b().evaluateJavaScript(str, valueCallback, this.f1946e);
            AppMethodBeat.o(54546);
            return;
        }
        if (this.f1947f != null) {
            this.f1947f.evaluateJavascript(str, valueCallback);
        }
        AppMethodBeat.o(54546);
    }

    @Deprecated
    public void pauseTimers() {
        AppMethodBeat.i(54547);
        if (this.f1946e != null) {
            b().pauseTimers(this.f1946e);
        }
        AppMethodBeat.o(54547);
    }

    @Deprecated
    public void resumeTimers() {
        AppMethodBeat.i(54548);
        if (this.f1946e != null) {
            b().resumeTimers(this.f1946e);
        }
        AppMethodBeat.o(54548);
    }

    @Deprecated
    public void pause() {
        AppMethodBeat.i(54549);
        if (this.f1946e != null) {
            b().pause(this.f1946e);
        }
        AppMethodBeat.o(54549);
    }

    @Deprecated
    public void resume() {
        AppMethodBeat.i(54550);
        if (this.f1946e != null) {
            b().resume(this.f1946e);
        }
        AppMethodBeat.o(54550);
    }

    @Deprecated
    public int getNativeBufferId() {
        AppMethodBeat.i(54551);
        if (this.f1946e == null || !canX5JsCoreUseNativeBuffer(this.f1945d)) {
            AppMethodBeat.o(54551);
            return -1;
        }
        int nativeBufferId = b().getNativeBufferId(this.f1946e);
        AppMethodBeat.o(54551);
        return nativeBufferId;
    }

    @Deprecated
    public void setNativeBuffer(int i2, ByteBuffer byteBuffer) {
        AppMethodBeat.i(54552);
        if (this.f1946e != null && canX5JsCoreUseNativeBuffer(this.f1945d)) {
            b().setNativeBuffer(this.f1946e, i2, byteBuffer);
        }
        AppMethodBeat.o(54552);
    }

    @Deprecated
    public ByteBuffer getNativeBuffer(int i2) {
        AppMethodBeat.i(54553);
        if (this.f1946e == null || !canX5JsCoreUseNativeBuffer(this.f1945d)) {
            AppMethodBeat.o(54553);
            return null;
        }
        ByteBuffer nativeBuffer = b().getNativeBuffer(this.f1946e, i2);
        AppMethodBeat.o(54553);
        return nativeBuffer;
    }

    @Deprecated
    public void destroy() {
        AppMethodBeat.i(54554);
        if (this.f1946e != null) {
            b().destroyX5JsCore(this.f1946e);
            this.f1946e = null;
            AppMethodBeat.o(54554);
            return;
        }
        if (this.f1947f != null) {
            this.f1947f.clearHistory();
            this.f1947f.clearCache(true);
            this.f1947f.loadUrl("about:blank");
            this.f1947f.freeMemory();
            this.f1947f.pauseTimers();
            this.f1947f.destroy();
            this.f1947f = null;
        }
        AppMethodBeat.o(54554);
    }
}
