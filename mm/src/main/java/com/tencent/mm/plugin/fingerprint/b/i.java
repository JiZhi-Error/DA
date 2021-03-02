package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends IListener<ow> {
    private String dDL = "";
    private boolean wEZ = false;
    private a wFu;
    private ow wFv;

    public i() {
        AppMethodBeat.i(160796);
        this.__eventId = ow.class.getName().hashCode();
        AppMethodBeat.o(160796);
    }

    static /* synthetic */ void a(i iVar, int i2, String str) {
        AppMethodBeat.i(213242);
        iVar.ak(i2, str);
        AppMethodBeat.o(213242);
    }

    static /* synthetic */ boolean b(i iVar, boolean z) {
        AppMethodBeat.i(213240);
        boolean po = iVar.po(z);
        AppMethodBeat.o(213240);
        return po;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ow owVar) {
        AppMethodBeat.i(64342);
        ow owVar2 = owVar;
        if (!g.aAc()) {
            Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        } else {
            this.wEZ = false;
            if (owVar2 instanceof ow) {
                Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (!d.dJX()) {
                    Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                    this.wEZ = true;
                    ak(1, "");
                    AppMethodBeat.o(64342);
                    return true;
                }
                this.wFv = owVar2;
                if (this.wFv == null) {
                    Log.e("MicroMsg.OpenFingerPrintAuthEventListener", null, "mEvent is null !!!");
                } else {
                    this.dDL = owVar2.dUQ.dNQ;
                    p.IML.wFL = this.dDL;
                    boolean dKr = ((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).dKr();
                    if (this.wFu == null) {
                        this.wFu = new a();
                    }
                    if (!Util.isNullOrNil(p.IML.wFE)) {
                        po(false);
                    } else {
                        Log.w("MicroMsg.OpenFingerPrintAuthEventListener", "no challenge!!");
                        ak(1, "");
                    }
                    AppMethodBeat.o(64342);
                    return dKr;
                }
            }
        }
        AppMethodBeat.o(64342);
        return false;
    }

    public final void release() {
        AppMethodBeat.i(64338);
        ((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
        this.wFv = null;
        AppMethodBeat.o(64338);
    }

    public static void dKl() {
        AppMethodBeat.i(64339);
        ((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).cancel();
        AppMethodBeat.o(64339);
    }

    private boolean po(boolean z) {
        AppMethodBeat.i(64340);
        dKl();
        if (!((com.tencent.mm.plugin.fingerprint.b.a.i) g.af(com.tencent.mm.plugin.fingerprint.b.a.i.class)).dKr()) {
            Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
            release();
            this.wEZ = true;
            ak(1, "");
            AppMethodBeat.o(64340);
            return false;
        }
        ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.wFu, z);
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
        AppMethodBeat.o(64340);
        return true;
    }

    private void ak(int i2, String str) {
        AppMethodBeat.i(64341);
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).a(this.wFv, i2, str);
        if (this.wEZ) {
            this.wFv = null;
        }
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
        AppMethodBeat.o(64341);
    }

    public class a implements c {
        public a() {
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.fingerprint.d.c
        public final void gz(int i2, int i3) {
            AppMethodBeat.i(64337);
            if (i.this.wEZ) {
                Log.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
                AppMethodBeat.o(64337);
                return;
            }
            switch (i2) {
                case 0:
                    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                    i.a(i.this, i3);
                    i.dKl();
                    AppMethodBeat.o(64337);
                    return;
                case 2000:
                    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                    AppMethodBeat.o(64337);
                    return;
                case 2001:
                    i.b(i.this, false);
                    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                    AppMethodBeat.o(64337);
                    return;
                case 2002:
                    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                    i.this.wEZ = false;
                    i.dKl();
                    i.b(i.this, true);
                    i.b(i.this);
                    AppMethodBeat.o(64337);
                    return;
                case 2004:
                case 2005:
                case 2007:
                case 10308:
                    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i2));
                    i.this.wEZ = true;
                    String string = MMApplicationContext.getContext().getString(R.string.hd4);
                    if (i2 == 10308) {
                        string = MMApplicationContext.getContext().getString(R.string.hd5);
                    } else if (i2 == 2007) {
                        if (i.this.wFv != null) {
                            ow unused = i.this.wFv;
                        }
                        p.IML.wFM = true;
                    } else if (i2 == 2005) {
                        string = MMApplicationContext.getContext().getString(R.string.hd6);
                        if (i.this.wFv != null) {
                            ow unused2 = i.this.wFv;
                        }
                    }
                    i.dKl();
                    i.a(i.this, 2, string);
                    AppMethodBeat.o(64337);
                    return;
                case 2009:
                    Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", Integer.valueOf(i2));
                    if (i.this.wFv != null) {
                        com.tencent.mm.plugin.soter.d.a.aaw(i.this.wFv.dUQ.dUT);
                    }
                    i.this.wEZ = true;
                    String string2 = MMApplicationContext.getContext().getString(R.string.hd4);
                    i.dKl();
                    i.a(i.this, i2, string2);
                    break;
            }
            AppMethodBeat.o(64337);
        }
    }

    static /* synthetic */ void a(i iVar, int i2) {
        AppMethodBeat.i(213239);
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
        iVar.wEZ = true;
        ((com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).a(iVar.wFv, i2);
        if (iVar.wEZ) {
            iVar.wFv = null;
        }
        Log.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
        AppMethodBeat.o(213239);
    }

    static /* synthetic */ void b(i iVar) {
        AppMethodBeat.i(213241);
        iVar.ak(1, "");
        AppMethodBeat.o(213241);
    }
}
