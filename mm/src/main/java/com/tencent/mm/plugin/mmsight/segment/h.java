package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h implements e.a {
    private static int jtZ = -1;
    int dYT;
    long endTimeMs = -1;
    int ies = -1;
    c igg;
    private int jtM;
    private int jtN;
    private int jtO;
    private int jtP;
    private int jtQ;
    private int jtR;
    VideoTransPara jtV;
    private int jtW = 0;
    String jtX;
    private MediaFormat jua;
    private Object lock = new byte[0];
    private int srcHeight;
    private int srcWidth;
    long startTimeMs = -1;
    int videoTrackIndex;
    private boolean zyA = false;
    a zyy;
    e zyz;

    public h() {
        AppMethodBeat.i(107657);
        AppMethodBeat.o(107657);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r0 == 3) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getDecoderType() {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.h.getDecoderType():int");
    }

    public final int h(MediaFormat mediaFormat) {
        AppMethodBeat.i(107659);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", mediaFormat, this.jtX);
        this.jua = mediaFormat;
        int decoderType = getDecoderType();
        if (decoderType == 1) {
            this.zyz = new i(this.igg, mediaFormat, this.videoTrackIndex);
            this.zyA = false;
        } else if (decoderType == 2) {
            this.zyz = new j(this.igg, mediaFormat, this.videoTrackIndex);
            this.zyA = false;
        } else {
            this.zyz = new b();
            this.zyA = true;
        }
        if (this.zyz == null) {
            Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.zyz = new i(this.igg, mediaFormat, this.videoTrackIndex);
            this.zyA = false;
        }
        int n = this.zyz.n(this.jtX, this.startTimeMs, this.endTimeMs);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", Integer.valueOf(n));
        if (n < 0 && (jtZ == 1 || jtZ == 2)) {
            Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.zyz.stop();
                this.zyz = null;
            } catch (Exception e2) {
            }
            this.zyz = new b();
            this.zyA = true;
            jtZ = 3;
            n = this.zyz.n(this.jtX, this.startTimeMs, this.endTimeMs);
        }
        this.zyz.a(this);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(n), Integer.valueOf(jtZ));
        AppMethodBeat.o(107659);
        return n;
    }

    public final void dA(int i2, int i3) {
        AppMethodBeat.i(107660);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.jtM = i2;
        this.jtN = i3;
        AppMethodBeat.o(107660);
    }

    private static Point v(int i2, int i3, int i4, int i5) {
        int min;
        int i6;
        AppMethodBeat.i(107661);
        Log.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i2 + "], decoderOutputHeight = [" + i3 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
        if (i2 > i4 || i3 > i5) {
            int max = Math.max(i2, i3);
            int min2 = Math.min(i2, i3);
            int max2 = Math.max(i4, i5);
            int min3 = Math.min(i4, i5);
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min2 % 16 == 0 && Math.abs(min2 - min3) < 16) {
                Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.o(107661);
                return null;
            } else if (max / 2 == max2 && min2 / 2 == min3) {
                Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                int i7 = i2 / 2;
                int i8 = i3 / 2;
                if (i7 % 2 != 0) {
                    i7++;
                }
                if (i8 % 2 != 0) {
                    i8++;
                }
                Point point = new Point(i7, i8);
                AppMethodBeat.o(107661);
                return point;
            } else {
                int i9 = max / 2;
                int i10 = min2 / 2;
                if (i9 % 16 != 0 || Math.abs(i9 - max2) >= 16 || i10 % 16 != 0 || Math.abs(i10 - min3) >= 16) {
                    Point point2 = new Point();
                    if (i2 < i3) {
                        i6 = Math.min(i4, i5);
                        min = (int) (((double) i3) / ((((double) i2) * 1.0d) / ((double) i6)));
                    } else {
                        min = Math.min(i4, i5);
                        i6 = (int) (((double) i2) / ((((double) i3) * 1.0d) / ((double) min)));
                    }
                    if (min % 2 != 0) {
                        min++;
                    }
                    if (i6 % 2 != 0) {
                        i6++;
                    }
                    Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(i6), Integer.valueOf(min));
                    point2.x = i6;
                    point2.y = min;
                    AppMethodBeat.o(107661);
                    return point2;
                }
                Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                int i11 = i2 / 2;
                int i12 = i3 / 2;
                if (i11 % 2 != 0) {
                    i11++;
                }
                if (i12 % 2 != 0) {
                    i12++;
                }
                Point point3 = new Point(i11, i12);
                AppMethodBeat.o(107661);
                return point3;
            }
        } else {
            Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
            AppMethodBeat.o(107661);
            return null;
        }
    }

    public final void release() {
        AppMethodBeat.i(107662);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", Integer.valueOf(jtZ));
        try {
            if (this.zyz != null) {
                this.zyz.stop();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", e2.getMessage());
        } finally {
            MP4MuxerJNI.releaseDataBuf(0);
            jtZ = -1;
            AppMethodBeat.o(107662);
        }
    }

    class a extends b {
        volatile int ifA;
        int isP;
        Object ite;
        boolean jue;

        private a() {
            AppMethodBeat.i(107655);
            this.ite = new Object();
            AppMethodBeat.o(107655);
        }

        /* synthetic */ a(h hVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(107656);
            if (this.isP == -1) {
                this.isP = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", Integer.valueOf(this.isP));
            }
            this.ifA = 0;
            synchronized (this.ite) {
                while (!this.jue) {
                    try {
                        long currentTicks = Util.currentTicks();
                        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                        int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.ifA), false);
                        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.ifA), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegment == this.ifA) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                            }
                        }
                        this.ifA = triggerEncodeForSegment;
                    } finally {
                        AppMethodBeat.o(107656);
                    }
                }
                long currentTicks2 = Util.currentTicks();
                this.ifA = MP4MuxerJNI.triggerEncodeForSegment(this.ifA, true);
                Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(this.ifA), Long.valueOf(Thread.currentThread().getId()));
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MediaCodecFFMpegTranscoder_Encoder";
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.e.a
    public final void bJ(byte[] bArr) {
        boolean z;
        AppMethodBeat.i(107663);
        if (bArr == null || bArr.length == 0) {
            Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            AppMethodBeat.o(107663);
            return;
        }
        Point bhJ = this.zyz.bhJ();
        this.srcWidth = bhJ.x;
        this.srcHeight = bhJ.y;
        if (this.jtR <= 0 || this.jtQ <= 0) {
            Point v = v(this.srcWidth, this.srcHeight, this.jtM, this.jtN);
            if (v != null) {
                this.jtQ = v.x;
                this.jtR = v.y;
            } else {
                this.jtQ = this.srcWidth;
                this.jtR = this.srcHeight;
            }
            Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.jtQ), Integer.valueOf(this.jtR), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight));
        }
        long currentTicks = Util.currentTicks();
        int i2 = 0;
        int i3 = 0;
        if (this.jua != null) {
            i2 = this.jua.getInteger("width");
            i3 = this.jua.getInteger("height");
            if (this.jtO <= 0 || this.jtP <= 0) {
                Point v2 = v(i2, i3, this.jtM, this.jtN);
                if (v2 != null) {
                    this.jtO = v2.x;
                    this.jtP = v2.y;
                    z = true;
                } else {
                    if (Math.abs(i3 - bhJ.y) <= 0 || i2 != bhJ.x) {
                        this.jtO = bhJ.x;
                        this.jtP = bhJ.y;
                    } else {
                        this.jtO = i2;
                        this.jtP = i3;
                    }
                    z = false;
                }
                if (z) {
                    this.jtQ = this.jtO;
                    this.jtR = this.jtP;
                }
                Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.jtO), Integer.valueOf(this.jtP), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
            }
        }
        this.jtW = this.zyz.bhK();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, bhJ.x, bhJ.y, this.jtQ, this.jtR, this.jtW, i2, i3);
        Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        if (writeYuvDataForSegment < 0) {
            Log.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(writeYuvDataForSegment));
        }
        if (this.zyy == null) {
            MP4MuxerJNI.initH264Encoder(this.jtO, this.jtP, (float) this.jtV.fps, this.jtV.videoBitrate, this.jtV.iSV, 8, this.jtV.iSU, 23.0f, 0, 51);
            this.zyy = new a(this, (byte) 0);
            com.tencent.f.h.RTc.ba(this.zyy);
            Log.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
        AppMethodBeat.o(107663);
    }
}
