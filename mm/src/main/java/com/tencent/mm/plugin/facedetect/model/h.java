package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;

public final class h {
    public static h sQT;
    public int rmJ = 0;
    public int[] sQR = null;
    public int sQS = -1;

    public static class a {
        public String ktN;
        public long sQU;
        public long sQV;
        public boolean sQW;
        public long sQX;
        public String sQY;
        public boolean sQZ;
        public boolean sRa;
        public int type;

        public a(int i2, String str) {
            AppMethodBeat.i(103741);
            this.type = i2;
            this.sQY = str;
            switch (this.type) {
                case 0:
                    this.sQU = 30;
                    this.sQV = 7000;
                    this.ktN = MMApplicationContext.getContext().getString(R.string.hct);
                    this.sQW = true;
                    this.sQX = 2500;
                    this.sQZ = false;
                    this.sRa = false;
                    AppMethodBeat.o(103741);
                    return;
                case 1:
                    this.sQU = 30;
                    this.sQV = 7000;
                    this.ktN = MMApplicationContext.getContext().getString(R.string.c5f);
                    this.sQW = false;
                    this.sQX = -1;
                    this.sQZ = true;
                    this.sRa = true;
                    AppMethodBeat.o(103741);
                    return;
                case 2:
                    this.sQU = 30;
                    this.sQV = 7000;
                    this.ktN = MMApplicationContext.getContext().getString(R.string.c5g);
                    this.sQW = false;
                    this.sQX = -1;
                    this.sQZ = true;
                    this.sRa = true;
                    AppMethodBeat.o(103741);
                    return;
                case 3:
                    this.sQU = 30;
                    this.sQV = 7000;
                    this.ktN = MMApplicationContext.getContext().getString(R.string.c5e);
                    this.sQW = true;
                    this.sQX = -1;
                    this.sQZ = true;
                    this.sRa = true;
                    AppMethodBeat.o(103741);
                    return;
                case 4:
                    this.sQU = 30;
                    this.sQV = 7000;
                    this.ktN = MMApplicationContext.getContext().getString(R.string.c5h);
                    this.sQW = true;
                    this.sQX = 1000;
                    this.sQZ = true;
                    this.sRa = true;
                    AppMethodBeat.o(103741);
                    return;
                default:
                    Log.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                    this.type = 100;
                    AppMethodBeat.o(103741);
                    return;
            }
        }

        public final String toString() {
            AppMethodBeat.i(103742);
            String str = "FaceProcessItem{type=" + this.type + ", frameTween=" + this.sQU + ", hintTween=" + this.sQV + ", hintStr='" + this.ktN + '\'' + ", isCheckFace=" + this.sQW + ", minSuccTime=" + this.sQX + ", actionData='" + this.sQY + '\'' + '}';
            AppMethodBeat.o(103742);
            return str;
        }
    }

    public static a cTd() {
        String engineGetCurrMotionData;
        AppMethodBeat.i(103743);
        int cSZ = f.INSTANCE.cSZ();
        g gVar = f.INSTANCE.sQN.sSO;
        if (gVar.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: get motion data not init");
            engineGetCurrMotionData = null;
        } else {
            engineGetCurrMotionData = gVar.sQQ.engineGetCurrMotionData();
        }
        a aVar = new a(cSZ, engineGetCurrMotionData);
        AppMethodBeat.o(103743);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(103744);
        String str = "FaceDetectProcessModel{mProcessInSequence=" + Arrays.toString(this.sQR) + '}';
        AppMethodBeat.o(103744);
        return str;
    }
}
