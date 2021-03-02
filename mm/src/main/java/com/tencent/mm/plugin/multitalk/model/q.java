package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.s;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.bh.e;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitalk.b.f;
import com.tencent.mm.plugin.multitalk.b.j;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.plugin.multitalk.model.v;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.multitalk.ui.widget.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ern;
import com.tencent.mm.protocal.protobuf.ero;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.ae;

public final class q implements ServiceConnection, com.tencent.pb.talkroom.sdk.a {
    private Timer dfh;
    public boolean guh;
    IListener hXn = new IListener<mu>() {
        /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass6 */

        {
            AppMethodBeat.i(239377);
            this.__eventId = mu.class.getName().hashCode();
            AppMethodBeat.o(239377);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mu muVar) {
            mu.b bVar;
            boolean emo;
            AppMethodBeat.i(239378);
            mu muVar2 = muVar;
            if (muVar2 instanceof mu) {
                switch (muVar2.dSs.action) {
                    case 1:
                        bVar = muVar2.dSt;
                        emo = q.this.ems();
                        bVar.isStart = emo;
                        break;
                    case 2:
                        bVar = muVar2.dSt;
                        q qVar = q.this;
                        emo = qVar.zLR != null ? qVar.zLR.emo() : false;
                        bVar.isStart = emo;
                        break;
                }
            }
            AppMethodBeat.o(239378);
            return false;
        }
    };
    public boolean mkd;
    public boolean yon;
    public e zLR;
    public boolean zMA = false;
    public Bundle zMB;
    public HashSet<String> zMC = new HashSet<>();
    public o zMD = o.Init;
    public MultiTalkGroup zME = null;
    public z zMF;
    public boolean zMG = false;
    public boolean zMH = false;
    private long zMI = 0;
    public int zMJ = 0;
    private int zMK = 0;
    private int zML = 2;
    private boolean zMM = false;
    private boolean zMN = false;
    private long zMO = 0;
    private long zMP = 30000;
    private v.a zMQ;
    private boolean zMR;
    private MultiTalkGroup zMS = null;
    private long zMT = 0;
    private boolean zMU = false;
    public com.tencent.mm.plugin.multitalk.a.a zMV;
    private t zMW;
    private ag zMX;
    private ae zMY;
    private a zMZ;
    private boolean zMv;
    private boolean zMw;
    public int zMx;
    private boolean zMy = true;
    public boolean zMz = false;
    private Object zNa = new Object();
    HashMap<String, Integer> zNb = new HashMap<>();
    public CopyOnWriteArrayList<String> zNc = new CopyOnWriteArrayList<>();
    private MTimerHandler zNd = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass11 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(239380);
            Log.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
            if (q.this.zMS == null) {
                q.this.zMT = 0;
                q.this.zNd.stopTimer();
                AppMethodBeat.o(239380);
                return false;
            } else if (q.gD(MMApplicationContext.getContext())) {
                q.this.b(q.this.zMS);
                q.this.zMS = null;
                q.this.zMT = 0;
                q.this.zNd.stopTimer();
                h.INSTANCE.idkeyStat(500, 7, 1, false);
                AppMethodBeat.o(239380);
                return false;
            } else if (System.currentTimeMillis() - q.this.zMT < Util.MILLSECONDS_OF_MINUTE) {
                AppMethodBeat.o(239380);
                return true;
            } else {
                q.this.zMS = null;
                q.this.zMT = 0;
                q.this.zNd.stopTimer();
                AppMethodBeat.o(239380);
                return false;
            }
        }
    }, true);
    a zNe;
    public boolean zNf = false;
    private MMHandler zNg = new MMHandler(Looper.getMainLooper());
    BroadcastReceiver zNh = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass3 */

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r10, android.content.Intent r11) {
            /*
            // Method dump skipped, instructions count: 177
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.q.AnonymousClass3.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    private IListener zNi = new IListener<rh>() {
        /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass5 */

        {
            AppMethodBeat.i(239374);
            this.__eventId = rh.class.getName().hashCode();
            AppMethodBeat.o(239374);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rh rhVar) {
            AppMethodBeat.i(239376);
            boolean a2 = a(rhVar);
            AppMethodBeat.o(239376);
            return a2;
        }

        private boolean a(rh rhVar) {
            AppMethodBeat.i(239375);
            if (rhVar != null) {
                switch (rhVar.dXY.type) {
                    case 1:
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.PHONE_STATE");
                        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
                        intentFilter.addAction("android.intent.action.PHONE_STATE2");
                        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
                        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        try {
                            MMApplicationContext.getContext().registerReceiver(q.this.zNh, intentFilter);
                            break;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver register error %s", e2.fillInStackTrace());
                            break;
                        }
                    case 2:
                        try {
                            MMApplicationContext.getContext().unregisterReceiver(q.this.zNh);
                            break;
                        } catch (Exception e3) {
                            Log.e("MicroMsg.MT.MultiTalkManager", "phoneStatusReceiver unregister error %s", e3.fillInStackTrace());
                            break;
                        }
                }
            }
            AppMethodBeat.o(239375);
            return false;
        }
    };

    static /* synthetic */ void a(q qVar, String str, String str2, int i2) {
        AppMethodBeat.i(239416);
        qVar.af(str, str2, i2);
        AppMethodBeat.o(239416);
    }

    static /* synthetic */ boolean gD(Context context) {
        AppMethodBeat.i(239417);
        boolean isAppOnForeground = isAppOnForeground(context);
        AppMethodBeat.o(239417);
        return isAppOnForeground;
    }

    static /* synthetic */ int n(q qVar) {
        int i2 = qVar.zMJ;
        qVar.zMJ = i2 + 1;
        return i2;
    }

    public q() {
        AppMethodBeat.i(114486);
        EventCenter.instance.addListener(this.hXn);
        EventCenter.instance.addListener(this.zNi);
        this.zMR = false;
        AppMethodBeat.o(114486);
    }

    public final void a(e eVar) {
        this.zLR = eVar;
    }

    public final void enm() {
        this.zLR = null;
    }

    public final MultiTalkGroup enn() {
        return this.zME;
    }

    public final boolean eno() {
        AppMethodBeat.i(114487);
        boolean Rl = v.Rl(this.zMx);
        AppMethodBeat.o(114487);
        return Rl;
    }

    public static boolean enp() {
        int i2;
        AppMethodBeat.i(239382);
        if (ac.eom().zMC.contains(z.aTY())) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (ac.eom().zMC.size() > i2) {
            AppMethodBeat.o(239382);
            return true;
        }
        AppMethodBeat.o(239382);
        return false;
    }

    public final boolean Zx() {
        return this.guh;
    }

    public final boolean enq() {
        return this.mkd;
    }

    public final HashSet<String> enr() {
        return this.zMC;
    }

    public final boolean aFW(String str) {
        int i2;
        AppMethodBeat.i(239383);
        if (Util.isNullOrNil(str)) {
            str = this.zME.zHD;
            if (Util.isNullOrNil(str)) {
                str = this.zME.RGY;
            }
        }
        if (this.zNb.containsKey(str)) {
            i2 = this.zNb.get(str).intValue();
        } else {
            i2 = 0;
        }
        if (i2 == 2) {
            AppMethodBeat.o(239383);
            return true;
        }
        AppMethodBeat.o(239383);
        return false;
    }

    public final boolean ens() {
        AppMethodBeat.i(239384);
        if (this.zME != null) {
            boolean aFW = aFW(this.zME.zHE);
            AppMethodBeat.o(239384);
            return aFW;
        }
        AppMethodBeat.o(239384);
        return false;
    }

    public final void eM(String str, int i2) {
        AppMethodBeat.i(239385);
        Log.i("MicroMsg.MT.MultiTalkManager", "setCurrentMTSDKMode groupid:%s, mode:%d", str, Integer.valueOf(i2));
        if (this.zNb == null) {
            AppMethodBeat.o(239385);
            return;
        }
        if (!this.zNb.containsKey(str) || this.zNb.get(str).intValue() != i2) {
            this.zNb.put(str, Integer.valueOf(i2));
        }
        AppMethodBeat.o(239385);
    }

    public final void aFX(String str) {
        AppMethodBeat.i(239386);
        Log.i("MicroMsg.MT.MultiTalkManager", "removeCurrentMTSDKMode groupid:%s", str);
        if (this.zNb != null && this.zNb.containsKey(str)) {
            this.zNb.remove(str);
        }
        AppMethodBeat.o(239386);
    }

    public final boolean ems() {
        boolean z;
        AppMethodBeat.i(114489);
        if (this.zMD == o.Init || this.zME == null) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", Boolean.valueOf(z));
        AppMethodBeat.o(114489);
        return z;
    }

    public final boolean ent() {
        boolean z;
        AppMethodBeat.i(114490);
        if (this.zMD == o.Starting || this.zMD == o.Talking) {
            z = true;
        } else {
            z = false;
        }
        Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", Boolean.valueOf(z));
        AppMethodBeat.o(114490);
        return z;
    }

    public final boolean emr() {
        boolean z;
        AppMethodBeat.i(114491);
        if (this.zMD == o.Talking) {
            z = true;
        } else {
            z = false;
        }
        Log.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", Boolean.valueOf(z));
        AppMethodBeat.o(114491);
        return z;
    }

    public final long getTotalTime() {
        AppMethodBeat.i(114492);
        long currentTimeMillis = System.currentTimeMillis() - this.zMI;
        AppMethodBeat.o(114492);
        return currentTimeMillis;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        boolean z;
        AppMethodBeat.i(114493);
        if (!ems()) {
            Log.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", v.g(multiTalkGroup));
            this.zME = multiTalkGroup;
            this.zMJ = 0;
            this.zMx = 1;
            this.zMC.clear();
            enu();
            sort();
            AppMethodBeat.o(114493);
            return true;
        }
        MultiTalkGroup multiTalkGroup2 = this.zME;
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            z = false;
        } else if (!Util.isNullOrNil(multiTalkGroup.zHD) && !Util.isNullOrNil(multiTalkGroup2.zHD) && multiTalkGroup.zHD.equals(multiTalkGroup2.zHD)) {
            z = true;
        } else if (Util.isNullOrNil(multiTalkGroup.RGY) || Util.isNullOrNil(multiTalkGroup2.RGY) || !multiTalkGroup.RGY.equals(multiTalkGroup2.RGY)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Log.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", v.g(multiTalkGroup));
            MultiTalkGroup multiTalkGroup3 = this.zME;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.RHa) {
                hashMap.put(multiTalkGroupMember.RHb, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup3.RHa) {
                if (!z.aTY().equals(multiTalkGroupMember2.RHb) && z.aTY().equals(multiTalkGroupMember2.RHc) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.RHb) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.RHb)).status == 20) {
                        Toast.makeText(MMApplicationContext.getContext(), l.c(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f76, aa.getDisplayName(multiTalkGroupMember2.RHb))), 0).show();
                    }
                }
            }
            this.zME = multiTalkGroup;
            enu();
            sort();
            AppMethodBeat.o(114493);
            return true;
        }
        Log.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", v.g(this.zME), v.g(multiTalkGroup));
        AppMethodBeat.o(114493);
        return false;
    }

    private void sort() {
        AppMethodBeat.i(114494);
        Log.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", this.zME.RHa);
        LinkedList linkedList = new LinkedList();
        MultiTalkGroupMember multiTalkGroupMember = null;
        for (MultiTalkGroupMember multiTalkGroupMember2 : this.zME.RHa) {
            if (!multiTalkGroupMember2.RHb.equals(z.aTY())) {
                linkedList.add(multiTalkGroupMember2);
            } else {
                multiTalkGroupMember = multiTalkGroupMember2;
            }
        }
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(MultiTalkGroupMember multiTalkGroupMember, MultiTalkGroupMember multiTalkGroupMember2) {
                AppMethodBeat.i(114469);
                int i2 = -multiTalkGroupMember.RHb.compareTo(multiTalkGroupMember2.RHb);
                AppMethodBeat.o(114469);
                return i2;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(MultiTalkGroupMember multiTalkGroupMember, MultiTalkGroupMember multiTalkGroupMember2) {
                MultiTalkGroupMember multiTalkGroupMember3 = multiTalkGroupMember;
                MultiTalkGroupMember multiTalkGroupMember4 = multiTalkGroupMember2;
                if (multiTalkGroupMember3.RGf > multiTalkGroupMember4.RGf) {
                    return -1;
                }
                if (multiTalkGroupMember3.RGf < multiTalkGroupMember4.RGf) {
                    return 1;
                }
                return 0;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass8 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(MultiTalkGroupMember multiTalkGroupMember, MultiTalkGroupMember multiTalkGroupMember2) {
                MultiTalkGroupMember multiTalkGroupMember3 = multiTalkGroupMember;
                MultiTalkGroupMember multiTalkGroupMember4 = multiTalkGroupMember2;
                if (!(multiTalkGroupMember3.status == 10 && multiTalkGroupMember4.status == 10)) {
                    if (multiTalkGroupMember3.status == 10) {
                        return -1;
                    }
                    if (multiTalkGroupMember3.status == 10) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        if (multiTalkGroupMember != null) {
            linkedList.add(multiTalkGroupMember);
        }
        this.zME.RHa = linkedList;
        Log.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", this.zME.RHa);
        AppMethodBeat.o(114494);
    }

    private void enu() {
        AppMethodBeat.i(114495);
        for (MultiTalkGroupMember multiTalkGroupMember : this.zME.RHa) {
            if (multiTalkGroupMember.status != 10 && this.zMC.remove(multiTalkGroupMember.RHb)) {
                Log.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", multiTalkGroupMember.RHb);
            }
        }
        AppMethodBeat.o(114495);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0093, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fA(java.util.List<java.lang.String> r14) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.q.fA(java.util.List):void");
    }

    public final void c(Activity activity, final String str, final String str2) {
        AppMethodBeat.i(114496);
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.guh);
        objArr[1] = Boolean.valueOf(this.mkd);
        objArr[2] = Boolean.valueOf(this.zMy);
        objArr[3] = this.zMD.toString();
        objArr[4] = Boolean.valueOf(this.zME == null);
        Log.i("MicroMsg.MT.MultiTalkManager", "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", objArr);
        p.ena();
        if (enQ()) {
            com.tencent.mm.ui.base.h.n(activity, R.string.e3e, R.string.zb);
            AppMethodBeat.o(114496);
        } else if (m.fKH()) {
            com.tencent.mm.ui.base.h.n(activity, R.string.e3i, R.string.zb);
            AppMethodBeat.o(114496);
        } else if (m.isVoipStarted()) {
            com.tencent.mm.ui.base.h.n(activity, R.string.e3h, R.string.zb);
            AppMethodBeat.o(114496);
        } else if (e.bgH()) {
            com.tencent.mm.ui.base.h.n(activity, R.string.e3d, R.string.zb);
            AppMethodBeat.o(114496);
        } else if (m.fKI()) {
            com.tencent.mm.ui.base.h.n(activity, R.string.e3g, R.string.zb);
            AppMethodBeat.o(114496);
        } else if (ems()) {
            e.a(activity, R.string.f64, null);
            AppMethodBeat.o(114496);
        } else if (!this.zMN || System.currentTimeMillis() - this.zMO >= this.zMP) {
            this.zMN = false;
            ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
            int a2 = ((b) g.af(b.class)).a(b.a.voipmt_mode, 0);
            Log.i("MicroMsg.MT.MultiTalkManager", "getMultiTalkSDKMode sdk mode:%d", Integer.valueOf(a2));
            if (a2 == 1) {
                af(str, str2, 2);
                AppMethodBeat.o(114496);
                return;
            }
            p pVar = p.INSTANCE;
            AnonymousClass9 r4 = new com.tencent.mm.plugin.multitalk.b.b<Integer>() {
                /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass9 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.multitalk.b.b
                public final /* synthetic */ void a(int i2, int i3, String str, Integer num) {
                    int i4;
                    AppMethodBeat.i(239379);
                    Integer num2 = num;
                    if (i2 == 0 && i3 == 0) {
                        i4 = num2.intValue();
                        if (!(i4 == 2 || i4 == 1)) {
                            i4 = 1;
                        }
                        Log.i("MicroMsg.MT.MultiTalkManager", "steve: getMTSDKMode done! svrmode:%d, finalmode:%d", Integer.valueOf(num2.intValue()), Integer.valueOf(i4));
                    } else {
                        Log.e("MicroMsg.MT.MultiTalkManager", "steve: getMTSDKMode fail errtype %d errcode %d errMsg: %s, finalmode:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, 1);
                        i4 = 1;
                    }
                    q.a(q.this, str, str2, i4);
                    AppMethodBeat.o(239379);
                }
            };
            d.a aVar = new d.a();
            aVar.iLN = new ern();
            aVar.iLO = new ero();
            aVar.funcId = 5949;
            aVar.uri = "/cgi-bin/micromsg-bin/voipmtgetsdkmode";
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            LinkedList<esc> linkedList = new LinkedList<>();
            Iterator<String> it = stringsToList.iterator();
            while (it.hasNext()) {
                esc esc = new esc();
                esc.username = it.next();
                linkedList.add(esc);
            }
            d aXF = aVar.aXF();
            ern ern = (ern) aXF.iLK.iLR;
            ern.Npf = linkedList;
            ern.NoW = str2;
            IPCRunCgi.a(aXF, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0157: INVOKE  
                  (r3v3 'aXF' com.tencent.mm.ak.d)
                  (wrap: com.tencent.mm.plugin.multitalk.b.p$5 : 0x0154: CONSTRUCTOR  (r0v33 com.tencent.mm.plugin.multitalk.b.p$5) = (r1v1 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r4v3 'r4' com.tencent.mm.plugin.multitalk.model.q$9) call: com.tencent.mm.plugin.multitalk.b.p.5.<init>(com.tencent.mm.plugin.multitalk.b.p, com.tencent.mm.plugin.multitalk.b.b):void type: CONSTRUCTOR)
                 type: STATIC call: com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a(com.tencent.mm.ak.d, com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi$a):com.tencent.mm.ak.q in method: com.tencent.mm.plugin.multitalk.model.q.c(android.app.Activity, java.lang.String, java.lang.String):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0154: CONSTRUCTOR  (r0v33 com.tencent.mm.plugin.multitalk.b.p$5) = (r1v1 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r4v3 'r4' com.tencent.mm.plugin.multitalk.model.q$9) call: com.tencent.mm.plugin.multitalk.b.p.5.<init>(com.tencent.mm.plugin.multitalk.b.p, com.tencent.mm.plugin.multitalk.b.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.model.q.c(android.app.Activity, java.lang.String, java.lang.String):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 35 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 41 more
                */
            /*
            // Method dump skipped, instructions count: 351
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.q.c(android.app.Activity, java.lang.String, java.lang.String):void");
        }

        private void af(String str, String str2, int i2) {
            boolean a2;
            AppMethodBeat.i(239388);
            ArrayList<String> stringsToList = Util.stringsToList(str.split(","));
            synchronized (this.zNa) {
                try {
                    if (this.zMD != o.Init) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "already in multitalk! cannot start again, status:%s", this.zMD.toString());
                        return;
                    }
                    if (i2 == 2) {
                        ArrayList<j> arrayList = new ArrayList<>();
                        for (String str3 : stringsToList) {
                            j jVar = new j();
                            jVar.goe = str3;
                            jVar.mStatus = 2;
                            arrayList.add(jVar);
                        }
                        p.INSTANCE.y((long) Util.nullAsNil((Integer) g.aAh().hqB.get(1)), z.aTY());
                        p.INSTANCE.e(arrayList, str2);
                        eM(str2, 2);
                        b(o.Creating);
                        a2 = true;
                    } else {
                        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
                        multiTalkGroup.RGY = ac.eol().zMd.hju();
                        multiTalkGroup.zHE = str2;
                        for (String str4 : stringsToList) {
                            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                            multiTalkGroupMember.RHb = str4;
                            if (str4.equals(z.aTY())) {
                                multiTalkGroupMember.status = 10;
                            } else {
                                multiTalkGroupMember.status = 1;
                            }
                            multiTalkGroup.RHa.add(multiTalkGroupMember);
                        }
                        ac.eol().zMd.dr(Util.nullAsNil((Integer) g.aAh().hqB.get(1)), z.aTY());
                        a2 = ac.eol().zMd.a(multiTalkGroup.RGY, str2, stringsToList, v2protocal.fJa());
                        eM(str2, 1);
                        b(o.Creating);
                        a(multiTalkGroup, Boolean.TRUE);
                    }
                    if (a2) {
                        p.emV();
                    } else {
                        p.emW();
                    }
                    com.tencent.mm.plugin.multitalk.d.d dVar = com.tencent.mm.plugin.multitalk.d.d.zZa;
                    com.tencent.mm.plugin.multitalk.d.d.reset();
                    AppMethodBeat.o(239388);
                } finally {
                    AppMethodBeat.o(239388);
                }
            }
        }

        public final void aFS(String str) {
            AppMethodBeat.i(239389);
            if (this.zLR != null) {
                this.zLR.aFS(str);
            }
            AppMethodBeat.o(239389);
        }

        public final void aFY(String str) {
            AppMethodBeat.i(239390);
            if (this.zLR != null) {
                this.zLR.aFT(str);
            }
            AppMethodBeat.o(239390);
        }

        public final void j(boolean z, boolean z2, boolean z3) {
            AppMethodBeat.i(114497);
            Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.FALSE, Boolean.valueOf(z3));
            env().close();
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
            ac.eom().stopRing();
            if (ems()) {
                rh rhVar = new rh();
                rhVar.dXY.type = 2;
                EventCenter.instance.publish(rhVar);
                k(z, z2, z3);
                o oVar = this.zMD;
                if (this.zLR != null) {
                    this.zLR.emt();
                }
                this.zMG = false;
                this.zMH = false;
                this.zMD = o.Init;
                enM();
                eny();
                rH(false);
                this.zMZ = null;
                qm(true);
                bUm();
                if (this.zMV != null) {
                    this.zMV.elB();
                    com.tencent.mm.plugin.multitalk.a.a.unInit();
                }
                ac.eok().reset();
                if (this.zME != null) {
                    a(this.zME, oVar, z2);
                    String str = this.zME.zHD;
                    if (Util.isNullOrNil(str)) {
                        str = this.zME.RGY;
                    }
                    Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isILinkMode %b", Boolean.valueOf(ens()));
                    p.INSTANCE.Rb(1);
                    ac.eol().zMd.aFM(str);
                    this.zME = null;
                } else {
                    Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: currentMultiTalkGroup null");
                }
                this.zMx = 0;
                this.mkd = true;
                this.guh = false;
                this.zMy = true;
                this.zMI = 0;
                this.zMJ = 0;
                this.zMC.clear();
                EventCenter.instance.publish(new fn());
                this.zMM = true;
            } else {
                Log.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: not connecting, isHangupMultitalk %b", Boolean.valueOf(this.zMM));
                if (!this.zMM) {
                    enM();
                    qm(false);
                    bUm();
                    if (this.zMV != null) {
                        this.zMV.elB();
                    }
                    this.zME = null;
                    this.zMx = 0;
                    this.zMI = 0;
                    this.zMJ = 0;
                    this.zMC.clear();
                    this.zMD = o.Init;
                    this.zMK = 0;
                }
            }
            this.zNc.clear();
            com.tencent.mm.plugin.multitalk.d.d dVar = com.tencent.mm.plugin.multitalk.d.d.zZa;
            com.tencent.mm.plugin.multitalk.d.d.report();
            enK();
            AppMethodBeat.o(114497);
        }

        public final boolean aFZ(String str) {
            AppMethodBeat.i(239391);
            ArrayList arrayList = new ArrayList(this.zNc);
            if (arrayList.contains(str)) {
                AppMethodBeat.o(239391);
                return true;
            }
            arrayList.add(str);
            this.zNc = new CopyOnWriteArrayList<>(arrayList);
            AppMethodBeat.o(239391);
            return false;
        }

        public final void aGa(String str) {
            AppMethodBeat.i(239392);
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.zNc.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!next.equals(str)) {
                    arrayList.add(next);
                }
            }
            this.zNc = new CopyOnWriteArrayList<>(arrayList);
            AppMethodBeat.o(239392);
        }

        private void a(MultiTalkGroup multiTalkGroup, boolean z, boolean z2, boolean z3, boolean z4) {
            AppMethodBeat.i(239394);
            String k = v.k(multiTalkGroup);
            p.iO(multiTalkGroup.zHE, k);
            p.aFV(k);
            if (this.zMD != o.Talking) {
                boolean j2 = v.j(this.zME);
                long totalTime = getTotalTime();
                int i2 = 0;
                if (j2) {
                    if (z2) {
                        i2 = 4;
                    } else if (z) {
                        i2 = 1;
                    } else if (z4) {
                        i2 = 5;
                    } else {
                        i2 = 2;
                    }
                } else if (z2) {
                    if (totalTime >= 45) {
                        i2 = 6;
                    } else {
                        i2 = 8;
                    }
                } else if (z) {
                    i2 = 7;
                } else if (z4) {
                    i2 = 10;
                }
                p.a(j2, totalTime, k, i2);
                AppMethodBeat.o(239394);
                return;
            }
            p.Rh(this.zMJ);
            p.z((long) this.zMJ, k);
            if (multiTalkGroup.RHa != null) {
                p.Re(multiTalkGroup.RHa.size());
            }
            AppMethodBeat.o(239394);
        }

        public final void d(String str, String str2, boolean z, boolean z2) {
            AppMethodBeat.i(114498);
            if (!com.tencent.mm.model.v.HU(str)) {
                Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", str);
                ay.a.iDq.a(str, "", new ay.b.a() {
                    /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass10 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(String str, boolean z) {
                    }
                });
            }
            ca caVar = new ca();
            caVar.setType(64);
            caVar.setCreateTime(System.currentTimeMillis());
            caVar.setStatus(6);
            caVar.nv(2);
            String aGb = aGb(str2);
            caVar.setContent(aGb);
            if (com.tencent.mm.model.v.HW(str)) {
                caVar.Cy(str);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
                az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(str);
                if (bjY != null) {
                    if (z) {
                        bjY.nt(bjY.field_unReadCount + 1);
                    }
                    bjY.setContent(aGb);
                    if (((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a(bjY, str) == -1) {
                        Log.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(str)));
                    }
                    if (z2) {
                        ((ba) ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(caVar);
                        AppMethodBeat.o(114498);
                        return;
                    }
                } else {
                    az azVar = new az();
                    azVar.setUsername(str);
                    if (z) {
                        azVar.nt(1);
                    }
                    azVar.setContent(aGb);
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().e(azVar);
                    if (z2) {
                        ((ba) ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(caVar);
                    }
                }
            }
            AppMethodBeat.o(114498);
        }

        private h env() {
            AppMethodBeat.i(239395);
            if (this.zMW == null) {
                this.zMW = new t();
            }
            t tVar = this.zMW;
            AppMethodBeat.o(239395);
            return tVar;
        }

        public final t enw() {
            AppMethodBeat.i(239396);
            if (this.zMW == null) {
                this.zMW = new t();
            }
            t tVar = this.zMW;
            AppMethodBeat.o(239396);
            return tVar;
        }

        public final af enx() {
            AppMethodBeat.i(239397);
            if (this.zMX == null) {
                this.zMX = new ag(ac.eol().zMd);
            }
            ag agVar = this.zMX;
            AppMethodBeat.o(239397);
            return agVar;
        }

        private void eny() {
            AppMethodBeat.i(239398);
            if (this.zMX == null) {
                AppMethodBeat.o(239398);
                return;
            }
            this.zMX.close();
            this.zMX = null;
            AppMethodBeat.o(239398);
        }

        public final ae enz() {
            AppMethodBeat.i(239399);
            if (this.zMY == null) {
                this.zMY = new ae();
            }
            ae aeVar = this.zMY;
            AppMethodBeat.o(239399);
            return aeVar;
        }

        private void rH(boolean z) {
            AppMethodBeat.i(239400);
            if (this.zMY == null) {
                AppMethodBeat.o(239400);
                return;
            }
            this.zMY.aa(z);
            if (!z) {
                this.zMY = null;
            }
            AppMethodBeat.o(239400);
        }

        public final a enA() {
            AppMethodBeat.i(239401);
            if (this.zMZ == null) {
                this.zMZ = new a();
            }
            a aVar = this.zMZ;
            AppMethodBeat.o(239401);
            return aVar;
        }

        private static String aGb(String str) {
            AppMethodBeat.i(239402);
            String displayName = aa.getDisplayName(str);
            if (displayName != null && !displayName.equals("")) {
                str = displayName;
            }
            String str2 = str + MMApplicationContext.getContext().getString(R.string.f7_);
            AppMethodBeat.o(239402);
            return str2;
        }

        public final void aGc(String str) {
            AppMethodBeat.i(239403);
            ca caVar = new ca();
            caVar.setType(64);
            caVar.setCreateTime(System.currentTimeMillis());
            caVar.setStatus(6);
            caVar.setContent(MMApplicationContext.getContext().getString(R.string.f79));
            if (com.tencent.mm.model.v.HW(str)) {
                caVar.Cy(str);
                caVar.setContent(caVar.field_content);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
            }
            if (this.zMS != null && str.equals(this.zMS.zHE) && !this.zNd.stopped()) {
                Log.i("MicroMsg.MT.MultiTalkManager", "multiTalkGroupTmp wxGroupId equals this wxGroupId.");
                this.zMS = null;
                this.zMT = 0;
                this.zNd.stopTimer();
            }
            AppMethodBeat.o(239403);
        }

        public static void aGd(String str) {
            AppMethodBeat.i(114499);
            Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
            ca caVar = new ca();
            caVar.setType(64);
            caVar.setCreateTime(System.currentTimeMillis());
            caVar.setStatus(6);
            caVar.setContent(MMApplicationContext.getContext().getString(R.string.f7b));
            if (com.tencent.mm.model.v.HW(str)) {
                caVar.Cy(str);
                caVar.setContent(caVar.field_content);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
            }
            AppMethodBeat.o(114499);
        }

        private static void a(MultiTalkGroup multiTalkGroup, o oVar, boolean z) {
            AppMethodBeat.i(114500);
            Log.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
            if (oVar == o.Inviting && z) {
                ca caVar = new ca();
                caVar.setType(64);
                caVar.setCreateTime(System.currentTimeMillis());
                caVar.setStatus(6);
                caVar.setContent(MMApplicationContext.getContext().getString(R.string.f7b));
                if (com.tencent.mm.model.v.HW(multiTalkGroup.zHE)) {
                    caVar.Cy(multiTalkGroup.zHE);
                    caVar.setContent(caVar.field_content);
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
                }
            }
            AppMethodBeat.o(114500);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void n(int i2, Object obj) {
            int intValue;
            String str;
            a.ac acVar;
            a.ab abVar;
            int i3 = R.string.f5l;
            AppMethodBeat.i(114501);
            Log.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", Integer.valueOf(i2));
            g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, (Object) -1);
            g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, (Object) -1L);
            switch (i2) {
                case -14287:
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip the talking case old version in group and over limited");
                    i3 = R.string.f5v;
                    break;
                case -14256:
                    Log.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                    i3 = R.string.f5u;
                    if (!(obj == null || ((a.ac) obj) == null)) {
                        com.tencent.wecall.talkroom.model.a.hqJ().Eh(false);
                        break;
                    }
                case -14255:
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = this.zME;
                    if (this.zME != null) {
                        str = this.zME.zHE;
                    } else {
                        str = "";
                    }
                    objArr[2] = str;
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s", objArr);
                    if (!(obj == null || (acVar = (a.ac) obj) == null)) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + acVar.groupId);
                        if (acVar.RDq != null) {
                            ac.eop().aFO(acVar.RDq.RFQ);
                            Log.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + acVar.RDq.RFQ);
                        }
                        if (!ac.eol().zMd.aFM(acVar.groupId)) {
                            Log.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + acVar.groupId);
                        }
                    }
                    i3 = R.string.f78;
                    break;
                case -1700:
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", obj);
                    Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.f5l), 0).show();
                    if (obj != null && (intValue = ((Integer) obj).intValue()) > 0) {
                        g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(intValue));
                        g.aAh().azQ().set(ar.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(Util.currentTicks()));
                        break;
                    }
                case -1601:
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, skip MULTITALK_ERRORCODE_SUBSCRIBEGENERALVEDIO_FAIL! ");
                    AppMethodBeat.o(114501);
                    return;
                case -1400:
                    i3 = R.string.f5t;
                    break;
                case -1300:
                    i3 = R.string.f5s;
                    this.zMN = true;
                    this.zMO = System.currentTimeMillis();
                    if (!(obj == null || (abVar = (a.ab) obj) == null)) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + abVar.REQ);
                        if (abVar.REQ != 0) {
                            this.zMP = (long) (abVar.REQ * 1000);
                            break;
                        }
                    }
                    break;
                case -1200:
                    i3 = R.string.f5r;
                    break;
                case -1100:
                    i3 = R.string.f5q;
                    break;
                case -1000:
                    i3 = R.string.f5p;
                    break;
                case -900:
                    i3 = R.string.f63;
                    break;
                case -800:
                    i3 = R.string.f62;
                    break;
                case -700:
                    i3 = R.string.f61;
                    break;
                case -600:
                    i3 = R.string.f60;
                    break;
                case -500:
                    i3 = R.string.f5z;
                    break;
                case -401:
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                    i3 = R.string.f6o;
                    break;
                case -400:
                    i3 = R.string.f5y;
                    break;
                case -301:
                    Log.i("MicroMsg.MT.MultiTalkManager", "onErr, add fail over limited");
                    i3 = R.string.f5v;
                    break;
                case -300:
                    i3 = R.string.f5x;
                    break;
                case -200:
                    p.rG(false);
                    i3 = R.string.f5w;
                    break;
                case -100:
                    p.rF(false);
                    i3 = R.string.f5o;
                    break;
                default:
                    i3 = R.string.f60;
                    break;
            }
            if (this.zLR != null) {
                this.zLR.onError(i2);
            }
            if (!(i2 == -800 || i2 == -500 || i2 == -1700)) {
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(i3), 0).show();
                j(false, false, true);
            }
            AppMethodBeat.o(114501);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void b(final MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(114502);
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(this.guh);
            objArr[1] = Boolean.valueOf(this.mkd);
            objArr[2] = Boolean.valueOf(this.zMy);
            objArr[3] = this.zMD.toString();
            objArr[4] = Boolean.valueOf(this.zME == null);
            Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b", objArr);
            p.enb();
            if (com.tencent.mm.n.g.apP() || isAppOnForeground(MMApplicationContext.getContext())) {
                String l = v.l(multiTalkGroup);
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(l);
                if (!e.bgI() || Kn == null || Kn.ary()) {
                    Log.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass12 */

                        public final void run() {
                            AppMethodBeat.i(239381);
                            String str = multiTalkGroup.zHD;
                            if (Util.isNullOrNil(str)) {
                                str = multiTalkGroup.RGY;
                            }
                            ac.eol().zMd.aFM(str);
                            AppMethodBeat.o(239381);
                        }
                    }, 1000);
                    p.bI(3, v.k(multiTalkGroup));
                    AppMethodBeat.o(114502);
                } else if (ems() || m.isVoipStarted() || m.fKH() || e.bgH() || e.isCalling() || m.fKI() || !c.oR(Kn.field_type)) {
                    Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", v.g(multiTalkGroup));
                    if (!com.tencent.mm.model.v.HU(multiTalkGroup.zHE)) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.zHE);
                        ay.a.iDq.a(multiTalkGroup.zHE, "", new ay.b.a() {
                            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass13 */

                            @Override // com.tencent.mm.model.ay.b.a
                            public final void p(String str, boolean z) {
                            }
                        });
                    }
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass14 */

                        public final void run() {
                            AppMethodBeat.i(114485);
                            String str = multiTalkGroup.zHD;
                            if (Util.isNullOrNil(str)) {
                                str = multiTalkGroup.RGY;
                            }
                            ac.eol().zMd.aFM(str);
                            AppMethodBeat.o(114485);
                        }
                    }, 1000);
                    p.bI(3, v.k(multiTalkGroup));
                    AppMethodBeat.o(114502);
                } else {
                    if (!com.tencent.mm.model.v.HU(multiTalkGroup.zHE)) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.zHE);
                        ay.a.iDq.a(multiTalkGroup.zHE, "", null);
                    }
                    Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", v.g(multiTalkGroup));
                    b(o.Inviting);
                    p.bI(1, v.k(multiTalkGroup));
                    if (!c.oR(Kn.field_type) || com.tencent.mm.q.a.atu()) {
                        Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", l, z.aTY());
                        if (a(multiTalkGroup)) {
                            this.zMv = false;
                            enC();
                            bpu();
                            AppMethodBeat.o(114502);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", l, z.aTY());
                        mu muVar = new mu();
                        muVar.dSs.action = 3;
                        EventCenter.instance.publish(muVar);
                        a(multiTalkGroup, Boolean.FALSE);
                    }
                    AppMethodBeat.o(114502);
                }
            } else {
                Log.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
                if (this.zMS == null && this.zNd.stopped()) {
                    this.zMS = multiTalkGroup;
                    this.zNd.startTimer(2000);
                    this.zMT = System.currentTimeMillis();
                    h.INSTANCE.idkeyStat(500, 6, 1, false);
                }
                AppMethodBeat.o(114502);
            }
        }

        public final void a(MultiTalkGroup multiTalkGroup, Boolean bool) {
            boolean z = false;
            AppMethodBeat.i(114503);
            Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
            if (a(multiTalkGroup)) {
                enJ();
                this.zMv = false;
                enC();
                bpu();
                Intent intent = new Intent();
                RemoteViews remoteViews = null;
                String str = "";
                if (!bool.booleanValue()) {
                    if (com.tencent.mm.compatible.util.d.oF(28) || Build.VERSION.CODENAME.equals("Q")) {
                        z = true;
                    }
                    if (z) {
                        this.zNe = new a(multiTalkGroup, Boolean.FALSE);
                    }
                    String string = MMApplicationContext.getResources().getString(R.string.f69);
                    intent.putExtra("Voip_User", v.l(multiTalkGroup));
                    String displayName = aa.getDisplayName(((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(intent.getStringExtra("Voip_User")).field_username);
                    remoteViews = new RemoteViews(MMApplicationContext.getPackageName(), (int) R.layout.c6z);
                    remoteViews.setTextViewText(R.id.g2f, string);
                    remoteViews.setTextViewText(R.id.g2e, displayName);
                    remoteViews.setImageViewResource(R.id.jlo, R.drawable.bvl);
                    remoteViews.setImageViewResource(R.id.g2_, R.drawable.bvg);
                    str = displayName + string;
                }
                com.tencent.mm.util.a.a(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent, remoteViews, str, com.tencent.mm.bq.a.glD());
            }
            AppMethodBeat.o(114503);
        }

        public final void enB() {
            AppMethodBeat.i(162239);
            this.zNe = null;
            this.zMM = false;
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
            AppMethodBeat.o(162239);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void c(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(114505);
            p.bI(2, v.k(multiTalkGroup));
            a(multiTalkGroup, o.Inviting, true);
            AppMethodBeat.o(114505);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void d(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(114506);
            Log.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", v.g(multiTalkGroup));
            p.rF(true);
            if (a(multiTalkGroup)) {
                enD();
            }
            AppMethodBeat.o(114506);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void e(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(114507);
            Log.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", v.g(multiTalkGroup));
            rh rhVar = new rh();
            rhVar.dXY.type = 1;
            EventCenter.instance.publish(rhVar);
            p.rG(true);
            if (this.zMD != o.Inviting) {
                b(o.Starting);
                a(multiTalkGroup, Boolean.TRUE);
            }
            if (ems() && a(multiTalkGroup)) {
                enD();
            }
            AppMethodBeat.o(114507);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void f(MultiTalkGroup multiTalkGroup) {
            AppMethodBeat.i(114509);
            Log.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", v.g(multiTalkGroup));
            if (ems() && a(multiTalkGroup)) {
                if (v.i(this.zME)) {
                    if (this.zMD != o.Talking && v.h(multiTalkGroup)) {
                        b(o.Talking);
                    }
                    if (this.zLR != null && v.c(this.zMD)) {
                        this.zLR.emu();
                    }
                } else if (this.zMD == o.Inviting) {
                    j(false, true, false);
                    AppMethodBeat.o(114509);
                    return;
                } else {
                    j(false, false, false);
                    AppMethodBeat.o(114509);
                    return;
                }
            }
            AppMethodBeat.o(114509);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void enE() {
            AppMethodBeat.i(114510);
            Log.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
            AppMethodBeat.o(114510);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void rv(boolean z) {
            AppMethodBeat.i(114511);
            this.guh = z;
            if (this.zLR != null) {
                this.zLR.rv(this.guh);
            }
            AppMethodBeat.o(114511);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void enF() {
            AppMethodBeat.i(114513);
            Log.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", Integer.valueOf(this.zMx));
            AppMethodBeat.o(114513);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void enG() {
            AppMethodBeat.i(114514);
            Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
            AppMethodBeat.o(114514);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void enH() {
            AppMethodBeat.i(178889);
            Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeGeneralVideoSuss ");
            AppMethodBeat.o(178889);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void enI() {
            AppMethodBeat.i(239404);
            Log.i("MicroMsg.MT.MultiTalkManager", "onSubscribeScreenSharingVideoSuss ");
            AppMethodBeat.o(239404);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void Ri(int i2) {
            AppMethodBeat.i(114515);
            Log.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(i2)));
            if (i2 > 0) {
                this.zMR = true;
                AppMethodBeat.o(114515);
                return;
            }
            this.zMR = false;
            AppMethodBeat.o(114515);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void fz(List<a.as> list) {
            AppMethodBeat.i(114516);
            if (ems()) {
                this.zMC.clear();
                Log.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", list);
                for (a.as asVar : list) {
                    if (asVar.videoStatus == 2 || asVar.videoStatus == 3) {
                        this.zMC.add(asVar.dLN);
                    }
                }
                h env = env();
                if (env != null) {
                    env.fz(list);
                }
                Log.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", this.zMC);
                if (this.zLR != null) {
                    this.zLR.emv();
                    AppMethodBeat.o(114516);
                    return;
                }
                Log.e("MicroMsg.MT.MultiTalkManager", "uiCallback is NULL !!!");
            }
            AppMethodBeat.o(114516);
        }

        @Override // com.tencent.pb.talkroom.sdk.a
        public final void Rd(int i2) {
            AppMethodBeat.i(239405);
            h env = env();
            if (env != null) {
                env.Rd(i2);
            }
            AppMethodBeat.o(239405);
        }

        public final void rI(boolean z) {
            AppMethodBeat.i(114517);
            if (ems()) {
                if (this.yon) {
                    AppMethodBeat.o(114517);
                    return;
                }
                p.j(v.enW(), v.Rl(ac.eom().zMx), z);
                Toast.makeText(MMApplicationContext.getContext(), (int) R.string.f6j, 0).show();
                String string = MMApplicationContext.getContext().getString(R.string.f5g);
                String string2 = MMApplicationContext.getContext().getString(R.string.f6s);
                Intent intent = new Intent();
                if (this.zMA) {
                    intent.putExtra("enterMainUIScreenProjectOnline", true);
                    intent.putExtra("enterMainUIScreenProjectParams", this.zMB);
                }
                intent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
                PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), 43, intent, 134217728);
                int i2 = R.drawable.cj8;
                if (com.tencent.mm.compatible.util.d.oE(19)) {
                    i2 = R.drawable.cj7;
                }
                s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(string2).i(System.currentTimeMillis()).f(string).g(string2);
                g2.Hv = activity;
                final Notification e2 = m.e(g2);
                e2.icon = i2;
                e2.flags |= 32;
                ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, e2, false);
                if (this.zLR != null) {
                    this.zLR.dZZ();
                    this.yon = true;
                }
                eny();
                rH(true);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass2 */

                    public final void run() {
                        String str;
                        AppMethodBeat.i(239368);
                        Intent intent = new Intent();
                        if (q.this.zMA) {
                            intent.putExtra("enterMainUIScreenProjectOnline", true);
                            intent.putExtra("enterMainUIScreenProjectParams", q.this.zMB);
                        }
                        intent.setFlags(268435456);
                        if (q.this.zME != null) {
                            str = q.this.zME.zHE;
                        } else {
                            str = "";
                        }
                        intent.putExtra("enterMainUiWxGroupId", str);
                        intent.setClass(MMApplicationContext.getContext(), MultiTalkMainUI.class);
                        intent.putExtra("notification", e2);
                        intent.putExtra("enterMainUiSource", 1);
                        n eon = ac.eon();
                        AnonymousClass1 r3 = new com.tencent.mm.plugin.voip.ui.a() {
                            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.voip.ui.a
                            public final boolean dZV() {
                                AppMethodBeat.i(239366);
                                if (q.this.ent() || q.this.emr()) {
                                    AppMethodBeat.o(239366);
                                    return true;
                                }
                                AppMethodBeat.o(239366);
                                return false;
                            }

                            @Override // com.tencent.mm.plugin.voip.ui.a
                            public final void a(Intent intent, BaseSmallView baseSmallView) {
                                AppMethodBeat.i(239367);
                                if (!q.this.emr()) {
                                    baseSmallView.aGx(MMApplicationContext.getContext().getString(R.string.f7m));
                                    AppMethodBeat.o(239367);
                                    return;
                                }
                                int i2 = q.this.zMJ;
                                baseSmallView.aGy(String.format("%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)));
                                AppMethodBeat.o(239367);
                            }
                        };
                        ac.eom();
                        boolean enp = q.enp();
                        eon.intent = intent;
                        eon.zTN = r3;
                        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
                            Log.e("MicroMsg.MultiTalkSmallWindow", "mini, permission denied");
                            Context context = MMApplicationContext.getContext();
                            RequestFloatWindowPermissionDialog.a(context, context.getString(R.string.i2r), new n.i(eon, r3, intent, enp), com.tencent.mm.bq.a.apJ());
                        } else {
                            eon.aM(intent);
                        }
                        q.g(q.this);
                        AppMethodBeat.o(239368);
                    }
                });
            }
            AppMethodBeat.o(114517);
        }

        public final void qm(boolean z) {
            AppMethodBeat.i(178890);
            this.yon = false;
            if (z) {
                ac.eon().eoN();
            } else {
                ac.eon().rX(false);
            }
            ((NotificationManager) MMApplicationContext.getContext().getSystemService("notification")).cancel(43);
            enK();
            AppMethodBeat.o(178890);
        }

        public final void enJ() {
            AppMethodBeat.i(239406);
            this.zMV = new com.tencent.mm.plugin.multitalk.a.a();
            if (this.mkd) {
                this.zMV.cV(true);
            }
            com.tencent.mm.plugin.multitalk.a.a.elz();
            AppMethodBeat.o(239406);
        }

        private void enK() {
            AppMethodBeat.i(114519);
            try {
                Log.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
                if (com.tencent.mm.compatible.util.d.oD(26) && this.zMU) {
                    MMApplicationContext.getContext().unbindService(this);
                    this.zMU = false;
                }
                AppMethodBeat.o(114519);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MT.MultiTalkManager", e2, "unBind VoipSmallService error: %s", e2.getMessage());
                AppMethodBeat.o(114519);
            }
        }

        public final void enL() {
            String str;
            MultitalkFrameView multitalkFrameView;
            AppMethodBeat.i(114520);
            Log.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
            if (ens()) {
                Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver exit due to ILINK mode!!!");
                AppMethodBeat.o(114520);
            } else if (this.zLR == null) {
                Log.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
                AppMethodBeat.o(114520);
            } else if (this.zMC.size() == 0) {
                Log.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
                AppMethodBeat.o(114520);
            } else {
                if (this.zMF == null) {
                    Log.i("MicroMsg.MT.MultiTalkManager", "startNetworkDataSource: NetworkDataSource is null %d", Integer.valueOf(this.zMC.size()));
                    this.zMF = new z();
                }
                this.zMF.a(enz());
                this.zMF.start();
                if (enA().emb()) {
                    com.tencent.mm.plugin.multitalk.ui.widget.b bVar = enA().zKR;
                    if (bVar == null || (multitalkFrameView = bVar.zQT) == null || (str = multitalkFrameView.getUsername()) == null) {
                        str = "";
                    }
                    bR(str, false);
                }
                AppMethodBeat.o(114520);
            }
        }

        public final void enM() {
            AppMethodBeat.i(114521);
            Log.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkDataSource");
            if (this.zMF != null) {
                this.zMF.stop();
                this.zMF = null;
            }
            AppMethodBeat.o(114521);
        }

        public final void rJ(boolean z) {
            AppMethodBeat.i(114512);
            Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "set multitalk speaker %s", Boolean.valueOf(z));
            if (ens()) {
                f fVar = p.INSTANCE.zHV;
                if (fVar.zHq != null) {
                    fVar.zHq.zHu.kJ(z);
                }
            } else {
                ac.eol().zMd.rJ(z);
            }
            Log.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", Boolean.valueOf(z));
            this.mkd = z;
            if (this.zLR != null) {
                this.zLR.rw(this.mkd);
            }
            AppMethodBeat.o(114512);
        }

        public final void rK(boolean z) {
            AppMethodBeat.i(239407);
            if (ens()) {
                p pVar = p.INSTANCE;
                Log.i("MicroMsg.Multitalk.ILinkService", "hy: set mute record: %b", Boolean.valueOf(z));
                pVar.aj(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE  
                      (r0v3 'pVar' com.tencent.mm.plugin.multitalk.b.p)
                      (wrap: com.tencent.mm.plugin.multitalk.b.p$33 : 0x0023: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.multitalk.b.p$33) = (r0v3 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r8v0 'z' boolean) call: com.tencent.mm.plugin.multitalk.b.p.33.<init>(com.tencent.mm.plugin.multitalk.b.p, boolean):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.plugin.multitalk.b.p.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.model.q.rK(boolean):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0023: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.multitalk.b.p$33) = (r0v3 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r8v0 'z' boolean) call: com.tencent.mm.plugin.multitalk.b.p.33.<init>(com.tencent.mm.plugin.multitalk.b.p, boolean):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.model.q.rK(boolean):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r6 = 239407(0x3a72f, float:3.3548E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                    boolean r0 = r7.ens()
                    if (r0 == 0) goto L_0x0030
                    com.tencent.mm.plugin.multitalk.b.p r0 = com.tencent.mm.plugin.multitalk.b.p.INSTANCE
                    java.lang.String r1 = "MicroMsg.Multitalk.ILinkService"
                    java.lang.String r2 = "hy: set mute record: %b"
                    r3 = 1
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    r4 = 0
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)
                    r3[r4] = r5
                    com.tencent.mm.sdk.platformtools.Log.i(r1, r2, r3)
                    com.tencent.mm.plugin.multitalk.b.p$33 r1 = new com.tencent.mm.plugin.multitalk.b.p$33
                    r1.<init>(r8)
                    r0.aj(r1)
                L_0x0029:
                    r7.rv(r8)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    return
                L_0x0030:
                    com.tencent.mm.plugin.multitalk.model.o r0 = com.tencent.mm.plugin.multitalk.model.ac.eol()
                    com.tencent.pb.talkroom.sdk.d r0 = r0.zMd
                    r0.rK(r8)
                    goto L_0x0029
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.q.rK(boolean):void");
            }

            public final boolean aF(int i2, boolean z) {
                boolean z2;
                AppMethodBeat.i(239408);
                if (z) {
                    if (ent()) {
                        this.zNf = true;
                        this.zMx = i2;
                        if (!ac.eom().ens()) {
                            boolean aqv = ac.eol().zMd.aqv(i2);
                            AppMethodBeat.o(239408);
                            return aqv;
                        }
                        AppMethodBeat.o(239408);
                        return true;
                    }
                    AppMethodBeat.o(239408);
                    return false;
                } else if (ent()) {
                    this.zNf = false;
                    boolean ens = ac.eom().ens();
                    Log.i("MicroMsg.MT.MultiTalkManager", "try switch to action : " + i2 + ", isILink:" + ens);
                    if (!ens) {
                        z2 = ac.eol().zMd.aqv(i2);
                        if (v.Rm(this.zMx)) {
                            enL();
                        } else {
                            enM();
                        }
                    } else {
                        z2 = false;
                    }
                    Log.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo result: %b", Boolean.valueOf(z2));
                    int i3 = this.zMx;
                    this.zMx = i2;
                    if (!(this.zLR == null || i3 == this.zMx)) {
                        this.zLR.hh(i3, this.zMx);
                    }
                    AppMethodBeat.o(239408);
                    return z2;
                } else {
                    AppMethodBeat.o(239408);
                    return false;
                }
            }

            public static boolean Rj(int i2) {
                AppMethodBeat.i(239409);
                if (!ac.eom().ens()) {
                    boolean aqv = ac.eol().zMd.aqv(i2);
                    AppMethodBeat.o(239409);
                    return aqv;
                }
                p pVar = p.INSTANCE;
                pVar.aj(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                      (r0v2 'pVar' com.tencent.mm.plugin.multitalk.b.p)
                      (wrap: com.tencent.mm.plugin.multitalk.b.p$36 : 0x0022: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.multitalk.b.p$36) = (r0v2 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r3v0 'i2' int) call: com.tencent.mm.plugin.multitalk.b.p.36.<init>(com.tencent.mm.plugin.multitalk.b.p, int):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.plugin.multitalk.b.p.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.model.q.Rj(int):boolean, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.multitalk.b.p$36) = (r0v2 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r3v0 'i2' int) call: com.tencent.mm.plugin.multitalk.b.p.36.<init>(com.tencent.mm.plugin.multitalk.b.p, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.model.q.Rj(int):boolean, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 18 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 24 more
                    */
                /*
                    r2 = 239409(0x3a731, float:3.35483E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    com.tencent.mm.plugin.multitalk.model.q r0 = com.tencent.mm.plugin.multitalk.model.ac.eom()
                    boolean r0 = r0.ens()
                    if (r0 != 0) goto L_0x001e
                    com.tencent.mm.plugin.multitalk.model.o r0 = com.tencent.mm.plugin.multitalk.model.ac.eol()
                    com.tencent.pb.talkroom.sdk.d r0 = r0.zMd
                    boolean r0 = r0.aqv(r3)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x001d:
                    return r0
                L_0x001e:
                    com.tencent.mm.plugin.multitalk.b.p r0 = com.tencent.mm.plugin.multitalk.b.p.INSTANCE
                    com.tencent.mm.plugin.multitalk.b.p$36 r1 = new com.tencent.mm.plugin.multitalk.b.p$36
                    r1.<init>(r3)
                    r0.aj(r1)
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x001d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.q.Rj(int):boolean");
            }

            public final boolean aGe(String str) {
                AppMethodBeat.i(114524);
                if (ent()) {
                    Log.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(str)));
                    if (ens()) {
                        if (str.equals("")) {
                            this.zLR.emw();
                            Log.i("MicroMsg.MT.MultiTalkManager", " ilink subscribe small video of visiable region OK!");
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str);
                            p pVar = p.INSTANCE;
                            pVar.aj(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004e: INVOKE  
                                  (r1v3 'pVar' com.tencent.mm.plugin.multitalk.b.p)
                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$29 : 0x004b: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.multitalk.b.p$29) = (r1v3 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r0v9 'arrayList' java.util.ArrayList) call: com.tencent.mm.plugin.multitalk.b.p.29.<init>(com.tencent.mm.plugin.multitalk.b.p, java.util.ArrayList):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.tencent.mm.plugin.multitalk.b.p.aj(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.model.q.aGe(java.lang.String):boolean, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.multitalk.b.p$29) = (r1v3 'pVar' com.tencent.mm.plugin.multitalk.b.p), (r0v9 'arrayList' java.util.ArrayList) call: com.tencent.mm.plugin.multitalk.b.p.29.<init>(com.tencent.mm.plugin.multitalk.b.p, java.util.ArrayList):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.model.q.aGe(java.lang.String):boolean, file: classes7.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 33 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.p, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 39 more
                                */
                            /*
                            // Method dump skipped, instructions count: 135
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.model.q.aGe(java.lang.String):boolean");
                        }

                        public final void bR(String str, boolean z) {
                            AppMethodBeat.i(239410);
                            if (ens()) {
                                Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast exit due to ILINK mode!!!");
                                ArrayList<String> arrayList = new ArrayList<>();
                                if (!TextUtils.isEmpty(str)) {
                                    arrayList.add(str);
                                }
                                p.INSTANCE.d(arrayList, z);
                                AppMethodBeat.o(239410);
                                return;
                            }
                            if (this.zMF == null) {
                                this.zMF = new z();
                            }
                            this.zMF.a(enz());
                            if (TextUtils.isEmpty(str)) {
                                this.zMF.eof();
                                AppMethodBeat.o(239410);
                                return;
                            }
                            Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast ownerUserName : ".concat(String.valueOf(str)));
                            this.zMF.aGm(str);
                            Log.i("MicroMsg.MT.MultiTalkManager", "subscribeScreenCast error");
                            AppMethodBeat.o(239410);
                        }

                        public final void enN() {
                            AppMethodBeat.i(239411);
                            if (this.zMF == null) {
                                this.zMF = new z();
                            }
                            this.zMF.a(enz());
                            this.zMF.start();
                            ac.eom().enx().rQ(true);
                            AppMethodBeat.o(239411);
                        }

                        public final boolean fB(List<a.ar> list) {
                            AppMethodBeat.i(239412);
                            if (ent()) {
                                Log.i("MicroMsg.MT.MultiTalkManager", "memberListInfo : ".concat(String.valueOf(list)));
                                boolean fB = ac.eol().zMd.fB(list);
                                Log.i("MicroMsg.MT.MultiTalkManager", "result of subscribeGeneralVideoForUserList: ".concat(String.valueOf(fB)));
                                AppMethodBeat.o(239412);
                                return fB;
                            }
                            AppMethodBeat.o(239412);
                            return false;
                        }

                        private void b(o oVar) {
                            boolean z = true;
                            AppMethodBeat.i(114525);
                            o oVar2 = this.zMD;
                            this.zMD = oVar;
                            if (oVar2 != oVar) {
                                if (oVar == o.Talking) {
                                    rh rhVar = new rh();
                                    rhVar.dXY.type = 1;
                                    EventCenter.instance.publish(rhVar);
                                    p.a(v.j(this.zME), getTotalTime(), v.k(this.zME));
                                    ac.eom().stopRing();
                                    com.tencent.mm.plugin.audio.c.a.setMode(3);
                                    if (com.tencent.mm.plugin.audio.c.a.cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
                                        z = false;
                                    }
                                    rJ(z);
                                    ac.eol().rz(z);
                                }
                                if (this.zLR != null) {
                                    this.zLR.a(oVar);
                                }
                            }
                            AppMethodBeat.o(114525);
                        }

                        private void bpu() {
                            AppMethodBeat.i(114526);
                            Log.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
                            if (this.dfh != null) {
                                this.dfh.cancel();
                                AppMethodBeat.o(114526);
                                return;
                            }
                            this.zMI = System.currentTimeMillis();
                            this.zMJ = 0;
                            this.dfh = new Timer();
                            this.dfh.schedule(new TimerTask() {
                                /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass4 */

                                {
                                    AppMethodBeat.i(161203);
                                    AppMethodBeat.o(161203);
                                }

                                public final void run() {
                                    AppMethodBeat.i(239373);
                                    if (q.this.getTotalTime() >= 45000 && q.this.zMD != o.Talking) {
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass4.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(239371);
                                                q.this.j(false, true, false);
                                                AppMethodBeat.o(239371);
                                            }
                                        });
                                    }
                                    if (q.this.zMD == o.Talking) {
                                        q.n(q.this);
                                        com.tencent.f.h.RTc.aV(new Runnable() {
                                            /* class com.tencent.mm.plugin.multitalk.model.q.AnonymousClass4.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(239372);
                                                if (q.this.zMD == o.Talking) {
                                                    n eon = ac.eon();
                                                    int i2 = q.this.zMJ;
                                                    com.tencent.mm.plugin.multitalk.ui.widget.m mVar = eon.zTM;
                                                    if (mVar != null) {
                                                        ae aeVar = ae.SYK;
                                                        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)}, 2));
                                                        kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
                                                        mVar.aGy(format);
                                                    }
                                                    if (q.this.zLR != null) {
                                                        q.this.zLR.eaa();
                                                    }
                                                }
                                                AppMethodBeat.o(239372);
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(239373);
                                }
                            }, 1000, 1000);
                            AppMethodBeat.o(114526);
                        }

                        private void bUm() {
                            AppMethodBeat.i(114527);
                            if (this.dfh != null) {
                                this.dfh.cancel();
                                this.dfh = null;
                            }
                            AppMethodBeat.o(114527);
                        }

                        public final List<String> elR() {
                            List<String> bpM;
                            AppMethodBeat.i(239413);
                            if (this.zME == null) {
                                AppMethodBeat.o(239413);
                                return null;
                            }
                            String str = this.zME.zHD;
                            if (Util.isNullOrNil(str)) {
                                str = this.zME.RGY;
                            }
                            boolean aFW = aFW(this.zME.zHE);
                            Log.d("MicroMsg.MT.MultiTalkManager", "getTalkingMember: %s, groupid:%s, isILink:%b", v.g(this.zME), this.zME.zHE, Boolean.valueOf(aFW));
                            new ArrayList();
                            if (aFW) {
                                bpM = p.INSTANCE.elR();
                            } else {
                                bpM = ac.eol().zMd.bpM(str);
                            }
                            AppMethodBeat.o(239413);
                            return bpM;
                        }

                        public final boolean enO() {
                            return this.zMR;
                        }

                        public final void rL(boolean z) {
                            this.zMy = z;
                        }

                        public final boolean enP() {
                            return this.zMy;
                        }

                        public final void rM(boolean z) {
                            AppMethodBeat.i(114528);
                            if (this.zMv) {
                                AppMethodBeat.o(114528);
                                return;
                            }
                            if (this.zMV != null) {
                                this.zMV.P(z, 0);
                                this.zMv = true;
                            }
                            AppMethodBeat.o(114528);
                        }

                        public final boolean czl() {
                            AppMethodBeat.i(239414);
                            if (this.zMV != null) {
                                boolean YZ = this.zMV.hTl.YZ();
                                AppMethodBeat.o(239414);
                                return YZ;
                            }
                            AppMethodBeat.o(239414);
                            return true;
                        }

                        public final void stopRing() {
                            AppMethodBeat.i(114529);
                            if (this.zMv && this.zMV != null) {
                                this.zMV.elA();
                                this.zMv = false;
                            }
                            AppMethodBeat.o(114529);
                        }

                        private static boolean enQ() {
                            Exception e2;
                            boolean z;
                            AppMethodBeat.i(114530);
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
                                if (telephonyManager != null) {
                                    int callState = telephonyManager.getCallState();
                                    switch (callState) {
                                        case 0:
                                            z = false;
                                            break;
                                        case 1:
                                        case 2:
                                            z = true;
                                            break;
                                        default:
                                            z = false;
                                            break;
                                    }
                                    try {
                                        Log.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", Integer.valueOf(callState));
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        Log.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e2.getLocalizedMessage());
                                        AppMethodBeat.o(114530);
                                        return z;
                                    }
                                } else {
                                    z = false;
                                }
                            } catch (Exception e4) {
                                e2 = e4;
                                z = false;
                                Log.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e2.getLocalizedMessage());
                                AppMethodBeat.o(114530);
                                return z;
                            }
                            AppMethodBeat.o(114530);
                            return z;
                        }

                        private static boolean isAppOnForeground(Context context) {
                            AppMethodBeat.i(114531);
                            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1);
                            if (runningTasks != null && !runningTasks.isEmpty()) {
                                ComponentName componentName = runningTasks.get(0).topActivity;
                                Log.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
                                if (!componentName.getPackageName().equals(context.getPackageName())) {
                                    Log.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                                    AppMethodBeat.o(114531);
                                    return false;
                                }
                            }
                            if (((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                                AppMethodBeat.o(114531);
                                return false;
                            }
                            Log.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
                            AppMethodBeat.o(114531);
                            return true;
                        }

                        public final void emx() {
                            AppMethodBeat.i(239415);
                            if (ac.eom().ent() && this.zLR != null) {
                                Log.i("MicroMsg.MT.MultiTalkManager", "exitProjectScreen");
                                this.zLR.emx();
                            }
                            AppMethodBeat.o(239415);
                        }

                        public final void rx(boolean z) {
                            AppMethodBeat.i(114532);
                            if (ac.eom().ent() && this.zLR != null) {
                                Log.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", Boolean.valueOf(z));
                                this.zLR.rx(z);
                            }
                            AppMethodBeat.o(114532);
                        }

                        public static void enR() {
                            AppMethodBeat.i(178891);
                            n eon = ac.eon();
                            if (eon.zTM != null && !eon.zTO) {
                                com.tencent.f.h.RTc.bqo("showIcon");
                                com.tencent.f.h.RTc.b(new n.f(eon), "showIcon");
                            }
                            AppMethodBeat.o(178891);
                        }

                        public final void rN(boolean z) {
                            AppMethodBeat.i(114533);
                            Log.printInfoStack("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", Boolean.valueOf(z));
                            this.zMw = z;
                            AppMethodBeat.o(114533);
                        }

                        public final boolean enS() {
                            return this.zMw;
                        }

                        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        }

                        public final void onServiceDisconnected(ComponentName componentName) {
                        }

                        /* access modifiers changed from: package-private */
                        public class a {
                            MultiTalkGroup zNs;
                            Boolean zNt;

                            a(MultiTalkGroup multiTalkGroup, Boolean bool) {
                                this.zNs = multiTalkGroup;
                                this.zNt = bool;
                            }
                        }

                        private void k(boolean z, boolean z2, boolean z3) {
                            AppMethodBeat.i(239393);
                            a(this.zME, z, z2, false, z3);
                            AppMethodBeat.o(239393);
                        }

                        private void enC() {
                            q qVar;
                            boolean z;
                            q qVar2;
                            AppMethodBeat.i(114504);
                            if (this.zMD == o.Creating) {
                                qVar = this;
                            } else if (com.tencent.mm.plugin.audio.c.a.cdW() || com.tencent.mm.plugin.audio.c.a.ceb()) {
                                qVar = this;
                            } else {
                                z = true;
                                qVar2 = this;
                                qVar2.mkd = z;
                                this.guh = false;
                                this.zMQ = v.enY();
                                AppMethodBeat.o(114504);
                            }
                            z = false;
                            qVar2 = qVar;
                            qVar2.mkd = z;
                            this.guh = false;
                            this.zMQ = v.enY();
                            AppMethodBeat.o(114504);
                        }

                        private void enD() {
                            AppMethodBeat.i(114508);
                            if (v.h(this.zME)) {
                                b(o.Talking);
                            } else {
                                b(o.Starting);
                            }
                            if (this.zLR != null) {
                                this.zLR.eie();
                                v.a enY = v.enY();
                                if (enY != this.zMQ) {
                                    this.zMQ = enY;
                                }
                                AppMethodBeat.o(114508);
                                return;
                            }
                            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
                            AppMethodBeat.o(114508);
                        }

                        static /* synthetic */ void g(q qVar) {
                            AppMethodBeat.i(239418);
                            try {
                                Log.i("MicroMsg.MT.MultiTalkManager", "bindSmallServiceIfNeed");
                                if (com.tencent.mm.compatible.util.d.oD(26)) {
                                    qVar.zMU = true;
                                    Intent intent = new Intent();
                                    if (qVar.zMA) {
                                        intent.putExtra("enterMainUIScreenProjectOnline", true);
                                        intent.putExtra("enterMainUIScreenProjectParams", qVar.zMB);
                                    }
                                    intent.setClass(MMApplicationContext.getContext(), MultiTalkingForegroundService.class);
                                    MMApplicationContext.getContext().bindService(intent, qVar, 1);
                                }
                                AppMethodBeat.o(239418);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.MT.MultiTalkManager", e2, "bindSmallServiceIfNeed error: %s", e2.getMessage());
                                AppMethodBeat.o(239418);
                            }
                        }
                    }
