package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {
    private Analyzer() {
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            singleGroup(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        boolean z = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.mBelongingGroup = null;
            constraintWidget.mGroupsToSolver = false;
            constraintWidget.resetResolutionNodes();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.mBelongingGroup == null && !determineGroups(constraintWidget2, list, z3)) {
                singleGroup(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int i2 = 0;
        int i3 = 0;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            i3 = Math.max(i3, getMaxDimension(constraintWidgetGroup, 0));
            i2 = Math.max(i2, getMaxDimension(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(i3);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = i3;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(i2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = i2;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    private static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return traverse(constraintWidget, constraintWidgetGroup, list, z);
    }

    private static boolean traverse(ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup, List<ConstraintWidgetGroup> list, boolean z) {
        if (constraintWidget == null) {
            return true;
        }
        constraintWidget.mOptimizerMeasured = false;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        if (constraintWidget.mBelongingGroup == null) {
            constraintWidget.mOptimizerMeasurable = true;
            constraintWidgetGroup.mConstrainedGroup.add(constraintWidget);
            constraintWidget.mBelongingGroup = constraintWidgetGroup;
            if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null && constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null && constraintWidget.mBaseline.mTarget == null && constraintWidget.mCenter.mTarget == null) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
            }
            if (!(constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null)) {
                constraintWidgetContainer.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (!(constraintWidget.mTop.mTarget.mOwner == constraintWidget.getParent() && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.getParent())) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                constraintWidgetContainer.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                    return false;
                } else if (!(constraintWidget.mLeft.mTarget.mOwner == constraintWidget.getParent() && constraintWidget.mRight.mTarget.mOwner == constraintWidget.getParent())) {
                    invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                }
            }
            if (((constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) ^ (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) && constraintWidget.mDimensionRatio != 0.0f) {
                resolveDimensionRatio(constraintWidget);
            } else if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
            }
            if (((constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) || ((constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mRight.mTarget == null) || ((constraintWidget.mRight.mTarget != null && constraintWidget.mRight.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mLeft.mTarget == null) || (constraintWidget.mLeft.mTarget != null && constraintWidget.mLeft.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mRight.mTarget != null && constraintWidget.mRight.mTarget.mOwner == constraintWidget.mParent)))) && constraintWidget.mCenter.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartHorizontalWidgets.add(constraintWidget);
            }
            if (((constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) || ((constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mBottom.mTarget == null) || ((constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mTop.mTarget == null) || (constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.mOwner == constraintWidget.mParent && constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.mParent)))) && constraintWidget.mCenter.mTarget == null && constraintWidget.mBaseline.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartVerticalWidgets.add(constraintWidget);
            }
            if (constraintWidget instanceof Helper) {
                invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                if (z) {
                    return false;
                }
                Helper helper = (Helper) constraintWidget;
                for (int i2 = 0; i2 < helper.mWidgetsCount; i2++) {
                    if (!traverse(helper.mWidgets[i2], constraintWidgetGroup, list, z)) {
                        return false;
                    }
                }
            }
            int length = constraintWidget.mListAnchors.length;
            for (int i3 = 0; i3 < length; i3++) {
                ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3];
                if (!(constraintAnchor.mTarget == null || constraintAnchor.mTarget.mOwner == constraintWidget.getParent())) {
                    if (constraintAnchor.mType == ConstraintAnchor.Type.CENTER) {
                        invalidate(constraintWidgetContainer, constraintWidget, constraintWidgetGroup);
                        if (z) {
                            return false;
                        }
                    } else {
                        setConnection(constraintAnchor);
                    }
                    if (!traverse(constraintAnchor.mTarget.mOwner, constraintWidgetGroup, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (constraintWidget.mBelongingGroup != constraintWidgetGroup) {
            constraintWidgetGroup.mConstrainedGroup.addAll(constraintWidget.mBelongingGroup.mConstrainedGroup);
            constraintWidgetGroup.mStartHorizontalWidgets.addAll(constraintWidget.mBelongingGroup.mStartHorizontalWidgets);
            constraintWidgetGroup.mStartVerticalWidgets.addAll(constraintWidget.mBelongingGroup.mStartVerticalWidgets);
            if (!constraintWidget.mBelongingGroup.mSkipSolver) {
                constraintWidgetGroup.mSkipSolver = false;
            }
            list.remove(constraintWidget.mBelongingGroup);
            for (ConstraintWidget constraintWidget2 : constraintWidget.mBelongingGroup.mConstrainedGroup) {
                constraintWidget2.mBelongingGroup = constraintWidgetGroup;
            }
        }
        return true;
    }

    private static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.mOptimizerMeasurable = false;
    }

    private static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i2) {
        boolean z;
        int i3 = i2 * 2;
        List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i2);
        int size = startWidgets.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            ConstraintWidget constraintWidget = startWidgets.get(i4);
            if (constraintWidget.mListAnchors[i3 + 1].mTarget == null || !(constraintWidget.mListAnchors[i3].mTarget == null || constraintWidget.mListAnchors[i3 + 1].mTarget == null)) {
                z = true;
            } else {
                z = false;
            }
            i4++;
            i5 = Math.max(i5, getMaxDimensionTraversal(constraintWidget, i2, z, 0));
        }
        constraintWidgetGroup.mGroupDimensions[i2] = i5;
        return i5;
    }

    private static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i2, boolean z, int i3) {
        int height;
        int baselineDistance;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        int i10;
        int i11;
        int i12;
        ConstraintWidget parent;
        if (!constraintWidget.mOptimizerMeasurable) {
            return 0;
        }
        boolean z2 = constraintWidget.mBaseline.mTarget != null && i2 == 1;
        if (z) {
            height = constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i5 = i2 * 2;
            i4 = i5 + 1;
        } else {
            height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getBaselineDistance();
            i4 = i2 * 2;
            i5 = i4 + 1;
        }
        if (constraintWidget.mListAnchors[i4].mTarget == null || constraintWidget.mListAnchors[i5].mTarget != null) {
            i6 = 1;
            i7 = i4;
            i8 = i5;
        } else {
            i6 = -1;
            i7 = i5;
            i8 = i4;
        }
        if (z2) {
            i3 -= height;
        }
        int margin = (constraintWidget.mListAnchors[i8].getMargin() * i6) + getParentBiasOffset(constraintWidget, i2);
        int i13 = margin + i3;
        int width2 = (i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
        Iterator it = constraintWidget.mListAnchors[i8].getResolutionNode().dependents.iterator();
        int i14 = 0;
        while (it.hasNext()) {
            i14 = Math.max(i14, getMaxDimensionTraversal(((ResolutionAnchor) ((ResolutionNode) it.next())).myAnchor.mOwner, i2, z, i13));
        }
        Iterator it2 = constraintWidget.mListAnchors[i7].getResolutionNode().dependents.iterator();
        int i15 = 0;
        while (it2.hasNext()) {
            i15 = Math.max(i15, getMaxDimensionTraversal(((ResolutionAnchor) ((ResolutionNode) it2.next())).myAnchor.mOwner, i2, z, width2 + i13));
        }
        if (z2) {
            width = i15 + baselineDistance;
            i9 = i14 - height;
        } else {
            width = ((i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6) + i15;
            i9 = i14;
        }
        int i16 = 0;
        if (i2 == 1) {
            Iterator it3 = constraintWidget.mBaseline.getResolutionNode().dependents.iterator();
            while (true) {
                i10 = i16;
                if (!it3.hasNext()) {
                    break;
                }
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) ((ResolutionNode) it3.next());
                if (i6 == 1) {
                    i16 = Math.max(i10, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i2, z, height + i13));
                } else {
                    i16 = Math.max(i10, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i2, z, (baselineDistance * i6) + i13));
                }
            }
            if (constraintWidget.mBaseline.getResolutionNode().dependents.size() > 0 && !z2) {
                i10 = i6 == 1 ? i10 + height : i10 - baselineDistance;
            }
        } else {
            i10 = 0;
        }
        int max = Math.max(i9, Math.max(width, i10)) + margin;
        int i17 = i3 + margin;
        int i18 = i17 + width2;
        if (i6 == -1) {
            i11 = i17;
            i12 = i18;
        } else {
            i11 = i18;
            i12 = i17;
        }
        if (z) {
            Optimizer.setOptimizedWidget(constraintWidget, i2, i12);
            constraintWidget.setFrame(i12, i11, i2);
        } else {
            constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
            constraintWidget.setRelativePositioning(i12, i2);
        }
        if (constraintWidget.getDimensionBehaviour(i2) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mDimensionRatio != 0.0f) {
            constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
        }
        if (constraintWidget.mListAnchors[i8].mTarget == null || constraintWidget.mListAnchors[i7].mTarget == null || constraintWidget.mListAnchors[i8].mTarget.mOwner != (parent = constraintWidget.getParent()) || constraintWidget.mListAnchors[i7].mTarget.mOwner != parent) {
            return max;
        }
        constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
        return max;
    }

    private static void setConnection(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        if (constraintAnchor.mTarget != null && constraintAnchor.mTarget.mTarget != constraintAnchor) {
            constraintAnchor.mTarget.getResolutionNode().addDependent(resolutionNode);
        }
    }

    private static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.mChildren));
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i2, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            for (ConstraintWidget constraintWidget : list.get(i4).getWidgetsToSet(i2)) {
                if (constraintWidget.mOptimizerMeasurable) {
                    updateSizeDependentWidgets(constraintWidget, i2, i3);
                }
            }
        }
    }

    private static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i2, int i3) {
        int i4 = i2 * 2;
        ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i4];
        ConstraintAnchor constraintAnchor2 = constraintWidget.mListAnchors[i4 + 1];
        if ((constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? false : true) {
            Optimizer.setOptimizedWidget(constraintWidget, i2, getParentBiasOffset(constraintWidget, i2) + constraintAnchor.getMargin());
        } else if (constraintWidget.mDimensionRatio == 0.0f || constraintWidget.getDimensionBehaviour(i2) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int relativePositioning = i3 - constraintWidget.getRelativePositioning(i2);
            int length = relativePositioning - constraintWidget.getLength(i2);
            constraintWidget.setFrame(length, relativePositioning, i2);
            Optimizer.setOptimizedWidget(constraintWidget, i2, length);
        } else {
            int resolveDimensionRatio = resolveDimensionRatio(constraintWidget);
            int i5 = (int) constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset;
            constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
            constraintAnchor2.getResolutionNode().resolvedOffset = (float) resolveDimensionRatio;
            constraintAnchor2.getResolutionNode().state = 1;
            constraintWidget.setFrame(i5, i5 + resolveDimensionRatio, i2);
        }
    }

    private static int getParentBiasOffset(ConstraintWidget constraintWidget, int i2) {
        int i3 = i2 * 2;
        ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3];
        ConstraintAnchor constraintAnchor2 = constraintWidget.mListAnchors[i3 + 1];
        if (constraintAnchor.mTarget == null || constraintAnchor.mTarget.mOwner != constraintWidget.mParent || constraintAnchor2.mTarget == null || constraintAnchor2.mTarget.mOwner != constraintWidget.mParent) {
            return 0;
        }
        return (int) ((i2 == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent) * ((float) (((constraintWidget.mParent.getLength(i2) - constraintAnchor.getMargin()) - constraintAnchor2.getMargin()) - constraintWidget.getLength(i2))));
    }

    private static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        int i2 = -1;
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mDimensionRatioSide == 0) {
                i2 = (int) (((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio);
            } else {
                i2 = (int) (((float) constraintWidget.getHeight()) / constraintWidget.mDimensionRatio);
            }
            constraintWidget.setWidth(i2);
        } else if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mDimensionRatioSide == 1) {
                i2 = (int) (((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio);
            } else {
                i2 = (int) (((float) constraintWidget.getWidth()) / constraintWidget.mDimensionRatio);
            }
            constraintWidget.setHeight(i2);
        }
        return i2;
    }
}
