package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;

public final class d {
    public static String bfO(String str) {
        AppMethodBeat.i(116323);
        List<ca> aEU = ((l) g.af(l.class)).eiy().aEU(str);
        if (aEU != null) {
            Log.i("MicroMsg.WalletConvDelCheckLogic", "checkUnProcessWalletMsgCount, msgInfoList size: %s", Integer.valueOf(aEU.size()));
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (ca caVar : aEU) {
                if (aU(caVar)) {
                    if (caVar.getType() == 419430449) {
                        i2++;
                    } else if (caVar.getType() == 436207665) {
                        String str2 = caVar.field_content;
                        k.b HD = str2 != null ? k.b.HD(str2) : null;
                        if (HD != null) {
                            if ("1001".equals(HD.iyq)) {
                                i3++;
                            } else {
                                i4++;
                            }
                        }
                    }
                }
                i4 = i4;
            }
            if (i4 > 0 || i3 > 0 || i2 > 0) {
                if (ab.Eq(str)) {
                    String string = MMApplicationContext.getContext().getString(R.string.ic0, Integer.valueOf(i3));
                    AppMethodBeat.o(116323);
                    return string;
                } else if (i4 > 0 && i2 <= 0) {
                    String string2 = MMApplicationContext.getContext().getString(R.string.ic2, Integer.valueOf(i4));
                    AppMethodBeat.o(116323);
                    return string2;
                } else if (i2 > 0 && i4 <= 0) {
                    String string3 = MMApplicationContext.getContext().getString(R.string.ic3, Integer.valueOf(i2));
                    AppMethodBeat.o(116323);
                    return string3;
                } else if (i2 > 0 && i4 > 0) {
                    String string4 = MMApplicationContext.getContext().getString(R.string.ic1, Integer.valueOf(i4), Integer.valueOf(i2));
                    AppMethodBeat.o(116323);
                    return string4;
                }
            }
        }
        AppMethodBeat.o(116323);
        return null;
    }

    public static boolean aU(ca caVar) {
        int i2;
        boolean z;
        k.b bVar;
        k.b bVar2 = null;
        AppMethodBeat.i(116324);
        if (caVar.getType() == 419430449) {
            if (caVar.field_isSend == 0) {
                String str = caVar.field_content;
                if (str != null) {
                    bVar = k.b.aD(str, caVar.field_reserved);
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    aag aag = new aag();
                    aag.ehb.dQp = bVar.ixQ;
                    EventCenter.instance.publish(aag);
                    int i3 = aag.ehc.status;
                    if (i3 <= 0) {
                        i3 = bVar.ixN;
                    }
                    if (i3 >= 0 && (i3 == 1 || i3 == 7)) {
                        AppMethodBeat.o(116324);
                        return true;
                    }
                }
            }
        } else if (caVar.getType() == 436207665 && caVar.field_isSend == 0) {
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar2 = k.b.HD(str2);
            }
            if (bVar2 != null) {
                if (!"1001".equals(bVar2.iyq) && !ab.Eq(caVar.field_talker)) {
                    aaf aaf = new aaf();
                    if (!Util.isNullOrNil(bVar2.iyr)) {
                        aaf.egV.egX = bVar2.iyr;
                        EventCenter.instance.publish(aaf);
                        if (aaf.egW.eha == 0) {
                            AppMethodBeat.o(116324);
                            return true;
                        }
                    }
                } else if (ab.Eq(caVar.field_talker)) {
                    String aTY = z.aTY();
                    if (!Util.isNullOrNil(bVar2.iyG)) {
                        Iterator<String> it = bVar2.iyG.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String[] split = it.next().split(",");
                            if (split.length == 3 && split[0].equals(aTY)) {
                                i2 = Util.getInt(split[2], -1);
                                z = true;
                                break;
                            }
                        }
                        if (z && i2 == 1) {
                            AppMethodBeat.o(116324);
                            return true;
                        }
                    }
                    i2 = 0;
                    z = false;
                    AppMethodBeat.o(116324);
                    return true;
                }
            }
        }
        AppMethodBeat.o(116324);
        return false;
    }
}
