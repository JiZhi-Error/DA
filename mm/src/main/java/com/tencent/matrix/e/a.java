package com.tencent.matrix.e;

import android.content.Context;
import com.tencent.matrix.g.c;

public class a implements c {
    private final Context context;

    public a(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.matrix.e.c
    public final void b(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is inited", bVar.getTag());
    }

    @Override // com.tencent.matrix.e.c
    public final void c(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is started", bVar.getTag());
    }

    @Override // com.tencent.matrix.e.c
    public final void d(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is stopped", bVar.getTag());
    }

    @Override // com.tencent.matrix.e.c
    public final void e(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is destroyed", bVar.getTag());
    }

    @Override // com.tencent.matrix.e.c
    public void a(com.tencent.matrix.report.c cVar) {
        Object[] objArr = new Object[1];
        Object obj = cVar;
        if (cVar == null) {
            obj = "";
        }
        objArr[0] = obj;
        c.i("Matrix.DefaultPluginListener", "report issue content: %s", objArr);
    }
}
