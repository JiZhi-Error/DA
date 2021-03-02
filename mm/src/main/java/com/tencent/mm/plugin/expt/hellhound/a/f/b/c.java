package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.b;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.dva;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static c sIz;
    public final IListener sIA = new IListener<ud>() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.f.b.c.AnonymousClass1 */

        {
            AppMethodBeat.i(161596);
            this.__eventId = ud.class.getName().hashCode();
            AppMethodBeat.o(161596);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ud udVar) {
            AppMethodBeat.i(122099);
            ud udVar2 = udVar;
            if (udVar2 != null) {
                Log.i("HABBYGE-MALI.HellSessionCloudConfig", "mSessionConfigChangeEvent callback json: %s", udVar2.eax.dNA);
                Log.i("HABBYGE-MALI.HellSessionCloudConfig", "mSessionConfigChangeEvent callback isDel: %b", udVar2.eax.eaz);
                Log.i("HABBYGE-MALI.HellSessionCloudConfig", "mSessionConfigChangeEvent callback: %b", udVar2.eax.eay);
                if (udVar2.eax.eaz.booleanValue()) {
                    duz cQl = b.cQl();
                    if (cQl == null) {
                        cQl = new duz();
                    }
                    cQl.gyp = true;
                    cQl.thE = false;
                    b.a(cQl);
                } else {
                    duz duz = new duz();
                    duz.gyp = false;
                    duz.thE = udVar2.eax.eay.booleanValue();
                    if (udVar2.eax.dNA == null || udVar2.eax.dNA.isEmpty()) {
                        AppMethodBeat.o(122099);
                        return false;
                    }
                    e aqD = c.aqD(udVar2.eax.dNA);
                    if (aqD == null || aqD.size() <= 0) {
                        AppMethodBeat.o(122099);
                        return false;
                    }
                    duz.MWd.addAll((Collection) aqD.get(0));
                    duz.MWe.addAll((Collection) aqD.get(1));
                    duz.MWf = (dva) aqD.get(2);
                    duz.MWg.addAll((Collection) aqD.get(3));
                    b.a(duz);
                    Log.i("HABBYGE-MALI.HellSessionCloudConfig", "mSessionConfigChangeEvent callback: END");
                }
            }
            AppMethodBeat.o(122099);
            return false;
        }
    };

    static /* synthetic */ e aqD(String str) {
        AppMethodBeat.i(122106);
        e<List<dvb>, List<duy>, dva, List<dvd>> aqC = aqC(str);
        AppMethodBeat.o(122106);
        return aqC;
    }

    private c() {
        AppMethodBeat.i(122100);
        AppMethodBeat.o(122100);
    }

    public static c cQa() {
        AppMethodBeat.i(122101);
        if (sIz == null) {
            synchronized (c.class) {
                try {
                    if (sIz == null) {
                        sIz = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(122101);
                    throw th;
                }
            }
        }
        c cVar = sIz;
        AppMethodBeat.o(122101);
        return cVar;
    }

    private static e<List<dvb>, List<duy>, dva, List<dvd>> aqC(String str) {
        AppMethodBeat.i(122105);
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("sessions");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            dva dva = null;
            LinkedList linkedList3 = new LinkedList();
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("sid");
                        if (b.aqr(optString)) {
                            duy duy = new duy();
                            duy.sGF = optString;
                            duy.MWb = optJSONObject.optString("prePage");
                            duy.dMl = optJSONObject.optString("pageName");
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("sessionParams");
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                duy.MWc = optJSONArray2.optJSONObject(0).optString("expect");
                            }
                            linkedList2.add(duy);
                        } else if (b.aqv(optString)) {
                            dva = new dva();
                            dva.sGF = optString;
                            dva.MWb = optJSONObject.optString("prePage");
                            dva.dMl = optJSONObject.optString("pageName");
                            JSONArray optJSONArray3 = optJSONObject.optJSONArray("sessionParams");
                            if (optJSONArray3 != null && optJSONArray3.length() > 1) {
                                JSONObject optJSONObject2 = optJSONArray3.optJSONObject(0);
                                JSONObject optJSONObject3 = optJSONArray3.optJSONObject(1);
                                dva.MWh = optJSONObject2.optString("expect");
                                dva.MWi = optJSONObject3.optString("expect");
                            }
                        } else {
                            JSONArray optJSONArray4 = optJSONObject.optJSONArray("sessionParams");
                            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                                dvb dvb = new dvb();
                                dvb.sGF = optString;
                                dvb.MWb = optJSONObject.optString("prePage");
                                dvb.dMl = optJSONObject.optString("pageName");
                                linkedList.add(dvb);
                            } else {
                                dvd dvd = new dvd();
                                dvd.sGF = optString;
                                dvd.MWb = optJSONObject.optString("prePage");
                                dvd.dMl = optJSONObject.optString("pageName");
                                int length2 = optJSONArray4.length();
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i3);
                                    if (optJSONObject4 != null) {
                                        dvc dvc = new dvc();
                                        dvc.className = optJSONObject4.optString("className");
                                        dvc.dataPath = optJSONObject4.optString("dataPath");
                                        dvc.MWc = optJSONObject4.optString("expect");
                                        arrayList.add(dvc);
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    dvd.MWj.addAll(arrayList);
                                }
                                linkedList3.add(dvd);
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionCloudConfig", e2, "SessionConfigJson parse2 crash", new Object[0]);
                    AppMethodBeat.o(122105);
                    return null;
                }
            }
            e<List<dvb>, List<duy>, dva, List<dvd>> b2 = a.b(linkedList, linkedList2, dva, linkedList3);
            AppMethodBeat.o(122105);
            return b2;
        } catch (JSONException e3) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionCloudConfig", e3, "SessionConfigJson parse1 crash", new Object[0]);
            AppMethodBeat.o(122105);
            return null;
        }
    }

    public static duz cQb() {
        AppMethodBeat.i(122102);
        duz cQl = b.cQl();
        AppMethodBeat.o(122102);
        return cQl;
    }

    public static boolean cQc() {
        AppMethodBeat.i(122103);
        duz cQl = b.cQl();
        if (cQl == null) {
            AppMethodBeat.o(122103);
            return true;
        }
        boolean z = cQl.gyp;
        AppMethodBeat.o(122103);
        return z;
    }

    public static boolean cQd() {
        AppMethodBeat.i(122104);
        duz cQl = b.cQl();
        if (cQl == null) {
            AppMethodBeat.o(122104);
            return false;
        }
        boolean z = cQl.thE;
        AppMethodBeat.o(122104);
        return z;
    }
}
