package com.tencent.kinda.framework.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TestMeasure {
    public static final String TAG = "TestMeasure";
    public long valLayout = 0;
    public long valMeasure = 0;

    public void reset() {
        this.valMeasure = 0;
        this.valLayout = 0;
    }

    public String result() {
        AppMethodBeat.i(18567);
        String format = String.format("result valMeasure:%s valLayout:%s total:%s", Long.valueOf(this.valMeasure), Long.valueOf(this.valLayout), Long.valueOf(this.valLayout + this.valMeasure));
        AppMethodBeat.o(18567);
        return format;
    }
}
