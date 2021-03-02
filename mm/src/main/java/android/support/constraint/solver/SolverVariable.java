package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    public int id;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    public int usageInRowCount;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        switch (type) {
            case UNRESTRICTED:
                StringBuilder sb = new StringBuilder("U");
                int i2 = uniqueUnrestrictedId + 1;
                uniqueUnrestrictedId = i2;
                return sb.append(i2).toString();
            case CONSTANT:
                StringBuilder sb2 = new StringBuilder("C");
                int i3 = uniqueConstantId + 1;
                uniqueConstantId = i3;
                return sb2.append(i3).toString();
            case SLACK:
                StringBuilder sb3 = new StringBuilder("S");
                int i4 = uniqueSlackId + 1;
                uniqueSlackId = i4;
                return sb3.append(i4).toString();
            case ERROR:
                StringBuilder sb4 = new StringBuilder("e");
                int i5 = uniqueErrorId + 1;
                uniqueErrorId = i5;
                return sb4.append(i5).toString();
            case UNKNOWN:
                StringBuilder sb5 = new StringBuilder("V");
                int i6 = uniqueId + 1;
                uniqueId = i6;
                return sb5.append(i6).toString();
            default:
                throw new AssertionError(type.name());
        }
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mName = str;
        this.mType = type;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.strengthVector = new float[7];
        this.mClientEquations = new ArrayRow[8];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mType = type;
    }

    /* access modifiers changed from: package-private */
    public void clearStrengths() {
        for (int i2 = 0; i2 < 7; i2++) {
            this.strengthVector[i2] = 0.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public String strengthsToString() {
        String str = this + "[";
        boolean z = true;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.strengthVector.length; i2++) {
            String str2 = str + this.strengthVector[i2];
            if (this.strengthVector[i2] > 0.0f) {
                z2 = false;
            } else if (this.strengthVector[i2] < 0.0f) {
                z2 = true;
            }
            if (this.strengthVector[i2] != 0.0f) {
                z = false;
            }
            str = i2 < this.strengthVector.length - 1 ? str2 + ", " : str2 + "] ";
        }
        String str3 = z2 ? str + " (-)" : str;
        if (z) {
            return str3 + " (*)";
        }
        return str3;
    }

    public final void addToRow(ArrayRow arrayRow) {
        for (int i2 = 0; i2 < this.mClientEquationsCount; i2++) {
            if (this.mClientEquations[i2] == arrayRow) {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        this.mClientEquationsCount++;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i2 = this.mClientEquationsCount;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mClientEquations[i3] == arrayRow) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    this.mClientEquations[i3 + i4] = this.mClientEquations[i3 + i4 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i2 = this.mClientEquationsCount;
        for (int i3 = 0; i3 < i2; i3++) {
            this.mClientEquations[i3].variables.updateFromRow(this.mClientEquations[i3], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String toString() {
        return "" + this.mName;
    }
}
