package com.tencent.mm.plugin.exdevice.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import junit.framework.Assert;

public final class a {
    private final int rNg = 1024;
    private ByteBuffer rNh;
    private ByteBuffer rNi;

    public a(int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(24311);
        Log.d("MicroMsg.exdevice.AutoBuffer", "******AutoBuffer****** capacity = ".concat(String.valueOf(i2)));
        Assert.assertTrue(i2 >= 0);
        this.rNi = ByteBuffer.allocate(i2);
        this.rNh = this.rNi.asReadOnlyBuffer();
        if (this.rNi != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(this.rNh == null ? false : z2);
        AppMethodBeat.o(24311);
    }

    private int getCapacity() {
        AppMethodBeat.i(24312);
        Log.d("MicroMsg.exdevice.AutoBuffer", "getCapacity = " + this.rNi.capacity());
        int capacity = this.rNi.capacity();
        AppMethodBeat.o(24312);
        return capacity;
    }

    public final int getSize() {
        AppMethodBeat.i(24313);
        Log.d("MicroMsg.exdevice.AutoBuffer", "size = " + this.rNi.position());
        int position = this.rNi.position();
        AppMethodBeat.o(24313);
        return position;
    }

    public final short readShort() {
        AppMethodBeat.i(24314);
        if (getSize() <= 1) {
            IOException iOException = new IOException("There is only one byte in array");
            AppMethodBeat.o(24314);
            throw iOException;
        }
        short s = this.rNh.getShort();
        Log.d("MicroMsg.exdevice.AutoBuffer", "getShort = ".concat(String.valueOf((int) s)));
        AppMethodBeat.o(24314);
        return s;
    }

    public final void T(byte[] bArr, int i2) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(24315);
        Assert.assertTrue(true);
        Assert.assertTrue(i2 >= 0);
        if (bArr.length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (bArr.length >= i2 + 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (this.rNh.remaining() < i2) {
            z3 = false;
        }
        Assert.assertTrue(z3);
        Log.d("MicroMsg.exdevice.AutoBuffer", "readByte dstOffset = 0 byteCount = " + i2);
        this.rNh.get(bArr, 0, i2);
        AppMethodBeat.o(24315);
    }

    public final void U(byte[] bArr, int i2) {
        boolean z = true;
        AppMethodBeat.i(24316);
        Assert.assertTrue(true);
        Assert.assertTrue(i2 >= 0);
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Log.d("MicroMsg.exdevice.AutoBuffer", "writeByte srcOffset = 0 byteCount = " + i2);
        if (i2 > this.rNi.remaining()) {
            Log.d("MicroMsg.exdevice.AutoBuffer", "byteCount > mWriteStream.remaining() Recalloc");
            ByteBuffer allocate = ByteBuffer.allocate(getCapacity() + i2 + 1024);
            int position = this.rNh.position();
            allocate.put(this.rNi.array());
            allocate.put(bArr, 0, i2);
            this.rNi = allocate;
            this.rNh = allocate.asReadOnlyBuffer();
            this.rNh.position(position);
            AppMethodBeat.o(24316);
            return;
        }
        this.rNi.put(bArr, 0, i2);
        AppMethodBeat.o(24316);
    }
}
