package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

/* access modifiers changed from: package-private */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i2) {
        int i3;
        int i4;
        ChainHead[] chainHeadArr;
        if (i2 == 0) {
            i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i3 = 2;
            i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4) || !Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i2, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i2, i3, chainHead);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:175:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x03de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r21, android.support.constraint.solver.LinearSystem r22, int r23, int r24, android.support.constraint.solver.widgets.ChainHead r25) {
        /*
        // Method dump skipped, instructions count: 1317
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
