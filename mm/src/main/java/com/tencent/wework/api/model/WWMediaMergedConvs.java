package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.wework.api.model.WWMediaMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WWMediaMergedConvs extends WWMediaMessage.WWMediaObject {
    public List<WWMediaConversation> bNN = new ArrayList();

    public WWMediaMergedConvs() {
        AppMethodBeat.i(106546);
        AppMethodBeat.o(106546);
    }

    public final boolean a(WWMediaConversation wWMediaConversation) {
        AppMethodBeat.i(106547);
        if (wWMediaConversation.checkArgs()) {
            this.bNN.add(wWMediaConversation);
            AppMethodBeat.o(106547);
            return true;
        }
        AppMethodBeat.o(106547);
        return false;
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        boolean z;
        AppMethodBeat.i(106548);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106548);
            return false;
        } else if (this.bNN == null || this.bNN.size() == 0) {
            AppMethodBeat.o(106548);
            return false;
        } else {
            Iterator<WWMediaConversation> it = this.bNN.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().checkArgs()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            AppMethodBeat.o(106548);
            return z;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106549);
        bundle.putInt("_wwmergedconvobject_messageslen", this.bNN.size());
        for (int i2 = 0; i2 < this.bNN.size(); i2++) {
            bundle.putBundle("_wwmergedconvobject_messages".concat(String.valueOf(i2)), BaseMessage.a(this.bNN.get(i2)));
        }
        super.toBundle(bundle);
        AppMethodBeat.o(106549);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199009);
        int i2 = bundle.getInt("_wwmergedconvobject_messageslen");
        for (int i3 = 0; i3 < i2; i3++) {
            Object bB = BaseMessage.bB(bundle.getBundle("_wwmergedconvobject_messages".concat(String.valueOf(i3))));
            if (bB == null || !(bB instanceof WWMediaConversation)) {
                StringBuilder sb = new StringBuilder("fromBundle ");
                if (bB == null) {
                    bB = BuildConfig.COMMAND;
                }
                sb.append(bB);
            } else {
                this.bNN.add((WWMediaConversation) bB);
            }
        }
        super.fromBundle(bundle);
        AppMethodBeat.o(199009);
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void v(Intent intent, String str) {
        AppMethodBeat.i(199010);
        for (WWMediaConversation wWMediaConversation : this.bNN) {
            wWMediaConversation.v(intent, str);
        }
        AppMethodBeat.o(199010);
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void brA(String str) {
        AppMethodBeat.i(199011);
        super.brA(str);
        for (WWMediaConversation wWMediaConversation : this.bNN) {
            wWMediaConversation.brA(str);
        }
        AppMethodBeat.o(199011);
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void setContext(Context context) {
        AppMethodBeat.i(199012);
        super.setContext(context);
        for (WWMediaConversation wWMediaConversation : this.bNN) {
            wWMediaConversation.setContext(context);
        }
        AppMethodBeat.o(199012);
    }
}
