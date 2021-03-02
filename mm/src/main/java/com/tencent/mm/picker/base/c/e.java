package com.tencent.mm.picker.base.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.TimerTask;

public final class e extends TimerTask {
    private final WheelView jKa;
    private int jKf = Integer.MAX_VALUE;
    private int jKg = 0;
    private int offset;

    public e(WheelView wheelView, int i2) {
        this.jKa = wheelView;
        this.offset = i2;
    }

    public final void run() {
        AppMethodBeat.i(175298);
        if (this.jKf == Integer.MAX_VALUE) {
            this.jKf = this.offset;
        }
        this.jKg = (int) (((float) this.jKf) * 0.1f);
        if (this.jKg == 0) {
            if (this.jKf < 0) {
                this.jKg = -1;
            } else {
                this.jKg = 1;
            }
        }
        if (Math.abs(this.jKf) <= 1) {
            this.jKa.bkU();
            this.jKa.getHandler().sendEmptyMessage(3000);
            AppMethodBeat.o(175298);
            return;
        }
        this.jKa.setTotalScrollY(this.jKa.getTotalScrollY() + ((float) this.jKg));
        if (!this.jKa.jqj) {
            float itemHeight = this.jKa.getItemHeight();
            float f2 = ((float) (-this.jKa.getInitPosition())) * itemHeight;
            float itemsCount = itemHeight * ((float) ((this.jKa.getItemsCount() - 1) - this.jKa.getInitPosition()));
            if (this.jKa.getTotalScrollY() <= f2 || this.jKa.getTotalScrollY() >= itemsCount) {
                this.jKa.setTotalScrollY(this.jKa.getTotalScrollY() - ((float) this.jKg));
                this.jKa.bkU();
                this.jKa.getHandler().sendEmptyMessage(3000);
                AppMethodBeat.o(175298);
                return;
            }
        }
        this.jKa.getHandler().sendEmptyMessage(1000);
        this.jKf -= this.jKg;
        AppMethodBeat.o(175298);
    }
}
