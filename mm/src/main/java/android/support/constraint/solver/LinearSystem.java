package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    private static final boolean DEBUG = false;
    public static final boolean FULL_DEBUG = false;
    private static int POOL_SIZE = 1000;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private final Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    private ArrayRow[] tempClientsCopy;

    /* access modifiers changed from: package-private */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();
    }

    public LinearSystem() {
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = this.TABLE_SIZE;
        this.mRows = null;
        this.graphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = this.TABLE_SIZE;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.tempClientsCopy = new ArrayRow[this.TABLE_SIZE];
        this.mRows = new ArrayRow[this.TABLE_SIZE];
        releaseRows();
        this.mCache = new Cache();
        this.mGoal = new GoalRow(this.mCache);
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        this.TABLE_SIZE *= 2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, this.TABLE_SIZE);
        this.mCache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(this.mCache.mIndexedVariables, this.TABLE_SIZE);
        this.mAlreadyTestedCandidates = new boolean[this.TABLE_SIZE];
        this.mMaxColumns = this.TABLE_SIZE;
        this.mMaxRows = this.TABLE_SIZE;
        if (sMetrics != null) {
            sMetrics.tableSizeIncrease++;
            Metrics metrics = sMetrics;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, (long) this.TABLE_SIZE);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private void releaseRows() {
        for (int i2 = 0; i2 < this.mRows.length; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow != null) {
                this.mCache.arrayRowPool.release(arrayRow);
            }
            this.mRows[i2] = null;
        }
    }

    public void reset() {
        for (int i2 = 0; i2 < this.mCache.mIndexedVariables.length; i2++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i2];
            if (solverVariable != null) {
                solverVariable.reset();
            }
        }
        this.mCache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        if (this.mVariables != null) {
            this.mVariables.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            this.mRows[i3].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj != null) {
            if (this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            if (obj instanceof ConstraintAnchor) {
                solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
                if (solverVariable == null) {
                    ((ConstraintAnchor) obj).resetSolverVariable(this.mCache);
                    solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
                }
                if (solverVariable.id == -1 || solverVariable.id > this.mVariablesID || this.mCache.mIndexedVariables[solverVariable.id] == null) {
                    if (solverVariable.id != -1) {
                        solverVariable.reset();
                    }
                    this.mVariablesID++;
                    this.mNumColumns++;
                    solverVariable.id = this.mVariablesID;
                    solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                    this.mCache.mIndexedVariables[this.mVariablesID] = solverVariable;
                }
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire = this.mCache.arrayRowPool.acquire();
        if (acquire == null) {
            acquire = new ArrayRow(this.mCache);
        } else {
            acquire.reset();
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        if (sMetrics != null) {
            sMetrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        if (sMetrics != null) {
            sMetrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private void addSingleError(ArrayRow arrayRow, int i2) {
        addSingleError(arrayRow, i2, 0);
    }

    /* access modifiers changed from: package-private */
    public void addSingleError(ArrayRow arrayRow, int i2, int i3) {
        arrayRow.addSingleError(createErrorVariable(i3, null), i2);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        if (sMetrics != null) {
            sMetrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createErrorVariable(int i2, String str) {
        if (sMetrics != null) {
            sMetrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        this.mVariablesID++;
        this.mNumColumns++;
        acquireSolverVariable.id = this.mVariablesID;
        acquireSolverVariable.strength = i2;
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariable;
        SolverVariable acquire = this.mCache.solverVariablePool.acquire();
        if (acquire == null) {
            SolverVariable solverVariable2 = new SolverVariable(type, str);
            solverVariable2.setType(type, str);
            solverVariable = solverVariable2;
        } else {
            acquire.reset();
            acquire.setType(type, str);
            solverVariable = acquire;
        }
        if (this.mPoolVariablesCount >= POOL_SIZE) {
            POOL_SIZE *= 2;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, POOL_SIZE);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i2 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i2 + 1;
        solverVariableArr[i2] = solverVariable;
        return solverVariable;
    }

    /* access modifiers changed from: package-private */
    public Row getGoal() {
        return this.mGoal;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow getRow(int i2) {
        return this.mRows[i2];
    }

    /* access modifiers changed from: package-private */
    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        if (solverVariable == null) {
            return createVariable(str, type);
        }
        return solverVariable;
    }

    public void minimize() {
        boolean z = false;
        if (sMetrics != null) {
            sMetrics.minimize++;
        }
        if (this.graphOptimizer) {
            if (sMetrics != null) {
                sMetrics.graphOptimizer++;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.mNumRows) {
                    z = true;
                    break;
                } else if (!this.mRows[i2].isSimpleDefinition) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                if (sMetrics != null) {
                    sMetrics.fullySolved++;
                }
                computeValues();
                return;
            }
        }
        minimizeGoal(this.mGoal);
    }

    /* access modifiers changed from: package-private */
    public void minimizeGoal(Row row) {
        if (sMetrics != null) {
            sMetrics.minimizeGoal++;
            Metrics metrics = sMetrics;
            metrics.maxVariables = Math.max(metrics.maxVariables, (long) this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, (long) this.mNumRows);
        }
        updateRowFromVariables((ArrayRow) row);
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    private final void updateRowFromVariables(ArrayRow arrayRow) {
        if (this.mNumRows > 0) {
            arrayRow.variables.updateFromSystem(arrayRow, this.mRows);
            if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
            }
        }
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        boolean z = true;
        if (arrayRow != null) {
            if (sMetrics != null) {
                sMetrics.constraints++;
                if (arrayRow.isSimpleDefinition) {
                    sMetrics.simpleconstraints++;
                }
            }
            if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            if (!arrayRow.isSimpleDefinition) {
                updateRowFromVariables(arrayRow);
                if (!arrayRow.isEmpty()) {
                    arrayRow.ensurePositiveConstant();
                    if (arrayRow.chooseSubject(this)) {
                        SolverVariable createExtraVariable = createExtraVariable();
                        arrayRow.variable = createExtraVariable;
                        addRow(arrayRow);
                        this.mTempGoal.initFromRow(arrayRow);
                        optimize(this.mTempGoal, true);
                        if (createExtraVariable.definitionId == -1) {
                            if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                                if (sMetrics != null) {
                                    sMetrics.pivots++;
                                }
                                arrayRow.pivot(pickPivot);
                            }
                            if (!arrayRow.isSimpleDefinition) {
                                arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                            }
                            this.mNumRows--;
                        }
                    } else {
                        z = false;
                    }
                    if (!arrayRow.hasKeyVariable()) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                z = false;
            }
            if (!z) {
                addRow(arrayRow);
            }
        }
    }

    private final void addRow(ArrayRow arrayRow) {
        if (this.mRows[this.mNumRows] != null) {
            this.mCache.arrayRowPool.release(this.mRows[this.mNumRows]);
        }
        this.mRows[this.mNumRows] = arrayRow;
        arrayRow.variable.definitionId = this.mNumRows;
        this.mNumRows++;
        arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 155
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    private final int optimize(android.support.constraint.solver.LinearSystem.Row r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.LinearSystem.optimize(android.support.constraint.solver.LinearSystem$Row, boolean):int");
    }

    private int enforceBFS(Row row) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= this.mNumRows) {
                z = false;
                break;
            }
            if (this.mRows[i7].variable.mType != SolverVariable.Type.UNRESTRICTED && this.mRows[i7].constantValue < 0.0f) {
                z = true;
                break;
            }
            i7++;
        }
        if (z) {
            boolean z3 = false;
            i6 = 0;
            while (!z3) {
                if (sMetrics != null) {
                    sMetrics.bfs++;
                }
                int i8 = i6 + 1;
                float f2 = Float.MAX_VALUE;
                int i9 = 0;
                int i10 = -1;
                int i11 = -1;
                for (int i12 = 0; i12 < this.mNumRows; i12++) {
                    ArrayRow arrayRow = this.mRows[i12];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < 0.0f) {
                        int i13 = 1;
                        int i14 = i11;
                        int i15 = i10;
                        int i16 = i9;
                        float f3 = f2;
                        while (i13 < this.mNumColumns) {
                            SolverVariable solverVariable = this.mCache.mIndexedVariables[i13];
                            float f4 = arrayRow.variables.get(solverVariable);
                            if (f4 > 0.0f) {
                                int i17 = 0;
                                int i18 = i14;
                                i3 = i15;
                                i4 = i16;
                                while (i17 < 7) {
                                    float f5 = solverVariable.strengthVector[i17] / f4;
                                    if ((f5 >= f3 || i17 != i4) && i17 <= i4) {
                                        i5 = i3;
                                        f5 = f3;
                                    } else {
                                        i18 = i13;
                                        i5 = i12;
                                        i4 = i17;
                                    }
                                    i17++;
                                    i3 = i5;
                                    f3 = f5;
                                }
                                i2 = i18;
                            } else {
                                i2 = i14;
                                i3 = i15;
                                i4 = i16;
                            }
                            i13++;
                            i14 = i2;
                            i15 = i3;
                            i16 = i4;
                        }
                        i11 = i14;
                        i10 = i15;
                        i9 = i16;
                        f2 = f3;
                    }
                }
                if (i10 != -1) {
                    ArrayRow arrayRow2 = this.mRows[i10];
                    arrayRow2.variable.definitionId = -1;
                    if (sMetrics != null) {
                        sMetrics.pivots++;
                    }
                    arrayRow2.pivot(this.mCache.mIndexedVariables[i11]);
                    arrayRow2.variable.definitionId = i10;
                    arrayRow2.variable.updateReferencesWithNewDefinition(arrayRow2);
                    z2 = z3;
                } else {
                    z2 = true;
                }
                if (i8 > this.mNumColumns / 2) {
                    z2 = true;
                }
                z3 = z2;
                i6 = i8;
            }
        }
        return i6;
    }

    private void computeValues() {
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            str = (str + this.mRows[i2]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    /* access modifiers changed from: package-private */
    public void displayReadableRows() {
        displaySolverVariables();
        String str = " #  ";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            str = (str + this.mRows[i2].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str = str + this.mGoal + "\n";
        }
        System.out.println(str);
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            if (this.mRows[i2].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i2].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public int getMemoryUsed() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            if (this.mRows[i3] != null) {
                i2 = this.mRows[i3].sizeInBytes() + i2;
            } else {
                i2 = i2;
            }
        }
        return i2;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    /* access modifiers changed from: package-private */
    public void displaySystemInformations() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.TABLE_SIZE; i3++) {
            if (this.mRows[i3] != null) {
                i2 += this.mRows[i3].sizeInBytes();
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            if (this.mRows[i5] != null) {
                i4 += this.mRows[i5].sizeInBytes();
            }
        }
        System.out.println("Linear System -> Table size: " + this.TABLE_SIZE + " (" + getDisplaySize(this.TABLE_SIZE * this.TABLE_SIZE) + ") -- row sizes: " + getDisplaySize(i2) + ", actual size: " + getDisplaySize(i4) + " rows: " + this.mNumRows + FilePathGenerator.ANDROID_DIR_SEP + this.mMaxRows + " cols: " + this.mNumColumns + FilePathGenerator.ANDROID_DIR_SEP + this.mMaxColumns + " 0 occupied cells, " + getDisplaySize(0));
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private String getDisplaySize(int i2) {
        int i3 = ((i2 * 4) / 1024) / 1024;
        if (i3 > 0) {
            return i3 + " Mb";
        }
        int i4 = (i2 * 4) / 1024;
        if (i4 > 0) {
            return i4 + " Kb";
        }
        return (i2 * 4) + " bytes";
    }

    public Cache getCache() {
        return this.mCache;
    }

    private String getDisplayStrength(int i2) {
        if (i2 == 1) {
            return "LOW";
        }
        if (i2 == 2) {
            return "MEDIUM";
        }
        if (i2 == 3) {
            return "HIGH";
        }
        if (i2 == 4) {
            return "HIGHEST";
        }
        if (i2 == 5) {
            return "EQUALITY";
        }
        if (i2 == 6) {
            return "FIXED";
        }
        return "NONE";
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (i3 != 6) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i3);
        }
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, i2, createSlackVariable);
        addConstraint(createRow);
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, 0);
        if (z) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), 1);
        }
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (i3 != 6) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i3);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, 0);
        if (z) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), 1);
        }
        addConstraint(createRow);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i4 != 6) {
            createRow.addError(this, i4);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 6) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i2);
        if (i3 != 6) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        int i3 = solverVariable.definitionId;
        if (solverVariable.definitionId != -1) {
            ArrayRow arrayRow = this.mRows[i3];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i2;
            } else if (arrayRow.variables.currentSize == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = (float) i2;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i2);
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.createRowDefinition(solverVariable, i2);
            addConstraint(createRow2);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i2, int i3) {
        int i4 = solverVariable.definitionId;
        if (solverVariable.definitionId != -1) {
            ArrayRow arrayRow = this.mRows[i4];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i2;
                return;
            }
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, i2);
            createRow.addError(this, i3);
            addConstraint(createRow);
            return;
        }
        ArrayRow createRow2 = createRow();
        createRow2.createRowDefinition(solverVariable, i2);
        createRow2.addError(this, i3);
        addConstraint(createRow2);
    }

    public static ArrayRow createRowEquals(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i2);
        if (z) {
            linearSystem.addSingleError(createRow, 1);
        }
        return createRow;
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        if (z) {
            linearSystem.addError(createRow);
        }
        return createRow.createRowDimensionPercent(solverVariable, solverVariable2, solverVariable3, f2);
    }

    public static ArrayRow createRowGreaterThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (z) {
            linearSystem.addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f));
        }
        return createRow;
    }

    public static ArrayRow createRowLowerThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (z) {
            linearSystem.addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f));
        }
        return createRow;
    }

    public static ArrayRow createRowCentering(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (z) {
            createRow.addError(linearSystem, 4);
        }
        return createRow;
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow createRow = createRow();
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin((double) f2) * ((double) i2)));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos((double) f2) * ((double) i2)));
        addConstraint(createRow2);
    }
}
