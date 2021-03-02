package com.tencent.mm.audio.mix.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.c.h;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class e {
    public static int dwK = 18432;
    private int dwC;
    private int dwD;
    private int dwE;
    private int dwF = 0;
    private ArrayList<String> dwG = new ArrayList<>();
    private HashMap<String, h> dwH = new HashMap<>();
    private HashMap<String, byte[]> dwI = new HashMap<>();
    private HashMap<String, Integer> dwJ = new HashMap<>();
    private i dwc = new d();

    public e() {
        AppMethodBeat.i(136866);
        this.dwc.init();
        AppMethodBeat.o(136866);
    }

    public final void r(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136867);
        b.i("MicroMsg.Mix.AudioSyncMixController", "init, outSample:%d, outChannel:%d, outBitDepth:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.dwC = i2;
        this.dwD = i3;
        this.dwE = i4;
        this.dwF = i5;
        if (this.dwF <= 0) {
            this.dwF = ((((2 == i4 ? 16 : 8) * (i2 * i3)) * 20) / 8) / 1000;
        }
        AppMethodBeat.o(136867);
    }

    public final byte[] Q(List<com.tencent.mm.audio.mix.a.e> list) {
        h gVar;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        int i3;
        int i4;
        AppMethodBeat.i(136868);
        if (list.isEmpty()) {
            AppMethodBeat.o(136868);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = list.size() > 1;
        for (com.tencent.mm.audio.mix.a.e eVar : list) {
            if (eVar == null || eVar.dtQ == null || TextUtils.isEmpty(eVar.dtX)) {
                b.i("MicroMsg.Mix.AudioSyncMixController", "track or pcmData is null, or audioId is empty");
            } else {
                if (this.dwH.containsKey(eVar.dtX)) {
                    gVar = this.dwH.get(eVar.dtX);
                } else {
                    gVar = new g(eVar.dtX, eVar.sampleRate, eVar.channels, eVar.dtP, this.dwC, this.dwD, this.dwE);
                    this.dwH.put(eVar.dtX, gVar);
                }
                com.tencent.mm.audio.mix.a.e eVar2 = new com.tencent.mm.audio.mix.a.e();
                eVar2.dtQ = gVar.X(eVar.dtQ);
                eVar2.dtX = eVar.dtX;
                eVar2.dua = eVar.dua;
                eVar2.channels = eVar.channels;
                eVar2.sampleRate = eVar.sampleRate;
                eVar2.dtP = eVar.dtP;
                if (!(!z || (bArr = eVar2.dtQ) == null || bArr.length == 0)) {
                    byte[] bArr3 = null;
                    if (this.dwI.containsKey(eVar2.dtX)) {
                        i2 = this.dwJ.get(eVar2.dtX).intValue();
                        bArr3 = this.dwI.get(eVar2.dtX);
                    } else {
                        i2 = 0;
                    }
                    if (i2 > 0 && bArr3 != null) {
                        if (bArr.length <= dwK - i2) {
                            System.arraycopy(bArr, 0, bArr3, i2, bArr.length);
                            i3 = bArr.length + i2;
                        } else {
                            System.arraycopy(bArr, 0, bArr3, i2, dwK - i2);
                            i3 = (dwK - i2) + i2;
                        }
                        if (i3 > this.dwF) {
                            i4 = i3 - this.dwF;
                            byte[] bArr4 = new byte[this.dwF];
                            System.arraycopy(bArr3, 0, bArr4, 0, this.dwF);
                            eVar2.dtQ = bArr4;
                            byte[] bArr5 = new byte[i4];
                            System.arraycopy(bArr3, this.dwF, bArr5, 0, i4);
                            Arrays.fill(bArr3, 0, dwK, (byte) 0);
                            System.arraycopy(bArr5, 0, bArr3, 0, i4);
                        } else {
                            byte[] bArr6 = new byte[this.dwF];
                            System.arraycopy(bArr3, 0, bArr6, 0, i3);
                            eVar2.dtQ = bArr6;
                            i4 = 0;
                            Arrays.fill(bArr3, 0, dwK, (byte) 0);
                        }
                        this.dwJ.put(eVar2.dtX, Integer.valueOf(i4));
                        this.dwI.put(eVar2.dtX, bArr3);
                    } else if (bArr.length < this.dwF) {
                        byte[] bArr7 = new byte[this.dwF];
                        Arrays.fill(bArr7, 0, this.dwF, (byte) 0);
                        System.arraycopy(bArr, 0, bArr7, 0, bArr.length);
                        eVar2.dtQ = bArr7;
                    } else if (bArr.length > this.dwF) {
                        byte[] bArr8 = new byte[this.dwF];
                        Arrays.fill(bArr8, 0, this.dwF, (byte) 0);
                        System.arraycopy(bArr, 0, bArr8, 0, this.dwF);
                        eVar2.dtQ = bArr8;
                        if (bArr3 == null) {
                            int length = bArr.length > dwK ? bArr.length : dwK;
                            dwK = length;
                            bArr2 = new byte[length];
                        } else {
                            bArr2 = bArr3;
                        }
                        Arrays.fill(bArr2, 0, dwK, (byte) 0);
                        System.arraycopy(bArr, this.dwF, bArr2, 0, bArr.length - this.dwF);
                        this.dwJ.put(eVar2.dtX, Integer.valueOf(bArr.length - this.dwF));
                        this.dwI.put(eVar2.dtX, bArr2);
                    }
                }
                if (eVar2.dtQ.equals(eVar.dtQ)) {
                    byte[] bArr9 = new byte[eVar2.dtQ.length];
                    System.arraycopy(eVar2.dtQ, 0, bArr9, 0, eVar2.dtQ.length);
                    eVar2.dtQ = bArr9;
                }
                eVar = eVar2;
            }
            arrayList.add(eVar);
        }
        byte[] R = R(arrayList);
        AppMethodBeat.o(136868);
        return R;
    }

    public final void release() {
        h remove;
        AppMethodBeat.i(136870);
        b.i("MicroMsg.Mix.AudioSyncMixController", "release, ids size:%d", Integer.valueOf(this.dwG.size()));
        Iterator<String> it = this.dwG.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.dwH.containsKey(next) && (remove = this.dwH.remove(next)) != null) {
                remove.release();
            }
            this.dwI.remove(next);
            this.dwJ.remove(next);
        }
        this.dwH.clear();
        this.dwI.clear();
        this.dwJ.clear();
        this.dwG.clear();
        if (this.dwc != null) {
            this.dwc = null;
        }
        AppMethodBeat.o(136870);
    }

    private byte[] R(List<com.tencent.mm.audio.mix.a.e> list) {
        AppMethodBeat.i(136871);
        if (list.isEmpty()) {
            b.i("MicroMsg.Mix.AudioSyncMixController", "list is invalid");
            AppMethodBeat.o(136871);
            return null;
        } else if (list.size() == 1) {
            byte[] bArr = list.get(0).dtQ;
            AppMethodBeat.o(136871);
            return bArr;
        } else if (this.dwc == null) {
            b.i("MicroMsg.Mix.AudioSyncMixController", "mixer is null");
            AppMethodBeat.o(136871);
            return null;
        } else {
            com.tencent.mm.audio.mix.a.b P = this.dwc.P(list);
            if (P != null) {
                byte[] bArr2 = P.dtQ;
                AppMethodBeat.o(136871);
                return bArr2;
            }
            AppMethodBeat.o(136871);
            return null;
        }
    }

    public final byte[] ZC() {
        AppMethodBeat.i(136869);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.dwG.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.dwI.containsKey(next)) {
                byte[] bArr = this.dwI.get(next);
                int intValue = this.dwJ.get(next).intValue();
                com.tencent.mm.audio.mix.a.e eVar = new com.tencent.mm.audio.mix.a.e();
                byte[] bArr2 = new byte[this.dwF];
                if (intValue > 0 && intValue <= this.dwF) {
                    System.arraycopy(bArr, 0, bArr2, 0, intValue);
                } else if (bArr != null) {
                    System.arraycopy(bArr, 0, bArr2, 0, this.dwF);
                }
                eVar.dtQ = bArr2;
                arrayList.add(eVar);
                this.dwJ.put(next, 0);
                Arrays.fill(bArr, 0, dwK, (byte) 0);
                this.dwI.put(next, bArr);
            }
        }
        byte[] R = R(arrayList);
        AppMethodBeat.o(136869);
        return R;
    }
}
