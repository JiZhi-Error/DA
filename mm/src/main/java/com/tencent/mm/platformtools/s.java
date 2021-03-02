package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface s {

    public interface b {
        Bitmap So(String str);
    }

    Bitmap a(Bitmap bitmap, a aVar, String str);

    void a(a aVar, String str);

    void ad(String str, boolean z);

    String blA();

    String blB();

    String blC();

    boolean blD();

    boolean blE();

    Bitmap blF();

    void blG();

    b blz();

    String getCacheKey();

    public enum a {
        NET,
        DISK;

        public static a valueOf(String str) {
            AppMethodBeat.i(151380);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(151380);
            return aVar;
        }

        static {
            AppMethodBeat.i(151381);
            AppMethodBeat.o(151381);
        }
    }
}
