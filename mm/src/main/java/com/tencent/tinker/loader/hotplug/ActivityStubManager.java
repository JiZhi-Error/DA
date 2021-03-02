package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager {
    private static final int[] NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS = {0, 0};
    private static final int[] NEXT_SINGLETASK_STUB_IDX_SLOTS = {0, 0};
    private static final int[] NEXT_SINGLETOP_STUB_IDX_SLOTS = {0, 0};
    private static final int[] NEXT_STANDARD_STUB_IDX_SLOTS = {0, 0};
    private static final int NOTRANSPARENT_SLOT_INDEX = 0;
    private static final int[] SINGLEINSTANCE_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] SINGLETASK_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] SINGLETOP_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] STANDARD_STUB_COUNT_SLOTS = {10, 3};
    private static final String TAG = "Tinker.ActivityStubManager";
    private static final int TRANSPARENT_SLOT_INDEX = 1;
    private static Map<String, String> sTargetToStubClassNameMap = new HashMap();

    public static String assignStub(String str, int i2, boolean z) {
        String str2;
        int[] iArr;
        int[] iArr2;
        char c2;
        int i3;
        String str3 = sTargetToStubClassNameMap.get(str);
        if (str3 != null) {
            return str3;
        }
        switch (i2) {
            case 1:
                str2 = ActivityStubs.SINGLETOP_STUB_CLASSNAME_FORMAT;
                int[] iArr3 = NEXT_SINGLETOP_STUB_IDX_SLOTS;
                iArr = SINGLETOP_STUB_COUNT_SLOTS;
                iArr2 = iArr3;
                break;
            case 2:
                str2 = ActivityStubs.SINGLETASK_STUB_CLASSNAME_FORMAT;
                int[] iArr4 = NEXT_SINGLETASK_STUB_IDX_SLOTS;
                iArr = SINGLETASK_STUB_COUNT_SLOTS;
                iArr2 = iArr4;
                break;
            case 3:
                str2 = ActivityStubs.SINGLEINSTANCE_STUB_CLASSNAME_FORMAT;
                int[] iArr5 = NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS;
                iArr = SINGLEINSTANCE_STUB_COUNT_SLOTS;
                iArr2 = iArr5;
                break;
            default:
                str2 = ActivityStubs.STARDARD_STUB_CLASSNAME_FORMAT;
                int[] iArr6 = NEXT_STANDARD_STUB_IDX_SLOTS;
                iArr = STANDARD_STUB_COUNT_SLOTS;
                iArr2 = iArr6;
                break;
        }
        if (z) {
            str2 = str2 + "_T";
            c2 = 1;
        } else {
            c2 = 0;
        }
        int i4 = iArr2[c2];
        iArr2[c2] = i4 + 1;
        if (i4 >= iArr[c2]) {
            iArr2[c2] = 0;
            i3 = 0;
        } else {
            i3 = i4;
        }
        String format = String.format(str2, Integer.valueOf(i3));
        sTargetToStubClassNameMap.put(str, format);
        return format;
    }

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }
}
