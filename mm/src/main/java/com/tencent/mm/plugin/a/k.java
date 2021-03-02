package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class k implements f {
    private long duration;
    private String filePath;
    public int jQB = 0;
    private List<long[]> jQC = new ArrayList();
    private Pair[] jQD;
    private long jQE = -1;
    private o jQF = null;
    private long jQG = -1;
    private o jQH = null;
    protected boolean jQI = false;
    private int jQJ = 0;
    private ArrayList<Pair<Integer, Integer>> jQK = new ArrayList<>();
    private Comparator<Pair<Integer, Integer>> jQL = new Comparator<Pair<Integer, Integer>>() {
        /* class com.tencent.mm.plugin.a.k.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2) {
            AppMethodBeat.i(175939);
            int compareTo = ((Integer) pair.first).compareTo((Integer) pair2.first);
            AppMethodBeat.o(175939);
            return compareTo;
        }
    };
    private long jQs;
    private long[] jQv;
    private int jQw;
    private List<n> jQx;
    private List<Pair> jQy;
    private RandomAccessFile randomAccessFile;

    public k() {
        AppMethodBeat.i(133873);
        blT();
        AppMethodBeat.o(133873);
    }

    public void blT() {
        AppMethodBeat.i(208738);
        if (((b) g.af(b.class)).a(b.a.clicfg_mp4_parse_lazy, 0) == 1) {
            Log.i("MicroMsg.Mp4Parser2", "config to use lazy parse");
            this.jQI = true;
            AppMethodBeat.o(208738);
            return;
        }
        Log.i("MicroMsg.Mp4Parser2", "not use lazy parse");
        this.jQI = false;
        AppMethodBeat.o(208738);
    }

    private void reset() {
        AppMethodBeat.i(133874);
        this.filePath = null;
        this.jQv = null;
        this.jQC.clear();
        this.jQw = 0;
        this.duration = 0;
        this.jQs = 0;
        if (this.jQx != null) {
            this.jQx.clear();
        }
        if (this.jQy != null) {
            this.jQy.clear();
        }
        if (this.jQK != null) {
            this.jQK.clear();
        }
        this.jQD = null;
        this.jQB = 0;
        AppMethodBeat.o(133874);
    }

    @Override // com.tencent.mm.plugin.a.f
    public final int blR() {
        int i2;
        AppMethodBeat.i(133875);
        try {
            if (!this.jQI) {
                if (this.jQy != null) {
                    if (this.jQB == 0) {
                        this.jQB = (int) ((((Long) this.jQy.get(this.jQy.size() - 1).second).longValue() / 1000) / 1000);
                    }
                    i2 = this.jQB;
                } else {
                    i2 = 0;
                }
            } else if (this.jQD == null || this.jQD.length <= 0) {
                i2 = 0;
            } else {
                if (this.jQD[this.jQD.length - 1] == null) {
                    uV(this.jQv.length - 1);
                }
                Pair pair = this.jQD[this.jQD.length - 1];
                if (pair != null && this.jQB == 0) {
                    this.jQB = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                }
                i2 = this.jQB;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Mp4Parser2", e2, "get last key frame error.", new Object[0]);
            i2 = 0;
        }
        AppMethodBeat.o(133875);
        return i2;
    }

    private Pair<Integer, Integer> uU(int i2) {
        Pair<Integer, Integer> pair;
        AppMethodBeat.i(175940);
        if (this.jQK.size() > 0) {
            Pair<Integer, Integer> pair2 = new Pair<>(Integer.valueOf(Math.max(i2 - 1, 1)), Integer.valueOf(Math.min(i2 + 5, this.jQv.length - 1)));
            Iterator<Pair<Integer, Integer>> it = this.jQK.iterator();
            Pair<Integer, Integer> pair3 = pair2;
            while (it.hasNext()) {
                Pair<Integer, Integer> next = it.next();
                if (!((Integer) next.first).equals(pair3.first) || !((Integer) next.second).equals(pair3.second)) {
                    if (((Integer) next.first).intValue() <= ((Integer) pair3.first).intValue() || ((Integer) next.second).intValue() >= ((Integer) pair3.second).intValue()) {
                        if (((Integer) next.first).intValue() >= ((Integer) pair3.first).intValue() || ((Integer) next.second).intValue() <= ((Integer) pair3.second).intValue()) {
                            if (((Integer) next.first).intValue() <= ((Integer) pair3.first).intValue() && ((Integer) pair3.first).intValue() <= ((Integer) next.second).intValue() && ((Integer) next.second).intValue() <= ((Integer) pair3.second).intValue()) {
                                pair3 = new Pair<>(Integer.valueOf(Math.min(((Integer) next.second).intValue() + 1, this.jQv.length - 1)), pair3.second);
                            } else if (((Integer) next.first).intValue() >= ((Integer) pair3.first).intValue() && ((Integer) pair3.second).intValue() >= ((Integer) next.first).intValue() && ((Integer) next.second).intValue() >= ((Integer) pair3.second).intValue()) {
                                pair = new Pair<>(pair3.first, Integer.valueOf(Math.max(((Integer) next.first).intValue() - 1, 1)));
                                pair3 = pair;
                            }
                        }
                    }
                    pair = pair3;
                    pair3 = pair;
                } else {
                    AppMethodBeat.o(175940);
                    return null;
                }
            }
            if (((Integer) pair3.first).intValue() > ((Integer) pair3.second).intValue()) {
                AppMethodBeat.o(175940);
                return null;
            }
            AppMethodBeat.o(175940);
            return pair3;
        }
        Pair<Integer, Integer> pair4 = new Pair<>(1, Integer.valueOf(i2));
        AppMethodBeat.o(175940);
        return pair4;
    }

    private void uV(int i2) {
        AppMethodBeat.i(175941);
        if (this.jQF != null) {
            long currentTicks = Util.currentTicks();
            Log.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable currentLazyParseSeconds:%s, second:%s", Integer.valueOf(this.jQJ), Integer.valueOf(i2));
            Pair<Integer, Integer> uU = uU(i2);
            Log.i("MicroMsg.Mp4Parser2", "calcLazyParseRange cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks)));
            if (uU != null) {
                Log.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable, newParseRange:[%s, %s]", uU.first, uU.second);
                boolean b2 = this.jQF.b(this.randomAccessFile, ((Integer) uU.first).intValue(), ((Integer) uU.second).intValue());
                this.jQv = this.jQF.jQv;
                this.jQx = this.jQF.jQx;
                this.jQy = this.jQF.jQy;
                this.jQD = this.jQF.jQD;
                this.jQK.add(uU);
                long currentTicks2 = Util.currentTicks();
                Collections.sort(this.jQK, this.jQL);
                this.jQJ = ((Integer) this.jQK.get(this.jQK.size() - 1).second).intValue();
                long ticksToNow = Util.ticksToNow(currentTicks);
                Log.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable incrementCreateTimeTable finish, ret:%s, cost:%sms, sort cost:%s, range:[%s, %s]", Boolean.valueOf(b2), Long.valueOf(ticksToNow), Long.valueOf(Util.ticksToNow(currentTicks2)), uU.first, uU.second);
                l lVar = l.jQN;
                l.AS(ticksToNow);
            }
        }
        AppMethodBeat.o(175941);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0171  */
    @Override // com.tencent.mm.plugin.a.f
    @android.annotation.TargetApi(5)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int r13, com.tencent.mm.pointers.PInt r14, com.tencent.mm.pointers.PInt r15) {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.a.k.b(int, com.tencent.mm.pointers.PInt, com.tencent.mm.pointers.PInt):boolean");
    }

    @Override // com.tencent.mm.plugin.a.f
    public final boolean a(int i2, int i3, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(133877);
        Log.i("MicroMsg.Mp4Parser2", "[before] curPlaySecond %d, cacheSecond %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.jQv == null) {
            AppMethodBeat.o(133877);
            return false;
        }
        long currentTicks = Util.currentTicks();
        if (i2 < 0) {
            i2 = 0;
        }
        int length = this.jQv.length;
        if (i2 >= length || i3 >= length) {
            i2 = length - 2;
            i3 = length - 1;
        }
        if (this.jQI) {
            try {
                uV(Math.max(i2, i3));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Mp4Parser2", e2, "videoTimeToFilePos, checkUpdateLazyParseTimeTable error", new Object[0]);
            }
        }
        long j2 = this.jQv[i2];
        long j3 = this.jQv[i3];
        Log.d("MicroMsg.Mp4Parser2", "curPos %d, cachePos %d", Long.valueOf(j2), Long.valueOf(j3));
        if (j2 < 0 || j3 < 0) {
            Log.e("MicroMsg.Mp4Parser2", "videoTimeToFilePos error, not parse this entry now");
        }
        if (i2 == 0) {
            pInt.value = 0;
            pInt2.value = (int) j3;
        } else {
            pInt.value = (int) j2;
            pInt2.value = ((int) j3) - ((int) j2);
        }
        Log.i("MicroMsg.Mp4Parser2", "[after] curPlaySecond %d, cacheSecond %d, offset.value %d, length.value %d, cost %sms", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(133877);
        return true;
    }

    @Override // com.tencent.mm.plugin.a.f
    public final int dG(int i2, int i3) {
        AppMethodBeat.i(175942);
        if (this.jQv == null) {
            AppMethodBeat.o(175942);
            return 0;
        }
        long currentTicks = Util.currentTicks();
        long j2 = (long) (i2 + i3);
        int i4 = 0;
        int length = this.jQv.length;
        if (this.jQI) {
            length = this.jQJ < this.jQv.length ? this.jQJ : this.jQv.length;
            Log.i("MicroMsg.Mp4Parser2", "filePosToVideoTime lazy parse try search from time table, count:%s", Integer.valueOf(length));
            try {
                uV(length);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Mp4Parser2", e2, "", new Object[0]);
            }
        }
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            if (this.jQI && this.jQv[i5] < 0) {
                try {
                    uV(i5);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.Mp4Parser2", e3, "", new Object[0]);
                }
            }
            if (this.jQv[i5] == j2) {
                i4 = i5;
                break;
            }
            if (this.jQv[i5] >= j2) {
                if (this.jQv[i5] > j2) {
                    break;
                }
            } else {
                i4 = i5;
            }
            i5++;
        }
        Log.i("MicroMsg.Mp4Parser2", "filePosToVideoTime, offset:%s, length:%s, filePos:%s, playtime:%s, cost:%sms", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i4), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(175942);
        return i4;
    }

    @Override // com.tencent.mm.plugin.a.f
    public final boolean L(String str, long j2) {
        boolean z = false;
        AppMethodBeat.i(208739);
        reset();
        this.filePath = str;
        if (!new o(this.filePath).exists()) {
            AppMethodBeat.o(208739);
        } else {
            try {
                this.randomAccessFile = s.dB(this.filePath, false);
                z = e(this.randomAccessFile);
                AppMethodBeat.o(208739);
            } catch (Exception e2) {
                AppMethodBeat.o(208739);
            }
        }
        return z;
    }

    private long[] a(RandomAccessFile randomAccessFile2, long j2, byte[] bArr, boolean z) {
        AppMethodBeat.i(133879);
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.Mp4Parser2", "createTimeTable, minfFilePos:%s, isVideo:%s", Long.valueOf(j2), Boolean.valueOf(z));
        randomAccessFile2.seek(j2);
        o oVar = (o) c.a(randomAccessFile2, bArr, a.blp);
        Log.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", oVar, Long.valueOf(this.duration), Long.valueOf(this.jQs));
        if (oVar != null) {
            oVar.duration = this.duration;
            oVar.jQs = this.jQs;
            oVar.f(randomAccessFile2);
            long[] jArr = oVar.jQv;
            if (z) {
                this.jQx = oVar.jQx;
                this.jQy = oVar.jQy;
            }
            if (!(this.jQx == null || this.jQy == null)) {
                Log.d("MicroMsg.Mp4Parser2", "parser stbl atom finish, sampleList:%s, stssList:%s", Integer.valueOf(this.jQx.size()), Integer.valueOf(this.jQy.size()));
            }
            if (jArr != null) {
                Log.i("MicroMsg.Mp4Parser2", "createTimeTable cost:%s, length:%s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(jArr.length));
            }
            AppMethodBeat.o(133879);
            return jArr;
        }
        long[] jArr2 = new long[0];
        AppMethodBeat.o(133879);
        return jArr2;
    }

    private long[] a(RandomAccessFile randomAccessFile2, o oVar) {
        long j2;
        AppMethodBeat.i(175943);
        long currentTicks = Util.currentTicks();
        Log.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", oVar, Long.valueOf(this.duration), Long.valueOf(this.jQs));
        if (oVar != null) {
            oVar.duration = this.duration;
            oVar.jQs = this.jQs;
            long size = oVar.getSize() - 8;
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
                int read = randomAccessFile2.read(bArr);
                int readInt = c.readInt(bArr, 0);
                int readInt2 = c.readInt(bArr, 4);
                Log.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", Integer.valueOf(readInt2), Integer.valueOf(readInt));
                long j3 = 0;
                long currentTicks3 = Util.currentTicks();
                if (readInt2 == a.blV) {
                    oVar.jQQ = randomAccessFile2.getFilePointer();
                    j3 = oVar.a(randomAccessFile2, readInt);
                    Log.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
                    z = true;
                } else if (readInt2 == a.blY) {
                    oVar.jQR = randomAccessFile2.getFilePointer();
                    j3 = oVar.b(randomAccessFile2, readInt);
                    Log.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
                    z3 = true;
                } else if (readInt2 == a.bmb) {
                    oVar.jQS = randomAccessFile2.getFilePointer();
                    j3 = oVar.c(randomAccessFile2, readInt);
                    Log.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
                    z2 = true;
                } else if (readInt2 == a.bmc) {
                    oVar.jQT = randomAccessFile2.getFilePointer();
                    j3 = oVar.d(randomAccessFile2, readInt);
                    Log.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
                    z2 = true;
                } else if (readInt2 == a.blZ) {
                    oVar.jQU = randomAccessFile2.getFilePointer();
                    oVar.jQW = readInt;
                    Log.i("MicroMsg.StblAtom", "stsz atom pos:%s", Long.valueOf(oVar.jQU));
                    z4 = true;
                } else if (readInt2 == a.blW) {
                    oVar.jQV = randomAccessFile2.getFilePointer();
                    j3 = oVar.f(randomAccessFile2, readInt);
                    Log.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks3)));
                    z5 = true;
                }
                if (c.a(randomAccessFile2, (((long) readInt) - j3) - ((long) read))) {
                    if (z && z2 && z3 && z4 && z5) {
                        Log.i("MicroMsg.StblAtom", "read stbl atom finish");
                        break;
                    }
                    size -= (long) readInt;
                } else {
                    IOException iOException = new IOException("skip file error.");
                    AppMethodBeat.o(175943);
                    throw iOException;
                }
            }
            Log.i("MicroMsg.StblAtom", "parse all atoms cost %sms", Long.valueOf(Util.ticksToNow(currentTicks2)));
            oVar.jRe = true;
            if (oVar.jQU > 0) {
                long currentTicks4 = Util.currentTicks();
                randomAccessFile2.seek(oVar.jQU);
                int i2 = oVar.jQW;
                if (!c.a(randomAccessFile2, 4)) {
                    j2 = -1;
                } else {
                    byte[] bArr2 = new byte[4];
                    if (randomAccessFile2.read(bArr2, 0, 4) < 4) {
                        Log.w("MicroMsg.StblAtom", "stsz read sample size error");
                        j2 = -1;
                    } else {
                        int readInt3 = c.readInt(bArr2, 0);
                        if (readInt3 > 0) {
                            oVar.boF = new int[1];
                            oVar.boF[0] = readInt3;
                            Log.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(readInt3)));
                            j2 = 8;
                        } else if (randomAccessFile2.read(bArr2, 0, 4) < 4) {
                            Log.w("MicroMsg.StblAtom", "stsz read entry count error");
                            j2 = -1;
                        } else {
                            int readInt4 = c.readInt(bArr2, 0);
                            long j4 = ((long) readInt4) * 4;
                            if (j4 <= 0 || j4 > ((long) (i2 - 20))) {
                                Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(readInt4)));
                                j2 = -1;
                            } else {
                                oVar.jRd = j4;
                                oVar.boF = new int[(readInt4 + 1)];
                                oVar.jRh = new byte[(oVar.boF.length * 4)];
                                oVar.jRc = randomAccessFile2.getFilePointer();
                                long read2 = (long) randomAccessFile2.read(oVar.jRh);
                                Log.i("MicroMsg.StblAtom", "handleStszAtomLazy start parse stsz filePos:%s, sampleSizeReaded:%s, sampleSizeTableData.length:%s", Long.valueOf(oVar.jRc), Long.valueOf(read2), Integer.valueOf(oVar.jRh.length));
                                oVar.a(randomAccessFile2, 0, 5);
                                j2 = read2 + 12;
                            }
                        }
                    }
                }
                Log.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms, ret:%s, sampleSizeTable.length:%s", Long.valueOf(Util.ticksToNow(currentTicks4)), Long.valueOf(j2), Integer.valueOf(oVar.boF.length));
                if (oVar.jQY == null) {
                    oVar.jQD = new Pair[oVar.jQx.size()];
                } else {
                    oVar.jQD = new Pair[oVar.jQY.length];
                }
                Log.i("MicroMsg.StblAtom", "parse lazy, stssArray.size:%s", Integer.valueOf(oVar.jQD.length));
                long currentTicks5 = Util.currentTicks();
                oVar.b(randomAccessFile2, 0, 5);
                oVar.jRb = 5;
                Log.i("MicroMsg.StblAtom", "createTimeTable cost:%sms, size:%s, lazyDurationSecond:%s", Long.valueOf(Util.ticksToNow(currentTicks5)), Integer.valueOf(oVar.jQv.length), 5);
                if (5 >= oVar.jQv.length) {
                    oVar.jRe = false;
                    Log.i("MicroMsg.StblAtom", "lazyDurationSecond:%s, timeTable.length:%s, not need lazy", 5, Integer.valueOf(oVar.jQv.length));
                }
                Log.i("MicroMsg.StblAtom", "lazy parse finish cost:%sms", Long.valueOf(Util.ticksToNow(currentTicks2)));
            }
            long[] jArr = oVar.jQv;
            this.jQx = oVar.jQx;
            this.jQy = oVar.jQy;
            this.jQD = oVar.jQD;
            if (!(this.jQx == null || this.jQD == null)) {
                Log.d("MicroMsg.Mp4Parser2", "parser stbl atom lazy finish, sampleList.size:%s, stssArray.length:%s", Integer.valueOf(this.jQx.size()), Integer.valueOf(this.jQD.length));
            }
            if (jArr != null) {
                Log.i("MicroMsg.Mp4Parser2", "createTimeTableLazy cost:%s, length:%s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(jArr.length));
            }
            AppMethodBeat.o(175943);
            return jArr;
        }
        long[] jArr2 = new long[0];
        AppMethodBeat.o(175943);
        return jArr2;
    }

    private void blU() {
        AppMethodBeat.i(133880);
        Log.i("MicroMsg.Mp4Parser2", "timeTableLength, length:%s", Integer.valueOf(this.jQw));
        this.jQv = new long[(this.jQw + 2)];
        for (long[] jArr : this.jQC) {
            for (int i2 = 0; i2 < jArr.length; i2++) {
                long[] jArr2 = this.jQv;
                jArr2[i2] = Math.max(jArr2[i2], jArr[i2]);
            }
        }
        AppMethodBeat.o(133880);
    }

    @Override // com.tencent.mm.plugin.a.f
    public final int blS() {
        return this.jQw;
    }

    private boolean e(RandomAccessFile randomAccessFile2) {
        long ticksToNow;
        boolean z;
        AppMethodBeat.i(133881);
        reset();
        l lVar = l.jQN;
        l.ge(this.jQI);
        try {
            byte[] bArr = new byte[8];
            Log.i("MicroMsg.Mp4Parser2", "parserExtractor");
            long currentTicks = Util.currentTicks();
            a a2 = c.a(randomAccessFile2, bArr, a.blk);
            Log.d("MicroMsg.Mp4Parser2", "find moov atom finish, cost:%s, beginPos:%s, size:%s", Long.valueOf(Util.ticksToNow(currentTicks)), Long.valueOf(a2.jPV), Long.valueOf(a2.getSize()));
            boolean z2 = false;
            long size = a2.getSize() - 8;
            long j2 = a2.jPV + 8;
            while (true) {
                if (size <= 0) {
                    break;
                }
                randomAccessFile2.seek(j2);
                randomAccessFile2.read(bArr);
                int readInt = c.readInt(bArr, 0);
                int readInt2 = c.readInt(bArr, 4);
                Log.i("MicroMsg.Mp4Parser2", "read atomSize:%s, atomType:%s", Integer.valueOf(readInt), Integer.valueOf(readInt2));
                if (readInt2 == a.blm) {
                    g b2 = p.b(randomAccessFile2, bArr);
                    Log.i("MicroMsg.Mp4Parser2", "found track atom, mdiaAtom:%s, trakAtom:%s", b2, (p) i.f(readInt, readInt2, j2));
                    if (b2 != null && b2.a(randomAccessFile2, bArr)) {
                        if (b2.jQt != ((long) g.jQp)) {
                            if (b2.jQt == ((long) g.jQq)) {
                                if (this.jQI && z2) {
                                    Log.i("MicroMsg.Mp4Parser2", "lazy parse, ignore sound trak atom");
                                    break;
                                } else if (this.jQw > 30) {
                                    Log.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse sound track", Integer.valueOf(this.jQw));
                                    break;
                                } else {
                                    this.jQs = b2.jQs;
                                    this.duration = b2.duration;
                                    Log.i("MicroMsg.Mp4Parser2", "this trak atom is sound trak. timeScale: " + this.jQs + " duration: " + this.duration);
                                    this.jQG = b2.jQu;
                                    long[] a3 = a(randomAccessFile2, b2.jQu, bArr, false);
                                    Log.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
                                    this.jQC.add(a3);
                                    this.jQw = Math.max(this.jQw, a3.length - 2);
                                    z = z2;
                                    long j3 = size - ((long) readInt);
                                    j2 += (long) readInt;
                                    Log.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", Integer.valueOf(readInt), Integer.valueOf(readInt2), Long.valueOf(j3), Long.valueOf(j2), Integer.valueOf(this.jQw));
                                    size = j3;
                                    z2 = z;
                                }
                            } else {
                                Log.i("MicroMsg.Mp4Parser2", "unknown mdiaAtom");
                                break;
                            }
                        } else {
                            this.jQs = b2.jQs;
                            this.duration = b2.duration;
                            Log.i("MicroMsg.Mp4Parser2", "this trak atom is video trak. timeScale: " + this.jQs + " duration: " + this.duration);
                            this.jQE = b2.jQu;
                            if (this.jQI) {
                                long j4 = this.jQE;
                                long currentTicks2 = Util.currentTicks();
                                Log.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, minfFilePos:%s", Long.valueOf(j4));
                                randomAccessFile2.seek(j4);
                                o oVar = (o) c.a(randomAccessFile2, bArr, a.blp);
                                Log.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, stblAtom:%s, duration:%s, timeScale:%s, cost:%s", oVar, Long.valueOf(this.duration), Long.valueOf(this.jQs), Long.valueOf(Util.ticksToNow(currentTicks2)));
                                this.jQF = oVar;
                                this.jQv = a(randomAccessFile2, this.jQF);
                                this.jQI = this.jQF.jRe;
                                this.jQK.add(new Pair<>(0, 5));
                                this.jQJ = ((Integer) this.jQK.get(this.jQK.size() - 1).second).intValue();
                                this.jQw = this.jQv.length - 2;
                                Log.i("MicroMsg.Mp4Parser2", "lazy parse finish, isLazyParse:%s", Boolean.valueOf(this.jQI));
                            } else {
                                long[] a4 = a(randomAccessFile2, b2.jQu, bArr, true);
                                Log.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
                                this.jQC.add(a4);
                                this.jQw = Math.max(this.jQw, a4.length - 2);
                            }
                            z = true;
                            if (this.jQw > 30) {
                                Log.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse other track", Integer.valueOf(this.jQw));
                                break;
                            } else if (this.jQI) {
                                Log.i("MicroMsg.Mp4Parser2", "lazy parse, ignore other trak atom");
                                break;
                            } else {
                                long j32 = size - ((long) readInt);
                                j2 += (long) readInt;
                                Log.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", Integer.valueOf(readInt), Integer.valueOf(readInt2), Long.valueOf(j32), Long.valueOf(j2), Integer.valueOf(this.jQw));
                                size = j32;
                                z2 = z;
                            }
                        }
                    }
                }
                z = z2;
                long j322 = size - ((long) readInt);
                j2 += (long) readInt;
                Log.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", Integer.valueOf(readInt), Integer.valueOf(readInt2), Long.valueOf(j322), Long.valueOf(j2), Integer.valueOf(this.jQw));
                size = j322;
                z2 = z;
            }
            if (!this.jQI) {
                Log.i("MicroMsg.Mp4Parser2", "parse finish, start merge time table, cost:%s", Long.valueOf(Util.ticksToNow(currentTicks)));
                blU();
                ticksToNow = Util.ticksToNow(currentTicks);
            } else {
                ticksToNow = Util.ticksToNow(currentTicks);
                Log.i("MicroMsg.Mp4Parser2", "lazy parse finish, cost:%s, timeTableLength:%s", Long.valueOf(ticksToNow), Integer.valueOf(this.jQw));
            }
            Log.i("MicroMsg.Mp4Parser2", "parseExtractor finish, totalCost:%sms, isLazyParse:%s", Long.valueOf(ticksToNow), Boolean.valueOf(this.jQI));
            l lVar2 = l.jQN;
            l.a(this.jQI, ticksToNow, this.jQw);
            AppMethodBeat.o(133881);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Mp4Parser2", e2, "parser mp4 error", new Object[0]);
            AppMethodBeat.o(133881);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.a.f
    public final synchronized void release() {
        AppMethodBeat.i(175944);
        if (this.randomAccessFile != null) {
            try {
                Log.printInfoStack("MicroMsg.Mp4Parser2", "release close file", new Object[0]);
                this.randomAccessFile.close();
                this.randomAccessFile = null;
                this.jQJ = 0;
                this.jQK.clear();
                this.jQF = null;
                this.jQH = null;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Mp4Parser2", e2, "", new Object[0]);
            } finally {
                this.randomAccessFile = null;
                AppMethodBeat.o(175944);
            }
        } else {
            AppMethodBeat.o(175944);
        }
    }
}
