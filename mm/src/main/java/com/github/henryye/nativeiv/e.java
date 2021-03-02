package com.github.henryye.nativeiv;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SuppressLint({"LongLogTag"})
public class e {
    private static volatile e baJ = null;
    b baK = new a(this, (byte) 0);

    public interface b {
        Bitmap aX(int i2, int i3);

        void init();
    }

    public static e sR() {
        e eVar;
        AppMethodBeat.i(127354);
        if (baJ == null) {
            synchronized (e.class) {
                try {
                    if (baJ == null) {
                        baJ = new e();
                    }
                    eVar = baJ;
                } finally {
                    AppMethodBeat.o(127354);
                }
            }
            return eVar;
        }
        e eVar2 = baJ;
        AppMethodBeat.o(127354);
        return eVar2;
    }

    private e() {
        AppMethodBeat.i(127355);
        this.baK.init();
        AppMethodBeat.o(127355);
    }

    class a implements b {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        @Override // com.github.henryye.nativeiv.e.b
        public final void init() {
            AppMethodBeat.i(127352);
            com.github.henryye.nativeiv.a.b.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
            AppMethodBeat.o(127352);
        }

        @Override // com.github.henryye.nativeiv.e.b
        public final Bitmap aX(int i2, int i3) {
            AppMethodBeat.i(127353);
            com.github.henryye.nativeiv.a.b.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            AppMethodBeat.o(127353);
            return createBitmap;
        }
    }
}
