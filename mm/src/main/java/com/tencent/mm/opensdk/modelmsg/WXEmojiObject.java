package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        AppMethodBeat.i(190376);
        this.emojiData = null;
        this.emojiPath = null;
        AppMethodBeat.o(190376);
    }

    public WXEmojiObject(String str) {
        AppMethodBeat.i(190378);
        this.emojiPath = str;
        AppMethodBeat.o(190378);
    }

    public WXEmojiObject(byte[] bArr) {
        AppMethodBeat.i(190377);
        this.emojiData = bArr;
        AppMethodBeat.o(190377);
    }

    private int getFileSize(String str) {
        AppMethodBeat.i(3943);
        int a2 = b.a(str);
        AppMethodBeat.o(3943);
        return a2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        AppMethodBeat.i(3942);
        byte[] bArr = this.emojiData;
        if ((bArr == null || bArr.length == 0) && ((str = this.emojiPath) == null || str.length() == 0)) {
            Log.e(TAG, "checkArgs fail, both arguments is null");
            AppMethodBeat.o(3942);
            return false;
        }
        byte[] bArr2 = this.emojiData;
        if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
            String str2 = this.emojiPath;
            if (str2 == null || getFileSize(str2) <= CONTENT_LENGTH_LIMIT) {
                AppMethodBeat.o(3942);
                return true;
            }
            Log.e(TAG, "checkArgs fail, emojiSize is too large");
            AppMethodBeat.o(3942);
            return false;
        }
        Log.e(TAG, "checkArgs fail, emojiData is too large");
        AppMethodBeat.o(3942);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3940);
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
        AppMethodBeat.o(3940);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 8;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3941);
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
        AppMethodBeat.o(3941);
    }
}
