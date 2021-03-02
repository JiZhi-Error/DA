package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements d {
    private NfcA AEk;

    public c(Tag tag) {
        AppMethodBeat.i(26671);
        this.AEk = NfcA.get(tag);
        AppMethodBeat.o(26671);
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        AppMethodBeat.i(26672);
        if (this.AEk == null) {
            Log.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            IllegalStateException illegalStateException = new IllegalStateException("NfcA is null");
            AppMethodBeat.o(26672);
            throw illegalStateException;
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.AEk.transceive(aVar.getBytes()));
            if (cVar2.ADT.length != 0) {
                if (cVar2.ADT.length - 2 >= 0) {
                    if (cVar2.ext() != 108) {
                        if (cVar == null) {
                            cVar = cVar2;
                        } else {
                            cVar.a(cVar2);
                        }
                        if (cVar2.ext() == 97) {
                            if (cVar2.exu() == 0) {
                                cVar.ADT[cVar.ADT.length - 1] = -112;
                                break;
                            }
                            aVar = new a((byte[]) b.AEb.clone());
                        } else {
                            break;
                        }
                    } else {
                        aVar.TH(cVar2.exu());
                    }
                } else {
                    cVar = cVar2;
                    break;
                }
            } else {
                break;
            }
        }
        AppMethodBeat.o(26672);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final boolean connect() {
        AppMethodBeat.i(26673);
        if (!this.AEk.isConnected()) {
            this.AEk.connect();
        }
        AppMethodBeat.o(26673);
        return true;
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final void close() {
        AppMethodBeat.i(26674);
        if (this.AEk.isConnected()) {
            this.AEk.close();
        }
        AppMethodBeat.o(26674);
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final boolean isConnected() {
        AppMethodBeat.i(26675);
        boolean isConnected = this.AEk.isConnected();
        AppMethodBeat.o(26675);
        return isConnected;
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final boolean exx() {
        AppMethodBeat.i(26676);
        close();
        connect();
        AppMethodBeat.o(26676);
        return true;
    }
}
