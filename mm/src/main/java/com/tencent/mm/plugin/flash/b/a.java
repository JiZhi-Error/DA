package com.tencent.mm.plugin.flash.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.b.p;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.flash.e.b;
import com.tencent.mm.plugin.flash.e.c;
import com.tencent.mm.plugin.flash.e.d;
import com.tencent.mm.plugin.flash.e.e;
import com.tencent.mm.plugin.flash.e.f;
import com.tencent.mm.plugin.flash.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements i, g.a, g {
    protected Activity activity;
    protected String fuN;
    protected String mAppId;
    private boolean sPq;
    protected long sQI;
    protected float sQv;
    public long sXP;
    protected int scene;
    protected YtSDKKitFramework.IYtSDKKitNetResponseParser wIj;
    protected String wIk;
    protected boolean wIl;
    protected String wIm;
    int wIn = -1;
    private long wIo = -1;
    private com.tencent.mm.plugin.flash.e.a wIp;
    private String wIq;
    protected long wIr;

    public a() {
        AppMethodBeat.i(186615);
        com.tencent.mm.kernel.g.aAf();
        this.sPq = com.tencent.mm.kernel.a.azo();
        this.wIq = "";
        this.sXP = 0;
        this.wIr = 0;
        AppMethodBeat.o(186615);
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public void h(Intent intent, Activity activity2) {
        com.tencent.mm.plugin.flash.e.a dVar;
        AppMethodBeat.i(186616);
        this.activity = activity2;
        this.scene = intent.getIntExtra("scene", 0);
        this.mAppId = intent.getStringExtra("appId");
        this.fuN = intent.getStringExtra("request_verify_pre_info");
        this.wIl = intent.getBooleanExtra("needVideo", false);
        this.wIm = intent.getStringExtra("feedbackUrl");
        this.wIn = Settings.System.getInt(activity2.getContentResolver(), "screen_brightness", 100);
        switch (this.scene) {
            case 0:
                dVar = new f();
                break;
            case 1:
                dVar = new e();
                break;
            case 2:
            case 5:
                dVar = new com.tencent.mm.plugin.flash.e.g();
                break;
            case 3:
                dVar = new h();
                break;
            case 4:
                dVar = new c();
                break;
            case 6:
                dVar = new d();
                break;
            default:
                dVar = new b();
                break;
        }
        this.wIp = dVar;
        String stringExtra = intent.getStringExtra("k_ticket");
        if (!Util.isNullOrNil(stringExtra)) {
            Log.i("MicroMsg.FaceFlashManagerData", "has prepared ticket. force set");
            p.arz(stringExtra);
        }
        if (this.sPq) {
            com.tencent.mm.kernel.g.azz().a(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, this);
        } else {
            com.tencent.mm.kernel.g.azz().a(733, this);
        }
        com.tencent.mm.kernel.g.azz().a(this.wIp.getType(), this);
        Log.i("MicroMsg.FaceFlashManagerData", "[%s]intent data, scene:%s ,mAppId:%s verifyInfo:%s currentLight %s enterBrightness: %s isLogin:%s", getClass().getSimpleName(), Integer.valueOf(this.scene), this.mAppId, this.fuN, Float.valueOf(this.sQv), Integer.valueOf(this.wIn), Boolean.valueOf(this.sPq));
        AppMethodBeat.o(186616);
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, final YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        AppMethodBeat.i(186617);
        Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", str, str2, hashMap);
        this.wIj = iYtSDKKitNetResponseParser;
        if (str.contains("wechat_face_config")) {
            com.tencent.mm.plugin.flash.c.b.dLi().ere = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.axn("reqCfg");
            dKZ();
            Log.i("MicroMsg.FaceFlashManagerData", "requestConfig");
            com.tencent.mm.plugin.flash.c.b.MY(2);
            try {
                this.wIk = new JSONObject(str2).getString("select_data");
                Log.i("MicroMsg.FaceFlashManagerData", "getConfig selectData:%s", this.wIk);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "reflect get yt config data error", new Object[0]);
            }
            if (this.sPq) {
                com.tencent.mm.kernel.g.azz().a(new u(this.scene, dKV(), this.mAppId, this.fuN, this.wIk.getBytes()), 0);
            } else {
                com.tencent.mm.kernel.g.azz().a(new v(this.scene, dKV()), 0);
            }
            com.tencent.mm.plugin.flash.c.a.MS(dKV());
            AppMethodBeat.o(186617);
        } else if (str.contains("wechat_face_verify")) {
            com.tencent.mm.plugin.flash.c.b.dLi().erh = System.currentTimeMillis();
            dLa();
            com.tencent.mm.plugin.flash.c.b.dLi().eqX = System.currentTimeMillis() - this.wIr;
            String axi = axi(str2);
            if (TextUtils.isEmpty(axi) || !s.YS(axi)) {
                bn(90034, "save result to file error.");
            } else {
                axj(axi);
            }
            com.tencent.mm.plugin.flash.c.a.MT(dKV());
            AppMethodBeat.o(186617);
        } else {
            YtSDKKitNetHelper.getInstance().sendNetworkRequest(str, str2, hashMap, new YtSDKKitFramework.IYtSDKKitNetResponseParser() {
                /* class com.tencent.mm.plugin.flash.b.a.AnonymousClass1 */

                @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser
                public final void onNetworkResponseEvent(HashMap<String, String> hashMap, Exception exc) {
                    AppMethodBeat.i(186612);
                    Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  result:%s", hashMap);
                    iYtSDKKitNetResponseParser.onNetworkResponseEvent(hashMap, exc);
                    AppMethodBeat.o(186612);
                }
            });
            AppMethodBeat.o(186617);
        }
    }

    /* access modifiers changed from: protected */
    public final void dKZ() {
        AppMethodBeat.i(186618);
        Log.i("MicroMsg.FaceFlashManagerData", "improveBrightness");
        if (this.activity == null) {
            AppMethodBeat.o(186618);
            return;
        }
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.plugin.flash.b.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(186613);
                YTCommonExInterface.setAppBrightness(a.this.activity, 255);
                AppMethodBeat.o(186613);
            }
        });
        AppMethodBeat.o(186618);
    }

    /* access modifiers changed from: protected */
    public final void dLa() {
        AppMethodBeat.i(186619);
        Log.i("MicroMsg.FaceFlashManagerData", "restoreBrightness %d", Integer.valueOf(this.wIn));
        if (this.wIn > 0) {
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.flash.b.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(186614);
                    if (a.this.activity != null) {
                        YTCommonExInterface.setAppBrightness(a.this.activity, a.this.wIn);
                    }
                    AppMethodBeat.o(186614);
                }
            });
        }
        AppMethodBeat.o(186619);
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public void reset() {
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public void release() {
        AppMethodBeat.i(186620);
        dLa();
        com.tencent.mm.kernel.g.azz().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, this);
        com.tencent.mm.kernel.g.azz().b(this.wIp.getType(), this);
        com.tencent.mm.kernel.g.azz().b(733, this);
        AppMethodBeat.o(186620);
    }

    public int dKV() {
        return 8;
    }

    public int dLb() {
        return 4;
    }

    public int dLc() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public final long cSK() {
        return this.sQI;
    }

    /* access modifiers changed from: protected */
    public String axi(String str) {
        AppMethodBeat.i(186621);
        String f2 = f.f(str, String.valueOf(this.sQI), this.mAppId, dLc());
        AppMethodBeat.o(186621);
        return f2;
    }

    /* access modifiers changed from: protected */
    public final void axj(String str) {
        AppMethodBeat.i(186622);
        g axk = axk(str);
        com.tencent.mm.plugin.flash.c.b.axn("reqCdn");
        this.sXP = System.currentTimeMillis();
        com.tencent.mm.plugin.flash.c.b.MY(8);
        if (!com.tencent.mm.an.f.baQ().f(axk)) {
            Log.e("MicroMsg.FaceFlashManagerData", "hy: cdntra addSendTask failed. clientid:%s", axk.field_mediaId);
            com.tencent.mm.plugin.flash.c.b.axn("cdnFailTask");
            bn(90019, "face file add to cdn failed");
        }
        AppMethodBeat.o(186622);
    }

    @Override // com.tencent.mm.i.g.a
    public int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
        AppMethodBeat.i(186623);
        int i3 = dVar == null ? -1 : dVar.field_retCode;
        com.tencent.mm.plugin.flash.c.b.s("rspCdn", Integer.valueOf(i3));
        com.tencent.mm.plugin.flash.c.b.dLi().eqU = i3;
        com.tencent.mm.plugin.flash.c.b.dLi().eqW = System.currentTimeMillis() - this.sXP;
        if (i2 == -21005) {
            Log.i("MicroMsg.FaceFlashManagerData", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            AppMethodBeat.o(186623);
            return 0;
        } else if (dVar != null && dVar.field_retCode == 0) {
            Log.i("MicroMsg.FaceFlashManagerData", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            String str2 = dVar.field_fileId;
            Bundle bundle = new Bundle();
            bundle.putString("key_pic_cdn_id", str2);
            bundle.putString("key_cdn_aes_key", dVar.field_aesKey);
            com.tencent.mm.plugin.flash.c.b.axn("reqVerify");
            com.tencent.mm.plugin.flash.c.b.MY(9);
            com.tencent.mm.plugin.flash.c.b.dLi().eri = System.currentTimeMillis();
            this.wIp.a(this.sQI, str2, dVar.field_aesKey, this.mAppId, this.fuN, dLb(), this.sQv, this.wIl ? 1 : 0, this);
            AppMethodBeat.o(186623);
            return 0;
        } else if (dVar != null) {
            Log.w("MicroMsg.FaceFlashManagerData", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            AppMethodBeat.o(186623);
            return 0;
        } else if (i2 != 0) {
            Log.w("MicroMsg.FaceFlashManagerData", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            AppMethodBeat.o(186623);
            return 0;
        } else {
            Log.i("MicroMsg.FaceFlashManagerData", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            if (cVar != null) {
                Log.d("MicroMsg.FaceFlashManagerData", "hy: cdn process: %f", Double.valueOf(((double) cVar.field_finishedLength) / ((double) cVar.field_toltalLength)));
            }
            AppMethodBeat.o(186623);
            return 0;
        }
    }

    @Override // com.tencent.mm.i.g.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    @Override // com.tencent.mm.i.g.a
    public final byte[] f(String str, byte[] bArr) {
        return null;
    }

    private g axk(String str) {
        AppMethodBeat.i(186624);
        g gVar = new g();
        gVar.gqy = this;
        gVar.field_mediaId = com.tencent.mm.plugin.facedetect.model.p.arC(str);
        gVar.field_fullpath = str;
        gVar.field_thumbpath = "";
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
        gVar.field_talker = "";
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 1;
        gVar.field_bzScene = 0;
        gVar.field_largesvideo = 0;
        gVar.fuQ = 5;
        AppMethodBeat.o(186624);
        return gVar;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(186625);
        if ((qVar instanceof u) || (qVar instanceof v)) {
            Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            com.tencent.mm.plugin.flash.c.b.dLi().erf = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(i3));
            com.tencent.mm.plugin.flash.c.b.dLi().eqT = i3;
            this.wIr = System.currentTimeMillis();
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.facedetect.b.b bVar = (com.tencent.mm.plugin.facedetect.b.b) qVar;
                this.sQI = bVar.cSK();
                String decrypt = YTAGFaceReflectForWXJNIInterface.decrypt(new StringBuilder().append(this.sQI).toString(), bVar.cSL(), (long) bVar.cSL().length);
                HashMap<String, String> hashMap = new HashMap<>();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errorcode", 0);
                    jSONObject.put("errormsg", "OK");
                    jSONObject.put("type", 1);
                    jSONObject.put("smallface_ratio_threshold", (double) bVar.cSM());
                    JSONObject jSONObject2 = new JSONObject();
                    Log.i("MicroMsg.FaceFlashManagerData", "update smallface_ratio_threshold:%f", Float.valueOf(bVar.cSM()));
                    jSONObject2.put("smallface_ratio_threshold", (double) bVar.cSM());
                    YtSDKKitFramework.getInstance().updateSDKSetting(jSONObject2);
                    if (bVar.cSN() != null) {
                        try {
                            jSONObject.put("select_data", new JSONObject(new String(bVar.cSN())));
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.FaceFlashManagerData", e2, "parse selectJson error", new Object[0]);
                        }
                    }
                    JSONArray optJSONArray = new JSONObject(decrypt).optJSONArray("face_action_seq");
                    if (optJSONArray != null) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            if (optJSONObject != null) {
                                if (optJSONObject.optInt("action_id", 0) == 6) {
                                    jSONObject.put("data", optJSONObject.optString("action_data"));
                                    jSONObject.put("color_data", optJSONObject.optString("action_data"));
                                }
                                if (optJSONObject.optInt("action_id", 0) == 7) {
                                    String optString = optJSONObject.optString("action_data", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    Log.i("MicroMsg.FaceFlashManagerData", "initPrepareTip :%s", optString);
                                    if (optString.equals("1")) {
                                        this.wIq = com.tencent.mm.cb.a.aI(this.activity, R.string.fl_act_blink);
                                    } else if (optString.equals("2")) {
                                        this.wIq = com.tencent.mm.cb.a.aI(this.activity, R.string.fl_act_open_mouth);
                                    } else if (optString.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                        this.wIq = com.tencent.mm.cb.a.aI(this.activity, R.string.fl_act_nod_head);
                                    } else if (optString.equals("4")) {
                                        this.wIq = com.tencent.mm.cb.a.aI(this.activity, R.string.fl_act_shake_head);
                                    } else if (optString.equals("5")) {
                                        this.wIq = com.tencent.mm.cb.a.aI(this.activity, R.string.fl_act_silence);
                                    }
                                    jSONObject.put("action_data", optString);
                                }
                            }
                        }
                    }
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e3, "reflect get config error", new Object[0]);
                }
                hashMap.put("response", jSONObject.toString());
                this.wIj.onNetworkResponseEvent(hashMap, null);
                Log.i("MicroMsg.FaceFlashManagerData", "[sdk-info] mBioId:%s decryptConfig:%s retMap:%s", Long.valueOf(this.sQI), decrypt, hashMap);
                AppMethodBeat.o(186625);
                return;
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errorcode", -1);
                jSONObject3.put("errormsg", "WeChat get config error!");
                jSONObject3.put("err_feedback", this.wIm);
                jSONObject3.put("err_msg", com.tencent.mm.cb.a.aI(this.activity, R.string.net_fetch_failed));
            } catch (JSONException e4) {
            }
            hashMap2.put("response", jSONObject3.toString());
            this.wIj.onNetworkResponseEvent(hashMap2, null);
            Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
            AppMethodBeat.o(186625);
        } else if (qVar instanceof d.a) {
            com.tencent.mm.plugin.flash.c.b.dLi().erj = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(i3));
            com.tencent.mm.plugin.flash.c.b.dLi().eqV = i3;
            if (i2 == 0 && i3 == 0) {
                JSONObject al = com.tencent.mm.plugin.flash.d.a.al(((d.a) qVar).result);
                try {
                    al.put("errorcode", i3);
                    al.put("error_code", i3);
                    al.put("errormsg", str);
                } catch (JSONException e5) {
                }
                Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", al);
                HashMap<String, String> hashMap3 = new HashMap<>();
                hashMap3.put("response", al.toString());
                this.wIj.onNetworkResponseEvent(hashMap3, null);
                AppMethodBeat.o(186625);
                return;
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("errorcode", i3);
                jSONObject4.put("error_code", i3);
                jSONObject4.put("errormsg", str);
                jSONObject4.put("err_type", 3);
                jSONObject4.put("err_code", 90020);
                jSONObject4.put("err_retry", true);
                jSONObject4.put("err_msg", com.tencent.mm.cb.a.aI(this.activity, R.string.hcu));
                AppMethodBeat.o(186625);
            } catch (JSONException e6) {
                AppMethodBeat.o(186625);
            }
        } else if (qVar instanceof m) {
            Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneFacePicThirdVerifyFace errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(i3));
            com.tencent.mm.plugin.flash.c.b.dLi().eqV = i3;
            com.tencent.mm.plugin.flash.c.b.dLi().erj = System.currentTimeMillis();
            JSONObject jSONObject5 = new JSONObject();
            try {
                jSONObject5.put("err_type", i2);
                jSONObject5.put("err_code", i3);
                jSONObject5.put("verify_result", ((m) qVar).sPY);
                jSONObject5.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.e) qVar).cSO());
                if (i2 == 0 && i3 == 0) {
                    jSONObject5.put("err_msg", str);
                    jSONObject5.put("key_app_id", this.mAppId);
                    jSONObject5.put("errorcode", i3);
                    jSONObject5.put("error_code", i3);
                    jSONObject5.put("errormsg", str);
                    com.tencent.mm.plugin.flash.c.a.MU(dKV());
                } else {
                    jSONObject5.put("errorcode", i3);
                    jSONObject5.put("error_code", i3);
                    jSONObject5.put("errormsg", "WeChat face verify error!");
                    jSONObject5.put("err_feedback", this.wIm);
                    jSONObject5.put("err_msg", str);
                    com.tencent.mm.plugin.flash.c.a.MV(dKV());
                }
            } catch (JSONException e7) {
            }
            Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", jSONObject5);
            HashMap<String, String> hashMap4 = new HashMap<>();
            hashMap4.put("response", jSONObject5.toString());
            this.wIj.onNetworkResponseEvent(hashMap4, null);
            AppMethodBeat.o(186625);
        } else {
            if (qVar instanceof com.tencent.mm.plugin.facedetect.b.e) {
                com.tencent.mm.plugin.flash.c.b.dLi().erj = System.currentTimeMillis();
                com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(i3));
                com.tencent.mm.plugin.flash.c.b.dLi().eqV = i3;
                JSONObject jSONObject6 = new JSONObject();
                new Bundle().putString(this.wIp.getResultKey(), ((com.tencent.mm.plugin.facedetect.b.e) qVar).cSP());
                try {
                    jSONObject6.put("errorcode", i3);
                    jSONObject6.put("error_code", i3);
                    jSONObject6.put("errormsg", str);
                    jSONObject6.put("err_type", 2);
                    jSONObject6.put("err_code", i3);
                    jSONObject6.put("err_msg", str);
                    jSONObject6.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.e) qVar).cSO());
                    Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", jSONObject6);
                    HashMap<String, String> hashMap5 = new HashMap<>();
                    hashMap5.put("response", jSONObject6.toString());
                    this.wIj.onNetworkResponseEvent(hashMap5, null);
                    AppMethodBeat.o(186625);
                    return;
                } catch (JSONException e8) {
                }
            }
            AppMethodBeat.o(186625);
        }
    }

    private void bn(int i2, String str) {
        AppMethodBeat.i(186626);
        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_type", 4);
            jSONObject.put("err_code", i2);
            jSONObject.put("errorcode", i2);
            jSONObject.put("error_code", i2);
            jSONObject.put("errormsg", str);
            jSONObject.put("err_feedback", this.wIm);
        } catch (JSONException e2) {
        }
        hashMap.put("response", jSONObject.toString());
        this.wIj.onNetworkResponseEvent(hashMap, null);
        AppMethodBeat.o(186626);
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public final JSONObject dT(String str, int i2) {
        AppMethodBeat.i(186627);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_type", 1);
            jSONObject.put("err_code", i2);
            jSONObject.put("err_feedback", this.wIm);
            jSONObject.put("key_app_id", this.mAppId);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("err_tip", str);
            }
        } catch (JSONException e2) {
        }
        AppMethodBeat.o(186627);
        return jSONObject;
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public final void dLd() {
        AppMethodBeat.i(186629);
        this.wIo = System.currentTimeMillis();
        AppMethodBeat.o(186629);
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public void r(TextView textView) {
        AppMethodBeat.i(186630);
        textView.setText(this.wIq);
        AppMethodBeat.o(186630);
    }

    @Override // com.tencent.mm.plugin.flash.b.g
    public final void c(TextView textView, String str) {
        boolean z = true;
        AppMethodBeat.i(186628);
        try {
            if (System.currentTimeMillis() - this.wIo >= 1000) {
                this.wIo = System.currentTimeMillis();
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(186628);
                return;
            }
            String aH = com.tencent.mm.plugin.flash.d.a.aH(textView.getContext(), str);
            Log.i("MicroMsg.FaceFlashManagerData", "updateTipText res:%s tip:%s", str, aH);
            if (!TextUtils.isEmpty(aH)) {
                textView.setText(aH);
            }
            AppMethodBeat.o(186628);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "", new Object[0]);
            AppMethodBeat.o(186628);
        }
    }
}
