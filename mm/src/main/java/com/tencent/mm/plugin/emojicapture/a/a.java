package com.tencent.mm.plugin.emojicapture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.jsapi.media.f;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
public final class a extends c<aiy> {
    private final String TAG = "MicroMsg.CgiTextAntiSpam";
    private final String text;

    public a(String str) {
        AppMethodBeat.i(128);
        this.text = str;
        d.a aVar = new d.a();
        aix aix = new aix();
        aix.KTg = this.text;
        aVar.c(aix);
        aVar.d(new aiy());
        aVar.MB("/cgi-bin/micromsg-bin/mmemojitextantispam");
        aVar.sG(f.CTRL_INDEX);
        c(aVar.aXF());
        Log.i(this.TAG, "Check text anti spam " + this.text);
        AppMethodBeat.o(128);
    }
}
