package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.g.a;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.roomsdk.a.c.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.e;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@i
public class ChatroomInfoUI extends MMPreference implements com.tencent.mm.ak.i, com.tencent.mm.bh.a, a.b, MStorage.IOnStorageChange, MStorageEx.IOnStorageChange {
    private static boolean guv = false;
    private as contact;
    private boolean dRx;
    private ProgressDialog gtM = null;
    private ProgressDialog gtN = null;
    private boolean gtO;
    private RoomCardPreference gtP;
    private Preference gtQ;
    private Preference gtR;
    private NormalIconPreference gtS;
    private NormalIconPreference gtT;
    private ContactListExpandPreference gtU;
    private CheckBoxPreference gtV;
    private CheckBoxPreference gtW;
    private CheckBoxPreference gtX;
    private KeyValuePreference gtY;
    private KeyValuePreference gtZ;
    private ah gtd = null;
    private int guA = 0;
    private CheckBoxPreference gua;
    private NewTipPreference gub;
    private boolean guc;
    private boolean gud;
    private boolean gue = false;
    private boolean guf = false;
    private int gug;
    private boolean guh;
    private boolean gui = false;
    private int guj = -1;
    private boolean guk = true;
    private boolean gul = false;
    private boolean gum = false;
    private boolean gun = false;
    private boolean guo = false;
    private e gup = new e(new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass12 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    });
    boolean guq = false;
    private IListener gur = new IListener<jj>() {
        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass30 */

        {
            AppMethodBeat.i(160778);
            this.__eventId = jj.class.getName().hashCode();
            AppMethodBeat.o(160778);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jj jjVar) {
            AppMethodBeat.i(12557);
            jj jjVar2 = jjVar;
            if ((jjVar2 instanceof jj) && Util.isEqual(jjVar2.dOd.dOe, ChatroomInfoUI.this.roomId)) {
                ChatroomInfoUI.k(ChatroomInfoUI.this);
            }
            AppMethodBeat.o(12557);
            return false;
        }
    };
    int gus = -1;
    private q gut = null;
    private String guu = "";
    private com.tencent.mm.roomsdk.a.c.a guw = null;
    private String gux = null;
    private b guy = new b() {
        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass22 */

        @Override // com.tencent.mm.pluginsdk.c.b
        public final void a(int i2, int i3, String str, IEvent iEvent) {
            AppMethodBeat.i(194087);
            if (iEvent instanceof nh) {
                nh nhVar = (nh) iEvent;
                Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
                if (ChatroomInfoUI.this.gtM != null) {
                    ChatroomInfoUI.this.gtM.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    if (i2 == 0 && i3 == 0 && ChatroomInfoUI.this.gtU != null) {
                        ArrayList<as> X = ChatroomInfoUI.X(nhVar.dTs.dTe);
                        ContactListExpandPreference contactListExpandPreference = ChatroomInfoUI.this.gtU;
                        if (contactListExpandPreference.KfY != null) {
                            r rVar = contactListExpandPreference.KfY.Kfo;
                            rVar.bh(X);
                            rVar.amZ();
                        }
                        if (ChatroomInfoUI.this.screen != null) {
                            ChatroomInfoUI.this.screen.notifyDataSetChanged();
                        }
                        ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(R.plurals.a1, X.size(), Integer.valueOf(X.size())));
                    }
                    ChatroomInfoUI.j(ChatroomInfoUI.this);
                } else if (i3 == -21) {
                    h.d(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.string.g7i), ChatroomInfoUI.this.getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass22.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(194086);
                            ChatroomInfoUI.this.finish();
                            AppMethodBeat.o(194086);
                        }
                    });
                    AppMethodBeat.o(194087);
                    return;
                } else {
                    h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.string.g7k), ChatroomInfoUI.this.getString(R.string.zb), true);
                    AppMethodBeat.o(194087);
                    return;
                }
            }
            AppMethodBeat.o(194087);
        }
    };
    private MTimerHandler guz = null;
    private MMHandler handler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(12507);
            ChatroomInfoUI.a(ChatroomInfoUI.this);
            AppMethodBeat.o(12507);
        }
    };
    private boolean isDeleteCancel = false;
    private String roomId;
    private f screen;
    private SharedPreferences sp = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChatroomInfoUI() {
        AppMethodBeat.i(12561);
        AppMethodBeat.o(12561);
    }

    static /* synthetic */ boolean d(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(12602);
        boolean amD = chatroomInfoUI.amD();
        AppMethodBeat.o(12602);
        return amD;
    }

    static /* synthetic */ void h(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(12603);
        chatroomInfoUI.amz();
        AppMethodBeat.o(12603);
    }

    static /* synthetic */ void i(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(12604);
        chatroomInfoUI.amA();
        AppMethodBeat.o(12604);
    }

    static /* synthetic */ void j(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(12605);
        chatroomInfoUI.updateTitle();
        AppMethodBeat.o(12605);
    }

    static /* synthetic */ void k(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(12606);
        chatroomInfoUI.amq();
        AppMethodBeat.o(12606);
    }

    static /* synthetic */ void l(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(194105);
        chatroomInfoUI.amv();
        AppMethodBeat.o(194105);
    }

    static /* synthetic */ void r(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(194106);
        chatroomInfoUI.amu();
        AppMethodBeat.o(194106);
    }

    static /* synthetic */ void u(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(194109);
        chatroomInfoUI.amr();
        AppMethodBeat.o(194109);
    }

    static /* synthetic */ void w(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(194110);
        chatroomInfoUI.ams();
        AppMethodBeat.o(194110);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12562);
        super.onCreate(bundle);
        g.aAg().hqi.a(480, this);
        b.a(nh.class.getName(), this.guy);
        com.tencent.mm.vending.b.b<IListener> alive = this.gur.alive();
        Assert.assertNotNull(this);
        keep(alive);
        g.aAh().azQ().add(this);
        ((c) g.af(c.class)).aSX().add(this);
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.a(this);
        }
        this.roomId = getIntent().getStringExtra("RoomInfo_Id");
        this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
        this.guk = true;
        this.dRx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.gtO = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.gul = getIntent().getBooleanExtra("fromChatting", false);
        this.gum = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
        this.guu = getPackageName() + "_preferences";
        if (this.dRx) {
            this.gtd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
            if (this.gtd != null) {
                this.guf = this.gtd.bjf(z.aTY());
            }
        }
        initView();
        if (this.dRx) {
            final AnonymousClass20 r0 = new ay.b.a() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass20 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(final String str, boolean z) {
                    AppMethodBeat.i(12534);
                    if (z && ChatroomInfoUI.this.roomId.equals(str)) {
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass20.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(12532);
                                ((c) g.af(c.class)).aSX().z(str, System.currentTimeMillis());
                                AppMethodBeat.o(12532);
                            }

                            public final String toString() {
                                AppMethodBeat.i(12533);
                                String str = super.toString() + "|getContactCallBack";
                                AppMethodBeat.o(12533);
                                return str;
                            }
                        });
                    }
                    AppMethodBeat.o(12534);
                }
            };
            if (this.gtd == null) {
                ay.a.iDq.a(this.roomId, "", r0);
                AppMethodBeat.o(12562);
                return;
            } else if (System.currentTimeMillis() - this.gtd.field_modifytime >= Util.MILLSECONDS_OF_DAY) {
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass24 */

                    public final String toString() {
                        AppMethodBeat.i(12544);
                        String str = super.toString() + "|getContactCallBack2";
                        AppMethodBeat.o(12544);
                        return str;
                    }

                    public final void run() {
                        AppMethodBeat.i(12543);
                        ay.a.iDq.a(ChatroomInfoUI.this.gtd.field_chatroomname, "", r0);
                        AppMethodBeat.o(12543);
                    }
                });
            }
        }
        AppMethodBeat.o(12562);
    }

    private void amq() {
        AppMethodBeat.i(12563);
        Log.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", this.roomId);
        com.tencent.mm.roomsdk.a.c.a Dt = com.tencent.mm.roomsdk.a.b.bhF(this.roomId).Dt(this.roomId);
        Dt.b(new com.tencent.mm.roomsdk.a.b.b() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass29 */

            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(12556);
                if (ChatroomInfoUI.this.gtd != null) {
                    ChatroomInfoUI.this.gug = ChatroomInfoUI.this.gtd.bax().size();
                }
                if ((!ChatroomInfoUI.d(ChatroomInfoUI.this) && ChatroomInfoUI.this.gug >= r.MAX_COUNT) || (ChatroomInfoUI.d(ChatroomInfoUI.this) && ChatroomInfoUI.this.gug >= r.MAX_COUNT - 1)) {
                    ChatroomInfoUI.this.screen.m38do("see_room_member", false);
                    ChatroomInfoUI.this.gtR.setTitle(ChatroomInfoUI.this.getString(R.string.gha));
                }
                ChatroomInfoUI.h(ChatroomInfoUI.this);
                ChatroomInfoUI.i(ChatroomInfoUI.this);
                ChatroomInfoUI.j(ChatroomInfoUI.this);
                AppMethodBeat.o(12556);
            }
        });
        Dt.aJu();
        AppMethodBeat.o(12563);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        boolean z;
        String str;
        AppMethodBeat.i(12564);
        super.onResume();
        this.screen.notifyDataSetChanged();
        if (this.gtd == null || this.gtd.gBy() == null) {
            z = false;
        } else {
            z = v.Ih(this.gtd.field_chatroomname);
            Log.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", this.gtd.field_chatroomname, Integer.valueOf(this.gtd.field_chatroomVersion), Integer.valueOf(this.gtd.field_oldChatroomVersion), this.gtd.field_roomowner);
        }
        if (v.HX(this.roomId) || z) {
            amq();
        }
        amz();
        updateTitle();
        amy();
        if (this.dRx) {
            amA();
            if (this.contact != null) {
                this.gtd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
                if (this.gtd == null) {
                    str = "";
                } else {
                    str = this.gtd.field_selfDisplayName;
                }
                if (Util.isNullOrNil(str)) {
                    str = z.aUa();
                }
                if (!Util.isNullOrNil(str)) {
                    this.gtY.gLI();
                    this.gtY.OYK = com.tencent.mm.cb.a.aG(getContext(), R.dimen.kn);
                    KeyValuePreference keyValuePreference = this.gtY;
                    if (str.length() <= 0) {
                        str = getString(R.string.gu1);
                    }
                    keyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, str));
                } else {
                    this.gtY.setSummary("");
                }
                if (this.screen != null) {
                    this.screen.notifyDataSetChanged();
                }
            }
            if (!(this.contact == null || this.gtZ == null)) {
                this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
                this.gtZ.gLI();
                if (as.bjq(this.roomId)) {
                    this.screen.e(this.gtZ);
                } else if (!Util.isNullOrNil(this.contact.field_conRemark)) {
                    this.gtZ.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, this.contact.field_conRemark));
                    if (this.screen != null) {
                        this.screen.notifyDataSetChanged();
                    }
                } else {
                    this.gtZ.setSummary("");
                }
            }
        }
        if (this.guk) {
            amx();
            this.guk = false;
        }
        String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.guq) {
            if (!Util.isNullOrNil(stringExtra)) {
                DF(stringExtra);
            }
            this.guq = true;
        }
        if (!Util.isNullOrNil(stringExtra) && stringExtra.equals("room_notify_new_notice") && !this.guq) {
            DF("room_card");
            this.guq = true;
        }
        com.tencent.mm.plugin.newtips.a.exl().TB(26);
        Log.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", Boolean.valueOf(this.gum));
        if (this.gum) {
            this.gum = false;
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass26 */

                public final void run() {
                    AppMethodBeat.i(194091);
                    ChatroomInfoUI.b(ChatroomInfoUI.this, "room_notify_new_msg");
                    ChatroomInfoUI.this.gun = true;
                    AppMethodBeat.o(194091);
                }
            }, 50);
        }
        AppMethodBeat.o(12564);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(12565);
        super.onConfigurationChanged(configuration);
        this.gtU.notifyChanged();
        AppMethodBeat.o(12565);
    }

    private void DF(String str) {
        AppMethodBeat.i(12566);
        final int bmj = this.screen.bmj(str);
        ListView listView = getListView();
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(bmj, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(listView, a2.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        listView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(listView, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "MatteHighLightItem", "(Ljava/lang/String;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        new MMHandler().postDelayed(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass31 */

            public final void run() {
                AppMethodBeat.i(12558);
                View a2 = ((com.tencent.mm.ui.base.preference.a) ChatroomInfoUI.this.screen).a(bmj, ChatroomInfoUI.this.getListView());
                if (a2 != null) {
                    com.tencent.mm.ui.i.a.c(ChatroomInfoUI.this.getContext(), a2);
                }
                AppMethodBeat.o(12558);
            }
        }, 10);
        AppMethodBeat.o(12566);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12567);
        super.onPause();
        if (this.gui && this.dRx) {
            if (this.gtd == null) {
                AppMethodBeat.o(12567);
                return;
            }
            v.a(this.roomId, this.gtd, this.guc);
        }
        AppMethodBeat.o(12567);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(12569);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 1:
                if (i3 != -1) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.v) g.af(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Qm(3);
                    AppMethodBeat.o(12569);
                    return;
                } else if (intent == null) {
                    AppMethodBeat.o(12569);
                    return;
                } else {
                    long longExtra = intent.getLongExtra("select_record_fake_msg_id", 0);
                    new com.tencent.mm.chatroom.g.a(this, this.roomId, intent.getStringExtra("Select_Contact"), (LocalHistoryInfo) intent.getParcelableExtra("select_record_msg_info"), longExtra, this);
                    AppMethodBeat.o(12569);
                    return;
                }
            case 2:
                if (i3 == -1) {
                    finish();
                    AppMethodBeat.o(12569);
                    return;
                }
                AppMethodBeat.o(12569);
                return;
            case 3:
            default:
                AppMethodBeat.o(12569);
                return;
            case 4:
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("room_name");
                    if (!Util.isNullOrNil(stringExtra)) {
                        EventCenter.instance.publish(new yr());
                        this.contact.setNickname(stringExtra);
                        ((l) g.af(l.class)).aSN().ao(this.contact);
                        amA();
                    }
                    AppMethodBeat.o(12569);
                    return;
                }
                AppMethodBeat.o(12569);
                return;
            case 5:
                if (i3 == 0) {
                    this.gus = -1;
                    AppMethodBeat.o(12569);
                    return;
                }
                AppMethodBeat.o(12569);
                return;
            case 6:
                if (i3 == -1) {
                    amz();
                }
                AppMethodBeat.o(12569);
                return;
            case 7:
                if (intent == null) {
                    AppMethodBeat.o(12569);
                    return;
                }
                String stringExtra2 = intent.getStringExtra("Select_Contact");
                if (stringExtra2 == null || stringExtra2.equals("")) {
                    AppMethodBeat.o(12569);
                    return;
                }
                final com.tencent.mm.roomsdk.a.c.a a2 = com.tencent.mm.roomsdk.a.b.bhF(this.roomId).a(this.roomId, Util.stringsToList(stringExtra2.split(",")), 0);
                a2.b(new com.tencent.mm.roomsdk.a.b.b() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass17 */

                    @Override // com.tencent.mm.roomsdk.a.b.a
                    public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                        AppMethodBeat.i(194081);
                        ChatroomInfoUI.this.ami();
                        ChatroomInfoUI.this.amj();
                        AppMethodBeat.o(194081);
                    }
                });
                a2.c(new com.tencent.mm.roomsdk.a.b.b() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass18 */

                    @Override // com.tencent.mm.roomsdk.a.b.a
                    public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                        AppMethodBeat.i(194082);
                        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                        if (Dk != null) {
                            Dk.a(ChatroomInfoUI.this, null, null);
                            AppMethodBeat.o(194082);
                            return;
                        }
                        if (i3 == -66) {
                            h.c(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.string.bl8), ChatroomInfoUI.this.getString(R.string.zb), true);
                        } else {
                            h.c(ChatroomInfoUI.this, Util.nullAs(str, ChatroomInfoUI.this.getString(R.string.bl9)), ChatroomInfoUI.this.getString(R.string.zb), true);
                        }
                        ChatroomInfoUI.this.ami();
                        ChatroomInfoUI.this.amj();
                        Log.i("MicroMsg.ActionCallbackFunc", "[delChatroomMember] onResult errType:%s errCode:%s", Integer.valueOf(i2), Integer.valueOf(i3));
                        AppMethodBeat.o(194082);
                    }
                });
                a2.a(this, getString(R.string.zb), getString(R.string.g6m), true, true, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass19 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(194083);
                        a2.cancel();
                        AppMethodBeat.o(194083);
                    }
                });
                AppMethodBeat.o(12569);
                return;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x045b  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 1293
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.chatroom.ui.ChatroomInfoUI.initView():void");
    }

    static class a implements DialogInterface.OnCancelListener {
        a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(12560);
            boolean unused = ChatroomInfoUI.guv = true;
            AppMethodBeat.o(12560);
        }
    }

    private void amr() {
        AppMethodBeat.i(194100);
        if (this.gtN == null) {
            getString(R.string.zb);
            this.gtN = h.a((Context) this, getString(R.string.a06), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass14 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(194076);
                    ChatroomInfoUI.this.isDeleteCancel = true;
                    AppMethodBeat.o(194076);
                }
            });
            AppMethodBeat.o(194100);
            return;
        }
        this.gtN.show();
        AppMethodBeat.o(194100);
    }

    private void ams() {
        AppMethodBeat.i(194101);
        if (this.gtN != null) {
            this.gtN.dismiss();
        }
        AppMethodBeat.o(194101);
    }

    public final void DG(final String str) {
        AppMethodBeat.i(194102);
        Log.i("MicroMsg.ChatroomInfoUI", "delete chatroom %s", str);
        this.guw = com.tencent.mm.roomsdk.a.b.bhF(str).Du(str);
        this.guw.d(new com.tencent.mm.roomsdk.a.b.e() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass15 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.e eVar) {
                AppMethodBeat.i(194078);
                com.tencent.mm.roomsdk.a.b.e eVar2 = eVar;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(i2);
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = Util.nullAs(str, "");
                objArr[3] = eVar2 != null ? Integer.valueOf(eVar2.ret) : BuildConfig.COMMAND;
                Log.i("MicroMsg.ChatroomInfoUI", "deleteChatroomImp errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                if (!ab.Ix(ChatroomInfoUI.this.roomId)) {
                    ChatroomInfoUI.w(ChatroomInfoUI.this);
                    if (this.ret == 0) {
                        ChatroomInfoUI.x(ChatroomInfoUI.this);
                        AppMethodBeat.o(194078);
                        return;
                    }
                } else if (this.ret == 0) {
                    afc afc = new afc();
                    afc.Lqk = new dqi().bhy(Util.nullAsNil(str));
                    ChatroomInfoUI.this.guw = new d();
                    ((d) ChatroomInfoUI.this.guw).a(new k.a(7, afc));
                    ChatroomInfoUI.this.guw.d(new com.tencent.mm.roomsdk.a.b.e() {
                        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass15.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                        @Override // com.tencent.mm.roomsdk.a.b.a
                        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.e eVar) {
                            AppMethodBeat.i(194077);
                            com.tencent.mm.roomsdk.a.b.e eVar2 = eVar;
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(i2);
                            objArr[1] = Integer.valueOf(i3);
                            objArr[2] = Util.nullAs(str, "");
                            objArr[3] = eVar2 != null ? Integer.valueOf(eVar2.ret) : BuildConfig.COMMAND;
                            Log.i("MicroMsg.ChatroomInfoUI", "deleteChatroomImp2 errType:%s errCode:%s errMsg:%s ret:%s", objArr);
                            ChatroomInfoUI.w(ChatroomInfoUI.this);
                            if (this.ret == 0) {
                                ChatroomInfoUI.x(ChatroomInfoUI.this);
                                AppMethodBeat.o(194077);
                                return;
                            }
                            ChatroomInfoUI.a(ChatroomInfoUI.this, eVar2);
                            AppMethodBeat.o(194077);
                        }
                    }).aJu();
                    AppMethodBeat.o(194078);
                    return;
                } else {
                    ChatroomInfoUI.w(ChatroomInfoUI.this);
                }
                ChatroomInfoUI.a(ChatroomInfoUI.this, eVar2);
                AppMethodBeat.o(194078);
            }
        }).aJu();
        AppMethodBeat.o(194102);
    }

    private void amt() {
        AppMethodBeat.i(12573);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 7, 1, true);
        List<String> Ic = v.Ic(this.roomId);
        String listToString = Util.listToString(Ic, ",");
        if (Ic != null) {
            this.gug = Ic.size();
        }
        Intent intent = new Intent();
        intent.putExtra("titile", getString(R.string.g4));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", of(u.PWT));
        intent.putExtra("always_select_contact", listToString);
        intent.putExtra("scene", 3);
        boolean IB = ab.IB(this.contact.field_username);
        if (!as.bjq(this.contact.field_username) && !IB) {
            intent.putExtra("without_openim", true);
        }
        intent.putExtra("KBlockOpenImFav", ab.Ix(this.roomId) && !IB);
        intent.putExtra("create_group_recommend", true);
        intent.putExtra("is_select_record_msg_mode", ab.Ix(this.roomId));
        intent.putExtra("menu_mode", 2);
        intent.putExtra("chatroomName", this.roomId);
        com.tencent.mm.br.c.c(this, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(12573);
    }

    private void amu() {
        AppMethodBeat.i(12574);
        if (this.dRx) {
            amt();
            AppMethodBeat.o(12574);
            return;
        }
        amC();
        AppMethodBeat.o(12574);
    }

    private int of(int i2) {
        AppMethodBeat.i(12575);
        if (!u.gVd()) {
            AppMethodBeat.o(12575);
            return i2;
        } else if (this.contact != null) {
            String str = this.contact.field_username;
            if (as.bjp(str) || as.bjq(str) || ab.IB(str)) {
                int i3 = i2 | TPMediaCodecProfileLevel.HEVCMainTierLevel62;
                AppMethodBeat.o(12575);
                return i3;
            }
            int i4 = i2 & -16777217;
            AppMethodBeat.o(12575);
            return i4;
        } else {
            AppMethodBeat.o(12575);
            return i2;
        }
    }

    private void amv() {
        AppMethodBeat.i(12576);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 8, 1, true);
        List<String> Ic = v.Ic(this.roomId);
        String listToString = Util.listToString(Ic, ",");
        this.gug = Ic.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.roomId);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", listToString);
        intent.putExtra("room_member_count", this.gug);
        intent.putExtra("Is_RoomOwner", this.gue);
        intent.putExtra("list_attr", u.PWT);
        intent.putExtra("room_name", this.contact.field_username);
        intent.putExtra("room_owner_name", this.gtd.field_roomowner);
        intent.setClass(this, SelectDelMemberUI.class);
        startActivityForResult(intent, 7);
        AppMethodBeat.o(12576);
    }

    @Override // com.tencent.mm.chatroom.g.a.b
    public final void amj() {
        AppMethodBeat.i(194103);
        updateTitle();
        if (this.gtd != null) {
            this.gug = this.gtd.bax().size();
        }
        if ((!this.gue && this.gug >= r.MAX_COUNT) || (this.gue && this.gug >= r.MAX_COUNT - 1)) {
            this.screen.m38do("see_room_member", false);
            this.gtR.setTitle(getString(R.string.gha));
        }
        AppMethodBeat.o(194103);
    }

    private String DH(String str) {
        AppMethodBeat.i(12578);
        if (this.gtd == null) {
            AppMethodBeat.o(12578);
            return null;
        }
        String displayName = this.gtd.getDisplayName(str);
        AppMethodBeat.o(12578);
        return displayName;
    }

    private String amw() {
        String str;
        AppMethodBeat.i(12579);
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.gtd.field_roomowner);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            str = null;
        } else {
            str = Kn.field_conRemark;
        }
        if (Util.isNullOrNil(str)) {
            str = DH(this.gtd.field_roomowner);
        }
        if (Util.isNullOrNil(str) && Kn != null && ((int) Kn.gMZ) > 0) {
            str = Kn.arI();
        }
        if (Util.isNullOrNil(str)) {
            str = this.gtd.field_roomowner;
        }
        AppMethodBeat.o(12579);
        return str;
    }

    private void updateTitle() {
        AppMethodBeat.i(12583);
        if (this.dRx) {
            this.gug = v.Ie(this.roomId);
            if (this.gug == 0) {
                setMMTitle(getString(R.string.g_b));
                AppMethodBeat.o(12583);
                return;
            }
            setMMTitle(getString(R.string.dea, new Object[]{getString(R.string.g_b), Integer.valueOf(this.gug)}));
        }
        AppMethodBeat.o(12583);
    }

    private void amx() {
        AppMethodBeat.i(12584);
        if (this.gtU != null) {
            if (this.dRx) {
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass21 */

                    public final void run() {
                        final LinkedList linkedList;
                        AppMethodBeat.i(194085);
                        if (ChatroomInfoUI.this.gtd == null) {
                            Log.w("MicroMsg.ChatroomInfoUI", "[updateRoomPref] member == null");
                            AppMethodBeat.o(194085);
                            return;
                        }
                        ChatroomInfoUI.this.gux = ((c) g.af(c.class)).aSX().Kg(ChatroomInfoUI.this.roomId);
                        List<String> Ic = v.Ic(ChatroomInfoUI.this.roomId);
                        if (Ic != null) {
                            ChatroomInfoUI.this.gug = Ic.size();
                            linkedList = Ic;
                        } else {
                            LinkedList linkedList2 = new LinkedList();
                            ChatroomInfoUI.this.gug = 0;
                            linkedList = linkedList2;
                        }
                        LinkedList linkedList3 = new LinkedList();
                        for (String str : linkedList) {
                            if (ChatroomInfoUI.this.gtd.bjf(str) || ChatroomInfoUI.this.gtd.JO(str)) {
                                linkedList3.add(str);
                            }
                        }
                        if (ChatroomInfoUI.this.gug > r.MAX_COUNT + 1 && linkedList != null) {
                            linkedList = linkedList.subList(0, r.MAX_COUNT + 1);
                            Iterator it = linkedList3.iterator();
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                if (!linkedList.contains(str2)) {
                                    linkedList.add(0, str2);
                                }
                            }
                        }
                        com.tencent.f.h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass21.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(194084);
                                if (ChatroomInfoUI.this.gug <= 1) {
                                    ChatroomInfoUI.this.screen.m38do("del_selector_btn", true);
                                    ChatroomInfoUI.this.gtU.zU(true).zV(false).gpH();
                                } else {
                                    ChatroomInfoUI.this.gtU.zU(true).zV(ChatroomInfoUI.d(ChatroomInfoUI.this)).gpH();
                                }
                                ChatroomInfoUI.this.gtU.H(ChatroomInfoUI.this.roomId, linkedList);
                                ChatroomInfoUI.this.gtU.zT(true);
                                AppMethodBeat.o(194084);
                            }
                        });
                        AppMethodBeat.o(194085);
                    }
                });
                AppMethodBeat.o(12584);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.roomId);
            this.gtU.H(this.roomId, linkedList);
        }
        AppMethodBeat.o(12584);
    }

    private void amy() {
        AppMethodBeat.i(12586);
        if (this.sp == null) {
            this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.contact != null) {
            if (this.dRx) {
                this.guh = this.contact.fuH == 0;
            } else if (!this.gtO) {
                this.guh = this.contact.Zx();
            }
        }
        if (this.guh) {
            setTitleMuteIconVisibility(0);
            if (this.gtV != null) {
                this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.gtV != null) {
                this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(12586);
    }

    private void amz() {
        AppMethodBeat.i(12587);
        if (!(this.contact == null || this.gtP == null)) {
            String Ig = v.Ig(this.roomId);
            if (Ig == null || Ig.length() <= 0) {
                this.gtP.dEF = false;
            } else {
                this.gtP.dEF = true;
                this.gtP.gCg = com.tencent.mm.pluginsdk.ui.span.l.c(this, Ig);
            }
            this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
            if (amB()) {
                String arJ = this.contact.arJ();
                RoomCardPreference roomCardPreference = this.gtP;
                if (arJ.length() <= 0) {
                    arJ = getString(R.string.gu1);
                }
                roomCardPreference.gCf = com.tencent.mm.pluginsdk.ui.span.l.c(this, arJ);
            } else {
                this.gtP.gCf = getString(R.string.g7e);
            }
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(12587);
    }

    private void amA() {
        AppMethodBeat.i(12588);
        if (!(this.contact == null || this.gtQ == null)) {
            this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
            if (amB()) {
                String arI = this.contact.arI();
                Preference preference = this.gtQ;
                if (arI.length() <= 0) {
                    arI = getString(R.string.gu1);
                }
                preference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, arI));
                if (this.screen != null) {
                    this.screen.notifyDataSetChanged();
                }
                AppMethodBeat.o(12588);
                return;
            }
            this.gtQ.setSummary(getString(R.string.g7e));
        }
        AppMethodBeat.o(12588);
    }

    private boolean amB() {
        AppMethodBeat.i(12589);
        String str = this.contact.field_nickname;
        if (Util.isNullOrNil(str) || str.length() > 50) {
            AppMethodBeat.o(12589);
            return false;
        }
        AppMethodBeat.o(12589);
        return true;
    }

    public static ArrayList<as> X(List<cho> list) {
        AppMethodBeat.i(12590);
        ArrayList<as> arrayList = new ArrayList<>();
        if (list == null) {
            AppMethodBeat.o(12590);
            return arrayList;
        }
        for (cho cho : list) {
            as asVar = new as();
            asVar.setUsername(cho.UserName);
            asVar.setNickname(cho.oUJ);
            arrayList.add(asVar);
        }
        AppMethodBeat.o(12590);
        return arrayList;
    }

    private void amC() {
        AppMethodBeat.i(12591);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10170, "1");
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.roomId);
        linkedList.add(z.aTY());
        String listToString = Util.listToString(linkedList, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", getString(R.string.g2));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", of(u.PWU));
        intent.putExtra("always_select_contact", listToString);
        intent.putExtra("create_group_recommend", true);
        com.tencent.mm.br.c.f(this, ".ui.contact.SelectContactUI", intent);
        AppMethodBeat.o(12591);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(12594);
        Log.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType());
        Log.d("MicroMsg.ChatroomInfoUI", "pre is " + this.gug);
        this.gug = v.Ie(this.roomId);
        Log.d("MicroMsg.ChatroomInfoUI", "now is " + this.gug);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(12594);
    }

    @Override // com.tencent.mm.chatroom.g.a.b
    public final void ami() {
        boolean z;
        AppMethodBeat.i(194104);
        if (this.gtU != null) {
            if (this.dRx) {
                amx();
            } else if (!this.gtO) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.roomId);
                this.gtU.H(this.roomId, linkedList);
            }
            this.gtU.notifyChanged();
        }
        boolean akx = ((c) g.af(c.class)).akx(this.roomId);
        if (!amD()) {
            this.screen.m38do("manage_room", true);
            f fVar = this.screen;
            if (!akx) {
                z = true;
            } else {
                z = false;
            }
            fVar.m38do("room_manager_view", z);
        } else {
            this.screen.m38do("room_manager_view", true);
            this.screen.m38do("manage_room", false);
        }
        if ((amD() || this.gug < r.MAX_COUNT) && (!amD() || this.gug < r.MAX_COUNT - 1)) {
            this.screen.m38do("see_room_member", true);
        } else {
            this.screen.m38do("see_room_member", false);
            this.gtR.setTitle(getString(R.string.gha));
        }
        if (ab.Iy(this.roomId)) {
            this.screen.m38do("room_manager_view", true);
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(194104);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(12596);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(12596);
            return;
        }
        onNotifyChange((String) obj, null);
        AppMethodBeat.o(12596);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(12597);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(12597);
        } else if (!ab.Eq(str)) {
            Log.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
            AppMethodBeat.o(12597);
        } else {
            Log.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(str)));
            if (this.dRx && str.equals(this.roomId)) {
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass25 */

                    public final void run() {
                        AppMethodBeat.i(194089);
                        ChatroomInfoUI.this.gtd = ((c) g.af(c.class)).aSX().Kd(ChatroomInfoUI.this.roomId);
                        if (ChatroomInfoUI.this.gtd == null) {
                            Log.e("MicroMsg.ChatroomInfoUI", "member is null");
                            AppMethodBeat.o(194089);
                        } else if (Util.isNullOrNil(ChatroomInfoUI.this.gtd.field_roomowner)) {
                            Log.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
                            AppMethodBeat.o(194089);
                        } else {
                            ChatroomInfoUI.this.handler.sendEmptyMessage(0);
                            ChatroomInfoUI.this.gue = ChatroomInfoUI.this.gtd.field_roomowner.equals(z.aTY());
                            ChatroomInfoUI.this.guf = ChatroomInfoUI.this.gtd.bjf(z.aTY());
                            ChatroomInfoUI.this.gtU.beT(ChatroomInfoUI.this.gtd.field_roomowner);
                            AppMethodBeat.o(194089);
                        }
                    }

                    public final String toString() {
                        AppMethodBeat.i(194090);
                        String str = super.toString() + "|onNotifyChange";
                        AppMethodBeat.o(194090);
                        return str;
                    }
                });
            }
            ami();
            AppMethodBeat.o(12597);
        }
    }

    @Override // com.tencent.mm.bh.a
    public final void h(String str, String str2, String str3) {
        AppMethodBeat.i(12598);
        if (str.equals(this.roomId) && this.gtU != null) {
            this.gtU.notifyChanged();
        }
        AppMethodBeat.o(12598);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(12599);
        com.tencent.mm.ui.base.preference.a aVar = new com.tencent.mm.ui.base.preference.a(this, getListView(), sharedPreferences);
        AppMethodBeat.o(12599);
        return aVar;
    }

    private boolean amD() {
        AppMethodBeat.i(12600);
        if (this.gtd == null || !this.gtd.amD()) {
            AppMethodBeat.o(12600);
            return false;
        }
        AppMethodBeat.o(12600);
        return true;
    }

    public static class LocalHistoryInfo implements Parcelable {
        public static final Parcelable.Creator<LocalHistoryInfo> CREATOR = new Parcelable.Creator<LocalHistoryInfo>() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LocalHistoryInfo[] newArray(int i2) {
                return new LocalHistoryInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LocalHistoryInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(194095);
                LocalHistoryInfo localHistoryInfo = new LocalHistoryInfo(parcel);
                AppMethodBeat.o(194095);
                return localHistoryInfo;
            }
        };
        public String aeskey;
        public String fileid;
        public String filemd5;
        public int guR;
        public int guS;

        public String toString() {
            AppMethodBeat.i(194096);
            String str = "LocalHistoryInfo{fileid='" + this.fileid + '\'' + ", aeskey='" + this.aeskey + '\'' + ", filemd5='" + this.filemd5 + '\'' + ", filelength=" + this.guR + ", msgsount=" + this.guS + '}';
            AppMethodBeat.o(194096);
            return str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(194097);
            parcel.writeString(this.fileid);
            parcel.writeString(this.aeskey);
            parcel.writeString(this.filemd5);
            parcel.writeInt(this.guR);
            parcel.writeInt(this.guS);
            AppMethodBeat.o(194097);
        }

        public LocalHistoryInfo() {
        }

        protected LocalHistoryInfo(Parcel parcel) {
            AppMethodBeat.i(194098);
            this.fileid = parcel.readString();
            this.aeskey = parcel.readString();
            this.filemd5 = parcel.readString();
            this.guR = parcel.readInt();
            this.guS = parcel.readInt();
            AppMethodBeat.o(194098);
        }

        static {
            AppMethodBeat.i(194099);
            AppMethodBeat.o(194099);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12568);
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.a(this);
        }
        g.aAh().azQ().remove(this);
        com.tencent.mm.ui.i.a.dismiss();
        g.aAg().hqi.b(480, this);
        EventCenter.instance.removeListener(this.gur);
        b.b(nh.class.getName(), this.guy);
        if (g.aAc()) {
            ((l) g.af(l.class)).aSN().remove(this);
            ((c) g.af(c.class)).aSX().remove(this);
        }
        if (com.tencent.mm.bh.g.jpy != null) {
            com.tencent.mm.bh.g.jpy.b(this);
        }
        if (this.guz != null) {
            this.guz.stopTimer();
        }
        super.onDestroy();
        AppMethodBeat.o(12568);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int i6 = 1;
        AppMethodBeat.i(12571);
        String str = preference.mKey;
        if (str.equals("room_name")) {
            String value = com.tencent.mm.n.h.aqJ().getValue("ChatRoomOwnerModTopic");
            if (!Util.isNullOrNil(value)) {
                i5 = Util.safeParseInt(value);
            } else {
                i5 = 0;
            }
            if (this.gtd == null || Util.isNullOrNil(this.gtd.field_roomowner) || i5 <= 0 || amD() || i5 >= this.gug) {
                Intent intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("Key_Scenen", 1);
                intent.putExtra("Key_Room_Id", this.roomId);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 3, 1, true);
            } else {
                h.a(this, getString(R.string.g9p, new Object[]{amw()}), (String) null, getString(R.string.w1), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        } else if (str.equals("room_upgrade_entry")) {
            if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChatroomGlobalSwitch"), 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", getString(R.string.awk, new Object[]{LocaleUtil.getApplicationLanguage()}));
                intent2.putExtra("geta8key_username", z.aTY());
                intent2.putExtra("showShare", false);
                com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
            }
        } else if (str.equals("room_qr_code")) {
            if (ab.Iy(this.roomId)) {
                gq gqVar = new gq();
                gqVar.us(this.roomId);
                gqVar.erw = 6;
                gqVar.bfK();
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 5, 1, true);
            Intent intent3 = new Intent();
            intent3.putExtra("from_userName", this.roomId);
            com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SelfQRCodeUI", intent3);
        } else if (str.equals("room_card")) {
            if (this.gtd == null) {
                Log.w("MicroMsg.ChatroomInfoUI", "goToRoomCardUI member == null");
            } else {
                boolean bjf = this.gtd.bjf(z.aTY());
                if (!Util.isNullOrNil(v.Ig(this.roomId)) || amD()) {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, RoomCardUI.class);
                    intent4.putExtra("RoomInfo_Id", this.roomId);
                    intent4.putExtra("room_name", this.gtP.gCf.toString());
                    this.gug = v.Ic(this.roomId).size();
                    intent4.putExtra("room_member_count", this.gug);
                    intent4.putExtra("room_owner_name", amw());
                    intent4.putExtra("room_notice", v.Ig(this.roomId));
                    intent4.putExtra("room_notice_publish_time", v.Ij(this.roomId));
                    intent4.putExtra("room_notice_editor", v.Ii(this.roomId));
                    intent4.putExtra("Is_RoomOwner", this.gue);
                    intent4.putExtra("Is_RoomManager", bjf);
                    startActivityForResult(intent4, 6);
                } else {
                    h.c(this, getString(R.string.g67), null, getString(R.string.g68), null, null, null);
                }
            }
        } else if (str.equals("room_notify_new_msg")) {
            this.guh = !this.guh;
            if (this.dRx) {
                if (this.guh) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                com.tencent.mm.roomsdk.a.b.bhF(this.roomId).I(this.roomId, i4).aJu();
                this.contact = ((l) g.af(l.class)).aSN().Kn(this.roomId);
                this.contact.nm(i4);
                ((l) g.af(l.class)).aSN().c(this.roomId, this.contact);
                if (this.gun) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(869, this.guh ? 14 : 15);
                }
            }
            com.tencent.mm.modelstat.b bVar = com.tencent.mm.modelstat.b.jmd;
            String str2 = this.roomId;
            boolean z4 = this.guh;
            if (bVar.bfZ() && bVar.fP(str2)) {
                IMBehavior iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z4) {
                    i6 = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i6;
                synchronized (bVar.lock) {
                    try {
                        bVar.jmc.oplist_.add(iMBehavior);
                    } catch (Throwable th) {
                        AppMethodBeat.o(12571);
                        throw th;
                    }
                }
            }
            amy();
        } else if (str.equals("room_save_to_contact")) {
            if (this.sp == null) {
                this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            as Kn = ((l) g.af(l.class)).aSN().Kn(this.roomId);
            if (Kn != null) {
                boolean oR = com.tencent.mm.contact.c.oR(Kn.field_type);
                this.sp.edit().putBoolean("room_save_to_contact", !oR).commit();
                if (oR) {
                    Kn.aqR();
                    com.tencent.mm.roomsdk.a.b.bhF(this.roomId).a(Kn, false);
                    h.cD(this, getString(R.string.g8x));
                    com.tencent.mm.modelstat.b.jmd.W(this.roomId, false);
                } else {
                    com.tencent.mm.roomsdk.a.b.bhF(this.roomId).a(Kn, true);
                    h.cD(this, getString(R.string.g9c));
                    com.tencent.mm.modelstat.b.jmd.W(this.roomId, true);
                }
                this.screen.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.guu, 0);
            if (this.contact != null) {
                if (((l) g.af(l.class)).aST().bkg(this.contact.field_username)) {
                    ab.F(this.contact.field_username, true);
                    com.tencent.mm.modelstat.b.jmd.c(false, this.roomId, false);
                } else {
                    ab.E(this.contact.field_username, true);
                    com.tencent.mm.modelstat.b.jmd.c(false, this.roomId, true);
                }
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", ((l) g.af(l.class)).aST().bkg(this.contact.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            Intent intent5 = new Intent();
            intent5.setClass(this, ModRemarkRoomNameUI.class);
            intent5.putExtra("Key_Scenen", 3);
            intent5.putExtra("Key_Room_Id", this.roomId);
            startActivityForResult(intent5, 4);
        } else if (str.equals("room_msg_show_username")) {
            SharedPreferences.Editor edit = getSharedPreferences(this.guu, 0).edit();
            if (!this.guc) {
                z = true;
            } else {
                z = false;
            }
            edit.putBoolean("room_msg_show_username", z).commit();
            if (!this.guc) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.guc = z2;
            this.gui = true;
        } else if (str.equals("room_set_chatting_background")) {
            if (ab.Iy(this.roomId)) {
                gq gqVar2 = new gq();
                gqVar2.us(this.roomId);
                gqVar2.erw = 9;
                gqVar2.bfK();
            }
            Intent intent6 = new Intent();
            intent6.putExtra("isApplyToAll", false);
            intent6.putExtra(ch.COL_USERNAME, this.contact.field_username);
            com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent6, 2);
        } else if (str.equals("room_search_chatting_content")) {
            if (ab.Iy(this.roomId)) {
                gq gqVar3 = new gq();
                gqVar3.us(this.roomId);
                gqVar3.erw = 8;
                gqVar3.bfK();
            }
            Intent intent7 = new Intent();
            intent7.putExtra("detail_username", this.roomId);
            com.tencent.mm.plugin.fts.a.d.d(this, ".ui.FTSChattingConvUI", intent7);
            if (this.gtd == null || this.gtd.bax() == null) {
                i3 = 0;
            } else {
                i3 = this.gtd.bax().size();
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14569, 1, 0, 0, 0, 0, 0, 0, Integer.valueOf(i3), 1);
        } else if (str.equals("room_clear_chatting_history")) {
            if (ab.Iy(this.roomId)) {
                gq gqVar4 = new gq();
                gqVar4.us(this.roomId);
                gqVar4.erw = 11;
                gqVar4.bfK();
            }
            h.a(getContext(), getString(R.string.dei), "", getString(R.string.t2), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    String str;
                    AppMethodBeat.i(194070);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 3, 2, ChatroomInfoUI.this.roomId);
                    boolean unused = ChatroomInfoUI.guv = false;
                    ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
                    ChatroomInfoUI.this.getString(R.string.zb);
                    final q a2 = h.a((Context) chatroomInfoUI, ChatroomInfoUI.this.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new a());
                    if (!ChatroomInfoUI.guv) {
                        str = com.tencent.mm.pluginsdk.wallet.d.bfO(ChatroomInfoUI.this.contact.field_username);
                    } else {
                        str = null;
                    }
                    if (!Util.isNullOrNil(str)) {
                        a2.dismiss();
                        h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(R.string.iba, new Object[]{str}), null, ChatroomInfoUI.this.getString(R.string.dvh), ChatroomInfoUI.this.getString(R.string.b5r), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass7.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(194068);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 3, 4, ChatroomInfoUI.this.roomId);
                                ChatroomInfoUI.this.isDeleteCancel = true;
                                if (!ChatroomInfoUI.this.gul) {
                                    Intent intent = new Intent();
                                    intent.putExtra("Chat_User", ChatroomInfoUI.this.contact.field_username);
                                    intent.addFlags(67108864);
                                    com.tencent.mm.br.c.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                                    AppMethodBeat.o(194068);
                                    return;
                                }
                                ChatroomInfoUI.this.finish();
                                AppMethodBeat.o(194068);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass7.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(194069);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 3, 3, ChatroomInfoUI.this.roomId);
                                a2.show();
                                ChatroomInfoUI.this.isDeleteCancel = false;
                                ChatroomInfoUI.a(ChatroomInfoUI.this, a2);
                                AppMethodBeat.o(194069);
                            }
                        }, -1, R.color.cd);
                        AppMethodBeat.o(194070);
                        return;
                    }
                    ChatroomInfoUI.a(ChatroomInfoUI.this, a2);
                    AppMethodBeat.o(194070);
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
        } else if (str.equals("room_report_it")) {
            if (ab.Iy(this.roomId)) {
                gq gqVar5 = new gq();
                gqVar5.us(this.roomId);
                gqVar5.erw = 10;
                gqVar5.bfK();
            }
            Intent intent8 = new Intent();
            intent8.putExtra("k_username", this.roomId);
            intent8.putExtra("showShare", false);
            intent8.putExtra("rawUrl", String.format(e.C2115e.OyU, 36));
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", intent8);
            com.tencent.mm.modelstat.b bVar2 = com.tencent.mm.modelstat.b.jmd;
            String str3 = this.roomId;
            if (bVar2.bfZ() && bVar2.fP(str3)) {
                IMBehavior iMBehavior2 = new IMBehavior();
                iMBehavior2.opType = 1;
                iMBehavior2.chattingOp = new IMBehaviorChattingOP();
                iMBehavior2.chattingOp.expose = 1;
                synchronized (bVar2.lock) {
                    try {
                        bVar2.jmc.oplist_.add(iMBehavior2);
                    } finally {
                        AppMethodBeat.o(12571);
                    }
                }
            }
        } else if (str.equals("room_del_quit")) {
            Log.d("MicroMsg.ChatroomInfoUI", " quit " + this.roomId);
            xq xqVar = new xq();
            xqVar.edR.edT = true;
            EventCenter.instance.publish(xqVar);
            final boolean z5 = !Util.isNullOrNil(this.roomId) && this.roomId.equals(xqVar.edS.edV);
            if (z5) {
                Log.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.roomId);
            } else if (this.gue && this.gtd != null && this.gtd.bax().size() > 2) {
                h.a(this, "", new String[]{getString(R.string.g8l)}, "", new h.d() {
                    /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass9 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(194073);
                        switch (i2) {
                            case 0:
                                Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                                if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving()) {
                                    h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(R.string.av9), (String) null, ChatroomInfoUI.this.getString(R.string.w1), new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass9.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    });
                                    AppMethodBeat.o(194073);
                                    return;
                                }
                                if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                                    ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                                }
                                ChatroomInfoUI.t(ChatroomInfoUI.this);
                                ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFG(ChatroomInfoUI.this.roomId);
                                AppMethodBeat.o(194073);
                                return;
                            default:
                                Log.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                                AppMethodBeat.o(194073);
                                return;
                        }
                    }
                });
            }
            h.a(getContext(), getString(R.string.bl7), "", getString(R.string.x_), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(194074);
                    if (ChatroomInfoUI.this.roomId == null || ChatroomInfoUI.this.roomId.length() <= 0) {
                        Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                        AppMethodBeat.o(194074);
                        return;
                    }
                    if (z5) {
                        xq xqVar = new xq();
                        xqVar.edR.edU = true;
                        EventCenter.instance.publish(xqVar);
                    }
                    if (!((l) g.af(l.class)).aSN().bjN(ChatroomInfoUI.this.roomId)) {
                        Log.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.this.roomId + "] is not exist");
                        AppMethodBeat.o(194074);
                    } else if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving()) {
                        h.a(ChatroomInfoUI.this.getContext(), ChatroomInfoUI.this.getString(R.string.av9), (String) null, ChatroomInfoUI.this.getString(R.string.w1), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass10.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(194074);
                    } else {
                        if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving()) {
                            ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(ChatroomInfoUI.this.getContext());
                        }
                        ChatroomInfoUI.t(ChatroomInfoUI.this);
                        ((com.tencent.mm.plugin.multitalk.model.d) g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFG(ChatroomInfoUI.this.roomId);
                        AppMethodBeat.o(194074);
                    }
                }
            }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
        } else if (str.equals("add_selector_btn")) {
            amu();
        } else if (str.equals("del_selector_btn")) {
            amv();
        } else if (str.equals("see_room_member")) {
            Intent intent9 = new Intent();
            intent9.setClass(getContext(), SeeRoomMemberUI.class);
            intent9.putExtra("Block_list", z.aTY());
            List<String> Ic = v.Ic(this.roomId);
            if (Ic != null) {
                this.gug = Ic.size();
            }
            intent9.putExtra("Chatroom_member_list", Util.listToString(Ic, ","));
            intent9.putExtra("RoomInfo_Id", this.roomId);
            intent9.putExtra("room_owner_name", this.gtd.field_roomowner);
            intent9.putExtra("Is_RoomOwner", this.gue);
            intent9.putExtra("room_member_count", this.gug);
            intent9.putExtra("Add_address_titile", getString(R.string.g9g));
            if (this.dRx) {
                intent9.putExtra("Contact_Scene", 14);
            } else if (this.gtO) {
                intent9.putExtra("Contact_Scene", 44);
                if (!z.Im(this.contact.field_username)) {
                    intent9.putExtra("Contact_IsLBSFriend", true);
                }
            }
            View childAt = getListView().getChildAt(0);
            if (childAt == null) {
                i2 = 0;
            } else {
                i2 = -childAt.getTop();
            }
            intent9.putExtra("offset", i2);
            intent9.putExtra("first_pos", getListView().getFirstVisiblePosition());
            intent9.putExtra("room_name", this.contact.field_username);
            startActivityForResult(intent9, 5);
            this.gus = 5;
        } else if (str.equals("manage_room")) {
            if (this.guo) {
                com.tencent.mm.plugin.newtips.a.exl().TC(26);
            }
            Intent intent10 = new Intent();
            intent10.setClass(getContext(), ManageChatroomUI.class);
            intent10.putExtra("RoomInfo_Id", this.roomId);
            intent10.putExtra("room_owner_name", this.gtd.field_roomowner);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent10);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("chat_room_app_brand")) {
            if (ab.Iy(this.roomId)) {
                gq gqVar6 = new gq();
                gqVar6.us(this.roomId);
                gqVar6.erw = 7;
                gqVar6.bfK();
            }
            Intent intent11 = new Intent();
            intent11.putExtra("Chat_User", this.roomId);
            com.tencent.mm.br.c.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent11);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 25, 1, true);
        } else if (str.equals("room_manager_view")) {
            Intent intent12 = new Intent();
            intent12.setClass(getContext(), SeeRoomOwnerManagerUI.class);
            intent12.putExtra("RoomInfo_Id", this.roomId);
            intent12.putExtra("room_owner_name", this.gtd.field_roomowner);
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent12);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "goToOwnerManageChatroomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (!str.equals("chat_room_story_videos") && str.equals("room_remark")) {
            Intent intent13 = new Intent();
            intent13.setClass(this, ModRemarkRoomNameUI.class);
            intent13.putExtra("Key_Scenen", 2);
            intent13.putExtra("Key_Room_Id", this.roomId);
            com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent13);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl4.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl4.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "dealModChatroomRemark", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        return false;
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(12601);
        chatroomInfoUI.updateTitle();
        String Kg = ((c) g.af(c.class)).aSX().Kg(chatroomInfoUI.roomId);
        if (chatroomInfoUI.gux != null && !chatroomInfoUI.gux.equals(Kg)) {
            chatroomInfoUI.ami();
        }
        AppMethodBeat.o(12601);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, final ProgressDialog progressDialog) {
        AppMethodBeat.i(194107);
        aa.Dy(chatroomInfoUI.roomId);
        bp.a(chatroomInfoUI.contact.field_username, new bp.a() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass8 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(194071);
                boolean z = ChatroomInfoUI.guv;
                AppMethodBeat.o(194071);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(194072);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(194072);
            }
        });
        AppMethodBeat.o(194107);
    }

    static /* synthetic */ void t(ChatroomInfoUI chatroomInfoUI) {
        String str;
        AppMethodBeat.i(194108);
        aa.Dy(chatroomInfoUI.roomId);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 4, 2, chatroomInfoUI.roomId);
        long j2 = ((l) g.af(l.class)).eiy().aEw(chatroomInfoUI.roomId).field_msgSvrId;
        afk afk = new afk();
        afk.Lqk = new dqi().bhy(Util.nullAsNil(chatroomInfoUI.roomId));
        afk.Brn = j2;
        ((l) g.af(l.class)).aSM().d(new k.a(8, afk));
        chatroomInfoUI.isDeleteCancel = false;
        chatroomInfoUI.amr();
        if (!chatroomInfoUI.isDeleteCancel) {
            str = com.tencent.mm.pluginsdk.wallet.d.bfO(chatroomInfoUI.contact.field_username);
        } else {
            str = null;
        }
        if (!Util.isNullOrNil(str)) {
            chatroomInfoUI.ams();
            h.a(chatroomInfoUI, false, chatroomInfoUI.getString(R.string.ibb, new Object[]{str}), null, chatroomInfoUI.getString(R.string.dvh), chatroomInfoUI.getString(R.string.g6n), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(12519);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 4, 4, ChatroomInfoUI.this.roomId);
                    ChatroomInfoUI.this.isDeleteCancel = true;
                    if (!ChatroomInfoUI.this.gul) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", ChatroomInfoUI.this.contact.field_username);
                        intent.addFlags(67108864);
                        com.tencent.mm.br.c.f(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                        AppMethodBeat.o(12519);
                        return;
                    }
                    ChatroomInfoUI.this.finish();
                    AppMethodBeat.o(12519);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(194075);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14553, 4, 3, ChatroomInfoUI.this.roomId);
                    ChatroomInfoUI.u(ChatroomInfoUI.this);
                    ChatroomInfoUI.this.isDeleteCancel = false;
                    ChatroomInfoUI.this.DG(ChatroomInfoUI.this.roomId);
                    AppMethodBeat.o(194075);
                }
            }, -1, R.color.cd);
            AppMethodBeat.o(194108);
            return;
        }
        chatroomInfoUI.DG(chatroomInfoUI.roomId);
        AppMethodBeat.o(194108);
    }

    static /* synthetic */ void x(ChatroomInfoUI chatroomInfoUI) {
        AppMethodBeat.i(194111);
        Log.i("MicroMsg.ChatroomInfoUI", "doDeleteChatroom");
        bp.a(chatroomInfoUI.roomId, new bp.a() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass16 */

            @Override // com.tencent.mm.model.bp.a
            public final boolean amG() {
                AppMethodBeat.i(194079);
                boolean z = ChatroomInfoUI.this.isDeleteCancel;
                AppMethodBeat.o(194079);
                return z;
            }

            @Override // com.tencent.mm.model.bp.a
            public final void amH() {
                AppMethodBeat.i(194080);
                if (ChatroomInfoUI.this.gtM != null) {
                    ChatroomInfoUI.this.gtM.dismiss();
                }
                AppMethodBeat.o(194080);
            }
        });
        ((l) g.af(l.class)).aST().bjW(chatroomInfoUI.roomId);
        v.Ia(chatroomInfoUI.roomId);
        com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().GZ(chatroomInfoUI.roomId);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.setComponent(new ComponentName(chatroomInfoUI.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.LauncherUI"));
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(chatroomInfoUI, bl.axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "doDeleteChatroom", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        chatroomInfoUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(chatroomInfoUI, "com/tencent/mm/chatroom/ui/ChatroomInfoUI", "doDeleteChatroom", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        chatroomInfoUI.finish();
        AppMethodBeat.o(194111);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, com.tencent.mm.roomsdk.a.b.e eVar) {
        AppMethodBeat.i(194112);
        String str = "";
        String string = chatroomInfoUI.getString(R.string.tg);
        if (eVar != null) {
            str = Util.nullAs(eVar.title, "");
            string = Util.nullAs(eVar.content, chatroomInfoUI.getString(R.string.tg));
        }
        h.c(chatroomInfoUI, string, str, true);
        AppMethodBeat.o(194112);
    }

    static /* synthetic */ void a(nh nhVar) {
        AppMethodBeat.i(194113);
        nhVar.dTr.dSQ = true;
        EventCenter.instance.publish(nhVar);
        AppMethodBeat.o(194113);
    }

    static /* synthetic */ boolean b(ChatroomInfoUI chatroomInfoUI, final String str) {
        AppMethodBeat.i(194114);
        if (chatroomInfoUI.screen == null) {
            AppMethodBeat.o(194114);
            return false;
        }
        chatroomInfoUI.guA = chatroomInfoUI.getListView().getTranscriptMode();
        chatroomInfoUI.getListView().setTranscriptMode(2);
        chatroomInfoUI.screen.notifyDataSetChanged();
        if (chatroomInfoUI.guz != null) {
            chatroomInfoUI.guz.stopTimer();
        }
        chatroomInfoUI.guz = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass27 */
            int loopCount = 0;

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                int i2;
                AppMethodBeat.i(194092);
                if (ChatroomInfoUI.this.screen == null) {
                    AppMethodBeat.o(194092);
                    return false;
                } else if (this.loopCount > 50) {
                    AppMethodBeat.o(194092);
                    return false;
                } else {
                    int bmj = ChatroomInfoUI.this.screen.bmj(str);
                    View childAt = ChatroomInfoUI.this.getListView().getChildAt(bmj - ChatroomInfoUI.this.getListView().getFirstVisiblePosition());
                    if (childAt != null) {
                        i2 = childAt.getHeight();
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        this.loopCount++;
                        AppMethodBeat.o(194092);
                        return true;
                    }
                    Log.d("MicroMsg.ChatroomInfoUI", "show cover view get y[%f] height [%d] index[%d] [%d %d]", Float.valueOf(childAt.getY()), Integer.valueOf(i2), Integer.valueOf(bmj), Integer.valueOf(ChatroomInfoUI.this.getListView().getFirstVisiblePosition()), Integer.valueOf(ChatroomInfoUI.this.getListView().getLastVisiblePosition()));
                    int y = (int) childAt.getY();
                    if (y < 0) {
                        i2 += y;
                        y = 0;
                    }
                    ChatroomInfoUI.a(ChatroomInfoUI.this, y, i2);
                    AppMethodBeat.o(194092);
                    return false;
                }
            }
        }, true);
        chatroomInfoUI.guz.startTimer(5);
        AppMethodBeat.o(194114);
        return true;
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, int i2, int i3) {
        AppMethodBeat.i(194115);
        final LinearLayout linearLayout = new LinearLayout(chatroomInfoUI);
        linearLayout.setOrientation(1);
        View view = new View(chatroomInfoUI);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
        view.setBackgroundResource(R.color.a2x);
        linearLayout.addView(view, layoutParams);
        View view2 = new View(chatroomInfoUI);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i3);
        view2.setBackgroundResource(R.color.ac_);
        linearLayout.addView(view2, layoutParams2);
        View view3 = new View(chatroomInfoUI);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        view3.setBackgroundResource(R.color.fm);
        linearLayout.addView(view3, layoutParams3);
        ViewGroup viewGroup = (ViewGroup) chatroomInfoUI.getWindow().findViewById(16908290);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(viewGroup == null);
        Log.i("MicroMsg.ChatroomInfoUI", "add cover view now. contentView is null [%b]", objArr);
        if (viewGroup != null) {
            viewGroup.addView(linearLayout);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.4f);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(600);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.chatroom.ui.ChatroomInfoUI.AnonymousClass28 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                boolean z = true;
                AppMethodBeat.i(194093);
                ViewGroup viewGroup = (ViewGroup) ChatroomInfoUI.this.getWindow().findViewById(16908290);
                Object[] objArr = new Object[1];
                if (viewGroup != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.ChatroomInfoUI", "remove cover view now. contentView is null [%b]", objArr);
                if (viewGroup != null) {
                    viewGroup.removeView(linearLayout);
                }
                ChatroomInfoUI.this.getListView().setTranscriptMode(ChatroomInfoUI.this.guA);
                AppMethodBeat.o(194093);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.setAnimation(alphaAnimation);
        view3.setAnimation(alphaAnimation);
        alphaAnimation.start();
        AppMethodBeat.o(194115);
    }
}
