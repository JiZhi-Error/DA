package com.bumptech.glide.load.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m implements r, v<BitmapDrawable> {
    private final Resources aKy;
    private final v<Bitmap> aLs;

    public static v<BitmapDrawable> a(Resources resources, v<Bitmap> vVar) {
        AppMethodBeat.i(77411);
        if (vVar == null) {
            AppMethodBeat.o(77411);
            return null;
        }
        m mVar = new m(resources, vVar);
        AppMethodBeat.o(77411);
        return mVar;
    }

    private m(Resources resources, v<Bitmap> vVar) {
        AppMethodBeat.i(77412);
        this.aKy = (Resources) j.checkNotNull(resources, "Argument must not be null");
        this.aLs = (v) j.checkNotNull(vVar, "Argument must not be null");
        AppMethodBeat.o(77412);
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<BitmapDrawable> oV() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        AppMethodBeat.i(77413);
        int size = this.aLs.getSize();
        AppMethodBeat.o(77413);
        return size;
    }

    @Override // com.bumptech.glide.load.b.v
    public final void recycle() {
        AppMethodBeat.i(77414);
        this.aLs.recycle();
        AppMethodBeat.o(77414);
    }

    @Override // com.bumptech.glide.load.b.r
    public final void initialize() {
        AppMethodBeat.i(77415);
        if (this.aLs instanceof r) {
            ((r) this.aLs).initialize();
        }
        AppMethodBeat.o(77415);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.b.v
    public final /* synthetic */ BitmapDrawable get() {
        AppMethodBeat.i(77416);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.aKy, this.aLs.get());
        AppMethodBeat.o(77416);
        return bitmapDrawable;
    }
}
