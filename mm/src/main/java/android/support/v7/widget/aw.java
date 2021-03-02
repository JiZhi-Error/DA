package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class aw extends ContextWrapper {
    private static final Object ayw = new Object();
    private static ArrayList<WeakReference<aw>> ayx;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    public static Context ae(Context context) {
        boolean z = false;
        if (!(context instanceof aw) && !(context.getResources() instanceof ay) && !(context.getResources() instanceof be) && (Build.VERSION.SDK_INT < 21 || be.nk())) {
            z = true;
        }
        if (!z) {
            return context;
        }
        synchronized (ayw) {
            if (ayx == null) {
                ayx = new ArrayList<>();
            } else {
                for (int size = ayx.size() - 1; size >= 0; size--) {
                    WeakReference<aw> weakReference = ayx.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        ayx.remove(size);
                    }
                }
                for (int size2 = ayx.size() - 1; size2 >= 0; size2--) {
                    WeakReference<aw> weakReference2 = ayx.get(size2);
                    aw awVar = weakReference2 != null ? weakReference2.get() : null;
                    if (awVar != null && awVar.getBaseContext() == context) {
                        return awVar;
                    }
                }
            }
            aw awVar2 = new aw(context);
            ayx.add(new WeakReference<>(awVar2));
            return awVar2;
        }
    }

    private aw(Context context) {
        super(context);
        if (be.nk()) {
            this.mResources = new be(this, context.getResources());
            this.mTheme = this.mResources.newTheme();
            this.mTheme.setTo(context.getTheme());
            return;
        }
        this.mResources = new ay(this, context.getResources());
        this.mTheme = null;
    }

    public final Resources.Theme getTheme() {
        return this.mTheme == null ? super.getTheme() : this.mTheme;
    }

    public final void setTheme(int i2) {
        if (this.mTheme == null) {
            super.setTheme(i2);
        } else {
            this.mTheme.applyStyle(i2, true);
        }
    }

    public final Resources getResources() {
        return this.mResources;
    }

    public final AssetManager getAssets() {
        return this.mResources.getAssets();
    }
}
