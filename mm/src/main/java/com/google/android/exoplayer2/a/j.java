package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j implements d {
    private int bgp = -1;
    private boolean bgs;
    private ByteBuffer buffer = beO;
    private int channelCount = -1;
    private int encoding = 0;
    private ByteBuffer outputBuffer = beO;

    @Override // com.google.android.exoplayer2.a.d
    public final boolean p(int i2, int i3, int i4) {
        AppMethodBeat.i(91830);
        if (i4 != 3 && i4 != 2 && i4 != Integer.MIN_VALUE && i4 != 1073741824) {
            d.a aVar = new d.a(i2, i3, i4);
            AppMethodBeat.o(91830);
            throw aVar;
        } else if (this.bgp == i2 && this.channelCount == i3 && this.encoding == i4) {
            AppMethodBeat.o(91830);
            return false;
        } else {
            this.bgp = i2;
            this.channelCount = i3;
            this.encoding = i4;
            if (i4 == 2) {
                this.buffer = beO;
            }
            AppMethodBeat.o(91830);
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.a.d
    public final boolean isActive() {
        return (this.encoding == 0 || this.encoding == 2) ? false : true;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final int tH() {
        return this.channelCount;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.a.d
    public final void f(ByteBuffer byteBuffer) {
        int i2;
        AppMethodBeat.i(91831);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        switch (this.encoding) {
            case Integer.MIN_VALUE:
                i2 = (i3 / 3) * 2;
                break;
            case 3:
                i2 = i3 * 2;
                break;
            case 1073741824:
                i2 = i3 / 2;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(91831);
                throw illegalStateException;
        }
        if (this.buffer.capacity() < i2) {
            this.buffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        switch (this.encoding) {
            case Integer.MIN_VALUE:
                while (position < limit) {
                    this.buffer.put(byteBuffer.get(position + 1));
                    this.buffer.put(byteBuffer.get(position + 2));
                    position += 3;
                }
                break;
            case 3:
                while (position < limit) {
                    this.buffer.put((byte) 0);
                    this.buffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                    position++;
                }
                break;
            case 1073741824:
                for (int i4 = position; i4 < limit; i4 += 4) {
                    this.buffer.put(byteBuffer.get(i4 + 2));
                    this.buffer.put(byteBuffer.get(i4 + 3));
                }
                break;
            default:
                IllegalStateException illegalStateException2 = new IllegalStateException();
                AppMethodBeat.o(91831);
                throw illegalStateException2;
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.outputBuffer = this.buffer;
        AppMethodBeat.o(91831);
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
        AppMethodBeat.i(91832);
        flush();
        this.buffer = beO;
        this.bgp = -1;
        this.channelCount = -1;
        this.encoding = 0;
        AppMethodBeat.o(91832);
    }
}
