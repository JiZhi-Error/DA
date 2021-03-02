package android.support.transition;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.support.v4.app.n;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class d extends n {
    @Override // android.support.v4.app.n
    public final boolean i(Object obj) {
        return obj instanceof Transition;
    }

    @Override // android.support.v4.app.n
    public final Object j(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // android.support.v4.app.n
    public final Object k(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.c((Transition) obj);
        return transitionSet;
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        ArrayList<View> arrayList2 = transitionSet.Cg;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a((List<View>) arrayList2, arrayList.get(i2));
        }
        arrayList2.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).a(new Transition.c() {
                /* class android.support.transition.d.AnonymousClass1 */

                @Override // android.support.transition.Transition.c
                public final Rect dJ() {
                    return rect;
                }
            });
        }
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int size = transitionSet.CT.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(transitionSet.ap(i2), arrayList);
                }
            } else if (!b(transition) && g(transition.Cg)) {
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    transition.I(arrayList.get(i3));
                }
            }
        }
    }

    @Override // android.support.v4.app.n
    public final Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.c((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.c((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.c((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // android.support.v4.app.n
    public final void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).a(new Transition.d() {
            /* class android.support.transition.d.AnonymousClass2 */

            @Override // android.support.transition.Transition.d
            public final void dK() {
            }

            @Override // android.support.transition.Transition.d
            public final void a(Transition transition) {
                transition.b(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList.get(i2)).setVisibility(0);
                }
            }

            @Override // android.support.transition.Transition.d
            public final void dF() {
            }

            @Override // android.support.transition.Transition.d
            public final void dG() {
            }
        });
    }

    @Override // android.support.v4.app.n
    public final Object b(Object obj, Object obj2, Object obj3) {
        Transition transition = null;
        Transition transition2 = (Transition) obj;
        Transition transition3 = (Transition) obj2;
        Transition transition4 = (Transition) obj3;
        if (transition2 != null && transition3 != null) {
            transition = new TransitionSet().c(transition2).c(transition3).ao(1);
        } else if (transition2 != null) {
            transition = transition2;
        } else if (transition3 != null) {
            transition = transition3;
        }
        if (transition4 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.c(transition);
        }
        transitionSet.c(transition4);
        return transitionSet;
    }

    @Override // android.support.v4.app.n
    public final void a(ViewGroup viewGroup, Object obj) {
        s.a(viewGroup, (Transition) obj);
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).a(new Transition.d() {
            /* class android.support.transition.d.AnonymousClass3 */

            @Override // android.support.transition.Transition.d
            public final void dK() {
                if (obj2 != null) {
                    d.this.b(obj2, arrayList, (ArrayList<View>) null);
                }
                if (obj3 != null) {
                    d.this.b(obj3, arrayList2, (ArrayList<View>) null);
                }
                if (obj4 != null) {
                    d.this.b(obj4, arrayList3, (ArrayList<View>) null);
                }
            }

            @Override // android.support.transition.Transition.d
            public final void a(Transition transition) {
            }

            @Override // android.support.transition.Transition.d
            public final void dF() {
            }

            @Override // android.support.transition.Transition.d
            public final void dG() {
            }
        });
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.Cg.clear();
            transitionSet.Cg.addAll(arrayList2);
            b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // android.support.v4.app.n
    public final void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.CT.size();
            for (int i2 = 0; i2 < size; i2++) {
                b((Object) transitionSet.ap(i2), arrayList, arrayList2);
            }
        } else if (!b(transition)) {
            ArrayList<View> arrayList3 = transition.Cg;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    transition.I(arrayList2.get(i3));
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    transition.J(arrayList.get(size3));
                }
            }
        }
    }

    @Override // android.support.v4.app.n
    public final void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).I(view);
        }
    }

    @Override // android.support.v4.app.n
    public final void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).J(view);
        }
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).a(new Transition.c() {
                /* class android.support.transition.d.AnonymousClass4 */

                @Override // android.support.transition.Transition.c
                public final Rect dJ() {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    private static boolean b(Transition transition) {
        return !g(transition.Cf) || !g(transition.Ch) || !g(transition.Ci);
    }
}
