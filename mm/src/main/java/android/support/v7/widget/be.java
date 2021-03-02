package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public final class be extends Resources {
    private static boolean azM = false;
    private final WeakReference<Context> mContextRef;

    public be(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i2) {
        Context context = this.mContextRef.get();
        if (context != null) {
            return g.jk().a(context, this, i2);
        }
        return super.getDrawable(i2);
    }

    /* access modifiers changed from: package-private */
    public final Drawable cY(int i2) {
        return super.getDrawable(i2);
    }

    public static boolean nk() {
        return azM && Build.VERSION.SDK_INT <= 20;
    }
}
