package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import org.json.JSONObject;

public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private String f1468a;

    /* renamed from: b  reason: collision with root package name */
    private String f1469b;

    /* renamed from: c  reason: collision with root package name */
    private String f1470c;

    /* renamed from: d  reason: collision with root package name */
    private String f1471d;

    /* renamed from: e  reason: collision with root package name */
    private String f1472e;

    /* renamed from: f  reason: collision with root package name */
    private OAuthListener f1473f;

    /* renamed from: g  reason: collision with root package name */
    private c f1474g;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public OAuthErrCode f1475a;

        /* renamed from: b  reason: collision with root package name */
        public String f1476b;

        /* renamed from: c  reason: collision with root package name */
        public String f1477c;

        /* renamed from: d  reason: collision with root package name */
        public String f1478d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f1479e;

        private a() {
        }

        public static a a(byte[] bArr) {
            AppMethodBeat.i(190421);
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                aVar.f1475a = OAuthErrCode.WechatAuth_Err_NetworkErr;
                AppMethodBeat.o(190421);
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, ProtocolPackage.ServerEncoding));
                        int i2 = jSONObject.getInt("errcode");
                        if (i2 != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i2)));
                            aVar.f1475a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            AppMethodBeat.o(190421);
                        } else {
                            String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                            if (string == null || string.length() == 0) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                                aVar.f1475a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                AppMethodBeat.o(190421);
                            } else {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode == null || decode.length == 0) {
                                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                    aVar.f1475a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                    AppMethodBeat.o(190421);
                                } else {
                                    aVar.f1475a = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.f1479e = decode;
                                    aVar.f1476b = jSONObject.getString("uuid");
                                    String string2 = jSONObject.getString("appname");
                                    aVar.f1477c = string2;
                                    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f1476b, string2, Integer.valueOf(aVar.f1479e.length)));
                                    AppMethodBeat.o(190421);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", e2.getMessage()));
                        aVar.f1475a = OAuthErrCode.WechatAuth_Err_NormalErr;
                        AppMethodBeat.o(190421);
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", e3.getMessage()));
                    aVar.f1475a = OAuthErrCode.WechatAuth_Err_NormalErr;
                    AppMethodBeat.o(190421);
                }
            }
            return aVar;
        }
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        AppMethodBeat.i(190355);
        this.f1468a = str;
        this.f1469b = str2;
        this.f1470c = str3;
        this.f1471d = str4;
        this.f1472e = str5;
        this.f1473f = oAuthListener;
        AppMethodBeat.o(190355);
    }

    public boolean a() {
        AppMethodBeat.i(190356);
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.f1474g;
        if (cVar == null) {
            boolean cancel = cancel(true);
            AppMethodBeat.o(190356);
            return cancel;
        }
        boolean cancel2 = cVar.cancel(true);
        AppMethodBeat.o(190356);
        return cancel2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public a doInBackground(Void[] voidArr) {
        AppMethodBeat.i(190358);
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f1468a, this.f1470c, this.f1471d, this.f1469b, this.f1472e);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(format, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        a a3 = a.a(a2);
        AppMethodBeat.o(190358);
        return a3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        AppMethodBeat.i(190357);
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f1475a;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f1479e.length);
            this.f1473f.onAuthGotQrcode(aVar2.f1478d, aVar2.f1479e);
            c cVar = new c(aVar2.f1476b, this.f1473f);
            this.f1474g = cVar;
            if (Build.VERSION.SDK_INT >= 11) {
                cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                AppMethodBeat.o(190357);
                return;
            }
            cVar.execute(new Void[0]);
            AppMethodBeat.o(190357);
            return;
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
        this.f1473f.onAuthFinish(aVar2.f1475a, null);
        AppMethodBeat.o(190357);
    }
}
