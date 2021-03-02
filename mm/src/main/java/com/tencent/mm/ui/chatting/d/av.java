package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.al;
import com.tencent.mm.ui.chatting.gallery.a.l;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/ui/chatting/component/ScanComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IScanComponent;", "()V", "onChattingExitAnimEnd", "", "Companion", "app_release"})
@com.tencent.mm.ui.chatting.d.a.a(gRF = al.class)
public final class av extends a implements al {
    public static final a Ptn = new a((byte) 0);

    static {
        AppMethodBeat.i(231220);
        AppMethodBeat.o(231220);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/component/ScanComponent$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(231219);
        super.gIo();
        l.a aVar = com.tencent.mm.ui.chatting.gallery.a.l.PCP;
        Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo clearCache previewResult size: %d, msgIdToPHashCache size: %d", Integer.valueOf(com.tencent.mm.ui.chatting.gallery.a.l.PCN.size()), Integer.valueOf(com.tencent.mm.ui.chatting.gallery.a.l.PCO.size()));
        com.tencent.mm.ui.chatting.gallery.a.l.PCN.clear();
        com.tencent.mm.ui.chatting.gallery.a.l.PCO.clear();
        AppMethodBeat.o(231219);
    }
}
