package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Object;

public abstract class o {
    private final String mKey;

    /* access modifiers changed from: protected */
    public abstract void a(m mVar, V8Object v8Object);

    /* access modifiers changed from: package-private */
    public abstract void cleanup();

    public o() {
        this("");
    }

    public o(String str) {
        this.mKey = str;
    }

    /* access modifiers changed from: package-private */
    public final o a(m mVar) {
        if (TextUtils.isEmpty(this.mKey)) {
            a(mVar, mVar.XJ().getGlobalObject());
        } else {
            V8Object newV8Object = mVar.XJ().newV8Object();
            mVar.XJ().add(this.mKey, newV8Object);
            a(mVar, newV8Object);
            newV8Object.release();
        }
        return this;
    }
}
