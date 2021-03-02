package com.tencent.mm.ui.chatting.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.ba.f;
import com.tencent.mm.g.a.za;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.viewitems.bf;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.x;
import com.tencent.mm.ui.z;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.g.b.p;

@com.tencent.mm.ui.chatting.d.a.a(gRF = aw.class)
public class bi extends a implements i, aw {
    private static Object lock = new Object();
    private ay.d FNy = new ay.d() {
        /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass2 */

        @Override // com.tencent.mm.model.ay.d
        public final void B(String str, final long j2) {
            AppMethodBeat.i(233232);
            Log.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + str + " time " + j2);
            if (ab.Jq(bg.getNotification().ala())) {
                h.a((Context) bi.this.dom.Pwc.getContext(), false, str, bi.this.dom.Pwc.getMMResources().getString(R.string.i03), bi.this.dom.Pwc.getMMResources().getString(R.string.i00), bi.this.dom.Pwc.getMMResources().getString(R.string.i02), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass2.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(233231);
                        bg.aVF();
                        if (c.aSQ().aO(bg.getNotification().ala(), j2)) {
                            int cZm = ((k) bi.this.dom.bh(k.class)).cZm();
                            int count = ((k) bi.this.dom.bh(k.class)).getCount();
                            bg.aVF();
                            int h2 = c.aSQ().h(bg.getNotification().ala(), j2, cZm - count);
                            if (h2 < 0) {
                                AppMethodBeat.o(233231);
                                return;
                            } else if (count > h2) {
                                bi.this.dom.amm(h2);
                            }
                        }
                        AppMethodBeat.o(233231);
                    }
                }, (DialogInterface.OnClickListener) null);
            }
            AppMethodBeat.o(233232);
        }
    };
    private IListener<zb> PvA = new IListener<zb>() {
        /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass3 */

        {
            AppMethodBeat.i(233234);
            this.__eventId = zb.class.getName().hashCode();
            AppMethodBeat.o(233234);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zb zbVar) {
            Object valueOf;
            boolean z;
            boolean z2;
            final boolean z3 = false;
            AppMethodBeat.i(233235);
            zb zbVar2 = zbVar;
            if (zbVar2 != null && bi.this.Pvq.containsKey(Long.valueOf(zbVar2.efl.msgId))) {
                Log.i("MicroMsg.ChattingUI.VoiceComponent", "voice msg(%s) download finish, success:%s, isReDownload:%s", Long.valueOf(zbVar2.efl.msgId), Boolean.valueOf(zbVar2.efl.success), Boolean.valueOf(zbVar2.efl.efm));
                bi.this.Pvq.put(Long.valueOf(zbVar2.efl.msgId), Boolean.FALSE);
                if (zbVar2.efl.success && !zbVar2.efl.efm) {
                    if (zbVar2.efl.msgId != bi.this.Pvo || !bi.this.Pvn) {
                        Log.e("MicroMsg.ChattingUI.VoiceComponent", "autoPlayDownloadMsgId:%s canAutoPlayDownloadVoice:%s", Long.valueOf(bi.this.Pvo), Boolean.valueOf(bi.this.Pvn));
                    } else if (bi.this.Pvp == null || bi.this.Pvp.get() == null) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(bi.this.Pvp == null);
                        if (bi.this.Pvp == null) {
                            valueOf = BuildConfig.COMMAND;
                        } else {
                            valueOf = Boolean.valueOf(bi.this.Pvp.get() == null);
                        }
                        objArr[1] = valueOf;
                        Log.e("MicroMsg.ChattingUI.VoiceComponent", "autoPlayDownloadView:%s view:%s", objArr);
                    } else {
                        int firstVisiblePosition = bi.this.dom.getFirstVisiblePosition() - bi.this.dom.getHeaderViewsCount();
                        int lastVisiblePosition = bi.this.dom.getLastVisiblePosition() - bi.this.dom.getHeaderViewsCount();
                        k kVar = (k) bi.this.dom.bh(k.class);
                        while (true) {
                            if (firstVisiblePosition <= lastVisiblePosition) {
                                ca amt = kVar.amt(firstVisiblePosition);
                                if (amt != null && amt.field_msgId == zbVar2.efl.msgId) {
                                    z = true;
                                    break;
                                }
                                firstVisiblePosition++;
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Log.i("MicroMsg.ChattingUI.VoiceComponent", "msgId:%s showInScreen:%s", Long.valueOf(zbVar2.efl.msgId), Boolean.valueOf(z));
                        z3 = z2;
                    }
                }
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233233);
                        bi.this.dom.cmy();
                        if (z3) {
                            ((View) bi.this.Pvp.get()).performClick();
                        }
                        AppMethodBeat.o(233233);
                    }
                });
            }
            AppMethodBeat.o(233235);
            return true;
        }
    };
    private IListener<zc> PvB = new IListener<zc>() {
        /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass4 */

        {
            AppMethodBeat.i(233236);
            this.__eventId = zc.class.getName().hashCode();
            AppMethodBeat.o(233236);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zc zcVar) {
            AppMethodBeat.i(233237);
            if (zcVar != null) {
                bi.this.Pvt = false;
                bi.this.Pvw = false;
                bi.this.gRC();
            }
            AppMethodBeat.o(233237);
            return false;
        }
    };
    private View PvC = null;
    public ChatFooter.d PvD = new ChatFooter.d() {
        /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass5 */

        @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d
        public final void q(Boolean bool) {
            AppMethodBeat.i(233238);
            if (bool.booleanValue()) {
                if (bi.this.PvC == null) {
                    bi.this.PvC = ((ViewStub) bi.this.dom.findViewById(R.id.j8k)).inflate();
                }
                bi.this.PvC.setVisibility(0);
                AppMethodBeat.o(233238);
                return;
            }
            if (bi.this.PvC != null && bi.this.PvC.getVisibility() == 0) {
                bi.this.PvC.setVisibility(8);
            }
            AppMethodBeat.o(233238);
        }
    };
    private IListener<za> PvE = new IListener<za>() {
        /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass6 */

        {
            AppMethodBeat.i(233239);
            this.__eventId = za.class.getName().hashCode();
            AppMethodBeat.o(233239);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(za zaVar) {
            AppMethodBeat.i(233240);
            if (zaVar.efk.isStart) {
                x xVar = x.Qxl;
                x.CM(true);
                bi.i(bi.this);
            }
            AppMethodBeat.o(233240);
            return false;
        }
    };
    private List<WeakReference<View>> PvF = new ArrayList();
    private d Pvm = null;
    private boolean Pvn = false;
    private long Pvo;
    private WeakReference<View> Pvp;
    private ConcurrentHashMap<Long, Boolean> Pvq = new ConcurrentHashMap<>();
    private boolean Pvr = false;
    private o Pvs = new o() {
        /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(233230);
            if (bi.this.Pvr) {
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233229);
                        bi.this.releaseWakeLock();
                        AppMethodBeat.o(233229);
                    }
                });
            }
            AppMethodBeat.o(233230);
        }
    };
    private boolean Pvt = false;
    private boolean Pvu = false;
    private long Pvv = -1;
    private boolean Pvw = false;
    private long Pvx = -1;
    private a Pvy = null;
    private Future Pvz = null;
    private Future dBz = null;
    private int minHeight = -1;
    public boolean qUn = false;

    public bi() {
        AppMethodBeat.i(35775);
        AppMethodBeat.o(35775);
    }

    static /* synthetic */ void i(bi biVar) {
        AppMethodBeat.i(233257);
        biVar.doPause();
        AppMethodBeat.o(233257);
    }

    static {
        AppMethodBeat.i(233260);
        AppMethodBeat.o(233260);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final d gRx() {
        return this.Pvm;
    }

    private void doPause() {
        AppMethodBeat.i(233245);
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "voiceComponent doPause");
        this.Pvn = false;
        if (ab.Jq(this.dom.getTalkerUserName()) && ay.a.iDt != null) {
            ay.a.iDt.b(this.FNy);
        }
        if (this.PvC != null && this.PvC.getVisibility() == 0) {
            Log.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
            this.PvC.setVisibility(8);
        }
        ((u) this.dom.bh(u.class)).setVoiceInputShowCallback(null);
        bg.aVF();
        c.azQ().set(26, Boolean.valueOf(this.qUn));
        if (this.Pvm != null && this.Pvm.isPlaying()) {
            x xVar = x.Qxl;
            if (!x.gXX()) {
                this.Pvr = true;
                x xVar2 = x.Qxl;
                x.CM(true);
                AppForegroundDelegate.INSTANCE.a(this.Pvs);
                AppMethodBeat.o(233245);
                return;
            }
        }
        x xVar3 = x.Qxl;
        x.CM(true);
        if (!t.gIO() && this.Pvm != null) {
            this.Pvm.gMO();
            this.Pvm.gMT();
            this.Pvm.release();
        }
        AppMethodBeat.o(233245);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final boolean Zx() {
        AppMethodBeat.i(35777);
        boolean gOP = ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP();
        boolean gOQ = ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ();
        boolean z = this.dom.gRL() || gOQ;
        if (gOP) {
            if (gOQ) {
                boolean iE = ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gON().iE(1);
                AppMethodBeat.o(35777);
                return iE;
            }
            boolean iE2 = ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOO().iE(1);
            AppMethodBeat.o(35777);
            return iE2;
        } else if ((!z || this.dom.GUe.fuH != 0) && !this.dom.GUe.Zx()) {
            AppMethodBeat.o(35777);
            return false;
        } else {
            AppMethodBeat.o(35777);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void gRy() {
        int i2;
        AppMethodBeat.i(35778);
        aa aaVar = (aa) this.dom.bh(aa.class);
        ai aiVar = (ai) this.dom.bh(ai.class);
        if (((l) this.dom.bh(l.class)).gPB() || aiVar.gQN()) {
            Log.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
            this.dom.BW(false);
            aaVar.setTitlePhoneIconVisibility(8);
            aaVar.setTitleMuteIconVisibility(8);
            AppMethodBeat.o(35778);
            return;
        }
        if (Zx()) {
            aaVar.setTitleMuteIconVisibility(0);
        } else {
            aaVar.setTitleMuteIconVisibility(8);
        }
        bg.aVF();
        Boolean bool = (Boolean) c.azQ().get(26, (Object) null);
        if (bool == null) {
            this.qUn = false;
        } else {
            this.qUn = bool.booleanValue();
        }
        Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", Boolean.valueOf(this.qUn));
        if (this.qUn) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        aaVar.setTitlePhoneIconVisibility(i2);
        AppMethodBeat.o(35778);
    }

    public final void acquireWakeLock() {
        AppMethodBeat.i(35779);
        this.dom.setKeepScreenOn(true);
        AppMethodBeat.o(35779);
    }

    public final void releaseWakeLock() {
        AppMethodBeat.i(35780);
        this.dom.setKeepScreenOn(false);
        if (this.Pvm != null && this.Pvr) {
            this.Pvr = false;
            this.Pvm.gMO();
            this.Pvm.gMT();
            this.Pvm.release();
        }
        AppForegroundDelegate.INSTANCE.b(this.Pvs);
        this.Pvr = false;
        AppMethodBeat.o(35780);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final boolean gRz() {
        return this.qUn;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void BV(boolean z) {
        AppMethodBeat.i(35781);
        if (this.Pvm == null) {
            Log.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
            AppMethodBeat.o(35781);
            return;
        }
        Log.printInfoStack("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", Boolean.valueOf(z));
        aa aaVar = (aa) this.dom.bh(aa.class);
        if (z) {
            this.Pvm.BL(false);
            this.qUn = true;
            bg.aVF();
            c.azQ().set(26, Boolean.TRUE);
            aaVar.setTitlePhoneIconVisibility(0);
            Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.dg0), 0).show();
            this.Pvm.gMS();
            this.dom.amK(R.raw.actionbar_ear_icon);
            AppMethodBeat.o(35781);
            return;
        }
        if (!com.tencent.mm.plugin.audio.c.a.ceb()) {
            this.Pvm.BL(true);
        } else {
            Log.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
        }
        this.qUn = false;
        bg.aVF();
        c.azQ().set(26, Boolean.FALSE);
        aaVar.setTitlePhoneIconVisibility(8);
        Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(R.string.dg1), 0).show();
        this.Pvm.gMS();
        this.dom.amK(R.raw.actionbar_loud_icon);
        AppMethodBeat.o(35781);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final boolean cl(ca caVar) {
        AppMethodBeat.i(35782);
        if (caVar.gAy()) {
            if (caVar.field_msgId == this.Pvm.Pei) {
                this.Pvm.gMT();
            }
            AppMethodBeat.o(35782);
            return true;
        }
        AppMethodBeat.o(35782);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final boolean cm(ca caVar) {
        AppMethodBeat.i(35783);
        if (caVar.gAy()) {
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                com.tencent.mm.ui.base.u.g(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView());
                AppMethodBeat.o(35783);
                return true;
            }
            if (caVar.field_msgId == this.Pvm.Pei) {
                this.Pvm.gMT();
            }
            if (!this.dom.getTalkerUserName().equals("medianote")) {
                bg.aVF();
                c.aSM().d(new f(caVar.field_talker, caVar.field_msgSvrId));
            }
            ak.bG(caVar);
            AppMethodBeat.o(35783);
            return true;
        }
        AppMethodBeat.o(35783);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    @TargetApi(9)
    public final void a(MMFragment mMFragment, boolean z) {
        AppMethodBeat.i(35784);
        if (mMFragment.getLandscapeMode()) {
            if (!z) {
                mMFragment.setRequestedOrientation(-1);
            } else if (Build.VERSION.SDK_INT >= 9) {
                Log.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", Integer.valueOf(mMFragment.getWindowManager().getDefaultDisplay().getOrientation()));
                switch (mMFragment.getWindowManager().getDefaultDisplay().getOrientation()) {
                    case 0:
                        mMFragment.setRequestedOrientation(1);
                        AppMethodBeat.o(35784);
                        return;
                    case 1:
                        mMFragment.setRequestedOrientation(0);
                        AppMethodBeat.o(35784);
                        return;
                    case 2:
                        mMFragment.setRequestedOrientation(9);
                        AppMethodBeat.o(35784);
                        return;
                    case 3:
                        mMFragment.setRequestedOrientation(8);
                        AppMethodBeat.o(35784);
                        return;
                    default:
                        AppMethodBeat.o(35784);
                        return;
                }
            } else if (this.dom.Pwc.getMMResources().getConfiguration().orientation == 2) {
                mMFragment.setRequestedOrientation(0);
                AppMethodBeat.o(35784);
                return;
            } else if (this.dom.Pwc.getMMResources().getConfiguration().orientation == 1) {
                mMFragment.setRequestedOrientation(1);
                AppMethodBeat.o(35784);
                return;
            }
        }
        AppMethodBeat.o(35784);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void NJ(long j2) {
        AppMethodBeat.i(233246);
        this.Pvq.put(Long.valueOf(j2), Boolean.TRUE);
        AppMethodBeat.o(233246);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final boolean NK(long j2) {
        AppMethodBeat.i(233247);
        if (this.Pvq.containsKey(Long.valueOf(j2))) {
            boolean booleanValue = this.Pvq.get(Long.valueOf(j2)).booleanValue();
            AppMethodBeat.o(233247);
            return booleanValue;
        }
        AppMethodBeat.o(233247);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void gRA() {
        this.Pvo = 0;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void a(long j2, View view) {
        AppMethodBeat.i(233248);
        this.Pvo = j2;
        this.Pvp = new WeakReference<>(view);
        AppMethodBeat.o(233248);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void NL(long j2) {
        RelativeLayout relativeLayout;
        AppMethodBeat.i(233249);
        if (this.Pvv == j2) {
            synchronized (lock) {
                try {
                    this.Pvt = true;
                } finally {
                    AppMethodBeat.o(233249);
                }
            }
            View zh = ((k) this.dom.bh(k.class)).zh(this.Pvv);
            if (!(zh == null || (relativeLayout = (RelativeLayout) zh.findViewById(R.id.avg)) == null)) {
                this.Pvv = -1;
                relativeLayout.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void NM(long j2) {
        View zh;
        RelativeLayout relativeLayout;
        AppMethodBeat.i(233250);
        synchronized (lock) {
            try {
                this.Pvt = true;
            } finally {
                AppMethodBeat.o(233250);
            }
        }
        if (!(this.Pvv != j2 || (zh = ((k) this.dom.bh(k.class)).zh(this.Pvv)) == null || (relativeLayout = (RelativeLayout) zh.findViewById(R.id.avg)) == null)) {
            this.Pvv = -1;
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final void gRB() {
        AppMethodBeat.i(233251);
        this.Pvw = true;
        gRC();
        AppMethodBeat.o(233251);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35785);
        super.gOK();
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", this.Pvm);
        com.tencent.mm.modelvoice.t.b(this.Pvm);
        e.b(this.Pvm);
        bg.azz().b(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, this);
        releaseWakeLock();
        if (this.Pvm != null) {
            this.Pvm.gMO();
            d dVar = this.Pvm;
            dVar.release();
            dVar.qUl.unInit();
            dVar.context = null;
            dVar.Peo = false;
            EventCenter.instance.removeListener(dVar.Pet);
            bg.Xi().b(dVar);
            this.Pvm = null;
        }
        com.tencent.mm.ak.a aVar = com.tencent.mm.ak.a.iLw;
        com.tencent.mm.ak.a.MA("VoiceComponent_playUploadVoiceSound");
        this.PvE.dead();
        AppMethodBeat.o(35785);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(233252);
        super.a(aVar);
        this.PvE.alive();
        AppMethodBeat.o(233252);
    }

    @Override // com.tencent.mm.ui.l
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(35786);
        AppMethodBeat.o(35786);
        return false;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35787);
        gRy();
        AppMethodBeat.o(35787);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35788);
        bg.azz().a(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, this);
        this.PvA.alive();
        this.PvB.alive();
        this.Pvt = false;
        gRC();
        AppMethodBeat.o(35788);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35790);
        doPause();
        AppMethodBeat.o(35790);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35791);
        bg.azz().b(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, this);
        if (this.Pvz != null) {
            this.Pvz.cancel(true);
        }
        this.PvA.dead();
        this.PvB.dead();
        this.Pvq.clear();
        AppMethodBeat.o(35791);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(233253);
        super.onScrollStateChanged(absListView, i2);
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "onScrollStateChanged %s", Integer.valueOf(i2));
        this.Pvw = false;
        if (i2 == 0) {
            this.Pvu = false;
            synchronized (lock) {
                try {
                    if (!this.Pvt) {
                        gRC();
                        AppMethodBeat.o(233253);
                    }
                } finally {
                    AppMethodBeat.o(233253);
                }
            }
        } else {
            this.Pvu = true;
            AppMethodBeat.o(233253);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e6, code lost:
        if (r9.Pvw == false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e8, code lost:
        r9.Pvw = false;
        com.tencent.matrix.trace.core.AppMethodBeat.o(233254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f5, code lost:
        r9.Pvw = true;
        gRC();
        com.tencent.matrix.trace.core.AppMethodBeat.o(233254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    @Override // com.tencent.mm.ui.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScroll(android.widget.AbsListView r10, int r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.bi.onScroll(android.widget.AbsListView, int, int, int):void");
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        MMHandler mMHandler;
        AppMethodBeat.i(35792);
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " sceneType:" + qVar.getType());
        this.dom.dismissDialog();
        if (!this.dom.cQp) {
            Log.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(35792);
        } else if (!Util.isTopActivity(this.dom.Pwc.getContext())) {
            AppMethodBeat.o(35792);
        } else {
            Activity context = this.dom.Pwc.getContext();
            if (z.a.a(context, i2, i3, str, 7)) {
                z = true;
            } else if (com.tencent.mm.plugin.account.ui.a.a(context, i2, i3, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(35792);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                switch (qVar.getType()) {
                    case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                        r Ro = s.Ro(((com.tencent.mm.modelvoice.f) qVar).fileName);
                        if (Ro != null && Ro.status == 99) {
                            if (((b) g.af(b.class)).a(b.a.clicfg_voice_component_upload_sound_async, 1) == 1) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                Log.i("MicroMsg.ChattingUI.VoiceComponent", "sync playUploadVoiceSound");
                                PlaySound.play(this.dom.Pwc.getContext(), R.string.gf);
                                break;
                            } else {
                                Log.i("MicroMsg.ChattingUI.VoiceComponent", "async playUploadVoiceSound");
                                com.tencent.mm.ak.a aVar = com.tencent.mm.ak.a.iLw;
                                AnonymousClass8 r2 = new kotlin.g.a.a<kotlin.x>() {
                                    /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass8 */

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ kotlin.x invoke() {
                                        AppMethodBeat.i(233242);
                                        PlaySound.play(bi.this.dom.Pwc.getContext(), R.string.gf);
                                        kotlin.x xVar = kotlin.x.SXb;
                                        AppMethodBeat.o(233242);
                                        return xVar;
                                    }
                                };
                                p.h("VoiceComponent_playUploadVoiceSound", "tag");
                                p.h(r2, "callback");
                                Log.i(com.tencent.mm.ak.a.TAG, "play, tag:".concat(String.valueOf("VoiceComponent_playUploadVoiceSound")));
                                com.tencent.mm.ak.e eVar = com.tencent.mm.ak.a.iLv.get("VoiceComponent_playUploadVoiceSound");
                                if (eVar == null || !eVar.thread.isAlive()) {
                                    Log.i(com.tencent.mm.ak.a.TAG, "createNewHandler, tag:".concat(String.valueOf("VoiceComponent_playUploadVoiceSound")));
                                    HandlerThread handlerThread = new HandlerThread("VoiceComponent_playUploadVoiceSound");
                                    handlerThread.start();
                                    com.tencent.mm.ak.e eVar2 = new com.tencent.mm.ak.e(handlerThread, new MMHandler(handlerThread.getLooper()));
                                    com.tencent.mm.ak.a.iLv.put("VoiceComponent_playUploadVoiceSound", eVar2);
                                    mMHandler = eVar2.handler;
                                } else {
                                    mMHandler = eVar.handler;
                                }
                                mMHandler.post(new com.tencent.mm.ak.b(r2));
                                AppMethodBeat.o(35792);
                                return;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(35792);
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aw
    public final boolean NN(long j2) {
        return this.Pvv == j2;
    }

    public final void gRC() {
        AppMethodBeat.i(233255);
        if (((ai) this.dom.bh(ai.class)).gQN()) {
            AppMethodBeat.o(233255);
        } else if (!gRD()) {
            AppMethodBeat.o(233255);
        } else {
            final k kVar = (k) this.dom.bh(k.class);
            final SparseArray<ca> gOq = kVar.gOq();
            if (gOq != null) {
                this.Pvz = com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.bi.AnonymousClass9 */

                    public final void run() {
                        ca caVar;
                        RelativeLayout relativeLayout;
                        View zh;
                        RelativeLayout relativeLayout2;
                        View zh2;
                        AppMethodBeat.i(233243);
                        Log.d("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt lastScrollState:%s", bi.this.Pvy);
                        long j2 = bi.this.Pvv;
                        bi.this.Pvv = -1;
                        int n = bi.n(bi.this);
                        bi.this.PvF.clear();
                        int size = gOq.size() - 1;
                        ca caVar2 = null;
                        while (true) {
                            if (size < 0) {
                                caVar = caVar2;
                                break;
                            }
                            ca caVar3 = (ca) gOq.get(size);
                            Pair a2 = bi.a(bi.this, kVar, caVar3, n);
                            if (((Boolean) a2.second).booleanValue()) {
                                caVar = caVar3;
                            } else {
                                caVar = caVar2;
                            }
                            if (!((Boolean) a2.first).booleanValue()) {
                                break;
                            }
                            size--;
                            caVar2 = caVar;
                        }
                        Object[] objArr = new Object[1];
                        objArr[0] = caVar != null ? caVar.field_msgId + "_" + caVar.field_content : BuildConfig.COMMAND;
                        Log.i("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt msg:%s", objArr);
                        if (caVar == null || (zh2 = kVar.zh(caVar.field_msgId)) == null) {
                            relativeLayout = null;
                        } else {
                            RelativeLayout relativeLayout3 = (RelativeLayout) zh2.findViewById(R.id.avg);
                            if (relativeLayout3 != null) {
                                bi.this.Pvv = caVar.field_msgId;
                            }
                            relativeLayout = relativeLayout3;
                        }
                        if (!(j2 == 0 || ((caVar != null && j2 == caVar.field_msgId) || (zh = kVar.zh(j2)) == null || (relativeLayout2 = (RelativeLayout) zh.findViewById(R.id.avg)) == null))) {
                            bi.this.PvF.add(new WeakReference(relativeLayout2));
                        }
                        for (WeakReference weakReference : bi.this.PvF) {
                            if (!(weakReference == null || weakReference.get() == null || weakReference.get() == relativeLayout)) {
                                ((View) weakReference.get()).setVisibility(8);
                            }
                        }
                        if (relativeLayout != null) {
                            relativeLayout.setVisibility(0);
                            if (j2 != bi.this.Pvv) {
                                bf.a.aW(1, bi.this.Pvv);
                            }
                        }
                        AppMethodBeat.o(233243);
                    }
                });
            }
            AppMethodBeat.o(233255);
        }
    }

    public static boolean gRD() {
        AppMethodBeat.i(233256);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_voice_trans_text_bt_switch, 0);
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "isOpenVoiceTransTextBt() swt:%s", Integer.valueOf(a2));
        if (a2 == 1) {
            AppMethodBeat.o(233256);
            return true;
        }
        AppMethodBeat.o(233256);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        long PvN = -1;
        long PvO = -1;

        a() {
        }

        public final String toString() {
            AppMethodBeat.i(233244);
            String str = "ScrollState{firstCheckMsgId=" + this.PvN + ", lastCheckMsgId=" + this.PvO + '}';
            AppMethodBeat.o(233244);
            return str;
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        c.b cG;
        AppMethodBeat.i(35789);
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", Looper.myLooper());
        this.Pvn = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.Pvr) {
            Log.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", this.Pvm, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper());
            if (this.Pvm == null) {
                this.Pvm = new d(this.dom, this, this.dom.getTalkerUserName());
                com.tencent.mm.modelvoice.t.c(this.Pvm);
                e.a(this.Pvm);
            } else {
                this.Pvm.bmt(this.dom.getTalkerUserName());
            }
            bg.aVF();
            boolean nullAs = Util.nullAs((Boolean) com.tencent.mm.model.c.azQ().get(16387, (Object) null), true);
            d dVar = this.Pvm;
            if (!dVar.Peo) {
                dVar.Pem = nullAs;
                dVar.gMO();
            }
            com.tencent.mm.api.c gOM = ((com.tencent.mm.ui.chatting.d.b.d) this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOM();
            if (!(gOM == null || (cG = gOM.cG(false)) == null)) {
                if (cG.dhz != null) {
                    cG.dhP = cG.dhz.optInt("AudioPlayType", 0) == 1;
                }
                if (cG.dhP) {
                    this.Pvm.Pen = false;
                }
            }
            this.Pvm.BL(!this.qUn);
            this.Pvm.BK(true);
        }
        Log.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (ab.Jq(this.dom.getTalkerUserName()) && ay.a.iDt != null) {
            ay.a.iDt.a(this.FNy);
        }
        if (!com.tencent.mm.aw.b.bdC()) {
            ((u) this.dom.bh(u.class)).setVoiceInputShowCallback(this.PvD);
        }
        gRy();
        AppForegroundDelegate.INSTANCE.b(this.Pvs);
        x xVar = x.Qxl;
        x.CM(true);
        AppMethodBeat.o(35789);
    }

    static /* synthetic */ int n(bi biVar) {
        AppMethodBeat.i(233258);
        int gQz = ((aa) biVar.dom.bh(aa.class)).gQz();
        AppMethodBeat.o(233258);
        return gQz;
    }

    static /* synthetic */ Pair a(bi biVar, k kVar, ca caVar, int i2) {
        AppMethodBeat.i(233259);
        if (caVar == null) {
            Boolean bool = Boolean.FALSE;
            Pair pair = new Pair(bool, bool);
            AppMethodBeat.o(233259);
            return pair;
        } else if (caVar.getType() != 34) {
            Pair pair2 = new Pair(Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(233259);
            return pair2;
        } else if (caVar.field_isSend == 1) {
            Pair pair3 = new Pair(Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(233259);
            return pair3;
        } else if (biVar.Pvy == null) {
            Pair pair4 = new Pair(Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(233259);
            return pair4;
        } else if (caVar.field_msgId > biVar.Pvy.PvO) {
            Pair pair5 = new Pair(Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(233259);
            return pair5;
        } else if (caVar.field_msgId < biVar.Pvy.PvN) {
            Boolean bool2 = Boolean.FALSE;
            Pair pair6 = new Pair(bool2, bool2);
            AppMethodBeat.o(233259);
            return pair6;
        } else {
            View zh = kVar.zh(caVar.field_msgId);
            if (zh == null) {
                Pair pair7 = new Pair(Boolean.TRUE, Boolean.FALSE);
                AppMethodBeat.o(233259);
                return pair7;
            }
            RelativeLayout relativeLayout = (RelativeLayout) zh.findViewById(R.id.avg);
            if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
                biVar.PvF.add(new WeakReference<>(relativeLayout));
            }
            d gRx = ((aw) biVar.dom.bh(aw.class)).gRx();
            if ((gRx != null && gRx.Pei == caVar.field_msgId) || s.ai(caVar)) {
                Pair pair8 = new Pair(Boolean.TRUE, Boolean.FALSE);
                AppMethodBeat.o(233259);
                return pair8;
            } else if (caVar.gDP()) {
                Pair pair9 = new Pair(Boolean.TRUE, Boolean.FALSE);
                AppMethodBeat.o(233259);
                return pair9;
            } else {
                int[] iArr = new int[2];
                zh.getLocationInWindow(iArr);
                if (iArr[1] == 0) {
                    Pair pair10 = new Pair(Boolean.TRUE, Boolean.FALSE);
                    AppMethodBeat.o(233259);
                    return pair10;
                }
                int i3 = iArr[1] - i2;
                if (i3 >= 0) {
                    Boolean bool3 = Boolean.TRUE;
                    Pair pair11 = new Pair(bool3, bool3);
                    AppMethodBeat.o(233259);
                    return pair11;
                }
                if (biVar.minHeight == -1) {
                    biVar.minHeight = com.tencent.mm.cb.a.fromDPToPix((Context) biVar.dom.Pwc.getContext(), 30);
                }
                if (i3 + zh.getHeight() > biVar.minHeight) {
                    Pair pair12 = new Pair(Boolean.FALSE, Boolean.TRUE);
                    AppMethodBeat.o(233259);
                    return pair12;
                }
                Boolean bool4 = Boolean.FALSE;
                Pair pair13 = new Pair(bool4, bool4);
                AppMethodBeat.o(233259);
                return pair13;
            }
        }
    }
}
