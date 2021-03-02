package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.e.n;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private final n<String, i> gX = new n<>();

    private void a(String str, i iVar) {
        this.gX.put(str, iVar);
    }

    public final long getTotalDuration() {
        long j2 = 0;
        int size = this.gX.size();
        for (int i2 = 0; i2 < size; i2++) {
            i valueAt = this.gX.valueAt(i2);
            j2 = Math.max(j2, valueAt.gY + valueAt.duration);
        }
        return j2;
    }

    public static h a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return k(context, resourceId);
    }

    public static h k(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return c(arrayList);
        } catch (Exception e2) {
            new StringBuilder("Can't load animation resource ID #0x").append(Integer.toHexString(i2));
            return null;
        }
    }

    private static h c(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(hVar, list.get(i2));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: ".concat(String.valueOf(animator)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.gX.equals(((h) obj).gX);
    }

    public final int hashCode() {
        return this.gX.hashCode();
    }

    public final String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.gX + "}\n";
    }

    public final i j(String str) {
        boolean z;
        if (this.gX.get(str) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.gX.get(str);
        }
        throw new IllegalArgumentException();
    }
}
