package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintWidgetGroup {
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions = {this.mGroupWidth, this.mGroupHeight};
    int mGroupHeight = -1;
    int mGroupWidth = -1;
    public boolean mSkipSolver = false;
    List<ConstraintWidget> mStartHorizontalWidgets = new ArrayList();
    List<ConstraintWidget> mStartVerticalWidgets = new ArrayList();
    List<ConstraintWidget> mUnresolvedWidgets = new ArrayList();
    HashSet<ConstraintWidget> mWidgetsToSetHorizontal = new HashSet<>();
    HashSet<ConstraintWidget> mWidgetsToSetVertical = new HashSet<>();
    List<ConstraintWidget> mWidgetsToSolve = new ArrayList();

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.mConstrainedGroup = list;
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }

    public List<ConstraintWidget> getStartWidgets(int i2) {
        if (i2 == 0) {
            return this.mStartHorizontalWidgets;
        }
        if (i2 == 1) {
            return this.mStartVerticalWidgets;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Set<ConstraintWidget> getWidgetsToSet(int i2) {
        if (i2 == 0) {
            return this.mWidgetsToSetHorizontal;
        }
        if (i2 == 1) {
            return this.mWidgetsToSetVertical;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void addWidgetsToSet(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            this.mWidgetsToSetHorizontal.add(constraintWidget);
        } else if (i2 == 1) {
            this.mWidgetsToSetVertical.add(constraintWidget);
        }
    }

    /* access modifiers changed from: package-private */
    public List<ConstraintWidget> getWidgetsToSolve() {
        if (!this.mWidgetsToSolve.isEmpty()) {
            return this.mWidgetsToSolve;
        }
        int size = this.mConstrainedGroup.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i2);
            if (!constraintWidget.mOptimizerMeasurable) {
                getWidgetsToSolveTraversal((ArrayList) this.mWidgetsToSolve, constraintWidget);
            }
        }
        this.mUnresolvedWidgets.clear();
        this.mUnresolvedWidgets.addAll(this.mConstrainedGroup);
        this.mUnresolvedWidgets.removeAll(this.mWidgetsToSolve);
        return this.mWidgetsToSolve;
    }

    private void getWidgetsToSolveTraversal(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (!constraintWidget.mGroupsToSolver) {
            arrayList.add(constraintWidget);
            constraintWidget.mGroupsToSolver = true;
            if (!constraintWidget.isFullyResolved()) {
                if (constraintWidget instanceof Helper) {
                    Helper helper = (Helper) constraintWidget;
                    int i2 = helper.mWidgetsCount;
                    for (int i3 = 0; i3 < i2; i3++) {
                        getWidgetsToSolveTraversal(arrayList, helper.mWidgets[i3]);
                    }
                }
                int length = constraintWidget.mListAnchors.length;
                for (int i4 = 0; i4 < length; i4++) {
                    ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i4].mTarget;
                    if (constraintAnchor != null) {
                        ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
                        if (!(constraintAnchor == null || constraintWidget2 == constraintWidget.getParent())) {
                            getWidgetsToSolveTraversal(arrayList, constraintWidget2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateUnresolvedWidgets() {
        int size = this.mUnresolvedWidgets.size();
        for (int i2 = 0; i2 < size; i2++) {
            updateResolvedDimension(this.mUnresolvedWidgets.get(i2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateResolvedDimension(android.support.constraint.solver.widgets.ConstraintWidget r7) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetGroup.updateResolvedDimension(android.support.constraint.solver.widgets.ConstraintWidget):void");
    }
}
