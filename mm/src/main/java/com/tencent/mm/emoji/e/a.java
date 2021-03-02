package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\t¨\u0006\""}, hxF = {"Lcom/tencent/mm/emoji/util/EmojiFileUtil;", "", "()V", "MaxThumbSize", "", "TAG", "", "dataEmojiRoot", "getDataEmojiRoot", "()Ljava/lang/String;", "emojiGifRoot", "getEmojiGifRoot", "emojiResAnim", "getEmojiResAnim", "emojiResEgg", "getEmojiResEgg", "emojiResNewEmoji", "getEmojiResNewEmoji", "emojiResPanel", "getEmojiResPanel", "emojiSystemRoot", "getEmojiSystemRoot", "emojiTempRoot", "getEmojiTempRoot", "emojiThumbRoot", "getEmojiThumbRoot", "emojiThumbSuffix", "getEmojiThumbSuffix", "emojiVFSRoot", "getEmojiVFSRoot", "getThumbPath", "md5", "removeAllGenerateThumb", "", "plugin-emojisdk_release"})
public final class a {
    private static final String TAG = TAG;
    private static final long hdP = hdP;
    private static final String hdQ = awt();
    private static final String hdR = (awt() + "/temp/");
    private static final String hdS = hdS;
    public static final a hdT = new a();

    static {
        AppMethodBeat.i(177058);
        AppMethodBeat.o(177058);
    }

    private a() {
    }

    public static String awt() {
        AppMethodBeat.i(200004);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.b.a ah = g.ah(d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        e provider = ((d) ah).getProvider();
        p.g(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        String sb2 = sb.append(provider.getAccPath()).append("emoji/").toString();
        AppMethodBeat.o(200004);
        return sb2;
    }

    public static String awu() {
        return hdR;
    }

    public static String awv() {
        AppMethodBeat.i(200005);
        String str = b.aKC() + "emoji/";
        AppMethodBeat.o(200005);
        return str;
    }

    public static String aww() {
        AppMethodBeat.i(200006);
        String str = awv() + "emoji_anim/";
        AppMethodBeat.o(200006);
        return str;
    }

    public static String EX(String str) {
        AppMethodBeat.i(177056);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(177056);
            return null;
        }
        String str2 = hdQ + str + hdS;
        AppMethodBeat.o(177056);
        return str2;
    }

    public static void awx() {
        AppMethodBeat.i(177057);
        ArrayList<EmojiInfo> dT = j.auL().dT(true);
        p.g(dT, "emojiList");
        for (T t : dT) {
            if (Util.isNullOrNil(((EmojiInfo) t).field_thumbUrl)) {
                p.g(t, LocaleUtil.ITALIAN);
                s.deleteFile(t.hYy());
            }
        }
        AppMethodBeat.o(177057);
    }
}
