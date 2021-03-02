package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.welab.b.c;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public final class e {
    private static DocumentBuilder iHe = null;

    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x03f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.welab.d.a.a bbB(java.lang.String r17) {
        /*
        // Method dump skipped, instructions count: 1096
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.welab.e.bbB(java.lang.String):com.tencent.mm.plugin.welab.d.a.a");
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        AppMethodBeat.i(146230);
        StringBuilder sb = new StringBuilder();
        if (hashMap.containsKey(str)) {
            sb.append(hashMap.get(str)).append(";");
            int i2 = 1;
            while (true) {
                String str2 = str + "_" + i2;
                if (hashMap.containsKey(str2)) {
                    sb.append(hashMap.get(str2)).append(";");
                    i2++;
                } else {
                    String sb2 = sb.toString();
                    AppMethodBeat.o(146230);
                    return sb2;
                }
            }
        } else {
            String sb3 = sb.toString();
            AppMethodBeat.o(146230);
            return sb3;
        }
    }

    public static List<String> bbC(String str) {
        AppMethodBeat.i(146231);
        if (TextUtils.isEmpty(str)) {
            List<String> list = Collections.EMPTY_LIST;
            AppMethodBeat.o(146231);
            return list;
        }
        List<String> asList = Arrays.asList(str.split(";"));
        AppMethodBeat.o(146231);
        return asList;
    }

    private static Element Lf(String str) {
        DocumentBuilder newDocumentBuilder;
        AppMethodBeat.i(146232);
        try {
            InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
            if (iHe != null) {
                newDocumentBuilder = iHe;
            } else {
                newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                iHe = newDocumentBuilder;
            }
            Document parse = newDocumentBuilder.parse(inputSource);
            parse.normalize();
            Element documentElement = parse.getDocumentElement();
            AppMethodBeat.o(146232);
            return documentElement;
        } catch (Exception e2) {
            Log.e("MicroMsg.Welabparser", e2.toString());
            AppMethodBeat.o(146232);
            return null;
        }
    }

    public static a a(c cVar) {
        AppMethodBeat.i(146233);
        a aVar = new a();
        aVar.field_expId = String.valueOf(cVar.sLf);
        aVar.field_sequence = (long) cVar.sLg;
        aVar.field_starttime = cVar.startTime > 0 ? cVar.startTime : System.currentTimeMillis() / 1000;
        aVar.field_endtime = cVar.endTime > 0 ? cVar.endTime : MAlarmHandler.NEXT_FIRE_INTERVAL;
        String str = "xlab_" + cVar.sLf;
        HashMap<String, String> hashMap = cVar.map;
        aVar.field_AllVer = Util.safeParseInt(hashMap.get(hr(str, "AllVer")));
        aVar.field_BizType = Util.safeParseInt(hashMap.get(hr(str, "BizType")));
        aVar.field_Desc_cn = hashMap.get(hr(str, "Desc_cn"));
        aVar.field_Desc_en = hashMap.get(hr(str, "Desc_en"));
        aVar.field_Desc_hk = hashMap.get(hr(str, "Desc_hk"));
        aVar.field_Desc_tw = hashMap.get(hr(str, "Desc_tw"));
        aVar.field_DetailURL = hashMap.get(hr(str, "DetailURL"));
        aVar.field_Introduce_cn = hashMap.get(hr(str, "Introduce_cn"));
        aVar.field_Introduce_en = hashMap.get(hr(str, "Introduce_en"));
        aVar.field_Introduce_hk = hashMap.get(hr(str, "Introduce_hk"));
        aVar.field_Introduce_tw = hashMap.get(hr(str, "Introduce_tw"));
        aVar.field_Pos = Util.safeParseInt(hashMap.get(hr(str, "Pos")));
        aVar.field_Type = Util.safeParseInt(hashMap.get(hr(str, "Type")));
        aVar.field_Switch = Util.safeParseInt(hashMap.get(hr(str, "Switch")));
        aVar.field_WeAppPath = hashMap.get(hr(str, "WeAppPath"));
        aVar.field_WeAppUser = hashMap.get(hr(str, "WeAppUser"));
        aVar.field_LabsAppId = hashMap.get(hr(str, "LabsAppId"));
        aVar.field_TitleKey_android = hashMap.get(hr(str, "TitleKey_android"));
        aVar.field_Title_cn = hashMap.get(hr(str, "Title_cn"));
        aVar.field_Title_en = hashMap.get(hr(str, "Title_en"));
        aVar.field_Title_hk = hashMap.get(hr(str, "Title_hk"));
        aVar.field_Title_tw = hashMap.get(hr(str, "Title_tw"));
        aVar.field_ThumbUrl_cn = hashMap.get(hr(str, "ThumbUrl_cn"));
        aVar.field_ThumbUrl_en = hashMap.get(hr(str, "ThumbUrl_en"));
        aVar.field_ThumbUrl_hk = hashMap.get(hr(str, "ThumbUrl_hk"));
        aVar.field_ThumbUrl_tw = hashMap.get(hr(str, "ThumbUrl_tw"));
        aVar.field_ImgUrl_android_cn = a(hashMap, hr(str, "ImgUrl_android_cn")).replace(',', ';');
        aVar.field_ImgUrl_android_tw = a(hashMap, hr(str, "ImgUrl_android_tw")).replace(',', ';');
        aVar.field_ImgUrl_android_en = a(hashMap, hr(str, "ImgUrl_android_en")).replace(',', ';');
        aVar.field_ImgUrl_android_hk = a(hashMap, hr(str, "ImgUrl_android_hk")).replace(',', ';');
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_cn)) {
            aVar.field_ImgUrl_android_cn = hashMap.get(hr(str, "ImgUrl_cn"));
        }
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_en)) {
            aVar.field_ImgUrl_android_en = hashMap.get(hr(str, "ImgUrl_en"));
        }
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_hk)) {
            aVar.field_ImgUrl_android_hk = hashMap.get(hr(str, "ImgUrl_hk"));
        }
        if (TextUtils.isEmpty(aVar.field_ImgUrl_android_tw)) {
            aVar.field_ImgUrl_android_tw = hashMap.get(hr(str, "ImgUrl_tw"));
        }
        aVar.field_RedPoint = Util.safeParseInt(hashMap.get(hr(str, "RedPoint")));
        aVar.field_WeAppDebugMode = Util.safeParseInt(hashMap.get(hr(str, "WeAppDebugMode")));
        aVar.field_TitleKey_android = hashMap.get(hr(str, "TitleKey_android"));
        aVar.field_Icon = hashMap.get(hr(str, "Icon"));
        aVar.field_bItemFromXExpt = 1;
        aVar.field_status = Util.safeParseInt(hashMap.get(hr(str, "status")));
        aVar.field_idkey = Util.safeParseInt(hashMap.get(hr(str, "idkey")));
        aVar.field_idkeyValue = Util.safeParseInt(hashMap.get(hr(str, "idkeyValue")));
        AppMethodBeat.o(146233);
        return aVar;
    }

    private static String hr(String str, String str2) {
        AppMethodBeat.i(146234);
        String lowerCase = (str + "_" + str2).toLowerCase();
        AppMethodBeat.o(146234);
        return lowerCase;
    }
}
