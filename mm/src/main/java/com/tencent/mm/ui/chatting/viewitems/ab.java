package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.RSInvalidStateException;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.i;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.al;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.xweb.util.d;

public final class ab {
    static /* synthetic */ Bitmap b(Context context, Bitmap bitmap, int i2, int i3, boolean z) {
        AppMethodBeat.i(259014);
        Bitmap a2 = a(context, bitmap, i2, i3, z);
        AppMethodBeat.o(259014);
        return a2;
    }

    protected static boolean a(com.tencent.mm.ui.chatting.e.a aVar, m mVar, View view, ca caVar, boolean z) {
        AppMethodBeat.i(233773);
        int i2 = ((bq) view.getTag()).position;
        if (caVar.field_content == null) {
            AppMethodBeat.o(233773);
        } else {
            k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                AppMethodBeat.o(233773);
            } else if (3 == HD.type || 76 == HD.type) {
                g o = h.o(HD.appId, false, false);
                if (h.l(o) && !com.tencent.mm.ui.chatting.k.bm(caVar) && caVar.field_status != 1) {
                    mVar.a(i2, 111, aVar.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                }
                if (!z && ((caVar.field_status == 2 || caVar.fQV == 1) && c.b(caVar, aVar) && c.bnf(caVar.field_talker) && !as.HF(aVar.getTalkerUserName()))) {
                    mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                if (com.tencent.mm.al.g.aZR() && !aVar.gRN()) {
                    mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
                }
                if (com.tencent.mm.br.c.aZU("favorite") && (o == null || !o.NA())) {
                    mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX || e.b.a(aVar.Pwc.getContext(), HD)) {
                    mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (!aVar.gRN()) {
                    mVar.a(i2, 100, aVar.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                }
                if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                    mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
                }
                AppMethodBeat.o(233773);
            } else {
                Log.e("MicroMsg.ChattingItemAppMsgMusic", "onCreateContextMenu(from), not music type, but enter here.");
                AppMethodBeat.o(233773);
            }
        }
        return true;
    }

    protected static boolean a(c cVar, MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(233774);
        switch (menuItem.getItemId()) {
            case 100:
                AppMethodBeat.o(233774);
                break;
            case 111:
                if (ac.bB(caVar)) {
                    e.b.a(aVar, caVar, cVar.a(aVar, caVar));
                    AppMethodBeat.o(233774);
                    break;
                } else {
                    com.tencent.mm.ui.base.h.a(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.c89), "", aVar.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(233774);
                    break;
                }
            case 114:
                an.a(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                AppMethodBeat.o(233774);
                break;
            case 144:
                Intent intent = new Intent();
                intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                AppMethodBeat.o(233774);
                break;
            default:
                AppMethodBeat.o(233774);
                break;
        }
        return false;
    }

    private static boolean k(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
        String str;
        com.tencent.mm.pluginsdk.ui.tools.b bVar2;
        int i2;
        css css;
        AppMethodBeat.i(259013);
        Log.i("MicroMsg.ChattingItemAppMsgMusic", "handleMusicVideoClick, content:%s", bVar.izG);
        if (!((aj) com.tencent.mm.kernel.g.ah(aj.class)).canEnterMvAndShowToast()) {
            AppMethodBeat.o(259013);
            return false;
        }
        if (cVar instanceof a) {
            str = ((a) cVar).jfz;
        } else if (cVar instanceof b) {
            str = ((b) cVar).jfz;
        } else {
            str = "";
        }
        Log.i("MicroMsg.ChattingItemAppMsgMusic", "handleMusicVideoClick, doPlayMusic, musicCoverPath:%s", str);
        String format = String.format("%d_msg", Long.valueOf(caVar.field_msgId));
        if (!s.aMJ(format)) {
            if (bVar != null) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10090, "0,1");
                if (bVar != null) {
                    com.tencent.mm.pluginsdk.ui.tools.b bVar3 = (com.tencent.mm.pluginsdk.ui.tools.b) bVar.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
                    if (bVar3 != null) {
                        css = al.a(bVar, bVar3);
                    } else {
                        css = null;
                    }
                } else {
                    css = null;
                }
                if (css != null) {
                    css.jfz = str;
                }
                String str2 = caVar.field_imgPath;
                bg.aVF();
                f a2 = i.a(bVar, format, str2, com.tencent.mm.model.c.getAccPath(), caVar.field_imgPath, com.tencent.mm.ay.h.a(format, css));
                Log.d("MicroMsg.ChattingItemHelper", "doPlayMusic, songName:%s, singer:%s, wrapper.songWebUrl:%s, wifiUrl:%s", a2.jeX, a2.jeY, a2.jfd, a2.jfb);
                com.tencent.mm.ay.a.c(a2);
            }
            com.tencent.mm.modelstat.b bVar4 = com.tencent.mm.modelstat.b.jmd;
            if (bVar != null) {
                i2 = bVar.type;
            } else {
                i2 = 0;
            }
            bVar4.a(caVar, true, i2);
        }
        Intent intent = new Intent();
        intent.putExtra("key_scene", 6);
        if (!(bVar == null || (bVar2 = (com.tencent.mm.pluginsdk.ui.tools.b) bVar.as(com.tencent.mm.pluginsdk.ui.tools.b.class)) == null)) {
            intent.putExtra("key_mv_song_name", bVar.title);
            intent.putExtra("key_mv_song_lyric", bVar2.songLyric);
            intent.putExtra("key_mv_album_cover_url", bVar2.songAlbumUrl);
            intent.putExtra("key_mv_feed_id", bVar2.Ktn);
            intent.putExtra("key_mv_nonce_id", bVar2.Kto);
            intent.putExtra("key_mv_cover_url", bVar2.Ktp);
            intent.putExtra("key_mv_poster", bVar2.Ktq);
            intent.putExtra("key_mv_singer_name", !Util.isNullOrNil(bVar2.Ktr) ? bVar2.Ktr : bVar.description);
            intent.putExtra("key_mv_album_name", bVar2.Kts);
            intent.putExtra("key_mv_music_genre", bVar2.Ktt);
            intent.putExtra("key_mv_issue_date", bVar2.Ktu);
            intent.putExtra("key_mv_music_duration", bVar2.Alz);
            intent.putExtra("key_mv_identification", bVar2.Ktv);
            intent.putExtra("key_mv_extra_info", bVar2.Ktw);
            intent.putExtra("key_mv_thumb_path", str);
        }
        intent.setFlags(268435456);
        SecDataUIC.a aVar2 = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(aVar.Pwc.getContext(), "MusicMvMainUI", 7, cst.class);
        cst.scene = 2;
        com.tencent.mm.plugin.comm.a aVar3 = com.tencent.mm.plugin.comm.a.qCo;
        cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
        cst.MxI = 84;
        cst.MxJ = caVar.field_talker;
        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "mv", ".ui.MusicMvMainUI", intent);
        AppMethodBeat.o(259013);
        return true;
    }

    public static class a extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;
        private String jfz = "";

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 1040187441) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233757);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rp);
                view.setTag(new c().G(view, true));
            }
            AppMethodBeat.o(233757);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(233758);
            this.PhN = aVar2;
            c.a(this, (c) aVar, caVar, true, i2, aVar2);
            AppMethodBeat.o(233758);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233759);
            boolean a2 = ab.a(this.PhN, mVar, view, caVar, true);
            AppMethodBeat.o(233759);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233760);
            boolean a2 = ab.a(this, menuItem, aVar, caVar);
            AppMethodBeat.o(233760);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233761);
            boolean a2 = ab.a(this, aVar, caVar);
            AppMethodBeat.o(233761);
            return a2;
        }
    }

    public static class b extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;
        private String jfz = "";

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 1040187441) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(233762);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t3);
                view.setTag(new c().G(view, false));
            }
            AppMethodBeat.o(233762);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(233763);
            this.PhN = aVar2;
            c.a(this, (c) aVar, caVar, false, i2, aVar2);
            c cVar = (c) aVar;
            if (gTW()) {
                if (caVar.field_status != 2 || !b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.field_msgId)) {
                    if (cVar.PIn != null) {
                        cVar.PIn.setVisibility(8);
                    }
                } else if (cVar.PIn != null) {
                    cVar.PIn.setVisibility(0);
                }
            }
            a(i2, cVar, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(233763);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233764);
            boolean a2 = ab.a(this.PhN, mVar, view, caVar, false);
            AppMethodBeat.o(233764);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233765);
            boolean a2 = ab.a(this, menuItem, aVar, caVar);
            AppMethodBeat.o(233765);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233766);
            boolean a2 = ab.a(this, aVar, caVar);
            AppMethodBeat.o(233766);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233767);
            caVar.unsetOmittedFailResend();
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            ((ad) aVar.bh(ad.class)).bU(caVar);
            AppMethodBeat.o(233767);
        }
    }

    static class c extends c.a {
        protected ImageView AmB;
        protected TextView EYV;
        protected TextView EYW;
        protected WeImageView EYY;
        protected TextView EsH;
        protected ImageView PIn;
        protected RelativeLayout PLh;
        protected LinearLayout PLi;
        protected MMRoundCornerImageView PLj;
        protected TextView PLk;

        c() {
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(233771);
            super.create(view);
            this.clickArea = view.findViewById(R.id.axb);
            this.PLh = (RelativeLayout) view.findViewById(R.id.axc);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.EsH = (TextView) view.findViewById(R.id.axh);
            this.EYV = (TextView) view.findViewById(R.id.axi);
            this.EYW = (TextView) view.findViewById(R.id.axf);
            this.EYY = (WeImageView) view.findViewById(R.id.axe);
            this.AmB = (ImageView) view.findViewById(R.id.axd);
            int fromDPToPix = at.fromDPToPix(view.getContext(), 4);
            ((RoundCornerRelativeLayout) view.findViewById(R.id.axg)).s((float) fromDPToPix, 0.0f, (float) fromDPToPix, 0.0f);
            this.PLi = (LinearLayout) view.findViewById(R.id.axj);
            this.PLj = (MMRoundCornerImageView) view.findViewById(R.id.axk);
            this.PLj.setRadius(at.fromDPToPix(view.getContext(), 2));
            this.PLk = (TextView) view.findViewById(R.id.axl);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            if (!z) {
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
            }
            this.EYV.setTextSize(1, 15.0f);
            this.EsH.setTextSize(1, 12.0f);
            AppMethodBeat.o(233771);
            return this;
        }

        @SuppressLint({"ResourceType"})
        public static void a(c cVar, c cVar2, final ca caVar, final boolean z, int i2, final com.tencent.mm.ui.chatting.e.a aVar) {
            k.b bVar;
            String str;
            int indexOf;
            AppMethodBeat.i(233772);
            if (cVar2 == null) {
                AppMethodBeat.o(233772);
                return;
            }
            String str2 = caVar.field_content;
            if (aVar.gRM() && (indexOf = caVar.field_content.indexOf(58)) != -1) {
                str2 = caVar.field_content.substring(indexOf + 1);
            }
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            cVar2.EYV.setMaxLines(2);
            cVar2.EsH.setMaxLines(1);
            cVar2.EYW.setMaxLines(1);
            cVar2.EsH.setText("");
            cVar2.AmB.setImageDrawable(aVar.Pwc.getContext().getResources().getDrawable(R.drawable.cvc));
            if (ao.isDarkMode()) {
                cVar2.AmB.setImageDrawable(aVar.Pwc.getContext().getResources().getDrawable(R.drawable.cvb));
            }
            if (bVar == null) {
                Log.e("MicroMsg.MusicItemHolder", "null == content");
                AppMethodBeat.o(233772);
                return;
            }
            if (z) {
                cVar2.PLh.setBackgroundResource(R.drawable.mw);
            } else {
                cVar2.PLh.setBackgroundResource(R.drawable.os);
            }
            if (3 == bVar.type || 76 == bVar.type) {
                com.tencent.mm.pluginsdk.ui.tools.b bVar2 = (com.tencent.mm.pluginsdk.ui.tools.b) bVar.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
                cVar2.EYV.setText(bVar.getTitle());
                if (bVar2 == null || Util.isNullOrNil(bVar2.Ktr)) {
                    cVar2.EsH.setText(bVar.getDescription());
                } else {
                    cVar2.EsH.setText(bVar2.Ktr);
                }
                cVar2.EYV.setTextColor(aVar.Pwc.getContext().getResources().getColor(R.color.FG_0));
                cVar2.EsH.setTextColor(aVar.Pwc.getContext().getResources().getColor(R.color.u_));
                if (!Util.isNullOrNil(cVar2.EsH.getText())) {
                    cVar2.EsH.setVisibility(0);
                } else {
                    cVar2.EsH.setText("");
                    cVar2.EsH.setVisibility(8);
                }
                g gE = h.gE(bVar.appId, bVar.appVersion);
                String str3 = (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) ? bVar.appName : gE.field_appName;
                if (bVar.appId != null && bVar.appId.length() > 0 && c.gp(str3)) {
                    cVar2.PLk.setText(h.a(aVar.Pwc.getContext(), gE, str3));
                    cVar2.PLk.setCompoundDrawables(null, null, null, null);
                    c.a(aVar, (View) cVar2.PLk, bVar.appId);
                    c.a(aVar, (ImageView) cVar2.PLj, bVar.appId);
                    cVar2.PLi.setVisibility(0);
                }
                cVar2.PLi.setBackgroundResource(R.drawable.o8);
                String str4 = "";
                if (bVar2 != null) {
                    String str5 = bVar2.Ktp;
                    String str6 = bVar2.Ktq;
                    if (!Util.isNullOrNil(str6)) {
                        cVar2.EYV.setMaxLines(1);
                        ((ViewGroup.MarginLayoutParams) cVar2.EYV.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 8);
                        ((ViewGroup.MarginLayoutParams) cVar2.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 4);
                        cVar2.PLh.findViewById(R.id.g8b).setVisibility(0);
                        cVar2.EYW.setText(str6 + aVar.Pwc.getContext().getString(R.string.f8v));
                        cVar2.EYW.setVisibility(0);
                        str4 = str5;
                    } else {
                        ((ViewGroup.MarginLayoutParams) cVar2.EYV.getLayoutParams()).topMargin = 0;
                        ((ViewGroup.MarginLayoutParams) cVar2.EsH.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 6);
                        cVar2.PLh.findViewById(R.id.g8b).setVisibility(8);
                        cVar2.EYW.setText("");
                        cVar2.EYW.setVisibility(8);
                        str4 = str5;
                    }
                }
                if (!Util.isNullOrNil(str4)) {
                    String messageDigest = d.getMessageDigest(str4.getBytes());
                    String str7 = messageDigest + "_cover";
                    Object[] objArr = new Object[2];
                    objArr[0] = messageDigest;
                    objArr[1] = z ? "from" : "to";
                    String format = String.format("%s_bg_%s", objArr);
                    Bitmap OQ = q.bcV().OQ(str7);
                    Bitmap OQ2 = q.bcV().OQ(format);
                    cVar2.AmB.setTag(str7);
                    Log.i("MicroMsg.MusicItemHolder", "updateTag %s %s %s %s %s", Integer.valueOf(cVar2.AmB.hashCode()), cVar2.AmB.getTag(), str7, Long.valueOf(caVar.field_msgId), str4);
                    cVar2.PLh.setTag(format);
                    if (OQ != null && !OQ.isRecycled()) {
                        cVar2.AmB.setImageBitmap(OQ);
                    }
                    if (OQ2 == null || OQ2.isRecycled()) {
                        cVar2.PLh.setBackground(null);
                    } else {
                        cVar2.PLh.setBackground(new BitmapDrawable(aVar.Pwc.getContext().getResources(), OQ2));
                    }
                    str = com.tencent.mm.plugin.music.h.b.bT(messageDigest, false);
                    if (OQ == null || OQ2 == null) {
                        c.a aVar2 = new c.a();
                        aVar2.jbf = true;
                        aVar2.jbd = true;
                        aVar2.fullPath = str;
                        aVar2.jbE = new Object[]{cVar2.AmB, str7, cVar2.PLh, format, str};
                        q.bcV().a(str4, aVar2.bdv(), new com.tencent.mm.av.a.c.d() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ab.c.AnonymousClass1 */

                            @Override // com.tencent.mm.av.a.c.d
                            public final void a(boolean z, Object... objArr) {
                                AppMethodBeat.i(259011);
                                final ImageView imageView = (ImageView) objArr[0];
                                final String str = (String) objArr[1];
                                final RelativeLayout relativeLayout = (RelativeLayout) objArr[2];
                                final String str2 = (String) objArr[3];
                                final Bitmap bitmapNative = BitmapUtil.getBitmapNative((String) objArr[4], imageView.getWidth(), imageView.getHeight());
                                final Bitmap b2 = ab.b(aVar.Pwc.getContext(), bitmapNative, relativeLayout.getHeight(), relativeLayout.getWidth(), z);
                                q.bcV().h(str, bitmapNative);
                                q.bcV().h(str2, b2);
                                com.tencent.f.h.RTc.aV(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.ab.c.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(259010);
                                        if (imageView.getTag() != null && imageView.getTag().equals(str)) {
                                            Log.i("MicroMsg.MusicItemHolder", "setImageBitmap %s %s %s ", Integer.valueOf(imageView.hashCode()), imageView.getTag(), str);
                                            imageView.setImageBitmap(bitmapNative);
                                        }
                                        if (relativeLayout.getTag() != null && relativeLayout.getTag().equals(str2)) {
                                            relativeLayout.setBackground(new BitmapDrawable(aVar.Pwc.getContext().getResources(), b2));
                                        }
                                        AppMethodBeat.o(259010);
                                    }
                                });
                                AppMethodBeat.o(259011);
                            }
                        });
                    }
                } else {
                    if (!bVar.aSy()) {
                        bg.aVF();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            if (!e.b.bnh(caVar.field_imgPath)) {
                                str = q.bcR().d(caVar.field_imgPath, false, true);
                            } else {
                                str = "";
                            }
                            if (!Util.isNullOrNil(str)) {
                                String messageDigest2 = d.getMessageDigest(str.getBytes());
                                final String str8 = messageDigest2 + "_cover";
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = messageDigest2;
                                objArr2[1] = z ? "from" : "to";
                                final String format2 = String.format("%s_bg_%s", objArr2);
                                cVar2.AmB.setTag(str8);
                                cVar2.PLh.setTag(format2);
                                Bitmap OQ3 = q.bcV().OQ(str8);
                                Bitmap OQ4 = q.bcV().OQ(format2);
                                if (OQ3 != null && !OQ3.isRecycled()) {
                                    Log.i("MicroMsg.MusicItemHolder", "coverBm (local) is valid, use cache, key:".concat(String.valueOf(str8)));
                                    cVar2.AmB.setImageBitmap(OQ3);
                                }
                                if (OQ4 != null && !OQ4.isRecycled()) {
                                    Log.i("MicroMsg.MusicItemHolder", "bgBm (local) is valid, use bg cache, key:".concat(String.valueOf(format2)));
                                    cVar2.PLh.setBackground(new BitmapDrawable(aVar.Pwc.getContext().getResources(), OQ4));
                                }
                                if (OQ3 == null || OQ4 == null) {
                                    final ImageView imageView = cVar2.AmB;
                                    final RelativeLayout relativeLayout = cVar2.PLh;
                                    com.tencent.f.h.RTc.aX(new Runnable() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.ab.c.AnonymousClass2 */

                                        public final void run() {
                                            AppMethodBeat.i(259012);
                                            final Bitmap a2 = q.bcR().a(caVar.field_imgPath, com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext()), false);
                                            final Bitmap b2 = ab.b(aVar.Pwc.getContext(), a2, relativeLayout.getHeight(), relativeLayout.getWidth(), z);
                                            q.bcV().h(str8, a2);
                                            q.bcV().h(format2, b2);
                                            com.tencent.f.h.RTc.aV(new Runnable() {
                                                /* class com.tencent.mm.ui.chatting.viewitems.ab.c.AnonymousClass2.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(233769);
                                                    if (imageView.getTag() != null && imageView.getTag().equals(str8) && a2 != null && !a2.isRecycled()) {
                                                        imageView.setImageBitmap(a2);
                                                    }
                                                    if (relativeLayout.getTag() != null && relativeLayout.getTag().equals(format2) && b2 != null && !b2.isRecycled()) {
                                                        relativeLayout.setBackground(new BitmapDrawable(aVar.Pwc.getContext().getResources(), b2));
                                                    }
                                                    AppMethodBeat.o(233769);
                                                }
                                            });
                                            AppMethodBeat.o(259012);
                                        }
                                    });
                                }
                            }
                        }
                    }
                    cVar2.AmB.setImageBitmap(BitmapFactory.decodeResource(aVar.Pwc.getMMResources(), R.drawable.bjm));
                    str = "";
                }
                if ((caVar.field_msgId + "_msg").equals(cVar2.playingMsgId)) {
                    cVar2.EYY.setImageResource(R.raw.icons_outlined_pause2);
                } else {
                    cVar2.EYY.setImageResource(R.raw.icons_outlined_play2);
                }
                cVar2.EYY.setIconColor(aVar.Pwc.getContext().getResources().getColor(R.color.fo));
                if (z) {
                    ((a) cVar).jfz = str;
                } else {
                    ((b) cVar).jfz = str;
                }
                e.g gVar = new e.g();
                gVar.msgId = caVar.field_msgId;
                gVar.xml = caVar.field_content;
                gVar.dRr = caVar.field_imgPath;
                gVar.jfy = al.a(bVar, bVar2);
                if (gVar.jfy != null) {
                    gVar.jfy.jfz = str;
                }
                gVar.ixW = 1;
                gVar.MxJ = caVar.field_talker;
                cVar2.EYY.setTag(gVar);
                cVar2.EYY.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOD());
                cVar2.clickArea.setTag(new bq(caVar, aVar.gRM(), i2, (String) null, (char) 0));
                cVar2.clickArea.setOnClickListener(cVar.d(aVar));
                cVar2.clickArea.setOnLongClickListener(cVar.c(aVar));
                cVar2.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            AppMethodBeat.o(233772);
        }
    }

    private static final Bitmap a(Context context, Bitmap bitmap, int i2, int i3, boolean z) {
        Bitmap bitmap2;
        Bitmap bitmap3;
        AppMethodBeat.i(233775);
        long currentTicks = Util.currentTicks();
        if (i2 == 0) {
            try {
                i2 = com.tencent.mm.cb.a.fromDPToPix(context, 88);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ChattingItemAppMsgMusic", e2, "getBgContentBm", new Object[0]);
                AppMethodBeat.o(233775);
                return null;
            }
        }
        if (i3 == 0) {
            i3 = com.tencent.mm.cb.a.fromDPToPix(context, 280);
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i4 = (int) (((float) height) * 1.0f * ((((float) i2) * 1.0f) / ((float) i3)));
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap2 = BitmapUtil.createColorBitmap(context.getResources().getColor(R.color.iu), width, i4);
        } else {
            bitmap2 = bitmap;
        }
        Matrix matrix = new Matrix();
        float f2 = ((((float) i2) * 1.0f) / ((float) i4)) * 0.25f * 0.25f;
        matrix.postScale(f2, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, (height - i4) / 2, width, i4, matrix, false);
        com.tencent.mm.ui.blur.f fVar = new com.tencent.mm.ui.blur.f(MMApplicationContext.getContext());
        try {
            Bitmap b2 = fVar.b(createBitmap, 30.0f);
            try {
                fVar.destroy();
                bitmap3 = b2;
            } catch (RSInvalidStateException e3) {
                Log.w("MicroMsg.ChattingItemAppMsgMusic", "RSInvalidStateException ${ex.message}");
                bitmap3 = b2;
            }
        } catch (Throwable th) {
            try {
                fVar.destroy();
            } catch (RSInvalidStateException e4) {
                Log.w("MicroMsg.ChattingItemAppMsgMusic", "RSInvalidStateException ${ex.message}");
            }
            AppMethodBeat.o(233775);
            throw th;
        }
        int i5 = R.drawable.c3c;
        if (!z) {
            i5 = R.drawable.c3n;
        }
        com.tencent.mm.plugin.comm.b bVar = com.tencent.mm.plugin.comm.b.qCp;
        Bitmap a2 = com.tencent.mm.plugin.comm.b.a(ao.isDarkMode(), bitmap3);
        Log.i("MicroMsg.ChattingItemAppMsgMusic", String.format("getBgContentBm, after addGradientDrawableToBitmap , from:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(Util.ticksToNow(currentTicks))));
        Bitmap createMaskImage = BitmapUtil.createMaskImage(a2, i5, i3, i2);
        Log.i("MicroMsg.ChattingItemAppMsgMusic", String.format("getBgContentBm,from:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(Util.ticksToNow(currentTicks))));
        AppMethodBeat.o(233775);
        return createMaskImage;
    }

    static /* synthetic */ boolean a(c cVar, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(233776);
        com.tencent.mm.modelstat.a.a(caVar, a.EnumC0456a.Click);
        ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
        if (caVar.field_content == null) {
            AppMethodBeat.o(233776);
            return false;
        }
        k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
        g o = h.o(HD.appId, false, false);
        String d2 = c.d(aVar, caVar);
        if (o != null) {
            c.a(aVar, HD, d2, o, caVar.field_msgSvrId, aVar.getTalkerUserName());
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13043, 2, HD.description, HD.appId);
        c.c(aVar, caVar);
        k(HD, aVar, cVar, caVar);
        AppMethodBeat.o(233776);
        return true;
    }
}
