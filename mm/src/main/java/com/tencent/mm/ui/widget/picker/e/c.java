package com.tencent.mm.ui.widget.picker.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.TimerTask;

public final class c extends TimerTask {
    private final WheelView QUD;
    private int jKf = Integer.MAX_VALUE;
    private int jKg = 0;
    private int offset;

    public c(WheelView wheelView, int i2) {
        this.QUD = wheelView;
        this.offset = i2;
    }

    public final void run() {
        AppMethodBeat.i(198524);
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
            this.QUD.bkU();
            this.QUD.getHandler().sendEmptyMessage(3000);
            AppMethodBeat.o(198524);
            return;
        }
        this.QUD.setTotalScrollY(this.QUD.getTotalScrollY() + ((float) this.jKg));
        if (!this.QUD.jqj) {
            float itemHeight = this.QUD.getItemHeight();
            float f2 = ((float) (-this.QUD.getInitPosition())) * itemHeight;
            float itemsCount = itemHeight * ((float) ((this.QUD.getItemsCount() - 1) - this.QUD.getInitPosition()));
            if (this.QUD.getTotalScrollY() <= f2 || this.QUD.getTotalScrollY() >= itemsCount) {
                this.QUD.setTotalScrollY(this.QUD.getTotalScrollY() - ((float) this.jKg));
                this.QUD.bkU();
                this.QUD.getHandler().sendEmptyMessage(3000);
                AppMethodBeat.o(198524);
                return;
            }
        }
        this.QUD.getHandler().sendEmptyMessage(1000);
        this.jKf -= this.jKg;
        AppMethodBeat.o(198524);
    }
}
