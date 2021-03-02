package com.tencent.mm.audio.mix.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.e;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class d {
    private static long dtY = 0;
    private static long dtZ = 0;
    public boolean aBQ;
    private String appId;
    private long bufferSize = 0;
    public int channels = 2;
    private int count = 0;
    public int dtP = 2;
    private ArrayList<e> dtS = new ArrayList<>();
    public String dtT;
    public boolean dtU;
    public boolean dtV = false;
    private a dtW;
    public String dtX;
    public long duration;
    private int index = 0;
    public int sampleRate = 44100;

    public d(String str) {
        AppMethodBeat.i(136709);
        this.dtT = str;
        AppMethodBeat.o(136709);
    }

    public final synchronized void reset() {
        AppMethodBeat.i(136710);
        int size = this.dtS.size();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            e remove = this.dtS.remove(i2);
            if (remove != null) {
                remove.dtX = null;
                remove.dtQ = null;
            }
        }
        ja(size);
        AppMethodBeat.o(136710);
    }

    public final synchronized void recycle() {
        AppMethodBeat.i(136711);
        int size = this.dtS.size();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            e remove = this.dtS.remove(i2);
            if (remove != null) {
                e.YJ().b(remove);
            }
        }
        ja(size);
        AppMethodBeat.o(136711);
    }

    public final synchronized boolean gA(String str) {
        boolean z;
        AppMethodBeat.i(136712);
        if (this.dtV) {
            b.i("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", this.dtT);
            AppMethodBeat.o(136712);
            z = true;
        } else {
            this.appId = str;
            int size = this.dtS.size();
            if (size > 0) {
                Yu();
            }
            if (this.dtW == null) {
                b.e("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
                this.dtV = false;
                AppMethodBeat.o(136712);
                z = false;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        e eVar = this.dtS.get(i2);
                        if (i2 == 0) {
                            this.dtX = eVar.dtX;
                            this.sampleRate = eVar.sampleRate;
                            this.dtP = eVar.dtP;
                            this.channels = eVar.channels;
                        }
                        if (eVar != null) {
                            if (!(this.dtW != null ? this.dtW.b(eVar.dtQ, (long) (i2 * 3536), eVar.dtQ.length) : false)) {
                                Yv();
                                b.e("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
                                this.dtV = false;
                                AppMethodBeat.o(136712);
                                z = false;
                                break;
                            }
                        }
                        i2++;
                    } else {
                        this.dtV = true;
                        for (int i3 = size - 1; i3 >= 0; i3--) {
                            e remove = this.dtS.remove(i3);
                            if (remove != null) {
                                e.YJ().b(remove);
                            }
                        }
                        b.i("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish");
                        AppMethodBeat.o(136712);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void ja(int i2) {
        AppMethodBeat.i(136713);
        b.i("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", this.dtT, Integer.valueOf(i2), Boolean.valueOf(this.aBQ), Long.valueOf(this.duration), Boolean.valueOf(this.dtU), Long.valueOf(this.bufferSize));
        this.dtS.clear();
        this.aBQ = false;
        this.duration = 0;
        this.dtU = false;
        this.index = 0;
        this.bufferSize = 0;
        Yr();
        AppMethodBeat.o(136713);
    }

    public final e jb(int i2) {
        AppMethodBeat.i(136714);
        if (this.dtV && this.dtW != null) {
            e jc = jc(i2);
            AppMethodBeat.o(136714);
            return jc;
        } else if (this.dtV && this.dtW == null) {
            Yt();
            e jc2 = jc(i2);
            AppMethodBeat.o(136714);
            return jc2;
        } else if (this.dtS == null || this.dtS.size() == 0) {
            AppMethodBeat.o(136714);
            return null;
        } else if (i2 >= this.dtS.size()) {
            AppMethodBeat.o(136714);
            return null;
        } else {
            e eVar = this.dtS.get(i2);
            AppMethodBeat.o(136714);
            return eVar;
        }
    }

    public final void a(e eVar) {
        AppMethodBeat.i(136715);
        this.index++;
        eVar.dua = (long) (this.index * 20);
        if (this.dtS != null) {
            this.dtS.add(eVar);
        }
        AppMethodBeat.o(136715);
    }

    public final int size() {
        AppMethodBeat.i(136716);
        if (this.count <= 0 || !this.aBQ) {
            int size = this.dtS.size();
            AppMethodBeat.o(136716);
            return size;
        }
        int i2 = this.count;
        AppMethodBeat.o(136716);
        return i2;
    }

    public final void complete() {
        AppMethodBeat.i(136717);
        this.aBQ = true;
        this.count = size();
        b.i("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", this.dtT);
        AppMethodBeat.o(136717);
    }

    public final long getBufferSize() {
        AppMethodBeat.i(136718);
        if (this.bufferSize > 0) {
            long j2 = this.bufferSize;
            AppMethodBeat.o(136718);
            return j2;
        }
        this.bufferSize = (long) (size() * 3536);
        long j3 = this.bufferSize;
        AppMethodBeat.o(136718);
        return j3;
    }

    private void Yr() {
        AppMethodBeat.i(136719);
        this.dtV = false;
        Yv();
        AppMethodBeat.o(136719);
    }

    public final synchronized void Ys() {
        AppMethodBeat.i(136720);
        if (this.dtW != null) {
            b.i("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
            this.dtW.close();
            this.dtW = null;
        }
        AppMethodBeat.o(136720);
    }

    private synchronized void Yt() {
        AppMethodBeat.i(136721);
        Yu();
        AppMethodBeat.o(136721);
    }

    private void Yu() {
        AppMethodBeat.i(136722);
        if (this.dtW == null) {
            this.dtW = new a(this.appId, this.dtT);
            if (this.dtW.open()) {
                b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
                this.dtW.setLength(getBufferSize());
                AppMethodBeat.o(136722);
                return;
            }
            b.i("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
            this.dtV = false;
            Yv();
        }
        AppMethodBeat.o(136722);
    }

    private void Yv() {
        AppMethodBeat.i(136723);
        if (this.dtW != null) {
            this.dtW.close();
            this.dtW.Yq();
            this.dtW = null;
        }
        AppMethodBeat.o(136723);
    }

    private int read(byte[] bArr, long j2, int i2) {
        AppMethodBeat.i(136724);
        if (this.dtW != null) {
            int read = this.dtW.read(bArr, j2, i2);
            AppMethodBeat.o(136724);
            return read;
        }
        AppMethodBeat.o(136724);
        return 0;
    }

    private e jc(int i2) {
        AppMethodBeat.i(136725);
        if (i2 >= this.count) {
            AppMethodBeat.o(136725);
            return null;
        } else if (this.dtW == null) {
            AppMethodBeat.o(136725);
            return null;
        } else {
            int i3 = i2 * 3536;
            if (i3 > this.dtW.getLength()) {
                AppMethodBeat.o(136725);
                return null;
            }
            e YI = com.tencent.mm.audio.mix.b.d.YH().YI();
            if (YI == null) {
                AppMethodBeat.o(136725);
                return null;
            }
            if (YI.dtQ == null) {
                YI.dtQ = new byte[3536];
            } else {
                Arrays.fill(YI.dtQ, 0, YI.dtQ.length, (byte) 0);
            }
            System.nanoTime();
            if (read(YI.dtQ, (long) i3, YI.dtQ.length) <= 0) {
                com.tencent.mm.audio.mix.b.d.YH().b(YI);
                AppMethodBeat.o(136725);
                return null;
            }
            YI.dtX = this.dtX;
            YI.sampleRate = this.sampleRate;
            YI.channels = this.channels;
            YI.dtP = this.dtP;
            YI.dua = (long) (i2 * 20);
            AppMethodBeat.o(136725);
            return YI;
        }
    }
}
