package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import java.util.UUID;

public abstract class f extends RelativeLayout {
    public static c Glu;
    public eiw GjH;
    public b GlS;
    protected FrameLayout GlT;
    public TextView GlU;
    protected View GlV;
    protected TextView GlW;
    protected ImageView GlX;
    protected ImageView GlY;
    protected Button GlZ;
    protected TextView Gma;
    protected TextView Gmb;
    protected View Gmc;
    protected View Gmd;
    protected View Gme;
    protected View Gmf;
    protected View Gmg;
    public FrameLayout Gmh;
    public ImageView Gmi;
    public ImageView Gmj;
    public a Gmk;
    protected TextView Gml;
    public a Gmm = a.UNKNOWN;
    protected ImageView puw;
    public String sessionId = "";
    protected TextView titleTv;

    public abstract void fyV();

    public abstract void fyW();

    public abstract g getControlBar();

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    public abstract i.b getVideoViewCallback();

    static {
        c.a aVar = new c.a();
        aVar.jbf = true;
        aVar.jbe = true;
        Glu = aVar.bdv();
    }

    public enum a {
        UNKNOWN,
        MOBILE_NET,
        NO_NET;

        public static a valueOf(String str) {
            AppMethodBeat.i(126070);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(126070);
            return aVar;
        }

        static {
            AppMethodBeat.i(126071);
            AppMethodBeat.o(126071);
        }
    }

    public f(Context context, b bVar, a aVar) {
        super(context);
        this.GlS = bVar;
        this.Gmk = aVar;
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        this.GlT = (FrameLayout) findViewById(R.id.j70);
        this.GlU = (TextView) findViewById(R.id.glp);
        this.Gmc = findViewById(R.id.ip0);
        this.Gmd = findViewById(R.id.j3t);
        this.Gme = findViewById(R.id.j6q);
        this.Gmf = findViewById(R.id.j3u);
        this.Gmg = findViewById(R.id.j56);
        this.GlV = findViewById(R.id.j5_);
        this.puw = (ImageView) findViewById(R.id.bh7);
        this.GlW = (TextView) findViewById(R.id.j6h);
        this.titleTv = (TextView) findViewById(R.id.ir3);
        this.GlX = (ImageView) findViewById(R.id.bgy);
        this.GlY = (ImageView) findViewById(R.id.bgz);
        this.Gmb = (TextView) findViewById(R.id.h34);
        this.GlZ = (Button) findViewById(R.id.iof);
        this.Gma = (TextView) findViewById(R.id.iog);
        this.Gmi = (ImageView) findViewById(R.id.gcs);
        this.Gmj = (ImageView) findViewById(R.id.gcr);
        this.Gmh = (FrameLayout) findViewById(R.id.gct);
        this.Gml = (TextView) findViewById(R.id.fv0);
    }

    public void fyX() {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setPlayingContainerStatus, pos:%d", Integer.valueOf(this.Gmk.fyz()));
        this.Gmd.setVisibility(8);
        this.puw.setVisibility(8);
        this.GlU.setVisibility(8);
        this.Gmc.setVisibility(8);
        this.GlT.setVisibility(0);
        this.GlT.setAlpha(1.0f);
    }

    public final void fyY() {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStopContainerStatus, pos:%d", Integer.valueOf(this.Gmk.fyz()));
        this.puw.setVisibility(0);
        this.Gmd.setVisibility(0);
        this.Gmh.setVisibility(8);
        this.Gme.setVisibility(8);
        this.Gmc.setVisibility(0);
        this.Gmf.setVisibility(0);
        this.GlX.setVisibility(0);
        this.GlY.setVisibility(8);
        this.Gmb.setVisibility(8);
        this.GlW.setVisibility(8);
    }

    public final void fyZ() {
        lg(getNoNetTip(), this.GlS.eeF().getString(R.string.hxp));
        getContext().getString(R.string.hq3, Util.getSizeMB(this.GjH.Niv, 100.0d));
    }

    public final void lg(String str, String str2) {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setWarningTipContainerStatus %s %s", str, str2);
        this.puw.setVisibility(0);
        this.Gmd.setVisibility(0);
        this.Gme.setVisibility(0);
        this.Gmc.setVisibility(0);
        this.Gmf.setVisibility(8);
        this.Gmg.setVisibility(0);
        this.GlV.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.Gma.setText(str);
            this.Gma.setVisibility(0);
        } else {
            this.Gma.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.GlZ.setText(str2);
            this.GlZ.setVisibility(0);
            return;
        }
        this.GlZ.setVisibility(8);
    }

    public FrameLayout getVideoViewParent() {
        return this.GlT;
    }

    /* access modifiers changed from: protected */
    public String getMobileNetTip() {
        if (this.GjH.Niv == 0) {
            return getContext().getString(R.string.hq4);
        }
        return getContext().getString(R.string.hq3, Util.getSizeMB(this.GjH.Niv, 100.0d));
    }

    public String getNoNetTip() {
        return getContext().getString(R.string.hx_);
    }

    public final void a(eiw eiw, int i2) {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "updateView position:%s", Integer.valueOf(i2));
        this.GjH = eiw;
        updateView();
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        this.puw.setImageDrawable(null);
        q.bcV().a(this.GjH.Nio, this.puw, Glu);
        if (this.Gml != null) {
            this.Gml.animate().cancel();
            this.Gml.setVisibility(8);
        }
    }

    public void fza() {
    }

    public void fzb() {
    }

    public boolean ay(boolean z, boolean z2) {
        int i2;
        String fyP = this.GlS.fyP();
        String fYe = ai.fYe();
        int fyQ = this.GlS.fyQ();
        if (!this.GlS.fyA().isConnected()) {
            this.Gmm = a.NO_NET;
            fza();
            lg(getNoNetTip(), getContext().getString(R.string.hxp));
            this.GlS.fyF().a(this, c(this.GjH));
            return false;
        }
        if (!fYe.equals("wifi") && !fYe.equals(fyP)) {
            if (fYe.equals("wangka")) {
                if (!(fyQ == 1 || fyQ == 2)) {
                    this.GlS.abW(1);
                    if (this.Gml != null) {
                        this.Gml.setVisibility(0);
                        this.Gml.setAlpha(1.0f);
                        this.Gml.animate().alpha(0.0f).setDuration(3000).start();
                    } else {
                        u.makeText(this.GlS.eeF(), (int) R.string.hq5, 0).show();
                    }
                }
            } else if (fyQ != 2) {
                fzc();
                this.GlS.fyF().a(this, c(this.GjH));
                return false;
            }
        }
        this.GlS.aTF(fYe);
        fzd();
        this.Gmm = a.UNKNOWN;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "setStartPlayContainerStatus");
        this.Gmd.setVisibility(0);
        this.Gmf.setVisibility(8);
        this.Gmc.setVisibility(8);
        this.Gmh.setVisibility(8);
        this.Gme.setVisibility(0);
        this.Gmg.setVisibility(8);
        this.GlV.setVisibility(0);
        this.GlV.setVisibility(0);
        this.GlV.setAlpha(0.0f);
        this.GlV.animate().setDuration(4000).setInterpolator(new AccelerateInterpolator()).alpha(1.0f).start();
        this.puw.setVisibility(0);
        this.GlU.setVisibility(8);
        this.GlT.setVisibility(0);
        this.GlT.setAlpha(0.0f);
        this.GlS.fyF().a(this, c(this.GjH));
        r fyF = this.GlS.fyF();
        b bVar = this.GlS;
        eiw eiw = this.GjH;
        String str = this.sessionId;
        int fyz = this.Gmk.fyz();
        HashMap<String, Integer> videoPlayProgressMap = ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getVideoPlayProgressMap();
        if (videoPlayProgressMap.containsKey(eiw.psI)) {
            i2 = videoPlayProgressMap.get(eiw.psI).intValue();
        } else {
            videoPlayProgressMap.put(eiw.psI, 0);
            i2 = 0;
        }
        Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "startPlay, pos:%s, vid:%s videoProgress: %d", Integer.valueOf(fyz), eiw.psI, Integer.valueOf(i2));
        if (eiw.Niz != null) {
            Log.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "video %s secondVideoInfo %d %d", eiw.psI, Integer.valueOf(eiw.Niz.NhT), Integer.valueOf(eiw.Niz.NhU));
        }
        if (eiw.NiI != null) {
            eiw.NiI.dEF = false;
        }
        if (fyF.GjK != null) {
            if (!fyF.GjK.wWb.equals(eiw.wWb) || z2) {
                fyF.GnX.stop();
                bVar.fyB().b(bVar.fyD());
                bVar.fyB().fzB();
            }
            return true;
        }
        if (Util.isNullOrNil(eiw.videoUrl)) {
            Log.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", str, eiw.psI, eiw.title);
        } else {
            bVar.fyB().a(eiw, fyz, str);
            fyF.GlS.fyB().j(eiw);
            fyF.GnX.setLoop(false);
            fyF.GnX.setVideoInfo(eiw);
            fyF.GnX.setMute(bVar.Zx());
            fyF.GnX.setKeepScreenOn(true);
            if (i2 == 0) {
                fyF.GnX.aTG(str);
            } else {
                q qVar = fyF.GnX;
                qVar.sessionId = str;
                qVar.G(i2, true);
            }
            fyF.GnX.fzE();
            fyF.GjK = eiw;
            fyF.GnZ = true;
            fyF.Goa = false;
        }
        return true;
    }

    public final void fzc() {
        this.Gmm = a.MOBILE_NET;
        fza();
        lg(getMobileNetTip(), getContext().getString(R.string.hph));
    }

    public i.e c(eiw eiw) {
        return i.e.DEFAULT;
    }

    public final String fzd() {
        this.sessionId = UUID.randomUUID().toString();
        return this.sessionId;
    }

    public final void seekTo(int i2) {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoContainer", "seek to position=%d current=%d", Integer.valueOf(i2), Integer.valueOf(this.GlS.fyF().getCurrPosSec()));
        r fyF = this.GlS.fyF();
        if (fyF.GnX != null) {
            fyF.GnX.G(i2, true);
        }
        b bVar = this.GlS.fyB().GnT;
        if (bVar != null) {
            bVar.Gjr = 1;
        }
    }

    public void crC() {
    }

    public final void fze() {
        this.Gmh.setVisibility(0);
    }

    public a getItemUIComponent() {
        return this.Gmk;
    }

    public a getPauseReason() {
        return this.Gmm;
    }

    public void fzf() {
    }

    public void fzg() {
    }

    public boolean fzh() {
        return false;
    }
}
