package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0015\u0016\u0017\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport;", "", "()V", "LoginReportID", "", "RegReportID", "loginReport", "", "accountType", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "loginUrl", "", "type", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "result", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "childCount", "errCode", "regReport", "kidsUIN", "Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "AccountType", "LoginResult", "LoginType", "RegResult", "Scene", "plugin-kidswatch_release"})
public final class c {
    public static final c yAF = new c();

    static {
        AppMethodBeat.i(256196);
        AppMethodBeat.o(256196);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_RESULT_SUCCESS", "LOGIN_RESULT_TURN_TO_REG", "LOGIN_RESULT_CANCEL", "LOGIN_RESULT_FAIL", "plugin-kidswatch_release"})
    public enum b {
        LOGIN_RESULT_SUCCESS(1),
        LOGIN_RESULT_TURN_TO_REG(2),
        LOGIN_RESULT_CANCEL(3),
        LOGIN_RESULT_FAIL(4);
        
        final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(256187);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(256187);
            return bVar;
        }

        private b(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(256185);
            AppMethodBeat.o(256185);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$LoginType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LOGIN_TYPE_DEFAULT", "LOGIN_TYPE_BOTH", "LOGIN_TYPE_WATCH_ONLY", "plugin-kidswatch_release"})
    /* renamed from: com.tencent.mm.plugin.kidswatch.model.c$c  reason: collision with other inner class name */
    public enum EnumC1454c {
        LOGIN_TYPE_DEFAULT(0),
        LOGIN_TYPE_BOTH(1),
        LOGIN_TYPE_WATCH_ONLY(2);
        
        final int value;

        public static EnumC1454c valueOf(String str) {
            AppMethodBeat.i(256190);
            EnumC1454c cVar = (EnumC1454c) Enum.valueOf(EnumC1454c.class, str);
            AppMethodBeat.o(256190);
            return cVar;
        }

        private EnumC1454c(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(256188);
            AppMethodBeat.o(256188);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$AccountType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ACCOUNT_TYPE_NORMAL", "ACCOUNT_TYPE_KIDS", "plugin-kidswatch_release"})
    public enum a {
        ACCOUNT_TYPE_NORMAL(0),
        ACCOUNT_TYPE_KIDS(1);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(256184);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(256184);
            return aVar;
        }

        private a(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(256182);
            AppMethodBeat.o(256182);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/model/KidsWatchReport$RegResult;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "REG_RESULT_SUCCESS", "REG_RESULT_FAIL", "REG_RESULT_CANCEL", "plugin-kidswatch_release"})
    public enum d {
        REG_RESULT_SUCCESS(1),
        REG_RESULT_FAIL(2),
        REG_RESULT_CANCEL(3);
        
        final int value;

        public static d valueOf(String str) {
            AppMethodBeat.i(256193);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(256193);
            return dVar;
        }

        private d(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(256191);
            AppMethodBeat.o(256191);
        }
    }

    public static void a(a aVar, String str, EnumC1454c cVar, b bVar, int i2, int i3) {
        AppMethodBeat.i(256194);
        p.h(aVar, "accountType");
        p.h(str, "loginUrl");
        p.h(cVar, "type");
        p.h(bVar, "result");
        h.INSTANCE.a(21127, true, true, false, Integer.valueOf(bVar.value), Integer.valueOf(cVar.value), str, Integer.valueOf(i2), Integer.valueOf(aVar.value), Integer.valueOf(i3));
        AppMethodBeat.o(256194);
    }

    public static void a(String str, d dVar, int i2) {
        AppMethodBeat.i(256195);
        p.h(str, "kidsUIN");
        p.h(dVar, "result");
        h.INSTANCE.a(21256, true, true, false, str, Integer.valueOf(dVar.value), Integer.valueOf(i2));
        AppMethodBeat.o(256195);
    }
}
