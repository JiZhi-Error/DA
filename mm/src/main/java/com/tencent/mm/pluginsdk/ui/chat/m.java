package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.c.l;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.jy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m {
    a Kjv;
    public jy KnA = new jy();
    public int KnB = 0;
    b KnC = new b() {
        /* class com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.chat.m.b
        public final void a(int i2, l lVar) {
            AppMethodBeat.i(199794);
            if (!(lVar == null || m.this.Knu == null || m.this.Kjv == null)) {
                EmojiInfo emojiInfo = lVar.gWm;
                if (bj.gCJ().OpN.blk(emojiInfo.field_md5) == null) {
                    bj.gCJ().OpN.K(emojiInfo);
                }
                m.this.Knu.B(emojiInfo);
                m.this.Kjv.clear();
                m.this.G(Collections.singletonList(lVar), 0);
                m.this.KnA.eDd = (long) i2;
                m.this.KnA.enl = 1;
                m.this.KnA.bfK();
                m.this.KnA.eDd = 0;
            }
            m.this.ygD.dismiss();
            AppMethodBeat.o(199794);
        }
    };
    private RecyclerView.k KnD = new RecyclerView.k() {
        /* class com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass3 */

        @Override // android.support.v7.widget.RecyclerView.k
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(199795);
            switch (motionEvent.getAction()) {
                case 0:
                    m.this.mHandler.sendEmptyMessage(20002);
                    break;
                case 1:
                case 3:
                    m.this.mHandler.sendEmptyMessageDelayed(20001, 3000);
                    break;
            }
            AppMethodBeat.o(199795);
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(199796);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$3", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(199796);
        }

        @Override // android.support.v7.widget.RecyclerView.k
        public final void ah(boolean z) {
        }
    };
    int Knr;
    int Kns;
    View Knt;
    j Knu;
    public boolean Knv = true;
    RecyclerView Knw;
    public final ArrayList<l> Knx = new ArrayList<>();
    c Kny;
    public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> Knz;
    private RecyclerView.l anE = new RecyclerView.l() {
        /* class com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass4 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(199798);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(199798);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(199797);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                m.this.G(null, 0);
                m.this.KnA.enl = 2;
                m.this.KnA.bfK();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(199797);
        }
    };
    private View mContentView;
    Context mContext;
    public MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            int i2;
            AppMethodBeat.i(104690);
            switch (message.what) {
                case 20001:
                    m.this.hide();
                    AppMethodBeat.o(104690);
                    return;
                case 20002:
                    removeMessages(20001);
                    break;
                case 20003:
                    m mVar = m.this;
                    Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "show: %s", Boolean.valueOf(mVar.Knv));
                    mVar.mHandler.removeMessages(20001);
                    if (mVar.Knv) {
                        c cVar = mVar.Kny;
                        ArrayList<l> arrayList = mVar.Knx;
                        cVar.rld.clear();
                        cVar.rld.addAll(arrayList);
                        cVar.atj.notifyChanged();
                        RecyclerView recyclerView = mVar.Knw;
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
                        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble", "show", "()V", "Undefined", "scrollToPosition", "(I)V");
                        if (mVar.Knx.size() > 2) {
                            i2 = ((int) (((float) mVar.Knr) * 2.5f)) + (mVar.Kns * 2);
                        } else if (mVar.Knx.size() == 2) {
                            i2 = (mVar.Knr * 2) + (mVar.Kns * 2);
                        } else {
                            i2 = mVar.Knr + (mVar.Kns * 2);
                        }
                        if (mVar.ygD.isShowing()) {
                            mVar.ygD.update(i2, -2);
                        } else {
                            mVar.ygD.setWidth(i2);
                            if (mVar.Knt != null) {
                                int[] iArr = new int[2];
                                mVar.Knt.getLocationInWindow(iArr);
                                mVar.ygD.showAtLocation(mVar.Knt, 0, iArr[0] - ((mVar.ygD.getWidth() - mVar.Knt.getWidth()) / 2), iArr[1] - mVar.ygD.getHeight());
                            }
                        }
                        if (mVar.Knx.size() >= 3) {
                            mVar.mHandler.sendEmptyMessageDelayed(20001, 5000);
                        } else {
                            mVar.mHandler.sendEmptyMessageDelayed(20001, 3000);
                        }
                        mVar.G(mVar.Knx, mVar.KnB);
                        mVar.KnA.enl = 0;
                        mVar.KnA.bfK();
                        mVar.KnB = mVar.Knx.size();
                    }
                    AppMethodBeat.o(104690);
                    return;
            }
            AppMethodBeat.o(104690);
        }
    };
    p ygD;
    public String ygH = "";

    public interface a {
        void clear();
    }

    interface b {
        void a(int i2, l lVar);
    }

    public m(Context context) {
        AppMethodBeat.i(104700);
        this.mContext = context;
        this.Knz = new com.tencent.mm.vending.e.c<>();
        this.mContentView = View.inflate(this.mContext, R.layout.qe, null);
        this.Knw = (RecyclerView) this.mContentView.findViewById(R.id.ie8);
        this.Knw.setLayoutManager(new LinearLayoutManager(0, false));
        this.Kny = new c();
        this.Knw.setAdapter(this.Kny);
        this.Knw.a(this.KnD);
        this.Knw.a(this.anE);
        this.Knr = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 102);
        this.Kns = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.c5);
        this.ygD = new p(this.mContentView, this.Knr + (this.Kns * 2), this.Knr + (this.Kns * 2), true);
        this.ygD.setBackgroundDrawable(new ColorDrawable(0));
        this.ygD.setOutsideTouchable(true);
        this.ygD.setFocusable(false);
        this.ygD.setAnimationStyle(R.style.s9);
        AppMethodBeat.o(104700);
    }

    public final void hide() {
        AppMethodBeat.i(104701);
        Log.i("MicroMsg.emoji.SuggestEmoticonBubble", "hide: ");
        if (this.ygD == null) {
            AppMethodBeat.o(104701);
            return;
        }
        if (this.ygD.isShowing()) {
            this.ygD.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.Knz != null) {
            this.Knz.dead();
            this.Knz = null;
        }
        AppMethodBeat.o(104701);
    }

    /* access modifiers changed from: package-private */
    public final void G(List<l> list, int i2) {
        AppMethodBeat.i(199805);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        if (list != null) {
            for (int i3 = i2; i3 < list.size(); i3++) {
                l lVar = list.get(i3);
                if (i3 != i2) {
                    sb.append("#");
                    sb2.append("#");
                    sb3.append("#");
                }
                sb.append(lVar.gWm.field_md5);
                sb2.append(lVar.type);
                sb3.append(lVar.gZO);
            }
        }
        jy jyVar = this.KnA;
        jyVar.eHs = jyVar.x("md5", sb.toString(), true);
        jy jyVar2 = this.KnA;
        jyVar2.eSY = jyVar2.x("IsLocalSearch", sb2.toString(), true);
        jy jyVar3 = this.KnA;
        jyVar3.eSW = jyVar3.x("Index", sb3.toString(), true);
        jy jyVar4 = this.KnA;
        jyVar4.eSU = jyVar4.x("Word", this.ygH.replace(",", ""), true);
        AppMethodBeat.o(199805);
    }

    class c extends RecyclerView.a<d> {
        LinkedList<l> rld = new LinkedList<>();

        c() {
            AppMethodBeat.i(199800);
            AppMethodBeat.o(199800);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(d dVar, int i2) {
            l lVar;
            AppMethodBeat.i(199802);
            d dVar2 = dVar;
            if (this.rld == null || this.rld.size() <= i2) {
                lVar = null;
            } else {
                lVar = this.rld.get(i2);
            }
            if (lVar != null) {
                dVar2.KnF = lVar;
                EmojiInfo emojiInfo = lVar.gWm;
                dVar2.EGu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String amp = ((PluginEmoji) g.ah(PluginEmoji.class)).getEmojiMgr().amp(emojiInfo.getMd5());
                if (Util.isNullOrNil(amp)) {
                    dVar2.EGu.setContentDescription(m.this.mContext.getString(R.string.bvt));
                } else {
                    dVar2.EGu.setContentDescription(amp);
                }
                dVar2.EGu.setEmojiInfo(emojiInfo);
            }
            AppMethodBeat.o(199802);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(199801);
            if (this.rld == null) {
                AppMethodBeat.o(199801);
                return 0;
            }
            int size = this.rld.size();
            AppMethodBeat.o(199801);
            return size;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ d a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(199803);
            d dVar = new d(LayoutInflater.from(m.this.mContext).inflate(R.layout.qf, viewGroup, false));
            AppMethodBeat.o(199803);
            return dVar;
        }
    }

    class d extends RecyclerView.v {
        EmojiStatusView EGu;
        l KnF;

        d(View view) {
            super(view);
            AppMethodBeat.i(104699);
            this.EGu = (EmojiStatusView) view.findViewById(R.id.ie7);
            this.EGu.setOnClickListener(new View.OnClickListener(m.this) {
                /* class com.tencent.mm.pluginsdk.ui.chat.m.d.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(199804);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m.this.KnC.a(d.this.lR(), d.this.KnF);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SuggestEmoticonBubble$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(199804);
                }
            });
            AppMethodBeat.o(104699);
        }
    }
}
