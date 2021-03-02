package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Scope extends Mirror {
    private static final String SCOPE_OBJECT = "scopeObject";
    private static final String SCOPE_TYPE = "scopeType";
    private static final String SET_VARIABLE_VALUE = "setVariableValue";

    public enum ScopeType {
        Global(0),
        Local(1),
        With(2),
        Closure(3),
        Catch(4),
        Block(5),
        Script(6);
        
        int index;

        public static ScopeType valueOf(String str) {
            AppMethodBeat.i(61523);
            ScopeType scopeType = (ScopeType) Enum.valueOf(ScopeType.class, str);
            AppMethodBeat.o(61523);
            return scopeType;
        }

        static {
            AppMethodBeat.i(61524);
            AppMethodBeat.o(61524);
        }

        private ScopeType(int i2) {
            this.index = i2;
        }
    }

    Scope(V8Object v8Object) {
        super(v8Object);
    }

    public ScopeType getType() {
        AppMethodBeat.i(61525);
        ScopeType scopeType = ScopeType.values()[this.v8Object.executeIntegerFunction(SCOPE_TYPE, null)];
        AppMethodBeat.o(61525);
        return scopeType;
    }

    public void setVariableValue(String str, int i2) {
        AppMethodBeat.i(61526);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(i2);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61526);
        }
    }

    public void setVariableValue(String str, V8Value v8Value) {
        AppMethodBeat.i(61527);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(v8Value);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61527);
        }
    }

    public void setVariableValue(String str, boolean z) {
        AppMethodBeat.i(61528);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(z);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61528);
        }
    }

    public void setVariableValue(String str, String str2) {
        AppMethodBeat.i(61529);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(str2);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61529);
        }
    }

    public void setVariableValue(String str, double d2) {
        AppMethodBeat.i(61530);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(str);
        v8Array.push(d2);
        try {
            this.v8Object.executeVoidFunction(SET_VARIABLE_VALUE, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61530);
        }
    }

    public ObjectMirror getScopeObject() {
        V8Object v8Object = null;
        AppMethodBeat.i(61531);
        try {
            v8Object = this.v8Object.executeObjectFunction(SCOPE_OBJECT, null);
            return (ObjectMirror) createMirror(v8Object);
        } finally {
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(61531);
        }
    }
}
