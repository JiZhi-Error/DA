package com.tencent.smtt.sdk.b;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreJsCore;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import com.tencent.smtt.sdk.JsValue;
import com.tencent.smtt.sdk.TbsWizard;
import java.nio.ByteBuffer;

public class n implements IX5CoreJsCore {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f2004a;

    public n(DexLoader dexLoader) {
        this.f2004a = dexLoader;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public IX5JsVirtualMachine createX5JsVirtualMachine(Context context, Looper looper) {
        AppMethodBeat.i(188493);
        Object a2 = a("createX5JsVirtualMachine", new Class[]{Context.class, Looper.class}, context, looper);
        if (a2 != null) {
            IX5JsVirtualMachine iX5JsVirtualMachine = (IX5JsVirtualMachine) a2;
            AppMethodBeat.o(188493);
            return iX5JsVirtualMachine;
        }
        AppMethodBeat.o(188493);
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public Object currentContextData() {
        AppMethodBeat.i(188494);
        Object a2 = a("currentContextData", new Class[0], new Object[0]);
        AppMethodBeat.o(188494);
        return a2;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void setJsValueFactory(Object obj) {
        AppMethodBeat.i(188495);
        a("setJsValueFactory", new Class[]{Object.class}, JsValue.factory());
        AppMethodBeat.o(188495);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void addJavascriptInterface(Object obj, String str, Object obj2) {
        AppMethodBeat.i(188496);
        a("addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, obj, str, obj2);
        AppMethodBeat.o(188496);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void removeJavascriptInterface(String str, Object obj) {
        AppMethodBeat.i(188497);
        a("removeJavascriptInterface", new Class[]{String.class, Object.class}, str, obj);
        AppMethodBeat.o(188497);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void evaluateJavaScript(String str, ValueCallback<String> valueCallback, Object obj) {
        AppMethodBeat.i(188498);
        a("evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, str, valueCallback, obj);
        AppMethodBeat.o(188498);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void destroyX5JsCore(Object obj) {
        AppMethodBeat.i(188499);
        a("destroyX5JsCore", new Class[]{Object.class}, obj);
        AppMethodBeat.o(188499);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void pauseTimers(Object obj) {
        AppMethodBeat.i(188500);
        a("pauseTimers", new Class[]{Object.class}, obj);
        AppMethodBeat.o(188500);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void resumeTimers(Object obj) {
        AppMethodBeat.i(188501);
        a("resumeTimers", new Class[]{Object.class}, obj);
        AppMethodBeat.o(188501);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void pause(Object obj) {
        AppMethodBeat.i(188502);
        a("pause", new Class[]{Object.class}, obj);
        AppMethodBeat.o(188502);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void resume(Object obj) {
        AppMethodBeat.i(188503);
        a("resume", new Class[]{Object.class}, obj);
        AppMethodBeat.o(188503);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public int getNativeBufferId(Object obj) {
        AppMethodBeat.i(188504);
        Object a2 = a("getNativeBufferId", new Class[]{Object.class}, obj);
        if (a2 == null || !(a2 instanceof Integer)) {
            AppMethodBeat.o(188504);
            return -1;
        }
        int intValue = ((Integer) a2).intValue();
        AppMethodBeat.o(188504);
        return intValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public void setNativeBuffer(Object obj, int i2, ByteBuffer byteBuffer) {
        AppMethodBeat.i(188505);
        a("setNativeBuffer", new Class[]{Object.class, Integer.TYPE, ByteBuffer.class}, obj, Integer.valueOf(i2), byteBuffer);
        AppMethodBeat.o(188505);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public ByteBuffer getNativeBuffer(Object obj, int i2) {
        AppMethodBeat.i(188506);
        Object a2 = a("getNativeBuffer", new Class[]{Object.class, Integer.TYPE}, obj, Integer.valueOf(i2));
        if (a2 == null || !(a2 instanceof ByteBuffer)) {
            AppMethodBeat.o(188506);
            return null;
        }
        ByteBuffer byteBuffer = (ByteBuffer) a2;
        AppMethodBeat.o(188506);
        return byteBuffer;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public boolean canUseX5JsCore(Context context) {
        AppMethodBeat.i(188507);
        Object a2 = a("canUseX5JsCore", new Class[]{Context.class}, context);
        if (a2 == null || !(a2 instanceof Boolean)) {
            AppMethodBeat.o(188507);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(188507);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public boolean canUseX5JsCoreNewAPI(Context context) {
        AppMethodBeat.i(188508);
        Object a2 = a("canUseX5JsCoreNewAPI", new Class[]{Context.class}, context);
        if (a2 == null || !(a2 instanceof Boolean)) {
            AppMethodBeat.o(188508);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(188508);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public boolean canX5JsCoreUseBuffer(Context context) {
        AppMethodBeat.i(188509);
        Object a2 = a("canX5JsCoreUseBuffer", new Class[]{Context.class}, context);
        if (a2 == null || !(a2 instanceof Boolean)) {
            AppMethodBeat.o(188509);
            return false;
        }
        boolean booleanValue = ((Boolean) a2).booleanValue();
        AppMethodBeat.o(188509);
        return booleanValue;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5CoreJsCore
    public Object createX5JavaBridge(Context context) {
        AppMethodBeat.i(188510);
        Object a2 = a("createX5JavaBridge", new Class[]{Context.class}, context);
        AppMethodBeat.o(188510);
        return a2;
    }

    private Object a(String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(188511);
        try {
            Object invokeStaticMethod = this.f2004a.invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, str, clsArr, objArr);
            AppMethodBeat.o(188511);
            return invokeStaticMethod;
        } catch (Exception e2) {
            AppMethodBeat.o(188511);
            return null;
        }
    }
}
