package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"checkUseCdn", "", "fetcherType", "", "checkUseEncrypt", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkUseTpUrl", "checkUseWxam", "plugin-emojisdk_release"})
public final class i {
    public static final boolean h(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105444);
        p.h(emojiInfo, "emojiInfo");
        if (Util.isNullOrNil(emojiInfo.field_tpurl) || Util.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.o(105444);
            return false;
        }
        AppMethodBeat.o(105444);
        return true;
    }

    public static final boolean i(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105445);
        p.h(emojiInfo, "emojiInfo");
        if (!n.avc() || Util.isNullOrNil(emojiInfo.field_externUrl) || Util.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.o(105445);
            return false;
        }
        AppMethodBeat.o(105445);
        return true;
    }

    public static final boolean j(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105446);
        p.h(emojiInfo, "emojiInfo");
        if (Util.isNullOrNil(emojiInfo.field_encrypturl) || Util.isNullOrNil(emojiInfo.field_aeskey)) {
            AppMethodBeat.o(105446);
            return false;
        }
        AppMethodBeat.o(105446);
        return true;
    }
}
