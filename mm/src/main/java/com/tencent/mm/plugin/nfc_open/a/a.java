package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class a extends IListener<k> {
    public a() {
        AppMethodBeat.i(161395);
        this.__eventId = k.class.getName().hashCode();
        AppMethodBeat.o(161395);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(k kVar) {
        AppMethodBeat.i(26685);
        boolean a2 = a(kVar);
        AppMethodBeat.o(26685);
        return a2;
    }

    private static boolean a(k kVar) {
        AppMethodBeat.i(26684);
        if (!(kVar instanceof k)) {
            AppMethodBeat.o(26684);
            return false;
        } else if (kVar.dCc == null) {
            AppMethodBeat.o(26684);
            return false;
        } else {
            int i2 = kVar.dCc.actionCode;
            Context context = kVar.dCc.context;
            if (context == null) {
                context = MMApplicationContext.getContext();
            }
            Bundle bundle = new Bundle();
            switch (i2) {
                case 4001:
                    bundle.putInt("status", com.tencent.mm.plugin.nfc.b.a.a.exw().gI(context));
                    break;
                case 4002:
                    int gJ = com.tencent.mm.plugin.nfc.b.a.a.exw().gJ(context);
                    Log.i("MicroMsg.ApduEngineFuncListener", "alvinluo NFC connect status: %d", Integer.valueOf(gJ));
                    bundle.putInt("status", gJ);
                    break;
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE:
                    String str = kVar.dCc.dCe;
                    if (Util.isNullOrNil(str)) {
                        Log.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                        break;
                    } else {
                        try {
                            bundle.putString("result", com.tencent.mm.plugin.nfc.b.a.a.exw().a(new com.tencent.mm.plugin.nfc.a.a(str)).toString());
                            break;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
                            Log.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                case WearableStatusCodes.INVALID_TARGET_NODE:
                    try {
                        String str2 = kVar.dCc.dCe;
                        boolean z = kVar.dCc.dCf;
                        boolean z2 = kVar.dCc.dCg;
                        if (Util.isNullOrNil(str2)) {
                            Log.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        } else {
                            String[] split = str2.split("\\|");
                            ArrayList<com.tencent.mm.plugin.nfc.b.a> arrayList = new ArrayList();
                            for (String str3 : split) {
                                if (Util.isNullOrNil(str3)) {
                                    Log.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                                } else {
                                    String[] split2 = str3.split(":");
                                    if (split2 == null || split2.length < 2) {
                                        Log.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                    } else {
                                        int i3 = Util.getInt(split2[0], 0);
                                        arrayList.add(new com.tencent.mm.plugin.nfc.b.a(i3, String.valueOf(i3), new com.tencent.mm.plugin.nfc.a.a(split2[1])));
                                    }
                                }
                            }
                            com.tencent.mm.plugin.nfc.b.a.a.exw().b(arrayList, z, z2);
                            StringBuilder sb = new StringBuilder();
                            for (com.tencent.mm.plugin.nfc.b.a aVar : arrayList) {
                                if (aVar.AEd == null) {
                                    bundle.putString("result", sb.toString());
                                    break;
                                } else {
                                    sb.append(aVar.id);
                                    sb.append(":");
                                    sb.append(aVar.AEd.toString());
                                    sb.append("|");
                                }
                            }
                            bundle.putString("result", sb.toString());
                        }
                    } catch (Exception e3) {
                        Log.e("MicroMsg.ApduEngineFuncListener", "alex: execute nfc command exception");
                        Log.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e3, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case WearableStatusCodes.ASSET_UNAVAILABLE:
                    bundle.putString("id", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.b.a.a.exw().AEf));
                    break;
                case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED:
                    bundle.putString("info", com.tencent.mm.plugin.nfc.b.a.a.exw().getInfo());
                    break;
            }
            kVar.dCd.dCh = bundle;
            AppMethodBeat.o(26684);
            return false;
        }
    }
}
