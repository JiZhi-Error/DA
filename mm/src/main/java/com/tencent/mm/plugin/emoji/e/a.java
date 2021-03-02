package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Random;

public final class a {
    static void amh(String str) {
        AppMethodBeat.i(108393);
        for (String str2 : str.replace("delete", "").trim().split(",")) {
            ((d) g.ah(d.class)).getEmojiMgr().amm(str2).hYj();
        }
        AppMethodBeat.o(108393);
    }

    static void ami(String str) {
        AppMethodBeat.i(108394);
        String[] split = str.split(" ");
        if (split.length <= 1) {
            AppMethodBeat.o(108394);
        } else if (split[1].equals("custom")) {
            for (EmojiInfo emojiInfo : bj.gCJ().Oqb.auO()) {
                emojiInfo.hYj();
            }
            AppMethodBeat.o(108394);
        } else {
            if (split[1].equals("customRandom")) {
                Random random = new Random();
                for (EmojiInfo emojiInfo2 : bj.gCJ().Oqb.auO()) {
                    if (random.nextBoolean()) {
                        emojiInfo2.hYj();
                    }
                }
            }
            AppMethodBeat.o(108394);
        }
    }
}
