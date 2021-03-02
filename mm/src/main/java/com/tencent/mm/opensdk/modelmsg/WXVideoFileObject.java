package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXVideoFileObject implements WXMediaMessage.IMediaObject {
    public static final int FILE_SIZE_LIMIT = 104857600;
    private static final String TAG = "MicroMsg.SDK.WXVideoFileObject";
    public static final int WXVideoFileShareSceneCommon = 0;
    public static final int WXVideoFileShareSceneFromWX = 1;
    public String filePath;
    public int shareScene;
    public String shareTicket;

    public WXVideoFileObject() {
        AppMethodBeat.i(190383);
        this.shareScene = 0;
        this.filePath = null;
        AppMethodBeat.o(190383);
    }

    public WXVideoFileObject(String str) {
        AppMethodBeat.i(190384);
        this.shareScene = 0;
        this.filePath = str;
        AppMethodBeat.o(190384);
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(3961);
        int a2 = b.a(str);
        AppMethodBeat.o(3961);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(3960);
        String str = this.filePath;
        if (str == null || str.length() == 0) {
            Log.e(TAG, "checkArgs fail, filePath is null");
            AppMethodBeat.o(3960);
            return false;
        } else if (getFileSize(this.filePath) > 104857600) {
            Log.e(TAG, "checkArgs fail, video file size is too large");
            AppMethodBeat.o(3960);
            return false;
        } else {
            AppMethodBeat.o(3960);
            return true;
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3958);
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putInt("_wxvideofileobject_shareScene", this.shareScene);
        bundle.putString("_wxvideofileobject_shareTicketh", this.shareTicket);
        AppMethodBeat.o(3958);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 38;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3959);
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.shareScene = bundle.getInt("_wxvideofileobject_shareScene", 0);
        this.shareTicket = bundle.getString("_wxvideofileobject_shareTicketh");
        AppMethodBeat.o(3959);
    }
}
