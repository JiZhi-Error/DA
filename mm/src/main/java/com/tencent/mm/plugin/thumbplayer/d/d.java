package com.tencent.mm.plugin.thumbplayer.d;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\"J\u0006\u0010'\u001a\u00020\"J\u0006\u0010(\u001a\u00020\"J\b\u0010)\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R-\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0017`\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/thumbplayer/model/MvPlayReportInfo;", "", "()V", "TAG", "", "effectReportInfo", "Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "getEffectReportInfo", "()Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;", "setEffectReportInfo", "(Lcom/tencent/mm/plugin/thumbplayer/model/EffectorReportInfo;)V", "errorCount", "", "getErrorCount", "()I", "firstFrame", "", "getFirstFrame", "()J", "setFirstFrame", "(J)V", "mediaReportInfo", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "Lkotlin/collections/HashMap;", "getMediaReportInfo", "()Ljava/util/HashMap;", "playTime", "getPlayTime", "setPlayTime", "startTick", "getStartTick", "setStartTick", "appendPlayerInfo", "", FirebaseAnalytics.b.INDEX, "info", "getPlayInfoJson", "reset", "start", "stop", "toString", "plugin-thumbplayer_release"})
public final class d {
    private final String TAG = "MicroMsg.MV.MvReportInfo";
    public c VfJ;
    public long VfK;
    public final HashMap<Integer, b> VfL = new HashMap<>();
    public long gXF;
    public long vgo;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010'\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "", "Lcom/tencent/mm/plugin/thumbplayer/model/CdnTPPlayerReportInfo;", "invoke"})
    static final class a extends q implements b<Map.Entry<Integer, b>, String> {
        public static final a VfM = new a();

        static {
            AppMethodBeat.i(260003);
            AppMethodBeat.o(260003);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Map.Entry<Integer, b> entry) {
            AppMethodBeat.i(260002);
            Map.Entry<Integer, b> entry2 = entry;
            p.h(entry2, LocaleUtil.ITALIAN);
            String str = entry2.getKey() + ":[" + entry2.getValue() + "] ";
            AppMethodBeat.o(260002);
            return str;
        }
    }

    public d() {
        AppMethodBeat.i(260007);
        AppMethodBeat.o(260007);
    }

    public final void a(int i2, b bVar) {
        AppMethodBeat.i(260004);
        p.h(bVar, "info");
        if (this.VfL.isEmpty() || this.VfK <= 0) {
            this.VfK = bVar.Vfx;
        }
        c cVar = this.VfJ;
        if (cVar != null) {
            bVar.VfB = (int) ((((float) cVar.VfF) * 1.0f) / ((float) cVar.VfE));
            bVar.VfC = cVar.VfG;
            bVar.VfD = cVar.VfH;
            cVar.reset();
        }
        this.VfL.put(Integer.valueOf(i2), bVar);
        Log.i(this.TAG, i2 + ", " + bVar);
        AppMethodBeat.o(260004);
    }

    public final String hXD() {
        AppMethodBeat.i(260005);
        try {
            i iVar = new i();
            for (Map.Entry<Integer, b> entry : this.VfL.entrySet()) {
                i iVar2 = new i();
                iVar2.v("firstFrame", entry.getValue().Vfx).v("playTime", entry.getValue().vgo).U("waitCount", entry.getValue().Vfy).U("renderTime", entry.getValue().VfB);
                if (entry.getValue().hXC()) {
                    iVar2.U("errType", entry.getValue().errType).U("errCode", entry.getValue().errCode);
                }
                if (entry.getValue().VfC > 0) {
                    iVar2.U("ptsNegative", entry.getValue().VfC);
                }
                if (entry.getValue().VfD > 0) {
                    iVar2.U("ptsOutOfBound", entry.getValue().VfD);
                }
                iVar.h(String.valueOf(entry.getKey().intValue()), iVar2);
            }
            String iVar3 = iVar.toString();
            p.g(iVar3, "obj.toString()");
            String j2 = n.j(iVar3, ",", ";", false);
            AppMethodBeat.o(260005);
            return j2;
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "getJson", new Object[0]);
            AppMethodBeat.o(260005);
            return "";
        }
    }

    public final String toString() {
        AppMethodBeat.i(260006);
        Set<Map.Entry<Integer, b>> entrySet = this.VfL.entrySet();
        p.g(entrySet, "mediaReportInfo.entries");
        String a2 = j.a(entrySet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.VfM, 31);
        AppMethodBeat.o(260006);
        return a2;
    }
}
