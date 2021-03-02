package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.a.b;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u001d\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020!H\u0002J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\b\u00100\u001a\u00020\u0019H\u0016J\u0018\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0019H\u0002J\b\u00107\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/ui/chatting/component/EmojiEggComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IEmojiEggComponent;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "()V", "TAG", "", "checkKeywordTask", "Ljava/lang/Runnable;", "dynamicController", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController;", "eggMgr", "Lcom/tencent/mm/ui/chatting/EggMgr;", "eggMsgFilter", "Lkotlin/Function1;", "Lcom/tencent/mm/storage/MsgInfo;", "", "isChatEnter", "isPaused", "onScrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "uncheckMsg", "viewProvider", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "checkEggKeyword", "", "msgInfoList", "", "isUnread", "checkKeyword", "text", "checkUnreadMsg", "getMagicEmojiHolder", "Landroid/widget/FrameLayout;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onChatContentScroll", "translateY", "", "finished", "onChattingEnterAnimEnd", "onChattingExitAnimStart", "onChattingPause", "onChattingResume", "onComponentUnInstall", "onNotifyChange", "msgStorage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "release", "updateView", "app_release"})
@com.tencent.mm.ui.chatting.d.a.a(gRF = r.class)
public final class u extends a implements i.a, r {
    private boolean Ppi;
    private ca Ppj;
    private final aa Ppk = new aa();
    private final com.tencent.mm.emoji.a.e Ppl = new com.tencent.mm.emoji.a.e();
    private final kotlin.g.a.b<ca, Boolean> Ppm = new c(this);
    private Runnable Ppn = b.Ppt;
    private final ViewTreeObserver.OnScrollChangedListener Ppo = new f(this);
    private final com.tencent.mm.emoji.a.a Ppp = new h(this);
    private final String TAG = "MicroMsg.EmojiEggComponent";
    private boolean isPaused;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/storage/MsgInfo;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<ca, Boolean> {
        final /* synthetic */ u Ppq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(u uVar) {
            super(1);
            this.Ppq = uVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(ca caVar) {
            boolean z;
            AppMethodBeat.i(231189);
            ca caVar2 = caVar;
            p.h(caVar2, LocaleUtil.ITALIAN);
            if (caVar2.isText() || caVar2.gDx() || caVar2.gDy()) {
                String ajO = caVar2.ajO();
                com.tencent.mm.ui.chatting.e.a aVar = this.Ppq.dom;
                p.g(aVar, "mChattingContext");
                if (Util.isEqual(ajO, aVar.getTalkerUserName())) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(231189);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(231189);
            return valueOf2;
        }
    }

    public u() {
        AppMethodBeat.i(231210);
        AppMethodBeat.o(231210);
    }

    public static final /* synthetic */ void f(u uVar) {
        AppMethodBeat.i(231212);
        uVar.updateView();
        AppMethodBeat.o(231212);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b Ppt = new b();

        static {
            AppMethodBeat.i(231188);
            AppMethodBeat.o(231188);
        }

        b() {
        }

        public final void run() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onScrollChanged"})
    static final class f implements ViewTreeObserver.OnScrollChangedListener {
        final /* synthetic */ u Ppq;

        f(u uVar) {
            this.Ppq = uVar;
        }

        public final void onScrollChanged() {
            AppMethodBeat.i(231193);
            u.f(this.Ppq);
            AppMethodBeat.o(231193);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/ui/chatting/component/EmojiEggComponent$viewProvider$1", "Lcom/tencent/mm/emoji/egg/ChattingViewProvider;", "getItemTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "itemView", "Landroid/view/View;", "getParentView", "getViewByMsgId", "msgId", "", "app_release"})
    public static final class h implements com.tencent.mm.emoji.a.a {
        final /* synthetic */ u Ppq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(u uVar) {
            this.Ppq = uVar;
        }

        @Override // com.tencent.mm.emoji.a.a
        public final View zh(long j2) {
            AppMethodBeat.i(231195);
            View zh = ((k) this.Ppq.dom.bh(k.class)).zh(j2);
            AppMethodBeat.o(231195);
            return zh;
        }

        @Override // com.tencent.mm.emoji.a.a
        public final MMNeat7extView ck(View view) {
            AppMethodBeat.i(231196);
            p.h(view, "itemView");
            MMNeat7extView mMNeat7extView = (MMNeat7extView) view.findViewById(R.id.auk);
            AppMethodBeat.o(231196);
            return mMNeat7extView;
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(231197);
        super.cFx();
        if (this.Ppl.gUY == null) {
            com.tencent.mm.emoji.a.e eVar = this.Ppl;
            com.tencent.mm.ui.chatting.e.a aVar = this.dom;
            p.g(aVar, "mChattingContext");
            eVar.gUY = (FrameLayout) aVar.getContext().findViewById(R.id.auw);
        }
        this.isPaused = false;
        ca caVar = this.Ppj;
        if (caVar != null) {
            z(j.listOf(caVar), true);
        }
        this.Ppj = null;
        AppMethodBeat.o(231197);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(231198);
        this.isPaused = true;
        super.cFy();
        this.Ppk.onPause();
        this.Ppk.gOi();
        this.Ppl.onStop();
        AppMethodBeat.o(231198);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(231199);
        super.gIm();
        com.tencent.mm.ui.chatting.e.a aVar = this.dom;
        p.g(aVar, "mChattingContext");
        af gRQ = aVar.gRQ();
        p.g(gRQ, "mChattingContext.pullDownViewCallback");
        MMChattingListView gOd = gRQ.gOd();
        p.g(gOd, "mChattingContext.pullDow…Callback.chattingListView");
        gOd.getViewTreeObserver().addOnScrollChangedListener(this.Ppo);
        aa aaVar = this.Ppk;
        com.tencent.mm.ui.chatting.e.a aVar2 = this.dom;
        p.g(aVar2, "mChattingContext");
        boolean gRM = aVar2.gRM();
        com.tencent.mm.ui.chatting.e.a aVar3 = this.dom;
        p.g(aVar3, "mChattingContext");
        aaVar.P(gRM, aVar3.getTalkerUserName());
        this.Ppk.onResume();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().a(this, (Looper) null);
        af bh = this.dom.bh(ae.class);
        p.g(bh, "mChattingContext.compone…BoxComponent::class.java)");
        List<ca> gQL = ((ae) bh).gQL();
        Log.i(this.TAG, "checkUnreadMsg: " + (gQL != null ? Integer.valueOf(gQL.size()) : null));
        List<ca> list = gQL;
        if (!(list == null || list.isEmpty())) {
            z(gQL, true);
        }
        if (this.Ppl.gUY == null) {
            com.tencent.mm.emoji.a.e eVar = this.Ppl;
            com.tencent.mm.ui.chatting.e.a aVar4 = this.dom;
            p.g(aVar4, "mChattingContext");
            eVar.gUY = (FrameLayout) aVar4.getContext().findViewById(R.id.auw);
        }
        com.tencent.mm.emoji.a.e eVar2 = this.Ppl;
        com.tencent.mm.ui.chatting.e.a aVar5 = this.dom;
        p.g(aVar5, "mChattingContext");
        eVar2.gVs = aVar5.getTalkerUserName();
        this.Ppl.gVt = new d(this);
        this.Ppi = true;
        AppMethodBeat.o(231199);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/ui/chatting/component/EmojiEggComponent$onChattingEnterAnimEnd$1", "Lcom/tencent/mm/emoji/egg/EmojiDynamicController$StateCallback;", "onEnd", "", "onPlayScreenEffect", "msgId", "", "effect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "onScreenEffect", "onStart", "app_release"})
    public static final class d implements e.b {
        final /* synthetic */ u Ppq;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(u uVar) {
            this.Ppq = uVar;
        }

        @Override // com.tencent.mm.emoji.a.e.b
        public final void a(b.C0317b bVar) {
            AppMethodBeat.i(231190);
            p.h(bVar, "effect");
            Log.i(this.Ppq.TAG, "onScreenEffect: msg:" + bVar.delay + ", " + bVar.effectId);
            com.tencent.mm.ui.l.a.b.INSTANCE.a(u.b(this.Ppq), new WeakReference<>(this.Ppq.dom));
            AppMethodBeat.o(231190);
        }

        @Override // com.tencent.mm.emoji.a.e.b
        public final void a(long j2, b.C0317b bVar) {
            AppMethodBeat.i(231191);
            p.h(bVar, "effect");
            Log.i(this.Ppq.TAG, "onPlayScreenEffect: msg:" + j2 + ", " + bVar.delay + ", " + bVar.effectId);
            com.tencent.mm.ui.l.a.b.INSTANCE.c(new com.tencent.mm.ui.l.a.c(this.Ppq.dom, u.b(this.Ppq), j2, System.currentTimeMillis()));
            AppMethodBeat.o(231191);
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(231200);
        this.Ppi = false;
        super.gIn();
        release();
        AppMethodBeat.o(231200);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(231201);
        super.gOK();
        release();
        AppMethodBeat.o(231201);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(231202);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 3001:
                aa.amp(i2);
                break;
        }
        AppMethodBeat.o(231202);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        public static final g Ppv = new g();

        static {
            AppMethodBeat.i(231194);
            AppMethodBeat.o(231194);
        }

        g() {
        }

        public final void run() {
        }
    }

    private final void release() {
        AppMethodBeat.i(231203);
        com.tencent.mm.ac.d.C(this.Ppn);
        this.Ppn = g.Ppv;
        com.tencent.mm.ui.chatting.e.a aVar = this.dom;
        p.g(aVar, "mChattingContext");
        af gRQ = aVar.gRQ();
        p.g(gRQ, "mChattingContext.pullDownViewCallback");
        MMChattingListView gOd = gRQ.gOd();
        p.g(gOd, "mChattingContext.pullDow…Callback.chattingListView");
        gOd.getViewTreeObserver().removeOnScrollChangedListener(this.Ppo);
        this.Ppk.onPause();
        this.Ppk.gOi();
        aa.onDestroy();
        this.Ppl.onStop();
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().a(this);
        AppMethodBeat.o(231203);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ u Ppq;
        final /* synthetic */ boolean Ppr;
        final /* synthetic */ List Pps;

        a(u uVar, boolean z, List list) {
            this.Ppq = uVar;
            this.Ppr = z;
            this.Pps = list;
        }

        public final void run() {
            Object obj;
            AppMethodBeat.i(231187);
            if (!this.Ppr) {
                for (ca caVar : this.Pps) {
                    this.Ppq.Ppl.q(caVar);
                }
            } else {
                Iterator it = this.Pps.iterator();
                if (!it.hasNext()) {
                    obj = null;
                } else {
                    Object next = it.next();
                    if (!it.hasNext()) {
                        obj = next;
                    } else {
                        long ajL = ((ca) next).ajL();
                        while (true) {
                            next = it.next();
                            long ajL2 = ((ca) next).ajL();
                            if (ajL < ajL2) {
                                ajL = ajL2;
                            } else {
                                next = next;
                            }
                            if (!it.hasNext()) {
                                break;
                            }
                        }
                        obj = next;
                    }
                }
                ca caVar2 = (ca) obj;
                if (caVar2 != null) {
                    this.Ppq.Ppl.q(caVar2);
                }
            }
            this.Ppq.Ppl.a(this.Ppq.Ppp);
            aa aaVar = this.Ppq.Ppk;
            com.tencent.mm.ui.chatting.e.a aVar = this.Ppq.dom;
            p.g(aVar, "mChattingContext");
            aaVar.a(aVar.getContext(), this.Pps);
            AppMethodBeat.o(231187);
        }
    }

    private final void z(List<? extends ca> list, boolean z) {
        AppMethodBeat.i(231204);
        this.Ppn = new a(this, z, list);
        com.tencent.mm.ac.d.B(this.Ppn);
        AppMethodBeat.o(231204);
    }

    private final void updateView() {
        AppMethodBeat.i(231205);
        this.Ppl.a(this.Ppp);
        AppMethodBeat.o(231205);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.ChattingScrollLayout.a
    public final void gru() {
        AppMethodBeat.i(231206);
        updateView();
        AppMethodBeat.o(231206);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.r
    public final void bmJ(String str) {
        AppMethodBeat.i(231207);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(231207);
            return;
        }
        ca caVar = new ca();
        caVar.setContent(str);
        caVar.nv(1);
        jq(j.listOf(caVar));
        AppMethodBeat.o(231207);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
    public final void a(i iVar, i.c cVar) {
        Object obj;
        AppMethodBeat.i(231209);
        p.h(iVar, "msgStorage");
        p.h(cVar, "notifyInfo");
        if (this.isPaused) {
            if (Util.isEqual("insert", cVar.zqn)) {
                ArrayList<ca> arrayList = cVar.hIs;
                p.g(arrayList, "notifyInfo.msgList");
                kotlin.g.a.b<ca, Boolean> bVar = this.Ppm;
                ArrayList arrayList2 = new ArrayList();
                for (T t : arrayList) {
                    if (bVar.invoke(t).booleanValue()) {
                        arrayList2.add(t);
                    }
                }
                Iterator it = arrayList2.iterator();
                if (!it.hasNext()) {
                    obj = null;
                } else {
                    Object next = it.next();
                    if (!it.hasNext()) {
                        obj = next;
                    } else {
                        ca caVar = (ca) next;
                        p.g(caVar, LocaleUtil.ITALIAN);
                        long ajL = caVar.ajL();
                        while (true) {
                            next = it.next();
                            ca caVar2 = (ca) next;
                            p.g(caVar2, LocaleUtil.ITALIAN);
                            long ajL2 = caVar2.ajL();
                            if (ajL >= ajL2) {
                                ajL2 = ajL;
                                next = next;
                            }
                            if (!it.hasNext()) {
                                break;
                            }
                            ajL = ajL2;
                        }
                        obj = next;
                    }
                }
                this.Ppj = (ca) obj;
            }
            AppMethodBeat.o(231209);
        } else if (Util.isEqual("insert", cVar.zqn)) {
            ArrayList<ca> arrayList3 = cVar.hIs;
            p.g(arrayList3, "notifyInfo.msgList");
            kotlin.g.a.b<ca, Boolean> bVar2 = this.Ppm;
            ArrayList arrayList4 = new ArrayList();
            for (T t2 : arrayList3) {
                if (bVar2.invoke(t2).booleanValue()) {
                    arrayList4.add(t2);
                }
            }
            jq(arrayList4);
            AppMethodBeat.o(231209);
        } else {
            if (Util.isEqual("update", cVar.zqn)) {
                ArrayList<ca> arrayList5 = cVar.hIs;
                p.g(arrayList5, "notifyInfo.msgList");
                ArrayList arrayList6 = new ArrayList();
                for (T t3 : arrayList5) {
                    T t4 = t3;
                    p.g(t4, LocaleUtil.ITALIAN);
                    if (t4.gDG() == 4 || t4.getType() == 10000) {
                        arrayList6.add(t3);
                    }
                }
                com.tencent.mm.ac.d.h(new e(this, arrayList6));
            }
            AppMethodBeat.o(231209);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ u Ppq;
        final /* synthetic */ List Ppu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(u uVar, List list) {
            super(0);
            this.Ppq = uVar;
            this.Ppu = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            T t;
            boolean z;
            AppMethodBeat.i(231192);
            for (ca caVar : this.Ppu) {
                com.tencent.mm.emoji.a.e eVar = this.Ppq.Ppl;
                p.g(caVar, LocaleUtil.ITALIAN);
                p.h(caVar, "msgInfo");
                Iterator<T> it = eVar.gVq.gVo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (next.msgId == caVar.ajL()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    t2.stop();
                    eVar.gVq.b(t2);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(231192);
            return xVar;
        }
    }

    private void jq(List<? extends ca> list) {
        AppMethodBeat.i(231208);
        p.h(list, "msgInfoList");
        z(list, false);
        AppMethodBeat.o(231208);
    }

    public static final /* synthetic */ FrameLayout b(u uVar) {
        AppMethodBeat.i(231211);
        com.tencent.mm.ui.chatting.e.a aVar = uVar.dom;
        p.g(aVar, "mChattingContext");
        View findViewById = aVar.getContext().findViewById(R.id.avd);
        p.g(findViewById, "mChattingContext.context…atting_frame_magic_emoji)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        AppMethodBeat.o(231211);
        return frameLayout;
    }
}
