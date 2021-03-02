package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static final int ALIGN_CENTER = 0;
    private static final int ALIGN_FULL = 3;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList<>();
    private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList<>();
    private int mNumCols = 0;
    private int mNumRows = 0;
    private int mPadding = 8;
    private boolean mVerticalGrowth = true;
    private ArrayList<Guideline> mVerticalGuidelines = new ArrayList<>();
    private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList<>();
    private LinearSystem system = null;

    /* access modifiers changed from: package-private */
    public class HorizontalSlice {
        ConstraintWidget bottom;
        int padding;
        ConstraintWidget top;

        HorizontalSlice() {
        }
    }

    /* access modifiers changed from: package-private */
    public class VerticalSlice {
        int alignment = 1;
        ConstraintWidget left;
        int padding;
        ConstraintWidget right;

        VerticalSlice() {
        }
    }

    public ConstraintTableLayout() {
    }

    public ConstraintTableLayout(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
    }

    public ConstraintTableLayout(int i2, int i3) {
        super(i2, i3);
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintTableLayout";
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public int getNumCols() {
        return this.mNumCols;
    }

    public int getPadding() {
        return this.mPadding;
    }

    public String getColumnsAlignmentRepresentation() {
        String str;
        int size = this.mVerticalSlices.size();
        String str2 = "";
        int i2 = 0;
        while (i2 < size) {
            VerticalSlice verticalSlice = this.mVerticalSlices.get(i2);
            if (verticalSlice.alignment == 1) {
                str = str2 + "L";
            } else if (verticalSlice.alignment == 0) {
                str = str2 + "C";
            } else if (verticalSlice.alignment == 3) {
                str = str2 + "F";
            } else if (verticalSlice.alignment == 2) {
                str = str2 + "R";
            } else {
                str = str2;
            }
            i2++;
            str2 = str;
        }
        return str2;
    }

    public String getColumnAlignmentRepresentation(int i2) {
        VerticalSlice verticalSlice = this.mVerticalSlices.get(i2);
        if (verticalSlice.alignment == 1) {
            return "L";
        }
        if (verticalSlice.alignment == 0) {
            return "C";
        }
        if (verticalSlice.alignment == 3) {
            return "F";
        }
        if (verticalSlice.alignment == 2) {
            return "R";
        }
        return "!";
    }

    public void setNumCols(int i2) {
        if (this.mVerticalGrowth && this.mNumCols != i2) {
            this.mNumCols = i2;
            setVerticalSlices();
            setTableDimensions();
        }
    }

    public void setNumRows(int i2) {
        if (!this.mVerticalGrowth && this.mNumCols != i2) {
            this.mNumRows = i2;
            setHorizontalSlices();
            setTableDimensions();
        }
    }

    public boolean isVerticalGrowth() {
        return this.mVerticalGrowth;
    }

    public void setVerticalGrowth(boolean z) {
        this.mVerticalGrowth = z;
    }

    public void setPadding(int i2) {
        if (i2 > 1) {
            this.mPadding = i2;
        }
    }

    public void setColumnAlignment(int i2, int i3) {
        if (i2 < this.mVerticalSlices.size()) {
            this.mVerticalSlices.get(i2).alignment = i3;
            setChildrenConnections();
        }
    }

    public void cycleColumnAlignment(int i2) {
        VerticalSlice verticalSlice = this.mVerticalSlices.get(i2);
        switch (verticalSlice.alignment) {
            case 0:
                verticalSlice.alignment = 2;
                break;
            case 1:
                verticalSlice.alignment = 0;
                break;
            case 2:
                verticalSlice.alignment = 1;
                break;
        }
        setChildrenConnections();
    }

    public void setColumnAlignment(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 'L') {
                setColumnAlignment(i2, 1);
            } else {
                if (charAt != 'C') {
                    if (charAt == 'F') {
                        setColumnAlignment(i2, 3);
                    } else if (charAt == 'R') {
                        setColumnAlignment(i2, 2);
                    }
                }
                setColumnAlignment(i2, 0);
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getVerticalGuidelines() {
        return this.mVerticalGuidelines;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getHorizontalGuidelines() {
        return this.mHorizontalGuidelines;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        int size = this.mChildren.size();
        if (size != 0) {
            setTableDimensions();
            if (linearSystem == this.mSystem) {
                int size2 = this.mVerticalGuidelines.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Guideline guideline = this.mVerticalGuidelines.get(i2);
                    guideline.setPositionRelaxed(getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    guideline.addToSolver(linearSystem);
                }
                int size3 = this.mHorizontalGuidelines.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Guideline guideline2 = this.mHorizontalGuidelines.get(i3);
                    guideline2.setPositionRelaxed(getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    guideline2.addToSolver(linearSystem);
                }
                for (int i4 = 0; i4 < size; i4++) {
                    ((ConstraintWidget) this.mChildren.get(i4)).addToSolver(linearSystem);
                }
            }
        }
    }

    public void setTableDimensions() {
        int size = this.mChildren.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += ((ConstraintWidget) this.mChildren.get(i3)).getContainerItemSkip();
        }
        int i4 = size + i2;
        if (this.mVerticalGrowth) {
            if (this.mNumCols == 0) {
                setNumCols(1);
            }
            int i5 = i4 / this.mNumCols;
            if (this.mNumCols * i5 < i4) {
                i5++;
            }
            if (this.mNumRows != i5 || this.mVerticalGuidelines.size() != this.mNumCols - 1) {
                this.mNumRows = i5;
                setHorizontalSlices();
            } else {
                return;
            }
        } else {
            if (this.mNumRows == 0) {
                setNumRows(1);
            }
            int i6 = i4 / this.mNumRows;
            if (this.mNumRows * i6 < i4) {
                i6++;
            }
            if (this.mNumCols != i6 || this.mHorizontalGuidelines.size() != this.mNumRows - 1) {
                this.mNumCols = i6;
                setVerticalSlices();
            } else {
                return;
            }
        }
        setChildrenConnections();
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.system = linearSystem;
        super.setDebugSolverName(linearSystem, str);
        updateDebugSolverNames();
    }

    private void updateDebugSolverNames() {
        if (this.system != null) {
            int size = this.mVerticalGuidelines.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mVerticalGuidelines.get(i2).setDebugSolverName(this.system, getDebugName() + ".VG" + i2);
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.mHorizontalGuidelines.get(i3).setDebugSolverName(this.system, getDebugName() + ".HG" + i3);
            }
        }
    }

    private void setVerticalSlices() {
        this.mVerticalSlices.clear();
        float f2 = 100.0f / ((float) this.mNumCols);
        float f3 = f2;
        ConstraintWidget constraintWidget = this;
        for (int i2 = 0; i2 < this.mNumCols; i2++) {
            VerticalSlice verticalSlice = new VerticalSlice();
            verticalSlice.left = constraintWidget;
            if (i2 < this.mNumCols - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(1);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f3);
                f3 += f2;
                verticalSlice.right = guideline;
                this.mVerticalGuidelines.add(guideline);
            } else {
                verticalSlice.right = this;
            }
            constraintWidget = verticalSlice.right;
            this.mVerticalSlices.add(verticalSlice);
        }
        updateDebugSolverNames();
    }

    private void setHorizontalSlices() {
        this.mHorizontalSlices.clear();
        float f2 = 100.0f / ((float) this.mNumRows);
        ConstraintWidget constraintWidget = this;
        float f3 = f2;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            HorizontalSlice horizontalSlice = new HorizontalSlice();
            horizontalSlice.top = constraintWidget;
            if (i2 < this.mNumRows - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(0);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f3);
                f3 += f2;
                horizontalSlice.bottom = guideline;
                this.mHorizontalGuidelines.add(guideline);
            } else {
                horizontalSlice.bottom = this;
            }
            constraintWidget = horizontalSlice.bottom;
            this.mHorizontalSlices.add(horizontalSlice);
        }
        updateDebugSolverNames();
    }

    private void setChildrenConnections() {
        int size = this.mChildren.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i3);
            int containerItemSkip = i2 + constraintWidget.getContainerItemSkip();
            int i4 = containerItemSkip % this.mNumCols;
            HorizontalSlice horizontalSlice = this.mHorizontalSlices.get(containerItemSkip / this.mNumCols);
            VerticalSlice verticalSlice = this.mVerticalSlices.get(i4);
            ConstraintWidget constraintWidget2 = verticalSlice.left;
            ConstraintWidget constraintWidget3 = verticalSlice.right;
            ConstraintWidget constraintWidget4 = horizontalSlice.top;
            ConstraintWidget constraintWidget5 = horizontalSlice.bottom;
            constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
            if (constraintWidget3 instanceof Guideline) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mPadding);
            } else {
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mPadding);
            }
            switch (verticalSlice.alignment) {
                case 1:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
                    break;
                case 2:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
                    break;
                case 3:
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    break;
            }
            constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
            if (constraintWidget5 instanceof Guideline) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.TOP), this.mPadding);
            } else {
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mPadding);
            }
            i2 = containerItemSkip + 1;
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        super.updateFromSolver(linearSystem);
        if (linearSystem == this.mSystem) {
            int size = this.mVerticalGuidelines.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mVerticalGuidelines.get(i2).updateFromSolver(linearSystem);
            }
            int size2 = this.mHorizontalGuidelines.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.mHorizontalGuidelines.get(i3).updateFromSolver(linearSystem);
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidgetContainer
    public boolean handlesInternalConstraints() {
        return true;
    }

    public void computeGuidelinesPercentPositions() {
        int size = this.mVerticalGuidelines.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mVerticalGuidelines.get(i2).inferRelativePercentPosition();
        }
        int size2 = this.mHorizontalGuidelines.size();
        for (int i3 = 0; i3 < size2; i3++) {
            this.mHorizontalGuidelines.get(i3).inferRelativePercentPosition();
        }
    }
}
