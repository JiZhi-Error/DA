package com.tencent.mm.plugin.appbrand.widget.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;

/* access modifiers changed from: package-private */
@SuppressLint({"AppCompatCustomView"})
public class f extends ImageView implements com.tencent.mm.plugin.appbrand.jsapi.base.f {
    private boolean nak;

    public f(Context context) {
        super(context);
    }

    public void setInterceptEvent(boolean z) {
        this.nak = z;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.f
    public boolean bEY() {
        return this.nak;
    }
}
