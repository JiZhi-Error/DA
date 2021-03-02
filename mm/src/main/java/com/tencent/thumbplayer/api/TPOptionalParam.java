package com.tencent.thumbplayer.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPCommonEnum;

public class TPOptionalParam {
    public static final int TP_OPTIONAL_PARAM_TYPE_BOOLEAN = 1;
    public static final int TP_OPTIONAL_PARAM_TYPE_FLOAT = 6;
    public static final int TP_OPTIONAL_PARAM_TYPE_LONG = 2;
    public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_INT = 4;
    public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_STRING = 5;
    public static final int TP_OPTIONAL_PARAM_TYPE_STRING = 3;
    public static final int TP_OPTIONAL_PARAM_TYPE_UNKNOWN = -1;
    @TPCommonEnum.TPOptionalId
    private int key;
    private OptionalParamBoolean paramBoolean;
    private OptionalParamFloat paramFloat;
    private OptionalParamLong paramLong;
    private OptionalParamQueueInt paramQueueInt;
    private OptionalParamQueueString paramQueueString;
    private OptionalParamString paramString;
    private int paramType = -1;

    public static class OptionalParamBoolean {
        public boolean value;
    }

    public static class OptionalParamFloat {
        public float param1;
        public float param2;
        public float value;
    }

    public static class OptionalParamLong {
        public long param1;
        public long param2;
        public long value;
    }

    public static class OptionalParamQueueInt {
        public int[] queueValue;
    }

    public static class OptionalParamQueueString {
        public String[] queueValue;
    }

    public static class OptionalParamString {
        public String param1;
        public String param2;
        public String value;
    }

    public TPOptionalParam buildBoolean(@TPCommonEnum.TPOptionalId int i2, boolean z) {
        AppMethodBeat.i(189011);
        this.paramType = 1;
        this.key = i2;
        this.paramBoolean = new OptionalParamBoolean();
        this.paramBoolean.value = z;
        AppMethodBeat.o(189011);
        return this;
    }

    public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int i2, long j2) {
        AppMethodBeat.i(189012);
        this.paramType = 2;
        this.key = i2;
        this.paramLong = new OptionalParamLong();
        this.paramLong.value = j2;
        AppMethodBeat.o(189012);
        return this;
    }

    public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int i2, long j2, long j3, long j4) {
        AppMethodBeat.i(189013);
        this.paramType = 2;
        this.key = i2;
        this.paramLong = new OptionalParamLong();
        this.paramLong.value = j2;
        this.paramLong.param1 = j3;
        this.paramLong.param2 = j4;
        AppMethodBeat.o(189013);
        return this;
    }

    public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int i2, float f2) {
        AppMethodBeat.i(189014);
        this.paramType = 6;
        this.key = i2;
        this.paramFloat = new OptionalParamFloat();
        this.paramFloat.value = f2;
        AppMethodBeat.o(189014);
        return this;
    }

    public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int i2, float f2, float f3, float f4) {
        AppMethodBeat.i(189015);
        this.paramType = 6;
        this.key = i2;
        this.paramFloat = new OptionalParamFloat();
        this.paramFloat.value = f2;
        this.paramFloat.param1 = f3;
        this.paramFloat.param2 = f4;
        AppMethodBeat.o(189015);
        return this;
    }

    public TPOptionalParam buildQueueInt(@TPCommonEnum.TPOptionalId int i2, int[] iArr) {
        AppMethodBeat.i(189016);
        this.paramType = 4;
        this.key = i2;
        this.paramQueueInt = new OptionalParamQueueInt();
        this.paramQueueInt.queueValue = iArr;
        AppMethodBeat.o(189016);
        return this;
    }

    public TPOptionalParam buildQueueString(@TPCommonEnum.TPOptionalId int i2, String[] strArr) {
        AppMethodBeat.i(189017);
        this.paramType = 5;
        this.key = i2;
        this.paramQueueString = new OptionalParamQueueString();
        this.paramQueueString.queueValue = strArr;
        AppMethodBeat.o(189017);
        return this;
    }

    public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int i2, String str) {
        AppMethodBeat.i(189018);
        this.paramType = 3;
        this.key = i2;
        this.paramString = new OptionalParamString();
        this.paramString.value = str;
        AppMethodBeat.o(189018);
        return this;
    }

    public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int i2, String str, String str2, String str3) {
        AppMethodBeat.i(189019);
        this.paramType = 3;
        this.key = i2;
        this.paramString = new OptionalParamString();
        this.paramString.value = str;
        this.paramString.param1 = str2;
        this.paramString.param2 = str3;
        AppMethodBeat.o(189019);
        return this;
    }

    @TPCommonEnum.TPOptionalId
    public int getKey() {
        return this.key;
    }

    public int getParamType() {
        return this.paramType;
    }

    public OptionalParamBoolean getParamBoolean() {
        return this.paramBoolean;
    }

    public OptionalParamLong getParamLong() {
        return this.paramLong;
    }

    public OptionalParamFloat getParamFloat() {
        return this.paramFloat;
    }

    public OptionalParamString getParamString() {
        return this.paramString;
    }

    public OptionalParamQueueInt getParamQueueInt() {
        return this.paramQueueInt;
    }

    public OptionalParamQueueString getParamQueueString() {
        return this.paramQueueString;
    }

    public String toString() {
        int i2 = 0;
        AppMethodBeat.i(189020);
        StringBuilder sb = new StringBuilder();
        switch (this.paramType) {
            case 1:
                sb.append("type:long, key:" + this.key + ", value:" + this.paramBoolean.value);
                break;
            case 2:
                sb.append("type:long, key:" + this.key + ", value:" + this.paramLong.value + ", param1:" + this.paramLong.param1 + ", param2:" + this.paramLong.param2);
                break;
            case 3:
                sb.append("type:string, key:" + this.key + ", value:" + this.paramString.value + ", param1:" + this.paramString.param1 + ", param2:" + this.paramString.param2);
                break;
            case 4:
                sb.append("type:quint_int, key:" + this.key + ", value:");
                if (this.paramQueueInt.queueValue != null) {
                    int[] iArr = this.paramQueueInt.queueValue;
                    int length = iArr.length;
                    while (i2 < length) {
                        sb.append(iArr[i2] + ", ");
                        i2++;
                    }
                    break;
                }
                break;
            case 5:
                sb.append("type:quint_string, key:" + this.key + ", value:");
                if (this.paramQueueString.queueValue != null) {
                    String[] strArr = this.paramQueueString.queueValue;
                    int length2 = strArr.length;
                    while (i2 < length2) {
                        sb.append(strArr[i2] + ", ");
                        i2++;
                    }
                    break;
                }
                break;
            case 6:
                sb.append("type:float, key:" + this.key + ", value:" + this.paramFloat.value + ", param1:" + this.paramFloat.param1 + ", param2:" + this.paramFloat.param2);
                break;
            default:
                sb.append("type:unknown");
                break;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(189020);
        return sb2;
    }
}
