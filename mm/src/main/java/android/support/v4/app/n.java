package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class n {
    public abstract Object a(Object obj, Object obj2, Object obj3);

    public abstract void a(ViewGroup viewGroup, Object obj);

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void c(Object obj, View view);

    public abstract boolean i(Object obj);

    public abstract Object j(Object obj);

    public abstract Object k(Object obj);

    protected static void a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    static ArrayList<String> c(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            arrayList2.add(u.an(view));
            u.a(view, (String) null);
        }
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            String an = u.an(view2);
            arrayList4.add(an);
            if (an != null) {
                u.a(view2, (String) null);
                String str = map.get(an);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i3))) {
                        u.a(arrayList2.get(i3), an);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        w.a(view, new Runnable() {
            /* class android.support.v4.app.n.AnonymousClass1 */

            public final void run() {
                for (int i2 = 0; i2 < size; i2++) {
                    u.a((View) arrayList2.get(i2), (String) arrayList3.get(i2));
                    u.a((View) arrayList.get(i2), (String) arrayList4.get(i2));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(ArrayList<View> arrayList, View view) {
        boolean z;
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (Build.VERSION.SDK_INT >= 21) {
                z = viewGroup.isTransitionGroup();
            } else {
                Boolean bool = (Boolean) viewGroup.getTag(R.id.ihd);
                z = ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && u.an(viewGroup) == null) ? false : true;
            }
            if (z) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                a(arrayList, viewGroup.getChildAt(i2));
            }
            return;
        }
        arrayList.add(view);
    }

    /* access modifiers changed from: package-private */
    public final void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String an = u.an(view);
            if (an != null) {
                map.put(an, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    protected static void a(List<View> list, View view) {
        int size = list.size();
        if (!a(list, view, size)) {
            list.add(view);
            for (int i2 = size; i2 < list.size(); i2++) {
                View view2 = list.get(i2);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (!a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(List list) {
        return list == null || list.isEmpty();
    }
}
