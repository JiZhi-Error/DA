package com.tencent.mm.plugin.finder.extension.reddot;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class i {
    private static String tLa = "";
    private static String tLb = "";
    private static String tLc = "";
    private static String tLd = "";
    private static String tLe = "";
    private static String tLf = "";
    private static String tLg = "";
    private static String tLh = "";
    public static final a tLi = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"J\u001a\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001dJ(\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"2\b\b\u0002\u0010!\u001a\u00020\u001dJ(\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"2\b\b\u0002\u0010!\u001a\u00020\u001dJ\u0016\u0010,\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)J(\u0010-\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"2\b\b\u0002\u0010!\u001a\u00020\u001dJ\"\u0010.\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010/\u001a\u00020\u0004J\u0016\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\u001f2\b\b\u0002\u00105\u001a\u00020\u0004J\"\u00106\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010!\u001a\u00020\"J\u0018\u00107\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)J\u0018\u00108\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotReportLogic$Companion;", "", "()V", "TAG", "", "clickHomeFollowTabRedDotId", "getClickHomeFollowTabRedDotId", "()Ljava/lang/String;", "setClickHomeFollowTabRedDotId", "(Ljava/lang/String;)V", "clickHomeFriendTabRedDotId", "getClickHomeFriendTabRedDotId", "setClickHomeFriendTabRedDotId", "clickHomeMachineTabRedDotId", "getClickHomeMachineTabRedDotId", "setClickHomeMachineTabRedDotId", "clickNearbyLiveTabRedDotId", "clickNearbyPersonTabRedDotId", "clickNearbyVideoTabRedDotId", "lastFindPageExposeTipsId", "getLastFindPageExposeTipsId", "setLastFindPageExposeTipsId", "lastNearbyExposeTipsId", "getLastNearbyExposeTipsId", "setLastNearbyExposeTipsId", "getFinderNotifyCount", "", "getNotifyCount", "hasMentionCount", "", "reportFindPageNearbyRedDotClick", "", "contextId", "autoClick", "", "reportFindPageRedDotClick", "reportFindPageRedDotExpose", "ignoreDuplicatedId", "reportHomeFollowTabRed", NativeProtocol.WEB_DIALOG_ACTION, "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "currentTabType", "reportHomeFriendTabRed", "reportHomeLbsTabRed", "reportHomeMachineTabRed", "reportHomePersonCenterRed", "lastExposeTipsId", "reportHomeTabRefreshRedDotClick", "tabType", "context", "Lcom/tencent/mm/ui/MMActivity;", "reportNearbyLiveRedBreakage", "overwriteTipsId", "reportNearbyLiveTabRed", "reportNearbyPersonTabRed", "reportNearbyVideoTabRed", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int[] dbo() {
            int i2;
            int i3;
            int i4;
            int i5;
            AppMethodBeat.i(243611);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("NotificationCenterLike");
            if (asW != null) {
                i2 = asW.count;
            } else {
                i2 = 0;
            }
            bdo asW2 = redDotManager.asW("NotificationCenterComment");
            if (asW2 != null) {
                i3 = asW2.count;
            } else {
                i3 = 0;
            }
            bdo asW3 = redDotManager.asW("NotificationCenterFollow");
            if (asW3 != null) {
                i4 = asW3.count;
            } else {
                i4 = 0;
            }
            bdo asW4 = redDotManager.asW("AuthorProfileNotify");
            if (asW4 != null) {
                i5 = asW4.count;
            } else {
                i5 = 0;
            }
            int[] iArr = {i2, i3, i4, i5};
            AppMethodBeat.o(243611);
            return iArr;
        }

        public static boolean dbp() {
            AppMethodBeat.i(243612);
            if (dbo()[3] > 0) {
                AppMethodBeat.o(243612);
                return true;
            }
            AppMethodBeat.o(243612);
            return false;
        }

        public static void a(int i2, bbn bbn, int i3, boolean z) {
            bbi bbi;
            AppMethodBeat.i(243613);
            p.h(bbn, "contextObj");
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("TLRecommendTab");
            k asX = redDotManager.asX("TLRecommendTab");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str = bbi.LKM;
                if (str == null) {
                    str = "";
                }
                p.g(str, "ctrInfo.tips_id ?: \"\"");
                if (i2 == 2) {
                    a aVar = i.tLi;
                    if (p.j(i.tLa, str)) {
                        AppMethodBeat.o(243613);
                        return;
                    }
                }
                k kVar = k.vfA;
                k.a("2", 8, i2, 1, 0, 0, str, (String) null, bbi.feedId, bbn, i3, z ? 1 : 0, 128);
                j jVar = j.vft;
                if (asX == null) {
                    p.hyc();
                }
                j.a("2", asX, asW, i2, bbn, z ? 1 : 0, i3);
                if (i2 == 2) {
                    a aVar2 = i.tLi;
                    p.h(str, "<set-?>");
                    i.tLa = str;
                }
            }
            AppMethodBeat.o(243613);
        }

        public static void b(int i2, bbn bbn, int i3, boolean z) {
            bbi bbi;
            AppMethodBeat.i(243614);
            p.h(bbn, "contextObj");
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("TLFollow");
            k asX = redDotManager.asX("TLFollow");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str = bbi.LKM;
                if (str == null) {
                    str = "";
                }
                p.g(str, "ctrInfo.tips_id ?: \"\"");
                if (i2 == 2) {
                    a aVar = i.tLi;
                    if (p.j(i.tLb, str)) {
                        AppMethodBeat.o(243614);
                        return;
                    }
                }
                k kVar = k.vfA;
                k.a("2", 7, i2, 1, 0, 0, str, (String) null, bbi.feedId, bbn, i3, z ? 1 : 0, 128);
                j jVar = j.vft;
                if (asX == null) {
                    p.hyc();
                }
                j.a("2", asX, asW, i2, bbn, z ? 1 : 0, i3);
                if (i2 == 2) {
                    a aVar2 = i.tLi;
                    p.h(str, "<set-?>");
                    i.tLb = str;
                }
            }
            AppMethodBeat.o(243614);
        }

        public static void c(int i2, bbn bbn, int i3, boolean z) {
            bbi bbi;
            String str;
            AppMethodBeat.i(243615);
            p.h(bbn, "contextObj");
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("finder_tl_hot_tab");
            k asX = redDotManager.asX("finder_tl_hot_tab");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str2 = bbi.LKM;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "ctrInfo.tips_id ?: \"\"");
                if (i2 == 2) {
                    a aVar = i.tLi;
                    if (p.j(i.tLc, str)) {
                        AppMethodBeat.o(243615);
                        return;
                    }
                }
                k kVar = k.vfA;
                String str3 = bbi.LKM;
                if (str3 == null) {
                    str3 = "";
                }
                k.a("2", 3, i2, 1, 2, 0, str3, (String) null, 0, bbn, i3, z ? 1 : 0, 384);
                j jVar = j.vft;
                if (asX == null) {
                    p.hyc();
                }
                j.a("2", asX, asW, i2, bbn, z ? 1 : 0, i3);
                if (i2 == 2) {
                    a aVar2 = i.tLi;
                    p.h(str, "<set-?>");
                    i.tLc = str;
                }
            }
            AppMethodBeat.o(243615);
        }

        public static void a(int i2, bbn bbn) {
            bbi bbi;
            AppMethodBeat.i(243616);
            p.h(bbn, "contextObj");
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("finder_tl_nearby_tab");
            k asX = redDotManager.asX("finder_tl_nearby_tab");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                k kVar = k.vfA;
                String str = bbi.LKM;
                if (str == null) {
                    str = "";
                }
                k.a("2", 3, i2, 1, 1, 0, str, (String) null, 0, bbn, 0, 0, 3456);
                j jVar = j.vft;
                if (asX == null) {
                    p.hyc();
                }
                j.a("2", asX, asW, i2, bbn, 0, 2, 32);
            }
            AppMethodBeat.o(243616);
        }

        public static String a(int i2, bbn bbn, String str) {
            bbi bbi;
            String str2;
            bbi bbi2;
            AppMethodBeat.i(243617);
            p.h(str, "lastExposeTipsId");
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("TLPersonalCenter");
            k asX = redDotManager.asX("TLPersonalCenter");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (asW == null || bbi == null) {
                str2 = "";
            } else {
                if (i2 == 1) {
                    String str3 = bbi.LKM;
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (p.j(str, str3)) {
                        AppMethodBeat.o(243617);
                        return str3;
                    }
                    str2 = str3;
                } else {
                    str2 = "";
                }
                j jVar = j.vft;
                if (asX == null) {
                    p.hyc();
                }
                j.a("2", asX, asW, i2, bbn, 0, 0, 96);
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_MSG_NORMAL_INT_SYNC, 0);
                e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                int i4 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, 0);
                c cVar = c.vCb;
                int i5 = c.dsx().value().intValue() == 1 ? 0 : 2;
                if (i3 > 0) {
                    k kVar = k.vfA;
                    k.a("2", 1, i2, 1, i5, i3, (String) null, (String) null, 0, bbn, 0, 0, 3520);
                } else if (i4 > 0) {
                    k kVar2 = k.vfA;
                    k.a("2", 4, i2, 1, i5, i4, (String) null, (String) null, 0, bbn, 0, 0, 3520);
                } else {
                    bdo asW2 = redDotManager.asW("Personal_Center_FavList_Entrance");
                    k asX2 = redDotManager.asX("Personal_Center_FavList_Entrance");
                    y yVar2 = y.vXH;
                    if (asX2 != null) {
                        bbi2 = asX2.field_ctrInfo;
                    } else {
                        bbi2 = null;
                    }
                    if (!(asW2 == null || bbi2 == null)) {
                        k kVar3 = k.vfA;
                        k.a("2", 6, i2, 1, 0, 0, (String) null, (String) null, 0, bbn, 0, 0, 3520);
                        j jVar2 = j.vft;
                        if (asX2 == null) {
                            p.hyc();
                        }
                        j.a("2", asX2, asW2, i2, bbn, 0, 0, 96);
                    }
                    com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
                    p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    bdo asW3 = ((PluginFinder) ah2).getRedDotManager().asW("TLCamera");
                    com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
                    p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                    k asX3 = ((PluginFinder) ah3).getRedDotManager().asX("TLCamera");
                    y yVar3 = y.vXH;
                    if (!(asW3 == null || asX3 == null)) {
                        k kVar4 = k.vfA;
                        k.a("2", 2, i2, 1, 1, 0, (String) null, (String) null, 0, bbn, 0, 0, 3520);
                        j jVar3 = j.vft;
                        j.a("2", asX3, asW3, i2, bbn, 0, 0, 96);
                    }
                }
            }
            AppMethodBeat.o(243617);
            return str2;
        }

        public static void mT(boolean z) {
            bbi bbi;
            bbi bbi2;
            String str;
            AppMethodBeat.i(243618);
            com.tencent.mm.kernel.b.a ah = g.ah(aj.class);
            p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            z redDotManager = ((aj) ah).getRedDotManager();
            p.g(redDotManager, "MMKernel.plugin(IPluginF…class.java).redDotManager");
            if (!redDotManager.daH()) {
                AppMethodBeat.o(243618);
                return;
            }
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("FinderEntrance");
            com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
            p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            k asX = ((PluginFinder) ah3).getRedDotManager().asX("FinderEntrance");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str2 = bbi.LKM;
                com.tencent.mm.kernel.b.a ah4 = g.ah(PluginFinder.class);
                p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
                String str3 = ((PluginFinder) ah4).getRedDotManager().asZ("FinderEntrance").report_ext_info;
                if (str3 == null) {
                    str3 = "";
                }
                p.g(str3, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
                a aVar = i.tLi;
                if ((!p.j(i.tLd, str2)) || z) {
                    k kVar = k.vfA;
                    int i2 = bbi.type;
                    if (str2 == null) {
                        str = "";
                    } else {
                        str = str2;
                    }
                    String nullAs = Util.nullAs(asW.title, "");
                    p.g(nullAs, "Util.nullAs(showInfo.title, \"\")");
                    k.a(kVar, "1", i2, str, nullAs, bbi.feedId, "", asW.xGz, str3);
                    j jVar = j.vft;
                    if (asX == null) {
                        p.hyc();
                    }
                    j.a(jVar, "1", asX, asW, 1);
                    a aVar2 = i.tLi;
                    if (str2 == null) {
                        str2 = "";
                    }
                    p.h(str2, "<set-?>");
                    i.tLd = str2;
                }
            }
            com.tencent.mm.kernel.b.a ah5 = g.ah(PluginFinder.class);
            p.g(ah5, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW2 = ((PluginFinder) ah5).getRedDotManager().asW("NearbyEntrance");
            com.tencent.mm.kernel.b.a ah6 = g.ah(PluginFinder.class);
            p.g(ah6, "MMKernel.plugin(PluginFinder::class.java)");
            k asX2 = ((PluginFinder) ah6).getRedDotManager().asX("NearbyEntrance");
            y yVar2 = y.vXH;
            if (asX2 != null) {
                bbi2 = asX2.field_ctrInfo;
            } else {
                bbi2 = null;
            }
            if (!(asW2 == null || bbi2 == null)) {
                String str4 = bbi2.LKM;
                a aVar3 = i.tLi;
                if ((!p.j(i.tLe, str4)) || z) {
                    j jVar2 = j.vft;
                    if (asX2 == null) {
                        p.hyc();
                    }
                    j.a(jVar2, "1", asX2, asW2, 1);
                    a aVar4 = i.tLi;
                    if (str4 == null) {
                        str4 = "";
                    }
                    p.h(str4, "<set-?>");
                    i.tLe = str4;
                }
            }
            AppMethodBeat.o(243618);
        }

        public static String dw(String str, int i2) {
            bbi bbi;
            AppMethodBeat.i(243619);
            p.h(str, "contextId");
            com.tencent.mm.kernel.b.a ah = g.ah(aj.class);
            p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            z redDotManager = ((aj) ah).getRedDotManager();
            p.g(redDotManager, "MMKernel.plugin(IPluginF…class.java).redDotManager");
            if (!redDotManager.daH()) {
                AppMethodBeat.o(243619);
                return null;
            }
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("FinderEntrance");
            com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
            p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            k asX = ((PluginFinder) ah3).getRedDotManager().asX("FinderEntrance");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (asW == null || bbi == null) {
                AppMethodBeat.o(243619);
                return null;
            }
            com.tencent.mm.kernel.b.a ah4 = g.ah(PluginFinder.class);
            p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
            String str2 = ((PluginFinder) ah4).getRedDotManager().asZ("FinderEntrance").report_ext_info;
            if (str2 == null) {
                str2 = "";
            }
            p.g(str2, "MMKernel.plugin(PluginFi…ANCE).report_ext_info?:\"\"");
            k kVar = k.vfA;
            int i3 = bbi.type;
            String str3 = bbi.LKM;
            if (str3 == null) {
                str3 = "";
            }
            String nullAs = Util.nullAs(asW.title, "");
            p.g(nullAs, "Util.nullAs(showInfo.title, \"\")");
            kVar.a("1", i3, 2, str3, nullAs, bbi.feedId, str, asW.xGz, str2, i2);
            j jVar = j.vft;
            if (asX == null) {
                p.hyc();
            }
            j.a("1", asX, asW, 2, str, i2);
            String str4 = bbi.LKM;
            AppMethodBeat.o(243619);
            return str4;
        }

        public static void atk(String str) {
            bbi bbi;
            AppMethodBeat.i(243620);
            p.h(str, "contextId");
            com.tencent.mm.kernel.b.a ah = g.ah(aj.class);
            p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
            z redDotManager = ((aj) ah).getRedDotManager();
            p.g(redDotManager, "MMKernel.plugin(IPluginF…class.java).redDotManager");
            if (!redDotManager.daH()) {
                AppMethodBeat.o(243620);
                return;
            }
            com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
            p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah2).getRedDotManager().asW("NearbyEntrance");
            com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
            p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            k asX = ((PluginFinder) ah3).getRedDotManager().asX("NearbyEntrance");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                int i2 = (bbi.type == 16 || asW.xGz == 6) ? 2 : 3;
                j jVar = j.vft;
                if (asX == null) {
                    p.hyc();
                }
                j.a("1", asX, asW, i2, str, 0);
            }
            AppMethodBeat.o(243620);
        }

        public static void b(int i2, bbn bbn) {
            bbi bbi;
            String str;
            AppMethodBeat.i(243621);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("NearbyFeedTab");
            k asX = redDotManager.asX("NearbyFeedTab");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str2 = bbi.LKM;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "ctrInfo.tips_id ?: \"\"");
                if (i2 != 2 || !p.j(i.tLf, str)) {
                    j jVar = j.vft;
                    if (asX == null) {
                        p.hyc();
                    }
                    j.a("9", asX, asW, i2, bbn, 0, 0, 96);
                    if (i2 == 2) {
                        i.tLf = str;
                    }
                } else {
                    AppMethodBeat.o(243621);
                    return;
                }
            }
            AppMethodBeat.o(243621);
        }

        public static void a(int i2, bbn bbn, int i3) {
            bbi bbi;
            String str;
            AppMethodBeat.i(243622);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("NearbyLiveTab");
            k asX = redDotManager.asX("NearbyLiveTab");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str2 = bbi.LKM;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "ctrInfo.tips_id ?: \"\"");
                if (i2 != 2 || !p.j(i.tLg, str)) {
                    j jVar = j.vft;
                    if (asX == null) {
                        p.hyc();
                    }
                    j.a("9", asX, asW, i2, bbn, i3, 0, 64);
                    if (i2 == 2) {
                        i.tLg = str;
                    }
                } else {
                    AppMethodBeat.o(243622);
                    return;
                }
            }
            AppMethodBeat.o(243622);
        }

        public static void c(int i2, bbn bbn) {
            bbi bbi;
            String str;
            AppMethodBeat.i(243623);
            com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            f redDotManager = ((PluginFinder) ah).getRedDotManager();
            bdo asW = redDotManager.asW("NearbyPeopleTab");
            k asX = redDotManager.asX("NearbyPeopleTab");
            y yVar = y.vXH;
            if (asX != null) {
                bbi = asX.field_ctrInfo;
            } else {
                bbi = null;
            }
            if (!(asW == null || bbi == null)) {
                String str2 = bbi.LKM;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.g(str, "ctrInfo.tips_id ?: \"\"");
                if (i2 != 3 || !p.j(i.tLh, str)) {
                    j jVar = j.vft;
                    if (asX == null) {
                        p.hyc();
                    }
                    j.a("9", asX, asW, i2, bbn, 0, 0, 96);
                    if (i2 == 3) {
                        i.tLh = str;
                    }
                } else {
                    AppMethodBeat.o(243623);
                    return;
                }
            }
            AppMethodBeat.o(243623);
        }
    }

    static {
        AppMethodBeat.i(243624);
        AppMethodBeat.o(243624);
    }
}
