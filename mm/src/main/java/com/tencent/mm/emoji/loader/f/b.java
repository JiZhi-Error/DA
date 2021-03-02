package com.tencent.mm.emoji.loader.f;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006%"}, hxF = {"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verifyMd5", "", "needDecrypt", "", "aesKey", "path", "tempPath", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAesKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getNeedDecrypt", "()Z", "getPath", "getTempPath", "getVerifyMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-emojisdk_release"})
public final class b {
    final String aesKey;
    final String gWQ;
    final boolean gWR;
    final String gWS;
    final EmojiInfo gWm;
    final int gWn;
    final String path;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r3.gWn == r4.gWn) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 105490(0x19c12, float:1.47823E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x004c
            boolean r0 = r4 instanceof com.tencent.mm.emoji.loader.f.b
            if (r0 == 0) goto L_0x0051
            com.tencent.mm.emoji.loader.f.b r4 = (com.tencent.mm.emoji.loader.f.b) r4
            com.tencent.mm.storage.emotion.EmojiInfo r0 = r3.gWm
            com.tencent.mm.storage.emotion.EmojiInfo r1 = r4.gWm
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r3.gWQ
            java.lang.String r1 = r4.gWQ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            boolean r0 = r3.gWR
            boolean r1 = r4.gWR
            if (r0 != r1) goto L_0x0051
            java.lang.String r0 = r3.aesKey
            java.lang.String r1 = r4.aesKey
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r3.path
            java.lang.String r1 = r4.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r3.gWS
            java.lang.String r1 = r4.gWS
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0051
            int r0 = r3.gWn
            int r1 = r4.gWn
            if (r0 != r1) goto L_0x0051
        L_0x004c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0050:
            return r0
        L_0x0051:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.loader.f.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(105489);
        EmojiInfo emojiInfo = this.gWm;
        int hashCode = (emojiInfo != null ? emojiInfo.hashCode() : 0) * 31;
        String str = this.gWQ;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        boolean z = this.gWR;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (i3 + hashCode2) * 31;
        String str2 = this.aesKey;
        int hashCode3 = ((str2 != null ? str2.hashCode() : 0) + i6) * 31;
        String str3 = this.path;
        int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + hashCode3) * 31;
        String str4 = this.gWS;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i7 = ((hashCode4 + i2) * 31) + this.gWn;
        AppMethodBeat.o(105489);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(105488);
        String str = "EmojiVerifyConfig(emojiInfo=" + this.gWm + ", verifyMd5=" + this.gWQ + ", needDecrypt=" + this.gWR + ", aesKey=" + this.aesKey + ", path=" + this.path + ", tempPath=" + this.gWS + ", fetcherType=" + this.gWn + ")";
        AppMethodBeat.o(105488);
        return str;
    }

    public b(EmojiInfo emojiInfo, String str, boolean z, String str2, String str3, String str4, int i2) {
        p.h(emojiInfo, "emojiInfo");
        p.h(str, "verifyMd5");
        p.h(str2, "aesKey");
        p.h(str3, "path");
        p.h(str4, "tempPath");
        AppMethodBeat.i(105487);
        this.gWm = emojiInfo;
        this.gWQ = str;
        this.gWR = z;
        this.aesKey = str2;
        this.path = str3;
        this.gWS = str4;
        this.gWn = i2;
        AppMethodBeat.o(105487);
    }
}
