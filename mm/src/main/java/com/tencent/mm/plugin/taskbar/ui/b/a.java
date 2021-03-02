package com.tencent.mm.plugin.taskbar.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a implements b {
    private List<Double> FVg = new ArrayList(100);
    public double FVh = 0.0d;
    public double idW = Double.MAX_VALUE;
    public double idX = Double.MIN_VALUE;

    public a() {
        AppMethodBeat.i(238313);
        AppMethodBeat.o(238313);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.b.b
    public final void axD() {
        AppMethodBeat.i(238314);
        if (this.FVg == null) {
            AppMethodBeat.o(238314);
        } else if (this.FVg.size() > 10000) {
            AppMethodBeat.o(238314);
        } else {
            if (this.FVg.size() != 0) {
                double d2 = 0.0d;
                for (Double d3 : this.FVg) {
                    double doubleValue = d3.doubleValue();
                    d2 += doubleValue;
                    this.idW = Math.min(this.idW, doubleValue);
                    this.idX = Math.max(this.idX, doubleValue);
                }
                this.FVh = d2 / ((double) this.FVg.size());
            }
            AppMethodBeat.o(238314);
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.b.b
    public final void axE() {
        double d2 = 60.0d;
        double d3 = 0.0d;
        AppMethodBeat.i(238315);
        double d4 = c.INSTANCE.hkh;
        if (d4 <= 60.0d) {
            d2 = d4;
        }
        if (d2 >= 0.0d) {
            d3 = d2;
        }
        this.FVg.add(Double.valueOf(d3));
        AppMethodBeat.o(238315);
    }
}
