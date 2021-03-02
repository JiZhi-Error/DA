package com.tencent.mm.ui.widget.picker.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class a extends TimerTask {
    private final WheelView QUE;
    private float jKc = 2.14748365E9f;
    private final float jKd;

    public a(WheelView wheelView, float f2) {
        this.QUE = wheelView;
        this.jKd = f2;
    }

    public final void run() {
        float f2 = 2000.0f;
        AppMethodBeat.i(198522);
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
            this.QUE.setTotalScrollY(this.QUE.getTotalScrollY() - ((float) i2));
            if (!this.QUE.jqj) {
                float itemHeight = this.QUE.getItemHeight();
                float f3 = ((float) (-this.QUE.getInitPosition())) * itemHeight;
                float itemsCount = ((float) ((this.QUE.getItemsCount() - 1) - this.QUE.getInitPosition())) * itemHeight;
                if (((double) this.QUE.getTotalScrollY()) - (((double) itemHeight) * 0.25d) < ((double) f3)) {
                    f3 = this.QUE.getTotalScrollY() + ((float) i2);
                } else if (((double) this.QUE.getTotalScrollY()) + (((double) itemHeight) * 0.25d) > ((double) itemsCount)) {
                    itemsCount = this.QUE.getTotalScrollY() + ((float) i2);
                }
                if (this.QUE.getTotalScrollY() <= f3) {
                    this.jKc = 40.0f;
                    this.QUE.setTotalScrollY((float) ((int) f3));
                } else if (this.QUE.getTotalScrollY() >= itemsCount) {
                    this.QUE.setTotalScrollY((float) ((int) itemsCount));
                    this.jKc = -40.0f;
                }
            }
            if (this.jKc < 0.0f) {
                this.jKc += 20.0f;
            } else {
                this.jKc -= 20.0f;
            }
            this.QUE.getHandler().sendEmptyMessage(1000);
            AppMethodBeat.o(198522);
            return;
        }
        this.QUE.bkU();
        this.QUE.getHandler().sendEmptyMessage(2000);
        AppMethodBeat.o(198522);
    }
}
