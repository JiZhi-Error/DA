package com.plattysoft.leonids.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.util.Random;

public final class a implements b {
    private float olh;
    private float oli;
    private int olj = 0;
    private int olk = v2helper.VOIP_ENC_HEIGHT_LV1;

    public a(float f2, float f3) {
        AppMethodBeat.i(261924);
        this.olh = f2;
        this.oli = f3;
        while (this.olj < 0) {
            this.olj += v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        while (this.olk < 0) {
            this.olk += v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        if (this.olj > this.olk) {
            int i2 = this.olj;
            this.olj = this.olk;
            this.olk = i2;
        }
        AppMethodBeat.o(261924);
    }

    @Override // com.plattysoft.leonids.a.b
    public final void a(com.plattysoft.leonids.a aVar, Random random) {
        int nextInt;
        AppMethodBeat.i(261925);
        float nextFloat = this.olh + (random.nextFloat() * (this.oli - this.olh));
        if (this.olk == this.olj) {
            nextInt = this.olj;
        } else {
            nextInt = random.nextInt(this.olk - this.olj) + this.olj;
        }
        double radians = Math.toRadians((double) nextInt);
        aVar.hHp = (float) (((double) nextFloat) * Math.cos(radians));
        aVar.hHq = (float) (Math.sin(radians) * ((double) nextFloat));
        aVar.hFr = (float) (nextInt + 90);
        AppMethodBeat.o(261925);
    }
}
