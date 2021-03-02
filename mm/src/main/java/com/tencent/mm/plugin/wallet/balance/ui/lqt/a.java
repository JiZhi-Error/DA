package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.f;

public final class a {
    private Context context = null;
    d kvo = null;

    public interface b {
        void aep(int i2);
    }

    public a(Context context2) {
        this.context = context2;
    }

    public final void a(ckj ckj, b bVar) {
        AppMethodBeat.i(213933);
        if (ckj == null || this.context == null) {
            Log.w("MicroMsg.LqtDialogHelper", "dialog or context is null");
            AppMethodBeat.o(213933);
        } else if (ckj.style == 1) {
            if (ckj.MpS == null) {
                Log.w("MicroMsg.LqtDialogHelper", "dialog center_btn is null");
                AppMethodBeat.o(213933);
            } else if (this.kvo == null || !this.kvo.isShowing()) {
                this.kvo = h.a(this.context, ckj.dQx, "", ckj.MpS.dQx, false, (DialogInterface.OnClickListener) new DialogInterface$OnClickListenerC1902a(this.context, ckj.MpS, bVar));
                AppMethodBeat.o(213933);
            } else {
                Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
                AppMethodBeat.o(213933);
            }
        } else if (ckj.style != 2) {
            Log.w("MicroMsg.LqtDialogHelper", "unknown dialog type");
            AppMethodBeat.o(213933);
        } else if (ckj.MpU == null || ckj.MpT == null) {
            Log.w("MicroMsg.LqtDialogHelper", "dialog right_btn or left_btn is null");
            AppMethodBeat.o(213933);
        } else if (this.kvo == null || !this.kvo.isShowing()) {
            this.kvo = h.a(this.context, ckj.dQx, "", ckj.MpU.dQx, ckj.MpT.dQx, false, (DialogInterface.OnClickListener) new DialogInterface$OnClickListenerC1902a(this.context, ckj.MpU, bVar), (DialogInterface.OnClickListener) new DialogInterface$OnClickListenerC1902a(this.context, ckj.MpT, bVar));
            AppMethodBeat.o(213933);
        } else {
            Log.i("MicroMsg.LqtDialogHelper", "old dialog is exits");
            AppMethodBeat.o(213933);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.a$a  reason: collision with other inner class name */
    public class DialogInterface$OnClickListenerC1902a implements DialogInterface.OnClickListener {
        private final ckk HwL;
        private final b HwM;
        private final Context context;

        public DialogInterface$OnClickListenerC1902a(Context context2, ckk ckk, b bVar) {
            this.context = context2;
            this.HwL = ckk;
            this.HwM = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(213932);
            a.this.kvo = null;
            if (this.HwL == null || this.context == null) {
                Log.w("MicroMsg.LqtDialogHelper", "LqtDialogBtn or context is null");
                AppMethodBeat.o(213932);
                return;
            }
            if (this.HwL.uSc == 2) {
                f.bn(this.context, this.HwL.nnB);
            } else if (this.HwL.uSc == 3) {
                f.u(this.HwL.MpV, this.HwL.MpW, 0, 1061);
            } else {
                Log.i("MicroMsg.LqtDialogHelper", "jump type not support native or none");
            }
            if (this.HwM != null) {
                this.HwM.aep(this.HwL.uSc);
            }
            AppMethodBeat.o(213932);
        }
    }
}
