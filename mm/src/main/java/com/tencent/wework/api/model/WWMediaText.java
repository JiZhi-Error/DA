package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage;

public class WWMediaText extends WWMediaMessage.WWMediaObject {
    public String text;

    public WWMediaText() {
    }

    public WWMediaText(String str) {
        this.text = str;
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        AppMethodBeat.i(106555);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106555);
            return false;
        } else if (this.text == null || this.text.length() == 0 || this.text.length() > 10240) {
            AppMethodBeat.o(106555);
            return false;
        } else {
            AppMethodBeat.o(106555);
            return true;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106556);
        bundle.putString("_wwtextobject_text", this.text);
        super.toBundle(bundle);
        AppMethodBeat.o(106556);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199015);
        this.text = bundle.getString("_wwtextobject_text");
        super.fromBundle(bundle);
        AppMethodBeat.o(199015);
    }
}
