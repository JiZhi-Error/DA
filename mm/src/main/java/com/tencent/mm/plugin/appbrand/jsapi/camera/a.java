package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class a {
    public boolean lOV;
    public boolean lOW;
    SparseArray<WeakReference<f>> lOX;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        AppMethodBeat.i(137464);
        this.lOV = true;
        this.lOW = true;
        this.lOX = new SparseArray<>();
        AppMethodBeat.o(137464);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a$a */
    public static class C0654a {
        private static a lOY = new a((byte) 0);

        static {
            AppMethodBeat.i(137463);
            AppMethodBeat.o(137463);
        }
    }

    public final void a(int i2, f fVar) {
        AppMethodBeat.i(137465);
        this.lOX.put(i2, new WeakReference<>(fVar));
        AppMethodBeat.o(137465);
    }

    public final boolean M(int i2, boolean z) {
        AppMethodBeat.i(137466);
        if (this.lOX.indexOfKey(i2) >= 0) {
            WeakReference<f> weakReference = this.lOX.get(i2);
            if (weakReference != null) {
                f fVar = weakReference.get();
                if (fVar != null) {
                    fVar.release();
                } else {
                    Log.i("MicroMsg.AppBrandCameraMrg", "release a recycled camera instance");
                }
            } else {
                Log.i("MicroMsg.AppBrandCameraMrg", "release client fail, weak reference not exist");
            }
            if (z) {
                this.lOX.remove(i2);
            }
            AppMethodBeat.o(137466);
            return true;
        }
        AppMethodBeat.o(137466);
        return false;
    }

    public final int[] bFG() {
        AppMethodBeat.i(137467);
        if (this.lOX == null || this.lOX.size() == 0) {
            int[] iArr = new int[0];
            AppMethodBeat.o(137467);
            return iArr;
        }
        int[] iArr2 = new int[this.lOX.size()];
        for (int i2 = 0; i2 < this.lOX.size(); i2++) {
            iArr2[i2] = this.lOX.keyAt(i2);
        }
        AppMethodBeat.o(137467);
        return iArr2;
    }

    public final boolean bFH() {
        AppMethodBeat.i(137468);
        if (!this.lOV) {
            Log.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        boolean z = this.lOV;
        AppMethodBeat.o(137468);
        return z;
    }
}
