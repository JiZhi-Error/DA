package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    public static boolean cHz() {
        AppMethodBeat.i(109438);
        boolean gED = k.getEmojiStorageMgr().OpO.gED();
        AppMethodBeat.o(109438);
        return gED;
    }

    public static boolean g(EmotionSummary emotionSummary) {
        AppMethodBeat.i(109439);
        if (emotionSummary == null) {
            AppMethodBeat.o(109439);
            return false;
        }
        boolean ang = ang(emotionSummary.ProductID);
        AppMethodBeat.o(109439);
        return ang;
    }

    public static boolean b(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(109440);
        if (emojiGroupInfo == null) {
            AppMethodBeat.o(109440);
            return false;
        }
        boolean ang = ang(emojiGroupInfo.field_productID);
        AppMethodBeat.o(109440);
        return ang;
    }

    public static boolean ang(String str) {
        AppMethodBeat.i(109441);
        if (str == null) {
            AppMethodBeat.o(109441);
            return false;
        }
        boolean equals = str.equals(cIr());
        AppMethodBeat.o(109441);
        return equals;
    }

    public static final String cIr() {
        AppMethodBeat.i(109442);
        String sb = new StringBuilder().append(EmojiGroupInfo.VkN).toString();
        AppMethodBeat.o(109442);
        return sb;
    }
}
