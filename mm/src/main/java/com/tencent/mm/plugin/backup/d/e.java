package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e {
    com.tencent.mm.plugin.backup.b.e oIX;
    LinkedList<adi> oMr;
    String oMs;
    private String oMt = "";
    private boolean oMu = false;
    a oMv;
    private MTimerHandler oMw = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.backup.d.e.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(21360);
            e.this.cfO();
            AppMethodBeat.o(21360);
            return true;
        }
    }, true);
    final i oMx = new i() {
        /* class com.tencent.mm.plugin.backup.d.e.AnonymousClass2 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            byte[] bufferToBytes;
            AppMethodBeat.i(21361);
            b.b(704, e.this.oMx);
            Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.backup.e.b bVar = (com.tencent.mm.plugin.backup.e.b) qVar;
                ir irVar = (ir) bVar.rr.iLL.iLR;
                b.cfv().oIU = "";
                b.cfv().oIV = irVar.KML;
                b.cfv().oIW = irVar.KMM;
                b.cfv().oLq = irVar.KMH;
                ir irVar2 = (ir) bVar.rr.iLL.iLR;
                if (irVar2 == null) {
                    bufferToBytes = null;
                } else {
                    bufferToBytes = irVar2.KMI == null ? null : irVar2.KMI.getBufferToBytes();
                }
                if (bufferToBytes != null) {
                    e.this.oIX.oJc = 51;
                    e.this.oMv.n(51, bufferToBytes);
                }
                AppMethodBeat.o(21361);
                return;
            }
            Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(str)));
            Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i3 == -100 || i3 == -2023) {
                bg.azz().a(1000, e.this.oMy);
                bg.azz().a(new com.tencent.mm.plugin.backup.e.a(e.this.oMr, e.this.oMs, b.cfv().oLq), 0);
                AppMethodBeat.o(21361);
                return;
            }
            e.this.oIX.oJc = -11;
            e.this.oMv.n(-11, null);
            AppMethodBeat.o(21361);
        }
    };
    final i oMy = new i() {
        /* class com.tencent.mm.plugin.backup.d.e.AnonymousClass3 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            byte[] bufferToBytes;
            AppMethodBeat.i(21362);
            b.b(1000, e.this.oMy);
            Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 == 0 && i3 == 0) {
                iq iqVar = ((k.b) ((com.tencent.mm.plugin.backup.e.a) qVar).iMO.getRespObj()).KzF;
                Object[] objArr = new Object[1];
                objArr[0] = iqVar == null ? BuildConfig.COMMAND : iqVar.KMJ;
                Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", objArr);
                if (iqVar == null) {
                    bufferToBytes = null;
                } else {
                    bufferToBytes = iqVar.KMI == null ? null : iqVar.KMI.getBufferToBytes();
                }
                if (bufferToBytes != null) {
                    e.this.oIX.oJc = 51;
                    e.this.oMv.n(51, bufferToBytes);
                }
                AppMethodBeat.o(21362);
                return;
            }
            Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(str)));
            e.this.oIX.oJc = -11;
            e.this.oMv.n(-11, null);
            AppMethodBeat.o(21362);
        }
    };

    public interface a {
        void n(int i2, byte[] bArr);
    }

    public e(a aVar, com.tencent.mm.plugin.backup.b.e eVar) {
        AppMethodBeat.i(21363);
        this.oMv = aVar;
        this.oIX = eVar;
        AppMethodBeat.o(21363);
    }

    public final void start() {
        AppMethodBeat.i(21364);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", Boolean.valueOf(this.oMu), Boolean.valueOf(this.oMw.stopped()), this, Util.getStack());
        if (this.oMu) {
            AppMethodBeat.o(21364);
            return;
        }
        this.oMu = true;
        if (cfP()) {
            this.oMt = null;
            cfO();
        } else {
            this.oIX.oJc = -4;
            this.oMv.n(-4, null);
        }
        this.oMw.startTimer(500);
        AppMethodBeat.o(21364);
    }

    public final void stop() {
        AppMethodBeat.i(21365);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.oMu = false;
        bg.azz().b(704, this.oMx);
        bg.azz().b(1000, this.oMy);
        this.oMw.stopTimer();
        AppMethodBeat.o(21365);
    }

    /* access modifiers changed from: package-private */
    public final void cfO() {
        AppMethodBeat.i(21366);
        String eE = g.eE(MMApplicationContext.getContext());
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", eE, this.oMt, Boolean.valueOf(bg.aAc()), Boolean.valueOf(bg.azj()));
        if (!eE.equals(this.oMt)) {
            if (!bg.aAc()) {
                AppMethodBeat.o(21366);
                return;
            }
            this.oMt = eE;
            if (!cfP()) {
                this.oMu = false;
                AppMethodBeat.o(21366);
                return;
            }
            this.oMu = false;
            if (!bg.azj()) {
                Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                bg.azz().a(704, this.oMx);
                bg.azz().a(new com.tencent.mm.plugin.backup.e.b(this.oMr, this.oMs), 0);
                AppMethodBeat.o(21366);
                return;
            }
            Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
            bg.azz().a(1000, this.oMy);
            bg.azz().a(new com.tencent.mm.plugin.backup.e.a(this.oMr, this.oMs, b.cfv().oLq), 0);
        }
        AppMethodBeat.o(21366);
    }

    private boolean cfP() {
        AppMethodBeat.i(21367);
        this.oMr = new LinkedList<>();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.oMs = g.eE(MMApplicationContext.getContext());
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", this.oMs);
        if (Util.isNullOrNil(this.oMs)) {
            this.oIX.oJc = -4;
            this.oMv.n(-4, null);
            this.oMt = "";
            AppMethodBeat.o(21367);
            return false;
        } else if (!b.cfv().cfw().a(pString, pInt)) {
            this.oIX.oJc = -4;
            this.oMv.n(-4, null);
            this.oMt = "";
            AppMethodBeat.o(21367);
            return false;
        } else {
            Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", pString.value, Integer.valueOf(pInt.value));
            adi adi = new adi();
            adi.LjZ = pString.value;
            adi.Low = new LinkedList<>();
            adi.Low.add(Integer.valueOf(pInt.value));
            this.oMr.add(adi);
            AppMethodBeat.o(21367);
            return true;
        }
    }
}
