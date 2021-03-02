package com.tencent.mm.plugin.topstory.a;

import android.os.Build;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wxmm.v2helper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    public static final eiy hJ(List<eiy> list) {
        AppMethodBeat.i(90973);
        for (eiy eiy : list) {
            if (!(eiy == null || Util.isNullOrNil(eiy.url))) {
                AppMethodBeat.o(90973);
                return eiy;
            }
        }
        AppMethodBeat.o(90973);
        return null;
    }

    public static final eit a(fat fat, int i2, String str) {
        AppMethodBeat.i(90974);
        eit eit = new eit();
        eit.sGQ = UUID.randomUUID().toString();
        eit.Nic = new eiw();
        eit.Nic.title = fat.msN;
        eit.Nic.wWb = "video-" + fat.IEy;
        eit.Nic.psI = fat.IEy;
        eit.Nic.Nio = fat.thumbUrl;
        if (Util.isNullOrNil(eit.Nic.Nio)) {
            eit.Nic.Nio = "http://shp.qpic.cn/qqvideo_ori/0/" + fat.IEy + String.format("_%s_%s/0", Integer.valueOf((int) m.CTRL_INDEX), 280);
        }
        eit.Nic.IEG = fat.IEG;
        eit.Nic.source = fat.source;
        eit.Nic.eby = fat.eby;
        eit.Nic.Nir = fat.IEz;
        eit.Nic.Nit = fat.IEz;
        eit.Nic.IEE = fat.IEE;
        if (fat.IEK == 100203) {
            eit.Nic.thumbWidth = v2helper.VOIP_ENC_HEIGHT_LV1;
            eit.Nic.thumbHeight = 640;
        } else {
            eit.Nic.thumbWidth = m.CTRL_INDEX;
            eit.Nic.thumbHeight = 280;
        }
        eit.Nic.timestamp = System.currentTimeMillis();
        if (!Util.isNullOrNil(fat.IEJ)) {
            try {
                JSONArray jSONArray = new JSONArray(fat.IEJ);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    dyi dyi = new dyi();
                    dyi.id = jSONObject.optString("id");
                    dyi.dQx = jSONObject.optString("wording");
                    dyi.MXW = jSONObject.optLong("category");
                    dyi.actionType = jSONObject.optInt("actionType");
                    dyi.url = jSONObject.optString("url");
                    dyi.title = jSONObject.optString("title");
                    dyi.oqZ = jSONObject.optString("subTitle");
                    dyi.icon = jSONObject.optString("icon");
                    eit.Nic.xuO.add(dyi);
                }
            } catch (Exception e2) {
            }
        }
        eit.NhX = fat.IEy;
        eit.NhY = fat.IEz;
        eit.NhZ = fat.IEA;
        eit.Nia = fat.IEB;
        eit.Nib = fat.IEK;
        if (eit.Nib <= 0) {
            eit.Nib = 100201;
        }
        eit.Nie = false;
        if (!Util.isNullOrNil(fat.IEI)) {
            q(eit.IDO, fat.IEI);
        }
        eit.hes = "";
        eit.scene = i2;
        eit.dDv = str;
        if (!Util.isNullOrNil(fat.IEL)) {
            eit.Nid = new dyi();
            eit.Nid.title = fat.IEL;
        }
        AppMethodBeat.o(90974);
        return eit;
    }

    public static final eit br(JSONObject jSONObject) {
        AppMethodBeat.i(90975);
        eit eit = new eit();
        eit.dDv = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
        eit.scene = jSONObject.optInt("scene", 21);
        eit.sGQ = UUID.randomUUID().toString();
        eit.NhZ = jSONObject.optString("searchId", "");
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext()) && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            eit.Nie = true;
        }
        String optString = jSONObject.optString("videoId", "");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("videoUrls", ""));
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    eiy eiy = new eiy();
                    eiy.url = jSONArray.getString(i2);
                    arrayList.add(eiy);
                }
            }
        } catch (JSONException e2) {
        }
        if (!Util.isNullOrNil(optString)) {
            eit.Nic = new eiw();
            eit.Nic.title = jSONObject.optString("title", "");
            eit.Nic.Nio = jSONObject.optString("thumbUrl", "");
            eit.Nic.Eso = jSONObject.optInt("mediaDuration", 0);
            eit.Nic.psI = optString;
            eit.Nic.IEG = jSONObject.optString("strPlayCount", "");
            eit.Nic.rCq = jSONObject.optString("shareUrl", "");
            eit.Nic.msN = jSONObject.optString("shareTitle", "");
            eit.Nic.IEH = jSONObject.optString("titleUrl", "");
            eit.Nic.xDQ = jSONObject.optString("shareDesc", "");
            eit.Nic.IED = jSONObject.optString("shareImgUrl", "");
            eit.Nic.IEE = jSONObject.optString("shareString", "");
            eit.Nic.IEF = jSONObject.optString("shareStringUrl", "");
            eit.Nic.source = jSONObject.optString("source", "");
            eit.Nic.eby = jSONObject.optString("sourceUrl", "");
            eit.Nic.Nip = (long) jSONObject.optInt("relevant_category", -1);
            eit.Nic.Niq = jSONObject.optString("shareOpenId", "");
            eit.Nic.wWb = jSONObject.optString("docID", "");
            eit.Nic.Niv = (long) jSONObject.optInt("videoSize", 0);
            eit.Nic.timestamp = Util.currentTicks();
            eit.Nic.Nis = jSONObject.optInt("itemType", 0);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("block", ""));
                eit.Nic.Niu = jSONObject2.optLong("resultType");
                eit.Nic.dDw = jSONObject2.optLong("type");
            } catch (JSONException e3) {
            }
            eit.Nic.Nir = jSONObject.optString("expand", "");
            eit.Nic.Niw.addAll(arrayList);
            eiy hJ = hJ(arrayList);
            if (hJ != null) {
                eit.Nic.videoUrl = hJ.url;
                eit.Nic.NiF = hJ.NiF;
            }
            if (Util.isNullOrNil(eit.Nic.Nio)) {
                eit.Nic.Nio = "http://shp.qpic.cn/qqvideo_ori/0/" + eit.Nic.psI + String.format("_%s_%s/0", Integer.valueOf((int) m.CTRL_INDEX), 280);
            }
            String optString2 = jSONObject.optString("tagList", "");
            if (!Util.isNullOrNil(optString2)) {
                try {
                    eit.Nic.xuO.addAll(I(new JSONArray(optString2)));
                } catch (Exception e4) {
                }
            }
            if (!jSONObject.optBoolean("not_show_feedback", false)) {
                eit.Nic.NiE = new eiu();
                JSONObject optJSONObject = jSONObject.optJSONObject("feedbackObj");
                if (optJSONObject != null) {
                    eit.Nic.NiE.Nil = optJSONObject.optString("detailWording");
                    eit.Nic.NiE.Nim = optJSONObject.optString("detailUrl");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("feedbackData");
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            any any = new any();
                            any.id = optJSONArray.optJSONObject(i3).optString("id", "");
                            any.dQx = optJSONArray.optJSONObject(i3).optString("wording", "");
                            eit.Nic.NiE.Nin.add(any);
                        }
                    }
                }
            }
            String optString3 = jSONObject.optString("show_tag_list", "");
            if (!Util.isNullOrNil(optString3)) {
                try {
                    eit.Nic.xuO.addAll(I(new JSONArray(optString3)));
                } catch (JSONException e5) {
                }
            }
            eit.Nib = eit.Nic.Nip;
            eit.NhY = jSONObject.optString("expand", "");
            eit.hes = "";
            eit.NhX = eit.Nic.psI;
            eit.Nic.Nix = jSONObject.optInt("switchFlag", 0);
            eit.Nic.NiC = jSONObject.optJSONObject("colikeInfo") != null && jSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb");
            eit.Nic.NiD = jSONObject.optJSONObject("colikeInfo") != null ? jSONObject.optJSONObject("colikeInfo").optString("byPass", "") : "";
            if (eit.Nib == 100203) {
                eit.Nic.thumbWidth = v2helper.VOIP_ENC_HEIGHT_LV1;
                eit.Nic.thumbHeight = 640;
            } else {
                eit.Nic.thumbWidth = m.CTRL_INDEX;
                eit.Nic.thumbHeight = 280;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("secondVideoInfo");
            if (optJSONObject2 != null) {
                eit.Nic.Niz = new eir();
                eit.Nic.Niz.NhR = optJSONObject2.optInt("videoSecondType");
                eit.Nic.Niz.NhT = optJSONObject2.optInt("requestDuration");
                eit.Nic.Niz.NhU = optJSONObject2.optInt("requestPercent");
            }
            String optString4 = jSONObject.optString("videoChannelTitle", "");
            if (!Util.isNullOrNil(optString4) && (eit.Nib == 100202 || eit.Nib == 100204 || eit.Nib == 100205)) {
                eit.Nid = new dyi();
                eit.Nid.title = optString4;
            }
            String optString5 = jSONObject.optString("extReqParams", "");
            if (!Util.isNullOrNil(optString5)) {
                try {
                    JSONArray jSONArray2 = new JSONArray(optString5);
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                        aca aca = new aca();
                        aca.key = jSONObject3.optString("key", "");
                        aca.LmC = (long) jSONObject3.optInt("uintValue", 0);
                        aca.LmD = jSONObject3.optString("textValue", "");
                        eit.IDO.add(aca);
                    }
                } catch (Exception e6) {
                }
            }
            eit.Nii = jSONObject.optString("preNetType", "");
            if (eit.Nii.equals("wangka")) {
                eit.Nij = 1;
            } else if (eit.Nii.equals("2g") || eit.Nii.equals("3g") || eit.Nii.equals("4g")) {
                eit.Nij = 2;
            } else {
                eit.Nij = 0;
            }
        }
        AppMethodBeat.o(90975);
        return eit;
    }

    public static final eit aU(Map<String, Object> map) {
        AppMethodBeat.i(90976);
        eit eit = new eit();
        eit.dDv = ai.N(map, SearchIntents.EXTRA_QUERY);
        eit.scene = ai.b(map, "scene", 21);
        eit.sGQ = UUID.randomUUID().toString();
        eit.hes = ai.N(map, "searchId");
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext()) && !NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            eit.Nie = true;
        }
        String N = ai.N(map, "videoId");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(ai.N(map, "videoUrls"));
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    eiy eiy = new eiy();
                    eiy.url = jSONArray.getString(i2);
                    arrayList.add(eiy);
                }
            }
        } catch (JSONException e2) {
        }
        if (!Util.isNullOrNil(N)) {
            eit.Nic = new eiw();
            eit.Nic.title = ai.N(map, "title");
            eit.Nic.Nio = ai.N(map, "thumbUrl");
            eit.Nic.Eso = ai.b(map, "mediaDuration", 0);
            eit.Nic.psI = N;
            eit.Nic.IEG = ai.N(map, "strPlayCount");
            eit.Nic.rCq = ai.N(map, "shareUrl");
            eit.Nic.msN = ai.N(map, "shareTitle");
            eit.Nic.IEH = ai.N(map, "titleUrl");
            eit.Nic.xDQ = ai.N(map, "shareDesc");
            eit.Nic.IED = ai.N(map, "shareImgUrl");
            eit.Nic.IEE = ai.N(map, "shareString");
            eit.Nic.IEF = ai.N(map, "shareStringUrl");
            eit.Nic.source = ai.N(map, "source");
            eit.Nic.eby = ai.N(map, "sourceUrl");
            eit.Nic.Nip = ai.a(map, "relevant_category", -1);
            eit.Nic.Niq = ai.N(map, "shareOpenId");
            eit.Nic.wWb = ai.N(map, "docID");
            eit.Nic.Niv = ai.a(map, "videoSize", 0);
            eit.Nic.timestamp = Util.currentTicks();
            eit.Nic.Nis = ai.b(map, "itemType", 0);
            eit.Nic.Nix = ai.b(map, "switchFlag", 0);
            if (Util.isNullOrNil(eit.Nic.Nio)) {
                eit.Nic.Nio = "http://shp.qpic.cn/qqvideo_ori/0/" + eit.Nic.psI + String.format("_%s_%s/0", Integer.valueOf((int) m.CTRL_INDEX), 280);
            }
            try {
                JSONObject jSONObject = new JSONObject(ai.N(map, "block"));
                eit.Nic.Niu = jSONObject.optLong("resultType");
                eit.Nic.dDw = jSONObject.optLong("type");
            } catch (JSONException e3) {
            }
            eit.Nic.Nir = ai.N(map, "expand");
            eit.Nic.Niw.addAll(arrayList);
            eiy hJ = hJ(arrayList);
            if (hJ != null) {
                eit.Nic.videoUrl = hJ.url;
                eit.Nic.NiF = hJ.NiF;
            }
            String N2 = ai.N(map, "show_tag_list");
            if (!Util.isNullOrNil(N2)) {
                try {
                    eit.Nic.xuO.addAll(I(new JSONArray(N2)));
                } catch (JSONException e4) {
                }
            }
            eit.Nib = eit.Nic.Nip;
            eit.NhY = ai.N(map, "expand");
            eit.NhZ = eit.hes;
            eit.NhX = eit.Nic.psI;
            if (eit.Nib == 100203) {
                eit.Nic.thumbWidth = v2helper.VOIP_ENC_HEIGHT_LV1;
                eit.Nic.thumbHeight = 640;
            } else {
                eit.Nic.thumbWidth = m.CTRL_INDEX;
                eit.Nic.thumbHeight = 280;
            }
            String N3 = ai.N(map, "videoChannelTitle");
            if (!Util.isNullOrNil(eit.Nic.IEE) && (eit.Nib == 100202 || eit.Nib == 100204 || eit.Nib == 100205)) {
                eit.Nid = new dyi();
                eit.Nid.title = N3;
            }
            String N4 = ai.N(map, "extReqParams");
            if (!Util.isNullOrNil(N4)) {
                try {
                    JSONArray jSONArray2 = new JSONArray(N4);
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                        aca aca = new aca();
                        aca.key = jSONObject2.optString("key", "");
                        aca.LmC = (long) jSONObject2.optInt("uintValue", 0);
                        aca.LmD = jSONObject2.optString("textValue", "");
                        eit.IDO.add(aca);
                    }
                } catch (Exception e5) {
                }
            }
        }
        AppMethodBeat.o(90976);
        return eit;
    }

    public static final eit a(eit eit) {
        AppMethodBeat.i(90977);
        eit eit2 = new eit();
        eit2.sGQ = eit.sGQ;
        eit2.scene = eit.scene;
        eit2.dDv = eit.dDv;
        eit2.hes = eit.hes;
        eit2.Nic = eit.Nic;
        eit2.Nib = eit.Nib;
        eit2.NhY = eit.NhY;
        eit2.NhZ = eit.NhZ;
        eit2.Nia = eit.Nia;
        eit2.NhX = eit.NhX;
        eit2.IDO.addAll(eit.IDO);
        eit2.guh = eit.guh;
        eit2.Nii = eit.Nii;
        eit2.Nij = eit.Nij;
        AppMethodBeat.o(90977);
        return eit2;
    }

    public static String fxQ() {
        AppMethodBeat.i(90978);
        String str = MMApplicationContext.getContext().getCacheDir() + "/topstory/";
        AppMethodBeat.o(90978);
        return str;
    }

    public static String aTv(String str) {
        AppMethodBeat.i(90979);
        String str2 = MMApplicationContext.getContext().getCacheDir() + "/topstory/" + str + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(90979);
        return str2;
    }

    public static boolean fxR() {
        AppMethodBeat.i(90980);
        if (1 >= Log.getLogLevel()) {
            AppMethodBeat.o(90980);
            return true;
        }
        AppMethodBeat.o(90980);
        return false;
    }

    public static JSONArray hK(List<dyi> list) {
        AppMethodBeat.i(90981);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                JSONObject jSONObject = new JSONObject();
                dyi dyi = list.get(i2);
                jSONObject.put("id", dyi.id);
                jSONObject.put("wording", dyi.dQx);
                jSONObject.put("category", dyi.MXW);
                jSONObject.put("actionType", dyi.actionType);
                jSONObject.put("url", dyi.url);
                jSONObject.put("title", dyi.title);
                jSONObject.put("subTitle", dyi.oqZ);
                jSONObject.put("icon", dyi.icon);
                jSONArray.put(jSONObject);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(90981);
        return jSONArray;
    }

    private static List<dyi> I(JSONArray jSONArray) {
        AppMethodBeat.i(90982);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            dyi dyi = new dyi();
            dyi.id = optJSONObject.optString("id", "");
            dyi.dQx = optJSONObject.optString("wording", "");
            dyi.MXW = optJSONObject.optLong("category", 0);
            dyi.actionType = optJSONObject.optInt("actionType", 0);
            dyi.url = optJSONObject.optString("url", "");
            dyi.title = optJSONObject.optString("title", "");
            dyi.oqZ = optJSONObject.optString("subTitle", "");
            dyi.icon = optJSONObject.optString("icon", "");
            arrayList.add(dyi);
        }
        AppMethodBeat.o(90982);
        return arrayList;
    }

    public static String a(int i2, String str, String str2, String str3, String str4, String str5, int i3, int i4, String str6, String str7) {
        AppMethodBeat.i(90983);
        HashMap hashMap = new HashMap();
        if (!Util.isNullOrNil(str4)) {
            hashMap.put("redPointMsgId", str4);
        }
        if (!Util.isNullOrNil(str)) {
            hashMap.put("sessionId", str);
        }
        if (!Util.isNullOrNil(str2)) {
            hashMap.put(SearchIntents.EXTRA_QUERY, str2);
        }
        if (!Util.isNullOrNil(str3)) {
            hashMap.put("requestId", str3);
            hashMap.put("pRequestId", str3);
            hashMap.put("seq", str3);
        }
        if (!Util.isNullOrNil(str7)) {
            hashMap.put("extParams", str7);
        }
        hashMap.put("scene", String.valueOf(i2));
        if (!Util.isNullOrNil(str5)) {
            hashMap.put("tabInfo", str5);
        }
        if (i3 > 0) {
            hashMap.put("contentReddot", String.valueOf(i3));
        }
        if (i4 > 0) {
            hashMap.put("numberReddot", String.valueOf(i4));
        }
        hashMap.put(Scopes.PROFILE, "1");
        if (!Util.isNullOrNil(str6)) {
            hashMap.put("homeMsgId", str6);
        }
        try {
            hashMap.put("deviceName", URLEncoder.encode(d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("ostype", d.KyK);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", e2, "", new Object[0]);
        }
        String n = n(hashMap);
        AppMethodBeat.o(90983);
        return n;
    }

    public static String n(HashMap<String, String> hashMap) {
        AppMethodBeat.i(90984);
        o(hashMap);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(ai.afr(1).fYs());
        stringBuffer.append(FilePathGenerator.ANDROID_DIR_SEP);
        stringBuffer.append("app.html");
        stringBuffer.append("?");
        stringBuffer.append(ai.toUrlParams(hashMap));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(90984);
        return stringBuffer2;
    }

    private static void o(HashMap<String, String> hashMap) {
        AppMethodBeat.i(90985);
        hashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("version", String.valueOf(ai.afr(1).bbw()));
        hashMap.put(DownloadInfo.NETTYPE, ai.ait());
        hashMap.put("isClientLoading", "1");
        hashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
        AppMethodBeat.o(90985);
    }

    public static String fxS() {
        AppMethodBeat.i(90986);
        String str = b.aKC().replace("/data/user/0", "/data/data") + "topstory/homecache/";
        AppMethodBeat.o(90986);
        return str;
    }

    public static String fxT() {
        AppMethodBeat.i(90987);
        String str = b.aKC().replace("/data/user/0", "/data/data") + "topstory/negcache/";
        AppMethodBeat.o(90987);
        return str;
    }

    public static boolean isFreeSimCard() {
        boolean z;
        AppMethodBeat.i(90988);
        int eiV = ((a) g.af(a.class)).eiV();
        switch (eiV) {
            case 3:
            case 4:
            case 5:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        Log.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", Boolean.valueOf(z), Integer.valueOf(eiV));
        AppMethodBeat.o(90988);
        return z;
    }

    public static final void q(List<aca> list, String str) {
        AppMethodBeat.i(90990);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    aca aca = new aca();
                    aca.key = jSONObject.optString("key", "");
                    aca.LmC = (long) jSONObject.optInt("uintValue", 0);
                    aca.LmD = jSONObject.optString("textValue", "");
                    list.add(aca);
                }
                AppMethodBeat.o(90990);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(90990);
    }
}
