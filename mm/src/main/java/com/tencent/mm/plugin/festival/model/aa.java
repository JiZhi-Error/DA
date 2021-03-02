package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.n.d;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u001cH\u0007J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0006\u0010 \u001a\u00020\fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\u001cJ\u0015\u0010%\u001a\u00020\u0004*\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishLikeLogic;", "", "()V", "SALT", "", "TAG", "finalSalt", "finalSalt$annotations", "getFinalSalt", "()Ljava/lang/String;", "friendsNameMap", "", "", "isFriendsNameMapGen", "", "<set-?>", "latestReadLikeRowId", "getLatestReadLikeRowId", "()I", "setLatestReadLikeRowId", "(I)V", "latestReadLikeRowId$delegate", "Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "HmacSHA256Encrypt", "text", "secretKey", "checkNeedRedDot", "genFriendsHashNameMap", "", "getHistoryLikeList", "", "Lcom/tencent/mm/plugin/festival/model/FestivalLikeMsgDao;", "getNewCount", "getNewLikeList", "isFriend", "hashUserName", "markRead", "xor", "that", "plugin-festival_release"})
public final class aa {
    private static final p Uzt = new p((Object) -1, f.a.LatestReadLikeRowId);
    private static final Map<String, Integer> Uzu = new LinkedHashMap();
    public static final aa Uzv = new aa();
    static final /* synthetic */ k[] cLI = {kotlin.g.b.aa.a(new v(kotlin.g.b.aa.bp(aa.class), "latestReadLikeRowId", "getLatestReadLikeRowId()I"))};

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements b<Character, String> {
        public static final a Uzw = new a();

        static {
            AppMethodBeat.i(263097);
            AppMethodBeat.o(263097);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Character ch) {
            AppMethodBeat.i(263096);
            String valueOf = String.valueOf(ch.charValue());
            AppMethodBeat.o(263096);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(263098);
        AppMethodBeat.o(263098);
    }

    private aa() {
    }

    public static final String hRD() {
        boolean z;
        AppMethodBeat.i(263099);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String a2 = aAh.azQ().a(ar.a.USERINFO_ACCOUNT_SALT_STRING_SYNC, (String) null);
        String str = a2;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.w("FestivalWishLikeLogic", "ACC_SALT is empty");
            AppMethodBeat.o(263099);
            return "";
        }
        String str2 = a2;
        ArrayList arrayList = new ArrayList(str2.length());
        int i2 = 0;
        int i3 = 0;
        while (i2 < str2.length()) {
            arrayList.add(Character.valueOf((char) ("b85df0d735cab5baef86cc9df8f3f99cb925e677e0b9a60cea3fb813ebf5b76e".charAt(i3) ^ str2.charAt(i2))));
            i2++;
            i3++;
        }
        String a3 = j.a(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.Uzw, 30);
        AppMethodBeat.o(263099);
        return a3;
    }

    public static final String fA(String str, String str2) {
        AppMethodBeat.i(263100);
        p.h(str, "text");
        p.h(str2, "secretKey");
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            byte[] bytes = str2.getBytes(d.UTF_8);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.init(new SecretKeySpec(bytes, "HmacSHA256"));
            byte[] bytes2 = str.getBytes(d.UTF_8);
            p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
            String encodeHexString = Util.encodeHexString(instance.doFinal(bytes2));
            p.g(encodeHexString, "Util.encodeHexString(sha…inal(text.toByteArray()))");
            AppMethodBeat.o(263100);
            return encodeHexString;
        } catch (Exception e2) {
            AppMethodBeat.o(263100);
            return "";
        }
    }
}
