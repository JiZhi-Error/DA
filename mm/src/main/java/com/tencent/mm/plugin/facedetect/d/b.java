package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.Log;

public interface b {
    void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    boolean a(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean b(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean cTq();

    boolean cTr();

    void cTs();

    C1036b cTt();

    a cTu();

    void setBusinessTip(String str);

    public static class a {
        public String errMsg;
        public int sRX;
        public int sRY;

        a(String str) {
            this.sRY = 7;
            this.errMsg = str;
        }

        a() {
            this.sRX = 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.d.b$b  reason: collision with other inner class name */
    public static class C1036b {
        public int errCode;
        public String errMsg;

        public C1036b(int i2, String str) {
            this.errCode = i2;
            this.errMsg = str;
        }
    }

    public static class c {
        private static String TAG = "MicroMsg.IFaceMotion.Factory";

        public static b a(h.a aVar) {
            AppMethodBeat.i(103815);
            if (aVar == null) {
                AppMethodBeat.o(103815);
                return null;
            } else if (aVar.type == 4) {
                Log.i(TAG, "hy: is read number");
                d dVar = new d(aVar.sQY);
                AppMethodBeat.o(103815);
                return dVar;
            } else {
                Log.i(TAG, "hy: is normal");
                c cVar = new c(aVar.ktN, aVar.sQV);
                AppMethodBeat.o(103815);
                return cVar;
            }
        }
    }
}
