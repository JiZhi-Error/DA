package com.tencent.mm.plugin.scanner.b.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.b.a.la;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.f.e;
import com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.scanlib.ui.ScanView;

public final class a extends e implements i, e.a {
    public boolean CEf;
    private la CEg;
    private int count;
    private String dRM = MD5Util.getMD5String(z.aTY() + System.currentTimeMillis());
    private Bitmap dZM;

    public a(int i2, ScanView scanView, e.b bVar, la laVar) {
        AppMethodBeat.i(118336);
        this.mode = i2;
        this.CIW = scanView;
        this.CIX = bVar;
        this.CEg = laVar;
        this.context = scanView.getContext();
        g.azz().a(2693, this);
        AppMethodBeat.o(118336);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void c(long j2, Bundle bundle) {
        AppMethodBeat.i(118337);
        if (bundle != null) {
            this.dZM = (Bitmap) bundle.getParcelable("param_card_bitmap");
            if (this.dZM != null) {
                String str = this.dRM;
                byte[] Bitmap2Bytes = BitmapUtil.Bitmap2Bytes(this.dZM);
                int i2 = this.count;
                this.count = i2 + 1;
                g.azz().a(new com.tencent.mm.plugin.scanner.b.b.a(str, Bitmap2Bytes, i2), 0);
                AppMethodBeat.o(118337);
                return;
            }
            r(2, null);
        }
        AppMethodBeat.o(118337);
    }

    @Override // com.tencent.mm.plugin.scanner.f.e
    public final void destroy() {
        AppMethodBeat.i(118338);
        g.azz().b(2693, this);
        AppMethodBeat.o(118338);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.scanner.f.e.a
    public final void r(int i2, Bundle bundle) {
        AppMethodBeat.i(118339);
        Log.i("MicroMsg.BankCardHandler", "notify Event: %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                AppMethodBeat.o(118339);
                return;
            case 1:
            case 2:
                this.CIW.onResume();
                AppMethodBeat.o(118339);
                return;
            case 3:
                this.CIX.cvn();
                AppMethodBeat.o(118339);
                return;
            case 5:
                this.CIW.onPause();
                break;
        }
        AppMethodBeat.o(118339);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        jb jbVar;
        boolean z;
        Bitmap createBitmap;
        AppMethodBeat.i(118340);
        Log.i("MicroMsg.BankCardHandler", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.dRM.equals(((com.tencent.mm.plugin.scanner.b.b.a) qVar).dRM)) {
                com.tencent.mm.plugin.scanner.b.b.a aVar = (com.tencent.mm.plugin.scanner.b.b.a) qVar;
                if (aVar.rr.iLL.iLR != null) {
                    jbVar = ((pc) aVar.rr.iLL.iLR).KVW;
                } else {
                    jbVar = null;
                }
                if (jbVar != null) {
                    String str2 = jbVar.KNx.text;
                    Log.d("MicroMsg.BankCardHandler", "cardNumber %s", str2);
                    Rect rect = new Rect((int) jbVar.KNx.MzB.MIr.x, (int) jbVar.KNx.MzB.MIr.y, (int) jbVar.KNx.MzB.MIt.x, (int) jbVar.KNx.MzB.MIt.y);
                    Log.i("MicroMsg.BankCardHandler", "cropRect %s", rect);
                    Bitmap bitmap = this.dZM;
                    if (rect.left < 0 || rect.top < 0 || rect.width() <= 0 || rect.width() > bitmap.getWidth() || rect.height() <= 0 || rect.height() > bitmap.getHeight()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z && (createBitmap = Bitmap.createBitmap(this.dZM, rect.left, rect.top, rect.width(), rect.height())) != null && !Util.isNullOrNil(str2)) {
                        if (this.CEf) {
                            ConfirmScanBankCardResultUI.c(createBitmap, str2);
                        } else {
                            tg tgVar = new tg();
                            tgVar.dZH.cardId = str2;
                            tgVar.dZH.dZI = createBitmap;
                            EventCenter.instance.publish(tgVar);
                        }
                        this.CEg.erW = 3;
                        r(3, null);
                        AppMethodBeat.o(118340);
                        return;
                    }
                }
            }
            r(2, null);
            AppMethodBeat.o(118340);
            return;
        }
        r(2, null);
        AppMethodBeat.o(118340);
    }
}
