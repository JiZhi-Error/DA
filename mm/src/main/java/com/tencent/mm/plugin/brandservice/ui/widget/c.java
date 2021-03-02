package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class c {
    private static a pNN;
    private static a pNO;
    public static final c pNP = new c();

    static {
        AppMethodBeat.i(179028);
        AppMethodBeat.o(179028);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "", "mode", "", "desc", "", "(Ljava/lang/String;IFLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getMode", "()F", "SLOW05", "SLOW075", "NORMAL", "FAST15", "FAST20", "Companion", "plugin-brandservice_release"})
    public enum a {
        SLOW05(0.5f, "0.5X"),
        SLOW075(0.75f, "0.75X"),
        NORMAL(1.0f, "1.0X"),
        FAST15(1.5f, "1.5X"),
        FAST20(2.0f, "2.0X");
        
        public static List<? extends a> pNX = j.listOf((Object[]) new a[]{SLOW05, SLOW075, NORMAL, FAST15, FAST20});
        public static final C0897a pNY = new C0897a((byte) 0);
        public final String desc;
        public final float pNW;

        public static a valueOf(String str) {
            AppMethodBeat.i(179026);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(179026);
            return aVar;
        }

        private a(float f2, String str) {
            this.pNW = f2;
            this.desc = str;
        }

        static {
            AppMethodBeat.i(179024);
            AppMethodBeat.o(179024);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed$Companion;", "", "()V", "speedList", "", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.c$a$a  reason: collision with other inner class name */
        public static final class C0897a {
            private C0897a() {
            }

            public /* synthetic */ C0897a(byte b2) {
                this();
            }
        }
    }

    public static a crx() {
        return pNN == null ? a.NORMAL : pNN;
    }

    public static void a(a aVar) {
        pNN = pNO == null ? a.NORMAL : pNO;
        pNO = aVar;
    }

    public static a cry() {
        return pNO == null ? a.NORMAL : pNO;
    }

    public static void crz() {
        AppMethodBeat.i(179027);
        pNN = a.NORMAL;
        a(a.NORMAL);
        AppMethodBeat.o(179027);
    }
}
