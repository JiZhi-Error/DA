package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ResultUndefined;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Mirror implements Releasable {
    private static final String IS_ARRAY = "isArray";
    private static final String IS_BOOLEAN = "isBoolean";
    private static final String IS_FUNCTION = "isFunction";
    private static final String IS_NULL = "isNull";
    private static final String IS_NUMBER = "isNumber";
    private static final String IS_OBJECT = "isObject";
    private static final String IS_STRING = "isString";
    private static final String IS_UNDEFINED = "isUndefined";
    private static final String IS_VALUE = "isValue";
    protected V8Object v8Object;

    Mirror(V8Object v8Object2) {
        AppMethodBeat.i(61493);
        this.v8Object = v8Object2.twin();
        AppMethodBeat.o(61493);
    }

    public boolean isUndefined() {
        AppMethodBeat.i(61494);
        boolean executeBooleanFunction = this.v8Object.executeBooleanFunction(IS_UNDEFINED, null);
        AppMethodBeat.o(61494);
        return executeBooleanFunction;
    }

    public boolean isValue() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isFunction() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isFrame() {
        return false;
    }

    public boolean isProperty() {
        return false;
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61495);
        if (this.v8Object != null && !this.v8Object.isReleased()) {
            this.v8Object.release();
            this.v8Object = null;
        }
        AppMethodBeat.o(61495);
    }

    protected static boolean isValue(V8Object v8Object2) {
        AppMethodBeat.i(61496);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_VALUE, null);
            AppMethodBeat.o(61496);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61496);
            return false;
        }
    }

    private static boolean isObject(V8Object v8Object2) {
        AppMethodBeat.i(61497);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_OBJECT, null);
            AppMethodBeat.o(61497);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61497);
            return false;
        }
    }

    private static boolean isNumber(V8Object v8Object2) {
        AppMethodBeat.i(61498);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_NUMBER, null);
            AppMethodBeat.o(61498);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61498);
            return false;
        }
    }

    private static boolean isBoolean(V8Object v8Object2) {
        AppMethodBeat.i(61499);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_BOOLEAN, null);
            AppMethodBeat.o(61499);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61499);
            return false;
        }
    }

    private static boolean isFunction(V8Object v8Object2) {
        AppMethodBeat.i(61500);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_FUNCTION, null);
            AppMethodBeat.o(61500);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61500);
            return false;
        }
    }

    private static boolean isArray(V8Object v8Object2) {
        AppMethodBeat.i(61501);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_ARRAY, null);
            AppMethodBeat.o(61501);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61501);
            return false;
        }
    }

    private static boolean isString(V8Object v8Object2) {
        AppMethodBeat.i(61502);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_STRING, null);
            AppMethodBeat.o(61502);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61502);
            return false;
        }
    }

    private static boolean isUndefined(V8Object v8Object2) {
        AppMethodBeat.i(61503);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_UNDEFINED, null);
            AppMethodBeat.o(61503);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61503);
            return false;
        }
    }

    private static boolean isNull(V8Object v8Object2) {
        AppMethodBeat.i(61504);
        try {
            boolean executeBooleanFunction = v8Object2.executeBooleanFunction(IS_NULL, null);
            AppMethodBeat.o(61504);
            return executeBooleanFunction;
        } catch (V8ResultUndefined e2) {
            AppMethodBeat.o(61504);
            return false;
        }
    }

    protected static ValueMirror createMirror(V8Object v8Object2) {
        AppMethodBeat.i(61505);
        if (isNull(v8Object2)) {
            NullMirror nullMirror = new NullMirror(v8Object2);
            AppMethodBeat.o(61505);
            return nullMirror;
        } else if (isUndefined(v8Object2)) {
            UndefinedMirror undefinedMirror = new UndefinedMirror(v8Object2);
            AppMethodBeat.o(61505);
            return undefinedMirror;
        } else if (isFunction(v8Object2)) {
            FunctionMirror functionMirror = new FunctionMirror(v8Object2);
            AppMethodBeat.o(61505);
            return functionMirror;
        } else if (isArray(v8Object2)) {
            ArrayMirror arrayMirror = new ArrayMirror(v8Object2);
            AppMethodBeat.o(61505);
            return arrayMirror;
        } else if (isObject(v8Object2)) {
            ObjectMirror objectMirror = new ObjectMirror(v8Object2);
            AppMethodBeat.o(61505);
            return objectMirror;
        } else if (isString(v8Object2)) {
            StringMirror stringMirror = new StringMirror(v8Object2);
            AppMethodBeat.o(61505);
            return stringMirror;
        } else if (isNumber(v8Object2)) {
            NumberMirror numberMirror = new NumberMirror(v8Object2);
            AppMethodBeat.o(61505);
            return numberMirror;
        } else if (isBoolean(v8Object2)) {
            BooleanMirror booleanMirror = new BooleanMirror(v8Object2);
            AppMethodBeat.o(61505);
            return booleanMirror;
        } else {
            ValueMirror valueMirror = new ValueMirror(v8Object2);
            AppMethodBeat.o(61505);
            return valueMirror;
        }
    }

    public String toString() {
        AppMethodBeat.i(61506);
        String v8Object2 = this.v8Object.toString();
        AppMethodBeat.o(61506);
        return v8Object2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(61507);
        if (obj == null) {
            AppMethodBeat.o(61507);
            return false;
        } else if (!(obj instanceof Mirror)) {
            AppMethodBeat.o(61507);
            return false;
        } else {
            boolean equals = this.v8Object.equals(((Mirror) obj).v8Object);
            AppMethodBeat.o(61507);
            return equals;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(61508);
        int hashCode = this.v8Object.hashCode();
        AppMethodBeat.o(61508);
        return hashCode;
    }
}
