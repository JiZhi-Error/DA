package com.tencent.tmassistantsdk.channel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.util.Base64;
import com.tencent.tmassistantsdk.util.Cryptor;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class TMAssistantSDKChannelDataItem {
    public static final int DATEITEM_VERSION = 1;
    private static final String ENCRYPT_KEY = "&-*)Wb5_U,[^!9'+";
    public static final int IPCDATA_MIN_VERSION = 1;
    private static final String TAG = "MicroMsg.TMAssistantSDKChannelDataItem";
    public int mDBIdentity = -1;
    public String mDataItemAction = "";
    public long mDataItemEndTime = 0;
    public long mDataItemStartTime = 0;
    public int mDataItemType = 0;
    public int mDataItemVersion = 0;
    public String mHostPackageName = "";
    public String mHostUserIdentity = "";
    public int mHostVersion = 0;
    public byte[] mIPCData = null;

    public TMAssistantSDKChannelDataItem(String str, int i2, String str2, int i3, String str3, long j2, long j3, int i4, byte[] bArr) {
        AppMethodBeat.i(101864);
        this.mHostPackageName = str;
        if (this.mHostPackageName == null) {
            this.mHostPackageName = "";
        }
        this.mHostVersion = i2;
        this.mHostUserIdentity = str2;
        if (this.mHostUserIdentity == null) {
            this.mHostUserIdentity = "";
        }
        this.mDataItemType = i3;
        this.mDataItemAction = str3;
        if (this.mDataItemAction == null) {
            this.mDataItemAction = "";
        }
        this.mDataItemStartTime = j2;
        this.mDataItemEndTime = j3;
        this.mDataItemVersion = i4;
        this.mIPCData = bArr;
        AppMethodBeat.o(101864);
    }

    public static TMAssistantSDKChannelDataItem getDataItemFromByte(byte[] bArr) {
        byte[] bArr2;
        String string;
        AppMethodBeat.i(101865);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(101865);
            return null;
        }
        byte[] decrypt = new Cryptor().decrypt(bArr, ENCRYPT_KEY.getBytes());
        if (decrypt != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(decrypt, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                String string2 = jSONObject.getString("mHostPackageName");
                int i2 = jSONObject.getInt("mHostVersion");
                String string3 = jSONObject.getString("mHostUserIdentity");
                int i3 = jSONObject.getInt("mDataItemType");
                String string4 = jSONObject.getString("mDataItemAction");
                long j2 = jSONObject.getLong("mDataItemStartTime");
                long j3 = jSONObject.getLong("mDataItemEndTime");
                int i4 = jSONObject.getInt("mDataItemVersion");
                if (i4 <= 0 || (string = jSONObject.getString("mIPCData")) == null) {
                    bArr2 = null;
                } else {
                    bArr2 = Base64.decode(string, 0);
                }
                TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem = new TMAssistantSDKChannelDataItem(string2, i2, string3, i3, string4, j2, j3, i4, bArr2);
                AppMethodBeat.o(101865);
                return tMAssistantSDKChannelDataItem;
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            } catch (JSONException e3) {
                Log.printErrStackTrace(TAG, e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(101865);
        return null;
    }

    public byte[] getBuffer() {
        byte[] bytes;
        String encodeToString;
        AppMethodBeat.i(101866);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mHostPackageName", this.mHostPackageName);
            jSONObject.put("mHostVersion", this.mHostVersion);
            jSONObject.put("mHostUserIdentity", this.mHostUserIdentity);
            jSONObject.put("mDataItemType", this.mDataItemType);
            jSONObject.put("mDataItemAction", this.mDataItemAction);
            jSONObject.put("mDataItemStartTime", this.mDataItemStartTime);
            jSONObject.put("mDataItemEndTime", this.mDataItemEndTime);
            jSONObject.put("mDataItemVersion", this.mDataItemVersion);
            if (!(this.mDataItemVersion <= 0 || this.mIPCData == null || (encodeToString = Base64.encodeToString(this.mIPCData, 0)) == null)) {
                jSONObject.put("mIPCData", encodeToString);
            }
            String jSONObject2 = jSONObject.toString();
            if (!(jSONObject2 == null || (bytes = jSONObject2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET)) == null)) {
                byte[] encrypt = new Cryptor().encrypt(bytes, ENCRYPT_KEY.getBytes());
                AppMethodBeat.o(101866);
                return encrypt;
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        } catch (UnsupportedEncodingException e3) {
            Log.printErrStackTrace(TAG, e3, "", new Object[0]);
        }
        AppMethodBeat.o(101866);
        return null;
    }
}
