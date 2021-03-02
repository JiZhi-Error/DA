package android.support.v7.widget.a;

import android.os.Build;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.R;

/* access modifiers changed from: package-private */
public final class c implements b {
    static final b aAU = new c();

    c() {
    }

    @Override // android.support.v7.widget.a.b
    public final void a(RecyclerView recyclerView, View view, float f2, float f3, boolean z) {
        float f4;
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.e41) == null) {
            Float valueOf = Float.valueOf(u.al(view));
            int childCount = recyclerView.getChildCount();
            float f5 = 0.0f;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    f4 = u.al(childAt);
                    if (f4 > f5) {
                        i2++;
                        f5 = f4;
                    }
                }
                f4 = f5;
                i2++;
                f5 = f4;
            }
            u.l(view, 1.0f + f5);
            view.setTag(R.id.e41, valueOf);
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }

    @Override // android.support.v7.widget.a.b
    public final void bU(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.e41);
            if (tag != null && (tag instanceof Float)) {
                u.l(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.e41, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
