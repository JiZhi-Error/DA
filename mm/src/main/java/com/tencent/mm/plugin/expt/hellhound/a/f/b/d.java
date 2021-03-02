package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.e;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static d sIC;
    public final IListener<ug> sID = new IListener<ug>() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.f.b.d.AnonymousClass1 */

        {
            AppMethodBeat.i(161597);
            this.__eventId = ug.class.getName().hashCode();
            AppMethodBeat.o(161597);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        @SuppressLint({"NewApi"})
        public final /* synthetic */ boolean callback(ug ugVar) {
            int i2;
            boolean z;
            dvh dvh;
            AppMethodBeat.i(122107);
            ug ugVar2 = ugVar;
            if (ugVar2 != null) {
                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent callback json: %s", ugVar2.eaD.dNA);
                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent callback json: %b, %b, %s, %d", ugVar2.eaD.eaz, ugVar2.eaD.eaF, Long.valueOf(ugVar2.eaD.eaB), Integer.valueOf(ugVar2.eaD.version));
                if (ugVar2.eaD.eaB == Util.getLong("-100", 0)) {
                    Log.w("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent: reset");
                    b.o("mkv_k_hellsionpgcldc", new byte[0]);
                } else {
                    dvh cQt = e.cQt();
                    if (cQt != null) {
                        i2 = cQt.MWn.size();
                    } else {
                        i2 = 0;
                    }
                    if (ugVar2.eaD.eaz.booleanValue()) {
                        if (i2 > 0) {
                            int i3 = i2 - 1;
                            while (true) {
                                if (i3 >= 0) {
                                    dvk dvk = cQt.MWn.get(i3);
                                    if (dvk != null && dvk.LPN == ugVar2.eaD.eaB) {
                                        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent-del: %s", Long.valueOf(dvk.LPN));
                                        cQt.MWn.remove(i3);
                                        dvh = cQt;
                                        break;
                                    }
                                    i3--;
                                } else {
                                    break;
                                }
                            }
                        }
                    } else if (ugVar2.eaD.dNA == null || ugVar2.eaD.dNA.isEmpty()) {
                        AppMethodBeat.o(122107);
                        return false;
                    } else {
                        dvk a2 = d.a(d.this, ugVar2.eaD.dNA, ugVar2.eaD.eaB, ugVar2.eaD.eaE, ugVar2.eaD.eaF.booleanValue(), ugVar2.eaD.version);
                        if (a2 != null) {
                            if (i2 <= 0) {
                                dvh = new dvh();
                                dvh.MWn.add(a2);
                                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent, add-1: %s", Long.valueOf(a2.LPN));
                            } else {
                                int i4 = 0;
                                while (true) {
                                    if (i4 < i2) {
                                        dvk dvk2 = cQt.MWn.get(i4);
                                        if (dvk2 != null && dvk2.LPN == ugVar2.eaD.eaB) {
                                            Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent, update: %s", Long.valueOf(dvk2.LPN));
                                            cQt.MWn.set(i4, a2);
                                            z = true;
                                            break;
                                        }
                                        i4++;
                                    } else {
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                    Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "mEvent, add-2: %s", Long.valueOf(a2.LPN));
                                    cQt.MWn.add(a2);
                                }
                                dvh = cQt;
                            }
                        }
                    }
                    if (dvh != null) {
                        e.a(dvh);
                    }
                }
            }
            AppMethodBeat.o(122107);
            return false;
        }
    };

    static /* synthetic */ dvk a(d dVar, String str, long j2, List list, boolean z, int i2) {
        AppMethodBeat.i(220562);
        dvk a2 = a(str, j2, list, z, i2);
        AppMethodBeat.o(220562);
        return a2;
    }

    public static d cQe() {
        AppMethodBeat.i(122108);
        if (sIC == null) {
            synchronized (d.class) {
                try {
                    if (sIC == null) {
                        sIC = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(122108);
                    throw th;
                }
            }
        }
        d dVar = sIC;
        AppMethodBeat.o(122108);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(122109);
        AppMethodBeat.o(122109);
    }

    private static dvk a(String str, long j2, List list, boolean z, int i2) {
        int length;
        int length2;
        AppMethodBeat.i(220559);
        if (str == null) {
            AppMethodBeat.o(220559);
            return null;
        }
        if (i2 == 2) {
            String aqU = com.tencent.mm.plugin.expt.hellhound.a.f.e.e.aqU(str);
            if (TextUtils.isEmpty(aqU)) {
                Log.e("HABBYGE-MALI.HellSessionPageCloudConfig", "parsePagePath decodeJson is NULL!!");
                l.Bt(122);
            } else {
                str = aqU;
            }
            if (list == null || list.isEmpty()) {
                l.Bt(123);
            } else {
                for (Object obj : list) {
                    if (obj instanceof cft) {
                        cft cft = (cft) obj;
                        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "parsePagePath, kv: %s -> %s", cft.key, cft.iFF);
                    }
                }
            }
        }
        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "parsePagePath: decodeJson=%s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                dvk dvk = new dvk();
                dvk.sGF = jSONObject.optString("sid");
                dvk.LPN = j2;
                dvk.LPM = jSONObject.optString("logId");
                dvk.vtY = z;
                dvk.type = jSONObject.optInt("type", 1);
                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "parsePagePath.parse: %s, %s, %s, %b, %d", dvk.sGF, Long.valueOf(dvk.LPN), dvk.LPM, Boolean.valueOf(dvk.vtY), Integer.valueOf(dvk.type));
                JSONArray optJSONArray = jSONObject.optJSONArray("pagePathUnits");
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            dvg dvg = new dvg();
                            dvg.dMl = optJSONObject.optString("pageName");
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("businessParams");
                            if (optJSONArray2 != null && (length2 = optJSONArray2.length()) > 0) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i4 = 0; i4 < length2; i4++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                                    if (optJSONObject2 != null) {
                                        cyk cyk = new cyk();
                                        cyk.className = optJSONObject2.optString("className");
                                        cyk.dataPath = optJSONObject2.optString("dataPath");
                                        cyk.action = optJSONObject2.optString(NativeProtocol.WEB_DIALOG_ACTION);
                                        a(cyk, list, false);
                                        arrayList2.add(cyk);
                                    }
                                }
                                dvg.MWl.addAll(arrayList2);
                            }
                            a(optJSONObject, list, dvg);
                            arrayList.add(dvg);
                        }
                    }
                    dvk.MWr.addAll(arrayList);
                }
                AppMethodBeat.o(220559);
                return dvk;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfig", e2, "parsePagePath crash-2: %s", e2.getMessage());
                AppMethodBeat.o(220559);
                return null;
            }
        } catch (JSONException e3) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfig", e3, "parsePagePath crash-1: %s", e3.getMessage());
            AppMethodBeat.o(220559);
            return null;
        }
    }

    private static void a(JSONObject jSONObject, List list, dvg dvg) {
        int length;
        int length2;
        AppMethodBeat.i(220560);
        JSONArray optJSONArray = jSONObject.optJSONArray("viewOp");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, viewOpArrayLength=%d", Integer.valueOf(length));
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    ere ere = new ere();
                    ere.type = optJSONObject.optInt("type");
                    ere.NoL = optJSONObject.optString("viewId");
                    ere.aPi = optJSONObject.optString("class");
                    ere.action = optJSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION);
                    Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, class=%s, resName=%s, type=%d", ere.aPi, ere.NoL, Integer.valueOf(ere.type));
                    if (list != null && !list.isEmpty()) {
                        for (Object obj : list) {
                            if (obj instanceof cft) {
                                cft cft = (cft) obj;
                                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, resName=%s, key=%s, val=%s", ere.NoL, cft.key, cft.iFF);
                                if (ere.NoL.equals(cft.key)) {
                                    boolean isEmpty = TextUtils.isEmpty(cft.iFF);
                                    ere.viewId = isEmpty ? ere.NoL : cft.iFF;
                                    if (isEmpty) {
                                        l.Bt(126);
                                    } else {
                                        l.Bt(136);
                                    }
                                } else if (ere.aPi.equals(cft.key)) {
                                    ere.NoR = cft.iFF;
                                    if (TextUtils.isEmpty(cft.iFF)) {
                                        l.Bt(127);
                                    } else {
                                        l.Bt(137);
                                    }
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("businessParams");
                    if (optJSONArray2 != null && (length2 = optJSONArray2.length()) > 0) {
                        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, viewOpParamJArraySize=%d", Integer.valueOf(length2));
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < length2; i3++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                            if (optJSONObject2 != null) {
                                cyk cyk = new cyk();
                                cyk.className = optJSONObject2.optString("className");
                                cyk.dataPath = optJSONObject2.optString("dataPath");
                                a(cyk, list, true);
                                Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, pageParam.className=%s, pageParam.dataPath=%s, ", cyk.className, cyk.dataPath);
                                arrayList.add(cyk);
                            }
                        }
                        ere.MWl.addAll(arrayList);
                        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "viewOp, viewOp.businessParams=%d", Integer.valueOf(ere.MWl.size()));
                    }
                    dvg.MWm.addLast(ere);
                }
            }
        }
        AppMethodBeat.o(220560);
    }

    private static void a(cyk cyk, List list, boolean z) {
        AppMethodBeat.i(220561);
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof cft) {
                    cft cft = (cft) obj;
                    if (cyk.className.equals(cft.key)) {
                        cyk.MDj = cft.iFF;
                        if (TextUtils.isEmpty(cyk.MDj)) {
                            l.Bt(124);
                        } else {
                            l.Bt(138);
                        }
                        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "paramPaoguard, classNameProguard: %s, %s, %b", cft.key, cft.iFF, Boolean.valueOf(z));
                    } else if (cyk.dataPath.equals(cft.key)) {
                        cyk.MDk = new cft();
                        cyk.MDk.type = z ? 0 : 1;
                        cyk.MDk.key = cyk.dataPath;
                        cyk.MDk.iFF = cft.iFF;
                        if (TextUtils.isEmpty(cyk.dataPath) || TextUtils.isEmpty(cft.iFF)) {
                            l.Bt(125);
                        } else {
                            l.Bt(139);
                        }
                        Log.i("HABBYGE-MALI.HellSessionPageCloudConfig", "paramPaoguard, dataPathProguard: type=%s, key=%s, val=%s, isView=%b", Integer.valueOf(cyk.MDk.type), cyk.dataPath, cft.iFF, Boolean.valueOf(z));
                    }
                }
            }
        }
        AppMethodBeat.o(220561);
    }

    public static dvh cQf() {
        AppMethodBeat.i(122110);
        dvh cQt = e.cQt();
        AppMethodBeat.o(122110);
        return cQt;
    }

    public static dvk Du(long j2) {
        AppMethodBeat.i(220558);
        dvh cQt = e.cQt();
        if (cQt == null || cQt.MWn.isEmpty()) {
            AppMethodBeat.o(220558);
            return null;
        }
        Iterator<dvk> it = cQt.MWn.iterator();
        while (it.hasNext()) {
            dvk next = it.next();
            if (next != null && next.LPN == j2) {
                AppMethodBeat.o(220558);
                return next;
            }
        }
        AppMethodBeat.o(220558);
        return null;
    }
}
