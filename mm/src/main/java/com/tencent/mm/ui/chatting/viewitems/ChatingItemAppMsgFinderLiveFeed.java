package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.Keep;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.live.q;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.view.NinePatchCropImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\b"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed;", "", "()V", "AppMsgFinderLiveFeedHolder", "ChattingItemAppMsgFinderLiveFeedFrom", "ChattingItemAppMsgFinderLiveFeedTo", "Companion", "IChattingItemAppMsgFinderLiveFeed", "app_release"})
public final class ChatingItemAppMsgFinderLiveFeed {
    public static final c PGG = new c((byte) 0);
    private static final String TAG = TAG;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustMediaHeight", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "width", "", "height", "checkLiveStatus", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static void a(AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder) {
            AppMethodBeat.i(231367);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            int width = appMsgFinderLiveFeedHolder.getWidth();
            ImageView finderThumb = appMsgFinderLiveFeedHolder.getFinderThumb();
            if (finderThumb == null) {
                p.hyc();
            }
            ViewGroup.LayoutParams layoutParams = finderThumb.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(231367);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = width;
            ImageView finderThumb2 = appMsgFinderLiveFeedHolder.getFinderThumb();
            if (finderThumb2 == null) {
                p.hyc();
            }
            finderThumb2.setLayoutParams(layoutParams2);
            AppMethodBeat.o(231367);
        }

        public static void a(Activity activity, ca caVar) {
            k.b HD;
            AppMethodBeat.i(231368);
            p.h(activity, "context");
            p.h(caVar, "msg");
            if (!Util.isNullOrNil(caVar.getContent()) && (HD = k.b.HD(caVar.getContent())) != null) {
                Intent intent = new Intent(activity, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_Type", 23);
                intent.putExtra("Multi_Retr", true);
                intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(231368);
        }

        public static void a(AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf, com.tencent.mm.ui.chatting.e.a aVar) {
            Long buB;
            AppMethodBeat.i(231369);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            p.h(axf, "shareObject");
            p.h(aVar, "ui");
            String str = axf.hJs;
            long longValue = (str == null || (buB = n.buB(str)) == null) ? 0 : buB.longValue();
            ((aj) g.ah(aj.class)).refreshLiveStatus(Long.valueOf(longValue), new a(longValue, axf, appMsgFinderLiveFeedHolder));
            AppMethodBeat.o(231369);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "liveId", "", "status", "", "liveInfo", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
        public static final class a implements aj.b {
            final /* synthetic */ long EYq;
            final /* synthetic */ AppMsgFinderLiveFeedHolder PGI;
            final /* synthetic */ axf PGN;

            a(long j2, axf axf, AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder) {
                this.EYq = j2;
                this.PGN = axf;
                this.PGI = appMsgFinderLiveFeedHolder;
            }

            @Override // com.tencent.mm.plugin.i.a.aj.b
            public final void a(long j2, int i2, Object obj) {
                boolean z;
                String str;
                AppMethodBeat.i(231366);
                c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
                Log.i(ChatingItemAppMsgFinderLiveFeed.TAG, "[checkLiveStatus] thisLiveId:" + this.EYq + ",liveID:" + j2 + ",desc:" + this.PGN.desc + ",share status:" + this.PGN.liveStatus + ",callback liveStatus:" + i2);
                if (this.EYq == j2) {
                    String str2 = this.PGN.coverUrl;
                    if (!(str2 == null || str2.length() == 0)) {
                        str = this.PGN.coverUrl;
                    } else {
                        String str3 = this.PGN.headUrl;
                        if (str3 == null || str3.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            str = this.PGN.headUrl;
                        } else {
                            str = "";
                        }
                    }
                    if (i2 == 2) {
                        this.PGN.liveStatus = i2;
                        FinderLiveOnliveWidget liveTag = this.PGI.getLiveTag();
                        if (liveTag != null) {
                            liveTag.setVisibility(8);
                        }
                        FinderLiveOnliveWidget liveEndTag = this.PGI.getLiveEndTag();
                        if (liveEndTag != null) {
                            liveEndTag.setVisibility(0);
                        }
                        ((aj) g.ah(aj.class)).getFinderUtilApi().g(this.PGI.getFinderThumb(), str);
                        AppMethodBeat.o(231366);
                        return;
                    } else if (i2 == 1) {
                        this.PGN.liveStatus = i2;
                    }
                }
                AppMethodBeat.o(231366);
            }
        }
    }

    static {
        AppMethodBeat.i(231370);
        AppMethodBeat.o(231370);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010&\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$IChattingItemAppMsgFinderLiveFeed;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "filling", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "Companion", "app_release"})
    public static class b extends c implements t.n {
        public static final a PGL = new a((byte) 0);
        private com.tencent.mm.ui.chatting.e.a PhN;

        static {
            AppMethodBeat.i(231365);
            AppMethodBeat.o(231365);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean bM(int i2, boolean z) {
            return z && i2 == 973078577;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(231359);
            p.h(layoutInflater, "inflater");
            if (view == null || view.getTag() == null) {
                an anVar = new an(layoutInflater, R.layout.ss);
                anVar.setTag(new AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(anVar, true));
                view = anVar;
            }
            AppMethodBeat.o(231359);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            AppMethodBeat.i(231360);
            p.h(aVar, "tag");
            p.h(aVar2, "ui");
            p.h(caVar, "msg");
            p.h(str, "userName");
            this.PhN = aVar2;
            AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder = (AppMsgFinderLiveFeedHolder) aVar;
            View detailLayout = appMsgFinderLiveFeedHolder.getDetailLayout();
            if (detailLayout == null) {
                p.hyc();
            }
            detailLayout.animate().cancel();
            View detailLayout2 = appMsgFinderLiveFeedHolder.getDetailLayout();
            if (detailLayout2 == null) {
                p.hyc();
            }
            detailLayout2.setTag(Long.valueOf(System.currentTimeMillis()));
            String content = caVar.getContent();
            k.b bVar = null;
            if (content != null) {
                bVar = k.b.aD(content, caVar.ajQ());
            }
            if (bVar != null) {
                axf axf = ((com.tencent.mm.plugin.i.a.b) bVar.as(com.tencent.mm.plugin.i.a.b.class)).wDV;
                if (axf != null) {
                    m mVar = m.uJa;
                    d<o> dka = m.dka();
                    com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(axf.headUrl, x.THUMB_IMAGE);
                    ImageView finderAvatar = appMsgFinderLiveFeedHolder.getFinderAvatar();
                    if (finderAvatar == null) {
                        p.hyc();
                    }
                    m mVar2 = m.uJa;
                    dka.a(pVar, finderAvatar, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    TextView finderNickname = appMsgFinderLiveFeedHolder.getFinderNickname();
                    if (finderNickname == null) {
                        p.hyc();
                    }
                    finderNickname.setText(com.tencent.mm.pluginsdk.ui.span.l.c(aVar2.getContext(), axf.nickName));
                    TextView finderNickname2 = appMsgFinderLiveFeedHolder.getFinderNickname();
                    if (finderNickname2 == null) {
                        p.hyc();
                    }
                    ao.a(finderNickname2.getPaint(), 0.8f);
                    if (axf.liveStatus == 1) {
                        String str3 = axf.coverUrl;
                        if (!(str3 == null || str3.length() == 0)) {
                            str2 = axf.coverUrl;
                        } else {
                            String str4 = axf.headUrl;
                            if (!(str4 == null || str4.length() == 0)) {
                                str2 = axf.headUrl;
                            } else {
                                str2 = "";
                            }
                        }
                        FinderLiveOnliveWidget liveTag = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag != null) {
                            liveTag.setVisibility(0);
                        }
                        FinderLiveOnliveWidget liveEndTag = appMsgFinderLiveFeedHolder.getLiveEndTag();
                        if (liveEndTag != null) {
                            liveEndTag.setVisibility(8);
                        }
                        FinderLiveOnliveWidget liveTag2 = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag2 != null) {
                            Activity context = aVar2.getContext();
                            p.g(context, "ui.context");
                            String string = context.getResources().getString(R.string.cz1);
                            p.g(string, "ui.context.resources.get…live_share_onlive_status)");
                            liveTag2.setText(string);
                        }
                        ((aj) g.ah(aj.class)).loadImage(str2, appMsgFinderLiveFeedHolder.getFinderThumb());
                        com.tencent.mm.ac.d.a(200, new C2105b(this, appMsgFinderLiveFeedHolder, axf, aVar2));
                    } else if (axf.liveStatus == 2) {
                        String str5 = "";
                        String str6 = axf.coverUrl;
                        if (!(str6 == null || str6.length() == 0)) {
                            String str7 = axf.coverUrl;
                            p.g(str7, "finderObject.coverUrl");
                            str5 = str7;
                        } else {
                            String str8 = axf.headUrl;
                            if (!(str8 == null || str8.length() == 0)) {
                                String str9 = axf.headUrl;
                                p.g(str9, "finderObject.headUrl");
                                str5 = str9;
                            }
                        }
                        FinderLiveOnliveWidget liveTag3 = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag3 != null) {
                            liveTag3.setVisibility(8);
                        }
                        FinderLiveOnliveWidget liveEndTag2 = appMsgFinderLiveFeedHolder.getLiveEndTag();
                        if (liveEndTag2 != null) {
                            liveEndTag2.setVisibility(0);
                        }
                        FinderLiveOnliveWidget liveTag4 = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag4 != null) {
                            Activity context2 = aVar2.getContext();
                            p.g(context2, "ui.context");
                            String string2 = context2.getResources().getString(R.string.cz1);
                            p.g(string2, "ui.context.resources.get…live_share_onlive_status)");
                            liveTag4.setText(string2);
                        }
                        ((aj) g.ah(aj.class)).getFinderUtilApi().g(appMsgFinderLiveFeedHolder.getFinderThumb(), str5);
                    }
                    c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
                    c.a(appMsgFinderLiveFeedHolder);
                    ImageView finderThumb = appMsgFinderLiveFeedHolder.getFinderThumb();
                    if (finderThumb == null) {
                        p.hyc();
                    }
                    finderThumb.setVisibility(0);
                    String str10 = axf.desc;
                    if (str10 == null || str10.length() == 0) {
                        TextView finderDesc = appMsgFinderLiveFeedHolder.getFinderDesc();
                        if (finderDesc == null) {
                            p.hyc();
                        }
                        finderDesc.setVisibility(8);
                    } else {
                        TextView finderDesc2 = appMsgFinderLiveFeedHolder.getFinderDesc();
                        if (finderDesc2 == null) {
                            p.hyc();
                        }
                        finderDesc2.setVisibility(0);
                        TextView finderDesc3 = appMsgFinderLiveFeedHolder.getFinderDesc();
                        if (finderDesc3 == null) {
                            p.hyc();
                        }
                        finderDesc3.setText(axf.desc);
                    }
                }
                appMsgFinderLiveFeedHolder.clickArea.setOnClickListener(d(aVar2));
                appMsgFinderLiveFeedHolder.clickArea.setOnLongClickListener(c(aVar2));
                View view = appMsgFinderLiveFeedHolder.clickArea;
                af bh = aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                p.g(bh, "ui.component(IChattingLi…terComponent::class.java)");
                view.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) bh).gOC());
                com.tencent.mm.ui.chatting.e.a aVar3 = this.PhN;
                if (aVar3 == null) {
                    p.hyc();
                }
                bq bqVar = new bq(caVar, aVar3.gRM(), i2, (String) null, (char) 0);
                View view2 = appMsgFinderLiveFeedHolder.clickArea;
                p.g(view2, "holder.clickArea");
                view2.setTag(bqVar);
            }
            if (c.gTW()) {
                if (appMsgFinderLiveFeedHolder.uploadingPB != null) {
                    ProgressBar progressBar = appMsgFinderLiveFeedHolder.uploadingPB;
                    p.g(progressBar, "holder.uploadingPB");
                    progressBar.setVisibility(8);
                }
                if (caVar.getStatus() != 2 || !b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.ajL())) {
                    if (appMsgFinderLiveFeedHolder.getTickIV() != null) {
                        ImageView tickIV = appMsgFinderLiveFeedHolder.getTickIV();
                        if (tickIV == null) {
                            p.hyc();
                        }
                        tickIV.setVisibility(8);
                    }
                } else if (appMsgFinderLiveFeedHolder.getTickIV() != null) {
                    ImageView tickIV2 = appMsgFinderLiveFeedHolder.getTickIV();
                    if (tickIV2 == null) {
                        p.hyc();
                    }
                    tickIV2.setVisibility(0);
                }
            } else {
                if (appMsgFinderLiveFeedHolder.getTickIV() != null) {
                    ImageView tickIV3 = appMsgFinderLiveFeedHolder.getTickIV();
                    if (tickIV3 == null) {
                        p.hyc();
                    }
                    tickIV3.setVisibility(8);
                }
                b(appMsgFinderLiveFeedHolder, caVar.getStatus() < 2);
            }
            a(i2, appMsgFinderLiveFeedHolder, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(231360);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(231361);
            p.h(view, "v");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.ajL());
                aVar.BN(true);
            }
            AppMethodBeat.o(231361);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(231362);
            p.h(mVar, "menu");
            p.h(view, "v");
            Object tag = view.getTag();
            if (tag == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
                AppMethodBeat.o(231362);
                throw tVar;
            }
            int i2 = ((bq) tag).position;
            if (caVar != null) {
                com.tencent.mm.ui.chatting.e.a aVar = this.PhN;
                if (aVar == null) {
                    p.hyc();
                }
                mVar.a(i2, 111, aVar.getResources().getString(R.string.g5c), R.raw.icons_filled_share);
                mVar.removeItem(116);
                if ((caVar.getStatus() == 2 || caVar.ajS() == 1) && b(caVar, this.PhN) && bnf(caVar.ajO())) {
                    com.tencent.mm.ui.chatting.e.a aVar2 = this.PhN;
                    if (aVar2 == null) {
                        p.hyc();
                    }
                    if (!aVar2.gRO()) {
                        mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    }
                }
            }
            AppMethodBeat.o(231362);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(231363);
            p.h(menuItem, "item");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            switch (menuItem.getItemId()) {
                case 111:
                    Activity context = aVar.getContext();
                    p.g(context, "ui.context");
                    a(context, caVar);
                    AppMethodBeat.o(231363);
                    return true;
                default:
                    AppMethodBeat.o(231363);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            com.tencent.mm.plugin.i.a.b bVar;
            long j2;
            AppMethodBeat.i(231364);
            p.h(view, "v");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            String content = caVar.getContent();
            k.b bVar2 = null;
            if (content != null) {
                bVar2 = k.b.aD(content, caVar.ajQ());
            }
            if (!(bVar2 == null || (bVar = (com.tencent.mm.plugin.i.a.b) bVar2.as(com.tencent.mm.plugin.i.a.b.class)) == null)) {
                long Ga = com.tencent.mm.ac.d.Ga(bVar.wDV.feedId);
                long Ga2 = com.tencent.mm.ac.d.Ga(bVar.wDV.hJs);
                if (Ga != 0) {
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (((Boolean) com.tencent.mm.plugin.finder.storage.c.dvR().value()).booleanValue()) {
                        Intent intent = new Intent();
                        intent.putExtra("feed_object_id", Ga);
                        intent.putExtra("feed_object_nonceId", bVar.wDV.objectNonceId);
                        ((aj) g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), intent);
                    } else {
                        String a2 = a(aVar, caVar);
                        if (a2 == null) {
                            as talker = aVar.getTalker();
                            p.g(talker, "ui.talker");
                            a2 = talker.getUsername();
                        }
                        if (a2 == null) {
                            a2 = "";
                        }
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = a2;
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs(aVar.getTalker().gMZ);
                        if (Util.isEqual(bVar.wDV.username, z.aUg())) {
                            ((aj) g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), Ga, Long.valueOf(Ga2), bVar.wDV.objectNonceId, bVar.wDV.desc, "", "", "");
                        } else {
                            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            String str = bVar.wDV.username;
                            p.g(str, "finderObject.shareObject.username");
                            s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM;
                            String str2 = s.j.COMMENT_SCENE_SHARE_PAGE.scene;
                            if (bVar.wDV.liveStatus == 1) {
                                j2 = s.n.LIVE_LIVING.jii;
                            } else {
                                j2 = s.n.LIVE_STOPPED.jii;
                            }
                            c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                            long cPi = (long) c.a.cPi();
                            String str3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq;
                            if (str3 == null) {
                                str3 = "";
                            }
                            String str4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr;
                            if (str4 == null) {
                                str4 = "";
                            }
                            com.tencent.mm.plugin.finder.report.live.k.b(new q(Ga, Ga2, str, 0, -1, pVar, str2, j2, cPi, str3, str4, System.currentTimeMillis(), s.av.CLICK_LIVE_CARD));
                            ((aj) g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), Ga, Long.valueOf(Ga2), bVar.wDV.username, bVar.wDV.objectNonceId, bVar.wDV.desc, "", "", "", 0);
                        }
                    }
                }
            }
            AppMethodBeat.o(231364);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo$Companion;", "", "()V", "TAG", "", "app_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public void a(Activity activity, ca caVar) {
            AppMethodBeat.i(259064);
            p.h(activity, "context");
            p.h(caVar, "msg");
            c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
            c.a(activity, caVar);
            AppMethodBeat.o(259064);
        }

        public void a(AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf, com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(259065);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            p.h(axf, "shareObject");
            p.h(aVar, "ui");
            c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
            c.a(appMsgFinderLiveFeedHolder, axf, aVar);
            AppMethodBeat.o(259065);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed$b$b  reason: collision with other inner class name */
        static final class C2105b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ AppMsgFinderLiveFeedHolder PGI;
            final /* synthetic */ com.tencent.mm.ui.chatting.e.a PGK;
            final /* synthetic */ axf PGM;
            final /* synthetic */ b VlD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2105b(b bVar, AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf, com.tencent.mm.ui.chatting.e.a aVar) {
                super(0);
                this.VlD = bVar;
                this.PGI = appMsgFinderLiveFeedHolder;
                this.PGM = axf;
                this.PGK = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(231358);
                this.VlD.a(this.PGI, this.PGM, this.PGK);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(231358);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$IChattingItemAppMsgFinderLiveFeed;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "filling", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "Companion", "app_release"})
    public static class a extends c {
        public static final C2104a PGH = new C2104a((byte) 0);
        private com.tencent.mm.ui.chatting.e.a PhN;

        static {
            AppMethodBeat.i(231357);
            AppMethodBeat.o(231357);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean bM(int i2, boolean z) {
            return !z && i2 == 973078577;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(231352);
            p.h(layoutInflater, "inflater");
            if (view == null || view.getTag() == null) {
                an anVar = new an(layoutInflater, R.layout.re);
                anVar.setTag(new AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(anVar, false));
                view = anVar;
            }
            AppMethodBeat.o(231352);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String str2;
            AppMethodBeat.i(231353);
            p.h(aVar, "tag");
            p.h(aVar2, "ui");
            p.h(caVar, "msg");
            p.h(str, "userName");
            this.PhN = aVar2;
            AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder = (AppMsgFinderLiveFeedHolder) aVar;
            View detailLayout = appMsgFinderLiveFeedHolder.getDetailLayout();
            if (detailLayout == null) {
                p.hyc();
            }
            detailLayout.animate().cancel();
            View detailLayout2 = appMsgFinderLiveFeedHolder.getDetailLayout();
            if (detailLayout2 == null) {
                p.hyc();
            }
            detailLayout2.setTag(Long.valueOf(System.currentTimeMillis()));
            String content = caVar.getContent();
            k.b bVar = null;
            if (content != null) {
                bVar = k.b.aD(content, caVar.ajQ());
            }
            if (bVar != null) {
                com.tencent.mm.plugin.i.a.b bVar2 = (com.tencent.mm.plugin.i.a.b) bVar.as(com.tencent.mm.plugin.i.a.b.class);
                if (bVar2 != null) {
                    m mVar = m.uJa;
                    d<o> dka = m.dka();
                    com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(bVar2.wDV.headUrl, x.THUMB_IMAGE);
                    ImageView finderAvatar = appMsgFinderLiveFeedHolder.getFinderAvatar();
                    if (finderAvatar == null) {
                        p.hyc();
                    }
                    m mVar2 = m.uJa;
                    dka.a(pVar, finderAvatar, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    TextView finderNickname = appMsgFinderLiveFeedHolder.getFinderNickname();
                    if (finderNickname == null) {
                        p.hyc();
                    }
                    finderNickname.setText(com.tencent.mm.pluginsdk.ui.span.l.c(aVar2.getContext(), bVar2.wDV.nickName));
                    TextView finderNickname2 = appMsgFinderLiveFeedHolder.getFinderNickname();
                    if (finderNickname2 == null) {
                        p.hyc();
                    }
                    ao.a(finderNickname2.getPaint(), 0.8f);
                    if (bVar2.wDV.liveStatus == 1) {
                        String str3 = bVar2.wDV.coverUrl;
                        if (str3 == null || str3.length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            str2 = bVar2.wDV.coverUrl;
                        } else {
                            String str4 = bVar2.wDV.headUrl;
                            if (str4 == null || str4.length() == 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                str2 = bVar2.wDV.headUrl;
                            } else {
                                str2 = "";
                            }
                        }
                        FinderLiveOnliveWidget liveTag = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag != null) {
                            liveTag.setVisibility(0);
                        }
                        FinderLiveOnliveWidget liveEndTag = appMsgFinderLiveFeedHolder.getLiveEndTag();
                        if (liveEndTag != null) {
                            liveEndTag.setVisibility(8);
                        }
                        FinderLiveOnliveWidget liveTag2 = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag2 != null) {
                            Activity context = aVar2.getContext();
                            p.g(context, "ui.context");
                            String string = context.getResources().getString(R.string.cz1);
                            p.g(string, "ui.context.resources.get…live_share_onlive_status)");
                            liveTag2.setText(string);
                        }
                        ((aj) g.ah(aj.class)).loadImage(str2, appMsgFinderLiveFeedHolder.getFinderThumb());
                        com.tencent.mm.ac.d.a(200, new b(this, appMsgFinderLiveFeedHolder, bVar2, aVar2));
                    } else if (bVar2.wDV.liveStatus == 2) {
                        String str5 = "";
                        String str6 = bVar2.wDV.coverUrl;
                        if (str6 == null || str6.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            String str7 = bVar2.wDV.coverUrl;
                            p.g(str7, "finderObject.shareObject.coverUrl");
                            str5 = str7;
                        } else {
                            String str8 = bVar2.wDV.headUrl;
                            if (str8 == null || str8.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                String str9 = bVar2.wDV.headUrl;
                                p.g(str9, "finderObject.shareObject.headUrl");
                                str5 = str9;
                            }
                        }
                        FinderLiveOnliveWidget liveTag3 = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag3 != null) {
                            liveTag3.setVisibility(8);
                        }
                        FinderLiveOnliveWidget liveEndTag2 = appMsgFinderLiveFeedHolder.getLiveEndTag();
                        if (liveEndTag2 != null) {
                            liveEndTag2.setVisibility(0);
                        }
                        FinderLiveOnliveWidget liveTag4 = appMsgFinderLiveFeedHolder.getLiveTag();
                        if (liveTag4 != null) {
                            Activity context2 = aVar2.getContext();
                            p.g(context2, "ui.context");
                            String string2 = context2.getResources().getString(R.string.cz1);
                            p.g(string2, "ui.context.resources.get…live_share_onlive_status)");
                            liveTag4.setText(string2);
                        }
                        ((aj) g.ah(aj.class)).getFinderUtilApi().g(appMsgFinderLiveFeedHolder.getFinderThumb(), str5);
                    }
                    c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
                    c.a(appMsgFinderLiveFeedHolder);
                    ImageView finderThumb = appMsgFinderLiveFeedHolder.getFinderThumb();
                    if (finderThumb == null) {
                        p.hyc();
                    }
                    finderThumb.setVisibility(0);
                    String str10 = bVar2.wDV.desc;
                    if (str10 == null || str10.length() == 0) {
                        TextView finderDesc = appMsgFinderLiveFeedHolder.getFinderDesc();
                        if (finderDesc == null) {
                            p.hyc();
                        }
                        finderDesc.setVisibility(8);
                    } else {
                        TextView finderDesc2 = appMsgFinderLiveFeedHolder.getFinderDesc();
                        if (finderDesc2 == null) {
                            p.hyc();
                        }
                        finderDesc2.setVisibility(0);
                        TextView finderDesc3 = appMsgFinderLiveFeedHolder.getFinderDesc();
                        if (finderDesc3 == null) {
                            p.hyc();
                        }
                        finderDesc3.setText(bVar2.wDV.desc);
                    }
                }
                appMsgFinderLiveFeedHolder.clickArea.setOnClickListener(d(aVar2));
                appMsgFinderLiveFeedHolder.clickArea.setOnLongClickListener(c(aVar2));
                View view = appMsgFinderLiveFeedHolder.clickArea;
                af bh = aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                p.g(bh, "ui.component(IChattingLi…terComponent::class.java)");
                view.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) bh).gOC());
                com.tencent.mm.ui.chatting.e.a aVar3 = this.PhN;
                if (aVar3 == null) {
                    p.hyc();
                }
                bq bqVar = new bq(caVar, aVar3.gRM(), i2, (String) null, (char) 0);
                View view2 = appMsgFinderLiveFeedHolder.clickArea;
                p.g(view2, "holder.clickArea");
                view2.setTag(bqVar);
            }
            AppMethodBeat.o(231353);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(231354);
            p.h(mVar, "menu");
            p.h(view, "v");
            Object tag = view.getTag();
            if (tag == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
                AppMethodBeat.o(231354);
                throw tVar;
            }
            int i2 = ((bq) tag).position;
            if (caVar != null) {
                com.tencent.mm.ui.chatting.e.a aVar = this.PhN;
                if (aVar == null) {
                    p.hyc();
                }
                mVar.a(i2, 111, aVar.getResources().getString(R.string.g5c), R.raw.icons_filled_share);
                mVar.removeItem(116);
            }
            AppMethodBeat.o(231354);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(231355);
            p.h(menuItem, "item");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            switch (menuItem.getItemId()) {
                case 111:
                    Activity context = aVar.getContext();
                    p.g(context, "ui.context");
                    a(context, caVar);
                    AppMethodBeat.o(231355);
                    return true;
                default:
                    AppMethodBeat.o(231355);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            com.tencent.mm.plugin.i.a.b bVar;
            long j2;
            AppMethodBeat.i(231356);
            p.h(view, "v");
            p.h(aVar, "ui");
            p.h(caVar, "msg");
            String content = caVar.getContent();
            k.b bVar2 = null;
            if (content != null) {
                bVar2 = k.b.aD(content, caVar.ajQ());
            }
            if (!(bVar2 == null || (bVar = (com.tencent.mm.plugin.i.a.b) bVar2.as(com.tencent.mm.plugin.i.a.b.class)) == null)) {
                long Ga = com.tencent.mm.ac.d.Ga(bVar.wDV.feedId);
                long Ga2 = com.tencent.mm.ac.d.Ga(bVar.wDV.hJs);
                if (Ga != 0) {
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (((Boolean) com.tencent.mm.plugin.finder.storage.c.dvR().value()).booleanValue()) {
                        Intent intent = new Intent();
                        intent.putExtra("feed_object_id", Ga);
                        intent.putExtra("feed_object_nonceId", bVar.wDV.objectNonceId);
                        ((aj) g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), intent);
                    } else if (Util.isEqual(bVar.wDV.username, z.aUg())) {
                        ((aj) g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), Ga, Long.valueOf(Ga2), bVar.wDV.objectNonceId, bVar.wDV.desc, "", "", "");
                    } else {
                        String a2 = a(aVar, caVar);
                        if (a2 == null) {
                            as talker = aVar.getTalker();
                            p.g(talker, "ui.talker");
                            a2 = talker.getUsername();
                        }
                        if (a2 == null) {
                            a2 = "";
                        }
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = a2;
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs(aVar.getTalker().gMZ);
                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        String str = bVar.wDV.username;
                        p.g(str, "finderObject.shareObject.username");
                        s.p pVar = s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM;
                        String str2 = s.j.COMMENT_SCENE_SHARE_PAGE.scene;
                        if (bVar.wDV.liveStatus == 1) {
                            j2 = s.n.LIVE_LIVING.jii;
                        } else {
                            j2 = s.n.LIVE_STOPPED.jii;
                        }
                        c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                        long cPi = (long) c.a.cPi();
                        String str3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr;
                        if (str4 == null) {
                            str4 = "";
                        }
                        com.tencent.mm.plugin.finder.report.live.k.b(new q(Ga, Ga2, str, 0, -1, pVar, str2, j2, cPi, str3, str4, System.currentTimeMillis(), s.av.CLICK_LIVE_CARD));
                        ((aj) g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), Ga, Long.valueOf(Ga2), bVar.wDV.username, bVar.wDV.objectNonceId, bVar.wDV.desc, "", "", "", 0);
                    }
                }
            }
            AppMethodBeat.o(231356);
            return false;
        }

        public void a(Activity activity, ca caVar) {
            AppMethodBeat.i(259062);
            p.h(activity, "context");
            p.h(caVar, "msg");
            c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
            c.a(activity, caVar);
            AppMethodBeat.o(259062);
        }

        public void a(AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, axf axf, com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(259063);
            p.h(appMsgFinderLiveFeedHolder, "holder");
            p.h(axf, "shareObject");
            p.h(aVar, "ui");
            c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
            c.a(appMsgFinderLiveFeedHolder, axf, aVar);
            AppMethodBeat.o(259063);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom$Companion;", "", "()V", "TAG", "", "app_release"})
        /* renamed from: com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed$a$a  reason: collision with other inner class name */
        public static final class C2104a {
            private C2104a() {
            }

            public /* synthetic */ C2104a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ AppMsgFinderLiveFeedHolder PGI;
            final /* synthetic */ com.tencent.mm.plugin.i.a.b PGJ;
            final /* synthetic */ com.tencent.mm.ui.chatting.e.a PGK;
            final /* synthetic */ a VlC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, AppMsgFinderLiveFeedHolder appMsgFinderLiveFeedHolder, com.tencent.mm.plugin.i.a.b bVar, com.tencent.mm.ui.chatting.e.a aVar2) {
                super(0);
                this.VlC = aVar;
                this.PGI = appMsgFinderLiveFeedHolder;
                this.PGJ = bVar;
                this.PGK = aVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(231351);
                this.VlC.a(this.PGI, this.PGJ.wDV, this.PGK);
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(231351);
                return xVar;
            }
        }
    }

    @Keep
    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u000206J\n\u00107\u001a\u0004\u0018\u00010\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010*\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00068"}, hxF = {"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "detailLayout", "Landroid/view/View;", "getDetailLayout", "()Landroid/view/View;", "setDetailLayout", "(Landroid/view/View;)V", "finderAvatar", "Landroid/widget/ImageView;", "getFinderAvatar", "()Landroid/widget/ImageView;", "setFinderAvatar", "(Landroid/widget/ImageView;)V", "finderDesc", "Landroid/widget/TextView;", "getFinderDesc", "()Landroid/widget/TextView;", "setFinderDesc", "(Landroid/widget/TextView;)V", "finderIcon", "getFinderIcon", "setFinderIcon", "finderNickname", "getFinderNickname", "setFinderNickname", "finderText", "getFinderText", "setFinderText", "finderThumb", "getFinderThumb", "setFinderThumb", "liveEndTag", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getLiveEndTag", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setLiveEndTag", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "liveTag", "getLiveTag", "setLiveTag", "tickIV", "getTickIV", "setTickIV", "width", "", "getWidth", "()I", "setWidth", "(I)V", "createAppMsgFinderFeedHolder", "view", "isSend", "", "getMainContainerView", "app_release"})
    public static final class AppMsgFinderLiveFeedHolder extends c.a {
        private View detailLayout;
        private ImageView finderAvatar;
        private TextView finderDesc;
        private ImageView finderIcon;
        private TextView finderNickname;
        private TextView finderText;
        private ImageView finderThumb;
        private FinderLiveOnliveWidget liveEndTag;
        private FinderLiveOnliveWidget liveTag;
        private ImageView tickIV;
        private int width;

        public final ImageView getFinderAvatar() {
            return this.finderAvatar;
        }

        public final void setFinderAvatar(ImageView imageView) {
            this.finderAvatar = imageView;
        }

        public final TextView getFinderNickname() {
            return this.finderNickname;
        }

        public final void setFinderNickname(TextView textView) {
            this.finderNickname = textView;
        }

        public final ImageView getFinderThumb() {
            return this.finderThumb;
        }

        public final void setFinderThumb(ImageView imageView) {
            this.finderThumb = imageView;
        }

        public final TextView getFinderDesc() {
            return this.finderDesc;
        }

        public final void setFinderDesc(TextView textView) {
            this.finderDesc = textView;
        }

        public final TextView getFinderText() {
            return this.finderText;
        }

        public final void setFinderText(TextView textView) {
            this.finderText = textView;
        }

        public final ImageView getFinderIcon() {
            return this.finderIcon;
        }

        public final void setFinderIcon(ImageView imageView) {
            this.finderIcon = imageView;
        }

        public final ImageView getTickIV() {
            return this.tickIV;
        }

        public final void setTickIV(ImageView imageView) {
            this.tickIV = imageView;
        }

        public final FinderLiveOnliveWidget getLiveTag() {
            return this.liveTag;
        }

        public final void setLiveTag(FinderLiveOnliveWidget finderLiveOnliveWidget) {
            this.liveTag = finderLiveOnliveWidget;
        }

        public final FinderLiveOnliveWidget getLiveEndTag() {
            return this.liveEndTag;
        }

        public final void setLiveEndTag(FinderLiveOnliveWidget finderLiveOnliveWidget) {
            this.liveEndTag = finderLiveOnliveWidget;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setWidth(int i2) {
            this.width = i2;
        }

        public final View getDetailLayout() {
            return this.detailLayout;
        }

        public final void setDetailLayout(View view) {
            this.detailLayout = view;
        }

        public final AppMsgFinderLiveFeedHolder createAppMsgFinderFeedHolder(View view, boolean z) {
            AppMethodBeat.i(231350);
            p.h(view, "view");
            super.create(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auf);
            Context context = view.getContext();
            Point az = au.az(context);
            int min = Math.min(az.x, az.y);
            p.g(context, "context");
            float dimension = context.getResources().getDimension(R.dimen.c5);
            this.width = (int) ((((float) min) - dimension) / 2.0f);
            p.g(linearLayout, "clickArea");
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(231350);
                throw tVar;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = this.width;
            linearLayout.setLayoutParams(layoutParams2);
            c cVar = ChatingItemAppMsgFinderLiveFeed.PGG;
            Log.i(ChatingItemAppMsgFinderLiveFeed.TAG, "real widthPixels:" + min + " ,dp:" + dimension + " , width:" + this.width);
            this.finderAvatar = (ImageView) view.findViewById(R.id.aw4);
            this.finderNickname = (TextView) view.findViewById(R.id.aw9);
            this.finderThumb = (ImageView) view.findViewById(R.id.awc);
            this.finderDesc = (TextView) view.findViewById(R.id.aw5);
            this.finderText = (TextView) view.findViewById(R.id.awb);
            this.finderIcon = (ImageView) view.findViewById(R.id.aw6);
            this.liveEndTag = (FinderLiveOnliveWidget) view.findViewById(R.id.cpw);
            View findViewById = view.findViewById(R.id.ayn);
            if (!(findViewById instanceof TextView)) {
                findViewById = null;
            }
            TextView textView = (TextView) findViewById;
            if (textView != null) {
                this.userTV = textView;
            }
            this.detailLayout = view.findViewById(R.id.atz);
            this.liveTag = (FinderLiveOnliveWidget) view.findViewById(R.id.cra);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
                if (this.finderThumb instanceof NinePatchCropImageView) {
                    ImageView imageView = this.finderThumb;
                    if (imageView == null) {
                        kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
                        AppMethodBeat.o(231350);
                        throw tVar2;
                    }
                    ((NinePatchCropImageView) imageView).setNinePatchId(R.drawable.c4o);
                }
            } else if (this.finderThumb instanceof NinePatchCropImageView) {
                ImageView imageView2 = this.finderThumb;
                if (imageView2 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
                    AppMethodBeat.o(231350);
                    throw tVar3;
                }
                ((NinePatchCropImageView) imageView2).setNinePatchId(R.drawable.c45);
            }
            ImageView imageView3 = this.finderIcon;
            if (imageView3 != null) {
                imageView3.setImageDrawable(ar.m(imageView3.getContext(), R.raw.icons_outlined_finder_icon, com.tencent.mm.cb.a.n(imageView3.getContext(), R.color.Orange)));
            }
            AppMethodBeat.o(231350);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.detailLayout;
        }
    }
}
