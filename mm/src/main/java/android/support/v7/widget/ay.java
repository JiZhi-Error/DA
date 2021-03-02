package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class ay extends am {
    private final WeakReference<Context> mContextRef;

    public ay(Context context, Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.am, android.content.res.Resources
    public final Drawable getDrawable(int i2) {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.mContextRef.get();
        if (!(drawable == null || context == null)) {
            g.jk();
            g.a(context, i2, drawable);
        }
        return drawable;
    }
}
