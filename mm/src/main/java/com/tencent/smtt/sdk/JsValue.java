package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.nio.ByteBuffer;

public class JsValue {

    /* renamed from: a  reason: collision with root package name */
    private final JsContext f1691a;

    /* renamed from: b  reason: collision with root package name */
    private final IX5JsValue f1692b;

    static class a implements IX5JsValue.JsValueFactory {
        private a() {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public String getJsValueClassName() {
            AppMethodBeat.i(54153);
            String name = JsValue.class.getName();
            AppMethodBeat.o(54153);
            return name;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public IX5JsValue unwrap(Object obj) {
            AppMethodBeat.i(54154);
            if (obj == null || !(obj instanceof JsValue)) {
                AppMethodBeat.o(54154);
                return null;
            }
            IX5JsValue iX5JsValue = ((JsValue) obj).f1692b;
            AppMethodBeat.o(54154);
            return iX5JsValue;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory
        public Object wrap(IX5JsValue iX5JsValue) {
            JsContext current;
            AppMethodBeat.i(54155);
            if (iX5JsValue == null || (current = JsContext.current()) == null) {
                AppMethodBeat.o(54155);
                return null;
            }
            JsValue jsValue = new JsValue(current, iX5JsValue);
            AppMethodBeat.o(54155);
            return jsValue;
        }
    }

    public static IX5JsValue.JsValueFactory factory() {
        AppMethodBeat.i(55293);
        a aVar = new a();
        AppMethodBeat.o(55293);
        return aVar;
    }

    protected JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.f1691a = jsContext;
        this.f1692b = iX5JsValue;
    }

    public boolean isUndefined() {
        AppMethodBeat.i(55294);
        boolean isUndefined = this.f1692b.isUndefined();
        AppMethodBeat.o(55294);
        return isUndefined;
    }

    public boolean isNull() {
        AppMethodBeat.i(55295);
        boolean isNull = this.f1692b.isNull();
        AppMethodBeat.o(55295);
        return isNull;
    }

    public boolean isArray() {
        AppMethodBeat.i(55296);
        boolean isArray = this.f1692b.isArray();
        AppMethodBeat.o(55296);
        return isArray;
    }

    public boolean isBoolean() {
        AppMethodBeat.i(55297);
        boolean isBoolean = this.f1692b.isBoolean();
        AppMethodBeat.o(55297);
        return isBoolean;
    }

    public boolean toBoolean() {
        AppMethodBeat.i(55298);
        boolean z = this.f1692b.toBoolean();
        AppMethodBeat.o(55298);
        return z;
    }

    public boolean isInteger() {
        AppMethodBeat.i(55299);
        boolean isInteger = this.f1692b.isInteger();
        AppMethodBeat.o(55299);
        return isInteger;
    }

    public int toInteger() {
        AppMethodBeat.i(55300);
        int integer = this.f1692b.toInteger();
        AppMethodBeat.o(55300);
        return integer;
    }

    public boolean isNumber() {
        AppMethodBeat.i(55301);
        boolean isNumber = this.f1692b.isNumber();
        AppMethodBeat.o(55301);
        return isNumber;
    }

    public Number toNumber() {
        AppMethodBeat.i(55302);
        Number number = this.f1692b.toNumber();
        AppMethodBeat.o(55302);
        return number;
    }

    public boolean isString() {
        AppMethodBeat.i(55303);
        boolean isString = this.f1692b.isString();
        AppMethodBeat.o(55303);
        return isString;
    }

    public String toString() {
        AppMethodBeat.i(55304);
        String iX5JsValue = this.f1692b.toString();
        AppMethodBeat.o(55304);
        return iX5JsValue;
    }

    public boolean isObject() {
        AppMethodBeat.i(55305);
        boolean isObject = this.f1692b.isObject();
        AppMethodBeat.o(55305);
        return isObject;
    }

    public <T> T toObject(Class<T> cls) {
        AppMethodBeat.i(55306);
        T t = (T) this.f1692b.toObject(cls);
        AppMethodBeat.o(55306);
        return t;
    }

    public boolean isJavascriptInterface() {
        AppMethodBeat.i(55307);
        boolean isJavascriptInterface = this.f1692b.isJavascriptInterface();
        AppMethodBeat.o(55307);
        return isJavascriptInterface;
    }

    public Object toJavascriptInterface() {
        AppMethodBeat.i(55308);
        Object javascriptInterface = this.f1692b.toJavascriptInterface();
        AppMethodBeat.o(55308);
        return javascriptInterface;
    }

    public boolean isArrayBufferOrArrayBufferView() {
        AppMethodBeat.i(55309);
        boolean isArrayBufferOrArrayBufferView = this.f1692b.isArrayBufferOrArrayBufferView();
        AppMethodBeat.o(55309);
        return isArrayBufferOrArrayBufferView;
    }

    public ByteBuffer toByteBuffer() {
        AppMethodBeat.i(55310);
        ByteBuffer byteBuffer = this.f1692b.toByteBuffer();
        AppMethodBeat.o(55310);
        return byteBuffer;
    }

    public boolean isFunction() {
        AppMethodBeat.i(55311);
        boolean isFunction = this.f1692b.isFunction();
        AppMethodBeat.o(55311);
        return isFunction;
    }

    public JsValue call(Object... objArr) {
        AppMethodBeat.i(55312);
        JsValue a2 = a(this.f1692b.call(objArr));
        AppMethodBeat.o(55312);
        return a2;
    }

    public JsValue construct(Object... objArr) {
        AppMethodBeat.i(55313);
        JsValue a2 = a(this.f1692b.construct(objArr));
        AppMethodBeat.o(55313);
        return a2;
    }

    public boolean isPromise() {
        AppMethodBeat.i(55314);
        boolean isPromise = this.f1692b.isPromise();
        AppMethodBeat.o(55314);
        return isPromise;
    }

    public void resolve(Object obj) {
        AppMethodBeat.i(55315);
        this.f1692b.resolveOrReject(obj, true);
        AppMethodBeat.o(55315);
    }

    public void reject(Object obj) {
        AppMethodBeat.i(55316);
        this.f1692b.resolveOrReject(obj, false);
        AppMethodBeat.o(55316);
    }

    public JsContext context() {
        return this.f1691a;
    }

    private JsValue a(IX5JsValue iX5JsValue) {
        AppMethodBeat.i(55317);
        if (iX5JsValue == null) {
            AppMethodBeat.o(55317);
            return null;
        }
        JsValue jsValue = new JsValue(this.f1691a, iX5JsValue);
        AppMethodBeat.o(55317);
        return jsValue;
    }
}
