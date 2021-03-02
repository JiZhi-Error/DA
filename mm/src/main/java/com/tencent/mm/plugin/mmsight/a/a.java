package com.tencent.mm.plugin.mmsight.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static void a(b bVar, String str) {
        AppMethodBeat.i(94388);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[14];
        objArr[0] = Integer.valueOf(bVar.scene);
        objArr[1] = Integer.valueOf(bVar.ifz ? 2 : 1);
        objArr[2] = Integer.valueOf(bVar.zxk);
        objArr[3] = Integer.valueOf(bVar.zxl);
        objArr[4] = Integer.valueOf(bVar.zxn);
        objArr[5] = Boolean.valueOf(bVar.zxm);
        objArr[6] = Integer.valueOf(bVar.gpA);
        objArr[7] = Integer.valueOf(bVar.zxi);
        objArr[8] = Integer.valueOf(bVar.zxj);
        objArr[9] = Integer.valueOf(bVar.zxo);
        objArr[10] = 0;
        objArr[11] = Integer.valueOf(bVar.textColor);
        objArr[12] = str;
        objArr[13] = Long.valueOf(Util.nowSecond());
        hVar.a(14362, objArr);
        Log.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", bVar.toString());
        AppMethodBeat.o(94388);
    }

    public static void a(C1478a aVar) {
        AppMethodBeat.i(94389);
        Log.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", aVar.toString());
        h.INSTANCE.a(14529, Integer.valueOf(aVar.scene), Integer.valueOf(aVar.source));
        AppMethodBeat.o(94389);
    }

    public static class b {
        public int gpA;
        public boolean ifz;
        public int scene;
        public int textColor;
        public int zxi;
        public int zxj;
        public int zxk;
        public int zxl;
        public boolean zxm;
        public int zxn;
        public int zxo;

        public b(int i2) {
            AppMethodBeat.i(94386);
            if (i2 == 1) {
                this.scene = 2;
                AppMethodBeat.o(94386);
            } else if (i2 == 2) {
                this.scene = 4;
                AppMethodBeat.o(94386);
            } else if (i2 == 512) {
                this.scene = 3;
                AppMethodBeat.o(94386);
            } else {
                if (i2 == 4) {
                    this.scene = 8;
                }
                AppMethodBeat.o(94386);
            }
        }

        public final String toString() {
            AppMethodBeat.i(94387);
            String str = "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.ifz + ", rawDuration=" + this.zxi + ", cropDuration=" + this.zxj + ", emojiItemCount=" + this.zxk + ", textItemCount=" + this.zxl + ", isCrop=" + this.zxm + ", undoCount=" + this.gpA + ", doodleCount=" + this.zxn + ", penColors=" + this.zxo + ", textColor=" + this.textColor + '}';
            AppMethodBeat.o(94387);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.a.a$a  reason: collision with other inner class name */
    public static class C1478a {
        int scene;
        int source = 2;

        public C1478a(int i2) {
            AppMethodBeat.i(94384);
            if (i2 == 1) {
                this.scene = 1;
                AppMethodBeat.o(94384);
            } else if (i2 == 2) {
                this.scene = 2;
                AppMethodBeat.o(94384);
            } else if (i2 == 512) {
                this.source = 1;
                this.scene = 2;
                AppMethodBeat.o(94384);
            } else {
                if (i2 == 4) {
                    this.scene = 4;
                }
                AppMethodBeat.o(94384);
            }
        }

        public final String toString() {
            AppMethodBeat.i(94385);
            String str = "VideoEditCountData{scene=" + this.scene + ", source=" + this.source + '}';
            AppMethodBeat.o(94385);
            return str;
        }
    }
}
