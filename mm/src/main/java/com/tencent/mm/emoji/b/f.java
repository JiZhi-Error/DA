package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/model/CgiUploadEmojiPrepare;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UploadEmojiPrepareResponse;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Z)V", "plugin-emojisdk_release"})
public final class f extends c<enh> {
    public f(EmojiInfo emojiInfo, boolean z) {
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105501);
        eng eng = new eng();
        enh enh = new enh();
        eng.MD5 = emojiInfo.field_md5;
        eng.Nli = true;
        eng.Nld = z;
        ArrayList<String> hYw = emojiInfo.hYw();
        if (hYw != null) {
            eng.Nle.addAll(hYw);
        }
        eng.Lsm = emojiInfo.field_attachedText;
        eng.Lsn = emojiInfo.field_attachTextColor;
        eng.Nlf = emojiInfo.field_imitateMd5;
        eng.Lso = emojiInfo.field_lensId;
        eng.Scene = 0;
        d.a aVar = new d.a();
        aVar.c(eng);
        aVar.d(enh);
        aVar.MB("/cgi-bin/micromsg-bin/mmuploademojiprepare");
        aVar.sG(3886);
        c(aVar.aXF());
        AppMethodBeat.o(105501);
    }
}
