package com.tencent.mm.plugin.scanner.f;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.scanlib.ui.ScanView;

public final class d extends e implements i, e.a {
    private int CIR;
    private boolean CIS = true;
    private c CIT;
    private a CIU;
    private com.tencent.mm.plugin.scanner.view.c CIV;

    public interface a extends e.b {
        void s(int i2, Bundle bundle);
    }

    public d(int i2, int i3, ScanView scanView, a aVar, com.tencent.mm.plugin.scanner.view.c cVar) {
        AppMethodBeat.i(51660);
        this.mode = i2;
        this.CIR = i3;
        this.CIW = scanView;
        this.CIU = aVar;
        this.context = scanView.getContext();
        this.CIV = cVar;
        g.azz().a(971, this);
        AppMethodBeat.o(51660);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void c(long j2, Bundle bundle) {
        AppMethodBeat.i(51661);
        if (bundle == null) {
            AppMethodBeat.o(51661);
            return;
        }
        String string = bundle.getString("result_content", "");
        String string2 = bundle.getString("result_code_name", "");
        int bcV = e.d.bcV(string2);
        int i2 = bundle.getInt("result_code_version", 0);
        int i3 = bundle.getInt("qbar_string_scan_source", 0);
        Log.i("MicroMsg.QRCodeHandler", "alvinluo handleResult content %s, codeType %d, codeName %s, codeVersion %d", string, Integer.valueOf(bcV), string2, Integer.valueOf(i2));
        if (!Util.isNullOrNil(string)) {
            qa qaVar = new qa();
            qaVar.dWj.dWl = string2;
            qaVar.dWj.scanResult = string;
            qaVar.dWj.cSx = 1;
            EventCenter.instance.publish(qaVar);
            if (qaVar.dWk.ret != 1) {
                if (this.CIT != null) {
                    this.CIT.eRR();
                }
                if (e.d.ahw(bcV)) {
                    this.CIT = new c();
                    this.CIT.a((Activity) this.CIW.getContext(), string, i3, string2, bcV, i2, this, this.CIV, null, this.CIR, false, -1, this.CIS);
                    AppMethodBeat.o(51661);
                    return;
                }
                new com.tencent.mm.plugin.scanner.util.a().a((Activity) this.CIW.getContext(), this, this.CIV, string, i3 == 1, i2, string2, null, this.CIR, false, -1, this.CIS, i3 == 1 ? 1 : 0);
            } else if (this.CIU != null) {
                this.CIU.cvn();
                AppMethodBeat.o(51661);
                return;
            }
        }
        AppMethodBeat.o(51661);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(51662);
        Log.i("MicroMsg.QRCodeHandler", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        switch (i2) {
            case 1:
                if (g.azz().aYT()) {
                    g.azz().getNetworkServerIp();
                    new StringBuilder().append(i3);
                } else if (ag.dm(this.context)) {
                    m.iC(this.context);
                } else {
                    Toast.makeText(this.context, this.context.getString(R.string.deo, 1, Integer.valueOf(i3)), 1).show();
                }
                z = true;
                break;
            case 2:
                Toast.makeText(this.context, this.context.getString(R.string.dep), 1).show();
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            r(0, null);
            AppMethodBeat.o(51662);
        } else if (i2 == 4 && i3 == -2004) {
            h.n(this.context, R.string.fsc, R.string.zb);
            AppMethodBeat.o(51662);
        } else if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 971) {
                r(3, null);
            }
            AppMethodBeat.o(51662);
        } else {
            Toast.makeText(this.context, this.context.getString(R.string.dg3, Integer.valueOf(i2), Integer.valueOf(i3)), 0).show();
            AppMethodBeat.o(51662);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.f.e.a
    public final void r(int i2, Bundle bundle) {
        AppMethodBeat.i(51663);
        Log.i("MicroMsg.QRCodeHandler", "notify Event: %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                AppMethodBeat.o(51663);
                return;
            case 1:
                this.CIW.onResume();
                AppMethodBeat.o(51663);
                return;
            case 2:
                this.CIW.onResume();
                AppMethodBeat.o(51663);
                return;
            case 3:
                if (this.CIU != null) {
                    this.CIU.cvn();
                    AppMethodBeat.o(51663);
                    return;
                }
                break;
            case 5:
                this.CIW.onPause();
                AppMethodBeat.o(51663);
                return;
            case 6:
                if (this.CIU != null) {
                    this.CIU.s(1, bundle);
                    AppMethodBeat.o(51663);
                    return;
                }
                break;
            case 7:
                if (this.CIU != null) {
                    this.CIU.s(2, bundle);
                    AppMethodBeat.o(51663);
                    return;
                }
                break;
            case 8:
                if (this.CIU != null) {
                    this.CIU.s(3, bundle);
                    break;
                }
                break;
        }
        AppMethodBeat.o(51663);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void destroy() {
        AppMethodBeat.i(51664);
        g.azz().b(971, this);
        if (this.CIT != null) {
            this.CIT.eRR();
        }
        AppMethodBeat.o(51664);
    }
}
