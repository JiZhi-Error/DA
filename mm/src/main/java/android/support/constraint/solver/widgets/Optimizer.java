package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i2, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i3 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i3);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i3);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i3, height);
        }
    }

    private static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i2) {
        char c2 = 1;
        if (constraintWidget.mListDimensionBehaviors[i2] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.mDimensionRatio != 0.0f) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
            if (i2 != 0) {
                c2 = 0;
            }
            if (dimensionBehaviourArr[c2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i2 == 0) {
            if (!(constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mMatchConstraintMinWidth == 0 && constraintWidget.mMatchConstraintMaxWidth == 0)) {
                return false;
            }
        } else if (!(constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mMatchConstraintMinHeight == 0 && constraintWidget.mMatchConstraintMaxHeight == 0)) {
            return false;
        }
        return true;
    }

    static void analyze(int i2, ConstraintWidget constraintWidget) {
        boolean z;
        boolean z2 = false;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget.mBottom.getResolutionNode();
        boolean z3 = (i2 & 8) == 8;
        if (constraintWidget.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || !optimizableMatchConstraint(constraintWidget, 0)) {
            z = false;
        } else {
            z = true;
        }
        if (!(resolutionNode.type == 4 || resolutionNode3.type == 4)) {
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z3) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z3) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z3) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z3) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, (float) (-constraintWidget.getWidth()));
                        resolutionNode3.setOpposite(resolutionNode, (float) constraintWidget.getWidth());
                    }
                }
            } else if (z) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    if (z3) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget != null) {
                    if (constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget == null) {
                        if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                            if (z3) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, (float) (-width));
                                resolutionNode3.setOpposite(resolutionNode, (float) width);
                                constraintWidget.setWidth(width);
                            }
                        }
                    } else if (z3) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z3) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 1)) {
            z2 = true;
        }
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z3) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaseline.mTarget != null) {
                        constraintWidget.mBaseline.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z3) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z3) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z3) {
                        resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    } else {
                        resolutionNode2.setOpposite(resolutionNode4, (float) (-constraintWidget.getHeight()));
                        resolutionNode4.setOpposite(resolutionNode2, (float) constraintWidget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                    }
                }
            } else if (z2) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    if (z3) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget != null) {
                    if (constraintWidget.mTop.mTarget != null || constraintWidget.mBottom.mTarget == null) {
                        if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                            if (z3) {
                                constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                resolutionNode2.setType(3);
                                resolutionNode4.setType(3);
                                resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                                resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                                return;
                            }
                            resolutionNode2.setType(2);
                            resolutionNode4.setType(2);
                            resolutionNode2.setOpposite(resolutionNode4, (float) (-height));
                            resolutionNode4.setOpposite(resolutionNode2, (float) height);
                            constraintWidget.setHeight(height);
                            if (constraintWidget.mBaselineDistance > 0) {
                                constraintWidget.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.mBaselineDistance);
                            }
                        }
                    } else if (z3) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (z3) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, height);
                }
            }
        }
    }

    static boolean applyChainOptimized(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i2, int i3, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        float f2;
        boolean z4;
        boolean z5;
        float f3;
        float f4;
        ConstraintWidget constraintWidget;
        float height;
        float f5;
        float height2;
        float f6;
        int i4;
        ConstraintWidget constraintWidget2;
        float height3;
        ConstraintWidget constraintWidget3 = chainHead.mFirst;
        ConstraintWidget constraintWidget4 = chainHead.mLast;
        ConstraintWidget constraintWidget5 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget6 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget7 = chainHead.mHead;
        boolean z6 = false;
        int i5 = 0;
        float f7 = chainHead.mTotalWeight;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i2 == 0) {
            z = constraintWidget7.mHorizontalChainStyle == 0;
            z2 = constraintWidget7.mHorizontalChainStyle == 1;
            z3 = constraintWidget7.mHorizontalChainStyle == 2;
        } else {
            z = constraintWidget7.mVerticalChainStyle == 0;
            z2 = constraintWidget7.mVerticalChainStyle == 1;
            z3 = constraintWidget7.mVerticalChainStyle == 2;
        }
        float f8 = 0.0f;
        float f9 = 0.0f;
        int i6 = 0;
        ConstraintWidget constraintWidget8 = constraintWidget3;
        while (!z6) {
            if (constraintWidget8.getVisibility() != 8) {
                i4 = i6 + 1;
                if (i2 == 0) {
                    height3 = ((float) constraintWidget8.getWidth()) + f8;
                } else {
                    height3 = ((float) constraintWidget8.getHeight()) + f8;
                }
                if (constraintWidget8 != constraintWidget5) {
                    height3 += (float) constraintWidget8.mListAnchors[i3].getMargin();
                }
                if (constraintWidget8 != constraintWidget6) {
                    height3 += (float) constraintWidget8.mListAnchors[i3 + 1].getMargin();
                }
                f9 = f9 + ((float) constraintWidget8.mListAnchors[i3].getMargin()) + ((float) constraintWidget8.mListAnchors[i3 + 1].getMargin());
                f8 = height3;
            } else {
                i4 = i6;
            }
            if (constraintWidget8.getVisibility() != 8 && constraintWidget8.mListDimensionBehaviors[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i7 = i5 + 1;
                if (i2 == 0) {
                    if (!(constraintWidget8.mMatchConstraintDefaultWidth == 0 && constraintWidget8.mMatchConstraintMinWidth == 0 && constraintWidget8.mMatchConstraintMaxWidth == 0)) {
                        return false;
                    }
                } else if (!(constraintWidget8.mMatchConstraintDefaultHeight == 0 && constraintWidget8.mMatchConstraintMinHeight == 0 && constraintWidget8.mMatchConstraintMaxHeight == 0)) {
                    return false;
                }
                if (constraintWidget8.mDimensionRatio != 0.0f) {
                    return false;
                }
                i5 = i7;
            }
            ConstraintAnchor constraintAnchor = constraintWidget8.mListAnchors[i3 + 1].mTarget;
            if (constraintAnchor != null) {
                constraintWidget2 = constraintAnchor.mOwner;
                if (constraintWidget2.mListAnchors[i3].mTarget == null || constraintWidget2.mListAnchors[i3].mTarget.mOwner != constraintWidget8) {
                    constraintWidget2 = null;
                }
            } else {
                constraintWidget2 = null;
            }
            if (constraintWidget2 != null) {
                i6 = i4;
                constraintWidget8 = constraintWidget2;
            } else {
                z6 = true;
                i6 = i4;
            }
        }
        ResolutionAnchor resolutionNode = constraintWidget3.mListAnchors[i3].getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget4.mListAnchors[i3 + 1].getResolutionNode();
        if (resolutionNode.target == null || resolutionNode2.target == null || resolutionNode.target.state != 1 || resolutionNode2.target.state != 1) {
            return false;
        }
        if (i5 > 0 && i5 != i6) {
            return false;
        }
        float f10 = 0.0f;
        if (z3 || z || z2) {
            if (constraintWidget5 != null) {
                f10 = (float) constraintWidget5.mListAnchors[i3].getMargin();
            }
            if (constraintWidget6 != null) {
                f10 += (float) constraintWidget6.mListAnchors[i3 + 1].getMargin();
            }
        }
        float f11 = resolutionNode.target.resolvedOffset;
        float f12 = resolutionNode2.target.resolvedOffset;
        if (f11 < f12) {
            f2 = (f12 - f11) - f8;
        } else {
            f2 = (f11 - f12) - f8;
        }
        if (i5 <= 0 || i5 != i6) {
            if (f2 < 0.0f) {
                z3 = true;
                z4 = false;
                z5 = false;
            } else {
                z4 = z2;
                z5 = z;
            }
            if (z3) {
                float biasPercent = f11 + ((f2 - f10) * constraintWidget3.getBiasPercent(i2));
                while (constraintWidget3 != null) {
                    if (LinearSystem.sMetrics != null) {
                        LinearSystem.sMetrics.nonresolvedWidgets--;
                        LinearSystem.sMetrics.resolvedWidgets++;
                        LinearSystem.sMetrics.chainConnectionResolved++;
                    }
                    ConstraintWidget constraintWidget9 = constraintWidget3.mNextChainWidget[i2];
                    if (constraintWidget9 != null || constraintWidget3 == constraintWidget4) {
                        if (i2 == 0) {
                            height2 = (float) constraintWidget3.getWidth();
                        } else {
                            height2 = (float) constraintWidget3.getHeight();
                        }
                        float margin = biasPercent + ((float) constraintWidget3.mListAnchors[i3].getMargin());
                        constraintWidget3.mListAnchors[i3].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin);
                        constraintWidget3.mListAnchors[i3 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin + height2);
                        constraintWidget3.mListAnchors[i3].getResolutionNode().addResolvedValue(linearSystem);
                        constraintWidget3.mListAnchors[i3 + 1].getResolutionNode().addResolvedValue(linearSystem);
                        f5 = height2 + margin + ((float) constraintWidget3.mListAnchors[i3 + 1].getMargin());
                    } else {
                        f5 = biasPercent;
                    }
                    biasPercent = f5;
                    constraintWidget3 = constraintWidget9;
                }
            } else if (z5 || z4) {
                if (z5) {
                    f3 = f2 - f10;
                } else if (z4) {
                    f3 = f2 - f10;
                } else {
                    f3 = f2;
                }
                float f13 = f3 / ((float) (i6 + 1));
                if (z4) {
                    if (i6 > 1) {
                        f13 = f3 / ((float) (i6 - 1));
                    } else {
                        f13 = f3 / 2.0f;
                    }
                }
                if (constraintWidget3.getVisibility() != 8) {
                    f4 = f11 + f13;
                } else {
                    f4 = f11;
                }
                if (z4 && i6 > 1) {
                    f4 = ((float) constraintWidget5.mListAnchors[i3].getMargin()) + f11;
                }
                if (!z5 || constraintWidget5 == null) {
                    constraintWidget = constraintWidget3;
                } else {
                    f4 += (float) constraintWidget5.mListAnchors[i3].getMargin();
                    constraintWidget = constraintWidget3;
                }
                while (constraintWidget != null) {
                    if (LinearSystem.sMetrics != null) {
                        LinearSystem.sMetrics.nonresolvedWidgets--;
                        LinearSystem.sMetrics.resolvedWidgets++;
                        LinearSystem.sMetrics.chainConnectionResolved++;
                    }
                    ConstraintWidget constraintWidget10 = constraintWidget.mNextChainWidget[i2];
                    if (constraintWidget10 != null || constraintWidget == constraintWidget4) {
                        if (i2 == 0) {
                            height = (float) constraintWidget.getWidth();
                        } else {
                            height = (float) constraintWidget.getHeight();
                        }
                        if (constraintWidget != constraintWidget5) {
                            f4 += (float) constraintWidget.mListAnchors[i3].getMargin();
                        }
                        constraintWidget.mListAnchors[i3].getResolutionNode().resolve(resolutionNode.resolvedTarget, f4);
                        constraintWidget.mListAnchors[i3 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, f4 + height);
                        constraintWidget.mListAnchors[i3].getResolutionNode().addResolvedValue(linearSystem);
                        constraintWidget.mListAnchors[i3 + 1].getResolutionNode().addResolvedValue(linearSystem);
                        f4 += ((float) constraintWidget.mListAnchors[i3 + 1].getMargin()) + height;
                        if (!(constraintWidget10 == null || constraintWidget10.getVisibility() == 8)) {
                            f4 += f13;
                        }
                    }
                    constraintWidget = constraintWidget10;
                }
            }
            return true;
        } else if (constraintWidget8.getParent() != null && constraintWidget8.getParent().mListDimensionBehaviors[i2] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            return false;
        } else {
            float f14 = (f2 + f8) - f9;
            float f15 = f11;
            while (constraintWidget3 != null) {
                if (LinearSystem.sMetrics != null) {
                    LinearSystem.sMetrics.nonresolvedWidgets--;
                    LinearSystem.sMetrics.resolvedWidgets++;
                    LinearSystem.sMetrics.chainConnectionResolved++;
                }
                ConstraintWidget constraintWidget11 = constraintWidget3.mNextChainWidget[i2];
                if (constraintWidget11 != null || constraintWidget3 == constraintWidget4) {
                    float f16 = f14 / ((float) i5);
                    if (f7 > 0.0f) {
                        if (constraintWidget3.mWeight[i2] == -1.0f) {
                            f16 = 0.0f;
                        } else {
                            f16 = (constraintWidget3.mWeight[i2] * f14) / f7;
                        }
                    }
                    if (constraintWidget3.getVisibility() == 8) {
                        f16 = 0.0f;
                    }
                    float margin2 = f15 + ((float) constraintWidget3.mListAnchors[i3].getMargin());
                    constraintWidget3.mListAnchors[i3].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2);
                    constraintWidget3.mListAnchors[i3 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2 + f16);
                    constraintWidget3.mListAnchors[i3].getResolutionNode().addResolvedValue(linearSystem);
                    constraintWidget3.mListAnchors[i3 + 1].getResolutionNode().addResolvedValue(linearSystem);
                    f6 = f16 + margin2 + ((float) constraintWidget3.mListAnchors[i3 + 1].getMargin());
                } else {
                    f6 = f15;
                }
                constraintWidget3 = constraintWidget11;
                f15 = f6;
            }
            return true;
        }
    }

    static void setOptimizedWidget(ConstraintWidget constraintWidget, int i2, int i3) {
        int i4 = i2 * 2;
        int i5 = i4 + 1;
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = (float) i3;
        constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
        constraintWidget.mListAnchors[i5].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i4].getResolutionNode();
        constraintWidget.mListAnchors[i5].getResolutionNode().resolvedOffset = (float) constraintWidget.getLength(i2);
        constraintWidget.mListAnchors[i5].getResolutionNode().state = 1;
    }
}
