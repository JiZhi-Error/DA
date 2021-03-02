package com.bumptech.glide.load.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.e.c;

public abstract class b<T extends Drawable> implements r, v<T> {
    protected final T drawable;

    public b(T t) {
        this.drawable = (T) ((Drawable) j.checkNotNull(t, "Argument must not be null"));
    }

    @Override // com.bumptech.glide.load.b.r
    public void initialize() {
        if (this.drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
        } else if (this.drawable instanceof c) {
            ((c) this.drawable).pJ().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.b.v
    public final /* synthetic */ Object get() {
        Drawable.ConstantState constantState = this.drawable.getConstantState();
        if (constantState == null) {
            return this.drawable;
        }
        return constantState.newDrawable();
    }
}
