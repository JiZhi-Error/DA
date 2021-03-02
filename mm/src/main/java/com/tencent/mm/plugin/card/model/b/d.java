package com.tencent.mm.plugin.card.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "cardId", "", "userCardId", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d extends j<dmt> {
    private static final String TAG = TAG;
    public static final a pVB = new a((byte) 0);

    public d(String str, String str2) {
        p.h(str, "cardId");
        p.h(str2, "userCardId");
        AppMethodBeat.i(201378);
        dms dms = new dms();
        dmt dmt = new dmt();
        dms.eaO = str;
        dms.KDM = str2;
        a(dms, dmt, 2986, "/cgi-bin/mmpay-bin/mktremovecardinrecentlyusedlist");
        Log.i(TAG, "card_id: " + str + ", code: " + str2);
        AppMethodBeat.o(201378);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v3/CgiRemoveCardInRecentlyUsedList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(201379);
        AppMethodBeat.o(201379);
    }
}
