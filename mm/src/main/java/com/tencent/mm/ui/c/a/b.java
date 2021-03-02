package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.HashMap;
import java.util.WeakHashMap;

public abstract class b {
    private static final WeakHashMap<View, b> OMi = new WeakHashMap<>(0);
    protected HashMap<Animator, Runnable> OMj;
    protected HashMap<Animator, Runnable> OMk;
    protected Runnable OMl;
    protected Runnable OMm;
    protected a OMn;

    public interface a {
        void by(float f2);
    }

    public abstract b aJ(Runnable runnable);

    public abstract b aK(Runnable runnable);

    public abstract b c(Interpolator interpolator);

    public abstract b cn(float f2);

    public abstract b co(float f2);

    public abstract b cp(float f2);

    public abstract b cq(float f2);

    public abstract b gKg();

    public abstract void start();

    public static b gu(View view) {
        b bVar = OMi.get(view);
        if (bVar == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            if (intValue >= 19) {
                bVar = new e(view);
            } else if (intValue >= 16) {
                bVar = new d(view);
            } else {
                bVar = new c(view);
            }
            OMi.put(view, bVar);
        }
        return bVar;
    }

    @TargetApi(11)
    public b a(a aVar) {
        this.OMn = aVar;
        return this;
    }
}
