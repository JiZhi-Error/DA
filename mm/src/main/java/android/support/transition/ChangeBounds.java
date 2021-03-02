package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds extends Transition {
    private static final String[] zP = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> zQ = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        /* class android.support.transition.ChangeBounds.AnonymousClass1 */
        private Rect mBounds = new Rect();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            return new PointF((float) this.mBounds.left, (float) this.mBounds.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.mBounds);
        }
    };
    private static final Property<a, PointF> zR = new Property<a, PointF>(PointF.class, "topLeft") {
        /* class android.support.transition.ChangeBounds.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(a aVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(a aVar, PointF pointF) {
            a aVar2 = aVar;
            PointF pointF2 = pointF;
            aVar2.Al = Math.round(pointF2.x);
            aVar2.Am = Math.round(pointF2.y);
            aVar2.Ap++;
            if (aVar2.Ap == aVar2.Aq) {
                aVar2.dH();
            }
        }
    };
    private static final Property<a, PointF> zS = new Property<a, PointF>(PointF.class, "bottomRight") {
        /* class android.support.transition.ChangeBounds.AnonymousClass4 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(a aVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(a aVar, PointF pointF) {
            a aVar2 = aVar;
            PointF pointF2 = pointF;
            aVar2.An = Math.round(pointF2.x);
            aVar2.Ao = Math.round(pointF2.y);
            aVar2.Aq++;
            if (aVar2.Ap == aVar2.Aq) {
                aVar2.dH();
            }
        }
    };
    private static final Property<View, PointF> zT = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* class android.support.transition.ChangeBounds.AnonymousClass5 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            ah.b(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    };
    private static final Property<View, PointF> zU = new Property<View, PointF>(PointF.class, "topLeft") {
        /* class android.support.transition.ChangeBounds.AnonymousClass6 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            ah.b(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    };
    private static final Property<View, PointF> zV = new Property<View, PointF>(PointF.class, "position") {
        /* class android.support.transition.ChangeBounds.AnonymousClass7 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            ah.b(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    };
    private static m zZ = new m();
    private int[] zW;
    private boolean zX;
    private boolean zY;

    public ChangeBounds() {
        this.zW = new int[2];
        this.zX = false;
        this.zY = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zW = new int[2];
        this.zX = false;
        this.zY = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BT);
        boolean a2 = g.a(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.zX = a2;
    }

    @Override // android.support.transition.Transition
    public final String[] getTransitionProperties() {
        return zP;
    }

    private void c(v vVar) {
        View view = vVar.view;
        if (u.az(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            vVar.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            vVar.values.put("android:changeBounds:parent", vVar.view.getParent());
            if (this.zY) {
                vVar.view.getLocationInWindow(this.zW);
                vVar.values.put("android:changeBounds:windowX", Integer.valueOf(this.zW[0]));
                vVar.values.put("android:changeBounds:windowY", Integer.valueOf(this.zW[1]));
            }
            if (this.zX) {
                vVar.values.put("android:changeBounds:clip", u.aC(view));
            }
        }
    }

    @Override // android.support.transition.Transition
    public final void a(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final void b(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final Animator a(final ViewGroup viewGroup, v vVar, v vVar2) {
        boolean z;
        ObjectAnimator objectAnimator;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator2;
        ObjectAnimator a2;
        if (vVar == null || vVar2 == null) {
            return null;
        }
        Map<String, Object> map = vVar.values;
        Map<String, Object> map2 = vVar2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view = vVar2.view;
        if (this.zY) {
            v c2 = c(viewGroup2, true);
            if (c2 == null) {
                z = viewGroup2 == viewGroup3;
            } else {
                z = viewGroup3 == c2.view;
            }
        } else {
            z = true;
        }
        if (z) {
            Rect rect3 = (Rect) vVar.values.get("android:changeBounds:bounds");
            Rect rect4 = (Rect) vVar2.values.get("android:changeBounds:bounds");
            int i2 = rect3.left;
            final int i3 = rect4.left;
            int i4 = rect3.top;
            final int i5 = rect4.top;
            int i6 = rect3.right;
            final int i7 = rect4.right;
            int i8 = rect3.bottom;
            final int i9 = rect4.bottom;
            int i10 = i6 - i2;
            int i11 = i8 - i4;
            int i12 = i7 - i3;
            int i13 = i9 - i5;
            Rect rect5 = (Rect) vVar.values.get("android:changeBounds:clip");
            final Rect rect6 = (Rect) vVar2.values.get("android:changeBounds:clip");
            int i14 = 0;
            if (!((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0))) {
                if (!(i2 == i3 && i4 == i5)) {
                    i14 = 1;
                }
                if (!(i6 == i7 && i8 == i9)) {
                    i14++;
                }
            }
            if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                i14++;
            }
            if (i14 > 0) {
                if (!this.zX) {
                    ah.b(view, i2, i4, i6, i8);
                    if (i14 == 2) {
                        if (i10 == i12 && i11 == i13) {
                            a2 = j.a(view, zV, this.CF.getPath((float) i2, (float) i4, (float) i3, (float) i5));
                        } else {
                            final a aVar = new a(view);
                            ObjectAnimator a3 = j.a(aVar, zR, this.CF.getPath((float) i2, (float) i4, (float) i3, (float) i5));
                            ObjectAnimator a4 = j.a(aVar, zS, this.CF.getPath((float) i6, (float) i8, (float) i7, (float) i9));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a3, a4);
                            animatorSet.addListener(new AnimatorListenerAdapter() {
                                /* class android.support.transition.ChangeBounds.AnonymousClass8 */
                                private a mViewBounds = aVar;
                            });
                            a2 = animatorSet;
                        }
                    } else if (i2 == i3 && i4 == i5) {
                        a2 = j.a(view, zT, this.CF.getPath((float) i6, (float) i8, (float) i7, (float) i9));
                    } else {
                        a2 = j.a(view, zU, this.CF.getPath((float) i2, (float) i4, (float) i3, (float) i5));
                    }
                } else {
                    ah.b(view, i2, i4, Math.max(i10, i12) + i2, Math.max(i11, i13) + i4);
                    if (i2 == i3 && i4 == i5) {
                        objectAnimator = null;
                    } else {
                        objectAnimator = j.a(view, zV, this.CF.getPath((float) i2, (float) i4, (float) i3, (float) i5));
                    }
                    if (rect5 == null) {
                        rect = new Rect(0, 0, i10, i11);
                    } else {
                        rect = rect5;
                    }
                    if (rect6 == null) {
                        rect2 = new Rect(0, 0, i12, i13);
                    } else {
                        rect2 = rect6;
                    }
                    if (!rect.equals(rect2)) {
                        u.b(view, rect);
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", zZ, rect, rect2);
                        ofObject.addListener(new AnimatorListenerAdapter() {
                            /* class android.support.transition.ChangeBounds.AnonymousClass9 */
                            private boolean mIsCanceled;

                            public final void onAnimationCancel(Animator animator) {
                                this.mIsCanceled = true;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                if (!this.mIsCanceled) {
                                    u.b(view, rect6);
                                    ah.b(view, i3, i5, i7, i9);
                                }
                            }
                        });
                        objectAnimator2 = ofObject;
                    } else {
                        objectAnimator2 = null;
                    }
                    a2 = u.a(objectAnimator, objectAnimator2);
                }
                if (!(view.getParent() instanceof ViewGroup)) {
                    return a2;
                }
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ab.c(viewGroup4, true);
                a(new r() {
                    /* class android.support.transition.ChangeBounds.AnonymousClass10 */
                    boolean mCanceled = false;

                    @Override // android.support.transition.r, android.support.transition.Transition.d
                    public final void a(Transition transition) {
                        if (!this.mCanceled) {
                            ab.c(viewGroup4, false);
                        }
                        transition.b(this);
                    }

                    @Override // android.support.transition.r, android.support.transition.Transition.d
                    public final void dF() {
                        ab.c(viewGroup4, false);
                    }

                    @Override // android.support.transition.r, android.support.transition.Transition.d
                    public final void dG() {
                        ab.c(viewGroup4, true);
                    }
                });
                return a2;
            }
        } else {
            int intValue = ((Integer) vVar.values.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) vVar.values.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) vVar2.values.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) vVar2.values.get("android:changeBounds:windowY")).intValue();
            if (!(intValue == intValue3 && intValue2 == intValue4)) {
                viewGroup.getLocationInWindow(this.zW);
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                final float P = ah.P(view);
                ah.d(view, 0.0f);
                ah.N(viewGroup).add(bitmapDrawable);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, l.a(zQ, this.CF.getPath((float) (intValue - this.zW[0]), (float) (intValue2 - this.zW[1]), (float) (intValue3 - this.zW[0]), (float) (intValue4 - this.zW[1]))));
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                    /* class android.support.transition.ChangeBounds.AnonymousClass2 */

                    public final void onAnimationEnd(Animator animator) {
                        ah.N(viewGroup).remove(bitmapDrawable);
                        ah.d(view, P);
                    }
                });
                return ofPropertyValuesHolder;
            }
        }
        return null;
    }

    static class a {
        int Al;
        int Am;
        int An;
        int Ao;
        int Ap;
        int Aq;
        private View mView;

        a(View view) {
            this.mView = view;
        }

        /* access modifiers changed from: package-private */
        public final void dH() {
            ah.b(this.mView, this.Al, this.Am, this.An, this.Ao);
            this.Ap = 0;
            this.Aq = 0;
        }
    }
}
