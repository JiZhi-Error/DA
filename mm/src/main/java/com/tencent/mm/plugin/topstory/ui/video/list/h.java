package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Iterator;
import java.util.UUID;

public final class h extends com.tencent.mm.plugin.topstory.ui.video.h implements a {
    public ImageView GmA;
    public TextView GoH;
    public View GoM;
    public View GoN;
    public View GoO;
    public TextView GoP;
    public TextView GoQ;
    public ImageView GoR;
    public ImageView GoS;
    public View GoT;
    public FrameLayout GoZ;
    public f GpP;
    public View GpQ;
    public ImageView GpR;
    public View GpS;
    public View GpT;
    public View GpU;
    public TextView GpV;
    public View GpW;
    public TextView GpX;
    public ImageView GpY;
    private boolean GpZ;
    public View Gpw;
    public View Gpx;
    public MMNeat7extView pIO;
    public View psf;
    public View rAO;
    public TextView xYx;

    public h(View view, b bVar, boolean z) {
        super(view, bVar);
        this.GpZ = z;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void fU(View view) {
        AppMethodBeat.i(126488);
        super.fU(view);
        this.GoZ = (FrameLayout) view.findViewById(R.id.j6z);
        this.GmA = (ImageView) view.findViewById(R.id.i2z);
        this.xYx = (TextView) view.findViewById(R.id.i34);
        this.pIO = (MMNeat7extView) view.findViewById(R.id.ir3);
        this.GoT = view.findViewById(R.id.i2y);
        this.rAO = view.findViewById(R.id.hpi);
        this.GpQ = view.findViewById(R.id.jox);
        this.GpR = (ImageView) view.findViewById(R.id.jow);
        this.GoH = (TextView) view.findViewById(R.id.jov);
        this.Gpx = view.findViewById(R.id.fk6);
        this.Gpw = view.findViewById(R.id.fki);
        this.GoM = view.findViewById(R.id.abg);
        this.GpV = (TextView) view.findViewById(R.id.aai);
        this.GoN = view.findViewById(R.id.igp);
        this.GoO = view.findViewById(R.id.igt);
        this.GpW = view.findViewById(R.id.igx);
        this.GoP = (TextView) view.findViewById(R.id.igq);
        this.GoQ = (TextView) view.findViewById(R.id.igu);
        this.GpX = (TextView) view.findViewById(R.id.igy);
        this.GoR = (ImageView) view.findViewById(R.id.igo);
        this.GoS = (ImageView) view.findViewById(R.id.igs);
        this.GpY = (ImageView) view.findViewById(R.id.igw);
        this.GpS = view.findViewById(R.id.a_v);
        this.GpT = view.findViewById(R.id.doi);
        this.GpU = view.findViewById(R.id.d8n);
        this.psf = view.findViewById(R.id.d8j);
        if (this.GpZ) {
            this.GoM.setVisibility(0);
            AppMethodBeat.o(126488);
            return;
        }
        this.GoM.setVisibility(8);
        AppMethodBeat.o(126488);
    }

    public final void dhM() {
        AppMethodBeat.i(126489);
        Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "showMaskView %d", Integer.valueOf(hashCode()));
        this.GpU.animate().cancel();
        this.GpT.animate().cancel();
        this.GpS.animate().cancel();
        this.GpS.setAlpha(0.8f);
        this.GpU.setAlpha(0.8f);
        this.GpT.setAlpha(0.8f);
        AppMethodBeat.o(126489);
    }

    public final void fzR() {
        AppMethodBeat.i(126490);
        Log.d("MicroMsg.TopStory.TopStoryListVideoItemHolder", "hideMaskView %d", Integer.valueOf(hashCode()));
        this.GpU.animate().cancel();
        this.GpT.animate().cancel();
        this.GpS.animate().cancel();
        this.GpS.setAlpha(0.0f);
        this.GpU.setAlpha(0.0f);
        this.GpT.setAlpha(0.0f);
        AppMethodBeat.o(126490);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.a, com.tencent.mm.plugin.topstory.ui.video.h
    public final void fyy() {
        AppMethodBeat.i(126491);
        super.fyy();
        this.GpU.animate().cancel();
        this.GpT.animate().cancel();
        this.GpU.setAlpha(0.0f);
        this.GpT.setAlpha(0.0f);
        AppMethodBeat.o(126491);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.a, com.tencent.mm.plugin.topstory.ui.video.h
    public final void fyx() {
        AppMethodBeat.i(126492);
        super.fyx();
        AppMethodBeat.o(126492);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final boolean fzi() {
        AppMethodBeat.i(126493);
        if (this.GpU.getAlpha() == 0.0f || this.GpT.getAlpha() == 0.0f) {
            AppMethodBeat.o(126493);
            return false;
        }
        AppMethodBeat.o(126493);
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void wu(boolean z) {
        AppMethodBeat.i(126494);
        super.wu(z);
        fzR();
        this.Gmr.abV(fyz());
        if (this.GpP.ay(z, false)) {
            fyy();
            super.fyx();
        }
        AppMethodBeat.o(126494);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void fzj() {
        AppMethodBeat.i(126495);
        if (!Util.isNullOrNil(this.GjH.title)) {
            this.pIO.aw(this.GjH.title);
            this.pIO.setVisibility(0);
            this.pIO.requestLayout();
        } else {
            this.pIO.setVisibility(8);
        }
        this.pIO.setOnClickListener(this.ko);
        this.xYx.setText(this.GjH.source);
        if (n.i(this.GjH)) {
            this.GoT.setVisibility(0);
        } else {
            this.GoT.setVisibility(8);
        }
        this.GmA.setOnClickListener(this.ko);
        this.xYx.setOnClickListener(this.ko);
        this.GoT.setOnClickListener(this.ko);
        if (!Util.isNullOrNil(this.GjH.MwR)) {
            q.bcV().a(this.GjH.MwR, this.GmA, c.GjU);
        } else {
            this.GmA.setImageResource(R.drawable.bca);
        }
        if (this.Gmr.fyI()) {
            this.rAO.setVisibility(0);
            this.rAO.setOnClickListener(this.ko);
        } else {
            this.rAO.setVisibility(8);
        }
        if (this.Gmr.fyJ()) {
            this.Gpw.setTag(this.GjH);
            this.Gpw.setOnClickListener(this.ko);
            this.Gpw.setVisibility(0);
            this.Gpx.setVisibility(0);
        } else {
            this.Gpw.setVisibility(8);
            this.Gpx.setVisibility(8);
        }
        this.Gpw.setTag(this.GjH);
        this.Gpw.setOnClickListener(this.ko);
        this.psf.setOnClickListener(this.ko);
        this.GpS.setVisibility(0);
        this.GpT.setVisibility(0);
        this.GpU.setVisibility(0);
        if (this.GpP == null) {
            this.GpP = new f(this.Gmr.eeF(), this.Gmr, this);
            this.GoZ.removeAllViews();
            FrameLayout frameLayout = this.GoZ;
            f fVar = this.GpP;
            Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "lxl getVideoViewLayoutParams: %s, %s", Integer.valueOf(this.Gmr.getVideoWidth()), Integer.valueOf(this.Gmr.getVideoHeight()));
            frameLayout.addView(fVar, new FrameLayout.LayoutParams(this.Gmr.getVideoWidth(), this.Gmr.getVideoHeight()));
        }
        this.GpP.a(this.GjH, fyz());
        if (this.Gmr.fyH() == fyz()) {
            super.fyx();
        }
        this.GpV.setText(this.GjH.xDQ);
        if (!this.GpZ || this.GjH.xuO.size() <= 0) {
            this.GoM.setVisibility(8);
        } else {
            this.GoM.setVisibility(0);
            dyi dyi = this.GjH.xuO.get(0);
            this.GoP.setTag(dyi);
            this.GoP.setText(dyi.dQx);
            this.GoP.setVisibility(0);
            this.GoP.setOnClickListener(this.ko);
            this.GoN.setVisibility(0);
            this.GoR.setVisibility(8);
            if (!Util.isNullOrNil(dyi.icon)) {
                q.bcV().a(dyi.icon, this.GoR, c.GjV);
                this.GoR.setVisibility(0);
            }
            if (this.GjH.xuO.size() > 1) {
                dyi dyi2 = this.GjH.xuO.get(1);
                this.GoQ.setTag(dyi2);
                this.GoQ.setText(dyi2.dQx);
                this.GoQ.setOnClickListener(this.ko);
                this.GoQ.setVisibility(0);
                this.GoO.setVisibility(0);
                this.GoS.setVisibility(8);
                if (!Util.isNullOrNil(dyi2.icon)) {
                    q.bcV().a(dyi2.icon, this.GoS, c.GjV);
                    this.GoS.setVisibility(0);
                }
            } else {
                this.GoO.setVisibility(8);
                this.GoQ.setVisibility(8);
            }
            if (this.GjH.xuO.size() > 2) {
                dyi dyi3 = this.GjH.xuO.get(2);
                this.GpX.setTag(dyi3);
                this.GpX.setText(dyi3.dQx);
                this.GpX.setOnClickListener(this.ko);
                this.GpX.setVisibility(0);
                this.GpW.setVisibility(0);
                this.GpY.setVisibility(8);
                if (!Util.isNullOrNil(dyi3.icon)) {
                    q.bcV().a(dyi3.icon, this.GpY, c.GjV);
                    this.GpY.setVisibility(0);
                }
            } else {
                this.GpW.setVisibility(8);
                this.GpX.setVisibility(8);
            }
        }
        if (this.Gmr.fyH() != fyz()) {
            dhM();
        }
        if ((this.GjH.Nix & 128) > 0) {
            this.GpQ.setVisibility(0);
            this.GpQ.setOnClickListener(this.ko);
            if (this.GjH.NiC) {
                this.GpR.setImageResource(R.raw.top_story_wow_selected);
                this.GoH.setTextColor(this.GoH.getResources().getColor(R.color.ac7));
            } else {
                this.GpR.setImageResource(R.raw.top_story_wow_unselected);
                this.GoH.setTextColor(this.GoH.getResources().getColor(R.color.ag2));
            }
            this.GoH.setText(c.abR(this.GjH.NiH));
            AppMethodBeat.o(126495);
            return;
        }
        this.GpQ.setVisibility(8);
        AppMethodBeat.o(126495);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final f fzk() {
        return this.GpP;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void fV(View view) {
        AppMethodBeat.i(126496);
        if (com.tencent.mm.plugin.topstory.a.h.fxR() && view.getId() == this.pIO.getId()) {
            this.Gmr.fyF().Gob = true;
        }
        super.fV(view);
        AppMethodBeat.o(126496);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final void fW(View view) {
        boolean z = true;
        AppMethodBeat.i(126497);
        if (view.getId() == this.pIO.getId()) {
            if (this.GjH != null && !Util.isNullOrNil(this.GjH.IEH)) {
                String str = this.GjH.IEH;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                com.tencent.mm.br.c.b(this.Gmr.eeF(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                if (this.Gmr.fyF().GnZ) {
                    this.GpP.crC();
                    this.Gmr.fyF().cXa();
                }
                this.Gmr.fyB().k(this.GjH);
                ((b) g.ah(b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 1, "");
                AppMethodBeat.o(126497);
                return;
            }
        } else if (view.getId() == this.rAO.getId()) {
            a.pl(8);
            a(this.Gmr, this.Gmr.eeF(), this.GpP, fyz());
            AppMethodBeat.o(126497);
            return;
        } else if (view.getId() == this.Gpw.getId()) {
            this.Gmr.ay(this.Gpw, fyz());
            AppMethodBeat.o(126497);
            return;
        } else if (view.getId() == this.GoP.getId() || view.getId() == this.GoQ.getId()) {
            this.Gmr.fyA().Gnu = true;
            this.Gmr.fyF().stopPlay();
            this.GpP.fyY();
            dyi dyi = (dyi) view.getTag();
            eit a2 = com.tencent.mm.plugin.topstory.a.h.a(this.Gmr.fyD());
            a2.sGQ = UUID.randomUUID().toString();
            a2.NhX = this.GjH.psI;
            a2.Nib = dyi.MXW;
            a2.Nic = null;
            a2.Nid = dyi;
            a2.guh = this.Gmr.Zx();
            a2.Nie = this.Gmr.fyA().Gnu;
            Iterator<aca> it = a2.IDO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                aca next = it.next();
                if ("show_tag_list".equals(next.key)) {
                    next.LmD = dyi.id;
                    break;
                }
            }
            if (!z) {
                aca aca = new aca();
                aca.key = "show_tag_list";
                aca.LmD = dyi.id;
                a2.IDO.add(aca);
            }
            ai.a(this.Gmr.eeF(), a2, 10001);
            a.pl(28);
            ((b) g.ah(b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 4, dyi.dQx + ":" + dyi.id);
            AppMethodBeat.o(126497);
            return;
        } else if (view.getId() == this.GmA.getId() || view.getId() == this.xYx.getId() || view.getId() == this.GoT.getId()) {
            if (n.a(this.GjH, this.Gmr.eeF())) {
                ((b) g.ah(b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 3, "");
                AppMethodBeat.o(126497);
                return;
            }
        } else if (view.getId() == this.GpQ.getId()) {
            this.Gmr.a(this.GjH, view);
            if (this.GjH.NiC) {
                this.GpR.setImageResource(R.raw.top_story_wow_selected);
                this.GoH.setTextColor(this.GoH.getResources().getColor(R.color.ac7));
                AppMethodBeat.o(126497);
                return;
            }
            this.GpR.setImageResource(R.raw.top_story_wow_unselected);
            this.GoH.setTextColor(this.GoH.getResources().getColor(R.color.ag2));
        }
        AppMethodBeat.o(126497);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.h
    public final View getWowView() {
        return this.GpQ;
    }
}
