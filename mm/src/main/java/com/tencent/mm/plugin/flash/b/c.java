package com.tencent.mm.plugin.flash.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    public com.tencent.mm.plugin.facedetect.d.a sSq = new com.tencent.mm.plugin.facedetect.d.a();
    public String wIt = "";

    public interface a {
        void j(com.tencent.mm.plugin.facedetect.d.a aVar);
    }

    public c() {
        AppMethodBeat.i(186633);
        AppMethodBeat.o(186633);
    }

    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dKV() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dLb() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dLc() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.flash.b.a
    public final String axi(String str) {
        AppMethodBeat.i(186634);
        try {
            JSONObject jSONObject = new JSONObject(str);
            mn mnVar = new mn();
            byte[] j2 = f.j(jSONObject, String.valueOf(this.sQI));
            mnVar.KQJ = b.cD(j2);
            mnVar.KQI = b.cD(f.p(String.valueOf(this.sQI), j2));
            String cTn = p.cTn();
            p.e(mnVar.toByteArray(), cTn);
            Log.i("MicroMsg.FaceFlashManagerNumber", "save verify result to file:%s  fileSize:%s", cTn, Long.valueOf(s.boW(cTn)));
            AppMethodBeat.o(186634);
            return cTn;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "number get yt result data error", new Object[0]);
            AppMethodBeat.o(186634);
            return "";
        }
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.flash.b.a
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(186635);
        if ((qVar instanceof u) || (qVar instanceof v)) {
            Log.i("MicroMsg.FaceFlashManagerNumber", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.wIr = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(i3));
            com.tencent.mm.plugin.flash.c.b.dLi().erf = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.dLi().eqT = i3;
            HashMap<String, String> hashMap = new HashMap<>();
            JSONObject jSONObject = new JSONObject();
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.facedetect.b.b bVar = (com.tencent.mm.plugin.facedetect.b.b) qVar;
                this.sQI = bVar.cSK();
                String decrypt = YTAGFaceReflectForWXJNIInterface.decrypt(new StringBuilder().append(this.sQI).toString(), bVar.cSL(), (long) bVar.cSL().length);
                Log.i("MicroMsg.FaceFlashManagerNumber", "mBioId:%s decryptConfig:%s", Long.valueOf(this.sQI), decrypt);
                try {
                    jSONObject.put("errorcode", 0);
                    jSONObject.put("errormsg", "OK");
                    jSONObject.put("type", 1);
                    JSONArray optJSONArray = new JSONObject(decrypt).optJSONArray("face_action_seq");
                    if (optJSONArray != null) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            if (optJSONObject != null && optJSONObject.optInt("action_id", 0) == 4) {
                                this.wIt = optJSONObject.optString("action_data");
                                String replaceAll = this.wIt.replaceAll("(.)", "$1,");
                                jSONObject.put("action_data", replaceAll.substring(0, replaceAll.length() - 1));
                            }
                        }
                    }
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "reflect get config error", new Object[0]);
                }
            } else {
                Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
                try {
                    jSONObject.put("errorcode", -1);
                    jSONObject.put("errormsg", "WeChat face get config error!");
                    jSONObject.put("err_feedback", this.wIm);
                    jSONObject.put("err_msg", com.tencent.mm.cb.a.aI(this.activity, R.string.net_fetch_failed));
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e3, "reflect get config error2", new Object[0]);
                }
            }
            hashMap.put("response", jSONObject.toString());
            Log.i("MicroMsg.FaceFlashManagerNumber", "set ytsdk number config:%s", hashMap);
            this.wIj.onNetworkResponseEvent(hashMap, null);
            AppMethodBeat.o(186635);
            return;
        }
        super.onSceneEnd(i2, i3, str, qVar);
        AppMethodBeat.o(186635);
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(186636);
        Log.i("MicroMsg.FaceFlashManagerNumber", JsApiStartRecordVoice.NAME);
        this.sSq.ap(new Runnable() {
            /* class com.tencent.mm.plugin.flash.b.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186632);
                aVar.j(c.this.sSq);
                AppMethodBeat.o(186632);
            }
        });
        AppMethodBeat.o(186636);
    }

    public final void stopRecord() {
        AppMethodBeat.i(186637);
        Log.i("MicroMsg.FaceFlashManagerNumber", JsApiStopRecordVoice.NAME);
        this.sSq.stopRecord();
        this.sSq.recycle();
        this.sSq.c(com.tencent.mm.plugin.facedetect.e.a.cTF().cTG());
        AppMethodBeat.o(186637);
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void reset() {
        AppMethodBeat.i(186638);
        Log.i("MicroMsg.FaceFlashManagerNumber", "reset");
        stopRecord();
        this.sSq.recycle();
        this.sSq.clearDiskCache();
        this.sSq = new com.tencent.mm.plugin.facedetect.d.a();
        AppMethodBeat.o(186638);
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void release() {
        AppMethodBeat.i(186639);
        Log.i("MicroMsg.FaceFlashManagerNumber", "release");
        super.release();
        this.sSq.recycle();
        this.sSq.clearDiskCache();
        AppMethodBeat.o(186639);
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void r(TextView textView) {
        AppMethodBeat.i(186640);
        textView.setText(com.tencent.mm.cb.a.aI(textView.getContext(), R.string.c6_));
        AppMethodBeat.o(186640);
    }
}
