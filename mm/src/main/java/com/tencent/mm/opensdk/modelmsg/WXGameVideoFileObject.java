package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXGameVideoFileObject implements WXMediaMessage.IMediaObject {
    private static final int FILE_SIZE_LIMIT = 104857600;
    private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String filePath;
    public String thumbUrl;
    public String videoUrl;

    public WXGameVideoFileObject() {
        AppMethodBeat.i(190374);
        this.filePath = null;
        this.videoUrl = null;
        this.thumbUrl = null;
        AppMethodBeat.o(190374);
    }

    public WXGameVideoFileObject(String str, String str2, String str3) {
        AppMethodBeat.i(190375);
        this.filePath = str;
        this.videoUrl = str2;
        this.thumbUrl = str3;
        AppMethodBeat.o(190375);
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(4027);
        int a2 = b.a(str);
        AppMethodBeat.o(4027);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(4026);
        String str = this.filePath;
        if (str == null || str.length() == 0) {
            Log.e(TAG, "checkArgs fail, filePath is null");
            AppMethodBeat.o(4026);
            return false;
        } else if (getFileSize(this.filePath) > 104857600) {
            Log.e(TAG, "checkArgs fail, video file size is too large");
            AppMethodBeat.o(4026);
            return false;
        } else {
            String str2 = this.videoUrl;
            if (str2 == null || str2.length() <= 10240) {
                String str3 = this.thumbUrl;
                if (str3 == null || str3.length() <= 10240) {
                    AppMethodBeat.o(4026);
                    return true;
                }
                Log.e(TAG, "checkArgs fail, thumbUrl is too long");
                AppMethodBeat.o(4026);
                return false;
            }
            Log.e(TAG, "checkArgs fail, videoUrl is too long");
            AppMethodBeat.o(4026);
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(4024);
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
        bundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
        AppMethodBeat.o(4024);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 39;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(4025);
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.videoUrl = bundle.getString("_wxvideofileobject_cdnUrl");
        this.thumbUrl = bundle.getString("_wxvideofileobject_thumbUrl");
        AppMethodBeat.o(4025);
    }
}
