package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Function extends V8Object {
    public V8Function(V8 v8, JavaCallback javaCallback) {
        super(v8, javaCallback);
    }

    protected V8Function(V8 v8) {
        this(v8, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
    public V8Value createTwin() {
        AppMethodBeat.i(62116);
        V8Function v8Function = new V8Function(this.v8);
        AppMethodBeat.o(62116);
        return v8Function;
    }

    @Override // com.eclipsesource.v8.V8Object
    public String toString() {
        AppMethodBeat.i(62117);
        if (this.released || this.v8.isReleased()) {
            AppMethodBeat.o(62117);
            return "[Function released]";
        }
        String v8Object = super.toString();
        AppMethodBeat.o(62117);
        return v8Object;
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value
    public void initialize(long j2, Object obj) {
        AppMethodBeat.i(62118);
        if (obj == null) {
            super.initialize(j2, null);
            AppMethodBeat.o(62118);
            return;
        }
        long[] initNewV8Function = this.v8.initNewV8Function(j2);
        this.v8.createAndRegisterMethodDescriptor((JavaCallback) obj, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
        AppMethodBeat.o(62118);
    }

    @Override // com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Object, com.eclipsesource.v8.V8Value
    public V8Function twin() {
        AppMethodBeat.i(62119);
        V8Function v8Function = (V8Function) super.twin();
        AppMethodBeat.o(62119);
        return v8Function;
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        AppMethodBeat.i(62120);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Object);
        this.v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.v8;
        }
        Object executeFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), v8Object.isUndefined() ? this.v8.getHandle() : v8Object.getHandle(), this.objectHandle, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.o(62120);
        return executeFunction;
    }
}
