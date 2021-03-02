package com.tencent.mm.plugin.sns.ui.video;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private static d Fdl;
    private List<WeakReference<SnsTimelineVideoView>> Fdm = new LinkedList();
    private List<SnsTimelineVideoView> Fdn = new ArrayList();
    private int Fdo = 0;
    public c Fdp;
    public String Fdq;
    public SnsTimelineVideoView Fdr;
    private WeakReference<SnsTimelineVideoView> JRM = null;

    static class a {
        a() {
        }
    }

    public static synchronized d fkS() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(100418);
            if (Fdl == null) {
                Fdl = new d();
            }
            dVar = Fdl;
            AppMethodBeat.o(100418);
        }
        return dVar;
    }

    public d() {
        AppMethodBeat.i(100419);
        AppMethodBeat.o(100419);
    }

    public final void a(OnlineVideoView onlineVideoView, c cVar, String str) {
        AppMethodBeat.i(100420);
        if (cVar == null) {
            Log.e("MicroMsg.Sns.SnsVideoViewMgr", "startPlay without videoInfo");
            AppMethodBeat.o(100420);
            return;
        }
        this.Fdr = (SnsTimelineVideoView) onlineVideoView;
        if (this.Fdr != null) {
            this.Fdr.setVisibility(0);
        }
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl startPlay, pos:%s, vid:%s, tlObjId:%s videoViewsSize: %s info %s", 0, cVar.ebR.Id, str, Integer.valueOf(this.Fdn.size()), onlineVideoView.fgj());
        ArrayList<SnsTimelineVideoView> arrayList = new ArrayList();
        for (SnsTimelineVideoView snsTimelineVideoView : this.Fdn) {
            if (snsTimelineVideoView != onlineVideoView) {
                if (snsTimelineVideoView.isPlaying() || snsTimelineVideoView.YY()) {
                    boolean H = H(snsTimelineVideoView);
                    snsTimelineVideoView.vi(true);
                    if (H) {
                        snsTimelineVideoView.fkN();
                    }
                    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s pause ", Integer.valueOf(snsTimelineVideoView.hashCode()));
                } else {
                    Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s remove isPlaying:%s, isPause:%s", Integer.valueOf(snsTimelineVideoView.hashCode()), Boolean.valueOf(snsTimelineVideoView.isPlaying()), Boolean.valueOf(snsTimelineVideoView.YY()));
                    arrayList.add(snsTimelineVideoView);
                }
            }
        }
        for (SnsTimelineVideoView snsTimelineVideoView2 : arrayList) {
            if (snsTimelineVideoView2.getParent() != null) {
                ((ViewGroup) snsTimelineVideoView2.getParent()).removeView(snsTimelineVideoView2);
            }
            this.Fdn.remove(snsTimelineVideoView2);
            snsTimelineVideoView2.fkP();
        }
        if (this.Fdr.FcY != null) {
            if (!Util.isEqual(str, this.Fdr.FcZ) || !this.Fdr.FcY.ebR.Id.equals(cVar.ebR.Id)) {
                Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s played another video, destroy it", Integer.valueOf(this.Fdr.hashCode()));
                this.Fdr.fkR();
            } else {
                Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s has been played or playing, just resume", Integer.valueOf(this.Fdr.hashCode()));
                if (!this.Fdr.isPlaying()) {
                    this.Fdr.setScene(1);
                    SnsTimelineVideoView snsTimelineVideoView3 = this.Fdr;
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    snsTimelineVideoView3.setSessionId(sb.append(new p(com.tencent.mm.kernel.a.getUin()).toString()).append("_").append(Util.nowMilliSecond()).toString());
                    this.Fdr.setSessionTimestamp(Util.nowMilliSecond());
                    this.Fdr.setSnsId(this.Fdr.FcY.dRS);
                    this.Fdr.setFilePath(ay.E(this.Fdr.FcY.ebR));
                }
                this.Fdr.eYd();
                this.Fdr.setMute(true);
                this.Fdr.abandonAudioFocus();
                AppMethodBeat.o(100420);
                return;
            }
        }
        this.Fdr.FcY = cVar;
        this.Fdr.FcZ = str;
        this.Fdr.FcX = SnsTimelineVideoView.a.PLAYING;
        this.Fdr.vgi = System.currentTimeMillis();
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s startPlay, setState PLAYING %s", Integer.valueOf(this.Fdr.hashCode()), onlineVideoView.fgj());
        this.Fdp = cVar;
        this.Fdq = str;
        this.Fdr.setMute(true);
        this.Fdr.a(cVar.ebR, cVar.dHp, cVar.iXu);
        this.Fdr.abandonAudioFocus();
        this.Fdr.onResume();
        this.Fdr.setScene(1);
        SnsTimelineVideoView snsTimelineVideoView4 = this.Fdr;
        StringBuilder sb2 = new StringBuilder();
        g.aAf();
        snsTimelineVideoView4.setSessionId(sb2.append(new p(com.tencent.mm.kernel.a.getUin()).toString()).append("_").append(Util.nowMilliSecond()).toString());
        this.Fdr.setSessionTimestamp(Util.nowMilliSecond());
        this.Fdr.setSnsId(this.Fdr.FcY.dRS);
        this.Fdr.setFilePath(ay.E(this.Fdr.FcY.ebR));
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "lxl normal start");
        AppMethodBeat.o(100420);
    }

    private void stopAll() {
        AppMethodBeat.i(100421);
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "stopAll");
        if (!this.Fdn.isEmpty()) {
            for (SnsTimelineVideoView snsTimelineVideoView : this.Fdn) {
                if (snsTimelineVideoView != null && snsTimelineVideoView.getParent() != null) {
                    snsTimelineVideoView.Fdc = false;
                    ((ViewGroup) snsTimelineVideoView.getParent()).removeView(snsTimelineVideoView);
                } else if (snsTimelineVideoView != null) {
                    snsTimelineVideoView.fkP();
                }
            }
            this.Fdn.clear();
        }
        this.Fdr = null;
        this.Fdp = null;
        this.Fdq = "";
        int i2 = 0;
        for (WeakReference<SnsTimelineVideoView> weakReference : this.Fdm) {
            final SnsTimelineVideoView snsTimelineVideoView2 = weakReference.get();
            if (snsTimelineVideoView2 != null) {
                if (!snsTimelineVideoView2.Fdd) {
                    i2++;
                }
                snsTimelineVideoView2.fgc();
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.video.d.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(100417);
                        snsTimelineVideoView2.EtU = true;
                        snsTimelineVideoView2.onDestroy();
                        AppMethodBeat.o(100417);
                    }
                });
            }
            i2 = i2;
        }
        Log.w("MicroMsg.Sns.SnsVideoViewMgr", "[fallbackRelease] releaseCount=%s allCount=%s", Integer.valueOf(i2), Integer.valueOf(this.Fdm.size()));
        this.Fdm.clear();
        AppMethodBeat.o(100421);
    }

    public final void cXa() {
        AppMethodBeat.i(100422);
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay");
        if (this.Fdr != null) {
            boolean H = H(this.Fdr);
            this.Fdr.vi(true);
            if (H) {
                this.Fdr.fkN();
            }
        }
        AppMethodBeat.o(100422);
    }

    public final void fkT() {
        this.Fdo++;
    }

    public final void onUIPause() {
        AppMethodBeat.i(100423);
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "pausePlay onUIPause");
        if (this.Fdr != null) {
            boolean H = H(this.Fdr);
            this.Fdr.fkO();
            if (H) {
                this.Fdr.fkN();
            }
        }
        AppMethodBeat.o(100423);
    }

    public final void aN(Activity activity) {
        AppMethodBeat.i(100424);
        this.Fdo--;
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "onUIDestroy %d", Integer.valueOf(this.Fdo));
        if (this.Fdo <= 0 || (activity instanceof SnsTimeLineUI)) {
            if (this.Fdo > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(31, 4, 1);
            }
            stopAll();
        }
        AppMethodBeat.o(100424);
    }

    public final boolean aRu(String str) {
        AppMethodBeat.i(203977);
        if (Util.isNullOrNil(this.Fdq) || Util.isNullOrNil(str)) {
            AppMethodBeat.o(203977);
            return false;
        }
        boolean equals = this.Fdq.equals(str);
        AppMethodBeat.o(203977);
        return equals;
    }

    public final boolean aRv(String str) {
        AppMethodBeat.i(100425);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(100425);
            return false;
        }
        for (SnsTimelineVideoView snsTimelineVideoView : this.Fdn) {
            if (str.equals(snsTimelineVideoView.FcZ) && snsTimelineVideoView.FcX != SnsTimelineVideoView.a.AVAILABLE) {
                AppMethodBeat.o(100425);
                return true;
            }
        }
        AppMethodBeat.o(100425);
        return false;
    }

    public final SnsTimelineVideoView aRw(String str) {
        SnsTimelineVideoView snsTimelineVideoView;
        SnsTimelineVideoView hd;
        AppMethodBeat.i(100426);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(100426);
            return null;
        }
        Iterator<SnsTimelineVideoView> it = this.Fdn.iterator();
        while (true) {
            if (!it.hasNext()) {
                snsTimelineVideoView = null;
                break;
            }
            SnsTimelineVideoView next = it.next();
            if (str.equals(next.FcZ)) {
                this.Fdn.remove(next);
                snsTimelineVideoView = next;
                break;
            }
        }
        if (snsTimelineVideoView == null) {
            AppMethodBeat.o(100426);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) snsTimelineVideoView.getParent();
        if (viewGroup == null) {
            AppMethodBeat.o(100426);
            return snsTimelineVideoView;
        } else if (snsTimelineVideoView != this.Fdr) {
            AppMethodBeat.o(100426);
            return snsTimelineVideoView;
        } else {
            if (snsTimelineVideoView == null) {
                hd = null;
            } else {
                hd = hd(snsTimelineVideoView.getContext());
            }
            snsTimelineVideoView.Fdc = true;
            viewGroup.removeView(snsTimelineVideoView);
            if (hd.getParent() != null) {
                hd.fkQ();
                hd.Fdc = true;
                ((ViewGroup) hd.getParent()).removeView(hd);
            }
            hd.setVisibility(0);
            hd.setVideoScaleType(i.e.COVER);
            viewGroup.addView(hd, new FrameLayout.LayoutParams(-1, -1));
            hd.setTag(new a());
            hd.a(snsTimelineVideoView.FcY.ebR, snsTimelineVideoView.FcY.dHp, snsTimelineVideoView.FcY.iXu);
            hd.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
            if (gcR()) {
                this.Fdp = snsTimelineVideoView.FcY;
                this.Fdq = snsTimelineVideoView.FcZ;
                this.JRM = new WeakReference<>(hd);
            } else {
                a(hd, snsTimelineVideoView.FcY, snsTimelineVideoView.FcZ);
            }
            Log.i("MicroMsg.Sns.SnsVideoViewMgr", "findAndReCreateVideoView lxl reAttach succ %s", str);
            AppMethodBeat.o(100426);
            return snsTimelineVideoView;
        }
    }

    public static boolean gcR() {
        AppMethodBeat.i(258147);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_timeline_enable_new_small_video_type, true);
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "enableNewSmallViewType %b", Boolean.valueOf(a2));
        AppMethodBeat.o(258147);
        return a2;
    }

    public final SnsTimelineVideoView aRx(String str) {
        AppMethodBeat.i(100427);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(100427);
            return null;
        }
        for (SnsTimelineVideoView snsTimelineVideoView : this.Fdn) {
            if (str.equals(snsTimelineVideoView.FcZ)) {
                AppMethodBeat.o(100427);
                return snsTimelineVideoView;
            }
        }
        AppMethodBeat.o(100427);
        return null;
    }

    public final SnsTimelineVideoView hd(Context context) {
        SnsTimelineVideoView snsTimelineVideoView;
        AppMethodBeat.i(100428);
        SnsTimelineVideoView snsTimelineVideoView2 = null;
        for (SnsTimelineVideoView snsTimelineVideoView3 : this.Fdn) {
            if (snsTimelineVideoView3.FcX != SnsTimelineVideoView.a.AVAILABLE) {
                snsTimelineVideoView3 = snsTimelineVideoView2;
            }
            snsTimelineVideoView2 = snsTimelineVideoView3;
        }
        if (snsTimelineVideoView2 != null) {
            snsTimelineVideoView = snsTimelineVideoView2;
        } else if (this.Fdn.size() < 3) {
            snsTimelineVideoView = new SnsTimelineVideoView(context);
            this.Fdn.add(snsTimelineVideoView);
            this.Fdm.add(new WeakReference<>(snsTimelineVideoView));
        } else {
            ArrayList arrayList = new ArrayList();
            int i2 = -1;
            for (int i3 = 0; i3 < this.Fdn.size(); i3++) {
                SnsTimelineVideoView snsTimelineVideoView4 = this.Fdn.get(i3);
                if (snsTimelineVideoView4.FcX != SnsTimelineVideoView.a.PLAYING && snsTimelineVideoView4.vgi < MAlarmHandler.NEXT_FIRE_INTERVAL && !snsTimelineVideoView4.Fdb) {
                    i2 = i3;
                }
                if (snsTimelineVideoView4.Fdb) {
                    arrayList.add(snsTimelineVideoView4);
                }
            }
            if (i2 >= 0 || arrayList.size() <= 0) {
                snsTimelineVideoView = this.Fdn.get(i2 < 0 ? 0 : i2);
                Log.i("MicroMsg.Sns.SnsVideoViewMgr", "use minIndex: %s", Integer.valueOf(i2));
            } else {
                SnsTimelineVideoView snsTimelineVideoView5 = (SnsTimelineVideoView) arrayList.get(0);
                this.Fdn.remove(snsTimelineVideoView5);
                if (snsTimelineVideoView5 != null && snsTimelineVideoView5.getParent() != null) {
                    snsTimelineVideoView5.Fdc = false;
                    ((ViewGroup) snsTimelineVideoView5.getParent()).removeView(snsTimelineVideoView5);
                } else if (snsTimelineVideoView5 != null) {
                    snsTimelineVideoView5.fkP();
                }
                SnsTimelineVideoView snsTimelineVideoView6 = new SnsTimelineVideoView(context);
                this.Fdn.add(snsTimelineVideoView6);
                this.Fdm.add(new WeakReference<>(snsTimelineVideoView6));
                Log.i("MicroMsg.Sns.SnsVideoViewMgr", "use new one, removes size:%s, first:%s", Integer.valueOf(arrayList.size()), Integer.valueOf(((SnsTimelineVideoView) arrayList.get(0)).hashCode()));
                snsTimelineVideoView = snsTimelineVideoView6;
            }
        }
        snsTimelineVideoView.FcX = SnsTimelineVideoView.a.ATTACHING;
        snsTimelineVideoView.fgg();
        Log.i("MicroMsg.Sns.SnsVideoViewMgr", "%s getAvailableVideoView, setState ATTACHING", Integer.valueOf(snsTimelineVideoView.hashCode()));
        AppMethodBeat.o(100428);
        return snsTimelineVideoView;
    }

    private static boolean H(OnlineVideoView onlineVideoView) {
        AppMethodBeat.i(100429);
        boolean z = false;
        if (onlineVideoView != null) {
            try {
                if (onlineVideoView.isPlaying()) {
                    z = true;
                }
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(100429);
        return z;
    }
}
