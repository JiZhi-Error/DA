package com.tencent.mm.plugin.flash.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    private static JSONObject a(JSONObject jSONObject, int i2, String str) {
        AppMethodBeat.i(186649);
        JSONObject jSONObject2 = new JSONObject();
        switch (i2) {
            case 2:
                jSONObject2.put("face_image", YTAGFaceReflectForWXJNIInterface.verifyDataToJpg(str, jSONObject.getJSONObject("livedata").getJSONArray("frames").getJSONObject(0).getString("image")));
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < 90; i3 = i3 + 1 + 1) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("x", 0);
                    jSONObject3.put("y", 0);
                    jSONArray.put(jSONObject3);
                }
                jSONObject2.put("coordinate_list", jSONArray);
                break;
            case 3:
                jSONObject2.put("face_image", YTAGFaceReflectForWXJNIInterface.verifyDataToJpg(str, jSONObject.getJSONObject("live_image").getString("image")));
                JSONArray jSONArray2 = jSONObject.getJSONObject("live_image").getJSONArray("five_points");
                JSONArray jSONArray3 = new JSONArray();
                for (int i4 = 0; i4 < jSONArray2.length(); i4 = i4 + 1 + 1) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("x", (double) Float.parseFloat(String.valueOf(jSONArray2.get(i4))));
                    jSONObject4.put("y", (double) Float.parseFloat(String.valueOf(jSONArray2.get(i4 + 1))));
                    jSONArray3.put(jSONObject4);
                }
                jSONObject2.put("coordinate_list", jSONArray3);
                break;
        }
        AppMethodBeat.o(186649);
        return jSONObject2;
    }

    private static byte[] m(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186650);
        byte[] ho = ho(str, jSONObject.toString());
        AppMethodBeat.o(186650);
        return ho;
    }

    private static byte[] ho(String str, String str2) {
        AppMethodBeat.i(186651);
        byte[] encrypt = YTAGFaceReflectForWXJNIInterface.encrypt(str, str2, (long) str2.getBytes().length);
        AppMethodBeat.o(186651);
        return encrypt;
    }

    public static byte[] p(String str, byte[] bArr) {
        AppMethodBeat.i(186652);
        JSONObject jSONObject = new JSONObject();
        String faceMd5 = YTAGFaceReflectForWXJNIInterface.faceMd5(bArr, (long) bArr.length);
        jSONObject.put("face_lib_version", 3);
        jSONObject.put("md5", faceMd5);
        Log.i("MicroMsg.FaceFlashDataUtil", "getBioHeader md5:%s", faceMd5);
        byte[] ho = ho(str, jSONObject.toString());
        AppMethodBeat.o(186652);
        return ho;
    }

    public static byte[] j(JSONObject jSONObject, String str) {
        AppMethodBeat.i(186653);
        JSONObject jSONObject2 = jSONObject.getJSONObject("livedata");
        jSONObject2.put("time_point_list", new JSONArray());
        JSONArray jSONArray = jSONObject2.getJSONArray("frames");
        jSONObject2.remove("frames");
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("face_image", jSONObject3.get("image"));
            JSONArray jSONArray3 = jSONObject3.getJSONArray("x_coordinates");
            JSONArray jSONArray4 = jSONObject3.getJSONArray("y_coordinates");
            JSONArray jSONArray5 = new JSONArray();
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("x", jSONArray3.get(i3));
                jSONObject5.put("y", jSONArray4.get(i3));
                jSONArray5.put(jSONObject5);
            }
            jSONObject4.put("coordinate_list", jSONArray5);
            jSONArray2.put(jSONObject4);
        }
        jSONObject2.put("face_live_pic_list_new", jSONArray2);
        if (jSONObject2.has("select_data")) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("select_data", jSONObject2.optJSONObject("select_data").toString());
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("onetwinkle_data", jSONObject6);
            jSONObject2.put("livedata", jSONObject7);
        }
        String string = jSONArray.getJSONObject(0).getString("image");
        String string2 = jSONObject2.getString("mouth_lip_reading");
        JSONArray jSONArray6 = new JSONArray();
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("face_image", FaceProNative.addVerifyData2Jpg(str, string2, string));
        jSONObject8.put("coordinate_list", jSONArray2.getJSONObject(0).get("coordinate_list"));
        jSONArray6.put(jSONObject8);
        jSONObject2.put("face_frame_list", jSONArray6);
        byte[] m = m(str, jSONObject2);
        AppMethodBeat.o(186653);
        return m;
    }

    public static String f(String str, String str2, String str3, int i2) {
        JSONObject jSONObject;
        AppMethodBeat.i(186654);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            mn mnVar = new mn();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_id", str3);
            jSONObject3.put("business_name", "");
            jSONObject3.put("person_id", "");
            jSONObject3.put("live_type", i2);
            jSONObject3.put("req_type", WeChatBrands.Business.GROUP_LIVE);
            JSONObject jSONObject4 = new JSONObject();
            switch (i2) {
                case 2:
                    jSONObject = jSONObject2.getJSONObject("livedata");
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                        Log.e("MicroMsg.FaceFlashManagerError", "LIVE_REFLECTION does not have livedata");
                    }
                    if (jSONObject.has("select_data")) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("select_data", jSONObject.optJSONObject("select_data").toString());
                        jSONObject.put("onetwinkle_data", jSONObject5);
                        break;
                    }
                    break;
                case 3:
                    jSONObject = new JSONObject();
                    jSONObject.put("reflect_data", jSONObject2.optJSONObject("reflect_data"));
                    jSONObject.put("color_data", jSONObject2.optString("color_data"));
                    jSONObject.put(TPDownloadProxyEnum.USER_PLATFORM, 2);
                    jSONObject4.put("live_image", jSONObject2.optJSONObject("live_image"));
                    jSONObject4.put("eye_image", jSONObject2.optJSONObject("eye_image"));
                    jSONObject4.put("mouth_image", jSONObject2.optJSONObject("mouth_image"));
                    jSONObject4.put("action_video", jSONObject2.getString("action_video"));
                    jSONObject4.put("select_data", jSONObject2.optJSONObject("select_data").toString());
                    jSONObject.put("onetwinkle_data", jSONObject4);
                    break;
                default:
                    jSONObject = new JSONObject();
                    break;
            }
            jSONObject3.put("livedata", jSONObject);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(a(jSONObject2, i2, str2));
            jSONObject3.put("face_frame_list", jSONArray);
            byte[] m = m(str2, jSONObject3);
            mnVar.KQJ = b.cD(m);
            mnVar.KQI = b.cD(p(str2, m));
            String cTn = p.cTn();
            p.e(mnVar.toByteArray(), cTn);
            Log.i("MicroMsg.FaceFlashDataUtil", "save verify result to file:%s  fileSize:%s", cTn, Long.valueOf(s.boW(cTn)));
            AppMethodBeat.o(186654);
            return cTn;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", e2, "reflect get yt result data error", new Object[0]);
            AppMethodBeat.o(186654);
            return "";
        }
    }
}
