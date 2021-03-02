package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.v4.content.a.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final Property<b, float[]> Ax = new Property<b, float[]>(float[].class, "nonTranslations") {
        /* class android.support.transition.ChangeTransform.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ float[] get(b bVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(b bVar, float[] fArr) {
            b bVar2 = bVar;
            float[] fArr2 = fArr;
            System.arraycopy(fArr2, 0, bVar2.AI, 0, fArr2.length);
            bVar2.dI();
        }
    };
    private static final Property<b, PointF> Ay = new Property<b, PointF>(PointF.class, "translations") {
        /* class android.support.transition.ChangeTransform.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(b bVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(b bVar, PointF pointF) {
            b bVar2 = bVar;
            PointF pointF2 = pointF;
            bVar2.AJ = pointF2.x;
            bVar2.AK = pointF2.y;
            bVar2.dI();
        }
    };
    private static final boolean Az;
    private static final String[] zP = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    boolean AA = true;
    private Matrix AB = new Matrix();
    private boolean zY = true;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        Az = z;
    }

    public ChangeTransform() {
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BW);
        this.AA = g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparentWithOverlay", 1, true);
        this.zY = g.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.transition.Transition
    public final String[] getTransitionProperties() {
        return zP;
    }

    private void c(v vVar) {
        Matrix matrix;
        View view = vVar.view;
        if (view.getVisibility() != 8) {
            vVar.values.put("android:changeTransform:parent", view.getParent());
            vVar.values.put("android:changeTransform:transforms", new c(view));
            Matrix matrix2 = view.getMatrix();
            if (matrix2 == null || matrix2.isIdentity()) {
                matrix = null;
            } else {
                matrix = new Matrix(matrix2);
            }
            vVar.values.put("android:changeTransform:matrix", matrix);
            if (this.zY) {
                Matrix matrix3 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                ah.a(viewGroup, matrix3);
                matrix3.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                vVar.values.put("android:changeTransform:parentMatrix", matrix3);
                vVar.values.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.iv6));
                vVar.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.g8p));
            }
        }
    }

    @Override // android.support.transition.Transition
    public final void a(v vVar) {
        c(vVar);
        if (!Az) {
            ((ViewGroup) vVar.view.getParent()).startViewTransition(vVar.view);
        }
    }

    @Override // android.support.transition.Transition
    public final void b(v vVar) {
        c(vVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // android.support.transition.Transition
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator a(android.view.ViewGroup r15, android.support.transition.v r16, android.support.transition.v r17) {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ChangeTransform.a(android.view.ViewGroup, android.support.transition.v, android.support.transition.v):android.animation.Animator");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.support.transition.Transition] */
    /* JADX WARN: Type inference failed for: r4v3 */
    private void b(ViewGroup viewGroup, v vVar, v vVar2) {
        g a2;
        View view = vVar2.view;
        Matrix matrix = new Matrix((Matrix) vVar2.values.get("android:changeTransform:parentMatrix"));
        ah.b(viewGroup, matrix);
        if (Build.VERSION.SDK_INT >= 21) {
            a2 = f.a(view, viewGroup, matrix);
        } else {
            a2 = e.a(view, viewGroup);
        }
        if (a2 != null) {
            a2.a((ViewGroup) vVar.values.get("android:changeTransform:parent"), vVar.view);
            ?? r4 = this;
            while (r4.Cs != null) {
                r4 = r4.Cs;
            }
            r4.a(new a(view, a2));
            if (Az) {
                if (vVar.view != vVar2.view) {
                    ah.d(vVar.view, 0.0f);
                }
                ah.d(view, 1.0f);
            }
        }
    }

    static void C(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        u.m(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        final float AJ;
        final float AK;
        final float AL;
        final float AM;
        final float AN;
        final float AO;
        final float xL;
        final float xM;

        c(View view) {
            this.AJ = view.getTranslationX();
            this.AK = view.getTranslationY();
            this.AL = u.am(view);
            this.xL = view.getScaleX();
            this.xM = view.getScaleY();
            this.AM = view.getRotationX();
            this.AN = view.getRotationY();
            this.AO = view.getRotation();
        }

        public final void D(View view) {
            ChangeTransform.a(view, this.AJ, this.AK, this.AL, this.xL, this.xM, this.AM, this.AN, this.AO);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.AJ == this.AJ && cVar.AK == this.AK && cVar.AL == this.AL && cVar.xL == this.xL && cVar.xM == this.xM && cVar.AM == this.AM && cVar.AN == this.AN && cVar.AO == this.AO) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8 = 0;
            int floatToIntBits = (this.AJ != 0.0f ? Float.floatToIntBits(this.AJ) : 0) * 31;
            if (this.AK != 0.0f) {
                i2 = Float.floatToIntBits(this.AK);
            } else {
                i2 = 0;
            }
            int i9 = (i2 + floatToIntBits) * 31;
            if (this.AL != 0.0f) {
                i3 = Float.floatToIntBits(this.AL);
            } else {
                i3 = 0;
            }
            int i10 = (i3 + i9) * 31;
            if (this.xL != 0.0f) {
                i4 = Float.floatToIntBits(this.xL);
            } else {
                i4 = 0;
            }
            int i11 = (i4 + i10) * 31;
            if (this.xM != 0.0f) {
                i5 = Float.floatToIntBits(this.xM);
            } else {
                i5 = 0;
            }
            int i12 = (i5 + i11) * 31;
            if (this.AM != 0.0f) {
                i6 = Float.floatToIntBits(this.AM);
            } else {
                i6 = 0;
            }
            int i13 = (i6 + i12) * 31;
            if (this.AN != 0.0f) {
                i7 = Float.floatToIntBits(this.AN);
            } else {
                i7 = 0;
            }
            int i14 = (i7 + i13) * 31;
            if (this.AO != 0.0f) {
                i8 = Float.floatToIntBits(this.AO);
            }
            return i14 + i8;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends r {
        private g AH;
        private View mView;

        a(View view, g gVar) {
            this.mView = view;
            this.AH = gVar;
        }

        @Override // android.support.transition.r, android.support.transition.Transition.d
        public final void a(Transition transition) {
            transition.b(this);
            View view = this.mView;
            if (Build.VERSION.SDK_INT >= 21) {
                if (!f.Bs) {
                    try {
                        f.dL();
                        Method declaredMethod = f.Bn.getDeclaredMethod("removeGhost", View.class);
                        f.Br = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e2) {
                    }
                    f.Bs = true;
                }
                if (f.Br != null) {
                    try {
                        f.Br.invoke(null, view);
                    } catch (IllegalAccessException e3) {
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException(e4.getCause());
                    }
                }
            } else {
                e.E(view);
            }
            this.mView.setTag(R.id.iv6, null);
            this.mView.setTag(R.id.g8p, null);
        }

        @Override // android.support.transition.r, android.support.transition.Transition.d
        public final void dF() {
            this.AH.setVisibility(4);
        }

        @Override // android.support.transition.r, android.support.transition.Transition.d
        public final void dG() {
            this.AH.setVisibility(0);
        }
    }

    static class b {
        final float[] AI;
        float AJ;
        float AK;
        final Matrix mMatrix = new Matrix();
        private final View mView;

        b(View view, float[] fArr) {
            this.mView = view;
            this.AI = (float[]) fArr.clone();
            this.AJ = this.AI[2];
            this.AK = this.AI[5];
            dI();
        }

        /* access modifiers changed from: package-private */
        public final void dI() {
            this.AI[2] = this.AJ;
            this.AI[5] = this.AK;
            this.mMatrix.setValues(this.AI);
            ah.c(this.mView, this.mMatrix);
        }
    }
}
