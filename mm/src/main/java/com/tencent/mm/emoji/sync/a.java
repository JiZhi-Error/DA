package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.il;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/BackupEmojiOperateResponse;", "customType", "", "opcode", "md5List", "", "", "(IILjava/util/List;)V", "Companion", "plugin-emojisdk_release"})
public final class a extends c<il> {
    private static final int hcs = 1;
    private static final int hct = 2;
    private static final int hcu = 3;
    public static final C0335a hcv = new C0335a((byte) 0);

    public a(int i2, List<String> list) {
        p.h(list, "md5List");
        AppMethodBeat.i(105728);
        ik ikVar = new ik();
        il ilVar = new il();
        ikVar.KMz = 4;
        ikVar.KMy.addAll(list);
        ikVar.xIY = i2;
        d.a aVar = new d.a();
        aVar.c(ikVar);
        aVar.d(ilVar);
        aVar.MB("/cgi-bin/micromsg-bin/mmbackupemojioperate");
        aVar.sG(698);
        c(aVar.aXF());
        AppMethodBeat.o(105728);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/sync/CgiBackupEmojiOperate$Companion;", "", "()V", "MM_EMOJI_BACKUP_ADD", "", "getMM_EMOJI_BACKUP_ADD", "()I", "MM_EMOJI_BACKUP_ADD_TO_TOP", "MM_EMOJI_BACKUP_DEL", "getMM_EMOJI_BACKUP_DEL", "MM_EMOJI_BACKUP_TOP", "getMM_EMOJI_BACKUP_TOP", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.sync.a$a  reason: collision with other inner class name */
    public static final class C0335a {
        private C0335a() {
        }

        public /* synthetic */ C0335a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(105729);
        AppMethodBeat.o(105729);
    }
}
