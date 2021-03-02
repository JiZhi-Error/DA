package com.tencent.mm.kiss.widget.textview.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public a huK;

    public static b aBq() {
        AppMethodBeat.i(141136);
        b bVar = new b();
        bVar.huK = new a();
        AppMethodBeat.o(141136);
        return bVar;
    }

    public final b aBr() {
        this.huK.maxLines = 6;
        return this;
    }

    public final b b(TextUtils.TruncateAt truncateAt) {
        this.huK.hux = truncateAt;
        return this;
    }

    public final b qk(int i2) {
        this.huK.gravity = i2;
        return this;
    }

    public final b as(float f2) {
        this.huK.textSize = f2;
        return this;
    }

    public final b ql(int i2) {
        this.huK.textColor = i2;
        return this;
    }

    public final b aBs() {
        this.huK.breakStrategy = 1;
        return this;
    }
}
