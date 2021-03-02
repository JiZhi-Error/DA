package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class WebViewJSSDKFileItem implements Parcelable {
    public a VgI;
    public String appId;
    public String dJX;
    public String fileName;
    public int height;
    public Bundle jkf = new Bundle();
    public String lPx;
    public String laR;
    public String laS;
    public boolean laU;
    public boolean laV = true;
    public boolean laW = true;
    public String mediaId;
    public int mediaType;
    public int size;
    public int width;

    public abstract String getFileType();

    public abstract WebViewJSSDKFileItem hXK();

    public abstract String hXL();

    public static WebViewJSSDKFileItem byx(String str) {
        WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.laR = str;
        webViewJSSDKImageItem.hXK();
        webViewJSSDKImageItem.mediaId = c.a("jsupimg", Util.nowMilliSecond(), webViewJSSDKImageItem.dJX, webViewJSSDKImageItem.dJX);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem ma(String str, String str2) {
        WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.laR = str;
        webViewJSSDKImageItem.lPx = str2;
        webViewJSSDKImageItem.hXK();
        webViewJSSDKImageItem.mediaId = c.a("jsupimg", Util.nowMilliSecond(), webViewJSSDKImageItem.dJX, webViewJSSDKImageItem.dJX);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem byy(String str) {
        WebViewJSSDKVoiceItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fileName = str;
        webViewJSSDKVoiceItem.hXK();
        webViewJSSDKVoiceItem.mediaId = c.a("jsupvoice", Util.nowMilliSecond(), webViewJSSDKVoiceItem.dJX, webViewJSSDKVoiceItem.dJX);
        return webViewJSSDKVoiceItem;
    }

    public static WebViewJSSDKFileItem ag(int i2, String str, String str2) {
        WebViewJSSDKUpFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i2;
        webViewJSSDKUpFileItem.ISo = str;
        webViewJSSDKUpFileItem.laR = str2;
        webViewJSSDKUpFileItem.hXK();
        webViewJSSDKUpFileItem.mediaId = c.a("jsupfile", Util.nowMilliSecond(), webViewJSSDKUpFileItem.dJX, webViewJSSDKUpFileItem.dJX);
        Log.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", Integer.valueOf(i2), str2, webViewJSSDKUpFileItem.dJX);
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem byz(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.laR = str;
        webViewJSSDKVideoItem.hXK();
        webViewJSSDKVideoItem.mediaId = c.a("jsvideofile", Util.nowMilliSecond(), webViewJSSDKVideoItem.dJX, webViewJSSDKVideoItem.dJX);
        Log.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", str, webViewJSSDKVideoItem.dJX, webViewJSSDKVideoItem.mediaId);
        return webViewJSSDKVideoItem;
    }

    /* access modifiers changed from: protected */
    public void cb(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString("appId");
            this.dJX = jSONObject.optString(ch.COL_LOCALID);
            this.lPx = jSONObject.optString("thumbFilePath");
            this.laR = jSONObject.optString("origFilePath");
            this.laS = jSONObject.optString("serverId");
            this.mediaId = jSONObject.optString("mediaId");
            this.fileName = jSONObject.optString(DownloadInfo.FILENAME);
            this.mediaType = jSONObject.optInt("mediaType");
            this.size = jSONObject.optInt("size");
            this.width = jSONObject.optInt("width");
            this.height = jSONObject.optInt("height");
            this.VgI = a.aYM(jSONObject.optString("cdnInfo"));
            this.laU = jSONObject.optBoolean("upload");
            this.laV = jSONObject.optBoolean("needCompress", true);
            this.laW = jSONObject.optBoolean("needUploadCDNInfo", true);
            this.jkf = aLl(jSONObject.optString("extra"));
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject hXJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put(ch.COL_LOCALID, this.dJX);
            jSONObject.put("thumbFilePath", this.lPx);
            jSONObject.put("origFilePath", this.laR);
            jSONObject.put("serverId", this.laS);
            jSONObject.put("mediaId", this.mediaId);
            jSONObject.put(DownloadInfo.FILENAME, this.fileName);
            jSONObject.put("mediaType", this.mediaType);
            jSONObject.put("size", this.size);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            if (this.VgI != null) {
                jSONObject.put("cdnInfo", this.VgI.toJson());
            }
            jSONObject.put("upload", this.laU);
            jSONObject.put("needCompress", this.laV);
            jSONObject.put("needUploadCDNInfo", this.laW);
            jSONObject.put("extra", au(this.jkf));
        } catch (JSONException e2) {
        }
        return jSONObject;
    }

    public void d(d dVar) {
        if (this.VgI == null) {
            this.VgI = new a();
        }
        if (dVar == null) {
            Log.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.VgI.field_aesKey = dVar.field_aesKey;
        this.VgI.field_fileId = dVar.field_fileId;
        this.VgI.field_fileUrl = dVar.field_fileUrl;
        this.VgI.field_fileLength = (int) dVar.field_fileLength;
    }

    public WebViewJSSDKFileItem() {
    }

    protected WebViewJSSDKFileItem(Parcel parcel) {
        this.appId = parcel.readString();
        this.dJX = parcel.readString();
        this.lPx = parcel.readString();
        this.laR = parcel.readString();
        this.mediaType = parcel.readInt();
        this.size = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.jkf = parcel.readBundle();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.appId);
        parcel.writeString(this.dJX);
        parcel.writeString(this.lPx);
        parcel.writeString(this.laR);
        parcel.writeInt(this.mediaType);
        parcel.writeInt(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeBundle(this.jkf);
    }

    public static class a {
        public String field_aesKey;
        public String field_fileId;
        public int field_fileLength;
        public String field_fileUrl;

        public final String toJson() {
            AppMethodBeat.i(182693);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("aesKey", this.field_aesKey);
                jSONObject.put("fileId", this.field_fileId);
                jSONObject.put("fileUrl", this.field_fileUrl);
                jSONObject.put("fileLength", this.field_fileLength);
            } catch (JSONException e2) {
            }
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(182693);
            return jSONObject2;
        }

        public static a aYM(String str) {
            AppMethodBeat.i(182694);
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.field_aesKey = jSONObject.optString("aesKey");
                aVar.field_fileId = jSONObject.optString("fileId");
                aVar.field_fileUrl = jSONObject.optString("fileUrl");
                aVar.field_fileLength = jSONObject.optInt("fileLength");
            } catch (JSONException e2) {
            }
            AppMethodBeat.o(182694);
            return aVar;
        }
    }

    private static Bundle aLl(String str) {
        Bundle bundle = new Bundle();
        if (str == null || str.isEmpty()) {
            return bundle;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    bundle.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Byte) {
                    bundle.putByte(next, ((Byte) obj).byteValue());
                } else if (obj instanceof Character) {
                    bundle.putChar(next, ((Character) obj).charValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Short) {
                    bundle.putShort(next, ((Short) obj).shortValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                } else {
                    bundle.putString(next, obj.toString());
                }
            }
        } catch (JSONException e2) {
        }
        return bundle;
    }

    private static String au(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
        } catch (JSONException e2) {
        }
        return jSONObject.toString();
    }
}
