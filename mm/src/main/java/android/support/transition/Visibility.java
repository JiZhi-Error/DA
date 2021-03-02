package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.transition.Transition;
import android.support.transition.a;
import android.support.v4.content.a.g;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility extends Transition {
    private static final String[] zP = {"android:visibility:visibility", "android:visibility:parent"};
    int mMode = 3;

    /* access modifiers changed from: package-private */
    public static class b {
        ViewGroup Bf;
        boolean Eh;
        boolean Ei;
        int Ej;
        int Ek;
        ViewGroup El;

        b() {
        }
    }

    public Visibility() {
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BU);
        int a2 = g.a(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (a2 != 0) {
            setMode(a2);
        }
    }

    public final void setMode(int i2) {
        if ((i2 & -4) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i2;
    }

    @Override // android.support.transition.Transition
    public final String[] getTransitionProperties() {
        return zP;
    }

    private static void c(v vVar) {
        vVar.values.put("android:visibility:visibility", Integer.valueOf(vVar.view.getVisibility()));
        vVar.values.put("android:visibility:parent", vVar.view.getParent());
        int[] iArr = new int[2];
        vVar.view.getLocationOnScreen(iArr);
        vVar.values.put("android:visibility:screenLocation", iArr);
    }

    @Override // android.support.transition.Transition
    public void a(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public void b(v vVar) {
        c(vVar);
    }

    private static b b(v vVar, v vVar2) {
        b bVar = new b();
        bVar.Eh = false;
        bVar.Ei = false;
        if (vVar == null || !vVar.values.containsKey("android:visibility:visibility")) {
            bVar.Ej = -1;
            bVar.Bf = null;
        } else {
            bVar.Ej = ((Integer) vVar.values.get("android:visibility:visibility")).intValue();
            bVar.Bf = (ViewGroup) vVar.values.get("android:visibility:parent");
        }
        if (vVar2 == null || !vVar2.values.containsKey("android:visibility:visibility")) {
            bVar.Ek = -1;
            bVar.El = null;
        } else {
            bVar.Ek = ((Integer) vVar2.values.get("android:visibility:visibility")).intValue();
            bVar.El = (ViewGroup) vVar2.values.get("android:visibility:parent");
        }
        if (vVar == null || vVar2 == null) {
            if (vVar == null && bVar.Ek == 0) {
                bVar.Ei = true;
                bVar.Eh = true;
            } else if (vVar2 == null && bVar.Ej == 0) {
                bVar.Ei = false;
                bVar.Eh = true;
            }
        } else if (bVar.Ej == bVar.Ek && bVar.Bf == bVar.El) {
            return bVar;
        } else {
            if (bVar.Ej != bVar.Ek) {
                if (bVar.Ej == 0) {
                    bVar.Ei = false;
                    bVar.Eh = true;
                } else if (bVar.Ek == 0) {
                    bVar.Ei = true;
                    bVar.Eh = true;
                }
            } else if (bVar.El == null) {
                bVar.Ei = false;
                bVar.Eh = true;
            } else if (bVar.Bf == null) {
                bVar.Ei = true;
                bVar.Eh = true;
            }
        }
        return bVar;
    }

    @Override // android.support.transition.Transition
    public final Animator a(ViewGroup viewGroup, v vVar, v vVar2) {
        View view;
        View view2;
        final aa aaVar;
        View view3;
        int id;
        b b2 = b(vVar, vVar2);
        if (!b2.Eh) {
            return null;
        }
        if (b2.Bf == null && b2.El == null) {
            return null;
        }
        if (!b2.Ei) {
            int i2 = b2.Ek;
            if ((this.mMode & 2) != 2) {
                return null;
            }
            final View view4 = vVar != null ? vVar.view : null;
            if (vVar2 != null) {
                view = vVar2.view;
            } else {
                view = null;
            }
            if (view == null || view.getParent() == null) {
                if (view != null) {
                    view2 = null;
                    view4 = view;
                } else {
                    if (view4 != null) {
                        if (view4.getParent() == null) {
                            view2 = null;
                        } else if (view4.getParent() instanceof View) {
                            View view5 = (View) view4.getParent();
                            if (!b(b(view5, true), c(view5, true)).Eh) {
                                view4 = u.a(viewGroup, view4, view5);
                                view2 = null;
                            } else {
                                if (view5.getParent() != null || (id = view5.getId()) == -1 || viewGroup.findViewById(id) == null || !this.Cx) {
                                    view3 = null;
                                } else {
                                    view3 = view4;
                                }
                                view2 = null;
                                view4 = view3;
                            }
                        }
                    }
                    view2 = null;
                    view4 = null;
                }
            } else if (i2 == 4) {
                view2 = view;
                view4 = null;
            } else if (view4 == view) {
                view2 = view;
                view4 = null;
            } else if (this.Cx) {
                view2 = null;
            } else {
                view4 = u.a(viewGroup, view4, (View) view4.getParent());
                view2 = null;
            }
            if (view4 != null && vVar != null) {
                int[] iArr = (int[]) vVar.values.get("android:visibility:screenLocation");
                int i3 = iArr[0];
                int i4 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view4.offsetLeftAndRight((i3 - iArr2[0]) - view4.getLeft());
                view4.offsetTopAndBottom((i4 - iArr2[1]) - view4.getTop());
                if (Build.VERSION.SDK_INT >= 18) {
                    aaVar = new z(viewGroup);
                } else {
                    aaVar = (y) ae.M(viewGroup);
                }
                aaVar.add(view4);
                Animator a2 = a(viewGroup, view4, vVar);
                if (a2 == null) {
                    aaVar.remove(view4);
                    return a2;
                }
                a2.addListener(new AnimatorListenerAdapter() {
                    /* class android.support.transition.Visibility.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        aaVar.remove(view4);
                    }
                });
                return a2;
            } else if (view2 == null) {
                return null;
            } else {
                int visibility = view2.getVisibility();
                ah.m(view2, 0);
                Animator a3 = a(viewGroup, view2, vVar);
                if (a3 != null) {
                    a aVar = new a(view2, i2);
                    a3.addListener(aVar);
                    a.a(a3, aVar);
                    a(aVar);
                    return a3;
                }
                ah.m(view2, visibility);
                return a3;
            }
        } else if ((this.mMode & 1) != 1 || vVar2 == null) {
            return null;
        } else {
            if (vVar == null) {
                View view6 = (View) vVar2.view.getParent();
                if (b(c(view6, false), b(view6, false)).Eh) {
                    return null;
                }
            }
            return a(viewGroup, vVar2.view, vVar, vVar2);
        }
    }

    public Animator a(ViewGroup viewGroup, View view, v vVar, v vVar2) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, View view, v vVar) {
        return null;
    }

    @Override // android.support.transition.Transition
    public final boolean a(v vVar, v vVar2) {
        if (vVar == null && vVar2 == null) {
            return false;
        }
        if (vVar != null && vVar2 != null && vVar2.values.containsKey("android:visibility:visibility") != vVar.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(vVar, vVar2);
        if (!b2.Eh) {
            return false;
        }
        if (b2.Ej == 0 || b2.Ek == 0) {
            return true;
        }
        return false;
    }

    static class a extends AnimatorListenerAdapter implements Transition.d, a.AbstractC0014a {
        private final int Ed;
        private final ViewGroup Ee;
        private final boolean Ef;
        private boolean Eg;
        boolean mCanceled = false;
        private final View mView;

        a(View view, int i2) {
            this.mView = view;
            this.Ed = i2;
            this.Ee = (ViewGroup) view.getParent();
            this.Ef = true;
            suppressLayout(true);
        }

        @Override // android.support.transition.a.AbstractC0014a
        public final void onAnimationPause(Animator animator) {
            if (!this.mCanceled) {
                ah.m(this.mView, this.Ed);
            }
        }

        @Override // android.support.transition.a.AbstractC0014a
        public final void onAnimationResume(Animator animator) {
            if (!this.mCanceled) {
                ah.m(this.mView, 0);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            dU();
        }

        @Override // android.support.transition.Transition.d
        public final void dK() {
        }

        @Override // android.support.transition.Transition.d
        public final void a(Transition transition) {
            dU();
            transition.b(this);
        }

        @Override // android.support.transition.Transition.d
        public final void dF() {
            suppressLayout(false);
        }

        @Override // android.support.transition.Transition.d
        public final void dG() {
            suppressLayout(true);
        }

        private void dU() {
            if (!this.mCanceled) {
                ah.m(this.mView, this.Ed);
                if (this.Ee != null) {
                    this.Ee.invalidate();
                }
            }
            suppressLayout(false);
        }

        private void suppressLayout(boolean z) {
            if (this.Ef && this.Eg != z && this.Ee != null) {
                this.Eg = z;
                ab.c(this.Ee, z);
            }
        }
    }
}
