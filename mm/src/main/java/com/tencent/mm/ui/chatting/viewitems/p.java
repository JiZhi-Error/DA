package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
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
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.f;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.view.NinePatchCropImageView;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class p {
    private static final Map<Long, Boolean> Vbe = new HashMap();

    static {
        AppMethodBeat.i(163351);
        AppMethodBeat.o(163351);
    }

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 754974769) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163344);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sr);
                view.setTag(new a().L(view, true));
            }
            AppMethodBeat.o(163344);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, final String str) {
            boolean z = false;
            AppMethodBeat.i(163345);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            aVar3.detailLayout.animate().cancel();
            aVar3.detailLayout.setTag(Long.valueOf(System.currentTimeMillis()));
            String str2 = caVar.field_content;
            k.b bVar = null;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            }
            if (bVar != null) {
                final f fVar = (f) bVar.as(f.class);
                if (p.Vbe.get(Long.valueOf(caVar.field_msgId)) == null) {
                    com.tencent.mm.view.f.a(aVar3.convertView, new e.b() {
                        /* class com.tencent.mm.ui.chatting.viewitems.p.c.AnonymousClass1 */

                        @Override // com.tencent.mm.view.e.b
                        public final void p(View view, boolean z) {
                            String str;
                            AppMethodBeat.i(259005);
                            if (z) {
                                String str2 = str;
                                boolean Eq = ab.Eq(caVar.field_talker);
                                if (Eq) {
                                    str = str2 + "-" + caVar.field_talker;
                                } else {
                                    str = str2;
                                }
                                am.USY.y(Eq ? 2 : 1, str, fVar.jlg.objectId);
                            }
                            AppMethodBeat.o(259005);
                        }

                        @Override // com.tencent.mm.view.e.b
                        public final long hE(View view) {
                            AppMethodBeat.i(259006);
                            long hashCode = caVar.field_msgId + ((long) view.hashCode());
                            AppMethodBeat.o(259006);
                            return hashCode;
                        }
                    });
                    p.Vbe.put(Long.valueOf(caVar.field_msgId), Boolean.TRUE);
                }
                if (fVar != null) {
                    m mVar = m.uJa;
                    com.tencent.mm.loader.d<o> dka = m.dka();
                    com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(fVar.jlg.uNR, x.THUMB_IMAGE);
                    ImageView imageView = aVar3.finderAvatar;
                    m mVar2 = m.uJa;
                    dka.a(pVar, imageView, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    aVar3.finderNickname.setText(l.c(aVar2.Pwc.getContext(), fVar.jlg.nickname));
                    ao.a(aVar3.finderNickname.getPaint(), 0.8f);
                    LinkedList<bch> linkedList = fVar.jlg.mediaList;
                    if (!linkedList.isEmpty()) {
                        ((aj) g.ah(aj.class)).loadImage(linkedList.get(0).thumbUrl, aVar3.finderThumb);
                        p.a(aVar3, linkedList);
                    }
                    if (fVar.jlg.vXJ == 1) {
                        aVar3.finderDesc.setVisibility(8);
                        aVar3.finderThumb.setVisibility(8);
                        aVar3.finderText.setText(l.c(aVar2.Pwc.getContext(), fVar.jlg.desc));
                        aVar3.finderText.setVisibility(0);
                    } else {
                        if (!Util.isNullOrNil(fVar.jlg.desc)) {
                            aVar3.finderDesc.setText(l.c(aVar2.Pwc.getContext(), fVar.jlg.desc));
                            aVar3.finderDesc.setVisibility(0);
                        } else {
                            aVar3.finderDesc.setVisibility(8);
                        }
                        aVar3.finderThumb.setVisibility(0);
                        aVar3.finderText.setVisibility(8);
                        if (fVar.jlg.vXJ == 4 || fVar.jlg.vXJ == 6) {
                            aVar3.PKw.setVisibility(0);
                            aVar3.EpV.setVisibility(8);
                        } else if (fVar.jlg.vXJ == 2) {
                            aVar3.PKw.setVisibility(8);
                            aVar3.EpV.setVisibility(0);
                            aVar3.EpV.FdA = linkedList.size();
                        } else {
                            aVar3.PKw.setVisibility(8);
                        }
                    }
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
            AppMethodBeat.o(163345);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233667);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233667);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233668);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
            }
            AppMethodBeat.o(233668);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163348);
            switch (menuItem.getItemId()) {
                case 111:
                    p.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(163348);
                    return true;
                default:
                    AppMethodBeat.o(163348);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            f fVar;
            AppMethodBeat.i(163349);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (fVar = (f) bVar.as(f.class)) == null)) {
                Intent intent = new Intent();
                intent.putExtra("feed_object_id", com.tencent.mm.ac.d.Ga(fVar.jlg.objectId));
                intent.putExtra("feed_object_nonceId", fVar.jlg.objectNonceId);
                intent.putExtra("business_type", 0);
                intent.putExtra("finder_user_name", fVar.jlg.username);
                if (ab.Eq(caVar.field_talker)) {
                    intent.putExtra("report_scene", 2);
                } else {
                    intent.putExtra("report_scene", 1);
                }
                intent.putExtra("from_user", caVar.field_talker);
                y yVar = y.vXH;
                intent.putExtra("key_from_user_name", y.aw(caVar));
                y yVar2 = y.vXH;
                intent.putExtra("key_to_user_name", y.ax(caVar));
                intent.putExtra("tab_type", 6);
                p.a(view, aVar, fVar, intent, true, ab.Eq(caVar.field_talker));
            }
            AppMethodBeat.o(163349);
            return false;
        }
    }

    public static class d extends IListener<ic> {
        WeakReference<View> PKx;
        long key;

        public d() {
            AppMethodBeat.i(233669);
            this.__eventId = ic.class.getName().hashCode();
            AppMethodBeat.o(233669);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ic icVar) {
            View view;
            AppMethodBeat.i(233670);
            EventCenter.instance.removeListener(this);
            if (icVar.dMI.key == this.key && (view = this.PKx.get()) != null) {
                view.animate().cancel();
                view.setAlpha(0.0f);
                view.animate().alpha(1.0f).setStartDelay(240).setDuration(400).start();
            }
            AppMethodBeat.o(233670);
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
            if (z || i2 != 754974769) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(163339);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rd);
                view.setTag(new a().L(view, false));
            }
            AppMethodBeat.o(163339);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, final String str) {
            k.b bVar;
            AppMethodBeat.i(163340);
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
                final f fVar = (f) bVar.as(f.class);
                if (fVar != null) {
                    if (p.Vbe.get(Long.valueOf(caVar.field_msgId)) == null) {
                        com.tencent.mm.view.f.a(aVar3.convertView, new e.b() {
                            /* class com.tencent.mm.ui.chatting.viewitems.p.b.AnonymousClass1 */

                            @Override // com.tencent.mm.view.e.b
                            public final void p(View view, boolean z) {
                                String str;
                                AppMethodBeat.i(259003);
                                if (z) {
                                    String str2 = str;
                                    boolean Eq = ab.Eq(caVar.field_talker);
                                    if (Eq) {
                                        str = str2 + "-" + caVar.field_talker;
                                    } else {
                                        str = str2;
                                    }
                                    am.USY.y(Eq ? 2 : 1, str, fVar.jlg.objectId);
                                }
                                AppMethodBeat.o(259003);
                            }

                            @Override // com.tencent.mm.view.e.b
                            public final long hE(View view) {
                                AppMethodBeat.i(259004);
                                long hashCode = caVar.field_msgId + ((long) view.hashCode());
                                AppMethodBeat.o(259004);
                                return hashCode;
                            }
                        });
                        p.Vbe.put(Long.valueOf(caVar.field_msgId), Boolean.TRUE);
                    }
                    m mVar = m.uJa;
                    com.tencent.mm.loader.d<o> dka = m.dka();
                    com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(fVar.jlg.uNR, x.THUMB_IMAGE);
                    ImageView imageView = aVar3.finderAvatar;
                    m mVar2 = m.uJa;
                    dka.a(pVar, imageView, m.a(m.a.AVATAR_WITHOUT_DEFAULT));
                    aVar3.finderNickname.setText(l.c(aVar2.Pwc.getContext(), fVar.jlg.nickname));
                    ao.a(aVar3.finderNickname.getPaint(), 0.8f);
                    LinkedList<bch> linkedList = fVar.jlg.mediaList;
                    if (!linkedList.isEmpty()) {
                        ((aj) g.ah(aj.class)).loadImage(linkedList.get(0).thumbUrl, aVar3.finderThumb);
                        p.a(aVar3, linkedList);
                    }
                    if (fVar.jlg.vXJ == 1) {
                        aVar3.finderDesc.setVisibility(8);
                        aVar3.finderThumb.setVisibility(8);
                        aVar3.finderText.setText(l.c(aVar2.Pwc.getContext(), fVar.jlg.desc));
                        aVar3.finderText.setVisibility(0);
                    } else {
                        if (!Util.isNullOrNil(fVar.jlg.desc)) {
                            aVar3.finderDesc.setText(l.c(aVar2.Pwc.getContext(), fVar.jlg.desc));
                            aVar3.finderDesc.setVisibility(0);
                        } else {
                            aVar3.finderDesc.setVisibility(8);
                        }
                        aVar3.finderThumb.setVisibility(0);
                        aVar3.finderText.setVisibility(8);
                        if (fVar.jlg.vXJ == 4 || fVar.jlg.vXJ == 6) {
                            aVar3.PKw.setVisibility(0);
                            aVar3.EpV.setVisibility(8);
                        } else if (fVar.jlg.vXJ == 2) {
                            aVar3.PKw.setVisibility(8);
                            aVar3.EpV.setVisibility(0);
                            aVar3.EpV.FdA = linkedList.size();
                        } else {
                            aVar3.PKw.setVisibility(8);
                        }
                    }
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(163340);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            AppMethodBeat.i(233666);
            int i2 = ((bq) view.getTag()).position;
            boolean z = !((aj) g.ah(aj.class)).showFinderEntry();
            if (caVar != null && com.tencent.mm.br.c.aZU("favorite") && !z) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                mVar.a(i2, 116, this.PhN.Pwc.getMMResources().getString(R.string.fn9), R.raw.icons_filled_favorites);
            }
            AppMethodBeat.o(233666);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(163342);
            switch (menuItem.getItemId()) {
                case 111:
                    if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(aVar.Pwc.getContext())) {
                        AppMethodBeat.o(163342);
                        return true;
                    }
                    p.b(aVar.Pwc.getContext(), caVar);
                    AppMethodBeat.o(163342);
                    return true;
                default:
                    AppMethodBeat.o(163342);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            f fVar;
            AppMethodBeat.i(163343);
            if (!WeChatBrands.Business.Entries.SessionChannels.checkAvailable(view.getContext())) {
                AppMethodBeat.o(163343);
                return true;
            }
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (!(bVar == null || (fVar = (f) bVar.as(f.class)) == null)) {
                Intent intent = new Intent();
                intent.putExtra("feed_object_id", com.tencent.mm.ac.d.Ga(fVar.jlg.objectId));
                intent.putExtra("feed_object_nonceId", fVar.jlg.objectNonceId);
                intent.putExtra("business_type", 0);
                intent.putExtra("finder_user_name", fVar.jlg.username);
                if (ab.Eq(caVar.field_talker)) {
                    intent.putExtra("report_scene", 2);
                } else {
                    intent.putExtra("report_scene", 1);
                }
                intent.putExtra("from_user", caVar.field_talker);
                y yVar = y.vXH;
                intent.putExtra("key_from_user_name", y.aw(caVar));
                y yVar2 = y.vXH;
                intent.putExtra("key_to_user_name", y.ax(caVar));
                intent.putExtra("tab_type", 6);
                p.a(view, aVar, fVar, intent, false, ab.Eq(caVar.field_talker));
            }
            AppMethodBeat.o(163343);
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

        public final a L(View view, boolean z) {
            AppMethodBeat.i(163338);
            super.create(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auf);
            Context context = view.getContext();
            Point az = au.az(context);
            int min = Math.min(az.x, az.y);
            float dimension = context.getResources().getDimension(R.dimen.c5);
            this.width = (int) ((((float) min) - dimension) / 2.0f);
            Log.i("ChattingItemAppMsgFinderFeed", "real widthPixels:" + min + " ,dp:" + dimension + " , width:" + this.width);
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
            AppMethodBeat.o(163338);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.detailLayout;
        }
    }

    static /* synthetic */ void a(a aVar, List list) {
        AppMethodBeat.i(259007);
        list.get(0);
        int i2 = aVar.width;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.finderThumb.getLayoutParams();
        layoutParams.height = i2;
        aVar.finderThumb.setLayoutParams(layoutParams);
        AppMethodBeat.o(259007);
    }

    static /* synthetic */ void b(Activity activity, ca caVar) {
        k.b HD;
        AppMethodBeat.i(259008);
        if (!Util.isNullOrNil(caVar.field_content) && (HD = k.b.HD(caVar.field_content)) != null) {
            Intent intent = new Intent(activity, MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_Type", 18);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(HD, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderFeed", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderFeed", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(259008);
    }

    static /* synthetic */ void a(View view, com.tencent.mm.ui.chatting.e.a aVar, f fVar, Intent intent, boolean z, boolean z2) {
        AppMethodBeat.i(259009);
        ImageView imageView = (ImageView) view.findViewById(R.id.awc);
        LinkedList<bch> linkedList = fVar.jlg.mediaList;
        boolean z3 = false;
        Activity context = aVar.Pwc.getContext();
        y yVar = y.vXH;
        double eB = (double) y.eB(linkedList);
        if (imageView != null && !linkedList.isEmpty()) {
            intent.putExtra("key_view_info", ViewAnimHelper.q(imageView, context.getWindow().getDecorView()));
            intent.putExtra("key_image_url", linkedList.get(0).thumbUrl);
            intent.putExtra("key_image_height_radio", eB);
            intent.putExtra("key_image_height", linkedList.get(0).height);
            intent.putExtra("key_image_width", linkedList.get(0).width);
            if (z) {
                intent.putExtra("key_nine_patch_id", R.drawable.c4j);
            } else {
                intent.putExtra("key_nine_patch_id", R.drawable.c40);
            }
            if (intent.getIntExtra("business_type", 0) == 0) {
                z3 = true;
            } else {
                z3 = false;
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
        if (z2) {
            intent.putExtra("key_finder_teen_mode_scene", 2);
        } else {
            intent.putExtra("key_finder_teen_mode_scene", 1);
        }
        intent.putExtra("key_finder_teen_mode_check", true);
        intent.putExtra("key_finder_teen_mode_user_name", fVar.jlg.nickname);
        intent.putExtra("key_finder_teen_mode_user_id", fVar.jlg.username);
        ((aj) g.ah(aj.class)).fillContextIdToIntent(z2 ? 3 : 2, 2, 25, intent);
        ((aj) g.ah(aj.class)).enterFinderShareFeedUI(aVar.Pwc.getContext(), intent);
        if (z3) {
            context.overridePendingTransition(R.anim.s, R.anim.s);
        }
        AppMethodBeat.o(259009);
    }
}
