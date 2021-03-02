package com.tencent.mm.ui;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.r;
import com.tencent.mm.g.a.aas;
import com.tencent.mm.g.a.abi;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.ipcall.model.f.i;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.aq;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ba;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.k.j;
import org.json.JSONObject;

public class FindMoreFriendsUI extends AbstractTabChildPreference implements bb, bc, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    r.a ACH = new r.a() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass13 */

        @Override // com.tencent.mm.av.r.a
        public final void a(final String str, final Bitmap bitmap, String str2) {
            AppMethodBeat.i(232487);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass13.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(232486);
                    Log.i("MicroMsg.FindMoreFriendsUI", "download url " + str + " , result " + (bitmap == null));
                    IconPreference iconPreference = (IconPreference) FindMoreFriendsUI.this.vOA.bmg("jd_market_entrance");
                    if (iconPreference != null) {
                        if (str.equals(FindMoreFriendsUI.this.OAH)) {
                            iconPreference.aL(bitmap);
                            FindMoreFriendsUI.this.OAH = null;
                        }
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.OAD)) {
                        ((IconPreference) FindMoreFriendsUI.this.vOA.bmg("find_friends_by_look")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), bitmap);
                        FindMoreFriendsUI.this.OAD = null;
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.OAE)) {
                        ((IconPreference) FindMoreFriendsUI.this.vOA.bmg("find_friends_by_search")).drawable = new BitmapDrawable(FindMoreFriendsUI.this.getContext().getResources(), bitmap);
                        FindMoreFriendsUI.this.OAE = null;
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.OAF)) {
                        ((IconPreference) FindMoreFriendsUI.this.vOA.bmg("find_friends_by_look")).aL(bitmap);
                        FindMoreFriendsUI.this.OAF = null;
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.OAG)) {
                        ((IconPreference) FindMoreFriendsUI.this.vOA.bmg("find_friends_by_search")).aL(bitmap);
                        FindMoreFriendsUI.this.OAG = null;
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                    }
                    if (str.equals(FindMoreFriendsUI.this.OAW)) {
                        ((IconPreference) FindMoreFriendsUI.this.vOA.bmg("my_life_around")).aL(BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) * 0.1f));
                        FindMoreFriendsUI.this.OAW = null;
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(232486);
                }
            });
            AppMethodBeat.o(232487);
        }
    };
    private CheckBox AzQ;
    private d AzS = null;
    IListener DLr = new IListener<wy>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass32 */

        {
            AppMethodBeat.i(161491);
            this.__eventId = wy.class.getName().hashCode();
            AppMethodBeat.o(161491);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wy wyVar) {
            AppMethodBeat.i(33069);
            wy wyVar2 = wyVar;
            Log.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", Integer.valueOf(wyVar2.edp.dJY));
            if (wyVar2.edp.dJY == 9) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass32.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(33068);
                        bg.aVF();
                        c.azQ().set(68377, "");
                        if (FindMoreFriendsUI.this.vOA != null) {
                            FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(33068);
                    }
                });
            }
            AppMethodBeat.o(33069);
            return true;
        }
    };
    private int Dcv;
    private View GEr;
    private com.tencent.mm.pluginsdk.c.a Kpg = new com.tencent.mm.pluginsdk.c.a() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass23 */

        @Override // com.tencent.mm.pluginsdk.c.a
        public final void g(IEvent iEvent) {
            AppMethodBeat.i(33062);
            Log.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", iEvent);
            if (iEvent instanceof lo) {
                FindMoreFriendsUI.e(FindMoreFriendsUI.this);
                if (FindMoreFriendsUI.this.vOA != null) {
                    FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(33062);
        }
    };
    private View OAA;
    private String OAB = "";
    private int OAC = 0;
    private String OAD = null;
    private String OAE = null;
    private String OAF = null;
    private String OAG = null;
    private String OAH = null;
    private boolean OAI = false;
    private boolean OAJ = false;
    private boolean OAK = true;
    private boolean OAL = false;
    private int OAM = 0;
    private long OAN = 0;
    private int OAO;
    private TextView OAP;
    private IListener<ts> OAQ = new IListener<ts>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass12 */

        {
            AppMethodBeat.i(161490);
            this.__eventId = ts.class.getName().hashCode();
            AppMethodBeat.o(161490);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ts tsVar) {
            AppMethodBeat.i(33045);
            FindMoreFriendsUI.c(FindMoreFriendsUI.this);
            FindMoreFriendsUI.d(FindMoreFriendsUI.this);
            AppMethodBeat.o(33045);
            return false;
        }
    };
    IListener OAR = new IListener<lb>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass35 */

        {
            AppMethodBeat.i(161492);
            this.__eventId = lb.class.getName().hashCode();
            AppMethodBeat.o(161492);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lb lbVar) {
            AppMethodBeat.i(33070);
            if (com.tencent.mm.pluginsdk.i.d.JYo != null) {
                String str = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().ftd().username;
                if (Util.isNullOrNil(str)) {
                    str = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().ftc();
                }
                h.INSTANCE.a(11178, str, com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV().FJm, Integer.valueOf(FindMoreFriendsUI.gHG()));
            }
            FindMoreFriendsUI.b(FindMoreFriendsUI.this);
            FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
            AppMethodBeat.o(33070);
            return true;
        }
    };
    IListener OAS = new IListener<df>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass36 */

        {
            AppMethodBeat.i(161493);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(161493);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(33071);
            Log.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
            FindMoreFriendsUI.this.mHandler.sendEmptyMessage(1);
            AppMethodBeat.o(33071);
            return true;
        }
    };
    private com.tencent.mm.pluginsdk.c.a OAT = new com.tencent.mm.pluginsdk.c.a() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass38 */

        @Override // com.tencent.mm.pluginsdk.c.a
        public final void g(IEvent iEvent) {
            AppMethodBeat.i(33073);
            if (iEvent instanceof ix) {
                FindMoreFriendsUI.a(FindMoreFriendsUI.this, true);
                FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
            }
            AppMethodBeat.o(33073);
        }
    };
    private com.tencent.mm.pluginsdk.c.a OAU = new com.tencent.mm.pluginsdk.c.a() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass39 */

        {
            AppMethodBeat.i(161494);
            AppMethodBeat.o(161494);
        }

        @Override // com.tencent.mm.pluginsdk.c.a
        public final void g(IEvent iEvent) {
            AppMethodBeat.i(232508);
            if (iEvent instanceof uo) {
                FindMoreFriendsUI.g(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
            }
            AppMethodBeat.o(232508);
        }
    };
    private IListener OAV = new IListener<un>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass2 */

        {
            AppMethodBeat.i(232476);
            this.__eventId = un.class.getName().hashCode();
            AppMethodBeat.o(232476);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(un unVar) {
            AppMethodBeat.i(232477);
            if (unVar instanceof un) {
                FindMoreFriendsUI.g(FindMoreFriendsUI.this);
                FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
            }
            AppMethodBeat.o(232477);
            return false;
        }
    };
    private String OAW;
    private a OAX = a.TYPE_NONE;
    private q OAY = new q() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(232479);
            if (Util.nullAsNil(str).equals("lifeappreddot") && map != null) {
                boolean equals = "1".equals(map.get(".sysmsg.lifeappreddot"));
                Log.i("MicroMsg.FindMoreFriendsUI", "life around xml msg content, showRedDot: %s.", Boolean.valueOf(equals));
                g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.valueOf(equals));
                if (equals) {
                    String str2 = map.get(".sysmsg.lifeappreddot.$type");
                    String str3 = map.get(".sysmsg.lifeappreddot.$text");
                    String str4 = map.get(".sysmsg.lifeappreddot.$imageurl");
                    Log.d("MicroMsg.FindMoreFriendsUI", "life around xml msg content, type: %s, text: %s, imgUrl: %s.", str2, str3, str4);
                    if (FindMoreFriendsUI.a(FindMoreFriendsUI.this, str3, str4)) {
                        g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, str2);
                        g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, str3);
                        g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, str4);
                    }
                    AppMethodBeat.o(232479);
                    return;
                }
                FindMoreFriendsUI.this.OAX = a.TYPE_NONE;
                g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, "");
                g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, "");
            }
            AppMethodBeat.o(232479);
        }
    };
    private IListener<jo> OAZ = new IListener<jo>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass10 */

        {
            AppMethodBeat.i(232483);
            this.__eventId = jo.class.getName().hashCode();
            AppMethodBeat.o(232483);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jo joVar) {
            AppMethodBeat.i(232484);
            joVar.dOr.dOs = FindMoreFriendsUI.this.dOs;
            AppMethodBeat.o(232484);
            return false;
        }
    };
    private long OAz;
    private Observer<h.a> OBa = null;
    private boolean OBb = false;
    private boolean OBc = false;
    private boolean dOs = false;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(33032);
            switch (message.what) {
                case 1:
                    if (FindMoreFriendsUI.this.vOA != null) {
                        FindMoreFriendsUI.b(FindMoreFriendsUI.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(33032);
        }
    };
    private long qAb;
    private int status;
    private Observer<h.a> tFo = null;
    private com.tencent.mm.ui.base.preference.h vOA;
    private com.tencent.mm.pluginsdk.c.a xWU = new com.tencent.mm.pluginsdk.c.a() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass37 */

        @Override // com.tencent.mm.pluginsdk.c.a
        public final void g(IEvent iEvent) {
            AppMethodBeat.i(33072);
            if (iEvent instanceof iy) {
                FindMoreFriendsUI.a(FindMoreFriendsUI.this, false);
                FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
            }
            AppMethodBeat.o(33072);
        }
    };
    private IListener<aas> xcg = new IListener<aas>() {
        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass9 */

        {
            AppMethodBeat.i(161489);
            this.__eventId = aas.class.getName().hashCode();
            AppMethodBeat.o(161489);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aas aas) {
            AppMethodBeat.i(33041);
            FindMoreFriendsUI.this.getContentView().post(new Runnable() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass9.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(232482);
                    if (FindMoreFriendsUI.this.isAdded()) {
                        FindMoreFriendsUI.d(FindMoreFriendsUI.this);
                    }
                    AppMethodBeat.o(232482);
                }
            });
            AppMethodBeat.o(33041);
            return false;
        }
    };

    public FindMoreFriendsUI() {
        AppMethodBeat.i(33078);
        AppMethodBeat.o(33078);
    }

    static /* synthetic */ boolean a(FindMoreFriendsUI findMoreFriendsUI, String str, String str2) {
        AppMethodBeat.i(33130);
        boolean nc = findMoreFriendsUI.nc(str, str2);
        AppMethodBeat.o(33130);
        return nc;
    }

    static /* synthetic */ void ao(long j2, int i2) {
        AppMethodBeat.i(258880);
        an(j2, i2);
        AppMethodBeat.o(258880);
    }

    static /* synthetic */ void b(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(33123);
        findMoreFriendsUI.AW(true);
        AppMethodBeat.o(33123);
    }

    static /* synthetic */ void b(IconPreference iconPreference, int i2, int i3, boolean z, int i4, int i5, int i6) {
        AppMethodBeat.i(258879);
        a(iconPreference, i2, 8, i3, z, i4, i5, i6);
        AppMethodBeat.o(258879);
    }

    static /* synthetic */ void c(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(33124);
        findMoreFriendsUI.gHB();
        AppMethodBeat.o(33124);
    }

    static /* synthetic */ void d(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(33125);
        findMoreFriendsUI.gHq();
        AppMethodBeat.o(33125);
    }

    static /* synthetic */ void dW(String str, boolean z) {
        AppMethodBeat.i(258872);
        bz(str, z);
        AppMethodBeat.o(258872);
    }

    static /* synthetic */ void e(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(33126);
        findMoreFriendsUI.gHC();
        AppMethodBeat.o(33126);
    }

    static /* synthetic */ void g(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(33129);
        findMoreFriendsUI.gHA();
        AppMethodBeat.o(33129);
    }

    static /* synthetic */ int gHG() {
        AppMethodBeat.i(33127);
        int gHt = gHt();
        AppMethodBeat.o(33127);
        return gHt;
    }

    static /* synthetic */ int h(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(258873);
        int topHeight = findMoreFriendsUI.getTopHeight();
        AppMethodBeat.o(258873);
        return topHeight;
    }

    static /* synthetic */ void v(FindMoreFriendsUI findMoreFriendsUI) {
        AppMethodBeat.i(258881);
        findMoreFriendsUI.updateStatus();
        AppMethodBeat.o(258881);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public final int getResourceId() {
        return R.xml.az;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean noActionBar() {
        return true;
    }

    private boolean gHp() {
        AppMethodBeat.i(33079);
        if (Util.isSameDay(g.aAh().azQ().a(ar.a.FIND_MORE_UI_ENTRY_LAST_REPORT_TIME_LONG_SYNC, 0), this.OAz)) {
            AppMethodBeat.o(33079);
            return true;
        }
        AppMethodBeat.o(33079);
        return false;
    }

    private void gHq() {
        boolean z;
        AppMethodBeat.i(33080);
        Log.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
        if (!this.OZh || !isAdded()) {
            Log.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
            AppMethodBeat.o(33080);
            return;
        }
        try {
            if (WeChatBrands.Business.Entries.DiscoveryChannels.banned()) {
                this.vOA.m39do("find_friends_by_finder", true);
            }
            JSONObject aXe = ak.aXe("discoverRecommendEntry");
            e redDotMgr = ((b) g.ah(b.class)).getRedDotMgr();
            if (redDotMgr != null) {
                z = redDotMgr.fxI();
            } else {
                z = true;
            }
            Log.i("MicroMsg.FindMoreFriendsUI", "showLookEntry %s", Boolean.valueOf(z));
            if (z) {
                String optString = aXe.optString("wording");
                final NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) this.vOA.bmg("find_friends_by_look");
                if (Util.isNullOrNil(optString)) {
                    normalIconNewTipPreference.setTitle(getString(R.string.cf5));
                } else {
                    normalIconNewTipPreference.setTitle(optString);
                }
                normalIconNewTipPreference.a(this.vOA);
                com.tencent.mm.plugin.newtips.a.exl().h(normalIconNewTipPreference);
                normalIconNewTipPreference.a(this.ACH, new NormalIconNewTipPreference.a() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.a
                    public final void aIA(String str) {
                        AppMethodBeat.i(232478);
                        FindMoreFriendsUI.this.OAF = str;
                        AppMethodBeat.o(232478);
                    }
                });
                com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
                this.OAO++;
                this.vOA.m39do("find_friends_by_look", false);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass6 */

                    public final void run() {
                        boolean z;
                        boolean z2;
                        eiq eiq;
                        boolean z3 = false;
                        AppMethodBeat.i(33037);
                        if (normalIconNewTipPreference == null) {
                            AppMethodBeat.o(33037);
                            return;
                        }
                        FindMoreFriendsUI.dW("find_friends_by_look", false);
                        boolean z4 = ((b) g.ah(b.class)).getRedDotMgr().fxl() && ((b) g.ah(b.class)).getRedDotMgr().fxK();
                        boolean fxL = ((b) g.ah(b.class)).getRedDotMgr().fxL();
                        if (!((b) g.ah(b.class)).getRedDotMgr().fxB() || !fxL) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int fxu = ((b) g.ah(b.class)).getRedDotMgr().fxu();
                        if (fxu <= 0 || !((b) g.ah(b.class)).getRedDotMgr().fxm()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2 || !z4) {
                            eiq = null;
                        } else {
                            if (LauncherUI.getCurrentTabIndex() == 2) {
                                ((b) g.ah(b.class)).getRedDotMgr().fxN();
                            }
                            eiq = ((b) g.ah(b.class)).getRedDotMgr().fxo();
                        }
                        com.tencent.mm.plugin.newtips.a.a aVar = (com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference;
                        if (aVar.qV(z2 || (z4 && (eiq == null || (eiq.type > 0 && eiq.type <= 4))) || z)) {
                            AppMethodBeat.o(33037);
                            return;
                        }
                        normalIconNewTipPreference.alF(8);
                        normalIconNewTipPreference.alE(8);
                        normalIconNewTipPreference.alI(8);
                        normalIconNewTipPreference.alD(8);
                        if (z2) {
                            normalIconNewTipPreference.alD(0);
                            String valueOf = String.valueOf(fxu);
                            if (fxu > 99) {
                                valueOf = "99+";
                            }
                            normalIconNewTipPreference.gY(valueOf, v.aQ(FindMoreFriendsUI.this.getContext(), fxu));
                            ((b) g.ah(b.class)).getRedDotMgr().fxN();
                            aVar.a(k.MMNEWTIPS_SHOWTYPE_COUNTER, true);
                        } else if (z4) {
                            switch (eiq.type) {
                                case 1:
                                    normalIconNewTipPreference.alF(0);
                                    aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
                                    break;
                                case 2:
                                    normalIconNewTipPreference.alF(8);
                                    normalIconNewTipPreference.alE(0);
                                    normalIconNewTipPreference.aS(eiq.text, -1, Color.parseColor("#8c8c8c"));
                                    normalIconNewTipPreference.BB(true);
                                    normalIconNewTipPreference.alI(8);
                                    aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                                    break;
                                case 3:
                                    normalIconNewTipPreference.alF(8);
                                    normalIconNewTipPreference.alI(0);
                                    normalIconNewTipPreference.alH(0);
                                    normalIconNewTipPreference.alJ(0);
                                    normalIconNewTipPreference.BB(false);
                                    com.tencent.mm.av.q.bcQ();
                                    Bitmap EP = com.tencent.mm.av.d.EP(eiq.icon);
                                    if (EP != null) {
                                        FindMoreFriendsUI.this.OAF = null;
                                        normalIconNewTipPreference.aL(EP);
                                    } else {
                                        com.tencent.mm.av.q.bcU().a(eiq.icon, FindMoreFriendsUI.this.ACH);
                                        FindMoreFriendsUI.this.OAF = eiq.icon;
                                    }
                                    aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON, true);
                                    break;
                                case 4:
                                    normalIconNewTipPreference.alF(8);
                                    normalIconNewTipPreference.alI(0);
                                    normalIconNewTipPreference.alH(0);
                                    normalIconNewTipPreference.alJ(0);
                                    normalIconNewTipPreference.alE(0);
                                    normalIconNewTipPreference.BB(false);
                                    normalIconNewTipPreference.aS(eiq.text, -1, Color.parseColor("#8c8c8c"));
                                    com.tencent.mm.av.q.bcQ();
                                    Bitmap EP2 = com.tencent.mm.av.d.EP(eiq.icon);
                                    if (EP2 != null) {
                                        FindMoreFriendsUI.this.OAF = null;
                                        normalIconNewTipPreference.aL(EP2);
                                    } else {
                                        com.tencent.mm.av.q.bcU().a(eiq.icon, FindMoreFriendsUI.this.ACH);
                                        FindMoreFriendsUI.this.OAF = eiq.icon;
                                    }
                                    aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON, true);
                                    break;
                                default:
                                    Log.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(eiq.type));
                                    break;
                            }
                        } else if (z) {
                            ((b) g.ah(b.class)).getRedDotMgr().fxN();
                            normalIconNewTipPreference.alF(0);
                            aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
                        }
                        if (z || z2 || z4) {
                            z3 = true;
                        }
                        FindMoreFriendsUI.dW("find_friends_by_look", z3);
                        FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                        AppMethodBeat.o(33037);
                    }
                });
                ((com.tencent.mm.plugin.topstory.ui.b) g.ah(com.tencent.mm.plugin.topstory.ui.b.class)).tryToCreateTopStoryWebView();
                AppMethodBeat.o(33080);
                return;
            }
            this.vOA.m39do("find_friends_by_look", true);
            if (!gHp()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(953, 3, 1);
            }
            AppMethodBeat.o(33080);
        } catch (Exception e2) {
            Log.e("MicroMsg.FindMoreFriendsUI", Util.stackTraceToString(e2));
            AppMethodBeat.o(33080);
        }
    }

    /* access modifiers changed from: package-private */
    public enum a {
        TYPE_NONE,
        TYPE_NORMAL,
        TYPE_TEXT,
        TYPE_IMG,
        TYPE_IMG_TEXT,
        TYPE_NEW_HINT;

        public static a valueOf(String str) {
            AppMethodBeat.i(33076);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(33076);
            return aVar;
        }

        static {
            AppMethodBeat.i(33077);
            AppMethodBeat.o(33077);
        }
    }

    private boolean nc(String str, String str2) {
        boolean z;
        a aVar;
        AppMethodBeat.i(33081);
        boolean z2 = !Util.isNullOrNil(str);
        if (!Util.isNullOrNil(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z2 && z) {
            aVar = a.TYPE_IMG_TEXT;
        } else if (z) {
            aVar = a.TYPE_IMG;
        } else if (z2) {
            aVar = a.TYPE_TEXT;
        } else {
            aVar = a.TYPE_NORMAL;
        }
        Log.i("MicroMsg.FindMoreFriendsUI", "new type: %s, now type: %s.", aVar, this.OAX);
        if (aVar.compareTo((Enum) this.OAX) >= 0) {
            this.OAX = aVar;
            AppMethodBeat.o(33081);
            return true;
        }
        AppMethodBeat.o(33081);
        return false;
    }

    private static void a(IconPreference iconPreference, int i2, int i3, boolean z, int i4, int i5, int i6) {
        AppMethodBeat.i(33082);
        iconPreference.alF(i2);
        iconPreference.alE(i3);
        iconPreference.BB(z);
        iconPreference.alI(i4);
        iconPreference.alH(i5);
        iconPreference.alJ(i6);
        AppMethodBeat.o(33082);
    }

    private void a(final aq.a aVar, final IconPreference iconPreference) {
        AppMethodBeat.i(33083);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass7 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(33038);
                if (iconPreference == null) {
                    AppMethodBeat.o(33038);
                    return;
                }
                FindMoreFriendsUI.dW("find_friends_by_search", false);
                com.tencent.mm.plugin.newtips.a.a aVar = (com.tencent.mm.plugin.newtips.a.a) iconPreference;
                if (aVar == null || !aVar.isValid() || aVar.type <= 0 || aVar.type > 4) {
                    z = false;
                } else {
                    z = true;
                }
                if (aVar.qV(z)) {
                    AppMethodBeat.o(33038);
                    return;
                }
                iconPreference.alD(8);
                if (aVar == null) {
                    iconPreference.alF(8);
                    AppMethodBeat.o(33038);
                    return;
                }
                if (aVar.isValid()) {
                    Log.i("MicroMsg.FindMoreFriendsUI", "show red %s", iconPreference.getTitle());
                    switch (aVar.type) {
                        case 1:
                            iconPreference.alF(0);
                            iconPreference.alE(8);
                            aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
                            break;
                        case 2:
                            iconPreference.alF(8);
                            iconPreference.alE(0);
                            iconPreference.aS(aVar.text, -1, Color.parseColor("#8c8c8c"));
                            iconPreference.BB(true);
                            iconPreference.alI(8);
                            aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                            break;
                        case 3:
                            iconPreference.alI(0);
                            iconPreference.alH(0);
                            iconPreference.alJ(0);
                            iconPreference.BB(false);
                            com.tencent.mm.av.q.bcQ();
                            Bitmap EP = com.tencent.mm.av.d.EP(aVar.icon);
                            if (EP != null) {
                                FindMoreFriendsUI.this.OAG = null;
                                iconPreference.aL(EP);
                            } else {
                                com.tencent.mm.av.q.bcU().a(aVar.icon, FindMoreFriendsUI.this.ACH);
                                FindMoreFriendsUI.this.OAG = aVar.icon;
                            }
                            aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON, true);
                            break;
                        case 4:
                            iconPreference.alI(0);
                            iconPreference.alH(0);
                            iconPreference.alJ(0);
                            iconPreference.alE(0);
                            iconPreference.BB(false);
                            iconPreference.aS(aVar.text, -1, Color.parseColor("#8c8c8c"));
                            com.tencent.mm.av.q.bcQ();
                            Bitmap EP2 = com.tencent.mm.av.d.EP(aVar.icon);
                            if (EP2 != null) {
                                FindMoreFriendsUI.this.OAG = null;
                                iconPreference.aL(EP2);
                            } else {
                                com.tencent.mm.av.q.bcU().a(aVar.icon, FindMoreFriendsUI.this.ACH);
                                FindMoreFriendsUI.this.OAG = aVar.icon;
                            }
                            aVar.a(k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON, true);
                            break;
                        default:
                            Log.e("MicroMsg.FindMoreFriendsUI", "search unknown red type %d", Integer.valueOf(aVar.type));
                            break;
                    }
                } else {
                    Log.i("MicroMsg.FindMoreFriendsUI", "hide red %s", iconPreference.getTitle());
                    iconPreference.alF(8);
                    iconPreference.alE(8);
                    iconPreference.alI(8);
                    iconPreference.alO(0);
                    if (iconPreference instanceof NormalIconNewTipPreference) {
                        com.tencent.mm.plugin.newtips.a.g.a((NormalIconNewTipPreference) iconPreference);
                    }
                }
                FindMoreFriendsUI.dW("find_friends_by_search", aVar.isValid());
                FindMoreFriendsUI.this.vOA.notifyDataSetChanged();
                AppMethodBeat.o(33038);
            }
        });
        AppMethodBeat.o(33083);
    }

    private boolean gHr() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(232509);
        boolean showFinderEntry = ((aj) g.ah(aj.class)).showFinderEntry();
        if (!IK(34359738368L)) {
            z = true;
        } else {
            z = false;
        }
        if (!((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() || ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW() != 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.i("MicroMsg.FindMoreFriendsUI", "[isShowFinderEntrance] show:%s open:%s, isTeenModeAndNothing:%s", Boolean.valueOf(showFinderEntry), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (!showFinderEntry || !z || z2) {
            AppMethodBeat.o(232509);
            return false;
        }
        AppMethodBeat.o(232509);
        return true;
    }

    private void gHs() {
        AppMethodBeat.i(232510);
        final View findViewById = getView().getRootView().findViewById(R.id.e8y);
        int eu = au.eu(getContext());
        int D = au.D(getContext(), -1);
        AnonymousClass8 r3 = new Runnable() {
            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass8 */
            int ibG = 0;

            public final void run() {
                AppMethodBeat.i(232481);
                if (FindMoreFriendsUI.this.getView() == null) {
                    AppMethodBeat.o(232481);
                    return;
                }
                int eu = au.eu(FindMoreFriendsUI.this.getContext());
                int D = au.D(FindMoreFriendsUI.this.getContext(), -1);
                if (D <= 0) {
                    if (this.ibG < 2) {
                        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight again!");
                        FindMoreFriendsUI.this.getView().post(this);
                    } else {
                        Log.e("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] try getStatusHeight finally!");
                    }
                    this.ibG++;
                } else {
                    int h2 = FindMoreFriendsUI.h(FindMoreFriendsUI.this);
                    if (h2 != FindMoreFriendsUI.this.getView().getPaddingTop()) {
                        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] now:%s old:%s", Integer.valueOf(h2), Integer.valueOf(FindMoreFriendsUI.this.getView().getPaddingTop()));
                        FindMoreFriendsUI.this.getView().setPadding(0, h2, 0, findViewById.getHeight());
                    } else {
                        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(D), Integer.valueOf(eu));
                    }
                }
                Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(this.ibG), Integer.valueOf(D), Integer.valueOf(eu));
                AppMethodBeat.o(232481);
            }
        };
        if (D <= 0) {
            getView().post(r3);
            AppMethodBeat.o(232510);
            return;
        }
        getView().setPadding(0, getTopHeight(), 0, findViewById.getHeight());
        Log.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", Integer.valueOf(D), Integer.valueOf(eu));
        getView().postDelayed(r3, 100);
        AppMethodBeat.o(232510);
    }

    private int getTopHeight() {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(33084);
        int eu = au.eu(getContext());
        int D = au.D(getContext(), -1);
        View findViewById = getView().getRootView().findViewById(R.id.c_);
        if (Build.VERSION.SDK_INT < 24 || LauncherUI.getInstance() == null) {
            z = false;
        } else {
            z = LauncherUI.getInstance().isInMultiWindowMode();
        }
        if (!z) {
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            if (defaultPreference != null) {
                z2 = defaultPreference.getBoolean("Main_need_read_top_margin", false);
            } else {
                z2 = false;
            }
            if (z2 && (i2 = defaultPreference.getInt("Main_top_marign", -1)) >= 0) {
                int i3 = eu + i2;
                AppMethodBeat.o(33084);
                return i3;
            }
        }
        if (z) {
            if (findViewById != null) {
                D = findViewById.getTop();
            } else {
                D = 0;
            }
        }
        Log.i("MicroMsg.FindMoreFriendsUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", Integer.valueOf(D), Boolean.valueOf(z));
        int i4 = D + eu;
        AppMethodBeat.o(33084);
        return i4;
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(33085);
        super.onActivityCreated(bundle);
        Log.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
        AppMethodBeat.o(33085);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0567  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0769  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x078a  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x07d9  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0347  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateStatus() {
        /*
        // Method dump skipped, instructions count: 2060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.FindMoreFriendsUI.updateStatus():void");
    }

    private static int gHt() {
        AppMethodBeat.i(33088);
        int i2 = 1;
        if (com.tencent.mm.pluginsdk.i.d.JYo != null) {
            com.tencent.mm.plugin.subapp.jdbiz.c fsV = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV();
            com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
            if (com.tencent.mm.plugin.subapp.jdbiz.d.fsR() && fsV.isStart() && !fsV.dMp()) {
                if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(fsV.FJl) && !Util.isNullOrNil(fsV.jumpUrl)) {
                    i2 = 6;
                } else if (!Util.isNullOrNil(fsV.FJp)) {
                    i2 = 3;
                } else if (fsV.FJo) {
                    i2 = 2;
                }
            }
        }
        AppMethodBeat.o(33088);
        return i2;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public final boolean onPreferenceTreeLongClick(f fVar, Preference preference, View view) {
        AppMethodBeat.i(33089);
        if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) && "app_brand_entrance".equals(preference.mKey)) {
            boolean dG = ((t) g.af(t.class)).dG(getContext());
            AppMethodBeat.o(33089);
            return dG;
        } else if ((WeChatEnvironment.isCoolassistEnv() || BuildInfo.IS_FLAVOR_RED) && !com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime() && "my_life_around".equals(preference.mKey)) {
            final MultiProcessMMKV multiDefault = MultiProcessMMKV.getMultiDefault();
            int i2 = multiDefault.getInt("life_mode", 1);
            new AlertDialog.Builder(getContext()).setTitle("选择附近的餐厅的渲染模式").setSingleChoiceItems(new String[]{"webview", "flutter"}, i2, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(232489);
                    multiDefault.putInt("life_mode", i2);
                    multiDefault.commit();
                    AppMethodBeat.o(232489);
                }
            }).create().show();
            AppMethodBeat.o(33089);
            return true;
        } else {
            boolean onPreferenceTreeLongClick = super.onPreferenceTreeLongClick(fVar, preference, view);
            AppMethodBeat.o(33089);
            return onPreferenceTreeLongClick;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        long j2;
        long j3;
        boolean z;
        Boolean bool;
        IconPreference iconPreference;
        AppMethodBeat.i(33090);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(fVar);
        bVar.bm(preference);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, bVar.axR());
        if ("album_dyna_photo_ui_title".equals(preference.mKey)) {
            com.tencent.mm.plugin.report.service.g.Wl(10);
            bg.aVF();
            this.OAB = (String) c.azQ().get(68377, (Object) null);
            Intent intent = new Intent();
            com.tencent.mm.modelsns.k kVar = new com.tencent.mm.modelsns.k(701, 1);
            kVar.fL(!Util.isNullOrNil(this.OAB));
            kVar.PH(new StringBuilder().append(this.OAC).toString());
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.putExtra("is_from_find_more", true);
            intent.putExtra("enter_by_red", !Util.isNullOrNil(this.OAB) || this.OAC > 0);
            bg.aVF();
            intent.putExtra("is_sns_notify_open", Util.nullAs((Boolean) c.azQ().get(68384, (Object) null), true));
            intent.putExtra("sns_unread_count", o.DCO.ctM());
            if (!Util.isNullOrNil(this.OAB)) {
                bg.aVF();
                intent.putExtra("new_feed_id", Util.nullAs((String) c.azQ().get(68418, (Object) null), ""));
                bg.aVF();
                com.tencent.mm.plugin.sns.k.f.s(3, (String) c.azQ().get(68418, ""), this.OAC);
            }
            kVar.b(intent, "enter_log");
            kd kdVar = new kd();
            EventCenter.instance.publish(kdVar);
            boolean z2 = true;
            if (!kdVar.dPd.isResume) {
                if (!Util.isNullOrNil(this.OAB)) {
                    z2 = false;
                }
                if (o.DCO != null) {
                    this.OAC = o.DCO.ctM();
                    if (this.OAC > 0) {
                        z2 = false;
                    }
                }
                bg.aVF();
                c.azQ().set(68377, "");
            }
            bg.aVF();
            c.azQ().set(589825, Boolean.FALSE);
            intent.putExtra("sns_resume_state", z2);
            com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsTimeLineUI", intent);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "1");
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass16 */

                public final void run() {
                    AppMethodBeat.i(33049);
                    com.tencent.mm.cr.d.hiy();
                    AppMethodBeat.o(33049);
                }
            }, 500);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_near".equals(preference.mKey) || "find_live_friends_by_near".equals(preference.mKey)) {
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEA = 1001;
            if (com.tencent.mm.bp.a.glB()) {
                com.tencent.mm.ui.report.a.gXa();
            } else if (!WeChatBrands.Business.Entries.DiscoveryNearby.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            if (!com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(thisActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 66, (String) null, (String) null);
                Log.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                    AppMethodBeat.o(33090);
                    return true;
                }
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(thisActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
                if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                    com.tencent.mm.plugin.account.a.b.a.b(thisActivity(), getString(R.string.el_, LocaleUtil.getApplicationLanguage()), 30764, true);
                } else {
                    com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_FINE_LOCATION", 66);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            gHw();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_shake".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.DiscoveryShake.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            if (!this.OAI && z.aUQ().booleanValue() && (iconPreference = (IconPreference) fVar.bmg("find_friends_by_shake")) != null) {
                iconPreference.alF(8);
                bg.aVF();
                c.azQ().set(340231, Boolean.TRUE);
                bg.aVF();
                c.azQ().gBI();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(232, 4, 1, false);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            bg.aVF();
            String nullAs = Util.nullAs((String) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) null), "");
            bg.aVF();
            if (!Util.nullAs((Boolean) c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, (Object) null), false) || nullAs == null || nullAs.equals("")) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            if (bool.booleanValue()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12653, 2, 2);
            }
            EventCenter.instance.publish(new rv());
            com.tencent.mm.br.c.V(getContext(), "shake", ".ui.ShakeReportUI");
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.GlobalScan.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            com.tencent.mm.y.c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SCAN_ENTRY_RED_DOT_STRING_SYNC);
            if (!com.tencent.mm.q.a.o(getContext(), true)) {
                getContext();
                if (!com.tencent.mm.bh.e.bgF() && !com.tencent.mm.q.a.r(getContext(), true)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "2");
                    Intent intent2 = new Intent();
                    intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                    intent2.putExtra("key_scan_entry_scene", 2);
                    intent2.putExtra("key_config_black_interval", true);
                    intent2.putExtra("key_enable_multi_code", true);
                    intent2.putExtra("key_scan_goods_enable_dynamic_wording", true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11265, 2);
                    com.tencent.mm.br.c.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                    AppMethodBeat.o(33090);
                    return true;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if (preference.mKey.equals("more_tab_game_recommend")) {
            if (!WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            com.tencent.mm.plugin.newtips.a.exl().TC(12);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "6");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(848, 2, 1, false);
            bg.aVF();
            if (!c.isSDCardAvailable()) {
                u.g(getContext(), null);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            Intent intent3 = new Intent();
            intent3.putExtra("from_find_more_friend", this.OAK);
            intent3.putExtra("game_report_from_scene", 901);
            if (this.OAK) {
                qf qfVar = new qf();
                EventCenter.instance.publish(qfVar);
                IconPreference iconPreference2 = (IconPreference) fVar.bmg("more_tab_game_recommend");
                if (!(qfVar.dWy.icon == null || iconPreference2 == null)) {
                    com.tencent.mm.av.q.bcV().a(qfVar.dWy.icon, iconPreference2.gLG());
                }
            }
            ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pkF);
            Log.i("MicroMsg.FindMoreFriendsUI", "start game center index, time : " + System.currentTimeMillis());
            intent3.putExtra("start_time", System.currentTimeMillis());
            try {
                intent3.putExtra("from_source_activity", getContext().getComponentName().getClassName());
            } catch (Exception e2) {
            }
            intent3.putExtra("has_game_life_chat_msg", this.OAL);
            intent3.putExtra("game_life_msg_count", this.OAM);
            com.tencent.mm.br.c.b(getContext(), "game", ".ui.GameCenterUI", intent3);
            if (((com.tencent.mm.plugin.lite.a.a) g.af(com.tencent.mm.plugin.lite.a.a.class)).ecx()) {
                sendBroadcast(new Intent(getContext(), LiteAppTaskPreloadReceiver.class));
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.mKey)) {
            com.tencent.mm.br.c.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_mobile".equals(preference.mKey)) {
            if (l.bnZ() != l.a.SUCC) {
                Intent intent4 = new Intent(getContext(), BindMContactIntroUI.class);
                intent4.putExtra("key_upload_scene", 6);
                MMWizardActivity.ay(getContext(), intent4);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(getContext(), MobileFriendUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_facebook".equals(preference.mKey)) {
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(getContext(), FacebookFriendUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/FindMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("settings_mm_card_package".equals(preference.mKey)) {
            Log.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
            kl klVar = new kl();
            klVar.dPA.context = getContext();
            EventCenter.instance.publish(klVar);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if (preference.mKey.equals("jd_market_entrance")) {
            if (!WeChatBrands.Business.Entries.DiscoveryShop.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            com.tencent.mm.plugin.newtips.a.exl().TC(11);
            com.tencent.mm.pluginsdk.wallet.h.setPayChannel(9);
            if (com.tencent.mm.pluginsdk.i.d.JYo != null) {
                String ftc = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().ftc();
                final com.tencent.mm.plugin.subapp.jdbiz.b ftd = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().ftd();
                Log.i("MicroMsg.FindMoreFriendsUI", "jumpUrl %s, jumpWeapp %s", ftc, ftd);
                int gHt = gHt();
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                com.tencent.mm.plugin.subapp.jdbiz.d.fsU();
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                com.tencent.mm.plugin.subapp.jdbiz.d.fsT();
                ((IconPreference) preference).gY("", -1);
                if (ftd.isValid()) {
                    Log.i("MicroMsg.FindMoreFriendsUI", "jump to jd weapp %s", ftd.username);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11179, ftd.username, com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV().FJm, Integer.valueOf(gHt));
                    if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_dialog_optimize_switch, 1) == 1) {
                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                        gVar.username = ftd.username;
                        gVar.version = ftd.version;
                        gVar.kHw = ftd.path;
                        gVar.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
                        if (gHu()) {
                            WeAppOpenDeclarePromptBundle weAppOpenDeclarePromptBundle = new WeAppOpenDeclarePromptBundle((byte) 0);
                            weAppOpenDeclarePromptBundle.fuQ = 1;
                            weAppOpenDeclarePromptBundle.kHS = getString(R.string.bn4);
                            weAppOpenDeclarePromptBundle.kHT = getString(R.string.e9x);
                            weAppOpenDeclarePromptBundle.kHU = getString(R.string.w0);
                            weAppOpenDeclarePromptBundle.ox = false;
                            gVar.kHJ = weAppOpenDeclarePromptBundle;
                        }
                        ((com.tencent.mm.plugin.appbrand.service.r) g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(getContext(), gVar);
                    } else {
                        Log.i("MicroMsg.FindMoreFriendsUI", "onClickOfJDEntrance clicfg_appbrand_dialog_optimize_switch close");
                        final AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
                        if (gHu()) {
                            com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.e9x), getString(R.string.bn4), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass17 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(232490);
                                    ((com.tencent.mm.plugin.appbrand.service.r) g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(FindMoreFriendsUI.this.getContext(), ftd.username, "", 0, ftd.version, ftd.path, appBrandStatObject);
                                    g.aAh().azQ().set(ar.a.USERINFO_JD_ENTRANCE_DECLARE_CLICK_BOOLEAN_SYNC, Boolean.TRUE);
                                    AppMethodBeat.o(232490);
                                }
                            });
                        } else {
                            ((com.tencent.mm.plugin.appbrand.service.r) g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(getContext(), ftd.username, "", 0, ftd.version, ftd.path, appBrandStatObject);
                        }
                    }
                    z = true;
                    com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                    AppMethodBeat.o(33090);
                    return z;
                } else if (!Util.isNullOrNil(ftc)) {
                    Log.i("MicroMsg.FindMoreFriendsUI", "jump to jd webview %s", ftc);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11179, ftc, com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV().FJm, Integer.valueOf(gHt));
                    final Intent intent5 = new Intent();
                    intent5.putExtra("rawUrl", ftc);
                    intent5.putExtra("useJs", true);
                    intent5.putExtra("vertical_scroll", true);
                    intent5.putExtra("minimize_secene", 1);
                    intent5.putExtra("KPublisherId", "jd_store");
                    final AnonymousClass18 r0 = new Runnable() {
                        /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass18 */

                        public final void run() {
                            AppMethodBeat.i(232491);
                            com.tencent.mm.br.c.b(FindMoreFriendsUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent5);
                            AppMethodBeat.o(232491);
                        }
                    };
                    if (gHu()) {
                        com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.e9x), getString(R.string.bn4), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass19 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(33052);
                                r0.run();
                                g.aAh().azQ().set(ar.a.USERINFO_JD_ENTRANCE_DECLARE_CLICK_BOOLEAN_SYNC, Boolean.TRUE);
                                AppMethodBeat.o(33052);
                            }
                        });
                    } else {
                        r0.run();
                    }
                }
            }
            z = true;
            com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return z;
        } else if ("ip_call_entrance".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.DiscoveryWeChatOut.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            IconPreference iconPreference3 = (IconPreference) fVar.bmg("ip_call_entrance");
            iconPreference3.alF(8);
            iconPreference3.alE(8);
            iconPreference3.BB(false);
            iconPreference3.alI(8);
            boolean z3 = false;
            bg.aVF();
            String str = (String) c.azQ().get(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, "");
            bg.aVF();
            if (((Boolean) c.azQ().get(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                i.am(1, -1, -1);
                bg.aVF();
                c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.FALSE);
                z3 = true;
            }
            bg.aVF();
            if (((Integer) c.azQ().get(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, (Object) 0)).intValue() < com.tencent.mm.n.h.aqJ().getInt("WCOEntranceRedDot", 0)) {
                z3 = true;
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13254, 0, 0, 1, -1, -1, -1);
                bg.aVF();
                c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.n.h.aqJ().getInt("WCOEntranceRedDot", 0)));
            }
            if (!Util.isNullOrNil(str)) {
                bg.aVF();
                c.azQ().set(ar.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, "");
            }
            if (z3) {
                EventCenter.instance.publish(new yi());
            }
            if (com.tencent.mm.q.a.att() || com.tencent.mm.q.a.atw()) {
                com.tencent.mm.ui.base.h.a(getContext(), (int) R.string.f67, 0, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12061, 1, 0, 0, 0, 0, 0);
                com.tencent.mm.br.c.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("app_brand_entrance".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.DiscoveryAppbrand.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            ((t) g.af(t.class)).K(getContext(), 1);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_search".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.DiscoverySearch.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            if (!ai.afs(0)) {
                Log.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            } else {
                String optString = ak.aXe("discoverSearchEntry").optString("wording");
                if (Util.isNullOrNil(optString)) {
                    Log.e("MicroMsg.FindMoreFriendsUI", "empty title");
                } else {
                    aq.fYk().afy(2);
                    aq fYk = aq.fYk();
                    fYk.IFk = new aq.a();
                    fYk.save();
                    ((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
                    com.tencent.mm.plugin.websearch.api.ar.q("", 0, 0, 20);
                    String afq = ai.afq(20);
                    String gaw = com.tencent.mm.plugin.webview.modeltools.g.gds().gaw();
                    HashMap hashMap = new HashMap();
                    hashMap.put("sessionId", afq);
                    hashMap.put("inputMarginTop", "32");
                    hashMap.put("inputMarginLeftRight", "24");
                    hashMap.put("inputHeight", "48");
                    if (gaw != null && !gaw.isEmpty()) {
                        hashMap.put("educationTab", Uri.encode(gaw));
                    }
                    hashMap.put("clickType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).b(getContext(), 20, "", afq, true, hashMap, optString);
                    ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).CN(com.tencent.mm.plugin.boots.a.b.pku);
                }
            }
            com.tencent.mm.plugin.newtips.a.exl().TC(9);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("find_friends_by_look".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.DiscoveryLooks.checkAvailable(getContext())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
            if (!ai.afs(1)) {
                Log.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            } else {
                String optString2 = ak.aXe("discoverRecommendEntry").optString("wording");
                if (Util.isNullOrNil(optString2)) {
                    Log.e("MicroMsg.FindMoreFriendsUI", "empty query");
                } else {
                    Log.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                    com.tencent.mm.plugin.topstory.ui.c.as(getContext(), 21);
                    ((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
                    om omVar = new om();
                    omVar.dUz.scene = 0;
                    EventCenter.instance.publish(omVar);
                    com.tencent.mm.plugin.websearch.api.ar.cO(21, optString2);
                    com.tencent.mm.plugin.websearch.api.ar.kb(21, 0);
                    if (ai.aft(1) > ai.fXU()) {
                        com.tencent.mm.plugin.websearch.api.ar.kb(21, 15);
                    } else {
                        com.tencent.mm.plugin.websearch.api.ar.kb(21, 14);
                    }
                    ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxM();
                }
            }
            com.tencent.mm.plugin.newtips.a.exl().TC(6);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if ("my_life_around".equals(preference.mKey)) {
            if (WeChatEnvironment.isCoolassistEnv() || (BuildInfo.IS_FLAVOR_RED && !com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime())) {
                MultiProcessMMKV.getSingleDefault().getInt("life_mode", 1);
            }
            gHv();
            com.tencent.mm.plugin.newtips.a.exl().TC(10);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else if (!"find_friends_by_finder".equals(preference.mKey) || g.ah(aj.class) == null) {
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return false;
        } else if (!WeChatBrands.Business.Entries.DiscoveryChannels.checkAvailable(getContext())) {
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33090);
            return true;
        } else {
            g.aAh().azQ().set(ar.a.USERINFO_FINDER_FIND_MORE_UI_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("entrance")) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            } else if (!((aj) g.ah(aj.class)).showFinderEntry()) {
                Log.i("MicroMsg.FindMoreFriendsUI", "second check finderEntry");
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            } else {
                int timelineCommentScene = ((aj) g.ah(aj.class)).getTimelineCommentScene();
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 0, 1, false);
                Intent intent6 = new Intent();
                String fillContextIdToIntent = ((aj) g.ah(aj.class)).fillContextIdToIntent(1, 1, timelineCommentScene, intent6);
                i.a aVar2 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                String dw = i.a.dw(fillContextIdToIntent, 0);
                intent6.putExtra("key_red_dot_id", dw);
                ((aj) g.ah(aj.class)).enterFinderTimelineUI(getContext(), intent6, Boolean.TRUE);
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.gS(fillContextIdToIntent, "Enter");
                com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                p.h(fillContextIdToIntent, "contextId");
                com.tencent.mm.g.b.a.aj ajVar = new com.tencent.mm.g.b.a.aj();
                ajVar.eoz = ajVar.x("ContextId", fillContextIdToIntent, true);
                String cMD = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
                if (cMD == null) {
                    cMD = "";
                }
                ajVar.eiB = ajVar.x("SessionId", cMD, true);
                com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
                p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
                FinderHomeTabStateVM finderHomeTabStateVM = (FinderHomeTabStateVM) viewModel;
                ajVar.eox = (long) finderHomeTabStateVM.dHR();
                com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                ViewModel viewModel2 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
                p.g(viewModel2, "UICProvider.of(PluginFin…alLocationVM::class.java)");
                FinderGlobalLocationVM finderGlobalLocationVM = (FinderGlobalLocationVM) viewModel2;
                if (FinderGlobalLocationVM.dHO()) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                ajVar.eos = j2;
                if (finderGlobalLocationVM.wtO != null) {
                    ajVar.eor = 1;
                } else {
                    ajVar.eor = 0;
                }
                if (dw != null) {
                    ajVar.eoq = 1;
                    ajVar.ip(dw);
                    ajVar.eow = 0;
                    ajVar.eov = 0;
                    ajVar.eot = 0;
                    ajVar.eou = 0;
                    ajVar.eoA = 1;
                } else {
                    ajVar.eoq = 0;
                    ajVar.ip("");
                    if (finderHomeTabStateVM.JN(finderHomeTabStateVM.dHR())) {
                        j3 = 2;
                    } else {
                        j3 = 1;
                    }
                    ajVar.eoA = j3;
                    ajVar.eot = j.aM((long) finderHomeTabStateVM.Mq(3).wuf, 0);
                    ajVar.eov = j.aM((long) finderHomeTabStateVM.Mq(2).wuf, 0);
                    ajVar.eou = j.aM((long) finderHomeTabStateVM.Mq(1).wuf, 0);
                    ajVar.eow = j.aM((long) finderHomeTabStateVM.Mq(4).wuf, 0);
                }
                ajVar.bfK();
                com.tencent.mm.plugin.finder.report.k.a(ajVar);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/FindMoreFriendsUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33090);
                return true;
            }
        }
    }

    private static boolean gHu() {
        AppMethodBeat.i(232511);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jd_entrance_declare, 0);
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_JD_ENTRANCE_DECLARE_CLICK_BOOLEAN_SYNC, false);
        Log.i("MicroMsg.FindMoreFriendsUI", "show declare needShow %d, hasShow %s", Integer.valueOf(a2), Boolean.valueOf(z));
        if (a2 == 0 || z) {
            AppMethodBeat.o(232511);
            return false;
        }
        AppMethodBeat.o(232511);
        return true;
    }

    private void gHv() {
        String str;
        AppMethodBeat.i(232512);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17065, 1, Long.valueOf(Util.nowSecond()), Integer.valueOf(this.OAX.ordinal()), g.aAh().azQ().get(ar.a.MY_LIFE_AROUND_APP_RED_DOT_IMG_URL_STRING, ""), g.aAh().azQ().get(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TEXT_STRING, ""), g.aAh().azQ().get(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TYPE_STRING, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        if (this.OAX.equals(a.TYPE_NEW_HINT)) {
            g.aAh().azQ().set(ar.a.MY_LIFE_AROUND_APP_NEW_RED_DOT_TAG_BOOLEAN, Boolean.FALSE);
            this.OAX = a.TYPE_NONE;
            IconPreference iconPreference = (IconPreference) this.vOA.bmg("my_life_around");
            iconPreference.alD(8);
            iconPreference.gY("", -1);
        }
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.MY_LIFE_AROUND_APP_RED_DOT_TAG_BOOLEAN, Boolean.FALSE)).booleanValue();
        ((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_nearbylife");
        String bbF = ((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).bbF("labs_nearbylife");
        int bbG = ((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).bbG("labs_nearbylife");
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
        int i2 = com.tencent.mm.n.h.aqJ().getInt("LifeAppEntranceBringRedDot", 0);
        Log.d("MicroMsg.FindMoreFriendsUI", "withRedTag: %d.", Integer.valueOf(i2));
        if (i2 == 0 || !booleanValue) {
            str = null;
        } else {
            str = "?hasRedDot=true";
        }
        ((com.tencent.mm.plugin.appbrand.service.r) g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(getContext(), bbF, (String) null, bbG, 0, str, appBrandStatObject);
        AppMethodBeat.o(232512);
    }

    public final void gHw() {
        AppMethodBeat.i(33093);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "4");
        bz aWk = bz.aWk();
        if (aWk == null) {
            com.tencent.mm.br.c.V(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
            AppMethodBeat.o(33093);
            return;
        }
        String nullAsNil = Util.nullAsNil(aWk.getProvince());
        int nullAs = Util.nullAs(Integer.valueOf(aWk.fuA), 0);
        if (Util.isNullOrNil(nullAsNil) || nullAs == 0) {
            com.tencent.mm.br.c.V(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
            AppMethodBeat.o(33093);
            return;
        }
        bg.aVF();
        Boolean bool = (Boolean) c.azQ().get(4104, (Object) null);
        if (bool == null || !bool.booleanValue()) {
            LauncherUI launcherUI = (LauncherUI) getContext();
            if (launcherUI != null) {
                launcherUI.ODR.getMainTabUI().blU("tab_find_friend");
            }
            Intent intent = new Intent();
            String fillContextIdToIntent = ((aj) g.ah(aj.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.acj(), intent);
            i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            i.a.atk(fillContextIdToIntent);
            com.tencent.mm.bp.a.au(getContext(), intent);
            AppMethodBeat.o(33093);
            return;
        }
        gHx();
        AppMethodBeat.o(33093);
    }

    private void gHx() {
        AppMethodBeat.i(33094);
        if (this.OAA == null) {
            this.OAA = View.inflate(getContext(), R.layout.azk, null);
            this.AzQ = (CheckBox) this.OAA.findViewById(R.id.e_r);
            this.AzQ.setChecked(false);
        }
        if (this.AzS == null) {
            this.AzS = com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.zb), this.OAA, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass20 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(232492);
                    if (FindMoreFriendsUI.this.AzQ != null) {
                        bg.aVF();
                        c.azQ().set(4104, Boolean.valueOf(!FindMoreFriendsUI.this.AzQ.isChecked()));
                    }
                    LauncherUI launcherUI = (LauncherUI) FindMoreFriendsUI.this.getContext();
                    if (launcherUI != null) {
                        launcherUI.ODR.getMainTabUI().blU("tab_find_friend");
                    }
                    Intent intent = new Intent();
                    ((aj) g.ah(aj.class)).fillContextIdToIntent(com.tencent.mm.ui.report.a.acj(), intent);
                    com.tencent.mm.bp.a.au(FindMoreFriendsUI.this.getContext(), intent);
                    AppMethodBeat.o(232492);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(33094);
            return;
        }
        this.AzS.show();
        AppMethodBeat.o(33094);
    }

    private void gHy() {
        AppMethodBeat.i(33095);
        NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) this.vOA.bmg("more_tab_game_recommend");
        if (normalIconNewTipPreference == null) {
            AppMethodBeat.o(33095);
            return;
        }
        normalIconNewTipPreference.a(this.vOA);
        com.tencent.mm.plugin.newtips.a.exl().h(normalIconNewTipPreference);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass21 */

            public final void run() {
                AppMethodBeat.i(232493);
                FindMoreFriendsUI.hYA();
                qf qfVar = new qf();
                EventCenter.instance.publish(qfVar);
                if (!qfVar.dWy.dWA) {
                    qe qeVar = new qe();
                    EventCenter.instance.publish(qeVar);
                    if (qeVar.dWv.dEF) {
                        FindMoreFriendsUI.a(FindMoreFriendsUI.this, qeVar);
                        AppMethodBeat.o(232493);
                        return;
                    }
                }
                FindMoreFriendsUI.a(FindMoreFriendsUI.this, qfVar);
                AppMethodBeat.o(232493);
            }
        }, "updateGame");
        AppMethodBeat.o(33095);
    }

    private synchronized void a(qf qfVar, final IconPreference iconPreference, qf qfVar2, final String str) {
        AppMethodBeat.i(33096);
        String str2 = qfVar.dWy.icon;
        int i2 = qfVar.dWy.iconWidth;
        int i3 = qfVar.dWy.iconHeight;
        final boolean z = qfVar.dWy.dWz;
        if (Util.isNullOrNil(str2) || iconPreference == null || iconPreference.gLG() == null) {
            AppMethodBeat.o(33096);
        } else {
            Log.i("MicroMsg.FindMoreFriendsUI", "download entrance image : %s, width: %d, height: %d", str2, Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 > 0 && i3 > 0) {
                iconPreference.lb(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), i2), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), i2));
            }
            final long j2 = qfVar2.dWy.msgId;
            final int i4 = qfVar2.dWy.dDG;
            final iz izVar = new iz();
            izVar.dND.EX = 1;
            izVar.dND.url = str2;
            EventCenter.instance.publish(izVar);
            if (izVar.dNE.dNG) {
                c.a aVar = new c.a();
                aVar.jbf = true;
                aVar.fullPath = izVar.dNE.dNF + com.tencent.mm.b.g.getMessageDigest(str2.getBytes());
                com.tencent.mm.av.q.bcV().a(str2, null, aVar.bdv(), new com.tencent.mm.av.a.c.k() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass25 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(232495);
                        izVar.dND.EX = 2;
                        izVar.dND.url = str;
                        EventCenter.instance.publish(izVar);
                        AppMethodBeat.o(232495);
                    }
                }, new com.tencent.mm.av.a.c.h() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass26 */

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view) {
                        AppMethodBeat.i(232499);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass26.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232496);
                                FindMoreFriendsUI.this.OAK = false;
                                FindMoreFriendsUI.b((IconPreference) FindMoreFriendsUI.this.vOA.bmg("more_tab_game_recommend"), 8, 8, false, 8, 8, 8);
                                AppMethodBeat.o(232496);
                            }
                        });
                        AppMethodBeat.o(232499);
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        Bitmap roundedCornerBitmap;
                        AppMethodBeat.i(232500);
                        if (bVar.bitmap == null || bVar.bitmap.isRecycled() || !z || (roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bVar.bitmap, true, ((float) bVar.bitmap.getWidth()) / 12.0f)) == null) {
                            AppMethodBeat.o(232500);
                            return null;
                        }
                        AppMethodBeat.o(232500);
                        return roundedCornerBitmap;
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        AppMethodBeat.i(232501);
                        izVar.dND.EX = 2;
                        izVar.dND.url = str;
                        EventCenter.instance.publish(izVar);
                        if (bVar == null) {
                            AppMethodBeat.o(232501);
                            return;
                        }
                        final int i2 = bVar.from;
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass26.AnonymousClass3 */

                                public final void run() {
                                    AppMethodBeat.i(232498);
                                    FindMoreFriendsUI.this.OAK = true;
                                    IconPreference iconPreference = (IconPreference) FindMoreFriendsUI.this.vOA.bmg("more_tab_game_recommend");
                                    if (i4 == 3) {
                                        iconPreference.gY(FindMoreFriendsUI.this.getString(R.string.x4), R.drawable.amr);
                                        FindMoreFriendsUI.b(iconPreference, 0, 8, false, 8, 8, 8);
                                        FindMoreFriendsUI.ao(j2, 1);
                                    } else if (i4 == 4) {
                                        iconPreference.aS(str, -1, Color.parseColor("#8c8c8c"));
                                        FindMoreFriendsUI.b(iconPreference, 8, 0, true, 8, 8, 8);
                                        FindMoreFriendsUI.ao(j2, 2);
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(858, 12, 1, false);
                                    if (i2 == 2) {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(858, 14, 1, false);
                                    }
                                    AppMethodBeat.o(232498);
                                }
                            });
                            AppMethodBeat.o(232501);
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass26.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(232497);
                                FindMoreFriendsUI.this.OAK = true;
                                iconPreference.aL(bitmap);
                                if (i4 == 3) {
                                    FindMoreFriendsUI.b(iconPreference, 8, 8, false, 0, 0, 0);
                                } else if (i4 == 4) {
                                    FindMoreFriendsUI.b(iconPreference, 8, 0, false, 0, 0, 0);
                                }
                                FindMoreFriendsUI.ao(j2, i4);
                                if (i2 == 2) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(858, 13, 1, false);
                                }
                                AppMethodBeat.o(232497);
                            }
                        });
                        AppMethodBeat.o(232501);
                    }
                });
            }
            AppMethodBeat.o(33096);
        }
    }

    private static void an(long j2, int i2) {
        AppMethodBeat.i(33097);
        g.aAi();
        if (j2 != g.aAh().azQ().a(ar.a.GAME_ENTRANCE_MSG_ID_LONG_SYNC, 0)) {
            g.aAi();
            g.aAh().azQ().set(ar.a.GAME_ENTRANCE_MSG_ID_LONG_SYNC, Long.valueOf(j2));
            com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
            if (dSQ != null) {
                dSQ.O(j2, i2);
            }
        }
        AppMethodBeat.o(33097);
    }

    private static void AX(boolean z) {
        AppMethodBeat.i(33098);
        b.a.dSQ().pG(z);
        AppMethodBeat.o(33098);
    }

    private String nd(String str, String str2) {
        AppMethodBeat.i(33099);
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(33099);
            return str;
        }
        String r = com.tencent.mm.pluginsdk.model.app.h.r(getContext(), str2);
        AppMethodBeat.o(33099);
        return r;
    }

    private static void a(IconPreference iconPreference, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        AppMethodBeat.i(33100);
        iconPreference.alD(i2);
        iconPreference.alF(i3);
        iconPreference.alE(i4);
        iconPreference.BB(z);
        iconPreference.alI(i5);
        iconPreference.alH(i6);
        iconPreference.alJ(i7);
        bz("more_tab_game_recommend", i2 == 0 || i3 == 0 || i4 == 0 || z || i5 == 0 || i6 == 0 || i7 == 0);
        AppMethodBeat.o(33100);
    }

    @Override // com.tencent.mm.model.bb
    public final void aVs() {
        AppMethodBeat.i(33101);
        if ((z.aUl() & 32768) != 0) {
            AppMethodBeat.o(33101);
            return;
        }
        this.OAC++;
        gHz();
        this.vOA.notifyDataSetChanged();
        AppMethodBeat.o(33101);
    }

    @Override // com.tencent.mm.model.bb
    public final void aVt() {
        AppMethodBeat.i(33102);
        if ((z.aUl() & 32768) != 0) {
            AppMethodBeat.o(33102);
            return;
        }
        gHz();
        this.vOA.notifyDataSetChanged();
        AppMethodBeat.o(33102);
    }

    @Override // com.tencent.mm.model.bb
    public final void aVu() {
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        AppMethodBeat.i(232513);
        super.onDestroy();
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.daK().removeObserver(this.tFo);
        AppMethodBeat.o(232513);
    }

    @Override // com.tencent.mm.model.bc
    public final void aVw() {
        AppMethodBeat.i(33103);
        if (this.vOA == null) {
            AppMethodBeat.o(33103);
            return;
        }
        this.status = z.aUc();
        updateStatus();
        AppMethodBeat.o(33103);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGu() {
        AppMethodBeat.i(33104);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.vOA = this.adapter;
        this.status = z.aUc();
        this.Dcv = z.aUl();
        this.qAb = z.aUd();
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
        this.vOA.m39do("find_friends_by_shake", true);
        this.vOA.m39do("ip_call_entrance", true);
        AppMethodBeat.o(33104);
    }

    private void aBd() {
        AppMethodBeat.i(161495);
        EventCenter.instance.removeListener(this.OAR);
        EventCenter.instance.removeListener(this.OAQ);
        EventCenter.instance.removeListener(this.OAS);
        EventCenter.instance.removeListener(this.DLr);
        EventCenter.instance.removeListener(this.OAV);
        EventCenter.instance.removeListener(this.xcg);
        EventCenter.instance.removeListener(this.OAZ);
        if (bg.aAc()) {
            com.tencent.mm.pluginsdk.c.a.b(lo.class.getName(), this.Kpg);
            com.tencent.mm.pluginsdk.c.a.b(iy.class.getName(), this.xWU);
            com.tencent.mm.pluginsdk.c.a.b(uo.class.getName(), this.OAU);
            com.tencent.mm.pluginsdk.c.a.b(ix.class.getName(), this.OAT);
            com.tencent.mm.bj.d.bgP().remove(this);
            bg.aVF();
            com.tencent.mm.model.c.aST().remove(this);
            bg.aVF();
            com.tencent.mm.model.c.b(this);
            bg.aVF();
            com.tencent.mm.model.c.azQ().remove(this);
            if (this.OAH != null) {
                com.tencent.mm.av.q.bcQ().Oo(this.OAH);
            }
        }
        if (o.DCQ != null) {
            o.DCQ.b(this);
        }
        AppMethodBeat.o(161495);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGv() {
        AppMethodBeat.i(33105);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab resume isTabSwitchInReport:%b isTabResumeReport:%b", Boolean.valueOf(this.OBb), Boolean.valueOf(this.OBc));
        if ((this.vOA instanceof com.tencent.mm.ui.base.preference.h) && this.vOA.OZd == 0) {
            this.vOA.OZd = System.currentTimeMillis();
        }
        this.dOs = true;
        gHD();
        com.tencent.mm.pluginsdk.c.a.a(lo.class.getName(), this.Kpg);
        com.tencent.mm.pluginsdk.c.a.a(iy.class.getName(), this.xWU);
        com.tencent.mm.pluginsdk.c.a.a(uo.class.getName(), this.OAU);
        com.tencent.mm.pluginsdk.c.a.a(ix.class.getName(), this.OAT);
        EventCenter.instance.addListener(this.OAR);
        EventCenter.instance.addListener(this.OAQ);
        EventCenter.instance.addListener(this.OAS);
        EventCenter.instance.addListener(this.DLr);
        EventCenter.instance.addListener(this.OAV);
        EventCenter.instance.add(this.xcg);
        EventCenter.instance.addListener(this.OAZ);
        com.tencent.mm.bj.d.bgP().add(this);
        bg.aVF();
        com.tencent.mm.model.c.aST().add(this);
        bg.aVF();
        com.tencent.mm.model.c.a(this);
        bg.aVF();
        com.tencent.mm.model.c.azQ().add(this);
        if (o.DCQ != null) {
            o.DCQ.a(this);
        }
        final View findViewById = findViewById(R.id.epv);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass27 */

                public final void run() {
                    AppMethodBeat.i(33066);
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(FindMoreFriendsUI.this.getContext(), R.anim.bs));
                    AppMethodBeat.o(33066);
                }
            });
        }
        if (isAdded()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass28 */

                public final void run() {
                    AppMethodBeat.i(232502);
                    Log.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", Integer.valueOf(FindMoreFriendsUI.this.status), Integer.valueOf(z.aUc()), Long.valueOf(FindMoreFriendsUI.this.qAb), Long.valueOf(z.aUd()), Integer.valueOf(FindMoreFriendsUI.this.Dcv), Integer.valueOf(z.aUl()));
                    FindMoreFriendsUI.this.qAb = z.aUd();
                    FindMoreFriendsUI.this.status = z.aUc();
                    FindMoreFriendsUI.this.Dcv = z.aUl();
                    FindMoreFriendsUI.v(FindMoreFriendsUI.this);
                    AppMethodBeat.o(232502);
                }
            });
        }
        gHs();
        if (gHr() && !this.OBb && !this.OBc) {
            i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            i.a.mT(true);
            this.OBc = true;
        }
        com.tencent.mm.plugin.scanner.box.h.aC(2, 0);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
        AppMethodBeat.o(33105);
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(232514);
        super.onConfigurationChanged(configuration);
        gHs();
        AppMethodBeat.o(232514);
    }

    private boolean IK(long j2) {
        return (this.qAb & j2) != 0;
    }

    private void gHz() {
        int i2;
        boolean z = false;
        AppMethodBeat.i(33106);
        boolean z2 = (this.Dcv & 32768) == 0;
        boolean aZU = com.tencent.mm.br.c.aZU("sns");
        Log.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", Boolean.valueOf(z2), Boolean.valueOf(aZU));
        if (!z2) {
            if (g.aAh().azQ().getInt(ar.a.USERINFO_SNS_ENTRY_SWITCH_INT, 0) == 1) {
                Log.w("MicroMsg.FindMoreFriendsUI", "opened sns entry recently");
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 71);
            } else if (g.aAh().azQ().getInt(ar.a.USERINFO_SNS_ENTRY_SWITCH_INT, 0) == -1) {
                Log.i("MicroMsg.FindMoreFriendsUI", "closed sns entry recently");
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 70);
            }
        }
        if (!z2 || !aZU) {
            this.vOA.m39do("album_dyna_photo_ui_title", true);
            if (!gHp()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(953, 0, 1);
            }
            AppMethodBeat.o(33106);
            return;
        }
        this.OAO++;
        this.vOA.m39do("album_dyna_photo_ui_title", false);
        FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.vOA.bmg("album_dyna_photo_ui_title");
        friendSnsPreference.drawable = at.aN(getContext(), R.attr.gf);
        bg.aVF();
        boolean nullAsFalse = Util.nullAsFalse((Boolean) com.tencent.mm.model.c.azQ().get(48, (Object) null));
        friendSnsPreference.alD(8);
        friendSnsPreference.alJ(8);
        if (nullAsFalse) {
            friendSnsPreference.alD(0);
            friendSnsPreference.gY(getString(R.string.x4), R.drawable.amr);
        }
        bg.aVF();
        this.OAB = (String) com.tencent.mm.model.c.azQ().get(68377, (Object) null);
        if (!Util.isNullOrNil(this.OAB) && LauncherUI.getCurrentTabIndex() == 2) {
            bg.aVF();
            if (com.tencent.mm.model.c.azQ().getInt(68419, 0) == 0) {
                g.aAi();
                com.tencent.mm.plugin.sns.k.f.s(2, (String) g.aAh().azQ().get(68418, ""), this.OAC);
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(68419, (Object) 1);
            }
        }
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_SNS_MEDIA_COLLAPSE_SNS_ID_LONG, (Object) null);
        long longValue = obj == null ? 0 : ((Long) obj).longValue();
        Log.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", Util.nullAs(this.OAB, ""));
        friendSnsPreference.alI(0);
        if (!Util.isNullOrNil(this.OAB)) {
            friendSnsPreference.alH(0);
            bg.aVF();
            if (Util.nullAs((Boolean) com.tencent.mm.model.c.azQ().get(68384, (Object) null), true)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            friendSnsPreference.alJ(i2);
            friendSnsPreference.blM(this.OAB);
        } else {
            bg.aVF();
            if (((Boolean) com.tencent.mm.model.c.azQ().get(589825, Boolean.FALSE)).booleanValue()) {
                friendSnsPreference.alG(R.raw.net_warn_icon);
                friendSnsPreference.alH(0);
                friendSnsPreference.alJ(8);
            } else if (longValue == 0 || !((n) g.af(n.class)).IM(longValue)) {
                friendSnsPreference.alH(8);
            } else {
                friendSnsPreference.alH(0);
                friendSnsPreference.alJ(0);
                friendSnsPreference.No(longValue);
            }
        }
        if (o.DCO != null) {
            this.OAC = o.DCO.ctM();
        }
        if (this.OAC != 0) {
            friendSnsPreference.alD(0);
            friendSnsPreference.gY(new StringBuilder().append(this.OAC).toString(), v.aQ(getContext(), this.OAC));
        }
        friendSnsPreference.alF(8);
        friendSnsPreference.alE(8);
        EventCenter.instance.publish(new yi());
        if (!Util.isNullOrNil(this.OAB) || this.OAC != 0) {
            z = true;
        }
        bz("album_dyna_photo_ui_title", z);
        AppMethodBeat.o(33106);
    }

    private void gHA() {
        boolean z;
        AppMethodBeat.i(33107);
        boolean z2 = (this.Dcv & 256) == 0;
        boolean aZU = com.tencent.mm.br.c.aZU("shake");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        Log.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s, isTeenMode:%s", Boolean.valueOf(z2), Boolean.valueOf(aZU), Boolean.valueOf(Vt));
        if (!z2 || !aZU || Vt) {
            this.vOA.m39do("find_friends_by_shake", true);
            if (!gHp()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(953, 2, 1);
            }
            AppMethodBeat.o(33107);
            return;
        }
        this.OAO++;
        this.vOA.m39do("find_friends_by_shake", false);
        IconPreference iconPreference = (IconPreference) this.vOA.bmg("find_friends_by_shake");
        int ctM = com.tencent.mm.bj.d.bgP().ctM() + o.a.glW().eUf();
        if (ctM > 0) {
            iconPreference.alD(0);
            iconPreference.gY(String.valueOf(ctM), R.drawable.b16);
        } else {
            iconPreference.alD(8);
            iconPreference.gY("", -1);
        }
        iconPreference.alH(8);
        o.a.glW().eUg();
        if (o.a.glW().eUh()) {
            z = com.tencent.mm.y.c.axV().cP(262154, 266258);
        } else {
            z = false;
        }
        if (z) {
            bg.aVF();
            String str = (String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, "");
            if (!TextUtils.isEmpty(str)) {
                iconPreference.alF(8);
                iconPreference.alD(0);
                iconPreference.gY(String.valueOf(str), R.drawable.b16);
            } else if (ctM > 0) {
                iconPreference.alF(0);
            } else {
                iconPreference.alF(0);
                iconPreference.alD(8);
                iconPreference.gY("", -1);
            }
        } else {
            iconPreference.alF(8);
        }
        bz("find_friends_by_shake", z);
        bg.aVF();
        String nullAs = Util.nullAs((String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) null), "");
        bg.aVF();
        Boolean valueOf = Boolean.valueOf(Util.nullAs((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, (Object) null), false));
        bg.aVF();
        int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, (Object) 0)).intValue();
        if (!valueOf.booleanValue() || nullAs == null || nullAs.equals("") || ctM > 0 || z) {
            iconPreference.alE(8);
        } else if (intValue == 0) {
            iconPreference.alF(8);
            iconPreference.alE(0);
            String[] split = nullAs.split(",");
            if (split.length > 0) {
                iconPreference.aS(split[0], -1, Color.parseColor("#8c8c8c"));
            }
            iconPreference.BB(true);
            iconPreference.alI(8);
            AppMethodBeat.o(33107);
            return;
        } else if (intValue == 1) {
            iconPreference.alE(8);
            iconPreference.alD(0);
            iconPreference.OYl = true;
            AppMethodBeat.o(33107);
            return;
        }
        AppMethodBeat.o(33107);
    }

    private void gHB() {
        AppMethodBeat.i(33108);
        boolean IK = IK(2097152);
        boolean aZU = com.tencent.mm.br.c.aZU("search");
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(!IK);
        objArr[1] = Boolean.valueOf(aZU);
        Log.i("MicroMsg.FindMoreFriendsUI", "openSearch %s, plugin installed %s", objArr);
        if (IK || !aZU) {
            this.vOA.m39do("find_friends_by_search", true);
            if (!gHp()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(953, 4, 1);
            }
            AppMethodBeat.o(33108);
            return;
        }
        this.OAO++;
        this.vOA.m39do("find_friends_by_search", false);
        try {
            JSONObject aXe = ak.aXe("discoverSearchEntry");
            String optString = aXe.optString("wording");
            aXe.optString("androidIcon");
            NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) this.vOA.bmg("find_friends_by_search");
            if (Util.isNullOrNil(optString)) {
                normalIconNewTipPreference.setTitle(getString(R.string.cf_));
            } else {
                normalIconNewTipPreference.setTitle(optString);
            }
            normalIconNewTipPreference.a(this.vOA);
            com.tencent.mm.plugin.newtips.a.exl().h(normalIconNewTipPreference);
            normalIconNewTipPreference.a(this.ACH, new NormalIconNewTipPreference.a() {
                /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass29 */

                @Override // com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.a
                public final void aIA(String str) {
                    AppMethodBeat.i(232503);
                    FindMoreFriendsUI.this.OAG = str;
                    AppMethodBeat.o(232503);
                }
            });
            com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
            a(aq.fYk().IFk, normalIconNewTipPreference);
            if (LauncherUI.getCurrentTabIndex() == 2) {
                aq.fYk().afy(1);
            }
            ai.fXY();
            AppMethodBeat.o(33108);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FindMoreFriendsUI", e2, "update search entry exception!", new Object[0]);
            AppMethodBeat.o(33108);
        }
    }

    private void gHC() {
        boolean z;
        AppMethodBeat.i(33109);
        final boolean z2 = (this.Dcv & 512) == 0;
        if (!IK(70368744177664L)) {
            z = true;
        } else {
            z = false;
        }
        boolean aZU = com.tencent.mm.br.c.aZU("nearby");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        Log.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, nearbyPluginInstalled %s, openNearbyLiveFriends %s, isTeenMode:%s", Boolean.valueOf(z2), Boolean.valueOf(aZU), Boolean.valueOf(z), Boolean.valueOf(Vt));
        if (Vt) {
            this.vOA.m39do("find_friends_by_near", true);
            this.vOA.m39do("find_live_friends_by_near", true);
            if (!gHp()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(953, 5, 1);
            }
            AppMethodBeat.o(33109);
            return;
        }
        this.OAO++;
        if (com.tencent.mm.bp.a.glB()) {
            this.vOA.m39do("find_friends_by_near", true);
            if (!z) {
                this.vOA.m39do("find_live_friends_by_near", true);
                AppMethodBeat.o(33109);
                return;
            }
            com.tencent.mm.ui.report.a.gWZ();
            this.vOA.m39do("find_live_friends_by_near", false);
            final FinderIconViewTipPreference finderIconViewTipPreference = (FinderIconViewTipPreference) this.vOA.bmg("find_live_friends_by_near");
            if (finderIconViewTipPreference == null) {
                Log.w("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry find_friends_by_near return for null.");
                AppMethodBeat.o(33109);
                return;
            }
            int ctM = com.tencent.mm.bj.d.bgO().ctM();
            if (!z2) {
                ctM = 0;
            }
            if (com.tencent.mm.app.plugin.b.Xm() || !z2) {
                Log.i("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry: clear footprint red dot");
                ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().Iy(1014);
            } else {
                Log.i("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry: add footprint red dot");
                ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().tJA.dbs();
            }
            if (ctM > 0) {
                Log.i("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry: add unread red dot");
                ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().tJA.IB(ctM);
            } else {
                Log.i("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry: clear footprint red dot");
                ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().Iy(1013);
            }
            if (this.OBa == null) {
                this.OBa = new Observer<h.a>() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass30 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.arch.lifecycle.Observer
                    public final /* synthetic */ void onChanged(h.a aVar) {
                        boolean z;
                        ConcurrentHashMap<String, bdo> concurrentHashMap;
                        AppMethodBeat.i(232504);
                        h.a aVar2 = aVar;
                        if (aVar2 == null) {
                            AppMethodBeat.o(232504);
                            return;
                        }
                        Log.i("MicroMsg.FindMoreFriendsUI", "[onChanged] result=%s", aVar2);
                        if (aVar2.dEF) {
                            bdo bdo = aVar2.tKS;
                            if (bdo == null) {
                                Log.e("MicroMsg.FindMoreFriendsUI", "info is null");
                                AppMethodBeat.o(232504);
                                return;
                            }
                            if (aVar2.tKT != null) {
                                z = aVar2.tKT.field_ctrType == 1013 || aVar2.tKT.field_ctrType == 1014 || aVar2.tKT.field_ctrType == 1011;
                            } else {
                                z = false;
                            }
                            if (z) {
                                FindMoreFriendsUI.dW("find_live_friends_by_near", true);
                                if (bdo.xGz == 6) {
                                    if (com.tencent.mm.bj.d.bgO().ctM() <= 0 || !z2) {
                                        finderIconViewTipPreference.alD(0);
                                        finderIconViewTipPreference.gY(FindMoreFriendsUI.this.getString(R.string.x4), R.drawable.amr);
                                        com.tencent.mm.ui.report.a.gXb();
                                    }
                                    AppMethodBeat.o(232504);
                                    return;
                                }
                                finderIconViewTipPreference.qW(false);
                                finderIconViewTipPreference.alH(0);
                                finderIconViewTipPreference.alI(0);
                                finderIconViewTipPreference.D(ar.m(FindMoreFriendsUI.this.getContext(), R.raw.icons_filled_footstep, FindMoreFriendsUI.this.getContext().getResources().getColor(R.color.en)));
                                finderIconViewTipPreference.lb(at.aH(FindMoreFriendsUI.this.getContext(), R.dimen.cc), at.aH(FindMoreFriendsUI.this.getContext(), R.dimen.cc));
                                if (bdo.xGz != 101) {
                                    int i2 = bdo.count;
                                    finderIconViewTipPreference.alD(0);
                                    finderIconViewTipPreference.gY(String.valueOf(i2), v.aQ(FindMoreFriendsUI.this.getContext(), i2));
                                    i.a aVar3 = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                                    String str = aVar2.tKT.field_tipsId;
                                    p.h(str, "overwriteTipsId");
                                    com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
                                    p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                                    com.tencent.mm.plugin.finder.extension.reddot.k kVar = null;
                                    for (com.tencent.mm.plugin.finder.extension.reddot.k kVar2 : com.tencent.mm.plugin.finder.extension.reddot.f.a(((PluginFinder) ah).getRedDotManager(), "NearbyEntrance")) {
                                        if (kVar2.field_ctrInfo.type != 16) {
                                            kVar2 = kVar;
                                        }
                                        kVar = kVar2;
                                    }
                                    bdo bdo2 = (kVar == null || (concurrentHashMap = kVar.tLk) == null) ? null : concurrentHashMap.get("NearbyEntrance");
                                    y yVar = y.vXH;
                                    bbi bbi = kVar != null ? kVar.field_ctrInfo : null;
                                    if (!(bdo2 == null || bbi == null)) {
                                        com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                                        if (kVar == null) {
                                            p.hyc();
                                        }
                                        com.tencent.mm.plugin.finder.report.j.a(kVar, bdo2, 6, 1, (String) null, str, 16);
                                    }
                                    AppMethodBeat.o(232504);
                                    return;
                                }
                            } else {
                                finderIconViewTipPreference.alH(8);
                                finderIconViewTipPreference.alD(8);
                                finderIconViewTipPreference.gY("", -1);
                                FindMoreFriendsUI.a(bdo, finderIconViewTipPreference, false);
                            }
                            AppMethodBeat.o(232504);
                            return;
                        }
                        finderIconViewTipPreference.qW(false);
                        FindMoreFriendsUI.dW("find_live_friends_by_near", false);
                        AppMethodBeat.o(232504);
                    }
                };
                com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                com.tencent.mm.plugin.finder.extension.reddot.h.dbf().observe(this, this.OBa);
                com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                h.a value = com.tencent.mm.plugin.finder.extension.reddot.h.dbf().getValue();
                if (value != null) {
                    this.OBa.onChanged(value);
                }
            }
            if (ctM <= 0 && g.aAh().azQ().getBoolean(ar.a.USERINFO_FIRST_SHOW_NEARBY_REDDOT_BOOLEAN_SYNC, true)) {
                Log.i("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry: add nearby new red dot");
                ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().tJA.dbt();
                g.aAh().azQ().set(ar.a.USERINFO_FIRST_SHOW_NEARBY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            }
            AppMethodBeat.o(33109);
            return;
        }
        this.vOA.m39do("find_live_friends_by_near", true);
        com.tencent.mm.plugin.finder.extension.reddot.h hVar3 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.daK().removeObserver(this.OBa);
        if (!z2 || !aZU) {
            this.vOA.m39do("find_friends_by_near", true);
            if (!gHp()) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(953, 5, 1);
            }
            AppMethodBeat.o(33109);
            return;
        }
        this.vOA.m39do("find_friends_by_near", false);
        IconPreference iconPreference = (IconPreference) this.vOA.bmg("find_friends_by_near");
        if (iconPreference == null) {
            Log.w("MicroMsg.FindMoreFriendsUI", "updateNearbyEntry find_friends_by_near return for null.");
            AppMethodBeat.o(33109);
            return;
        }
        if (com.tencent.mm.app.plugin.b.Xm()) {
            iconPreference.alH(8);
        } else {
            iconPreference.alH(0);
            iconPreference.D(ar.m(getContext(), R.raw.icons_filled_footstep, getContext().getResources().getColor(R.color.en)));
            iconPreference.lb(at.aH(getContext(), R.dimen.cc), at.aH(getContext(), R.dimen.cc));
        }
        int ctM2 = com.tencent.mm.bj.d.bgO().ctM();
        if (!com.tencent.mm.bp.a.glC() || com.tencent.mm.bp.a.glB()) {
            if (ctM2 > 0) {
                iconPreference.alD(0);
                iconPreference.gY(String.valueOf(ctM2), v.aQ(getContext(), ctM2));
                com.tencent.mm.ui.report.a.NZ((long) ctM2);
                AppMethodBeat.o(33109);
                return;
            }
            iconPreference.alD(8);
            iconPreference.gY("", -1);
            AppMethodBeat.o(33109);
        } else if (ctM2 > 0) {
            iconPreference.alF(0);
            com.tencent.mm.ui.report.a.NZ((long) ctM2);
            AppMethodBeat.o(33109);
        } else {
            iconPreference.alF(8);
            AppMethodBeat.o(33109);
        }
    }

    private void gHD() {
        AppMethodBeat.i(33110);
        tu tuVar = new tu();
        tuVar.eao.dOs = this.dOs;
        EventCenter.instance.publish(tuVar);
        AppMethodBeat.o(33110);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGw() {
        AppMethodBeat.i(33111);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab start");
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("lifeappreddot", this.OAY);
        AppMethodBeat.o(33111);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGx() {
        AppMethodBeat.i(33112);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        this.dOs = false;
        this.OBb = false;
        this.OBc = false;
        gHD();
        aBd();
        AppMethodBeat.o(33112);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGy() {
        AppMethodBeat.i(33113);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
        AppMethodBeat.o(33113);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGz() {
        AppMethodBeat.i(33114);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
        aBd();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("lifeappreddot", this.OAY);
        AppMethodBeat.o(33114);
    }

    @Override // com.tencent.mm.ui.n
    public final void gGB() {
        AppMethodBeat.i(33115);
        Log.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
        AppMethodBeat.o(33115);
    }

    @Override // com.tencent.mm.ui.n
    public final void gGC() {
        AppMethodBeat.i(33116);
        Log.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
        AppMethodBeat.o(33116);
    }

    @Override // com.tencent.mm.ui.n
    public final void gGE() {
        AppMethodBeat.i(33117);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
        AppMethodBeat.o(33117);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        boolean z = true;
        AppMethodBeat.i(33118);
        Log.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorage)");
        if (LauncherUI.getCurrentTabIndex() == 2) {
            boolean z2 = false;
            if (this.status != z.aUc()) {
                this.status = z.aUc();
                z2 = true;
            }
            if (this.qAb != z.aUd()) {
                this.qAb = z.aUd();
                z2 = true;
            }
            if (this.Dcv != z.aUl()) {
                this.Dcv = z.aUl();
            } else {
                z = z2;
            }
            if (z) {
                updateStatus();
            }
        }
        AppMethodBeat.o(33118);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        boolean z = true;
        AppMethodBeat.i(33119);
        Log.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
        if (LauncherUI.getCurrentTabIndex() == 2) {
            boolean z2 = false;
            if (this.status != z.aUc()) {
                this.status = z.aUc();
                z2 = true;
            }
            if (this.qAb != z.aUd()) {
                this.qAb = z.aUd();
                z2 = true;
            }
            if (this.Dcv != z.aUl()) {
                this.Dcv = z.aUl();
            } else {
                z = z2;
            }
            if (z) {
                updateStatus();
            }
            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 68377) {
                gHz();
            }
            if (mStorageEx instanceof ba) {
                this.vOA.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(33119);
    }

    @Override // com.tencent.mm.ui.n
    public final void gHE() {
        AppMethodBeat.i(33120);
        Log.i("MicroMsg.FindMoreFriendsUI", "on tab switch in isTabSwitchInReport:%b isTabResumeReport:%b", Boolean.valueOf(this.OBb), Boolean.valueOf(this.OBc));
        this.dOs = true;
        gHD();
        com.tencent.mm.blink.b.ake().arrange(new Runnable() {
            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass33 */

            public final void run() {
                AppMethodBeat.i(232506);
                FindMoreFriendsUI.this.status = z.aUc();
                FindMoreFriendsUI.this.Dcv = z.aUl();
                FindMoreFriendsUI.this.qAb = z.aUd();
                long currentTimeMillis = System.currentTimeMillis();
                FindMoreFriendsUI.v(FindMoreFriendsUI.this);
                Log.i("MicroMsg.FindMoreFriendsUI", "[updateStatus] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(232506);
            }
        });
        ak.bq(20, false);
        if (gHr() && !this.OBb && !this.OBc) {
            i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            i.a.mT(true);
            this.OBb = true;
        }
        AppMethodBeat.o(33120);
    }

    @Override // com.tencent.mm.ui.n
    public final void gHF() {
        AppMethodBeat.i(33121);
        Log.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
        this.dOs = false;
        this.OBb = false;
        this.OBc = false;
        gHD();
        AppMethodBeat.o(33121);
    }

    @Override // com.tencent.mm.model.bb
    public final void aVv() {
        AppMethodBeat.i(33122);
        Log.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
        if ((z.aUl() & 32768) != 0) {
            AppMethodBeat.o(33122);
            return;
        }
        if (com.tencent.mm.plugin.sns.b.o.DCO != null) {
            this.OAC = com.tencent.mm.plugin.sns.b.o.DCO.ctM();
        }
        gHz();
        this.vOA.notifyDataSetChanged();
        AppMethodBeat.o(33122);
    }

    private static void bz(String str, boolean z) {
        AppMethodBeat.i(258871);
        Log.i("MicroMsg.FindMoreFriendsUI", "note entry red dot [%s] entry [%b]", str, Boolean.valueOf(z));
        abi abi = new abi();
        abi.opT.wJe = str;
        abi.opT.HHY = z;
        EventCenter.instance.publish(abi);
        AppMethodBeat.o(258871);
    }

    private void AW(boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(33087);
        if (com.tencent.mm.pluginsdk.i.d.JYo != null) {
            if (com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsY()) {
                this.OAO++;
                com.tencent.mm.plugin.subapp.jdbiz.c fsV = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV();
                NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) this.vOA.bmg("jd_market_entrance");
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                normalIconNewTipPreference.setTitle(com.tencent.mm.plugin.subapp.jdbiz.d.fsZ());
                normalIconNewTipPreference.a(this.vOA);
                com.tencent.mm.plugin.newtips.a.exl().h(normalIconNewTipPreference);
                normalIconNewTipPreference.a(this.ACH, new NormalIconNewTipPreference.a() {
                    /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass14 */

                    @Override // com.tencent.mm.plugin.newtips.NormalIconNewTipPreference.a
                    public final void aIA(String str) {
                        AppMethodBeat.i(232488);
                        FindMoreFriendsUI.this.OAH = str;
                        AppMethodBeat.o(232488);
                    }
                });
                com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                boolean z4 = com.tencent.mm.plugin.subapp.jdbiz.d.fsR() && fsV.isStart() && !fsV.dMp();
                if (!z4 || (Util.isNullOrNil(fsV.FJp) && Util.isNullOrNil(fsV.FJq) && !fsV.FJo)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!com.tencent.mm.plugin.newtips.a.g.a(z2, normalIconNewTipPreference)) {
                    normalIconNewTipPreference.alD(8);
                    normalIconNewTipPreference.alF(8);
                    normalIconNewTipPreference.alE(8);
                    normalIconNewTipPreference.BB(false);
                    normalIconNewTipPreference.alI(8);
                    if (z4) {
                        if (!Util.isNullOrNil(fsV.FJp)) {
                            normalIconNewTipPreference.alD(8);
                            normalIconNewTipPreference.alF(8);
                            normalIconNewTipPreference.aS(fsV.FJp, -1, -7566196);
                            normalIconNewTipPreference.alE(0);
                        }
                        if (!Util.isNullOrNil(fsV.FJq)) {
                            com.tencent.mm.av.q.bcQ();
                            Bitmap EP = com.tencent.mm.av.d.EP(fsV.FJq);
                            normalIconNewTipPreference.alI(0);
                            normalIconNewTipPreference.alH(0);
                            normalIconNewTipPreference.alJ(0);
                            normalIconNewTipPreference.BB(false);
                            if (EP != null) {
                                this.OAH = null;
                                normalIconNewTipPreference.aL(EP);
                            } else {
                                com.tencent.mm.av.q.bcU().a(fsV.FJq, this.ACH);
                                this.OAH = fsV.FJq;
                            }
                            if (!Util.isNullOrNil(fsV.FJp)) {
                                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON, true);
                            } else {
                                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON, true);
                            }
                        } else if (!Util.isNullOrNil(fsV.FJp)) {
                            normalIconNewTipPreference.BB(true);
                            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                        } else if (fsV.FJo) {
                            normalIconNewTipPreference.alF(0);
                            normalIconNewTipPreference.gY("", -1);
                            normalIconNewTipPreference.alD(8);
                            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
                        } else {
                            com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
                        }
                    } else {
                        com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
                    }
                    bz("jd_market_entrance", z4);
                }
                if (z) {
                    this.vOA.notifyDataSetChanged();
                }
                boolean z5 = g.aAh().azQ().getBoolean(ar.a.USERINFO_JD_ENTRANCE_RESET_EXPOSURE_FLAG_BOOLEAN_SYNC, false);
                if (!gHp() || z5) {
                    String str = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().ftd().username;
                    if (Util.isNullOrNil(str)) {
                        str = com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().ftc();
                    }
                    g.aAh().azQ().set(ar.a.USERINFO_JD_ENTRANCE_RESET_EXPOSURE_FLAG_BOOLEAN_SYNC, Boolean.FALSE);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 12);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11178, str, com.tencent.mm.plugin.subapp.jdbiz.d.fsQ().fsV().FJm, Integer.valueOf(gHt()), 2);
                }
                z3 = false;
            } else {
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                String fsZ = com.tencent.mm.plugin.subapp.jdbiz.d.fsZ();
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                String fta = com.tencent.mm.plugin.subapp.jdbiz.d.fta();
                if (!gHp() && LocaleUtil.isSimplifiedChineseAppLang()) {
                    if (Util.isNullOrNil(fsZ)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 2);
                    }
                    if (Util.isNullOrNil(fta)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(931, 4);
                    }
                }
            }
        }
        this.vOA.m39do("jd_market_entrance", z3);
        AppMethodBeat.o(33087);
    }

    static /* synthetic */ void a(FindMoreFriendsUI findMoreFriendsUI, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(232515);
        if (z) {
            if (System.currentTimeMillis() - findMoreFriendsUI.OAN > 1000) {
                findMoreFriendsUI.OAN = System.currentTimeMillis();
            } else {
                z2 = false;
            }
        }
        if (z2) {
            findMoreFriendsUI.gHy();
            findMoreFriendsUI.vOA.notifyDataSetChanged();
        }
        AppMethodBeat.o(232515);
    }

    static /* synthetic */ void hYA() {
        AppMethodBeat.i(258874);
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(ar.a.USERINFO_GAME_LAST_SAVED_LANGUAGE_STRING, ""));
        if (!nullAsNil.equalsIgnoreCase(applicationLanguage)) {
            Log.i("MicroMsg.FindMoreFriendsUI", "checkLangChange lastLang:%s, currentLang:%s", nullAsNil, applicationLanguage);
            g.aAh().azQ().set(ar.a.USERINFO_GAME_LAST_SAVED_LANGUAGE_STRING, applicationLanguage);
            it itVar = new it();
            itVar.dNs.EX = 5;
            itVar.dNs.param = "6";
            EventCenter.instance.publish(itVar);
        }
        AppMethodBeat.o(258874);
    }

    static /* synthetic */ void a(FindMoreFriendsUI findMoreFriendsUI, final qf qfVar) {
        AppMethodBeat.i(258875);
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass22 */

            public final void run() {
                AppMethodBeat.i(232494);
                FindMoreFriendsUI.b(FindMoreFriendsUI.this, qfVar);
                AppMethodBeat.o(232494);
            }
        });
        AppMethodBeat.o(258875);
    }

    static /* synthetic */ void a(FindMoreFriendsUI findMoreFriendsUI, final qe qeVar) {
        AppMethodBeat.i(258876);
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.ui.FindMoreFriendsUI.AnonymousClass24 */

            public final void run() {
                AppMethodBeat.i(33063);
                FindMoreFriendsUI.b(FindMoreFriendsUI.this, qeVar);
                AppMethodBeat.o(33063);
            }
        });
        AppMethodBeat.o(258876);
    }

    static /* synthetic */ void b(FindMoreFriendsUI findMoreFriendsUI, qf qfVar) {
        boolean z;
        AppMethodBeat.i(258877);
        NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) findMoreFriendsUI.vOA.bmg("more_tab_game_recommend");
        if (normalIconNewTipPreference != null) {
            com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
            findMoreFriendsUI.OAL = false;
            long j2 = qfVar.dWy.msgId;
            if (qfVar.dWy.dDG == 1 || qfVar.dWy.dDG == 2 || qfVar.dWy.dDG == 3 || qfVar.dWy.dDG == 4 || qfVar.dWy.dDG == 5) {
                z = true;
            } else {
                z = false;
            }
            if (!com.tencent.mm.plugin.newtips.a.g.a(z, normalIconNewTipPreference)) {
                normalIconNewTipPreference.alF(8);
                if (qfVar.dWy.dDG == 1) {
                    normalIconNewTipPreference.gY(findMoreFriendsUI.getString(R.string.x4), R.drawable.amr);
                    a(normalIconNewTipPreference, 0, 8, 8, false, 8, 8, 8);
                    an(j2, qfVar.dWy.dDG);
                    AX(true);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_NEW, true);
                    AppMethodBeat.o(258877);
                    return;
                } else if (qfVar.dWy.dDG == 2) {
                    normalIconNewTipPreference.aS(findMoreFriendsUI.nd(qfVar.dWy.appName, qfVar.dWy.appId), -1, Color.parseColor("#8c8c8c"));
                    a(normalIconNewTipPreference, 8, 8, 0, true, 8, 8, 8);
                    an(j2, qfVar.dWy.dDG);
                    AX(true);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                    AppMethodBeat.o(258877);
                    return;
                } else if (qfVar.dWy.dDG == 3) {
                    if (Util.isNullOrNil(qfVar.dWy.icon)) {
                        normalIconNewTipPreference.aL(com.tencent.mm.pluginsdk.model.app.h.c(qfVar.dWy.appId, 1, com.tencent.mm.cb.a.getDensity(findMoreFriendsUI.getContext())));
                        a(normalIconNewTipPreference, 8, 8, 8, false, 0, 0, 0);
                    } else {
                        findMoreFriendsUI.a(qfVar, normalIconNewTipPreference, qfVar, "");
                    }
                    AX(true);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON, true);
                    AppMethodBeat.o(258877);
                    return;
                } else if (qfVar.dWy.dDG == 4) {
                    String nd = findMoreFriendsUI.nd(qfVar.dWy.appName, qfVar.dWy.appId);
                    if (!Util.isNullOrNil(nd)) {
                        normalIconNewTipPreference.aS(nd, -1, Color.parseColor("#8c8c8c"));
                        if (Util.isNullOrNil(qfVar.dWy.icon)) {
                            normalIconNewTipPreference.aL(com.tencent.mm.pluginsdk.model.app.h.c(qfVar.dWy.appId, 1, com.tencent.mm.cb.a.getDensity(findMoreFriendsUI.getContext())));
                            a(normalIconNewTipPreference, 8, 8, 0, false, 0, 0, 0);
                        } else {
                            findMoreFriendsUI.a(qfVar, normalIconNewTipPreference, qfVar, nd);
                        }
                        AX(true);
                    } else {
                        findMoreFriendsUI.OAK = true;
                        a(normalIconNewTipPreference, 8, 8, 8, false, 8, 8, 8);
                    }
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE_ICON, true);
                    AppMethodBeat.o(258877);
                    return;
                } else if (qfVar.dWy.dDG == 5) {
                    findMoreFriendsUI.OAK = true;
                    a(normalIconNewTipPreference, 8, 0, 8, false, 8, 8, 8);
                    an(j2, qfVar.dWy.dDG);
                    AX(true);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
                    AppMethodBeat.o(258877);
                    return;
                } else {
                    findMoreFriendsUI.OAK = true;
                    a(normalIconNewTipPreference, 8, 8, 8, false, 8, 8, 8);
                    AX(false);
                }
            }
        }
        AppMethodBeat.o(258877);
    }

    static /* synthetic */ void b(FindMoreFriendsUI findMoreFriendsUI, qe qeVar) {
        AppMethodBeat.i(258878);
        NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) findMoreFriendsUI.vOA.bmg("more_tab_game_recommend");
        if (normalIconNewTipPreference != null) {
            com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
            if (!Util.isNullOrNil(qeVar.dWv.dQx)) {
                normalIconNewTipPreference.aS(qeVar.dWv.dQx, -1, Color.parseColor("#8c8c8c"));
            }
            if (!Util.isNullOrNil(qeVar.dWv.dWw)) {
                normalIconNewTipPreference.aL(null);
                com.tencent.mm.ui.g.a.a.c(normalIconNewTipPreference.gLG(), qeVar.dWv.dWw);
                a(normalIconNewTipPreference, 8, 8, 0, false, 0, 0, 0);
            } else {
                a(normalIconNewTipPreference, 8, 8, 0, false, 8, 8, 8);
            }
            if (Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_GAME_LIFE_REPORTED_MSG_ID_LONG, (Object) 0L)) != qeVar.dWv.dWx) {
                g.aAh().azQ().set(ar.a.USERINFO_GAME_LIFE_REPORTED_MSG_ID_LONG, Long.valueOf(qeVar.dWv.dWx));
                com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                if (dSQ != null) {
                    dSQ.NX(qeVar.dWv.dCm);
                }
            }
            findMoreFriendsUI.OAL = true;
            findMoreFriendsUI.OAM = qeVar.dWv.dCm;
        }
        AppMethodBeat.o(258878);
    }

    static /* synthetic */ void a(bdo bdo, FinderIconViewTipPreference finderIconViewTipPreference, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(258882);
        Log.i("MicroMsg.FindMoreFriendsUI", "changeRedDot icon url: " + bdo.qGB + " show_type:" + bdo.xGz);
        boolean daH = ((aj) g.ah(aj.class)).getRedDotManager().daH();
        if (bdo.xGz == 7 || bdo.xGz == 11 || bdo.xGz == 4 || bdo.xGz == 12 || bdo.xGz == 13 || bdo.xGz == 14 || bdo.xGz == 16) {
            Log.i("MicroMsg.FindMoreFriendsUI", "enableShowEntranceRedDot %s", Boolean.valueOf(daH));
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtC().value().intValue() != -1) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int intValue = com.tencent.mm.plugin.finder.storage.c.dtC().value().intValue();
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (intValue < com.tencent.mm.plugin.finder.storage.c.dtD().size()) {
                    com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    bdo.xGz = com.tencent.mm.plugin.finder.storage.c.dtD().get(intValue).first.intValue();
                    com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    bdo.title = com.tencent.mm.plugin.finder.storage.c.dtD().get(intValue).second;
                    Log.i("MicroMsg.FindMoreFriendsUI", "debug set showType %s title %s", Integer.valueOf(bdo.xGz), bdo.title);
                }
            }
        }
        if (bdo.xGz == 16) {
            finderIconViewTipPreference.ACK = true;
            ehv ehv = new ehv();
            ehv.url = bdo.qGB;
            ehv.title = bdo.title;
            finderIconViewTipPreference.a(daH, ehv, 4, true, false, true);
        } else if (bdo.xGz == 7 || bdo.xGz == 12 || bdo.xGz == 14) {
            finderIconViewTipPreference.ACK = false;
            ehv ehv2 = new ehv();
            ehv2.url = bdo.qGB;
            ehv2.title = bdo.title;
            if ((!daH || bdo.xGz != 12) && ((!Util.isNullOrNil(bdo.title) || bdo.xGz != 7) && bdo.xGz != 14)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (bdo.xGz != 14) {
                z3 = true;
            } else {
                z3 = false;
            }
            finderIconViewTipPreference.a(daH, ehv2, 5, z2, z3, false);
        } else if (bdo.xGz == 4 || bdo.xGz == 11 || bdo.xGz == 13) {
            finderIconViewTipPreference.ACK = true;
            ehv ehv3 = new ehv();
            ehv3.url = bdo.qGB;
            ehv3.title = bdo.title;
            if ((!daH || bdo.xGz != 11) && ((!Util.isNullOrNil(bdo.title) || bdo.xGz != 4) && bdo.xGz != 13)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (bdo.xGz != 13) {
                z5 = true;
            } else {
                z5 = false;
            }
            finderIconViewTipPreference.a(daH, ehv3, 4, z4, z5, false);
        } else if (bdo.xGz == 9) {
            finderIconViewTipPreference.ACK = false;
            ehv ehv4 = new ehv();
            ehv4.url = bdo.qGB;
            ehv4.title = bdo.title;
            finderIconViewTipPreference.a(daH, ehv4, 2, Util.isNullOrNil(bdo.title), true, false);
        } else if (bdo.xGz == 10) {
            finderIconViewTipPreference.ACK = true;
            ehv ehv5 = new ehv();
            ehv5.url = bdo.qGB;
            ehv5.title = bdo.title;
            finderIconViewTipPreference.a(daH, ehv5, 1, Util.isNullOrNil(bdo.title), true, false);
        } else if (bdo.xGz == 3) {
            ehv ehv6 = new ehv();
            ehv6.title = bdo.title;
            int i2 = 6;
            if (z) {
                i2 = 7;
            }
            finderIconViewTipPreference.a(daH, ehv6, i2, true, false, false);
        } else if (bdo.xGz == 1) {
            finderIconViewTipPreference.qW(daH);
        } else if (bdo.xGz == 100 || bdo.xGz == 6) {
            finderIconViewTipPreference.qX(true);
        } else {
            finderIconViewTipPreference.qW(false);
        }
        if (LauncherUI.getCurrentTabIndex() == 2) {
            i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
            i.a.mT(false);
        }
        bz(finderIconViewTipPreference.mKey, daH);
        AppMethodBeat.o(258882);
    }
}
