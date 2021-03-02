package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.BitSet;

public final class d {
    public BitSet AiI = new BitSet();
    public int count = 0;
    public String dSF = "";
    public long jPY = -1;
    public String mUrl;

    public d(String str) {
        AppMethodBeat.i(137154);
        this.mUrl = str;
        AppMethodBeat.o(137154);
    }

    public final void etI() {
        AppMethodBeat.i(137155);
        if (!TextUtils.isEmpty(this.dSF)) {
            e.t(this.dSF, a.a(this.AiI));
        }
        Log.d("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet:%s", this.AiI.toString());
        Log.i("MicroMsg.Music.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.AiI.cardinality());
        if (etJ()) {
            SE(1);
        }
        AppMethodBeat.o(137155);
    }

    public final void clearCache() {
        AppMethodBeat.i(137156);
        Log.i("MicroMsg.Music.IndexBitMgr", "clearCache");
        this.AiI = new BitSet(this.count);
        SE(0);
        if (!TextUtils.isEmpty(this.dSF)) {
            e.t(this.dSF, null);
        }
        AppMethodBeat.o(137156);
    }

    public final void SE(int i2) {
        AppMethodBeat.i(137157);
        Log.i("MicroMsg.Music.IndexBitMgr", "setFileCacheComplete %d", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(this.dSF)) {
            e.eS(this.dSF, i2);
        }
        AppMethodBeat.o(137157);
    }

    public final int getIndex(int i2) {
        AppMethodBeat.i(137158);
        if (((long) i2) > this.jPY) {
            Log.e("MicroMsg.Music.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", Integer.valueOf(i2), Long.valueOf(this.jPY));
            AppMethodBeat.o(137158);
            return 0;
        }
        int i3 = i2 / 8192;
        AppMethodBeat.o(137158);
        return i3;
    }

    public final boolean SF(int i2) {
        AppMethodBeat.i(137159);
        boolean z = this.AiI.get(i2);
        AppMethodBeat.o(137159);
        return z;
    }

    public final void SG(int i2) {
        AppMethodBeat.i(137160);
        this.AiI.set(i2);
        AppMethodBeat.o(137160);
    }

    public final void SH(int i2) {
        AppMethodBeat.i(137161);
        this.AiI.set(i2, false);
        AppMethodBeat.o(137161);
    }

    public final boolean hp(int i2, int i3) {
        AppMethodBeat.i(137162);
        if (i2 < 0 || i3 < 0 || ((long) i2) > this.jPY || ((long) (i2 + i3)) > this.jPY) {
            Log.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.jPY));
            Log.e("MicroMsg.Music.IndexBitMgr", "canReadFromCache invalid parameter!");
            AppMethodBeat.o(137162);
            return false;
        }
        int index = getIndex(i2);
        int index2 = getIndex(i2 + i3);
        for (int i4 = index; i4 <= index2; i4++) {
            if (!SF(index)) {
                Log.d("MicroMsg.Music.IndexBitMgr", "index %d, indexBit 0", Integer.valueOf(i4));
                AppMethodBeat.o(137162);
                return false;
            }
        }
        AppMethodBeat.o(137162);
        return true;
    }

    private boolean etJ() {
        AppMethodBeat.i(137163);
        Log.i("MicroMsg.Music.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", Integer.valueOf(this.count), Integer.valueOf(this.AiI.cardinality()));
        if (this.count <= 0 || this.count != this.AiI.cardinality()) {
            AppMethodBeat.o(137163);
            return false;
        }
        AppMethodBeat.o(137163);
        return true;
    }

    public static class a {
        public static byte[] a(BitSet bitSet) {
            AppMethodBeat.i(137152);
            byte[] bArr = new byte[(bitSet.size() / 8)];
            for (int i2 = 0; i2 < bitSet.size(); i2++) {
                int i3 = i2 / 8;
                int i4 = 7 - (i2 % 8);
                bArr[i3] = (byte) (((bitSet.get(i2) ? 1 : 0) << i4) | bArr[i3]);
            }
            AppMethodBeat.o(137152);
            return bArr;
        }

        public static BitSet bT(byte[] bArr) {
            AppMethodBeat.i(137153);
            BitSet bitSet = new BitSet(bArr.length * 8);
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                int i4 = 7;
                while (i4 >= 0) {
                    int i5 = i2 + 1;
                    bitSet.set(i2, ((bArr[i3] & (1 << i4)) >> i4) == 1);
                    i4--;
                    i2 = i5;
                }
            }
            AppMethodBeat.o(137153);
            return bitSet;
        }
    }
}
