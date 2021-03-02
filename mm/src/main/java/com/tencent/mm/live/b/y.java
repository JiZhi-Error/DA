package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0001H\u0016JF\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J(\u0010\u001d\u001a\u00020\u00112\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\""}, hxF = {"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "setLiveId", "(Ljava/lang/String;)V", "liveName", "getLiveName", "setLiveName", "thumbUrl", "getThumbUrl", "setThumbUrl", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "toString", "Companion", "plugin-logic_release"})
public final class y extends f {
    public static final a hJt = new a((byte) 0);
    public String hJs = "";
    public String hwb = "";
    public String thumbUrl = "";

    static {
        AppMethodBeat.i(207737);
        AppMethodBeat.o(207737);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/ShareLiveAppMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(207733);
        if (bVar == null) {
            AppMethodBeat.o(207733);
        } else if (bVar.type != 60 || sb == null) {
            AppMethodBeat.o(207733);
        } else {
            sb.append("<mmlive>");
            sb.append("<live_id>");
            sb.append(k.b.HE(this.hJs));
            sb.append("</live_id>");
            sb.append("</mmlive>");
            AppMethodBeat.o(207733);
        }
    }

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(207734);
        y yVar = new y();
        AppMethodBeat.o(207734);
        return yVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(207735);
        if (bVar != null) {
            if (bVar.type == 60) {
                if (map == null) {
                    p.hyc();
                }
                String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.mmlive.live_id"));
                p.g(nullAsNil, "Util.nullAsNil(values!![….appmsg.mmlive.live_id\"])");
                this.hJs = nullAsNil;
                String nullAsNil2 = Util.nullAsNil(map.get(".msg.appmsg.title"));
                p.g(nullAsNil2, "Util.nullAsNil(values!![\".msg.appmsg.title\"])");
                this.hwb = nullAsNil2;
                String nullAsNil3 = Util.nullAsNil(map.get(".msg.appmsg.thumburl"));
                p.g(nullAsNil3, "Util.nullAsNil(values!![\".msg.appmsg.thumburl\"])");
                this.thumbUrl = nullAsNil3;
                Log.i("MicroMsg.ShareLiveAppMsgPiece", toString());
            }
            AppMethodBeat.o(207735);
            return;
        }
        AppMethodBeat.o(207735);
    }

    public final String toString() {
        AppMethodBeat.i(207736);
        String str = "ShareLiveAppMsgPiece(liveId='" + this.hJs + "', liveName='" + this.hwb + "', thumbUrl='" + this.thumbUrl + "')";
        AppMethodBeat.o(207736);
        return str;
    }
}
