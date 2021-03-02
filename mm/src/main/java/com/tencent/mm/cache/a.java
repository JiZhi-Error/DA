package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;

public final class a implements f<com.tencent.mm.z.a> {
    private int gpA;
    private Stack<com.tencent.mm.z.a> gpx;
    private Stack<com.tencent.mm.z.a> gpy;
    public Matrix gpz = new Matrix();

    public a() {
        AppMethodBeat.i(9187);
        AppMethodBeat.o(9187);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ void add(com.tencent.mm.z.a aVar) {
        AppMethodBeat.i(9196);
        a(aVar);
        AppMethodBeat.o(9196);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ com.tencent.mm.z.a pop() {
        AppMethodBeat.i(9197);
        com.tencent.mm.z.a alD = alD();
        AppMethodBeat.o(9197);
        return alD;
    }

    @Override // com.tencent.mm.cache.f
    public final void onCreate() {
        AppMethodBeat.i(9188);
        Log.i("MicroMsg.CropCache", "[onCreate]");
        this.gpx = new Stack<>();
        AppMethodBeat.o(9188);
    }

    @Override // com.tencent.mm.cache.f
    public final void onDestroy() {
        AppMethodBeat.i(9189);
        if (this.gpx != null) {
            this.gpx.clear();
        }
        if (this.gpy != null) {
            this.gpy.clear();
        }
        this.gpz.reset();
        AppMethodBeat.o(9189);
    }

    @Override // com.tencent.mm.cache.f
    public final void dl(boolean z) {
        AppMethodBeat.i(9190);
        Log.i("MicroMsg.CropCache", "[onSave] size:%s", Integer.valueOf(this.gpx.size()));
        if (this.gpy != null) {
            this.gpy.clear();
        }
        this.gpy = (Stack) this.gpx.clone();
        if (z) {
            this.gpx.clear();
        }
        AppMethodBeat.o(9190);
    }

    @Override // com.tencent.mm.cache.f
    public final void alC() {
        AppMethodBeat.i(9191);
        Log.i("MicroMsg.CropCache", "[onRestore] size:%s", Integer.valueOf(this.gpx.size()));
        this.gpx.clear();
        if (this.gpy != null) {
            Log.i("MicroMsg.CropCache", "[onRestore] %s", Integer.valueOf(this.gpy.size()));
            this.gpx.addAll(this.gpy);
        }
        AppMethodBeat.o(9191);
    }

    @Override // com.tencent.mm.cache.f
    public final void a(Canvas canvas, boolean z) {
    }

    @Override // com.tencent.mm.cache.f
    public final void e(Canvas canvas) {
    }

    public final com.tencent.mm.z.a alD() {
        AppMethodBeat.i(9192);
        if (this.gpx.size() <= 0) {
            Log.e("MicroMsg.CropCache", "[pop]");
            AppMethodBeat.o(9192);
            return null;
        }
        com.tencent.mm.z.a pop = this.gpx.pop();
        AppMethodBeat.o(9192);
        return pop;
    }

    public final void a(com.tencent.mm.z.a aVar) {
        AppMethodBeat.i(9193);
        if (this.gpx != null) {
            this.gpx.push(aVar);
        }
        AppMethodBeat.o(9193);
    }

    @Override // com.tencent.mm.cache.f
    public final void clear() {
        AppMethodBeat.i(204747);
        if (this.gpx != null) {
            this.gpx.clear();
        }
        AppMethodBeat.o(204747);
    }

    public final com.tencent.mm.z.a alE() {
        AppMethodBeat.i(9194);
        if (this.gpx == null || this.gpx.size() <= 0) {
            AppMethodBeat.o(9194);
            return null;
        }
        com.tencent.mm.z.a peek = this.gpx.peek();
        AppMethodBeat.o(9194);
        return peek;
    }

    @Override // com.tencent.mm.cache.f
    public final int ai(boolean z) {
        AppMethodBeat.i(9195);
        if (z) {
            if (this.gpx != null) {
                int size = this.gpx.size();
                AppMethodBeat.o(9195);
                return size;
            }
            AppMethodBeat.o(9195);
            return 0;
        } else if (this.gpy != null) {
            int size2 = this.gpy.size();
            AppMethodBeat.o(9195);
            return size2;
        } else {
            AppMethodBeat.o(9195);
            return 0;
        }
    }

    @Override // com.tencent.mm.cache.f
    public final void Ya() {
        this.gpA++;
    }
}
