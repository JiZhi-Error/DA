package android.support.design.f;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: me  reason: collision with root package name */
    public float f30me;
    public float mf;
    public float mg;
    public float mh;
    private final List<c> mi = new ArrayList();

    public static abstract class c {
        protected final Matrix gT = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public d() {
        bK();
    }

    public final void bK() {
        this.f30me = 0.0f;
        this.mf = 0.0f;
        this.mg = 0.0f;
        this.mh = 0.0f;
        this.mi.clear();
    }

    public final void j(float f2) {
        b bVar = new b();
        bVar.x = f2;
        bVar.y = 0.0f;
        this.mi.add(bVar);
        this.mg = f2;
        this.mh = 0.0f;
    }

    public final void addArc(float f2, float f3, float f4, float f5, float f6, float f7) {
        a aVar = new a(f2, f3, f4, f5);
        aVar.mj = f6;
        aVar.mk = f7;
        this.mi.add(aVar);
        this.mg = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians((double) (f6 + f7)))));
        this.mh = ((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians((double) (f6 + f7)))));
    }

    public final void a(Matrix matrix, Path path) {
        int size = this.mi.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mi.get(i2).a(matrix, path);
        }
    }

    public static class b extends c {
        float x;
        float y;

        @Override // android.support.design.f.d.c
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.gT;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x, this.y);
            path.transform(matrix);
        }
    }

    public static class a extends c {
        private static final RectF hO = new RectF();
        public float bottom;
        public float left;
        public float mj;
        public float mk;
        public float right;
        public float top;

        public a(float f2, float f3, float f4, float f5) {
            this.left = f2;
            this.top = f3;
            this.right = f4;
            this.bottom = f5;
        }

        @Override // android.support.design.f.d.c
        public final void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.gT;
            matrix.invert(matrix2);
            path.transform(matrix2);
            hO.set(this.left, this.top, this.right, this.bottom);
            path.arcTo(hO, this.mj, this.mk, false);
            path.transform(matrix);
        }
    }
}
