package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u000b\u001a\u00020\f\u001a\u0006\u0010\r\u001a\u00020\f\u001a\u0006\u0010\u000e\u001a\u00020\f\u001a\u0006\u0010\u000f\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u0014\u0010\t\u001a\u00020\u0001XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004¨\u0006\u0010"}, hxF = {"TAG", "", "captureGroupId", "getCaptureGroupId", "()Ljava/lang/String;", "customGroupId", "getCustomGroupId", "smileyGroupId", "getSmileyGroupId", "smileyRecentGroupId", "getSmileyRecentGroupId", "createCaptureGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createCustomGroupInfo", "createSmileyGroupInfo", "createSmileyRecentGroupInfo", "plugin-emojisdk_release"})
public final class ad {
    private static final String TAG = TAG;
    private static final String gYZ = gYZ;
    private static final String gZa = gZa;
    private static final String gZb = gZb;
    private static final String gZc = gZc;

    public static final String avB() {
        return gYZ;
    }

    public static final String avC() {
        return gZb;
    }

    public static final String avD() {
        return gZc;
    }

    public static final EmojiGroupInfo avE() {
        AppMethodBeat.i(105574);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.setProductID(gZa);
        emojiGroupInfo.byF(MMApplicationContext.getContext().getString(R.string.bt4));
        AppMethodBeat.o(105574);
        return emojiGroupInfo;
    }

    public static final EmojiGroupInfo avF() {
        AppMethodBeat.i(105575);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.setProductID(gYZ);
        emojiGroupInfo.byF(MMApplicationContext.getContext().getString(R.string.bt5));
        AppMethodBeat.o(105575);
        return emojiGroupInfo;
    }

    public static final EmojiGroupInfo avG() {
        AppMethodBeat.i(105576);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.setProductID(gZb);
        emojiGroupInfo.byF(MMApplicationContext.getContext().getString(R.string.bsz));
        AppMethodBeat.o(105576);
        return emojiGroupInfo;
    }

    public static final EmojiGroupInfo avH() {
        AppMethodBeat.i(105577);
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.setProductID(gZc);
        emojiGroupInfo.byF(MMApplicationContext.getContext().getString(R.string.bsy));
        AppMethodBeat.o(105577);
        return emojiGroupInfo;
    }
}
