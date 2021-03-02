package com.tencent.mm.plugin.multitalk.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.facebook.appevents.AppEventsConstants;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.voip.model.g;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class j extends Thread {
    public static int zLk = 10;
    private static String zLl = b.aKJ();
    public static byte[] zLo = null;
    public static byte[] zLp = null;
    public static byte[] zLq = null;
    public static int zLs = 640;
    public static int zLt = 480;
    public byte[] configbyte;
    private BufferedOutputStream outputStream;
    private Surface surface;
    public int yGf;
    public int yGg;
    public int zLA;
    public int zLB;
    public int zLC;
    private int zLD;
    private int zLE;
    private a zLF;
    public byte[] zLG;
    public byte[] zLH;
    public byte[] zLI;
    private int zLJ;
    private BufferedOutputStream zLm;
    private z zLn;
    private boolean zLr;
    private boolean zLu;
    public boolean zLv;
    public boolean zLw;
    public boolean zLx;
    public int zLy;
    public byte[] zLz;

    public interface a {
        void onSizeChanged(int i2, int i3);
    }

    static {
        AppMethodBeat.i(239335);
        AppMethodBeat.o(239335);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(239326);
        this.zLF = aVar;
        if (!(this.yGf == 0 || this.yGg == 0)) {
            this.zLF.onSizeChanged(this.yGf, this.yGg);
        }
        AppMethodBeat.o(239326);
    }

    public j(Surface surface2) {
        AppMethodBeat.i(239327);
        this.outputStream = null;
        this.zLm = null;
        this.configbyte = null;
        this.zLr = false;
        this.zLu = false;
        this.zLv = true;
        this.zLw = true;
        this.zLx = false;
        this.zLy = 0;
        this.zLz = new byte[]{0, 0, 0, 1};
        this.zLA = 0;
        this.zLB = 0;
        this.zLC = 0;
        this.zLD = 0;
        this.zLE = 0;
        this.yGf = 0;
        this.yGg = 0;
        this.zLG = new byte[]{103, 100, 0, JceStruct.SIMPLE_LIST, -84, -74, 10, 15, -120};
        this.zLH = new byte[]{0, 0, 0, 1, 40, -50, 60, 48};
        this.zLI = new byte[]{JceStruct.SIMPLE_LIST, 0, -15, 98, -22};
        this.zLJ = 39;
        this.zLv = true;
        this.zLw = true;
        this.zLn = null;
        this.zLr = false;
        this.zLC = 0;
        if (surface2 != null) {
            this.surface = surface2;
        }
        AppMethodBeat.o(239327);
    }

    private int emA() {
        AppMethodBeat.i(239328);
        this.zLy++;
        Log.i("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.zLx + ", mIsHWDecEnable = " + this.zLv + ", mHWErrorDecFrmCount = " + this.zLy);
        if (!this.zLv || this.zLy > zLk) {
            int i2 = 8;
            if (this.zLr) {
                i2 = 16;
            }
            ByteBuffer allocate = ByteBuffer.allocate(6);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putShort(0);
            allocate.putShort((short) i2);
            allocate.putShort(0);
            ac.eol().zMd.setAppCmd(this.zLJ, allocate.array(), 6);
            emB();
            this.zLC |= 64;
            Log.i("MeidaCodec[HWDec]", "[HW]: ErrFrm > threshold, end HWDec!!");
            AppMethodBeat.o(239328);
            return 0;
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(1);
        allocate2.order(ByteOrder.LITTLE_ENDIAN);
        allocate2.put((byte) 1);
        ac.eol().zMd.setAppCmd(28, allocate2.array(), 1);
        this.zLx = true;
        AppMethodBeat.o(239328);
        return 1;
    }

    private static String bO(byte[] bArr) {
        AppMethodBeat.i(239329);
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
            }
            str = str + hexString;
        }
        AppMethodBeat.o(239329);
        return str;
    }

    public final int f(byte[] bArr, int i2, boolean z) {
        boolean z2;
        byte[] bArr2;
        int i3;
        char c2;
        ByteBuffer inputBuffer;
        MediaFormat createVideoFormat;
        int length;
        boolean z3;
        AppMethodBeat.i(239330);
        if (bArr == null) {
            Log.d("TAG", "DECODER_THREAD:: data not ready yet!");
            AppMethodBeat.o(239330);
            return -1;
        } else if (!this.zLv) {
            this.zLC |= 1;
            Log.d("TAG", "DECODER_THREAD:: HWDec NOT supported!");
            AppMethodBeat.o(239330);
            return -1;
        } else {
            if (z && this.zLn != null) {
                this.zLu = false;
            }
            System.currentTimeMillis();
            byte[] bArr3 = null;
            if (i2 == 2) {
                try {
                    cap cap = (cap) new cap().parseFrom(bArr);
                    if (cap.MfN == null) {
                        length = 0;
                    } else {
                        length = cap.MfN.zy.length;
                    }
                    int length2 = cap.MfL.zy.length;
                    int length3 = cap.MfM.zy.length;
                    if (length != 0) {
                        if (!this.zLr) {
                            this.zLu = false;
                        }
                        this.zLr = true;
                        zLo = new byte[(length + 4)];
                        zLp = new byte[(length2 + 4)];
                        zLq = new byte[(length3 + 4)];
                        System.arraycopy(this.zLz, 0, zLo, 0, 4);
                        System.arraycopy(this.zLz, 0, zLp, 0, 4);
                        System.arraycopy(this.zLz, 0, zLq, 0, 4);
                        cap.MfN.cE(zLo);
                        cap.MfL.cE(zLp);
                        cap.MfM.cE(zLq);
                        this.configbyte = new byte[(zLo.length + zLp.length + zLq.length)];
                        System.arraycopy(zLo, 0, this.configbyte, 0, zLo.length);
                        int length4 = zLo.length + 0;
                        System.arraycopy(zLp, 0, this.configbyte, length4, zLp.length);
                        System.arraycopy(zLq, 0, this.configbyte, length4 + zLp.length, zLq.length);
                    } else {
                        if (this.zLr) {
                            this.zLu = false;
                        }
                        this.zLr = false;
                        byte[] bArr4 = new byte[(length2 + 4)];
                        System.arraycopy(this.zLz, 0, bArr4, 0, 4);
                        cap.MfL.cE(bArr4);
                        Log.d("MeidaCodec[HWDec]", " old sps: ".concat(String.valueOf(bArr4)));
                        String bO = bO(bArr4);
                        String bO2 = bO(new byte[]{0, 0, 3});
                        Log.d("MeidaCodec[HWDec]", "parent: " + bO + ", child:" + bO2);
                        int indexOf = bO.indexOf(bO2, 0);
                        if (indexOf != -1) {
                            Log.d("MeidaCodec[HWDec]", "hack code detected!!pos: ".concat(String.valueOf(indexOf)));
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            Log.i("MeidaCodec[HWDec]", " Hack code existed!! NO modify ");
                            zLp = bArr4;
                        } else {
                            zLp = new g().cf(bArr4);
                        }
                        Log.d("MeidaCodec[HWDec]", " Parsing protobuf, spsLen = " + zLp.length + ", original=" + length2);
                        zLq = new byte[(length3 + 4)];
                        System.arraycopy(this.zLz, 0, zLq, 0, 4);
                        cap.MfM.cE(zLq);
                        this.configbyte = new byte[(zLp.length + zLq.length)];
                        System.arraycopy(zLp, 0, this.configbyte, 0, zLp.length);
                        System.arraycopy(zLq, 0, this.configbyte, zLp.length + 0, zLq.length);
                    }
                    this.zLD = length2;
                    byte[] bArr5 = new byte[(zLp.length - 4)];
                    System.arraycopy(zLp, 4, bArr5, 0, zLp.length - 4);
                    bR(bArr5);
                    z2 = true;
                } catch (Exception e2) {
                    this.zLC |= 2;
                    Log.e("MeidaCodec[HWDec]", " sps/pps parsing error:" + e2.toString());
                    z2 = false;
                }
            } else {
                try {
                    cao cao = (cao) new cao().parseFrom(bArr);
                    int intValue = cao.MfJ.getFirst().intValue();
                    int i4 = 0;
                    Log.d("MeidaCodec[HWDec]", " Parsing protobuf, framelen = ".concat(String.valueOf(intValue)));
                    if (i2 == 1) {
                        int length5 = this.configbyte.length;
                        i3 = intValue + length5;
                        bArr2 = new byte[i3];
                        System.arraycopy(this.configbyte, 0, bArr2, 0, length5);
                        i4 = length5 + 0;
                    } else {
                        bArr2 = new byte[intValue];
                        i3 = intValue;
                    }
                    int i5 = 0;
                    int i6 = intValue;
                    while (true) {
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        cao.MfG.j(allocate.array(), i5, 0, 4);
                        allocate.order(ByteOrder.BIG_ENDIAN);
                        int i7 = allocate.getInt(0);
                        System.arraycopy(this.zLz, 0, bArr2, i5 + i4, 4);
                        int i8 = i5 + 4;
                        cao.MfG.j(bArr2, i8, i8 + i4, i7);
                        int i9 = i8 + i7;
                        i6 -= i7 + 4;
                        Log.d("MeidaCodec[HWDec]", "steve: nTmpLen :" + i7 + ", framelen:" + i3 + ", naluType:" + i2);
                        if (i6 <= 0) {
                            break;
                        }
                        i5 = i9;
                    }
                    z2 = false;
                    bArr3 = bArr2;
                } catch (Exception e3) {
                    this.zLC |= 4;
                    Log.e("MeidaCodec[HWDec]", " frame parsing error:" + e3.toString());
                    z2 = false;
                }
            }
            if (!(bArr3 == null || this.zLm == null)) {
                try {
                    this.zLm.write(bArr3, 0, bArr3.length);
                } catch (IOException e4) {
                    Log.e("MeidaCodec[HWDec]", " error:" + e4.toString());
                }
            }
            if (z2) {
                try {
                    if (!(zLp == null || zLq == null)) {
                        if (!this.zLu) {
                            if (this.zLn != null) {
                                try {
                                    this.zLn.stop();
                                    this.zLn.release();
                                    this.zLn = null;
                                } catch (Exception e5) {
                                    Log.e("MeidaCodec[HWDec]", " decoder stop  error:" + e5.toString());
                                }
                            }
                            if (this.zLr) {
                                createVideoFormat = MediaFormat.createVideoFormat(TPDecoderType.TP_CODEC_MIMETYPE_HEVC, zLs, zLt);
                            } else {
                                createVideoFormat = MediaFormat.createVideoFormat("video/avc", zLs, zLt);
                            }
                            createVideoFormat.setInteger("rotation-degrees", 90);
                            Log.i("MeidaCodec[HWDec]", "create HW decoder, format : ".concat(String.valueOf(createVideoFormat)));
                            String string = createVideoFormat.getString("mime");
                            if (string.startsWith("video/")) {
                                this.zLn = z.DZ(string);
                                try {
                                    Log.d("MeidaCodec[HWDec]", "configure, format : ".concat(String.valueOf(createVideoFormat)));
                                    this.zLn.a(createVideoFormat, this.surface, 0);
                                    this.zLn.start();
                                    this.zLu = true;
                                    start();
                                } catch (Exception e6) {
                                    this.zLC |= 8;
                                    Log.e("MeidaCodec[HWDec]", "codec '" + string + "' failed configuration. " + e6);
                                    this.zLv = false;
                                    emA();
                                    AppMethodBeat.o(239330);
                                    return -1;
                                }
                            }
                        }
                        AppMethodBeat.o(239330);
                        return 1;
                    }
                } catch (Exception e7) {
                    this.zLC |= 16;
                    Log.e("MeidaCodec[HWDec]", " error:" + e7.toString());
                }
            }
            if (!this.zLu) {
                Log.e("MeidaCodec[HWDec]", "DECODER_THREAD:: decoder not ready yet");
                emA();
                AppMethodBeat.o(239330);
                return -1;
            } else if (bArr3 == null) {
                Log.e("MeidaCodec[HWDec]", "currentFrame is null!!!");
                AppMethodBeat.o(239330);
                return -1;
            } else {
                if (!this.zLw) {
                    this.zLw = true;
                }
                int length6 = bArr3.length;
                int i10 = bArr3[4] & 31;
                if (i10 == 7 || i10 == 8) {
                    c2 = 'S';
                } else {
                    c2 = (i10 == 5 || i10 == 6) ? 'I' : 'P';
                }
                Log.d("MeidaCodec[HWDec]", "steve: before dequeueInputBuffer, frameLen=" + length6 + ", fNalType=" + i10 + ", frmType=" + c2 + ", mInputCnt=" + this.zLB);
                if (!this.zLx || c2 != 'P') {
                    int dequeueInputBuffer = this.zLn.dequeueInputBuffer(10000);
                    if (dequeueInputBuffer < 0) {
                        if (this.zLx && c2 != 'P') {
                            this.zLv = false;
                            this.zLC |= 32;
                        }
                        emA();
                        Log.e("MeidaCodec[HWDec]", "steve: fail to input data into mediacodec inputbuffer!!");
                    } else if (bArr3 != null && length6 > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("MeidaCodec[HWDec]", "steve: (10000us)put data into inputbuffer,idx=" + dequeueInputBuffer + ", frameLen=" + length6 + ", frmType=" + c2 + ", inputpts=" + currentTimeMillis);
                        if (Build.VERSION.SDK_INT < 21) {
                            inputBuffer = this.zLn.getInputBuffers()[dequeueInputBuffer];
                            inputBuffer.clear();
                        } else {
                            inputBuffer = this.zLn.getInputBuffer(dequeueInputBuffer);
                        }
                        inputBuffer.clear();
                        inputBuffer.put(bArr3, 0, length6);
                        this.zLn.a(dequeueInputBuffer, length6, currentTimeMillis, 0);
                        this.zLB++;
                        this.zLy = 0;
                        if (this.zLx) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(1);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            allocate2.put((byte) 0);
                            ac.eol().zMd.setAppCmd(28, allocate2.array(), 1);
                            this.zLx = false;
                        }
                    }
                    AppMethodBeat.o(239330);
                    return 0;
                }
                Log.e("MeidaCodec[HWDec]", "DECODER_THREAD:: IRequest, not decodeable!");
                AppMethodBeat.o(239330);
                return -2;
            }
        }
    }

    private long bP(byte[] bArr) {
        long j2 = 0;
        long j3 = 0;
        while (this.zLE < (this.zLD << 3) && (bArr[this.zLE >> 3] & (128 >> (this.zLE & 7))) == 0) {
            j3++;
            this.zLE++;
        }
        this.zLE++;
        for (int i2 = 0; ((long) i2) < j3; i2++) {
            j2 <<= 1;
            if ((bArr[this.zLE >> 3] & (128 >> (this.zLE & 7))) != 0) {
                j2++;
            }
            this.zLE++;
        }
        return ((long) ((1 << ((int) j3)) - 1)) + j2;
    }

    private long bQ(byte[] bArr) {
        AppMethodBeat.i(239331);
        long bP = bP(bArr);
        long j2 = (1 + bP) >> 1;
        if (bP % 2 == 0) {
            j2 = -j2;
        }
        AppMethodBeat.o(239331);
        return j2;
    }

    private long e(long j2, byte[] bArr) {
        long j3 = 0;
        int i2 = 0;
        while (true) {
            if (!(((long) i2) < j2) || !(this.zLE < (this.zLD << 3))) {
                return j3;
            }
            j3 <<= 1;
            if ((bArr[this.zLE >> 3] & (128 >> (this.zLE & 7))) != 0) {
                j3++;
            }
            this.zLE++;
            i2++;
        }
    }

    private boolean bR(byte[] bArr) {
        AppMethodBeat.i(239332);
        this.zLE = 0;
        e(1, bArr);
        e(2, bArr);
        if (e(5, bArr) == 7) {
            long e2 = e(8, bArr);
            e(1, bArr);
            e(1, bArr);
            e(1, bArr);
            e(1, bArr);
            e(4, bArr);
            e(8, bArr);
            bP(bArr);
            if (e2 == 100 || e2 == 110 || e2 == 122 || e2 == 144) {
                if (bP(bArr) == 3) {
                    e(1, bArr);
                }
                bP(bArr);
                bP(bArr);
                e(1, bArr);
                long[] jArr = new long[8];
                if (e(1, bArr) != 0) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        jArr[i2] = e(1, bArr);
                    }
                }
            }
            bP(bArr);
            long bP = bP(bArr);
            if (bP == 0) {
                bP(bArr);
            } else if (bP == 1) {
                e(1, bArr);
                bQ(bArr);
                bQ(bArr);
                int bP2 = (int) bP(bArr);
                long[] jArr2 = new long[bP2];
                for (int i3 = 0; i3 < bP2; i3++) {
                    jArr2[i3] = bQ(bArr);
                }
            }
            bP(bArr);
            e(1, bArr);
            int bP3 = ((int) (bP(bArr) + 1)) * 16;
            int bP4 = ((int) (bP(bArr) + 1)) * 16;
            Log.i("MeidaCodec[HWDec]", "newWidth[%d], newHeight[%d]", Integer.valueOf(bP3), Integer.valueOf(bP4));
            if (!(bP3 == this.yGf && bP4 == this.yGg)) {
                this.yGf = bP3;
                this.yGg = bP4;
                if (this.zLF != null) {
                    this.zLF.onSizeChanged(bP3, bP4);
                }
            }
            AppMethodBeat.o(239332);
            return true;
        }
        AppMethodBeat.o(239332);
        return false;
    }

    @SuppressLint({"NewApi"})
    public final void run() {
        AppMethodBeat.i(239333);
        while (!Thread.interrupted() && this.zLv) {
            if (this.zLn == null || !this.zLu || !this.zLw) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e2) {
                    Log.e("MeidaCodec[HWDec]", " error:" + e2.toString());
                }
            } else {
                try {
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int dequeueOutputBuffer = this.zLn.dequeueOutputBuffer(bufferInfo, 10000);
                    Log.d("MeidaCodec[HWDec]", "steve:  outIndex=".concat(String.valueOf(dequeueOutputBuffer)));
                    switch (dequeueOutputBuffer) {
                        case -3:
                            Log.d("MeidaCodec[HWDec]", "INFO_OUTPUT_BUFFERS_CHANGED");
                            continue;
                        case -2:
                            MediaFormat outputFormat = this.zLn.getOutputFormat();
                            Log.i("MeidaCodec[HWDec]", "DECODER_THREAD:: New format : ".concat(String.valueOf(outputFormat)));
                            outputFormat.getInteger("width");
                            outputFormat.getInteger("height");
                            continue;
                        case -1:
                            Log.d("MeidaCodec[HWDec]", "DECODER_THREAD:: dequeueOutputBuffer timed out!");
                            continue;
                        default:
                            if (bufferInfo.size <= 0) {
                                Log.d("MeidaCodec[HWDec]", "steve: drop frame: " + this.zLA + ", size:" + bufferInfo.size + ", pts:" + bufferInfo.presentationTimeUs);
                                this.zLn.releaseOutputBuffer(dequeueOutputBuffer, false);
                                break;
                            } else {
                                long j2 = bufferInfo.presentationTimeUs;
                                Log.d("MeidaCodec[HWDec]", "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : " + this.zLA + ", size:" + bufferInfo.size + ", pts:" + bufferInfo.presentationTimeUs + ", latency:" + (System.currentTimeMillis() - j2));
                                this.zLA++;
                                this.zLn.releaseOutputBuffer(dequeueOutputBuffer, true);
                                long currentTimeMillis = System.currentTimeMillis();
                                Log.d("MeidaCodec[HWDec]", "steve: Avcdecoder frame processTime = " + (currentTimeMillis - j2) + ", decFrameCnt=" + this.zLA + ", endTime=" + currentTimeMillis);
                                continue;
                            }
                    }
                } catch (Exception e3) {
                    this.zLv = false;
                    this.zLC |= 128;
                    emA();
                    Log.e("MeidaCodec[HWDec]", " dequeueOutputBuffer/releaseOutputBuffer error:" + e3.toString());
                }
            }
        }
        if (!this.zLv && this.zLn != null) {
            try {
                this.zLn.stop();
                this.zLn.release();
                this.zLn = null;
                AppMethodBeat.o(239333);
                return;
            } catch (Exception e4) {
                Log.e("MeidaCodec[HWDec]", " decoder stop  error:" + e4.toString());
            }
        }
        AppMethodBeat.o(239333);
    }

    public final void emB() {
        AppMethodBeat.i(239334);
        this.zLv = false;
        this.zLw = false;
        this.zLy = 0;
        Log.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
        try {
            if (this.outputStream != null) {
                this.outputStream.flush();
                this.outputStream.close();
            }
            if (this.zLm != null) {
                this.zLm.flush();
                this.zLm.close();
            }
            AppMethodBeat.o(239334);
        } catch (IOException e2) {
            Log.e("MeidaCodec[HWDec]", " error:" + e2.toString());
            AppMethodBeat.o(239334);
        }
    }
}
