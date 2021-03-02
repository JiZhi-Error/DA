package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;
import java.util.Iterator;

public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    public static final EnumSet<SmartLoginOption> ALL = EnumSet.allOf(SmartLoginOption.class);
    private final long mValue;

    public static SmartLoginOption valueOf(String str) {
        AppMethodBeat.i(17918);
        SmartLoginOption smartLoginOption = (SmartLoginOption) Enum.valueOf(SmartLoginOption.class, str);
        AppMethodBeat.o(17918);
        return smartLoginOption;
    }

    static {
        AppMethodBeat.i(17920);
        AppMethodBeat.o(17920);
    }

    public static EnumSet<SmartLoginOption> parseOptions(long j2) {
        AppMethodBeat.i(17919);
        EnumSet<SmartLoginOption> noneOf = EnumSet.noneOf(SmartLoginOption.class);
        Iterator it = ALL.iterator();
        while (it.hasNext()) {
            SmartLoginOption smartLoginOption = (SmartLoginOption) it.next();
            if ((smartLoginOption.getValue() & j2) != 0) {
                noneOf.add(smartLoginOption);
            }
        }
        AppMethodBeat.o(17919);
        return noneOf;
    }

    private SmartLoginOption(long j2) {
        this.mValue = j2;
    }

    public final long getValue() {
        return this.mValue;
    }
}
