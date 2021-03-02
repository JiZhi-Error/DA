package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;

public class q implements f {
    public volatile int frameCount = 0;
    private boolean isQ;
    public boolean isR;
    private long qPn = 0;
    private int targetHeight;
    private int targetWidth;
    private long tick = 0;
    public int zwA = -1;
    private int zwB = -1;
    private int zwC = -1;
    private int zwD = -1;
    private int zwE = -1;

    public q(boolean z, int i2, int i3, int i4, boolean z2) {
        AppMethodBeat.i(89576);
        this.isQ = z;
        this.zwB = i2;
        this.targetWidth = i3;
        this.targetHeight = i4;
        this.isR = z2;
        Log.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", Boolean.valueOf(z), Integer.valueOf(this.zwB), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(89576);
    }

    public final int QO(int i2) {
        AppMethodBeat.i(89577);
        if (i2 < 0) {
            Log.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            AppMethodBeat.o(89577);
            return -1;
        }
        this.zwA = i2;
        synchronized (q.class) {
            try {
                this.frameCount = 0;
            } catch (Throwable th) {
                AppMethodBeat.o(89577);
                throw th;
            }
        }
        this.qPn = 0;
        AppMethodBeat.o(89577);
        return 0;
    }

    public final void start() {
        AppMethodBeat.i(89578);
        if (0 == this.qPn) {
            this.qPn = System.currentTimeMillis();
        }
        AppMethodBeat.o(89578);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(byte[] r10, int r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.a.q.f(byte[], int, int, int):void");
    }

    public final void stop() {
        synchronized (q.class) {
            this.frameCount = 0;
        }
        this.qPn = 0;
    }

    public final long aMm() {
        AppMethodBeat.i(89580);
        if (0 == this.qPn) {
            Log.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
            AppMethodBeat.o(89580);
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.qPn;
        AppMethodBeat.o(89580);
        return currentTimeMillis;
    }

    public final void M(int i2, int i3, int i4) {
        AppMethodBeat.i(89581);
        Log.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.zwC = i2;
        this.zwD = i3;
        this.zwE = i4;
        AppMethodBeat.o(89581);
    }

    public final void clear() {
        AppMethodBeat.i(89582);
        SightVideoJNI.releaseBigSightDataBufferLock(this.zwA);
        this.zwA = -1;
        synchronized (q.class) {
            try {
                this.frameCount = 0;
            } catch (Throwable th) {
                AppMethodBeat.o(89582);
                throw th;
            }
        }
        this.qPn = 0;
        AppMethodBeat.o(89582);
    }
}
