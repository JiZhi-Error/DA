package com.tencent.mm.plugin.fts.a.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import java.util.ArrayList;
import java.util.List;

public abstract class b implements e {
    protected Context context;
    protected int mve;
    public e.b wXC;

    public b(Context context2, e.b bVar, int i2) {
        this.context = context2;
        this.wXC = bVar;
        this.mve = i2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public int dOF() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public List<c> GE(long j2) {
        return new ArrayList();
    }

    protected static boolean eP(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    protected static <T> List<T> eQ(List<T> list) {
        if (!eP(list) || list.size() <= 3) {
            return list;
        }
        return list.subList(0, 3);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.e
    public boolean a(View view, a aVar, boolean z) {
        return false;
    }
}
