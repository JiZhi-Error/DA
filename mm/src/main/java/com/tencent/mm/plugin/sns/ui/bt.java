package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class bt {
    public int EBc = -1;
    int ECI = -1;
    int ERG = -1;
    int ERH = -1;
    public int ERI = 0;
    boolean ERJ = false;
    protected long ERK;
    Runnable ERL = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.bt.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(99751);
            if (bt.this.list != null && bt.this.list.getCount() > bt.this.position) {
                int top = bt.this.EoJ.getTop();
                Log.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bt.this.das + " footerHeight:" + bt.this.EoJ.getHeight() + " listOriginalBottom: " + bt.this.EBc);
                if (bt.a(bt.this) > 0 && (bt.this.ECI != top || top > bt.this.EBc - 200 || bt.this.list.getBottom() > (bt.this.EBc - bt.this.EoJ.getHeight()) - 150)) {
                    int i2 = 10;
                    if (bt.this.das == 0) {
                        i2 = 200;
                    }
                    new MMHandler().postDelayed(this, (long) i2);
                }
                bt.this.ECI = top;
                int i3 = (bt.this.ECI - bt.this.ERI) - bt.this.ERG;
                Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bt.this.ERG + " footerTop" + bt.this.ECI + " list.bottom:" + bt.this.list.getBottom() + " position: " + bt.this.position + " topselection: " + i3);
                Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bt.this.list.getTop() + " marginTop: " + bt.this.ERI + " footerTop " + bt.this.ECI);
                bt.this.list.setSelectionFromTop(bt.this.position + bt.this.list.getHeaderViewsCount(), i3);
            }
            AppMethodBeat.o(99751);
        }
    };
    Runnable ERM = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.bt.AnonymousClass2 */
        int offset = 0;

        public final void run() {
            AppMethodBeat.i(99752);
            if (bt.this.list != null && bt.this.list.getCount() > bt.this.position) {
                bt.this.ECI = bt.this.EoJ.getTop();
                int i2 = (bt.this.ECI - bt.this.ERI) - bt.this.ERG;
                Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bt.this.ERG + " footerTop" + bt.this.ECI + " list.bottom:" + bt.this.list.getBottom() + " position: " + bt.this.position + " topselection: " + i2);
                Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bt.this.list.getTop() + " marginTop: " + bt.this.ERI + " footerTop " + bt.this.ECI);
                if (i2 == this.offset) {
                    bt.this.list.setSelectionFromTop(bt.this.position + bt.this.list.getHeaderViewsCount(), i2);
                    this.offset = 0;
                    bt.this.das = 0;
                    AppMethodBeat.o(99752);
                    return;
                } else if (bt.a(bt.this) > 0) {
                    new MMHandler().postDelayed(this, 100);
                    this.offset = i2;
                    AppMethodBeat.o(99752);
                    return;
                } else {
                    this.offset = 0;
                    bt.this.das = 0;
                }
            }
            AppMethodBeat.o(99752);
        }
    };
    Runnable ERN = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.bt.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(99753);
            Log.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bt.this.ERH + " position:" + bt.this.position + " list.bottom:" + bt.this.list.getBottom());
            AppMethodBeat.o(99753);
        }
    };
    SnsCommentFooter EoJ;
    int das;
    ListView list;
    int position = -1;

    static /* synthetic */ int a(bt btVar) {
        int i2 = btVar.das;
        btVar.das = i2 - 1;
        return i2;
    }

    public bt(ListView listView, SnsCommentFooter snsCommentFooter) {
        AppMethodBeat.i(99754);
        this.list = listView;
        this.EoJ = snsCommentFooter;
        AppMethodBeat.o(99754);
    }

    public final void fjX() {
        AppMethodBeat.i(99755);
        this.ERJ = true;
        new MMHandler().postDelayed(this.ERL, 30);
        this.das = 10;
        Log.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.EoJ.getTop());
        this.ERK = Util.currentTicks();
        AppMethodBeat.o(99755);
    }

    public final void fjY() {
        AppMethodBeat.i(99756);
        this.ERJ = true;
        this.das = 20;
        new MMHandler().postDelayed(this.ERM, 100);
        AppMethodBeat.o(99756);
    }

    public final void fjZ() {
        AppMethodBeat.i(99757);
        if (!this.ERJ) {
            AppMethodBeat.o(99757);
            return;
        }
        this.ERJ = false;
        new MMHandler().postDelayed(this.ERN, 30);
        this.das = 10;
        AppMethodBeat.o(99757);
    }
}
