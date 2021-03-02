package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class b<T extends c> implements c {
    Context mContext;

    /* access modifiers changed from: protected */
    public abstract T j(SnsInfo snsInfo);

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        if (view == null || snsInfo == null) {
            return false;
        }
        try {
            T j2 = j(snsInfo);
            if (j2 != null) {
                boolean a2 = j2.a(view, i2, snsInfo, dVar);
                if (!a2) {
                    return a2;
                }
                a(j2, snsInfo, dVar);
                return a2;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(T t, SnsInfo snsInfo, d dVar) {
    }
}
