package com.tencent.mm.plugin.brandservice.b;

import android.util.Base64;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.eqo;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002abB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0002J(\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00101\u001a\u00020\u0010J\u0012\u00102\u001a\u00020+2\n\b\u0002\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u00020\u0004J\b\u00106\u001a\u0004\u0018\u00010\u0004J\n\u00107\u001a\u0004\u0018\u00010)H\u0007J\b\u00108\u001a\u0004\u0018\u00010\u0004J\b\u00109\u001a\u00020+H\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0014H\u0002J\u0006\u0010<\u001a\u00020\u0010J\u0006\u0010=\u001a\u00020\u0010J\u0006\u0010>\u001a\u00020\u0010J\b\u0010?\u001a\u00020\u0010H\u0007J\u0012\u0010@\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DJ\u0010\u0010F\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u001a\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010)H\u0002J&\u0010I\u001a\u00020+2\u0006\u0010;\u001a\u00020\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004J\u0010\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020+H\u0007J\u000e\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020PJ\u0012\u0010Q\u001a\u00020+2\b\u0010R\u001a\u0004\u0018\u00010)H\u0002J\u0006\u0010S\u001a\u00020\u0010J\u0006\u0010T\u001a\u00020\u0010J\u0010\u0010U\u001a\u00020+2\u0006\u0010K\u001a\u00020LH\u0007J\u001a\u0010V\u001a\u00020+2\u0006\u0010W\u001a\u00020\u00102\b\b\u0002\u0010X\u001a\u00020\u0010H\u0007J\u0018\u0010Y\u001a\u00020+2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010Z\u001a\u00020+2\u0006\u0010H\u001a\u00020\u0014H\u0002J\u001a\u0010[\u001a\u00020+2\n\u0010\\\u001a\u00060]R\u00020^2\u0006\u0010_\u001a\u00020`R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/model/BizVideoChannelStrategy;", "", "()V", "BIZ_PROFILE_VIDEO_CHANNEL_ENTRY_OPEN", "", "KEY_BIZ_VIDEO_CHANNEL_SHOW_DEFAULT_ICON", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_FETCH_LAST_TIME", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_INTERVAL", "KEY_BIZ_VIDEO_CHANNEL_STRATEGY_TL_FETCH_LAST_TIME", "TAG", "TOP_BAR_INFO", "TOP_BAR_VIDEO_CHANNEL_SWITCH_OPTION", "VIDEO_CHANNEL_FEEDS_DATA", "bizVideoChannelCanvasId", "isBizProfileEntryOpen", "", "Ljava/lang/Boolean;", "isTimelineTopBarEntryOpen", "localOpen", "", "getLocalOpen", "()I", "localOpen$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "showCanvas", "getShowCanvas", "()Z", "showCanvas$delegate", "showingLogoUrl", "getShowingLogoUrl", "()Ljava/lang/String;", "setShowingLogoUrl", "(Ljava/lang/String;)V", "timelineTopBarInfo", "Lcom/tencent/mm/protocal/protobuf/VideoChannelTopBarInfo;", "clearTopBarInfo", "", "fetchBizVideoChannelStrategy", "fromScene", "talker", "url", "getLogoUrl", "force", "getNotifyAndChannelFeeds", "updateCallback", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$UpdateChannelFeedsCallback;", "getProtoData", "getSyncBuffer", "getTopBarInfo", "getTopBarPath", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isPreloadOpen", "scene", "isShowDefaultIcon", "isShowingDefaultIcon", "isShowingIconCached", "isTimeLineTopBarEntryOpen", "isTopBarInfoChanged", "topBarInfo", "loadChannelIcon", "iconIV", "Landroid/widget/ImageView;", "loadChannelSmallIcon", "onLogoClick", "onTopBarVideoChannelEntryChanged", "switchOption", "preloadChannelStrategy", "preloadIcon", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "release", "report", "key", "", "saveTopBarInfo", "top_bar_info", "shouldChaneDefaultLogoAfterClick", "showRightTopGreedDot", "update", "updateBizProfileEntryStatus", "isEntryOpen", "needSave", "updateInterval", "updateTimelineTopBarEntryStatus", "updateUnReadView", "holder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView$HotListViewHolder;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "context", "Landroid/content/Context;", "VideoChannelSwitchOption", "VideoChannelTopBarControlBit", "plugin-brandservice_release"})
public final class c {
    private static final kotlin.f iBW = g.ah(d.pnj);
    public static String pmY = "";
    private static Boolean pmZ;
    private static eqs pna;
    private static Boolean pnb;
    private static final kotlin.f pnc = g.ah(C0864c.pni);
    private static final kotlin.f pnd = g.ah(f.pnm);
    public static final c pne = new c();

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(175468);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(175468);
        return multiProcessMMKV;
    }

    public static boolean clF() {
        AppMethodBeat.i(195142);
        boolean booleanValue = ((Boolean) pnd.getValue()).booleanValue();
        AppMethodBeat.o(195142);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(175467);
        AppMethodBeat.o(175467);
    }

    private c() {
    }

    public static final /* synthetic */ MultiProcessMMKV clH() {
        AppMethodBeat.i(195145);
        MultiProcessMMKV aTI = aTI();
        AppMethodBeat.o(195145);
        return aTI;
    }

    public static final void init() {
        boolean z = true;
        AppMethodBeat.i(175469);
        int i2 = aTI().getInt("top_bar_video_channel_switch_option", 0);
        if (aTI().getInt("top_bar_video_channel_switch_option", 0) != 1) {
            z = false;
        }
        CU(i2);
        E(z, false);
        AppMethodBeat.o(175469);
    }

    public static final void release() {
    }

    public static final void a(qd qdVar) {
        Integer num;
        String str;
        String str2;
        Integer num2;
        boolean z;
        Integer num3 = null;
        AppMethodBeat.i(175470);
        p.h(qdVar, "resp");
        int i2 = aTI().getInt("top_bar_video_channel_switch_option", 0);
        eqo eqo = qdVar.KXa;
        if (eqo != null) {
            aTI().encode("biz_video_channel_show_default_icon", 0);
            StringBuilder sb = new StringBuilder("alvinluo onUpdateBizVideoChannelStrategy localSwitchOption: %d, switch_option: %d, appId: %s, title: %s, logo: %s, version: %d, funcVersion: %d, default_logo_url: ");
            eqs eqs = eqo.NnX;
            StringBuilder append = sb.append(eqs != null ? eqs.Nob : null).append(", control_bits: ");
            eqs eqs2 = eqo.NnX;
            StringBuilder append2 = append.append(eqs2 != null ? Integer.valueOf(eqs2.Nog) : null).append(", display_type=");
            eqs eqs3 = eqo.NnX;
            StringBuilder append3 = append2.append(eqs3 != null ? Integer.valueOf(eqs3.Nom) : null).append(' ').append("showSmallIcon=");
            eqs eqs4 = eqo.NnX;
            if (eqs4 != null) {
                num = Integer.valueOf(eqs4.Nok);
            } else {
                num = null;
            }
            StringBuilder append4 = append3.append(num).append(" smallIconUrl=");
            eqs eqs5 = eqo.NnX;
            String sb2 = append4.append(eqs5 != null ? eqs5.Nol : null).toString();
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(eqo.MOQ);
            eqs eqs6 = eqo.NnX;
            if (eqs6 != null) {
                str = eqs6.dNI;
            } else {
                str = null;
            }
            objArr[2] = str;
            eqs eqs7 = eqo.NnX;
            objArr[3] = eqs7 != null ? eqs7.title : null;
            eqs eqs8 = eqo.NnX;
            if (eqs8 != null) {
                str2 = eqs8.iwv;
            } else {
                str2 = null;
            }
            objArr[4] = str2;
            eqs eqs9 = eqo.NnX;
            if (eqs9 != null) {
                num2 = Integer.valueOf(eqs9.version);
            } else {
                num2 = null;
            }
            objArr[5] = num2;
            eqs eqs10 = eqo.NnX;
            if (eqs10 != null) {
                num3 = Integer.valueOf(eqs10.Noa);
            }
            objArr[6] = num3;
            Log.i("MicroMsg.BizVideoChannelStrategy", sb2, objArr);
            aTI().putInt("top_bar_video_channel_switch_option", eqo.MOQ);
            if (eqo.MOQ == 2) {
                if (!com.tencent.mm.plugin.brandservice.ui.b.c.b(eqo.NnX, clw())) {
                    z = true;
                } else {
                    z = false;
                }
                pna = eqo.NnX;
                a(eqo.NnX);
                if (z && clF()) {
                    r.a aVar = r.puL;
                    x cmU = r.a.cmU();
                    String clG = clG();
                    p.h("vc", "type");
                    p.h("__biz_video_channel_canvas_id__", "canvasId");
                    p.h(clG, "data");
                    Log.i(cmU.TAG, "update #".concat(String.valueOf("__biz_video_channel_canvas_id__")));
                    if (!cmU.IzF.containsKey("__biz_video_channel_canvas_id__")) {
                        com.tencent.mm.plugin.webcanvas.c.a(cmU, "vc", "__biz_video_channel_canvas_id__", clG);
                    } else {
                        com.tencent.mm.plugin.webcanvas.c.a(cmU, "update", "__biz_video_channel_canvas_id__");
                    }
                }
            } else if (eqo.MOQ == 0 || eqo.MOQ == 1) {
                clx();
                z = false;
            } else if (eqo.MOQ == 3) {
                z = false;
                clx();
            } else {
                z = false;
            }
            Boolean bool = pmZ;
            CU(eqo.MOQ);
            Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onUpdateBizVideoChannelStrategy oldEntry: %b, new: %b, isTopBarInfoChanged: %b", bool, pmZ, Boolean.valueOf(z));
            if ((!p.j(bool, pmZ)) || z) {
                int i3 = eqo.MOQ;
                eqs eqs11 = pna;
                Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo onTopBarVideoChannelEntryChanged");
                aq aqVar = new aq();
                aqVar.dDA.dDB = i3;
                if (eqs11 != null) {
                    aqVar.dDA.dDC = eqs11;
                }
                EventCenter.instance.publish(aqVar);
            }
            AppMethodBeat.o(175470);
            return;
        }
        AppMethodBeat.o(175470);
    }

    public static final boolean clu() {
        AppMethodBeat.i(175471);
        if (com.tencent.mm.plugin.biz.b.c.cku()) {
            AppMethodBeat.o(175471);
            return false;
        }
        Boolean bool = pmZ;
        if (bool == null) {
            p.hyc();
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(175471);
        return booleanValue;
    }

    public static final boolean clv() {
        AppMethodBeat.i(175472);
        Boolean bool = pnb;
        if (bool == null) {
            p.hyc();
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(175472);
        return booleanValue;
    }

    public static void a(eqs eqs) {
        byte[] bArr;
        AppMethodBeat.i(195133);
        try {
            MultiProcessMMKV aTI = aTI();
            if (eqs == null || (bArr = eqs.toByteArray()) == null) {
                bArr = new byte[0];
            }
            aTI.encode("biz_video_channel_top_bar_info", bArr);
            AppMethodBeat.o(195133);
        } catch (Exception e2) {
            AppMethodBeat.o(195133);
        }
    }

    private static void CU(int i2) {
        AppMethodBeat.i(175473);
        pmZ = Boolean.valueOf(i2 == 2);
        AppMethodBeat.o(175473);
    }

    public static final void E(boolean z, boolean z2) {
        AppMethodBeat.i(175474);
        pnb = Boolean.valueOf(z);
        if (z2) {
            aTI().putInt("biz_profile_video_channel_entry_open", 1);
        }
        Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo updateBizProfileEntryStatus server isEntryOpen: %b,needSave: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(175474);
    }

    public static final eqs clw() {
        Object obj;
        byte[] decodeBytes;
        boolean z = true;
        AppMethodBeat.i(175475);
        if (pna == null) {
            MultiProcessMMKV aTI = aTI();
            p.g(aTI, "mmkv");
            if (aTI.containsKey("biz_video_channel_top_bar_info") && (decodeBytes = aTI.decodeBytes("biz_video_channel_top_bar_info")) != null) {
                if (decodeBytes.length == 0) {
                    z = false;
                }
                if (z) {
                    try {
                        Object newInstance = eqs.class.newInstance();
                        ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                        obj = (com.tencent.mm.bw.a) newInstance;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                    }
                    pna = (eqs) obj;
                }
            }
            obj = null;
            pna = (eqs) obj;
        }
        eqs eqs = pna;
        AppMethodBeat.o(175475);
        return eqs;
    }

    private static void clx() {
        AppMethodBeat.i(175476);
        try {
            aTI().encode("biz_video_channel_top_bar_info", new byte[0]);
            pna = null;
            AppMethodBeat.o(175476);
        } catch (Exception e2) {
            AppMethodBeat.o(175476);
        }
    }

    public static /* synthetic */ void cly() {
        AppMethodBeat.i(175478);
        b((b.AbstractC0862b) null);
        AppMethodBeat.o(175478);
    }

    public static void b(b.AbstractC0862b bVar) {
        AppMethodBeat.i(175477);
        d.a aVar = new d.a();
        aVar.c(new bqz());
        aVar.d(new bra());
        aVar.MB("/cgi-bin/mmbiz-bin/videochannel/getnotifyandchannelfeeds");
        aVar.sG(1814);
        aa.a(aVar.aXF(), new b(bVar));
        AppMethodBeat.o(175477);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class b implements aa.a {
        final /* synthetic */ b.AbstractC0862b pnh;

        b(b.AbstractC0862b bVar) {
            this.pnh = bVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            String str2;
            AppMethodBeat.i(175464);
            Log.i("MicroMsg.BizVideoChannelStrategy", "alvinluo getNotifyAndChannelFeeds callback errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 == 0 && i3 == 0) {
                p.g(dVar, "comReqResp");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (aYK != null) {
                    if (aYK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetNotifyAndChannelFeedsResp");
                        AppMethodBeat.o(175464);
                        throw tVar;
                    }
                    String str3 = ((bra) aYK).LYz;
                    if (str3 == null) {
                        str2 = "";
                    } else {
                        str2 = str3;
                    }
                    Log.d("MicroMsg.BizVideoChannelStrategy", "alvinuo getNotifyAndChannelFeeds channelFeeds: %s", str2);
                    ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahA(str2);
                    b.AbstractC0862b bVar = this.pnh;
                    if (bVar != null) {
                        bVar.onSuccess(str2);
                    }
                }
            } else {
                b.AbstractC0862b bVar2 = this.pnh;
                if (bVar2 != null) {
                    bVar2.p(i2, i3, str);
                }
            }
            AppMethodBeat.o(175464);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class a implements aa.a {
        final /* synthetic */ int pnf;
        final /* synthetic */ qc png;

        a(int i2, qc qcVar) {
            this.pnf = i2;
            this.png = qcVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            eqs eqs;
            AppMethodBeat.i(195125);
            Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy callback %d/%d %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.pnf == 2 || this.pnf == 1) {
                c cVar = c.pne;
                c.clH().putLong("biz_video_channel_strategy_fetch_last_time", System.currentTimeMillis());
            } else {
                c cVar2 = c.pne;
                c.clH().putLong("biz_video_channel_strategy_tl_fetch_last_time", System.currentTimeMillis());
            }
            if (i2 == 0 && i3 == 0) {
                p.g(dVar, "comReqResp");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (!(aYK instanceof qd)) {
                    aYK = null;
                }
                qd qdVar = (qd) aYK;
                if (qdVar == null) {
                    AppMethodBeat.o(195125);
                } else {
                    eqo eqo = qdVar.KXa;
                    if (eqo == null || (eqs = eqo.NnX) == null || eqs.Nod != 0) {
                        c cVar3 = c.pne;
                        c.report(1);
                        if ((this.png.ReqType & 8) != 0) {
                            c.a(qdVar);
                            c cVar4 = c.pne;
                            c.b(this.pnf, qdVar);
                            c cVar5 = c.pne;
                            c.b(qdVar);
                        }
                        AppMethodBeat.o(195125);
                    } else {
                        Log.i("MicroMsg.BizVideoChannelStrategy", "sync_flag is 0, just return!");
                        AppMethodBeat.o(195125);
                    }
                }
            } else {
                c cVar6 = c.pne;
                c.report(2);
                AppMethodBeat.o(195125);
            }
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ String mkH;
        final /* synthetic */ String pnk;

        e(String str, String str2) {
            this.mkH = str;
            this.pnk = str2;
        }

        public final void run() {
            AppMethodBeat.i(195130);
            Log.i("MicroMsg.BizVideoChannelStrategy", "preloadIcon start = %s", this.mkH);
            com.tencent.mm.av.q.bcV().a(this.mkH, (ImageView) null, new c.a().bdt().ty(R.drawable.bar).bdp().OS(this.pnk).bdv(), AnonymousClass1.pnl);
            AppMethodBeat.o(195130);
        }
    }

    public static boolean clz() {
        AppMethodBeat.i(195135);
        eqs clw = clw();
        if (clw == null) {
            AppMethodBeat.o(195135);
            return false;
        } else if ((clw.Nog & 16) != 0) {
            AppMethodBeat.o(195135);
            return true;
        } else {
            AppMethodBeat.o(195135);
            return false;
        }
    }

    public static boolean clA() {
        AppMethodBeat.i(195136);
        eqs clw = clw();
        if (clw == null) {
            AppMethodBeat.o(195136);
            return false;
        } else if (Util.isNullOrNil(clw.Nob) || aTI().decodeInt("biz_video_channel_show_default_icon", 0) != 1) {
            AppMethodBeat.o(195136);
            return false;
        } else {
            AppMethodBeat.o(195136);
            return true;
        }
    }

    public final boolean clB() {
        AppMethodBeat.i(195137);
        eqs clw = clw();
        if (clw == null) {
            AppMethodBeat.o(195137);
            return false;
        } else if (clA() || Util.isEqual(clw.iwv, clw.Nob)) {
            AppMethodBeat.o(195137);
            return true;
        } else {
            AppMethodBeat.o(195137);
            return false;
        }
    }

    public final String kj(boolean z) {
        AppMethodBeat.i(195139);
        if (Util.isNullOrNil(pmY) || z) {
            eqs clw = clw();
            if (clw == null) {
                AppMethodBeat.o(195139);
                return "";
            }
            String nullAsNil = Util.nullAsNil(clA() ? clw.Nob : clw.iwv);
            p.g(nullAsNil, "Util.nullAsNil(if (isSho…else topBarInfo.logo_url)");
            pmY = nullAsNil;
        }
        String str = pmY;
        AppMethodBeat.o(195139);
        return str;
    }

    public static String clD() {
        AppMethodBeat.i(195140);
        eqs clw = clw();
        if (clw == null) {
            AppMethodBeat.o(195140);
            return "";
        }
        String str = clw.Noc;
        AppMethodBeat.o(195140);
        return str;
    }

    public static boolean clE() {
        AppMethodBeat.i(195141);
        eqs clw = clw();
        if (clw == null || clw.Noi != 1) {
            AppMethodBeat.o(195141);
            return false;
        }
        AppMethodBeat.o(195141);
        return true;
    }

    public static String clG() {
        AppMethodBeat.i(195143);
        eqs clw = clw();
        if (clw == null) {
            Log.w("MicroMsg.BizVideoChannelStrategy", "getProtoData topBarInfo is null");
            AppMethodBeat.o(195143);
            return "";
        }
        byte[] encode = Base64.encode(clw.toByteArray(), 2);
        p.g(encode, "Base64.encode(topBarInfo…eArray(), Base64.NO_WRAP)");
        Charset charset = StandardCharsets.UTF_8;
        p.g(charset, "StandardCharsets.UTF_8");
        String str = new String(encode, charset);
        AppMethodBeat.o(195143);
        return str;
    }

    public static void report(long j2) {
        AppMethodBeat.i(195144);
        h.INSTANCE.n(1416, j2, 1);
        AppMethodBeat.o(195144);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final d pnj = new d();

        static {
            AppMethodBeat.i(175466);
            AppMethodBeat.o(175466);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(175465);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(175465);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.b.c$c  reason: collision with other inner class name */
    static final class C0864c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final C0864c pni = new C0864c();

        static {
            AppMethodBeat.i(195127);
            AppMethodBeat.o(195127);
        }

        C0864c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int i2;
            AppMethodBeat.i(195126);
            c cVar = c.pne;
            MultiProcessMMKV clH = c.clH();
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            Integer valueOf = Integer.valueOf(clH.decodeInt("BizTimeLineChannelCanvasOpen", i2));
            AppMethodBeat.o(195126);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final f pnm = new f();

        static {
            AppMethodBeat.i(195132);
            AppMethodBeat.o(195132);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(195131);
            c cVar = c.pne;
            if (c.clI() != -1) {
                c cVar2 = c.pne;
                if (c.clI() != 1 || c.clw() == null) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                eqs clw = c.clw();
                Log.i("MicroMsg.BizVideoChannelStrategy", "showCanvas " + (clw != null ? Integer.valueOf(clw.Nom) : null));
                if (clw == null || clw.Nom != 1) {
                    z = false;
                } else {
                    z = true;
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195131);
            return valueOf;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void t(int r12, java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 324
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.b.c.t(int, java.lang.String, java.lang.String):void");
    }

    public final boolean clC() {
        AppMethodBeat.i(195138);
        boolean YS = s.YS(com.tencent.mm.pluginsdk.model.s.bdu(kj(false)));
        AppMethodBeat.o(195138);
        return YS;
    }

    public static final /* synthetic */ void b(int i2, qd qdVar) {
        eqs eqs;
        AppMethodBeat.i(195146);
        eqo eqo = qdVar.KXa;
        if (eqo == null || (eqs = eqo.NnX) == null) {
            AppMethodBeat.o(195146);
            return;
        }
        if (i2 == 2 || i2 == 1) {
            if (eqs.gTn > 0) {
                Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy expose interval = %d", Integer.valueOf(eqs.gTn));
                aTI().putLong("biz_video_channel_strategy_fetch_interval", (long) eqs.gTn);
                AppMethodBeat.o(195146);
                return;
            }
        } else if (eqs.gTn > 0) {
            Log.i("MicroMsg.BizVideoChannelStrategy", "fetchBizVideoChannelStrategy tl interval = %d", Integer.valueOf(eqs.gTn));
            aTI().putLong("biz_video_channel_strategy_tl_fetch_interval", (long) eqs.gTn);
        }
        AppMethodBeat.o(195146);
    }

    public static final /* synthetic */ void b(qd qdVar) {
        eqs eqs;
        AppMethodBeat.i(195147);
        eqo eqo = qdVar.KXa;
        if (eqo == null || (eqs = eqo.NnX) == null) {
            AppMethodBeat.o(195147);
            return;
        }
        String[] strArr = {eqs.iwv, eqs.Nob, eqs.Nol};
        p.h(strArr, "$this$distinct");
        p.h(strArr, "$this$toMutableSet");
        LinkedHashSet linkedHashSet = new LinkedHashSet(ae.atJ(3));
        for (int i2 = 0; i2 < 3; i2++) {
            linkedHashSet.add(strArr[i2]);
        }
        for (String str : j.p(linkedHashSet)) {
            String str2 = str;
            if (!(str2 == null || n.aL(str2))) {
                String bdu = com.tencent.mm.pluginsdk.model.s.bdu(str);
                if (!s.YS(bdu)) {
                    report(10);
                    com.tencent.f.h.RTc.aV(new e(str, bdu));
                }
            }
        }
        AppMethodBeat.o(195147);
    }

    public static final /* synthetic */ int clI() {
        AppMethodBeat.i(195148);
        int intValue = ((Number) pnc.getValue()).intValue();
        AppMethodBeat.o(195148);
        return intValue;
    }
}
