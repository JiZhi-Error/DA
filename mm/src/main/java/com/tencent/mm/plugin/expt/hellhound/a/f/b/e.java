package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.h;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.dvp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private static e sIF;
    public final IListener sIG = new IListener<uh>() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.f.b.e.AnonymousClass1 */

        {
            AppMethodBeat.i(161598);
            this.__eventId = uh.class.getName().hashCode();
            AppMethodBeat.o(161598);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uh uhVar) {
            List aqE;
            AppMethodBeat.i(122113);
            uh uhVar2 = uhVar;
            if (uhVar2 != null) {
                Log.i("HABBYGE-MALI.HellSessionUBACloudConfig", "mSessionUBAListener: %b, %s", uhVar2.eaG.eaz, uhVar2.eaG.dNA);
                if (uhVar2.eaG.eaz.booleanValue()) {
                    dvo cQz = h.cQz();
                    if (cQz == null) {
                        cQz = new dvo();
                    }
                    cQz.gyp = true;
                    h.a(cQz);
                } else {
                    dvo dvo = new dvo();
                    dvo.gyp = false;
                    if (uhVar2.eaG.dNA != null && !uhVar2.eaG.dNA.isEmpty() && (aqE = e.aqE(uhVar2.eaG.dNA)) != null && !aqE.isEmpty()) {
                        dvo.iAd.addAll(aqE);
                    }
                    h.a(dvo);
                    Log.i("HABBYGE-MALI.HellSessionUBACloudConfig", "mSessionUBAListener callback: END");
                }
            }
            AppMethodBeat.o(122113);
            return false;
        }
    };

    static /* synthetic */ List aqE(String str) {
        AppMethodBeat.i(122119);
        List<dvp> parse = parse(str);
        AppMethodBeat.o(122119);
        return parse;
    }

    private e() {
        AppMethodBeat.i(122114);
        AppMethodBeat.o(122114);
    }

    public static e cQg() {
        AppMethodBeat.i(122115);
        if (sIF == null) {
            synchronized (e.class) {
                try {
                    if (sIF == null) {
                        sIF = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(122115);
                    throw th;
                }
            }
        }
        e eVar = sIF;
        AppMethodBeat.o(122115);
        return eVar;
    }

    private static List<dvp> parse(String str) {
        int length;
        int length2;
        ArrayList arrayList = null;
        AppMethodBeat.i(122118);
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("sessionUBAConfigs");
            if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
                AppMethodBeat.o(122118);
                return arrayList;
            }
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    dvp dvp = new dvp();
                    dvp.dMl = optJSONObject.optString("pageName");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("businessParams");
                    if (optJSONArray2 != null && (length2 = optJSONArray2.length()) > 0) {
                        for (int i3 = 0; i3 < length2; i3++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                            if (optJSONObject2 != null) {
                                cyk cyk = new cyk();
                                cyk.className = optJSONObject2.optString("className");
                                cyk.dataPath = optJSONObject2.optString("dataPath");
                                cyk.action = optJSONObject2.optString(NativeProtocol.WEB_DIALOG_ACTION);
                                dvp.KVY.add(cyk);
                            }
                        }
                    }
                    arrayList.add(dvp);
                }
            }
            AppMethodBeat.o(122118);
            return arrayList;
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfig", e2, "HellSessionUBACloudConfig parse crash", new Object[0]);
            AppMethodBeat.o(122118);
        }
    }

    public static dvo cQh() {
        AppMethodBeat.i(122116);
        dvo cQz = h.cQz();
        AppMethodBeat.o(122116);
        return cQz;
    }

    public static boolean cQc() {
        AppMethodBeat.i(122117);
        dvo cQz = h.cQz();
        if (cQz == null) {
            AppMethodBeat.o(122117);
            return true;
        }
        boolean z = cQz.gyp;
        AppMethodBeat.o(122117);
        return z;
    }
}
