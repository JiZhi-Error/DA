package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

public final class a {
    private static final int[] beC = {1, 2, 3, 6};
    private static final int[] beD = {48000, 44100, 32000};
    private static final int[] beE = {24000, 22050, 16000};
    private static final int[] beF = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] beG = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320, 384, FileUtils.S_IRWXU, 512, 576, 640};
    private static final int[] beH = {69, 87, 104, 121, b.CTRL_INDEX, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 208, d.CTRL_INDEX, 278, e.a.CTRL_INDEX, 417, 487, JsApiGetLabInfo.CTRL_INDEX, 696, 835, 975, FaceManager.FACE_ACQUIRED_RIGHT, 1253, 1393};

    /* renamed from: com.google.android.exoplayer2.a.a$a  reason: collision with other inner class name */
    public static final class C0098a {
        public final int beI;
        public final int channelCount;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;

        /* synthetic */ C0098a(String str, int i2, int i3, int i4, int i5, byte b2) {
            this(str, i2, i3, i4, i5);
        }

        private C0098a(String str, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.beI = i4;
            this.sampleCount = i5;
        }
    }

    public static Format a(m mVar, String str, String str2, DrmInitData drmInitData) {
        AppMethodBeat.i(91748);
        int i2 = beD[(mVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = mVar.readUnsignedByte();
        int i3 = beF[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i3++;
        }
        Format a2 = Format.a(str, "audio/ac3", -1, -1, i3, i2, null, drmInitData, str2);
        AppMethodBeat.o(91748);
        return a2;
    }

    public static Format b(m mVar, String str, String str2, DrmInitData drmInitData) {
        AppMethodBeat.i(91749);
        mVar.eZ(2);
        int i2 = beD[(mVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = mVar.readUnsignedByte();
        int i3 = beF[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i3++;
        }
        Format a2 = Format.a(str, "audio/eac3", -1, -1, i3, i2, null, drmInitData, str2);
        AppMethodBeat.o(91749);
        return a2;
    }

    public static int n(byte[] bArr) {
        AppMethodBeat.i(91751);
        if (bArr.length < 5) {
            AppMethodBeat.o(91751);
            return -1;
        }
        int bc = bc((bArr[4] & 192) >> 6, bArr[4] & 63);
        AppMethodBeat.o(91751);
        return bc;
    }

    public static int tG() {
        return 1536;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i2;
        AppMethodBeat.i(91752);
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) == 3) {
            i2 = 6;
        } else {
            i2 = beC[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        int i3 = i2 * 256;
        AppMethodBeat.o(91752);
        return i3;
    }

    private static int bc(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0 || i2 >= beD.length || i3 < 0 || i4 >= beH.length) {
            return -1;
        }
        int i5 = beD[i2];
        if (i5 == 44100) {
            return (beH[i4] + (i3 % 2)) * 2;
        }
        int i6 = beG[i4];
        if (i5 == 32000) {
            return i6 * 6;
        }
        return i6 * 4;
    }

    public static C0098a a(l lVar) {
        int bc;
        int em;
        int i2;
        int i3;
        String str;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(91750);
        int i6 = lVar.bpJ + (lVar.bpI * 8);
        lVar.en(40);
        boolean z = lVar.em(5) == 16;
        lVar.setPosition(i6);
        if (z) {
            lVar.en(21);
            bc = (lVar.em(11) + 1) * 2;
            int em2 = lVar.em(2);
            if (em2 == 3) {
                i2 = beE[lVar.em(2)];
                i4 = 6;
            } else {
                i4 = beC[lVar.em(2)];
                i2 = beD[em2];
            }
            i3 = i4 * 256;
            em = lVar.em(3);
            str = "audio/eac3";
        } else {
            lVar.en(32);
            int em3 = lVar.em(2);
            bc = bc(em3, lVar.em(6));
            lVar.en(8);
            em = lVar.em(3);
            if (!((em & 1) == 0 || em == 1)) {
                lVar.en(2);
            }
            if ((em & 4) != 0) {
                lVar.en(2);
            }
            if (em == 2) {
                lVar.en(2);
            }
            i2 = beD[em3];
            i3 = 1536;
            str = "audio/ac3";
        }
        boolean uI = lVar.uI();
        int i7 = beF[em];
        if (!uI) {
            i5 = 0;
        }
        C0098a aVar = new C0098a(str, i5 + i7, i2, bc, i3, (byte) 0);
        AppMethodBeat.o(91750);
        return aVar;
    }
}
