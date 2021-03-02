package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class e {
    ListView ytY;
    h ytZ;
    View yua;
    IPCallAddressUI yub;
    boolean yuc = false;
    TextView yud = null;
    TextView yue = null;
    LinearLayout yuf = null;
    TextView yug = null;
    ImageView yuh = null;

    public e(IPCallAddressUI iPCallAddressUI, ListView listView, View view) {
        this.ytY = listView;
        this.yub = iPCallAddressUI;
        this.yua = view;
    }

    public final void ebh() {
        AppMethodBeat.i(25658);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(25654);
                bg.aVF();
                if (((Boolean) c.azQ().get(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    e.this.yuh.setVisibility(0);
                } else {
                    e.this.yuh.setVisibility(8);
                }
                bg.aVF();
                String str = (String) c.azQ().get(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, "");
                bg.aVF();
                String str2 = (String) c.azQ().get(ar.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, "");
                if (!Util.isNullOrNil(str)) {
                    e.this.yug.setText(str);
                    e.this.yuf.setVisibility(0);
                    AppMethodBeat.o(25654);
                } else if (!Util.isNullOrNil(str2)) {
                    e.this.yug.setText(str2);
                    e.this.yuf.setVisibility(0);
                    AppMethodBeat.o(25654);
                } else {
                    e.this.yug.setText("");
                    e.this.yuf.setVisibility(8);
                    AppMethodBeat.o(25654);
                }
            }
        });
        AppMethodBeat.o(25658);
    }

    public final void ebi() {
        AppMethodBeat.i(25659);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ipcall.ui.e.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(25655);
                byf ebR = com.tencent.mm.plugin.ipcall.a.c.ebR();
                if (ebR != null) {
                    e.this.yud.setText(ebR.MdJ);
                    if (!Util.isNullOrNil(ebR.MdR)) {
                        e.this.yue.setText(ebR.MdR);
                        e.this.yue.setVisibility(0);
                        AppMethodBeat.o(25655);
                        return;
                    }
                    e.this.yue.setText("");
                    e.this.yue.setVisibility(8);
                    AppMethodBeat.o(25655);
                    return;
                }
                e.this.yud.setText("");
                e.this.yue.setText("");
                e.this.yue.setVisibility(8);
                AppMethodBeat.o(25655);
            }
        });
        AppMethodBeat.o(25659);
    }
}
