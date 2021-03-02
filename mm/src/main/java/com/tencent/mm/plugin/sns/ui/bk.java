package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.ContextMenu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.c.a;
import com.tencent.mm.plugin.sns.ad.timeline.c.b;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.a;
import com.tencent.mm.plugin.sns.ui.item.c;
import com.tencent.mm.plugin.sns.ui.item.d;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.i;
import com.tencent.mm.plugin.sns.ui.item.j;
import com.tencent.mm.plugin.sns.ui.item.m;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.item.o;
import com.tencent.mm.plugin.sns.ui.item.p;
import com.tencent.mm.plugin.sns.ui.item.r;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.blur.f;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class bk implements ac {
    public com.tencent.mm.plugin.sns.ui.d.c DQs;
    protected ScaleAnimation EAX;
    protected ScaleAnimation EAY;
    public boolean EAv = false;
    private f EBK = null;
    private IListener EBM = new IListener<wi>() {
        /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass5 */

        {
            AppMethodBeat.i(160722);
            this.__eventId = wi.class.getName().hashCode();
            AppMethodBeat.o(160722);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wi wiVar) {
            AppMethodBeat.i(99226);
            wi wiVar2 = wiVar;
            if (wiVar2 instanceof wi) {
                String str = wiVar2.ect.id;
                if (wiVar2.ect.type == 1) {
                    bk.c(bk.this, str);
                } else if (wiVar2.ect.type == 2) {
                    bk.d(bk.this, wiVar2.ect.id);
                }
            }
            AppMethodBeat.o(99226);
            return false;
        }
    };
    private IListener EBN = new IListener<wk>() {
        /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass1 */

        {
            AppMethodBeat.i(160720);
            this.__eventId = wk.class.getName().hashCode();
            AppMethodBeat.o(160720);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wk wkVar) {
            AppMethodBeat.i(99223);
            wk wkVar2 = wkVar;
            if (wkVar2 instanceof wk) {
                if (wkVar2.ecw.type == 1) {
                    bk.a(bk.this, wkVar2.ecw.id);
                } else if (wkVar2.ecw.type == 2) {
                    bk.b(bk.this, wkVar2.ecw.id);
                }
            }
            AppMethodBeat.o(99223);
            return false;
        }
    };
    private IListener EBO = new IListener<wl>() {
        /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass6 */

        {
            AppMethodBeat.i(160723);
            this.__eventId = wl.class.getName().hashCode();
            AppMethodBeat.o(160723);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wl wlVar) {
            AppMethodBeat.i(99227);
            wl wlVar2 = wlVar;
            if (wlVar2 instanceof wl) {
                String str = wlVar2.ecx.id;
                if (wlVar2.ecx.type == 1) {
                    bk.e(bk.this, str);
                } else if (wlVar2.ecx.type == 2) {
                    bk.f(bk.this, str);
                }
            }
            AppMethodBeat.o(99227);
            return false;
        }
    };
    public be EBe;
    private int EBh = 0;
    public j EBk;
    public br EBo;
    public int EFK = 0;
    public boolean EFL = false;
    protected HashMap<String, Integer> EFN = new HashMap<>();
    private Set<String> EKA = new HashSet();
    private HashMap<Integer, Class<? extends BaseTimeLineItem.BaseViewHolder>> EKB = new HashMap<>();
    public View.OnClickListener EKC;
    public View.OnClickListener EKD;
    public SnsPostDescPreloadTextView.b EKE;
    public View.OnClickListener EKF;
    public View.OnClickListener EKG;
    private HashMap<String, Boolean> EKH;
    private d EKI;
    protected aa EKk;
    public i EKl;
    protected LinkedList<SnsCommentCollapseLayout> EKm = new LinkedList<>();
    public HashMap<Integer, WeakReference<View>> EKn = new HashMap<>();
    View EKo;
    public PBool EKp = new PBool();
    public int EKq = -1;
    int EKr = 0;
    protected HashMap<String, a> EKs = new HashMap<>();
    protected HashMap<Integer, View> EKt = new HashMap<>();
    public l EKu;
    private Map<Integer, WeakReference<SnsCommentPreloadTextView>> EKv = new HashMap();
    public HashMap<String, String> EKw = new HashMap<>();
    private int EKx = 2;
    public boolean EKy = false;
    private boolean EKz = false;
    protected HashMap<String, Integer> Epp = new HashMap<>();
    public View.OnTouchListener EqE;
    public l contextMenuHelper;
    public MMActivity gte;
    private ListView hUI;
    protected MMHandler handler = new MMHandler();
    IListener lEl;
    public com.tencent.mm.ui.widget.b.a pqr;
    protected int requestType = 0;

    public interface a {
        String getKey();

        void vv(boolean z);
    }

    public interface b {
        boolean fiX();
    }

    public final void fiM() {
        AppMethodBeat.i(99237);
        this.Epp.clear();
        this.EFN.clear();
        AppMethodBeat.o(99237);
    }

    public final x fiN() {
        if (this.gte instanceof x) {
            return (x) this.gte;
        }
        return null;
    }

    public final SnsCommentCollapseLayout fiO() {
        AppMethodBeat.i(99238);
        if (this.EKm.size() == 0) {
            SnsCommentCollapseLayout snsCommentCollapseLayout = new SnsCommentCollapseLayout(this.gte);
            AppMethodBeat.o(99238);
            return snsCommentCollapseLayout;
        }
        SnsCommentCollapseLayout removeFirst = this.EKm.removeFirst();
        AppMethodBeat.o(99238);
        return removeFirst;
    }

    public final void a(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.i(99239);
        this.EKm.add(snsCommentCollapseLayout);
        AppMethodBeat.o(99239);
    }

    public final void fiP() {
        AppMethodBeat.i(203664);
        EventCenter.instance.removeListener(this.lEl);
        AppMethodBeat.o(203664);
    }

    public final boolean fiQ() {
        AppMethodBeat.i(99240);
        if (this.EKm != null) {
            this.EKm.clear();
        }
        if (this.EKB != null) {
            this.EKB.clear();
        }
        com.tencent.mm.pluginsdk.ui.span.l.clearCache();
        com.tencent.mm.kiss.widget.textview.c.hue.aBj();
        if (this.EKp.value) {
            ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_like_collapse_enable, 0);
        }
        if (this.EBK != null) {
            this.EBK.destroy();
            this.EBK = null;
        }
        AppMethodBeat.o(99240);
        return true;
    }

    static class d implements View.OnCreateContextMenuListener {
        private cnb DIq;
        private SnsInfo DsC;
        private TimeLineObject EpO;
        private String dJX;
        private View targetView;
        private String url;

        d() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(99236);
            Object tag = view.getTag();
            if (tag instanceof s) {
                s sVar = (s) tag;
                TimeLineObject timeLineObject = sVar.EpO;
                view.getContext();
                String aRg = bk.aRg(timeLineObject.ContentObj.Url);
                if (aRg == null || aRg.length() == 0) {
                    AppMethodBeat.o(99236);
                    return;
                }
                this.url = aRg;
                this.dJX = sVar.dHp;
                this.targetView = view;
                this.DIq = timeLineObject.ContentObj.LoV.size() > 0 ? timeLineObject.ContentObj.LoV.get(0) : null;
                this.DsC = aj.faO().aQm(this.dJX);
                this.EpO = timeLineObject;
                if (timeLineObject.ContentObj.LoU == 10 || timeLineObject.ContentObj.LoU == 13) {
                    AppMethodBeat.o(99236);
                    return;
                }
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    switch (timeLineObject.ContentObj.LoU) {
                        case 4:
                            contextMenu.add(0, 4, 0, view.getContext().getString(R.string.fn9));
                            break;
                        case 9:
                            contextMenu.add(0, 5, 0, view.getContext().getString(R.string.fn9));
                            break;
                        case 14:
                            contextMenu.add(0, 9, 0, view.getContext().getString(R.string.fn9));
                            break;
                        case 42:
                            contextMenu.add(0, 11, 0, view.getContext().getString(R.string.fn9));
                            break;
                        default:
                            contextMenu.add(0, 3, 0, view.getContext().getString(R.string.fn9));
                            break;
                    }
                }
                if (this.DsC != null && !this.DsC.getUserName().equals(aj.fau())) {
                    contextMenu.add(0, 8, 0, view.getContext().getString(R.string.bdg));
                }
            }
            AppMethodBeat.o(99236);
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(99241);
        this.EKk.notifyDataSetChanged();
        AppMethodBeat.o(99241);
    }

    public final void fiR() {
        AppMethodBeat.i(99242);
        this.EKk.ffM();
        AppMethodBeat.o(99242);
    }

    public bk(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.d.c cVar, i iVar, final aa aaVar) {
        AppMethodBeat.i(99243);
        this.EKB.put(6, o.a.class);
        this.EKB.put(2, m.a.class);
        this.EKB.put(3, m.a.class);
        this.EKB.put(4, m.a.class);
        this.EKB.put(5, m.a.class);
        this.EKB.put(0, m.a.class);
        this.EKB.put(24, j.a.class);
        this.EKB.put(1, m.a.class);
        this.EKB.put(7, m.a.class);
        this.EKB.put(8, m.a.class);
        this.EKB.put(9, m.a.class);
        this.EKB.put(11, p.b.class);
        this.EKB.put(13, a.C1738a.class);
        this.EKB.put(14, f.a.class);
        this.EKB.put(15, n.a.class);
        this.EKB.put(10, m.a.class);
        this.EKB.put(12, m.a.class);
        this.EKB.put(16, m.a.class);
        this.EKB.put(17, h.a.class);
        this.EKB.put(18, d.a.class);
        this.EKB.put(20, c.a.class);
        this.EKB.put(25, c.a.class);
        this.EKB.put(21, i.a.class);
        this.EKB.put(19, b.a.class);
        this.EKB.put(22, r.a.class);
        this.EKB.put(23, a.C1708a.class);
        this.EKC = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(99228);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
                bk.this.EKl.EoH = false;
                com.tencent.mm.plugin.sns.abtest.a.eWu();
                if (!(view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                    Log.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99228);
                    return;
                }
                BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                if (baseViewHolder.timeLineObject != null && baseViewHolder.timeLineObject.ContentObj.LoU == 21) {
                    cnc cnc = baseViewHolder.postInfo;
                    if (!z.aTY().equals(baseViewHolder.timeLineObject.UserName) && (cnc == null || cnc.egZ == 0)) {
                        com.tencent.mm.plugin.sns.lucky.ui.a.f(bk.this.gte, baseViewHolder.EWX.ZD(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99228);
                        return;
                    }
                }
                if (baseViewHolder.isAd) {
                    com.tencent.mm.plugin.sns.ad.i.i.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(baseViewHolder.dHp, view, bk.this.EKl.EoE));
                }
                if (bk.this.gte instanceof x) {
                    ((x) bk.this.gte).fv(view);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99228);
            }
        };
        this.EKD = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(99229);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99229);
                    return;
                }
                BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                if (baseViewHolder == null || baseViewHolder.isAd) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99229);
                } else if (bk.this.Epp.containsKey(baseViewHolder.dHp) && bk.this.Epp.get(baseViewHolder.dHp).equals(0)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99229);
                } else if (!bk.this.Epp.containsKey(baseViewHolder.dHp) || !bk.this.Epp.get(baseViewHolder.dHp).equals(1)) {
                    bk.this.Epp.put(baseViewHolder.dHp, 1);
                    bk.this.EKk.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99229);
                } else {
                    bk.this.Epp.put(baseViewHolder.dHp, 2);
                    bk.this.EKk.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99229);
                }
            }
        };
        this.EKE = new SnsPostDescPreloadTextView.b() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView.b
            public final void fiW() {
                AppMethodBeat.i(203661);
                bk.this.EKk.notifyDataSetChanged();
                AppMethodBeat.o(203661);
            }
        };
        this.EKF = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(99231);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!bk.this.EFL || bk.this.EFK <= 0) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99231);
                } else if (!(view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99231);
                } else {
                    BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                    if (baseViewHolder == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99231);
                        return;
                    }
                    Log.d("MicroMsg.SnsTimeLineBaseAdapter", "likeCollapListener onclick %s", baseViewHolder.dHp);
                    if (!bk.this.EFN.containsKey(baseViewHolder.dHp) || (!bk.this.EFN.get(baseViewHolder.dHp).equals(1) && !bk.this.EFN.get(baseViewHolder.dHp).equals(3))) {
                        bk.this.EFN.put(baseViewHolder.dHp, 1);
                        e.DUQ.cm(com.tencent.mm.plugin.sns.data.r.Jb(baseViewHolder.EWu), false);
                    } else {
                        bk.this.EFN.put(baseViewHolder.dHp, 2);
                        e.DUQ.cm(com.tencent.mm.plugin.sns.data.r.Jb(baseViewHolder.EWu), true);
                    }
                    bk.this.EKk.notifyDataSetChanged();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99231);
                }
            }
        };
        this.EKG = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(203662);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getParent() == null || !(view.getParent() instanceof SnsCommentCollapseLayout)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203662);
                } else if (((SnsCommentCollapseLayout) view.getParent()).getTag() == null || !(((SnsCommentCollapseLayout) view.getParent()).getTag() instanceof m)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203662);
                } else {
                    m mVar = (m) ((SnsCommentCollapseLayout) view.getParent()).getTag();
                    if (mVar == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203662);
                        return;
                    }
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("sns_text_show", mVar.iAc);
                        intent.putExtra("sns_local_id", mVar.Epu);
                        intent.putExtra("sns_comment_buf", mVar.DIu.toByteArray());
                        intent.setClass(bk.this.gte, SnsSingleTextViewUI.class);
                        MMActivity mMActivity = bk.this.gte;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        mMActivity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", e2, "commentCollapse click exception.", new Object[0]);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203662);
                }
            }
        };
        this.EqE = Util.genLinearPressedListener();
        this.EKH = new HashMap<>();
        this.EKI = new d();
        this.lEl = new IListener<mx>() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass4 */

            {
                AppMethodBeat.i(203659);
                this.__eventId = mx.class.getName().hashCode();
                AppMethodBeat.o(203659);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mx mxVar) {
                AppMethodBeat.i(203660);
                mx mxVar2 = mxVar;
                if (mxVar2 instanceof mx) {
                    switch (mxVar2.dSE.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                            bk.this.EKk.notifyDataSetChanged();
                            break;
                    }
                }
                AppMethodBeat.o(203660);
                return false;
            }
        };
        this.EKk = aaVar;
        this.EKl = iVar;
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.hUI = listView;
        aj.faL();
        this.gte = mMActivity;
        this.DQs = cVar;
        this.contextMenuHelper = new l(mMActivity);
        this.pqr = new com.tencent.mm.ui.widget.b.a(mMActivity);
        this.EBe = new be(mMActivity);
        this.EAX = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.EAX.setDuration(150);
        this.EAY = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.EAY.setDuration(150);
        this.EBk = new j(mMActivity, 0, iVar.EoF);
        this.EKu = new l(iVar);
        this.requestType = 10;
        this.EBo = new br(mMActivity, new br.a() {
            /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.sns.ui.br.a
            public final void dWI() {
                AppMethodBeat.i(203663);
                aaVar.notifyDataSetChanged();
                AppMethodBeat.o(203663);
            }
        }, 0, iVar.EoF);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            this.EFK = this.EKx;
            this.EFL = true;
        } else {
            try {
                this.EFK = Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().gA(b.a.clicfg_sns_like_collapse_lines.name(), AppEventsConstants.EVENT_PARAM_VALUE_NO));
                this.EFL = Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().gA(b.a.clicfg_sns_like_collapse_enable.name(), AppEventsConstants.EVENT_PARAM_VALUE_NO)) == 1;
            } catch (NumberFormatException e2) {
                Log.w("MicroMsg.SnsTimeLineBaseAdapter", "parse like collapse config error: %s", e2.getMessage());
            }
        }
        this.EBK = new com.tencent.mm.ui.blur.f(mMActivity);
        this.EKy = g.aAh().azQ().getInt(ar.a.USERINFO_SNS_WS_FOLD_DEBUG_INT_SYNC, 0) == 1;
        EventCenter.instance.addListener(this.lEl);
        this.EKz = Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_sns_timeline_skip_crash_item", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true)) > 0;
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("SnsTimelineMMKV");
        String string = mmkv.getString("SnsTimelineMMKVLastShowItemId", "");
        if (!Util.isNullOrNil(string)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 91);
            mmkv.encode("SnsTimelineMMKVLastShowItemId", "");
            String string2 = mmkv.getString("SnsTimelineMMKVLastCrashItemId", "");
            if (Util.isNullOrNil(string2) || !string2.equals(string)) {
                mmkv.encode("SnsTimelineMMKVLastCrashItemId", string);
                mmkv.encode("SnsTimelineMMKVLastCrashItemCount", 1);
            } else {
                int i2 = mmkv.getInt("SnsTimelineMMKVLastCrashItemCount", 0) + 1;
                if (i2 >= Util.safeParseInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_sns_timeline_skip_crash_item_count", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, false, true))) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 92);
                    Set<String> stringSet = mmkv.getStringSet("SnsTimelineMMKVNeedSkipItem", new HashSet());
                    stringSet = stringSet.size() > 10 ? new HashSet<>() : stringSet;
                    stringSet.add(string2);
                    mmkv.encode("SnsTimelineMMKVNeedSkipItem", stringSet);
                    mmkv.encode("SnsTimelineMMKVLastCrashItemId", "");
                    mmkv.encode("SnsTimelineMMKVLastCrashItemCount", 0);
                } else {
                    mmkv.encode("SnsTimelineMMKVLastCrashItemCount", i2);
                }
            }
        }
        if (this.EKz) {
            this.EKA = mmkv.getStringSet("SnsTimelineMMKVNeedSkipItem", new HashSet());
        }
        AppMethodBeat.o(99243);
    }

    public final void fiS() {
        AppMethodBeat.i(99244);
        int firstVisiblePosition = this.hUI.getFirstVisiblePosition() - this.hUI.getHeaderViewsCount();
        int lastVisiblePosition = this.hUI.getLastVisiblePosition() - this.hUI.getHeaderViewsCount();
        Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.EKk.getCount();
        int i2 = firstVisiblePosition;
        while (i2 <= lastVisiblePosition && i2 < count) {
            SnsInfo Zv = Zv(i2);
            View view = this.EKt.get(Integer.valueOf(i2));
            if (view == null || Zv == null || view.getTag() == null) {
                Log.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i2)));
            } else {
                BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                Log.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i2 + " " + baseViewHolder.position);
                baseViewHolder.EXx.a(baseViewHolder, i2, Zv, this.EKk.Zw(i2));
            }
            i2++;
        }
        AppMethodBeat.o(99244);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View o(int r17, android.view.View r18) {
        /*
        // Method dump skipped, instructions count: 706
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.bk.o(int, android.view.View):android.view.View");
    }

    private static ArrayList<au.b> aRe(String str) {
        AppMethodBeat.i(203665);
        ArrayList<au.b> arrayList = new ArrayList<>();
        if (au.fbC().size() <= 0) {
            AppMethodBeat.o(203665);
            return arrayList;
        }
        for (String str2 : au.fbC().keySet()) {
            if (str2.startsWith(str)) {
                au.b bVar = au.fbC().get(str2);
                if (au.c(bVar)) {
                    arrayList.add(bVar);
                }
            }
        }
        AppMethodBeat.o(203665);
        return arrayList;
    }

    public final int getItemViewType(int i2) {
        int g2;
        AppMethodBeat.i(99246);
        SnsInfo Zv = this.EKk.Zv(i2);
        if (this.EKl.ffo() == 1) {
            g2 = g(Zv, false);
        } else {
            g2 = g(Zv, true);
        }
        AppMethodBeat.o(99246);
        return g2;
    }

    public final aa fiT() {
        return this.EKk;
    }

    protected static int g(SnsInfo snsInfo, boolean z) {
        AppMethodBeat.i(99247);
        TimeLineObject timeLine = snsInfo.getTimeLine();
        if (z && snsInfo.isWsFold()) {
            AppMethodBeat.o(99247);
            return 22;
        } else if (timeLine.ContentObj.LoU != 1) {
            switch (timeLine.ContentObj.LoU) {
                case 2:
                    AppMethodBeat.o(99247);
                    return 6;
                case 3:
                case 6:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 30:
                case 31:
                case 32:
                case 35:
                case 40:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                default:
                    AppMethodBeat.o(99247);
                    return 1;
                case 4:
                    String str = timeLine.AppInfo != null ? timeLine.AppInfo.Id : "";
                    com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
                    if (com.tencent.mm.plugin.comm.a.akQ(str)) {
                        AppMethodBeat.o(99247);
                        return 24;
                    }
                    com.tencent.mm.plugin.comm.a aVar2 = com.tencent.mm.plugin.comm.a.qCo;
                    if (!com.tencent.mm.plugin.comm.a.cAI()) {
                        AppMethodBeat.o(99247);
                        return 0;
                    }
                    AppMethodBeat.o(99247);
                    return 1;
                case 5:
                    if (snsInfo.isAd() && snsInfo.getAdXml() != null) {
                        if (snsInfo.getAdXml().isCardAd()) {
                            AppMethodBeat.o(99247);
                            return 13;
                        } else if (snsInfo.isFullCardAd()) {
                            AppMethodBeat.o(99247);
                            return 14;
                        } else if (snsInfo.isSphereCardAd()) {
                            AppMethodBeat.o(99247);
                            return 15;
                        }
                    }
                    AppMethodBeat.o(99247);
                    return 1;
                case 7:
                    AppMethodBeat.o(99247);
                    return 2;
                case 8:
                    AppMethodBeat.o(99247);
                    return 3;
                case 14:
                    AppMethodBeat.o(99247);
                    return 7;
                case 15:
                    if (z && timeLine.sightFolded == 1) {
                        AppMethodBeat.o(99247);
                        return 12;
                    } else if (!snsInfo.isAd() || snsInfo.getAdXml() == null) {
                        AppMethodBeat.o(99247);
                        return 9;
                    } else if (snsInfo.getAdXml().isCardAd()) {
                        AppMethodBeat.o(99247);
                        return 13;
                    } else if (snsInfo.isFullCardAd()) {
                        AppMethodBeat.o(99247);
                        return 14;
                    } else if (snsInfo.isSphereCardAd()) {
                        AppMethodBeat.o(99247);
                        return 15;
                    } else if (snsInfo.isFinderTopicCardAd()) {
                        AppMethodBeat.o(99247);
                        return 23;
                    } else {
                        AppMethodBeat.o(99247);
                        return 19;
                    }
                case 21:
                    AppMethodBeat.o(99247);
                    return 10;
                case 27:
                    AppMethodBeat.o(99247);
                    return 11;
                case 28:
                    AppMethodBeat.o(99247);
                    return 18;
                case 29:
                case 37:
                case 38:
                    AppMethodBeat.o(99247);
                    return 16;
                case 33:
                    AppMethodBeat.o(99247);
                    return 17;
                case 34:
                    AppMethodBeat.o(99247);
                    return 20;
                case 36:
                    AppMethodBeat.o(99247);
                    return 21;
                case 39:
                    switch (timeLine.ContentObj.izD) {
                        case 3:
                        case XWalkEnvironment.TEST_APK_START_VERSION /*{ENCODED_INT: 100000000}*/:
                            AppMethodBeat.o(99247);
                            return 16;
                        default:
                            AppMethodBeat.o(99247);
                            return 1;
                    }
                case 42:
                    AppMethodBeat.o(99247);
                    return 24;
                case 43:
                    AppMethodBeat.o(99247);
                    return 25;
            }
        } else if (!z || timeLine.showFlag != 1) {
            if (snsInfo.isAd() && snsInfo.getAdXml() != null) {
                if (snsInfo.getAdXml().isCardAd()) {
                    AppMethodBeat.o(99247);
                    return 13;
                } else if (snsInfo.isFullCardAd()) {
                    AppMethodBeat.o(99247);
                    return 14;
                } else if (snsInfo.isSphereCardAd()) {
                    AppMethodBeat.o(99247);
                    return 15;
                }
            }
            int size = timeLine.ContentObj.LoV.size();
            if (size <= 1) {
                AppMethodBeat.o(99247);
                return 2;
            } else if (size <= 3) {
                AppMethodBeat.o(99247);
                return 3;
            } else if (size <= 6) {
                AppMethodBeat.o(99247);
                return 4;
            } else {
                AppMethodBeat.o(99247);
                return 5;
            }
        } else {
            AppMethodBeat.o(99247);
            return 12;
        }
    }

    public static int Y(SnsInfo snsInfo) {
        AppMethodBeat.i(259461);
        int g2 = g(snsInfo, true);
        AppMethodBeat.o(259461);
        return g2;
    }

    public static String aRf(String str) {
        AppMethodBeat.i(99249);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(99249);
        } else {
            int indexOf = str.indexOf("://");
            if (indexOf != -1) {
                str = str.substring(indexOf + 3);
            }
            int indexOf2 = str.indexOf(FilePathGenerator.ANDROID_DIR_SEP);
            if (indexOf2 != -1) {
                str = str.substring(0, indexOf2);
            }
            AppMethodBeat.o(99249);
        }
        return str;
    }

    public static String a(TimeLineObject timeLineObject, Context context) {
        AppMethodBeat.i(99250);
        String e2 = com.tencent.mm.plugin.sns.c.a.jRu.e(context, timeLineObject.AppInfo.Id, "timeline");
        AppMethodBeat.o(99250);
        return e2;
    }

    public static String aRg(String str) {
        AppMethodBeat.i(99251);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(str)));
        String R = com.tencent.mm.plugin.sns.c.a.jRu.R(str, "timeline");
        AppMethodBeat.o(99251);
        return R;
    }

    public final void aB(Runnable runnable) {
        AppMethodBeat.i(99252);
        this.EKk.ffM();
        runnable.run();
        AppMethodBeat.o(99252);
    }

    public final void H(boolean z, String str) {
        AppMethodBeat.i(99253);
        a aVar = this.EKs.get(str);
        if (aVar != null && Util.isEqual(aVar.getKey(), str)) {
            aVar.vv(z);
        }
        AppMethodBeat.o(99253);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(99254);
        if (aVar != null) {
            this.EKs.put(str, aVar);
        }
        AppMethodBeat.o(99254);
    }

    public final void fiU() {
        AppMethodBeat.i(99255);
        this.EKs.clear();
        AppMethodBeat.o(99255);
    }

    public final void fz(View view) {
        AppMethodBeat.i(99256);
        if (!(view.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            AppMethodBeat.o(99256);
            return;
        }
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
        if (this.EKo != null && this.EKo.getVisibility() == 0) {
            this.EKo.startAnimation(this.EAY);
            this.EAY.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.plugin.sns.ui.bk.AnonymousClass3 */

                {
                    AppMethodBeat.i(160721);
                    AppMethodBeat.o(160721);
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(203658);
                    if (bk.this.EKo != null) {
                        bk.this.EKo.clearAnimation();
                        bk.this.EKo.setVisibility(8);
                    }
                    bk.this.EKo = null;
                    AppMethodBeat.o(203658);
                }
            });
        }
        AppMethodBeat.o(99256);
    }

    public final SnsInfo Zv(int i2) {
        AppMethodBeat.i(99257);
        SnsInfo Zv = this.EKk.Zv(i2);
        AppMethodBeat.o(99257);
        return Zv;
    }

    public final int getCount() {
        AppMethodBeat.i(99258);
        int count = this.EKk.getCount();
        AppMethodBeat.o(99258);
        return count;
    }

    public static boolean aMJ(String str) {
        AppMethodBeat.i(203667);
        if (!com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(203667);
            return false;
        }
        com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
        if (bef == null || !com.tencent.mm.ay.a.e(bef) || !str.equals(bef.jeV)) {
            AppMethodBeat.o(203667);
            return false;
        }
        AppMethodBeat.o(203667);
        return true;
    }

    public final void onPause() {
        AppMethodBeat.i(203668);
        EventCenter.instance.removeListener(this.EBN);
        EventCenter.instance.removeListener(this.EBM);
        EventCenter.instance.removeListener(this.EBO);
        AppMethodBeat.o(203668);
    }

    public final void onResume() {
        AppMethodBeat.i(203669);
        EventCenter.instance.addListener(this.EBN);
        EventCenter.instance.addListener(this.EBM);
        EventCenter.instance.addListener(this.EBO);
        AppMethodBeat.o(203669);
    }

    public final com.tencent.mm.ui.widget.b.a fiV() {
        AppMethodBeat.i(99260);
        if (this.pqr != null) {
            this.pqr.gNq();
        }
        this.pqr = new com.tencent.mm.ui.widget.b.a(this.gte);
        com.tencent.mm.ui.widget.b.a aVar = this.pqr;
        AppMethodBeat.o(99260);
        return aVar;
    }

    public static class c implements ay.b.a {
        aa EKM = null;
        int mPosition;

        public c(aa aaVar, int i2) {
            this.EKM = aaVar;
            this.mPosition = i2;
        }

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(99235);
            if (z) {
                g.aAi();
                if (g.aAf().azp()) {
                    aj.dRd().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.bk.c.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(99234);
                            if (c.this.EKM.ffN() != null) {
                                c.this.EKM.ffN().request(Integer.valueOf(c.this.mPosition));
                            }
                            c.this.EKM.notifyDataSetChanged();
                            AppMethodBeat.o(99234);
                        }
                    });
                }
            }
            AppMethodBeat.o(99235);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.ac
    public final boolean Zx(int i2) {
        AppMethodBeat.i(99259);
        if (i2 < this.hUI.getFirstVisiblePosition() - 1 || i2 > this.hUI.getLastVisiblePosition() - 1) {
            AppMethodBeat.o(99259);
            return false;
        }
        AppMethodBeat.o(99259);
        return true;
    }

    static /* synthetic */ void a(bk bkVar, String str) {
        AppMethodBeat.i(99261);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateStart, id: %s", str);
        SnsInfo aQl = aj.faO().aQl(str);
        if (aQl != null) {
            String localid = aQl.getLocalid();
            if (bkVar.Epp.containsKey(localid) && bkVar.Epp.get(localid).equals(1)) {
                bkVar.Epp.put(localid, 2);
            }
            au.fA(str, 2);
            bkVar.notifyDataSetChanged();
        }
        AppMethodBeat.o(99261);
    }

    static /* synthetic */ void b(bk bkVar, String str) {
        AppMethodBeat.i(99262);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateStart, id: %s", str);
        au.fA(str, 2);
        bkVar.notifyDataSetChanged();
        AppMethodBeat.o(99262);
    }

    static /* synthetic */ void c(bk bkVar, String str) {
        AppMethodBeat.i(99263);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", str);
        au.fA(str, 2);
        bkVar.notifyDataSetChanged();
        AppMethodBeat.o(99263);
    }

    static /* synthetic */ void d(bk bkVar, String str) {
        AppMethodBeat.i(99264);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", str);
        au.fA(str, 2);
        bkVar.notifyDataSetChanged();
        AppMethodBeat.o(99264);
    }

    static /* synthetic */ void e(bk bkVar, String str) {
        AppMethodBeat.i(99265);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", str);
        au.fB(str, 2);
        bkVar.notifyDataSetChanged();
        AppMethodBeat.o(99265);
    }

    static /* synthetic */ void f(bk bkVar, String str) {
        AppMethodBeat.i(99266);
        Log.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", str);
        au.fB(str, 2);
        bkVar.notifyDataSetChanged();
        AppMethodBeat.o(99266);
    }
}
