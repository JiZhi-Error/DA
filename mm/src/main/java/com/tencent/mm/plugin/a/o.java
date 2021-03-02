package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class o extends a {
    int[] boF;
    long duration;
    Pair<Integer, Long>[] jQD;
    long jQQ;
    long jQR;
    long jQS;
    long jQT;
    long jQU;
    long jQV;
    int jQW;
    private int[] jQX;
    int[] jQY;
    private int[] jQZ;
    long jQs;
    long[] jQv;
    List<n> jQx = new ArrayList();
    List<Pair> jQy = new ArrayList();
    private int[] jRa;
    long jRb = 0;
    long jRc = 0;
    long jRd = 0;
    boolean jRe = false;
    private long[] jRf = null;
    private long[] jRg;
    byte[] jRh = null;
    private byte[] jRi = new byte[4];
    private long jRj = 0;
    private long jRk = 0;
    private long jRl = 0;
    private long jRm = 0;
    private int jRn = 0;
    private HashMap<Integer, Long> jRo = new HashMap<>();
    private int[] jRp;

    public o(int i2, long j2, int i3) {
        super(i2, j2, i3, 0);
        AppMethodBeat.i(133883);
        AppMethodBeat.o(133883);
    }

    public final void f(RandomAccessFile randomAccessFile) {
        AppMethodBeat.i(133884);
        long currentTicks = Util.currentTicks();
        long size = getSize() - 8;
        byte[] bArr = new byte[8];
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        long currentTicks2 = Util.currentTicks();
        while (true) {
            if (size <= 0) {
                break;
            }
            int read = randomAccessFile.read(bArr);
            int readInt = c.readInt(bArr, 0);
            int readInt2 = c.readInt(bArr, 4);
            Log.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", Integer.valueOf(readInt2), Integer.valueOf(readInt));
            long j2 = 0;
            if (readInt2 == a.blV) {
                this.jQQ = randomAccessFile.getFilePointer();
                j2 = a(randomAccessFile, readInt);
                Log.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                z = true;
            } else if (readInt2 == a.blY) {
                this.jQR = randomAccessFile.getFilePointer();
                j2 = b(randomAccessFile, readInt);
                Log.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                z3 = true;
            } else if (readInt2 == a.bmb) {
                this.jQS = randomAccessFile.getFilePointer();
                j2 = c(randomAccessFile, readInt);
                Log.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                z2 = true;
            } else if (readInt2 == a.bmc) {
                this.jQT = randomAccessFile.getFilePointer();
                j2 = d(randomAccessFile, readInt);
                Log.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                z2 = true;
            } else if (readInt2 == a.blZ) {
                this.jQU = randomAccessFile.getFilePointer();
                Log.i("MicroMsg.StblAtom", "stsz atom pos:%s", Long.valueOf(this.jQU));
                j2 = e(randomAccessFile, readInt);
                Log.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                z4 = true;
            } else if (readInt2 == a.blW) {
                this.jQV = randomAccessFile.getFilePointer();
                j2 = f(randomAccessFile, readInt);
                Log.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                z5 = true;
            }
            if (c.a(randomAccessFile, (((long) readInt) - j2) - ((long) read))) {
                if (z && z2 && z3 && z4 && z5) {
                    Log.i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                size -= (long) readInt;
            } else {
                IOException iOException = new IOException("skip file error.");
                AppMethodBeat.o(133884);
                throw iOException;
            }
        }
        Log.i("MicroMsg.StblAtom", "parse all atoms cost %sms", Long.valueOf(Util.ticksToNow(currentTicks2)));
        long currentTicks3 = Util.currentTicks();
        blV();
        Log.i("MicroMsg.StblAtom", "createTimeTable cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
        Log.i("MicroMsg.StblAtom", "parse stbl atom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(133884);
    }

    /* access modifiers changed from: package-private */
    public final long a(RandomAccessFile randomAccessFile, int i2) {
        AppMethodBeat.i(133885);
        if (!c.a(randomAccessFile, 4)) {
            AppMethodBeat.o(133885);
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "stts read entry count error");
            AppMethodBeat.o(133885);
            return -1;
        }
        int readInt = c.readInt(bArr, 0);
        long j2 = ((long) readInt) * 8;
        if (j2 > ((long) (i2 - 16)) || j2 <= 0) {
            Log.w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(133885);
            return -1;
        }
        int i3 = 0;
        int i4 = 0;
        this.jQv = new long[(((int) (this.duration / this.jQs)) + 2)];
        Arrays.fill(this.jQv, -1L);
        int i5 = 1;
        this.jQv[0] = 1;
        long j3 = 0;
        int read = randomAccessFile.read(bArr);
        while (true) {
            if (read < 8) {
                break;
            }
            long j4 = ((long) read) + j3;
            int readInt2 = c.readInt(bArr, 0);
            int readInt3 = c.readInt(bArr, 4);
            this.jRf = new long[readInt2];
            Arrays.fill(this.jRf, 0L);
            int i6 = 0;
            int i7 = i4;
            while (i6 < readInt2) {
                n nVar = new n();
                nVar.igk = (long) readInt3;
                int i8 = i6 == 0 ? 0 : i6 - 1;
                long[] jArr = this.jRf;
                jArr[i6] = jArr[i8] + nVar.igk;
                this.jQx.add(nVar);
                int i9 = i3 + readInt3;
                i7++;
                int i10 = i5;
                while (((long) i9) >= this.jQs && i10 < this.jQv.length) {
                    this.jQv[i10] = (long) i7;
                    i10++;
                    i9 = (int) (((long) i9) - this.jQs);
                }
                i6++;
                i5 = i10;
                i3 = i9;
            }
            if (j4 >= j2) {
                Log.d("MicroMsg.StblAtom", "read stts Atom end");
                j3 = j4;
                i4 = i7;
                break;
            }
            read = randomAccessFile.read(bArr);
            j3 = j4;
            i4 = i7;
        }
        if (i5 < this.jQv.length) {
            this.jQv[i5] = (long) i4;
        }
        long j5 = 8 + j3;
        AppMethodBeat.o(133885);
        return j5;
    }

    /* access modifiers changed from: package-private */
    public final long b(RandomAccessFile randomAccessFile, int i2) {
        AppMethodBeat.i(133886);
        if (!c.a(randomAccessFile, 4)) {
            AppMethodBeat.o(133886);
            return -1;
        }
        byte[] bArr = new byte[12];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "stsc read entry count error");
            AppMethodBeat.o(133886);
            return -1;
        }
        int readInt = c.readInt(bArr, 0);
        long j2 = ((long) readInt) * 12;
        if (j2 > ((long) (i2 - 16)) || j2 <= 0) {
            Log.w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(133886);
            return -1;
        }
        Log.d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(readInt)));
        this.jQZ = new int[readInt];
        this.jRa = new int[readInt];
        long j3 = 0;
        int read = randomAccessFile.read(bArr);
        int i3 = 0;
        while (true) {
            if (read < 12) {
                break;
            }
            j3 += (long) read;
            this.jQZ[i3] = c.readInt(bArr, 0);
            this.jRa[i3] = c.readInt(bArr, 4);
            i3++;
            if (j3 >= j2) {
                Log.d("MicroMsg.StblAtom", "read stsc atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
        }
        long j4 = j3 + 8;
        AppMethodBeat.o(133886);
        return j4;
    }

    /* access modifiers changed from: package-private */
    public final long c(RandomAccessFile randomAccessFile, int i2) {
        AppMethodBeat.i(133887);
        if (!c.a(randomAccessFile, 4)) {
            AppMethodBeat.o(133887);
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "stco read entry count error");
            AppMethodBeat.o(133887);
            return -1;
        }
        int readInt = c.readInt(bArr, 0);
        long j2 = 4 * ((long) readInt);
        if (j2 <= 0 || j2 > ((long) (i2 - 16))) {
            Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(133887);
            return -1;
        }
        this.jQX = new int[(readInt + 1)];
        int i3 = 1;
        long j3 = 0;
        int read = randomAccessFile.read(bArr);
        while (true) {
            if (read < 4) {
                break;
            }
            j3 += (long) read;
            int i4 = i3 + 1;
            this.jQX[i3] = c.readInt(bArr, 0);
            if (j3 >= j2) {
                Log.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i3 = i4;
        }
        long j4 = j3 + 8;
        AppMethodBeat.o(133887);
        return j4;
    }

    /* access modifiers changed from: package-private */
    public final long d(RandomAccessFile randomAccessFile, int i2) {
        AppMethodBeat.i(133888);
        if (!c.a(randomAccessFile, 4)) {
            AppMethodBeat.o(133888);
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "co64 read entry count error");
            AppMethodBeat.o(133888);
            return -1;
        }
        int readInt = c.readInt(bArr, 0);
        long j2 = ((long) readInt) * 8;
        if (j2 <= 0 || j2 > ((long) (i2 - 16))) {
            Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(133888);
            return -1;
        }
        this.jRg = new long[(readInt + 1)];
        int i3 = 1;
        int read = randomAccessFile.read(bArr);
        long j3 = 0;
        while (true) {
            if (read < 8) {
                break;
            }
            j3 += (long) read;
            int i4 = i3 + 1;
            this.jRg[i3] = c.aE(bArr);
            if (j3 >= j2) {
                Log.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i3 = i4;
        }
        long j4 = j3 + 8;
        AppMethodBeat.o(133888);
        return j4;
    }

    private long e(RandomAccessFile randomAccessFile, int i2) {
        int i3 = 1;
        AppMethodBeat.i(133889);
        if (!c.a(randomAccessFile, 4)) {
            AppMethodBeat.o(133889);
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "stsz read sample size error");
            AppMethodBeat.o(133889);
            return -1;
        }
        int readInt = c.readInt(bArr, 0);
        if (readInt > 0) {
            this.boF = new int[1];
            this.boF[0] = readInt;
            Log.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(133889);
            return 8;
        } else if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "stsz read entry count error");
            AppMethodBeat.o(133889);
            return -1;
        } else {
            int readInt2 = c.readInt(bArr, 0);
            long j2 = ((long) readInt2) * 4;
            if (j2 <= 0 || j2 > ((long) (i2 - 20))) {
                Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(readInt2)));
                AppMethodBeat.o(133889);
                return -1;
            }
            this.boF = new int[(readInt2 + 1)];
            int read = randomAccessFile.read(bArr);
            long j3 = 0;
            while (true) {
                if (read < 4) {
                    break;
                }
                j3 += (long) read;
                int i4 = i3 + 1;
                this.boF[i3] = c.readInt(bArr, 0);
                if (j3 >= j2) {
                    Log.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                read = randomAccessFile.read(bArr);
                i3 = i4;
            }
            long j4 = j3 + 12;
            AppMethodBeat.o(133889);
            return j4;
        }
    }

    /* access modifiers changed from: package-private */
    public final long a(RandomAccessFile randomAccessFile, int i2, int i3) {
        AppMethodBeat.i(175945);
        Pair<Integer, Integer> uW = uW(i2);
        Pair<Integer, Integer> uW2 = uW(i3);
        if (uW == null || uW2 == null) {
            AppMethodBeat.o(175945);
            return 0;
        }
        int intValue = (this.jRb == 0 ? (Integer) uW.first : (Integer) uW.second).intValue();
        int intValue2 = ((Integer) uW2.second).intValue();
        Log.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(this.boF.length), uW, uW2, Long.valueOf(this.jRc));
        if (intValue > intValue2) {
            AppMethodBeat.o(175945);
            return -1;
        } else if (intValue > this.boF.length || intValue2 > this.boF.length) {
            AppMethodBeat.o(175945);
            return -1;
        } else if (this.jRc < 0) {
            AppMethodBeat.o(175945);
            return -1;
        } else if (this.jRh == null) {
            AppMethodBeat.o(175945);
            return -1;
        } else {
            int i4 = (intValue - 1) * 4;
            while (true) {
                if (i4 >= this.jRh.length || intValue > intValue2) {
                    break;
                }
                this.boF[intValue] = c.readInt(this.jRh, i4);
                intValue++;
                if (0 >= this.jRd) {
                    Log.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                i4 += 4;
            }
            Log.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", Long.valueOf(randomAccessFile.getFilePointer()), Integer.valueOf(i4), Integer.valueOf(this.jRh.length));
            AppMethodBeat.o(175945);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final long f(RandomAccessFile randomAccessFile, int i2) {
        AppMethodBeat.i(133890);
        if (!c.a(randomAccessFile, 4)) {
            AppMethodBeat.o(133890);
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            Log.w("MicroMsg.StblAtom", "stss rread entry count error");
            AppMethodBeat.o(133890);
            return -1;
        }
        int readInt = c.readInt(bArr, 0);
        long j2 = 4 * ((long) readInt);
        if (j2 <= 0 || j2 > ((long) (i2 - 16))) {
            Log.w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(readInt)));
            AppMethodBeat.o(133890);
            return -1;
        }
        this.jQY = new int[readInt];
        int i3 = 0;
        int read = randomAccessFile.read(bArr);
        long j3 = 0;
        while (true) {
            if (read < 4) {
                break;
            }
            j3 += (long) read;
            int i4 = i3 + 1;
            this.jQY[i3] = c.readInt(bArr, 0);
            if (j3 >= j2) {
                Log.d("MicroMsg.StblAtom", "read stss atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i3 = i4;
        }
        Log.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", Integer.valueOf(this.jQY.length));
        long j4 = j3 + 8;
        AppMethodBeat.o(133890);
        return j4;
    }

    private Pair<Integer, Integer> uW(int i2) {
        int i3 = 0;
        AppMethodBeat.i(175946);
        if (this.jRp == null) {
            long currentTicks = Util.currentTicks();
            blW();
            Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        if (i2 < this.jQv.length) {
            int i4 = (int) this.jQv[i2];
            if (i4 < 0) {
                Log.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", Integer.valueOf(i2));
                AppMethodBeat.o(175946);
                return null;
            }
            int uX = uX(i4);
            if (uX > 0) {
                i3 = uX - 1;
            }
            Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(this.jRp[i3] + 1), Integer.valueOf(i4));
            AppMethodBeat.o(175946);
            return pair;
        }
        AppMethodBeat.o(175946);
        return null;
    }

    private boolean blV() {
        AppMethodBeat.i(133891);
        long currentTicks = Util.currentTicks();
        blW();
        Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        for (int i2 = 0; i2 < this.jQv.length; i2++) {
            int i3 = (int) this.jQv[i2];
            int uX = uX(i3);
            int i4 = this.jRp[uX - 1] + 1;
            Log.d("MicroMsg.StblAtom", "sampleId : " + i3 + " chunkId : " + uX + ", sampleBeginId: " + i4);
            this.jQv[i2] = uY(uX) + dH(i4, i3);
        }
        this.jRm = this.jQv[this.jQv.length - 1];
        long currentTicks2 = Util.currentTicks();
        int i5 = 1;
        int i6 = 0;
        long j2 = 0;
        long j3 = 0;
        for (n nVar : this.jQx) {
            nVar.size = this.boF[i5];
            int uX2 = uX(i5);
            if (uX2 != i6) {
                nVar.start = uY(uX2);
            } else {
                nVar.start = j3;
            }
            j3 = nVar.start + ((long) nVar.size);
            j2 += nVar.igk;
            nVar.igk = (long) (((((float) j2) * 1.0f) / ((float) this.jQs)) * 1000.0f * 1000.0f);
            nVar.id = i5;
            i6 = uX2;
            i5++;
        }
        Log.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(this.jQx.size()));
        long currentTicks3 = Util.currentTicks();
        if (this.jQY == null) {
            for (int i7 = 0; i7 < this.jQx.size(); i7++) {
                n nVar2 = this.jQx.get(i7);
                nVar2.jQP = 1;
                Pair pair = new Pair(Integer.valueOf(i7), Long.valueOf(nVar2.igk));
                Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", pair.first, pair.second, Integer.valueOf(this.jQy.size()));
                this.jQy.add(pair);
            }
        } else {
            for (int i8 = 0; i8 < this.jQY.length; i8++) {
                n nVar3 = this.jQx.get(this.jQY[i8] - 1);
                nVar3.jQP = 1;
                Pair pair2 = new Pair(Integer.valueOf(this.jQY[i8] - 1), Long.valueOf(nVar3.igk));
                Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", pair2.first, pair2.second, Integer.valueOf(this.jQy.size()));
                this.jQy.add(pair2);
            }
        }
        Log.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", Long.valueOf(Util.ticksToNow(currentTicks3)), Integer.valueOf(this.jQy.size()));
        AppMethodBeat.o(133891);
        return true;
    }

    public final boolean b(RandomAccessFile randomAccessFile, int i2, int i3) {
        Integer num;
        int i4;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(175947);
        if (i3 < i2) {
            AppMethodBeat.o(175947);
            return false;
        }
        Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.jQv.length));
        long currentTicks = Util.currentTicks();
        if (this.jRp == null) {
            blW();
            Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        }
        if (i2 > 0) {
            long currentTicks2 = Util.currentTicks();
            long a2 = a(randomAccessFile, i2, i3);
            Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, incrementParseStsz ret:%s, cost:%sms", Long.valueOf(a2), Long.valueOf(Util.ticksToNow(currentTicks2)));
            if (a2 < 0) {
                AppMethodBeat.o(175947);
                return false;
            }
        }
        long currentTicks3 = Util.currentTicks();
        int min = Math.min(i2, this.jQv.length - 1);
        int min2 = Math.min(i3, this.jQv.length - 1);
        Pair<Integer, Integer> uW = uW(i2);
        Pair<Integer, Integer> uW2 = uW(i3);
        Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", Integer.valueOf(min), Integer.valueOf(min2), uW, uW2, Long.valueOf(Util.ticksToNow(currentTicks3)), Integer.valueOf(this.jRp.length));
        long currentTicks4 = Util.currentTicks();
        for (int i8 = min; i8 <= min2; i8++) {
            int i9 = (int) this.jQv[i8];
            long currentTicks5 = Util.currentTicks();
            int uX = uX(i9);
            long ticksToNow = Util.ticksToNow(currentTicks5);
            int i10 = this.jRp[uX > 0 ? uX - 1 : 0] + 1;
            long currentTicks6 = Util.currentTicks();
            long dH = dH(i10, i9);
            long ticksToNow2 = Util.ticksToNow(currentTicks6);
            long uY = uY(uX);
            this.jQv[i8] = uY + dH;
            Log.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(uX), Long.valueOf(dH), Long.valueOf(uY), Long.valueOf(ticksToNow), Long.valueOf(ticksToNow2));
        }
        Log.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks4)));
        this.jRm = this.jQv[min2 - 1];
        if (!(uW == null || uW2 == null)) {
            if (this.jRb == 0) {
                num = (Integer) uW.first;
            } else {
                num = (Integer) uW.second;
            }
            int intValue = num.intValue();
            int intValue2 = ((Integer) uW2.second).intValue();
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            long currentTicks7 = Util.currentTicks();
            for (int i15 = 0; i15 < this.jQY.length; i15++) {
                if (i11 < 0 && this.jQY[i15] - 1 >= intValue - 1) {
                    i13 = this.jQY[i15] - 1;
                    i11 = i15;
                }
                if (i12 < 0 && this.jQY[i15] - 1 >= intValue2 - 1) {
                    i14 = this.jQY[i15] - 1;
                    i12 = i15;
                }
                if (i11 >= 0 && i12 >= 0) {
                    break;
                }
            }
            if (i11 < 0) {
                Log.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", Integer.valueOf(this.jQY.length - 1));
                i5 = this.jQY.length - 1;
                i4 = this.jQY[i5] - 1;
            } else {
                i4 = i13;
                i5 = i11;
            }
            if (i12 < 0) {
                Log.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", Integer.valueOf(this.jQY.length - 1));
                int length = this.jQY.length - 1;
                i14 = this.jQY[length] - 1;
                i6 = length;
            } else {
                i6 = i12;
            }
            if (i14 > intValue2) {
                i7 = i14;
            } else {
                i7 = intValue2;
            }
            int size = i7 >= this.jQx.size() ? this.jQx.size() - 1 : i7;
            Log.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", Integer.valueOf(intValue), Integer.valueOf(size), Integer.valueOf(this.jQx.size()), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Integer.valueOf(i14), Integer.valueOf(this.jRn), Integer.valueOf(this.jQY.length), Long.valueOf(Util.ticksToNow(currentTicks7)));
            if (size > intValue && size < this.jQx.size() && this.jRf != null && size < this.jRf.length) {
                long currentTicks8 = Util.currentTicks();
                for (int i16 = intValue; i16 <= size; i16++) {
                    n nVar = this.jQx.get(i16);
                    int i17 = i16 + 1;
                    nVar.size = this.boF[i17];
                    nVar.igk = (long) (((((float) this.jRf[i16]) * 1.0f) / ((float) this.jQs)) * 1000.0f * 1000.0f);
                    nVar.id = i17;
                }
                Log.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", Long.valueOf(Util.ticksToNow(currentTicks8)), Integer.valueOf(intValue), Integer.valueOf(this.jRn), Integer.valueOf(size));
                this.jRn = size;
                long currentTicks9 = Util.currentTicks();
                if (this.jQY == null) {
                    for (int i18 = intValue; i18 <= size; i18++) {
                        if (this.jQD[i18] == null) {
                            n nVar2 = this.jQx.get(i18);
                            nVar2.jQP = 1;
                            Pair<Integer, Long> pair = new Pair<>(Integer.valueOf(i18), Long.valueOf(nVar2.igk));
                            Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", pair.first, pair.second, Integer.valueOf(this.jQy.size()));
                            this.jQD[i18] = pair;
                        }
                    }
                } else {
                    Log.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", Integer.valueOf(i5), Integer.valueOf(i6));
                    if (i6 >= i5) {
                        for (int i19 = i5; i19 <= i6; i19++) {
                            if (this.jQD[i19] == null) {
                                n nVar3 = this.jQx.get(this.jQY[i19] - 1);
                                nVar3.jQP = 1;
                                Pair<Integer, Long> pair2 = new Pair<>(Integer.valueOf(this.jQY[i19] - 1), Long.valueOf(nVar3.igk));
                                Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", pair2.first, pair2.second, Integer.valueOf(this.jQy.size()));
                                this.jQD[i19] = pair2;
                            }
                        }
                    }
                }
                Log.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", Long.valueOf(Util.ticksToNow(currentTicks9)), Integer.valueOf(this.jQy.size()));
            }
        }
        Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(175947);
        return true;
    }

    private void blW() {
        AppMethodBeat.i(175948);
        int length = (this.jQX != null ? this.jQX.length : this.jRg.length) - 1;
        int length2 = this.jQZ.length;
        for (int i2 = 1; i2 < length2; i2++) {
            this.jQZ[i2 - 1] = this.jQZ[i2] - this.jQZ[i2 - 1];
        }
        this.jQZ[length2 - 1] = (length - this.jQZ[length2 - 1]) + 1;
        this.jRp = new int[(length + 1)];
        this.jRp[0] = 0;
        int i3 = 1;
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = this.jQZ[i4];
            int i6 = this.jRa[i4];
            for (int i7 = 0; i7 < i5; i7++) {
                int[] iArr = this.jRp;
                iArr[i3] = iArr[i3 - 1] + i6;
                i3++;
            }
        }
        Log.i("MicroMsg.StblAtom", "create chunkTable size:%s", Integer.valueOf(this.jRp.length));
        AppMethodBeat.o(175948);
    }

    private int uX(int i2) {
        for (int i3 = 0; i3 < this.jRp.length; i3++) {
            if (i2 <= this.jRp[i3]) {
                return i3;
            }
        }
        return 0;
    }

    private long uY(int i2) {
        if (this.jQX != null) {
            return (long) this.jQX[i2];
        }
        if (this.jRg != null) {
            return this.jRg[i2];
        }
        return 0;
    }

    private long dH(int i2, int i3) {
        if (this.boF.length == 1) {
            return ((long) this.boF[0]) * ((long) (i3 - i2));
        }
        long j2 = 0;
        while (i2 <= i3) {
            j2 += (long) this.boF[i2];
            i2++;
        }
        return j2;
    }
}
