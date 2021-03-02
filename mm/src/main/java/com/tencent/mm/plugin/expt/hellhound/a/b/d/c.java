package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ll;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.d;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\r\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics;", "", "flowStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;)V", "feedObject_Field", "Ljava/lang/reflect/Field;", "getFlowStatistics", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "id_Field", "mListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1;", "fillShotScreenJson", "", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "feedMap", "", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "getFeed", "position", "", "feedId", "getListener", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "Companion", "plugin-expt_release"})
public final class c {
    public static final a sGX = new a((byte) 0);
    private Field sCe;
    private Method sFF;
    private Field sGU;
    public final b sGV;
    final j sGW;

    static {
        AppMethodBeat.i(221044);
        AppMethodBeat.o(221044);
    }

    public c(j jVar) {
        p.h(jVar, "flowStatistics");
        AppMethodBeat.i(221043);
        this.sGW = jVar;
        try {
            Class<?> cls = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            p.g(cls, "Class.forName(BaseFinderFeed_Name)");
            Field declaredField = cls.getDeclaredField("feedObject");
            p.g(declaredField, "BaseFinderFeed_Class.get…redField(feedObject_Name)");
            this.sCe = declaredField;
            Field field = this.sCe;
            if (field == null) {
                p.btv("feedObject_Field");
            }
            field.setAccessible(true);
            Class<?> cls2 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
            p.g(cls2, "Class.forName(FinderItem_Name)");
            Method declaredMethod = cls2.getDeclaredMethod("getFinderObject", new Class[0]);
            p.g(declaredMethod, "FinderItem_Class.getDecl…hod(getFinderObject_Name)");
            this.sFF = declaredMethod;
            Method method = this.sFF;
            if (method == null) {
                p.btv("getFinderObject_Method");
            }
            method.setAccessible(true);
            Class<?> cls3 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
            p.g(cls3, "Class.forName(FinderObject_Name)");
            Field declaredField2 = cls3.getDeclaredField("id");
            p.g(declaredField2, "FinderObject_Class.getDeclaredField(id_Name)");
            this.sGU = declaredField2;
            Field field2 = this.sGU;
            if (field2 == null) {
                p.btv("id_Field");
            }
            field2.setAccessible(true);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", e2, "init crash: " + e2.getMessage(), new Object[0]);
        }
        this.sGV = new b(this);
        AppMethodBeat.o(221043);
    }

    public static final /* synthetic */ Field a(c cVar) {
        AppMethodBeat.i(221048);
        Field field = cVar.sCe;
        if (field == null) {
            p.btv("feedObject_Field");
        }
        AppMethodBeat.o(221048);
        return field;
    }

    public static final /* synthetic */ Method b(c cVar) {
        AppMethodBeat.i(221049);
        Method method = cVar.sFF;
        if (method == null) {
            p.btv("getFinderObject_Method");
        }
        AppMethodBeat.o(221049);
        return method;
    }

    public static final /* synthetic */ Field c(c cVar) {
        AppMethodBeat.i(221050);
        Field field = cVar.sGU;
        if (field == null) {
            p.btv("id_Field");
        }
        AppMethodBeat.o(221050);
        return field;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderClickStatistics$mListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IFinderClickListener;", "getFeedIdWithBaseFinderFeedType", "", "obj", "", "onFeedClick", "", "position", "", "plugin-expt_release"})
    public static final class b implements d {
        final /* synthetic */ c sGY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(c cVar) {
            this.sGY = cVar;
        }

        @Override // com.tencent.mm.plugin.expt.hellhound.a.b.b.d
        public final void k(Object obj, int i2) {
            Map<String, i> cPv;
            float f2;
            float f3;
            Class<?> cls;
            i iVar = null;
            AppMethodBeat.i(221041);
            Log.i("HABBYGE-MALI.FinderClickStatistics", "onFeedClick: obj=" + ((obj == null || (cls = obj.getClass()) == null) ? null : cls.getName()) + ", pos=" + i2);
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = new a((byte) 0);
            if (obj instanceof View) {
                j jVar = this.sGY.sGW;
                View view = (View) obj;
                p.h(view, "feedView");
                com.tencent.mm.plugin.expt.hellhound.a.a.a.b bVar = jVar.sBo;
                String ac = bVar != null ? bVar.ac(view, i2) : null;
                Log.w("HABBYGE-MALI.WaterfallsFlowStatistics", "getFeedWhenClick, getFeed=".concat(String.valueOf(ac)));
                if (ac != null) {
                    i iVar2 = jVar.sHy.get(ac);
                    if (iVar2 == null) {
                        jVar.Do(currentTimeMillis);
                        iVar2 = jVar.sHy.get(ac);
                    }
                    iVar = iVar2;
                }
                cPv = this.sGY.sGW.cPv();
                if (iVar == null && i2 >= 0 && (iVar = c.g(i2, cPv)) == null) {
                    Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-0-1");
                }
            } else {
                cPv = this.sGY.sGW.cPv();
                String dh = dh(obj);
                if (dh != null) {
                    iVar = c.s(dh, cPv);
                    if (iVar == null) {
                        Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-2");
                    }
                } else if (i2 >= 0 && (iVar = c.g(i2, cPv)) == null) {
                    Log.w("HABBYGE-MALI.FinderClickStatistics", "getFeed-1-1");
                }
            }
            if (iVar == null) {
                Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", new NullPointerException("onFeedClick, wtf, feed is null !!!"), "", new Object[0]);
                AppMethodBeat.o(221041);
                return;
            }
            aVar.width = iVar.width;
            aVar.height = iVar.height;
            aVar.sessionId = iVar.sessionId;
            aVar.sGI = iVar.feedId;
            aVar.nickName = iVar.nickName;
            aVar.scene = iVar.scene;
            aVar.sGJ = iVar.sGJ;
            aVar.sGK = currentTimeMillis;
            aVar.sGL = iVar.sGL;
            aVar.sGM = iVar.sGM;
            aVar.sGN = iVar.sHx;
            aVar.sGO = iVar.sGS;
            aVar.sGQ = iVar.sGQ;
            aVar.sGR = iVar.sGR;
            aVar.sGS = iVar.kf;
            aVar.position = iVar.position;
            c.a(aVar, cPv);
            a.C1016a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.c.a.sGv;
            p.h(aVar, "clickFeed");
            ll llVar = new ll();
            llVar.yG(aVar.sessionId);
            llVar.yH(aVar.sGI);
            llVar.lT(aVar.scene);
            llVar.uV(aVar.sGJ);
            llVar.uW(aVar.sGK);
            if (aVar.sGL <= 0.0f) {
                f2 = 100.0f;
            } else {
                f2 = aVar.sGL;
            }
            ae aeVar = ae.SYK;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f2 / 100.0f)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            llVar.yI(format);
            if (aVar.sGM <= 0.0f) {
                c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                f3 = ((aVar.width * aVar.height) * 100.0f) / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEI;
            } else {
                f3 = aVar.sGM;
            }
            ae aeVar2 = ae.SYK;
            String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f3 / 100.0f)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            llVar.yJ(format2);
            llVar.lU(aVar.sGN);
            llVar.lV(aVar.sGO);
            llVar.yK(com.tencent.mm.plugin.expt.hellhound.core.b.aoY(aVar.sGP));
            llVar.yL(aVar.sGQ);
            llVar.yM(aVar.sGR);
            llVar.lW(aVar.sGS);
            h.RTc.ba(new a.C1016a.c(llVar, aVar));
            AppMethodBeat.o(221041);
        }

        private final String dh(Object obj) {
            AppMethodBeat.i(221042);
            if (obj == null) {
                AppMethodBeat.o(221042);
                return null;
            }
            try {
                Object obj2 = c.c(this.sGY).get(c.b(this.sGY).invoke(c.a(this.sGY).get(obj), new Object[0]));
                if (obj2 == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(221042);
                    throw tVar;
                }
                String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long) obj2).longValue());
                AppMethodBeat.o(221042);
                return zs;
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.FinderClickStatistics", e2, "getFeedIdWithBaseFinderFeedType crash: " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(221042);
                return null;
            }
        }
    }

    public static final /* synthetic */ i g(int i2, Map map) {
        AppMethodBeat.i(221045);
        if (i2 >= 0) {
            for (Map.Entry entry : map.entrySet()) {
                if (((i) entry.getValue()).position == i2) {
                    i iVar = (i) entry.getValue();
                    AppMethodBeat.o(221045);
                    return iVar;
                }
            }
        }
        AppMethodBeat.o(221045);
        return null;
    }

    public static final /* synthetic */ i s(String str, Map map) {
        AppMethodBeat.i(221046);
        i iVar = (i) map.get(str);
        AppMethodBeat.o(221046);
        return iVar;
    }

    public static final /* synthetic */ void a(a aVar, Map map) {
        float f2;
        AppMethodBeat.i(221047);
        JSONArray jSONArray = new JSONArray();
        z.f fVar = new z.f();
        for (Map.Entry entry : map.entrySet()) {
            fVar.SYG = (T) new JSONObject();
            fVar.SYG.put("ItemDirection", ((i) entry.getValue()).sHx);
            fVar.SYG.put("FeedId", ((i) entry.getValue()).feedId);
            if (((i) entry.getValue()).sGM <= 0.0f) {
                float f3 = ((i) entry.getValue()).width;
                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                f2 = ((((i) entry.getValue()).height * f3) * 100.0f) / com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEI;
            } else {
                f2 = ((i) entry.getValue()).sGM;
            }
            ae aeVar = ae.SYK;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f2 / 100.0f)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            fVar.SYG.put("ScreenExposureAreaWeigth", format);
            float f4 = ((i) entry.getValue()).sGL <= 0.0f ? 100.0f : ((i) entry.getValue()).sGL;
            ae aeVar2 = ae.SYK;
            String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f4 / 100.0f)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            fVar.SYG.put("ItemExposureAreaWeigth", format2);
            fVar.SYG.put("ItemIndex", ((i) entry.getValue()).sGS);
            jSONArray.put(fVar.SYG);
        }
        aVar.sGP = jSONArray.toString();
        AppMethodBeat.o(221047);
    }
}
