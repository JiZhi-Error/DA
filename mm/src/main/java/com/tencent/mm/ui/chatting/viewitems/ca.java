package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021;", "", "()V", "ChattingItemAppMsgFestival2021From", "ChattingItemAppMsgFestival2021To", "Companion", "app_release"})
public final class ca {
    private static final String TAG = TAG;
    public static final c VlI = new c((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkLiveStatus", "", "scene", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"})
    public static final class c {

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/festival/api/IFestivalExportService$FestivalLiveInfo;", "kotlin.jvm.PlatformType", "onInfoUpdate"})
        public static final class a {
            public static final a VlJ = new a();

            static {
                AppMethodBeat.i(259072);
                AppMethodBeat.o(259072);
            }

            a() {
            }
        }

        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static void a(Activity activity, com.tencent.mm.storage.ca caVar) {
            k.b HD;
            AppMethodBeat.i(259073);
            p.h(activity, "context");
            p.h(caVar, "msg");
            if (!Util.isNullOrNil(caVar.getContent()) && (HD = k.b.HD(caVar.getContent())) != null) {
                Intent intent = new Intent(activity, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_Type", 29);
                intent.putExtra("Multi_Retr", true);
                intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(259073);
        }

        public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf) {
            boolean z;
            String str;
            AppMethodBeat.i(259074);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            p.h(axf, "shareObject");
            a aVar = a.VlJ;
            int i2 = ((com.tencent.mm.plugin.festival.a.a) g.af(com.tencent.mm.plugin.festival.a.a.class)).dnB().liveStatus;
            Log.i(ca.TAG, "[checkLiveStatus] festival,desc:" + axf.desc + ",share status:" + axf.liveStatus);
            String str2 = axf.coverUrl;
            if (!(str2 == null || str2.length() == 0)) {
                str = axf.coverUrl;
            } else {
                String str3 = axf.headUrl;
                if (str3 == null || str3.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    str = axf.headUrl;
                } else {
                    str = "";
                }
            }
            if (i2 == 2) {
                axf.liveStatus = i2;
                FinderLiveOnliveWidget liveTag = appMsgFinderLiveFeedHolder.getLiveTag();
                if (liveTag != null) {
                    liveTag.setVisibility(8);
                }
                FinderLiveOnliveWidget liveEndTag = appMsgFinderLiveFeedHolder.getLiveEndTag();
                if (liveEndTag != null) {
                    liveEndTag.setVisibility(0);
                }
                ((aj) g.ah(aj.class)).getFinderUtilApi().g(appMsgFinderLiveFeedHolder.getFinderThumb(), str);
                AppMethodBeat.o(259074);
                return;
            }
            if (i2 == 1) {
                axf.liveStatus = i2;
            }
            AppMethodBeat.o(259074);
        }
    }

    static {
        AppMethodBeat.i(259075);
        AppMethodBeat.o(259075);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$ChattingItemAppMsgFestival2021To;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "()V", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onItemClick", "", "v", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "", "isSender", "app_release"})
    public static final class b extends ChatingItemAppMsgFinderLiveFeed.b {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.b
        public final boolean bM(int i2, boolean z) {
            return z && i2 == 1074790449;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.b
        public final void a(Activity activity, com.tencent.mm.storage.ca caVar) {
            AppMethodBeat.i(259069);
            p.h(activity, "context");
            p.h(caVar, "msg");
            c cVar = ca.VlI;
            c.a(activity, caVar);
            AppMethodBeat.o(259069);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.b
        public final void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf, com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(259070);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            p.h(axf, "shareObject");
            p.h(aVar, "ui");
            c cVar = ca.VlI;
            c.a(appMsgFinderLiveFeedHolder, axf);
            AppMethodBeat.o(259070);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.b
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, com.tencent.mm.storage.ca caVar) {
            AppMethodBeat.i(259071);
            p.h(view, "v");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            ((com.tencent.mm.plugin.festival.a.a) g.af(com.tencent.mm.plugin.festival.a.a.class)).ba(view.getContext(), 10);
            AppMethodBeat.o(259071);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFestival2021$ChattingItemAppMsgFestival2021From;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "()V", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "onItemClick", "", "v", "Landroid/view/View;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "", "isSender", "app_release"})
    public static final class a extends ChatingItemAppMsgFinderLiveFeed.a {
        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.a
        public final boolean bM(int i2, boolean z) {
            return !z && i2 == 1074790449;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.a
        public final void a(Activity activity, com.tencent.mm.storage.ca caVar) {
            AppMethodBeat.i(259066);
            p.h(activity, "context");
            p.h(caVar, "msg");
            c cVar = ca.VlI;
            c.a(activity, caVar);
            AppMethodBeat.o(259066);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.a
        public final void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf, com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(259067);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            p.h(axf, "shareObject");
            p.h(aVar, "ui");
            c cVar = ca.VlI;
            c.a(appMsgFinderLiveFeedHolder, axf);
            AppMethodBeat.o(259067);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c, com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed.a
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, com.tencent.mm.storage.ca caVar) {
            AppMethodBeat.i(259068);
            p.h(view, "v");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            ((com.tencent.mm.plugin.festival.a.a) g.af(com.tencent.mm.plugin.festival.a.a.class)).ba(view.getContext(), 10);
            AppMethodBeat.o(259068);
            return false;
        }
    }
}
