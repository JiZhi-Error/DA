package android.support.design.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.b;
import android.support.design.widget.k;
import android.util.Property;

public interface c extends b.a {
    void bu();

    void bv();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(d dVar);

    public static class d {
        public float centerX;
        public float centerY;
        public float radius;

        /* synthetic */ d(byte b2) {
            this();
        }

        private d() {
        }

        public d(float f2, float f3, float f4) {
            this.centerX = f2;
            this.centerY = f3;
            this.radius = f4;
        }

        public d(d dVar) {
            this(dVar.centerX, dVar.centerY, dVar.radius);
        }

        public final void b(float f2, float f3, float f4) {
            this.centerX = f2;
            this.centerY = f3;
            this.radius = f4;
        }

        public final void b(d dVar) {
            b(dVar.centerX, dVar.centerY, dVar.radius);
        }

        public final boolean isInvalid() {
            return this.radius == Float.MAX_VALUE;
        }
    }

    public static class b extends Property<c, d> {
        public static final Property<c, d> jQ = new b("circularReveal");

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ d get(c cVar) {
            return cVar.getRevealInfo();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(c cVar, d dVar) {
            cVar.setRevealInfo(dVar);
        }

        private b(String str) {
            super(d.class, str);
        }
    }

    public static class a implements TypeEvaluator<d> {
        public static final TypeEvaluator<d> jP = new a();
        private final d jL = new d((byte) 0);

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public final /* synthetic */ d evaluate(float f2, d dVar, d dVar2) {
            d dVar3 = dVar;
            d dVar4 = dVar2;
            this.jL.b(k.lerp(dVar3.centerX, dVar4.centerX, f2), k.lerp(dVar3.centerY, dVar4.centerY, f2), k.lerp(dVar3.radius, dVar4.radius, f2));
            return this.jL;
        }
    }

    /* renamed from: android.support.design.circularreveal.c$c  reason: collision with other inner class name */
    public static class C0010c extends Property<c, Integer> {
        public static final Property<c, Integer> jR = new C0010c("circularRevealScrimColor");

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }

        private C0010c(String str) {
            super(Integer.class, str);
        }
    }
}
