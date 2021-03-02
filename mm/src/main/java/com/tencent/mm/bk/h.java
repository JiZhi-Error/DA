package com.tencent.mm.bk;

import android.graphics.Point;
import android.media.MediaFormat;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.a;
import com.tencent.mm.bk.c;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class h implements a.AbstractC0278a {
    private static int jtZ = -1;
    private static int jub = 1;
    private int bufId;
    int dYT;
    long endTimeMs = -1;
    int ies = -1;
    c igg;
    private boolean jtJ = false;
    boolean jtK = false;
    private int jtM;
    private int jtN;
    private int jtO;
    private int jtP;
    private int jtQ;
    private int jtR;
    b jtS;
    private c jtT;
    a jtU;
    VideoTransPara jtV;
    private int jtW = 0;
    String jtX;
    a jtY;
    private MediaFormat jua;
    private Object lock = new byte[0];
    private int srcHeight;
    private int srcWidth;
    long startTimeMs = -1;
    int videoTrackIndex;

    public h(int i2) {
        AppMethodBeat.i(127119);
        Log.i("MicroMsg.VideoTranscoder", "create VideoTranscoder: %s", Integer.valueOf(i2));
        this.bufId = i2;
        AppMethodBeat.o(127119);
    }

    public final int a(MediaFormat mediaFormat, boolean z) {
        AppMethodBeat.i(127120);
        Log.i("MicroMsg.VideoTranscoder", "initDecoder, format: %s, filePath: %s, scaleFrame: %s", mediaFormat, this.jtX, Boolean.valueOf(z));
        this.jua = mediaFormat;
        this.jtJ = z;
        this.jtY = new d(this.igg, mediaFormat, this.videoTrackIndex);
        int n = this.jtY.n(this.jtX, this.startTimeMs, this.endTimeMs);
        Util.ticksToNow(Util.currentTicks());
        Log.i("MicroMsg.VideoTranscoder", "init decoder ret: %s", Integer.valueOf(n));
        if (n < 0) {
            Log.i("MicroMsg.VideoTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.jtY.stop();
                this.jtY = null;
            } catch (Exception e2) {
            }
            this.jtY = new d(this.igg, mediaFormat, this.videoTrackIndex);
            n = this.jtY.n(this.jtX, this.startTimeMs, this.endTimeMs);
        }
        this.jtY.a(this);
        Log.i("MicroMsg.VideoTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(n), Integer.valueOf(jtZ));
        AppMethodBeat.o(127120);
        return n;
    }

    public final void dA(int i2, int i3) {
        AppMethodBeat.i(127121);
        Log.i("MicroMsg.VideoTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.jtM = i2;
        this.jtN = i3;
        AppMethodBeat.o(127121);
    }

    private static Point v(int i2, int i3, int i4, int i5) {
        int min;
        int i6;
        AppMethodBeat.i(127122);
        Log.d("MicroMsg.VideoTranscoder", "scale() called with: decoderOutputWidth = [" + i2 + "], decoderOutputHeight = [" + i3 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
        if (i2 > i4 || i3 > i5) {
            int max = Math.max(i2, i3);
            int min2 = Math.min(i2, i3);
            int max2 = Math.max(i4, i5);
            int min3 = Math.min(i4, i5);
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min2 % 16 == 0 && Math.abs(min2 - min3) < 16) {
                Log.i("MicroMsg.VideoTranscoder", "calc scale, same len divide by 16, no need scale");
                AppMethodBeat.o(127122);
                return null;
            } else if (max / 2 == max2 && min2 / 2 == min3) {
                Log.i("MicroMsg.VideoTranscoder", "calc scale, double ratio");
                int i7 = i2 / 2;
                int i8 = i3 / 2;
                if (i7 % 2 != 0) {
                    i7++;
                }
                if (i8 % 2 != 0) {
                    i8++;
                }
                Point point = new Point(i7, i8);
                AppMethodBeat.o(127122);
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
                    Log.i("MicroMsg.VideoTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(i6), Integer.valueOf(min));
                    point2.x = i6;
                    point2.y = min;
                    point2.x = uh(point2.x);
                    point2.y = uh(point2.y);
                    AppMethodBeat.o(127122);
                    return point2;
                }
                Log.i("MicroMsg.VideoTranscoder", "calc scale, double ratio divide by 16");
                int i11 = i2 / 2;
                int i12 = i3 / 2;
                if (i11 % 2 != 0) {
                    i11++;
                }
                if (i12 % 2 != 0) {
                    i12++;
                }
                Point point3 = new Point(i11, i12);
                AppMethodBeat.o(127122);
                return point3;
            }
        } else {
            Log.i("MicroMsg.VideoTranscoder", "calc scale, small or equal to spec size");
            AppMethodBeat.o(127122);
            return null;
        }
    }

    private static int uh(int i2) {
        AppMethodBeat.i(127123);
        int i3 = i2 % 16;
        if (i3 == 0) {
            AppMethodBeat.o(127123);
            return i2;
        }
        int min = i2 - Math.min(16, i3);
        if (min < Integer.MAX_VALUE) {
            AppMethodBeat.o(127123);
            return min;
        }
        int i4 = i2 - i3;
        AppMethodBeat.o(127123);
        return i4;
    }

    public final void release() {
        AppMethodBeat.i(127124);
        Log.i("MicroMsg.VideoTranscoder", "release, decoderType: %d", Integer.valueOf(jtZ));
        try {
            if (this.jtY != null) {
                this.jtY.stop();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.VideoTranscoder", "release error: %s", e2.getMessage());
        } finally {
            MP4MuxerJNI.releaseDataBufLock(0);
            jtZ = -1;
            AppMethodBeat.o(127124);
        }
    }

    class b extends com.tencent.f.i.b {
        volatile int ifA;
        int isP;
        Object ite;
        boolean jue;

        private b() {
            AppMethodBeat.i(127117);
            this.ite = new Object();
            AppMethodBeat.o(127117);
        }

        /* synthetic */ b(h hVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(127118);
            if (this.isP == -1) {
                this.isP = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                Log.i("MicroMsg.VideoTranscoder", "encodeTid: %s", Integer.valueOf(this.isP));
            }
            this.ifA = 0;
            synchronized (this.ite) {
                while (!this.jue) {
                    try {
                        long currentTicks = Util.currentTicks();
                        Log.i("MicroMsg.VideoTranscoder", "try trigger encode");
                        int triggerEncodeForSegmentLock = MP4MuxerJNI.triggerEncodeForSegmentLock(Math.max(0, this.ifA), false);
                        Log.i("MicroMsg.VideoTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.ifA), Integer.valueOf(triggerEncodeForSegmentLock), Long.valueOf(Thread.currentThread().getId()));
                        if (triggerEncodeForSegmentLock == this.ifA) {
                            try {
                                Thread.sleep(5);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.VideoTranscoder", "thread sleep error");
                            }
                        }
                        this.ifA = triggerEncodeForSegmentLock;
                    } finally {
                        AppMethodBeat.o(127118);
                    }
                }
                long currentTicks2 = Util.currentTicks();
                this.ifA = MP4MuxerJNI.triggerEncodeForSegmentLock(this.ifA, true);
                Log.i("MicroMsg.VideoTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(this.ifA), Long.valueOf(Thread.currentThread().getId()));
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "MediaCodecFFMpegTranscoder_Encoder";
        }
    }

    class a extends MMHandler {
        private Point jud = null;

        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            int i2;
            int i3;
            boolean z = true;
            AppMethodBeat.i(127116);
            if (message.what == h.jub) {
                byte[] bArr = (byte[]) message.obj;
                if (message.arg1 != 1) {
                    z = false;
                }
                long j2 = (long) message.arg2;
                if (h.this.jtT != null) {
                    this.jud = h.this.jtY.bhJ();
                    if (h.this.jua != null) {
                        i3 = h.this.jua.getInteger("width");
                        i2 = h.this.jua.getInteger("height");
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    h.this.jtT.a(bArr, i3, i2, this.jud.x, this.jud.y, z, j2, h.this.jtY.bhK());
                    b.jtf.k(bArr);
                }
            }
            AppMethodBeat.o(127116);
        }
    }

    @Override // com.tencent.mm.bk.a.AbstractC0278a
    public final void a(byte[] bArr, boolean z, long j2) {
        AppMethodBeat.i(127125);
        if (bArr == null || bArr.length == 0) {
            Log.i("MicroMsg.VideoTranscoder", "onYuvDataImp error data is null!!");
            AppMethodBeat.o(127125);
            return;
        }
        Point bhJ = this.jtY.bhJ();
        this.srcWidth = bhJ.x;
        this.srcHeight = bhJ.y;
        long currentTicks = Util.currentTicks();
        int i2 = 0;
        int i3 = 0;
        if (!this.jtJ) {
            if (this.jtR <= 0 || this.jtQ <= 0) {
                this.jtQ = this.srcWidth;
                this.jtR = this.srcHeight;
                Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.jtQ), Integer.valueOf(this.jtR), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight));
            }
            if (this.jua != null) {
                i2 = this.jua.getInteger("width");
                i3 = this.jua.getInteger("height");
                if (this.jtO <= 0 || this.jtP <= 0) {
                    if (Math.abs(i3 - bhJ.y) <= 0 || i2 != bhJ.x) {
                        this.jtO = bhJ.x;
                        this.jtP = bhJ.y;
                    } else {
                        this.jtO = i2;
                        this.jtP = i3;
                    }
                    Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.jtO), Integer.valueOf(this.jtP), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.FALSE);
                }
            }
        } else {
            if (this.jtR <= 0 || this.jtQ <= 0) {
                Point v = v(this.srcWidth, this.srcHeight, this.jtM, this.jtN);
                if (v != null) {
                    this.jtQ = v.x;
                    this.jtR = v.y;
                } else {
                    this.jtQ = this.srcWidth;
                    this.jtR = this.srcHeight;
                }
                Log.i("MicroMsg.VideoTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.jtQ), Integer.valueOf(this.jtR), Integer.valueOf(this.srcWidth), Integer.valueOf(this.srcHeight));
            }
            if (this.jua != null) {
                i2 = this.jua.getInteger("width");
                i3 = this.jua.getInteger("height");
                if (this.jtO <= 0 || this.jtP <= 0) {
                    boolean z2 = false;
                    Point v2 = v(i2, i3, this.jtM, this.jtN);
                    if (v2 != null) {
                        this.jtO = v2.x;
                        this.jtP = v2.y;
                        z2 = true;
                    } else if (Math.abs(i3 - bhJ.y) <= 0 || i2 != bhJ.x) {
                        this.jtO = bhJ.x;
                        this.jtP = bhJ.y;
                    } else {
                        this.jtO = i2;
                        this.jtP = i3;
                    }
                    if (z2) {
                        this.jtQ = this.jtO;
                        this.jtR = this.jtP;
                    }
                    Log.i("MicroMsg.VideoTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.jtO), Integer.valueOf(this.jtP), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2));
                }
            }
        }
        this.jtW = this.jtY.bhK();
        int i4 = 0;
        if (this.jtK) {
            i4 = MP4MuxerJNI.writeYuvDataForSegmentLock(bArr, bhJ.x, bhJ.y, this.jtQ, this.jtR, this.jtW, i2, i3);
            Log.i("MicroMsg.VideoTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        if (i4 < 0) {
            Log.e("MicroMsg.VideoTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(i4));
        }
        if (this.jtK) {
            if (this.jtS == null) {
                MP4MuxerJNI.initH264EncoderLock(this.jtO, this.jtP, (float) this.jtV.fps, this.jtV.videoBitrate, this.jtV.iSV, 8, this.jtV.iSU, 23.0f, 0, 51);
                this.jtS = new b(this, (byte) 0);
                com.tencent.f.h.RTc.ba(this.jtS);
                Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", Boolean.valueOf(this.jtK));
            }
        } else if (this.jtT == null) {
            this.jtT = new c(this.jtO, this.jtP, this.jtV.videoBitrate, this.jtV.fps);
            this.jtT.jth = new c.a() {
                /* class com.tencent.mm.bk.h.AnonymousClass1 */

                @Override // com.tencent.mm.bk.c.a
                public final void a(int i2, ByteBuffer byteBuffer, int i3) {
                    AppMethodBeat.i(127114);
                    MP4MuxerJNI.writeH264DataLock(i2, byteBuffer, i3);
                    AppMethodBeat.o(127114);
                }
            };
            try {
                Log.i("MicroMsg.VideoTranscoder", "init mediaCodecEncoder: %s", Integer.valueOf(this.jtT.ug(this.bufId)));
                c cVar = this.jtT;
                Log.i("MicroMsg.MediaCodecTransCodeEncoder", "Start");
                cVar.isStart = true;
                if (this.jtU == null) {
                    this.jtU = new a("remuxer_encode");
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoTranscoder", e2, "init mediaCodecEncoder error: %s", e2.getMessage());
            }
            Log.i("MicroMsg.VideoTranscoder", "initAndStartEncoderIfNeed, useX264: %s", Boolean.valueOf(this.jtK));
        }
        if (!this.jtK && this.jtU != null) {
            Message obtain = Message.obtain();
            obtain.what = jub;
            byte[] h2 = b.jtf.h(Integer.valueOf(bArr.length));
            if (h2 != null) {
                System.arraycopy(bArr, 0, h2, 0, bArr.length);
            }
            obtain.obj = h2;
            obtain.arg1 = z ? 1 : 0;
            obtain.arg2 = (int) j2;
            this.jtU.sendMessage(obtain);
        }
        AppMethodBeat.o(127125);
    }
}
