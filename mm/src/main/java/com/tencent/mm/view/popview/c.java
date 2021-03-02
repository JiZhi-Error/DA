package com.tencent.mm.view.popview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ai;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.b.p;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class c {
    public static AbstractPopView b(Context context, Object obj) {
        AppMethodBeat.i(105303);
        if ((obj instanceof p) || (obj instanceof ai)) {
            SmileyPopView smileyPopView = new SmileyPopView(context);
            AppMethodBeat.o(105303);
            return smileyPopView;
        } else if ((obj instanceof h) || (obj instanceof EmojiInfo)) {
            EmojiPopView emojiPopView = new EmojiPopView(context);
            AppMethodBeat.o(105303);
            return emojiPopView;
        } else {
            EmojiPopView emojiPopView2 = new EmojiPopView(context);
            AppMethodBeat.o(105303);
            return emojiPopView2;
        }
    }

    public static void a(AbstractPopView abstractPopView, Object obj) {
        AppMethodBeat.i(105304);
        if (abstractPopView instanceof EmojiPopView) {
            if (obj instanceof EmojiInfo) {
                ((EmojiPopView) abstractPopView).setEmojiInfo((EmojiInfo) obj);
                AppMethodBeat.o(105304);
                return;
            } else if (obj instanceof h) {
                ((EmojiPopView) abstractPopView).setEmojiInfo(((h) obj).gWm);
                AppMethodBeat.o(105304);
                return;
            }
        } else if (abstractPopView instanceof SmileyPopView) {
            if (obj instanceof p) {
                ((SmileyPopView) abstractPopView).setSmileyItem((p) obj);
                AppMethodBeat.o(105304);
                return;
            } else if (obj instanceof ai) {
                ((SmileyPopView) abstractPopView).setSmileyItem(((ai) obj).gZf);
            }
        }
        AppMethodBeat.o(105304);
    }
}
