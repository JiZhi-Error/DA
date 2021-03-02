package com.tencent.mm.ui.chatting.h;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.l.b;
import com.tencent.mm.ui.chatting.n.f;
import java.util.LinkedList;
import java.util.List;

public final class a implements c<ca> {
    private SparseArray<ca> PDv;
    private com.tencent.mm.ui.chatting.e.a dom;

    public a(com.tencent.mm.ui.chatting.e.a aVar, SparseArray<ca> sparseArray) {
        this.dom = aVar;
        this.PDv = sparseArray;
    }

    @Override // com.tencent.mm.ui.chatting.h.c
    public final void a(final d.a aVar, final f<ca> fVar, final d.C2097d<ca> dVar, final d.b bVar) {
        AppMethodBeat.i(36418);
        b bVar2 = b.PEW;
        switch (b.AnonymousClass1.PEY[dVar.PDL.ordinal()]) {
            case 1:
                int[] iArr = bVar2.PEX;
                iArr[0] = iArr[0] + 1;
                break;
            case 2:
                int[] iArr2 = bVar2.PEX;
                iArr2[1] = iArr2[1] + 1;
                break;
            case 3:
                int[] iArr3 = bVar2.PEX;
                iArr3[2] = iArr3[2] + 1;
                break;
            case 4:
                if (dVar.PDK != null && dVar.PDK.getInt("SCENE") == 1) {
                    int[] iArr4 = bVar2.PEX;
                    iArr4[3] = iArr4[3] + 1;
                    break;
                } else {
                    int[] iArr5 = bVar2.PEX;
                    iArr5[4] = iArr5[4] + 1;
                    break;
                }
                break;
        }
        if (fVar == null) {
            Log.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
            bVar.next();
            AppMethodBeat.o(36418);
            return;
        }
        fVar.a(new d.b() {
            /* class com.tencent.mm.ui.chatting.h.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.chatting.h.d.b
            public final void next() {
                AppMethodBeat.i(36417);
                fVar.jA(dVar.PDM);
                fVar.close();
                dVar.gAZ = fVar.cZm();
                dVar.PDN = dVar.PDM.size();
                Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + aVar + " addCount:" + dVar.PDN + " totalCount:" + dVar.gAZ);
                bVar.next();
                AppMethodBeat.o(36417);
            }
        });
        AppMethodBeat.o(36418);
    }

    @Override // com.tencent.mm.ui.chatting.h.c
    public final SparseArray<ca> jv(List<ca> list) {
        AppMethodBeat.i(36419);
        if (list == null) {
            list = new LinkedList<>();
            Log.e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
        }
        try {
            if (list.size() > 0 && this.dom != null) {
                String talkerUserName = this.dom.getTalkerUserName();
                ca caVar = list.get(0);
                if (caVar != null && !Util.isNullOrNil(talkerUserName) && !Util.isNullOrNil(caVar.field_talker) && !Util.isEqual(caVar.field_talker, talkerUserName)) {
                    Log.i("MicroMsg.ChattingLoader.ChattingDataCallback", "talker not equal, chattingContextTalker:%s, msgInfoTalker:%s", caVar.field_talker, talkerUserName);
                    h.INSTANCE.a(18264, caVar.field_talker, talkerUserName);
                    h.INSTANCE.n(1151, 0, 1);
                    SparseArray<ca> sparseArray = this.PDv;
                    AppMethodBeat.o(36419);
                    return sparseArray;
                }
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.ChattingLoader.ChattingDataCallback", th, "fillData Exception", new Object[0]);
            h.INSTANCE.n(1151, 1, 1);
        }
        this.PDv.clear();
        int i2 = 0;
        for (ca caVar2 : list) {
            SparseArray<ca> sparseArray2 = this.PDv;
            sparseArray2.put(i2, caVar2);
            i2++;
            if (!(caVar2 == null || !caVar2.isText() || caVar2.field_content == null)) {
                caVar2.setContent(caVar2.field_content.replaceAll("‮", ""));
            }
        }
        SparseArray<ca> sparseArray3 = this.PDv;
        AppMethodBeat.o(36419);
        return sparseArray3;
    }
}
