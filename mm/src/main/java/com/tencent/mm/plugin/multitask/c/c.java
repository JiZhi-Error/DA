package com.tencent.mm.plugin.multitask.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    void RL(int i2);

    void a(Bitmap bitmap, boolean z, int i2);

    void g(Bitmap bitmap, int i2);

    public static final class a {
        public static /* synthetic */ void a(c cVar, Bitmap bitmap, boolean z, int i2) {
            AppMethodBeat.i(200620);
            if ((i2 & 2) != 0) {
                z = false;
            }
            cVar.a(bitmap, z, 0);
            AppMethodBeat.o(200620);
        }

        public static /* synthetic */ void a(c cVar, Bitmap bitmap) {
            AppMethodBeat.i(200621);
            cVar.g(bitmap, 0);
            AppMethodBeat.o(200621);
        }
    }
}
