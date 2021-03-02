package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.p;

public final class d implements c {
    ValueAnimator animator = null;
    public String content;
    boolean isNew = false;
    private int lastType;
    private View mContentView;
    Context mContext;
    MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.groupsolitaire.ui.d.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(110497);
            switch (message.what) {
                case 20001:
                    d dVar = d.this;
                    String str = (String) message.obj;
                    int i2 = message.arg1;
                    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips()");
                    if (!((j) g.af(j.class)).aBg(dVar.ygk) || Util.isNullOrNil(dVar.content) || dVar.ygS == null) {
                        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
                        AppMethodBeat.o(110497);
                        return;
                    }
                    dVar.mHandler.removeMessages(20001);
                    dVar.isNew = false;
                    if (i2 == 1) {
                        dVar.mPa.setText(R.string.dwf);
                        dVar.isNew = true;
                    } else {
                        dVar.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.U(dVar.ygk, str, dVar.ygI.yfE.size());
                        if (dVar.isNew) {
                            dVar.mPa.setText(R.string.dwf);
                            if (com.tencent.mm.plugin.groupsolitaire.b.b.aBj(dVar.ygI.header)) {
                                if (dVar.ygD.isShowing()) {
                                    dVar.dYf();
                                }
                                AppMethodBeat.o(110497);
                                return;
                            }
                        } else {
                            dVar.mPa.setText(R.string.dwe);
                        }
                    }
                    if (dVar.ygD.isShowing()) {
                        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
                        AppMethodBeat.o(110497);
                        return;
                    }
                    if (!dVar.isNew) {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        com.tencent.mm.plugin.groupsolitaire.b.d.en(dVar.ygk, 1);
                    } else if (i2 == 1) {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        com.tencent.mm.plugin.groupsolitaire.b.d.en(dVar.ygk, 3);
                    } else {
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                        com.tencent.mm.plugin.groupsolitaire.b.d.en(dVar.ygk, 2);
                    }
                    if (dVar.ygE != null) {
                        dVar.wrA = new int[2];
                        dVar.ygE.getLocationInWindow(dVar.wrA);
                        dVar.ygM = 0;
                        dVar.ygK = (dVar.ygE.getWidth() - dVar.ygD.getWidth()) - com.tencent.mm.cb.a.fromDPToPix(dVar.mContext, 8);
                        dVar.ygL = (dVar.wrA[1] - dVar.ygD.getHeight()) - com.tencent.mm.cb.a.fromDPToPix(dVar.mContext, 8);
                        if (dVar.ygR != null && !dVar.ygR.dYh()) {
                            dVar.ygL += dVar.ygR.dYg();
                        }
                        dVar.ygD.showAtLocation(dVar.ygE, 0, dVar.ygK, dVar.ygL);
                        dVar.ygE.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            /* class com.tencent.mm.plugin.groupsolitaire.ui.d.AnonymousClass3 */

                            public final void onGlobalLayout() {
                                AppMethodBeat.i(110502);
                                d.this.ygE.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.groupsolitaire.ui.d.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(110501);
                                        d.this.ygE.getLocationInWindow(d.this.wrA);
                                        d.this.ygK = (d.this.ygE.getWidth() - d.this.ygD.getWidth()) - com.tencent.mm.cb.a.fromDPToPix(d.this.mContext, 8);
                                        d.this.ygL = (d.this.wrA[1] - d.this.ygD.getHeight()) - com.tencent.mm.cb.a.fromDPToPix(d.this.mContext, 8);
                                        if (d.this.ygR != null && !d.this.ygR.dYh()) {
                                            d.this.ygL += d.this.ygR.dYg();
                                        }
                                        d.this.animator = ValueAnimator.ofInt(d.this.ygM, d.this.ygL);
                                        d.this.animator.setDuration(175L);
                                        d.this.animator.setInterpolator(new android.support.v4.view.b.b());
                                        d.this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                            /* class com.tencent.mm.plugin.groupsolitaire.ui.d.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                AppMethodBeat.i(110500);
                                                d.this.ygD.update(d.this.ygK, ((Integer) valueAnimator.getAnimatedValue()).intValue(), -1, -1);
                                                AppMethodBeat.o(110500);
                                            }
                                        });
                                        d.this.animator.start();
                                        d.this.ygM = d.this.ygL;
                                        AppMethodBeat.o(110501);
                                    }
                                }, 175);
                                AppMethodBeat.o(110502);
                            }
                        });
                    }
                    AppMethodBeat.o(110497);
                    return;
                case 20002:
                    d.this.dYf();
                    break;
            }
            AppMethodBeat.o(110497);
        }
    };
    TextView mPa;
    int[] wrA;
    c.b ygC;
    public p ygD;
    public View ygE;
    AbstractC1429d ygF;
    boolean ygG = false;
    public String ygH = "";
    com.tencent.mm.plugin.groupsolitaire.c.a ygI = null;
    String ygJ = "";
    int ygK;
    int ygL;
    int ygM;
    public com.tencent.mm.plugin.groupsolitaire.c.a ygN = null;
    private String ygO = "";
    public a ygP;
    public b ygQ;
    public c ygR = null;
    public View ygS;
    public String ygk = "";

    public interface c {
        int dYg();

        boolean dYh();
    }

    /* renamed from: com.tencent.mm.plugin.groupsolitaire.ui.d$d  reason: collision with other inner class name */
    public interface AbstractC1429d {
        void aBt(String str);

        void dYi();
    }

    public d(Context context, c.b bVar, AbstractC1429d dVar) {
        AppMethodBeat.i(110504);
        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
        this.mContext = context;
        this.ygC = bVar;
        this.ygF = dVar;
        this.ygP = new a(this.mContext, this.mHandler, this);
        this.ygQ = new b(this.mContext, this.mHandler, this);
        this.ygJ = this.mContext.getString(R.string.dvu);
        this.mContentView = View.inflate(this.mContext, R.layout.c1_, null);
        this.mContentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.d.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(110499);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
                if (d.this.ygI != null || com.tencent.mm.plugin.groupsolitaire.b.b.aS(d.this.mContext, d.this.content)) {
                    Intent intent = new Intent();
                    if (d.this.ygI == null) {
                        d.this.ygI = new com.tencent.mm.plugin.groupsolitaire.c.a();
                        d.this.ygI.header = d.this.ygJ + "\n";
                        d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
                        d.this.ygI.separator = ".";
                        d.this.ygI.yfG = 1;
                        intent.putExtra("key_group_solitatire_create", true);
                        intent.putExtra("key_group_solitatire_scene", 4);
                    } else {
                        d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
                        Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> hW = com.tencent.mm.plugin.groupsolitaire.b.b.hW(d.this.ygk, d.this.ygI.field_key);
                        if (!((Boolean) hW.first).booleanValue()) {
                            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aT(d.this.mContext, d.this.content)) {
                                d.this.ygI.header = d.this.mContext.getString(R.string.dvu) + "\n" + d.this.ygI.header;
                                d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
                            }
                            intent.putExtra("key_group_solitatire_create", true);
                        } else if (d.this.isNew) {
                            intent.putExtra("key_group_solitatire_create", true);
                            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aT(d.this.mContext, d.this.content)) {
                                d.this.ygI.header = d.this.mContext.getString(R.string.dvu) + "\n" + d.this.ygI.header;
                                d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
                            }
                        } else {
                            intent.putExtra("key_group_solitatire_create", false);
                            d.this.ygI = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI, d.this.ygN, (com.tencent.mm.plugin.groupsolitaire.c.a) hW.second);
                        }
                        intent.putExtra("key_group_solitatire_scene", 3);
                    }
                    intent.putExtra("key_group_solitatire_key", d.this.ygI.field_key);
                    intent.putExtra("key_group_solitatire_chatroom_username", d.this.ygk);
                    com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygk, d.this.ygI);
                    ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.ygk, d.this.ygI);
                    com.tencent.mm.br.c.a(d.this.ygC, "groupsolitaire", ".ui.GroupSolitatireEditUI", intent, 3001, new c.a() {
                        /* class com.tencent.mm.plugin.groupsolitaire.ui.d.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.br.c.a
                        public final void onActivityResult(int i2, int i3, Intent intent) {
                            AppMethodBeat.i(110498);
                            if (i2 == 3001) {
                                Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", Integer.valueOf(i3));
                                if (-1 == i3 && d.this.ygF != null) {
                                    d.this.ygF.dYi();
                                    d.this.reset();
                                    if (intent != null) {
                                        d.this.ygF.aBt(intent.getStringExtra("key_group_solitatire_content"));
                                    }
                                    d.this.ygG = true;
                                }
                            }
                            AppMethodBeat.o(110498);
                        }
                    });
                    d.this.dYf();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110499);
                    return;
                }
                Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110499);
            }
        });
        this.ygD = new p(this.mContentView, com.tencent.mm.cb.a.aH(this.mContext, R.dimen.aml), com.tencent.mm.cb.a.aH(this.mContext, R.dimen.amk), true);
        this.ygD.setBackgroundDrawable(new ColorDrawable(0));
        this.ygD.setOutsideTouchable(false);
        this.ygD.setFocusable(false);
        this.ygD.setAnimationStyle(R.style.s9);
        this.mPa = (TextView) this.mContentView.findViewById(R.id.i27);
        this.mPa.setTextSize(0, (float) com.tencent.mm.cb.a.aH(this.mContext, R.dimen.hc));
        ((TextView) this.mContentView.findViewById(R.id.i24)).setTextSize(0, (float) com.tencent.mm.cb.a.aH(this.mContext, R.dimen.l));
        this.lastType = 1;
        AppMethodBeat.o(110504);
    }

    public final void reset() {
        this.ygH = "";
        this.ygN = null;
        this.ygI = null;
    }

    public final boolean dYe() {
        boolean z = this.ygG;
        this.ygG = false;
        return z;
    }

    public final void dYf() {
        AppMethodBeat.i(110505);
        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
        if (this.ygD.isShowing()) {
            this.ygD.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.removeMessages(20002);
        AppMethodBeat.o(110505);
    }

    @Override // com.tencent.mm.plugin.groupsolitaire.ui.c
    public final void j(com.tencent.mm.plugin.groupsolitaire.c.a aVar) {
        this.ygI = aVar;
    }

    @Override // com.tencent.mm.plugin.groupsolitaire.ui.c
    public final void aBr(String str) {
        this.ygJ = str;
    }

    @Override // com.tencent.mm.plugin.groupsolitaire.ui.c
    public final void c(com.tencent.mm.plugin.groupsolitaire.c.a aVar, String str) {
        AppMethodBeat.i(178797);
        if (this.ygN == null) {
            this.ygN = aVar;
            this.ygO = str;
            AppMethodBeat.o(178797);
        } else if (this.ygN == null || aVar != null) {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
            AppMethodBeat.o(178797);
        } else {
            this.ygN = null;
            this.ygO = "";
            AppMethodBeat.o(178797);
        }
    }

    public static class a implements Runnable {
        protected String content;
        protected MMHandler handler;
        protected Context mContext;
        protected c ygX;
        protected String ygk;

        public a(Context context, MMHandler mMHandler, c cVar) {
            this.mContext = context;
            this.handler = mMHandler;
            this.ygX = cVar;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final void aBs(String str) {
            this.ygk = str;
        }

        public void run() {
            AppMethodBeat.i(110503);
            try {
                Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ia = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(this.content, this.ygk);
                if (((Integer) ia.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.dXN()) {
                    this.handler.sendEmptyMessage(20002);
                    AppMethodBeat.o(110503);
                } else if (((Integer) ia.first).intValue() > 0 || (ia.second != null && ((com.tencent.mm.plugin.groupsolitaire.c.a) ia.second).yfG > 0)) {
                    this.ygX.j((com.tencent.mm.plugin.groupsolitaire.c.a) ia.second);
                    if (com.tencent.mm.plugin.groupsolitaire.b.b.d((com.tencent.mm.plugin.groupsolitaire.c.a) ia.second)) {
                        Message message = new Message();
                        message.what = 20001;
                        message.obj = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a) ia.second);
                        this.handler.sendMessage(message);
                        AppMethodBeat.o(110503);
                        return;
                    }
                    this.handler.sendEmptyMessage(20002);
                    AppMethodBeat.o(110503);
                } else if (com.tencent.mm.plugin.groupsolitaire.b.b.aS(this.mContext, this.content)) {
                    this.ygX.j(null);
                    Message message2 = new Message();
                    message2.what = 20001;
                    message2.arg1 = 1;
                    this.ygX.aBr(this.content.trim());
                    this.handler.sendMessage(message2);
                    AppMethodBeat.o(110503);
                } else {
                    this.handler.sendEmptyMessage(20002);
                    AppMethodBeat.o(110503);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(110503);
            }
        }
    }

    public class b extends a {
        public b(Context context, MMHandler mMHandler, c cVar) {
            super(context, mMHandler, cVar);
        }

        @Override // com.tencent.mm.plugin.groupsolitaire.ui.d.a
        public final void run() {
            AppMethodBeat.i(178796);
            try {
                Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ia = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(this.content, this.ygk);
                if (((Integer) ia.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.dXN()) {
                    AppMethodBeat.o(178796);
                    return;
                }
                if (((Integer) ia.first).intValue() > 0) {
                    this.ygX.c((com.tencent.mm.plugin.groupsolitaire.c.a) ia.second, this.content);
                }
                AppMethodBeat.o(178796);
            } catch (Exception e2) {
                Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(178796);
            }
        }
    }
}
