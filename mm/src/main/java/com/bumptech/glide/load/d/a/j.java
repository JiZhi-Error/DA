package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j implements l<Drawable> {
    private final l<Bitmap> aLm;
    private final boolean aLn = true;

    public j(l<Bitmap> lVar, boolean z) {
        this.aLm = lVar;
    }

    @Override // com.bumptech.glide.load.l
    public final v<Drawable> a(Context context, v<Drawable> vVar, int i2, int i3) {
        AppMethodBeat.i(77404);
        e eVar = c.af(context).aCj;
        Drawable drawable = vVar.get();
        v<Bitmap> a2 = i.a(eVar, drawable, i2, i3);
        if (a2 != null) {
            v<Bitmap> a3 = this.aLm.a(context, a2, i2, i3);
            if (a3.equals(a2)) {
                a3.recycle();
                AppMethodBeat.o(77404);
                return vVar;
            }
            v<BitmapDrawable> a4 = m.a(context.getResources(), a3);
            AppMethodBeat.o(77404);
            return a4;
        } else if (this.aLn) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            AppMethodBeat.o(77404);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.o(77404);
            return vVar;
        }
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(77405);
        if (obj instanceof j) {
            boolean equals = this.aLm.equals(((j) obj).aLm);
            AppMethodBeat.o(77405);
            return equals;
        }
        AppMethodBeat.o(77405);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(77406);
        int hashCode = this.aLm.hashCode();
        AppMethodBeat.o(77406);
        return hashCode;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(77407);
        this.aLm.a(messageDigest);
        AppMethodBeat.o(77407);
    }
}
