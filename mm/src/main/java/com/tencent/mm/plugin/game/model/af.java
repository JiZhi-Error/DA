package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.bf;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.game.protobuf.cq;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af extends x {
    public bu xHt;
    private boolean xHu;
    public LinkedList<c> xHv;
    public HashMap<String, Integer> xHw;

    public af(a aVar) {
        AppMethodBeat.i(41549);
        this.xHw = new HashMap<>();
        if (aVar == null) {
            this.xHt = new bu();
            AppMethodBeat.o(41549);
            return;
        }
        this.xHt = (bu) aVar;
        this.xHu = true;
        amZ();
        AppMethodBeat.o(41549);
    }

    public af(byte[] bArr) {
        AppMethodBeat.i(41550);
        this.xHw = new HashMap<>();
        this.xHt = new bu();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(41550);
            return;
        }
        try {
            this.xHt.parseFrom(bArr);
        } catch (IOException e2) {
            Log.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", e2.getMessage());
        }
        this.xHu = false;
        amZ();
        AppMethodBeat.o(41550);
    }

    private void amZ() {
        AppMethodBeat.i(41551);
        this.xHv = dVU();
        if (this.xHu) {
            d.aZ(this.xHv);
            dVV();
            ((e) g.af(e.class)).dSI().init(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(41551);
    }

    private LinkedList<c> dVU() {
        c a2;
        AppMethodBeat.i(41552);
        LinkedList<c> linkedList = new LinkedList<>();
        if (this.xHt.xLS == null || this.xHt.xLS.xJs == null) {
            AppMethodBeat.o(41552);
            return linkedList;
        }
        Iterator<bc> it = this.xHt.xLS.xJs.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            bc next = it.next();
            if (!(next.xIz == null || (a2 = a(next.xIz)) == null)) {
                if (next.xIz.xIU == null) {
                    a2.xEl = com.tencent.mm.plugin.game.d.a.Fh(next.xJt);
                } else if (next.xIz.xIU.Name == null || next.xIz.xIU.xMD == null) {
                    a2.xEl = com.tencent.mm.plugin.game.d.a.Fh(next.xJt);
                } else {
                    a2.xEh = next.xIz.xIU.Name;
                    a2.xEi = next.xIz.xIU.xMD;
                    a2.xEl = com.tencent.mm.plugin.game.d.a.as(next.xJt, "label", a2.xEh);
                }
                if (next.xLe != null) {
                    Iterator<bd> it2 = next.xLe.iterator();
                    while (it2.hasNext()) {
                        bd next2 = it2.next();
                        if (next2 != null) {
                            if (next2.xLf == null || next2.xLf.size() == 0) {
                                a2.xEc.add("");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                for (int i3 = 0; i3 < next2.xLf.size(); i3++) {
                                    as Kn = ((l) g.af(l.class)).aSN().Kn(next2.xLf.get(i3));
                                    if (Kn == null || Kn.gMZ == 0) {
                                        sb.append(next2.xLf.get(i3));
                                    } else {
                                        sb.append(Kn.arJ());
                                    }
                                    if (i3 < next2.xLf.size() - 1) {
                                        sb.append("、");
                                    }
                                }
                                sb.append(" ");
                                a2.xEc.add(sb.toString());
                            }
                            a2.xEc.add(next2.xKd);
                        }
                    }
                }
                a2.scene = 10;
                a2.dYu = 1004;
                a2.position = i2;
                linkedList.add(a2);
                i2++;
            }
        }
        AppMethodBeat.o(41552);
        return linkedList;
    }

    private void dVV() {
        AppMethodBeat.i(41553);
        this.xHw = new HashMap<>();
        if (this.xHt.xLT == null || this.xHt.xLT.xMy == null) {
            AppMethodBeat.o(41553);
            return;
        }
        Iterator<cq> it = this.xHt.xLT.xMy.iterator();
        while (it.hasNext()) {
            cq next = it.next();
            c a2 = a(next.xIz);
            if (a2 != null) {
                this.xHw.put(a2.field_appId, Integer.valueOf(a2.versionCode));
                com.tencent.mm.pluginsdk.model.app.g bdG = com.tencent.mm.plugin.r.a.eAS().bdG(a2.field_appId);
                if (bdG != null) {
                    bdG.Bn(next.xMA);
                    if (!com.tencent.mm.plugin.r.a.eAS().a(bdG, new String[0])) {
                        Log.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", bdG.field_appId);
                    }
                }
            }
        }
        AppMethodBeat.o(41553);
    }

    public final bf dVW() {
        if (this.xHt != null) {
            return this.xHt.xLQ;
        }
        return null;
    }
}
