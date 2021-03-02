package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String str, String str2) {
        AppMethodBeat.i(190394);
        this.extInfo = str;
        this.filePath = str2;
        AppMethodBeat.o(190394);
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        AppMethodBeat.i(190393);
        this.extInfo = str;
        this.fileData = bArr;
        AppMethodBeat.o(190393);
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(3956);
        int a2 = b.a(str);
        AppMethodBeat.o(3956);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        byte[] bArr;
        AppMethodBeat.i(3955);
        String str2 = this.extInfo;
        if ((str2 == null || str2.length() == 0) && (((str = this.filePath) == null || str.length() == 0) && ((bArr = this.fileData) == null || bArr.length == 0))) {
            Log.e(TAG, "checkArgs fail, all arguments is null");
            AppMethodBeat.o(3955);
            return false;
        }
        String str3 = this.extInfo;
        if (str3 == null || str3.length() <= 2048) {
            String str4 = this.filePath;
            if (str4 == null || str4.length() <= 10240) {
                String str5 = this.filePath;
                if (str5 == null || getFileSize(str5) <= CONTENT_LENGTH_LIMIT) {
                    byte[] bArr2 = this.fileData;
                    if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
                        AppMethodBeat.o(3955);
                        return true;
                    }
                    Log.e(TAG, "checkArgs fail, fileData is too large");
                    AppMethodBeat.o(3955);
                    return false;
                }
                Log.e(TAG, "checkArgs fail, fileSize is too large");
                AppMethodBeat.o(3955);
                return false;
            }
            Log.e(TAG, "checkArgs fail, filePath is invalid");
            AppMethodBeat.o(3955);
            return false;
        }
        Log.e(TAG, "checkArgs fail, extInfo is invalid");
        AppMethodBeat.o(3955);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3953);
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
        AppMethodBeat.o(3953);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3954);
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
        AppMethodBeat.o(3954);
    }
}
