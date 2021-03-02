package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.n;
import com.tencent.xweb.x5.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public final class h implements IJsRuntime {
    private JsContext SFj;
    private a SFk;
    private n SFl;
    private Context mContext;

    public h(Context context) {
        AppMethodBeat.i(153866);
        this.mContext = context;
        Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
        AppMethodBeat.o(153866);
    }

    @Override // com.tencent.xweb.internal.IJsRuntime
    public final void init(int i2) {
        AppMethodBeat.i(153867);
        this.SFj = new JsContext(this.mContext);
        this.SFk = new a();
        this.SFj.addJavascriptInterface(this.SFk, "nativeBufferCompat");
        this.SFj.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new a.d(new ValueCallback<String>() {
            /* class com.tencent.xweb.x5.h.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(153859);
                Log.i("MicroMsg.X5V8JsRuntime", "on inject nativeBufferCompat Object finished.");
                AppMethodBeat.o(153859);
            }
        }));
        this.SFj.setExceptionHandler(new JsContext.ExceptionHandler() {
            /* class com.tencent.xweb.x5.h.AnonymousClass2 */

            @Override // com.tencent.smtt.sdk.JsContext.ExceptionHandler
            public final void handleException(JsContext jsContext, JsError jsError) {
                AppMethodBeat.i(153860);
                if (jsError == null) {
                    Log.i("MicroMsg.X5V8JsRuntime", "jsError is null.");
                    AppMethodBeat.o(153860);
                    return;
                }
                Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", jsError.getMessage()));
                if (h.this.SFl != null) {
                    n unused = h.this.SFl;
                }
                AppMethodBeat.o(153860);
            }
        });
        AppMethodBeat.o(153867);
    }

    public static class a {
        private static final AtomicInteger QH = new AtomicInteger(1);
        private HashMap<Integer, byte[]> SFn = new HashMap<>();

        public a() {
            AppMethodBeat.i(153861);
            AppMethodBeat.o(153861);
        }

        static {
            AppMethodBeat.i(153865);
            AppMethodBeat.o(153865);
        }

        @JavascriptInterface
        public final int getNativeBufferId() {
            int i2;
            int i3;
            AppMethodBeat.i(153862);
            do {
                i2 = QH.get();
                i3 = i2 + 1;
                if (i3 > 16777215) {
                    i3 = 1;
                }
            } while (!QH.compareAndSet(i2, i3));
            AppMethodBeat.o(153862);
            return i2;
        }

        @JavascriptInterface
        public final void setNativeBuffer(int i2, byte[] bArr) {
            AppMethodBeat.i(153863);
            this.SFn.put(Integer.valueOf(i2), bArr);
            AppMethodBeat.o(153863);
        }

        @JavascriptInterface
        public final byte[] getNativeBuffer(int i2) {
            AppMethodBeat.i(153864);
            byte[] remove = this.SFn.remove(Integer.valueOf(i2));
            AppMethodBeat.o(153864);
            return remove;
        }
    }
}
