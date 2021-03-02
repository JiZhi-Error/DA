package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXFileObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXFileObject";
    private int contentLengthLimit;
    public byte[] fileData;
    public String filePath;

    public WXFileObject() {
        AppMethodBeat.i(190400);
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = null;
        this.filePath = null;
        AppMethodBeat.o(190400);
    }

    public WXFileObject(String str) {
        AppMethodBeat.i(190402);
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.filePath = str;
        AppMethodBeat.o(190402);
    }

    public WXFileObject(byte[] bArr) {
        AppMethodBeat.i(190401);
        this.contentLengthLimit = CONTENT_LENGTH_LIMIT;
        this.fileData = bArr;
        AppMethodBeat.o(190401);
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(WearableStatusCodes.UNKNOWN_CAPABILITY);
        int a2 = b.a(str);
        AppMethodBeat.o(WearableStatusCodes.UNKNOWN_CAPABILITY);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        AppMethodBeat.i(WearableStatusCodes.DUPLICATE_CAPABILITY);
        byte[] bArr = this.fileData;
        if ((bArr == null || bArr.length == 0) && ((str = this.filePath) == null || str.length() == 0)) {
            Log.e(TAG, "checkArgs fail, both arguments is null");
            AppMethodBeat.o(WearableStatusCodes.DUPLICATE_CAPABILITY);
            return false;
        }
        byte[] bArr2 = this.fileData;
        if (bArr2 == null || bArr2.length <= this.contentLengthLimit) {
            String str2 = this.filePath;
            if (str2 == null || getFileSize(str2) <= this.contentLengthLimit) {
                AppMethodBeat.o(WearableStatusCodes.DUPLICATE_CAPABILITY);
                return true;
            }
            Log.e(TAG, "checkArgs fail, fileSize is too large");
            AppMethodBeat.o(WearableStatusCodes.DUPLICATE_CAPABILITY);
            return false;
        }
        Log.e(TAG, "checkArgs fail, fileData is too large");
        AppMethodBeat.o(WearableStatusCodes.DUPLICATE_CAPABILITY);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(WearableStatusCodes.INVALID_TARGET_NODE);
        bundle.putByteArray("_wxfileobject_fileData", this.fileData);
        bundle.putString("_wxfileobject_filePath", this.filePath);
        AppMethodBeat.o(WearableStatusCodes.INVALID_TARGET_NODE);
    }

    public void setContentLengthLimit(int i2) {
        this.contentLengthLimit = i2;
    }

    public void setFileData(byte[] bArr) {
        this.fileData = bArr;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(WearableStatusCodes.ASSET_UNAVAILABLE);
        this.fileData = bundle.getByteArray("_wxfileobject_fileData");
        this.filePath = bundle.getString("_wxfileobject_filePath");
        AppMethodBeat.o(WearableStatusCodes.ASSET_UNAVAILABLE);
    }
}
