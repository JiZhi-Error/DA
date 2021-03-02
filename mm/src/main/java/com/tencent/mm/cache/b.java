package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Stack;

public final class b implements f<com.tencent.mm.z.b> {
    public int gpA;
    public Stack<com.tencent.mm.z.b> gpx;
    public Stack<com.tencent.mm.z.b> gpy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ void add(com.tencent.mm.z.b bVar) {
        AppMethodBeat.i(9205);
        com.tencent.mm.z.b bVar2 = bVar;
        if (this.gpx != null) {
            this.gpx.push(bVar2);
        }
        AppMethodBeat.o(9205);
    }

    @Override // com.tencent.mm.cache.f
    public final void onCreate() {
        AppMethodBeat.i(9198);
        this.gpx = new Stack<>();
        AppMethodBeat.o(9198);
    }

    @Override // com.tencent.mm.cache.f
    public final void onDestroy() {
        AppMethodBeat.i(9199);
        Log.i("MicroMsg.DoodleCache", "[onDestroy]");
        if (this.gpx != null) {
            this.gpx.clear();
        }
        if (this.gpy != null) {
            this.gpy.clear();
        }
        AppMethodBeat.o(9199);
    }

    @Override // com.tencent.mm.cache.f
    public final void dl(boolean z) {
        AppMethodBeat.i(9200);
        Log.i("MicroMsg.DoodleCache", "[onSave] size:%s", Integer.valueOf(this.gpx.size()));
        if (this.gpy != null) {
            this.gpy.clear();
        }
        this.gpy = (Stack) this.gpx.clone();
        if (z) {
            this.gpx.clear();
        }
        AppMethodBeat.o(9200);
    }

    @Override // com.tencent.mm.cache.f
    public final void alC() {
        AppMethodBeat.i(9201);
        Log.i("MicroMsg.DoodleCache", "[onRestore] size:%s", Integer.valueOf(this.gpx.size()));
        this.gpx.clear();
        if (this.gpy != null) {
            Log.i("MicroMsg.DoodleCache", "[onRestore] %s", Integer.valueOf(this.gpy.size()));
            this.gpx.addAll(this.gpy);
        }
        AppMethodBeat.o(9201);
    }

    @Override // com.tencent.mm.cache.f
    public final void a(Canvas canvas, boolean z) {
        com.tencent.mm.z.b bVar;
        AppMethodBeat.i(9202);
        if (z) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Iterator<com.tencent.mm.z.b> it = this.gpx.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas);
            }
            AppMethodBeat.o(9202);
            return;
        }
        if (this.gpx == null || this.gpx.size() <= 0) {
            bVar = null;
        } else {
            bVar = this.gpx.peek();
        }
        if (bVar != null) {
            bVar.draw(canvas);
        }
        AppMethodBeat.o(9202);
    }

    @Override // com.tencent.mm.cache.f
    public final void e(Canvas canvas) {
        AppMethodBeat.i(9203);
        Iterator<com.tencent.mm.z.b> it = this.gpx.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
        AppMethodBeat.o(9203);
    }

    @Override // com.tencent.mm.cache.f
    public final void clear() {
        AppMethodBeat.i(204748);
        if (this.gpx != null) {
            this.gpx.clear();
        }
        AppMethodBeat.o(204748);
    }

    @Override // com.tencent.mm.cache.f
    public final int ai(boolean z) {
        AppMethodBeat.i(9204);
        if (z) {
            if (this.gpx != null) {
                int size = this.gpx.size();
                AppMethodBeat.o(9204);
                return size;
            }
            AppMethodBeat.o(9204);
            return 0;
        } else if (this.gpy != null) {
            int size2 = this.gpy.size();
            AppMethodBeat.o(9204);
            return size2;
        } else {
            AppMethodBeat.o(9204);
            return 0;
        }
    }

    @Override // com.tencent.mm.cache.f
    public final void Ya() {
        this.gpA++;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ com.tencent.mm.z.b pop() {
        AppMethodBeat.i(9206);
        if (this.gpx.size() <= 0) {
            AppMethodBeat.o(9206);
            return null;
        }
        com.tencent.mm.z.b pop = this.gpx.pop();
        AppMethodBeat.o(9206);
        return pop;
    }
}
