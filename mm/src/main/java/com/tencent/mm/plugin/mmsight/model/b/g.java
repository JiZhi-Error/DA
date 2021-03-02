package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g {
    int bitrate;
    int frameCount = 0;
    int frameRate;
    int iSU;
    int iSV;
    boolean isStart = false;
    int kxW;
    int kxX;
    int targetHeight;
    int targetWidth;
    int zwX;
    int zwY;
    a zxg;

    public g(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.kxW = i2;
        this.kxX = i3;
        this.targetWidth = i4;
        this.targetHeight = i5;
        this.bitrate = i6;
        this.frameRate = i7;
        this.iSU = 2;
        this.iSV = i8;
        this.zwX = i9;
        this.zwY = i10;
    }

    class a extends b {
        volatile int ifA;
        int isP;
        final Object ite;
        boolean jue;

        private a() {
            AppMethodBeat.i(89638);
            this.ite = new Object();
            AppMethodBeat.o(89638);
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(89639);
            if (this.isP == -1) {
                this.isP = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                Log.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", Integer.valueOf(this.isP));
            }
            this.ifA = 0;
            synchronized (this.ite) {
                while (!this.jue) {
                    try {
                        long currentTicks = Util.currentTicks();
                        Log.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
                        int triggerEncodeForSegmentLock = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.ifA), false);
                        Log.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.ifA), Integer.valueOf(triggerEncodeForSegmentLock), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegmentLock == this.ifA) {
                            try {
                                Thread.sleep(10);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
                            }
                        }
                        this.ifA = triggerEncodeForSegmentLock;
                    } finally {
                        AppMethodBeat.o(89639);
                    }
                }
                long currentTicks2 = Util.currentTicks();
                this.ifA = MP4MuxerJNI.triggerEncodeForSegmentLock(this.ifA, true);
                Log.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(this.ifA), Long.valueOf(Thread.currentThread().getId()));
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MediaCodecFFMpegTranscoder_Encoder";
        }
    }
}
