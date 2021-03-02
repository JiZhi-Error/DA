package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ca.a;
import com.tencent.mm.emoji.b.b.ad;
import com.tencent.mm.g.a.Cdo;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.q;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class aq {

    public static class b extends c implements t.n {
        protected d PND;
        private c PNE;
        protected t.m PNF;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 47) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37285);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ta);
                view.setTag(new e().G(view, false));
            }
            AppMethodBeat.o(37285);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37286);
            this.PhN = aVar2;
            e eVar = (e) aVar;
            EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(caVar.field_imgPath);
            if (aml != null) {
                be bkr = be.bkr(caVar.field_content);
                aml.talker = caVar.field_talker;
                eVar.PKh.a(aml, caVar.field_msgId, bkr);
                if (eVar.PNH != null) {
                    if (bkr.Opg) {
                        eVar.PNH.setVisibility(0);
                        TextView textView = (TextView) eVar.convertView.findViewById(R.id.axz).findViewById(R.id.auz);
                        textView.setText(Html.fromHtml(aVar2.Pwc.getMMResources().getString(R.string.bru)));
                        ImageView imageView = (ImageView) eVar.convertView.findViewById(R.id.axz).findViewById(R.id.auy);
                        textView.setTag(new bq(caVar, false, i2, aVar2.gRI(), false, "", "", "", "", aml.field_groupId, "", true, false));
                        textView.setOnClickListener(i(aVar2));
                        if (((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFH()) {
                            imageView.setVisibility(0);
                            imageView.setTag(new bq(caVar, aVar2.gRM(), i2, aVar2.gRI(), (char) 0));
                            if (this.PNF == null) {
                                this.PNF = new t.m(aVar2);
                            }
                            imageView.setOnClickListener(this.PNF);
                        } else {
                            imageView.setVisibility(8);
                        }
                    } else {
                        eVar.PNH.setVisibility(8);
                    }
                }
                if (aml.NA() && !bkr.jsi) {
                    bkr.jsi = true;
                    caVar.setContent(bkr.bie());
                    bg.aVF();
                    caVar.setStatus(com.tencent.mm.model.c.aSQ().Hb(caVar.field_msgId).field_status);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().aE(caVar);
                }
                if (gTW()) {
                    b((c.a) eVar, false);
                    if (caVar.field_status != 2 || !b((k) aVar2.bh(k.class), caVar.field_msgId)) {
                        if (eVar.PIn != null) {
                            eVar.PIn.setVisibility(8);
                        }
                    } else if (eVar.PIn != null) {
                        eVar.PIn.setVisibility(0);
                    }
                } else {
                    if (eVar.PIn != null) {
                        eVar.PIn.setVisibility(8);
                    }
                    b(eVar, caVar.field_status < 2);
                }
                if (com.tencent.mm.plugin.emoji.h.b.z(aml)) {
                    eVar.PNI.setVisibility(0);
                    View view = eVar.PNI;
                    if (this.PNE == null) {
                        this.PNE = new c(this.PhN);
                    }
                    view.setOnClickListener(this.PNE);
                } else {
                    eVar.PNI.setVisibility(8);
                }
            }
            String str2 = "";
            if (aml == null || !aml.NA()) {
                if (aml != null) {
                    str2 = Util.nullAs(((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(aml.getMd5()), "");
                }
            } else if (aml.field_name.startsWith("jsb_j")) {
                str2 = this.PhN.Pwc.getContext().getString(R.string.bsm);
            } else if (aml.field_name.startsWith("jsb_s")) {
                str2 = this.PhN.Pwc.getContext().getString(R.string.bsn);
            } else if (aml.field_name.startsWith("jsb_b")) {
                str2 = this.PhN.Pwc.getContext().getString(R.string.bsl);
            } else if (aml.field_name.startsWith("dice")) {
                str2 = aml.field_name.replace("dice_", "").replace(".png", "");
            }
            eVar.PKh.setContentDescription(this.PhN.Pwc.getContext().getString(R.string.bvt) + str2);
            eVar.PKh.setTag(new bq(caVar, aVar2.gRM(), i2, aVar2.gRI(), (char) 0));
            RTChattingEmojiView rTChattingEmojiView = eVar.PKh;
            if (this.PND == null) {
                this.PND = new d(aVar2);
            }
            rTChattingEmojiView.setOnClickListener(this.PND);
            eVar.PKh.setOnLongClickListener(c(aVar2));
            eVar.PKh.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            a(i2, eVar, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(37286);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233905);
            if (caVar.gDn()) {
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    int i2 = ((bq) view.getTag()).position;
                    EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(caVar.field_imgPath);
                    if (aml == null) {
                        Log.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", caVar.field_imgPath);
                        AppMethodBeat.o(233905);
                        return true;
                    }
                    boolean hYi = aml.hYi();
                    if (aml.field_catalog != EmojiInfo.VkW && !aml.hYm() && !aml.hYn()) {
                        if (hYi) {
                            mVar.a(i2, 104, view.getContext().getString(R.string.b0j), R.raw.icons_filled_addsticker);
                        } else {
                            Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    if (!aml.hYm()) {
                        if (hYi) {
                            mVar.a(i2, 113, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                        } else {
                            Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                    }
                    com.tencent.mm.search.c.b bVar = com.tencent.mm.search.c.b.NJx;
                    com.tencent.mm.search.c.b.c(aml, this.PhN.getTalkerUserName());
                    boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_similar_emoji, true);
                    if (!aml.NA() && (view.getContext() instanceof Activity) && view.getContext().getResources().getConfiguration().orientation == 1 && a2) {
                        Log.i("MicroMsg.emoji.ChattingItemEmojiTo", "menu add similar emoji item.");
                        mVar.a(i2, 115, view.getContext().getString(R.string.b0m), R.raw.icons_filled_othersticker);
                    }
                    if (((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
                        mVar.a(i2, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, view.getContext().getString(R.string.b09), R.raw.icons_filled_makesticker);
                    }
                    if (com.tencent.mm.plugin.emoji.h.b.ani(aml.field_groupId) && !aml.NA() && !aml.hYn()) {
                        mVar.a(i2, 128, view.getContext().getString(R.string.b0l), R.raw.icons_filled_sticker_album);
                    }
                    if (!caVar.gAt() && caVar.gDn() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                        mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    }
                    if (!this.PhN.gRN()) {
                        mVar.a(i2, 100, view.getContext().getString(R.string.b04), R.raw.icons_filled_delete);
                    }
                    if (caVar.field_status == 5) {
                        mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                    }
                    h.INSTANCE.a(12789, 0, aml.getMd5(), 0, aml.field_designerID, aml.field_groupId, "", "", "", "", "", aml.field_activityid);
                }
            }
            AppMethodBeat.o(233905);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37288);
            boolean a2 = ((q) aVar.bh(q.class)).a(menuItem, aVar, caVar);
            AppMethodBeat.o(37288);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233906);
            caVar.unsetOmittedFailResend();
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            ((q) aVar.bh(q.class)).ca(caVar);
            AppMethodBeat.o(233906);
        }
    }

    public static class a extends c {
        protected d PND;
        private c PNE;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 47) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37280);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.f3123rx);
                view.setTag(new e().G(view, true));
            }
            AppMethodBeat.o(37280);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            boolean z;
            AppMethodBeat.i(37281);
            if (caVar == null) {
                Log.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", str);
                AppMethodBeat.o(37281);
                return;
            }
            this.PhN = aVar2;
            EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(caVar.field_imgPath);
            e eVar = (e) aVar;
            if (aml == null) {
                Object[] objArr = new Object[3];
                objArr[0] = caVar.field_imgPath;
                if (aml == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = Long.valueOf(caVar.field_msgId);
                Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: db emoji %s, %s, msgId %s", objArr);
            }
            if (aml != null) {
                aml.talker = caVar.field_talker;
                be bkr = be.bkr(caVar.field_content);
                eVar.PKh.a(aml, caVar.field_msgId, bkr);
                if (aml.NA() && !bkr.jsi) {
                    bg.aVF();
                    ca Hb = com.tencent.mm.model.c.aSQ().Hb(caVar.field_msgId);
                    bkr.jsi = true;
                    caVar.setContent(bkr.bie());
                    if (Hb.getType() != 10000) {
                        bg.aVF();
                        com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                    } else {
                        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "filling: emoji revoked!");
                    }
                }
                if (com.tencent.mm.plugin.emoji.h.b.z(aml)) {
                    eVar.PNI.setVisibility(0);
                    View view = eVar.PNI;
                    if (this.PNE == null) {
                        this.PNE = new c(this.PhN);
                    }
                    view.setOnClickListener(this.PNE);
                } else {
                    eVar.PNI.setVisibility(8);
                }
            }
            String str2 = "";
            if (aml == null || !aml.NA()) {
                if (aml != null) {
                    str2 = Util.nullAs(((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(aml.getMd5()), "");
                }
            } else if (aml.field_name.startsWith("jsb_j")) {
                str2 = this.PhN.Pwc.getContext().getString(R.string.bsm);
            } else if (aml.field_name.startsWith("jsb_s")) {
                str2 = this.PhN.Pwc.getContext().getString(R.string.bsn);
            } else if (aml.field_name.startsWith("jsb_b")) {
                str2 = this.PhN.Pwc.getContext().getString(R.string.bsl);
            } else if (aml.field_name.startsWith("dice")) {
                str2 = aml.field_name.replace("dice_", "").replace(".png", "");
            }
            eVar.PKh.setContentDescription(this.PhN.Pwc.getContext().getString(R.string.bvt) + str2);
            eVar.PKh.setTag(new bq(caVar, aVar2.gRM(), i2, str, (char) 0));
            RTChattingEmojiView rTChattingEmojiView = eVar.PKh;
            if (this.PND == null) {
                this.PND = new d(aVar2);
            }
            rTChattingEmojiView.setOnClickListener(this.PND);
            eVar.PKh.setOnLongClickListener(c(aVar2));
            eVar.PKh.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            AppMethodBeat.o(37281);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37282);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(37282);
            return gRM;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233904);
            if (caVar.gDn()) {
                bg.aVF();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    int i2 = ((bq) view.getTag()).position;
                    EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(caVar.field_imgPath);
                    if (aml == null) {
                        Log.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", caVar.field_imgPath);
                        AppMethodBeat.o(233904);
                        return true;
                    }
                    boolean hYi = aml.hYi();
                    if (aml.field_catalog != EmojiInfo.VkW && !aml.hYm() && !aml.hYn()) {
                        if (hYi) {
                            mVar.a(i2, 104, view.getContext().getString(R.string.b0j), R.raw.icons_filled_addsticker);
                        } else {
                            Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    if (!aml.hYm()) {
                        if (hYi) {
                            mVar.a(i2, 113, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                        } else {
                            Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
                        }
                    }
                    com.tencent.mm.search.c.b bVar = com.tencent.mm.search.c.b.NJx;
                    com.tencent.mm.search.c.b.c(aml, this.PhN.getTalkerUserName());
                    boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_similar_emoji, true);
                    if (!aml.NA() && (view.getContext() instanceof Activity) && view.getContext().getResources().getConfiguration().orientation == 1 && a2) {
                        Log.i("MicroMsg.emoji.ChattingItemEmojiFrom", "menu add similar emoji item.");
                        mVar.a(i2, 115, view.getContext().getString(R.string.b0m), R.raw.icons_filled_othersticker);
                    }
                    if (((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
                        mVar.a(i2, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, view.getContext().getString(R.string.b09), R.raw.icons_filled_makesticker);
                    }
                    if (com.tencent.mm.plugin.emoji.h.b.ani(aml.field_groupId) && !aml.NA() && !aml.hYn()) {
                        mVar.a(i2, 128, view.getContext().getString(R.string.b0l), R.raw.icons_filled_sticker_album);
                    }
                    if (!this.PhN.gRN()) {
                        mVar.a(i2, 100, view.getContext().getString(R.string.b04), R.raw.icons_filled_delete);
                    }
                    h.INSTANCE.a(12789, 0, aml.getMd5(), 0, aml.field_designerID, aml.field_groupId, "", "", "", "", aml.field_activityid);
                }
            }
            AppMethodBeat.o(233904);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37284);
            boolean a2 = ((q) aVar.bh(q.class)).a(menuItem, aVar, caVar);
            AppMethodBeat.o(37284);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    static class e extends c.a {
        ImageView PIn;
        RTChattingEmojiView PKh;
        ImageView PKi;
        ViewStub PNH;
        View PNI;
        ImageView PNJ;

        e() {
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(37294);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PKh = (RTChattingEmojiView) view.findViewById(R.id.aul);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.PNI = view.findViewById(R.id.auu);
            this.PNJ = (ImageView) view.findViewById(R.id.auv);
            this.PNJ.setImageDrawable(ar.m(view.getContext(), R.raw.emoticonstore_capture_icon, -1));
            if (z) {
                this.userTV = (TextView) view.findViewById(R.id.ayn);
            } else {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.userTV = (TextView) view.findViewById(R.id.ayn);
                this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
            }
            if (this.PKi != null) {
                ((ViewGroup) this.PKi.getParent()).setBackgroundDrawable(null);
            }
            this.PNH = (ViewStub) view.findViewById(R.id.axy);
            AppMethodBeat.o(37294);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKh;
        }
    }

    public static class d extends t.e {
        private int scene;

        public d(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
            this.scene = 0;
        }

        public d(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            super(aVar);
            AppMethodBeat.i(37291);
            this.scene = 0;
            this.scene = 1;
            if (this.scene == 1) {
                a(new bq(caVar, this.PhN.gRM(), 0, this.PhN.gRI(), (char) 0));
            }
            AppMethodBeat.o(37291);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37292);
            a((bq) view.getTag());
            AppMethodBeat.o(37292);
        }

        private void a(bq bqVar) {
            AppMethodBeat.i(37293);
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                AppMethodBeat.o(37293);
                return;
            }
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(bqVar.dTX.field_talker);
            EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(bqVar.dTX.field_imgPath);
            if (aml == null || aml.NA()) {
                AppMethodBeat.o(37293);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("custom_smiley_preview_md5", bqVar.dTX.field_imgPath);
            intent.putExtra("custom_to_talker_name", bqVar.dTX.field_talker);
            if (!(aml.field_catalog == EmojiGroupInfo.VkP || aml.field_catalog == EmojiGroupInfo.VkO || aml.field_catalog == EmojiGroupInfo.VkN)) {
                intent.putExtra("custom_smiley_preview_productid", aml.field_groupId);
            }
            intent.putExtra("msg_id", bqVar.dTX.field_msgSvrId);
            intent.putExtra("msg_content", bqVar.dTX.field_content);
            String str = bqVar.dTX.field_talker;
            if (ab.Eq(str)) {
                str = bp.Ks(bqVar.dTX.field_content);
                intent.putExtra("room_id", this.PhN.getTalkerUserName());
            }
            intent.putExtra("msg_sender", str);
            intent.putExtra("talker_username", this.PhN.getTalkerUserName());
            com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", intent, 1111);
            h.INSTANCE.a(11592, 0);
            AppMethodBeat.o(37293);
        }
    }

    public static class c implements View.OnClickListener {
        private com.tencent.mm.ui.chatting.e.a PhN;

        public c(com.tencent.mm.ui.chatting.e.a aVar) {
            this.PhN = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(37290);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.EmojiCaptureTipsClickListener", "onClick: ");
            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_CAPTURE_PANEL_FROM_TIPS_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            EmojiCaptureReporter.cIw();
            Cdo doVar = new Cdo();
            doVar.dGz.type = 2;
            EventCenter.instance.publish(doVar);
            EventCenter.instance.publish(new rj());
            if (!doVar.dGA.dGB) {
                com.tencent.mm.ca.a.gvc();
                a.b bVar2 = com.tencent.mm.ca.a.NCN;
                a.b.bhD("capture");
                ((u) this.PhN.bh(u.class)).gPO().setDefaultSmileyByDetail(ad.avD());
            }
            ((u) this.PhN.bh(u.class)).gPO().gqo();
            com.tencent.mm.ui.chatting.e.a aVar = this.PhN;
            Log.i("MicroMsg.ChattingContext", "[scrollToLast]");
            aVar.Pwd.gNX();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemEmoji$EmojiCaptureTipsClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37290);
        }
    }
}
