package android.support.design.transformation;

import android.content.Context;
import android.os.Build;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.design.transformation.FabTransformationBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.R;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map<View, Integer> mR;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.design.transformation.FabTransformationBehavior
    public final FabTransformationBehavior.a h(Context context, boolean z) {
        int i2;
        if (z) {
            i2 = R.animator.p;
        } else {
            i2 = R.animator.o;
        }
        FabTransformationBehavior.a aVar = new FabTransformationBehavior.a();
        aVar.mM = h.k(context, i2);
        aVar.mN = new j();
        return aVar;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.design.transformation.ExpandableTransformationBehavior, android.support.design.transformation.ExpandableBehavior
    public final boolean a(View view, View view2, boolean z, boolean z2) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.mR = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.d) && (((CoordinatorLayout.d) childAt.getLayoutParams()).qC instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z3) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.mR.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        u.p(childAt, 4);
                    } else if (this.mR != null && this.mR.containsKey(childAt)) {
                        u.p(childAt, this.mR.get(childAt).intValue());
                    }
                }
            }
            if (!z) {
                this.mR = null;
            }
        }
        return super.a(view, view2, z, z2);
    }
}
