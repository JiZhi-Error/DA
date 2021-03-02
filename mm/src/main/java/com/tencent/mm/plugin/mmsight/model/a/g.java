package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(16)
public final class g extends h {
    private ArrayList<Integer> irw = new ArrayList<>();

    public g(int i2, int i3, int i4, boolean z) {
        super(i2, i3, i4, null, z);
        AppMethodBeat.i(89472);
        AppMethodBeat.o(89472);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c, com.tencent.mm.plugin.mmsight.model.a.h
    public final int H(int i2, String str) {
        AppMethodBeat.i(89473);
        this.irw.clear();
        this.irw.add(Integer.valueOf(i2));
        int H = super.H(i2, str);
        AppMethodBeat.o(89473);
        return H;
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.c, com.tencent.mm.plugin.mmsight.model.a.h
    public final void rA(int i2) {
        AppMethodBeat.i(89474);
        this.irw.add(Integer.valueOf(i2));
        AppMethodBeat.o(89474);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.model.a.h
    public final void h(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(89475);
        if (this.irw.size() > 0 && byteBuffer != null && !this.zvT) {
            Iterator<Integer> it = this.irw.iterator();
            while (it.hasNext()) {
                SightVideoJNI.writeAACDataLock(it.next().intValue(), byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
            }
        }
        AppMethodBeat.o(89475);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.model.a.h
    public final void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, int i3, int i4) {
        AppMethodBeat.i(89476);
        if (this.irw.size() > 0 && byteBuffer != null && !this.zvT) {
            Iterator<Integer> it = this.irw.iterator();
            while (it.hasNext()) {
                SightVideoJNI.writeAACDataWithADTSLock(it.next().intValue(), byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs, i2, i3, i4);
            }
        }
        AppMethodBeat.o(89476);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.model.a.h
    public final boolean aQF() {
        return true;
    }
}
