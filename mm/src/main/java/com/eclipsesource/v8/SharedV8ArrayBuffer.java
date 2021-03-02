package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class SharedV8ArrayBuffer extends V8ArrayBuffer {
    private SharedV8ArrayBuffer(V8 v8, int i2) {
        super(v8, i2);
        AppMethodBeat.i(61650);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not support this way construct");
        AppMethodBeat.o(61650);
        throw illegalArgumentException;
    }

    public SharedV8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8, byteBuffer);
    }

    @Override // com.eclipsesource.v8.V8Value, com.eclipsesource.v8.Releasable
    public void release() {
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value, com.eclipsesource.v8.V8ArrayBuffer
    public void initialize(long j2, Object obj) {
        AppMethodBeat.i(61651);
        this.v8.checkThread();
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        this.objectHandle = this.v8.initNewSharedV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        this.released = false;
        addObjectReference(this.objectHandle);
        AppMethodBeat.o(61651);
    }

    public void manualRelease() {
        AppMethodBeat.i(61652);
        super.release();
        AppMethodBeat.o(61652);
    }
}
