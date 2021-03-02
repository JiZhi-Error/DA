package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

final class m extends n {
    m() {
    }

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
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(targets, arrayList.get(i2));
        }
        targets.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                /* class android.support.v4.app.m.AnonymousClass1 */

                public final Rect onGetEpicenter(Transition transition) {
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
                int transitionCount = transitionSet.getTransitionCount();
                for (int i2 = 0; i2 < transitionCount; i2++) {
                    a(transitionSet.getTransitionAt(i2), arrayList);
                }
            } else if (!a(transition) && g(transition.getTargets())) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    transition.addTarget(arrayList.get(i3));
                }
            }
        }
    }

    private static boolean a(Transition transition) {
        return !g(transition.getTargetIds()) || !g(transition.getTargetNames()) || !g(transition.getTargetTypes());
    }

    @Override // android.support.v4.app.n
    public final Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // android.support.v4.app.n
    public final void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() {
            /* class android.support.v4.app.m.AnonymousClass2 */

            public final void onTransitionStart(Transition transition) {
            }

            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList.get(i2)).setVisibility(0);
                }
            }

            public final void onTransitionCancel(Transition transition) {
            }

            public final void onTransitionPause(Transition transition) {
            }

            public final void onTransitionResume(Transition transition) {
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
            transition = new TransitionSet().addTransition(transition2).addTransition(transition3).setOrdering(1);
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
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition4);
        return transitionSet;
    }

    @Override // android.support.v4.app.n
    public final void a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new Transition.TransitionListener() {
            /* class android.support.v4.app.m.AnonymousClass3 */

            public final void onTransitionStart(Transition transition) {
                if (obj2 != null) {
                    m.this.b(obj2, arrayList, (ArrayList<View>) null);
                }
                if (obj3 != null) {
                    m.this.b(obj3, arrayList2, (ArrayList<View>) null);
                }
                if (obj4 != null) {
                    m.this.b(obj4, arrayList3, (ArrayList<View>) null);
                }
            }

            public final void onTransitionEnd(Transition transition) {
            }

            public final void onTransitionCancel(Transition transition) {
            }

            public final void onTransitionPause(Transition transition) {
            }

            public final void onTransitionResume(Transition transition) {
            }
        });
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // android.support.v4.app.n
    public final void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i2 = 0; i2 < transitionCount; i2++) {
                b((Object) transitionSet.getTransitionAt(i2), arrayList, arrayList2);
            }
        } else if (!a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                transition.addTarget(arrayList2.get(i3));
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // android.support.v4.app.n
    public final void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // android.support.v4.app.n
    public final void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // android.support.v4.app.n
    public final void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                /* class android.support.v4.app.m.AnonymousClass4 */

                public final Rect onGetEpicenter(Transition transition) {
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
