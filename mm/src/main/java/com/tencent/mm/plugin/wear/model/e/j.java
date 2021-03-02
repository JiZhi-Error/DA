package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.eza;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.ezg;
import com.tencent.mm.protocal.protobuf.ezi;
import com.tencent.mm.protocal.protobuf.ezj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String Iyv = "";

    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30087);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11019);
        arrayList.add(11020);
        arrayList.add(11021);
        arrayList.add(11031);
        AppMethodBeat.o(30087);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        List<ca> f2;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(30088);
        switch (i2) {
            case 11019:
                eza eza = new eza();
                try {
                    eza.parseFrom(bArr);
                } catch (IOException e2) {
                }
                ezb ezb = new ezb();
                ezb.NvC = eza.NvC;
                if (ezb.NvC) {
                    bg.aVF();
                    f2 = c.aSQ().g(eza.Username, eza.MKf, 11);
                } else {
                    bg.aVF();
                    f2 = c.aSQ().f(eza.Username, eza.MKf, 11);
                }
                int i3 = 0;
                while (i3 < 10 && i3 < f2.size()) {
                    ezb.Mcg.add(h.aP(f2.get(i3)));
                    i3++;
                }
                if (f2.size() > 10) {
                    z = true;
                } else {
                    z = false;
                }
                ezb.LYI = z;
                try {
                    byte[] byteArray = ezb.toByteArray();
                    AppMethodBeat.o(30088);
                    return byteArray;
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e3, "", new Object[0]);
                    break;
                }
                break;
            case 11020:
                a.jZ(9, 0);
                a.aff(8);
                ezf ezf = new ezf();
                try {
                    ezf.parseFrom(bArr);
                    if (!Util.isNullOrNil(ezf.Username)) {
                        this.Iyv = ezf.Username;
                        ezg ezg = new ezg();
                        bg.aVF();
                        List<ca> f3 = c.aSQ().f(ezf.Username, ezf.MKf, 11);
                        int i4 = 0;
                        while (i4 < 10 && i4 < f3.size()) {
                            ezg.Mcg.add(h.aP(f3.get(i4)));
                            i4++;
                        }
                        if (f3.size() <= 10) {
                            z2 = false;
                        }
                        ezg.LYI = z2;
                        try {
                            byte[] byteArray2 = ezg.toByteArray();
                            AppMethodBeat.o(30088);
                            return byteArray2;
                        } catch (IOException e4) {
                            Log.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e4, "", new Object[0]);
                            break;
                        }
                    } else {
                        AppMethodBeat.o(30088);
                        return null;
                    }
                } catch (IOException e5) {
                    AppMethodBeat.o(30088);
                    return null;
                }
                break;
            case 11021:
                this.Iyv = "";
                break;
            case 11031:
                a.jZ(12, 0);
                a.aff(14);
                ezi ezi = new ezi();
                try {
                    ezi.parseFrom(bArr);
                } catch (IOException e6) {
                }
                bg.aVF();
                ca Hb = c.aSQ().Hb(ezi.KMm);
                ezj ezj = new ezj();
                String fullPath = s.getFullPath(Hb.field_imgPath);
                ezj.NvM = q.g(fullPath, 0, true);
                ezj.KMm = ezi.KMm;
                ezj.KKz = new b(com.tencent.mm.vfs.s.aW(fullPath, 0, -1));
                s.ak(Hb);
                try {
                    byte[] byteArray3 = ezj.toByteArray();
                    AppMethodBeat.o(30088);
                    return byteArray3;
                } catch (IOException e7) {
                    AppMethodBeat.o(30088);
                    return null;
                }
        }
        AppMethodBeat.o(30088);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afh(int i2) {
        switch (i2) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afg(int i2) {
        switch (i2) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
