package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.eyh;
import com.tencent.mm.protocal.protobuf.eyn;
import com.tencent.mm.protocal.protobuf.eyo;
import com.tencent.mm.protocal.protobuf.ezk;
import com.tencent.mm.protocal.protobuf.ezl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30071);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11008);
        arrayList.add(11009);
        AppMethodBeat.o(30071);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        int i3 = 5;
        AppMethodBeat.i(30072);
        if (i2 == 11008) {
            a.aff(6);
            ezk ezk = new ezk();
            try {
                ezk.parseFrom(bArr);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(u.gVb());
                linkedList.addAll(u.gVc());
                bg.aVF();
                Cursor f2 = com.tencent.mm.model.c.aST().f(linkedList, ezk.KZk, 50);
                if (ezk.KZk != 0) {
                    i3 = 20;
                }
                ezl ezl = new ezl();
                ezl.KZk = ezk.KZk;
                while (true) {
                    if (f2 == null || !f2.moveToNext()) {
                        break;
                    }
                    String string = f2.getString(f2.getColumnIndex(ch.COL_USERNAME));
                    bg.aVF();
                    as Kn = com.tencent.mm.model.c.aSN().Kn(string);
                    ezl.KZk++;
                    if (!Kn.gBM() && !Kn.ary()) {
                        eyh eyh = new eyh();
                        eyh.oUJ = aa.b(Kn);
                        eyh.UserName = Kn.field_username;
                        ezl.LUC.add(eyh);
                        if (ezl.LUC.size() >= i3) {
                            ezl.LYI = f2.moveToNext();
                            break;
                        }
                    }
                }
                Log.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", Integer.valueOf(ezk.KZk), Integer.valueOf(ezl.KZk), Integer.valueOf(ezl.LUC.size()));
                if (f2 != null) {
                    f2.close();
                }
                try {
                    byte[] byteArray = ezl.toByteArray();
                    AppMethodBeat.o(30072);
                    return byteArray;
                } catch (IOException e2) {
                    AppMethodBeat.o(30072);
                    return null;
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e3, "", new Object[0]);
                AppMethodBeat.o(30072);
                return null;
            }
        } else if (i2 == 11009) {
            a.aff(7);
            eyn eyn = new eyn();
            try {
                eyn.parseFrom(bArr);
                eyo eyo = new eyo();
                bg.aVF();
                Cursor iS = com.tencent.mm.model.c.aSN().iS(null);
                int i4 = eyn.KZk;
                while (true) {
                    if (iS == null || !iS.moveToNext()) {
                        break;
                    } else if (i4 > 0) {
                        i4--;
                    } else {
                        String string2 = iS.getString(0);
                        bg.aVF();
                        as Kn2 = com.tencent.mm.model.c.aSN().Kn(string2);
                        eyh eyh2 = new eyh();
                        eyh2.oUJ = aa.b(Kn2);
                        eyh2.UserName = Kn2.field_username;
                        eyo.LUC.add(eyh2);
                        if (eyo.LUC.size() >= 5) {
                            eyo.LYI = iS.moveToNext();
                            break;
                        }
                    }
                }
                if (iS != null) {
                    iS.close();
                }
                eyo.KZk = eyn.KZk + eyo.LUC.size();
                try {
                    byte[] byteArray2 = eyo.toByteArray();
                    AppMethodBeat.o(30072);
                    return byteArray2;
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e4, "", new Object[0]);
                    AppMethodBeat.o(30072);
                    return null;
                }
            } catch (IOException e5) {
                Log.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e5, "", new Object[0]);
                AppMethodBeat.o(30072);
                return null;
            }
        } else {
            AppMethodBeat.o(30072);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afh(int i2) {
        AppMethodBeat.i(30073);
        if (i2 == 11008) {
            AppMethodBeat.o(30073);
            return true;
        } else if (i2 == 11009) {
            AppMethodBeat.o(30073);
            return true;
        } else {
            boolean afh = super.afh(i2);
            AppMethodBeat.o(30073);
            return afh;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final boolean afg(int i2) {
        AppMethodBeat.i(30074);
        if (i2 == 11008) {
            AppMethodBeat.o(30074);
            return true;
        } else if (i2 == 11009) {
            AppMethodBeat.o(30074);
            return true;
        } else {
            boolean afg = super.afg(i2);
            AppMethodBeat.o(30074);
            return afg;
        }
    }
}
