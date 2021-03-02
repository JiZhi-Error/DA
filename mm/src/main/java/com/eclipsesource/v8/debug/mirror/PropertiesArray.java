package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PropertiesArray implements Releasable {
    private V8Array v8Array;

    PropertiesArray(V8Array v8Array2) {
        AppMethodBeat.i(61516);
        this.v8Array = v8Array2.twin();
        AppMethodBeat.o(61516);
    }

    public PropertyMirror getProperty(int i2) {
        AppMethodBeat.i(61517);
        V8Object object = this.v8Array.getObject(i2);
        try {
            return new PropertyMirror(object);
        } finally {
            object.release();
            AppMethodBeat.o(61517);
        }
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61518);
        if (!this.v8Array.isReleased()) {
            this.v8Array.release();
        }
        AppMethodBeat.o(61518);
    }

    public int length() {
        AppMethodBeat.i(61519);
        int length = this.v8Array.length();
        AppMethodBeat.o(61519);
        return length;
    }
}
