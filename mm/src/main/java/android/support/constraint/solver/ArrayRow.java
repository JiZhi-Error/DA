package android.support.constraint.solver;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;

public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final float epsilon = 0.001f;
    float constantValue = 0.0f;
    boolean isSimpleDefinition = false;
    boolean used = false;
    SolverVariable variable = null;
    public final ArrayLinkedVariables variables;

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    /* access modifiers changed from: package-private */
    public boolean hasKeyVariable() {
        return this.variable != null && (this.variable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    public String toString() {
        return toReadableString();
    }

    /* access modifiers changed from: package-private */
    public String toReadableString() {
        String str;
        boolean z;
        boolean z2;
        float f2;
        String str2;
        if (this.variable == null) {
            str = "" + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = "" + this.variable;
        }
        String str3 = str + " = ";
        if (this.constantValue != 0.0f) {
            str3 = str3 + this.constantValue;
            z = true;
        } else {
            z = false;
        }
        int i2 = this.variables.currentSize;
        int i3 = 0;
        while (i3 < i2) {
            SolverVariable variable2 = this.variables.getVariable(i3);
            if (variable2 != null) {
                float variableValue = this.variables.getVariableValue(i3);
                if (variableValue != 0.0f) {
                    String solverVariable = variable2.toString();
                    if (!z) {
                        if (variableValue < 0.0f) {
                            str3 = str3 + "- ";
                            f2 = variableValue * -1.0f;
                        } else {
                            f2 = variableValue;
                        }
                    } else if (variableValue > 0.0f) {
                        str3 = str3 + " + ";
                        f2 = variableValue;
                    } else {
                        str3 = str3 + " - ";
                        f2 = variableValue * -1.0f;
                    }
                    if (f2 == 1.0f) {
                        str2 = str3 + solverVariable;
                    } else {
                        str2 = str3 + f2 + " " + solverVariable;
                    }
                    z2 = true;
                    str3 = str2;
                    i3++;
                    z = z2;
                }
            }
            z2 = z;
            i3++;
            z = z2;
        }
        if (!z) {
            return str3 + "0.0";
        }
        return str3;
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.containsKey(solverVariable);
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i2) {
        this.variable = solverVariable;
        solverVariable.computedValue = (float) i2;
        this.constantValue = (float) i2;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i2) {
        if (i2 < 0) {
            this.constantValue = (float) (i2 * -1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = (float) i2;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.constantValue = (float) i2;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow addSingleError(SolverVariable solverVariable, int i2) {
        this.variables.put(solverVariable, (float) i2);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.constantValue = (float) i2;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i2, SolverVariable solverVariable2) {
        this.constantValue = (float) i2;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.constantValue = (float) i2;
        }
        if (!z) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f5);
            this.variables.put(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow createRowEqualDimension(float f2, float f3, float f4, SolverVariable solverVariable, int i2, SolverVariable solverVariable2, int i3, SolverVariable solverVariable3, int i4, SolverVariable solverVariable4, int i5) {
        if (f3 == 0.0f || f2 == f4) {
            this.constantValue = (float) (((-i2) - i3) + i4 + i5);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.constantValue = ((float) ((-i2) - i3)) + (((float) i4) * f5) + (((float) i5) * f5);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f5);
            this.variables.put(solverVariable3, -f5);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
        } else if (f2 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.constantValue = (float) ((-i2) + i3);
            }
        } else if (f2 <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = (float) i2;
        } else if (f2 >= 1.0f) {
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.constantValue = (float) i3;
        } else {
            this.variables.put(solverVariable, (1.0f - f2) * 1.0f);
            this.variables.put(solverVariable2, (1.0f - f2) * -1.0f);
            this.variables.put(solverVariable3, -1.0f * f2);
            this.variables.put(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.constantValue = (((float) (-i2)) * (1.0f - f2)) + (((float) i3) * f2);
            }
        }
        return this;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i2) {
        this.variables.put(linearSystem.createErrorVariable(i2, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i2, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f - f2);
        this.variables.put(solverVariable3, f2);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f2);
        this.variables.put(solverVariable4, -f2);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public int sizeInBytes() {
        int i2 = 0;
        if (this.variable != null) {
            i2 = 4;
        }
        return i2 + 4 + 4 + this.variables.sizeInBytes();
    }

    /* access modifiers changed from: package-private */
    public void ensurePositiveConstant() {
        if (this.constantValue < 0.0f) {
            this.constantValue *= -1.0f;
            this.variables.invert();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z = false;
        SolverVariable chooseSubject = this.variables.chooseSubject(linearSystem);
        if (chooseSubject == null) {
            z = true;
        } else {
            pivot(chooseSubject);
        }
        if (this.variables.currentSize == 0) {
            this.isSimpleDefinition = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return this.variables.getPivotCandidate(null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public void pivot(SolverVariable solverVariable) {
        if (this.variable != null) {
            this.variables.put(this.variable, -1.0f);
            this.variable = null;
        }
        float remove = this.variables.remove(solverVariable, true) * -1.0f;
        this.variable = solverVariable;
        if (remove != 1.0f) {
            this.constantValue /= remove;
            this.variables.divideByAmount(remove);
        }
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.currentSize == 0;
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return this.variables.getPivotCandidate(zArr, null);
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i2 = 0; i2 < arrayRow.variables.currentSize; i2++) {
                this.variables.add(arrayRow.variables.getVariable(i2), arrayRow.variables.getVariableValue(i2), true);
            }
        }
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        float f2 = 1.0f;
        if (solverVariable.strength != 1) {
            if (solverVariable.strength == 2) {
                f2 = 1000.0f;
            } else if (solverVariable.strength == 3) {
                f2 = 1000000.0f;
            } else if (solverVariable.strength == 4) {
                f2 = 1.0E9f;
            } else if (solverVariable.strength == 5) {
                f2 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f2);
    }

    @Override // android.support.constraint.solver.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }
}
