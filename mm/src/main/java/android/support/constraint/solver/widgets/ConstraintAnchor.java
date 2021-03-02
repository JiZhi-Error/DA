package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.HashSet;

public class ConstraintAnchor {
    private static final boolean ALLOW_BINARY = false;
    public static final int AUTO_CONSTRAINT_CREATOR = 2;
    public static final int SCOUT_CREATOR = 1;
    private static final int UNSET_GONE_MARGIN = -1;
    public static final int USER_CREATOR = 0;
    private int mConnectionCreator = 0;
    private ConnectionType mConnectionType = ConnectionType.RELAXED;
    int mGoneMargin = -1;
    public int mMargin = 0;
    final ConstraintWidget mOwner;
    private ResolutionAnchor mResolutionAnchor = new ResolutionAnchor(this);
    SolverVariable mSolverVariable;
    private Strength mStrength = Strength.NONE;
    ConstraintAnchor mTarget;
    final Type mType;

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ResolutionAnchor getResolutionNode() {
        return this.mResolutionAnchor;
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.mOwner = constraintWidget;
        this.mType = type;
    }

    public SolverVariable getSolverVariable() {
        return this.mSolverVariable;
    }

    public void resetSolverVariable(Cache cache) {
        if (this.mSolverVariable == null) {
            this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            this.mSolverVariable.reset();
        }
    }

    public ConstraintWidget getOwner() {
        return this.mOwner;
    }

    public Type getType() {
        return this.mType;
    }

    public int getMargin() {
        if (this.mOwner.getVisibility() == 8) {
            return 0;
        }
        if (this.mGoneMargin < 0 || this.mTarget == null || this.mTarget.mOwner.getVisibility() != 8) {
            return this.mMargin;
        }
        return this.mGoneMargin;
    }

    public Strength getStrength() {
        return this.mStrength;
    }

    public ConstraintAnchor getTarget() {
        return this.mTarget;
    }

    public ConnectionType getConnectionType() {
        return this.mConnectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.mConnectionType = connectionType;
    }

    public int getConnectionCreator() {
        return this.mConnectionCreator;
    }

    public void setConnectionCreator(int i2) {
        this.mConnectionCreator = i2;
    }

    public void reset() {
        this.mTarget = null;
        this.mMargin = 0;
        this.mGoneMargin = -1;
        this.mStrength = Strength.STRONG;
        this.mConnectionCreator = 0;
        this.mConnectionType = ConnectionType.RELAXED;
        this.mResolutionAnchor.reset();
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2, Strength strength, int i3) {
        return connect(constraintAnchor, i2, -1, strength, i3, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2, int i3, Strength strength, int i4, boolean z) {
        if (constraintAnchor == null) {
            this.mTarget = null;
            this.mMargin = 0;
            this.mGoneMargin = -1;
            this.mStrength = Strength.NONE;
            this.mConnectionCreator = 2;
            return true;
        } else if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        } else {
            this.mTarget = constraintAnchor;
            if (i2 > 0) {
                this.mMargin = i2;
            } else {
                this.mMargin = 0;
            }
            this.mGoneMargin = i3;
            this.mStrength = strength;
            this.mConnectionCreator = i4;
            return true;
        }
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2, int i3) {
        return connect(constraintAnchor, i2, -1, Strength.STRONG, i3, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2) {
        return connect(constraintAnchor, i2, -1, Strength.STRONG, 0, false);
    }

    public boolean isConnected() {
        return this.mTarget != null;
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        boolean z;
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        if (type == this.mType) {
            return this.mType != Type.BASELINE || (constraintAnchor.getOwner().hasBaseline() && getOwner().hasBaseline());
        }
        switch (this.mType) {
            case CENTER:
                return (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                if (type == Type.LEFT || type == Type.RIGHT) {
                    z = true;
                } else {
                    z = false;
                }
                if (constraintAnchor.getOwner() instanceof Guideline) {
                    return z || type == Type.CENTER_X;
                }
                break;
            case TOP:
            case BOTTOM:
                if (type == Type.TOP || type == Type.BOTTOM) {
                    z = true;
                } else {
                    z = false;
                }
                if (constraintAnchor.getOwner() instanceof Guideline) {
                    return z || type == Type.CENTER_Y;
                }
                break;
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new AssertionError(this.mType.name());
        }
        return z;
    }

    public boolean isSideAnchor() {
        switch (this.mType) {
            case CENTER:
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            case LEFT:
            case RIGHT:
            case TOP:
            case BOTTOM:
                return true;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        Type type = constraintAnchor.getType();
        if (type == this.mType) {
            return true;
        }
        switch (this.mType) {
            case CENTER:
                return type != Type.BASELINE;
            case LEFT:
            case RIGHT:
            case CENTER_X:
                return type == Type.LEFT || type == Type.RIGHT || type == Type.CENTER_X;
            case TOP:
            case BOTTOM:
            case BASELINE:
            case CENTER_Y:
                return type == Type.TOP || type == Type.BOTTOM || type == Type.CENTER_Y || type == Type.BASELINE;
            case NONE:
                return false;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public void setStrength(Strength strength) {
        if (isConnected()) {
            this.mStrength = strength;
        }
    }

    public void setMargin(int i2) {
        if (isConnected()) {
            this.mMargin = i2;
        }
    }

    public void setGoneMargin(int i2) {
        if (isConnected()) {
            this.mGoneMargin = i2;
        }
    }

    public boolean isVerticalAnchor() {
        switch (this.mType) {
            case CENTER:
            case LEFT:
            case RIGHT:
            case CENTER_X:
                return false;
            case TOP:
            case BOTTOM:
            case BASELINE:
            case CENTER_Y:
            case NONE:
                return true;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public String toString() {
        return this.mOwner.getDebugName() + ":" + this.mType.toString();
    }

    public int getSnapPriorityLevel() {
        switch (this.mType) {
            case CENTER:
                return 3;
            case LEFT:
            case RIGHT:
            case CENTER_Y:
                return 1;
            case TOP:
                return 0;
            case BOTTOM:
                return 0;
            case BASELINE:
                return 2;
            case CENTER_X:
                return 0;
            case NONE:
                return 0;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public int getPriorityLevel() {
        switch (this.mType) {
            case CENTER:
                return 2;
            case LEFT:
                return 2;
            case RIGHT:
                return 2;
            case TOP:
                return 2;
            case BOTTOM:
                return 2;
            case BASELINE:
                return 1;
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return 0;
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public boolean isSnapCompatibleWith(ConstraintAnchor constraintAnchor) {
        if (this.mType == Type.CENTER) {
            return false;
        }
        if (this.mType == constraintAnchor.getType()) {
            return true;
        }
        switch (this.mType) {
            case CENTER:
            case BASELINE:
            case NONE:
                return false;
            case LEFT:
                switch (constraintAnchor.getType()) {
                    case RIGHT:
                        return true;
                    case CENTER_X:
                        return true;
                    default:
                        return false;
                }
            case RIGHT:
                switch (constraintAnchor.getType()) {
                    case LEFT:
                        return true;
                    case CENTER_X:
                        return true;
                    default:
                        return false;
                }
            case TOP:
                switch (constraintAnchor.getType()) {
                    case BOTTOM:
                        return true;
                    case BASELINE:
                    case CENTER_X:
                    default:
                        return false;
                    case CENTER_Y:
                        return true;
                }
            case BOTTOM:
                switch (constraintAnchor.getType()) {
                    case TOP:
                        return true;
                    case CENTER_Y:
                        return true;
                    default:
                        return false;
                }
            case CENTER_X:
                switch (constraintAnchor.getType()) {
                    case LEFT:
                        return true;
                    case RIGHT:
                        return true;
                    default:
                        return false;
                }
            case CENTER_Y:
                switch (constraintAnchor.getType()) {
                    case TOP:
                        return true;
                    case BOTTOM:
                        return true;
                    default:
                        return false;
                }
            default:
                throw new AssertionError(this.mType.name());
        }
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return isConnectionAllowed(constraintWidget);
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (isConnectionToMe(constraintWidget, new HashSet<>())) {
            return false;
        }
        ConstraintWidget parent = getOwner().getParent();
        if (parent == constraintWidget) {
            return true;
        }
        return constraintWidget.getParent() == parent;
    }

    private boolean isConnectionToMe(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == getOwner()) {
            return true;
        }
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = anchors.get(i2);
            if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && isConnectionToMe(constraintAnchor.getTarget().getOwner(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public final ConstraintAnchor getOpposite() {
        switch (this.mType) {
            case CENTER:
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
            case LEFT:
                return this.mOwner.mRight;
            case RIGHT:
                return this.mOwner.mLeft;
            case TOP:
                return this.mOwner.mBottom;
            case BOTTOM:
                return this.mOwner.mTop;
            default:
                throw new AssertionError(this.mType.name());
        }
    }
}
