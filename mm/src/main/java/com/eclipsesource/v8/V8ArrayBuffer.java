package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class V8ArrayBuffer extends V8Value {
    private ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v8, int i2) {
        super(v8);
        AppMethodBeat.i(62066);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i2));
        this.byteBuffer = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i2);
        this.byteBuffer.order(ByteOrder.nativeOrder());
        AppMethodBeat.o(62066);
    }

    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer2) {
        super(v8);
        AppMethodBeat.i(62067);
        if (!byteBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
            AppMethodBeat.o(62067);
            throw illegalArgumentException;
        }
        initialize(v8.getV8RuntimePtr(), byteBuffer2);
        this.byteBuffer = byteBuffer2;
        byteBuffer2.order(ByteOrder.nativeOrder());
        AppMethodBeat.o(62067);
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value
    public void initialize(long j2, Object obj) {
        AppMethodBeat.i(62068);
        this.v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer2 = (ByteBuffer) obj;
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer2, byteBuffer2.limit());
        } else {
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
        AppMethodBeat.o(62068);
    }

    /* access modifiers changed from: protected */
    @Override // com.eclipsesource.v8.V8Value
    public V8Value createTwin() {
        AppMethodBeat.i(62069);
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(this.v8, this.byteBuffer);
        AppMethodBeat.o(62069);
        return v8ArrayBuffer;
    }

    @Override // com.eclipsesource.v8.V8Value
    public V8ArrayBuffer twin() {
        AppMethodBeat.i(62070);
        V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) super.twin();
        AppMethodBeat.o(62070);
        return v8ArrayBuffer;
    }

    public ByteBuffer getBackingStore() {
        AppMethodBeat.i(62071);
        this.v8.checkReleased();
        this.v8.checkThread();
        ByteBuffer byteBuffer2 = this.byteBuffer;
        AppMethodBeat.o(62071);
        return byteBuffer2;
    }
}
