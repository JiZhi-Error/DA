package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.av.n;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.contact.c;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class SelectContactUI extends MMBaseSelectContactUI implements i, g {
    private boolean AxH = false;
    private int PSP;
    private TextView PYA;
    private TextView PYB;
    private TextView PYC;
    private TextView PYD;
    private List<String> PYE;
    private Map<String, Integer> PYF = new HashMap();
    private boolean PYG;
    private boolean PYH;
    private String PYI;
    private String PYJ;
    private boolean PYK;
    private int PYL;
    private RelativeLayout PYM;
    private LinearLayout PYN;
    private ImageView PYO;
    private ImageView PYP;
    private ImageView PYQ;
    private ProgressBar PYR;
    private TextView PYS;
    private Button PYT;
    private boolean PYU;
    private int PYV = 0;
    private int PYW = 0;
    private boolean PYX = false;
    private boolean PYY = false;
    private boolean PYZ = true;
    private int PYo;
    private boolean PYp = true;
    private a PYq = new a();
    private TextView PYy;
    private TextView PYz;
    private Pair<Long, Boolean> PZa = new Pair<>(-1L, Boolean.FALSE);
    private d PZb;
    private ArrayList<String> PZc = null;
    private boolean PZd;
    private boolean PZe;
    private boolean PZf = false;
    private String PZg;
    private IListener<rb> PZh = new IListener<rb>() {
        /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass1 */

        {
            AppMethodBeat.i(234017);
            this.__eventId = rb.class.getName().hashCode();
            AppMethodBeat.o(234017);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rb rbVar) {
            AppMethodBeat.i(234018);
            rb rbVar2 = rbVar;
            if (!(rbVar2 == null || rbVar2.dXE.msgId == 0)) {
                Log.i("MicroMsg.SelectContactUI", "RecordMsgNetSceneEvent msgId:%s netSceneMsgId:%s isSucc:%s", Long.valueOf(rbVar2.dXE.msgId), SelectContactUI.this.PZa.first, Boolean.valueOf(rbVar2.dXE.dQA));
                if (rbVar2.dXE.msgId == ((Long) SelectContactUI.this.PZa.first).longValue()) {
                    if (rbVar2.dXE.dQA) {
                        SelectContactUI.b(SelectContactUI.this);
                    } else {
                        SelectContactUI.a(SelectContactUI.this, "send record error", rbVar2.dXE.errMsg);
                    }
                }
            }
            AppMethodBeat.o(234018);
            return false;
        }
    };
    private b PZi = new b(this, (byte) 0);
    private boolean PZj = false;
    private HashMap<String, String> PZk = new HashMap<>();
    private long PsQ = -1;
    private ProgressDialog gtM;
    private String gwx;
    private h gyh;
    private List<String> gzY;
    private String oqZ;
    private int requestCode;
    private g.a sPz = new g.a() {
        /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass18 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(234036);
            if (i2 == -21005) {
                Log.i("MicroMsg.SelectContactUI", "ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(234036);
            } else if (dVar != null && dVar.field_retCode == 0) {
                SelectContactUI.this.PZb = dVar;
                SelectContactUI.this.PYX = false;
                Log.i("MicroMsg.SelectContactUI", "sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] result:%s", str, Integer.valueOf(i2), cVar, dVar, Boolean.valueOf(s.deleteFile((String) SelectContactUI.this.PZk.get(str))));
                SelectContactUI.k(SelectContactUI.this);
                com.tencent.mm.plugin.selectrecord.b.a.eSu().IG(cl.aWy());
                AppMethodBeat.o(234036);
            } else if (dVar != null) {
                Log.w("MicroMsg.SelectContactUI", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                SelectContactUI.a(SelectContactUI.this, dVar.field_retCode, "cdn ret error");
                AppMethodBeat.o(234036);
            } else if (i2 != 0) {
                Log.w("MicroMsg.SelectContactUI", "start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                SelectContactUI.a(SelectContactUI.this, 0, "cdn start error");
                AppMethodBeat.o(234036);
            } else {
                Log.i("MicroMsg.SelectContactUI", "on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                if (cVar != null) {
                    Log.d("MicroMsg.SelectContactUI", "cdn process: %f", Double.valueOf(((double) cVar.field_finishedLength) / ((double) cVar.field_toltalLength)));
                }
                AppMethodBeat.o(234036);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    };
    private String title;
    private String yCr;
    private int ygg;
    private List<String> zow;

    public SelectContactUI() {
        AppMethodBeat.i(37994);
        AppMethodBeat.o(37994);
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, int i2, String str) {
        AppMethodBeat.i(234068);
        selectContactUI.m42do(i2, str);
        AppMethodBeat.o(234068);
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, String str, String str2) {
        AppMethodBeat.i(234060);
        selectContactUI.Z(0, str, str2);
        AppMethodBeat.o(234060);
    }

    static /* synthetic */ boolean a(SelectContactUI selectContactUI, List list) {
        AppMethodBeat.i(234063);
        boolean jP = selectContactUI.jP(list);
        AppMethodBeat.o(234063);
        return jP;
    }

    static /* synthetic */ void b(SelectContactUI selectContactUI) {
        AppMethodBeat.i(234059);
        selectContactUI.gVk();
        AppMethodBeat.o(234059);
    }

    static /* synthetic */ boolean b(SelectContactUI selectContactUI, List list) {
        AppMethodBeat.i(234066);
        boolean jO = selectContactUI.jO(list);
        AppMethodBeat.o(234066);
        return jO;
    }

    static /* synthetic */ void k(SelectContactUI selectContactUI) {
        AppMethodBeat.i(234061);
        selectContactUI.gVh();
        AppMethodBeat.o(234061);
    }

    static /* synthetic */ ArrayList p(SelectContactUI selectContactUI) {
        AppMethodBeat.i(234062);
        ArrayList<String> Cs = selectContactUI.Cs(true);
        AppMethodBeat.o(234062);
        return Cs;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        int i2;
        t.b bVar;
        AppMethodBeat.i(37995);
        super.onCreate(bundle);
        Log.i("MicroMsg.SelectContactUI", "create!");
        bg.azz().a(30, this);
        bg.azz().a(138, this);
        if (!Util.isNullOrNil(this.oqZ)) {
            setMMSubTitle(this.oqZ);
        }
        if (u.hasAttr(this.PYo, 64)) {
            if (this.PYL == 1) {
                this.PYM.setVisibility(8);
                String string = getString(R.string.x_);
                AnonymousClass7 r3 = new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass7 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(234025);
                        boolean r = SelectContactUI.r(SelectContactUI.this);
                        AppMethodBeat.o(234025);
                        return r;
                    }
                };
                if (hYM()) {
                    bVar = t.b.FINDER_LIVE;
                } else {
                    bVar = t.b.GREEN;
                }
                addTextOptionMenu(1, string, r3, null, bVar);
            } else {
                this.PYM.setVisibility(0);
                this.PYT.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(234028);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (SelectContactUI.this.PYX) {
                            com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(R.string.fwf), "", SelectContactUI.this.getString(R.string.j34), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass8.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(234026);
                                    Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                                    AppMethodBeat.o(234026);
                                }
                            });
                            com.tencent.mm.plugin.selectrecord.b.a.eSu().CXa++;
                        } else if (SelectContactUI.this.PYY) {
                            com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(R.string.fwe), "", SelectContactUI.this.getString(R.string.j34), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass8.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(234027);
                                    Log.i("MicroMsg.SelectContactUI", "initMenu(upload fail) click i know");
                                    AppMethodBeat.o(234027);
                                }
                            });
                            com.tencent.mm.plugin.selectrecord.b.a.eSu().CXb++;
                            com.tencent.mm.plugin.selectrecord.b.a.eSu().eSy();
                        } else {
                            SelectContactUI.r(SelectContactUI.this);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(234028);
                    }
                });
            }
        }
        ani();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(234032);
                SelectContactUI.this.hideVKB();
                SelectContactUI.this.finish();
                if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    MMHandlerThread.postToMainThreadDelayed(SelectContactUI.this.PZi, 80);
                }
                AppMethodBeat.o(234032);
                return true;
            }
        });
        if (!(this.PSP == 15 || this.zoy == null)) {
            this.zoy.it(this.zow);
        }
        if (getIntent().getBooleanExtra("create_group_recommend", false)) {
            switch (this.scene) {
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                default:
                    i2 = 0;
                    break;
                case 7:
                    i2 = 1;
                    break;
            }
            w.PXE = i2;
            Log.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", Integer.valueOf(i2));
        }
        AppMethodBeat.o(37995);
    }

    /* access modifiers changed from: package-private */
    public static class b implements Runnable {
        private WeakReference<SelectContactUI> cMO;

        /* synthetic */ b(SelectContactUI selectContactUI, byte b2) {
            this(selectContactUI);
        }

        private b(SelectContactUI selectContactUI) {
            AppMethodBeat.i(37990);
            this.cMO = new WeakReference<>(selectContactUI);
            AppMethodBeat.o(37990);
        }

        public final void run() {
            AppMethodBeat.i(37991);
            SelectContactUI selectContactUI = this.cMO.get();
            if (selectContactUI == null) {
                AppMethodBeat.o(37991);
                return;
            }
            selectContactUI.moveTaskToBack(true);
            AppMethodBeat.o(37991);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(234042);
        super.onResume();
        if (this.gyh != null) {
            this.gyh.start();
        }
        AppMethodBeat.o(234042);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(234043);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (this.gyh != null) {
            this.gyh.start();
        }
        AppMethodBeat.o(234043);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(234044);
        super.onPause();
        if (this.gyh != null) {
            this.gyh.close();
        }
        AppMethodBeat.o(234044);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37996);
        this.PZh.dead();
        bg.azz().b(30, this);
        bg.azz().b(138, this);
        anK(1);
        w.reset();
        super.onDestroy();
        AppMethodBeat.o(37996);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void amZ() {
        AppMethodBeat.i(37997);
        super.amZ();
        this.PYo = getIntent().getIntExtra("list_attr", u.PWR);
        this.title = getIntent().getStringExtra("titile");
        this.oqZ = getIntent().getStringExtra("sub_title");
        this.PSP = getIntent().getIntExtra("list_type", -1);
        this.PYp = getIntent().getBooleanExtra("show_too_many_member", true);
        this.yCr = getIntent().getStringExtra("label_source");
        if (u.hasAttr(this.PYo, 256) && ab.aUV().size() == 0) {
            u.ll(this.PYo, 256);
        }
        this.PYG = getIntent().getBooleanExtra("Add_SendCard", false);
        this.PYH = getIntent().getBooleanExtra("recommend_friends", false);
        if (this.PYG || this.PYH) {
            this.PYI = Util.nullAs(getIntent().getStringExtra("be_send_card_name"), "");
            this.PYJ = Util.nullAs(getIntent().getStringExtra("received_card_name"), "");
        }
        this.PYK = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
        this.PYU = getIntent().getBooleanExtra("is_select_record_msg_mode", false);
        this.PYL = getIntent().getIntExtra("menu_mode", 1);
        this.gwx = getIntent().getStringExtra("chatroomName");
        Log.i("MicroMsg.SelectContactUI", "mRoomId：%s", Util.nullAs(this.gwx, ""));
        this.gzY = new ArrayList();
        this.zow = new LinkedList();
        this.PYE = new LinkedList();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!Util.isNullOrNil(stringExtra)) {
            this.PYE.addAll(Util.stringsToList(stringExtra.split(",")));
        }
        String stringExtra2 = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(stringExtra2)) {
            this.zow.addAll(Util.stringsToList(stringExtra2.split(",")));
        }
        HashSet hashSet = new HashSet();
        String stringExtra3 = getIntent().getStringExtra("block_contact");
        if (!Util.isNullOrNil(stringExtra3)) {
            hashSet.addAll(Util.stringsToList(stringExtra3.split(",")));
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.addAll(u.gVb());
        hashSet2.addAll(u.gVc());
        if (!u.hasAttr(this.PYo, 268435456)) {
            hashSet2.add(z.aTY());
        }
        if (this.PYG) {
            hashSet2.removeAll(u.gVb());
        }
        this.gzY.add("gh_3dfda90e39d6");
        this.gzY.addAll(hashSet2);
        gVg();
        AppMethodBeat.o(37997);
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        int i2;
        boolean z2;
        AppMethodBeat.i(234045);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_db_anrfix_mode_on_new, 0);
        if (com.tencent.mm.protocal.d.KyR || a2 == 1) {
            z = true;
        } else {
            z = false;
        }
        this.PWx = z;
        super.initView();
        this.PYM = (RelativeLayout) findViewById(R.id.hig);
        this.PYN = (LinearLayout) findViewById(R.id.hif);
        this.PYT = (Button) findViewById(R.id.d50);
        this.PYO = (ImageView) findViewById(R.id.hii);
        this.PYP = (ImageView) findViewById(R.id.hik);
        this.PYQ = (ImageView) findViewById(R.id.hih);
        this.PYR = (ProgressBar) findViewById(R.id.gxd);
        this.PYS = (TextView) findViewById(R.id.hij);
        this.PYN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass20 */

            public final void onClick(View view) {
                AppMethodBeat.i(37978);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SelectContactUI", "click selectRecordMsgBt %s", Util.nullAs(SelectContactUI.this.gwx, ""));
                SelectContactUI.this.hideVKB();
                Intent putExtra = new Intent().putExtra("Chat_User", SelectContactUI.this.gwx).putExtra("finish_direct", true).putExtra("key_record_msg_select", true).putExtra("key_record_msg_select_introduce", SelectContactUI.this.PYZ).putExtra("key_record_select_min_msg_id", SelectContactUI.this.PsQ).putExtra("key_record_select_msg_num", SelectContactUI.this.PYV);
                if (SelectContactUI.this.PZc != null) {
                    putExtra.putStringArrayListExtra("key_record_select_msg_black_list", SelectContactUI.this.PZc);
                }
                com.tencent.mm.br.c.c(SelectContactUI.this, ".ui.chatting.ChattingUI", putExtra, 6);
                SelectContactUI.this.PYZ = false;
                com.tencent.mm.plugin.selectrecord.b.a.eSu().CWO.eMX = 1;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37978);
            }
        });
        this.PYP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass21 */

            public final void onClick(View view) {
                AppMethodBeat.i(37979);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SelectContactUI", "click warn to retry");
                SelectContactUI.this.PZb = null;
                SelectContactUI.this.PYY = false;
                SelectContactUI.this.PYX = true;
                SelectContactUI.k(SelectContactUI.this);
                SelectContactUI.this.PZa = l.m(SelectContactUI.this, "msginfo@fakeuser", true);
                if (!((Boolean) SelectContactUI.this.PZa.second).booleanValue()) {
                    SelectContactUI.this.PZh.alive();
                } else {
                    SelectContactUI.b(SelectContactUI.this);
                }
                com.tencent.mm.plugin.selectrecord.b.a.eSu().CWY++;
                Log.i("MicroMsg.SelectContactUI", "click warn to retry, msgId:%s direct:%s", SelectContactUI.this.PZa.first, SelectContactUI.this.PZa.second);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37979);
            }
        });
        com.tencent.mm.plugin.selectrecord.b.a.eSv();
        com.tencent.mm.plugin.selectrecord.b.a eSu = com.tencent.mm.plugin.selectrecord.b.a.eSu();
        String str = this.gwx;
        id idVar = eSu.CWO;
        idVar.eMN = idVar.x("RoomId", str, true);
        id idVar2 = eSu.CWO;
        if (ab.IB(str)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        idVar2.eNp = i2;
        int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_room_select_record_entry, 0);
        Log.d("MicroMsg.recordSelect.SelectRecordConfig", "canSelectRecordInAddRoomMembers() sw:%s", Integer.valueOf(a3));
        if (a3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !ab.Ix(this.gwx) || ab.IB(this.gwx) || ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEX(this.gwx) <= 0) {
            this.PYN.setVisibility(8);
            com.tencent.mm.plugin.selectrecord.b.a.eSu().un(false);
        } else {
            this.PYN.setVisibility(0);
            com.tencent.mm.plugin.selectrecord.b.a.eSu().un(true);
            if (this.Bvb != null) {
                this.PYM.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass22 */

                    public final void run() {
                        AppMethodBeat.i(234039);
                        int height = SelectContactUI.this.PYM.getHeight();
                        if (height > 0) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SelectContactUI.this.Bvb.getLayoutParams();
                            layoutParams.bottomMargin = height;
                            SelectContactUI.this.Bvb.setLayoutParams(layoutParams);
                        }
                        AppMethodBeat.o(234039);
                    }
                });
            }
        }
        if (this.PYL == 2) {
            this.gyh = new h(this);
            this.gyh.Quk = this;
        }
        if (hYM()) {
            setTheme(R.style.a0);
            setActionbarColor(getResources().getColor(R.color.w));
            setNavigationbarColor(getResources().getColor(R.color.w));
            hYJ();
            hYK();
            this.Bvb.setBackgroundResource(R.color.y);
            this.PWj.setTextColor(getResources().getColor(R.color.BW_100_Alpha_0_2));
            this.PWj.setBackgroundColor(getResources().getColor(R.color.q5));
        }
        AppMethodBeat.o(234045);
    }

    private boolean hYM() {
        AppMethodBeat.i(259015);
        boolean booleanExtra = getIntent().getBooleanExtra("KForceDarkMode", false);
        AppMethodBeat.o(259015);
        return booleanExtra;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final p gUP() {
        AppMethodBeat.i(234046);
        p gUP = super.gUP();
        if (gUP == null) {
            gUP = bmC();
            getContentLV().setAdapter((ListAdapter) gUP);
            Log.i("MicroMsg.SelectContactUI", "getAdapter is null");
        }
        AppMethodBeat.o(234046);
        return gUP;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final q gUQ() {
        AppMethodBeat.i(234047);
        q gUQ = super.gUQ();
        if (gUQ == null) {
            gUQ = bmC();
            getContentLV().setAdapter((ListAdapter) gUQ);
            Log.i("MicroMsg.SelectContactUI", "getInitAdapter is null");
        }
        AppMethodBeat.o(234047);
        return gUQ;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void M(View view, int i2) {
        AppMethodBeat.i(234048);
        int headerViewsCount = i2 - getContentLV().getHeaderViewsCount();
        if (headerViewsCount < 0) {
            Log.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", Integer.valueOf(headerViewsCount), Integer.valueOf(i2));
            AppMethodBeat.o(234048);
            return;
        }
        com.tencent.mm.ui.contact.a.a anH = gUP().getItem(headerViewsCount);
        if (anH == null) {
            AppMethodBeat.o(234048);
        } else if (anH instanceof k) {
            if (u.hasAttr(this.PYo, 16384)) {
                Log.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", "");
                intent.putExtra("Select_Conv_User", "");
                intent.putExtra("Select_Contact", "");
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.o(234048);
        } else if (anH.contact == null) {
            AppMethodBeat.o(234048);
        } else if (anH.contact.field_deleteFlag == 1) {
            AppMethodBeat.o(234048);
        } else {
            String str = anH.contact.field_username;
            Log.i("MicroMsg.SelectContactUI", "ClickUser=%s", str);
            if (!u.hasAttr(this.PYo, 64)) {
                jO(Util.stringsToList(new String[]{str}));
            } else if (!ab.Eq(str) || !getIntent().getBooleanExtra("create_group_recommend", false)) {
                if (!u.hasAttr(this.PYo, 131072) || this.zow.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                    bnA(str);
                } else if (!this.PYE.contains(str)) {
                    gUW();
                    if (this.zow.contains(str)) {
                        this.zoy.bev(str);
                        this.zow.remove(str);
                    } else {
                        String stringExtra = getIntent().getStringExtra("too_many_member_tip_string");
                        if (Util.isNullOrNil(stringExtra)) {
                            stringExtra = getString(R.string.ghv, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10))});
                        }
                        com.tencent.mm.ui.base.h.d(getContext(), stringExtra, "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass15 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                }
                ani();
                gVg();
                if (gUQ() != null) {
                    gUQ().notifyDataSetChanged();
                    AppMethodBeat.o(234048);
                    return;
                }
            } else {
                Intent intent2 = new Intent(this, ChattingUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", str);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
                anK(3);
                AppMethodBeat.o(234048);
                return;
            }
            AppMethodBeat.o(234048);
        }
    }

    private void gVg() {
        int i2 = 0;
        AppMethodBeat.i(37999);
        if (this.PYp && (this.PSP == 1 || this.PSP == 0)) {
            int size = this.PYE != null ? this.PYE.size() : 0;
            if (this.zow != null) {
                i2 = this.zow.size();
            }
            this.PYq.e(this, size + i2, Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("ChatRoomInviteStartCount")));
        }
        AppMethodBeat.o(37999);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmz() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean bmA() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final String bmB() {
        return this.title;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final synchronized q bmC() {
        boolean z;
        c cVar;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(38000);
            c.a aVar = new c.a();
            aVar.PTM = u.hasAttr(this.PYo, 16);
            aVar.PTL = u.hasAttr(this.PYo, 32);
            aVar.PTP = getIntent().getBooleanExtra("create_group_recommend", false);
            aVar.PTN = !u.hasAttr(this.PYo, 4);
            if (!u.hasAttr(this.PYo, 1)) {
                z = true;
            } else {
                z = false;
            }
            aVar.PTO = z;
            aVar.PTQ = u.hasAttr(this.PYo, 128);
            aVar.PTR = u.hasAttr(this.PYo, 1048576);
            aVar.PTV = u.hasAttr(this.PYo, 256);
            if (aVar.PTV) {
                aVar.PTW = getIntent().getStringExtra("custom_contact");
            }
            if (aVar.PTQ) {
                this.PZf = true;
                aVar.PTT = getIntent().getStringExtra("wechat_sport_contact");
                aVar.PTU = getIntent().getStringExtra("wechat_sport_recent_like");
                this.PZg = aVar.PTT;
            }
            if (u.gVd()) {
                aVar.PSf = "@all.contact.without.chatroom.without.openim";
            } else {
                aVar.PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            if (this.scene == 6 || this.scene == 5) {
                aVar.PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
                aVar.PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            List<String> list = this.PYE;
            List<String> list2 = this.zow;
            List<String> list3 = this.gzY;
            boolean hasAttr = u.hasAttr(this.PYo, 1);
            boolean hasAttr2 = u.hasAttr(this.PYo, 64);
            if (this.PSP != 15) {
                z2 = false;
            }
            cVar = new c(this, list, list2, list3, hasAttr, hasAttr2, aVar, z2, hYM());
            AppMethodBeat.o(38000);
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final o bmD() {
        AppMethodBeat.i(38001);
        if (this.PZf) {
            t tVar = new t(this, this.gzY, u.hasAttr(this.PYo, 64), this.PZg);
            AppMethodBeat.o(38001);
            return tVar;
        } else if (getIntent().getBooleanExtra("create_group_recommend", false)) {
            v vVar = new v(this, this.PYE, this.zow, this.gzY, u.hasAttr(this.PYo, 64), this.scene);
            AppMethodBeat.o(38001);
            return vVar;
        } else {
            s sVar = new s(this, this.gzY, u.hasAttr(this.PYo, 64), this.scene, hYM());
            AppMethodBeat.o(38001);
            return sVar;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void a(ListView listView, int i2) {
        final int i3;
        final int i4;
        String string;
        AppMethodBeat.i(38002);
        super.a(listView, i2);
        if (u.hasAttr(this.PYo, 256)) {
            if (this.PYy == null) {
                AnonymousClass23 r2 = new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass23 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(37982);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", true);
                        boolean hasAttr = u.hasAttr(SelectContactUI.this.PYo, 16384);
                        intent.putExtra("group_select_need_result", hasAttr);
                        if (!hasAttr) {
                            SelectContactUI selectContactUI = SelectContactUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(selectContactUI, bl.axQ(), "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            selectContactUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(selectContactUI, "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        } else if (SelectContactUI.this.PSP == 14) {
                            intent.putExtra("group_multi_select", true);
                            intent.putExtra("already_select_contact", Util.listToString(SelectContactUI.p(SelectContactUI.this), ","));
                            intent.putExtra("max_limit_num", SelectContactUI.this.getIntent().getIntExtra("max_limit_num", 9));
                            SelectContactUI.this.startActivityForResult(intent, 4);
                        } else {
                            SelectContactUI.this.startActivityForResult(intent, 0);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37982);
                    }
                };
                if (this.PSP == 14) {
                    string = getString(R.string.fu);
                } else {
                    string = getString(R.string.f_);
                }
                this.PYy = a(listView, r2, string);
            }
            this.PYy.setVisibility(i2);
        }
        if (u.hasAttr(this.PYo, 512)) {
            if (this.PYz == null) {
                this.PYz = a(listView, new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass24 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(37983);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11140, 0);
                        com.tencent.mm.br.c.V(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37983);
                    }
                }, getString(R.string.cf3));
            }
            this.PYz.setVisibility(i2);
        }
        if (u.hasAttr(this.PYo, 1024)) {
            if (this.PYA == null) {
                this.PYA = a(listView, new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass25 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(234040);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                        intent.putExtra("group_select_type", false);
                        SelectContactUI.this.startActivityForResult(intent, 1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(234040);
                    }
                }, getString(R.string.fa));
            }
            this.PYA.setVisibility(i2);
        }
        if (u.hasAttr(this.PYo, 2048)) {
            if (this.PYC == null) {
                this.PYC = a(listView, new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass26 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(234041);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!WeChatBrands.Business.Entries.ContactOa.checkAvailable(view.getContext())) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(234041);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("list_attr", 16384);
                        com.tencent.mm.br.c.b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", intent, 2);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(234041);
                    }
                }, getString(R.string.fo));
            }
            this.PYC.setVisibility(i2);
            this.PYC.setTextSize(16.0f * com.tencent.mm.cb.a.ez(this.PYC.getContext()));
        }
        if (u.hasAttr(this.PYo, 524288)) {
            if (this.PYB == null) {
                final String str = "";
                int intExtra = getIntent().getIntExtra("topstory_import_type", 0);
                int i5 = R.string.fe;
                if (intExtra == 1) {
                    List<String> IZ = o.DCP.IZ(5);
                    int size = Util.isNullOrNil(IZ) ? 0 : IZ.size();
                    str = Util.listToString(IZ, ",");
                    i5 = R.string.fe;
                    i3 = R.string.ff;
                    i4 = size;
                } else if (intExtra == 2) {
                    List<String> gnq = com.tencent.mm.pluginsdk.i.a.gnq();
                    int size2 = Util.isNullOrNil(gnq) ? 0 : gnq.size();
                    str = Util.listToString(gnq, ",");
                    i5 = R.string.fc;
                    i3 = R.string.fd;
                    i4 = size2;
                } else {
                    i3 = R.string.ff;
                    i4 = 0;
                }
                this.PYB = a(listView, new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(234020);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.ui.base.h.c(SelectContactUI.this, SelectContactUI.this.getString(i3, new Object[]{Integer.valueOf(i4)}), "", SelectContactUI.this.getString(R.string.fb), SelectContactUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(234019);
                                Intent intent = new Intent();
                                intent.putExtra("Select_Contact", str);
                                intent.putExtra("App_MsgId", "fromSns");
                                SelectContactUI.this.setResult(-1, intent);
                                SelectContactUI.this.finish();
                                AppMethodBeat.o(234019);
                            }
                        }, null);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(234020);
                    }
                }, getString(i5));
                this.PYB.setTag(Integer.valueOf(i4));
            }
            Object tag = this.PYB.getTag();
            if (!(tag instanceof Integer) || ((Integer) tag).intValue() <= 0) {
                this.PYB.setVisibility(8);
            } else {
                this.PYB.setVisibility(i2);
            }
        }
        if (u.hasAttr(this.PYo, TPMediaCodecProfileLevel.HEVCMainTierLevel62)) {
            if (this.PYD == null) {
                bg.aVF();
                List<String> gBY = com.tencent.mm.model.c.aSN().gBY();
                Log.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", Integer.valueOf(gBY.size()));
                if (gBY.size() != 0) {
                    this.PYD = a(listView, new View.OnClickListener() {
                        /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(234022);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(view.getContext())) {
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(234022);
                                return;
                            }
                            Intent intent = new Intent(SelectContactUI.this.getIntent());
                            intent.setClass(SelectContactUI.this.getContext(), OpenIMSelectContactUI.class);
                            intent.removeExtra("titile");
                            intent.putExtra("openim_appid", "3552365301");
                            ArrayList arrayList = new ArrayList();
                            for (String str : SelectContactUI.this.zow) {
                                if (as.bjp(str)) {
                                    arrayList.add(str);
                                }
                            }
                            intent.putExtra("already_select_contact", Util.listToString(arrayList, ","));
                            SelectContactUI.this.startActivityForResult(intent, 5);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(234022);
                        }
                    }, "");
                    String a2 = ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a("3552365301", "openim_acct_type_title", a.EnumC0497a.TYPE_WORDING);
                    this.PYD.setVisibility(i2);
                    this.PYD.setText(a2);
                }
            }
            if (this.PYD != null) {
                this.PYD.setVisibility(i2);
            }
        }
        if (!u.hasAttr(this.PYo, TPMediaCodecProfileLevel.HEVCMainTierLevel62) || this.PYD == null) {
            if (u.hasAttr(this.PYo, 2048)) {
                if (this.PYC != null) {
                    this.PYC.setBackgroundResource(R.drawable.qd);
                    AppMethodBeat.o(38002);
                    return;
                }
            } else if (u.hasAttr(this.PYo, 1024)) {
                if (this.PYA != null) {
                    this.PYA.setBackgroundResource(R.drawable.qd);
                    AppMethodBeat.o(38002);
                    return;
                }
            } else if (u.hasAttr(this.PYo, 512)) {
                if (this.PYz != null) {
                    this.PYz.setBackgroundResource(R.drawable.qd);
                    AppMethodBeat.o(38002);
                    return;
                }
            } else if (u.hasAttr(this.PYo, 256) && this.PYy != null) {
                this.PYy.setBackgroundResource(R.drawable.qd);
            }
            AppMethodBeat.o(38002);
            return;
        }
        this.PYD.setBackgroundResource(R.drawable.qd);
        AppMethodBeat.o(38002);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        boolean z2;
        ObjectAnimator ofFloat;
        AppMethodBeat.i(234049);
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.AxH == z2) {
            Log.d("MicroMsg.SelectContactUI", "onKeyboardHeightChanged repeat");
            AppMethodBeat.o(234049);
            return;
        }
        if (this.ygg == 0) {
            this.ygg = i2;
        }
        if (z2) {
            if (this.PYM.getTranslationY() != 0.0f) {
                this.PYM.setTranslationY(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(this.PYM, "translationY", this.PYM.getTranslationY(), this.PYM.getTranslationY() - ((float) this.ygg));
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.PYM, "translationY", this.PYM.getTranslationY(), this.PYM.getTranslationY() + ((float) this.ygg));
        }
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new android.support.v4.view.b.b());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass3 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(234021);
                Log.i("MicroMsg.SelectContactUI", "onAnimationUpdate %s", Float.valueOf(((Float) valueAnimator.getAnimatedValue("translationY")).floatValue()));
                AppMethodBeat.o(234021);
            }
        });
        ofFloat.start();
        this.AxH = z2;
        Log.i("MicroMsg.SelectContactUI", "height:%s moveHeight:%s isKeyboardShow:%s", Integer.valueOf(i2), Integer.valueOf(this.ygg), Boolean.valueOf(z2));
        AppMethodBeat.o(234049);
    }

    private TextView a(ListView listView, View.OnClickListener onClickListener, String str) {
        AppMethodBeat.i(38003);
        View inflate = aa.jQ(this).inflate(R.layout.ats, (ViewGroup) null);
        inflate.setOnClickListener(onClickListener);
        TextView textView = (TextView) inflate.findViewById(R.id.bfe);
        textView.setText(str);
        listView.addHeaderView(inflate);
        AppMethodBeat.o(38003);
        return textView;
    }

    private boolean jO(final List<String> list) {
        AppMethodBeat.i(38004);
        Log.i("MicroMsg.SelectContactUI", "handleSelect %s", list);
        if (u.hasAttr(this.PYo, 65536)) {
            String jQ = jQ(list);
            this.PZe = true;
            com.tencent.mm.ui.base.h.a((Context) getContext(), jQ, (String) null, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(234023);
                    SelectContactUI.this.PZe = SelectContactUI.a(SelectContactUI.this, list);
                    AppMethodBeat.o(234023);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(234024);
                    SelectContactUI.this.PZe = false;
                    AppMethodBeat.o(234024);
                }
            });
            boolean z = this.PZe;
            AppMethodBeat.o(38004);
            return z;
        }
        boolean jP = jP(list);
        AppMethodBeat.o(38004);
        return jP;
    }

    private boolean jP(List<String> list) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(38005);
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
            if (Util.isNullOrNil(this.PYI)) {
                this.PYI = Util.listToString(list, ",");
            } else if (Util.isNullOrNil(this.PYJ)) {
                this.PYJ = Util.listToString(list, ",");
            } else {
                Log.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", this.PYI, this.PYJ);
                AppMethodBeat.o(38005);
                return false;
            }
            boolean Eq = ab.Eq(this.PYJ);
            Intent intent = new Intent();
            intent.putExtra("be_send_card_name", this.PYI);
            intent.putExtra("received_card_name", this.PYJ);
            intent.putExtra("Is_Chatroom", Eq);
            setResult(-1, intent);
            finish();
        } else if (getIntent().getBooleanExtra("snsPostWhoCanSee", false)) {
            Log.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", list.toString());
            ArrayList<String> Cs = Cs(false);
            Cs.remove(z.aTY());
            boolean z3 = false;
            for (String str : list) {
                if (!Util.isNullOrNil(str)) {
                    if (!Cs.contains(str) && !z.aTY().equals(str)) {
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                        if (!(Kn == null || ((int) Kn.gMZ) == 0 || !com.tencent.mm.contact.c.oR(Kn.field_type))) {
                            bnA(str);
                            Cs.add(str);
                            z = true;
                            z3 = z;
                        }
                    }
                }
                z = z3;
                z3 = z;
            }
            if (z3) {
                ani();
                gUP().notifyDataSetChanged();
            } else {
                gVj();
            }
        } else if (getIntent().getBooleanExtra("recommend_friends", false)) {
            Log.i("MicroMsg.SelectContactUI", "Recommend Friends");
            ad.a(getContext(), this.PYJ, list);
        } else if (u.hasAttr(this.PYo, 16384)) {
            Log.i("MicroMsg.SelectContactUI", "return the result");
            Intent intent2 = new Intent();
            String listToString = Util.listToString(list, ",");
            intent2.putExtra("Select_Contact", listToString);
            intent2.putExtra("Select_Conv_User", listToString);
            intent2.putExtra("Select_Contact", listToString);
            if (this.PZb != null) {
                ChatroomInfoUI.LocalHistoryInfo localHistoryInfo = new ChatroomInfoUI.LocalHistoryInfo();
                localHistoryInfo.fileid = this.PZb.field_fileId;
                localHistoryInfo.aeskey = this.PZb.field_aesKey;
                localHistoryInfo.filemd5 = this.PZb.field_filemd5;
                localHistoryInfo.guR = (int) this.PZb.field_fileLength;
                localHistoryInfo.guS = this.PYW;
                intent2.putExtra("select_record_msg_info", localHistoryInfo);
                intent2.putExtra("select_record_fake_msg_id", this.PZa != null ? ((Long) this.PZa.first).longValue() : 0);
            }
            intent2.putExtra("label_source", this.yCr);
            if (this.requestCode == 1) {
                z2 = true;
            }
            intent2.putExtra("Is_Chatroom", z2);
            setResult(-1, intent2);
            finish();
        } else if (getIntent().getBooleanExtra("shareImage", false)) {
            Log.i("MicroMsg.SelectContactUI", "Share Image");
            gVi();
        } else if (list.size() > 0) {
            Log.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", list.toString());
            finish();
            Intent intent3 = new Intent();
            intent3.setClass(this, ChattingUI.class);
            intent3.putExtra("Chat_User", list.get(0));
            intent3.addFlags(67108864);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            anK(3);
        } else {
            Log.e("MicroMsg.SelectContactUI", "unkown action: User=%s", list.toString());
        }
        AppMethodBeat.o(38005);
        return true;
    }

    private void ani() {
        AppMethodBeat.i(38006);
        if (u.hasAttr(this.PYo, 64) && this.zow.size() > 0) {
            bnz(getString(R.string.vl) + "(" + this.zow.size() + ")");
            int intExtra = getIntent().getIntExtra("min_limit_num", 0);
            if (!u.hasAttr(this.PYo, TPMediaCodecProfileLevel.HEVCMainTierLevel52) || this.zow.size() >= intExtra) {
                Cr(true);
                AppMethodBeat.o(38006);
                return;
            }
            Cr(false);
            AppMethodBeat.o(38006);
        } else if (!u.hasAttr(this.PYo, 64) || !u.hasAttr(this.PYo, 4194304)) {
            bnz(getString(R.string.vl));
            Cr(false);
            AppMethodBeat.o(38006);
        } else {
            bnz(getString(R.string.vl));
            Cr(true);
            AppMethodBeat.o(38006);
        }
    }

    private void Cr(boolean z) {
        AppMethodBeat.i(234050);
        if (this.PYL == 1) {
            enableOptionMenu(1, z);
            AppMethodBeat.o(234050);
            return;
        }
        this.PYT.setEnabled(z);
        AppMethodBeat.o(234050);
    }

    private void bnz(String str) {
        AppMethodBeat.i(234051);
        if (this.PYL == 1) {
            updateOptionMenuText(1, str);
            AppMethodBeat.o(234051);
            return;
        }
        this.PYT.setText(str);
        AppMethodBeat.o(234051);
    }

    private void gVh() {
        AppMethodBeat.i(234052);
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(234029);
                if (SelectContactUI.this.PYU) {
                    if (SelectContactUI.this.PYW == 0) {
                        SelectContactUI.this.PYO.setVisibility(8);
                        SelectContactUI.this.PYP.setVisibility(8);
                        SelectContactUI.this.PYR.setVisibility(8);
                        SelectContactUI.this.PYQ.setVisibility(0);
                        SelectContactUI.this.PYS.setTextColor(SelectContactUI.this.getResources().getColor(R.color.FG_1));
                        SelectContactUI.this.PYS.setText(R.string.gij);
                        SelectContactUI.this.PYN.setBackground(SelectContactUI.this.getResources().getDrawable(R.drawable.asa));
                        AppMethodBeat.o(234029);
                        return;
                    } else if (SelectContactUI.this.PYY) {
                        SelectContactUI.this.PYO.setVisibility(8);
                        SelectContactUI.this.PYP.setVisibility(0);
                        SelectContactUI.this.PYR.setVisibility(8);
                        SelectContactUI.this.PYQ.setVisibility(8);
                        SelectContactUI.this.PYS.setTextColor(SelectContactUI.this.getResources().getColor(R.color.Brand_100));
                        SelectContactUI.this.PYS.setText(SelectContactUI.this.getString(R.string.gir, new Object[]{Integer.toString(SelectContactUI.this.PYW)}));
                        SelectContactUI.this.PYN.setBackground(SelectContactUI.this.getResources().getDrawable(R.drawable.asb));
                        AppMethodBeat.o(234029);
                        return;
                    } else if (SelectContactUI.this.PYX) {
                        SelectContactUI.this.PYO.setVisibility(8);
                        SelectContactUI.this.PYP.setVisibility(8);
                        SelectContactUI.this.PYR.setVisibility(0);
                        SelectContactUI.this.PYQ.setVisibility(8);
                        SelectContactUI.this.PYS.setTextColor(SelectContactUI.this.getResources().getColor(R.color.Brand_100));
                        SelectContactUI.this.PYS.setText(SelectContactUI.this.getString(R.string.gir, new Object[]{Integer.toString(SelectContactUI.this.PYW)}));
                        SelectContactUI.this.PYN.setBackground(SelectContactUI.this.getResources().getDrawable(R.drawable.asb));
                        AppMethodBeat.o(234029);
                        return;
                    } else {
                        SelectContactUI.this.PYO.setVisibility(0);
                        SelectContactUI.this.PYP.setVisibility(8);
                        SelectContactUI.this.PYR.setVisibility(8);
                        SelectContactUI.this.PYQ.setVisibility(8);
                        SelectContactUI.this.PYS.setTextColor(SelectContactUI.this.getResources().getColor(R.color.Brand_100));
                        SelectContactUI.this.PYS.setText(SelectContactUI.this.getString(R.string.gir, new Object[]{Integer.toString(SelectContactUI.this.PYW)}));
                        SelectContactUI.this.PYN.setBackground(SelectContactUI.this.getResources().getDrawable(R.drawable.asb));
                    }
                }
                AppMethodBeat.o(234029);
            }
        });
        AppMethodBeat.o(234052);
    }

    private ArrayList<String> Cs(boolean z) {
        AppMethodBeat.i(38007);
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        for (String str : this.zow) {
            if (z || !ab.IQ(str)) {
                hashSet.add(str);
            } else {
                List<String> Id = v.Id(str);
                if (Id != null) {
                    for (String str2 : Id) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        arrayList.addAll(hashSet);
        AppMethodBeat.o(38007);
        return arrayList;
    }

    private ArrayList<String> Ct(boolean z) {
        AppMethodBeat.i(38008);
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        for (String str : this.zow) {
            if (z || !ab.IQ(str)) {
                hashSet.add(str);
            } else {
                List<String> Id = v.Id(str);
                if (Id != null) {
                    for (String str2 : Id) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        hashSet.addAll(this.PYE);
        arrayList.addAll(hashSet);
        AppMethodBeat.o(38008);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public static class c implements Runnable {
        private ArrayList<String> PZA;
        private WeakReference<SelectContactUI> cMO;

        /* synthetic */ c(SelectContactUI selectContactUI, ArrayList arrayList, byte b2) {
            this(selectContactUI, arrayList);
        }

        private c(SelectContactUI selectContactUI, ArrayList<String> arrayList) {
            AppMethodBeat.i(37992);
            this.cMO = new WeakReference<>(selectContactUI);
            this.PZA = arrayList;
            AppMethodBeat.o(37992);
        }

        public final void run() {
            String str;
            AppMethodBeat.i(37993);
            SelectContactUI selectContactUI = this.cMO.get();
            if (selectContactUI == null) {
                AppMethodBeat.o(37993);
                return;
            }
            String aTY = z.aTY();
            Iterator<String> it = this.PZA.iterator();
            int i2 = 0;
            String str2 = null;
            while (it.hasNext()) {
                String next = it.next();
                Log.d("MicroMsg.SelectContactUI", "toSend, %s", next);
                i2 += ab.Eq(next) ? 1 : 0;
                o.e tc = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(4);
                tc.dRL = aTY;
                tc.toUser = next;
                tc.iZt = selectContactUI.getIntent().getStringExtra("shareImagePath");
                tc.iXp = 0;
                tc.jdS = null;
                tc.dQd = 0;
                tc.iXy = "";
                tc.thumbPath = "";
                tc.jdV = true;
                tc.jdU = R.drawable.c3h;
                tc.thumbPath = str2;
                tc.jdR = 11;
                o.b bdQ = tc.bdQ();
                bdQ.execute();
                n nVar = (n) bdQ.jdJ;
                if (nVar.bcD() != null) {
                    str = nVar.bcD().field_imgPath;
                } else {
                    str = str2;
                }
                str2 = str;
            }
            selectContactUI.gtM.dismiss();
            Intent intent = new Intent();
            intent.putStringArrayListExtra("Select_Contact", this.PZA);
            selectContactUI.setResult(-1, intent);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11048, 1, Integer.valueOf(this.PZA.size() - i2), Integer.valueOf(i2));
            selectContactUI.finish();
            AppMethodBeat.o(37993);
        }
    }

    private void gVi() {
        AppMethodBeat.i(38009);
        ArrayList<String> Cs = Cs(true);
        Cs.remove(z.aTY());
        if (Cs.size() > 0) {
            this.gtM = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.evg), false, (DialogInterface.OnCancelListener) null);
            bg.aAk().postToWorker(new c(this, Cs, (byte) 0));
        }
        AppMethodBeat.o(38009);
    }

    private void gVj() {
        AppMethodBeat.i(38010);
        ArrayList<String> Cs = Cs(false);
        Cs.remove(z.aTY());
        final String listToString = Util.listToString(Cs, ",");
        if (!Util.isNullOrNil(Cs)) {
            com.tencent.mm.ui.base.h.a((Context) getContext(), true, getString(R.string.eby), "", getString(R.string.ebx), getString(R.string.ebw), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(234030);
                    Log.i("MicroMsg.SelectContactUI", "return the result,and create new label");
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", listToString);
                    intent.putExtra("Select_Conv_User", listToString);
                    intent.putExtra("Select_Contact", listToString);
                    intent.putExtra("Select_Contacts_To_Create_New_Label", listToString);
                    SelectContactUI.this.setResult(-1, intent);
                    SelectContactUI.this.finish();
                    AppMethodBeat.o(234030);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(234031);
                    Log.i("MicroMsg.SelectContactUI", "return the result");
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", listToString);
                    intent.putExtra("Select_Conv_User", listToString);
                    intent.putExtra("Select_Contact", listToString);
                    SelectContactUI.this.setResult(-1, intent);
                    SelectContactUI.this.finish();
                    AppMethodBeat.o(234031);
                }
            });
            AppMethodBeat.o(38010);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", listToString);
        intent.putExtra("Select_Conv_User", listToString);
        intent.putExtra("Select_Contact", listToString);
        intent.putExtra("Select_Contacts_To_Create_New_Label", listToString);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(38010);
    }

    private void a(final com.tencent.mm.roomsdk.a.c.a aVar) {
        AppMethodBeat.i(38011);
        aVar.d(new com.tencent.mm.roomsdk.a.b.c() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass13 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
            @Override // com.tencent.mm.roomsdk.a.b.a
            public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.c cVar) {
                AppMethodBeat.i(234033);
                com.tencent.mm.roomsdk.a.b.c cVar2 = cVar;
                SelectContactUI.this.PZd = false;
                if (!z.a.a(SelectContactUI.this, i2, i3, str, 4)) {
                    if (i2 == 0 && i3 == 0 && !Util.isNullOrNil(this.chatroomName)) {
                        if (aVar.gvP()) {
                            u.a(this.chatroomName, cVar2.grX, SelectContactUI.this.getString(R.string.awr), false, "");
                        }
                        List<String> list = cVar2.dTa;
                        if (list != null && list.size() > 0) {
                            LinkedList linkedList = new LinkedList();
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                linkedList.add(list.get(i4));
                            }
                            String str2 = "weixin://findfriend/verifycontact/" + this.chatroomName + FilePathGenerator.ANDROID_DIR_SEP;
                            if (aVar.gvP()) {
                                u.a(this.chatroomName, linkedList, SelectContactUI.this.getString(R.string.aws), true, str2);
                            }
                        }
                        SelectContactUI.b(SelectContactUI.this, Util.stringsToList(new String[]{this.chatroomName}));
                    } else {
                        SelectContactUI.a(SelectContactUI.this, i2, i3, cVar2, str, aVar.gvP());
                        AppMethodBeat.o(234033);
                        return;
                    }
                }
                AppMethodBeat.o(234033);
            }
        });
        aVar.a(this, getString(R.string.zb), getString(R.string.edv), true, true, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass14 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(234034);
                SelectContactUI.this.PZd = false;
                aVar.cancel();
                AppMethodBeat.o(234034);
            }
        });
        anK(2);
        AppMethodBeat.o(38011);
    }

    private void anK(int i2) {
        int i3;
        AppMethodBeat.i(38012);
        if (this.PZj) {
            AppMethodBeat.o(38012);
            return;
        }
        this.PZj = true;
        if (getIntent().getBooleanExtra("create_group_recommend", false)) {
            switch (this.scene) {
                case 2:
                    i3 = 3;
                    break;
                case 3:
                    i3 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                default:
                    i3 = 0;
                    break;
                case 7:
                    i3 = 1;
                    break;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            for (String str : this.zow) {
                if (this.PYF.containsKey(str)) {
                    switch (this.PYF.get(str).intValue()) {
                        case 0:
                            i4++;
                            continue;
                        case 1:
                            i5++;
                            continue;
                        case 2:
                            i6++;
                            continue;
                        case 3:
                            i7++;
                            continue;
                        case 4:
                            i8++;
                            break;
                    }
                }
                i8 = i8;
            }
            Log.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(gUP().gUt()), Integer.valueOf(i2), Integer.valueOf(i7), Integer.valueOf(i8));
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(17535, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(gUP().gUt()), Integer.valueOf(i2), Integer.valueOf(i7), Integer.valueOf(i8));
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.PYE);
            linkedList.addAll(this.zow);
            w.jN(linkedList);
        }
        AppMethodBeat.o(38012);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(38013);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (!Util.isTopActivity(this)) {
            AppMethodBeat.o(38013);
        } else if (z.a.a(this, i2, i3, str, 4)) {
            AppMethodBeat.o(38013);
        } else if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 138:
                    gUP().notifyDataSetChanged();
                    break;
            }
            AppMethodBeat.o(38013);
        } else {
            if (i2 == 4 && i3 == -24 && !Util.isNullOrNil(str)) {
                Toast.makeText(this, str, 1).show();
            }
            AppMethodBeat.o(38013);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final int[] egI() {
        AppMethodBeat.i(38016);
        ArrayList arrayList = new ArrayList();
        arrayList.add(131072);
        if (!getIntent().getBooleanExtra("without_openim", false)) {
            arrayList.add(131081);
        }
        if (!u.hasAttr(this.PYo, 1)) {
            arrayList.add(131076);
        }
        if (!u.hasAttr(this.PYo, 4)) {
            arrayList.add(131075);
        }
        int[] iArr = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        AppMethodBeat.o(38016);
        return iArr;
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c
    public final void T(int i2, String str) {
        AppMethodBeat.i(38017);
        if (i2 == 1) {
            this.zow.remove(str);
            if (gUP() instanceof v) {
                this.zoy.getInputText().setText(((v) gUP()).gUO());
            } else if (gUP() instanceof c) {
                gUQ().and();
            } else {
                gUP().notifyDataSetChanged();
            }
            ani();
        }
        AppMethodBeat.o(38017);
    }

    private void bnA(String str) {
        boolean z;
        AppMethodBeat.i(38018);
        if (this.PYE.contains(str)) {
            AppMethodBeat.o(38018);
            return;
        }
        if (this.zow.contains(str)) {
            this.zow.remove(str);
            z = true;
        } else {
            this.zow.add(str);
            if (!(gUP() instanceof v)) {
                if (gUP() == gUQ()) {
                    if (((c) gUQ()).bnq(str)) {
                        this.PYF.put(str, 2);
                        z = false;
                    } else {
                        this.PYF.put(str, 0);
                    }
                }
                z = false;
            } else if (((v) gUP()).gVe()) {
                this.PYF.put(str, Integer.valueOf(((v) gUP()).bnw(str)));
                z = false;
            } else {
                this.PYF.put(str, 1);
                z = false;
            }
        }
        if (getIntent().getBooleanExtra("create_group_recommend", false)) {
            if (gUP() != gUQ()) {
                ((c) gUQ()).PTI.reset();
                gUQ().and();
                this.PWs.cIi();
                hideVKB();
            } else if (z || ((c) gUQ()).bnq(str)) {
                gUQ().and();
            }
        }
        if (gUP() instanceof v) {
            String gUO = ((v) gUP()).gUO();
            if (this.zoy != null) {
                this.zoy.getInputText().setText(gUO);
            }
        } else {
            gUW();
        }
        this.zoy.bev(str);
        AppMethodBeat.o(38018);
    }

    private String jQ(List<String> list) {
        AppMethodBeat.i(38019);
        String str = null;
        if (list != null) {
            if (list.size() == 1) {
                str = getString(R.string.ghh, new Object[]{com.tencent.mm.model.aa.getDisplayName(list.get(0))});
            } else if (list.size() > 1) {
                String string = getString(R.string.yu);
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    } else if (i2 == 3) {
                        sb.append("...");
                        break;
                    } else {
                        sb.append(com.tencent.mm.model.aa.getDisplayName(list.get(i2)));
                        if (i2 < list.size() - 1) {
                            sb.append(string);
                        }
                        i2++;
                    }
                }
                str = getString(R.string.ghh, new Object[]{sb.toString()});
            }
        }
        AppMethodBeat.o(38019);
        return str;
    }

    private static List<String> V(List<String> list) {
        AppMethodBeat.i(38020);
        LinkedList linkedList = new LinkedList();
        if (!bg.aAc()) {
            AppMethodBeat.o(38020);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.o(38020);
            return linkedList;
        } else {
            for (String str : list) {
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                    str = Kn.arJ();
                }
                linkedList.add(str);
            }
            AppMethodBeat.o(38020);
            return linkedList;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(38021);
        super.onActivityResult(i2, i3, intent);
        this.requestCode = i2;
        Log.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(38021);
            return;
        }
        switch (i2) {
            case 0:
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                if (!Util.isNullOrNil(stringExtra)) {
                    jO(Util.stringsToList(new String[]{stringExtra}));
                    AppMethodBeat.o(38021);
                    return;
                }
                break;
            case 1:
                String stringExtra2 = intent.getStringExtra("Select_Contact");
                if (!Util.isNullOrNil(stringExtra2)) {
                    jO(Util.stringsToList(stringExtra2.split(",")));
                    AppMethodBeat.o(38021);
                    return;
                }
                break;
            case 2:
                if (intent != null) {
                    String stringExtra3 = intent.getStringExtra("Select_Contact");
                    if (!Util.isNullOrNil(stringExtra3)) {
                        jO(Util.stringsToList(new String[]{stringExtra3}));
                    }
                    AppMethodBeat.o(38021);
                    return;
                }
                break;
            case 3:
                String stringExtra4 = intent.getStringExtra("Select_Contact");
                if (Util.isNullOrNil(stringExtra4)) {
                    Log.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                    AppMethodBeat.o(38021);
                    return;
                }
                Log.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", stringExtra4);
                if (u.hasAttr(this.PYo, 64)) {
                    String[] split = stringExtra4.split(",");
                    for (String str : split) {
                        if (this.zow.add(str)) {
                            this.zoy.bev(str);
                        }
                    }
                    ani();
                    gUP().notifyDataSetChanged();
                    AppMethodBeat.o(38021);
                    return;
                }
                jO(Util.stringsToList(new String[]{stringExtra4}));
                AppMethodBeat.o(38021);
                return;
            case 4:
                String stringExtra5 = intent.getStringExtra("Select_Conv_User");
                for (String str2 : this.zow) {
                    this.zoy.bew(str2);
                }
                this.zow.clear();
                if (!Util.isNullOrNil(stringExtra5)) {
                    this.zow.addAll(Util.stringsToList(stringExtra5.split(",")));
                }
                for (String str3 : this.zow) {
                    this.zoy.bex(str3);
                }
                ani();
                AppMethodBeat.o(38021);
                return;
            case 5:
                if (intent != null) {
                    String stringExtra6 = intent.getStringExtra("Select_Contact");
                    String stringExtra7 = intent.getStringExtra("Cancel_Select_Contact");
                    List<String> stringToList = Util.isNullOrNil(stringExtra6) ? null : Util.stringToList(stringExtra6, ",");
                    List<String> stringToList2 = Util.isNullOrNil(stringExtra7) ? null : Util.stringToList(stringExtra7, ",");
                    if (stringToList != null) {
                        if (this.zoy != null) {
                            for (String str4 : stringToList) {
                                if (!this.zow.contains(str4)) {
                                    this.zoy.bev(str4);
                                }
                            }
                        }
                        this.zow.addAll(stringToList);
                    }
                    if (stringToList2 != null) {
                        if (this.zoy != null) {
                            for (String str5 : stringToList2) {
                                this.zoy.bev(str5);
                            }
                        }
                        this.zow.removeAll(stringToList2);
                    }
                    gUP().notifyDataSetChanged();
                    if (getIntent().getBooleanExtra("Add_SendCard", false)) {
                        jO(Util.stringsToList(new String[]{stringExtra6}));
                    }
                }
                ani();
                AppMethodBeat.o(38021);
                return;
            case 6:
                if (intent != null) {
                    this.PYV = intent.getIntExtra("select_record_msg_num", 0);
                    this.PYW = this.PYV;
                    this.PZc = intent.getStringArrayListExtra("key_select_record_msg_black_list");
                    this.PZb = null;
                    this.PYY = false;
                    if (this.PYV == 0) {
                        this.PYX = false;
                        gVh();
                    } else {
                        this.PYX = true;
                        this.PsQ = intent.getLongExtra("select_record_min_msg_id", -1);
                        if (l.gNw() > 0 && l.gNw() < this.PYV) {
                            this.PYW = l.gNw();
                        }
                        gVh();
                        com.tencent.mm.plugin.selectrecord.b.a.eSu().CWW = cl.aWy();
                        this.PZa = l.c(this, "msginfo@fakeuser", true, this.gwx);
                        if (!((Boolean) this.PZa.second).booleanValue()) {
                            this.PZh.alive();
                        } else {
                            gVk();
                        }
                    }
                    com.tencent.mm.plugin.selectrecord.b.a.eSu().CWO.eJj = (long) this.PYW;
                    Log.i("MicroMsg.SelectContactUI", "GET_SELECT_RECORD_MSG selectMsgNum:%s actualSelectMsgNum:%s msgId:%s direct:%s", Integer.valueOf(this.PYV), Integer.valueOf(this.PYW), this.PZa.first, this.PZa.second);
                    break;
                }
                break;
        }
        AppMethodBeat.o(38021);
    }

    private void gVk() {
        AppMethodBeat.i(234053);
        Log.i("MicroMsg.SelectContactUI", "uploadRecordXml");
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(((Long) this.PZa.first).longValue());
        if (Hb.field_content == null) {
            Log.e("MicroMsg.SelectContactUI", "uploadRecordXml msgInfo.getContent() is null");
            AppMethodBeat.o(234053);
            return;
        }
        String bnB = bnB(Hb.field_content);
        if (Util.isNullOrNil(bnB)) {
            Log.e("MicroMsg.SelectContactUI", "uploadRecordXml filePath is null");
            AppMethodBeat.o(234053);
            return;
        }
        com.tencent.mm.i.g axk = axk(bnB);
        if (!f.baQ().f(axk)) {
            Log.e("MicroMsg.SelectContactUI", "hy: cdntra addSendTask failed. clientid:%s", axk.field_mediaId);
            m42do(0, "add to cdn failed");
        }
        Log.i("MicroMsg.SelectContactUI", "uploadRecordXml filePath：%s", bnB);
        AppMethodBeat.o(234053);
    }

    private static String bnB(String str) {
        AppMethodBeat.i(234054);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.SelectContactUI", "xml is null");
            AppMethodBeat.o(234054);
            return null;
        }
        String str2 = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
        if (!s.YS(str2)) {
            s.boN(str2);
        }
        try {
            String str3 = str2 + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
            if (s.YS(str3)) {
                s.deleteFile(str3);
            }
            byte[] bytes = str.getBytes();
            s.f(str3, bytes, bytes.length);
            com.tencent.mm.plugin.selectrecord.b.a.eSu().CWO.eNm = s.boW(str3);
            AppMethodBeat.o(234054);
            return str3;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SelectContactUI", e2, "", new Object[0]);
            AppMethodBeat.o(234054);
            return null;
        }
    }

    private com.tencent.mm.i.g axk(String str) {
        AppMethodBeat.i(234055);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.ehd = true;
        gVar.gqy = this.sPz;
        gVar.field_mediaId = arC(str);
        gVar.field_fullpath = str;
        gVar.field_thumbpath = "";
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
        gVar.field_talker = "";
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 0;
        gVar.field_bzScene = 0;
        this.PZk.put(gVar.field_mediaId, gVar.field_fullpath);
        AppMethodBeat.o(234055);
        return gVar;
    }

    private static String arC(String str) {
        AppMethodBeat.i(234056);
        String messageDigest = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + str).getBytes());
        AppMethodBeat.o(234056);
        return messageDigest;
    }

    /* renamed from: do  reason: not valid java name */
    private void m42do(int i2, String str) {
        AppMethodBeat.i(234057);
        Z(i2, str, "");
        AppMethodBeat.o(234057);
    }

    private void Z(int i2, String str, final String str2) {
        AppMethodBeat.i(234058);
        Log.i("MicroMsg.SelectContactUI", "triggerErrorCallback errCode:%s errMsg:%s", Integer.valueOf(i2), Util.nullAs(str, ""));
        this.PYY = true;
        this.PYX = false;
        gVh();
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(234038);
                com.tencent.mm.ui.base.h.a(SelectContactUI.this, Util.isNullOrNil(str2) ? SelectContactUI.this.getString(R.string.fwe) : str2, "", SelectContactUI.this.getString(R.string.j34), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass19.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(234037);
                        Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                        AppMethodBeat.o(234037);
                    }
                });
                AppMethodBeat.o(234038);
            }
        });
        com.tencent.mm.plugin.selectrecord.b.a.eSu().IG(cl.aWy());
        com.tencent.mm.plugin.selectrecord.b.a.eSu().eSy();
        AppMethodBeat.o(234058);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final boolean eim() {
        if (this.PZf) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI
    public final void aDT(String str) {
        AppMethodBeat.i(38022);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11225, 1, 0);
        Intent intent = new Intent();
        intent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
        intent.putExtra("label", str);
        HashSet hashSet = new HashSet();
        hashSet.addAll(Cs(u.hasAttr(this.PYo, 8192)));
        hashSet.addAll(this.PYE);
        intent.putExtra("always_select_contact", Util.listToString(new ArrayList(hashSet), ","));
        intent.putExtra("always_select_contact", Util.listToString(new ArrayList(hashSet), ","));
        if (u.hasAttr(this.PYo, 64)) {
            intent.putExtra("list_attr", u.Q(16384, 64, 131072));
            if (this.PSP == 14) {
                intent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE));
            }
        } else {
            intent.putExtra("list_attr", 16384);
        }
        startActivityForResult(intent, 3);
        AppMethodBeat.o(38022);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private AlphaAnimation PZw;
        private AlphaAnimation PZx;
        boolean PZy = false;
        TextView nnM;

        a() {
        }

        public final void e(final Activity activity, int i2, int i3) {
            AppMethodBeat.i(37988);
            if (i3 <= 0 || i2 != i3 + 1 || this.PZy) {
                if (i2 < i3) {
                    bs(activity);
                    this.PZy = false;
                }
                AppMethodBeat.o(37988);
                return;
            }
            if (this.nnM == null) {
                this.nnM = (TextView) activity.findViewById(R.id.hhg);
            }
            if (this.nnM.getVisibility() != 0) {
                this.nnM.setText(R.string.g5z);
                this.nnM.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(37986);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a.this.PZy = true;
                        a.this.bs(activity);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(37986);
                    }
                });
                if (this.PZw == null) {
                    this.PZw = new AlphaAnimation(0.0f, 1.0f);
                }
                this.PZw.setDuration(300);
                if (this.PZx != null) {
                    this.PZx.cancel();
                }
                this.nnM.setVisibility(0);
                this.nnM.startAnimation(this.PZw);
            }
            AppMethodBeat.o(37988);
        }

        /* access modifiers changed from: package-private */
        public final void bs(Activity activity) {
            AppMethodBeat.i(37989);
            if (this.nnM == null) {
                this.nnM = (TextView) activity.findViewById(R.id.hhg);
            }
            if (this.nnM.getVisibility() == 8) {
                AppMethodBeat.o(37989);
                return;
            }
            if (this.PZx == null) {
                this.PZx = new AlphaAnimation(1.0f, 0.0f);
                this.PZx.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.ui.contact.SelectContactUI.a.AnonymousClass2 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(37987);
                        a.this.nnM.setVisibility(8);
                        AppMethodBeat.o(37987);
                    }
                });
            }
            this.PZx.setDuration(300);
            if (this.PZw != null) {
                this.PZw.cancel();
            }
            this.nnM.startAnimation(this.PZx);
            AppMethodBeat.o(37989);
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(38014);
        if (aVar.PWh && aVar.contact != null) {
            boolean contains = this.zow.contains(aVar.contact.field_username);
            AppMethodBeat.o(38014);
            return contains;
        } else if (aVar.PWi && aVar.contact != null) {
            boolean contains2 = this.zow.contains(aVar.contact.field_username);
            AppMethodBeat.o(38014);
            return contains2;
        } else if (aVar instanceof k) {
            boolean isEmpty = this.zow.isEmpty();
            AppMethodBeat.o(38014);
            return isEmpty;
        } else {
            AppMethodBeat.o(38014);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.contact.n
    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        AppMethodBeat.i(38015);
        if (!aVar.PWh || aVar.contact == null) {
            AppMethodBeat.o(38015);
            return false;
        } else if (u.hasAttr(this.PYo, 536870912)) {
            boolean arD = aVar.contact.arD();
            AppMethodBeat.o(38015);
            return arD;
        } else {
            boolean contains = this.PYE.contains(aVar.contact.field_username);
            AppMethodBeat.o(38015);
            return contains;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008c, code lost:
        if (((java.lang.Integer) com.tencent.mm.model.c.azQ().get(com.tencent.mm.storage.ar.a.USERINFO_OPEN_IM_CREATE_ROOM_LOCAL_SWITCH_INT, (java.lang.Object) 1)).intValue() != 0) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean r(com.tencent.mm.ui.contact.SelectContactUI r8) {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.SelectContactUI.r(com.tencent.mm.ui.contact.SelectContactUI):boolean");
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, int i2, int i3, com.tencent.mm.roomsdk.a.b.c cVar, String str, boolean z) {
        String str2;
        boolean z2;
        AppMethodBeat.i(234065);
        String str3 = "";
        String str4 = "";
        String string = MMApplicationContext.getContext().getString(R.string.awt);
        if (!z) {
            if (cVar != null && !Util.isNullOrNil(cVar.KHy)) {
                com.tencent.mm.ui.base.h.c(selectContactUI, cVar.KHy, "", true);
                AppMethodBeat.o(234065);
                return;
            } else if (!z && !Util.isNullOrNil(str)) {
                com.tencent.mm.ui.base.h.c(selectContactUI, str, "", true);
                AppMethodBeat.o(234065);
                return;
            }
        }
        if (i3 == -23) {
            str3 = selectContactUI.getString(R.string.g84);
            str4 = selectContactUI.getString(R.string.g83);
        }
        List<String> list = cVar.dTa;
        List<String> list2 = cVar.grY;
        if (list == null || list.size() <= 0 || (list.size() != cVar.dRN && (list2 == null || list2.size() <= 0 || cVar.dRN != list.size() + list2.size()))) {
            List<String> list3 = cVar.grY;
            if (list3 == null || list3.size() <= 0 || cVar.dRN != list3.size()) {
                str2 = str4;
            } else {
                str3 = selectContactUI.getString(R.string.edt);
                str2 = str4 + selectContactUI.getString(R.string.deq, new Object[]{Util.listToString(V(list3), string)});
            }
            List<String> list4 = cVar.dSX;
            if (list4 != null && list4.size() > 0) {
                Iterator<String> it = list4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (as.bjp(it.next())) {
                            str3 = selectContactUI.getString(R.string.edt);
                            str2 = selectContactUI.getString(R.string.edu);
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    str3 = selectContactUI.getString(R.string.edt);
                    str2 = str2 + selectContactUI.getString(R.string.det, new Object[]{Util.listToString(V(list4), string)});
                }
            }
            if (str3 == null || str3.length() <= 0) {
                Toast.makeText(selectContactUI, selectContactUI.getString(R.string.deb, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                AppMethodBeat.o(234065);
                return;
            }
            com.tencent.mm.ui.base.h.c(selectContactUI, str2, str3, true);
            AppMethodBeat.o(234065);
            return;
        }
        final LinkedList linkedList = new LinkedList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            linkedList.add(list.get(i4));
        }
        Assert.assertTrue(linkedList.size() > 0);
        String string2 = MMApplicationContext.getContext().getString(R.string.awt);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(linkedList);
        arrayList.addAll(list2);
        com.tencent.mm.ui.base.h.a((Context) selectContactUI, selectContactUI.getString(R.string.df2, new Object[]{Util.listToString(V(arrayList), string2)}), selectContactUI.getString(R.string.edt), selectContactUI.getString(R.string.df1), selectContactUI.getString(R.string.df0), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass16 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(234035);
                SelectContactUI.a(SelectContactUI.this, linkedList);
                AppMethodBeat.o(234035);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(234065);
    }

    static /* synthetic */ void a(SelectContactUI selectContactUI, LinkedList linkedList) {
        AppMethodBeat.i(234067);
        Assert.assertTrue(linkedList.size() > 0);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            linkedList2.add(3);
        }
        new com.tencent.mm.pluginsdk.ui.applet.aa(selectContactUI, new aa.a() {
            /* class com.tencent.mm.ui.contact.SelectContactUI.AnonymousClass17 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.aa.a
            /* renamed from: do  reason: not valid java name */
            public final void m43do(boolean z) {
            }
        }).a(linkedList, linkedList2, null);
        AppMethodBeat.o(234067);
    }
}
