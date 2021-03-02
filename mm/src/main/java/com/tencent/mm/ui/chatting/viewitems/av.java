package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.g;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i;
import com.tencent.mm.av.p;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.an;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class av {

    public static class b extends c implements t.n {
        private c POe;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 3 && i2 != 23 && i2 != 13 && i2 != 39 && i2 != 33)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37326);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.te);
                view.setTag(new d().G(view, false));
            }
            AppMethodBeat.o(37326);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            boolean z;
            View view;
            int i3;
            boolean b2;
            AppMethodBeat.i(37327);
            this.PhN = aVar2;
            d dVar = (d) aVar;
            boolean containsKey = p.bcF().iZJ.containsKey(Long.valueOf(caVar.field_msgId));
            g U = q.bcR().U(caVar);
            if (U == null || containsKey) {
                z = false;
            } else {
                if (p.bcF().AA(U.localId)) {
                    p.d AB = p.bcF().AB(U.localId);
                    int i4 = (int) AB.total;
                    int i5 = (int) AB.offset;
                    if (i4 == 0) {
                        b2 = true;
                    } else {
                        b2 = i5 == i4 && i4 != 0;
                    }
                } else {
                    b2 = h.b(U);
                }
                z = b2;
            }
            float G = br.G(caVar);
            if (G != 1.0f) {
                jc jcVar = new jc();
                jcVar.emN = caVar.field_msgSvrId;
                jcVar.eLn = (long) caVar.getType();
                jcVar.eQu = (long) br.C(caVar);
                jcVar.ejA = 1;
                jcVar.bfK();
                Log.i("MicroMsg.ChattingItemImgTo", "img need scale:%s, %s", Long.valueOf(caVar.field_msgId), Float.valueOf(G));
            }
            i bcR = q.bcR();
            ImageView imageView = dVar.PKi;
            String str2 = caVar.field_imgPath;
            float density = G * com.tencent.mm.cb.a.getDensity(aVar2.Pwc.getContext());
            int i6 = caVar.fQS;
            int i7 = caVar.fQT;
            ImageView imageView2 = dVar.PLQ;
            if (z) {
                view = null;
            } else {
                view = dVar.POh;
            }
            if (!bcR.a(imageView, str2, density, i6, i7, imageView2, R.drawable.f3080me, 0, view)) {
                dVar.PKi.setImageDrawable(com.tencent.mm.cb.a.l(aVar2.Pwc.getContext(), R.drawable.f3080me));
            }
            if (U != null || containsKey) {
                boolean z2 = z || caVar.field_status == 5;
                if (containsKey) {
                    dVar.POg.setText("0%");
                } else {
                    TextView textView = dVar.POg;
                    StringBuilder sb = new StringBuilder();
                    if (U != null) {
                        int i8 = U.iKP;
                        int i9 = U.offset;
                        if (p.bcF().AA(U.localId)) {
                            p.d AB2 = p.bcF().AB(U.localId);
                            i8 = (int) AB2.total;
                            i9 = (int) AB2.offset;
                        }
                        if (U.bcv()) {
                            g tl = q.bcR().tl(U.iXx);
                            if (p.bcF().AA((long) U.iXx)) {
                                p.d AB3 = p.bcF().AB((long) U.iXx);
                                i8 = (int) AB3.total;
                                i9 = (int) AB3.offset;
                            } else {
                                i8 = tl.iKP;
                                i9 = tl.offset;
                            }
                        }
                        if (i8 > 0) {
                            i3 = i9 >= i8 ? 100 : (i9 * 100) / i8;
                            textView.setText(sb.append(i3).append("%").toString());
                        }
                    }
                    i3 = 0;
                    textView.setText(sb.append(i3).append("%").toString());
                }
                a((c.a) dVar, !z2, false);
                dVar.POg.setVisibility(z2 ? 8 : 0);
                dVar.POh.setVisibility(z2 ? 8 : 0);
            } else {
                dVar.POh.setVisibility(8);
                a((c.a) dVar, false, false);
                dVar.POg.setVisibility(8);
            }
            dVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, caVar.field_talker, (char) 0));
            View view2 = dVar.clickArea;
            if (this.POe == null) {
                this.POe = new c(this.PhN, this);
            }
            this.POe.scene = 0;
            if (br.D(caVar)) {
                this.POe.scene = 2;
            }
            view2.setOnClickListener(this.POe);
            dVar.clickArea.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            dVar.clickArea.setOnLongClickListener(c(aVar2));
            dVar.PKi.setContentDescription(aVar2.Pwc.getMMResources().getString(R.string.az3));
            if (gTW()) {
                a((c.a) dVar, false, false);
                Log.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.field_status));
                if (gTW()) {
                    if (caVar.field_status != 2 || !b((k) aVar2.bh(k.class), caVar.field_msgId)) {
                        if (dVar.PIn != null) {
                            dVar.PIn.setVisibility(8);
                        }
                    } else if (dVar.PIn != null) {
                        dVar.PIn.setVisibility(0);
                    }
                }
            }
            a(i2, dVar, caVar, aVar2.gRI(), false, aVar2.gRM(), aVar2, this);
            av.a(caVar, aVar2, dVar);
            AppMethodBeat.o(37327);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            int i2;
            int i3;
            AppMethodBeat.i(233911);
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable() && view != null) {
                int i4 = ((bq) view.getTag()).position;
                g gVar = null;
                if (caVar.field_msgId > 0) {
                    gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
                }
                if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
                    gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                }
                if (gVar != null && gVar.bcv() && gVar.iKP == 0) {
                    gVar = q.bcR().tl(gVar.iXx);
                }
                if (!br.J(caVar)) {
                    mVar.a(i4, 110, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                }
                if (caVar.field_status == 5) {
                    mVar.a(i4, 103, view.getContext().getString(R.string.b1y), R.raw.icons_filled_refresh);
                }
                if (com.tencent.mm.al.g.aZI() && !this.PhN.gRN()) {
                    mVar.add(i4, 114, 0, view.getContext().getString(R.string.b02));
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i4, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (gVar.status != -1) {
                    MenuItem a2 = mVar.a(i4, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, view.getContext().getString(R.string.ayz), R.raw.icons_filled_pencil);
                    int[] iArr = new int[2];
                    if (view != null) {
                        i3 = view.getWidth();
                        i2 = view.getHeight();
                        view.getLocationOnScreen(iArr);
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i2).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    a2.setIntent(intent);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX || com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                    mVar.a(i4, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (!caVar.gAt() && caVar.gAz() && ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName()))) {
                    mVar.a(i4, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i4, 100, view.getContext().getString(R.string.b05), R.raw.icons_filled_delete);
                }
                if (br.B(caVar) || br.K(caVar) || br.E(caVar)) {
                    mVar.clear();
                    if (!this.PhN.gRN()) {
                        mVar.a(i4, 100, view.getContext().getString(R.string.b05), R.raw.icons_filled_delete);
                    }
                }
                if (br.D(caVar)) {
                    jc jcVar = new jc();
                    jcVar.emN = caVar.field_msgSvrId;
                    jcVar.eLn = (long) caVar.getType();
                    jcVar.eQu = (long) br.C(caVar);
                    jcVar.ejA = 3;
                    jcVar.bfK();
                }
            }
            AppMethodBeat.o(233911);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37329);
            if (100 == menuItem.getItemId()) {
                av.c(caVar, aVar);
            } else if (131 == menuItem.getItemId()) {
                av.b(aVar, menuItem, caVar);
            } else {
                ((an) aVar.bh(an.class)).a(menuItem, caVar);
            }
            AppMethodBeat.o(37329);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        public static void a(c.a aVar, int i2, int i3) {
            AppMethodBeat.i(37330);
            int i4 = i3 > 0 ? i2 >= i3 ? 100 : (int) ((((long) i2) * 100) / ((long) i3)) : 0;
            if (aVar == null) {
                Log.e("MicroMsg.ChattingItemImgTo", "[updateImgUploadProgress] tag is null");
                AppMethodBeat.o(37330);
                return;
            }
            d dVar = (d) aVar;
            if (i4 < 100 || dVar.POg.getVisibility() == 0) {
                dVar.POg.setText(i4 + "%");
                if (gTW()) {
                    a((c.a) dVar, false);
                } else {
                    a((c.a) dVar, true);
                }
                dVar.POg.setVisibility(0);
                dVar.POh.setVisibility(0);
                AppMethodBeat.o(37330);
                return;
            }
            AppMethodBeat.o(37330);
        }

        public static void c(c.a aVar, boolean z) {
            AppMethodBeat.i(37331);
            if (z && (aVar instanceof d)) {
                d dVar = (d) aVar;
                a((c.a) dVar, false);
                dVar.POg.setVisibility(4);
                dVar.POh.setVisibility(4);
            }
            AppMethodBeat.o(37331);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233912);
            caVar.unsetOmittedFailResend();
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
            ((an) aVar.bh(an.class)).bU(caVar);
            AppMethodBeat.o(233912);
        }
    }

    public static class a extends c {
        private c POe;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || (i2 != 39 && i2 != 3 && i2 != 23 && i2 != 13 && i2 != 33)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37320);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s2);
                view.setTag(new d().G(view, true));
            }
            AppMethodBeat.o(37320);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37321);
            this.PhN = aVar2;
            ((com.tencent.mm.ui.chatting.d.b.m) aVar2.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bY(caVar);
            d dVar = (d) aVar;
            float G = br.G(caVar);
            if (G != 1.0f) {
                jc jcVar = new jc();
                jcVar.emN = caVar.field_msgSvrId;
                jcVar.eLn = (long) caVar.getType();
                jcVar.eQu = (long) br.C(caVar);
                jcVar.ejA = 1;
                jcVar.bfK();
                Log.i("MicroMsg.ChattingItemImgFrom", "img need scale:%s, %s", Long.valueOf(caVar.field_msgId), Float.valueOf(G));
            }
            boolean a2 = q.bcR().a(dVar.PKi, caVar.field_imgPath, G * com.tencent.mm.cb.a.getDensity(aVar2.Pwc.getContext()), caVar.fQS, caVar.fQT, dVar.PLQ, R.drawable.f3080me, 1, (View) null);
            dVar.POh.setVisibility(0);
            a((c.a) dVar, false, false);
            if (!a2) {
                dVar.PKi.setImageBitmap(BitmapFactory.decodeResource(aVar2.Pwc.getMMResources(), R.drawable.f3080me));
            }
            String str2 = null;
            if (aVar2.gRM()) {
                str2 = caVar.field_talker;
            }
            dVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, str, str2));
            View view = dVar.clickArea;
            if (this.POe == null) {
                this.POe = new c(this.PhN, this);
            }
            this.POe.scene = 0;
            if (br.D(caVar)) {
                this.POe.scene = 2;
            }
            view.setOnClickListener(this.POe);
            dVar.clickArea.setOnLongClickListener(c(aVar2));
            dVar.clickArea.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            av.a(caVar, aVar2, dVar);
            AppMethodBeat.o(37321);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(37322);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(37322);
            return gRM;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            int i2;
            int i3;
            AppMethodBeat.i(233910);
            bg.aVF();
            if (!(!com.tencent.mm.model.c.isSDCardAvailable() || view == null || caVar == null)) {
                int i4 = ((bq) view.getTag()).position;
                g gVar = null;
                if (caVar.field_msgId > 0) {
                    gVar = q.bcR().H(caVar.field_talker, caVar.field_msgId);
                }
                if ((gVar == null || gVar.localId <= 0) && caVar.field_msgSvrId > 0) {
                    gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                }
                if (!br.J(caVar)) {
                    mVar.a(i4, 110, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                }
                if (com.tencent.mm.al.g.aZI() && !this.PhN.gRN()) {
                    mVar.add(i4, 114, 0, view.getContext().getString(R.string.b02));
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i4, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (!(gVar == null || gVar.status == -1)) {
                    MenuItem a2 = mVar.a(i4, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, view.getContext().getString(R.string.ayz), R.raw.icons_filled_pencil);
                    int[] iArr = new int[2];
                    if (view != null) {
                        i3 = view.getWidth();
                        i2 = view.getHeight();
                        view.getLocationOnScreen(iArr);
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i2).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    a2.setIntent(intent);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX || com.tencent.mm.pluginsdk.model.app.h.ay(this.PhN.Pwc.getContext(), caVar.getType())) {
                    mVar.a(i4, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i4, 100, view.getContext().getString(R.string.b05), R.raw.icons_filled_delete);
                }
                if (br.B(caVar) || br.K(caVar) || br.E(caVar)) {
                    mVar.clear();
                    if (!this.PhN.gRN()) {
                        mVar.a(i4, 100, view.getContext().getString(R.string.b05), R.raw.icons_filled_delete);
                    }
                }
                if (br.D(caVar)) {
                    jc jcVar = new jc();
                    jcVar.emN = caVar.field_msgSvrId;
                    jcVar.eLn = (long) caVar.getType();
                    jcVar.eQu = (long) br.C(caVar);
                    jcVar.ejA = 3;
                    jcVar.bfK();
                }
            }
            AppMethodBeat.o(233910);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37324);
            if (100 == menuItem.getItemId()) {
                av.c(caVar, aVar);
            } else if (131 == menuItem.getItemId()) {
                av.b(aVar, menuItem, caVar);
            } else {
                ((an) aVar.bh(an.class)).a(menuItem, caVar);
            }
            AppMethodBeat.o(37324);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        public static void a(Context context, c.a aVar, ca caVar, boolean z) {
            AppMethodBeat.i(37325);
            if (true != z) {
                AppMethodBeat.o(37325);
                return;
            }
            if (aVar instanceof d) {
                d dVar = (d) aVar;
                q.bcR().a(dVar.PKi, caVar.field_imgPath, com.tencent.mm.cb.a.getDensity(context), caVar.fQS, caVar.fQT, dVar.PLQ, R.drawable.bb3, 1, (View) null);
            }
            AppMethodBeat.o(37325);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d extends c.a {
        ImageView PIn;
        ImageView PKi;
        ImageView PLQ;
        TextView POg;
        View POh;
        TextView tln;

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PKi;
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(37340);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PKi = (ImageView) view.findViewById(R.id.aul);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.POh = view.findViewById(R.id.j10);
            if (z) {
                this.userTV = (TextView) view.findViewById(R.id.ayn);
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.buu);
            } else {
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
                this.POg = (TextView) view.findViewById(R.id.j0z);
                this.userTV = (TextView) view.findViewById(R.id.ayn);
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
            }
            this.PLQ = (ImageView) view.findViewById(R.id.aun);
            this.tln = (TextView) view.findViewById(R.id.atq);
            AppMethodBeat.o(37340);
            return this;
        }
    }

    public static class c extends t.e {
        private c POf;
        private int scene = 0;

        public c(com.tencent.mm.ui.chatting.e.a aVar, c cVar) {
            super(aVar);
            this.POf = cVar;
        }

        public c(com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar, View view) {
            super(aVar);
            AppMethodBeat.i(37333);
            this.POf = cVar;
            this.scene = 1;
            if (this.scene == 1) {
                com.tencent.mm.modelstat.b.jmd.ae(caVar);
                a(new bq(caVar, this.PhN.gRM(), 0, caVar.field_talker, (char) 0), view);
            }
            AppMethodBeat.o(37333);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            com.tencent.mm.pluginsdk.model.app.g o;
            AppMethodBeat.i(37334);
            bq bqVar = (bq) view.getTag();
            com.tencent.mm.modelstat.b.jmd.ae(bqVar.dTX);
            a(bqVar, view);
            k.b HC = k.b.HC(caVar.field_content);
            if (!(HC == null || Util.isNullOrNil(HC.appId) || this.POf == null || (o = com.tencent.mm.pluginsdk.model.app.h.o(HC.appId, false, false)) == null)) {
                c.a(aVar, HC, this.POf instanceof a ? c.d(aVar, caVar) : z.aTY(), o, caVar.field_msgSvrId, aVar.getTalkerUserName());
            }
            c.c(aVar, caVar);
            AppMethodBeat.o(37334);
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(com.tencent.mm.ui.chatting.viewitems.bq r17, android.view.View r18) {
            /*
            // Method dump skipped, instructions count: 573
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.av.c.a(com.tencent.mm.ui.chatting.viewitems.bq, android.view.View):void");
        }

        private void a(long j2, long j3, String str, String str2, int[] iArr, int i2, int i3) {
            String str3;
            int i4;
            Bundle bundle;
            AppMethodBeat.i(37336);
            Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] doGetMsgImg");
            Intent intent = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j2);
            intent.putExtra("show_search_chat_content_result", ((am) this.PhN.bh(am.class)).gQZ());
            intent.putExtra("img_gallery_msg_svr_id", j3);
            intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP());
            intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPc());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i2);
            intent.putExtra("img_gallery_height", i3);
            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
            intent.putExtra("msg_type", this.scene);
            if (this.scene == 1) {
                intent.putExtra("show_enter_grid", false);
            }
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", as.HF(str));
            String talkerUserName = this.PhN.getTalkerUserName();
            Bundle bundle2 = new Bundle();
            if (this.PhN.gRM()) {
                str3 = "stat_scene";
                i4 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (ab.IT(talkerUserName)) {
                    i4 = 7;
                    bundle = bundle2;
                } else {
                    i4 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str3, i4);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j3));
            bundle2.putString("stat_chat_talker_username", talkerUserName);
            bundle2.putString("stat_send_msg_user", str);
            intent.putExtra("_stat_obj", bundle2);
            intent.putExtra("img_gallery_session_id", g(j3, str, talkerUserName));
            com.tencent.mm.ui.chatting.e.a aVar = this.PhN;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            aVar.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "doGetMsgImg", "(JJLjava/lang/String;ILjava/lang/String;[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.PhN.Pwc.overridePendingTransition(0, 0);
            AppMethodBeat.o(37336);
        }

        public static void a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar, long j2, long j3, String str, String str2, int[] iArr, int i2, int i3) {
            AppMethodBeat.i(37337);
            a(aVar, caVar, j2, j3, str, str2, iArr, i2, i3, true, 0);
            AppMethodBeat.o(37337);
        }

        private static void a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar, long j2, long j3, String str, String str2, int[] iArr, int i2, int i3, boolean z, int i4) {
            String str3;
            int i5;
            Bundle bundle;
            AppMethodBeat.i(37338);
            Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
            Intent intent = new Intent(aVar.Pwc.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j2);
            intent.putExtra("img_gallery_msg_svr_id", j3);
            intent.putExtra("show_search_chat_content_result", ((am) aVar.bh(am.class)).gQZ());
            intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP());
            intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPc());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i2);
            intent.putExtra("img_gallery_height", i3);
            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
            intent.putExtra("img_gallery_enter_PhotoEditUI", z);
            intent.putExtra("msg_type", i4);
            if (i4 == 1) {
                intent.putExtra("show_enter_grid", false);
            }
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", as.HF(str));
            String talkerUserName = aVar.getTalkerUserName();
            if (caVar.field_isSend == 1) {
                str = aVar.gRI();
            }
            Bundle bundle2 = new Bundle();
            if (aVar.gRL()) {
                str3 = "stat_scene";
                i5 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (ab.IT(talkerUserName)) {
                    i5 = 7;
                    bundle = bundle2;
                } else {
                    i5 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str3, i5);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j3));
            bundle2.putString("stat_chat_talker_username", talkerUserName);
            bundle2.putString("stat_send_msg_user", str);
            intent.putExtra("_stat_obj", bundle2);
            intent.putExtra("img_gallery_session_id", g(j3, str, talkerUserName));
            BaseChattingUIFragment baseChattingUIFragment = aVar.Pwc;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            baseChattingUIFragment.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/viewitems/ChattingItemImg$ImageClickListener", "showImgGallery", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;JJLjava/lang/String;IZJLjava/lang/String;[IIIZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            aVar.Pwc.overridePendingTransition(0, 0);
            AppMethodBeat.o(37338);
        }

        private static String g(long j2, String str, String str2) {
            AppMethodBeat.i(37339);
            String JX = ad.JX(String.valueOf(j2));
            ad.b G = ad.aVe().G(JX, true);
            G.l("preUsername", str);
            G.l("preChatName", str2);
            int i2 = 3;
            if (com.tencent.mm.al.g.Nc(str2) || as.HF(str2)) {
                i2 = 5;
            }
            G.l("Contact_Sub_Scene", Integer.valueOf(i2));
            G.l("Contact_Scene_Note", str2);
            AppMethodBeat.o(37339);
            return JX;
        }
    }

    static /* synthetic */ void a(ca caVar, com.tencent.mm.ui.chatting.e.a aVar, d dVar) {
        AppMethodBeat.i(233913);
        k.b HC = k.b.HC(caVar.field_content);
        if (HC == null || Util.isNullOrNil(HC.appId)) {
            dVar.tln.setVisibility(8);
            AppMethodBeat.o(233913);
            return;
        }
        String str = HC.appId;
        com.tencent.mm.pluginsdk.model.app.g gE = com.tencent.mm.pluginsdk.model.app.h.gE(str, HC.appVersion);
        if (gE != null) {
            c.b(aVar, HC, caVar);
        }
        String str2 = (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) ? HC.appName : gE.field_appName;
        if (c.gp(str2)) {
            dVar.tln.setText(com.tencent.mm.pluginsdk.model.app.h.a(aVar.Pwc.getContext(), gE, str2));
            dVar.tln.setVisibility(0);
            if (gE == null || !gE.NA()) {
                c.a(aVar, (View) dVar.tln, str);
            } else {
                c.a(aVar, dVar.tln, caVar, HC, gE.field_packageName, caVar.field_msgSvrId);
            }
            c.a(aVar, dVar.tln, str);
            AppMethodBeat.o(233913);
            return;
        }
        dVar.tln.setVisibility(8);
        AppMethodBeat.o(233913);
    }

    static /* synthetic */ void c(ca caVar, com.tencent.mm.ui.chatting.e.a aVar) {
        com.tencent.mm.pluginsdk.model.app.g o;
        com.tencent.mm.plugin.game.api.b dSQ;
        String str;
        AppMethodBeat.i(233914);
        k.b HC = k.b.HC(caVar.field_content);
        if (!(HC == null || Util.isNullOrNil(HC.appId) || (o = com.tencent.mm.pluginsdk.model.app.h.o(HC.appId, false, false)) == null || !o.NA() || (dSQ = b.a.dSQ()) == null)) {
            int i2 = aVar.gRM() ? 2 : 1;
            String d2 = c.d(aVar, caVar);
            Activity context = aVar.Pwc.getContext();
            String str2 = HC.appId;
            if (o == null) {
                str = null;
            } else {
                str = o.field_packageName;
            }
            dSQ.a(context, str2, str, d2, HC.type, HC.mediaTagName, i2);
        }
        AppMethodBeat.o(233914);
    }

    static /* synthetic */ boolean b(com.tencent.mm.ui.chatting.e.a aVar, MenuItem menuItem, ca caVar) {
        g gVar;
        AppMethodBeat.i(233915);
        switch (menuItem.getItemId()) {
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                Log.i("MicroMsg.ChattingItemImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    Log.e("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    AppMethodBeat.o(233915);
                    return true;
                }
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = {intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (aVar.gRL() || ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) {
                    str = caVar.field_talker;
                }
                g gVar2 = null;
                if (caVar.field_msgId > 0) {
                    gVar2 = q.bcR().H(caVar.field_talker, caVar.field_msgId);
                }
                if ((gVar2 == null || gVar2.localId <= 0) && caVar.field_msgSvrId > 0) {
                    gVar = q.bcR().G(caVar.field_talker, caVar.field_msgSvrId);
                } else {
                    gVar = gVar2;
                }
                String o = gVar == null ? "" : q.bcR().o(gVar.iXm, "", "");
                if (gVar == null || gVar.status == -1 || caVar.field_status == 5) {
                    Log.e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", Long.valueOf(caVar.field_msgId));
                } else {
                    Log.i("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(caVar.field_msgId), o);
                    c.a(aVar, caVar, caVar.field_msgId, caVar.field_msgSvrId, caVar.field_talker, str, iArr, intExtra, intExtra2);
                }
                AppMethodBeat.o(233915);
                return true;
            default:
                AppMethodBeat.o(233915);
                return false;
        }
    }
}
