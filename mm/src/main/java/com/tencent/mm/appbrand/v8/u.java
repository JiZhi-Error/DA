package com.tencent.mm.appbrand.v8;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class u implements e {
    private final AtomicInteger dqV = new AtomicInteger(0);
    private final AtomicInteger dqW = new AtomicInteger(0);
    private final SparseArray<ByteBuffer> dqX = new SparseArray<>();

    public u() {
        AppMethodBeat.i(144103);
        AppMethodBeat.o(144103);
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public final int generateId() {
        int addAndGet;
        AppMethodBeat.i(144104);
        synchronized (this) {
            try {
                addAndGet = this.dqV.addAndGet(1);
                this.dqX.put(addAndGet, null);
            } catch (Throwable th) {
                AppMethodBeat.o(144104);
                throw th;
            }
        }
        Log.i("V8EngineBufferStore", "generateId:%d", Integer.valueOf(addAndGet));
        AppMethodBeat.o(144104);
        return addAndGet;
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public final ByteBuffer getBuffer(int i2, boolean z) {
        ByteBuffer byteBuffer;
        AppMethodBeat.i(216907);
        synchronized (this) {
            try {
                byteBuffer = this.dqX.get(i2);
                this.dqX.remove(i2);
            } catch (Throwable th) {
                AppMethodBeat.o(216907);
                throw th;
            }
        }
        if (byteBuffer == null) {
            Log.e("V8EngineBufferStore", "getBuffer:%d not contains", Integer.valueOf(i2));
            AppMethodBeat.o(216907);
            return null;
        }
        Log.i("V8EngineBufferStore", "getBuffer:%d remains[%d]", Integer.valueOf(i2), Integer.valueOf(this.dqW.addAndGet(-byteBuffer.capacity())));
        AppMethodBeat.o(216907);
        return byteBuffer;
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public final void setBuffer(int i2, ByteBuffer byteBuffer) {
        AppMethodBeat.i(144106);
        if (byteBuffer == null) {
            AppMethodBeat.o(144106);
            return;
        }
        ByteBuffer q = x.q(byteBuffer);
        if (!q.isDirect()) {
            Log.i("V8EngineBufferStore", "setBuffer:%d cannot convert to direct buffer", Integer.valueOf(i2));
            AppMethodBeat.o(144106);
            return;
        }
        synchronized (this) {
            try {
                if (this.dqX.indexOfKey(i2) < 0) {
                    Log.i("V8EngineBufferStore", "setBuffer:%d not contains", Integer.valueOf(i2));
                    return;
                }
                this.dqX.put(i2, q);
                Log.i("V8EngineBufferStore", "setBuffer %d isDirect:%b remains[%d]", Integer.valueOf(i2), Boolean.valueOf(byteBuffer.isDirect()), Integer.valueOf(this.dqW.addAndGet(byteBuffer.capacity())));
                AppMethodBeat.o(144106);
            } finally {
                AppMethodBeat.o(144106);
            }
        }
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public final boolean supportBufferStoreBindTo() {
        return false;
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public final void bufferStoreBindTo(long j2, long j3) {
        AppMethodBeat.i(144107);
        Log.e("V8EngineBufferStore", "no bind to here");
        AppMethodBeat.o(144107);
    }

    @Override // com.tencent.mm.appbrand.v8.e
    public final void releaseDirectByteBuffer(ByteBuffer byteBuffer) {
    }
}
