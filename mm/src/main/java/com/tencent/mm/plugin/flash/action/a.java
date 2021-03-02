package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Intent;
import android.util.Base64;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.flash.b.a {
    private String dYK;
    private String dYL = "";
    private String packageName;
    private String personId;
    private String sQY;
    private float sXC;
    private String sXD;
    private boolean sXI = false;
    private byte[] sXN;
    private String videoPath = (com.tencent.mm.plugin.flash.a.wHI + Util.currentTicks() + ".mp4");
    private String wHU = (com.tencent.mm.plugin.flash.a.wHI + Util.currentTicks() + "_encrypt");
    private String wHV = "";
    private int wHW = 0;
    private long wHX = 0;

    public a() {
        AppMethodBeat.i(186527);
        AppMethodBeat.o(186527);
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void h(Intent intent, Activity activity) {
        AppMethodBeat.i(186528);
        super.h(intent, activity);
        this.packageName = intent.getStringExtra("package");
        this.dYK = intent.getStringExtra("packageSign");
        this.sXI = intent.getBooleanExtra("needContract", false);
        this.dYL = intent.getStringExtra("otherVerifyTitle");
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[%s]intent data, packageName:%s packageSign:%s needSignContract:%s otherVerifyTitle:%s", getClass().getSimpleName(), this.packageName, this.dYK, Boolean.valueOf(this.sXI), this.dYL);
        AppMethodBeat.o(186528);
    }

    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dKV() {
        return 16;
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void release() {
        AppMethodBeat.i(186529);
        super.release();
        g.azz().b(2696, this);
        g.azz().b(2726, this);
        s.deleteFile(this.videoPath);
        s.deleteFile(this.wHU);
        AppMethodBeat.o(186529);
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void onNetworkRequestEvent(String str, String str2, HashMap<String, String> hashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        AppMethodBeat.i(186530);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", str, str2, hashMap);
        this.wIj = iYtSDKKitNetResponseParser;
        if (str.contains("wechat_face_config")) {
            b.axn("reqCfg");
            dKZ();
            com.tencent.mm.plugin.flash.c.a.MS(16);
            com.tencent.mm.plugin.facedetectaction.a.a aVar = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dYK);
            g.azz().a(2696, this);
            g.azz().a(aVar, 0);
            AppMethodBeat.o(186530);
            return;
        }
        if (str.contains("wechat_face_verify")) {
            try {
                dLa();
                com.tencent.mm.plugin.flash.c.a.MT(16);
                String optString = new JSONObject(str2).optString("action_video");
                s.deleteFile(this.videoPath);
                s.deleteFile(this.wHU);
                String str3 = this.videoPath;
                byte[] decode = Base64.decode(optString, 0);
                s.f(str3, decode, decode.length);
                String bhK = s.bhK(this.videoPath);
                Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "MD5ForSignatureString：%s", bhK);
                byte[] bytes = bhK.getBytes();
                PByteArray pByteArray = new PByteArray();
                if (d.INSTANCE.a(1, bytes, 0, bytes.length, pByteArray)) {
                    this.sXN = pByteArray.value;
                } else {
                    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "digitalSignature failed");
                    this.sXN = bytes;
                }
                ae(this.personId, this.videoPath, this.wHU);
                s.deleteFile(this.videoPath);
                axj(this.wHU);
                AppMethodBeat.o(186530);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "action parse verify body error!!!", new Object[0]);
            }
        }
        AppMethodBeat.o(186530);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.flash.b.a
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4 = 1;
        AppMethodBeat.i(186531);
        if (qVar instanceof com.tencent.mm.plugin.facedetectaction.a.a) {
            b.s("rspCfg", Integer.valueOf(i3));
            this.wHW++;
            g.azz().b(2696, this);
            com.tencent.mm.plugin.facedetectaction.a.a aVar = (com.tencent.mm.plugin.facedetectaction.a.a) qVar;
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction1 errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            b.dLj().eqT = i3;
            this.wHX = System.currentTimeMillis();
            if (i2 == 0 && i3 == 0) {
                bnf bnf = aVar.sXg;
                Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction2, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", Integer.valueOf(bnf.pTZ), bnf.pUa, bnf.action_data, Float.valueOf(bnf.LVN), bnf.LjH);
                if (bnf.pTZ == 0) {
                    this.personId = bnf.person_id;
                    this.sQY = bnf.action_data;
                    this.sXC = bnf.LVN;
                    this.sXD = bnf.LjH;
                    Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "[cgi-ret]NetSceneGetFaceCheckAction2 personId:%s actionData:%s reductionRatio:%s", this.personId, this.sQY, Float.valueOf(this.sXC));
                    switch (Util.getInt(this.sQY, -1)) {
                        case 1:
                        case 3:
                            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "user check blink eye");
                            this.wHV = com.tencent.mm.cb.a.aI(this.activity, R.string.c41);
                            break;
                        case 2:
                        case 4:
                        default:
                            i4 = -1;
                            break;
                        case 5:
                            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "user check open month");
                            this.wHV = com.tencent.mm.cb.a.aI(this.activity, R.string.c42);
                            i4 = 2;
                            break;
                    }
                    if (i4 == -1) {
                        A(-1, "", "get action data error 1");
                        AppMethodBeat.o(186531);
                        return;
                    }
                    String valueOf = String.valueOf(i4);
                    HashMap<String, String> hashMap = new HashMap<>();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errorcode", 0);
                        jSONObject.put("errormsg", "OK");
                        jSONObject.put("type", 1);
                        jSONObject.put("action_data", valueOf);
                        hashMap.put("response", jSONObject.toString());
                    } catch (JSONException e2) {
                    }
                    this.wIj.onNetworkResponseEvent(hashMap, null);
                    AppMethodBeat.o(186531);
                    return;
                }
                A(bnf.pTZ, bnf.pUa, "get action data error 2");
                AppMethodBeat.o(186531);
                return;
            }
            A(i3, str, "get action data error 3");
            AppMethodBeat.o(186531);
            return;
        }
        if (qVar instanceof com.tencent.mm.plugin.facedetectaction.a.b) {
            g.azz().b(2726, this);
            bnh bnh = ((com.tencent.mm.plugin.facedetectaction.a.b) qVar).sXi;
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "get face check result, ret_code: %s, ret_msg: %s serialId:%s retry:%s", Integer.valueOf(bnh.pTZ), bnh.pUa, bnh.LVU, Integer.valueOf(bnh.LVT));
            b.s("rspVerify", Integer.valueOf(bnh.pTZ));
            b.dLj().eqV = bnh.pTZ;
            HashMap<String, String> hashMap2 = new HashMap<>();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("countFace", this.wHW);
                jSONObject2.put("err_code", bnh.pTZ);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.plugin.flash.c.a.MU(16);
                    jSONObject2.put("errorcode", bnh.pTZ);
                    jSONObject2.put("error_code", bnh.pTZ);
                    jSONObject2.put("errormsg", bnh.pUa);
                    jSONObject2.put("err_msg", "ok");
                    jSONObject2.put("token", bnh.LpC);
                    jSONObject2.put("serial_id", bnh.LVU);
                    jSONObject2.put("scene", this.scene);
                    if (bnh.pTZ != 0) {
                        jSONObject2.put("err_retry", bnh.LVT);
                        jSONObject2.put("err_tip", bnh.pUa);
                        jSONObject2.put("err_msg", "fail");
                    }
                    hashMap2.put("response", jSONObject2.toString());
                    this.wIj.onNetworkResponseEvent(hashMap2, null);
                } else {
                    com.tencent.mm.plugin.flash.c.a.MV(16);
                    jSONObject2.put("errorcode", i3);
                    jSONObject2.put("error_code", i3);
                    jSONObject2.put("errormsg", bnh.pUa);
                    jSONObject2.put("otherVerifyTitle", this.dYL);
                    jSONObject2.put("err_code", i3);
                    jSONObject2.put("err_retry", bnh.LVT);
                    jSONObject2.put("err_msg", "fail");
                    hashMap2.put("response", jSONObject2.toString());
                    this.wIj.onNetworkResponseEvent(hashMap2, null);
                }
            } catch (JSONException e3) {
            }
        }
        AppMethodBeat.o(186531);
    }

    @Override // com.tencent.mm.plugin.flash.b.a, com.tencent.mm.i.g.a
    public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
        AppMethodBeat.i(186532);
        Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
        int i3 = dVar == null ? -1 : dVar.field_retCode;
        b.s("rspCdn", Integer.valueOf(i3));
        b.dLj().eqU = i3;
        b.dLj().eqW = System.currentTimeMillis() - this.sXP;
        if (dVar != null && dVar.field_retCode == 0) {
            Log.i("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: upload video done. now upload");
            s.deleteFile(this.wHU);
            b.axn("reqVerify");
            com.tencent.mm.plugin.facedetectaction.a.b bVar = new com.tencent.mm.plugin.facedetectaction.a.b(this.personId, this.sQY, this.sXC, dVar.field_fileId, dVar.field_aesKey, this.scene, this.sXD, this.packageName, this.sXN, this.sXI);
            g.azz().a(2726, this);
            g.azz().a(bVar, 0);
            b.dLj().eqX = System.currentTimeMillis() - this.wHX;
        } else if (dVar != null) {
            Log.w("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            s.deleteFile(this.wHU);
            AppMethodBeat.o(186532);
            return 0;
        } else if (i2 != 0) {
            Log.w("MicroMsg.FaceFlashManager.FaceFlashActionManager", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            AppMethodBeat.o(186532);
            return 0;
        }
        AppMethodBeat.o(186532);
        return 0;
    }

    private void A(int i2, String str, String str2) {
        AppMethodBeat.i(186533);
        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorcode", i2);
            jSONObject.put("errormsg", str);
            jSONObject.put("err_code", i2);
            jSONObject.put("otherVerifyTitle", this.dYL);
        } catch (JSONException e2) {
        }
        hashMap.put("response", jSONObject.toString());
        this.wIj.onNetworkResponseEvent(hashMap, null);
        Log.e("MicroMsg.FaceFlashManagerError", str2);
        AppMethodBeat.o(186533);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void ae(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flash.action.a.ae(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void r(TextView textView) {
        AppMethodBeat.i(186535);
        textView.setText(this.wHV);
        AppMethodBeat.o(186535);
    }
}
