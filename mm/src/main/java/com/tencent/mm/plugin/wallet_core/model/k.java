package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public final class k {
    private static b HXR;
    private static k HXS;
    private static bf HXT = null;
    private static long HXU = 0;
    public JSONArray HXV;

    public static class a {
        public String HXW;
        public String HXX;
        public String HXY;
        public String HXZ;
        public String HYa;
        public String cellid;
        public String dbm;
        public String lac;
        public String mcc;
        public String mnc;
        public String networkId;
        public String networkType;
        public String stationId;
        public String systemId;
        public String type;
    }

    private k() {
        AppMethodBeat.i(70283);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_LBS_REPORT_CONFIG_STRING_SYNC, "");
        Log.i("MicroMsg.GpsReportHelper", "GpsReportHelper ".concat(String.valueOf(str)));
        if (!Util.isNullOrNil(str)) {
            try {
                this.HXV = new JSONArray(str);
                AppMethodBeat.o(70283);
                return;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.GpsReportHelper", e2, "", new Object[0]);
                Log.e("MicroMsg.GpsReportHelper", "parse lbs config error", e2);
            }
        }
        AppMethodBeat.o(70283);
    }

    public static k fQt() {
        AppMethodBeat.i(70284);
        if (HXS == null) {
            HXS = new k();
        }
        k kVar = HXS;
        AppMethodBeat.o(70284);
        return kVar;
    }

    /* access modifiers changed from: package-private */
    public static class b implements b.a {
        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            return z;
        }
    }

    private static String fQu() {
        AppMethodBeat.i(70285);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Context context = MMApplicationContext.getContext();
            if (context == null) {
                AppMethodBeat.o(70285);
                return "";
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            wifiManager.getConnectionInfo();
            new StringBuffer();
            new StringBuffer();
            int i2 = 0;
            for (ScanResult scanResult : wifiManager.getScanResults()) {
                stringBuffer.append(String.format("&scan_ssid%d=%s&scan_bssid%d=%s&sm%d=%s", Integer.valueOf(i2), Fg(scanResult.SSID), Integer.valueOf(i2), Fg(scanResult.BSSID), Integer.valueOf(i2), Integer.valueOf(scanResult.level)));
                int i3 = i2 + 1;
                if (i3 >= 5) {
                    break;
                }
                i2 = i3;
            }
            Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readScanWifi cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(70285);
            return stringBuffer2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GpsReportHelper", e2, "", new Object[0]);
        }
    }

    private static String fQv() {
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(70286);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        if (!shouldReportCellInfo()) {
            AppMethodBeat.o(70286);
            return "";
        }
        hashMap.put("is_ci_permitted", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("net_type", NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
        Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 01- %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        if (fQw()) {
            hashMap.put("is_ci_permitted", "1");
            hashMap.put("uuid", UUID.randomUUID().toString());
            hashMap.put("sample_time", new StringBuilder().append(System.currentTimeMillis() / 1000).toString());
            hashMap.put("phone_brand", Build.BRAND);
            hashMap.put("phone_model", Build.MODEL);
            try {
                if (MMApplicationContext.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && (activeNetworkInfo = ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
                    hashMap.put("net_subtype", new StringBuilder().append(activeNetworkInfo.getSubtype()).toString());
                }
            } catch (Exception e2) {
            }
            Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 02- %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            long currentTimeMillis3 = System.currentTimeMillis();
            List<a> gw = gw(MMApplicationContext.getContext());
            Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
            currentTimeMillis2 = System.currentTimeMillis();
            int size = gw.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = gw.get(i2);
                if (aVar != null) {
                    hashMap.put("mcc_".concat(String.valueOf(i2)), aVar.mcc);
                    hashMap.put("mnc_".concat(String.valueOf(i2)), aVar.mnc);
                    hashMap.put("lac_".concat(String.valueOf(i2)), aVar.lac);
                    hashMap.put("cell_id_".concat(String.valueOf(i2)), aVar.cellid);
                    hashMap.put("type_".concat(String.valueOf(i2)), aVar.type);
                    hashMap.put("sid_".concat(String.valueOf(i2)), aVar.stationId);
                    hashMap.put("net_id_".concat(String.valueOf(i2)), aVar.networkId);
                    hashMap.put("sys_id_".concat(String.valueOf(i2)), aVar.systemId);
                    hashMap.put("dbm_".concat(String.valueOf(i2)), aVar.dbm);
                    hashMap.put("tac_".concat(String.valueOf(i2)), aVar.HXW);
                    hashMap.put("arfcn_".concat(String.valueOf(i2)), aVar.HXZ);
                    hashMap.put("earfcn_".concat(String.valueOf(i2)), aVar.HXX);
                    hashMap.put("uarfcn_".concat(String.valueOf(i2)), aVar.HXY);
                    hashMap.put("dbm_".concat(String.valueOf(i2)), aVar.dbm);
                }
            }
            hashMap.put("count", String.valueOf(size));
        }
        StringBuilder sb = new StringBuilder("");
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (!Util.isNullOrNil(str2)) {
                sb.append(String.format("&%s=%s", str, Fg(str2)));
            }
        }
        String sb2 = sb.toString();
        if (!Util.isNullOrNil(sb2) && sb2.indexOf("&") == 0) {
            sb2 = sb2.substring(1);
        }
        Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: readCellInfo cost 03- %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        AppMethodBeat.o(70286);
        return sb2;
    }

    private static boolean fQw() {
        AppMethodBeat.i(70287);
        if (Build.VERSION.SDK_INT >= 23 || "MNC".equals(Build.VERSION.CODENAME)) {
            try {
                if (android.support.v4.content.b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    AppMethodBeat.o(70287);
                    return true;
                }
                AppMethodBeat.o(70287);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.GpsReportHelper", "check permission exception:%s.", e2);
                AppMethodBeat.o(70287);
                return true;
            }
        } else {
            AppMethodBeat.o(70287);
            return true;
        }
    }

    private static String Fg(String str) {
        AppMethodBeat.i(70288);
        try {
            str = q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.GpsReportHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(70288);
        return str;
    }

    public static bf aZ(Map<String, String> map) {
        AppMethodBeat.i(70289);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        String join = TextUtils.join("&", arrayList);
        byte[] bArr = new byte[16];
        byte[] bytes = y.hhp().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = new StringBuilder().append(System.currentTimeMillis()).toString().getBytes();
        }
        int i2 = 0;
        int i3 = 0;
        do {
            bArr[i3] = bytes[i2];
            i3++;
            i2++;
            if (i2 >= bytes.length) {
                i2 = 0;
                continue;
            }
        } while (i3 < 16);
        bf bfVar = new bf();
        bfVar.KEG = o.fQA().cs(Base64.encode(bArr, 0));
        bfVar.KEF = new String(Base64.encode(AesEcb.aesCryptEcb(join.getBytes(), bArr, true, true), 0));
        AppMethodBeat.o(70289);
        return bfVar;
    }

    private static void lu(String str, String str2) {
        AppMethodBeat.i(70290);
        if (HXT == null) {
            HXT = new bf();
        }
        Log.d("MicroMsg.GpsReportHelper", "encrypt data userInfo:%s, cellInfo:%s", str, str2);
        byte[] bArr = new byte[16];
        byte[] bytes = y.hhp().getBytes();
        if (bytes == null || bytes.length <= 0) {
            bytes = new StringBuilder().append(System.currentTimeMillis()).toString().getBytes();
        }
        int i2 = 0;
        int i3 = 0;
        do {
            bArr[i3] = bytes[i2];
            i3++;
            i2++;
            if (i2 >= bytes.length) {
                i2 = 0;
                continue;
            }
        } while (i3 < 16);
        HXT.KEG = o.fQA().cs(Base64.encode(bArr, 0));
        Log.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_key %s", HXT.KEG);
        if (!Util.isNullOrNil(str)) {
            byte[] encode = Base64.encode(AesEcb.aesCryptEcb(str.getBytes(), bArr, true, true), 0);
            HXT.KEF = new String(encode);
            Log.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_userinfo %s", new String(encode));
        }
        if (!Util.isNullOrNil(str2)) {
            byte[] encode2 = Base64.encode(AesEcb.aesCryptEcb(str2.getBytes(), bArr, true, true), 0);
            HXT.KEH = new String(encode2);
            Log.d("MicroMsg.GpsReportHelper", "encryptReportData mLocationInfo.encrypt_cellinfo %s", new String(encode2));
        }
        AppMethodBeat.o(70290);
    }

    public static void aeJ(int i2) {
        AppMethodBeat.i(70291);
        Log.i("MicroMsg.GpsReportHelper", "reflashLocationInfo ".concat(String.valueOf(i2)));
        HXU = System.currentTimeMillis() / 1000;
        if (!shouldReportLocation()) {
            HXR = null;
            fQx();
            HXU = System.currentTimeMillis() / 1000;
        }
        AppMethodBeat.o(70291);
    }

    private static void fQx() {
        String str;
        String str2;
        AppMethodBeat.i(70292);
        long currentTimeMillis = System.currentTimeMillis();
        if (shouldReportLocation()) {
            AppMethodBeat.o(70292);
            return;
        }
        if (fQz() || shouldReportCellInfo()) {
            try {
                str = new StringBuilder().append(((WifiManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getRssi()).toString();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.GpsReportHelper", e2, "", new Object[0]);
                str = "";
            }
            String str3 = String.format("wifissid=%s&wifibssid=%s&wifimac=%s&sm=%s&ssid_timestamp=%s", Fg(NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext())), Fg(NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext())), Fg(com.tencent.mm.compatible.deviceinfo.q.aoD()), str, new StringBuilder().append(System.currentTimeMillis()).toString()) + fQu();
            if (shouldReportCellInfo()) {
                str2 = fQv();
            } else {
                str2 = null;
            }
            lu(str3, str2);
        }
        Log.e("MicroMsg.GpsReportHelper", "RecordCostTime: refreshWifiAndCellInfo cost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(70292);
    }

    public static bf fQy() {
        AppMethodBeat.i(70293);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - HXU > 300) {
            fQx();
            HXU = currentTimeMillis;
        }
        bf bfVar = HXT;
        AppMethodBeat.o(70293);
        return bfVar;
    }

    public static czu elk() {
        AppMethodBeat.i(70294);
        if (HXT == null) {
            AppMethodBeat.o(70294);
            return null;
        }
        czu czu = new czu();
        czu.fuK = HXT.fuK;
        czu.fuJ = HXT.fuJ;
        czu.latitude = HXT.latitude;
        czu.longitude = HXT.longitude;
        czu.KEC = HXT.KEC;
        czu.KEG = HXT.KEG;
        czu.KED = HXT.KED;
        czu.KEE = HXT.KEE;
        czu.KEF = HXT.KEF;
        AppMethodBeat.o(70294);
        return czu;
    }

    public static boolean shouldReportLocation() {
        AppMethodBeat.i(70295);
        boolean UB = t.fQI().fRs().UB();
        AppMethodBeat.o(70295);
        return UB;
    }

    public static boolean fQz() {
        AppMethodBeat.i(70296);
        boolean fRd = t.fQI().fRs().fRd();
        AppMethodBeat.o(70296);
        return fRd;
    }

    public static boolean shouldReportCellInfo() {
        AppMethodBeat.i(70297);
        boolean fRe = t.fQI().fRs().fRe();
        AppMethodBeat.o(70297);
        return fRe;
    }

    private static synchronized List<a> gw(Context context) {
        LinkedList linkedList;
        int i2;
        synchronized (k.class) {
            AppMethodBeat.i(70298);
            linkedList = new LinkedList();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i3 = Build.VERSION.SDK_INT;
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        a aVar = new a();
                        aVar.networkType = new StringBuilder().append(telephonyManager.getNetworkType()).toString();
                        if (cellInfo instanceof CellInfoGsm) {
                            CellSignalStrengthGsm cellSignalStrength = ((CellInfoGsm) cellInfo).getCellSignalStrength();
                            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                            int mnc = cellIdentity.getMnc();
                            aVar.cellid = new StringBuilder().append(cellIdentity.getCid()).toString();
                            aVar.mcc = new StringBuilder().append(cellIdentity.getMcc()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity.getMnc()).toString();
                            aVar.lac = new StringBuilder().append(cellIdentity.getLac()).toString();
                            aVar.dbm = new StringBuilder().append(cellSignalStrength.getDbm()).toString();
                            aVar.HYa = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (Build.VERSION.SDK_INT >= 24) {
                                aVar.HXZ = new StringBuilder().append(cellIdentity.getArfcn()).toString();
                            }
                            i2 = mnc;
                        } else if (cellInfo instanceof CellInfoCdma) {
                            CellSignalStrengthCdma cellSignalStrength2 = ((CellInfoCdma) cellInfo).getCellSignalStrength();
                            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                            int systemId = cellIdentity2.getSystemId();
                            aVar.cellid = new StringBuilder().append(cellIdentity2.getBasestationId()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity2.getSystemId()).toString();
                            aVar.lac = new StringBuilder().append(cellIdentity2.getNetworkId()).toString();
                            aVar.dbm = new StringBuilder().append(cellSignalStrength2.getDbm()).toString();
                            aVar.HYa = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            i2 = systemId;
                        } else if (cellInfo instanceof CellInfoLte) {
                            CellSignalStrengthLte cellSignalStrength3 = ((CellInfoLte) cellInfo).getCellSignalStrength();
                            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                            int mnc2 = cellIdentity3.getMnc();
                            aVar.cellid = new StringBuilder().append(cellIdentity3.getCi()).toString();
                            aVar.mcc = new StringBuilder().append(cellIdentity3.getMcc()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity3.getMnc()).toString();
                            aVar.HXW = new StringBuilder().append(cellIdentity3.getTac()).toString();
                            aVar.dbm = new StringBuilder().append(cellSignalStrength3.getDbm()).toString();
                            aVar.HYa = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (Build.VERSION.SDK_INT >= 24) {
                                aVar.HXX = new StringBuilder().append(cellIdentity3.getEarfcn()).toString();
                            }
                            i2 = mnc2;
                        } else if (i3 < 18 || !(cellInfo instanceof CellInfoWcdma)) {
                            Log.i("MicroMsg.GpsReportHelper", "Unknown type of cell signal!\n ClassName: " + cellInfo.getClass().getSimpleName() + "\n ToString: " + cellInfo.toString());
                            i2 = 0;
                        } else {
                            CellSignalStrengthWcdma cellSignalStrength4 = ((CellInfoWcdma) cellInfo).getCellSignalStrength();
                            CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            int mnc3 = cellIdentity4.getMnc();
                            aVar.cellid = new StringBuilder().append(cellIdentity4.getCid()).toString();
                            aVar.mcc = new StringBuilder().append(cellIdentity4.getMcc()).toString();
                            aVar.mnc = new StringBuilder().append(cellIdentity4.getMnc()).toString();
                            aVar.lac = new StringBuilder().append(cellIdentity4.getLac()).toString();
                            aVar.dbm = new StringBuilder().append(cellSignalStrength4.getDbm()).toString();
                            aVar.HYa = cellInfo.isRegistered() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (Build.VERSION.SDK_INT >= 24) {
                                aVar.HXY = new StringBuilder().append(cellIdentity4.getUarfcn()).toString();
                            }
                            i2 = mnc3;
                        }
                        if (i2 != Integer.MAX_VALUE) {
                            linkedList.add(aVar);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.GpsReportHelper", "loadCellInfo: Unable to obtain cell signal information: ", e2);
            }
            AppMethodBeat.o(70298);
        }
        return linkedList;
    }
}
