package com.tencent.mm.wallet_core.c;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.ah;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class s extends w {
    protected static final int ERR_RETCODE_JSON_RESOLVE_ERROR = -10089;
    private static final int ERR_RETCODE_NO_JSON = -10088;
    private static final String PAY_END = "1";
    private static final String TAG = "MicroMsg.NetScenePayBase";
    protected int SVR_ERR_CODE = 0;
    protected int SVR_ERR_TYPE = 0;
    private Map<String, String> _request = new HashMap();
    protected i callback;
    public String crt_token = "";
    public String crt_wording = "";
    protected String error_detail_url;
    private boolean hasProcessWalletError = false;
    public boolean hasRevServerRep = false;
    protected boolean isChildConsume = false;
    public int is_gen_cert = 0;
    public int is_hint_cert = 0;
    public int is_ignore_cert = 0;
    private m jumpRemind;
    private String payAppUrl = "";
    private String payFlag = "";
    protected d rr;
    private String wappay_jumped_url = "";

    public abstract void configRequest(boolean z, boolean z2);

    public abstract int doSceneSimulately(d dVar, g gVar, i iVar);

    public abstract String getEncryptUrl(String str);

    public abstract int getPayCgicmd();

    public abstract x getRetModel(d dVar);

    public abstract void onGYNetEnd(int i2, String str, JSONObject jSONObject);

    public abstract void putToReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t);

    public abstract void putToWXReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t);

    public void onGYNetEnd2(e eVar, JSONObject jSONObject) {
    }

    public void onRawGYNetEnd(e eVar, JSONObject jSONObject) {
        onGYNetEnd(eVar.errCode, eVar.errMsg, jSONObject);
    }

    public boolean callbackUIWhenWalletError() {
        return false;
    }

    public void setHasProcessWalletError(boolean z) {
        this.hasProcessWalletError = z;
    }

    public boolean hasProcessWalletError() {
        return this.hasProcessWalletError;
    }

    public void onRawGYNetEndFuck2(e eVar, JSONObject jSONObject) {
        onGYNetEnd2(eVar, jSONObject);
    }

    public void addRequestData(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map != null) {
            map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (this._request == null) {
            this._request = new HashMap();
        }
        if (this._request != null) {
            this._request.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        Object[] array = map.keySet().toArray();
        for (Object obj : array) {
            String str = map.get(obj);
            if (this._request.containsKey(obj)) {
                this._request.remove(obj);
            }
            this._request.put((String) obj, str);
        }
        setRequestData(this._request);
    }

    public void setRequestData(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map != null) {
            map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (!e.gsQ()) {
            map.put("jsapi_reqkey", e.gsR());
        }
        this._request = map;
        configRequest(true, true);
        getCommReqResp().getReqObj().setRouteInfo(f.bpA(map.get("req_key")));
        if (map != null) {
            Object[] array = map.keySet().toArray();
            Arrays.sort(array);
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (Object obj : array) {
                String str = map.get(obj);
                if (!Util.isNullOrNil(str)) {
                    if (z) {
                        sb.append("&");
                    }
                    sb.append(obj);
                    sb.append("=");
                    putToRequest(sb, str);
                    z = true;
                }
            }
            if (CrashReportFactory.hasDebuger()) {
                Log.i(TAG, "RQ: Cmd : " + getPayCgicmd() + ", req = " + sb.toString() + " " + toString() + " " + Util.getStack().toString());
            } else {
                Log.i(TAG, "RQ: Cmd : " + getPayCgicmd() + ", req = " + sb.toString() + " " + toString());
            }
            String encryptUrl = getEncryptUrl(sb.toString());
            sb.append(z ? "&" : "");
            sb.append("WCPaySign");
            sb.append("=");
            sb.append(encryptUrl);
            putToReqText(this.rr, new SKBuiltinBuffer_t().setBuffer(sb.toString().getBytes()));
        }
        Log.i(TAG, "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", Integer.valueOf(getPayCgicmd()), Integer.valueOf(getType()), toString(), this.rr.getUri());
    }

    public void putToRequest(StringBuilder sb, String str) {
        sb.append(str);
    }

    public d getCommReqResp() {
        return this.rr;
    }

    public void setCommReqResp(d dVar) {
        this.rr = dVar;
    }

    public void setWXRequestData(Map<String, String> map) {
        configRequest(false, false);
        if (map != null) {
            bf fQy = k.fQy();
            if (fQy != null) {
                Log.i(TAG, "location found");
                map.put("province", fQy.fuJ);
                if (!map.containsKey("city")) {
                    map.put("city", fQy.fuK);
                }
                map.put("location_timestamp", new StringBuilder().append(fQy.KEC).toString());
                map.put("encrypt_key", fQy.KEG);
                map.put("encrypt_userinfo", fQy.KEF);
                if (k.shouldReportCellInfo()) {
                    map.put("encrypt_cellinfo", fQy.KEH);
                }
            }
            Object[] array = map.keySet().toArray();
            Arrays.sort(array);
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (Object obj : array) {
                String str = map.get(obj);
                if (!Util.isNullOrNil(str)) {
                    if (z) {
                        sb.append("&");
                    }
                    sb.append(obj);
                    sb.append("=");
                    sb.append(str);
                    z = true;
                }
            }
            if (CrashReportFactory.hasDebuger()) {
                Log.d(TAG, "Cmd : " + getPayCgicmd() + ", wxreq = " + sb.toString());
            }
            Log.d(TAG, "wxreq: " + sb.toString());
            putToWXReqText(this.rr, new SKBuiltinBuffer_t().setBuffer(sb.toString().getBytes()));
        }
    }

    public void certSignConfig() {
    }

    public void setPayInfo(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        setPayInfo(payInfo, map, map2, false);
    }

    public void setPayInfo(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (payInfo == null) {
            Log.e(TAG, "Cmd : " + getPayCgicmd() + ", payInfo is null");
            map2.put("devicename", Build.MODEL);
            setWXRequestData(map2);
            return;
        }
        map.put("req_key", payInfo.dDL);
        map.put("partner_id", payInfo.partnerId);
        map.put("pay_sign", payInfo.dQk);
        if (payInfo.Kxw >= 0) {
            map.put("auto_deduct_flag", new StringBuilder().append(payInfo.Kxw).toString());
        }
        if (payInfo.dVv > 0) {
            map.put("pay_scene", new StringBuilder().append(payInfo.dVv).toString());
        }
        if (payInfo.dVw >= 0) {
            map.put("bindbankscene", new StringBuilder().append(payInfo.dVw).toString());
        }
        if (!Util.isNullOrNil(payInfo.Kxx)) {
            map.put("deduct_bank_type", payInfo.Kxx);
        }
        if (!Util.isNullOrNil(payInfo.Kxy)) {
            map.put("deduct_bind_serial", payInfo.Kxy);
        }
        if (z) {
            map.put("use_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            map.put("use_touch", new StringBuilder().append(payInfo.Ijy).toString());
        }
        map.put("fp_identify_num", new StringBuilder().append(payInfo.Ijz).toString());
        if (!TextUtils.isEmpty(payInfo.dNR)) {
            map.put("encrypted_pay_info", URLEncoder.encode(payInfo.dNR));
        }
        if (!TextUtils.isEmpty(payInfo.dNS)) {
            map.put("encrypted_rsa_sign", URLEncoder.encode(payInfo.dNS));
        }
        map2.put("uuid", payInfo.uuid);
        map2.put("appid", payInfo.appId);
        map2.put("appsource", payInfo.IqM);
        map2.put("channel", new StringBuilder().append(payInfo.channel).toString());
        map2.put("devicename", Build.MODEL);
        map2.put("soter_req", payInfo.dUV);
    }

    public boolean checkRecSrvResp() {
        return this.hasRevServerRep;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x020d  */
    @Override // com.tencent.mm.wallet_core.c.w
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGYNetEnd(int r16, int r17, int r18, java.lang.String r19, com.tencent.mm.network.s r20, byte[] r21, long r22) {
        /*
        // Method dump skipped, instructions count: 546
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.wallet_core.c.s.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[], long):void");
    }

    public boolean isJumpRemind() {
        if (this.jumpRemind == null) {
            return false;
        }
        return true;
    }

    public m getJumpRemind() {
        return this.jumpRemind;
    }

    public boolean isPayEnd() {
        if (this.payFlag == null) {
            return false;
        }
        return "1".equals(this.payFlag.trim());
    }

    public String getReturnUrl() {
        return this.payAppUrl;
    }

    public String getWappayJumpUrl() {
        return this.wappay_jumped_url;
    }

    public String getToken() {
        return null;
    }

    public boolean shouldResolveJsonWhenError() {
        return false;
    }

    public boolean resend() {
        reset();
        return false;
    }

    public static e getRetModel(int i2, int i3, String str, int i4, String str2, int i5, String str3, int i6, String str4) {
        e eVar = new e(i2, i3, str);
        if (i2 != 0 || i3 != 0) {
            getRetModel(i2, i3, str, eVar);
        } else if (i4 != 0) {
            Log.w(TAG, "hy: resolve busi error: plat ret is error");
            eVar.f(1000, i4, str2, 1);
        } else if (i5 != 0) {
            Log.w(TAG, "hy: resolve busi error: errType is error");
            eVar.f(1000, i5, str3, 2);
        } else if (i6 != 0) {
            Log.w(TAG, "hy: resolve busi error: retCode is error");
            if (i6 == ERR_RETCODE_JSON_RESOLVE_ERROR || i6 == ERR_RETCODE_NO_JSON) {
                eVar.f(1000, 2, str4, 2);
            } else {
                eVar.f(1000, i6, str4, 2);
            }
        } else {
            if (!Util.isNullOrNil(str3)) {
                Log.i(TAG, "finModel.errMsg = biz_errMsg");
                eVar.errMsg = str3;
            }
            Log.i(TAG, "hy: all's OK");
        }
        return eVar;
    }

    public static void getRetModel(int i2, int i3, String str, e eVar) {
        if (i2 != 0 || i3 != 0) {
            Log.w(TAG, "hy: resolve system error.");
            Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
            if (parseXml != null) {
                Log.d(TAG, "hy: CDN error!");
                eVar.errMsg = parseXml.get(".e.Content");
            } else if (i3 == -1 || i3 == -500) {
                Log.w(TAG, "hy: network error");
                eVar.errMsg = MMApplicationContext.getContext().getString(R.string.ij2);
            } else {
                Log.w(TAG, "hy: unknown system error");
                eVar.errMsg = MMApplicationContext.getContext().getString(R.string.ibn);
            }
        }
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public int getCgicmdForKV() {
        return getPayCgicmd();
    }

    public String getErrDetailUrl() {
        return this.error_detail_url;
    }

    public boolean isBlock() {
        return true;
    }

    public void reportCellInfo(int i2, int i3) {
        if (i2 == 0) {
            try {
                Log.e(TAG, "errType is OK, reportCellInfo do nothing");
            } catch (Exception e2) {
                Log.e(TAG, "reportCellInfo error. %s", e2.getMessage());
            }
        } else if (!k.shouldReportCellInfo()) {
            Log.e(TAG, "shouldReportCellInfo is false, reportCellInfo do nothing");
        } else {
            bf fQy = k.fQy();
            if (fQy != null && !Util.isNullOrNil(fQy.KEG) && !Util.isNullOrNil(fQy.KEH)) {
                int payCgicmd = getPayCgicmd();
                String str = fQy.KEG;
                String str2 = fQy.KEF;
                String str3 = fQy.KEH;
                if (!Util.isNullOrNil(str3)) {
                    int length = str3.length();
                    String str4 = "";
                    String str5 = "";
                    String str6 = "";
                    String str7 = "";
                    String str8 = "";
                    if (length > 5000) {
                        Log.e(TAG, "reportCellInfo. cell info is too long to report");
                    } else if (length > 4000) {
                        str4 = str3.substring(0, 1000);
                        str5 = str3.substring(1000, 2000);
                        str6 = str3.substring(2000, 3000);
                        str7 = str3.substring(3000, 4000);
                        str8 = str3.substring(4000, length);
                    } else if (length > 3000) {
                        str4 = str3.substring(0, 1000);
                        str5 = str3.substring(1000, 2000);
                        str6 = str3.substring(2000, 3000);
                        str7 = str3.substring(3000, length);
                    } else if (length > 2000) {
                        str4 = str3.substring(0, 1000);
                        str5 = str3.substring(1000, 2000);
                        str6 = str3.substring(2000, length);
                    } else if (length > 1000) {
                        str4 = str3.substring(0, 1000);
                        str5 = str3.substring(1000, length);
                    } else if (length > 0) {
                        str4 = str3.substring(0, length);
                    }
                    Log.e(TAG, "reportCellInfo do report");
                    ah ahVar = new ah();
                    ahVar.enX = payCgicmd;
                    ahVar.enY = i2;
                    ahVar.enZ = i3;
                    ahVar.eoa = ahVar.x("EncryptKey", str, true);
                    ahVar.eob = ahVar.x("EncryptUserinfo", str2, true);
                    ahVar.eoc = ahVar.x("EncryptCellinfoLength", String.valueOf(length), true);
                    ahVar.eod = ahVar.x("EncryptCellinfo_01", str4, true);
                    ahVar.eoe = ahVar.x("EncryptCellinfo_02", str5, true);
                    ahVar.eog = ahVar.x("EncryptCellinfo_03", str6, true);
                    ahVar.eoh = ahVar.x("EncryptCellinfo_04", str7, true);
                    ahVar.eoi = ahVar.x("EncryptCellinfo_05", str8, true);
                    ahVar.bfK();
                }
            }
        }
    }
}
