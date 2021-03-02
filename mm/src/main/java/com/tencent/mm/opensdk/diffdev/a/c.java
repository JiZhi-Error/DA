package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private String f1480a;

    /* renamed from: b  reason: collision with root package name */
    private String f1481b;

    /* renamed from: c  reason: collision with root package name */
    private OAuthListener f1482c;

    /* renamed from: d  reason: collision with root package name */
    private int f1483d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public OAuthErrCode f1484a;

        /* renamed from: b  reason: collision with root package name */
        public String f1485b;

        /* renamed from: c  reason: collision with root package name */
        public int f1486c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        AppMethodBeat.i(190422);
        this.f1480a = str;
        this.f1482c = oAuthListener;
        this.f1481b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
        AppMethodBeat.o(190422);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        AppMethodBeat.i(190424);
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str = this.f1480a;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            aVar.f1484a = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (true) {
                if (!isCancelled()) {
                    String str2 = this.f1481b + (this.f1483d == 0 ? "" : "&last=" + this.f1483d);
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(str2, 60000);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    a aVar2 = new a();
                    Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                    if (a2 == null || a2.length == 0) {
                        Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                        aVar2.f1484a = OAuthErrCode.WechatAuth_Err_NetworkErr;
                    } else {
                        try {
                            try {
                                JSONObject jSONObject = new JSONObject(new String(a2, ProtocolPackage.ServerEncoding));
                                int i2 = jSONObject.getInt("wx_errcode");
                                aVar2.f1486c = i2;
                                Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                                int i3 = aVar2.f1486c;
                                if (i3 != 408) {
                                    if (i3 != 500) {
                                        switch (i3) {
                                            case 402:
                                                oAuthErrCode = OAuthErrCode.WechatAuth_Err_Timeout;
                                                aVar2.f1484a = oAuthErrCode;
                                                break;
                                            case 403:
                                                oAuthErrCode = OAuthErrCode.WechatAuth_Err_Cancel;
                                                aVar2.f1484a = oAuthErrCode;
                                                break;
                                            case 405:
                                                aVar2.f1484a = OAuthErrCode.WechatAuth_Err_OK;
                                                aVar2.f1485b = jSONObject.getString("wx_code");
                                                break;
                                        }
                                    }
                                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    aVar2.f1484a = oAuthErrCode;
                                }
                                oAuthErrCode = OAuthErrCode.WechatAuth_Err_OK;
                                aVar2.f1484a = oAuthErrCode;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", e2.getMessage()));
                                aVar2.f1484a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            }
                        } catch (Exception e3) {
                            Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", e3.getMessage()));
                            aVar2.f1484a = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                    }
                    Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str2, aVar2.f1484a.toString(), Integer.valueOf(aVar2.f1486c), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    OAuthErrCode oAuthErrCode2 = aVar2.f1484a;
                    if (oAuthErrCode2 == OAuthErrCode.WechatAuth_Err_OK) {
                        int i4 = aVar2.f1486c;
                        this.f1483d = i4;
                        if (i4 == d.UUID_SCANED.a()) {
                            this.f1482c.onQrcodeScanned();
                        } else if (aVar2.f1486c != d.UUID_KEEP_CONNECT.a() && aVar2.f1486c == d.UUID_CONFIRM.a()) {
                            String str3 = aVar2.f1485b;
                            if (str3 == null || str3.length() == 0) {
                                Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                aVar2.f1484a = OAuthErrCode.WechatAuth_Err_NormalErr;
                                aVar = aVar2;
                            } else {
                                aVar = aVar2;
                            }
                        }
                    } else {
                        Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(aVar2.f1486c)));
                        aVar = aVar2;
                    }
                } else {
                    Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
                    aVar = new a();
                    aVar.f1484a = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
                }
            }
        }
        AppMethodBeat.o(190424);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        AppMethodBeat.i(190423);
        a aVar2 = aVar;
        this.f1482c.onAuthFinish(aVar2.f1484a, aVar2.f1485b);
        AppMethodBeat.o(190423);
    }
}
