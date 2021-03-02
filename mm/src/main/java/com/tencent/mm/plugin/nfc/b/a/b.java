package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class b implements d {
    private IsoDep AEj;

    public b(Tag tag) {
        AppMethodBeat.i(26665);
        if (tag == null) {
            Log.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            IllegalStateException illegalStateException = new IllegalStateException("tag is null");
            AppMethodBeat.o(26665);
            throw illegalStateException;
        }
        this.AEj = IsoDep.get(tag);
        AppMethodBeat.o(26665);
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final boolean connect() {
        AppMethodBeat.i(26666);
        if (!this.AEj.isConnected()) {
            this.AEj.connect();
        }
        AppMethodBeat.o(26666);
        return true;
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final void close() {
        AppMethodBeat.i(26667);
        if (this.AEj.isConnected()) {
            this.AEj.close();
        }
        AppMethodBeat.o(26667);
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final boolean isConnected() {
        AppMethodBeat.i(26668);
        boolean isConnected = this.AEj.isConnected();
        AppMethodBeat.o(26668);
        return isConnected;
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final boolean exx() {
        AppMethodBeat.i(26669);
        close();
        connect();
        AppMethodBeat.o(26669);
        return true;
    }

    @Override // com.tencent.mm.plugin.nfc.b.a.d
    public final c a(a aVar) {
        AppMethodBeat.i(26670);
        if (this.AEj == null) {
            Log.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            IllegalStateException illegalStateException = new IllegalStateException("IsoDep is null");
            AppMethodBeat.o(26670);
            throw illegalStateException;
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.AEj.transceive(aVar.getBytes()));
            if (cVar2.ADT.length != 0) {
                if (cVar2.ADT.length - 2 > 0) {
                    if (cVar2.ext() != 108) {
                        if (cVar == null) {
                            cVar = cVar2;
                        } else {
                            cVar.a(cVar2);
                        }
                        if (cVar2.ext() != 97) {
                            break;
                        }
                        aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.AEb.clone());
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
        AppMethodBeat.o(26670);
        return cVar;
    }
}
