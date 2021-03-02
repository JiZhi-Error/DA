package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import java.util.Arrays;

public class ArrayLinkedVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    private static final int NONE = -1;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    int currentSize = 0;
    private int[] mArrayIndices = new int[this.ROW_SIZE];
    private int[] mArrayNextIndices = new int[this.ROW_SIZE];
    private float[] mArrayValues = new float[this.ROW_SIZE];
    private final Cache mCache;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    public final void put(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            remove(solverVariable, true);
        } else if (this.mHead == -1) {
            this.mHead = 0;
            this.mArrayValues[this.mHead] = f2;
            this.mArrayIndices[this.mHead] = solverVariable.id;
            this.mArrayNextIndices[this.mHead] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
                if (this.mLast >= this.mArrayIndices.length) {
                    this.mDidFillOnce = true;
                    this.mLast = this.mArrayIndices.length - 1;
                }
            }
        } else {
            int i2 = this.mHead;
            int i3 = 0;
            int i4 = -1;
            while (i2 != -1 && i3 < this.currentSize) {
                if (this.mArrayIndices[i2] == solverVariable.id) {
                    this.mArrayValues[i2] = f2;
                    return;
                }
                if (this.mArrayIndices[i2] < solverVariable.id) {
                    i4 = i2;
                }
                i2 = this.mArrayNextIndices[i2];
                i3++;
            }
            int i5 = this.mLast + 1;
            if (this.mDidFillOnce) {
                if (this.mArrayIndices[this.mLast] == -1) {
                    i5 = this.mLast;
                } else {
                    i5 = this.mArrayIndices.length;
                }
            }
            if (i5 >= this.mArrayIndices.length && this.currentSize < this.mArrayIndices.length) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.mArrayIndices.length) {
                        break;
                    } else if (this.mArrayIndices[i6] == -1) {
                        i5 = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            if (i5 >= this.mArrayIndices.length) {
                i5 = this.mArrayIndices.length;
                this.ROW_SIZE *= 2;
                this.mDidFillOnce = false;
                this.mLast = i5 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i5] = solverVariable.id;
            this.mArrayValues[i5] = f2;
            if (i4 != -1) {
                int[] iArr = this.mArrayNextIndices;
                iArr[i5] = iArr[i4];
                this.mArrayNextIndices[i4] = i5;
            } else {
                this.mArrayNextIndices[i5] = this.mHead;
                this.mHead = i5;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            if (this.currentSize >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
            }
            if (this.mLast >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
                this.mLast = this.mArrayIndices.length - 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void add(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 != 0.0f) {
            if (this.mHead == -1) {
                this.mHead = 0;
                this.mArrayValues[this.mHead] = f2;
                this.mArrayIndices[this.mHead] = solverVariable.id;
                this.mArrayNextIndices[this.mHead] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (!this.mDidFillOnce) {
                    this.mLast++;
                    if (this.mLast >= this.mArrayIndices.length) {
                        this.mDidFillOnce = true;
                        this.mLast = this.mArrayIndices.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i2 = this.mHead;
            int i3 = 0;
            int i4 = -1;
            while (i2 != -1 && i3 < this.currentSize) {
                if (this.mArrayIndices[i2] == solverVariable.id) {
                    float[] fArr = this.mArrayValues;
                    fArr[i2] = fArr[i2] + f2;
                    if (this.mArrayValues[i2] == 0.0f) {
                        if (i2 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i2];
                        } else {
                            int[] iArr = this.mArrayNextIndices;
                            iArr[i4] = iArr[i2];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i2;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                        return;
                    }
                    return;
                }
                if (this.mArrayIndices[i2] < solverVariable.id) {
                    i4 = i2;
                }
                i2 = this.mArrayNextIndices[i2];
                i3++;
            }
            int i5 = this.mLast + 1;
            if (this.mDidFillOnce) {
                if (this.mArrayIndices[this.mLast] == -1) {
                    i5 = this.mLast;
                } else {
                    i5 = this.mArrayIndices.length;
                }
            }
            if (i5 >= this.mArrayIndices.length && this.currentSize < this.mArrayIndices.length) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.mArrayIndices.length) {
                        break;
                    } else if (this.mArrayIndices[i6] == -1) {
                        i5 = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            if (i5 >= this.mArrayIndices.length) {
                i5 = this.mArrayIndices.length;
                this.ROW_SIZE *= 2;
                this.mDidFillOnce = false;
                this.mLast = i5 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i5] = solverVariable.id;
            this.mArrayValues[i5] = f2;
            if (i4 != -1) {
                int[] iArr2 = this.mArrayNextIndices;
                iArr2[i5] = iArr2[i4];
                this.mArrayNextIndices[i4] = i5;
            } else {
                this.mArrayNextIndices[i5] = this.mHead;
                this.mHead = i5;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            if (this.mLast >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
                this.mLast = this.mArrayIndices.length - 1;
            }
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        if (this.mHead == -1) {
            return 0.0f;
        }
        int i2 = this.mHead;
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                if (i2 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i2];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i2] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i2;
                }
                return this.mArrayValues[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.mArrayNextIndices[i2];
        }
        return 0.0f;
    }

    public final void clear() {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean containsKey(SolverVariable solverVariable) {
        if (this.mHead == -1) {
            return false;
        }
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                return true;
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAtLeastOnePositiveVariable() {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayValues[i2] > 0.0f) {
                return true;
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void invert() {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
    }

    /* access modifiers changed from: package-private */
    public void divideByAmount(float f2) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable chooseSubject(LinearSystem linearSystem) {
        int i2 = 0;
        int i3 = this.mHead;
        boolean z = false;
        boolean z2 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        while (i3 != -1 && i2 < this.currentSize) {
            float f4 = this.mArrayValues[i3];
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
            if (f4 < 0.0f) {
                if (f4 > -0.001f) {
                    this.mArrayValues[i3] = 0.0f;
                    solverVariable3.removeFromRow(this.mRow);
                    f4 = 0.0f;
                }
            } else if (f4 < 0.001f) {
                this.mArrayValues[i3] = 0.0f;
                solverVariable3.removeFromRow(this.mRow);
                f4 = 0.0f;
            }
            if (f4 != 0.0f) {
                if (solverVariable3.mType == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable == null) {
                        z2 = isNew(solverVariable3, linearSystem);
                        f3 = f4;
                        solverVariable = solverVariable3;
                    } else if (f3 > f4) {
                        z2 = isNew(solverVariable3, linearSystem);
                        f3 = f4;
                        solverVariable = solverVariable3;
                    } else if (!z2 && isNew(solverVariable3, linearSystem)) {
                        z2 = true;
                        f3 = f4;
                        solverVariable = solverVariable3;
                    }
                } else if (solverVariable == null && f4 < 0.0f) {
                    if (solverVariable2 == null) {
                        z = isNew(solverVariable3, linearSystem);
                        f2 = f4;
                        solverVariable2 = solverVariable3;
                    } else if (f2 > f4) {
                        z = isNew(solverVariable3, linearSystem);
                        f2 = f4;
                        solverVariable2 = solverVariable3;
                    } else if (!z && isNew(solverVariable3, linearSystem)) {
                        z = true;
                        f2 = f4;
                        solverVariable2 = solverVariable3;
                    }
                }
            }
            i2++;
            i3 = this.mArrayNextIndices[i3];
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    /* access modifiers changed from: package-private */
    public final void updateFromRow(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i2] == arrayRow2.variable.id) {
                float f2 = this.mArrayValues[i2];
                remove(arrayRow2.variable, z);
                ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                int i4 = arrayLinkedVariables.mHead;
                int i5 = 0;
                while (i4 != -1 && i5 < arrayLinkedVariables.currentSize) {
                    add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i4]], arrayLinkedVariables.mArrayValues[i4] * f2, z);
                    i4 = arrayLinkedVariables.mArrayNextIndices[i4];
                    i5++;
                }
                arrayRow.constantValue += arrayRow2.constantValue * f2;
                if (z) {
                    arrayRow2.variable.removeFromRow(arrayRow);
                }
                i2 = this.mHead;
                i3 = 0;
            } else {
                i2 = this.mArrayNextIndices[i2];
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateFromSystem(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            if (solverVariable.definitionId != -1) {
                float f2 = this.mArrayValues[i2];
                remove(solverVariable, true);
                ArrayRow arrayRow2 = arrayRowArr[solverVariable.definitionId];
                if (!arrayRow2.isSimpleDefinition) {
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                    int i4 = arrayLinkedVariables.mHead;
                    int i5 = 0;
                    while (i4 != -1 && i5 < arrayLinkedVariables.currentSize) {
                        add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i4]], arrayLinkedVariables.mArrayValues[i4] * f2, true);
                        i4 = arrayLinkedVariables.mArrayNextIndices[i4];
                        i5++;
                    }
                }
                arrayRow.constantValue += arrayRow2.constantValue * f2;
                arrayRow2.variable.removeFromRow(arrayRow);
                i2 = this.mHead;
                i3 = 0;
            } else {
                i2 = this.mArrayNextIndices[i2];
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate() {
        if (this.candidate != null) {
            return this.candidate;
        }
        int i2 = this.mHead;
        int i3 = 0;
        SolverVariable solverVariable = null;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayValues[i2] < 0.0f) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
                if (solverVariable == null || solverVariable.strength < solverVariable2.strength) {
                    solverVariable = solverVariable2;
                }
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return solverVariable;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate(boolean[] zArr, SolverVariable solverVariable) {
        int i2 = this.mHead;
        int i3 = 0;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayValues[i2] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
                if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && (solverVariable3.mType == SolverVariable.Type.SLACK || solverVariable3.mType == SolverVariable.Type.ERROR)) {
                    float f3 = this.mArrayValues[i2];
                    if (f3 < f2) {
                        f2 = f3;
                        solverVariable2 = solverVariable3;
                    }
                }
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return solverVariable2;
    }

    /* access modifiers changed from: package-private */
    public final SolverVariable getVariable(int i2) {
        int i3 = this.mHead;
        int i4 = 0;
        while (i3 != -1 && i4 < this.currentSize) {
            if (i4 == i2) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
            }
            i3 = this.mArrayNextIndices[i3];
            i4++;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getVariableValue(int i2) {
        int i3 = this.mHead;
        int i4 = 0;
        while (i3 != -1 && i4 < this.currentSize) {
            if (i4 == i2) {
                return this.mArrayValues[i3];
            }
            i3 = this.mArrayNextIndices[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float get(SolverVariable solverVariable) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                return this.mArrayValues[i2];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 4 * 3) + 0 + 36;
    }

    public void display() {
        int i2 = this.currentSize;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i3) + " ");
            }
        }
        System.out.println(" }");
    }

    public String toString() {
        String str = "";
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            str = ((str + " -> ") + this.mArrayValues[i2] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return str;
    }
}
