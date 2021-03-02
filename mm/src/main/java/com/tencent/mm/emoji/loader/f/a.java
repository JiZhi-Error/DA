package com.tencent.mm.emoji.loader.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.e;
import com.tencent.mm.emoji.loader.c.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import javax.crypto.BadPaddingException;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/emoji/loader/verify/EmojiFileVerify;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkFixAesKey", "", "verifyConfig", "Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reportDecrypt", "success", "", "reportVerify", "verify", "plugin-emojisdk_release"})
public final class a {
    private final String TAG = "MicroMsg.EmojiLoader.EmojiFileVerify";

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
    /* renamed from: com.tencent.mm.emoji.loader.f.a$a  reason: collision with other inner class name */
    public static final class C0329a extends q implements m<Boolean, e, x> {
        public static final C0329a gWP = new C0329a();

        static {
            AppMethodBeat.i(199907);
            AppMethodBeat.o(199907);
        }

        C0329a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, e eVar) {
            AppMethodBeat.i(199906);
            bool.booleanValue();
            x xVar = x.SXb;
            AppMethodBeat.o(199906);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(b bVar, boolean z) {
        AppMethodBeat.i(105486);
        if (z) {
            switch (bVar.gWn) {
                case 1:
                    d.CK(7);
                    AppMethodBeat.o(105486);
                    return;
                case 2:
                    d.CK(11);
                    AppMethodBeat.o(105486);
                    return;
                case 3:
                    d.CK(24);
                    AppMethodBeat.o(105486);
                    return;
                default:
                    AppMethodBeat.o(105486);
                    return;
            }
        } else {
            EmojiInfo emojiInfo = bVar.gWm;
            switch (bVar.gWn) {
                case 1:
                    d.CK(8);
                    d.a(emojiInfo.getMd5(), 3, 0, 1, emojiInfo.avy(), 1, emojiInfo.field_designerID);
                    AppMethodBeat.o(105486);
                    return;
                case 2:
                    d.CK(12);
                    d.a(emojiInfo.getMd5(), 4, 0, 1, emojiInfo.avy(), 1, emojiInfo.field_designerID);
                    AppMethodBeat.o(105486);
                    return;
                case 3:
                    d.CK(25);
                    break;
            }
            AppMethodBeat.o(105486);
        }
    }

    public final boolean a(b bVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(105485);
        p.h(bVar, "verifyConfig");
        if (bVar.gWR) {
            try {
                byte[] c2 = com.tencent.mm.b.a.c(s.aW(bVar.gWS, 0, -1), Base64.encodeToString(Util.decodeHexString(bVar.aesKey), 0));
                if (c2 == null || s.C(bVar.path, c2) != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                s.deleteFile(bVar.gWS);
                if (!z2) {
                    Log.w(this.TAG, "decrypt failed : " + bVar.aesKey);
                    a(bVar, false);
                    AppMethodBeat.o(105485);
                    return false;
                }
                a(bVar, true);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "decrypt exception : " + bVar.aesKey, new Object[0]);
                a(bVar, false);
                if (e2 instanceof BadPaddingException) {
                    Log.i(this.TAG, "checkFixAesKey: " + bVar.aesKey);
                    EmojiInfo emojiInfo = bVar.gWm;
                    if (!Util.isNullOrNil(emojiInfo.field_tpurl)) {
                        emojiInfo.field_externUrl = "";
                        emojiInfo.field_encrypturl = "";
                        emojiInfo.field_cdnUrl = "";
                        emojiInfo.field_tpurl = "";
                        emojiInfo.field_aeskey = "";
                        new f(emojiInfo, C0329a.gWP);
                    }
                }
                AppMethodBeat.o(105485);
                return false;
            }
        } else {
            s.nx(bVar.gWS, bVar.path);
        }
        String bhK = s.bhK(bVar.path);
        Log.i(this.TAG, "file md5 " + bhK + ", " + bVar.gWQ);
        if (Util.isNullOrNil(bhK) || !n.I(bhK, bVar.gWQ, true)) {
            z = false;
        } else {
            z = true;
        }
        EmojiInfo emojiInfo2 = bVar.gWm;
        if (!z) {
            switch (bVar.gWn) {
                case 0:
                    d.a(emojiInfo2.getMd5(), 4, 1, 1, emojiInfo2.avy(), 1, emojiInfo2.field_designerID);
                    d.CK(5);
                    break;
                case 1:
                    d.a(emojiInfo2.getMd5(), 2, 1, 1, emojiInfo2.avy(), 1, emojiInfo2.field_designerID);
                    d.CK(5);
                    break;
                case 2:
                    d.a(emojiInfo2.getMd5(), 4, 1, 1, emojiInfo2.avy(), 1, emojiInfo2.field_designerID);
                    d.CK(14);
                    break;
                case 3:
                    d.CK(27);
                    break;
            }
        } else {
            switch (bVar.gWn) {
                case 0:
                    d.a(emojiInfo2.getMd5(), 4, 0, 0, emojiInfo2.avy(), 0, emojiInfo2.field_designerID);
                    d.CK(4);
                    break;
                case 1:
                    d.a(emojiInfo2.getMd5(), 2, 0, 0, emojiInfo2.avy(), 0, emojiInfo2.field_designerID);
                    d.CK(4);
                    break;
                case 2:
                    d.a(emojiInfo2.getMd5(), 4, 0, 0, emojiInfo2.avy(), 1, emojiInfo2.field_designerID);
                    d.CK(13);
                    break;
                case 3:
                    d.CK(26);
                    break;
            }
        }
        if (!z || !g.aAf().azp()) {
            AppMethodBeat.o(105485);
            return false;
        }
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        ((com.tencent.mm.plugin.emoji.b.d) ah).getEmojiMgr().a(bVar.gWm, true);
        AppMethodBeat.o(105485);
        return true;
    }
}
