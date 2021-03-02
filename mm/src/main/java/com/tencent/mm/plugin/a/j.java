package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public final class j implements f {
    private long duration;
    private String filePath;
    private long gra;
    public int jQB = 0;
    private long jQs;
    private long[] jQv;
    public int jQw;
    private List<n> jQx;
    private List<Pair> jQy;

    private void reset() {
        AppMethodBeat.i(208734);
        this.filePath = null;
        this.jQv = null;
        this.jQw = 0;
        this.duration = 0;
        this.jQs = 0;
        this.gra = 0;
        if (this.jQx != null) {
            this.jQx.clear();
        }
        if (this.jQy != null) {
            this.jQy.clear();
        }
        this.jQB = 0;
        AppMethodBeat.o(208734);
    }

    @Override // com.tencent.mm.plugin.a.f
    public final int blR() {
        int i2;
        AppMethodBeat.i(208735);
        try {
            if (this.jQy != null) {
                if (this.jQB == 0) {
                    this.jQB = (int) ((((Long) this.jQy.get(this.jQy.size() - 1).second).longValue() / 1000) / 1000);
                }
                i2 = this.jQB;
            } else {
                i2 = 0;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Mp4Parser", e2, "get last key frame error.", new Object[0]);
            i2 = 0;
        }
        AppMethodBeat.o(208735);
        return i2;
    }

    @Override // com.tencent.mm.plugin.a.f
    @TargetApi(5)
    public final boolean b(int i2, PInt pInt, PInt pInt2) {
        Exception e2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(208736);
        try {
            if (this.jQy != null) {
                int size = this.jQy.size();
                long j2 = 1000 * ((long) i2) * 1000;
                pInt2.value = 0;
                pInt.value = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z2 = false;
                        break;
                    }
                    Pair pair = this.jQy.get(i3);
                    if (((Long) pair.second).longValue() > j2) {
                        pInt2.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                        z2 = true;
                        break;
                    }
                    pInt.value = (int) ((((Long) pair.second).longValue() / 1000) / 1000);
                    i3++;
                }
                if (!z2) {
                    try {
                        pInt.value = (int) ((((Long) this.jQy.get(size - 1).second).longValue() / 1000) / 1000);
                        pInt2.value = i2;
                        z = true;
                    } catch (Exception e3) {
                        e2 = e3;
                        z = z2;
                        Log.printErrStackTrace("MicroMsg.Mp4Parser", e2, "seekVFrame seekTime[%d]", Integer.valueOf(i2));
                        Log.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i2), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
                        AppMethodBeat.o(208736);
                        return z;
                    }
                } else {
                    z = z2;
                }
                Log.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i2), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
                AppMethodBeat.o(208736);
                return z;
            }
            AppMethodBeat.o(208736);
            return false;
        } catch (Exception e4) {
            e2 = e4;
            z = false;
            Log.printErrStackTrace("MicroMsg.Mp4Parser", e2, "seekVFrame seekTime[%d]", Integer.valueOf(i2));
            Log.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", Integer.valueOf(i2), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
            AppMethodBeat.o(208736);
            return z;
        }
    }

    @Override // com.tencent.mm.plugin.a.f
    public final boolean a(int i2, int i3, PInt pInt, PInt pInt2) {
        if (this.jQv == null) {
            return false;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int length = this.jQv.length;
        if (i2 >= length || i3 >= length) {
            i2 = length - 2;
            i3 = length - 1;
        }
        long j2 = this.jQv[i2];
        long j3 = this.jQv[i3];
        if (i2 == 0) {
            pInt.value = 0;
            pInt2.value = (int) j3;
        } else {
            pInt.value = (int) j2;
            pInt2.value = ((int) j3) - ((int) j2);
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.a.f
    public final int dG(int i2, int i3) {
        int i4;
        int i5 = 0;
        if (this.jQv == null) {
            return 0;
        }
        long j2 = (long) (i2 + i3);
        int i6 = 0;
        while (true) {
            i4 = i5;
            if (i6 >= this.jQv.length) {
                break;
            } else if (this.jQv[i6] == j2) {
                i4 = i6;
                break;
            } else {
                if (this.jQv[i6] >= j2) {
                    if (this.jQv[i6] > j2) {
                        break;
                    }
                    i5 = i4;
                } else {
                    i5 = i6;
                }
                i6++;
            }
        }
        return i4;
    }

    @Override // com.tencent.mm.plugin.a.f
    public final boolean L(String str, long j2) {
        boolean z;
        AppMethodBeat.i(133871);
        reset();
        this.filePath = str;
        this.gra = j2;
        if (!new o(this.filePath).exists()) {
            AppMethodBeat.o(133871);
            return false;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            byte[] bArr = new byte[8];
            RandomAccessFile dB = s.dB(this.filePath, false);
            p a2 = a(dB, bArr, this.gra);
            while (true) {
                if (a2 == null) {
                    break;
                }
                Log.d("MicroMsg.Mp4Parser", "last trak atom file pos : " + a2.jPV);
                g b2 = p.b(dB, bArr);
                if (b2 == null || !b2.a(dB, bArr)) {
                    Log.w("MicroMsg.Mp4Parser", "mdia atom parser fail.");
                    a2 = null;
                } else {
                    if (b2.jQt == ((long) g.jQp)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        long endPos = a2.getEndPos() - dB.getFilePointer();
                        Log.d("MicroMsg.Mp4Parser", "this trak atom is not video trak skip: ".concat(String.valueOf(endPos)));
                        a2 = a(dB, bArr, endPos);
                    } else {
                        this.jQs = b2.jQs;
                        this.duration = b2.duration;
                        Log.d("MicroMsg.Mp4Parser", "this trak atom is video trak. timeScale: " + this.jQs + " duration: " + this.duration);
                        dB.seek(b2.jQu);
                        o oVar = (o) c.a(dB, bArr, a.blp);
                        if (oVar != null) {
                            oVar.duration = this.duration;
                            oVar.jQs = this.jQs;
                            oVar.f(dB);
                            this.jQv = oVar.jQv;
                            this.jQw = this.jQv.length - 2;
                            this.jQx = oVar.jQx;
                            this.jQy = oVar.jQy;
                        }
                    }
                }
            }
            if (dB != null) {
                try {
                    dB.close();
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.Mp4Parser", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(133871);
            return true;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.Mp4Parser", e3, "", new Object[0]);
            Log.e("MicroMsg.Mp4Parser", "parser mp4 error. e: " + e3.toString());
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.Mp4Parser", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(133871);
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.Mp4Parser", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(133871);
            throw th;
        }
    }

    private static p a(RandomAccessFile randomAccessFile, byte[] bArr, long j2) {
        AppMethodBeat.i(133872);
        Log.d("MicroMsg.Mp4Parser", "start to find trak atom.");
        if (!c.a(randomAccessFile, j2)) {
            AppMethodBeat.o(133872);
            return null;
        }
        p pVar = (p) c.a(randomAccessFile, bArr, a.blm);
        AppMethodBeat.o(133872);
        return pVar;
    }

    @Override // com.tencent.mm.plugin.a.f
    public final int blS() {
        return this.jQw;
    }

    @Override // com.tencent.mm.plugin.a.f
    public final void release() {
        AppMethodBeat.i(208737);
        reset();
        AppMethodBeat.o(208737);
    }
}
