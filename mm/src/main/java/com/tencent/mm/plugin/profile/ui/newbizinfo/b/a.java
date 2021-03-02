package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "", "()V", "headerList", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "list", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "now", "Ljava/util/Calendar;", "nowDay", "", "nowYear", "<set-?>", "size", "getSize", "()I", "getDateString", "", "position", "getHeaderItem", "getHeaderItemType", "getItem", "getItemType", "update", "", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "updateHeader", "notifyInfo", "Companion", "ItemType", "app_release"})
public final class a {
    public static final C1585a Bke = new C1585a((byte) 0);
    private final LinkedList<o<b, dey>> Bka = new LinkedList<>();
    private final Calendar Bkb;
    private final int Bkc;
    private final int Bkd;
    private final LinkedList<o<b, ou>> gCs = new LinkedList<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "SectionToday", "SectionYesterday", "SectionThisWeek", "SectionThisYear", "SectionFullDate", "Message", "Loading", "VideoChannel", "app_release"})
    public enum b {
        SectionToday,
        SectionYesterday,
        SectionThisWeek,
        SectionThisYear,
        SectionFullDate,
        Message,
        Loading,
        VideoChannel;

        static {
            AppMethodBeat.i(39628);
            AppMethodBeat.o(39628);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(39630);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(39630);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(169910);
        AppMethodBeat.o(169910);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b.a$a  reason: collision with other inner class name */
    public static final class C1585a {
        private C1585a() {
        }

        public /* synthetic */ C1585a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(39633);
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        p.g(instance, "Calendar.getInstance().apply { time = Date() }");
        this.Bkb = instance;
        this.Bkc = this.Bkb.get(6);
        this.Bkd = this.Bkb.get(1);
        AppMethodBeat.o(39633);
    }

    public final void b(ov ovVar) {
        AppMethodBeat.i(230657);
        p.h(ovVar, "msgList");
        this.gCs.clear();
        p.g(Calendar.getInstance(), "Calendar.getInstance()");
        new Date();
        LinkedList<ou> linkedList = ovVar.KVw;
        p.g(linkedList, "msgList.Msg");
        for (T t : linkedList) {
            this.gCs.add(new o<>(b.SectionFullDate, t));
            this.gCs.add(new o<>(b.Message, t));
        }
        pf pfVar = ovVar.KVx;
        if (pfVar != null) {
            if (pfVar.KWa == 0) {
                this.gCs.add(new o<>(b.Loading, new ou()));
            }
            AppMethodBeat.o(230657);
            return;
        }
        AppMethodBeat.o(230657);
    }

    public final void a(dey dey) {
        AppMethodBeat.i(230658);
        if (dey != null && c.clv()) {
            LinkedList<cty> linkedList = dey.MJY;
            p.g(linkedList, "notifyInfo.notify_list");
            if (!linkedList.isEmpty()) {
                Log.i("MicroMsg.BizMessageAdapter", "alvinluo updateHeader add video channel");
                this.Bka.clear();
                this.Bka.add(new o<>(b.VideoChannel, dey));
            }
        }
        AppMethodBeat.o(230658);
    }

    public final int getSize() {
        AppMethodBeat.i(230659);
        int size = this.gCs.size() + this.Bka.size();
        AppMethodBeat.o(230659);
        return size;
    }

    public final String UT(int i2) {
        AppMethodBeat.i(230660);
        Context context = MMApplicationContext.getContext();
        UU(i2);
        Object item = getItem(i2);
        if (item == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
            AppMethodBeat.o(230660);
            throw tVar;
        }
        long j2 = ((long) ((ou) item).KVq.LmE) * 1000;
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j2));
        p.g(instance, "Calendar.getInstance().apply { time = Date(date) }");
        DateFormat.format(context.getString(R.string.df6), j2);
        String obj = f.y(context, j2).toString();
        AppMethodBeat.o(230660);
        return obj;
    }

    public final b UU(int i2) {
        AppMethodBeat.i(39631);
        if (i2 < this.Bka.size()) {
            b UV = UV(i2);
            AppMethodBeat.o(39631);
            return UV;
        }
        A a2 = this.gCs.get(i2 - this.Bka.size()).first;
        AppMethodBeat.o(39631);
        return a2;
    }

    private final b UV(int i2) {
        AppMethodBeat.i(169907);
        A a2 = this.Bka.get(i2).first;
        AppMethodBeat.o(169907);
        return a2;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(169908);
        if (i2 < this.Bka.size()) {
            dey UW = UW(i2);
            AppMethodBeat.o(169908);
            return UW;
        }
        B b2 = this.gCs.get(i2 - this.Bka.size()).second;
        AppMethodBeat.o(169908);
        return b2;
    }

    private final dey UW(int i2) {
        AppMethodBeat.i(169909);
        B b2 = this.Bka.get(i2).second;
        AppMethodBeat.o(169909);
        return b2;
    }
}
