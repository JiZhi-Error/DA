package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class r extends s {
    protected int bufId = -1;

    public r(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        super(i2, i3, i4, i5, i6, i7, i8, z);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.s
    public final int ha(int i2, int i3) {
        AppMethodBeat.i(89583);
        this.bufId = i2;
        int ha = super.ha(i2, i3);
        AppMethodBeat.o(89583);
        return ha;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.mmsight.model.a.s
    public final void i(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(89584);
        if (this.bufId >= 0 && byteBuffer != null && bufferInfo != null && bufferInfo.size == byteBuffer.limit() - byteBuffer.position()) {
            long currentTicks = Util.currentTicks();
            SightVideoJNI.writeH264DataLock(this.bufId, byteBuffer, bufferInfo.size, bufferInfo.presentationTimeUs);
            Log.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeH264Data used %sms, size: %s %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(bufferInfo.size), Integer.valueOf(byteBuffer.capacity()));
        }
        AppMethodBeat.o(89584);
    }

    @Override // com.tencent.mm.plugin.mmsight.model.a.s
    public final void clear() {
        AppMethodBeat.i(89585);
        super.clear();
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        AppMethodBeat.o(89585);
    }
}
