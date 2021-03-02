package com.tencent.mm.plugin.emojicapture.model.a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sticker.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "", "()V", "attachEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getAttachEmoji", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "setAttachEmoji", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "attachEmojiMatrix", "Landroid/graphics/Matrix;", "getAttachEmojiMatrix", "()Landroid/graphics/Matrix;", "setAttachEmojiMatrix", "(Landroid/graphics/Matrix;)V", "attachText", "", "getAttachText", "()Ljava/lang/String;", "setAttachText", "(Ljava/lang/String;)V", "attachTextColor", "", "getAttachTextColor", "()I", "setAttachTextColor", "(I)V", "enableRemoveBg", "", "getEnableRemoveBg", "()Z", "setEnableRemoveBg", "(Z)V", "removeBg", "getRemoveBg", "setRemoveBg", "scene", "getScene", "setScene", "stickerInfo", "Lcom/tencent/mm/sticker/StickerPack;", "getStickerInfo", "()Lcom/tencent/mm/sticker/StickerPack;", "setStickerInfo", "(Lcom/tencent/mm/sticker/StickerPack;)V", "thumbPath", "getThumbPath", "setThumbPath", "timeEnter", "", "getTimeEnter", "()J", "setTimeEnter", "(J)V", "videoPath", "getVideoPath", "setVideoPath", "plugin-emojicapture_release"})
public final class b {
    public long hdz;
    public boolean rnN;
    public f roL;
    public String roM;
    public int roN;
    public boolean roO = true;
    public EmojiInfo roP;
    public Matrix roQ = new Matrix();
    public int scene = 1;
    public String thumbPath = "";
    public String videoPath = "";

    public b() {
        AppMethodBeat.i(212);
        AppMethodBeat.o(212);
    }

    public final void setVideoPath(String str) {
        AppMethodBeat.i(210);
        p.h(str, "<set-?>");
        this.videoPath = str;
        AppMethodBeat.o(210);
    }

    public final void HA(String str) {
        AppMethodBeat.i(211);
        p.h(str, "<set-?>");
        this.thumbPath = str;
        AppMethodBeat.o(211);
    }
}
