package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.newtips.a.l;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J2\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J<\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J<\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J*\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "getFinderNewTips", "handleAdd", "uniqueId", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "handleCancel", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "parseFinderExtInfo", "Companion", "plugin-finder_release"})
public final class b implements l.a {
    public static final a tJk = new a((byte) 0);
    private final f toy;

    static {
        AppMethodBeat.i(243506);
        AppMethodBeat.o(243506);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$handleCancel$1$ret$1"})
    /* renamed from: com.tencent.mm.plugin.finder.extension.reddot.b$b  reason: collision with other inner class name */
    static final class C1112b extends q implements kotlin.g.a.b<k, Boolean> {
        final /* synthetic */ b tJl;
        final /* synthetic */ long tJm;
        final /* synthetic */ Map tJn;
        final /* synthetic */ String tJo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1112b(b bVar, long j2, Map map, String str) {
            super(1);
            this.tJl = bVar;
            this.tJm = j2;
            this.tJn = map;
            this.tJo = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(k kVar) {
            AppMethodBeat.i(243500);
            k kVar2 = kVar;
            p.h(kVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(p.j(kVar2.field_tipsId, this.tJo));
            AppMethodBeat.o(243500);
            return valueOf;
        }
    }

    public b(f fVar) {
        p.h(fVar, "redDotManager");
        AppMethodBeat.i(243505);
        this.toy = fVar;
        AppMethodBeat.o(243505);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.newtips.a.l.a
    public final boolean a(long j2, String str, List<c> list, Map<String, String> map) {
        int i2;
        AppMethodBeat.i(243502);
        p.h(list, "tipsList");
        p.h(map, "values");
        Log.w("Finder.NewTipsTransform", "[handleCancel] tipsId=" + j2 + " uniqueId=" + str);
        if (b(map, j2) == null) {
            AppMethodBeat.o(243502);
            return false;
        } else if (!a(j2, map)) {
            AppMethodBeat.o(243502);
            return true;
        } else {
            if (j2 == 40001002) {
                i2 = 1003;
            } else {
                i2 = j2 == 40001001 ? 1004 : -1;
            }
            if (i2 != -1 && this.toy.a(i2, new C1112b(this, j2, map, str))) {
                Log.i("Finder.NewTipsTransform", "[handleCancel] successfully! tipsId=" + j2 + " uniqueId=" + str);
            }
            AppMethodBeat.o(243502);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.newtips.a.l.a
    public final boolean b(long j2, String str, List<c> list, Map<String, String> map) {
        String str2;
        AppMethodBeat.i(243503);
        p.h(list, "tipsList");
        p.h(map, "values");
        if (b(map, j2) == null) {
            AppMethodBeat.o(243503);
            return false;
        } else if (!a(j2, map)) {
            AppMethodBeat.o(243503);
            return true;
        } else {
            c cVar = (c) j.kt(list);
            int i2 = cVar != null ? cVar.field_priority : 0;
            bbi bbi = new bbi();
            for (T t : list) {
                bdo bdo = new bdo();
                if (((c) t).field_showType != k.MMNEWTIPS_SHOWTYPE_NONE.value) {
                    bbi.GaM.add(bdo);
                    int i3 = ((c) t).field_showType;
                    if (i3 == k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE.value) {
                        bdo.title = ((c) t).field_title;
                        bdo.xGz = 3;
                    } else if (i3 == k.MMNEWTIPS_SHOWTYPE_COUNTER.value) {
                        bdo.count = 1;
                        bdo.xGz = 2;
                    } else if (i3 == k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON.value) {
                        bdo.qGB = ((c) t).field_icon_url;
                        bdo.xGz = 4;
                    } else if (i3 == k.MMNEWTIPS_SHOWTYPE_REDPOINT.value) {
                        bdo.xGz = 1;
                    } else if (i3 == k.MMNEWTIPS_SHOWTYPE_NEW.value) {
                        bdo.xGz = 100;
                    }
                    switch (((c) t).field_path) {
                        case 2:
                            str2 = "Discovery";
                            break;
                        case 24:
                            str2 = "FinderEntrance";
                            break;
                        case 28:
                            str2 = "finder_tl_hot_tab";
                            break;
                        case 29:
                            str2 = "finder_tl_nearby_tab";
                            break;
                        default:
                            str2 = "";
                            break;
                    }
                    bdo.path = str2;
                    bdo.LNm = 1;
                    if (j2 == 40001002) {
                        FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
                        finderTipsShowEntranceExtInfo.tab_type = 2;
                        bdo.LNn = 1;
                        bdo.LNo = new com.tencent.mm.bw.b(finderTipsShowEntranceExtInfo.toByteArray());
                        bbi.type = 1003;
                    } else if (j2 == 40001001) {
                        FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo2 = new FinderTipsShowEntranceExtInfo();
                        finderTipsShowEntranceExtInfo2.tab_type = 4;
                        bdo.LNn = 1;
                        bdo.LNo = new com.tencent.mm.bw.b(finderTipsShowEntranceExtInfo2.toByteArray());
                        bbi.type = 1004;
                    }
                }
            }
            bbi.LKM = str;
            bbi.priority = i2;
            bdh bdh = new bdh();
            bdj bdj = new bdj();
            bdh.LKY.add(bdj);
            bdj.LNi = bbi;
            this.toy.a(bdh, "FinderNewTipsTransform");
            AppMethodBeat.o(243503);
            return true;
        }
    }

    private static boolean a(long j2, Map<String, String> map) {
        int i2;
        int i3;
        AppMethodBeat.i(243504);
        if (map.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {
            i2 = Util.getInt(map.get(".sysmsg.newtips.control.android_min_clientversion"), 0);
        } else {
            i2 = 0;
        }
        if (map.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {
            i3 = Util.getInt(map.get(".sysmsg.newtips.control.android_max_clientversion"), Integer.MAX_VALUE);
        } else {
            i3 = 0;
        }
        if (d.KyO < i2 || d.KyO > i3) {
            Log.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(d.KyO));
            AppMethodBeat.o(243504);
            return false;
        }
        AppMethodBeat.o(243504);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (r0 != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.lang.String> b(java.util.Map<java.lang.String, java.lang.String> r7, long r8) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.extension.reddot.b.b(java.util.Map, long):java.util.Map");
    }
}
