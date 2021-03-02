package android.support.a;

import android.os.Looper;
import android.os.SystemClock;
import android.support.a.a;
import android.support.a.b;
import android.support.v4.view.u;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;

public abstract class b<T extends b<T>> implements a.b {
    public static final AbstractC0004b fK = new AbstractC0004b("translationX") {
        /* class android.support.a.b.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getTranslationX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setTranslationX(f2);
        }
    };
    public static final AbstractC0004b fL = new AbstractC0004b("translationY") {
        /* class android.support.a.b.AnonymousClass7 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getTranslationY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setTranslationY(f2);
        }
    };
    public static final AbstractC0004b fM = new AbstractC0004b("translationZ") {
        /* class android.support.a.b.AnonymousClass8 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return u.am(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            u.m(view, f2);
        }
    };
    public static final AbstractC0004b fN = new AbstractC0004b("scaleX") {
        /* class android.support.a.b.AnonymousClass9 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getScaleX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setScaleX(f2);
        }
    };
    public static final AbstractC0004b fO = new AbstractC0004b("scaleY") {
        /* class android.support.a.b.AnonymousClass10 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getScaleY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setScaleY(f2);
        }
    };
    public static final AbstractC0004b fP = new AbstractC0004b("rotation") {
        /* class android.support.a.b.AnonymousClass11 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getRotation();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setRotation(f2);
        }
    };
    public static final AbstractC0004b fQ = new AbstractC0004b("rotationX") {
        /* class android.support.a.b.AnonymousClass12 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getRotationX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setRotationX(f2);
        }
    };
    public static final AbstractC0004b fR = new AbstractC0004b("rotationY") {
        /* class android.support.a.b.AnonymousClass13 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getRotationY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setRotationY(f2);
        }
    };
    public static final AbstractC0004b fS = new AbstractC0004b("x") {
        /* class android.support.a.b.AnonymousClass14 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setX(f2);
        }
    };
    public static final AbstractC0004b fT = new AbstractC0004b("y") {
        /* class android.support.a.b.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setY(f2);
        }
    };
    public static final AbstractC0004b fU = new AbstractC0004b("z") {
        /* class android.support.a.b.AnonymousClass3 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return u.aA(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            u.n(view, f2);
        }
    };
    public static final AbstractC0004b fV = new AbstractC0004b("alpha") {
        /* class android.support.a.b.AnonymousClass4 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return view.getAlpha();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setAlpha(f2);
        }
    };
    public static final AbstractC0004b fW = new AbstractC0004b("scrollX") {
        /* class android.support.a.b.AnonymousClass5 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return (float) view.getScrollX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setScrollX((int) f2);
        }
    };
    public static final AbstractC0004b fX = new AbstractC0004b("scrollY") {
        /* class android.support.a.b.AnonymousClass6 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.support.a.c
        public final /* synthetic */ float f(View view) {
            return (float) view.getScrollY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // android.support.a.c
        public final /* synthetic */ void setValue(View view, float f2) {
            view.setScrollY((int) f2);
        }
    };
    private long fF = 0;
    float fY = 0.0f;
    float fZ = Float.MAX_VALUE;
    boolean ga = false;
    final c gb;
    boolean gc = false;
    float gd = Float.MAX_VALUE;
    float ge = (-this.gd);
    float gf;
    private final ArrayList<Object> gg = new ArrayList<>();
    private final ArrayList<Object> gh = new ArrayList<>();
    final Object mTarget;

    /* access modifiers changed from: package-private */
    public abstract boolean e(long j2);

    /* renamed from: android.support.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0004b extends c<View> {
        /* synthetic */ AbstractC0004b(String str, byte b2) {
            this(str);
        }

        private AbstractC0004b(String str) {
            super(str);
        }
    }

    static class a {
        float fY;
        float fZ;

        a() {
        }
    }

    <K> b(K k, c<K> cVar) {
        this.mTarget = k;
        this.gb = cVar;
        if (this.gb == fP || this.gb == fQ || this.gb == fR) {
            this.gf = 0.1f;
        } else if (this.gb == fV) {
            this.gf = 0.00390625f;
        } else if (this.gb == fN || this.gb == fO) {
            this.gf = 0.00390625f;
        } else {
            this.gf = 1.0f;
        }
    }

    public final T e(float f2) {
        this.fZ = f2;
        this.ga = true;
        return this;
    }

    public final T aH() {
        this.fY = 4000.0f;
        return this;
    }

    private static <T> void b(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.gc && !this.gc) {
            this.gc = true;
            if (!this.ga) {
                this.fZ = this.gb.f(this.mTarget);
            }
            if (this.fZ > this.gd || this.fZ < this.ge) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a aD = a.aD();
            if (aD.fy.size() == 0) {
                aD.aE().aG();
            }
            if (!aD.fy.contains(this)) {
                aD.fy.add(this);
            }
            if (0 > 0) {
                aD.fx.put(this, Long.valueOf(SystemClock.uptimeMillis() + 0));
            }
        }
    }

    public final void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.gc) {
            aI();
        }
    }

    @Override // android.support.a.a.b
    public final boolean d(long j2) {
        if (this.fF == 0) {
            this.fF = j2;
            f(this.fZ);
            return false;
        }
        this.fF = j2;
        boolean e2 = e(j2 - this.fF);
        this.fZ = Math.min(this.fZ, this.gd);
        this.fZ = Math.max(this.fZ, this.ge);
        f(this.fZ);
        if (!e2) {
            return e2;
        }
        aI();
        return e2;
    }

    private void aI() {
        this.gc = false;
        a.aD().a(this);
        this.fF = 0;
        this.ga = false;
        for (int i2 = 0; i2 < this.gg.size(); i2++) {
            if (this.gg.get(i2) != null) {
                this.gg.get(i2);
            }
        }
        b(this.gg);
    }

    private void f(float f2) {
        this.gb.setValue(this.mTarget, f2);
        for (int i2 = 0; i2 < this.gh.size(); i2++) {
            if (this.gh.get(i2) != null) {
                this.gh.get(i2);
            }
        }
        b(this.gh);
    }
}
