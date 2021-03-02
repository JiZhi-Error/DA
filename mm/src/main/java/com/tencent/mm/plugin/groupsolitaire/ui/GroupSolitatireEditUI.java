package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.c;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.plugin.groupsolitaire.ui.a;
import com.tencent.mm.plugin.groupsolitaire.ui.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class GroupSolitatireEditUI extends MMActivity implements g {
    private GestureDetector aYg;
    private TextWatcher aws = new TextWatcher() {
        /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass1 */

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(110427);
            long currentTimeMillis = System.currentTimeMillis();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
            if (GroupSolitatireEditUI.this.yge instanceof MMEditText) {
                String obj = editable.toString();
                try {
                    obj = ((a) com.tencent.mm.kernel.g.af(a.class)).alW(obj);
                } catch (Exception e2) {
                    Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() emojiSoftBank2Unicode %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                }
                int intValue = ((Integer) ((MMEditText) GroupSolitatireEditUI.this.yge).getTag(R.id.dlw)).intValue();
                Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", obj, Integer.valueOf(intValue));
                int aBl = b.aBl(obj);
                switch (intValue) {
                    case 1:
                        if (aBl > b.dXP() * 2) {
                            int em = b.em(obj, b.dXP() * 2);
                            editable.delete(em, obj.length());
                            obj = obj.substring(0, em);
                        }
                        GroupSolitatireEditUI.this.ygi.header = obj;
                        GroupSolitatireEditUI.this.ygi.yfC = 1;
                        break;
                    case 2:
                        GroupSolitatireEditUI.this.ygi.yfB = obj;
                        break;
                    case 3:
                        com.tencent.mm.plugin.groupsolitaire.c.b bVar = (com.tencent.mm.plugin.groupsolitaire.c.b) ((MMEditText) GroupSolitatireEditUI.this.yge).getTag(R.id.dlu);
                        if (bVar != null) {
                            if (aBl > b.dXO() * 2) {
                                int em2 = b.em(obj, b.dXO() * 2);
                                editable.delete(em2, obj.length());
                                obj = obj.substring(0, em2);
                            }
                            bVar.content = obj;
                            break;
                        }
                        break;
                    case 4:
                        if (aBl > b.dXQ() * 2) {
                            int em3 = b.em(obj, b.dXQ() * 2);
                            editable.delete(em3, obj.length());
                            obj = obj.substring(0, em3);
                        }
                        GroupSolitatireEditUI.this.ygi.xxN = obj;
                        break;
                }
            }
            GroupSolitatireEditUI.d(GroupSolitatireEditUI.this);
            GroupSolitatireEditUI.this.yge.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(110426);
                    GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.this.xfU);
                    AppMethodBeat.o(110426);
                }
            }, 100);
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "startTime:%s interTime:%s", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(110427);
        }
    };
    private boolean dAE = false;
    private ah gtd;
    private h gyh;
    private TextView jVn;
    private ScrollView lTw;
    private RelativeLayout onl;
    private int scene;
    private boolean thl = false;
    private boolean xfU = false;
    private CdnImageView yfS;
    private MMEditText yfT;
    private View yfU;
    private View yfV;
    private LinearLayout yfW;
    private ImageButton yfX;
    private MMEditText yfY;
    private LinearLayout yfZ;
    private RelativeLayout yga;
    private RelativeLayout ygb;
    private RelativeLayout ygc;
    private View ygd;
    private View yge;
    private boolean ygf = false;
    private int ygg;
    private int ygh;
    private com.tencent.mm.plugin.groupsolitaire.c.a ygi = null;
    private com.tencent.mm.plugin.groupsolitaire.c.a ygj = null;
    private String ygk = "";
    private boolean ygl = false;
    private boolean ygm = false;
    private boolean ygn = false;
    private ArrayList<View> ygo = new ArrayList<>();
    private Rect ygp;
    private Rect ygq;
    private a ygr;
    private View.OnTouchListener ygs = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass12 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(110438);
            if (motionEvent.getActionMasked() == 1 && (view instanceof MMEditText) && GroupSolitatireEditUI.this.ygl) {
                ((MMEditText) view).setCursorVisible(true);
            }
            if (motionEvent.getActionMasked() == 1 && (view instanceof MMEditText) && ((Integer) ((MMEditText) view).getTag(R.id.dlw)).intValue() == 3 && GroupSolitatireEditUI.this.ygn) {
                ((MMEditText) view).setCursorVisible(true);
            }
            if (GroupSolitatireEditUI.c((MMEditText) view)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                GroupSolitatireEditUI.this.ygm = true;
                if (motionEvent.getAction() == 1) {
                    GroupSolitatireEditUI.this.ygm = false;
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            AppMethodBeat.o(110438);
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GroupSolitatireEditUI() {
        AppMethodBeat.i(110460);
        AppMethodBeat.o(110460);
    }

    static /* synthetic */ void a(GroupSolitatireEditUI groupSolitatireEditUI) {
        AppMethodBeat.i(110486);
        groupSolitatireEditUI.dYd();
        AppMethodBeat.o(110486);
    }

    static /* synthetic */ void a(GroupSolitatireEditUI groupSolitatireEditUI, String str) {
        AppMethodBeat.i(110492);
        groupSolitatireEditUI.aBq(str);
        AppMethodBeat.o(110492);
    }

    static /* synthetic */ boolean h(GroupSolitatireEditUI groupSolitatireEditUI) {
        AppMethodBeat.i(110490);
        boolean amI = groupSolitatireEditUI.amI();
        AppMethodBeat.o(110490);
        return amI;
    }

    static /* synthetic */ void j(GroupSolitatireEditUI groupSolitatireEditUI) {
        AppMethodBeat.i(110491);
        groupSolitatireEditUI.dYc();
        AppMethodBeat.o(110491);
    }

    static /* synthetic */ int o(GroupSolitatireEditUI groupSolitatireEditUI) {
        AppMethodBeat.i(194448);
        int dXX = groupSolitatireEditUI.dXX();
        AppMethodBeat.o(194448);
        return dXX;
    }

    static /* synthetic */ void p(GroupSolitatireEditUI groupSolitatireEditUI) {
        AppMethodBeat.i(194449);
        groupSolitatireEditUI.pZ(false);
        AppMethodBeat.o(194449);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.atz;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        com.tencent.mm.plugin.groupsolitaire.c.a aVar;
        boolean z;
        AppMethodBeat.i(110461);
        super.onCreate(bundle);
        this.ygl = getIntent().getBooleanExtra("key_group_solitatire_create", false);
        String stringExtra = getIntent().getStringExtra("key_group_solitatire_key");
        this.ygk = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
        this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
        if (this.scene == 3 || dXZ()) {
            c groupSolitatireManager = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager();
            String str = this.ygk;
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", str, stringExtra);
            aVar = groupSolitatireManager.yfg.get(str + stringExtra);
        } else {
            aVar = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(this.ygk, stringExtra);
        }
        if (aVar == null) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s temp == null", stringExtra);
            finish();
            z = false;
        } else {
            this.ygi = aVar.dXV();
            if (this.ygi == null) {
                Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", stringExtra);
                finish();
                z = false;
            } else {
                this.ygj = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(this.ygk, this.ygi.field_key);
                this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.ygk);
                setResult(0);
                z = true;
            }
        }
        if (!z) {
            AppMethodBeat.o(110461);
            return;
        }
        initView();
        AppMethodBeat.o(110461);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(110462);
        if (i2 == 4) {
            if (!this.xfU) {
                amI();
            }
            AppMethodBeat.o(110462);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(110462);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        AppMethodBeat.i(110463);
        super.initView();
        setMMTitle(getString(R.string.dwg));
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.BW_93));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass20 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(110448);
                boolean h2 = GroupSolitatireEditUI.h(GroupSolitatireEditUI.this);
                AppMethodBeat.o(110448);
                return h2;
            }
        });
        this.gyh = new h(getContext());
        this.gyh.Quk = this;
        this.lTw = (ScrollView) findViewById(R.id.h9a);
        this.onl = (RelativeLayout) findViewById(R.id.h8y);
        this.yfS = (CdnImageView) findViewById(R.id.dlr);
        this.jVn = (TextView) findViewById(R.id.dls);
        this.yfT = (MMEditText) findViewById(R.id.dlx);
        this.yfU = findViewById(R.id.dm3);
        this.yfV = findViewById(R.id.dm4);
        this.yfW = (LinearLayout) findViewById(R.id.dlt);
        this.yfX = (ImageButton) findViewById(R.id.dlv);
        this.yfY = (MMEditText) findViewById(R.id.dm6);
        this.yfZ = (LinearLayout) findViewById(R.id.dly);
        this.yga = (RelativeLayout) findViewById(R.id.dlz);
        this.ygb = (RelativeLayout) findViewById(R.id.dm0);
        this.ygc = (RelativeLayout) findViewById(R.id.dm1);
        this.ygd = findViewById(R.id.dm5);
        this.yga.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass22 */

            public final void onClick(View view) {
                AppMethodBeat.i(110450);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
                GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
                GroupSolitatireEditUI.this.OI(2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110450);
            }
        });
        this.ygb.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass23 */

            public final void onClick(View view) {
                AppMethodBeat.i(110453);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
                if ((GroupSolitatireEditUI.this.yge instanceof MMEditText) && (GroupSolitatireEditUI.this.yge.getParent() instanceof RelativeLayout)) {
                    ((RelativeLayout) GroupSolitatireEditUI.this.yge.getParent()).setTag(1);
                }
                final a aVar = new a(GroupSolitatireEditUI.this);
                aVar.yfN = new a.AbstractC1428a() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass23.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.groupsolitaire.ui.a.AbstractC1428a
                    public final void aBp(String str) {
                        AppMethodBeat.i(110451);
                        aVar.hide();
                        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, str);
                        GroupSolitatireEditUI.this.OI(5);
                        AppMethodBeat.o(110451);
                    }

                    @Override // com.tencent.mm.plugin.groupsolitaire.ui.a.AbstractC1428a
                    public final void onCancel() {
                        AppMethodBeat.i(110452);
                        aVar.hide();
                        AppMethodBeat.o(110452);
                    }
                };
                GroupSolitatireEditUI.this.ygr = aVar;
                aVar.show();
                GroupSolitatireEditUI.this.OI(4);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110453);
            }
        });
        this.ygc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass24 */

            public final void onClick(View view) {
                int i2;
                int i3;
                int i4;
                AppMethodBeat.i(110455);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
                if ((GroupSolitatireEditUI.this.yge instanceof MMEditText) && (GroupSolitatireEditUI.this.yge.getParent() instanceof RelativeLayout)) {
                    ((RelativeLayout) GroupSolitatireEditUI.this.yge.getParent()).setTag(1);
                }
                b bVar2 = new b(GroupSolitatireEditUI.this);
                if (bVar2.yfP != null) {
                    i2 = bVar2.yfP.getYear();
                } else {
                    i2 = 0;
                }
                if (bVar2.yfP != null) {
                    i3 = bVar2.yfP.getMonth();
                } else {
                    i3 = 0;
                }
                if (bVar2.yfP != null) {
                    i4 = bVar2.yfP.getDayOfMonth();
                } else {
                    i4 = 0;
                }
                bVar2.yfQ = new b.a() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass24.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.groupsolitaire.ui.b.a
                    public final void onResult(boolean z, int i2, int i3, int i4) {
                        AppMethodBeat.i(110454);
                        if (z) {
                            Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", String.format(Locale.US, "%04d-%02d-%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
                            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, String.format(Locale.US, "%04d/%02d/%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
                            GroupSolitatireEditUI.this.OI(1);
                        }
                        AppMethodBeat.o(110454);
                    }
                };
                if (i2 >= 0 && i3 >= 0 && i4 >= 0 && bVar2.yfP != null) {
                    bVar2.yfP.a(i2, i3, i4, null);
                }
                Calendar instance = Calendar.getInstance(Locale.US);
                instance.set(2009, 0, 1);
                if (bVar2.yfP != null) {
                    bVar2.yfP.setMinDate(instance.getTimeInMillis());
                }
                Calendar instance2 = Calendar.getInstance(Locale.US);
                instance2.set(TXLiteAVCode.EVT_MIC_RELEASE_SUCC, 11, 31);
                if (bVar2.yfP != null) {
                    bVar2.yfP.setMaxDate(instance2.getTimeInMillis());
                }
                if (bVar2.yfL != null) {
                    if (bVar2.yfP != null) {
                        bVar2.yfP.ccq();
                    }
                    bVar2.yfL.show();
                }
                GroupSolitatireEditUI.this.OI(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(110455);
            }
        });
        addTextOptionMenu(0, getString(R.string.dw9), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass25 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(110458);
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", Boolean.valueOf(GroupSolitatireEditUI.this.dAE));
                if (GroupSolitatireEditUI.this.dAE) {
                    AppMethodBeat.o(110458);
                } else {
                    com.tencent.mm.plugin.groupsolitaire.b.b.a(GroupSolitatireEditUI.this.ygk, z.aTY(), GroupSolitatireEditUI.this.ygi);
                    if (GroupSolitatireEditUI.this.ygi.yfF) {
                        com.tencent.mm.ui.base.h.c(GroupSolitatireEditUI.this.getContext(), GroupSolitatireEditUI.this.getString(R.string.dw7), "", GroupSolitatireEditUI.this.getString(R.string.dw6), GroupSolitatireEditUI.this.getString(R.string.dw5), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass25.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(110456);
                                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
                                GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
                                AppMethodBeat.o(110456);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass25.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(110457);
                                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
                                AppMethodBeat.o(110457);
                            }
                        });
                    } else {
                        GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
                    }
                    AppMethodBeat.o(110458);
                }
                return true;
            }
        }, null, t.b.GREEN);
        if (this.ygl) {
            enableOptionMenu(0, true);
        } else {
            enableOptionMenu(0, false);
        }
        final AnonymousClass26 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(110459);
                Bitmap a2 = com.tencent.mm.aj.c.a(GroupSolitatireEditUI.this.ygi.field_creator, false, -1, null);
                if (a2 == null) {
                    GroupSolitatireEditUI.this.yfS.setImageResource(R.drawable.bca);
                    AppMethodBeat.o(110459);
                    return;
                }
                GroupSolitatireEditUI.this.yfS.setImageBitmap(a2);
                AppMethodBeat.o(110459);
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r0.run();
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(110428);
                    r0.run();
                    AppMethodBeat.o(110428);
                }
            });
        }
        if (this.ygi.yfE.size() > 0) {
            HashSet hashSet = new HashSet();
            for (int i3 = 1; i3 <= this.ygi.yfE.size(); i3++) {
                hashSet.add(this.ygi.yfE.get(Integer.valueOf(i3)).username);
            }
            i2 = hashSet.size();
        } else {
            i2 = 0;
        }
        this.jVn.setText(getString(R.string.dwi, new Object[]{bK(this.ygi.field_creator, true), String.valueOf(i2)}));
        if (!Util.isNullOrNil(this.ygi.header) && this.ygi.yfC == 1) {
            String str = this.ygi.header;
            if (str != null && com.tencent.mm.plugin.groupsolitaire.b.b.aBl(str) > com.tencent.mm.plugin.groupsolitaire.b.b.dXP() * 2) {
                str = str.substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.em(str, com.tencent.mm.plugin.groupsolitaire.b.b.dXP() * 2));
                this.ygi.header = str;
            }
            Context context = this.yfT.getContext();
            this.yfT.getTextSize();
            this.yfT.setText(l.f(context, str, 1));
        } else if (!this.ygl) {
            this.yfT.setVisibility(8);
            this.yfU.setVisibility(8);
        } else {
            this.yfT.setHint(R.string.dwh);
        }
        if (this.ygl && !Util.isNullOrNil(this.ygi.header) && this.ygi.yfC == 0) {
            this.ygi.yfC = 1;
            this.ygi.header = "";
            if (this.ygi.yfE.size() > 0 && this.ygi.yfE.get(1).yfH == 1) {
                this.ygi.yfE.get(1).yfH = 0;
            }
        }
        if (!Util.isNullOrNil(this.ygi.xxN)) {
            Context context2 = this.yfY.getContext();
            String str2 = this.ygi.xxN;
            this.yfY.getTextSize();
            this.yfY.setText(l.f(context2, str2, 1));
        } else if (!this.ygl) {
            this.yfY.setVisibility(8);
        } else {
            this.yfY.setHint(R.string.dw_);
        }
        if (this.ygl) {
            this.yfT.setFocusable(true);
            this.yfT.setFocusableInTouchMode(true);
            this.yfT.requestFocus();
            this.yfT.setOnTouchListener(this.ygs);
            if (Util.isNullOrNil(this.ygi.header)) {
                this.yfT.setHeight(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 160));
            }
            this.yfT.addTextChangedListener(this.aws);
            this.yfT.setMaxLines(10);
            this.yfY.setFocusable(true);
            this.yfY.setFocusableInTouchMode(true);
            this.yfY.addTextChangedListener(this.aws);
            this.yfY.setOnTouchListener(this.ygs);
            this.yfY.setMaxLines(10);
        } else {
            this.yfT.setKeyListener(null);
            this.yfT.setTextIsSelectable(true);
            this.yfY.setKeyListener(null);
            this.yfY.setTextIsSelectable(true);
        }
        this.yfT.setTag(R.id.dlw, 1);
        this.yfY.setTag(R.id.dlw, 4);
        if (!Util.isNullOrNil(this.ygi.yfB) || this.ygl) {
            View inflate = getLayoutInflater().inflate(R.layout.aty, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.dlq)).setText(getString(R.string.dw0));
            MMEditText mMEditText = (MMEditText) inflate.findViewById(R.id.dlp);
            mMEditText.setTag(R.id.dlw, 2);
            if (!Util.isNullOrNil(this.ygi.yfB)) {
                mMEditText.setText(l.e(mMEditText.getContext(), (CharSequence) this.ygi.yfB, (int) mMEditText.getTextSize()));
                this.ygf = false;
            } else {
                mMEditText.setHint(R.string.dvz);
                this.ygf = true;
            }
            if (this.ygl) {
                mMEditText.setFocusable(true);
                mMEditText.setFocusableInTouchMode(true);
                mMEditText.addTextChangedListener(this.aws);
            } else {
                mMEditText.setTextColor(getResources().getColor(R.color.BW_50));
                mMEditText.setKeyListener(null);
                mMEditText.setTextIsSelectable(true);
            }
            mMEditText.setOnTouchListener(this.ygs);
            mMEditText.setMaxLines(10);
            this.yfW.addView(inflate);
        }
        dYa();
        if (this.ygi.yfE.size() < com.tencent.mm.plugin.groupsolitaire.b.b.dXN()) {
            this.yfX.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(110431);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    GroupSolitatireEditUI.p(GroupSolitatireEditUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(110431);
                }
            });
        }
        if (this.scene == 2 || ((dXY() && this.ygi.yfG > 0) || this.scene == 5)) {
            pZ(true);
            if (this.ygl && dXZ()) {
                this.yfT.requestFocus();
            }
        } else if (this.scene == 1) {
            this.lTw.post(new Runnable() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass21 */

                public final void run() {
                    AppMethodBeat.i(110449);
                    GroupSolitatireEditUI.this.lTw.fullScroll(33);
                    AppMethodBeat.o(110449);
                }
            });
        }
        if (this.ygl) {
            this.ygj = this.ygi.dXV();
        }
        dYd();
        qa(true);
        a(this.yfY);
        a(this.yfT);
        this.aYg = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass19 */

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(194442);
                if (!GroupSolitatireEditUI.this.ygm) {
                    GroupSolitatireEditUI.this.hideVKB();
                }
                AppMethodBeat.o(194442);
                return false;
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(194443);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(194443);
                return false;
            }

            public final void onShowPress(MotionEvent motionEvent) {
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(194444);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(194444);
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }
        });
        this.ygp = new Rect();
        this.ygq = new Rect();
        AppMethodBeat.o(110463);
    }

    private boolean amI() {
        AppMethodBeat.i(110464);
        if (this.thl) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dvt), "", getString(R.string.dvs), getString(R.string.dvr), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110429);
                    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
                    ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                    d.a(GroupSolitatireEditUI.this.ygi, GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.this.ygl);
                    GroupSolitatireEditUI.this.finish();
                    AppMethodBeat.o(110429);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(110430);
                    Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot cancel");
                    AppMethodBeat.o(110430);
                }
            }, (int) R.color.a5c);
        } else {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.a(this.ygi, dXX(), 1, this.ygl);
            finish();
        }
        AppMethodBeat.o(110464);
        return true;
    }

    private int dXX() {
        AppMethodBeat.i(110465);
        if (dXY()) {
            AppMethodBeat.o(110465);
            return 3;
        }
        int i2 = this.scene;
        AppMethodBeat.o(110465);
        return i2;
    }

    private boolean dXY() {
        if (this.scene == 3 || this.scene == 4) {
            return true;
        }
        return false;
    }

    private boolean dXZ() {
        if (this.scene == 4 || this.scene == 5) {
            return true;
        }
        return false;
    }

    private void dYa() {
        int i2;
        AppMethodBeat.i(110466);
        int i3 = 1;
        int i4 = 1;
        while (i3 <= this.ygi.yfE.size()) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = this.ygi.yfE.get(Integer.valueOf(i3));
            if (bVar != null) {
                View inflate = getLayoutInflater().inflate(R.layout.aty, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.dlq)).setText(String.valueOf(i4));
                MMEditText mMEditText = (MMEditText) inflate.findViewById(R.id.dlp);
                mMEditText.setTag(R.id.dlw, 3);
                mMEditText.setTag(R.id.dlu, bVar);
                mMEditText.setText(l.e(mMEditText.getContext(), (CharSequence) bVar.content, (int) mMEditText.getTextSize()));
                if (Util.isEqual(bVar.username, z.aTY())) {
                    this.ygn = true;
                    mMEditText.requestFocus();
                    mMEditText.setFocusable(true);
                    mMEditText.setFocusableInTouchMode(true);
                    mMEditText.addTextChangedListener(this.aws);
                    if (this.scene == 1) {
                        mMEditText.setCursorVisible(false);
                    }
                } else {
                    this.ygn = false;
                    mMEditText.setTextColor(getResources().getColor(R.color.BW_50));
                    mMEditText.setKeyListener(null);
                    mMEditText.setTextIsSelectable(true);
                }
                mMEditText.setOnTouchListener(this.ygs);
                mMEditText.setMaxLines(10);
                this.yfW.addView(inflate);
                this.ygo.add(inflate);
                a(mMEditText);
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        AppMethodBeat.o(110466);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(110467);
        super.onResume();
        this.lTw.post(new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(110432);
                if (GroupSolitatireEditUI.this.gyh != null) {
                    GroupSolitatireEditUI.this.gyh.start();
                }
                AppMethodBeat.o(110432);
            }
        });
        if (this.scene == 2 || dXY() || this.scene == 5) {
            this.yfW.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(110433);
                    GroupSolitatireEditUI.this.showVKB();
                    AppMethodBeat.o(110433);
                }
            }, 200);
        }
        AppMethodBeat.o(110467);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(110468);
        super.onPause();
        if (this.gyh != null) {
            this.gyh.close();
        }
        AppMethodBeat.o(110468);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(110469);
        super.finish();
        try {
            hideVKB();
            AppMethodBeat.o(110469);
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "finish() hideVKB() %s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(110469);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(110470);
        super.onDestroy();
        AppMethodBeat.o(110470);
    }

    private void pZ(boolean z) {
        AppMethodBeat.i(194445);
        com.tencent.mm.plugin.groupsolitaire.c.b bVar = new com.tencent.mm.plugin.groupsolitaire.c.b();
        View inflate = getLayoutInflater().inflate(R.layout.aty, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.dlq)).setText(new StringBuilder().append(this.ygi.yfE.size() + 1).toString());
        MMEditText mMEditText = (MMEditText) inflate.findViewById(R.id.dlp);
        CharSequence bK = bK(z.aTY(), false);
        if (!Util.isNullOrNil(bK)) {
            mMEditText.setText(((Object) bK) + " ");
            bVar.content = String.valueOf(bK);
        }
        bVar.username = z.aTY();
        bVar.separator = this.ygi.separator;
        bVar.yfI = this.ygi.yfE.size() + 1;
        mMEditText.setTag(R.id.dlw, 3);
        mMEditText.setTag(R.id.dlu, bVar);
        mMEditText.requestFocus();
        mMEditText.setFocusable(true);
        mMEditText.setFocusableInTouchMode(true);
        mMEditText.addTextChangedListener(this.aws);
        mMEditText.setOnTouchListener(this.ygs);
        a(mMEditText);
        mMEditText.setMaxLines(10);
        this.ygi.yfE.put(Integer.valueOf(this.ygi.yfE.size() + 1), bVar);
        this.yfW.addView(inflate);
        this.ygo.add(inflate);
        inflate.post(new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(110434);
                GroupSolitatireEditUI.this.showVKB();
                AppMethodBeat.o(110434);
            }
        });
        qa(z);
        AppMethodBeat.o(194445);
    }

    private CharSequence bK(String str, boolean z) {
        String DH;
        AppMethodBeat.i(110472);
        com.tencent.mm.kernel.g.aAi();
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
        if (!z || Util.isNullOrNil(Kn.field_conRemark)) {
            DH = DH(Kn.field_username);
        } else {
            DH = Kn.field_conRemark;
        }
        if (Util.isNullOrNil(DH)) {
            DH = Kn.field_conRemark;
        }
        if (Util.isNullOrNil(DH)) {
            DH = Kn.arI();
        }
        if (Util.isNullOrNil(DH)) {
            DH = Kn.field_username;
        }
        SpannableString c2 = l.c(getContext(), DH);
        AppMethodBeat.o(110472);
        return c2;
    }

    private String DH(String str) {
        AppMethodBeat.i(110473);
        if (this.gtd == null) {
            AppMethodBeat.o(110473);
            return null;
        }
        String displayName = this.gtd.getDisplayName(str);
        AppMethodBeat.o(110473);
        return displayName;
    }

    private void qa(boolean z) {
        boolean z2;
        AppMethodBeat.i(110475);
        int i2 = 1;
        while (true) {
            if (i2 > this.ygi.yfE.size()) {
                z2 = false;
                break;
            }
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = this.ygi.yfE.get(Integer.valueOf(i2));
            if (bVar != null && !Util.isNullOrNil(bVar.content.trim())) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (!this.ygl) {
            Pair<Boolean, Boolean> dYb = dYb();
            boolean booleanValue = ((Boolean) dYb.first).booleanValue();
            boolean booleanValue2 = ((Boolean) dYb.second).booleanValue();
            if (!z2 || (!booleanValue && !booleanValue2)) {
                enableOptionMenu(0, false);
                V(false, z);
            } else {
                enableOptionMenu(0, true);
                V(true, z);
                AppMethodBeat.o(110475);
                return;
            }
        } else if (z2) {
            enableOptionMenu(0, true);
            if (!z) {
                if (this.ygj != null && Util.isEqual(this.ygi.header, this.ygj.header) && Util.isEqual(this.ygi.yfB, this.ygj.yfB) && Util.isEqual(this.ygi.xxN, this.ygj.xxN)) {
                    Pair<Boolean, Boolean> dYb2 = dYb();
                    boolean booleanValue3 = ((Boolean) dYb2.first).booleanValue();
                    boolean booleanValue4 = ((Boolean) dYb2.second).booleanValue();
                    if (!booleanValue3 && !booleanValue4) {
                        V(false, z);
                        AppMethodBeat.o(110475);
                        return;
                    }
                }
                V(true, z);
                AppMethodBeat.o(110475);
                return;
            }
        } else {
            enableOptionMenu(0, false);
            V(false, z);
            AppMethodBeat.o(110475);
            return;
        }
        AppMethodBeat.o(110475);
    }

    private Pair<Boolean, Boolean> dYb() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(194446);
        HashSet hashSet = new HashSet();
        for (int i2 = 1; i2 <= this.ygj.yfE.size(); i2++) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar = this.ygj.yfE.get(Integer.valueOf(i2));
            if (Util.isEqual(bVar.username, z.aTY())) {
                hashSet.add(bVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        for (int i3 = 1; i3 <= this.ygi.yfE.size(); i3++) {
            com.tencent.mm.plugin.groupsolitaire.c.b bVar2 = this.ygi.yfE.get(Integer.valueOf(i3));
            if (Util.isEqual(bVar2.username, z.aTY()) && !Util.isNullOrNil(bVar2.content.trim())) {
                arrayList.add(bVar2);
                hashSet2.add(bVar2);
            }
        }
        if (hashSet.size() == arrayList.size()) {
            z = arrayList.size() != hashSet2.size();
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!hashSet.contains((com.tencent.mm.plugin.groupsolitaire.c.b) it.next())) {
                        break;
                    }
                } else {
                    break;
                }
            }
            Pair<Boolean, Boolean> pair = new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
            AppMethodBeat.o(194446);
            return pair;
        }
        z = false;
        z2 = true;
        Pair<Boolean, Boolean> pair2 = new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
        AppMethodBeat.o(194446);
        return pair2;
    }

    private void V(boolean z, boolean z2) {
        if (!z2) {
            this.thl = z;
        }
    }

    public final void OI(int i2) {
        int i3 = 0;
        AppMethodBeat.i(110476);
        if (this.yge == null || !(this.yge instanceof MMEditText)) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.a(this.ygi, i2, 0);
            AppMethodBeat.o(110476);
            return;
        }
        switch (((Integer) ((MMEditText) this.yge).getTag(R.id.dlw)).intValue()) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 3;
                break;
            case 3:
                i3 = 4;
                break;
            case 4:
                i3 = 2;
                break;
        }
        ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
        d.a(this.ygi, i2, i3);
        AppMethodBeat.o(110476);
    }

    @Override // com.tencent.mm.ui.tools.g
    public final void y(int i2, boolean z) {
        ObjectAnimator ofFloat;
        AppMethodBeat.i(110477);
        boolean z2 = this.xfU;
        if (i2 > 0) {
            this.xfU = true;
        } else {
            this.xfU = false;
        }
        if (!z2 && this.xfU) {
            Iterator<View> it = this.ygo.iterator();
            while (it.hasNext()) {
                it.next().setTag(null);
            }
        }
        if (this.ygg == 0) {
            this.ygg = i2;
        }
        if (this.ygl) {
            this.yfT.setMaxLines(b(this.yfT));
            this.yfY.setMaxLines(b(this.yfY));
        }
        if (this.yge != null) {
            if (!this.xfU) {
                this.yge.post(new Runnable() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass10 */

                    public final void run() {
                        AppMethodBeat.i(110436);
                        ((MMEditText) GroupSolitatireEditUI.this.yge).setCursorVisible(false);
                        AppMethodBeat.o(110436);
                    }
                });
            } else {
                this.yge.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(110437);
                        ((MMEditText) GroupSolitatireEditUI.this.yge).setCursorVisible(true);
                        AppMethodBeat.o(110437);
                    }
                }, 100);
            }
        }
        if (this.xfU) {
            if (this.yfZ.getTranslationY() != 0.0f) {
                this.yfZ.setTranslationY(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(this.yfZ, "translationY", this.yfZ.getTranslationY(), this.yfZ.getTranslationY() - ((float) this.ygg));
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.yfZ, "translationY", this.yfZ.getTranslationY(), this.yfZ.getTranslationY() + ((float) this.ygg));
        }
        ofFloat.setDuration(175L);
        ofFloat.setInterpolator(new android.support.v4.view.b.b());
        ofFloat.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass13 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(110439);
                if (GroupSolitatireEditUI.this.xfU) {
                    GroupSolitatireEditUI.this.yfZ.setVisibility(0);
                }
                AppMethodBeat.o(110439);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(110440);
                if (GroupSolitatireEditUI.this.xfU) {
                    GroupSolitatireEditUI.this.yfX.setVisibility(4);
                    AppMethodBeat.o(110440);
                    return;
                }
                GroupSolitatireEditUI.t(GroupSolitatireEditUI.this);
                if (GroupSolitatireEditUI.this.ygi.yfE.size() < com.tencent.mm.plugin.groupsolitaire.b.b.dXN()) {
                    GroupSolitatireEditUI.this.yfX.setVisibility(0);
                }
                GroupSolitatireEditUI.this.yfZ.setVisibility(8);
                AppMethodBeat.o(110440);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
        dYd();
        if (this.yge == null) {
            AppMethodBeat.o(110477);
            return;
        }
        this.yge.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(110441);
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.this.xfU);
                AppMethodBeat.o(110441);
            }
        }, 50);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", Boolean.valueOf(this.xfU), Integer.valueOf(i2), Integer.valueOf(this.ygg));
        AppMethodBeat.o(110477);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(110478);
        super.onActivityResult(i2, i3, intent);
        ((MMEditText) this.yge).requestFocus();
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            AppMethodBeat.o(110478);
            return;
        }
        switch (i2) {
            case 4097:
                String nullAs = Util.nullAs(intent.getStringExtra("Kwebmap_locaion"), "");
                String stringExtra = intent.getStringExtra("kPoiName");
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_LOC address: %s, poiName：%s", nullAs, stringExtra);
                if (nullAs.contains(getString(R.string.dvn))) {
                    nullAs = nullAs.substring(nullAs.indexOf(getString(R.string.dvn)) + 1);
                }
                aBq(stringExtra + "(" + nullAs + ")");
                OI(3);
                AppMethodBeat.o(110478);
                return;
            case 4098:
                Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
                if (this.ygr != null) {
                    this.ygr.show();
                    break;
                }
                break;
        }
        AppMethodBeat.o(110478);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(110479);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(110479);
        } else if (iArr[0] == 0) {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult OK");
            dYc();
            AppMethodBeat.o(110479);
        } else {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
            com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.fl3), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass15 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(194437);
                    GroupSolitatireEditUI groupSolitatireEditUI = GroupSolitatireEditUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    com.tencent.mm.hellhoundlib.a.a.a(groupSolitatireEditUI, bl.axQ(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$22", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    groupSolitatireEditUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(groupSolitatireEditUI, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$22", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(194437);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(110479);
        }
    }

    private void dYc() {
        AppMethodBeat.i(110480);
        if (!com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null))) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, (String) null, (String) null);
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(a2));
            if (!a2) {
                AppMethodBeat.o(110480);
                return;
            }
        } else if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION")) {
            if (!((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                com.tencent.mm.plugin.account.a.b.a.b(this, getResources().getString(R.string.el_, LocaleUtil.getApplicationLanguage()), 30764, true);
                AppMethodBeat.o(110480);
                return;
            }
            com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
            AppMethodBeat.o(110480);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
        intent.putExtra("map_view_type", 3);
        com.tencent.mm.br.c.b(this, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, 4097);
        AppMethodBeat.o(110480);
    }

    private void aBq(String str) {
        AppMethodBeat.i(110481);
        ((MMEditText) this.yge).requestFocus();
        this.yfW.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(110443);
                GroupSolitatireEditUI.this.showVKB();
                AppMethodBeat.o(110443);
            }
        }, 200);
        ((MMEditText) this.yge).getText().insert(this.ygh, str + "; ");
        AppMethodBeat.o(110481);
    }

    private void dYd() {
        AppMethodBeat.i(110482);
        if (this.onl.findFocus() == null) {
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
            AppMethodBeat.o(110482);
            return;
        }
        this.yge = this.onl.findFocus();
        this.ygh = ((MMEditText) this.yge).getSelectionStart();
        AppMethodBeat.o(110482);
    }

    private void a(final MMEditText mMEditText) {
        AppMethodBeat.i(110483);
        mMEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass18 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(194441);
                if (!z || GroupSolitatireEditUI.this.yge == null || !GroupSolitatireEditUI.this.xfU) {
                    mMEditText.setSelection(0);
                    AppMethodBeat.o(194441);
                    return;
                }
                GroupSolitatireEditUI.this.yge.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass18.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(194439);
                        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
                        AppMethodBeat.o(194439);
                    }
                }, 200);
                GroupSolitatireEditUI.this.yge.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass18.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(194440);
                        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.this.xfU);
                        AppMethodBeat.o(194440);
                    }
                }, 200);
                AppMethodBeat.o(194441);
            }
        });
        AppMethodBeat.o(110483);
    }

    private int b(MMEditText mMEditText) {
        AppMethodBeat.i(110484);
        if (this.ygg == 0) {
            AppMethodBeat.o(110484);
            return 10;
        }
        int height = (int) (((float) (((WindowManager) getSystemService("window")).getDefaultDisplay().getHeight() - ((this.ygg + this.yfZ.getHeight()) + at.fromDPToPix(this, 145)))) / ((float) mMEditText.getLineHeight()));
        AppMethodBeat.o(110484);
        return height;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(110485);
        GestureDetector gestureDetector = this.aYg;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(110485);
        return false;
    }

    static /* synthetic */ void d(GroupSolitatireEditUI groupSolitatireEditUI) {
        AppMethodBeat.i(110487);
        groupSolitatireEditUI.qa(false);
        AppMethodBeat.o(110487);
    }

    static /* synthetic */ void a(GroupSolitatireEditUI groupSolitatireEditUI, boolean z) {
        AppMethodBeat.i(110488);
        if (groupSolitatireEditUI.yge != null) {
            groupSolitatireEditUI.ygh = ((MMEditText) groupSolitatireEditUI.yge).getSelectionStart();
            int height = ((WindowManager) groupSolitatireEditUI.getSystemService("window")).getDefaultDisplay().getHeight();
            groupSolitatireEditUI.yge.getGlobalVisibleRect(groupSolitatireEditUI.ygq);
            if (groupSolitatireEditUI.ygq.bottom > height) {
                groupSolitatireEditUI.ygq.bottom = height;
            }
            final int height2 = (groupSolitatireEditUI.ygg + groupSolitatireEditUI.yfZ.getHeight()) - (height - groupSolitatireEditUI.ygq.bottom);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) groupSolitatireEditUI.ygd.getLayoutParams();
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "screenHeight - (moveHeight + mKeyBoardLl.getHeight()):%s ", Integer.valueOf(height - (groupSolitatireEditUI.ygg + groupSolitatireEditUI.yfZ.getHeight())));
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "focusViewRect.bottom.bottom：%s，screenHeight：%s,move：%s", Integer.valueOf(groupSolitatireEditUI.ygq.bottom), Integer.valueOf(height), Integer.valueOf(height2));
            if (!z) {
                layoutParams.height = 0;
                groupSolitatireEditUI.ygd.setLayoutParams(layoutParams);
                AppMethodBeat.o(110488);
                return;
            } else if (groupSolitatireEditUI.ygq.bottom > height - (groupSolitatireEditUI.ygg + groupSolitatireEditUI.yfZ.getHeight()) && groupSolitatireEditUI.ygg != 0) {
                if (groupSolitatireEditUI.yfY.isShown()) {
                    groupSolitatireEditUI.yfY.getGlobalVisibleRect(groupSolitatireEditUI.ygp);
                } else {
                    groupSolitatireEditUI.yfV.getGlobalVisibleRect(groupSolitatireEditUI.ygp);
                }
                if (groupSolitatireEditUI.ygp.bottom > height) {
                    groupSolitatireEditUI.ygp.bottom = height;
                }
                layoutParams.height = (height - groupSolitatireEditUI.ygp.bottom) + height2;
                groupSolitatireEditUI.ygd.setLayoutParams(layoutParams);
                groupSolitatireEditUI.ygd.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass17 */

                    public final void run() {
                        AppMethodBeat.i(194438);
                        if (height2 > 0) {
                            Log.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "Scroll");
                            GroupSolitatireEditUI.this.lTw.smoothScrollBy(0, ((MMEditText) GroupSolitatireEditUI.this.yge).getLineHeight() + height2);
                        }
                        AppMethodBeat.o(194438);
                    }
                }, 100);
            }
        }
        AppMethodBeat.o(110488);
    }

    static /* synthetic */ boolean c(MMEditText mMEditText) {
        AppMethodBeat.i(110489);
        if (mMEditText.getLineCount() > mMEditText.getMaxLines()) {
            AppMethodBeat.o(110489);
            return true;
        }
        AppMethodBeat.o(110489);
        return false;
    }

    static /* synthetic */ void m(GroupSolitatireEditUI groupSolitatireEditUI) {
        boolean z;
        com.tencent.mm.plugin.groupsolitaire.c.a aVar;
        Pair<Long, String> pair;
        AppMethodBeat.i(194447);
        groupSolitatireEditUI.dAE = true;
        if (groupSolitatireEditUI.ygf && groupSolitatireEditUI.ygi != null && groupSolitatireEditUI.ygi.yfB != null && !Util.isNullOrNil(groupSolitatireEditUI.ygi.yfB.trim())) {
            StringBuilder sb = new StringBuilder();
            sb.append(groupSolitatireEditUI.getString(R.string.dw0)).append(" ").append(groupSolitatireEditUI.ygi.yfB.trim());
            groupSolitatireEditUI.ygi.yfB = sb.toString();
            groupSolitatireEditUI.ygi.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(groupSolitatireEditUI.ygi);
        }
        com.tencent.mm.plugin.groupsolitaire.c.a ib = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ib(groupSolitatireEditUI.ygk, groupSolitatireEditUI.ygi.field_key);
        com.tencent.mm.plugin.groupsolitaire.b.b.b(ib);
        boolean z2 = false;
        if (groupSolitatireEditUI.ygl) {
            if (ib != null) {
                z2 = true;
            }
            z = z2;
            aVar = com.tencent.mm.plugin.groupsolitaire.b.b.a(groupSolitatireEditUI.ygi, ib, z.aTY(), 2);
        } else {
            z = false;
            aVar = ib;
        }
        com.tencent.mm.plugin.groupsolitaire.c.a dXV = aVar == null ? null : aVar.dXV();
        com.tencent.mm.plugin.groupsolitaire.c.a a2 = com.tencent.mm.plugin.groupsolitaire.b.b.a(groupSolitatireEditUI.ygi, aVar, z.aTY());
        if (a2.yfF) {
            com.tencent.mm.plugin.groupsolitaire.b.b.c(a2);
        }
        if (aVar != null && aVar.field_active == 0 && a2.yfE.size() > 1) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            d.b(a2, z.aTY());
        }
        a2.field_lastActiveTime = (long) cl.aWB();
        com.tencent.mm.plugin.groupsolitaire.b.b.a(a2, aVar != null, false);
        if (groupSolitatireEditUI.dXZ() || (groupSolitatireEditUI.ygl && aVar != null)) {
            pair = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).sendGroupSolitatireInCall(groupSolitatireEditUI.ygk, a2, groupSolitatireEditUI.ygi, dXV, aVar == null, z);
        } else {
            pair = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).sendGroupSolitatire(groupSolitatireEditUI.ygk, a2, dXV, groupSolitatireEditUI.ygl, z);
        }
        Intent intent = new Intent();
        intent.putExtra("key_group_solitatire_content", (String) pair.second);
        groupSolitatireEditUI.setResult(-1, intent);
        if (((Long) pair.first).longValue() >= 0) {
            if (a2.field_msgSvrId == 0) {
                d groupSolitatireReportManager = ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                long longValue = ((Long) pair.first).longValue();
                com.tencent.mm.plugin.groupsolitaire.c.a aVar2 = groupSolitatireEditUI.ygi;
                int dXX = groupSolitatireEditUI.dXX();
                boolean z3 = groupSolitatireEditUI.ygl;
                if (longValue >= 0 && aVar2 != null) {
                    d.a aVar3 = new d.a();
                    aVar3.gqV = aVar2.field_username;
                    aVar3.yfx = (long) dXX;
                    aVar3.key = aVar2.field_key;
                    if (z3) {
                        aVar3.yfy = 2;
                    } else {
                        aVar3.yfy = 1;
                    }
                    groupSolitatireReportManager.yfs.put(Long.valueOf(longValue), aVar3);
                }
            } else {
                ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
                d.a(a2, groupSolitatireEditUI.dXX(), 3, groupSolitatireEditUI.ygl);
            }
        }
        groupSolitatireEditUI.finish();
        AppMethodBeat.o(194447);
    }

    static /* synthetic */ void t(GroupSolitatireEditUI groupSolitatireEditUI) {
        View view;
        AppMethodBeat.i(194450);
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 1; i2 <= groupSolitatireEditUI.ygi.yfE.size(); i2++) {
                com.tencent.mm.plugin.groupsolitaire.c.b bVar = groupSolitatireEditUI.ygi.yfE.get(Integer.valueOf(i2));
                if (bVar != null) {
                    if (!Util.isNullOrNil(bVar.content.trim()) || groupSolitatireEditUI.ygo.get(i2 - 1).getTag() != null) {
                        arrayList2.add(bVar);
                    } else {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
            }
            Collections.sort(arrayList, new Comparator<Integer>() {
                /* class com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI.AnonymousClass9 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Integer num, Integer num2) {
                    AppMethodBeat.i(110435);
                    Integer num3 = num;
                    Integer num4 = num2;
                    if (num3.intValue() < num4.intValue()) {
                        AppMethodBeat.o(110435);
                        return 1;
                    } else if (num3 == num4) {
                        AppMethodBeat.o(110435);
                        return 0;
                    } else {
                        AppMethodBeat.o(110435);
                        return -1;
                    }
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (num.intValue() - 1 < groupSolitatireEditUI.ygo.size() && (view = groupSolitatireEditUI.ygo.get(num.intValue() - 1)) != null) {
                    groupSolitatireEditUI.yfW.removeView(view);
                    groupSolitatireEditUI.ygo.remove(num.intValue() - 1);
                }
            }
            Iterator<View> it2 = groupSolitatireEditUI.ygo.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                i3++;
                ((TextView) it2.next().findViewById(R.id.dlq)).setText(String.valueOf(i3));
            }
            groupSolitatireEditUI.ygi.yfE.clear();
            Iterator it3 = arrayList2.iterator();
            int i4 = 0;
            while (it3.hasNext()) {
                i4++;
                groupSolitatireEditUI.ygi.yfE.put(Integer.valueOf(i4), (com.tencent.mm.plugin.groupsolitaire.c.b) it3.next());
            }
            AppMethodBeat.o(194450);
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "updateContent Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(194450);
        }
    }
}
