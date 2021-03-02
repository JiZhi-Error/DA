package com.tencent.mm.emojisearch.d;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ$\u0010\u001d\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J<\u0010#\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J\u0016\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/emojisearch/report/EmojiSearchReport;", "", "()V", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_ICON", "", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_MORE", "EMOJI_SEARCH_ENTRANCE_ACTION_TYPE_CLICK_SEARCH_STORE", "EMOJI_SEARCH_ENTRANCE_KV_KEY", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEARCH_RESULT", "EMOJI_SEARCH_EXPOSE_ACTION_TYPE_SEND_EMOJI", "EMOJI_SEARCH_EXPOSE_KV_KEY", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_EDITTEXT_BRING", "EMOJI_SEARCH_EXPOSE_QUERY_SOURCE_TYPE_USER_INPUT", "chatId", "", SearchIntents.EXTRA_QUERY, "querySource", "reportCount", "reportIndex", "reportMD5", "searchId", "sessionId", "enableReport", "", "start", "", "markClickSearchMore", "", "markClickSearchStore", "markSearchResultByEmojiInfo", "emojiInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "totalCount", FirebaseAnalytics.b.INDEX, "markSearchResultByMd5", "md5List", "markSendEmoji", "md5", "position", "markShowEmojiSearchPanel", "plugin-emojisdk_release"})
public final class a {
    private static String gVs = "";
    private static int gXY;
    private static String hes = "";
    private static int het = 1;
    private static String heu = "";
    private static int hev;
    public static final a hew = new a();
    private static String query = "";
    private static String sessionId = "";

    static {
        AppMethodBeat.i(200036);
        AppMethodBeat.o(200036);
    }

    private a() {
    }

    public static void a(String str, String str2, ArrayList<String> arrayList, int i2, int i3, int i4) {
        AppMethodBeat.i(200030);
        p.h(str, SearchIntents.EXTRA_QUERY);
        p.h(str2, "sessionId");
        p.h(arrayList, "md5List");
        query = str;
        sessionId = str2;
        het = i3;
        gXY = i2;
        hev = i4;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next()).append("#");
        }
        String stringBuffer2 = stringBuffer.toString();
        p.g(stringBuffer2, "md5String.toString()");
        heu = stringBuffer2;
        h.INSTANCE.a(21159, str, str2, hes, 1, heu, Integer.valueOf(i2), 0, Integer.valueOf(i3), gVs, Integer.valueOf(i4));
        AppMethodBeat.o(200030);
    }

    public static void b(ArrayList<EmojiInfo> arrayList, int i2, int i3) {
        AppMethodBeat.i(200031);
        p.h(arrayList, "emojiInfoList");
        gXY = i2;
        hev = i3;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<EmojiInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            EmojiInfo next = it.next();
            p.g(next, "emoji");
            stringBuffer.append(next.getMd5()).append("#");
        }
        String stringBuffer2 = stringBuffer.toString();
        p.g(stringBuffer2, "md5String.toString()");
        heu = stringBuffer2;
        h.INSTANCE.a(21159, query, sessionId, hes, 1, heu, Integer.valueOf(i2), 0, Integer.valueOf(het), gVs, Integer.valueOf(i3));
        AppMethodBeat.o(200031);
    }

    public static void R(String str, int i2) {
        AppMethodBeat.i(200032);
        p.h(str, "md5");
        h.INSTANCE.a(21159, query, sessionId, hes, 2, str, 1, Integer.valueOf(i2), Integer.valueOf(het), gVs, Integer.valueOf(hev));
        AppMethodBeat.o(200032);
    }

    public static void Fb(String str) {
        AppMethodBeat.i(200033);
        p.h(str, "chatId");
        hes = String.valueOf(System.currentTimeMillis());
        gVs = str;
        h.INSTANCE.a(21160, hes, sessionId, 0, 0, 0, 1);
        AppMethodBeat.o(200033);
    }

    public static void awz() {
        AppMethodBeat.i(200034);
        h.INSTANCE.a(21160, hes, sessionId, 0, 0, 0, 2);
        AppMethodBeat.o(200034);
    }

    public static void awA() {
        AppMethodBeat.i(200035);
        h.INSTANCE.a(21160, hes, sessionId, 0, 0, 0, 3);
        AppMethodBeat.o(200035);
    }
}
