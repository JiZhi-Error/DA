package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage;

public class WWMediaMiniProgram extends WWMediaMessage.WWMediaObject {
    public byte[] Sxw;
    public int Sxx;
    public String iconUrl;
    public String name;
    public String path;
    public String title;
    public int type;
    public String username;
    public String webpageUrl;

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        AppMethodBeat.i(106553);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106553);
            return false;
        } else if (this.username == null || this.username.length() <= 0) {
            AppMethodBeat.o(106553);
            return false;
        } else if (this.Sxw == null || this.Sxw.length <= 0 || this.Sxw.length > 1048576) {
            AppMethodBeat.o(106553);
            return false;
        } else {
            AppMethodBeat.o(106553);
            return true;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106554);
        bundle.putString("_wwwxaobject_userName", this.username);
        bundle.putString("_wwwxaobject_path", this.path == null ? "" : this.path);
        bundle.putString("_wwwxaobject_iconUrl", this.iconUrl == null ? "" : this.iconUrl);
        bundle.putString("_wwwxaobject_name", this.name == null ? "" : this.name);
        bundle.putString("_wwwxaobject_title", this.title == null ? "" : this.title);
        bundle.putByteArray("_wwwxaobject_hdImageData", this.Sxw);
        bundle.putInt("_wwwxaobject_type", this.type);
        bundle.putString("_wwwxaobject_webpageurl", this.webpageUrl == null ? "" : this.webpageUrl);
        bundle.putInt("_wwwxaobject_programtype", this.Sxx);
        super.toBundle(bundle);
        AppMethodBeat.o(106554);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199014);
        this.username = bundle.getString("_wwwxaobject_userName");
        this.path = bundle.getString("_wwwxaobject_path");
        this.iconUrl = bundle.getString("_wwwxaobject_iconUrl");
        this.name = bundle.getString("_wwwxaobject_name");
        this.title = bundle.getString("_wwwxaobject_title");
        this.Sxw = bundle.getByteArray("_wwwxaobject_hdImageData");
        this.type = bundle.getInt("_wwwxaobject_type", 2);
        this.webpageUrl = bundle.getString("_wwwxaobject_webpageurl");
        this.Sxx = bundle.getInt("_wwwxaobject_programtype", 0);
        super.fromBundle(bundle);
        AppMethodBeat.o(199014);
    }
}
