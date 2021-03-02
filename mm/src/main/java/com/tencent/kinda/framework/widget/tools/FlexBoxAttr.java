package com.tencent.kinda.framework.widget.tools;

import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.tencent.kinda.framework.widget.base.ViewStyleMapper;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.FlexDirection;
import com.tencent.kinda.gen.Justify;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Wrap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlexBoxAttr {
    public static final String TAG = "MicroMsg.FlexBoxAttr";
    public static final float UNDEFINED = 1.0E21f;
    protected Align alignContent;
    protected Align alignItems;
    protected Align alignSelf;
    protected float aspectRatio;
    protected float bottom;
    protected float bottomPercent;
    protected float flexBasis;
    protected FlexDirection flexDirection;
    protected float flexGrow;
    protected float flexShrink;
    protected Wrap flexWrap;
    protected float height = 1.0E21f;
    protected float heightPercent;
    private IFlexBoxChange iFlexBoxChange;
    protected Justify justifyContent;
    protected float left;
    protected float leftPercent;
    protected float marginBottom;
    protected float marginBottomPercent;
    protected float marginLeft;
    protected float marginLeftPercent;
    protected float marginRight;
    protected float marginRightPercent;
    protected float marginTop;
    protected float marginTopPercent;
    protected float maxHeight;
    protected float maxWidth;
    protected float minHeight;
    protected float minWidth;
    protected float paddingBottom;
    protected float paddingBottomPercent;
    protected float paddingLeft;
    protected float paddingLeftPercent;
    protected float paddingRight;
    protected float paddingRightPercent;
    protected float paddingTop;
    protected float paddingTopPercent;
    protected PositionType positionType;
    protected float right;
    protected float rightPercent;
    protected String testId;
    protected float top;
    protected float topPercent;
    protected int visibility;
    protected float width = 1.0E21f;
    protected float widthPercent;
    YogaNode yogaNode = YogaNodeFactory.create();

    public interface IFlexBoxChange {
        void onChange();
    }

    public static boolean isUndefined(float f2) {
        AppMethodBeat.i(19329);
        if (Float.compare(f2, 1.0E9f) >= 0 || Float.compare(f2, -1.0E9f) <= 0) {
            AppMethodBeat.o(19329);
            return true;
        }
        AppMethodBeat.o(19329);
        return false;
    }

    public FlexBoxAttr() {
        AppMethodBeat.i(19330);
        applyNodeDefaultParam();
        AppMethodBeat.o(19330);
    }

    public FlexBoxAttr(IFlexBoxChange iFlexBoxChange2) {
        AppMethodBeat.i(19331);
        this.iFlexBoxChange = iFlexBoxChange2;
        applyNodeDefaultParam();
        AppMethodBeat.o(19331);
    }

    private void applyNodeDefaultParam() {
        AppMethodBeat.i(19332);
        this.yogaNode = YogaNodeFactory.create();
        this.yogaNode.reset();
        AppMethodBeat.o(19332);
    }

    public YogaNode node() {
        return this.yogaNode;
    }

    public void setYogaNode(YogaNode yogaNode2) {
        this.yogaNode = yogaNode2;
    }

    public void setWidth(float f2) {
        AppMethodBeat.i(19333);
        this.width = f2;
        if (f2 > 0.0f) {
            node().setWidth(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19333);
    }

    public float getWidth() {
        AppMethodBeat.i(19334);
        if (isUndefined(this.width)) {
            float pxToDp = MMKViewUtil.pxToDp(KindaContext.get(), this.yogaNode.getLayoutWidth());
            AppMethodBeat.o(19334);
            return pxToDp;
        }
        float f2 = this.width;
        AppMethodBeat.o(19334);
        return f2;
    }

    public void setHeight(float f2) {
        AppMethodBeat.i(19335);
        this.height = f2;
        if (f2 > 0.0f) {
            node().setHeight(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19335);
    }

    public float getHeight() {
        AppMethodBeat.i(19336);
        if (isUndefined(this.height)) {
            float pxToDp = MMKViewUtil.pxToDp(KindaContext.get(), this.yogaNode.getLayoutHeight());
            AppMethodBeat.o(19336);
            return pxToDp;
        }
        float f2 = this.height;
        AppMethodBeat.o(19336);
        return f2;
    }

    public void setWidthPercent(float f2) {
        AppMethodBeat.i(19337);
        this.widthPercent = f2;
        if (f2 > 0.0f) {
            node().setWidthPercent(f2);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19337);
    }

    public float getWidthPercent() {
        return this.widthPercent;
    }

    public void setHeightPercent(float f2) {
        AppMethodBeat.i(19338);
        this.heightPercent = f2;
        if (f2 > 0.0f) {
            node().setHeightPercent(f2);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19338);
    }

    public float getHeightPercent() {
        return this.heightPercent;
    }

    public void setAlignSelf(Align align) {
        AppMethodBeat.i(19339);
        this.alignSelf = align;
        node().setAlignSelf(ViewStyleMapper.mapYGAlign(align));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19339);
    }

    public Align getAlignSelf() {
        return this.alignSelf;
    }

    public void setFlexBasis(float f2) {
        AppMethodBeat.i(19340);
        this.flexBasis = f2;
        if (this.flexBasis > 0.0f) {
            node().setWidth(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19340);
    }

    public float getFlexBasis() {
        return this.flexBasis;
    }

    public void setPositionType(PositionType positionType2) {
        AppMethodBeat.i(19341);
        this.positionType = positionType2;
        node().setPositionType(ViewStyleMapper.mapPositionType(positionType2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19341);
    }

    public PositionType getPositionType() {
        return this.positionType;
    }

    public void setLeft(float f2) {
        AppMethodBeat.i(19342);
        this.left = f2;
        node().setPosition(YogaEdge.LEFT, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19342);
    }

    public float getLeft() {
        return this.left;
    }

    public void setTop(float f2) {
        AppMethodBeat.i(19343);
        this.top = f2;
        node().setPosition(YogaEdge.TOP, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19343);
    }

    public float getTop() {
        return this.top;
    }

    public void setRight(float f2) {
        AppMethodBeat.i(19344);
        this.right = f2;
        node().setPosition(YogaEdge.RIGHT, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19344);
    }

    public float getRight() {
        return this.right;
    }

    public void setBottom(float f2) {
        AppMethodBeat.i(19345);
        this.bottom = f2;
        node().setPosition(YogaEdge.BOTTOM, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19345);
    }

    public float getBottom() {
        return this.bottom;
    }

    public void setMinWidth(float f2) {
        AppMethodBeat.i(19346);
        this.minWidth = f2;
        if (this.minWidth > 0.0f) {
            node().setMinWidth(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19346);
    }

    public float getMinWidth() {
        return this.minWidth;
    }

    public void setMaxWidth(float f2) {
        AppMethodBeat.i(19347);
        this.maxWidth = f2;
        if (this.maxWidth > 0.0f) {
            node().setMaxWidth(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19347);
    }

    public float getMaxWidth() {
        return this.maxWidth;
    }

    public void setMinHeight(float f2) {
        AppMethodBeat.i(19348);
        this.minHeight = f2;
        if (this.minHeight > 0.0f) {
            node().setMinHeight(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19348);
    }

    public float getMinHeight() {
        return this.minHeight;
    }

    public void setMaxHeight(float f2) {
        AppMethodBeat.i(19349);
        this.maxHeight = f2;
        if (this.maxHeight > 0.0f) {
            node().setMaxHeight(MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19349);
    }

    public float getMaxHeight() {
        return this.maxHeight;
    }

    public void setAspectRatio(float f2) {
        AppMethodBeat.i(19350);
        this.aspectRatio = f2;
        if (this.aspectRatio > 0.0f) {
            node().setAspectRatio(this.aspectRatio);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19350);
    }

    public float getAspectRatio() {
        return this.aspectRatio;
    }

    public void setFlexGrow(float f2) {
        AppMethodBeat.i(19351);
        this.flexGrow = f2;
        if (this.flexGrow > 0.0f) {
            node().setFlexGrow(this.flexGrow);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19351);
    }

    public float getFlexGrow() {
        return this.flexGrow;
    }

    public void setFlexShrink(float f2) {
        AppMethodBeat.i(19352);
        this.flexShrink = f2;
        if (this.flexShrink > 0.0f) {
            node().setFlexShrink(this.flexShrink);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19352);
    }

    public float getFlexShrink() {
        return this.flexShrink;
    }

    public void setFlexDirection(FlexDirection flexDirection2) {
        AppMethodBeat.i(19353);
        this.flexDirection = flexDirection2;
        node().setFlexDirection(ViewStyleMapper.mapFlexDirection(flexDirection2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19353);
    }

    public FlexDirection getFlexDirection() {
        return this.flexDirection;
    }

    public void setJustifyContent(Justify justify) {
        AppMethodBeat.i(19354);
        this.justifyContent = justify;
        node().setJustifyContent(ViewStyleMapper.mapJustifyContent(justify));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19354);
    }

    public Justify getJustifyContent() {
        return this.justifyContent;
    }

    public void setFlexWrap(Wrap wrap) {
        AppMethodBeat.i(19355);
        this.flexWrap = wrap;
        node().setWrap(ViewStyleMapper.mapYGWrap(wrap));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19355);
    }

    public Wrap getFlexWrap() {
        return this.flexWrap;
    }

    public void setAlignItems(Align align) {
        AppMethodBeat.i(19356);
        this.alignItems = align;
        node().setAlignItems(ViewStyleMapper.mapYGAlign(align));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19356);
    }

    public Align getAlignItems() {
        return this.alignItems;
    }

    public void setAlignContent(Align align) {
        AppMethodBeat.i(19357);
        this.alignContent = align;
        node().setAlignContent(ViewStyleMapper.mapYGAlign(align));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19357);
    }

    public Align getAlignContent() {
        return this.alignContent;
    }

    public void setMarginLeft(float f2) {
        AppMethodBeat.i(19358);
        this.marginLeft = f2;
        node().setMargin(YogaEdge.LEFT, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19358);
    }

    public float getMarginLeft() {
        return this.marginLeft;
    }

    public void setMarginTop(float f2) {
        AppMethodBeat.i(19359);
        this.marginTop = f2;
        node().setMargin(YogaEdge.TOP, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19359);
    }

    public float getMarginTop() {
        return this.marginTop;
    }

    public void setMarginRight(float f2) {
        AppMethodBeat.i(19360);
        this.marginRight = f2;
        node().setMargin(YogaEdge.RIGHT, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19360);
    }

    public float getMarginRight() {
        return this.marginRight;
    }

    public void setMarginBottom(float f2) {
        AppMethodBeat.i(19361);
        this.marginBottom = f2;
        node().setMargin(YogaEdge.BOTTOM, MMKViewUtil.dpToPx(KindaContext.get(), f2));
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19361);
    }

    public float getMarginBottom() {
        return this.marginBottom;
    }

    public void setPaddingLeft(float f2) {
        AppMethodBeat.i(19362);
        this.paddingLeft = f2;
        if (this.paddingLeft > 0.0f) {
            node().setPadding(YogaEdge.LEFT, MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19362);
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public void setPaddingTop(float f2) {
        AppMethodBeat.i(19363);
        this.paddingTop = f2;
        if (this.paddingTop > 0.0f) {
            node().setPadding(YogaEdge.TOP, MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19363);
    }

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public void setPaddingRight(float f2) {
        AppMethodBeat.i(19364);
        this.paddingRight = f2;
        if (this.paddingRight > 0.0f) {
            node().setPadding(YogaEdge.RIGHT, MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19364);
    }

    public float getPaddingRight() {
        return this.paddingRight;
    }

    public void setPaddingBottom(float f2) {
        AppMethodBeat.i(19365);
        this.paddingBottom = f2;
        if (this.paddingBottom > 0.0f) {
            node().setPadding(YogaEdge.BOTTOM, MMKViewUtil.dpToPx(KindaContext.get(), f2));
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19365);
    }

    public void setLeftPercent(float f2) {
        AppMethodBeat.i(19366);
        this.leftPercent = f2;
        node().setPositionPercent(YogaEdge.LEFT, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19366);
    }

    public float getLeftPercent() {
        return this.leftPercent;
    }

    public void setTopPercent(float f2) {
        AppMethodBeat.i(19367);
        this.topPercent = f2;
        node().setPositionPercent(YogaEdge.TOP, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19367);
    }

    public float getTopPercent() {
        return this.topPercent;
    }

    public void setRightPercent(float f2) {
        AppMethodBeat.i(19368);
        this.rightPercent = f2;
        node().setPositionPercent(YogaEdge.RIGHT, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19368);
    }

    public float getRightPercent() {
        return this.rightPercent;
    }

    public void setBottomPercent(float f2) {
        AppMethodBeat.i(19369);
        this.bottomPercent = f2;
        node().setPositionPercent(YogaEdge.BOTTOM, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19369);
    }

    public float getBottomPercent() {
        return this.bottomPercent;
    }

    public void setMarginLeftPercent(float f2) {
        AppMethodBeat.i(19370);
        this.marginLeftPercent = f2;
        node().setMarginPercent(YogaEdge.LEFT, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19370);
    }

    public float getMarginLeftPercent() {
        return this.marginLeftPercent;
    }

    public void setMarginTopPercent(float f2) {
        AppMethodBeat.i(19371);
        this.marginTopPercent = f2;
        node().setMarginPercent(YogaEdge.TOP, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19371);
    }

    public float getMarginTopPercent() {
        return this.marginTopPercent;
    }

    public void setMarginRightPercent(float f2) {
        AppMethodBeat.i(19372);
        this.marginRightPercent = f2;
        node().setMarginPercent(YogaEdge.RIGHT, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19372);
    }

    public float getMarginRightPercent() {
        return this.marginRightPercent;
    }

    public void setMarginBottomPercent(float f2) {
        AppMethodBeat.i(19373);
        this.marginBottomPercent = f2;
        node().setMarginPercent(YogaEdge.BOTTOM, f2);
        if (this.iFlexBoxChange != null) {
            this.iFlexBoxChange.onChange();
        }
        AppMethodBeat.o(19373);
    }

    public float getMarginBottomPercent() {
        return this.marginBottomPercent;
    }

    public void setPaddingLeftPercent(float f2) {
        AppMethodBeat.i(19374);
        this.paddingLeftPercent = f2;
        if (this.paddingLeft > 0.0f) {
            node().setPaddingPercent(YogaEdge.LEFT, f2);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19374);
    }

    public float getPaddingLeftPercent() {
        return this.paddingLeftPercent;
    }

    public void setPaddingTopPercent(float f2) {
        AppMethodBeat.i(19375);
        this.paddingTopPercent = f2;
        if (this.paddingTop > 0.0f) {
            node().setPaddingPercent(YogaEdge.TOP, f2);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19375);
    }

    public float getPaddingTopPercent() {
        return this.paddingTopPercent;
    }

    public void setPaddingRightPercent(float f2) {
        AppMethodBeat.i(19376);
        this.paddingRightPercent = f2;
        if (this.paddingRight > 0.0f) {
            node().setPadding(YogaEdge.RIGHT, f2);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19376);
    }

    public float getPaddingRightPercent() {
        return this.paddingRightPercent;
    }

    public void setPaddingBottomPercent(float f2) {
        AppMethodBeat.i(19377);
        this.paddingBottomPercent = f2;
        if (this.paddingBottom > 0.0f) {
            node().setPadding(YogaEdge.BOTTOM, f2);
            if (this.iFlexBoxChange != null) {
                this.iFlexBoxChange.onChange();
            }
        }
        AppMethodBeat.o(19377);
    }

    public float getPaddingBottomPercent() {
        return this.paddingBottomPercent;
    }

    public void setTestId(String str) {
        this.testId = str;
    }

    public String getTestId() {
        return this.testId;
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setVisibility(int i2) {
        this.visibility = i2;
    }

    public int getVisibility() {
        return this.visibility;
    }
}
