package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ay {
    public static Intent bf(String str, String str2, String str3) {
        Intent[] intentArr;
        boolean z = true;
        AppMethodBeat.i(79046);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (Util.isNullOrNil(str)) {
            intent.setType("*/*");
        } else {
            intent.setType(str);
        }
        Intent[] intentArr2 = null;
        if (Util.isNullOrNil(str2)) {
            if (d.oE(16)) {
                Log.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                z = false;
                intentArr = new Intent[]{aYX(str3)};
            }
            z = false;
            intentArr = null;
        } else if ("camera".equalsIgnoreCase(str2)) {
            z = false;
            intentArr = new Intent[]{aYX(str3)};
        } else if ("camcorder".equalsIgnoreCase(str2)) {
            z = false;
            intentArr = new Intent[]{gcV()};
        } else if ("microphone".equalsIgnoreCase(str2)) {
            z = false;
            intentArr = new Intent[]{gcW()};
        } else {
            if ("*".equalsIgnoreCase(str2) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2) || "false".equalsIgnoreCase(str2)) {
                if (str.equalsIgnoreCase("image/*")) {
                    intentArr2 = new Intent[]{aYX(str3)};
                } else if (str.equalsIgnoreCase("audio/*")) {
                    intentArr2 = new Intent[]{gcW()};
                } else if (str.equalsIgnoreCase("video/*")) {
                    intentArr2 = new Intent[]{gcV()};
                }
                if ("false".equalsIgnoreCase(str2) || "*".equalsIgnoreCase(str2)) {
                    intentArr = intentArr2;
                } else {
                    z = false;
                    intentArr = intentArr2;
                }
            }
            z = false;
            intentArr = null;
        }
        if (z || intentArr == null || intentArr.length == 0) {
            Intent intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent2.putExtra("android.intent.extra.TITLE", MMApplicationContext.getContext().getString(R.string.j52));
            intent2.putExtra("android.intent.extra.INTENT", intent);
            AppMethodBeat.o(79046);
            return intent2;
        }
        Intent intent3 = intentArr[0];
        AppMethodBeat.o(79046);
        return intent3;
    }

    public static String aYW(String str) {
        AppMethodBeat.i(79047);
        o oVar = new o(b.aKV());
        if (!oVar.mkdirs()) {
            Log.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + oVar.exists());
        }
        if (!oVar.exists()) {
            Log.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", b.aKV());
        }
        String str2 = aa.z(oVar.her()) + FilePathGenerator.ANDROID_DIR_SEP + str + ".jpg";
        Log.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", str, str2);
        AppMethodBeat.o(79047);
        return str2;
    }

    private static Intent aYX(String str) {
        AppMethodBeat.i(79048);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), new o(aYW(str))));
        AppMethodBeat.o(79048);
        return intent;
    }

    private static Intent gcV() {
        AppMethodBeat.i(79049);
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        AppMethodBeat.o(79049);
        return intent;
    }

    private static Intent gcW() {
        AppMethodBeat.i(79050);
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        AppMethodBeat.o(79050);
        return intent;
    }

    public static String aYY(String str) {
        AppMethodBeat.i(79051);
        Log.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79051);
            return null;
        }
        String str2 = "weixin://resourceid/" + MD5Util.getMD5String(str);
        Log.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", str, str2);
        AppMethodBeat.o(79051);
        return str2;
    }

    public static String aYZ(String str) {
        AppMethodBeat.i(79052);
        WebViewJSSDKFileItem aYO = g.gdv().aYO(str);
        if (aYO != null) {
            Log.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", aYO.lPx);
            String str2 = aYO.lPx;
            AppMethodBeat.o(79052);
            return str2;
        }
        Log.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", str);
        AppMethodBeat.o(79052);
        return null;
    }

    public static String aZa(String str) {
        AppMethodBeat.i(79053);
        WebViewJSSDKFileItem aYO = g.gdv().aYO(str);
        if (aYO != null) {
            Log.i("MicroMsg.WebviewJSSDKUtil", "get orignal filepath from local id :%s", aYO.laR);
            String str2 = aYO.laR;
            AppMethodBeat.o(79053);
            return str2;
        }
        Log.e("MicroMsg.WebviewJSSDKUtil", "getOrigFilePathByLocalId, local map not contains the local id : %s", str);
        AppMethodBeat.o(79053);
        return null;
    }

    public static String bb(ArrayList<String> arrayList) {
        AppMethodBeat.i(79054);
        if (arrayList.size() == 0) {
            Log.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            AppMethodBeat.o(79054);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray.put(arrayList.get(i2));
        }
        String jSONArray2 = jSONArray.toString();
        AppMethodBeat.o(79054);
        return jSONArray2;
    }

    public static String bc(ArrayList<String> arrayList) {
        AppMethodBeat.i(79055);
        if (arrayList.size() == 0) {
            Log.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            AppMethodBeat.o(79055);
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                jSONStringer.key(ch.COL_LOCALID);
                jSONStringer.value(arrayList.get(i2));
            }
            jSONStringer.endObject();
            jSONStringer.endArray();
            String jSONStringer2 = jSONStringer.toString();
            AppMethodBeat.o(79055);
            return jSONStringer2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e2, "", new Object[0]);
            AppMethodBeat.o(79055);
            return "";
        }
    }

    public static String bd(ArrayList<String> arrayList) {
        AppMethodBeat.i(79056);
        if (Util.isNullOrNil(arrayList)) {
            AppMethodBeat.o(79056);
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                WebViewJSSDKFileItem aYO = g.gdv().aYO(next);
                if (aYO instanceof WebViewJSSDKImageItem) {
                    jSONStringer.object();
                    jSONStringer.key(ch.COL_LOCALID);
                    jSONStringer.value(next);
                    jSONStringer.key("height");
                    jSONStringer.value(new StringBuilder().append(aYO.height).toString());
                    jSONStringer.key("width");
                    jSONStringer.value(new StringBuilder().append(aYO.width).toString());
                    jSONStringer.key("isGif");
                    jSONStringer.value(new StringBuilder().append(((WebViewJSSDKImageItem) aYO).xlR).toString());
                    jSONStringer.endObject();
                }
            }
            jSONStringer.endArray();
            String jSONStringer2 = jSONStringer.toString();
            AppMethodBeat.o(79056);
            return jSONStringer2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e2, "", new Object[0]);
            AppMethodBeat.o(79056);
            return "";
        }
    }

    public static String c(String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(79057);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            AppMethodBeat.o(79057);
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key(ch.COL_LOCALID);
            jSONStringer.value(str);
            jSONStringer.key("thumbLocalId");
            jSONStringer.value(str2);
            jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i5));
            jSONStringer.endObject();
            jSONStringer.endArray();
            String jSONStringer2 = jSONStringer.toString();
            AppMethodBeat.o(79057);
            return jSONStringer2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e2, "", new Object[0]);
            AppMethodBeat.o(79057);
            return "";
        }
    }

    public static String aZb(String str) {
        AppMethodBeat.i(79059);
        String str2 = "_USER_FOR_WEBVIEW_JSAPI" + x.x(str, Util.nowMilliSecond());
        AppMethodBeat.o(79059);
        return str2;
    }
}
