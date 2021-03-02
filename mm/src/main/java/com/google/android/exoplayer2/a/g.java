package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g implements d {
    private boolean active;
    private int bgp = -1;
    int[] bgq;
    private int[] bgr;
    private boolean bgs;
    private ByteBuffer buffer = beO;
    private int channelCount = -1;
    private ByteBuffer outputBuffer = beO;

    @Override // com.google.android.exoplayer2.a.d
    public final boolean p(int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(91802);
        boolean z2 = !Arrays.equals(this.bgq, this.bgr);
        this.bgr = this.bgq;
        if (this.bgr == null) {
            this.active = false;
            AppMethodBeat.o(91802);
            return z2;
        } else if (i4 != 2) {
            d.a aVar = new d.a(i2, i3, i4);
            AppMethodBeat.o(91802);
            throw aVar;
        } else if (!z2 && this.bgp == i2 && this.channelCount == i3) {
            AppMethodBeat.o(91802);
            return false;
        } else {
            this.bgp = i2;
            this.channelCount = i3;
            if (i3 != this.bgr.length) {
                z = true;
            } else {
                z = false;
            }
            this.active = z;
            int i5 = 0;
            while (i5 < this.bgr.length) {
                int i6 = this.bgr[i5];
                if (i6 >= i3) {
                    d.a aVar2 = new d.a(i2, i3, i4);
                    AppMethodBeat.o(91802);
                    throw aVar2;
                }
                this.active = (i6 != i5) | this.active;
                i5++;
            }
            AppMethodBeat.o(91802);
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.a.d
    public final boolean isActive() {
        return this.active;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final int tH() {
        return this.bgr == null ? this.channelCount : this.bgr.length;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void f(ByteBuffer byteBuffer) {
        AppMethodBeat.i(91803);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.bgr.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (position < limit) {
            for (int i2 : this.bgr) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.channelCount * 2;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
        AppMethodBeat.o(91803);
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void tI() {
        this.bgs = true;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final ByteBuffer tJ() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = beO;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final boolean tB() {
        return this.bgs && this.outputBuffer == beO;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void flush() {
        this.outputBuffer = beO;
        this.bgs = false;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void reset() {
        AppMethodBeat.i(91804);
        flush();
        this.buffer = beO;
        this.channelCount = -1;
        this.bgp = -1;
        this.bgr = null;
        this.active = false;
        AppMethodBeat.o(91804);
    }
}
