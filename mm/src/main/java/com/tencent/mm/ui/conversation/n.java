package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class n {
    ListView Qbd;
    i Qct;
    boolean QgR = false;
    private MMHandler QgS;
    private Runnable QgT;
    int QgU = -1;
    e gup = new e(new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.ui.conversation.n.AnonymousClass1 */

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AppMethodBeat.i(234253);
            d dVar = d.QbK;
            d.a(n.this.Qbd, n.this.Qct, true, true);
            AppMethodBeat.o(234253);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(38703);
            if (i2 == 2) {
                d.gGm().gV(MainUI.class.getName() + ".Listview", 4);
            }
            if (i2 != 0) {
                n.this.gWg();
                AppMethodBeat.o(38703);
            } else if (n.this.Qbd == null) {
                AppMethodBeat.o(38703);
            } else {
                n.a(n.this, -1);
                AppMethodBeat.o(38703);
            }
        }
    });

    public n() {
        AppMethodBeat.i(38706);
        AppMethodBeat.o(38706);
    }

    /* access modifiers changed from: package-private */
    public final void gWg() {
        AppMethodBeat.i(38707);
        if (!this.QgR) {
            Log.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
            this.QgR = true;
        }
        if (!(this.QgS == null || this.QgT == null)) {
            this.QgS.removeCallbacks(this.QgT);
        }
        if (this.QgS != null) {
            this.QgS.quit();
            this.QgS = null;
        }
        AppMethodBeat.o(38707);
    }

    static /* synthetic */ void a(n nVar, int i2) {
        AppMethodBeat.i(234254);
        if (i2 < 0) {
            i2 = 300;
        }
        nVar.gWg();
        if (nVar.QgS == null) {
            nVar.QgS = new MMHandler("pre load mainui avatar");
        }
        nVar.QgR = false;
        MMHandler mMHandler = nVar.QgS;
        AnonymousClass3 r1 = new Runnable() {
            /* class com.tencent.mm.ui.conversation.n.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(38705);
                if (n.this.QgR) {
                    AppMethodBeat.o(38705);
                    return;
                }
                int lastVisiblePosition = n.this.Qbd.getLastVisiblePosition();
                int firstVisiblePosition = n.this.Qbd.getFirstVisiblePosition();
                int i2 = lastVisiblePosition - firstVisiblePosition;
                if (firstVisiblePosition == n.this.QgU) {
                    AppMethodBeat.o(38705);
                    return;
                }
                n.this.QgU = firstVisiblePosition;
                Log.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(i2));
                int i3 = lastVisiblePosition + 1;
                while (i3 < n.this.Qct.getCount() && i3 < (i2 * 1) + lastVisiblePosition) {
                    try {
                        n.this.Qct.anR(i3);
                        i3++;
                    } catch (RuntimeException e2) {
                        Log.printErrStackTrace("MicroMsg.PreLoadHelper", e2, "Failed to preload MainUI avatars", new Object[0]);
                        AppMethodBeat.o(38705);
                        return;
                    }
                }
                int i4 = firstVisiblePosition - 1;
                while (i4 >= 0 && i4 > firstVisiblePosition - (i2 * 1)) {
                    n.this.Qct.anR(i4);
                    i4--;
                }
                AppMethodBeat.o(38705);
            }
        };
        nVar.QgT = r1;
        mMHandler.postDelayed(r1, (long) i2);
        AppMethodBeat.o(234254);
    }
}
