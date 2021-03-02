package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.constraint.R;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 74;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINT_REFERENCED_IDS = 73;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 75;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(55, 25);
        mapToConstant.append(56, 26);
        mapToConstant.append(58, 29);
        mapToConstant.append(59, 30);
        mapToConstant.append(64, 36);
        mapToConstant.append(63, 35);
        mapToConstant.append(37, 4);
        mapToConstant.append(36, 3);
        mapToConstant.append(34, 1);
        mapToConstant.append(72, 6);
        mapToConstant.append(73, 7);
        mapToConstant.append(44, 17);
        mapToConstant.append(45, 18);
        mapToConstant.append(46, 19);
        mapToConstant.append(0, 27);
        mapToConstant.append(60, 32);
        mapToConstant.append(61, 33);
        mapToConstant.append(43, 10);
        mapToConstant.append(42, 9);
        mapToConstant.append(76, 13);
        mapToConstant.append(79, 16);
        mapToConstant.append(77, 14);
        mapToConstant.append(74, 11);
        mapToConstant.append(78, 15);
        mapToConstant.append(UNUSED, 12);
        mapToConstant.append(67, 40);
        mapToConstant.append(53, 39);
        mapToConstant.append(52, 41);
        mapToConstant.append(66, 42);
        mapToConstant.append(51, 20);
        mapToConstant.append(65, 37);
        mapToConstant.append(41, 5);
        mapToConstant.append(54, UNUSED);
        mapToConstant.append(62, UNUSED);
        mapToConstant.append(57, UNUSED);
        mapToConstant.append(35, UNUSED);
        mapToConstant.append(33, UNUSED);
        mapToConstant.append(5, 24);
        mapToConstant.append(7, 28);
        mapToConstant.append(23, 31);
        mapToConstant.append(24, 8);
        mapToConstant.append(6, 34);
        mapToConstant.append(8, 2);
        mapToConstant.append(3, 23);
        mapToConstant.append(4, 21);
        mapToConstant.append(2, 22);
        mapToConstant.append(13, 43);
        mapToConstant.append(26, 44);
        mapToConstant.append(21, 45);
        mapToConstant.append(22, 46);
        mapToConstant.append(20, 60);
        mapToConstant.append(18, 47);
        mapToConstant.append(19, 48);
        mapToConstant.append(14, 49);
        mapToConstant.append(15, 50);
        mapToConstant.append(16, 51);
        mapToConstant.append(17, 52);
        mapToConstant.append(25, 53);
        mapToConstant.append(68, 54);
        mapToConstant.append(47, 55);
        mapToConstant.append(69, 56);
        mapToConstant.append(48, 57);
        mapToConstant.append(70, 58);
        mapToConstant.append(49, 59);
        mapToConstant.append(38, 61);
        mapToConstant.append(40, 62);
        mapToConstant.append(39, 63);
        mapToConstant.append(1, 38);
        mapToConstant.append(CHAIN_USE_RTL, 69);
        mapToConstant.append(50, 70);
        mapToConstant.append(29, CHAIN_USE_RTL);
        mapToConstant.append(28, 72);
        mapToConstant.append(30, 73);
        mapToConstant.append(27, 74);
    }

    public Constraint getParameters(int i2) {
        return get(i2);
    }

    /* access modifiers changed from: package-private */
    public static class Constraint {
        static final int UNSET = -1;
        public float alpha;
        public boolean applyElevation;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public float elevation;
        public int endMargin;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mHeight;
        public int mHelperType;
        boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        int mViewId;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int visibility;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        private Constraint() {
            this.mIsGuideline = false;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.endMargin = -1;
            this.startMargin = -1;
            this.visibility = 0;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneEndMargin = -1;
            this.goneStartMargin = -1;
            this.verticalWeight = 0.0f;
            this.horizontalWeight = 0.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = Float.NaN;
            this.transformPivotY = Float.NaN;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = -1;
            this.heightMax = -1;
            this.widthMin = -1;
            this.heightMin = -1;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierAllowsGoneWidgets = false;
            this.mBarrierDirection = -1;
            this.mHelperType = -1;
        }

        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.mIsGuideline = this.mIsGuideline;
            constraint.mWidth = this.mWidth;
            constraint.mHeight = this.mHeight;
            constraint.guideBegin = this.guideBegin;
            constraint.guideEnd = this.guideEnd;
            constraint.guidePercent = this.guidePercent;
            constraint.leftToLeft = this.leftToLeft;
            constraint.leftToRight = this.leftToRight;
            constraint.rightToLeft = this.rightToLeft;
            constraint.rightToRight = this.rightToRight;
            constraint.topToTop = this.topToTop;
            constraint.topToBottom = this.topToBottom;
            constraint.bottomToTop = this.bottomToTop;
            constraint.bottomToBottom = this.bottomToBottom;
            constraint.baselineToBaseline = this.baselineToBaseline;
            constraint.startToEnd = this.startToEnd;
            constraint.startToStart = this.startToStart;
            constraint.endToStart = this.endToStart;
            constraint.endToEnd = this.endToEnd;
            constraint.horizontalBias = this.horizontalBias;
            constraint.verticalBias = this.verticalBias;
            constraint.dimensionRatio = this.dimensionRatio;
            constraint.editorAbsoluteX = this.editorAbsoluteX;
            constraint.editorAbsoluteY = this.editorAbsoluteY;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.orientation = this.orientation;
            constraint.leftMargin = this.leftMargin;
            constraint.rightMargin = this.rightMargin;
            constraint.topMargin = this.topMargin;
            constraint.bottomMargin = this.bottomMargin;
            constraint.endMargin = this.endMargin;
            constraint.startMargin = this.startMargin;
            constraint.visibility = this.visibility;
            constraint.goneLeftMargin = this.goneLeftMargin;
            constraint.goneTopMargin = this.goneTopMargin;
            constraint.goneRightMargin = this.goneRightMargin;
            constraint.goneBottomMargin = this.goneBottomMargin;
            constraint.goneEndMargin = this.goneEndMargin;
            constraint.goneStartMargin = this.goneStartMargin;
            constraint.verticalWeight = this.verticalWeight;
            constraint.horizontalWeight = this.horizontalWeight;
            constraint.horizontalChainStyle = this.horizontalChainStyle;
            constraint.verticalChainStyle = this.verticalChainStyle;
            constraint.alpha = this.alpha;
            constraint.applyElevation = this.applyElevation;
            constraint.elevation = this.elevation;
            constraint.rotation = this.rotation;
            constraint.rotationX = this.rotationX;
            constraint.rotationY = this.rotationY;
            constraint.scaleX = this.scaleX;
            constraint.scaleY = this.scaleY;
            constraint.transformPivotX = this.transformPivotX;
            constraint.transformPivotY = this.transformPivotY;
            constraint.translationX = this.translationX;
            constraint.translationY = this.translationY;
            constraint.translationZ = this.translationZ;
            constraint.constrainedWidth = this.constrainedWidth;
            constraint.constrainedHeight = this.constrainedHeight;
            constraint.widthDefault = this.widthDefault;
            constraint.heightDefault = this.heightDefault;
            constraint.widthMax = this.widthMax;
            constraint.heightMax = this.heightMax;
            constraint.widthMin = this.widthMin;
            constraint.heightMin = this.heightMin;
            constraint.widthPercent = this.widthPercent;
            constraint.heightPercent = this.heightPercent;
            constraint.mBarrierDirection = this.mBarrierDirection;
            constraint.mHelperType = this.mHelperType;
            if (this.mReferenceIds != null) {
                constraint.mReferenceIds = Arrays.copyOf(this.mReferenceIds, this.mReferenceIds.length);
            }
            constraint.circleConstraint = this.circleConstraint;
            constraint.circleRadius = this.circleRadius;
            constraint.circleAngle = this.circleAngle;
            constraint.mBarrierAllowsGoneWidgets = this.mBarrierAllowsGoneWidgets;
            return constraint;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void fillFromConstraints(ConstraintHelper constraintHelper, int i2, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i2, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.mBarrierDirection = barrier.getType();
                this.mReferenceIds = barrier.getReferencedIds();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void fillFromConstraints(int i2, Constraints.LayoutParams layoutParams) {
            fillFrom(i2, layoutParams);
            this.alpha = layoutParams.alpha;
            this.rotation = layoutParams.rotation;
            this.rotationX = layoutParams.rotationX;
            this.rotationY = layoutParams.rotationY;
            this.scaleX = layoutParams.scaleX;
            this.scaleY = layoutParams.scaleY;
            this.transformPivotX = layoutParams.transformPivotX;
            this.transformPivotY = layoutParams.transformPivotY;
            this.translationX = layoutParams.translationX;
            this.translationY = layoutParams.translationY;
            this.translationZ = layoutParams.translationZ;
            this.elevation = layoutParams.elevation;
            this.applyElevation = layoutParams.applyElevation;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void fillFrom(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = i2;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.guidePercent = layoutParams.guidePercent;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.mWidth = layoutParams.width;
            this.mHeight = layoutParams.height;
            this.leftMargin = layoutParams.leftMargin;
            this.rightMargin = layoutParams.rightMargin;
            this.topMargin = layoutParams.topMargin;
            this.bottomMargin = layoutParams.bottomMargin;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.widthDefault = layoutParams.matchConstraintDefaultWidth;
            this.heightDefault = layoutParams.matchConstraintDefaultHeight;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.widthMax = layoutParams.matchConstraintMaxWidth;
            this.heightMax = layoutParams.matchConstraintMaxHeight;
            this.widthMin = layoutParams.matchConstraintMinWidth;
            this.heightMin = layoutParams.matchConstraintMinHeight;
            this.widthPercent = layoutParams.matchConstraintPercentWidth;
            this.heightPercent = layoutParams.matchConstraintPercentHeight;
            if (Build.VERSION.SDK_INT >= 17) {
                this.endMargin = layoutParams.getMarginEnd();
                this.startMargin = layoutParams.getMarginStart();
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.leftToLeft = this.leftToLeft;
            layoutParams.leftToRight = this.leftToRight;
            layoutParams.rightToLeft = this.rightToLeft;
            layoutParams.rightToRight = this.rightToRight;
            layoutParams.topToTop = this.topToTop;
            layoutParams.topToBottom = this.topToBottom;
            layoutParams.bottomToTop = this.bottomToTop;
            layoutParams.bottomToBottom = this.bottomToBottom;
            layoutParams.baselineToBaseline = this.baselineToBaseline;
            layoutParams.startToEnd = this.startToEnd;
            layoutParams.startToStart = this.startToStart;
            layoutParams.endToStart = this.endToStart;
            layoutParams.endToEnd = this.endToEnd;
            layoutParams.leftMargin = this.leftMargin;
            layoutParams.rightMargin = this.rightMargin;
            layoutParams.topMargin = this.topMargin;
            layoutParams.bottomMargin = this.bottomMargin;
            layoutParams.goneStartMargin = this.goneStartMargin;
            layoutParams.goneEndMargin = this.goneEndMargin;
            layoutParams.horizontalBias = this.horizontalBias;
            layoutParams.verticalBias = this.verticalBias;
            layoutParams.circleConstraint = this.circleConstraint;
            layoutParams.circleRadius = this.circleRadius;
            layoutParams.circleAngle = this.circleAngle;
            layoutParams.dimensionRatio = this.dimensionRatio;
            layoutParams.editorAbsoluteX = this.editorAbsoluteX;
            layoutParams.editorAbsoluteY = this.editorAbsoluteY;
            layoutParams.verticalWeight = this.verticalWeight;
            layoutParams.horizontalWeight = this.horizontalWeight;
            layoutParams.verticalChainStyle = this.verticalChainStyle;
            layoutParams.horizontalChainStyle = this.horizontalChainStyle;
            layoutParams.constrainedWidth = this.constrainedWidth;
            layoutParams.constrainedHeight = this.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = this.widthDefault;
            layoutParams.matchConstraintDefaultHeight = this.heightDefault;
            layoutParams.matchConstraintMaxWidth = this.widthMax;
            layoutParams.matchConstraintMaxHeight = this.heightMax;
            layoutParams.matchConstraintMinWidth = this.widthMin;
            layoutParams.matchConstraintMinHeight = this.heightMin;
            layoutParams.matchConstraintPercentWidth = this.widthPercent;
            layoutParams.matchConstraintPercentHeight = this.heightPercent;
            layoutParams.orientation = this.orientation;
            layoutParams.guidePercent = this.guidePercent;
            layoutParams.guideBegin = this.guideBegin;
            layoutParams.guideEnd = this.guideEnd;
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mHeight;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.startMargin);
                layoutParams.setMarginEnd(this.endMargin);
            }
            layoutParams.validate();
        }
    }

    public void clone(Context context, int i2) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer num : constraintSet.mConstraints.keySet()) {
            this.mConstraints.put(num, constraintSet.mConstraints.get(num).clone());
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            constraint.fillFrom(id, layoutParams);
            constraint.visibility = childAt.getVisibility();
            if (Build.VERSION.SDK_INT >= 17) {
                constraint.alpha = childAt.getAlpha();
                constraint.rotation = childAt.getRotation();
                constraint.rotationX = childAt.getRotationX();
                constraint.rotationY = childAt.getRotationY();
                constraint.scaleX = childAt.getScaleX();
                constraint.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                    constraint.transformPivotX = pivotX;
                    constraint.transformPivotY = pivotY;
                }
                constraint.translationX = childAt.getTranslationX();
                constraint.translationY = childAt.getTranslationY();
                if (Build.VERSION.SDK_INT >= 21) {
                    constraint.translationZ = childAt.getTranslationZ();
                    if (constraint.applyElevation) {
                        constraint.elevation = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                constraint.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                constraint.mReferenceIds = barrier.getReferencedIds();
                constraint.mBarrierDirection = barrier.getType();
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
            }
            constraint.fillFromConstraints(id, layoutParams);
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    /* access modifiers changed from: package-private */
    public void applyToInternal(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.mConstraints.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    constraint.mHelperType = 1;
                }
                if (constraint.mHelperType != -1) {
                    switch (constraint.mHelperType) {
                        case 1:
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(constraint.mBarrierDirection);
                            barrier.setAllowsGoneWidget(constraint.mBarrierAllowsGoneWidgets);
                            if (constraint.mReferenceIds == null) {
                                if (constraint.mReferenceIdString != null) {
                                    constraint.mReferenceIds = convertReferenceString(barrier, constraint.mReferenceIdString);
                                    barrier.setReferencedIds(constraint.mReferenceIds);
                                    break;
                                }
                            } else {
                                barrier.setReferencedIds(constraint.mReferenceIds);
                                break;
                            }
                            break;
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                constraint.applyTo(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(constraint.visibility);
                if (Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(constraint.alpha);
                    childAt.setRotation(constraint.rotation);
                    childAt.setRotationX(constraint.rotationX);
                    childAt.setRotationY(constraint.rotationY);
                    childAt.setScaleX(constraint.scaleX);
                    childAt.setScaleY(constraint.scaleY);
                    if (!Float.isNaN(constraint.transformPivotX)) {
                        childAt.setPivotX(constraint.transformPivotX);
                    }
                    if (!Float.isNaN(constraint.transformPivotY)) {
                        childAt.setPivotY(constraint.transformPivotY);
                    }
                    childAt.setTranslationX(constraint.translationX);
                    childAt.setTranslationY(constraint.translationY);
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(constraint.translationZ);
                        if (constraint.applyElevation) {
                            childAt.setElevation(constraint.elevation);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2.mHelperType != -1) {
                switch (constraint2.mHelperType) {
                    case 1:
                        Barrier barrier2 = new Barrier(constraintLayout.getContext());
                        barrier2.setId(num.intValue());
                        if (constraint2.mReferenceIds != null) {
                            barrier2.setReferencedIds(constraint2.mReferenceIds);
                        } else if (constraint2.mReferenceIdString != null) {
                            constraint2.mReferenceIds = convertReferenceString(barrier2, constraint2.mReferenceIdString);
                            barrier2.setReferencedIds(constraint2.mReferenceIds);
                        }
                        barrier2.setType(constraint2.mBarrierDirection);
                        ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                        barrier2.validateParams();
                        constraint2.applyTo(generateDefaultLayoutParams);
                        constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                        break;
                }
            }
            if (constraint2.mIsGuideline) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void center(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        if (i5 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i8 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f2 <= 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i4 == 1 || i4 == 2) {
            connect(i2, 1, i3, i4, i5);
            connect(i2, 2, i6, i7, i8);
            this.mConstraints.get(Integer.valueOf(i2)).horizontalBias = f2;
        } else if (i4 == 6 || i4 == 7) {
            connect(i2, 6, i3, i4, i5);
            connect(i2, 7, i6, i7, i8);
            this.mConstraints.get(Integer.valueOf(i2)).horizontalBias = f2;
        } else {
            connect(i2, 3, i3, i4, i5);
            connect(i2, 4, i6, i7, i8);
            this.mConstraints.get(Integer.valueOf(i2)).verticalBias = f2;
        }
    }

    public void centerHorizontally(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        connect(i2, 1, i3, i4, i5);
        connect(i2, 2, i6, i7, i8);
        this.mConstraints.get(Integer.valueOf(i2)).horizontalBias = f2;
    }

    public void centerHorizontallyRtl(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        connect(i2, 6, i3, i4, i5);
        connect(i2, 7, i6, i7, i8);
        this.mConstraints.get(Integer.valueOf(i2)).horizontalBias = f2;
    }

    public void centerVertically(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        connect(i2, 3, i3, i4, i5);
        connect(i2, 4, i6, i7, i8);
        this.mConstraints.get(Integer.valueOf(i2)).verticalBias = f2;
    }

    public void createVerticalChain(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr == null || fArr.length == iArr.length) {
            if (fArr != null) {
                get(iArr[0]).verticalWeight = fArr[0];
            }
            get(iArr[0]).verticalChainStyle = i6;
            connect(iArr[0], 3, i2, i3, 0);
            for (int i7 = 1; i7 < iArr.length; i7++) {
                connect(iArr[i7], 3, iArr[i7 - 1], 4, 0);
                connect(iArr[i7 - 1], 4, iArr[i7], 3, 0);
                if (fArr != null) {
                    get(iArr[i7]).verticalWeight = fArr[i7];
                }
            }
            connect(iArr[iArr.length - 1], 4, i4, i5, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void createHorizontalChain(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        createHorizontalChain(i2, i3, i4, i5, iArr, fArr, i6, 1, 2);
    }

    public void createHorizontalChainRtl(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        createHorizontalChain(i2, i3, i4, i5, iArr, fArr, i6, 6, 7);
    }

    private void createHorizontalChain(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6, int i7, int i8) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr == null || fArr.length == iArr.length) {
            if (fArr != null) {
                get(iArr[0]).horizontalWeight = fArr[0];
            }
            get(iArr[0]).horizontalChainStyle = i6;
            connect(iArr[0], i7, i2, i3, -1);
            for (int i9 = 1; i9 < iArr.length; i9++) {
                connect(iArr[i9], i7, iArr[i9 - 1], i8, -1);
                connect(iArr[i9 - 1], i8, iArr[i9], i7, -1);
                if (fArr != null) {
                    get(iArr[i9]).horizontalWeight = fArr[i9];
                }
            }
            connect(iArr[iArr.length - 1], i8, i4, i5, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void connect(int i2, int i3, int i4, int i5, int i6) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i2))) {
            this.mConstraints.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    constraint.leftToLeft = i4;
                    constraint.leftToRight = -1;
                } else if (i5 == 2) {
                    constraint.leftToRight = i4;
                    constraint.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i5) + " undefined");
                }
                constraint.leftMargin = i6;
                return;
            case 2:
                if (i5 == 1) {
                    constraint.rightToLeft = i4;
                    constraint.rightToRight = -1;
                } else if (i5 == 2) {
                    constraint.rightToRight = i4;
                    constraint.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
                constraint.rightMargin = i6;
                return;
            case 3:
                if (i5 == 3) {
                    constraint.topToTop = i4;
                    constraint.topToBottom = -1;
                    constraint.baselineToBaseline = -1;
                } else if (i5 == 4) {
                    constraint.topToBottom = i4;
                    constraint.topToTop = -1;
                    constraint.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
                constraint.topMargin = i6;
                return;
            case 4:
                if (i5 == 4) {
                    constraint.bottomToBottom = i4;
                    constraint.bottomToTop = -1;
                    constraint.baselineToBaseline = -1;
                } else if (i5 == 3) {
                    constraint.bottomToTop = i4;
                    constraint.bottomToBottom = -1;
                    constraint.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
                constraint.bottomMargin = i6;
                return;
            case 5:
                if (i5 == 5) {
                    constraint.baselineToBaseline = i4;
                    constraint.bottomToBottom = -1;
                    constraint.bottomToTop = -1;
                    constraint.topToTop = -1;
                    constraint.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    constraint.startToStart = i4;
                    constraint.startToEnd = -1;
                } else if (i5 == 7) {
                    constraint.startToEnd = i4;
                    constraint.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
                constraint.startMargin = i6;
                return;
            case 7:
                if (i5 == 7) {
                    constraint.endToEnd = i4;
                    constraint.endToStart = -1;
                } else if (i5 == 6) {
                    constraint.endToStart = i4;
                    constraint.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
                constraint.endMargin = i6;
                return;
            default:
                throw new IllegalArgumentException(sideToString(i3) + " to " + sideToString(i5) + " unknown");
        }
    }

    public void connect(int i2, int i3, int i4, int i5) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i2))) {
            this.mConstraints.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    constraint.leftToLeft = i4;
                    constraint.leftToRight = -1;
                    return;
                } else if (i5 == 2) {
                    constraint.leftToRight = i4;
                    constraint.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + sideToString(i5) + " undefined");
                }
            case 2:
                if (i5 == 1) {
                    constraint.rightToLeft = i4;
                    constraint.rightToRight = -1;
                    return;
                } else if (i5 == 2) {
                    constraint.rightToRight = i4;
                    constraint.rightToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
            case 3:
                if (i5 == 3) {
                    constraint.topToTop = i4;
                    constraint.topToBottom = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else if (i5 == 4) {
                    constraint.topToBottom = i4;
                    constraint.topToTop = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
            case 4:
                if (i5 == 4) {
                    constraint.bottomToBottom = i4;
                    constraint.bottomToTop = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else if (i5 == 3) {
                    constraint.bottomToTop = i4;
                    constraint.bottomToBottom = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
            case 5:
                if (i5 == 5) {
                    constraint.baselineToBaseline = i4;
                    constraint.bottomToBottom = -1;
                    constraint.bottomToTop = -1;
                    constraint.topToTop = -1;
                    constraint.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    constraint.startToStart = i4;
                    constraint.startToEnd = -1;
                    return;
                } else if (i5 == 7) {
                    constraint.startToEnd = i4;
                    constraint.startToStart = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
            case 7:
                if (i5 == 7) {
                    constraint.endToEnd = i4;
                    constraint.endToStart = -1;
                    return;
                } else if (i5 == 6) {
                    constraint.endToStart = i4;
                    constraint.endToEnd = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i5) + " undefined");
                }
            default:
                throw new IllegalArgumentException(sideToString(i3) + " to " + sideToString(i5) + " unknown");
        }
    }

    public void centerHorizontally(int i2, int i3) {
        if (i3 == 0) {
            center(i2, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i2, i3, 2, 0, i3, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i2, int i3) {
        if (i3 == 0) {
            center(i2, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i2, i3, 7, 0, i3, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i2, int i3) {
        if (i3 == 0) {
            center(i2, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i2, i3, 4, 0, i3, 3, 0, 0.5f);
        }
    }

    public void clear(int i2) {
        this.mConstraints.remove(Integer.valueOf(i2));
    }

    public void clear(int i2, int i3) {
        if (this.mConstraints.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i2));
            switch (i3) {
                case 1:
                    constraint.leftToRight = -1;
                    constraint.leftToLeft = -1;
                    constraint.leftMargin = -1;
                    constraint.goneLeftMargin = -1;
                    return;
                case 2:
                    constraint.rightToRight = -1;
                    constraint.rightToLeft = -1;
                    constraint.rightMargin = -1;
                    constraint.goneRightMargin = -1;
                    return;
                case 3:
                    constraint.topToBottom = -1;
                    constraint.topToTop = -1;
                    constraint.topMargin = -1;
                    constraint.goneTopMargin = -1;
                    return;
                case 4:
                    constraint.bottomToTop = -1;
                    constraint.bottomToBottom = -1;
                    constraint.bottomMargin = -1;
                    constraint.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.baselineToBaseline = -1;
                    return;
                case 6:
                    constraint.startToEnd = -1;
                    constraint.startToStart = -1;
                    constraint.startMargin = -1;
                    constraint.goneStartMargin = -1;
                    return;
                case 7:
                    constraint.endToStart = -1;
                    constraint.endToEnd = -1;
                    constraint.endMargin = -1;
                    constraint.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void setMargin(int i2, int i3, int i4) {
        Constraint constraint = get(i2);
        switch (i3) {
            case 1:
                constraint.leftMargin = i4;
                return;
            case 2:
                constraint.rightMargin = i4;
                return;
            case 3:
                constraint.topMargin = i4;
                return;
            case 4:
                constraint.bottomMargin = i4;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.startMargin = i4;
                return;
            case 7:
                constraint.endMargin = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGoneMargin(int i2, int i3, int i4) {
        Constraint constraint = get(i2);
        switch (i3) {
            case 1:
                constraint.goneLeftMargin = i4;
                return;
            case 2:
                constraint.goneRightMargin = i4;
                return;
            case 3:
                constraint.goneTopMargin = i4;
                return;
            case 4:
                constraint.goneBottomMargin = i4;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.goneStartMargin = i4;
                return;
            case 7:
                constraint.goneEndMargin = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setHorizontalBias(int i2, float f2) {
        get(i2).horizontalBias = f2;
    }

    public void setVerticalBias(int i2, float f2) {
        get(i2).verticalBias = f2;
    }

    public void setDimensionRatio(int i2, String str) {
        get(i2).dimensionRatio = str;
    }

    public void setVisibility(int i2, int i3) {
        get(i2).visibility = i3;
    }

    public void setAlpha(int i2, float f2) {
        get(i2).alpha = f2;
    }

    public boolean getApplyElevation(int i2) {
        return get(i2).applyElevation;
    }

    public void setApplyElevation(int i2, boolean z) {
        get(i2).applyElevation = z;
    }

    public void setElevation(int i2, float f2) {
        get(i2).elevation = f2;
        get(i2).applyElevation = true;
    }

    public void setRotation(int i2, float f2) {
        get(i2).rotation = f2;
    }

    public void setRotationX(int i2, float f2) {
        get(i2).rotationX = f2;
    }

    public void setRotationY(int i2, float f2) {
        get(i2).rotationY = f2;
    }

    public void setScaleX(int i2, float f2) {
        get(i2).scaleX = f2;
    }

    public void setScaleY(int i2, float f2) {
        get(i2).scaleY = f2;
    }

    public void setTransformPivotX(int i2, float f2) {
        get(i2).transformPivotX = f2;
    }

    public void setTransformPivotY(int i2, float f2) {
        get(i2).transformPivotY = f2;
    }

    public void setTransformPivot(int i2, float f2, float f3) {
        Constraint constraint = get(i2);
        constraint.transformPivotY = f3;
        constraint.transformPivotX = f2;
    }

    public void setTranslationX(int i2, float f2) {
        get(i2).translationX = f2;
    }

    public void setTranslationY(int i2, float f2) {
        get(i2).translationY = f2;
    }

    public void setTranslation(int i2, float f2, float f3) {
        Constraint constraint = get(i2);
        constraint.translationX = f2;
        constraint.translationY = f3;
    }

    public void setTranslationZ(int i2, float f2) {
        get(i2).translationZ = f2;
    }

    public void constrainHeight(int i2, int i3) {
        get(i2).mHeight = i3;
    }

    public void constrainWidth(int i2, int i3) {
        get(i2).mWidth = i3;
    }

    public void constrainCircle(int i2, int i3, int i4, float f2) {
        Constraint constraint = get(i2);
        constraint.circleConstraint = i3;
        constraint.circleRadius = i4;
        constraint.circleAngle = f2;
    }

    public void constrainMaxHeight(int i2, int i3) {
        get(i2).heightMax = i3;
    }

    public void constrainMaxWidth(int i2, int i3) {
        get(i2).widthMax = i3;
    }

    public void constrainMinHeight(int i2, int i3) {
        get(i2).heightMin = i3;
    }

    public void constrainMinWidth(int i2, int i3) {
        get(i2).widthMin = i3;
    }

    public void constrainPercentWidth(int i2, float f2) {
        get(i2).widthPercent = f2;
    }

    public void constrainPercentHeight(int i2, float f2) {
        get(i2).heightPercent = f2;
    }

    public void constrainDefaultHeight(int i2, int i3) {
        get(i2).heightDefault = i3;
    }

    public void constrainDefaultWidth(int i2, int i3) {
        get(i2).widthDefault = i3;
    }

    public void setHorizontalWeight(int i2, float f2) {
        get(i2).horizontalWeight = f2;
    }

    public void setVerticalWeight(int i2, float f2) {
        get(i2).verticalWeight = f2;
    }

    public void setHorizontalChainStyle(int i2, int i3) {
        get(i2).horizontalChainStyle = i3;
    }

    public void setVerticalChainStyle(int i2, int i3) {
        get(i2).verticalChainStyle = i3;
    }

    public void addToHorizontalChain(int i2, int i3, int i4) {
        int i5;
        connect(i2, 1, i3, i3 == 0 ? 1 : 2, 0);
        if (i4 == 0) {
            i5 = 2;
        } else {
            i5 = 1;
        }
        connect(i2, 2, i4, i5, 0);
        if (i3 != 0) {
            connect(i3, 2, i2, 1, 0);
        }
        if (i4 != 0) {
            connect(i4, 1, i2, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i2, int i3, int i4) {
        int i5;
        connect(i2, 6, i3, i3 == 0 ? 6 : 7, 0);
        if (i4 == 0) {
            i5 = 7;
        } else {
            i5 = 6;
        }
        connect(i2, 7, i4, i5, 0);
        if (i3 != 0) {
            connect(i3, 7, i2, 6, 0);
        }
        if (i4 != 0) {
            connect(i4, 6, i2, 7, 0);
        }
    }

    public void addToVerticalChain(int i2, int i3, int i4) {
        int i5;
        connect(i2, 3, i3, i3 == 0 ? 3 : 4, 0);
        if (i4 == 0) {
            i5 = 4;
        } else {
            i5 = 3;
        }
        connect(i2, 4, i4, i5, 0);
        if (i3 != 0) {
            connect(i3, 4, i2, 3, 0);
        }
        if (i3 != 0) {
            connect(i4, 3, i2, 4, 0);
        }
    }

    public void removeFromVerticalChain(int i2) {
        if (this.mConstraints.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i2));
            int i3 = constraint.topToBottom;
            int i4 = constraint.bottomToTop;
            if (!(i3 == -1 && i4 == -1)) {
                if (i3 != -1 && i4 != -1) {
                    connect(i3, 4, i4, 3, 0);
                    connect(i4, 3, i3, 4, 0);
                } else if (!(i3 == -1 && i4 == -1)) {
                    if (constraint.bottomToBottom != -1) {
                        connect(i3, 4, constraint.bottomToBottom, 4, 0);
                    } else if (constraint.topToTop != -1) {
                        connect(i4, 3, constraint.topToTop, 3, 0);
                    }
                }
            }
        }
        clear(i2, 3);
        clear(i2, 4);
    }

    public void removeFromHorizontalChain(int i2) {
        if (this.mConstraints.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i2));
            int i3 = constraint.leftToRight;
            int i4 = constraint.rightToLeft;
            if (i3 == -1 && i4 == -1) {
                int i5 = constraint.startToEnd;
                int i6 = constraint.endToStart;
                if (!(i5 == -1 && i6 == -1)) {
                    if (i5 != -1 && i6 != -1) {
                        connect(i5, 7, i6, 6, 0);
                        connect(i6, 6, i3, 7, 0);
                    } else if (!(i3 == -1 && i6 == -1)) {
                        if (constraint.rightToRight != -1) {
                            connect(i3, 7, constraint.rightToRight, 7, 0);
                        } else if (constraint.leftToLeft != -1) {
                            connect(i6, 6, constraint.leftToLeft, 6, 0);
                        }
                    }
                }
                clear(i2, 6);
                clear(i2, 7);
                return;
            }
            if (i3 != -1 && i4 != -1) {
                connect(i3, 2, i4, 1, 0);
                connect(i4, 1, i3, 2, 0);
            } else if (!(i3 == -1 && i4 == -1)) {
                if (constraint.rightToRight != -1) {
                    connect(i3, 2, constraint.rightToRight, 2, 0);
                } else if (constraint.leftToLeft != -1) {
                    connect(i4, 1, constraint.leftToLeft, 1, 0);
                }
            }
            clear(i2, 1);
            clear(i2, 2);
        }
    }

    public void create(int i2, int i3) {
        Constraint constraint = get(i2);
        constraint.mIsGuideline = true;
        constraint.orientation = i3;
    }

    public void createBarrier(int i2, int i3, int... iArr) {
        Constraint constraint = get(i2);
        constraint.mHelperType = 1;
        constraint.mBarrierDirection = i3;
        constraint.mIsGuideline = false;
        constraint.mReferenceIds = iArr;
    }

    public void setGuidelineBegin(int i2, int i3) {
        get(i2).guideBegin = i3;
        get(i2).guideEnd = -1;
        get(i2).guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i2, int i3) {
        get(i2).guideEnd = i3;
        get(i2).guideBegin = -1;
        get(i2).guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i2, float f2) {
        get(i2).guidePercent = f2;
        get(i2).guideEnd = -1;
        get(i2).guideBegin = -1;
    }

    public void setBarrierType(int i2, int i3) {
    }

    private Constraint get(int i2) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i2))) {
            this.mConstraints.put(Integer.valueOf(i2), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i2));
    }

    private String sideToString(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void load(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                switch (eventType) {
                    case 0:
                        xml.getName();
                        break;
                    case 2:
                        String name = xml.getName();
                        Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            fillFromAttributeList.mIsGuideline = true;
                        }
                        this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                        break;
                }
            }
        } catch (IOException | XmlPullParserException e2) {
        }
    }

    private static int lookupID(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        if (resourceId == -1) {
            return typedArray.getInt(i2, -1);
        }
        return resourceId;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        populateConstraint(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private void populateConstraint(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            switch (mapToConstant.get(index)) {
                case 1:
                    constraint.baselineToBaseline = lookupID(typedArray, index, constraint.baselineToBaseline);
                    break;
                case 2:
                    constraint.bottomMargin = typedArray.getDimensionPixelSize(index, constraint.bottomMargin);
                    break;
                case 3:
                    constraint.bottomToBottom = lookupID(typedArray, index, constraint.bottomToBottom);
                    break;
                case 4:
                    constraint.bottomToTop = lookupID(typedArray, index, constraint.bottomToTop);
                    break;
                case 5:
                    constraint.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    constraint.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, constraint.editorAbsoluteX);
                    break;
                case 7:
                    constraint.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, constraint.editorAbsoluteY);
                    break;
                case 8:
                    constraint.endMargin = typedArray.getDimensionPixelSize(index, constraint.endMargin);
                    break;
                case 9:
                    constraint.endToEnd = lookupID(typedArray, index, constraint.endToEnd);
                    break;
                case 10:
                    constraint.endToStart = lookupID(typedArray, index, constraint.endToStart);
                    break;
                case 11:
                    constraint.goneBottomMargin = typedArray.getDimensionPixelSize(index, constraint.goneBottomMargin);
                    break;
                case 12:
                    constraint.goneEndMargin = typedArray.getDimensionPixelSize(index, constraint.goneEndMargin);
                    break;
                case 13:
                    constraint.goneLeftMargin = typedArray.getDimensionPixelSize(index, constraint.goneLeftMargin);
                    break;
                case 14:
                    constraint.goneRightMargin = typedArray.getDimensionPixelSize(index, constraint.goneRightMargin);
                    break;
                case 15:
                    constraint.goneStartMargin = typedArray.getDimensionPixelSize(index, constraint.goneStartMargin);
                    break;
                case 16:
                    constraint.goneTopMargin = typedArray.getDimensionPixelSize(index, constraint.goneTopMargin);
                    break;
                case 17:
                    constraint.guideBegin = typedArray.getDimensionPixelOffset(index, constraint.guideBegin);
                    break;
                case 18:
                    constraint.guideEnd = typedArray.getDimensionPixelOffset(index, constraint.guideEnd);
                    break;
                case 19:
                    constraint.guidePercent = typedArray.getFloat(index, constraint.guidePercent);
                    break;
                case 20:
                    constraint.horizontalBias = typedArray.getFloat(index, constraint.horizontalBias);
                    break;
                case 21:
                    constraint.mHeight = typedArray.getLayoutDimension(index, constraint.mHeight);
                    break;
                case 22:
                    constraint.visibility = typedArray.getInt(index, constraint.visibility);
                    constraint.visibility = VISIBILITY_FLAGS[constraint.visibility];
                    break;
                case 23:
                    constraint.mWidth = typedArray.getLayoutDimension(index, constraint.mWidth);
                    break;
                case 24:
                    constraint.leftMargin = typedArray.getDimensionPixelSize(index, constraint.leftMargin);
                    break;
                case 25:
                    constraint.leftToLeft = lookupID(typedArray, index, constraint.leftToLeft);
                    break;
                case 26:
                    constraint.leftToRight = lookupID(typedArray, index, constraint.leftToRight);
                    break;
                case 27:
                    constraint.orientation = typedArray.getInt(index, constraint.orientation);
                    break;
                case 28:
                    constraint.rightMargin = typedArray.getDimensionPixelSize(index, constraint.rightMargin);
                    break;
                case 29:
                    constraint.rightToLeft = lookupID(typedArray, index, constraint.rightToLeft);
                    break;
                case 30:
                    constraint.rightToRight = lookupID(typedArray, index, constraint.rightToRight);
                    break;
                case 31:
                    constraint.startMargin = typedArray.getDimensionPixelSize(index, constraint.startMargin);
                    break;
                case 32:
                    constraint.startToEnd = lookupID(typedArray, index, constraint.startToEnd);
                    break;
                case 33:
                    constraint.startToStart = lookupID(typedArray, index, constraint.startToStart);
                    break;
                case 34:
                    constraint.topMargin = typedArray.getDimensionPixelSize(index, constraint.topMargin);
                    break;
                case 35:
                    constraint.topToBottom = lookupID(typedArray, index, constraint.topToBottom);
                    break;
                case 36:
                    constraint.topToTop = lookupID(typedArray, index, constraint.topToTop);
                    break;
                case 37:
                    constraint.verticalBias = typedArray.getFloat(index, constraint.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    constraint.horizontalWeight = typedArray.getFloat(index, constraint.horizontalWeight);
                    break;
                case 40:
                    constraint.verticalWeight = typedArray.getFloat(index, constraint.verticalWeight);
                    break;
                case 41:
                    constraint.horizontalChainStyle = typedArray.getInt(index, constraint.horizontalChainStyle);
                    break;
                case 42:
                    constraint.verticalChainStyle = typedArray.getInt(index, constraint.verticalChainStyle);
                    break;
                case 43:
                    constraint.alpha = typedArray.getFloat(index, constraint.alpha);
                    break;
                case 44:
                    constraint.applyElevation = true;
                    constraint.elevation = typedArray.getDimension(index, constraint.elevation);
                    break;
                case 45:
                    constraint.rotationX = typedArray.getFloat(index, constraint.rotationX);
                    break;
                case 46:
                    constraint.rotationY = typedArray.getFloat(index, constraint.rotationY);
                    break;
                case 47:
                    constraint.scaleX = typedArray.getFloat(index, constraint.scaleX);
                    break;
                case 48:
                    constraint.scaleY = typedArray.getFloat(index, constraint.scaleY);
                    break;
                case 49:
                    constraint.transformPivotX = typedArray.getFloat(index, constraint.transformPivotX);
                    break;
                case 50:
                    constraint.transformPivotY = typedArray.getFloat(index, constraint.transformPivotY);
                    break;
                case 51:
                    constraint.translationX = typedArray.getDimension(index, constraint.translationX);
                    break;
                case 52:
                    constraint.translationY = typedArray.getDimension(index, constraint.translationY);
                    break;
                case 53:
                    constraint.translationZ = typedArray.getDimension(index, constraint.translationZ);
                    break;
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                default:
                    new StringBuilder("Unknown attribute 0x").append(Integer.toHexString(index)).append("   ").append(mapToConstant.get(index));
                    break;
                case 60:
                    constraint.rotation = typedArray.getFloat(index, constraint.rotation);
                    break;
                case 61:
                    constraint.circleConstraint = lookupID(typedArray, index, constraint.circleConstraint);
                    break;
                case 62:
                    constraint.circleRadius = typedArray.getDimensionPixelSize(index, constraint.circleRadius);
                    break;
                case 63:
                    constraint.circleAngle = typedArray.getFloat(index, constraint.circleAngle);
                    break;
                case 69:
                    constraint.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case CHAIN_USE_RTL /*{ENCODED_INT: 71}*/:
                    break;
                case 72:
                    constraint.mBarrierDirection = typedArray.getInt(index, constraint.mBarrierDirection);
                    break;
                case 73:
                    constraint.mReferenceIdString = typedArray.getString(index);
                    break;
                case 74:
                    constraint.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, constraint.mBarrierAllowsGoneWidgets);
                    break;
                case UNUSED /*{ENCODED_INT: 75}*/:
                    new StringBuilder("unused attribute 0x").append(Integer.toHexString(index)).append("   ").append(mapToConstant.get(index));
                    break;
            }
        }
    }

    private int[] convertReferenceString(View view, String str) {
        int i2;
        int i3;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i4 = 0;
        int i5 = 0;
        while (i4 < split.length) {
            String trim = split[i4].trim();
            try {
                i2 = R.id.class.getField(trim).getInt(null);
            } catch (Exception e2) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 != 0 || !view.isInEditMode() || !(view.getParent() instanceof ConstraintLayout) || (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) == null || !(designInformation instanceof Integer)) {
                i3 = i2;
            } else {
                i3 = ((Integer) designInformation).intValue();
            }
            iArr[i5] = i3;
            i4++;
            i5++;
        }
        if (i5 != split.length) {
            return Arrays.copyOf(iArr, i5);
        }
        return iArr;
    }
}