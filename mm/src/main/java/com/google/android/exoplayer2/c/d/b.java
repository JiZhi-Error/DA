package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d.a;
import com.google.android.exoplayer2.c.d.d;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class b {
    private static final int bmC = x.bJ("vide");
    private static final int bmD = x.bJ("soun");
    private static final int bmE = x.bJ("text");
    private static final int bmF = x.bJ("sbtl");
    private static final int bmG = x.bJ("subt");
    private static final int bmH = x.bJ("clcp");
    private static final int bmI = x.bJ("cenc");
    private static final int bmk = x.bJ("meta");

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.c.d.b$b  reason: collision with other inner class name */
    public interface AbstractC0102b {
        int getSampleCount();

        int uD();

        boolean uE();
    }

    static {
        AppMethodBeat.i(92073);
        AppMethodBeat.o(92073);
    }

    public static j a(a.C0101a aVar, a.b bVar, long j2, DrmInitData drmInitData, boolean z, boolean z2) {
        int i2;
        long dE;
        int i3;
        long j3;
        long b2;
        AppMethodBeat.i(92063);
        a.C0101a eg = aVar.eg(a.bln);
        m mVar = eg.ef(a.blB).bmB;
        mVar.setPosition(16);
        int readInt = mVar.readInt();
        if (readInt == bmD) {
            i2 = 1;
        } else if (readInt == bmC) {
            i2 = 2;
        } else if (readInt == bmE || readInt == bmF || readInt == bmG || readInt == bmH) {
            i2 = 3;
        } else if (readInt == bmk) {
            i2 = 4;
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            AppMethodBeat.o(92063);
            return null;
        }
        m mVar2 = aVar.ef(a.blx).bmB;
        mVar2.setPosition(8);
        int ec = a.ec(mVar2.readInt());
        mVar2.eZ(ec == 0 ? 8 : 16);
        int readInt2 = mVar2.readInt();
        mVar2.eZ(4);
        boolean z3 = true;
        int i4 = mVar2.position;
        int i5 = ec == 0 ? 4 : 8;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                break;
            } else if (mVar2.data[i4 + i6] != -1) {
                z3 = false;
                break;
            } else {
                i6++;
            }
        }
        if (z3) {
            mVar2.eZ(i5);
            dE = -9223372036854775807L;
        } else {
            dE = ec == 0 ? mVar2.dE() : mVar2.xm();
            if (dE == 0) {
                dE = -9223372036854775807L;
            }
        }
        mVar2.eZ(16);
        int readInt3 = mVar2.readInt();
        int readInt4 = mVar2.readInt();
        mVar2.eZ(4);
        int readInt5 = mVar2.readInt();
        int readInt6 = mVar2.readInt();
        if (readInt3 == 0 && readInt4 == 65536 && readInt5 == -65536 && readInt6 == 0) {
            i3 = 90;
        } else if (readInt3 == 0 && readInt4 == -65536 && readInt5 == 65536 && readInt6 == 0) {
            i3 = 270;
        } else if (readInt3 == -65536 && readInt4 == 0 && readInt5 == 0 && readInt6 == -65536) {
            i3 = TXLiveConstants.RENDER_ROTATION_180;
        } else {
            i3 = 0;
        }
        f fVar = new f(readInt2, dE, i3);
        if (j2 == -9223372036854775807L) {
            j3 = fVar.duration;
        } else {
            j3 = j2;
        }
        m mVar3 = bVar.bmB;
        mVar3.setPosition(8);
        mVar3.eZ(a.ec(mVar3.readInt()) == 0 ? 8 : 16);
        long dE2 = mVar3.dE();
        if (j3 == -9223372036854775807L) {
            b2 = -9223372036854775807L;
        } else {
            b2 = x.b(j3, TimeUtil.SECOND_TO_US, dE2);
        }
        a.C0101a eg2 = eg.eg(a.blo).eg(a.blp);
        m mVar4 = eg.ef(a.blA).bmB;
        mVar4.setPosition(8);
        int ec2 = a.ec(mVar4.readInt());
        mVar4.eZ(ec2 == 0 ? 8 : 16);
        long dE3 = mVar4.dE();
        mVar4.eZ(ec2 == 0 ? 4 : 8);
        int readUnsignedShort = mVar4.readUnsignedShort();
        Pair create = Pair.create(Long.valueOf(dE3), new StringBuilder().append((char) (((readUnsignedShort >> 10) & 31) + 96)).append((char) (((readUnsignedShort >> 5) & 31) + 96)).append((char) ((readUnsignedShort & 31) + 96)).toString());
        c a2 = a(eg2.ef(a.blC).bmB, fVar.id, fVar.bdv, (String) create.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair<long[], long[]> b3 = b(aVar.eg(a.bly));
            jArr2 = (long[]) b3.second;
            jArr = (long[]) b3.first;
        }
        if (a2.bdF == null) {
            AppMethodBeat.o(92063);
            return null;
        }
        j jVar = new j(fVar.id, i2, ((Long) create.first).longValue(), dE2, b2, a2.bdF, a2.bmQ, a2.bmP, a2.biD, jArr, jArr2);
        AppMethodBeat.o(92063);
        return jVar;
    }

    public static m a(j jVar, a.C0101a aVar, i iVar) {
        AbstractC0102b eVar;
        long[] jArr;
        int[] iArr;
        int i2;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        int i3;
        int[] iArr4;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(92064);
        a.b ef = aVar.ef(a.blZ);
        if (ef != null) {
            eVar = new d(ef);
        } else {
            a.b ef2 = aVar.ef(a.bma);
            if (ef2 == null) {
                o oVar = new o("Track has no sample table size information");
                AppMethodBeat.o(92064);
                throw oVar;
            }
            eVar = new e(ef2);
        }
        int sampleCount = eVar.getSampleCount();
        if (sampleCount == 0) {
            m mVar = new m(new long[0], new int[0], 0, new long[0], new int[0]);
            AppMethodBeat.o(92064);
            return mVar;
        }
        boolean z2 = false;
        a.b ef3 = aVar.ef(a.bmb);
        if (ef3 == null) {
            z2 = true;
            ef3 = aVar.ef(a.bmc);
        }
        m mVar2 = ef3.bmB;
        m mVar3 = aVar.ef(a.blY).bmB;
        m mVar4 = aVar.ef(a.blV).bmB;
        a.b ef4 = aVar.ef(a.blW);
        m mVar5 = ef4 != null ? ef4.bmB : null;
        a.b ef5 = aVar.ef(a.blX);
        m mVar6 = ef5 != null ? ef5.bmB : null;
        a aVar2 = new a(mVar3, mVar2, z2);
        mVar4.setPosition(12);
        int xk = mVar4.xk() - 1;
        int xk2 = mVar4.xk();
        int xk3 = mVar4.xk();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        if (mVar6 != null) {
            mVar6.setPosition(12);
            i9 = mVar6.xk();
        }
        int i11 = -1;
        int i12 = 0;
        if (mVar5 != null) {
            mVar5.setPosition(12);
            i12 = mVar5.xk();
            if (i12 > 0) {
                i11 = mVar5.xk() - 1;
            } else {
                mVar5 = null;
            }
        }
        int i13 = 0;
        long j2 = 0;
        if (!(eVar.uE() && "audio/raw".equals(jVar.bdF.bdq) && xk == 0 && i9 == 0 && i12 == 0)) {
            long[] jArr4 = new long[sampleCount];
            int[] iArr5 = new int[sampleCount];
            long[] jArr5 = new long[sampleCount];
            int[] iArr6 = new int[sampleCount];
            long j3 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = i12;
            int i17 = i11;
            while (i15 < sampleCount) {
                while (i14 == 0) {
                    com.google.android.exoplayer2.i.a.checkState(aVar2.uC());
                    j3 = aVar2.offset;
                    i14 = aVar2.bmJ;
                }
                if (mVar6 != null) {
                    i5 = i10;
                    i6 = i9;
                    while (i8 == 0 && i6 > 0) {
                        i8 = mVar6.xk();
                        i5 = mVar6.readInt();
                        i6--;
                    }
                    i8--;
                } else {
                    i5 = i10;
                    i6 = i9;
                }
                jArr4[i15] = j3;
                iArr5[i15] = eVar.uD();
                if (iArr5[i15] > i13) {
                    i13 = iArr5[i15];
                }
                jArr5[i15] = ((long) i5) + j2;
                iArr6[i15] = mVar5 == null ? 1 : 0;
                if (i15 == i17) {
                    iArr6[i15] = 1;
                    int i18 = i16 - 1;
                    if (i18 > 0) {
                        i16 = i18;
                        i17 = mVar5.xk() - 1;
                    } else {
                        i16 = i18;
                    }
                }
                j2 += (long) xk3;
                int i19 = xk2 - 1;
                if (i19 != 0 || xk <= 0) {
                    i7 = i19;
                } else {
                    int xk4 = mVar4.xk();
                    xk--;
                    xk3 = mVar4.xk();
                    i7 = xk4;
                }
                j3 += (long) iArr5[i15];
                i14--;
                i15++;
                i10 = i5;
                i9 = i6;
                xk2 = i7;
            }
            com.google.android.exoplayer2.i.a.checkArgument(i8 == 0);
            while (i9 > 0) {
                com.google.android.exoplayer2.i.a.checkArgument(mVar6.xk() == 0);
                mVar6.readInt();
                i9--;
            }
            if (!(i16 == 0 && xk2 == 0 && i14 == 0 && xk == 0)) {
                new StringBuilder("Inconsistent stbl box for track ").append(jVar.id).append(": remainingSynchronizationSamples ").append(i16).append(", remainingSamplesAtTimestampDelta ").append(xk2).append(", remainingSamplesInChunk ").append(i14).append(", remainingTimestampDeltaChanges ").append(xk);
            }
            iArr2 = iArr6;
            jArr2 = jArr5;
            iArr = iArr5;
            i2 = i13;
            jArr = jArr4;
        } else {
            long[] jArr6 = new long[aVar2.length];
            int[] iArr7 = new int[aVar2.length];
            while (aVar2.uC()) {
                jArr6[aVar2.index] = aVar2.offset;
                iArr7[aVar2.index] = aVar2.bmJ;
            }
            d.a a2 = d.a(eVar.uD(), jArr6, iArr7, (long) xk3);
            jArr = a2.offsets;
            iArr = a2.bhG;
            i2 = a2.bmW;
            jArr2 = a2.bmX;
            iArr2 = a2.bmY;
        }
        if (jVar.bor == null || iVar.uz()) {
            x.a(jArr2, jVar.boo);
            m mVar7 = new m(jArr, iArr, i2, jArr2, iArr2);
            AppMethodBeat.o(92064);
            return mVar7;
        }
        if (jVar.bor.length == 1 && jVar.type == 1 && jArr2.length >= 2) {
            long j4 = jVar.bos[0];
            long b2 = x.b(jVar.bor[0], jVar.boo, jVar.bop) + j4;
            if (jArr2[0] <= j4 && j4 < jArr2[1] && jArr2[jArr2.length - 1] < b2 && b2 <= j2) {
                long b3 = x.b(j4 - jArr2[0], (long) jVar.bdF.sampleRate, jVar.boo);
                long b4 = x.b(j2 - b2, (long) jVar.bdF.sampleRate, jVar.boo);
                if (!(b3 == 0 && b4 == 0) && b3 <= 2147483647L && b4 <= 2147483647L) {
                    iVar.bdA = (int) b3;
                    iVar.bdB = (int) b4;
                    x.a(jArr2, jVar.boo);
                    m mVar8 = new m(jArr, iArr, i2, jArr2, iArr2);
                    AppMethodBeat.o(92064);
                    return mVar8;
                }
            }
        }
        if (jVar.bor.length == 1 && jVar.bor[0] == 0) {
            for (int i20 = 0; i20 < jArr2.length; i20++) {
                jArr2[i20] = x.b(jArr2[i20] - jVar.bos[0], TimeUtil.SECOND_TO_US, jVar.boo);
            }
            m mVar9 = new m(jArr, iArr, i2, jArr2, iArr2);
            AppMethodBeat.o(92064);
            return mVar9;
        }
        boolean z3 = jVar.type == 1;
        int i21 = 0;
        int i22 = 0;
        boolean z4 = false;
        for (int i23 = 0; i23 < jVar.bor.length; i23++) {
            long j5 = jVar.bos[i23];
            if (j5 != -1) {
                long b5 = x.b(jVar.bor[i23], jVar.boo, jVar.bop);
                int a3 = x.a(jArr2, j5, true, true);
                i22 = x.a(jArr2, b5 + j5, z3, false);
                i21 += i22 - a3;
                if (i22 != a3) {
                    z = true;
                } else {
                    z = false;
                }
                z4 |= z;
            } else {
                i21 = i21;
                z4 = z4;
                i22 = i22;
            }
        }
        boolean z5 = z4 | (i21 != sampleCount);
        if (z5) {
            jArr3 = new long[i21];
        } else {
            jArr3 = jArr;
        }
        if (z5) {
            iArr3 = new int[i21];
        } else {
            iArr3 = iArr;
        }
        if (z5) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (z5) {
            iArr4 = new int[i21];
        } else {
            iArr4 = iArr2;
        }
        long[] jArr7 = new long[i21];
        long j6 = 0;
        int i24 = 0;
        for (int i25 = 0; i25 < jVar.bor.length; i25++) {
            long j7 = jVar.bos[i25];
            long j8 = jVar.bor[i25];
            if (j7 != -1) {
                long b6 = j7 + x.b(j8, jVar.boo, jVar.bop);
                int a4 = x.a(jArr2, j7, true, true);
                int a5 = x.a(jArr2, b6, z3, false);
                if (z5) {
                    int i26 = a5 - a4;
                    System.arraycopy(jArr, a4, jArr3, i24, i26);
                    System.arraycopy(iArr, a4, iArr3, i24, i26);
                    System.arraycopy(iArr2, a4, iArr4, i24, i26);
                }
                for (int i27 = a4; i27 < a5; i27++) {
                    jArr7[i24] = x.b(jArr2[i27] - j7, TimeUtil.SECOND_TO_US, jVar.boo) + x.b(j6, TimeUtil.SECOND_TO_US, jVar.bop);
                    if (!z5 || iArr3[i24] <= i3) {
                        i4 = i3;
                    } else {
                        i4 = iArr[i27];
                    }
                    i24++;
                    i3 = i4;
                }
            }
            j6 += j8;
            i24 = i24;
        }
        boolean z6 = false;
        for (int i28 = 0; i28 < iArr4.length && !z6; i28++) {
            z6 |= (iArr4[i28] & 1) != 0;
        }
        if (!z6) {
            x.a(jArr2, jVar.boo);
            m mVar10 = new m(jArr, iArr, i2, jArr2, iArr2);
            AppMethodBeat.o(92064);
            return mVar10;
        }
        m mVar11 = new m(jArr3, iArr3, i3, jArr7, iArr4);
        AppMethodBeat.o(92064);
        return mVar11;
    }

    public static Metadata a(a.b bVar, boolean z) {
        AppMethodBeat.i(92065);
        if (z) {
            AppMethodBeat.o(92065);
            return null;
        }
        m mVar = bVar.bmB;
        mVar.setPosition(8);
        while (mVar.xd() >= 8) {
            int i2 = mVar.position;
            int readInt = mVar.readInt();
            if (mVar.readInt() == a.bmk) {
                mVar.setPosition(i2);
                int i3 = i2 + readInt;
                mVar.eZ(12);
                while (true) {
                    if (mVar.position >= i3) {
                        break;
                    }
                    int i4 = mVar.position;
                    int readInt2 = mVar.readInt();
                    if (mVar.readInt() == a.bml) {
                        mVar.setPosition(i4);
                        int i5 = i4 + readInt2;
                        mVar.eZ(8);
                        ArrayList arrayList = new ArrayList();
                        while (mVar.position < i5) {
                            Metadata.Entry o = f.o(mVar);
                            if (o != null) {
                                arrayList.add(o);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            AppMethodBeat.o(92065);
                            return metadata;
                        }
                    } else {
                        mVar.eZ(readInt2 - 8);
                    }
                }
                AppMethodBeat.o(92065);
                return null;
            }
            mVar.eZ(readInt - 8);
        }
        AppMethodBeat.o(92065);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x022e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.c.d.b.c a(com.google.android.exoplayer2.i.m r28, int r29, int r30, java.lang.String r31, com.google.android.exoplayer2.drm.DrmInitData r32, boolean r33) {
        /*
        // Method dump skipped, instructions count: 1430
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.d.b.a(com.google.android.exoplayer2.i.m, int, int, java.lang.String, com.google.android.exoplayer2.drm.DrmInitData, boolean):com.google.android.exoplayer2.c.d.b$c");
    }

    private static Pair<long[], long[]> b(a.C0101a aVar) {
        a.b ef;
        long readInt;
        AppMethodBeat.i(92067);
        if (aVar == null || (ef = aVar.ef(a.blz)) == null) {
            Pair<long[], long[]> create = Pair.create(null, null);
            AppMethodBeat.o(92067);
            return create;
        }
        m mVar = ef.bmB;
        mVar.setPosition(8);
        int ec = a.ec(mVar.readInt());
        int xk = mVar.xk();
        long[] jArr = new long[xk];
        long[] jArr2 = new long[xk];
        for (int i2 = 0; i2 < xk; i2++) {
            jArr[i2] = ec == 1 ? mVar.xm() : mVar.dE();
            if (ec == 1) {
                readInt = mVar.readLong();
            } else {
                readInt = (long) mVar.readInt();
            }
            jArr2[i2] = readInt;
            byte[] bArr = mVar.data;
            int i3 = mVar.position;
            mVar.position = i3 + 1;
            byte[] bArr2 = mVar.data;
            int i4 = mVar.position;
            mVar.position = i4 + 1;
            if (((short) (((bArr[i3] & 255) << 8) | (bArr2[i4] & 255))) != 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported media rate.");
                AppMethodBeat.o(92067);
                throw illegalArgumentException;
            }
            mVar.eZ(2);
        }
        Pair<long[], long[]> create2 = Pair.create(jArr, jArr2);
        AppMethodBeat.o(92067);
        return create2;
    }

    private static Pair<String, byte[]> c(m mVar, int i2) {
        String str = null;
        AppMethodBeat.i(92068);
        mVar.setPosition(i2 + 8 + 4);
        mVar.eZ(1);
        k(mVar);
        mVar.eZ(2);
        int readUnsignedByte = mVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            mVar.eZ(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            mVar.eZ(mVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            mVar.eZ(2);
        }
        mVar.eZ(1);
        k(mVar);
        switch (mVar.readUnsignedByte()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
                break;
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
            case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                str = "video/mpeg2";
                break;
            case 107:
                Pair<String, byte[]> create = Pair.create("audio/mpeg", null);
                AppMethodBeat.o(92068);
                return create;
            case TbsListener.ErrorCode.STARTDOWNLOAD_6 /*{ENCODED_INT: 165}*/:
                str = "audio/ac3";
                break;
            case 166:
                str = "audio/eac3";
                break;
            case 169:
            case 172:
                Pair<String, byte[]> create2 = Pair.create("audio/vnd.dts", null);
                AppMethodBeat.o(92068);
                return create2;
            case TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE /*{ENCODED_INT: 170}*/:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /*{ENCODED_INT: 171}*/:
                Pair<String, byte[]> create3 = Pair.create("audio/vnd.dts.hd", null);
                AppMethodBeat.o(92068);
                return create3;
        }
        mVar.eZ(12);
        mVar.eZ(1);
        int k = k(mVar);
        byte[] bArr = new byte[k];
        mVar.readBytes(bArr, 0, k);
        Pair<String, byte[]> create4 = Pair.create(str, bArr);
        AppMethodBeat.o(92068);
        return create4;
    }

    private static Pair<Integer, k> b(m mVar, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92070);
        int i4 = i2 + 8;
        Integer num = null;
        String str = null;
        int i5 = 0;
        int i6 = -1;
        while (i4 - i2 < i3) {
            mVar.setPosition(i4);
            int readInt = mVar.readInt();
            int readInt2 = mVar.readInt();
            if (readInt2 == a.blK) {
                num = Integer.valueOf(mVar.readInt());
            } else if (readInt2 == a.blF) {
                mVar.eZ(4);
                str = mVar.readString(4);
            } else if (readInt2 == a.blG) {
                i5 = readInt;
                i6 = i4;
            }
            i4 += readInt;
        }
        if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
            com.google.android.exoplayer2.i.a.checkArgument(num != null, "frma atom is mandatory");
            if (i6 != -1) {
                z = true;
            } else {
                z = false;
            }
            com.google.android.exoplayer2.i.a.checkArgument(z, "schi atom is mandatory");
            k a2 = a(mVar, i6, i5, str);
            if (a2 == null) {
                z2 = false;
            }
            com.google.android.exoplayer2.i.a.checkArgument(z2, "tenc atom is mandatory");
            Pair<Integer, k> create = Pair.create(num, a2);
            AppMethodBeat.o(92070);
            return create;
        }
        AppMethodBeat.o(92070);
        return null;
    }

    private static k a(m mVar, int i2, int i3, String str) {
        int i4;
        int i5;
        byte[] bArr = null;
        boolean z = true;
        AppMethodBeat.i(92071);
        int i6 = i2 + 8;
        while (i6 - i2 < i3) {
            mVar.setPosition(i6);
            int readInt = mVar.readInt();
            if (mVar.readInt() == a.blH) {
                int ec = a.ec(mVar.readInt());
                mVar.eZ(1);
                if (ec == 0) {
                    mVar.eZ(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int readUnsignedByte = mVar.readUnsignedByte();
                    i4 = (readUnsignedByte & 240) >> 4;
                    i5 = readUnsignedByte & 15;
                }
                if (mVar.readUnsignedByte() != 1) {
                    z = false;
                }
                int readUnsignedByte2 = mVar.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                mVar.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = mVar.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    mVar.readBytes(bArr, 0, readUnsignedByte3);
                }
                k kVar = new k(z, str, readUnsignedByte2, bArr2, i4, i5, bArr);
                AppMethodBeat.o(92071);
                return kVar;
            }
            i6 += readInt;
        }
        AppMethodBeat.o(92071);
        return null;
    }

    private static int k(m mVar) {
        AppMethodBeat.i(92072);
        int readUnsignedByte = mVar.readUnsignedByte();
        int i2 = readUnsignedByte & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = mVar.readUnsignedByte();
            i2 = (i2 << 7) | (readUnsignedByte & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        }
        AppMethodBeat.o(92072);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public int bmJ;
        private final boolean bmK;
        private final m bmL;
        private final m bmM;
        private int bmN;
        private int bmO;
        public int index;
        public final int length;
        public long offset;

        public a(m mVar, m mVar2, boolean z) {
            boolean z2 = true;
            AppMethodBeat.i(92056);
            this.bmM = mVar;
            this.bmL = mVar2;
            this.bmK = z;
            mVar2.setPosition(12);
            this.length = mVar2.xk();
            mVar.setPosition(12);
            this.bmO = mVar.xk();
            com.google.android.exoplayer2.i.a.checkState(mVar.readInt() != 1 ? false : z2, "first_chunk must be 1");
            this.index = -1;
            AppMethodBeat.o(92056);
        }

        public final boolean uC() {
            long dE;
            AppMethodBeat.i(92057);
            int i2 = this.index + 1;
            this.index = i2;
            if (i2 == this.length) {
                AppMethodBeat.o(92057);
                return false;
            }
            if (this.bmK) {
                dE = this.bmL.xm();
            } else {
                dE = this.bmL.dE();
            }
            this.offset = dE;
            if (this.index == this.bmN) {
                this.bmJ = this.bmM.xk();
                this.bmM.eZ(4);
                int i3 = this.bmO - 1;
                this.bmO = i3;
                this.bmN = i3 > 0 ? this.bmM.xk() - 1 : -1;
            }
            AppMethodBeat.o(92057);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f {
        final int bdv;
        final long duration;
        final int id;

        public f(int i2, long j2, int i3) {
            this.id = i2;
            this.duration = j2;
            this.bdv = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        public Format bdF;
        public int biD;
        public final k[] bmP;
        public int bmQ = 0;

        public c(int i2) {
            AppMethodBeat.i(92058);
            this.bmP = new k[i2];
            AppMethodBeat.o(92058);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements AbstractC0102b {
        private final m bmB;
        private final int bmR = this.bmB.xk();
        private final int sampleCount = this.bmB.xk();

        public d(a.b bVar) {
            AppMethodBeat.i(92059);
            this.bmB = bVar.bmB;
            this.bmB.setPosition(12);
            AppMethodBeat.o(92059);
        }

        @Override // com.google.android.exoplayer2.c.d.b.AbstractC0102b
        public final int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.c.d.b.AbstractC0102b
        public final int uD() {
            AppMethodBeat.i(92060);
            if (this.bmR == 0) {
                int xk = this.bmB.xk();
                AppMethodBeat.o(92060);
                return xk;
            }
            int i2 = this.bmR;
            AppMethodBeat.o(92060);
            return i2;
        }

        @Override // com.google.android.exoplayer2.c.d.b.AbstractC0102b
        public final boolean uE() {
            return this.bmR != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e implements AbstractC0102b {
        private final m bmB;
        private final int bmS = (this.bmB.xk() & 255);
        private int bmT;
        private int bmU;
        private final int sampleCount = this.bmB.xk();

        public e(a.b bVar) {
            AppMethodBeat.i(92061);
            this.bmB = bVar.bmB;
            this.bmB.setPosition(12);
            AppMethodBeat.o(92061);
        }

        @Override // com.google.android.exoplayer2.c.d.b.AbstractC0102b
        public final int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.c.d.b.AbstractC0102b
        public final int uD() {
            AppMethodBeat.i(92062);
            if (this.bmS == 8) {
                int readUnsignedByte = this.bmB.readUnsignedByte();
                AppMethodBeat.o(92062);
                return readUnsignedByte;
            } else if (this.bmS == 16) {
                int readUnsignedShort = this.bmB.readUnsignedShort();
                AppMethodBeat.o(92062);
                return readUnsignedShort;
            } else {
                int i2 = this.bmT;
                this.bmT = i2 + 1;
                if (i2 % 2 == 0) {
                    this.bmU = this.bmB.readUnsignedByte();
                    int i3 = (this.bmU & 240) >> 4;
                    AppMethodBeat.o(92062);
                    return i3;
                }
                int i4 = this.bmU & 15;
                AppMethodBeat.o(92062);
                return i4;
            }
        }

        @Override // com.google.android.exoplayer2.c.d.b.AbstractC0102b
        public final boolean uE() {
            return false;
        }
    }

    private static Pair<Integer, k> a(m mVar, int i2, int i3) {
        Pair<Integer, k> b2;
        AppMethodBeat.i(92069);
        int i4 = mVar.position;
        while (i4 - i2 < i3) {
            mVar.setPosition(i4);
            int readInt = mVar.readInt();
            com.google.android.exoplayer2.i.a.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (mVar.readInt() != a.blE || (b2 = b(mVar, i4, readInt)) == null) {
                i4 += readInt;
            } else {
                AppMethodBeat.o(92069);
                return b2;
            }
        }
        AppMethodBeat.o(92069);
        return null;
    }
}
