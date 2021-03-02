package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage;

public class WWMediaLink extends WWMediaMessage.WWMediaObject {
    public String thumbUrl;
    public String webpageUrl;

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        AppMethodBeat.i(106542);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106542);
            return false;
        } else if (this.webpageUrl == null || this.webpageUrl.length() == 0 || this.webpageUrl.length() > 10240) {
            AppMethodBeat.o(106542);
            return false;
        } else {
            AppMethodBeat.o(106542);
            return true;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106543);
        bundle.putString("_wwwebpageobject_thumbUrl", this.thumbUrl);
        bundle.putString("_wwwebpageobject_webpageUrl", this.webpageUrl);
        super.toBundle(bundle);
        AppMethodBeat.o(106543);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199007);
        this.thumbUrl = bundle.getString("_wwwebpageobject_thumbUrl");
        this.webpageUrl = bundle.getString("_wwwebpageobject_webpageUrl");
        super.fromBundle(bundle);
        AppMethodBeat.o(199007);
    }
}
