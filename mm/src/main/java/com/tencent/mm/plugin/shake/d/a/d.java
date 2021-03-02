package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bz;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.protocal.protobuf.cck;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends q implements m {
    private long DiL;
    int action;
    private i callback;
    final com.tencent.mm.ak.d iUB;

    public d(Collection<h.a> collection, float f2, float f3, int i2) {
        AppMethodBeat.i(28280);
        this.action = 1;
        this.DiL = 0;
        this.action = 1;
        d.a aVar = new d.a();
        aVar.iLN = new cck();
        aVar.iLO = new ccl();
        aVar.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        aVar.funcId = JsApiInstallDownloadTaskForNative.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        bz aWj = bz.aWj();
        String nullAsNil = Util.nullAsNil(aWj.provinceCode);
        String nullAsNil2 = Util.nullAsNil(aWj.cityCode);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        cck cck = (cck) this.iUB.iLK.iLR;
        cck.Mis = Util.nullAsNil((String) null);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"Beacons\":[");
        if (collection != null) {
            int i3 = 0;
            int size = collection.size();
            for (h.a aVar2 : collection) {
                sb.append("{\"UUID\":\"" + aVar2.uuid + "\",\"Location\":{\"Major\":" + aVar2.major + ",\"Minor\":" + aVar2.minor + "},\"Distance\":" + aVar2.jiP + ",\"Extra\":\"\",\"MacAddress\":\"" + aVar2.DiU + "\",\"Rssi\":\"" + aVar2.DiV + "\",\"MeasurePower\":\"" + aVar2.DiW + "\"}");
                if (i3 < size - 1) {
                    sb.append(",");
                }
                i3++;
            }
        }
        int i4 = 1;
        boolean hasSystemFeature = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && Build.VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i4 = 0;
        }
        sb.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + f2 + ",\"Longitude\":" + f3 + ",\"Province\":\"" + nullAsNil + "\",\"City\":\"" + nullAsNil2 + "\"},\"MachineID\":\"" + com.tencent.mm.compatible.deviceinfo.q.aoG() + "\",\"ZBBeaconState\":\"" + i4 + "\"}");
        cck.iAc = sb.toString();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = cck.iAc;
        Log.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang]beaconCollection.size:%d,json:%s", objArr);
        o.a(2008, f3, f2, i2);
        AppMethodBeat.o(28280);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return JsApiInstallDownloadTaskForNative.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28281);
        this.DiL = System.currentTimeMillis();
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(28281);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28282);
        Log.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        this.DiL = System.currentTimeMillis() - this.DiL;
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11497, String.valueOf((int) (((double) (this.DiL / 1000)) + 0.5d)), 1, Integer.valueOf((int) this.DiL));
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
            ccl ccl = (ccl) this.iUB.iLL.iLR;
            try {
                JSONObject jSONObject = new JSONObject(((cck) this.iUB.iLK.iLR).iAc);
                JSONArray jSONArray = jSONObject.getJSONArray("Beacons");
                int length = jSONArray.length();
                JSONObject jSONObject2 = jSONObject.getJSONObject("LBS");
                int i5 = jSONObject.getInt("Action");
                String string = jSONObject2.getString("Latitude");
                String string2 = jSONObject2.getString("Longitude");
                if (length > 0) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                    String string3 = jSONObject3.getString("UUID");
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("Location");
                    int i6 = jSONObject4.getInt("Major");
                    int i7 = jSONObject4.getInt("Minor");
                    if (ccl.Mit == null || ccl.Mit.LjQ != 0) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12659, 1, Integer.valueOf(length), string3, Integer.valueOf(i6), Integer.valueOf(i7), string, string2, 2, Integer.valueOf(ccl.Mit.LjQ));
                        AppMethodBeat.o(28282);
                        return;
                    }
                    String str2 = ccl.Mit.xJz;
                    if (i5 == 1 && str2 != null && !str2.equals("") && new JSONObject(str2).getJSONArray("msgs").length() == 0) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12659, 1, Integer.valueOf(length), string3, Integer.valueOf(i6), Integer.valueOf(i7), string, string2, 2, Integer.valueOf(ccl.Mit.LjQ));
                    }
                    AppMethodBeat.o(28282);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12659, 1, Integer.valueOf(length), "", 0, 0, string, string2, 2, Integer.valueOf(ccl.Mit.LjQ));
                AppMethodBeat.o(28282);
            } catch (JSONException e2) {
                Log.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                AppMethodBeat.o(28282);
            }
        } else {
            Log.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
            try {
                JSONObject jSONObject5 = new JSONObject(((cck) this.iUB.iLK.iLR).iAc);
                JSONArray jSONArray2 = jSONObject5.getJSONArray("Beacons");
                int length2 = jSONArray2.length();
                JSONObject jSONObject6 = jSONObject5.getJSONObject("LBS");
                String string4 = jSONObject6.getString("Latitude");
                String string5 = jSONObject6.getString("Longitude");
                if (length2 > 0) {
                    JSONObject jSONObject7 = jSONArray2.getJSONObject(0);
                    String string6 = jSONObject7.getString("UUID");
                    JSONObject jSONObject8 = jSONObject7.getJSONObject("Location");
                    int i8 = jSONObject8.getInt("Major");
                    int i9 = jSONObject8.getInt("Minor");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12659, 1, Integer.valueOf(length2), string6, Integer.valueOf(i8), Integer.valueOf(i9), string4, string5, 1, Integer.valueOf(i4));
                    AppMethodBeat.o(28282);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12659, 1, Integer.valueOf(length2), "", 0, 0, string4, string5, 1, Integer.valueOf(i4));
                AppMethodBeat.o(28282);
            } catch (JSONException e3) {
                Log.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                AppMethodBeat.o(28282);
            }
        }
    }
}
