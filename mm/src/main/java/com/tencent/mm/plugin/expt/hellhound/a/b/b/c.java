package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00032\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig;", "", "()V", "Companion", "PageReportType", "ShareType", "TopicType", "VisiableState", "WaterfallsFlowSceneEnum", "plugin-expt_release"})
public final class c {
    private static boolean hSh;
    public static int sEA = 1001;
    private static String sEB = "";
    private static boolean sEC;
    private static String sED = "";
    private static String sEE = "";
    private static String sEF = "";
    private static String sEG = "";
    private static String sEH = "";
    private static float sEI;
    private static final List<String> sEJ = new ArrayList();
    private static final List<String> sEK = new ArrayList();
    private static final List<String> sEL = new ArrayList();
    private static final List<String> sEM = new ArrayList();
    private static final List<String> sEN = new ArrayList();
    private static final List<String> sEO = new ArrayList();
    public static int sEP = -1;
    public static String sEQ;
    public static String sER;
    public static String sES;
    private static final ArrayList<String> sET;
    private static final ArrayList<String> sEU = j.ac("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI");
    private static final ArrayList<String> sEV = j.ac("com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI", "com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI2");
    private static final ArrayList<String> sEW = j.ac("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", "com.tencent.mm.plugin.finder.feed.ui.FinderNewUIC", "com.tencent.mm.plugin.finder.feed.ui.FinderTimelineLbsUI", "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI", "com.tencent.mm.plugin.finder.search.FinderMixSearchUI", "com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI", "com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI");
    private static int sEX = d.Words.value;
    private static String sEY = "";
    private static String sEZ = "";
    public static boolean sEl;
    private static final Map<Integer, Map<String, i>> sEm = new LinkedHashMap();
    private static final Map<String, Map<String, i>> sEn = new LinkedHashMap();
    private static String sEo;
    private static int sEp;
    public static String sEq = "";
    public static String sEr = "";
    public static String sEs = "";
    public static boolean sEt;
    private static boolean sEu = true;
    private static boolean sEv = true;
    public static String sEw = "";
    public static long sEx;
    public static String sEy = "";
    private static String sEz = "";
    public static final a sFa = new a((byte) 0);

    public static final int cPi() {
        AppMethodBeat.i(220946);
        int cPi = a.cPi();
        AppMethodBeat.o(220946);
        return cPi;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "VISIABLE_ON_SCROLL", "INVISIABLE_ON_SCROLL", "VISIABLE_ON_RESUME", "INVISIABLE_ON_PAUSE", "EVENT_ON_DESTROY", "plugin-expt_release"})
    public enum e {
        VISIABLE_ON_SCROLL(0),
        INVISIABLE_ON_SCROLL(1),
        VISIABLE_ON_RESUME(2),
        INVISIABLE_ON_PAUSE(3),
        EVENT_ON_DESTROY(4);
        
        public final int state;

        public static e valueOf(String str) {
            AppMethodBeat.i(220939);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(220939);
            return eVar;
        }

        private e(int i2) {
            this.state = i2;
        }

        static {
            AppMethodBeat.i(220937);
            AppMethodBeat.o(220937);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$ShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "SINGLE_CHAT", "GROUP_CHAT", "SNS", "JSAPI", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.b.c$c  reason: collision with other inner class name */
    public enum EnumC1015c {
        SINGLE_CHAT(1),
        GROUP_CHAT(2),
        SNS(3),
        JSAPI(4);
        
        final int type;

        public static EnumC1015c valueOf(String str) {
            AppMethodBeat.i(220933);
            EnumC1015c cVar = (EnumC1015c) Enum.valueOf(EnumC1015c.class, str);
            AppMethodBeat.o(220933);
            return cVar;
        }

        private EnumC1015c(int i2) {
            this.type = i2;
        }

        static {
            AppMethodBeat.i(220931);
            AppMethodBeat.o(220931);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020l0kJ\b\u0010\u0001\u001a\u00030\u0001J \u0010 \u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020l\u0018\u00010k2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\t\u0010¡\u0001\u001a\u00020\u0004H\u0007J\u0012\u0010¡\u0001\u001a\u00020\u00042\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010£\u0001\u001a\u00020\u00132\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0013J\t\u0010¥\u0001\u001a\u00020SH\u0007J\u0012\u0010¦\u0001\u001a\u00020S2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0013J\u0014\u0010¨\u0001\u001a\u00020S2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010ª\u0001\u001a\u00020S2\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0013J\u0012\u0010«\u0001\u001a\u00020S2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0013J\u0013\u0010¬\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001J\b\u0010­\u0001\u001a\u00030\u0001J\b\u0010®\u0001\u001a\u00030\u0001J\n\u0010¯\u0001\u001a\u00030\u0001H\u0007J\b\u0010°\u0001\u001a\u00030\u0001J\b\u0010±\u0001\u001a\u00030\u0001J\u0011\u0010²\u0001\u001a\u00030\u00012\u0007\u0010³\u0001\u001a\u00020SJ \u0010´\u0001\u001a\u00030\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0013H\u0007J!\u0010¶\u0001\u001a\u00030\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010\u00132\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0007J?\u0010¹\u0001\u001a\u00030\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010»\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R!\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u001b\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R%\u0010\u001c\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u000e\u0010\u001e\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00020E8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u0012\u0010N\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010P\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Q\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010WR\u0014\u0010[\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010]\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010^\u001a\u00020S8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00130`¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00130`X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00130`¢\u0006\b\n\u0000\u001a\u0004\be\u0010bR\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00130`X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00130`¢\u0006\b\n\u0000\u001a\u0004\bh\u0010bR\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00130`X\u0004¢\u0006\u0002\n\u0000R&\u0010j\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020l0k0kX\u0004¢\u0006\u0002\n\u0000R&\u0010m\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020l0k0kX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010n\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010o\u001a\u00020S8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010p\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010q\u001a\u00020rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0014\u0010w\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010U\"\u0004\b\u0010WR\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010z\"\u0005\b\u0001\u0010|R\u000f\u0010\u0001\u001a\u00020SX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010H\"\u0005\b\u0001\u0010JR\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010z\"\u0005\b\u0001\u0010|R\u000f\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010H\"\u0005\b\u0001\u0010JR\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010H\"\u0005\b\u0001\u0010JR\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010H\"\u0005\b\u0001\u0010JR\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010H\"\u0005\b\u0001\u0010JR\u001d\u0010\u0001\u001a\u00020\u0013X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010H\"\u0005\b\u0001\u0010J¨\u0006¿\u0001"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$Companion;", "", "()V", "ACTIVITY_ON_PAUSE", "", "ACTIVITY_ON_RESUME", "ACTIVITY_ON_STARTACTIVITY", "DISAPPEAR_TYPE_8Event", "DISAPPEAR_TYPE_NOREM", "DISAPPEAR_TYPE_PAGE_SWITCH", "DISAPPEAR_TYPE_REFRESH", "FEED_POS_LEFT", "FEED_POS_RIGHT", "FRAGMENT_ON_PAUSE", "FRAGMENT_ON_RESUME", "FRAGMENT_SWITCH_2_BACK", "FRAGMENT_SWITCH_2_FRONT", "PAGE_EXPOSURE_LIST", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPAGE_EXPOSURE_LIST", "()Ljava/util/ArrayList;", "PAGE_IN_OUT_LIST", "getPAGE_IN_OUT_LIST", "PRE_PAGE_LIST", "getPRE_PAGE_LIST", "TAG", "WATERFALLSFLOW_WHITE_LIST", "getWATERFALLSFLOW_WHITE_LIST", "_BulletSubtitleViewCallback_Header", "_FinderConversationUI", "_FinderFavFeedUI", "_FinderFavTimelineUI", "_FinderFeedRelTimelineUI", "_FinderFeedSearchUI", "_FinderFollowTabFragment", "_FinderFriendTabFragment", "_FinderHomeUI", "_FinderLbsStreamListUI", "_FinderLbsTabFragment", "_FinderLikedFeedUI", "_FinderLiveAnchorUI", "_FinderMachineTabFragment", "_FinderMixSearchUI", "_FinderMsgFeedDetailUI", "_FinderNewUIB", "_FinderNewUIC", "_FinderProfileTimeLineUI", "_FinderProfileUI", "_FinderSelfUI", "_FinderShareFeedDetailUI", "_FinderShareFeedRelUI", "_FinderTimelineLbsUI", "_FinderTimelineUI", "_FinderTopicFeedUI", "_FinderTopicTimelineUI", "_OccupyFinderUI2", "_SnsTimelineUI", "_sFinderConversationUI", "_sFinderFollowTabFragment", "_sFinderFriendTabFragment", "_sFinderHomeUI", "_sFinderLbsTabFragment", "_sFinderMachineTabFragment", "_sFinderSelfUI", "_sFinderTopicFeedUI", "_sSnsTimelineUI", "actionMs", "", "curClickId", "getCurClickId", "()Ljava/lang/String;", "setCurClickId", "(Ljava/lang/String;)V", "curFinderUserName", "getCurFinderUserName", "setCurFinderUserName", "curNearbyFragmentType", "enterSessionId", "gActivityActionLatest", "gCurFinderHomePage", "gCurIsPoiScene", "", "getGCurIsPoiScene", "()Z", "setGCurIsPoiScene", "(Z)V", "gCurIsShareScene", "getGCurIsShareScene", "setGCurIsShareScene", "gCurShareUserName", "gCurSnsFeedId", "gCurSnsSessionId", "gEnterFinderBySnsCamera", "gFeedIdLeftList", "", "getGFeedIdLeftList", "()Ljava/util/List;", "gFeedIdLeftListOnRefreshBegin", "gFeedIdList", "getGFeedIdList", "gFeedIdListOnRefreshBegin", "gFeedIdRightList", "getGFeedIdRightList", "gFeedIdRightListOnRefreshBegin", "gFeedMapCache0", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "gFeedMapCache1", "gFinishActivityName", "gLastVisible", "gPauseActivityName", "gScreenArea", "", "getGScreenArea", "()F", "setGScreenArea", "(F)V", "gStartActivityName", "gTopicType", "getGTopicType", "()I", "setGTopicType", "(I)V", "giftPanelShow", "getGiftPanelShow", "setGiftPanelShow", "identityType", "getIdentityType", "setIdentityType", "isLiving", "requestShareStateUserName", "getRequestShareStateUserName", "setRequestShareStateUserName", "shareStateCount", "getShareStateCount", "setShareStateCount", "snsAdData", "snsFinderUsername", "visitorAppId", "getVisitorAppId", "setVisitorAppId", "visitorClickId", "getVisitorClickId", "setVisitorClickId", "visitorLiveid", "getVisitorLiveid", "setVisitorLiveid", "visitorSessionid", "getVisitorSessionid", "setVisitorSessionid", "visitorShopwindowid", "getVisitorShopwindowid", "setVisitorShopwindowid", "addFeedMapCache", "", "page", "feedMap", "cacheFeedIdOnRefreshBegin", "getFeedMapCache", "getShareType", "sid", "getSnsAdData", "finderUsername", "inLiveRoom", "isFinderHomeUI", "pageName", "isFinderHomeUIFragment", "fragmentName", "isSameFinderUserName", "isShare", "removeFeedMapCache", "resetFeedIdCache", "resetFeedLeftRightCache", "resetSnsAdData", "resetVisitorCommerceParams", "restoreFeedIdOnRefreshEnd", "setInLiveRoom", "inRoom", "setSnsAdData", "snsAdInfo", "setTopicType", "intent", "Landroid/content/Intent;", "setVisitorCommerceParams", "clickId", "appId", "liveId", "shopwindowId", "sessionid", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void apC(String str) {
            AppMethodBeat.i(220912);
            p.h(str, "<set-?>");
            c.sEz = str;
            AppMethodBeat.o(220912);
        }

        public static void apD(String str) {
            AppMethodBeat.i(220913);
            p.h(str, "<set-?>");
            c.sEB = str;
            AppMethodBeat.o(220913);
        }

        private static void apE(String str) {
            AppMethodBeat.i(220914);
            p.h(str, "<set-?>");
            c.sED = str;
            AppMethodBeat.o(220914);
        }

        private static void apF(String str) {
            AppMethodBeat.i(220915);
            p.h(str, "<set-?>");
            c.sEE = str;
            AppMethodBeat.o(220915);
        }

        private static void apG(String str) {
            AppMethodBeat.i(220916);
            p.h(str, "<set-?>");
            c.sEF = str;
            AppMethodBeat.o(220916);
        }

        private static void apH(String str) {
            AppMethodBeat.i(220917);
            p.h(str, "<set-?>");
            c.sEG = str;
            AppMethodBeat.o(220917);
        }

        private static void apI(String str) {
            AppMethodBeat.i(220918);
            p.h(str, "<set-?>");
            c.sEH = str;
            AppMethodBeat.o(220918);
        }

        public static void f(String str, String str2, String str3, String str4, String str5) {
            AppMethodBeat.i(220919);
            if (str == null) {
                str = "";
            }
            apE(str);
            if (str2 == null) {
                str2 = "";
            }
            apF(str2);
            if (str3 == null) {
                str3 = "";
            }
            apG(str3);
            if (str4 == null) {
                str4 = "";
            }
            apH(str4);
            if (str5 == null) {
                str5 = "";
            }
            apI(str5);
            AppMethodBeat.o(220919);
        }

        public static void djP() {
            AppMethodBeat.i(259539);
            apE("");
            apF("");
            apG("");
            apH("");
            apI("");
            AppMethodBeat.o(259539);
        }

        public static void cPj() {
            AppMethodBeat.i(220920);
            Log.i("HABBYGE-MALI.HellFinderConfig", "resetFeedIdCache...");
            c.sEJ.clear();
            cPk();
            AppMethodBeat.o(220920);
        }

        public static int cPi() {
            AppMethodBeat.i(220922);
            com.tencent.mm.plugin.expt.hellhound.a.f.b cPO = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
            p.g(cPO, "HellSessionMonitor.getInstance()");
            String cPQ = cPO.cPQ();
            if (apK(cPQ)) {
                int apJ = apJ(cPQ);
                AppMethodBeat.o(220922);
                return apJ;
            }
            AppMethodBeat.o(220922);
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
            if (r3.equals("999") != false) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.equals("101") != false) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
            r0 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.EnumC1015c.sFf.type;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int apJ(java.lang.String r3) {
            /*
                r2 = 220923(0x35efb, float:3.09579E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                r0 = 0
                if (r3 != 0) goto L_0x000d
            L_0x0009:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return r0
            L_0x000d:
                int r1 = r3.hashCode()
                switch(r1) {
                    case 48626: goto L_0x0015;
                    case 48627: goto L_0x0031;
                    case 48690: goto L_0x0023;
                    case 56601: goto L_0x003f;
                    default: goto L_0x0014;
                }
            L_0x0014:
                goto L_0x0009
            L_0x0015:
                java.lang.String r1 = "101"
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x0009
            L_0x001e:
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c$c r0 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.EnumC1015c.SINGLE_CHAT
                int r0 = r0.type
                goto L_0x0009
            L_0x0023:
                java.lang.String r1 = "123"
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x0009
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c$c r0 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.EnumC1015c.SNS
                int r0 = r0.type
                goto L_0x0009
            L_0x0031:
                java.lang.String r1 = "102"
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x0009
                com.tencent.mm.plugin.expt.hellhound.a.b.b.c$c r0 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.EnumC1015c.GROUP_CHAT
                int r0 = r0.type
                goto L_0x0009
            L_0x003f:
                java.lang.String r1 = "999"
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x0009
                goto L_0x001e
                switch-data {48626->0x0015, 48627->0x0031, 48690->0x0023, 56601->0x003f, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.apJ(java.lang.String):int");
        }

        public static boolean apK(String str) {
            AppMethodBeat.i(220924);
            if (p.j("999", str) || p.j("101", str) || p.j("102", str) || p.j("123", str)) {
                AppMethodBeat.o(220924);
                return true;
            }
            AppMethodBeat.o(220924);
            return false;
        }

        public static boolean apL(String str) {
            AppMethodBeat.i(220925);
            if (str == null) {
                AppMethodBeat.o(220925);
                return false;
            }
            boolean j2 = p.j(str, c.sEZ);
            AppMethodBeat.o(220925);
            return j2;
        }

        public static String apM(String str) {
            AppMethodBeat.i(220926);
            if (str == null) {
                AppMethodBeat.o(220926);
                return "";
            } else if (p.j(c.sEZ, str)) {
                String str2 = c.sEY;
                AppMethodBeat.o(220926);
                return str2;
            } else {
                AppMethodBeat.o(220926);
                return "";
            }
        }

        public static void cPl() {
            AppMethodBeat.i(220927);
            c.sEY = "";
            c.sEZ = "";
            AppMethodBeat.o(220927);
        }

        public static void cPk() {
            AppMethodBeat.i(220921);
            c.sEK.clear();
            c.sEL.clear();
            AppMethodBeat.o(220921);
        }
    }

    static {
        AppMethodBeat.i(220943);
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.szf;
        p.g(str, "HellhoundUtil._sChattingUIFragment");
        sET = j.ac(str, "ChattingUI", "SnsTimeLineUI", "FavoriteIndexUI");
        AppMethodBeat.o(220943);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
    public enum f {
        LBS(1000),
        TOPIC(1001),
        POI(1002),
        SEARCH(1004),
        OTHER_PROFILE(1006),
        FAVORITE(1008);
        
        public final int value;

        public static f valueOf(String str) {
            AppMethodBeat.i(220942);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(220942);
            return fVar;
        }

        private f(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(220940);
            AppMethodBeat.o(220940);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$TopicType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Words", "Poi", "plugin-expt_release"})
    public enum d {
        Words(1),
        Poi(2);
        
        public final int value;

        public static d valueOf(String str) {
            AppMethodBeat.i(220936);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(220936);
            return dVar;
        }

        private d(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(220934);
            AppMethodBeat.o(220934);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
    public enum b {
        EXPOSURE(0),
        INOUT(1),
        INOUT_WITHOUT_78EVENT(2);
        
        public final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(220930);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(220930);
            return bVar;
        }

        private b(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(220928);
            AppMethodBeat.o(220928);
        }
    }

    public static final boolean apB(String str) {
        AppMethodBeat.i(220944);
        if (str != null) {
            if (n.a((CharSequence) str, (CharSequence) ".", false)) {
                if (p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment", str) || p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment", str) || p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment", str) || p.j("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment", str)) {
                    AppMethodBeat.o(220944);
                    return true;
                }
                AppMethodBeat.o(220944);
                return false;
            } else if (p.j("FinderFollowTabFragment", str) || p.j("FinderFriendTabFragment", str) || p.j("FinderLbsTabFragment", str) || p.j("FinderMachineTabFragment", str)) {
                AppMethodBeat.o(220944);
                return true;
            }
        }
        AppMethodBeat.o(220944);
        return false;
    }

    public static final void d(String str, Intent intent) {
        int i2;
        AppMethodBeat.i(220945);
        if (p.j(str, "com.tencent.mm.plugin.finder.feed.ui.FinderTopicFeedUI")) {
            if (intent != null) {
                i2 = intent.getIntExtra("key_topic_type", d.Words.value);
            } else {
                i2 = d.Words.value;
            }
            sEX = i2;
            Log.i("HABBYGE-MALI.HellFinderConfig", "setTopicType: " + sEX);
        }
        AppMethodBeat.o(220945);
    }

    public static final void gr(String str, String str2) {
        AppMethodBeat.i(220947);
        if (str == null || str2 == null) {
            sEY = "";
            sEZ = "";
            AppMethodBeat.o(220947);
            return;
        }
        sEY = str;
        sEZ = str2;
        Log.i("HABBYGE-MALI.HellFinderConfig", "setSnsAdData, snsAdData=" + sEY + ", snsFinderUsername=" + sEZ);
        AppMethodBeat.o(220947);
    }
}
