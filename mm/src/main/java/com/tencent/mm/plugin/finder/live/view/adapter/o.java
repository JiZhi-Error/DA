package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0003./0B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010!\u001a\u00060\"R\u00020\u0001H\u0014J\u001e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0018\u00010\"R\u00020\u0001H\u0016J\"\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0002J\f\u0010,\u001a\u00060-R\u00020\u0001H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "chatMembers", "", "getChatMembers", "()Ljava/lang/CharSequence;", "setChatMembers", "(Ljava/lang/CharSequence;)V", "chatRoomViewHolder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewHolder;", "chatRoomViewItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewItem;", "content", "getContent", "setContent", "matchInfo", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "getMatchInfo", "()Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "setMatchInfo", "(Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;)V", "nickname", "getNickname", "setNickname", ch.COL_USERNAME, "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "formatText", "match", "contact", "Lcom/tencent/mm/storage/Contact;", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Companion", "FinderLiveMultiChatRoomViewHolder", "FinderLiveMultiChatRoomViewItem", "plugin-finder_release"})
public final class o extends com.tencent.mm.ui.contact.a.a {
    private static final Pattern ESG = Pattern.compile(";");
    public static final a UOQ = new a((byte) 0);
    CharSequence ESH;
    private final c UOO = new c();
    final b UOP = new b();
    CharSequence hXr;
    CharSequence jVL;
    m lqW;
    String username;

    public o(int i2) {
        super(4, i2);
        AppMethodBeat.i(260941);
        AppMethodBeat.o(260941);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tR\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "plugin-finder_release"})
    public final class c extends a.b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(260937);
            p.h(context, "context");
            p.h(viewGroup, "parent");
            View inflate = LayoutInflater.from(context).inflate(R.layout.cf9, viewGroup, false);
            b bVar = o.this.UOP;
            if (bVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveMultiChatRoomDataItem.FinderLiveMultiChatRoomViewHolder");
                AppMethodBeat.o(260937);
                throw tVar;
            }
            b bVar2 = bVar;
            View findViewById = inflate.findViewById(R.id.jyh);
            if (findViewById == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(260937);
                throw tVar2;
            }
            bVar2.gvv = (ImageView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.jyl);
            if (findViewById2 == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(260937);
                throw tVar3;
            }
            bVar2.gvw = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.jyi);
            if (findViewById3 == null) {
                t tVar4 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(260937);
                throw tVar4;
            }
            bVar2.jBR = (TextView) findViewById3;
            TextView textView = bVar2.jBR;
            if (textView == null) {
                p.hyc();
            }
            textView.setVisibility(8);
            View findViewById4 = inflate.findViewById(R.id.jyk);
            if (findViewById4 == null) {
                t tVar5 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(260937);
                throw tVar5;
            }
            bVar2.xcs = (TextView) findViewById4;
            View findViewById5 = inflate.findViewById(R.id.jyj);
            if (findViewById5 == null) {
                t tVar6 = new t("null cannot be cast to non-null type android.widget.CheckBox");
                AppMethodBeat.o(260937);
                throw tVar6;
            }
            bVar2.jVQ = (CheckBox) findViewById5;
            p.g(inflate, "convertView");
            inflate.setTag(bVar2);
            AppMethodBeat.o(260937);
            return inflate;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00da  */
        @Override // com.tencent.mm.ui.contact.a.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.content.Context r8, com.tencent.mm.ui.contact.a.a.C2110a r9, com.tencent.mm.ui.contact.a.a r10, boolean r11, boolean r12) {
            /*
            // Method dump skipped, instructions count: 235
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.adapter.o.c.a(android.content.Context, com.tencent.mm.ui.contact.a.a$a, com.tencent.mm.ui.contact.a.a, boolean, boolean):void");
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.ui.contact.a.a aVar) {
            AppMethodBeat.i(260939);
            p.h(context, "context");
            p.h(view, "v");
            p.h(aVar, "data");
            AppMethodBeat.o(260939);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$FinderLiveMultiChatRoomViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "nicknameTV", "getNicknameTV", "setNicknameTV", "selectCB", "Landroid/widget/CheckBox;", "getSelectCB", "()Landroid/widget/CheckBox;", "setSelectCB", "(Landroid/widget/CheckBox;)V", "tipTV", "getTipTV", "setTipTV", "plugin-finder_release"})
    public final class b extends a.C2110a {
        ImageView gvv;
        TextView gvw;
        TextView jBR;
        CheckBox jVQ;
        TextView xcs;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        boolean z;
        String[] strArr;
        boolean z2;
        boolean z3;
        boolean z4;
        CharSequence charSequence = null;
        AppMethodBeat.i(260940);
        p.h(context, "context");
        if (this.lqW != null) {
            if (eFa() == null) {
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
                m mVar = this.lqW;
                if (mVar == null) {
                    p.hyc();
                }
                ay(aSN.bjF(mVar.wVX));
                if (eFa() == null) {
                    com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
                    bv aSN2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN();
                    m mVar2 = this.lqW;
                    if (mVar2 == null) {
                        p.hyc();
                    }
                    ay(aSN2.bjK(mVar2.wVX));
                    z = true;
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (eFa() == null) {
            this.jVL = "";
            AppMethodBeat.o(260940);
            return;
        }
        as eFa = eFa();
        p.g(eFa, "contact");
        this.username = eFa.getUsername();
        if (z) {
            m mVar3 = this.lqW;
            as eFa2 = eFa();
            p.g(eFa2, "contact");
            Resources resources = context.getResources();
            String b2 = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(eFa2, eFa2.getUsername());
            if (mVar3 == null) {
                p.hyc();
            }
            switch (mVar3.wVW) {
                case 1:
                case 5:
                    resources.getString(R.string.gg4);
                    z2 = false;
                    z3 = false;
                    z4 = true;
                    break;
                case 2:
                case 6:
                    resources.getString(R.string.gg4);
                    z2 = false;
                    z3 = true;
                    z4 = true;
                    break;
                case 3:
                case 7:
                    resources.getString(R.string.gg4);
                    z2 = true;
                    z3 = true;
                    z4 = true;
                    break;
                case 38:
                    e aAh = g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    Cursor rawQuery = aAh.getDataDB().rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{eFa2.getUsername()}, 2);
                    if (rawQuery.moveToFirst()) {
                        String string = rawQuery.getString(0);
                        rawQuery.close();
                        strArr = string == null ? null : ESG.split(string);
                    } else {
                        rawQuery.close();
                        strArr = null;
                    }
                    if (strArr != null && strArr.length > 0) {
                        this.ESH = "(" + strArr.length + ")";
                    }
                    if (!(strArr == null || mVar3.wXl == null)) {
                        charSequence = TextUtils.concat(resources.getString(R.string.gg2), n.a(context, mVar3.wXl, strArr, hYN(), b.c.wZY));
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        break;
                    }
                default:
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    break;
            }
            if (z4) {
                this.jVL = w(context, b2, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
                this.jVL = f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.jVL, hYN(), z3, z2)).wWu;
            } else {
                this.jVL = w(context, b2, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
            }
            this.hXr = charSequence;
            AppMethodBeat.o(260940);
            return;
        }
        as eFa3 = eFa();
        as eFa4 = eFa();
        p.g(eFa4, "contact");
        this.jVL = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(eFa3, eFa4.getUsername());
        if (this.lqW != null) {
            StringBuilder sb = new StringBuilder("(");
            m mVar4 = this.lqW;
            if (mVar4 == null) {
                p.hyc();
            }
            this.ESH = sb.append(mVar4.wXe).append(")").toString();
        }
        AppMethodBeat.o(260940);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.UOO;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem$Companion;", "", "()V", "SPLIT_MEMBER_LIST", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260942);
        AppMethodBeat.o(260942);
    }
}
