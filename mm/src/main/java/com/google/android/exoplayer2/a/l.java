package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l implements d {
    float bdN = 1.0f;
    private k bgZ;
    private int bgp = -1;
    private boolean bgs;
    private ShortBuffer bha = this.buffer.asShortBuffer();
    long bhb;
    long bhc;
    private ByteBuffer buffer = beO;
    private int channelCount = -1;
    private ByteBuffer outputBuffer = beO;
    float pitch = 1.0f;

    public l() {
        AppMethodBeat.i(91839);
        AppMethodBeat.o(91839);
    }

    @Override // com.google.android.exoplayer2.a.d
    public final boolean p(int i2, int i3, int i4) {
        AppMethodBeat.i(91840);
        if (i4 != 2) {
            d.a aVar = new d.a(i2, i3, i4);
            AppMethodBeat.o(91840);
            throw aVar;
        } else if (this.bgp == i2 && this.channelCount == i3) {
            AppMethodBeat.o(91840);
            return false;
        } else {
            this.bgp = i2;
            this.channelCount = i3;
            AppMethodBeat.o(91840);
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.a.d
    public final boolean isActive() {
        AppMethodBeat.i(91841);
        if (Math.abs(this.bdN - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f) {
            AppMethodBeat.o(91841);
            return true;
        }
        AppMethodBeat.o(91841);
        return false;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final int tH() {
        return this.channelCount;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void f(ByteBuffer byteBuffer) {
        AppMethodBeat.i(91842);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.bhb += (long) remaining;
            k kVar = this.bgZ;
            int remaining2 = asShortBuffer.remaining() / kVar.bgE;
            kVar.dJ(remaining2);
            asShortBuffer.get(kVar.bgK, kVar.bgR * kVar.bgE, ((kVar.bgE * remaining2) * 2) / 2);
            kVar.bgR += remaining2;
            kVar.ub();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i2 = this.bgZ.bgS * this.channelCount * 2;
        if (i2 > 0) {
            if (this.buffer.capacity() < i2) {
                this.buffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
                this.bha = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.bha.clear();
            }
            k kVar2 = this.bgZ;
            ShortBuffer shortBuffer = this.bha;
            int min = Math.min(shortBuffer.remaining() / kVar2.bgE, kVar2.bgS);
            shortBuffer.put(kVar2.bgM, 0, kVar2.bgE * min);
            kVar2.bgS -= min;
            System.arraycopy(kVar2.bgM, min * kVar2.bgE, kVar2.bgM, 0, kVar2.bgE * kVar2.bgS);
            this.bhc += (long) i2;
            this.buffer.limit(i2);
            this.outputBuffer = this.buffer;
        }
        AppMethodBeat.o(91842);
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void tI() {
        AppMethodBeat.i(91843);
        k kVar = this.bgZ;
        int i2 = kVar.bgR;
        int i3 = kVar.bgS + ((int) ((((((float) i2) / (kVar.bdN / kVar.pitch)) + ((float) kVar.bgT)) / kVar.pitch) + 0.5f));
        kVar.dJ((kVar.bgH * 2) + i2);
        for (int i4 = 0; i4 < kVar.bgH * 2 * kVar.bgE; i4++) {
            kVar.bgK[(kVar.bgE * i2) + i4] = 0;
        }
        kVar.bgR += kVar.bgH * 2;
        kVar.ub();
        if (kVar.bgS > i3) {
            kVar.bgS = i3;
        }
        kVar.bgR = 0;
        kVar.bgU = 0;
        kVar.bgT = 0;
        this.bgs = true;
        AppMethodBeat.o(91843);
    }

    @Override // com.google.android.exoplayer2.a.d
    public final ByteBuffer tJ() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = beO;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.a.d
    public final boolean tB() {
        return this.bgs && (this.bgZ == null || this.bgZ.bgS == 0);
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void flush() {
        AppMethodBeat.i(91844);
        this.bgZ = new k(this.bgp, this.channelCount);
        this.bgZ.bdN = this.bdN;
        this.bgZ.pitch = this.pitch;
        this.outputBuffer = beO;
        this.bhb = 0;
        this.bhc = 0;
        this.bgs = false;
        AppMethodBeat.o(91844);
    }

    @Override // com.google.android.exoplayer2.a.d
    public final void reset() {
        AppMethodBeat.i(91845);
        this.bgZ = null;
        this.buffer = beO;
        this.bha = this.buffer.asShortBuffer();
        this.outputBuffer = beO;
        this.channelCount = -1;
        this.bgp = -1;
        this.bhb = 0;
        this.bhc = 0;
        this.bgs = false;
        AppMethodBeat.o(91845);
    }
}
