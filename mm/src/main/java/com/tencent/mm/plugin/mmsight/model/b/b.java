package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.b.f;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b extends com.tencent.mm.plugin.mmsight.api.a {
    private int bufId;
    private int channelCount;
    private String filePath;
    private int iee;
    private int ihQ;
    private int ihR;
    private int ihS;
    private Bitmap ihg;
    private long iho = -1;
    private int iiB = -1;
    private int iix;
    private c jto;
    private Point jud = null;
    private String outputFilePath;
    private int outputHeight;
    private int outputWidth;
    private long remuxEndTime = -1;
    private int videoDuration = -1;
    private int videoFps;
    private a zwO;
    private f zwP;
    private HandlerThread zwQ;
    private a zwR;
    private byte[] zwS = null;
    private byte[] zwT = null;
    private a.AbstractC1479a zwU;

    public b(String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(89609);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || i2 <= 0 || i3 <= 0) {
            Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5));
            AppMethodBeat.o(89609);
            return;
        }
        this.filePath = str;
        this.outputFilePath = str2;
        this.outputWidth = i2;
        this.outputHeight = i3;
        this.iix = i4;
        this.iiB = i5;
        this.ihS = SightVideoJNI.getMp4RotateVFS(str);
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str);
        if (aNx != null) {
            this.ihQ = aNx.width;
            this.ihR = aNx.height;
            this.videoDuration = aNx.videoDuration;
            this.videoFps = aNx.frameRate;
        }
        this.iho = 0;
        this.remuxEndTime = (long) this.videoDuration;
        Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.ihQ), Integer.valueOf(this.ihR), Integer.valueOf(this.ihS), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(89609);
    }

    public b(String str, String str2, int i2, int i3, int i4, int i5, long j2, long j3) {
        AppMethodBeat.i(89610);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || i2 <= 0 || i3 <= 0) {
            Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5));
            AppMethodBeat.o(89610);
            return;
        }
        this.filePath = str;
        this.outputFilePath = str2;
        this.outputWidth = i2;
        this.outputHeight = i3;
        this.iix = i4;
        this.iiB = i5;
        this.ihS = SightVideoJNI.getMp4RotateVFS(str);
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str);
        if (aNx != null) {
            this.ihQ = aNx.width;
            this.ihR = aNx.height;
            this.videoFps = aNx.frameRate;
        }
        this.iho = j2;
        this.remuxEndTime = j3;
        Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.ihQ), Integer.valueOf(this.ihR), Integer.valueOf(this.ihS), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(89610);
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a
    public final void D(Bitmap bitmap) {
        if (bitmap != null) {
            this.ihg = bitmap;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a
    public final int aMG() {
        int e2;
        long j2;
        MediaFormat mediaFormat;
        AppMethodBeat.i(89611);
        int round = Math.round(((float) this.videoDuration) / 1000.0f);
        if (this.iho >= 0 && this.remuxEndTime >= 0) {
            round = Math.round(((float) (this.remuxEndTime - this.iho)) / 1000.0f) + 1;
        }
        this.bufId = MP4MuxerJNI.initDataBufLock(round);
        if (com.tencent.mm.bk.e.QW(this.filePath)) {
            Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
            this.zwO = new e();
        } else {
            this.zwO = new d();
        }
        if (this.videoDuration > 0) {
            e2 = this.zwO.e(this.filePath, 0, (long) this.videoDuration, this.videoFps);
        } else if (this.iho < 0 || this.remuxEndTime < 0) {
            Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.videoDuration), Long.valueOf(this.iho), Long.valueOf(this.remuxEndTime));
            MP4MuxerJNI.releaseDataBufLock(this.bufId);
            AppMethodBeat.o(89611);
            return -1;
        } else {
            e2 = this.zwO.e(this.filePath, this.iho, this.remuxEndTime, this.videoFps);
        }
        Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", Integer.valueOf(e2));
        if (e2 < 0) {
            MP4MuxerJNI.releaseDataBufLock(this.bufId);
            AppMethodBeat.o(89611);
            return -1;
        }
        if (this.iiB > 0 && this.iiB < this.videoFps) {
            this.zwO.uf((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.iiB))));
        }
        this.zwP = new f(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, this.iix, this.iiB > 0 ? Math.min(this.iiB, this.videoFps) : this.videoFps);
        this.zwO.a(new h() {
            /* class com.tencent.mm.plugin.mmsight.model.b.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.mmsight.model.b.h
            public final void a(byte[] bArr, boolean z, long j2) {
                int i2 = 1;
                AppMethodBeat.i(89606);
                if (b.this.zwQ == null) {
                    b.this.zwQ = d.hB("remuxer_encode", -2);
                    b.this.zwQ.start();
                    b.this.zwR = new a(b.this.zwQ.getLooper());
                }
                if (b.this.zwR != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    byte[] h2 = bArr != null ? k.zwi.h(Integer.valueOf(bArr.length)) : null;
                    if (h2 != null) {
                        System.arraycopy(bArr, 0, h2, 0, h2.length);
                    }
                    obtain.obj = h2;
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.arg1 = i2;
                    obtain.arg2 = (int) j2;
                    b.this.zwR.sendMessage(obtain);
                }
                AppMethodBeat.o(89606);
            }
        });
        this.zwP.zxf = new f.a() {
            /* class com.tencent.mm.plugin.mmsight.model.b.b.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.mmsight.model.b.f.a
            public final void a(int i2, ByteBuffer byteBuffer, int i3) {
                AppMethodBeat.i(89607);
                MP4MuxerJNI.writeH264DataLock(i2, byteBuffer, i3);
                AppMethodBeat.o(89607);
            }
        };
        try {
            this.zwP.ug(this.bufId);
            f fVar = this.zwP;
            Log.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
            fVar.isStart = true;
            this.zwO.ekm();
            this.zwQ.quitSafely();
            this.zwQ.join();
            this.zwR = null;
            this.jto = new c();
            try {
                this.jto.setDataSource(this.filePath);
                String str = null;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.jto.gLF.getTrackCount()) {
                        mediaFormat = null;
                        i2 = -1;
                        break;
                    }
                    mediaFormat = this.jto.getTrackFormat(i2);
                    str = mediaFormat.getString("mime");
                    if (str.startsWith("audio/")) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= 0 && mediaFormat != null && !Util.isNullOrNil(str)) {
                    this.channelCount = mediaFormat.getInteger("channel-count");
                    this.iee = mediaFormat.getInteger("sample-rate");
                    this.jto.selectTrack(i2);
                    if (this.iho > 0) {
                        this.jto.seekTo(this.iho * 1000, 0);
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(mediaFormat.getInteger("max-input-size"));
                    while (true) {
                        allocateDirect.clear();
                        int readSampleData = this.jto.readSampleData(allocateDirect, 0);
                        Log.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.jto.gLF.getSampleTime() >= this.remuxEndTime * 1000) {
                            break;
                        } else if (this.jto.gLF.getSampleTrackIndex() != i2) {
                            Log.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACDataLock(this.bufId, allocateDirect, readSampleData);
                            this.jto.gLF.advance();
                        }
                    }
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e3, "muxAudio create extractor failed: %s", e3.getMessage());
            }
            String str2 = this.outputFilePath;
            if (this.ihS > 0) {
                str2 = str2 + "tempRotate.mp4";
            }
            long j3 = (long) this.videoDuration;
            if (j3 <= 0) {
                j2 = this.remuxEndTime - this.iho;
            } else {
                j2 = j3;
            }
            int muxingLock = MP4MuxerJNI.muxingLock(this.bufId, this.iee, 1024, 2, this.channelCount, str2, (((float) this.zwP.frameCount) * 1000.0f) / ((float) j2), null, 0);
            Log.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", Integer.valueOf(muxingLock));
            if (this.ihS > 0) {
                SightVideoJNI.tagRotateVideoVFS(str2, this.outputFilePath, this.ihS);
                s.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBufLock(this.bufId);
            k.zwi.aRR();
            AppMethodBeat.o(89611);
            return muxingLock;
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e4, "decode error: %s", e4.getMessage());
            AppMethodBeat.o(89611);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a
    public final int getType() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public class a extends MMHandler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z;
            Bitmap ejs;
            AppMethodBeat.i(89608);
            if (message.what == 1) {
                byte[] bArr = (byte[]) message.obj;
                boolean z2 = message.arg1 == 1;
                long j2 = (long) message.arg2;
                if (b.this.zwP != null) {
                    if (b.this.jud == null) {
                        b.this.jud = b.this.zwO.bhJ();
                    }
                    if (!(b.this.zwU == null || (ejs = b.this.zwU.ejs()) == null)) {
                        int rowBytes = ejs.getRowBytes() * ejs.getHeight();
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rowBytes);
                        allocateDirect.position(0);
                        ejs.copyPixelsToBuffer(allocateDirect);
                        allocateDirect.position(0);
                        if (b.this.zwT == null) {
                            b.this.zwT = new byte[rowBytes];
                        }
                        allocateDirect.get(b.this.zwT);
                        SightVideoJNI.blendYuvFrame(bArr, b.this.zwT, b.this.jud.x, b.this.jud.y);
                    }
                    if (b.this.ihg != null) {
                        if (b.this.zwT == null) {
                            if (b.this.ihS == 90 || b.this.ihS == 270) {
                                b.this.ihg = BitmapUtil.rotate(b.this.ihg, (float) (360 - b.this.ihS));
                            } else if (b.this.ihS == 180) {
                                b.this.ihg = BitmapUtil.rotate(b.this.ihg, 180.0f);
                            }
                            b.this.ihg = Bitmap.createScaledBitmap(b.this.ihg, b.this.jud.x, b.this.jud.y, true);
                            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(b.this.ihg.getRowBytes() * b.this.ihg.getHeight());
                            allocateDirect2.position(0);
                            b.this.ihg.copyPixelsToBuffer(allocateDirect2);
                            allocateDirect2.position(0);
                            b.this.zwT = new byte[allocateDirect2.remaining()];
                            allocateDirect2.get(b.this.zwT);
                        }
                        SightVideoJNI.blendYuvFrame(bArr, b.this.zwT, b.this.jud.x, b.this.jud.y);
                    }
                    f fVar = b.this.zwP;
                    int i2 = b.this.jud.x;
                    int i3 = b.this.jud.y;
                    if (z2 || bArr == null) {
                        fVar.b(fVar.jtm, true, j2);
                    } else {
                        if (i2 == fVar.targetWidth && i3 == fVar.targetHeight) {
                            z = false;
                        } else {
                            z = true;
                        }
                        Log.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(fVar.targetWidth), Integer.valueOf(fVar.targetHeight), Long.valueOf(j2));
                        if (fVar.jtm == null) {
                            fVar.jtm = new byte[(((fVar.targetWidth * fVar.targetHeight) * 3) >> 1)];
                        }
                        if (fVar.colorFormat != 19 || z) {
                            MP4MuxerJNI.yuv420pTo420XXAndScaleLock(bArr, 2, fVar.jtm, fVar.jtn, i2, i3, i2, i3, fVar.targetWidth, fVar.targetHeight);
                        } else {
                            System.arraycopy(bArr, 0, fVar.jtm, 0, bArr.length);
                        }
                        fVar.jti++;
                        fVar.b(fVar.jtm, false, j2);
                    }
                    k.zwi.k(bArr);
                }
            }
            AppMethodBeat.o(89608);
        }
    }
}
