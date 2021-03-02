package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.modelstat.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ag;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class be {

    public static class b extends c {
        private c PPr;
        private com.tencent.mm.ui.chatting.e.a PhN;

        private c cP(ca caVar) {
            AppMethodBeat.i(233946);
            if (this.PPr == null) {
                this.PPr = new c(this.PhN);
            }
            this.PPr.scene = 0;
            if (br.D(caVar)) {
                this.PPr.scene = 2;
            }
            c cVar = this.PPr;
            AppMethodBeat.o(233946);
            return cVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 43 && i2 != 486539313)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37443);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.ti);
                view.setTag(new d().G(view, false));
            }
            AppMethodBeat.o(37443);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37444);
            this.PhN = aVar2;
            d dVar = (d) aVar;
            d.a(dVar, caVar, false, i2, aVar2, cP(caVar), c(aVar2));
            if (gTW()) {
                s QN = u.QN(caVar.field_imgPath);
                if (QN == null || QN.status != 199 || !b((k) aVar2.bh(k.class), caVar.field_msgId)) {
                    if (dVar.PIn != null) {
                        dVar.PIn.setVisibility(8);
                    }
                } else if (dVar.PIn != null) {
                    dVar.PIn.setVisibility(0);
                    AppMethodBeat.o(37444);
                    return;
                }
            }
            AppMethodBeat.o(37444);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233947);
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                if (view == null) {
                    AppMethodBeat.o(233947);
                    return false;
                }
                int i2 = ((bq) view.getTag()).position;
                s Qq = o.bhj().Qq(caVar.field_imgPath);
                MenuItem a2 = mVar.a(i2, 130, view.getContext().getString(R.string.b0b), R.raw.icons_filled_volume_off);
                int width = view.getWidth();
                int height = view.getHeight();
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                a2.setIntent(intent);
                if (Qq != null) {
                    int i3 = Qq.status;
                    if (!(104 == i3 || 103 == i3 || 105 == i3 || 106 == i3)) {
                        mVar.a(i2, 107, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                    }
                } else if (caVar.cWK()) {
                    mVar.a(i2, 107, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                }
                if (Qq != null && (Qq.status == 199 || Qq.status == 199)) {
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                    }
                    ef efVar = new ef();
                    efVar.dHy.msgId = caVar.field_msgId;
                    EventCenter.instance.publish(efVar);
                    if (efVar.dHz.dGX) {
                        mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                    }
                    if (!caVar.gAt() && ((caVar.cWJ() || caVar.cWL()) && b(caVar, this.PhN) && ((Qq.status == 199 || Qq.status == 199 || caVar.fQV == 1) && bnf(caVar.field_talker)))) {
                        mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    }
                    if (g.aZJ() && !this.PhN.gRN()) {
                        mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
                    }
                } else if (caVar.cWK() && com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b07), R.raw.icons_filled_delete);
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
            AppMethodBeat.o(233947);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37446);
            ((av) aVar.bh(av.class)).a(menuItem, caVar);
            AppMethodBeat.o(37446);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37447);
            cP(caVar).onClick(view);
            AppMethodBeat.o(37447);
            return true;
        }
    }

    public static class a extends c {
        private c PPr;
        private com.tencent.mm.ui.chatting.e.a PhN;

        private c cP(ca caVar) {
            AppMethodBeat.i(233944);
            if (this.PPr == null) {
                this.PPr = new c(this.PhN);
            }
            this.PPr.scene = 0;
            if (br.D(caVar)) {
                this.PPr.scene = 2;
            }
            c cVar = this.PPr;
            AppMethodBeat.o(233944);
            return cVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || (i2 != 43 && i2 != 486539313)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37437);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s6);
                view.setTag(new d().G(view, true));
            }
            AppMethodBeat.o(37437);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37438);
            this.PhN = aVar2;
            d.a((d) aVar, caVar, true, i2, aVar2, cP(caVar), c(aVar2));
            AppMethodBeat.o(37438);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233945);
            bg.aVF();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i2 = ((bq) view.getTag()).position;
                s Qq = o.bhj().Qq(caVar.field_imgPath);
                mVar.a(i2, 130, view.getContext().getString(R.string.b0b), R.raw.icons_filled_volume_off);
                mVar.a(i2, 107, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                }
                ef efVar = new ef();
                efVar.dHy.msgId = caVar.field_msgId;
                EventCenter.instance.publish(efVar);
                if (efVar.dHz.dGX) {
                    mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
                }
                if (Qq != null && ((Qq.status == 199 || Qq.status == 199) && g.aZJ() && !this.PhN.gRN())) {
                    mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
                }
                if (br.B(caVar) || br.E(caVar)) {
                    mVar.clear();
                    mVar.a(i2, 130, view.getContext().getString(R.string.b0b), R.raw.icons_filled_volume_off);
                }
                if (!this.PhN.gRN()) {
                    mVar.a(i2, 100, view.getContext().getString(R.string.b07), R.raw.icons_filled_delete);
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
            AppMethodBeat.o(233945);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37440);
            ((av) aVar.bh(av.class)).a(menuItem, caVar);
            AppMethodBeat.o(37440);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37441);
            cP(caVar).onClick(view);
            AppMethodBeat.o(37441);
            return true;
        }
    }

    public static class d extends c.a {
        private static Map<String, WeakReference<d>> PKm = new HashMap();
        private static SparseArray<String> PPz = new SparseArray<>();
        TextView Bvi;
        ImageView EeS;
        View Gpy;
        ImageView PHO;
        ImageView PHW;
        ImageView PHX;
        ImageView PIn;
        ImageView PKi;
        ImageView PLQ;
        TextView PPt;
        MMPinProgressBtn PPu;
        View PPv;
        LinearLayout PPw;
        ProgressBar PPx;
        View PPy;
        TextView tln;

        static {
            AppMethodBeat.i(37464);
            AppMethodBeat.o(37464);
        }

        public static boolean b(t.a.C0460a aVar) {
            AppMethodBeat.i(37461);
            if (aVar.jsH != t.a.b.UPDATE) {
                AppMethodBeat.o(37461);
                return false;
            }
            final s QN = u.QN(aVar.fileName);
            if (QN == null) {
                Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", aVar.fileName);
                AppMethodBeat.o(37461);
                return false;
            } else if (QN.status == 112 || QN.status == 104 || QN.status == 103) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.viewitems.be.d.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(37457);
                        WeakReference weakReference = (WeakReference) d.PKm.get(QN.getFileName());
                        if (weakReference == null) {
                            Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", QN.getFileName());
                            AppMethodBeat.o(37457);
                            return;
                        }
                        d dVar = (d) weakReference.get();
                        if (dVar == null) {
                            Log.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", QN.getFileName());
                            AppMethodBeat.o(37457);
                            return;
                        }
                        dVar.PHW.setVisibility(8);
                        dVar.EeS.setVisibility(8);
                        dVar.PPu.setVisibility(0);
                        int i2 = QN.status;
                        Log.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i2)));
                        if (i2 == 112 || i2 == 122 || i2 == 120) {
                            dVar.PPu.setProgress(u.g(QN));
                            AppMethodBeat.o(37457);
                            return;
                        }
                        dVar.PPu.setProgress(u.h(QN));
                        AppMethodBeat.o(37457);
                    }
                });
                AppMethodBeat.o(37461);
                return true;
            } else {
                AppMethodBeat.o(37461);
                return false;
            }
        }

        public final c.a G(View view, boolean z) {
            ImageView imageView;
            ProgressBar progressBar;
            View view2 = null;
            AppMethodBeat.i(37462);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PKi = (ImageView) view.findViewById(R.id.aul);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.Bvi = (TextView) view.findViewById(R.id.ay8);
            this.PPt = (TextView) view.findViewById(R.id.awu);
            this.EeS = (ImageView) view.findViewById(R.id.ayc);
            this.PHW = (ImageView) view.findViewById(R.id.aup);
            this.PHX = (ImageView) view.findViewById(R.id.aye);
            this.PPu = (MMPinProgressBtn) view.findViewById(R.id.aut);
            this.PPv = view.findViewById(R.id.ayq);
            this.clickArea = view.findViewById(R.id.auf);
            this.tln = (TextView) view.findViewById(R.id.ayu);
            this.PHO = (ImageView) view.findViewById(R.id.ayt);
            this.Gpy = view.findViewById(R.id.ays);
            this.PPw = (LinearLayout) view.findViewById(R.id.j47);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.PLQ = (ImageView) view.findViewById(R.id.aun);
            if (!z) {
                imageView = (ImageView) view.findViewById(R.id.ayd);
            } else {
                imageView = null;
            }
            this.PIn = imageView;
            if (!z) {
                progressBar = (ProgressBar) view.findViewById(R.id.ayr);
            } else {
                progressBar = null;
            }
            this.PPx = progressBar;
            if (!z) {
                view2 = view.findViewById(R.id.j10);
            }
            this.PPy = view2;
            AppMethodBeat.o(37462);
            return this;
        }

        public static void a(d dVar, ca caVar, final boolean z, int i2, com.tencent.mm.ui.chatting.e.a aVar, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
            s sVar;
            Bitmap a2;
            int i3;
            AppMethodBeat.i(37463);
            String str = PPz.get(dVar.hashCode());
            if (str != null) {
                PKm.remove(str);
            }
            PPz.put(dVar.hashCode(), caVar.field_imgPath);
            PKm.put(caVar.field_imgPath, new WeakReference<>(dVar));
            s QN = u.QN(caVar.field_imgPath);
            if (QN == null) {
                sVar = new s();
            } else {
                sVar = QN;
            }
            o.bhj();
            String Qx = t.Qx(caVar.field_imgPath);
            y yVar = null;
            if (caVar.cWK()) {
                k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
                String bdu = com.tencent.mm.pluginsdk.model.s.bdu(aD.thumburl);
                i bcR = q.bcR();
                float density = com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext());
                aVar.Pwc.getContext();
                Bitmap a3 = bcR.a(bdu, density, R.drawable.c3h);
                if (!(a3 != null || aD == null || caVar == null)) {
                    final WeakReference weakReference = new WeakReference(aVar);
                    com.tencent.mm.av.a.a bcV = q.bcV();
                    String str2 = aD.thumburl;
                    c.a aVar2 = new c.a();
                    aVar2.fullPath = bdu;
                    aVar2.jbf = true;
                    bcV.a(str2, aVar2.bdv(), new com.tencent.mm.av.a.c.d() {
                        /* class com.tencent.mm.ui.chatting.viewitems.be.d.AnonymousClass2 */

                        @Override // com.tencent.mm.av.a.c.d
                        public final void a(boolean z, Object... objArr) {
                            AppMethodBeat.i(233949);
                            if (z) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.be.d.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(37458);
                                        if (!(weakReference.get() == null || ((com.tencent.mm.ui.chatting.e.a) weakReference.get()).Pwc.getContext() == null || ((com.tencent.mm.ui.chatting.e.a) weakReference.get()).Pwc.getContext().isFinishing())) {
                                            ((com.tencent.mm.ui.chatting.e.a) weakReference.get()).cmy();
                                        }
                                        AppMethodBeat.o(37458);
                                    }
                                });
                            }
                            AppMethodBeat.o(233949);
                        }
                    });
                }
                com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) aD.as(com.tencent.mm.ag.e.class);
                if (!(eVar == null || eVar.iwi == null)) {
                    y yVar2 = eVar.iwi;
                    sVar.iFw = yVar2.videoDuration;
                    yVar = yVar2;
                }
                dVar.Gpy.setVisibility(0);
                al.a(aVar.Pwc.getContext(), aD, dVar.PHO, dVar.tln);
                f gPr = ((com.tencent.mm.ui.chatting.d.b.c) aVar.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPr();
                if (gPr == null || !gPr.Kbu) {
                    dVar.Gpy.setBackgroundResource(R.drawable.on);
                    dVar.tln.setTextColor(com.tencent.mm.cb.a.n(aVar.Pwc.getContext(), R.color.BW_0_Alpha_0_3));
                } else {
                    dVar.Gpy.setBackgroundResource(R.drawable.oo);
                    dVar.tln.setTextColor(com.tencent.mm.cb.a.n(aVar.Pwc.getContext(), R.color.BW_0_Alpha_0_5));
                }
                dVar.Gpy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(dVar) {
                    /* class com.tencent.mm.ui.chatting.viewitems.be.d.AnonymousClass3 */
                    final /* synthetic */ d PPC;

                    {
                        this.PPC = r1;
                    }

                    public final boolean onPreDraw() {
                        AppMethodBeat.i(37460);
                        this.PPC.Gpy.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.PPC.PPw.setGravity((this.PPC.Gpy.getWidth() <= this.PPC.clickArea.getWidth() || z) ? 3 : 5);
                        AppMethodBeat.o(37460);
                        return true;
                    }
                });
                a2 = a3;
            } else {
                dVar.Gpy.setVisibility(8);
                float G = br.G(caVar);
                if (G != 1.0f) {
                    jc jcVar = new jc();
                    jcVar.emN = caVar.field_msgSvrId;
                    jcVar.eLn = (long) caVar.getType();
                    jcVar.eQu = (long) br.C(caVar);
                    jcVar.ejA = 1;
                    jcVar.bfK();
                }
                i bcR2 = q.bcR();
                float density2 = G * com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext());
                aVar.Pwc.getContext();
                a2 = bcR2.a(Qx, density2, R.drawable.c3h);
            }
            dVar.PLQ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            if (a2 == null) {
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 85);
                int aG = com.tencent.mm.cb.a.aG(aVar.Pwc.getContext(), R.dimen.a6);
                if (!caVar.cWK() || yVar == null || yVar.width <= 0 || yVar.height <= 0) {
                    i3 = fromDPToPix;
                } else if (yVar.width >= yVar.height) {
                    int fromDPToPix2 = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), i.iYg);
                    aG = (int) ((((float) yVar.height) / ((float) yVar.width)) * ((float) fromDPToPix2));
                    i3 = fromDPToPix2;
                } else {
                    int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), i.iYg);
                    aG = (int) ((((float) yVar.width) / ((float) yVar.height)) * ((float) fromDPToPix3));
                    i3 = fromDPToPix3;
                }
                Bitmap createMaskImage = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(aVar.Pwc.getContext().getResources().getColor(R.color.u6), i3, aG), R.drawable.c3h, i3, aG);
                bg.aVF();
                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                    dVar.PKi.setImageDrawable(com.tencent.mm.cb.a.l(aVar.Pwc.getContext(), R.raw.video_no_sd_icon));
                    dVar.PKi.setBackground(new BitmapDrawable(createMaskImage));
                } else {
                    dVar.PKi.setImageBitmap(BitmapUtil.createMaskImage(createMaskImage, R.drawable.c3h, i3, aG));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, aG);
                dVar.PLQ.setLayoutParams(layoutParams);
                if (dVar.PPy != null) {
                    dVar.PPy.setLayoutParams(layoutParams);
                }
            } else {
                dVar.PKi.setImageBitmap(a2);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2.getWidth(), a2.getHeight());
                dVar.PLQ.setLayoutParams(layoutParams2);
                if (dVar.PPy != null) {
                    dVar.PPy.setLayoutParams(layoutParams2);
                }
            }
            if (z) {
                dVar.Bvi.setText(af.getSizeKB((long) sVar.iKP));
                dVar.PPt.setText(af.formatSecToMin(sVar.iFw));
                int i4 = sVar.status;
                Log.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + i4 + " info : " + sVar.getFileName());
                if (i4 == 199) {
                    dVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(aVar.Pwc.getContext(), R.raw.shortvideo_play_btn));
                } else {
                    dVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(aVar.Pwc.getContext(), R.raw.shortvideo_play_btn));
                    dVar.Bvi.setVisibility(8);
                }
                if (i4 == 112 || i4 == 122 || i4 == 120) {
                    dVar.PHW.setVisibility(8);
                    dVar.EeS.setVisibility(8);
                    dVar.PPu.setVisibility(0);
                    dVar.PPu.setProgress(u.g(sVar));
                    Log.v("MicroMsg.VideoItemHoder", "status begin");
                    dVar.PPu.invalidate();
                } else if (i4 == 113 || i4 == 198 || sVar.bhw()) {
                    dVar.PHW.setVisibility(0);
                    dVar.PHX.setVisibility(8);
                    dVar.PPu.setVisibility(8);
                    dVar.EeS.setVisibility(0);
                    Log.v("MicroMsg.VideoItemHoder", "status pause");
                } else {
                    dVar.PHX.setVisibility(8);
                    dVar.PHW.setVisibility(8);
                    dVar.PPu.setVisibility(8);
                    dVar.EeS.setVisibility(0);
                    Log.v("MicroMsg.VideoItemHoder", "status gone");
                }
            } else {
                dVar.Bvi.setText(af.getSizeKB((long) sVar.iKP));
                dVar.PPt.setText(af.formatSecToMin(sVar.iFw));
                int i5 = sVar.status;
                dVar.EeS.setImageDrawable(com.tencent.mm.cb.a.l(aVar.Pwc.getContext(), R.raw.shortvideo_play_btn));
                if (dVar.PPx != null) {
                    dVar.PPx.setVisibility(8);
                }
                if (dVar.PPy != null) {
                    dVar.PPy.setVisibility(8);
                }
                Log.v("MicroMsg.VideoItemHoder", "video status %d", Integer.valueOf(i5));
                if (i5 == 104 || i5 == 103) {
                    if (com.tencent.mm.plugin.mmsight.c.QG(sVar.jso)) {
                        if (dVar.PPx != null) {
                            dVar.PPx.setVisibility(0);
                        }
                        if (dVar.PPy != null) {
                            dVar.PPy.setVisibility(0);
                        }
                        dVar.PPt.setText((CharSequence) null);
                        dVar.Bvi.setText((CharSequence) null);
                        dVar.EeS.setImageDrawable(null);
                        dVar.PHX.setVisibility(8);
                        dVar.PHW.setVisibility(8);
                        dVar.PPu.setVisibility(8);
                    } else {
                        if (dVar.PPx != null) {
                            dVar.PPx.setVisibility(8);
                        }
                        if (dVar.PPy != null) {
                            dVar.PPy.setVisibility(8);
                        }
                        dVar.PHW.setVisibility(8);
                        dVar.EeS.setVisibility(8);
                        dVar.PPu.setVisibility(0);
                        dVar.PPu.setProgress(u.h(sVar));
                    }
                    Log.v("MicroMsg.VideoItemHoder", "status begin");
                } else if (i5 == 105 || i5 == 198 || sVar.bhw()) {
                    dVar.PHW.setVisibility(0);
                    dVar.PHX.setVisibility(8);
                    dVar.PPu.setVisibility(8);
                    dVar.EeS.setVisibility(0);
                    Log.v("MicroMsg.VideoItemHoder", "status pause");
                } else if (i5 != 106) {
                    dVar.PHX.setVisibility(8);
                    dVar.PHW.setVisibility(8);
                    dVar.PPu.setVisibility(8);
                    dVar.EeS.setVisibility(0);
                    Log.v("MicroMsg.VideoItemHoder", "status gone");
                } else if (!com.tencent.mm.pluginsdk.model.m.bdr(caVar.field_imgPath)) {
                    u.QE(caVar.field_imgPath);
                } else {
                    if (dVar.PPx != null) {
                        dVar.PPx.setVisibility(0);
                    }
                    if (dVar.PPy != null) {
                        dVar.PPy.setVisibility(0);
                    }
                    dVar.PPt.setText((CharSequence) null);
                    dVar.Bvi.setText((CharSequence) null);
                    dVar.EeS.setImageDrawable(null);
                    dVar.PHX.setVisibility(8);
                    dVar.PHW.setVisibility(8);
                    dVar.PPu.setVisibility(8);
                }
            }
            ImageView imageView = dVar.PHX;
            e eVar2 = new e(caVar, aVar.gRM(), i2, caVar.field_talker);
            eVar2.qcr = 4;
            imageView.setTag(eVar2);
            dVar.PHX.setOnClickListener(onClickListener);
            ImageView imageView2 = dVar.PHW;
            e eVar3 = new e(caVar, aVar.gRM(), i2, caVar.field_talker);
            eVar3.qcr = 3;
            imageView2.setTag(eVar3);
            dVar.PHW.setOnClickListener(onClickListener);
            View view = dVar.clickArea;
            e eVar4 = new e(caVar, aVar.gRM(), i2, caVar.field_talker);
            eVar4.qcr = 2;
            view.setTag(eVar4);
            dVar.clickArea.setOnClickListener(onClickListener);
            dVar.clickArea.setOnLongClickListener(onLongClickListener);
            dVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            AppMethodBeat.o(37463);
        }
    }

    /* access modifiers changed from: protected */
    public static class e extends bq {
        int qcr;

        public e(ca caVar, boolean z, int i2, String str) {
            super(caVar, z, i2, str, (char) 0);
        }
    }

    public static class c extends t.e {
        public static boolean PAp = false;
        private int scene;

        public c(com.tencent.mm.ui.chatting.e.a aVar) {
            super(aVar);
            this.scene = 0;
        }

        public c(com.tencent.mm.ui.chatting.e.a aVar, ca caVar, View view) {
            super(aVar);
            AppMethodBeat.i(37449);
            this.scene = 0;
            this.scene = 1;
            if (this.scene == 1) {
                com.tencent.mm.modelstat.b.jmd.ae(caVar);
                e eVar = new e(caVar, this.PhN.gRM(), 0, caVar.field_talker);
                eVar.qcr = 2;
                a(eVar, view);
            }
            AppMethodBeat.o(37449);
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37450);
            bq bqVar = (bq) view.getTag();
            com.tencent.mm.modelstat.b.jmd.ae(bqVar.dTX);
            a((e) bqVar, view);
            AppMethodBeat.o(37450);
        }

        private void a(e eVar, View view) {
            AppMethodBeat.i(37451);
            com.tencent.mm.modelstat.a.a(eVar.dTX, a.EnumC0456a.Click);
            if (2 != eVar.qcr) {
                ca caVar = eVar.dTX;
                if (caVar.field_isSend == 0) {
                    a(eVar);
                }
                if (caVar.field_isSend == 1) {
                    b(eVar);
                }
                AppMethodBeat.o(37451);
            } else if (com.tencent.mm.q.a.cC(this.PhN.Pwc.getContext()) || com.tencent.mm.q.a.cA(this.PhN.Pwc.getContext()) || com.tencent.mm.q.a.cE(this.PhN.Pwc.getContext())) {
                Log.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
                AppMethodBeat.o(37451);
            } else {
                ca caVar2 = eVar.dTX;
                int[] iArr = new int[2];
                int i2 = 0;
                int i3 = 0;
                if (view != null) {
                    view.getLocationOnScreen(iArr);
                    i2 = view.getWidth();
                    i3 = view.getHeight();
                }
                a(caVar2, caVar2.field_msgId, caVar2.field_msgSvrId, eVar.userName, eVar.chatroomName, iArr, i2, i3, this.scene);
                if (caVar2.cWL() && eVar.userName != null) {
                    com.tencent.mm.ui.chatting.a.a(a.EnumC2087a.EnterFullScreen, caVar2);
                    if (eVar.userName.toLowerCase().endsWith("@chatroom")) {
                        h.INSTANCE.a(11444, 2);
                        AppMethodBeat.o(37451);
                        return;
                    }
                    h.INSTANCE.a(11444, 1);
                }
                AppMethodBeat.o(37451);
            }
        }

        private void a(e eVar) {
            AppMethodBeat.i(37452);
            ca caVar = eVar.dTX;
            s QN = u.QN(caVar.field_imgPath);
            Log.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + QN.status + " is sender:" + caVar.field_isSend);
            switch (eVar.qcr) {
                case 4:
                    bg.aVF();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
                        AppMethodBeat.o(37452);
                        return;
                    }
                    u.QJ(caVar.field_imgPath);
                    AppMethodBeat.o(37452);
                    return;
                case 3:
                    i(QN);
                    break;
            }
            AppMethodBeat.o(37452);
        }

        private void i(final s sVar) {
            AppMethodBeat.i(37453);
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
                AppMethodBeat.o(37453);
            } else if (sVar.status == 198) {
                u.QK(sVar.getFileName());
                AppMethodBeat.o(37453);
            } else if (ag.dm(this.PhN.Pwc.getContext()) || PAp) {
                u.QI(sVar.getFileName());
                AppMethodBeat.o(37453);
            } else {
                PAp = true;
                com.tencent.mm.ui.base.h.a(this.PhN.Pwc.getContext(), (int) R.string.hwn, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.be.c.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(37448);
                        c.bnm(sVar.getFileName());
                        AppMethodBeat.o(37448);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.be.c.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(37453);
            }
        }

        private void b(e eVar) {
            AppMethodBeat.i(37454);
            ca caVar = eVar.dTX;
            if (caVar == null) {
                Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
                AppMethodBeat.o(37454);
                return;
            }
            s Qq = o.bhj().Qq(caVar.field_imgPath);
            if (Qq == null) {
                Log.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", caVar.field_imgPath);
                AppMethodBeat.o(37454);
                return;
            }
            int i2 = Qq.status;
            Log.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i2)));
            switch (eVar.qcr) {
                case 4:
                    bg.aVF();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
                        AppMethodBeat.o(37454);
                        return;
                    } else if (i2 == 112) {
                        Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
                        u.QJ(caVar.field_imgPath);
                        AppMethodBeat.o(37454);
                        return;
                    } else {
                        u.QH(caVar.field_imgPath);
                        Log.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
                        tx txVar = new tx();
                        txVar.ear.dCM = caVar;
                        EventCenter.instance.publish(txVar);
                        AppMethodBeat.o(37454);
                        return;
                    }
                case 3:
                    bg.aVF();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        if (i2 != 113) {
                            if (!Qq.bhw()) {
                                caVar.unsetOmittedFailResend();
                                bg.aVF();
                                com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                                if (Qq.status != 198) {
                                    u.QG(caVar.field_imgPath);
                                    break;
                                } else {
                                    u.QL(caVar.field_imgPath);
                                    AppMethodBeat.o(37454);
                                    return;
                                }
                            } else {
                                Log.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
                                String string = this.PhN.Pwc.getContext().getString(R.string.hwl);
                                if (i2 == 142) {
                                    string = this.PhN.Pwc.getContext().getString(R.string.hwl);
                                } else if (i2 == 141) {
                                    string = this.PhN.Pwc.getContext().getString(R.string.hwm);
                                } else if (i2 == 140) {
                                    string = this.PhN.Pwc.getContext().getString(R.string.hwk);
                                }
                                com.tencent.mm.ui.base.h.c(this.PhN.Pwc.getContext(), string, this.PhN.Pwc.getContext().getString(R.string.hoz), true);
                                AppMethodBeat.o(37454);
                                return;
                            }
                        } else {
                            Log.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
                            i(Qq);
                            AppMethodBeat.o(37454);
                            return;
                        }
                    } else {
                        com.tencent.mm.ui.base.u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
                        AppMethodBeat.o(37454);
                        return;
                    }
            }
            AppMethodBeat.o(37454);
        }

        private boolean a(ca caVar, long j2, long j3, String str, String str2, int[] iArr, int i2, int i3, int i4) {
            String str3;
            int i5;
            Bundle bundle;
            AppMethodBeat.i(37455);
            Log.i("MicroMsg.DesignerClickListener", "[ImageGalleryUI] showImgGallery");
            Intent intent = new Intent(this.PhN.Pwc.getContext(), ImageGalleryUI.class);
            intent.putExtra("show_search_chat_content_result", ((am) this.PhN.bh(am.class)).gQZ());
            intent.putExtra("img_gallery_msg_id", j2);
            intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP());
            intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.d.b.d) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gPc());
            intent.putExtra("img_gallery_msg_svr_id", j3);
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i2);
            intent.putExtra("img_gallery_height", i3);
            intent.putExtra("KOpenArticleSceneFromScene", 1);
            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
            intent.putExtra("msg_type", i4);
            if (i4 == 1) {
                intent.putExtra("show_enter_grid", false);
            }
            String talkerUserName = this.PhN.getTalkerUserName();
            if (caVar.field_isSend == 1) {
                str = this.PhN.gRI();
            }
            Bundle bundle2 = new Bundle();
            if (this.PhN.gRM()) {
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
            if (caVar.cWK()) {
                intent.putExtra("img_gallery_mp_video_click_from", 2);
            }
            com.tencent.mm.ui.chatting.e.a aVar = this.PhN;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            aVar.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVideo$VideoClickListener", "showImgGallery", "(Lcom/tencent/mm/storage/MsgInfo;JJLjava/lang/String;Ljava/lang/String;[IIII)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.PhN.Pwc.overridePendingTransition(0, 0);
            AppMethodBeat.o(37455);
            return true;
        }

        static /* synthetic */ void bnm(String str) {
            AppMethodBeat.i(233948);
            u.QI(str);
            AppMethodBeat.o(233948);
        }
    }
}
