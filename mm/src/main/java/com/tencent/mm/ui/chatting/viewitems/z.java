package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.ViewAnimHelper;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class z {

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 1023410225) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233740);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sr);
                view.setTag(new a().Q(view, true));
            }
            AppMethodBeat.o(233740);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            boolean z = false;
            AppMethodBeat.i(233741);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            aVar3.detailLayout.animate().cancel();
            aVar3.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                i iVar = (i) bVar.as(i.class);
                if (iVar != null) {
                    m mVar = m.uJa;
                    com.tencent.mm.loader.d<o> dka = m.dka();
                    p pVar = new p(iVar.jlh.uNR, x.THUMB_IMAGE);
                    ImageView imageView = aVar3.finderAvatar;
                    m mVar2 = m.uJa;
                    dka.a(pVar, imageView, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    aVar3.finderNickname.setText(l.c(aVar2.Pwc.getContext(), iVar.jlh.nickname));
                    ao.a(aVar3.finderNickname.getPaint(), 0.8f);
                    LinkedList<cok> linkedList = iVar.jlh.mediaList;
                    if (!linkedList.isEmpty()) {
                        if (!Util.isNullOrNil(linkedList.get(0).coverUrl)) {
                            ((aj) g.ah(aj.class)).loadImage(linkedList.get(0).coverUrl, aVar3.finderThumb);
                        } else {
                            ((aj) g.ah(aj.class)).loadImage(linkedList.get(0).thumbUrl, aVar3.finderThumb);
                        }
                        z.a(aVar3, linkedList);
                    }
                    if (!Util.isNullOrNil(iVar.jlh.desc)) {
                        aVar3.finderDesc.setText(l.c(aVar2.Pwc.getContext(), iVar.jlh.desc));
                        aVar3.finderDesc.setVisibility(0);
                    } else {
                        aVar3.finderDesc.setVisibility(8);
                    }
                    aVar3.finderThumb.setVisibility(0);
                    aVar3.finderText.setVisibility(8);
                    aVar3.PKw.setVisibility(0);
                    aVar3.EpV.setVisibility(8);
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            if (gTW()) {
                if (aVar3.uploadingPB != null) {
                    aVar3.uploadingPB.setVisibility(8);
                }
                if (caVar.field_status != 2 || !b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.field_msgId)) {
                    if (aVar3.tickIV != null) {
                        aVar3.tickIV.setVisibility(8);
                    }
                } else if (aVar3.tickIV != null) {
                    aVar3.tickIV.setVisibility(0);
                }
            } else {
                if (aVar3.tickIV != null) {
                    aVar3.tickIV.setVisibility(8);
                }
                if (caVar.field_status < 2) {
                    z = true;
                }
                b(aVar3, z);
            }
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(233741);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233742);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233742);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233743);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                com.tencent.mm.br.c.aZU("favorite");
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
            }
            AppMethodBeat.o(233743);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233744);
            switch (menuItem.getItemId()) {
                case 111:
                    z.c(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233744);
                    return true;
                default:
                    AppMethodBeat.o(233744);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            i iVar;
            AppMethodBeat.i(233745);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (iVar = (i) bVar.as(i.class)) == null)) {
                Intent intent = new Intent();
                intent.putExtra("feed_object_id", com.tencent.mm.ac.d.Ga(iVar.jlh.objectId));
                intent.putExtra("feed_object_nonceId", iVar.jlh.objectNonceId);
                intent.putExtra("business_type", 1);
                intent.putExtra("finder_user_name", iVar.jlh.username);
                if (ab.Eq(caVar.field_talker)) {
                    intent.putExtra("report_scene", 2);
                    intent.putExtra("key_finder_teen_mode_scene", 2);
                } else {
                    intent.putExtra("report_scene", 1);
                    intent.putExtra("key_finder_teen_mode_scene", 1);
                }
                intent.putExtra("key_finder_teen_mode_check", true);
                intent.putExtra("key_finder_teen_mode_user_name", iVar.jlh.nickname);
                intent.putExtra("key_finder_teen_mode_user_id", iVar.jlh.username);
                intent.putExtra("from_user", caVar.field_talker);
                y yVar = y.vXH;
                intent.putExtra("key_from_user_name", y.aw(caVar));
                y yVar2 = y.vXH;
                intent.putExtra("key_to_user_name", y.ax(caVar));
                intent.putExtra("tab_type", 6);
                z.a(view, aVar, iVar, intent, true, ab.Eq(caVar.field_talker));
            }
            AppMethodBeat.o(233745);
            return false;
        }
    }

    public static class d extends IListener<ic> {
        WeakReference<View> PKx;
        long key;

        public d() {
            AppMethodBeat.i(233746);
            this.__eventId = ic.class.getName().hashCode();
            AppMethodBeat.o(233746);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ic icVar) {
            View view;
            AppMethodBeat.i(233747);
            EventCenter.instance.removeListener(this);
            if (icVar.dMI.key == this.key && (view = this.PKx.get()) != null) {
                view.animate().cancel();
                view.setAlpha(0.0f);
                view.animate().alpha(1.0f).setStartDelay(240).setDuration(400).start();
            }
            AppMethodBeat.o(233747);
            return false;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 1023410225) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233735);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rd);
                view.setTag(new a().Q(view, false));
            }
            AppMethodBeat.o(233735);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(233736);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            aVar3.detailLayout.animate().cancel();
            aVar3.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                i iVar = (i) bVar.as(i.class);
                if (iVar != null) {
                    m mVar = m.uJa;
                    com.tencent.mm.loader.d<o> dka = m.dka();
                    p pVar = new p(iVar.jlh.uNR, x.THUMB_IMAGE);
                    ImageView imageView = aVar3.finderAvatar;
                    m mVar2 = m.uJa;
                    dka.a(pVar, imageView, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    aVar3.finderNickname.setText(l.c(aVar2.Pwc.getContext(), iVar.jlh.nickname));
                    ao.a(aVar3.finderNickname.getPaint(), 0.8f);
                    LinkedList<cok> linkedList = iVar.jlh.mediaList;
                    if (!linkedList.isEmpty()) {
                        if (!Util.isNullOrNil(linkedList.get(0).coverUrl)) {
                            ((aj) g.ah(aj.class)).loadImage(linkedList.get(0).coverUrl, aVar3.finderThumb);
                        } else {
                            ((aj) g.ah(aj.class)).loadImage(linkedList.get(0).thumbUrl, aVar3.finderThumb);
                        }
                        z.a(aVar3, linkedList);
                    }
                    if (!Util.isNullOrNil(iVar.jlh.desc)) {
                        aVar3.finderDesc.setText(l.c(aVar2.Pwc.getContext(), iVar.jlh.desc));
                        aVar3.finderDesc.setVisibility(0);
                    } else {
                        aVar3.finderDesc.setVisibility(8);
                    }
                    aVar3.finderThumb.setVisibility(0);
                    aVar3.finderText.setVisibility(8);
                    aVar3.PKw.setVisibility(0);
                    aVar3.EpV.setVisibility(8);
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(233736);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233737);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && com.tencent.mm.br.c.aZU("favorite") && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            AppMethodBeat.o(233737);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233738);
            switch (menuItem.getItemId()) {
                case 111:
                    z.c(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(233738);
                    return true;
                default:
                    AppMethodBeat.o(233738);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            i iVar;
            AppMethodBeat.i(233739);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (iVar = (i) bVar.as(i.class)) == null)) {
                Intent intent = new Intent();
                intent.putExtra("feed_object_id", com.tencent.mm.ac.d.Ga(iVar.jlh.objectId));
                intent.putExtra("feed_object_nonceId", iVar.jlh.objectNonceId);
                intent.putExtra("business_type", 1);
                intent.putExtra("finder_user_name", iVar.jlh.username);
                if (ab.Eq(caVar.field_talker)) {
                    intent.putExtra("report_scene", 2);
                    intent.putExtra("key_finder_teen_mode_scene", 2);
                } else {
                    intent.putExtra("report_scene", 1);
                    intent.putExtra("key_finder_teen_mode_scene", 1);
                }
                intent.putExtra("key_finder_teen_mode_check", true);
                intent.putExtra("key_finder_teen_mode_user_name", iVar.jlh.nickname);
                intent.putExtra("key_finder_teen_mode_user_id", iVar.jlh.username);
                intent.putExtra("from_user", caVar.field_talker);
                y yVar = y.vXH;
                intent.putExtra("key_from_user_name", y.aw(caVar));
                y yVar2 = y.vXH;
                intent.putExtra("key_to_user_name", y.ax(caVar));
                intent.putExtra("tab_type", 6);
                z.a(view, aVar, iVar, intent, false, ab.Eq(caVar.field_talker));
            }
            AppMethodBeat.o(233739);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends c.a {
        public ImageIndicatorView EpV;
        public ImageView PKw;
        public View detailLayout;
        public ImageView finderAvatar;
        public TextView finderDesc;
        public ImageView finderIcon;
        public TextView finderNickname;
        public TextView finderText;
        public ImageView finderThumb;
        public ImageView tickIV;
        public int width;

        a() {
        }

        public final a Q(View view, boolean z) {
            AppMethodBeat.i(233734);
            super.create(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auf);
            Context context = view.getContext();
            this.width = (int) ((((float) context.getResources().getDisplayMetrics().widthPixels) - context.getResources().getDimension(R.dimen.c5)) / 2.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = this.width;
            linearLayout.setLayoutParams(layoutParams);
            this.finderAvatar = (ImageView) view.findViewById(R.id.aw4);
            this.finderNickname = (TextView) view.findViewById(R.id.aw9);
            this.finderThumb = (ImageView) view.findViewById(R.id.awc);
            this.finderDesc = (TextView) view.findViewById(R.id.aw5);
            this.finderText = (TextView) view.findViewById(R.id.awb);
            this.finderIcon = (ImageView) view.findViewById(R.id.aw6);
            this.PKw = (ImageView) view.findViewById(R.id.aw8);
            this.EpV = (ImageIndicatorView) view.findViewById(R.id.aw7);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.detailLayout = view.findViewById(R.id.atz);
            if (!(!((aj) g.ah(aj.class)).showFinderEntry())) {
                this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                this.maskView = view.findViewById(R.id.ax3);
            }
            if (z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.tickIV = (ImageView) view.findViewById(R.id.ayd);
                if (this.finderThumb instanceof NinePatchCropImageView) {
                    ((NinePatchCropImageView) this.finderThumb).setNinePatchId(R.drawable.c4o);
                }
            } else if (this.finderThumb instanceof NinePatchCropImageView) {
                ((NinePatchCropImageView) this.finderThumb).setNinePatchId(R.drawable.c45);
            }
            this.finderIcon.setImageDrawable(ar.m(this.finderIcon.getContext(), R.raw.icons_outlined_finder_icon, com.tencent.mm.cb.a.n(this.finderIcon.getContext(), R.color.Orange)));
            AppMethodBeat.o(233734);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.detailLayout;
        }
    }

    static /* synthetic */ void a(a aVar, List list) {
        AppMethodBeat.i(233748);
        list.get(0);
        int i2 = aVar.width;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.finderThumb.getLayoutParams();
        layoutParams.height = i2;
        aVar.finderThumb.setLayoutParams(layoutParams);
        AppMethodBeat.o(233748);
    }

    static /* synthetic */ void c(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(233749);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", 26);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMegaVideo", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMegaVideo", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(233749);
    }

    static /* synthetic */ void a(View view, com.tencent.mm.ui.chatting.e.a aVar, i iVar, Intent intent, boolean z, boolean z2) {
        String str;
        boolean z3 = false;
        AppMethodBeat.i(233750);
        ImageView imageView = (ImageView) view.findViewById(R.id.awc);
        LinkedList<cok> linkedList = iVar.jlh.mediaList;
        Activity context = aVar.Pwc.getContext();
        if (!(imageView == null || linkedList.isEmpty() || linkedList.get(0).width == 0.0f || linkedList.get(0).height == 0.0f)) {
            intent.putExtra("key_view_info", ViewAnimHelper.q(imageView, context.getWindow().getDecorView()));
            if (Util.isNullOrNil(linkedList.get(0).coverUrl)) {
                str = linkedList.get(0).coverUrl;
            } else {
                str = linkedList.get(0).thumbUrl;
            }
            y yVar = y.vXH;
            intent.putExtra("key_image_url", str);
            intent.putExtra("key_image_height_radio", (double) y.eC(linkedList));
            intent.putExtra("key_image_height", linkedList.get(0).height);
            intent.putExtra("key_image_width", linkedList.get(0).width);
            if (z) {
                intent.putExtra("key_nine_patch_id", R.drawable.c4j);
            } else {
                intent.putExtra("key_nine_patch_id", R.drawable.c40);
            }
            if (intent.getIntExtra("business_type", 0) == 0) {
                z3 = true;
            }
            View view2 = (View) view.getParent();
            if (view2 != null && (view2.getTag() instanceof Long)) {
                Long l = (Long) view2.getTag();
                intent.putExtra("key_animate_id", l.longValue());
                d dVar = new d();
                dVar.key = l.longValue();
                dVar.PKx = new WeakReference<>(view2);
                EventCenter.instance.add(dVar);
            }
        }
        ((aj) g.ah(aj.class)).fillContextIdToIntent(z2 ? 3 : 2, 2, 25, intent);
        ((aj) g.ah(aj.class)).enterFinderShareFeedUI(aVar.Pwc.getContext(), intent);
        if (z3) {
            context.overridePendingTransition(R.anim.s, R.anim.s);
        }
        AppMethodBeat.o(233750);
    }
}
