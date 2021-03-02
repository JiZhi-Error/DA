package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.b;
import android.support.v4.e.i;
import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class l {
    private static final int[] Gi = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final n Gj = (Build.VERSION.SDK_INT >= 21 ? new m() : null);
    private static final n Gk = eo();

    private static n eo() {
        try {
            return (n) Class.forName("android.support.transition.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    static void a(FragmentManagerImpl fragmentManagerImpl, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z) {
        Object obj;
        final Object obj2;
        final Object a2;
        final Rect rect;
        Object obj3;
        Object a3;
        final Rect rect2;
        final View view;
        if (fragmentManagerImpl.mCurState > 0) {
            SparseArray sparseArray = new SparseArray();
            for (int i4 = i2; i4 < i3; i4++) {
                b bVar = arrayList.get(i4);
                if (arrayList2.get(i4).booleanValue()) {
                    b(bVar, sparseArray, z);
                } else {
                    a(bVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                final View view2 = new View(fragmentManagerImpl.mHost.mContext);
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    final android.support.v4.e.a<String, String> a4 = a(keyAt, arrayList, arrayList2, i2, i3);
                    final a aVar = (a) sparseArray.valueAt(i5);
                    if (z) {
                        ViewGroup viewGroup = fragmentManagerImpl.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(keyAt) : null;
                        if (viewGroup != null) {
                            Fragment fragment = aVar.Gx;
                            Fragment fragment2 = aVar.GA;
                            final n a5 = a(fragment2, fragment);
                            if (a5 != null) {
                                boolean z2 = aVar.Gy;
                                boolean z3 = aVar.GB;
                                ArrayList<View> arrayList3 = new ArrayList<>();
                                ArrayList<View> arrayList4 = new ArrayList<>();
                                Object a6 = a(a5, fragment, z2);
                                Object b2 = b(a5, fragment2, z3);
                                final Fragment fragment3 = aVar.Gx;
                                final Fragment fragment4 = aVar.GA;
                                if (fragment3 != null) {
                                    fragment3.getView().setVisibility(0);
                                }
                                if (fragment3 == null || fragment4 == null) {
                                    obj3 = null;
                                } else {
                                    final boolean z4 = aVar.Gy;
                                    if (a4.isEmpty()) {
                                        a3 = null;
                                    } else {
                                        a3 = a(a5, fragment3, fragment4, z4);
                                    }
                                    android.support.v4.e.a<String, View> a7 = a(a5, a4, a3, aVar);
                                    final android.support.v4.e.a<String, View> b3 = b(a5, a4, a3, aVar);
                                    if (a4.isEmpty()) {
                                        a3 = null;
                                        if (a7 != null) {
                                            a7.clear();
                                        }
                                        if (b3 != null) {
                                            b3.clear();
                                        }
                                    } else {
                                        a(arrayList4, a7, a4.keySet());
                                        a(arrayList3, b3, a4.values());
                                    }
                                    if (a6 == null && b2 == null && a3 == null) {
                                        obj3 = null;
                                    } else {
                                        a(fragment3, fragment4, z4, a7);
                                        if (a3 != null) {
                                            arrayList3.add(view2);
                                            a5.a(a3, view2, arrayList4);
                                            a(a5, a3, b2, a7, aVar.GB, aVar.GC);
                                            rect2 = new Rect();
                                            view = a(b3, aVar, a6, z4);
                                            if (view != null) {
                                                a5.a(a6, rect2);
                                            }
                                        } else {
                                            rect2 = null;
                                            view = null;
                                        }
                                        w.a(viewGroup, new Runnable() {
                                            /* class android.support.v4.app.l.AnonymousClass3 */

                                            public final void run() {
                                                l.a(fragment3, fragment4, z4, b3);
                                                if (view != null) {
                                                    n.a(view, rect2);
                                                }
                                            }
                                        });
                                        obj3 = a3;
                                    }
                                }
                                if (a6 != null || obj3 != null || b2 != null) {
                                    final ArrayList<View> a8 = a(a5, b2, fragment2, arrayList4, view2);
                                    ArrayList<View> a9 = a(a5, a6, fragment, arrayList3, view2);
                                    a(a9, 4);
                                    Object a10 = a(a5, a6, b2, obj3, fragment, z2);
                                    if (a10 != null) {
                                        if (fragment2 != null && b2 != null && fragment2.mAdded && fragment2.mHidden && fragment2.mHiddenChanged) {
                                            fragment2.setHideReplaced(true);
                                            a5.b(b2, fragment2.getView(), a8);
                                            w.a(fragment2.mContainer, new Runnable() {
                                                /* class android.support.v4.app.l.AnonymousClass1 */

                                                public final void run() {
                                                    l.a(a8, 4);
                                                }
                                            });
                                        }
                                        ArrayList<String> c2 = n.c(arrayList3);
                                        a5.a(a10, a6, a9, b2, a8, obj3, arrayList3);
                                        a5.a(viewGroup, a10);
                                        a5.a(viewGroup, arrayList4, arrayList3, c2, a4);
                                        a(a9, 0);
                                        a5.a(obj3, arrayList4, arrayList3);
                                    }
                                }
                            }
                        }
                    } else {
                        ViewGroup viewGroup2 = fragmentManagerImpl.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(keyAt) : null;
                        if (viewGroup2 != null) {
                            final Fragment fragment5 = aVar.Gx;
                            Fragment fragment6 = aVar.GA;
                            final n a11 = a(fragment6, fragment5);
                            if (a11 != null) {
                                boolean z5 = aVar.Gy;
                                boolean z6 = aVar.GB;
                                final Object a12 = a(a11, fragment5, z5);
                                Object b4 = b(a11, fragment6, z6);
                                final ArrayList<View> arrayList5 = new ArrayList<>();
                                final ArrayList<View> arrayList6 = new ArrayList<>();
                                final Fragment fragment7 = aVar.Gx;
                                final Fragment fragment8 = aVar.GA;
                                if (fragment7 == null || fragment8 == null) {
                                    obj = null;
                                } else {
                                    final boolean z7 = aVar.Gy;
                                    if (a4.isEmpty()) {
                                        a2 = null;
                                    } else {
                                        a2 = a(a11, fragment7, fragment8, z7);
                                    }
                                    android.support.v4.e.a<String, View> a13 = a(a11, a4, a2, aVar);
                                    if (a4.isEmpty()) {
                                        a2 = null;
                                    } else {
                                        arrayList5.addAll(a13.values());
                                    }
                                    if (a12 == null && b4 == null && a2 == null) {
                                        obj = null;
                                    } else {
                                        a(fragment7, fragment8, z7, a13);
                                        if (a2 != null) {
                                            rect = new Rect();
                                            a11.a(a2, view2, arrayList5);
                                            a(a11, a2, b4, a13, aVar.GB, aVar.GC);
                                            if (a12 != null) {
                                                a11.a(a12, rect);
                                            }
                                        } else {
                                            rect = null;
                                        }
                                        w.a(viewGroup2, new Runnable() {
                                            /* class android.support.v4.app.l.AnonymousClass4 */

                                            public final void run() {
                                                android.support.v4.e.a<String, View> b2 = l.b(a11, a4, a2, aVar);
                                                if (b2 != null) {
                                                    arrayList6.addAll(b2.values());
                                                    arrayList6.add(view2);
                                                }
                                                l.a(fragment7, fragment8, z7, b2);
                                                if (a2 != null) {
                                                    a11.a(a2, arrayList5, arrayList6);
                                                    View a2 = l.a(b2, aVar, a12, z7);
                                                    if (a2 != null) {
                                                        n.a(a2, rect);
                                                    }
                                                }
                                            }
                                        });
                                        obj = a2;
                                    }
                                }
                                if (a12 != null || obj != null || b4 != null) {
                                    final ArrayList<View> a14 = a(a11, b4, fragment6, arrayList5, view2);
                                    if (a14 == null || a14.isEmpty()) {
                                        obj2 = null;
                                    } else {
                                        obj2 = b4;
                                    }
                                    a11.b(a12, view2);
                                    Object a15 = a(a11, a12, obj2, obj, fragment5, aVar.Gy);
                                    if (a15 != null) {
                                        final ArrayList<View> arrayList7 = new ArrayList<>();
                                        a11.a(a15, a12, arrayList7, obj2, a14, obj, arrayList6);
                                        w.a(viewGroup2, new Runnable() {
                                            /* class android.support.v4.app.l.AnonymousClass2 */

                                            public final void run() {
                                                if (a12 != null) {
                                                    a11.c(a12, view2);
                                                    arrayList7.addAll(l.a(a11, a12, fragment5, arrayList6, view2));
                                                }
                                                if (a14 != null) {
                                                    if (obj2 != null) {
                                                        ArrayList<View> arrayList = new ArrayList<>();
                                                        arrayList.add(view2);
                                                        a11.b(obj2, a14, arrayList);
                                                    }
                                                    a14.clear();
                                                    a14.add(view2);
                                                }
                                            }
                                        });
                                        w.a(viewGroup2, new Runnable(arrayList6, a4) {
                                            /* class android.support.v4.app.n.AnonymousClass2 */
                                            final /* synthetic */ ArrayList Be;
                                            final /* synthetic */ Map GI;

                                            {
                                                this.Be = r2;
                                                this.GI = r3;
                                            }

                                            public final void run() {
                                                String str;
                                                int size = this.Be.size();
                                                for (int i2 = 0; i2 < size; i2++) {
                                                    View view = (View) this.Be.get(i2);
                                                    String an = u.an(view);
                                                    if (an != null) {
                                                        Iterator it = this.GI.entrySet().iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                str = null;
                                                                break;
                                                            }
                                                            Map.Entry entry = (Map.Entry) it.next();
                                                            if (an.equals(entry.getValue())) {
                                                                str = (String) entry.getKey();
                                                                break;
                                                            }
                                                        }
                                                        u.a(view, str);
                                                    }
                                                }
                                            }
                                        });
                                        a11.a(viewGroup2, a15);
                                        w.a(viewGroup2, new Runnable(arrayList6, a4) {
                                            /* class android.support.v4.app.n.AnonymousClass3 */
                                            final /* synthetic */ ArrayList Be;
                                            final /* synthetic */ Map GI;

                                            {
                                                this.Be = r2;
                                                this.GI = r3;
                                            }

                                            public final void run() {
                                                int size = this.Be.size();
                                                for (int i2 = 0; i2 < size; i2++) {
                                                    View view = (View) this.Be.get(i2);
                                                    u.a(view, (String) this.GI.get(u.an(view)));
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static android.support.v4.e.a<String, String> a(int i2, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        android.support.v4.e.a<String, String> aVar = new android.support.v4.e.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            b bVar = arrayList.get(i5);
            if (bVar.ar(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                if (bVar.ET != null) {
                    int size = bVar.ET.size();
                    if (booleanValue) {
                        arrayList3 = bVar.ET;
                        arrayList4 = bVar.EU;
                    } else {
                        ArrayList<String> arrayList5 = bVar.ET;
                        arrayList3 = bVar.EU;
                        arrayList4 = arrayList5;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static n a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (Gj != null && a(Gj, arrayList)) {
            return Gj;
        }
        if (Gk != null && a(Gk, arrayList)) {
            return Gk;
        }
        if (Gj == null && Gk == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(n nVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!nVar.i(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(n nVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return nVar.k(nVar.j(sharedElementEnterTransition));
    }

    private static Object a(n nVar, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return nVar.j(enterTransition);
    }

    private static Object b(n nVar, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return nVar.j(exitTransition);
    }

    private static void a(ArrayList<View> arrayList, android.support.v4.e.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View valueAt = aVar.valueAt(size);
            if (collection.contains(u.an(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    private static android.support.v4.e.a<String, View> a(n nVar, android.support.v4.e.a<String, String> aVar, Object obj, a aVar2) {
        z exitTransitionCallback;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = aVar2.GA;
        android.support.v4.e.a<String, View> aVar3 = new android.support.v4.e.a<>();
        nVar.a((Map<String, View>) aVar3, fragment.getView());
        b bVar = aVar2.GC;
        if (aVar2.GB) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = bVar.EU;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = bVar.ET;
        }
        i.a(aVar3, arrayList);
        if (exitTransitionCallback != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(u.an(view))) {
                    aVar.put(u.an(view), aVar.remove(str));
                }
            }
        } else {
            i.a(aVar, aVar3.keySet());
        }
        return aVar3;
    }

    static android.support.v4.e.a<String, View> b(n nVar, android.support.v4.e.a<String, String> aVar, Object obj, a aVar2) {
        z enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = aVar2.Gx;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        android.support.v4.e.a<String, View> aVar3 = new android.support.v4.e.a<>();
        nVar.a((Map<String, View>) aVar3, view);
        b bVar = aVar2.Gz;
        if (aVar2.Gy) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = bVar.ET;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = bVar.EU;
        }
        if (arrayList != null) {
            i.a(aVar3, arrayList);
            i.a(aVar3, aVar.values());
        }
        if (enterTransitionCallback != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = aVar3.get(str);
                if (view2 == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(u.an(view2)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, u.an(view2));
                }
            }
        } else {
            for (int size2 = aVar.size() - 1; size2 >= 0; size2--) {
                if (!aVar3.containsKey(aVar.valueAt(size2))) {
                    aVar.removeAt(size2);
                }
            }
        }
        return aVar3;
    }

    private static String a(android.support.v4.e.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(aVar.valueAt(i2))) {
                return aVar.keyAt(i2);
            }
        }
        return null;
    }

    static View a(android.support.v4.e.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        String str;
        b bVar = aVar2.Gz;
        if (obj == null || aVar == null || bVar.ET == null || bVar.ET.isEmpty()) {
            return null;
        }
        if (z) {
            str = bVar.ET.get(0);
        } else {
            str = bVar.EU.get(0);
        }
        return aVar.get(str);
    }

    private static void a(n nVar, Object obj, Object obj2, android.support.v4.e.a<String, View> aVar, boolean z, b bVar) {
        String str;
        if (bVar.ET != null && !bVar.ET.isEmpty()) {
            if (z) {
                str = bVar.EU.get(0);
            } else {
                str = bVar.ET.get(0);
            }
            View view = aVar.get(str);
            nVar.a(obj, view);
            if (obj2 != null) {
                nVar.a(obj2, view);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, android.support.v4.e.a<String, View> aVar) {
        z enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.keyAt(i2));
                arrayList.add(aVar.valueAt(i2));
            }
        }
    }

    static ArrayList<View> a(n nVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                nVar.a(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                nVar.a(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    private static Object a(n nVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || fragment == null)) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return nVar.a(obj2, obj, obj3);
        }
        return nVar.b(obj2, obj, obj3);
    }

    private static void a(b bVar, SparseArray<a> sparseArray, boolean z) {
        int size = bVar.EF.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(bVar, bVar.EF.get(i2), sparseArray, false, z);
        }
    }

    private static void b(b bVar, SparseArray<a> sparseArray, boolean z) {
        if (bVar.EE.mContainer.onHasView()) {
            for (int size = bVar.EF.size() - 1; size >= 0; size--) {
                a(bVar, bVar.EF.get(size), sparseArray, true, z);
            }
        }
    }

    private static void a(b bVar, b.a aVar, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        a aVar2;
        a aVar3;
        Fragment fragment = aVar.fragment;
        if (fragment != null && (i2 = fragment.mContainerId) != 0) {
            switch (z ? Gi[aVar.EX] : aVar.EX) {
                case 1:
                case 7:
                    if (z2) {
                        z9 = fragment.mIsNewlyAdded;
                    } else {
                        z9 = !fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z9;
                    break;
                case 2:
                default:
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    z7 = false;
                    break;
                case 3:
                case 6:
                    if (z2) {
                        z3 = !fragment.mAdded && fragment.mView != null && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f;
                    } else {
                        z3 = fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = false;
                    z5 = z3;
                    z6 = true;
                    z7 = false;
                    break;
                case 4:
                    if (z2) {
                        z8 = fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden;
                    } else {
                        z8 = fragment.mAdded && !fragment.mHidden;
                    }
                    z4 = false;
                    z5 = z8;
                    z6 = true;
                    z7 = false;
                    break;
                case 5:
                    if (z2) {
                        z10 = fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded;
                    } else {
                        z10 = fragment.mHidden;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z10;
                    break;
            }
            a aVar4 = sparseArray.get(i2);
            if (z7) {
                aVar2 = a(aVar4, sparseArray, i2);
                aVar2.Gx = fragment;
                aVar2.Gy = z;
                aVar2.Gz = bVar;
            } else {
                aVar2 = aVar4;
            }
            if (!z2 && z4) {
                if (aVar2 != null && aVar2.GA == fragment) {
                    aVar2.GA = null;
                }
                FragmentManagerImpl fragmentManagerImpl = bVar.EE;
                if (fragment.mState <= 0 && fragmentManagerImpl.mCurState > 0 && !bVar.EV) {
                    fragmentManagerImpl.makeActive(fragment);
                    fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
                }
            }
            if (!z5 || !(aVar2 == null || aVar2.GA == null)) {
                aVar3 = aVar2;
            } else {
                aVar3 = a(aVar2, sparseArray, i2);
                aVar3.GA = fragment;
                aVar3.GB = z;
                aVar3.GC = bVar;
            }
            if (!z2 && z6 && aVar3 != null && aVar3.Gx == fragment) {
                aVar3.Gx = null;
            }
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i2) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i2, aVar2);
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public Fragment GA;
        public boolean GB;
        public b GC;
        public Fragment Gx;
        public boolean Gy;
        public b Gz;

        a() {
        }
    }
}
