package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXMiniProgramObject implements WXMediaMessage.IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public int disableforward = 0;
    private HashMap<String, String> extraInfoMap = null;
    public boolean isSecretMessage = false;
    public boolean isUpdatableMessage = false;
    public int miniprogramType = 0;
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;

    public WXMiniProgramObject() {
        AppMethodBeat.i(190363);
        AppMethodBeat.o(190363);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        AppMethodBeat.i(3948);
        if (b.b(this.webpageUrl)) {
            Log.e(TAG, "webPageUrl is null");
            AppMethodBeat.o(3948);
            return false;
        } else if (b.b(this.userName)) {
            Log.e(TAG, "userName is null");
            AppMethodBeat.o(3948);
            return false;
        } else {
            int i2 = this.miniprogramType;
            if (i2 < 0 || i2 > 2) {
                Log.e(TAG, "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
                AppMethodBeat.o(3948);
                return false;
            }
            AppMethodBeat.o(3948);
            return true;
        }
    }

    public String getExtra(String str, String str2) {
        AppMethodBeat.i(190365);
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            String str3 = hashMap.get(str);
            if (str3 != null) {
                str2 = str3;
            }
            AppMethodBeat.o(190365);
            return str2;
        }
        AppMethodBeat.o(190365);
        return null;
    }

    public void putExtra(String str, String str2) {
        AppMethodBeat.i(190364);
        if (this.extraInfoMap == null) {
            this.extraInfoMap = new HashMap<>();
        }
        if (!b.b(str)) {
            this.extraInfoMap.put(str, str2);
        }
        AppMethodBeat.o(190364);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        AppMethodBeat.i(3946);
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
        bundle.putBoolean("_wxminiprogram_isupdatablemsg", this.isUpdatableMessage);
        bundle.putBoolean("_wxminiprogram_issecretmsg", this.isSecretMessage);
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            bundle.putSerializable("_wxminiprogram_extrainfo", hashMap);
        }
        AppMethodBeat.o(3946);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 36;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        AppMethodBeat.i(3947);
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
        this.isUpdatableMessage = bundle.getBoolean("_wxminiprogram_isupdatablemsg");
        this.isSecretMessage = bundle.getBoolean("_wxminiprogram_issecretmsg");
        this.extraInfoMap = (HashMap) bundle.getSerializable("_wxminiprogram_extrainfo");
        AppMethodBeat.o(3947);
    }
}
