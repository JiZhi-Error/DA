package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaFormat;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.b.g;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c extends a {
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
    private com.tencent.mm.compatible.i.c jto;
    private Point jud = null;
    private String outputFilePath;
    private int outputHeight;
    private int outputWidth;
    private long remuxEndTime = -1;
    private int videoDuration = -1;
    private int videoFps;
    private a zwO;
    private byte[] zwS = null;
    private byte[] zwT = null;
    private a.AbstractC1479a zwU;
    private g zwW;
    private int zwX;
    private int zwY;

    public c(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(89613);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || i2 <= 0 || i3 <= 0) {
            Log.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5));
            AppMethodBeat.o(89613);
            return;
        }
        this.filePath = str;
        this.outputFilePath = str2;
        this.outputWidth = i2;
        this.outputHeight = i3;
        this.iix = i4;
        this.iiB = i5;
        this.zwX = i6;
        this.zwY = i7;
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
        Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.ihQ), Integer.valueOf(this.ihR), Integer.valueOf(this.ihS), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(89613);
    }

    public c(String str, String str2, int i2, int i3, int i4, int i5, long j2, long j3, int i6, int i7) {
        AppMethodBeat.i(89614);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || i2 <= 0 || i3 <= 0) {
            Log.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5));
            AppMethodBeat.o(89614);
            return;
        }
        this.filePath = str;
        this.outputFilePath = str2;
        this.outputWidth = i2;
        this.outputHeight = i3;
        this.iix = i4;
        this.iiB = i5;
        this.zwX = i6;
        this.zwY = i7;
        this.ihS = SightVideoJNI.getMp4RotateVFS(str);
        com.tencent.mm.plugin.sight.base.a aNx = e.aNx(str);
        if (aNx != null) {
            this.ihQ = aNx.width;
            this.ihR = aNx.height;
            this.videoFps = aNx.frameRate;
        }
        this.iho = j2;
        this.remuxEndTime = j3;
        Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.ihQ), Integer.valueOf(this.ihR), Integer.valueOf(this.ihS), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(89614);
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
        AppMethodBeat.i(89615);
        int round = Math.round(((float) this.videoDuration) / 1000.0f);
        if (this.iho >= 0 && this.remuxEndTime >= 0) {
            round = Math.round(((float) (this.remuxEndTime - this.iho)) / 1000.0f) + 1;
        }
        this.bufId = MP4MuxerJNI.initDataBufLock(round);
        if (com.tencent.mm.bk.e.QW(this.filePath)) {
            Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "ish265, create mediacodec decoder");
            this.zwO = new e();
        } else {
            this.zwO = new d();
        }
        if (this.videoDuration > 0) {
            e2 = this.zwO.e(this.filePath, 0, (long) this.videoDuration, this.videoFps);
        } else if (this.iho < 0 || this.remuxEndTime < 0) {
            Log.e("MicroMsg.MMSightFFMpegX264Remuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.videoDuration), Long.valueOf(this.iho), Long.valueOf(this.remuxEndTime));
            MP4MuxerJNI.releaseDataBufLock(this.bufId);
            AppMethodBeat.o(89615);
            return -1;
        } else {
            e2 = this.zwO.e(this.filePath, this.iho, this.remuxEndTime, this.videoFps);
        }
        Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "decoder init ret: %s", Integer.valueOf(e2));
        if (e2 < 0) {
            MP4MuxerJNI.releaseDataBufLock(this.bufId);
            AppMethodBeat.o(89615);
            return -1;
        }
        if (this.iiB > 0 && this.iiB < this.videoFps) {
            this.zwO.uf((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.iiB))));
        }
        int min = this.iiB > 0 ? Math.min(this.iiB, this.videoFps) : this.videoFps;
        this.zwO.a(new h() {
            /* class com.tencent.mm.plugin.mmsight.model.b.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.mmsight.model.b.h
            public final void a(byte[] bArr, boolean z, long j2) {
                boolean z2;
                Bitmap ejs;
                AppMethodBeat.i(89612);
                if (c.this.jud == null) {
                    c.this.jud = c.this.zwO.bhJ();
                }
                if (!(c.this.zwU == null || (ejs = c.this.zwU.ejs()) == null)) {
                    int rowBytes = ejs.getRowBytes() * ejs.getHeight();
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rowBytes);
                    allocateDirect.position(0);
                    ejs.copyPixelsToBuffer(allocateDirect);
                    allocateDirect.position(0);
                    if (c.this.zwT == null) {
                        c.this.zwT = new byte[rowBytes];
                    }
                    allocateDirect.get(c.this.zwT);
                    SightVideoJNI.blendYuvFrame(bArr, c.this.zwT, c.this.jud.x, c.this.jud.y);
                }
                if (c.this.ihg != null) {
                    if (c.this.zwT == null) {
                        if (c.this.ihS == 90 || c.this.ihS == 270) {
                            c.this.ihg = BitmapUtil.rotate(c.this.ihg, (float) (360 - c.this.ihS));
                        } else if (c.this.ihS == 180) {
                            c.this.ihg = BitmapUtil.rotate(c.this.ihg, 180.0f);
                        }
                        c.this.ihg = Bitmap.createScaledBitmap(c.this.ihg, c.this.jud.x, c.this.jud.y, true);
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(c.this.ihg.getRowBytes() * c.this.ihg.getHeight());
                        allocateDirect2.position(0);
                        c.this.ihg.copyPixelsToBuffer(allocateDirect2);
                        allocateDirect2.position(0);
                        c.this.zwT = new byte[allocateDirect2.remaining()];
                        allocateDirect2.get(c.this.zwT);
                    }
                    SightVideoJNI.blendYuvFrame(bArr, c.this.zwT, c.this.jud.x, c.this.jud.y);
                }
                if (c.this.zwW != null) {
                    g gVar = c.this.zwW;
                    int i2 = c.this.jud.x;
                    int i3 = c.this.jud.y;
                    int bhK = c.this.zwO.bhK();
                    if (bArr != null) {
                        if (i2 == gVar.targetWidth && i3 == gVar.targetHeight) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        Log.d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(gVar.targetWidth), Integer.valueOf(gVar.targetHeight), Long.valueOf(j2));
                        MP4MuxerJNI.writeYuvDataForSegmentLock(bArr, i2, i3, gVar.targetWidth, gVar.targetHeight, bhK, gVar.kxW, gVar.kxX);
                        gVar.frameCount++;
                    }
                }
                k.zwi.k(bArr);
                if (z && c.this.zwW != null) {
                    g gVar2 = c.this.zwW;
                    if (gVar2.zxg != null) {
                        gVar2.zxg.jue = true;
                    }
                }
                AppMethodBeat.o(89612);
            }
        });
        this.zwW = new g(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, this.iix, min, com.tencent.mm.plugin.sight.base.c.Dmc, this.zwX, this.zwY);
        g gVar = this.zwW;
        gVar.frameCount = 0;
        MP4MuxerJNI.initH264EncoderLock(gVar.targetWidth, gVar.targetHeight, (float) gVar.frameRate, gVar.bitrate, gVar.iSV, 8, gVar.iSU, 23.0f, gVar.zwX, gVar.zwY);
        gVar.zxg = new g.a(gVar, (byte) 0);
        i iVar = h.RTc;
        g.a aVar = new g.a(gVar, (byte) 0);
        gVar.zxg = aVar;
        iVar.ba(aVar);
        gVar.isStart = false;
        Log.i("MicroMsg.MMSightRemuxX264Encoder", "initAndStartEncoder");
        try {
            this.zwO.ekm();
            g gVar2 = this.zwW;
            if (gVar2.zxg != null) {
                gVar2.zxg.jue = true;
                try {
                    gVar2.zxg.hmy();
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.MMSightRemuxX264Encoder", e3, "waitEncoderFinish, join error: %s", e3.getMessage());
                }
            }
            this.jto = new com.tencent.mm.compatible.i.c();
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
                        Log.d("MicroMsg.MMSightFFMpegX264Remuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.jto.gLF.getSampleTime() >= this.remuxEndTime * 1000) {
                            break;
                        } else if (this.jto.gLF.getSampleTrackIndex() != i2) {
                            Log.e("MicroMsg.MMSightFFMpegX264Remuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACDataLock(this.bufId, allocateDirect, readSampleData);
                            this.jto.gLF.advance();
                        }
                    }
                }
            } catch (IOException e4) {
                Log.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e4, "muxAudio create extractor failed: %s", e4.getMessage());
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
            int muxingForX264Lock = MP4MuxerJNI.muxingForX264Lock(this.iee, 1024, 2, this.channelCount, str2, (((float) this.zwW.frameCount) * 1000.0f) / ((float) j2), (int) j2, null, 0);
            Log.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxing ret: %s", Integer.valueOf(muxingForX264Lock));
            if (this.ihS > 0) {
                SightVideoJNI.tagRotateVideoVFS(str2, this.outputFilePath, this.ihS);
                s.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBufLock(this.bufId);
            k.zwi.aRR();
            AppMethodBeat.o(89615);
            return muxingForX264Lock;
        } catch (Exception e5) {
            Log.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e5, "decode error: %s", e5.getMessage());
            AppMethodBeat.o(89615);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.mmsight.api.a
    public final int getType() {
        return 3;
    }
}
