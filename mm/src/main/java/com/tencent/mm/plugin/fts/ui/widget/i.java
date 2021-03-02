package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.t;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class i implements View.OnFocusChangeListener, com.tencent.mm.ak.i {
    public View contentView;
    public boolean dDz = false;
    public ImageView gvv;
    public long mZq;
    public String query;
    private long wXS;
    public long xaI;
    private View xaW;
    private View xaX;
    public View xaY;
    private View xaZ;
    public int xat = 1;
    public LinearLayout xba;
    public TextView xbb;
    private TextView xbc;
    private czf xbd;
    public long xbf;
    public MMHandler xeO = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(112332);
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (message.obj.equals(Long.valueOf(i.this.xbf))) {
                        i.this.a(b.Timeout);
                        i.this.wXS = System.currentTimeMillis();
                        Log.i("MicroMsg.FTS.PardusSearchLogic", "cancel Time %d", Long.valueOf(i.this.wXS - i.this.xaI));
                        l.N(i.this.xbf, 5);
                        i.this.dOG();
                        i.this.cHi();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(112332);
        }
    };
    public View xeb;
    public TextView xec;
    public FTSMainUI xfV;
    private final int xfX = 3;
    public View xfY;
    private int xfZ = 0;
    public TextView xgA;
    public j xgB;
    public u xgC;
    public b xgD = b.None;
    public boolean xgE = false;
    public boolean xgF = false;
    private boolean xgG = false;
    private boolean xgH = false;
    private t xgI;
    private long xgJ;
    private long xgK = 60;
    private View.OnClickListener xgL = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(112336);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            alv alv = (alv) view.getTag();
            i.this.J(alv.Lux.MGp, 22, alv.Lux.MEq);
            i.this.xfV.xbX.xby = true;
            l.a(i.this.query, 1, 1, i.this.xfV.mve, i.this.xfV.xbX.xbD, 28, "", "", "");
            i.this.xfV.xbX.xbD.Nv(28);
            i.a(i.this, 0, "", "", "", alv.Lux.MEq, alv.xuA + 1, "");
            i.this.Nz(6);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(112336);
        }
    };
    private View.OnClickListener xgM = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass12 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(112343);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            sa saVar = (sa) view.getTag();
            switch (saVar.oUv) {
                case 512:
                case 4194304:
                    int i3 = 2;
                    if (!i.this.xgF) {
                        i3 = 1;
                    }
                    czb first = saVar.KZF.getFirst();
                    i.this.a(first.MEm);
                    if (saVar.oUv == 512) {
                        i2 = 7;
                    } else {
                        i2 = saVar.oUv == 4194304 ? 6 : 0;
                    }
                    String ayQ = l.ayQ(first.MEl.Title);
                    l.a(i.this.query, i3, 1, i.this.xfV.mve, i.this.xfV.xbX.xbD, 27, i2 + "$" + ayQ, first.MEl.MEq, "");
                    i.this.xfV.xbX.xbD.Nv(27);
                    i.a(i.this, saVar.oUv, first.MEl.MEq, ayQ, "", "", 0, "");
                    Log.i("MicroMsg.FTS.PardusSearchLogic", "click result %d %s %s", Integer.valueOf(i2), ayQ, first.MEl.MEq);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(112343);
        }
    };
    private IListener<mx> xgN = new IListener<mx>() {
        /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass4 */

        {
            AppMethodBeat.i(161158);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(161158);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        @SuppressLint({"ResourceType"})
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(112335);
            mx mxVar2 = mxVar;
            if (mxVar2.dSE.action == 3 || mxVar2.dSE.action == 2) {
                f bef = com.tencent.mm.ay.a.bef();
                Log.i("MicroMsg.FTS.PardusSearchLogic", "onStop MusicId:%s DocId:%s", bef.jeV, i.k(i.this));
                if (bef.jfl.equals(i.k(i.this))) {
                    i.this.xgw.setImageResource(R.raw.pardus_music_video_icon);
                }
            } else if (mxVar2.dSE.action == 0) {
                f bef2 = com.tencent.mm.ay.a.bef();
                Log.i("MicroMsg.FTS.PardusSearchLogic", "onStart MusicId:%s DocId:%s", bef2.jeV, i.k(i.this));
                if (bef2.jfl.equals(i.k(i.this))) {
                    i.this.xgw.setImageResource(R.raw.pardus_music_pause_icon);
                }
            }
            AppMethodBeat.o(112335);
            return false;
        }
    };
    private int xga = 0;
    private int xgb = 0;
    public View xgc;
    public TextView xgd;
    public TextView xge;
    public TextView xgf;
    public View xgg;
    public View xgh;
    public TextView xgi;
    public TextView xgj;
    public View xgk;
    public ImageView xgl;
    public TextView xgm;
    public TextView xgn;
    public TextView xgo;
    public TextView xgp;
    public View xgq;
    public ImageView xgr;
    public TextView xgs;
    public TextView xgt;
    public TextView xgu;
    public View xgv;
    public ImageView xgw;
    public ImageView xgx;
    public TextView xgy;
    public TextView xgz;

    public i(FTSMainUI fTSMainUI) {
        AppMethodBeat.i(112351);
        this.xfV = fTSMainUI;
        this.xfZ = com.tencent.mm.cb.a.jn(fTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix((Context) fTSMainUI.getContext(), 100);
        this.xga = com.tencent.mm.cb.a.jn(fTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix((Context) fTSMainUI.getContext(), 116);
        this.xgb = com.tencent.mm.cb.a.jn(fTSMainUI.getContext()) - com.tencent.mm.cb.a.fromDPToPix((Context) fTSMainUI.getContext(), 48);
        dQb();
        AppMethodBeat.o(112351);
    }

    public final void dOG() {
        AppMethodBeat.i(112352);
        this.xeO.removeMessages(1);
        if (this.xgC != null) {
            g.azz().a(this.xgC);
            g.azz().b(1076, this);
            this.xgC = null;
        }
        AppMethodBeat.o(112352);
    }

    public final void clearData() {
        AppMethodBeat.i(112353);
        this.xgD = b.None;
        this.xat = 1;
        this.xbf = 0;
        this.xaI = 0;
        this.wXS = 0;
        this.xgE = false;
        this.xgF = false;
        this.dDz = false;
        this.xgH = false;
        this.query = null;
        this.xbd = null;
        this.xgN.dead();
        if (this.xgB != null) {
            this.xgB.clearData();
        }
        AppMethodBeat.o(112353);
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(112354);
        Log.i("MicroMsg.FTS.PardusSearchLogic", "onFocusChange %b", Boolean.valueOf(z));
        if (z) {
            dQb();
        }
        AppMethodBeat.o(112354);
    }

    private void dQb() {
        AppMethodBeat.i(112355);
        if (System.currentTimeMillis() - this.xgJ > this.xgK * 1000) {
            Log.i("MicroMsg.FTS.PardusSearchLogic", "start to request pre search");
            dQc();
            this.xgI = new t(new cyz());
            g.azz().a(1417, this);
            g.azz().a(this.xgI, 0);
            this.xgJ = System.currentTimeMillis();
        }
        AppMethodBeat.o(112355);
    }

    public final void dQc() {
        AppMethodBeat.i(112356);
        if (this.xgI != null) {
            g.azz().a(this.xgI);
            g.azz().b(1417, this);
            this.xgI = null;
        }
        AppMethodBeat.o(112356);
    }

    @TargetApi(8)
    public final void dQd() {
        AppMethodBeat.i(112357);
        if (this.contentView != null) {
            this.xfV.pu(true);
            this.contentView.clearAnimation();
            this.contentView.setVisibility(8);
        }
        if (this.xba != null) {
            this.xba.removeAllViews();
            this.xba.setVisibility(8);
        }
        if (this.xaX != null) {
            this.xaX.setVisibility(8);
        }
        if (this.xaY != null) {
            this.xaY.setVisibility(8);
        }
        if (this.xgB != null) {
            this.xgB.dQf();
        }
        AppMethodBeat.o(112357);
    }

    public final void Nz(int i2) {
        AppMethodBeat.i(184532);
        if (!this.xgH && !Util.isNullOrNil(this.query)) {
            ar.q(this.query, this.xat, i2, 3);
            this.xgH = true;
        }
        AppMethodBeat.o(184532);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4 = 0;
        AppMethodBeat.i(112359);
        if (qVar.equals(this.xgI)) {
            g.azz().b(1417, this);
            if (i2 == 0 && i3 == 0) {
                this.xgK = (long) this.xgI.IDB.MEk;
                Log.i("MicroMsg.FTS.PardusSearchLogic", "pardusCacheExpireTime %d", Long.valueOf(this.xgK));
                AppMethodBeat.o(112359);
                return;
            }
        } else if (qVar.equals(this.xgC) && this.xgC.IDD.Mba.equals(String.valueOf(this.xbf))) {
            a(b.ReturnResult);
            this.xeO.removeMessages(1);
            g.azz().b(1076, this);
            if (i2 == 0 && i3 == 0) {
                l.N(this.xbf, 4);
                this.xbd = this.xgC.IDC;
                this.xgG = this.xbd != null && !Util.isNullOrNil(this.xbd.MEz);
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(this.xgG);
                objArr[1] = Integer.valueOf(this.xbd.MEu.size());
                if (this.xbd.MlS != null) {
                    i4 = this.xbd.MlS.KKx.size();
                }
                objArr[2] = Integer.valueOf(i4);
                Log.i("MicroMsg.FTS.PardusSearchLogic", "searchResponse hasWebViewResult %b result:%d sug:%d", objArr);
                if (!this.xgE) {
                    if (this.xgG) {
                        j jVar = this.xgB;
                        String str2 = this.xbd.MEz;
                        jVar.dUA = this.query;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", str2);
                        } catch (Exception e2) {
                        }
                        jVar.xbE.xfV.runOnUiThread(new Runnable(jSONObject) {
                            /* class com.tencent.mm.plugin.fts.ui.widget.j.AnonymousClass1 */
                            final /* synthetic */ JSONObject xhc;

                            {
                                this.xhc = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(176940);
                                j.this.hA("pardusDataReady", this.xhc.toString());
                                AppMethodBeat.o(176940);
                            }
                        });
                    } else {
                        dQe();
                    }
                }
            } else {
                l.N(this.xbf, 5);
            }
            if (!this.xgG) {
                cHi();
            }
        }
        AppMethodBeat.o(112359);
    }

    public final void cHi() {
        AppMethodBeat.i(112360);
        if (!this.dDz) {
            this.xba.removeAllViews();
            LinkedList<efk> linkedList = (this.xbd == null || this.xbd.MEy == null) ? null : this.xbd.MEy.KKx;
            if (this.xgF || linkedList == null || linkedList.size() <= 0) {
                this.xfV.xbX.xbD.gG(0, 1);
                this.xba.setVisibility(8);
            } else {
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    efk efk = linkedList.get(i2);
                    alv alv = new alv();
                    alv.Lux = efk;
                    alv.xuA = i2;
                    View inflate = this.xfV.getLayoutInflater().inflate(R.layout.ao5, (ViewGroup) this.xba, false);
                    inflate.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(112337);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            alv alv = (alv) view.getTag();
                            if (alv.Lux.xJa != 3) {
                                i.this.J(alv.Lux.MGp, 7, alv.Lux.MEq);
                            } else if (alv.Lux.NfH == null || Util.isNullOrNil(alv.Lux.NfH.yO())) {
                                Log.e("MicroMsg.FTS.PardusSearchLogic", "updateFooterView, fts h5 relatedItem.Item.JumpType = " + alv.Lux.xJa + ", but JumpUrl = " + alv.Lux.NfH);
                            } else {
                                i.hz(alv.Lux.NfH.yO(), i.this.query);
                            }
                            com.tencent.mm.plugin.fts.ui.c.b bVar2 = i.this.xfV.xbX.xbD;
                            l.a(i.this.query, i.this.xfV.xbX.getCount(), i.this.xfV.mve, bVar2, 23);
                            i.this.xfV.xbX.xby = true;
                            if (!i.this.xfV.xbX.xbo) {
                                i.this.xfV.xbX.xbo = true;
                                l.a(alv.Lux.MGp, true, i.this.xfV.xbX.getCount(), 0, bVar2);
                            }
                            i.this.Nz(7);
                            ar.afA(3);
                            i.this.xfV.xbX.xbD.Nv(23);
                            i.a(i.this, 0, "", "", "", "", alv.xuA + 1, alv.Lux.MEq);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(112337);
                        }
                    });
                    ((TextView) inflate.findViewById(R.id.be9)).setText(efk.MGp);
                    inflate.setTag(alv);
                    this.xba.addView(inflate);
                }
                this.xfV.xbX.xbD.gG(linkedList.size(), 1);
                this.xba.setVisibility(0);
                this.xfV.xbX.xbD.eS(linkedList);
            }
            this.xaX.setVisibility(0);
            this.xaY.setVisibility(0);
            this.xfV.xbX.xbD.dPB();
            AppMethodBeat.o(112360);
            return;
        }
        this.xfV.xbX.xbD.gG(0, 0);
        this.xaY.setVisibility(8);
        this.xaX.setVisibility(8);
        AppMethodBeat.o(112360);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r17v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r17v3, types: [java.lang.CharSequence] */
    /* JADX WARNING: Unknown variable types count: 4 */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dQe() {
        /*
        // Method dump skipped, instructions count: 2176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.widget.i.dQe():void");
    }

    public final void a(czc czc) {
        AppMethodBeat.i(176934);
        switch (czc.KWb) {
            case 1:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", czc.xIy);
                c.b(this.xfV, "webview", ".ui.tools.WebviewMpUI", intent);
                break;
            case 2:
                wq wqVar = new wq();
                wqVar.ecI.userName = czc.UserName;
                wqVar.ecI.ecK = czc.Lrs;
                wqVar.ecI.appVersion = czc.Lrt;
                wqVar.ecI.dCw = czc.Lru;
                EventCenter.instance.publish(wqVar);
                break;
            case 3:
                String str = czc.query;
                String str2 = czc.MEp;
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.optString(next));
                    }
                } catch (Exception e2) {
                }
                ((h) g.af(h.class)).a(this.xfV, 3, str, String.valueOf(e.wVm), hashMap);
                break;
        }
        Nz(4);
        AppMethodBeat.o(176934);
    }

    /* access modifiers changed from: package-private */
    public class a implements Animator.AnimatorListener {
        private long xgP;

        public a(long j2) {
            this.xgP = j2;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(176931);
            Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationStart listenSearchId:%s currentSearchId:%s", Long.valueOf(this.xgP), Long.valueOf(i.this.xbf));
            if (this.xgP == i.this.xbf) {
                i.this.xfV.pu(false);
                i.this.a(b.StartAnimation);
                l.N(i.this.xbf, 6);
            }
            AppMethodBeat.o(176931);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(176932);
            Log.i("MicroMsg.FTS.PardusSearchLogic", "onAnimationEnd listenSearchId:%s currentSearchId:%s", Long.valueOf(this.xgP), Long.valueOf(i.this.xbf));
            if (this.xgP == i.this.xbf) {
                i.this.xfV.pu(true);
                if (i.this.xgD == b.StartAnimation) {
                    i.this.a(b.ShowResult);
                    l.N(i.this.xbf, 7);
                }
            }
            AppMethodBeat.o(176932);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public final View dzK() {
        AppMethodBeat.i(112361);
        if (this.xaW == null) {
            this.xaW = this.xfV.getLayoutInflater().inflate(R.layout.ao1, (ViewGroup) null, false);
            this.xaY = this.xaW.findViewById(R.id.jkc);
            this.xaX = this.xaW.findViewById(R.id.jkf);
            this.xaZ = this.xaW.findViewById(R.id.jke);
            this.xbb = (TextView) this.xaW.findViewById(R.id.jkg);
            this.xbc = (TextView) this.xaW.findViewById(R.id.jkd);
            this.xba = (LinearLayout) this.xaX.findViewById(R.id.gzw);
            try {
                String optString = ak.aXe("webSearchBar").optString("wording");
                Log.i("MicroMsg.FTS.PardusSearchLogic", "set searchNetworkTips %s", optString);
                this.xbc.setText(optString);
            } catch (Exception e2) {
            }
            this.xaY.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fts.ui.widget.i.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(112333);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!WeChatBrands.Business.Entries.ContextSearch.checkAvailable(view.getContext())) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(112333);
                        return;
                    }
                    i.this.xfV.xbX.xby = true;
                    if (!i.this.xfV.xbX.xbo) {
                        i.this.xfV.xbX.xbo = true;
                        l.a(i.this.query, true, i.this.xfV.xbX.getCount(), 0, i.this.xfV.xbX.xbD);
                    }
                    i.this.dY(i.this.query, 15);
                    i.this.xfV.xbX.xby = true;
                    i.this.Nz(2);
                    ar.afA(3);
                    i.this.xfV.xbX.xbD.Nv(18);
                    l.a(i.this.query, i.this.xfV.xbX.getCount(), i.this.xfV.mve, i.this.xfV.xbX.xbD, 18);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/widget/PardusSearchLogic$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(112333);
                }
            });
        }
        View view = this.xaW;
        AppMethodBeat.o(112361);
        return view;
    }

    public final void f(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(112362);
        if (z2 || i2 != 0) {
            this.xaZ.setVisibility(0);
        } else {
            this.xaZ.setVisibility(8);
        }
        if (z) {
            b.a aVar = b.a.clicfg_fts_pardus_open_flag;
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdd()) == 0) {
                cHi();
            }
        }
        AppMethodBeat.o(112362);
    }

    public final void dY(String str, int i2) {
        AppMethodBeat.i(176935);
        String str2 = "";
        if (this.xbd != null) {
            str2 = String.format("%s:%s:%s:%s", Integer.valueOf(i2), this.xbd.Mbb, str, Long.valueOf(this.xbf));
        }
        hy(str, str2);
        AppMethodBeat.o(176935);
    }

    private void hy(String str, String str2) {
        AppMethodBeat.i(112363);
        this.xfV.xbX.xby = true;
        if (str == null || Util.isNullOrNil(str.trim())) {
            AppMethodBeat.o(112363);
        } else if (System.currentTimeMillis() - this.mZq <= 1000) {
            AppMethodBeat.o(112363);
        } else {
            this.mZq = System.currentTimeMillis();
            String valueOf = String.valueOf(e.wVm);
            HashMap hashMap = new HashMap();
            hashMap.put("sceneActionType", "1");
            hashMap.put("parentSearchID", str2);
            hashMap.put("clickType", "17");
            ((h) g.af(h.class)).a(this.xfV.getContext(), 3, str, valueOf, hashMap);
            AppMethodBeat.o(112363);
        }
    }

    public final void m(Map<String, String> map, String str) {
        AppMethodBeat.i(176936);
        this.xfV.xbX.xby = true;
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(176936);
        } else if (System.currentTimeMillis() - this.mZq <= 1000) {
            AppMethodBeat.o(176936);
        } else {
            this.mZq = System.currentTimeMillis();
            String valueOf = String.valueOf(e.wVm);
            map.put("clickType", "7");
            ((h) g.af(h.class)).a(this.xfV.getContext(), str, valueOf, map);
            AppMethodBeat.o(176936);
        }
    }

    public final void J(String str, int i2, String str2) {
        AppMethodBeat.i(184533);
        String str3 = "";
        if (this.xbd != null) {
            str3 = String.format("%s:%s:%s:%s", Integer.valueOf(i2), this.xbd.Mbb, str2, Long.valueOf(this.xbf));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("prefixSug", this.query);
        if (!Util.isNullOrNil(str3)) {
            hashMap.put("parentSearchID", str3);
        }
        hashMap.put("sceneActionType", "6");
        m(hashMap, str);
        AppMethodBeat.o(184533);
    }

    public final void e(int i2, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(112365);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pardussearch=expose&searchid=");
            stringBuffer.append(getSearchId());
            stringBuffer.append("&query=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(this.query, "utf8"));
            stringBuffer.append("&type=");
            stringBuffer.append(i2);
            stringBuffer.append("&docid=");
            stringBuffer.append(str);
            stringBuffer.append("&title=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str2, "utf8"));
            stringBuffer.append("&clienttimestamp=");
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append("&sug=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str3, "utf8"));
            stringBuffer.append("&relatedsug=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str4, "utf8"));
            Log.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchExposeReport %s", stringBuffer.toString());
            doc doc = new doc();
            doc.MRe = stringBuffer.toString();
            g.azz().a(new ad(doc), 0);
            AppMethodBeat.o(112365);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", e2, "realtimeSearchExposeReport", new Object[0]);
            AppMethodBeat.o(112365);
        }
    }

    private String getSearchId() {
        AppMethodBeat.i(112366);
        if (this.xbd != null) {
            String str = this.xbd.Mbb;
            AppMethodBeat.o(112366);
            return str;
        }
        String valueOf = String.valueOf(this.xbf);
        AppMethodBeat.o(112366);
        return valueOf;
    }

    public enum b {
        None,
        StartSearch,
        ReturnResult,
        StartAnimation,
        ShowResult,
        Timeout;

        public static b valueOf(String str) {
            AppMethodBeat.i(112349);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(112349);
            return bVar;
        }

        static {
            AppMethodBeat.i(112350);
            AppMethodBeat.o(112350);
        }
    }

    public final void a(b bVar) {
        AppMethodBeat.i(112367);
        Log.i("MicroMsg.FTS.PardusSearchLogic", "change status from %s to %s", this.xgD, bVar);
        this.xgD = bVar;
        AppMethodBeat.o(112367);
    }

    public static f a(String str, TimeLineObject timeLineObject, String str2) {
        String str3 = null;
        AppMethodBeat.i(112368);
        if (timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV == null || timeLineObject.ContentObj.LoV.size() <= 0) {
            AppMethodBeat.o(112368);
            return null;
        }
        cnb cnb = timeLineObject.ContentObj.LoV.get(0);
        if (cnb == null) {
            AppMethodBeat.o(112368);
            return null;
        }
        f fVar = new f();
        fVar.jeT = 9;
        fVar.jeV = str2;
        fVar.jeW = 0.0f;
        fVar.jeZ = "";
        if (!TextUtils.isEmpty(cnb.songAlbumUrl)) {
            fVar.jfm = cnb.songAlbumUrl;
        }
        fVar.jfa = cnb.Msz;
        fVar.jff = null;
        fVar.jeU = 1;
        fVar.jfe = cnb.songLyric;
        fVar.jeX = cnb.Title;
        fVar.jeY = cnb.Desc;
        if (timeLineObject.ContentObj != null) {
            str3 = timeLineObject.ContentObj.Url;
        }
        fVar.jfd = str3;
        fVar.jfc = cnb.MsC;
        fVar.jfb = cnb.Url;
        fVar.jfj = cnb.MsA;
        fVar.jfl = cnb.Id;
        fVar.jfg = str;
        fVar.jfi = timeLineObject.AppInfo.Id;
        fVar.jfp = timeLineObject.UserName;
        fVar.jfw = timeLineObject.Id;
        AppMethodBeat.o(112368);
        return fVar;
    }

    static /* synthetic */ void a(i iVar, int i2, String str, String str2, String str3, String str4, int i3, String str5) {
        AppMethodBeat.i(176938);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("pardussearch=click&searchid=");
            stringBuffer.append(iVar.getSearchId());
            stringBuffer.append("&query=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(iVar.query, "utf8"));
            stringBuffer.append("&type=");
            stringBuffer.append(i2);
            stringBuffer.append("&docid=");
            stringBuffer.append(str);
            stringBuffer.append("&title=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str2, "utf8"));
            stringBuffer.append("&clienttimestamp=");
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append("&jumpurl=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str3, "utf8"));
            stringBuffer.append("&sug=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str4, "utf8"));
            stringBuffer.append("&sugpos=");
            stringBuffer.append(i3);
            stringBuffer.append("&relatedsug=");
            stringBuffer.append(com.tencent.mm.compatible.util.q.encode(str5, "utf8"));
            Log.i("MicroMsg.FTS.PardusSearchLogic", "realtimeSearchClickReport %s", stringBuffer.toString());
            doc doc = new doc();
            doc.MRe = stringBuffer.toString();
            g.azz().a(new ad(doc), 0);
            AppMethodBeat.o(176938);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.PardusSearchLogic", e2, "realtimeSearchClickReport", new Object[0]);
            AppMethodBeat.o(176938);
        }
    }

    static /* synthetic */ void hz(String str, String str2) {
        AppMethodBeat.i(235410);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("key_init_url", str);
        intent.putExtra("key_search_query", str2);
        c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.fts.SosWebViewUI", intent);
        AppMethodBeat.o(235410);
    }

    static /* synthetic */ String k(i iVar) {
        AppMethodBeat.i(235411);
        if (iVar.xbd != null && iVar.xbd.MEu.size() > 0) {
            sa first = iVar.xbd.MEu.getFirst();
            if (first.oUv == 512 && first.KZF.size() > 0) {
                String str = first.KZF.getFirst().MEl.MEq;
                AppMethodBeat.o(235411);
                return str;
            }
        }
        AppMethodBeat.o(235411);
        return "";
    }
}
