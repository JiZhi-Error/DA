package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Frame extends Mirror {
    private static final String ARGUMENT_COUNT = "argumentCount";
    private static final String ARGUMENT_NAME = "argumentName";
    private static final String ARGUMENT_VALUE = "argumentValue";
    private static final String COLUMN = "column";
    private static final String FUNC = "func";
    private static final String LINE = "line";
    private static final String LOCAL_COUNT = "localCount";
    private static final String LOCAL_NAME = "localName";
    private static final String LOCAL_VALUE = "localValue";
    private static final String NAME = "name";
    private static final String POSITION = "position";
    private static final String SCOPE = "scope";
    private static final String SCOPE_COUNT = "scopeCount";
    private static final String SCRIPT = "script";
    private static final String SOURCE_LOCATION = "sourceLocation";
    private static final String SOURCE_TEXT = "sourceText";

    public Frame(V8Object v8Object) {
        super(v8Object);
    }

    public int getScopeCount() {
        AppMethodBeat.i(61481);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(SCOPE_COUNT, null);
        AppMethodBeat.o(61481);
        return executeIntegerFunction;
    }

    public SourceLocation getSourceLocation() {
        String str;
        AppMethodBeat.i(61482);
        V8Object executeObjectFunction = this.v8Object.executeObjectFunction(SOURCE_LOCATION, null);
        FunctionMirror function = getFunction();
        String scriptName = function.getScriptName();
        try {
            V8Object v8Object = (V8Object) executeObjectFunction.get(SCRIPT);
            if (v8Object != null) {
                String string = v8Object.getString("name");
                v8Object.release();
                str = string;
            } else {
                str = null;
            }
            if (str != null || scriptName == null) {
                scriptName = "undefined";
            }
            return new SourceLocation(scriptName, executeObjectFunction.getInteger(POSITION), executeObjectFunction.getInteger(LINE), executeObjectFunction.getInteger(COLUMN), executeObjectFunction.getString(SOURCE_TEXT));
        } finally {
            function.release();
            executeObjectFunction.release();
            AppMethodBeat.o(61482);
        }
    }

    public int getArgumentCount() {
        AppMethodBeat.i(61483);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(ARGUMENT_COUNT, null);
        AppMethodBeat.o(61483);
        return executeIntegerFunction;
    }

    public String getArgumentName(int i2) {
        AppMethodBeat.i(61484);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i2);
        try {
            return this.v8Object.executeStringFunction(ARGUMENT_NAME, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61484);
        }
    }

    public ValueMirror getArgumentValue(int i2) {
        AppMethodBeat.i(61485);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i2);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(ARGUMENT_VALUE, v8Array);
            if (!isValue(v8Object)) {
                IllegalStateException illegalStateException = new IllegalStateException("Argument value is not a ValueMirror");
                AppMethodBeat.o(61485);
                throw illegalStateException;
            }
            return new ValueMirror(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(61485);
        }
    }

    public ValueMirror getLocalValue(int i2) {
        AppMethodBeat.i(61486);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i2);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction(LOCAL_VALUE, v8Array);
            if (!isValue(v8Object)) {
                IllegalStateException illegalStateException = new IllegalStateException("Local value is not a ValueMirror");
                AppMethodBeat.o(61486);
                throw illegalStateException;
            }
            return createMirror(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(61486);
        }
    }

    public int getLocalCount() {
        AppMethodBeat.i(61487);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(LOCAL_COUNT, null);
        AppMethodBeat.o(61487);
        return executeIntegerFunction;
    }

    public String getLocalName(int i2) {
        AppMethodBeat.i(61488);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i2);
        try {
            return this.v8Object.executeStringFunction(LOCAL_NAME, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61488);
        }
    }

    public Scope getScope(int i2) {
        AppMethodBeat.i(61489);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i2);
        V8Object v8Object = null;
        try {
            v8Object = this.v8Object.executeObjectFunction("scope", v8Array);
            return new Scope(v8Object);
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(61489);
        }
    }

    public FunctionMirror getFunction() {
        V8Object v8Object = null;
        AppMethodBeat.i(61490);
        try {
            v8Object = this.v8Object.executeObjectFunction(FUNC, null);
            return new FunctionMirror(v8Object);
        } finally {
            if (v8Object != null) {
                v8Object.release();
            }
            AppMethodBeat.o(61490);
        }
    }

    @Override // com.eclipsesource.v8.debug.mirror.Mirror
    public boolean isFrame() {
        return true;
    }
}
