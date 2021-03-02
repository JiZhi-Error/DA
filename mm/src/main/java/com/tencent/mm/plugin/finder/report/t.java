package com.tencent.mm.plugin.finder.report;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nJ2\u0010\u0013\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ8\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderStreamCardAlbumReporter;", "", "()V", "report21086", "", "title", "", "cardFeed", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "position", "", "exposedTime", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "report21087", "cardId", NativeProtocol.WEB_DIALOG_ACTION, "feedId", "report21089", FirebaseAnalytics.b.INDEX, "report21090", "txtCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "clickWording", "plugin-finder_release"})
public final class t {
    public static final t vhJ = new t();

    static {
        AppMethodBeat.i(250802);
        AppMethodBeat.o(250802);
    }

    private t() {
    }

    public static void a(String str, long j2, int i2, int i3, bbn bbn) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(250798);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = d.zs(j2);
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        if (bbn != null) {
            str2 = bbn.sessionId;
        } else {
            str2 = null;
        }
        objArr[4] = str2;
        objArr[5] = bbn != null ? bbn.sGQ : null;
        if (bbn != null) {
            str3 = bbn.sGE;
        }
        objArr[6] = str3;
        hVar.a(21089, objArr);
        AppMethodBeat.o(250798);
    }

    public static void a(String str, long j2, int i2, bdb bdb, String str2, bbn bbn) {
        AppMethodBeat.i(250799);
        p.h(str, "title");
        p.h(bdb, "txtCard");
        p.h(str2, "clickWording");
        LinkedList<String> linkedList = bdb.LMR;
        p.g(linkedList, "txtCard.link_wording");
        int i3 = 0;
        String str3 = "";
        for (T t : linkedList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t2 = t;
            StringBuilder append = new StringBuilder().append(str3).append(bdb.LMT.isEmpty() ? "" : bdb.LMT.get(i3)).append(';').append((String) t2).append(';').append(i3).append(';');
            i3 = i4;
            str3 = append.append(p.j(str2, t2) ? 1 : 0).append('|').toString();
        }
        n.c(str3, (CharSequence) "|");
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = d.zs(j2);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i2 + 1);
        objArr[3] = str3;
        objArr[4] = bbn != null ? bbn.sessionId : null;
        objArr[5] = bbn != null ? bbn.sGQ : null;
        objArr[6] = bbn != null ? bbn.sGE : null;
        hVar.a(21090, objArr);
        Log.i("report21090", String.valueOf(str));
        AppMethodBeat.o(250799);
    }

    public static void a(String str, long j2, int i2, long j3, bbn bbn, int i3) {
        Integer num;
        String str2 = null;
        AppMethodBeat.i(250800);
        p.h(str, "title");
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[9];
        if (bbn != null) {
            num = Integer.valueOf(bbn.tCE);
        } else {
            num = null;
        }
        objArr[0] = num;
        objArr[1] = d.zs(j2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = d.zs(j3);
        objArr[5] = bbn != null ? bbn.sessionId : null;
        objArr[6] = bbn != null ? bbn.sGQ : null;
        if (bbn != null) {
            str2 = bbn.sGE;
        }
        objArr[7] = str2;
        objArr[8] = Integer.valueOf(i3);
        hVar.a(21087, objArr);
        AppMethodBeat.o(250800);
    }

    public static void a(String str, ag agVar, int i2, long j2, bbn bbn) {
        Integer num;
        AppMethodBeat.i(250801);
        p.h(agVar, "cardFeed");
        bcu bcu = agVar.tQQ;
        int i3 = 0;
        String str2 = "";
        for (T t : agVar.rvFeedList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t2 = t;
            String zs = d.zs(t2.lT());
            if (t2.cxn() == 4 && i3 == 0) {
                i3 = i4;
                str2 = str2 + zs + ';' + i3 + ";1|";
            } else {
                i3 = i4;
                str2 = str2 + zs + ';' + i3 + ";0|";
            }
        }
        n.c(str2, (CharSequence) "|");
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[11];
        if (bbn != null) {
            num = Integer.valueOf(bbn.tCE);
        } else {
            num = null;
        }
        objArr[0] = num;
        objArr[1] = d.zs(agVar.tQQ.id);
        objArr[2] = str;
        objArr[3] = str2;
        objArr[4] = bcu.LLT;
        objArr[5] = Integer.valueOf(agVar.rvFeedList.size());
        objArr[6] = bbn != null ? bbn.sessionId : null;
        objArr[7] = bbn != null ? bbn.sGQ : null;
        objArr[8] = bbn != null ? bbn.sGE : null;
        objArr[9] = Long.valueOf(j2);
        objArr[10] = Integer.valueOf(i2);
        hVar.a(21086, objArr);
        AppMethodBeat.o(250801);
    }
}
