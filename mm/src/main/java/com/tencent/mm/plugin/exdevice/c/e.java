package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.exdevice.f.f;
import com.tencent.mm.plugin.exdevice.f.g;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import com.tencent.wxmm.v2encoder;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.CRC32;

public final class e extends d {
    public e(long j2, int i2, int i3, byte[] bArr) {
        super(j2, i2, i3, bArr);
        AppMethodBeat.i(23150);
        Log.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + j2 + " seq = " + i2 + " cmdId = " + i3);
        AppMethodBeat.o(23150);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.exdevice.c.d
    public final a bu(byte[] bArr) {
        AppMethodBeat.i(23151);
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
            AppMethodBeat.o(23151);
            return null;
        }
        f fVar = new f();
        try {
            fVar.parseFrom(bArr);
            Log.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
            this.rxA = fVar;
            AppMethodBeat.o(23151);
            return fVar;
        } catch (IOException e2) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdInit", e2, "", new Object[0]);
            AppMethodBeat.o(23151);
            return null;
        }
    }

    public final void a(int i2, String str, byte[] bArr, byte[] bArr2, int i3, int i4) {
        int[] iArr;
        int i5;
        long j2;
        AppMethodBeat.i(23152);
        Log.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", Integer.valueOf(i2), str, b.bw(bArr), b.bw(bArr2), Integer.valueOf(i3), Integer.valueOf(i4));
        g gVar = new g();
        gVar.rCc = aQ(0, "ok");
        String aTY = z.aTY();
        if (!Util.isNullOrNil(aTY)) {
            String lowerCase = MD5Util.getMD5String(aTY).toLowerCase();
            Log.i("MicroMsg.exdevice.Util", "user md5 : [%s]", lowerCase);
            if (Util.isNullOrNil(lowerCase)) {
                Log.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
                j2 = 0;
            } else {
                int i6 = 0;
                char[] charArray = lowerCase.toCharArray();
                if (charArray.length > 0) {
                    for (char c2 : charArray) {
                        i6 = (i6 * 31) + c2;
                    }
                }
                long j3 = ((long) i6) & Util.MAX_32BIT_VALUE;
                Log.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", Integer.valueOf(i6), Long.valueOf(j3));
                j2 = j3;
            }
            iArr = new int[]{(int) ((j2 >> 32) & Util.MAX_32BIT_VALUE), (int) (j2 & Util.MAX_32BIT_VALUE)};
        } else {
            iArr = null;
        }
        gVar.rBP = iArr[0];
        gVar.rBQ = iArr[1];
        if (!Util.isNullOrNil(bArr2)) {
            if (bArr2 == null || bArr2.length == 0) {
                i5 = 0;
            } else {
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                i5 = (int) crc32.getValue();
            }
            gVar.rBR = i5;
        }
        if (!Util.isNullOrNil(bArr)) {
            if ((bArr[0] & 4) != 0) {
                gVar.oTJ = d.KyJ;
            }
            if ((bArr[0] & 8) != 0) {
                gVar.rBW = d.KyM;
            }
            if ((bArr[0] & 2) != 0) {
                gVar.rBV = 2;
            }
            if ((bArr[0] & v2encoder.enumCODEC_vcodec2) != 0) {
                gVar.rBX = (int) Util.nowSecond();
            }
            if ((bArr[0] & 32) != 0) {
                TimeZone timeZone = TimeZone.getDefault();
                int rawOffset = timeZone.getRawOffset() / 1000;
                int i7 = (!timeZone.useDaylightTime() || !timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 0 : 1;
                int i8 = (rawOffset / LocalCache.TIME_HOUR) + i7;
                Log.i("MicroMsg.exdevice.Util", "getTimeZone, rawSecond = %d, dt = %d, re = %d", Integer.valueOf(rawOffset), Integer.valueOf(i7), Integer.valueOf(i8));
                gVar.rBY = i8;
            }
            if ((bArr[0] & 64) != 0) {
                gVar.rBZ = b.cMi();
            }
            if ((bArr[0] & 1) != 0) {
                gVar.rBU = z.aUa();
            }
        }
        gVar.rBS = i3;
        gVar.rBT = i4;
        this.rxz = gVar;
        this.rxx = 20003;
        AppMethodBeat.o(23152);
    }
}
