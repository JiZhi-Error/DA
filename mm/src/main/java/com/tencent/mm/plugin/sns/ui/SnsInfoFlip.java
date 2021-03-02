package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.model.ad;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    int EAk = -1;
    private boolean EAv = false;
    private boolean EAx = false;
    c EDX;
    private g EDY;
    private boolean EDZ = true;
    HashMap<Integer, Integer> EEa = new HashMap<>();
    HashMap<Integer, Long> EEb = new HashMap<>();
    HashMap<Integer, Long> EEc = new HashMap<>();
    private boolean EEd = false;
    private boolean EEe = false;
    private boolean EEf = false;
    private boolean EEg = false;
    private boolean EEh = true;
    private boolean EEi = true;
    private float EEj = 1.0f;
    MMPageControlView EEk;
    private Runnable EEl = null;
    private String EEm = "";
    private int EEn = -1;
    long EEo = 0;
    private b EEp;
    private HashMap<String, SnsInfo> EEq = new HashMap<>();
    private HashSet<String> EEr = new HashSet<>();
    public int EEs = 0;
    private HashMap<String, a> EEt = new HashMap<>();
    private int Ewx = 0;
    private Context context;
    private MMHandler handler = new MMHandler();
    List<com.tencent.mm.plugin.sns.j.b> iHf;
    boolean isAd = false;
    public String username;
    MMViewPager xqs;

    public interface b {
        void a(cnb cnb, int i2, String str);
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, cnb cnb, int i2, String str) {
        AppMethodBeat.i(203595);
        snsInfoFlip.b(cnb, i2, str);
        AppMethodBeat.o(203595);
    }

    public bp getFromScene() {
        return this.DEv;
    }

    public void setFromScene(bp bpVar) {
        this.DEv = bpVar;
    }

    public void setUIFromScene(int i2) {
        this.Eqv = i2;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    public void setOnDeleteAllAction(Runnable runnable) {
        this.EEl = runnable;
    }

    public void setItems(List<com.tencent.mm.plugin.sns.j.b> list) {
        this.iHf = list;
    }

    public float getWidthModHeight() {
        return this.EEj;
    }

    public void setOnPageSelectListener(b bVar) {
        this.EEp = bVar;
    }

    public SnsInfoFlip(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(98758);
        init(context2);
        AppMethodBeat.o(98758);
    }

    public SnsInfoFlip(Context context2) {
        super(context2);
        AppMethodBeat.i(98759);
        init(context2);
        AppMethodBeat.o(98759);
    }

    public void setIsFromMainTimeline(boolean z) {
        this.EAv = z;
    }

    public void setIsSoonEnterPhotoEditUI(boolean z) {
        this.EAx = z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public final boolean ffH() {
        return this.EAv;
    }

    private void init(Context context2) {
        AppMethodBeat.i(98760);
        this.EEo = System.currentTimeMillis();
        this.context = context2;
        this.xqs = (MMViewPager) inflate(context2, R.layout.bw2, this).findViewById(R.id.dci);
        this.xqs.setVerticalFadingEdgeEnabled(false);
        this.xqs.setHorizontalFadingEdgeEnabled(false);
        this.xqs.setOffscreenPageLimit(1);
        this.xqs.setSingleClickOverListener(new MMViewPager.f() {
            /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMViewPager.f
            public final void bmt() {
                AppMethodBeat.i(98733);
                if (SnsInfoFlip.this.EEh) {
                    SnsInfoFlip.c(SnsInfoFlip.this);
                }
                AppMethodBeat.o(98733);
            }

            @Override // com.tencent.mm.ui.base.MMViewPager.f
            public final void dSr() {
                AppMethodBeat.i(98734);
                SnsInfoFlip.c(SnsInfoFlip.this);
                AppMethodBeat.o(98734);
            }
        });
        this.EEk = (MMPageControlView) findViewById(R.id.jne);
        this.EEk.setIndicatorLayoutRes(R.layout.bya);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.EEk.getLayoutParams();
        layoutParams.bottomMargin += au.aD(getContext());
        this.EEk.setLayoutParams(layoutParams);
        r.DEL = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_big_pic_bound, 3200);
        AppMethodBeat.o(98760);
    }

    public void setShowPageControl(boolean z) {
        this.EEd = z;
    }

    public void setShowTitle(boolean z) {
        this.EEf = z;
    }

    public void setTouchFinish(boolean z) {
        this.EEe = z;
    }

    public void setShowLongClickMenu(boolean z) {
        this.EDZ = z;
    }

    public void setInfoType(int i2) {
        this.infoType = i2;
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.EEg = z;
    }

    public void setEnableSingleClickOver(boolean z) {
        this.EEh = z;
    }

    public final void bEq() {
        AppMethodBeat.i(203593);
        if (this.EDX == null || this.xqs == null) {
            AppMethodBeat.o(203593);
            return;
        }
        try {
            com.tencent.mm.plugin.sns.j.b ZN = this.EDX.ZN(this.xqs.getCurrentItem());
            String str = ZN.ebR.Id;
            g(ar.ki(aj.getAccSnsPath(), str) + r.l(this.EDX.ZN(this.xqs.getCurrentItem()).ebR), ZN.parentId, str, true);
            AppMethodBeat.o(203593);
        } catch (Exception e2) {
            AppMethodBeat.o(203593);
        }
    }

    public com.tencent.mm.plugin.sns.j.b getSelectItem() {
        AppMethodBeat.i(98761);
        if (this.xqs == null || this.EDX == null) {
            AppMethodBeat.o(98761);
            return null;
        }
        com.tencent.mm.plugin.sns.j.b ZN = this.EDX.ZN(this.xqs.getCurrentItem());
        AppMethodBeat.o(98761);
        return ZN;
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public String getSelectedMediaId() {
        AppMethodBeat.i(98762);
        cnb cntMedia = getCntMedia();
        if (cntMedia != null) {
            String str = cntMedia.Id;
            AppMethodBeat.o(98762);
            return str;
        }
        AppMethodBeat.o(98762);
        return null;
    }

    public String getSelectId() {
        AppMethodBeat.i(98763);
        com.tencent.mm.plugin.sns.j.b selectItem = getSelectItem();
        if (selectItem == null) {
            AppMethodBeat.o(98763);
            return null;
        }
        String str = selectItem.parentId;
        AppMethodBeat.o(98763);
        return str;
    }

    private void b(cnb cnb, int i2, String str) {
        String str2;
        com.tencent.mm.plugin.sns.j.b ZN;
        long j2;
        long j3 = 0;
        AppMethodBeat.i(98764);
        if (this.EEp != null) {
            this.EEp.a(cnb, i2, str);
        }
        SnsInfo aQm = aj.faO().aQm(str);
        if (aQm != null) {
            com.tencent.mm.plugin.sns.ui.a.c.h(aQm, i2);
        }
        if (this.EEn == -1) {
            this.EEn = i2;
        }
        if (!Util.isNullOrNil(str) || this.EDX == null) {
            SnsInfo snsInfo = this.EEq.get(str);
            if (snsInfo == null) {
                snsInfo = aj.faO().aQm(str);
                this.EEq.put(str, snsInfo);
            }
            if (snsInfo == null) {
                AppMethodBeat.o(98764);
                return;
            }
            if (cnb.oUv != 6) {
                aj.dRd().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(98735);
                        if (SnsInfoFlip.this.EDX != null) {
                            SnsInfoFlip.this.EDX.fij();
                        }
                        AppMethodBeat.o(98735);
                    }
                });
            }
            Log.d("MicroMsg.SnsInfoFlip", "onItemSelected " + i2 + " localId " + str);
            if (this.EAk != i2) {
                this.EEa.put(Integer.valueOf(i2), Integer.valueOf((this.EEa.containsKey(Integer.valueOf(i2)) ? this.EEa.get(Integer.valueOf(i2)).intValue() : 0) + 1));
                this.EEb.put(Integer.valueOf(i2), Long.valueOf(Util.currentTicks()));
                if (this.EAk >= 0) {
                    if (this.EEb.containsKey(Integer.valueOf(this.EAk))) {
                        j2 = this.EEb.get(Integer.valueOf(this.EAk)).longValue();
                    } else {
                        j2 = 0;
                    }
                    if (j2 > 0) {
                        this.EEb.put(Integer.valueOf(this.EAk), 0L);
                        if (this.EEc.containsKey(Integer.valueOf(this.EAk))) {
                            j3 = this.EEc.get(Integer.valueOf(this.EAk)).longValue();
                        }
                        long ticksToNow = Util.ticksToNow(j2);
                        long j4 = j3 + ticksToNow;
                        this.EEc.put(Integer.valueOf(this.EAk), Long.valueOf(j4));
                        Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + this.EAk + " curtime " + j4 + " passtime " + (((double) ticksToNow) / 1000.0d));
                    }
                }
                if (!(!this.EAv || this.EDX == null || (ZN = this.EDX.ZN(this.EAk)) == null)) {
                    String str3 = ZN.ebR.Id;
                    Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, bigPicId:%s", str3);
                    if (this.EEt.containsKey(str3)) {
                        a aVar = this.EEt.get(str3);
                        aVar.networkType = getReportNetworkType();
                        if (aVar.EEx != -1) {
                            aVar.EEv = 1;
                            aVar.DOA = aVar.EEx - aVar.EEw;
                            Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load success, costTime:%d", Long.valueOf(aVar.DOA));
                        } else {
                            aVar.EEv = 2;
                            aVar.EEx = System.currentTimeMillis();
                            aVar.DOA = aVar.EEx - aVar.EEw;
                            Log.d("MicroMsg.SnsInfoFlip", "recordMediaScrollOver, load failed, costTime:%d", Long.valueOf(aVar.DOA));
                        }
                    }
                }
            }
            this.EAk = i2;
            if (this.Eqb != null) {
                this.Eqb.aQQ(str);
            }
            int createTime = snsInfo.getCreateTime();
            TimeLineObject timeLine = snsInfo.getTimeLine();
            String r = bm.r(this.context, ((long) createTime) * 1000);
            if (timeLine == null || timeLine.ContentObj == null || timeLine.ContentObj.LoV.size() <= 1 || this.EDX == null) {
                str2 = null;
            } else {
                str2 = (this.EDX.ZN(i2).DRJ + 1) + " / " + timeLine.ContentObj.LoV.size();
            }
            this.Eqc.kQ(String.valueOf(r), str2);
            this.Eqc.fI(str, i2);
            if (this.EDX != null) {
                this.EDX.ZJ(i2);
            }
            AppMethodBeat.o(98764);
            return;
        }
        this.Eqc.kQ((i2 + 1) + " / " + this.EDX.getCount(), null);
        AppMethodBeat.o(98764);
    }

    public final void a(List<com.tencent.mm.plugin.sns.j.b> list, String str, int i2, y yVar, w.a aVar) {
        AppMethodBeat.i(98765);
        aj.faJ().a(this);
        this.iHf = list;
        an.In(str);
        this.Eqb = yVar;
        this.Eqc = aVar;
        this.EDX = new c(this.context);
        this.xqs.setAdapter(this.EDX);
        if (i2 >= 0 && i2 < this.iHf.size()) {
            this.xqs.setCurrentItem(i2);
            if (this.EEi) {
                this.EEi = false;
                cnb cnb = this.EDX.ZN(i2).ebR;
                if (cnb == null || cnb.MsB == null || cnb.MsB.Mtp <= 0.0f) {
                    this.EEj = 1.0f;
                } else {
                    this.EEj = cnb.MsB.Mto / cnb.MsB.Mtp;
                }
            }
        }
        this.xqs.setFadingEdgeLength(0);
        this.xqs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.AnonymousClass4 */

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                AppMethodBeat.i(98736);
                if (SnsInfoFlip.this.EDX != null) {
                    if (SnsInfoFlip.this.EEd && SnsInfoFlip.this.EDX.getCount() > 1) {
                        SnsInfoFlip.this.EEk.setVisibility(0);
                        SnsInfoFlip.this.EEk.setPage(i2);
                    }
                    SnsInfoFlip.a(SnsInfoFlip.this, SnsInfoFlip.this.EDX.ZN(i2).ebR, i2, SnsInfoFlip.this.EDX.ZN(i2).parentId);
                    g NQ = SnsInfoFlip.this.EDX.NQ(i2);
                    if (NQ == null) {
                        NQ = SnsInfoFlip.this.EDX.NR(i2);
                    }
                    SnsInfoFlip.this.EDY = NQ;
                    if (NQ != null) {
                        NQ.gKy();
                    }
                    if (SnsInfoFlip.this.context instanceof SnsBrowseUI) {
                        ((SnsBrowseUI) SnsInfoFlip.this.context).fhM();
                    }
                    SnsInfoFlip.this.EDX.ZK(i2);
                }
                AppMethodBeat.o(98736);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }
        });
        this.xqs.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.AnonymousClass5 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(203588);
                switch (motionEvent.getAction()) {
                    case 0:
                        ad.b G = ad.aVe().G("basescanui@datacenter", true);
                        if (SnsInfoFlip.this.EDY instanceof View) {
                            PointF e2 = m.e((View) SnsInfoFlip.this.EDY, motionEvent.getRawX(), motionEvent.getRawY());
                            if (e2 == null) {
                                Log.e("MicroMsg.SnsInfoFlip", "alvinluo get touchCoordinate is invalid");
                                G.l("key_basescanui_screen_position", Boolean.TRUE);
                                G.l("key_basescanui_screen_x", Float.valueOf(motionEvent.getRawX()));
                                G.l("key_basescanui_screen_y", Float.valueOf(motionEvent.getRawY()));
                                break;
                            } else {
                                G.l("key_basescanui_touch_normalize_x", Float.valueOf(e2.x));
                                G.l("key_basescanui_touch_normalize_y", Float.valueOf(e2.y));
                                break;
                            }
                        }
                        break;
                }
                AppMethodBeat.o(203588);
                return false;
            }
        });
        if (this.EDZ) {
            this.xqs.setLongClickOverListener(new MMViewPager.d() {
                /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.AnonymousClass6 */

                @Override // com.tencent.mm.ui.base.MMViewPager.d
                public final void bmu() {
                    AppMethodBeat.i(203589);
                    if (!SnsInfoFlip.this.EDZ) {
                        AppMethodBeat.o(203589);
                    } else if (SnsInfoFlip.this.EDX == null) {
                        Log.e("MicroMsg.SnsInfoFlip", "longClickOver, adapter is null.");
                        AppMethodBeat.o(203589);
                    } else {
                        com.tencent.mm.plugin.sns.j.b ZN = SnsInfoFlip.this.EDX.ZN(SnsInfoFlip.this.xqs.getCurrentItem());
                        if (ZN == null || Util.isNullOrNil(ZN.parentId)) {
                            AppMethodBeat.o(203589);
                            return;
                        }
                        ep epVar = new ep();
                        epVar.ejA = 1;
                        if (SnsInfoFlip.this.EAv) {
                            epVar.eDV = 6;
                        } else {
                            epVar.eDV = 7;
                        }
                        cnb cnb = SnsInfoFlip.this.EDX.ZN(SnsInfoFlip.this.xqs.getCurrentItem()).ebR;
                        epVar.rK(cnb.Url);
                        epVar.bfK();
                        String str = cnb.Id;
                        SnsInfoFlip.this.g(ar.ki(aj.getAccSnsPath(), str) + r.l(SnsInfoFlip.this.EDX.ZN(SnsInfoFlip.this.xqs.getCurrentItem()).ebR), ZN.parentId, str, true);
                        AppMethodBeat.o(203589);
                    }
                }
            });
        }
        if (this.EEd && this.EDX.getCount() > 1) {
            this.EEk.setVisibility(0);
            this.EEk.kX(this.EDX.getCount(), i2);
        }
        if (this.EAx && !Util.isNullOrNil(this.EDX.ZN(i2).parentId)) {
            aQN(ar.ki(aj.getAccSnsPath(), this.EDX.ZN(i2).ebR.Id) + r.l(this.EDX.ZN(i2).ebR));
        }
        AppMethodBeat.o(98765);
    }

    /* access modifiers changed from: package-private */
    public class c extends v {
        private int EEA;
        private String EEB;
        Map<String, WeakReference<View>> EEC = new HashMap();
        private boolean EED = false;
        Context context;
        private boolean qJf;

        static /* synthetic */ void a(c cVar, d dVar, int i2, cnb cnb, boolean z) {
            AppMethodBeat.i(203592);
            cVar.a(dVar, i2, cnb, z);
            AppMethodBeat.o(203592);
        }

        c(Context context2) {
            AppMethodBeat.i(98742);
            this.context = context2;
            this.EEA = SnsInfoFlip.this.iHf.size();
            com.tencent.mm.modelcontrol.d.baW();
            this.qJf = com.tencent.mm.modelcontrol.d.baY();
            AppMethodBeat.o(98742);
        }

        @Override // com.tencent.mm.ui.base.v
        public final MultiTouchImageView NQ(int i2) {
            AppMethodBeat.i(98743);
            View abm = super.abm(i2);
            if (abm == null) {
                Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition view is null.", Integer.valueOf(i2));
                AppMethodBeat.o(98743);
                return null;
            }
            d dVar = (d) abm.getTag();
            if (dVar == null) {
                Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getMultiTouchImageViewByPosition holder is null.", Integer.valueOf(i2));
                AppMethodBeat.o(98743);
                return null;
            } else if (dVar.EEM.getVisibility() == 8) {
                AppMethodBeat.o(98743);
                return null;
            } else {
                MultiTouchImageView multiTouchImageView = dVar.EEM;
                AppMethodBeat.o(98743);
                return multiTouchImageView;
            }
        }

        @Override // com.tencent.mm.ui.base.v
        public final WxImageView NR(int i2) {
            AppMethodBeat.i(98744);
            View abm = super.abm(i2);
            if (abm == null) {
                Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition view is null.", Integer.valueOf(i2));
                AppMethodBeat.o(98744);
                return null;
            }
            d dVar = (d) abm.getTag();
            if (dVar == null) {
                Log.e("MicroMsg.SnsGalleryAdapter", "position : %d getWxImageViewByPosition holder is null.", Integer.valueOf(i2));
                AppMethodBeat.o(98744);
                return null;
            } else if (dVar.xpO.getVisibility() == 8) {
                AppMethodBeat.o(98744);
                return null;
            } else {
                WxImageView wxImageView = dVar.xpO;
                AppMethodBeat.o(98744);
                return wxImageView;
            }
        }

        @Override // com.tencent.mm.ui.base.v
        public final Object h(int i2, View view) {
            OnlineVideoView onlineVideoView;
            OnlineVideoView onlineVideoView2;
            AppMethodBeat.i(98745);
            if (ZN(i2).ebR.oUv == 6) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i2);
                objArr[1] = Boolean.valueOf(view == null);
                Log.d("MicroMsg.SnsGalleryAdapter", "fill view online sight %d convert view is null %b.", objArr);
                com.tencent.mm.plugin.sns.j.b ZN = ZN(i2);
                if (ZN == null) {
                    Log.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but flip item is null.");
                    onlineVideoView2 = view;
                } else {
                    String str = ZN.parentId;
                    if (Util.isNullOrNil(str)) {
                        Log.w("MicroMsg.SnsGalleryAdapter", "fill online sight view, but sns local id is null.");
                        onlineVideoView2 = view;
                    } else {
                        WeakReference<View> weakReference = this.EEC.get(str);
                        if (weakReference == null || weakReference.get() == null) {
                            OnlineVideoView onlineVideoView3 = new OnlineVideoView(this.context);
                            this.EEC.put(str, new WeakReference<>(onlineVideoView3));
                            onlineVideoView = onlineVideoView3;
                        } else {
                            onlineVideoView = (OnlineVideoView) weakReference.get();
                        }
                        onlineVideoView.aM(null);
                        if (Util.isEqual(str, this.EEB)) {
                            ZJ(i2);
                        }
                        Log.i("MicroMsg.SnsGalleryAdapter", "return online sight view %d parent id %s.", Integer.valueOf(onlineVideoView.hashCode()), ZN.parentId);
                        SnsInfo aQm = aj.faO().aQm(str);
                        onlineVideoView2 = onlineVideoView;
                        if (aQm != null) {
                            onlineVideoView.setScene(SnsInfoFlip.this.Ewx);
                            StringBuilder sb = new StringBuilder();
                            com.tencent.mm.kernel.g.aAf();
                            onlineVideoView.setSessionId(sb.append(new p(com.tencent.mm.kernel.a.getUin()).toString()).append("_").append(Util.nowMilliSecond()).toString());
                            onlineVideoView.setSessionTimestamp(Util.nowMilliSecond());
                            onlineVideoView.setSnsId(r.Jb(aQm.field_snsId));
                            onlineVideoView.setFilePath(ay.E(ZN.ebR));
                            onlineVideoView2 = onlineVideoView;
                            if (com.tencent.mm.q.a.aty()) {
                                onlineVideoView.setMute(true);
                                onlineVideoView2 = onlineVideoView;
                            }
                        }
                    }
                }
                AppMethodBeat.o(98745);
                return onlineVideoView2;
            }
            View k = k(i2, view);
            AppMethodBeat.o(98745);
            return k;
        }

        /* access modifiers changed from: package-private */
        public final void ZJ(int i2) {
            AppMethodBeat.i(98746);
            com.tencent.mm.plugin.sns.j.b ZN = ZN(i2);
            if (ZN == null) {
                Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but flip item is null.");
                AppMethodBeat.o(98746);
                return;
            }
            String str = ZN.parentId;
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but sns local id is null.");
                AppMethodBeat.o(98746);
                return;
            }
            Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight play pos %s sns local id %s.", Integer.valueOf(i2), str);
            WeakReference<View> weakReference = this.EEC.get(str);
            if (weakReference == null) {
                Log.w("MicroMsg.SnsGalleryAdapter", "notify online sight play, but view cache is null.");
                this.EEB = str;
                AppMethodBeat.o(98746);
                return;
            }
            OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
            if (onlineVideoView == null) {
                Log.w("MicroMsg.SnsGalleryAdapter", "online sight view is null, do nothing. snsLocalId %s.", str);
                this.EEB = str;
                AppMethodBeat.o(98746);
                return;
            }
            Log.i("MicroMsg.SnsGalleryAdapter", "%d notify online sight play video %s.", Integer.valueOf(onlineVideoView.hashCode()), str);
            this.EEB = null;
            onlineVideoView.fgh();
            onlineVideoView.a(ZN.ebR, ZN.parentId, ZN.iXu);
            vm vmVar = new vm();
            vmVar.ebJ.dKy = 1;
            vmVar.ebJ.dJX = str;
            EventCenter.instance.publish(vmVar);
            AppMethodBeat.o(98746);
        }

        public final void clear() {
            AppMethodBeat.i(98747);
            Log.i("MicroMsg.SnsGalleryAdapter", "adapter clear.");
            this.EEC.clear();
            AppMethodBeat.o(98747);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(98748);
            if (SnsInfoFlip.this.iHf == null) {
                AppMethodBeat.o(98748);
                return 0;
            }
            int size = SnsInfoFlip.this.iHf.size();
            AppMethodBeat.o(98748);
            return size;
        }

        public final void fij() {
            AppMethodBeat.i(98749);
            Log.i("MicroMsg.SnsGalleryAdapter", "notify online sight stop %s", Util.getStack());
            vm vmVar = new vm();
            vmVar.ebJ.context = this.context;
            vmVar.ebJ.dJX = this.EEB;
            vmVar.ebJ.dKy = 2;
            EventCenter.instance.publish(vmVar);
            this.EEB = null;
            AppMethodBeat.o(98749);
        }

        private View k(final int i2, View view) {
            final d dVar;
            final boolean z = true;
            AppMethodBeat.i(98750);
            final cnb cnb = ZN(i2).ebR;
            if (view == null || view.getTag() == null) {
                dVar = new d();
                view = View.inflate(this.context, R.layout.bvy, null);
                dVar.EEL = view.findViewById(R.id.dcp);
                dVar.wSb = (ImageView) view.findViewById(R.id.epj);
                dVar.kdb = (ProgressBar) view.findViewById(R.id.epo);
                dVar.EEM = (MultiTouchImageView) view.findViewById(R.id.fnb);
                dVar.xpO = (WxImageView) view.findViewById(R.id.jrc);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            Log.d("MicroMsg.SnsGalleryAdapter", "gallery position %d, media id: %s, %s.", Integer.valueOf(i2), cnb.Id, dVar.EEM);
            dVar.position = i2;
            if (Util.isNullOrNil(SnsInfoFlip.this.EEm) || !SnsInfoFlip.this.EEm.equals(cnb.Id)) {
                z = false;
            }
            if (cnb.Id.startsWith("Locall_path") && !Util.isNullOrNil(ZN(i2).parentId)) {
                SnsInfo snsInfo = (SnsInfo) SnsInfoFlip.this.EEq.get(ZN(i2).parentId);
                if (snsInfo == null) {
                    snsInfo = aj.faO().aQm(ZN(i2).parentId);
                    SnsInfoFlip.this.EEq.put(ZN(i2).parentId, snsInfo);
                }
                if (snsInfo == null) {
                    AppMethodBeat.o(98750);
                    return view;
                }
                TimeLineObject timeLine = snsInfo.getTimeLine();
                if (timeLine.ContentObj.LoV.size() > ZN(i2).DRJ) {
                    cnb = timeLine.ContentObj.LoV.get(ZN(i2).DRJ);
                }
            }
            String D = com.tencent.mm.plugin.sns.model.g.D(cnb);
            if (Util.isNullOrNil(D) || !SnsInfoFlip.aRa(D)) {
                a(dVar, i2, cnb, z);
            } else {
                Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use wxImageView.");
                dVar.EEM.setVisibility(8);
                dVar.xpO.setVisibility(0);
                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(D);
                if (imageOptions != null) {
                    dVar.xpO.setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(D));
                    dVar.xpO.cN(imageOptions.outWidth, imageOptions.outHeight);
                    dVar.xpO.gKy();
                    dVar.xpO.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b() {
                        /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c.AnonymousClass1 */

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void sb() {
                            AppMethodBeat.i(98738);
                            Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on preview loaded.");
                            AppMethodBeat.o(98738);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void n(Bitmap bitmap) {
                            AppMethodBeat.i(98739);
                            Log.d("MicroMsg.SnsGalleryAdapter", "pennqin, wxImageView, on image loaded.");
                            dVar.wSb.setVisibility(8);
                            dVar.kdb.setVisibility(8);
                            if (SnsInfoFlip.this.xqs != null && i2 == SnsInfoFlip.this.xqs.getCurrentItem()) {
                                SnsInfoFlip.this.EDY = dVar.xpO;
                            }
                            AppMethodBeat.o(98739);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void a(com.davemorrissey.labs.subscaleview.a.c cVar) {
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void b(com.davemorrissey.labs.subscaleview.a.c cVar) {
                            AppMethodBeat.i(203590);
                            Log.w("MicroMsg.SnsGalleryAdapter", "onImageLoadError, switch to multiTouchImageView");
                            c.a(c.this, dVar, i2, cnb, z);
                            AppMethodBeat.o(203590);
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void c(com.davemorrissey.labs.subscaleview.a.c cVar) {
                        }

                        @Override // com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.e
                        public final void sc() {
                        }
                    });
                    String encode = Uri.encode(s.k(com.tencent.mm.plugin.sns.model.g.r(cnb), false));
                    if (!Util.isNullOrNil(encode)) {
                        dVar.xpO.a(s.k(D, false), com.davemorrissey.labs.subscaleview.view.a.aP(encode));
                    }
                }
            }
            ZL(i2);
            AppMethodBeat.o(98750);
            return view;
        }

        @Override // com.tencent.mm.ui.base.v, android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(98751);
            viewGroup.removeView((View) obj);
            super.destroyItem(viewGroup, i2, obj);
            AppMethodBeat.o(98751);
        }

        /* access modifiers changed from: package-private */
        public final boolean ZK(int i2) {
            AppMethodBeat.i(98752);
            View abm = abm(i2);
            if (abm != null && NQ(i2) == null && NR(i2) == null) {
                k(i2, abm);
                AppMethodBeat.o(98752);
                return true;
            }
            AppMethodBeat.o(98752);
            return false;
        }

        private void a(final d dVar, final int i2, final cnb cnb, final boolean z) {
            boolean z2;
            AppMethodBeat.i(203591);
            final bp a2 = bp.a(SnsInfoFlip.this.DEv, ZN(i2).iXu);
            com.tencent.mm.plugin.sns.model.g faL = aj.faL();
            MultiTouchImageView multiTouchImageView = dVar.EEM;
            int hashCode = this.context.hashCode();
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            faL.a(cnb, multiTouchImageView, hashCode, z2, a2, y.aQH(ZN(i2).parentId), new g.e() {
                /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sns.model.g.e
                public final void ax(Bitmap bitmap) {
                    AppMethodBeat.i(98741);
                    if (!r.M(bitmap) && SnsInfoFlip.this.EAv && SnsInfoFlip.this.getSelectItem() != null) {
                        SnsInfoFlip.a(SnsInfoFlip.this, cnb.Id, SnsInfoFlip.this.getSelectItem().parentId, cnb.MsB, cnb);
                    }
                    if (!r.M(bitmap) && cnb.Id != null && !cnb.Id.startsWith("pre_temp_extend_pic")) {
                        Log.i("MicroMsg.SnsGalleryAdapter", "big image not ready, set loading img. position: %d, media id: %s.", Integer.valueOf(i2), cnb.Id);
                        dVar.wSb.setVisibility(0);
                        dVar.kdb.setVisibility(0);
                        dVar.kdb.setAlpha(0.1f);
                        dVar.kdb.animate().alpha(1.0f).setDuration(2000).setListener(null);
                        dVar.EEM.setVisibility(8);
                        dVar.xpO.setVisibility(8);
                        aj.faL().ff(dVar.wSb);
                        aj.faL().b(cnb, dVar.wSb, R.drawable.ban, c.this.context.hashCode(), a2);
                        if (z) {
                            dVar.kdb.setVisibility(8);
                            AppMethodBeat.o(98741);
                            return;
                        }
                    } else if (r.M(bitmap)) {
                        Log.i("MicroMsg.SnsGalleryAdapter", "pennqin, use multiTouchImageView, %s.", dVar.EEM);
                        dVar.EEM.setVisibility(0);
                        dVar.xpO.setVisibility(8);
                        dVar.EEM.setEnableHorLongBmpMode(SnsInfoFlip.this.EEg);
                        dVar.EEM.cN(bitmap.getWidth(), bitmap.getHeight());
                        dVar.EEM.setImageBitmap(null);
                        dVar.EEM.setImageBitmap(bitmap);
                        dVar.EEM.post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(98740);
                                dVar.wSb.setVisibility(8);
                                dVar.kdb.setVisibility(8);
                                AppMethodBeat.o(98740);
                            }
                        });
                        if (SnsInfoFlip.this.xqs != null && i2 == SnsInfoFlip.this.xqs.getCurrentItem()) {
                            SnsInfoFlip.this.EDY = dVar.EEM;
                        }
                    }
                    AppMethodBeat.o(98741);
                }
            });
            AppMethodBeat.o(203591);
        }

        private void ZL(int i2) {
            AppMethodBeat.i(98753);
            if (!this.qJf) {
                AppMethodBeat.o(98753);
            } else if (SnsInfoFlip.this.EDX == null) {
                AppMethodBeat.o(98753);
            } else if (!ag.dm(this.context)) {
                AppMethodBeat.o(98753);
            } else {
                if (i2 - 1 >= 0) {
                    ZM(i2 - 1);
                }
                if (i2 + 1 < SnsInfoFlip.this.EDX.getCount()) {
                    ZM(i2 + 1);
                }
                AppMethodBeat.o(98753);
            }
        }

        private void ZM(int i2) {
            AppMethodBeat.i(98754);
            cnb cnb = ZN(i2).ebR;
            bp a2 = bp.a(SnsInfoFlip.this.DEv, ZN(i2).iXu);
            if (cnb.oUv != 2) {
                AppMethodBeat.o(98754);
                return;
            }
            boolean aQH = y.aQH(ZN(i2).parentId);
            aj.faL();
            boolean a3 = com.tencent.mm.plugin.sns.model.g.a(cnb, a2, aQH);
            if (SnsInfoFlip.this.EAv && !a3) {
                SnsInfoFlip.a(SnsInfoFlip.this, cnb.Id, SnsInfoFlip.this.getSelectItem().parentId, cnb.MsB, cnb);
            }
            AppMethodBeat.o(98754);
        }

        @Override // android.support.v4.view.q
        public final void notifyDataSetChanged() {
            AppMethodBeat.i(98755);
            this.EED = true;
            super.notifyDataSetChanged();
            this.EED = false;
            this.EEA = SnsInfoFlip.this.iHf.size();
            Log.d("MicroMsg.SnsGalleryAdapter", "items.size: %d.", Integer.valueOf(this.EEA));
            if (this.EEA <= 0 && SnsInfoFlip.this.EEl != null) {
                SnsInfoFlip.this.EEl.run();
            }
            AppMethodBeat.o(98755);
        }

        public final com.tencent.mm.plugin.sns.j.b ZN(int i2) {
            AppMethodBeat.i(98756);
            if (i2 >= SnsInfoFlip.this.iHf.size() || i2 < 0) {
                AppMethodBeat.o(98756);
                return null;
            }
            com.tencent.mm.plugin.sns.j.b bVar = (com.tencent.mm.plugin.sns.j.b) SnsInfoFlip.this.iHf.get(i2);
            AppMethodBeat.o(98756);
            return bVar;
        }

        @Override // com.tencent.mm.ui.base.v, android.support.v4.view.q
        public final int getItemPosition(Object obj) {
            AppMethodBeat.i(98757);
            if (this.EED) {
                AppMethodBeat.o(98757);
                return -2;
            }
            int itemPosition = super.getItemPosition(obj);
            AppMethodBeat.o(98757);
            return itemPosition;
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        View EEL;
        MultiTouchImageView EEM;
        ProgressBar kdb;
        int position;
        String videoPath = "";
        ImageView wSb;
        WxImageView xpO;

        d() {
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public long getSnsId() {
        AppMethodBeat.i(98766);
        if (this.EDX == null) {
            AppMethodBeat.o(98766);
            return 0;
        }
        com.tencent.mm.plugin.sns.j.b ZN = this.EDX.ZN(this.xqs.getCurrentItem());
        String str = ZN == null ? "" : ZN.parentId;
        if (!Util.isNullOrNil(str)) {
            SnsInfo aQm = aj.faO().aQm(str);
            if (aQm == null) {
                AppMethodBeat.o(98766);
                return 0;
            }
            long j2 = aQm.field_snsId;
            AppMethodBeat.o(98766);
            return j2;
        }
        AppMethodBeat.o(98766);
        return 0;
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public int getPosition() {
        return this.EAk;
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public View getCurrentImageView() {
        if (this.EDY instanceof View) {
            return (View) this.EDY;
        }
        return null;
    }

    private void fig() {
        AppMethodBeat.i(98767);
        if (this.EDX == null || this.EDX.ZN(this.xqs.getCurrentItem()) == null) {
            AppMethodBeat.o(98767);
            return;
        }
        int currentItem = this.xqs.getCurrentItem();
        if (this.EEd && this.EDX.getCount() > 1) {
            this.EEk.setVisibility(0);
            this.EEk.setPage(currentItem);
        }
        cnb cnb = this.EDX.ZN(this.xqs.getCurrentItem()).ebR;
        this.EEr.add(cnb.Id);
        String str = this.EDX.ZN(this.xqs.getCurrentItem()).parentId;
        String str2 = cnb.Id;
        if (Util.isNullOrNil(this.EEm) || !this.EEm.equals(str2)) {
            this.EEm = "";
        }
        b(cnb, currentItem, str);
        AppMethodBeat.o(98767);
    }

    public final void vu(boolean z) {
        AppMethodBeat.i(179207);
        if (this.EDX != null) {
            Log.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            if (z) {
                this.EDX.notifyDataSetChanged();
            }
            fig();
        }
        AppMethodBeat.o(179207);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public final void onPause() {
        AppMethodBeat.i(98769);
        super.onPause();
        if (this.EDX != null) {
            this.EDX.fij();
            this.EDX.clear();
        }
        AppMethodBeat.o(98769);
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public MMViewPager getGallery() {
        return this.xqs;
    }

    public final int fih() {
        AppMethodBeat.i(98770);
        if (this.xqs == null || this.EDX == null) {
            AppMethodBeat.o(98770);
            return -1;
        }
        int currentItem = this.xqs.getCurrentItem();
        if (currentItem >= 0 && this.iHf.size() > currentItem) {
            this.iHf.remove(currentItem);
            this.EDX.notifyDataSetChanged();
            fig();
        }
        int count = this.EDX.getCount();
        AppMethodBeat.o(98770);
        return count;
    }

    public int getCount() {
        AppMethodBeat.i(98771);
        if (this.EDX != null) {
            int count = this.EDX.getCount();
            AppMethodBeat.o(98771);
            return count;
        }
        AppMethodBeat.o(98771);
        return 0;
    }

    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public cnb getCntMedia() {
        AppMethodBeat.i(98772);
        if (this.EDX != null) {
            int currentItem = this.xqs.getCurrentItem();
            if (this.iHf != null && currentItem < this.iHf.size()) {
                cnb cnb = this.EDX.ZN(currentItem).ebR;
                AppMethodBeat.o(98772);
                return cnb;
            }
        }
        AppMethodBeat.o(98772);
        return null;
    }

    public int getSelectCount() {
        AppMethodBeat.i(98773);
        int size = this.EEr.size();
        AppMethodBeat.o(98773);
        return size;
    }

    public int getNumOfFileExist() {
        AppMethodBeat.i(98774);
        int i2 = 0;
        int i3 = 0;
        for (com.tencent.mm.plugin.sns.j.b bVar : this.iHf) {
            aj.faL();
            if (s.YS(com.tencent.mm.plugin.sns.model.g.D(bVar.ebR))) {
                i3++;
            }
            int i4 = i2 + 1;
            if (i4 > 9) {
                break;
            }
            i2 = i4;
        }
        AppMethodBeat.o(98774);
        return i3;
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b, com.tencent.mm.plugin.sns.ui.FlipView
    public final void ci(String str, boolean z) {
        cnb cnb;
        cnb cnb2;
        int i2 = 0;
        AppMethodBeat.i(98775);
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(this.EDX == null);
        Log.i("MicroMsg.SnsInfoFlip", "onImageFinish, mediaId: %s, isOK: %s, null == adapter: %s.", objArr);
        if (this.EDX == null) {
            AppMethodBeat.o(98775);
            return;
        }
        if (!(z || this.EDX.ZN(this.xqs.getCurrentItem()) == null || (cnb2 = this.EDX.ZN(this.xqs.getCurrentItem()).ebR) == null || cnb2.Id == null || !cnb2.Id.equals(str))) {
            Toast.makeText(this.context, this.context.getString(R.string.h5t), 0).show();
            this.EEm = str;
        }
        this.EEs++;
        if (this.EAv) {
            Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", str, Boolean.valueOf(z));
            if (z && this.EEt.containsKey(str)) {
                a aVar = this.EEt.get(str);
                aVar.EEx = System.currentTimeMillis();
                aVar.networkType = getReportNetworkType();
                Log.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
            }
        }
        if (!(this.EDX.ZN(this.xqs.getCurrentItem()) == null || (cnb = this.EDX.ZN(this.xqs.getCurrentItem()).ebR) == null || cnb.Id == null || !cnb.Id.equals(str))) {
            Log.i("MicroMsg.SnsInfoFlip", "img download finish, refresh ui, media id: %s. and mediaLocal id %s", cnb.Id, Integer.valueOf(cnb.ecf));
            c cVar = this.EDX;
            int size = SnsInfoFlip.this.iHf.size();
            while (true) {
                if (i2 < size) {
                    com.tencent.mm.plugin.sns.j.b ZN = cVar.ZN(i2);
                    if (ZN != null && ZN.ebR.Id.equals(str)) {
                        cVar.ZK(i2);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (this.EAx) {
                F(cnb);
            }
        }
        AppMethodBeat.o(98775);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b, com.tencent.mm.plugin.sns.ui.FlipView
    public final void cj(String str, boolean z) {
        cnb cnb;
        AppMethodBeat.i(98776);
        Log.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z + " " + (this.EDX == null));
        if (this.EDX == null) {
            AppMethodBeat.o(98776);
            return;
        }
        if (!(z || this.EDX.ZN(this.xqs.getCurrentItem()) == null || (cnb = this.EDX.ZN(this.xqs.getCurrentItem()).ebR) == null || cnb.Id == null || !cnb.Id.equals(str))) {
            Toast.makeText(this.context, this.context.getString(R.string.h5u), 0).show();
            this.EEm = str;
        }
        this.EDX.notifyDataSetChanged();
        AppMethodBeat.o(98776);
    }

    public List<com.tencent.mm.plugin.sns.j.b> getFlipList() {
        return this.iHf;
    }

    /* access modifiers changed from: package-private */
    public class a {
        cnb DIq;
        long DOA = -1;
        int EEv = -1;
        long EEw = -1;
        long EEx = -1;
        cnd EEy;
        String EEz;
        String dJX = "";
        int iAC;
        int networkType;

        a() {
        }
    }

    private int getReportNetworkType() {
        AppMethodBeat.i(98777);
        Context context2 = MMApplicationContext.getContext();
        if (NetStatusUtil.is2G(context2)) {
            AppMethodBeat.o(98777);
            return 1;
        } else if (NetStatusUtil.is3G(context2)) {
            AppMethodBeat.o(98777);
            return 2;
        } else if (NetStatusUtil.is4G(context2)) {
            AppMethodBeat.o(98777);
            return 3;
        } else if (NetStatusUtil.isWifi(context2)) {
            AppMethodBeat.o(98777);
            return 4;
        } else {
            AppMethodBeat.o(98777);
            return 0;
        }
    }

    public final void fii() {
        AppMethodBeat.i(98778);
        for (a aVar : this.EEt.values()) {
            if (aVar.EEv != -1) {
                SnsInfo aQm = aj.faO().aQm(aVar.dJX);
                String str = ar.ki(aj.getAccSnsPath(), aVar.EEz) + r.l(aVar.DIq);
                BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
                int i2 = 0;
                int i3 = 0;
                int boW = (int) s.boW(str);
                if (imageOptions != null) {
                    i2 = imageOptions.outWidth;
                    i3 = imageOptions.outHeight;
                    boW = (int) s.boW(str);
                }
                int aBO = r.aBO(str);
                if (aVar.DIq.mediaType != 0) {
                    aBO = aVar.DIq.mediaType;
                }
                if (aQm != null) {
                    h.INSTANCE.a(11601, Integer.valueOf(aVar.iAC), Integer.valueOf(aVar.EEv), Long.valueOf(aVar.DOA), Integer.valueOf(aVar.networkType), 0, 0, Long.valueOf(aQm.field_snsId), Long.valueOf(aVar.EEw), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(boW), Integer.valueOf(aBO));
                    Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", Integer.valueOf(aVar.iAC), Integer.valueOf(aVar.EEv), Long.valueOf(aVar.DOA), Integer.valueOf(aVar.networkType), Long.valueOf(aQm.field_snsId), Long.valueOf(aVar.EEw), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(boW), Integer.valueOf(r.aBO(str)), str);
                }
            } else if (aVar.EEw != -1) {
                if (aVar.EEx != -1) {
                    aVar.EEv = 1;
                } else {
                    aVar.EEv = 2;
                    aVar.EEx = System.currentTimeMillis();
                }
                aVar.DOA = aVar.EEx - aVar.EEw;
                SnsInfo aQm2 = aj.faO().aQm(aVar.dJX);
                String str2 = ar.ki(aj.getAccSnsPath(), aVar.EEz) + r.l(aVar.DIq);
                BitmapFactory.Options imageOptions2 = BitmapUtil.getImageOptions(str2);
                int i4 = 0;
                int i5 = 0;
                int boW2 = (int) s.boW(str2);
                if (imageOptions2 != null) {
                    i4 = imageOptions2.outWidth;
                    i5 = imageOptions2.outHeight;
                    boW2 = (int) s.boW(str2);
                }
                int aBO2 = r.aBO(str2);
                if (aVar.DIq.mediaType != 0) {
                    aBO2 = aVar.DIq.mediaType;
                }
                if (aQm2 != null) {
                    h.INSTANCE.a(11601, Integer.valueOf(aVar.iAC), Integer.valueOf(aVar.EEv), Long.valueOf(aVar.DOA), Integer.valueOf(aVar.networkType), 0, 0, Long.valueOf(aQm2.field_snsId), Long.valueOf(aVar.EEw), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(boW2), Integer.valueOf(aBO2));
                    Log.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d ,publishid:%d,startTimes:%d,width:%d,height:%d,size:%d,mediaType:%d,path:%s", Integer.valueOf(aVar.iAC), Integer.valueOf(aVar.EEv), Long.valueOf(aVar.DOA), Integer.valueOf(aVar.networkType), Long.valueOf(aQm2.field_snsId), Long.valueOf(aVar.EEw), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(boW2), Integer.valueOf(r.aBO(str2)), str2);
                }
            }
        }
        this.EEt.clear();
        AppMethodBeat.o(98778);
    }

    public void setVideoScene(int i2) {
        this.Ewx = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.FlipView
    public final void onDestroy() {
        AppMethodBeat.i(98779);
        super.onDestroy();
        if (this.EDX != null) {
            this.EDX.detach();
            this.EDX = null;
        }
        AppMethodBeat.o(98779);
    }

    static /* synthetic */ void c(SnsInfoFlip snsInfoFlip) {
        AppMethodBeat.i(203594);
        if (snsInfoFlip.context instanceof SnsBrowseUI) {
            ((SnsBrowseUI) snsInfoFlip.context).cvQ();
            AppMethodBeat.o(203594);
        } else if (snsInfoFlip.EEe) {
            ((MMActivity) snsInfoFlip.context).finish();
            AppMethodBeat.o(203594);
        } else {
            snsInfoFlip.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsInfoFlip.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(98732);
                    if (SnsInfoFlip.this.Eqc != null && SnsInfoFlip.this.EEf) {
                        SnsInfoFlip.this.Eqc.ffK();
                    }
                    AppMethodBeat.o(98732);
                }
            });
            AppMethodBeat.o(203594);
        }
    }

    static /* synthetic */ boolean aRa(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(203596);
        boolean adl = com.tencent.mm.cq.b.adl(s.k(str, false));
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            z = true;
        } else {
            z = false;
        }
        if (1 == ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_big_image_opt, 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("MicroMsg.SnsInfoFlip", "isSupport: %s, isInnerVersion: %s, isOpen: %s, path: %s.", Boolean.valueOf(adl), Boolean.valueOf(z), Boolean.valueOf(z2), str);
        if (!adl || (!z && !z2)) {
            AppMethodBeat.o(203596);
            return false;
        }
        AppMethodBeat.o(203596);
        return true;
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str, String str2, cnd cnd, cnb cnb) {
        AppMethodBeat.i(203597);
        Log.printInfoStack("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", str);
        if (!snsInfoFlip.EEt.containsKey(str)) {
            a aVar = new a();
            aVar.iAC = snsInfoFlip.getCount();
            aVar.dJX = str2;
            aVar.networkType = snsInfoFlip.getReportNetworkType();
            aVar.EEw = System.currentTimeMillis();
            aVar.EEz = str;
            aVar.EEy = cnd;
            aVar.DIq = cnb;
            snsInfoFlip.EEt.put(str, aVar);
            Log.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
        AppMethodBeat.o(203597);
    }
}
