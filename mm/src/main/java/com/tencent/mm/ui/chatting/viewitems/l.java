package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class l {

    public static class d extends c implements t.n {
        protected a PKn;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 1048625) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36930);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.so);
                view.setTag(new b().G(view, false));
            }
            AppMethodBeat.o(36930);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            EmojiInfo emojiInfo;
            k.b bVar;
            EmojiInfo emojiInfo2;
            long j2;
            boolean z;
            AppMethodBeat.i(36931);
            this.PhN = aVar2;
            ((m) aVar2.bh(m.class)).bZ(caVar);
            b bVar2 = (b) aVar;
            if (caVar != null) {
                String str2 = caVar.field_content;
                be bkr = be.bkr(caVar.field_content);
                if (!bkr.jsi) {
                    if (str2 != null) {
                        bVar = k.b.aD(str2, caVar.field_reserved);
                    } else {
                        bVar = null;
                    }
                    emojiInfo = bVar != null ? ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(bVar.iwK) : null;
                } else {
                    emojiInfo = null;
                    bVar = null;
                }
                if (bkr.md5 == null || bkr.md5.equals("-1") || emojiInfo != null) {
                    emojiInfo2 = emojiInfo;
                } else {
                    emojiInfo2 = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(bkr.md5);
                }
                if (emojiInfo2 == null || !emojiInfo2.hYi()) {
                    String R = q.bcR().R(caVar.field_imgPath, true);
                    Bitmap OQ = q.bcV().OQ(R);
                    if (OQ == null || OQ.isRecycled()) {
                        OQ = BitmapUtil.decodeFile(R, null);
                        q.bcV().h(R, OQ);
                    }
                    b((c.a) bVar2, false);
                    bVar2.PKk.setVisibility(0);
                    bVar2.PKj.setVisibility(8);
                    TextView textView = bVar2.PKl;
                    if (bVar == null) {
                        j2 = 0;
                    } else {
                        j2 = (long) bVar.iwI;
                    }
                    textView.setText(af.getSizeKB(j2));
                    bVar2.PKl.setVisibility(0);
                    bVar2.PKk.setImageResource(R.drawable.emoji_download_btn);
                    if (OQ == null || OQ.isRecycled()) {
                        OQ = BitmapUtil.transformDrawableToBitmap(this.PhN.Pwc.getMMResources().getDrawable(R.drawable.ba8));
                    }
                    bVar2.PKh.setImageBitmap(OQ);
                    if (bVar != null && !Util.isNullOrNil(bVar.iwK)) {
                        b.PKm.put(bVar.iwK, new WeakReference<>(bVar2));
                    }
                } else {
                    emojiInfo2.talker = caVar.field_talker;
                    bVar2.PKh.a(emojiInfo2, caVar.field_msgId);
                    RTChattingEmojiView rTChattingEmojiView = bVar2.PKh;
                    if (rTChattingEmojiView.KoD != null) {
                        rTChattingEmojiView.KoD.resume();
                    }
                    if (!(caVar.field_status != 1)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b(bVar2, z);
                    a(caVar, emojiInfo2);
                }
                if (gTW()) {
                    if (caVar == null || caVar.field_status != 2 || !b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.field_msgId)) {
                        if (bVar2.PIn != null) {
                            bVar2.PIn.setVisibility(8);
                        }
                    } else if (bVar2.PIn != null) {
                        bVar2.PIn.setVisibility(0);
                    }
                }
                bVar2.PKh.setTag(new bq(caVar, aVar2.gRM(), i2, aVar2.gRI(), (char) 0));
                RTChattingEmojiView rTChattingEmojiView2 = bVar2.PKh;
                if (this.PKn == null) {
                    this.PKn = new a(aVar2);
                }
                rTChattingEmojiView2.setOnClickListener(this.PKn);
                bVar2.PKh.setOnLongClickListener(c(aVar2));
                bVar2.PKh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                a(i2, bVar2, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            }
            AppMethodBeat.o(36931);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            k.b bVar;
            AppMethodBeat.i(233628);
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i2 = ((bq) view.getTag()).position;
                be bkr = be.bkr(caVar.field_content);
                k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
                if (aD == null) {
                    k.b bVar2 = new k.b();
                    bVar2.iwK = bkr.md5;
                    bVar = bVar2;
                } else {
                    bVar = aD;
                }
                if (!af.isNullOrNil(bVar.iwK) && !bVar.iwK.equals("-1")) {
                    EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(bVar.iwK);
                    if (aml != null) {
                        if (aml.field_catalog != EmojiInfo.VkW && !aml.hYm()) {
                            mVar.a(i2, 104, view.getContext().getString(R.string.b0j), R.raw.icons_filled_addsticker);
                        }
                        com.tencent.mm.search.c.b bVar3 = com.tencent.mm.search.c.b.NJx;
                        com.tencent.mm.search.c.b.c(aml, this.PhN.getTalkerUserName());
                        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_similar_emoji, true);
                        if ((view.getContext() instanceof Activity) && view.getContext().getResources().getConfiguration().orientation == 1 && a2) {
                            Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "menu add similar emoji item.");
                            mVar.a(i2, 115, view.getContext().getString(R.string.b0m), R.raw.icons_filled_othersticker);
                        }
                        h.INSTANCE.a(12789, 0, aml.getMd5(), 0, aml.field_designerID, aml.field_groupId, "", "", "", "", aml.field_activityid);
                        if (aml.hYi()) {
                            mVar.a(i2, 113, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                        } else {
                            Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                        }
                        if (((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
                            mVar.a(i2, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, view.getContext().getString(R.string.b09), R.raw.icons_filled_makesticker);
                        }
                    } else {
                        Log.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", bVar.iwK);
                    }
                }
                if (caVar.field_status == 5) {
                    mVar.a(i2, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                if (!caVar.gAt() && caVar.gDo() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker))) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b04), R.raw.icons_filled_delete);
                }
            }
            AppMethodBeat.o(233628);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36933);
            boolean a2 = ((com.tencent.mm.ui.chatting.d.b.q) aVar.bh(com.tencent.mm.ui.chatting.d.b.q.class)).a(menuItem, aVar, caVar);
            AppMethodBeat.o(36933);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233629);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
                AppMethodBeat.o(233629);
                return;
            }
            AppMethodBeat.o(233629);
        }
    }

    public static class c extends c {
        protected a PKn;
        private com.tencent.mm.ui.chatting.e.a PhN;

        private a m(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36924);
            if (this.PKn == null) {
                this.PKn = new a(aVar);
            }
            a aVar2 = this.PKn;
            AppMethodBeat.o(36924);
            return aVar2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 1048625) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36925);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ra);
                view.setTag(new b().G(view, true));
            }
            AppMethodBeat.o(36925);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            EmojiInfo emojiInfo;
            long j2;
            AppMethodBeat.i(36926);
            this.PhN = aVar2;
            ((m) aVar2.bh(m.class)).bZ(caVar);
            b bVar2 = (b) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar == null || bVar.iwK == null) {
                emojiInfo = null;
            } else {
                emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(bVar.iwK);
            }
            if (emojiInfo == null || !emojiInfo.hYi()) {
                String R = q.bcR().R(caVar.field_imgPath, true);
                Bitmap OQ = q.bcV().OQ(R);
                if (OQ == null || OQ.isRecycled()) {
                    OQ = BitmapUtil.decodeFile(R, null);
                    q.bcV().h(R, OQ);
                }
                bVar2.PKk.setVisibility(0);
                bVar2.PKj.setVisibility(8);
                TextView textView = bVar2.PKl;
                if (bVar == null) {
                    j2 = 0;
                } else {
                    j2 = (long) bVar.iwI;
                }
                textView.setText(af.getSizeKB(j2));
                bVar2.PKl.setVisibility(0);
                bVar2.PKk.setImageResource(R.drawable.emoji_download_btn);
                if (bVar != null && !Util.isNullOrNil(bVar.iwK)) {
                    b.PKm.put(bVar.iwK, new WeakReference<>(bVar2));
                }
                if (OQ == null || OQ.isRecycled()) {
                    OQ = BitmapUtil.transformDrawableToBitmap(this.PhN.Pwc.getMMResources().getDrawable(R.drawable.ba8));
                }
                bVar2.PKh.setImageBitmap(OQ);
            } else {
                emojiInfo.talker = caVar.field_talker;
                bVar2.PKh.a(emojiInfo, caVar.field_msgId);
                bVar2.PKk.setVisibility(8);
                bVar2.PKj.setVisibility(8);
                bVar2.PKl.setVisibility(8);
                bVar2.PKk.setVisibility(8);
                if (bVar != null && !Util.isNullOrNil(bVar.iwK)) {
                    b.PKm.remove(bVar.iwK);
                }
                a(caVar, emojiInfo);
            }
            bVar2.PKh.setTag(new bq(caVar, aVar2.gRM(), i2, str, (char) 0));
            bVar2.PKh.setOnClickListener(m(aVar2));
            bVar2.PKh.setOnLongClickListener(c(aVar2));
            bVar2.PKh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            bVar2.PKk.setOnClickListener(m(aVar2));
            bVar2.PKk.setOnLongClickListener(c(aVar2));
            bVar2.PKk.setTag(bVar2.PKh.getTag());
            AppMethodBeat.o(36926);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36927);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(36927);
            return gRM;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            k.b bVar;
            EmojiInfo aml;
            AppMethodBeat.i(233627);
            int i2 = ((bq) view.getTag()).position;
            be bkr = be.bkr(caVar.field_content);
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                k.b bVar2 = new k.b();
                bVar2.iwK = bkr.md5;
                bVar = bVar2;
            } else {
                bVar = aD;
            }
            if (!af.isNullOrNil(bVar.iwK) && !bVar.iwK.equals("-1") && (aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(bVar.iwK)) != null) {
                if (aml.field_catalog != EmojiInfo.VkW && !aml.hYm()) {
                    mVar.a(i2, 104, view.getContext().getString(R.string.b0j), R.raw.icons_filled_addsticker);
                }
                com.tencent.mm.search.c.b bVar3 = com.tencent.mm.search.c.b.NJx;
                com.tencent.mm.search.c.b.c(aml, this.PhN.getTalkerUserName());
                boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_similar_emoji, true);
                if ((view.getContext() instanceof Activity) && view.getContext().getResources().getConfiguration().orientation == 1 && a2) {
                    Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "menu add similar emoji item.");
                    mVar.a(i2, 115, view.getContext().getString(R.string.b0m), R.raw.icons_filled_othersticker);
                }
                if (aml != null) {
                    h.INSTANCE.a(12789, 0, aml.getMd5(), 0, aml.field_designerID, aml.field_groupId, "", "", "", "", aml.field_activityid);
                }
                if (aml.hYi()) {
                    mVar.a(i2, 113, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                } else {
                    Log.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                }
                if (((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cFM()) {
                    mVar.a(i2, com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, view.getContext().getString(R.string.b09), R.raw.icons_filled_makesticker);
                }
            }
            if (br.B(caVar)) {
                mVar.clear();
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, view.getContext().getString(R.string.b04), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233627);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36929);
            boolean a2 = ((com.tencent.mm.ui.chatting.d.b.q) aVar.bh(com.tencent.mm.ui.chatting.d.b.q.class)).a(menuItem, aVar, caVar);
            AppMethodBeat.o(36929);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    public static final class b extends c.a {
        public static Map<String, WeakReference<b>> PKm = new HashMap();
        ImageView PIn;
        RTChattingEmojiView PKh;
        ImageView PKi;
        ProgressBar PKj;
        ImageView PKk;
        TextView PKl;

        static {
            AppMethodBeat.i(36923);
            AppMethodBeat.o(36923);
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(36921);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PKh = (RTChattingEmojiView) view.findViewById(R.id.aul);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.PKj = (ProgressBar) view.findViewById(R.id.aut);
            this.PKk = (ImageView) view.findViewById(R.id.ayc);
            this.PKl = (TextView) view.findViewById(R.id.ay8);
            if (!z) {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
            }
            if (this.PKi != null) {
                ((ViewGroup) this.PKi.getParent()).setBackgroundDrawable(null);
            }
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            AppMethodBeat.o(36921);
            return this;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static void u(String str, int i2, int i3) {
            AppMethodBeat.i(36922);
            if (!PKm.containsKey(str)) {
                Log.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
                AppMethodBeat.o(36922);
                return;
            }
            b bVar = PKm.get(str).get();
            if (bVar != null) {
                switch (i3) {
                    case 0:
                        bVar.PKj.setVisibility(0);
                        bVar.PKl.setVisibility(8);
                        bVar.PKk.setVisibility(8);
                        bVar.PKj.setProgress(0);
                        break;
                    case 1:
                        bVar.PKj.setVisibility(8);
                        bVar.PKl.setVisibility(8);
                        bVar.PKk.setVisibility(8);
                        AppMethodBeat.o(36922);
                        return;
                    case 2:
                        bVar.PKj.setVisibility(8);
                        bVar.PKl.setVisibility(8);
                        bVar.PKk.setVisibility(0);
                        bVar.PKj.setProgress(i2);
                        bVar.PKk.setImageResource(R.drawable.emoji_download_failed_btn);
                        AppMethodBeat.o(36922);
                        return;
                }
            }
            AppMethodBeat.o(36922);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKh;
        }
    }

    public static class a extends t.e {
        a(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            AppMethodBeat.i(36920);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            bq bqVar = (bq) view.getTag();
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ca caVar2 = bqVar.dTX;
                if (ab.Eq(caVar2.field_talker)) {
                    str = this.PhN.getTalkerUserName();
                } else {
                    str = null;
                }
                ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.PhN.Pwc.getContext(), caVar2, str);
                h.INSTANCE.a(11592, 0);
            }
            AppMethodBeat.o(36920);
        }
    }
}
