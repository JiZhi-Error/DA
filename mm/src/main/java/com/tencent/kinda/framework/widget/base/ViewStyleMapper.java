package com.tencent.kinda.framework.widget.base;

import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.FlexDirection;
import com.tencent.kinda.gen.Justify;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Wrap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewStyleMapper {
    public static YogaAlign mapYGAlign(Align align) {
        AppMethodBeat.i(19300);
        switch (align) {
            case AUTO:
                YogaAlign yogaAlign = YogaAlign.AUTO;
                AppMethodBeat.o(19300);
                return yogaAlign;
            case BASELINE:
                YogaAlign yogaAlign2 = YogaAlign.BASELINE;
                AppMethodBeat.o(19300);
                return yogaAlign2;
            case CENTER:
                YogaAlign yogaAlign3 = YogaAlign.CENTER;
                AppMethodBeat.o(19300);
                return yogaAlign3;
            case FLEXEND:
                YogaAlign yogaAlign4 = YogaAlign.FLEX_END;
                AppMethodBeat.o(19300);
                return yogaAlign4;
            case FLEXSTART:
                YogaAlign yogaAlign5 = YogaAlign.FLEX_START;
                AppMethodBeat.o(19300);
                return yogaAlign5;
            case SPACEAROUND:
                YogaAlign yogaAlign6 = YogaAlign.SPACE_AROUND;
                AppMethodBeat.o(19300);
                return yogaAlign6;
            case SPACEBETWEEN:
                YogaAlign yogaAlign7 = YogaAlign.SPACE_BETWEEN;
                AppMethodBeat.o(19300);
                return yogaAlign7;
            case STRETCH:
                YogaAlign yogaAlign8 = YogaAlign.STRETCH;
                AppMethodBeat.o(19300);
                return yogaAlign8;
            default:
                YogaAlign yogaAlign9 = YogaAlign.STRETCH;
                AppMethodBeat.o(19300);
                return yogaAlign9;
        }
    }

    public static YogaWrap mapYGWrap(Wrap wrap) {
        AppMethodBeat.i(19301);
        switch (wrap) {
            case NOWRAP:
                YogaWrap yogaWrap = YogaWrap.NO_WRAP;
                AppMethodBeat.o(19301);
                return yogaWrap;
            case WRAP:
                YogaWrap yogaWrap2 = YogaWrap.WRAP;
                AppMethodBeat.o(19301);
                return yogaWrap2;
            case WRAPREVERSE:
                YogaWrap yogaWrap3 = YogaWrap.WRAP_REVERSE;
                AppMethodBeat.o(19301);
                return yogaWrap3;
            default:
                YogaWrap yogaWrap4 = YogaWrap.NO_WRAP;
                AppMethodBeat.o(19301);
                return yogaWrap4;
        }
    }

    public static YogaPositionType mapPositionType(PositionType positionType) {
        AppMethodBeat.i(19302);
        switch (positionType) {
            case ABSOLUTE:
                YogaPositionType yogaPositionType = YogaPositionType.ABSOLUTE;
                AppMethodBeat.o(19302);
                return yogaPositionType;
            case RELATIVE:
                YogaPositionType yogaPositionType2 = YogaPositionType.RELATIVE;
                AppMethodBeat.o(19302);
                return yogaPositionType2;
            default:
                YogaPositionType yogaPositionType3 = YogaPositionType.RELATIVE;
                AppMethodBeat.o(19302);
                return yogaPositionType3;
        }
    }

    public static YogaFlexDirection mapFlexDirection(FlexDirection flexDirection) {
        AppMethodBeat.i(19303);
        switch (flexDirection) {
            case COLUMN:
                YogaFlexDirection yogaFlexDirection = YogaFlexDirection.COLUMN;
                AppMethodBeat.o(19303);
                return yogaFlexDirection;
            case COLUMNREVERSE:
                YogaFlexDirection yogaFlexDirection2 = YogaFlexDirection.COLUMN_REVERSE;
                AppMethodBeat.o(19303);
                return yogaFlexDirection2;
            case ROW:
                YogaFlexDirection yogaFlexDirection3 = YogaFlexDirection.ROW;
                AppMethodBeat.o(19303);
                return yogaFlexDirection3;
            case ROWREVERSE:
                YogaFlexDirection yogaFlexDirection4 = YogaFlexDirection.ROW_REVERSE;
                AppMethodBeat.o(19303);
                return yogaFlexDirection4;
            default:
                YogaFlexDirection yogaFlexDirection5 = YogaFlexDirection.COLUMN;
                AppMethodBeat.o(19303);
                return yogaFlexDirection5;
        }
    }

    public static YogaJustify mapJustifyContent(Justify justify) {
        AppMethodBeat.i(19304);
        switch (justify) {
            case CENTER:
                YogaJustify yogaJustify = YogaJustify.CENTER;
                AppMethodBeat.o(19304);
                return yogaJustify;
            case FLEXEND:
                YogaJustify yogaJustify2 = YogaJustify.FLEX_END;
                AppMethodBeat.o(19304);
                return yogaJustify2;
            case FLEXSTART:
                YogaJustify yogaJustify3 = YogaJustify.FLEX_START;
                AppMethodBeat.o(19304);
                return yogaJustify3;
            case SPACEAROUND:
                YogaJustify yogaJustify4 = YogaJustify.SPACE_AROUND;
                AppMethodBeat.o(19304);
                return yogaJustify4;
            case SPACEBETWEEN:
                YogaJustify yogaJustify5 = YogaJustify.SPACE_BETWEEN;
                AppMethodBeat.o(19304);
                return yogaJustify5;
            default:
                YogaJustify yogaJustify6 = YogaJustify.FLEX_START;
                AppMethodBeat.o(19304);
                return yogaJustify6;
        }
    }
}
