package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001@B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020-H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u00104\u001a\u00020&J\u0010\u00105\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0012H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u00106\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020-H\u0002J\u0018\u0010:\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u000208H\u0002J\u0018\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u000208H\u0002J\u0018\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010=\u001a\u00020\u0001H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020-H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u00000\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u00000\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgAvatar", "Landroid/widget/ImageView;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "txtNickname", "Landroid/widget/TextView;", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "viewClose", "viewHead", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "checkIllegal", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "clickCard", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "refreshClose", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "refreshCommonSlot", "refreshHead", "registerCard", "cardTmpl", "setVideoStatus", "status", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class t extends ad {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private View puO;
    private LinearLayout puP;
    private LinkedList<a> puQ = new LinkedList<>();
    private final i<a> puR = new i<>(new h(this));
    private View pvb;
    private ImageView pvc;
    private TextView pvd;
    private View pve;
    private WeImageView pvf;
    private g pvg = new g(this.context, this.psQ);
    private d pvh = new d(this.context, this.psQ);
    private boolean pvi;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<pj, Boolean> {
        public static final b pvo = new b();

        static {
            AppMethodBeat.i(195360);
            AppMethodBeat.o(195360);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(pj pjVar) {
            boolean z;
            AppMethodBeat.i(195359);
            pj pjVar2 = pjVar;
            p.h(pjVar2, "info");
            if (Util.isNullOrNil(pjVar2.UserName)) {
                z = false;
            } else if (Util.isNullOrNil(pjVar2.KWy)) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195359);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "userName", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<String, Boolean> {
        public static final c pvp = new c();

        static {
            AppMethodBeat.i(195362);
            AppMethodBeat.o(195362);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(String str) {
            boolean z;
            AppMethodBeat.i(195361);
            String str2 = str;
            p.h(str2, "userName");
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str2);
            if (Kn == null || !Kn.arv()) {
                if (Kn == null || Kn.arH() <= 0) {
                    ay.a.aVo().a(str2, "", null);
                }
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195361);
            return valueOf;
        }
    }

    public t(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
        p.h(bVar, "adapter");
        p.h(context2, "context");
        AppMethodBeat.i(195372);
        this.psQ = bVar;
        this.context = context2;
        AppMethodBeat.o(195372);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fb  */
    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.storage.z r20, int r21, android.view.View r22, android.view.View r23) {
        /*
        // Method dump skipped, instructions count: 1456
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.item.t.a(com.tencent.mm.storage.z, int, android.view.View, android.view.View):void");
    }

    public final void hide() {
        AppMethodBeat.i(195369);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195369);
            return;
        }
        AppMethodBeat.o(195369);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class f implements View.OnClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ t pvj;

        f(t tVar, z zVar) {
            this.pvj = tVar;
            this.prL = zVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195365);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            String str = this.prL.field_talker;
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.prL.field_talker);
            if (Kn == null || Kn.arv()) {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                intent.putExtra("KOpenArticleSceneFromScene", 90);
                intent.putExtra("specific_chat_from_scene", 2);
                intent.putExtra("preChatTYPE", 11);
                com.tencent.mm.br.c.f(this.pvj.context, ".ui.chatting.ChattingUI", intent);
                com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
                com.tencent.mm.plugin.brandservice.b.c.t(3, str, "");
            } else {
                t tVar = this.pvj;
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Scene", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
                intent2.putExtra("force_get_contact", true);
                intent2.putExtra("key_use_new_contact_profile", true);
                com.tencent.mm.br.c.b(tVar.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                ege gAD = this.prL.gAD();
                tVar.psQ.pqZ.a(str, 0, 0, 13, gAD.MOC, "", 0, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, 0, gAD.style, "");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195365);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class g implements View.OnLongClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ t pvj;
        final /* synthetic */ pj pvl;

        g(t tVar, z zVar, pj pjVar) {
            this.pvj = tVar;
            this.prL = zVar;
            this.pvl = pjVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(195366);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            this.pvj.psQ.pqY = this.prL;
            ege gAD = this.prL.gAD();
            if (gAD != null) {
                pi piVar = this.pvl.KWy.get(0);
                int i2 = 0;
                long j2 = 0;
                try {
                    Uri parse = Uri.parse(piVar.KSj);
                    i2 = Util.getInt(parse.getQueryParameter("idx"), 0);
                    j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                } catch (Exception e2) {
                }
                this.pvj.psQ.pqZ.a(this.pvl.UserName, j2, i2, 15, gAD.MOC, "", 0, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, piVar.KWv, gAD.style, "");
            }
            this.pvj.psQ.cmn();
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshHead$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(195366);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ z prL;
        final /* synthetic */ t pvj;
        final /* synthetic */ pj pvl;
        final /* synthetic */ int pvq;

        e(t tVar, z zVar, pj pjVar, int i2) {
            this.pvj = tVar;
            this.prL = zVar;
            this.pvl = pjVar;
            this.pvq = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195364);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ege gAD = this.prL.gAD();
            pi piVar = this.pvl.KWy.get(0);
            String str = piVar.KSj;
            int i2 = 0;
            long j2 = 0;
            if (!Util.isNullOrNil(str)) {
                try {
                    Uri parse = Uri.parse(str);
                    i2 = Util.getInt(parse.getQueryParameter("idx"), 0);
                    j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                } catch (Exception e2) {
                }
            }
            this.pvj.psQ.pqZ.a(this.pvl.UserName, j2, i2, 16, gAD.MOC, "", 0, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, piVar.KWv, gAD.style, piVar.KWw);
            ((e) new e(this.pvj.context, this.prL, this.pvj.psQ, this.pvl, this.pvq).hw(this.pvj.pvf)).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$refreshClose$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195364);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ\u0016\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eJ&\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "onAppMsgClick", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "appMsgBizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "convertView", "order", "", "refreshUI", "bizInfo", "pos", "realIndex", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
    public final class a extends ah {
        final Context context;
        final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
        final v ptH = new v();
        final View puS = View.inflate(this.context, R.layout.k_, null);
        final /* synthetic */ t pvj;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "margin", "", "invoke"})
        public static final class c extends q implements m<View, Integer, x> {
            public static final c pvm = new c();

            static {
                AppMethodBeat.i(195354);
                AppMethodBeat.o(195354);
            }

            c() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(View view, Integer num) {
                AppMethodBeat.i(195353);
                View view2 = view;
                int intValue = num.intValue();
                p.h(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(195353);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = intValue;
                view2.setLayoutParams(layoutParams2);
                x xVar = x.SXb;
                AppMethodBeat.o(195353);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "invoke"})
        public static final class d extends q implements s<View, Integer, Integer, Integer, Integer, x> {
            public static final d pvn = new d();

            static {
                AppMethodBeat.i(195356);
                AppMethodBeat.o(195356);
            }

            d() {
                super(5);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.s
            public final /* synthetic */ x a(View view, Integer num, Integer num2, Integer num3, Integer num4) {
                AppMethodBeat.i(195355);
                View view2 = view;
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                int intValue3 = num3.intValue();
                int intValue4 = num4.intValue();
                p.h(view2, "view");
                view2.setPadding(intValue, intValue2, intValue3, intValue4);
                x xVar = x.SXb;
                AppMethodBeat.o(195355);
                return xVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(t tVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
            super(bVar, context2);
            p.h(bVar, "adapter");
            p.h(context2, "context");
            this.pvj = tVar;
            AppMethodBeat.i(195358);
            this.psQ = bVar;
            this.context = context2;
            this.jBI = this.puS.findViewById(R.id.it2);
            this.pxo = this.puS.findViewById(R.id.bf0);
            View findViewById = this.puS.findViewById(R.id.iqr);
            if (findViewById == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                AppMethodBeat.o(195358);
                throw tVar2;
            }
            this.pxp = (MMNeat7extView) findViewById;
            this.pxq = (TextView) this.puS.findViewById(R.id.ied);
            this.pxr = this.puS.findViewById(R.id.bgx);
            this.ptE = (ImageView) this.puS.findViewById(R.id.bh7);
            this.pxs = this.puS.findViewById(R.id.a7p);
            this.pxt = (ImageView) this.puS.findViewById(R.id.a97);
            this.pxu = (ImageView) this.puS.findViewById(R.id.gcf);
            this.ptX = this.puS.findViewById(R.id.i4r);
            View findViewById2 = this.puS.findViewById(R.id.daz);
            if (findViewById2 == null) {
                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(195358);
                throw tVar3;
            }
            this.ptY = (TextView) findViewById2;
            this.pxv = this.puS.findViewById(R.id.gbl);
            this.pxw = this.puS.findViewById(R.id.gbk);
            this.puD = (TextView) this.puS.findViewById(R.id.gbt);
            AppMethodBeat.o(195358);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.t$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0879a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP = 1;
            final /* synthetic */ pi ptK;
            final /* synthetic */ a pvk;
            final /* synthetic */ pj pvl;

            View$OnClickListenerC0879a(a aVar, z zVar, pj pjVar, pi piVar) {
                this.pvk = aVar;
                this.prL = zVar;
                this.pvl = pjVar;
                this.ptK = piVar;
            }

            public final void onClick(View view) {
                long j2;
                AppMethodBeat.i(195351);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = this.pvk;
                z zVar = this.prL;
                pj pjVar = this.pvl;
                pi piVar = this.ptK;
                int i2 = this.prP;
                p.h(zVar, "info");
                p.h(pjVar, "appMsgBizInfo");
                if (!(piVar == null || zVar.gAC() == null)) {
                    efz gAC = zVar.gAC();
                    if (gAC == null) {
                        p.hyc();
                    }
                    if (gAC.NfT != null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1149, 4, 1, false);
                        Log.i("MicroMsg.BizTimeLineItem", "onClick jump to url:%s", piVar.KSj);
                        Intent intent = new Intent();
                        String d2 = com.tencent.mm.ag.m.d(piVar.KSj, 169, 10000, 0);
                        intent.putExtra("rawUrl", d2);
                        intent.putExtra("geta8key_scene", 56);
                        intent.putExtra("geta8key_username", pjVar.UserName);
                        intent.putExtra("srcUsername", pjVar.UserName);
                        intent.putExtra("srcDisplayname", pjVar.oUJ);
                        intent.putExtra("prePublishId", "rec_card");
                        intent.putExtra("KPublisherId", "rec_card");
                        if (piVar.iAb == 5) {
                            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                            p.g(af, "MMKernel.service(IBrandService::class.java)");
                            if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
                                intent.putExtra(e.b.OyQ, 169);
                                intent.putExtra(e.b.OyR, 10000);
                                intent.putExtra("biz_video_session_id", ab.getSessionId());
                                com.tencent.mm.ag.x xVar = new com.tencent.mm.ag.x();
                                xVar.iAh = intent.getStringExtra("KPublisherId");
                                xVar.dHc = pjVar.UserName;
                                xVar.iAg = pjVar.oUJ;
                                xVar.iAi.url = d2;
                                xVar.iAi.title = piVar.Title;
                                xVar.iAi.iAq = piVar.KSh;
                                xVar.iAi.iAo = piVar.KSl;
                                xVar.iAi.type = piVar.iAb;
                                xVar.iAi.time = (long) piVar.CreateTime;
                                xVar.iAi.iAs = piVar.KSx;
                                xVar.iAi.videoWidth = piVar.KSv;
                                xVar.iAi.videoHeight = piVar.KSw;
                                xVar.iAi.vid = piVar.KSu;
                                xVar.t(intent);
                                Log.i("MicroMsg.BizTimeLineItem", "jump to native video");
                                int[] iArr = new int[2];
                                if (view != null) {
                                    int width = view.getWidth();
                                    int height = view.getHeight();
                                    view.getLocationInWindow(iArr);
                                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                                }
                                intent.addFlags(268435456);
                            }
                        }
                        aVar.pvj.a(zVar, "PAUSE_FOR_RESUME");
                        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.context, d2, piVar.iAb, 169, 10000, intent)) {
                            com.tencent.mm.br.c.b(aVar.context, "webview", ".ui.tools.WebViewUI", intent);
                        } else {
                            Log.i("MicroMsg.BizTimeLineItem", "jump to TmplWebview");
                        }
                        ege gAD = zVar.gAD();
                        if (gAD != null) {
                            int i3 = 0;
                            try {
                                Uri parse = Uri.parse(d2);
                                i3 = Util.getInt(parse.getQueryParameter("idx"), 0);
                                j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                            } catch (Exception e2) {
                                j2 = 0;
                            }
                            com.tencent.mm.plugin.brandservice.ui.timeline.f.a(gAD);
                            aVar.psQ.pqZ.a(pjVar.UserName, j2, i3, 15, gAD.MOC, "", i2, gAD.Nga.KUo, gAD.event, gAD.Nga.KUk, piVar.KWv, gAD.style, piVar.KWw);
                        }
                        aVar.psQ.b(zVar, i2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(195351);
                    }
                }
                Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195351);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            final /* synthetic */ z prL;
            final /* synthetic */ int puX = 1;
            final /* synthetic */ a pvk;

            /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/storage/z;I)V */
            b(a aVar, z zVar) {
                this.pvk = aVar;
                this.prL = zVar;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(195352);
                this.pvk.a(this.pvk.ptH, true);
                this.pvk.pxE.prc.m(this.prL.field_msgId, this.puX);
                AppMethodBeat.o(195352);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class e implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ pi ptK;
            final /* synthetic */ a pvk;

            e(a aVar, z zVar, pi piVar) {
                this.pvk = aVar;
                this.prL = zVar;
                this.ptK = piVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195357);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((com.tencent.mm.plugin.brandservice.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(this.pvk.pxt);
                if (this.prL.gAD() != null) {
                    try {
                        Uri parse = Uri.parse(this.ptK.KSj);
                        Util.getInt(parse.getQueryParameter("idx"), 0);
                        Util.getLong(parse.getQueryParameter("mid"), 0);
                    } catch (Exception e2) {
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195357);
            }
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, ad adVar) {
        AppMethodBeat.i(195370);
        p.h(zVar, "info");
        p.h(adVar, "cardTmpl");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, adVar);
        AppMethodBeat.o(195370);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final boolean cmS() {
        return this.pvi;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final View getVideoView() {
        return this.pvg.puc;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void setVideoStatus(int i2) {
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, String str) {
        AppMethodBeat.i(195371);
        p.h(zVar, "info");
        p.h(str, "extra");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, str);
        AppMethodBeat.o(195371);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontentUnfollow;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ t pvj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(t tVar) {
            super(0);
            this.pvj = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(195367);
            a aVar = new a(this.pvj, this.pvj.psQ, this.pvj.context);
            AppMethodBeat.o(195367);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ z prL;
        final /* synthetic */ t pvj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(t tVar, z zVar) {
            super(0);
            this.pvj = tVar;
            this.prL = zVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195363);
            this.pvj.a(this.prL, "");
            x xVar = x.SXb;
            AppMethodBeat.o(195363);
            return xVar;
        }
    }
}
