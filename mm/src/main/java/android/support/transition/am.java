package android.support.transition;

import android.view.View;

public abstract class am extends t {
    private static final String[] Em = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // android.support.transition.t
    public final void c(v vVar) {
        View view = vVar.view;
        Integer num = (Integer) vVar.values.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        vVar.values.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = (view.getHeight() / 2) + iArr[1];
        vVar.values.put("android:visibilityPropagation:center", iArr);
    }

    @Override // android.support.transition.t
    public final String[] getPropagationProperties() {
        return Em;
    }

    public static int e(v vVar) {
        if (vVar == null) {
            return 8;
        }
        Integer num = (Integer) vVar.values.get("android:visibilityPropagation:visibility");
        if (num == null) {
            return 8;
        }
        return num.intValue();
    }

    static int a(v vVar, int i2) {
        if (vVar == null) {
            return -1;
        }
        int[] iArr = (int[]) vVar.values.get("android:visibilityPropagation:center");
        if (iArr == null) {
            return -1;
        }
        return iArr[i2];
    }
}
