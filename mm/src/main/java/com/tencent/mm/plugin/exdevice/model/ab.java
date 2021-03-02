package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.je;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.tavkit.component.TAVPlayer;

public final class ab extends IListener<je> implements i {
    private ProgressDialog gtM;
    private je rAL;

    public ab() {
        AppMethodBeat.i(161355);
        this.__eventId = je.class.getName().hashCode();
        AppMethodBeat.o(161355);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(je jeVar) {
        AppMethodBeat.i(23441);
        boolean a2 = a(jeVar);
        AppMethodBeat.o(23441);
        return a2;
    }

    private boolean a(je jeVar) {
        AppMethodBeat.i(23437);
        if (jeVar instanceof je) {
            this.rAL = jeVar;
            String str = this.rAL.dNT.result;
            Log.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", Integer.valueOf(this.rAL.dNT.actionCode), str);
            if (!Util.isNullOrNil(str)) {
                switch (this.rAL.dNT.actionCode) {
                    case 15:
                        if (this.rAL.dNT.context == null || !(this.rAL.dNT.context instanceof Activity)) {
                            AppMethodBeat.o(23437);
                            break;
                        } else {
                            bg.azz().a(TAVPlayer.VIDEO_PLAYER_WIDTH, this);
                            final u uVar = new u(str);
                            bg.azz().a(uVar, 0);
                            Context context = this.rAL.dNT.context;
                            this.rAL.dNT.context.getString(R.string.zb);
                            this.gtM = h.b(context, this.rAL.dNT.context.getString(R.string.gct), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.exdevice.model.ab.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(23436);
                                    bg.azz().a(uVar);
                                    if (ab.this.rAL.callback != null) {
                                        ab.this.rAL.dNU.ret = 1;
                                        ab.this.rAL.callback.run();
                                    }
                                    AppMethodBeat.o(23436);
                                }
                            });
                        }
                        break;
                    default:
                        AppMethodBeat.o(23437);
                        break;
                }
            } else {
                AppMethodBeat.o(23437);
            }
        } else {
            Log.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
            AppMethodBeat.o(23437);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x026a  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r17, int r18, java.lang.String r19, com.tencent.mm.ak.q r20) {
        /*
        // Method dump skipped, instructions count: 1719
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.ab.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private void cKJ() {
        AppMethodBeat.i(23439);
        if (!(this.rAL == null || this.rAL.callback == null)) {
            this.rAL.dNU.ret = 1;
            this.rAL.callback.run();
        }
        AppMethodBeat.o(23439);
    }

    private void stopScan() {
        AppMethodBeat.i(23440);
        if (!(this.rAL == null || this.rAL.callback == null)) {
            this.rAL.dNU.ret = 2;
            this.rAL.callback.run();
        }
        AppMethodBeat.o(23440);
    }
}
