package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.d;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class f implements l<c> {
    private final l<Bitmap> aLm;

    public f(l<Bitmap> lVar) {
        AppMethodBeat.i(77506);
        this.aLm = (l) j.checkNotNull(lVar, "Argument must not be null");
        AppMethodBeat.o(77506);
    }

    @Override // com.bumptech.glide.load.l
    public final v<c> a(Context context, v<c> vVar, int i2, int i3) {
        AppMethodBeat.i(77507);
        c cVar = vVar.get();
        v<Bitmap> dVar = new d(cVar.pJ(), c.af(context).aCj);
        v<Bitmap> a2 = this.aLm.a(context, dVar, i2, i3);
        if (!dVar.equals(a2)) {
            dVar.recycle();
        }
        l<Bitmap> lVar = this.aLm;
        cVar.aLL.aLQ.a(lVar, a2.get());
        AppMethodBeat.o(77507);
        return vVar;
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(77508);
        if (obj instanceof f) {
            boolean equals = this.aLm.equals(((f) obj).aLm);
            AppMethodBeat.o(77508);
            return equals;
        }
        AppMethodBeat.o(77508);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(77509);
        int hashCode = this.aLm.hashCode();
        AppMethodBeat.o(77509);
        return hashCode;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(77510);
        this.aLm.a(messageDigest);
        AppMethodBeat.o(77510);
    }
}
