package com.facebook.yoga;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaValue {
    static final YogaValue AUTO = new YogaValue(Float.NaN, YogaUnit.AUTO);
    static final YogaValue UNDEFINED = new YogaValue(Float.NaN, YogaUnit.UNDEFINED);
    static final YogaValue ZERO = new YogaValue(0.0f, YogaUnit.POINT);
    public final YogaUnit unit;
    public final float value;

    static {
        AppMethodBeat.i(18218);
        AppMethodBeat.o(18218);
    }

    public YogaValue(float f2, YogaUnit yogaUnit) {
        this.value = f2;
        this.unit = yogaUnit;
    }

    YogaValue(float f2, int i2) {
        this(f2, YogaUnit.fromInt(i2));
        AppMethodBeat.i(18213);
        AppMethodBeat.o(18213);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(18214);
        if (obj instanceof YogaValue) {
            YogaValue yogaValue = (YogaValue) obj;
            if (this.unit == yogaValue.unit) {
                if (this.unit == YogaUnit.UNDEFINED || this.unit == YogaUnit.AUTO || Float.compare(this.value, yogaValue.value) == 0) {
                    AppMethodBeat.o(18214);
                    return true;
                }
                AppMethodBeat.o(18214);
                return false;
            }
        }
        AppMethodBeat.o(18214);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(18215);
        int floatToIntBits = Float.floatToIntBits(this.value) + this.unit.intValue();
        AppMethodBeat.o(18215);
        return floatToIntBits;
    }

    public String toString() {
        AppMethodBeat.i(18216);
        switch (this.unit) {
            case UNDEFINED:
                AppMethodBeat.o(18216);
                return "undefined";
            case POINT:
                String f2 = Float.toString(this.value);
                AppMethodBeat.o(18216);
                return f2;
            case PERCENT:
                String str = this.value + "%";
                AppMethodBeat.o(18216);
                return str;
            case AUTO:
                AppMethodBeat.o(18216);
                return "auto";
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(18216);
                throw illegalStateException;
        }
    }

    public static YogaValue parse(String str) {
        AppMethodBeat.i(18217);
        if (str == null) {
            AppMethodBeat.o(18217);
            return null;
        } else if ("undefined".equals(str)) {
            YogaValue yogaValue = UNDEFINED;
            AppMethodBeat.o(18217);
            return yogaValue;
        } else if ("auto".equals(str)) {
            YogaValue yogaValue2 = AUTO;
            AppMethodBeat.o(18217);
            return yogaValue2;
        } else if (str.endsWith("%")) {
            YogaValue yogaValue3 = new YogaValue(Float.parseFloat(str.substring(0, str.length() - 1)), YogaUnit.PERCENT);
            AppMethodBeat.o(18217);
            return yogaValue3;
        } else {
            YogaValue yogaValue4 = new YogaValue(Float.parseFloat(str), YogaUnit.POINT);
            AppMethodBeat.o(18217);
            return yogaValue4;
        }
    }
}
