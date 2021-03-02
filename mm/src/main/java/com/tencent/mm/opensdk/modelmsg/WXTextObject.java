package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXTextObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXTextObject";
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        AppMethodBeat.i(190425);
        this.text = str;
        AppMethodBeat.o(190425);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(3982);
        String str = this.text;
        if (str == null || str.length() == 0 || this.text.length() > 10240) {
            Log.e(TAG, "checkArgs fail, text is invalid");
            AppMethodBeat.o(3982);
            return false;
        }
        AppMethodBeat.o(3982);
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3980);
        bundle.putString("_wxtextobject_text", this.text);
        AppMethodBeat.o(3980);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3981);
        this.text = bundle.getString("_wxtextobject_text");
        AppMethodBeat.o(3981);
    }
}
