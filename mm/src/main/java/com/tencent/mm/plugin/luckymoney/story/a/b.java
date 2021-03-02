package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.wallet_core.c.a;
import java.util.Iterator;

public final class b extends a<buh, a> {
    @Override // com.tencent.mm.wallet_core.c.a
    public final void b(c.a<buh> aVar) {
        int delete;
        long j2;
        AppMethodBeat.i(182472);
        Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (aVar.errType == 0 && aVar.errCode == 0 && ((buh) aVar.iLC).MaT != null) {
            com.tencent.mm.plugin.luckymoney.story.b.a aVar2 = new com.tencent.mm.plugin.luckymoney.story.b.a();
            aVar2.field_packet_id = ((a) this.iLD).yZF;
            ((buh) aVar.iLC).MaT.VjK = ((buh) aVar.iLC).VjK;
            boolean z = com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get(aVar2, new String[0]);
            Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "get story info: %s, %s", ((a) this.iLD).yZF, Boolean.valueOf(z));
            com.tencent.mm.plugin.luckymoney.story.b.a.a(aVar2, ((buh) aVar.iLC).MaT, ((a) this.iLD).yZF, ((buh) aVar.iLC).VjK);
            aVar2.field_update_time = System.currentTimeMillis();
            if (z) {
                com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().update(aVar2, new String[0]);
            } else {
                com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().insert(aVar2);
            }
            d eev = com.tencent.mm.plugin.luckymoney.b.a.eex().eev();
            String str = ((a) this.iLD).yZF;
            if (Util.isNullOrNil(str)) {
                delete = -1;
            } else {
                Log.i("MicroMsg.LocalRedPacketStoryInfoStorage", "delete story detail: %s", str);
                delete = eev.db.delete("LocalStoryDetail", "packet_id=?", new String[]{str});
            }
            Log.i("MicroMsg.RedPacketStoryInfoAsyncLoader", "delete story detail: %s", Integer.valueOf(delete));
            if (!((buh) aVar.iLC).MaT.MPo.isEmpty()) {
                d eev2 = com.tencent.mm.plugin.luckymoney.b.a.eex().eev();
                if (eev2.db != null) {
                    j2 = ((ISQLiteDatabaseEx) eev2.db).beginTransaction(Thread.currentThread().getId());
                } else {
                    j2 = -1;
                }
                Iterator<edn> it = ((buh) aVar.iLC).MaT.MPo.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.luckymoney.b.a.eex().eev().insert(com.tencent.mm.plugin.luckymoney.story.b.c.a(it.next(), ((a) this.iLD).yZF));
                }
                d eev3 = com.tencent.mm.plugin.luckymoney.b.a.eex().eev();
                if (eev3.db != null) {
                    ((ISQLiteDatabaseEx) eev3.db).endTransaction(j2);
                }
                AppMethodBeat.o(182472);
                return;
            }
            Log.w("MicroMsg.RedPacketStoryInfoAsyncLoader", "story detail is empty!!");
        }
        AppMethodBeat.o(182472);
    }

    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    @Override // com.tencent.mm.wallet_core.c.a
    public final /* synthetic */ buh efb() {
        AppMethodBeat.i(163690);
        String str = ((a) this.iLD).yZF;
        com.tencent.mm.plugin.luckymoney.story.b.a aVar = new com.tencent.mm.plugin.luckymoney.story.b.a();
        aVar.field_packet_id = str;
        if (com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get(aVar, new String[0])) {
            dlt a2 = com.tencent.mm.plugin.luckymoney.story.b.a.a(aVar);
            a2.MPo.addAll(com.tencent.mm.plugin.luckymoney.b.a.eex().eev().aDB(((a) this.iLD).yZF));
            buh buh = new buh();
            buh.BaseResponse = new BaseResponse();
            buh.MaT = a2;
            AppMethodBeat.o(163690);
            return buh;
        }
        AppMethodBeat.o(163690);
        return null;
    }
}
