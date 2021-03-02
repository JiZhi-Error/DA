package com.tencent.mm.emoji.panel.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(105631);
        int[] iArr = new int[EmojiInfo.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[EmojiInfo.b.ERR_NON_NETWORK.ordinal()] = 1;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_WIFI_NETWORK.ordinal()] = 2;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_MOBILE_NETWORK.ordinal()] = 3;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_NOT_COMPLETED.ordinal()] = 4;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_OVER_LIMIT.ordinal()] = 5;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_OTHERS.ordinal()] = 6;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_LOCAL_FILE.ordinal()] = 7;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_OVER_SIZE.ordinal()] = 8;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_SPAM.ordinal()] = 9;
        $EnumSwitchMapping$0[EmojiInfo.b.ERR_OVER_UPLOAD_TIME.ordinal()] = 10;
        int[] iArr2 = new int[EmojiInfo.a.values().length];
        haE = iArr2;
        iArr2[EmojiInfo.a.STATUS_SUCCESS.ordinal()] = 1;
        haE[EmojiInfo.a.STATUS_MIXING.ordinal()] = 2;
        haE[EmojiInfo.a.STATUS_UPLOADING.ordinal()] = 3;
        haE[EmojiInfo.a.STATUS_MIX_FAIL.ordinal()] = 4;
        haE[EmojiInfo.a.STATUS_UPLOAD_FAIL.ordinal()] = 5;
        AppMethodBeat.o(105631);
    }
}
