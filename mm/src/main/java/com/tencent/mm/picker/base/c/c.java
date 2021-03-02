package com.tencent.mm.picker.base.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class c extends TimerTask {
    private float jKc = 2.14748365E9f;
    private final float jKd;
    private final WheelView jKe;

    public c(WheelView wheelView, float f2) {
        this.jKe = wheelView;
        this.jKd = f2;
    }

    public final void run() {
        float f2 = 2000.0f;
        AppMethodBeat.i(175296);
        if (this.jKc == 2.14748365E9f) {
            if (Math.abs(this.jKd) > 2000.0f) {
                if (this.jKd <= 0.0f) {
                    f2 = -2000.0f;
                }
                this.jKc = f2;
            } else {
                this.jKc = this.jKd;
            }
        }
        if (Math.abs(this.jKc) < 0.0f || Math.abs(this.jKc) > 20.0f) {
            int i2 = (int) (this.jKc / 100.0f);
            this.jKe.setTotalScrollY(this.jKe.getTotalScrollY() - ((float) i2));
            if (!this.jKe.jqj) {
                float itemHeight = this.jKe.getItemHeight();
                float f3 = ((float) (-this.jKe.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.jKe.getItemsCount() - 1) - this.jKe.getInitPosition())) * itemHeight;
                if (((double) this.jKe.getTotalScrollY()) - (((double) itemHeight) * 0.25d) < ((double) f3)) {
                    f3 = this.jKe.getTotalScrollY() + ((float) i2);
                } else if (((double) this.jKe.getTotalScrollY()) + (((double) itemHeight) * 0.25d) > ((double) itemsCount)) {
                    itemsCount = this.jKe.getTotalScrollY() + ((float) i2);
                }
                if (this.jKe.getTotalScrollY() <= f3) {
                    this.jKc = 40.0f;
                    this.jKe.setTotalScrollY((float) ((int) f3));
                } else if (this.jKe.getTotalScrollY() >= itemsCount) {
                    this.jKe.setTotalScrollY((float) ((int) itemsCount));
                    this.jKc = -40.0f;
                }
            }
            if (this.jKc < 0.0f) {
                this.jKc += 20.0f;
            } else {
                this.jKc -= 20.0f;
            }
            this.jKe.getHandler().sendEmptyMessage(1000);
            AppMethodBeat.o(175296);
            return;
        }
        this.jKe.bkU();
        this.jKe.getHandler().sendEmptyMessage(2000);
        AppMethodBeat.o(175296);
    }
}
