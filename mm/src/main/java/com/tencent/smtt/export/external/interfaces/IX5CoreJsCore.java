package com.tencent.smtt.export.external.interfaces;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.nio.ByteBuffer;

public interface IX5CoreJsCore {
    void addJavascriptInterface(Object obj, String str, Object obj2);

    boolean canUseX5JsCore(Context context);

    boolean canUseX5JsCoreNewAPI(Context context);

    boolean canX5JsCoreUseBuffer(Context context);

    Object createX5JavaBridge(Context context);

    IX5JsVirtualMachine createX5JsVirtualMachine(Context context, Looper looper);

    Object currentContextData();

    void destroyX5JsCore(Object obj);

    void evaluateJavaScript(String str, ValueCallback<String> valueCallback, Object obj);

    ByteBuffer getNativeBuffer(Object obj, int i2);

    int getNativeBufferId(Object obj);

    void pause(Object obj);

    void pauseTimers(Object obj);

    void removeJavascriptInterface(String str, Object obj);

    void resume(Object obj);

    void resumeTimers(Object obj);

    void setJsValueFactory(Object obj);

    void setNativeBuffer(Object obj, int i2, ByteBuffer byteBuffer);
}
