package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage;

public class WWMediaConversation extends WWMediaMessage.WWMediaObject {
    public byte[] Sxt;
    public WWMediaMessage.WWMediaObject Sxu;
    public String name;
    public long sJT;
    public String tjJ;

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        AppMethodBeat.i(106538);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106538);
            return false;
        } else if (this.Sxt != null && this.Sxt.length > 10485760) {
            AppMethodBeat.o(106538);
            return false;
        } else if (this.tjJ != null && this.tjJ.length() > 10240) {
            AppMethodBeat.o(106538);
            return false;
        } else if (this.tjJ != null && getFileSize(this.tjJ) > 10485760) {
            AppMethodBeat.o(106538);
            return false;
        } else if (this.Sxu == null || !this.Sxu.checkArgs()) {
            AppMethodBeat.o(106538);
            return false;
        } else {
            AppMethodBeat.o(106538);
            return true;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106539);
        super.toBundle(bundle);
        bundle.putString("_wwconvobject_name", this.name);
        bundle.putLong("_wwconvobject_date", this.sJT);
        bundle.putByteArray("_wwconvobject_avatarData", this.Sxt);
        bundle.putString("_wwconvobject_avatarPath", this.tjJ);
        bundle.putBundle("_wwconvobject_message", BaseMessage.a(this.Sxu));
        AppMethodBeat.o(106539);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199001);
        super.fromBundle(bundle);
        this.name = bundle.getString("_wwconvobject_name");
        this.sJT = bundle.getLong("_wwconvobject_date");
        this.Sxt = bundle.getByteArray("_wwconvobject_avatarData");
        this.tjJ = bundle.getString("_wwconvobject_avatarPath");
        try {
            this.Sxu = (WWMediaMessage.WWMediaObject) BaseMessage.bB(bundle.getBundle("_wwconvobject_message"));
            AppMethodBeat.o(199001);
        } catch (Throwable th) {
            AppMethodBeat.o(199001);
        }
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void v(Intent intent, String str) {
        AppMethodBeat.i(199002);
        try {
            this.Sxu.v(intent, str);
            AppMethodBeat.o(199002);
        } catch (Throwable th) {
            AppMethodBeat.o(199002);
        }
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void brA(String str) {
        AppMethodBeat.i(199003);
        super.brA(str);
        try {
            this.Sxu.brA(str);
            AppMethodBeat.o(199003);
        } catch (Throwable th) {
            AppMethodBeat.o(199003);
        }
    }

    @Override // com.tencent.wework.api.model.BaseMessage
    public final void setContext(Context context) {
        AppMethodBeat.i(199004);
        super.setContext(context);
        try {
            this.Sxu.setContext(context);
            AppMethodBeat.o(199004);
        } catch (Throwable th) {
            AppMethodBeat.o(199004);
        }
    }
}
