package com.tencent.mm.emoji.loader.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "url", "", "path", "authKey", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getPath", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-emojisdk_release"})
public final class e {
    final String authKey;
    final EmojiInfo gWm;
    final int gWn;
    final String path;
    final String url;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r3.gWn == r4.gWn) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 105434(0x19bda, float:1.47745E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x003c
            boolean r0 = r4 instanceof com.tencent.mm.emoji.loader.c.e
            if (r0 == 0) goto L_0x0041
            com.tencent.mm.emoji.loader.c.e r4 = (com.tencent.mm.emoji.loader.c.e) r4
            com.tencent.mm.storage.emotion.EmojiInfo r0 = r3.gWm
            com.tencent.mm.storage.emotion.EmojiInfo r1 = r4.gWm
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r3.url
            java.lang.String r1 = r4.url
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r3.path
            java.lang.String r1 = r4.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r3.authKey
            java.lang.String r1 = r4.authKey
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            int r0 = r3.gWn
            int r1 = r4.gWn
            if (r0 != r1) goto L_0x0041
        L_0x003c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0040:
            return r0
        L_0x0041:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.loader.c.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(105433);
        EmojiInfo emojiInfo = this.gWm;
        int hashCode = (emojiInfo != null ? emojiInfo.hashCode() : 0) * 31;
        String str = this.url;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.path;
        int hashCode3 = ((str2 != null ? str2.hashCode() : 0) + hashCode2) * 31;
        String str3 = this.authKey;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = ((hashCode3 + i2) * 31) + this.gWn;
        AppMethodBeat.o(105433);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(105432);
        String str = "EmojiFetcherConfig(emojiInfo=" + this.gWm + ", url=" + this.url + ", path=" + this.path + ", authKey=" + this.authKey + ", fetcherType=" + this.gWn + ")";
        AppMethodBeat.o(105432);
        return str;
    }

    public e(EmojiInfo emojiInfo, String str, String str2, String str3, int i2) {
        p.h(emojiInfo, "emojiInfo");
        p.h(str, "url");
        p.h(str2, "path");
        p.h(str3, "authKey");
        AppMethodBeat.i(105431);
        this.gWm = emojiInfo;
        this.url = str;
        this.path = str2;
        this.authKey = str3;
        this.gWn = i2;
        AppMethodBeat.o(105431);
    }
}
