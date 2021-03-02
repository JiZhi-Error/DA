package com.tencent.mm.emoji.panel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(105628);
        int[] iArr = new int[EmojiInfo.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[EmojiInfo.a.STATUS_SUCCESS.ordinal()] = 1;
        $EnumSwitchMapping$0[EmojiInfo.a.STATUS_MIXING.ordinal()] = 2;
        $EnumSwitchMapping$0[EmojiInfo.a.STATUS_UPLOADING.ordinal()] = 3;
        $EnumSwitchMapping$0[EmojiInfo.a.STATUS_MIX_FAIL.ordinal()] = 4;
        $EnumSwitchMapping$0[EmojiInfo.a.STATUS_UPLOAD_FAIL.ordinal()] = 5;
        AppMethodBeat.o(105628);
    }
}
