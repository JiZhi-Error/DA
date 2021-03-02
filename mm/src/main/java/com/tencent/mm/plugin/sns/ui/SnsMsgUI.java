package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Process;
import android.text.SpannableStringBuilder;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.l;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SnsMsgUI extends MMActivity implements i, c.b {
    long DRU;
    private bv EBg;
    private a EFR;
    private boolean EFS = false;
    private String EFT;
    private boolean EFU = false;
    private boolean EFV = false;
    private q EFW;
    private q EFX;
    private int EFY = LocalCache.TIME_DAY;
    private View.OnClickListener EFZ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(98853);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof bc) {
                SnsMsgUI.this.EoL.v(view, -1, 1);
            } else if (view.getTag() instanceof h) {
                SnsMsgUI.a(SnsMsgUI.this, (h) view.getTag());
            } else {
                Log.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98853);
        }
    };
    private MStorage.IOnStorageChange EGa = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(98861);
            aj.dRd().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass8.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(98860);
                    synchronized (SnsMsgUI.this.EFR) {
                        try {
                            Log.v("MicroMsg.SnsMsgUI", "comment notify");
                            SnsMsgUI.this.EFU = true;
                            SnsMsgUI.this.EFR.onNotifyChange(null, null);
                        } finally {
                            AppMethodBeat.o(98860);
                        }
                    }
                }
            });
            AppMethodBeat.o(98861);
        }
    };
    Runnable EGb = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass9 */

        public final void run() {
            AppMethodBeat.i(98862);
            if (SnsMsgUI.this.EFR == null) {
                AppMethodBeat.o(98862);
                return;
            }
            synchronized (SnsMsgUI.this.EFR) {
                try {
                    SnsMsgUI.this.EFR.onNotifyChange(null, null);
                    SnsMsgUI.this.EFS = false;
                } finally {
                    AppMethodBeat.o(98862);
                }
            }
        }
    };
    private long EGc;
    private int EGd = 0;
    private int EGe = 0;
    private HashMap<Integer, h> EGf = new HashMap<>();
    private HashMap<Integer, Integer> EGg = new HashMap<>();
    int Emk;
    private bb EoL;
    private SnsCmdList EqW = new SnsCmdList();
    private int fromScene;
    private int gsi;
    private MMHandler handler = aj.dRd();
    private long hlB = 0;
    private long iTC = 0;
    private ListView list;
    private o.g plk = new o.g() {
        /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass4 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(203600);
            switch (menuItem.getItemId()) {
                case 0:
                    SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.Emk);
                    AppMethodBeat.o(203600);
                    return;
                case 1:
                    SnsMsgUI.m(SnsMsgUI.this);
                    AppMethodBeat.o(203600);
                    return;
                case 2:
                    SnsMsgUI.a(SnsMsgUI.this, false);
                    break;
            }
            AppMethodBeat.o(203600);
        }
    };
    private View poS;
    private View qdl;
    private View qdm = null;
    private boolean qdn = false;
    private long sGB;
    private int[] tef = new int[2];

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsMsgUI() {
        AppMethodBeat.i(98888);
        AppMethodBeat.o(98888);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98889);
        super.onCreate(bundle);
        g.aAi();
        g.aAg().hqi.a(210, this);
        g.aAi();
        g.aAg().hqi.a(683, this);
        g.aAi();
        g.aAg().hqi.a(218, this);
        this.EFT = z.aTY();
        this.EBg = aj.faC();
        this.EFU = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.EFU) {
            this.qdn = true;
        }
        aj.faT().add(this.EGa);
        setActionbarColor(getActionbarColor());
        initView();
        this.EGc = Util.nowMilliSecond();
        this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
        AppMethodBeat.o(98889);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x015a  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
        // Method dump skipped, instructions count: 503
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsMsgUI.onDestroy():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        com.tencent.matrix.trace.f.c cVar;
        AppMethodBeat.i(98891);
        this.iTC = Util.nowSecond();
        if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = (long) cVar.dcx;
        }
        aj.faJ().a(this);
        super.onResume();
        AppMethodBeat.o(98891);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        com.tencent.matrix.trace.f.c cVar;
        AppMethodBeat.i(98892);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.gsi);
        this.gsi = 0;
        aj.faJ().b(this);
        super.onPause();
        if (!(!com.tencent.matrix.b.isInstalled() || com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) == null || (cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF) == null)) {
            this.hlB = Math.max(0L, ((long) cVar.dcx) - this.hlB);
        }
        this.iTC = Util.nowSecond() > this.iTC ? Util.nowSecond() - this.iTC : 1;
        WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.hlB, this.iTC);
        this.hlB = 0;
        this.iTC = 0;
        AppMethodBeat.o(98892);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bwm;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(98893);
        setMMTitle(R.string.h8y);
        addTextOptionMenu(0, getString(R.string.t2), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass10 */

            {
                AppMethodBeat.i(98864);
                AppMethodBeat.o(98864);
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(203603);
                com.tencent.mm.ui.base.h.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(R.string.h8r), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass10.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(203602);
                        SnsMsgUI.this.list.setVisibility(8);
                        SnsMsgUI.this.poS.setVisibility(0);
                        aj.faT().iFy.execSQL("SnsComment", "delete from SnsComment");
                        SnsMsgUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(203602);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(203603);
                return true;
            }
        });
        this.EoL = new bb(this);
        this.poS = findViewById(R.id.hz1);
        this.list = (ListView) findViewById(R.id.hz3);
        this.qdl = aa.jQ(this).inflate(R.layout.bwk, (ViewGroup) null);
        this.qdm = aa.jQ(this).inflate(R.layout.b84, (ViewGroup) null);
        Log.d("MicroMsg.SnsMsgUI", "autoLoad " + this.qdn);
        if (this.qdn) {
            this.list.addFooterView(this.qdm);
        } else {
            this.list.addFooterView(this.qdl);
        }
        this.EFR = new a(this, new h());
        this.EFR.setGetViewPositionCallback(new MMSlideDelView.c() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass11 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.c
            public final int dr(View view) {
                AppMethodBeat.i(203604);
                int positionForView = SnsMsgUI.this.list.getPositionForView(view);
                AppMethodBeat.o(203604);
                return positionForView;
            }
        });
        this.EFR.setPerformItemClickListener(new MMSlideDelView.g() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.g
            public final void r(View view, int i2, int i3) {
                AppMethodBeat.i(203605);
                SnsMsgUI.this.list.performItemClick(view, i2, (long) i3);
                AppMethodBeat.o(203605);
            }
        });
        this.EFR.b(new MMSlideDelView.f() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass13 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.f
            public final void cZ(Object obj) {
                AppMethodBeat.i(203606);
                if (obj == null) {
                    Log.e("MicroMsg.SnsMsgUI", "onItemDel object null");
                    AppMethodBeat.o(203606);
                    return;
                }
                try {
                    SnsMsgUI.a(SnsMsgUI.this, Util.safeParseInt(obj.toString()));
                    AppMethodBeat.o(203606);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
                    Log.printErrStackTrace("MicroMsg.SnsMsgUI", e2, "", new Object[0]);
                    AppMethodBeat.o(203606);
                }
            }
        });
        this.EFR.a(new s.a() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.s.a
            public final void bnE() {
                AppMethodBeat.i(203607);
                Log.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.this.EFR.gAZ + " unread:" + aj.faT().ctM() + "  showcount:" + SnsMsgUI.this.EFR.qdp);
                if (SnsMsgUI.this.EFR.getCount() == 0) {
                    SnsMsgUI.this.list.setVisibility(8);
                    SnsMsgUI.this.poS.setVisibility(0);
                    SnsMsgUI.this.enableOptionMenu(false);
                } else {
                    SnsMsgUI.this.list.setVisibility(0);
                    SnsMsgUI.this.poS.setVisibility(8);
                    SnsMsgUI.this.enableOptionMenu(true);
                }
                if ((SnsMsgUI.this.EFR.cwg() && aj.faT().ctM() == 0) || aj.faT().ctM() == aj.faT().feH()) {
                    SnsMsgUI.this.qdl.setVisibility(8);
                }
                AppMethodBeat.o(203607);
            }
        });
        this.list.setAdapter((ListAdapter) this.EFR);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass15 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                int cwh;
                AppMethodBeat.i(203608);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == SnsMsgUI.this.EFR.getCount()) {
                    if (aj.faT().ctM() > 0) {
                        aj.faT().ctN();
                        cwh = SnsMsgUI.this.EFR.cwg() ? 0 : 1;
                    } else {
                        cwh = SnsMsgUI.this.EFR.cwh();
                    }
                    SnsMsgUI.this.EFR.onNotifyChange(null, null);
                    if (!SnsMsgUI.this.qdn) {
                        if (SnsMsgUI.this.qdl.getParent() != null) {
                            Log.d("MicroMsg.SnsMsgUI", "remove footer");
                            SnsMsgUI.this.list.removeFooterView(SnsMsgUI.this.qdl);
                        }
                        if (SnsMsgUI.this.qdm.getParent() == null && cwh > 0) {
                            SnsMsgUI.this.list.addFooterView(SnsMsgUI.this.qdm);
                            Log.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                        }
                    }
                    SnsMsgUI.this.qdn = true;
                    SnsMsgUI.this.qdl.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(203608);
                    return;
                }
                h hVar = (h) SnsMsgUI.this.EFR.getItem(i2);
                if (hVar != null && !SnsMsgUI.X(aj.faO().JJ(hVar.field_snsID))) {
                    SnsMsgUI.a(SnsMsgUI.this, hVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(203608);
            }
        });
        new l(this);
        this.list.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass16 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(203609);
                switch (motionEvent.getAction()) {
                    case 0:
                        SnsMsgUI.this.hideVKB();
                        SnsMsgUI.this.tef[0] = (int) motionEvent.getRawX();
                        SnsMsgUI.this.tef[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(203609);
                return false;
            }
        });
        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass17 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(203610);
                if (i2 < SnsMsgUI.this.list.getHeaderViewsCount()) {
                    Log.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                    AppMethodBeat.o(203610);
                    return true;
                }
                new com.tencent.mm.ui.widget.b.a(SnsMsgUI.this).a(view, i2, j2, SnsMsgUI.this, SnsMsgUI.this.plk, SnsMsgUI.this.tef[0], SnsMsgUI.this.tef[1]);
                AppMethodBeat.o(203610);
                return true;
            }
        });
        this.list.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass2 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(203598);
                if (!SnsMsgUI.this.qdn) {
                    AppMethodBeat.o(203598);
                    return;
                }
                Log.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", Integer.valueOf(i2));
                if (i2 == 2) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.this.gsi);
                    SnsMsgUI.this.gsi = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, WXHardCoderJNI.hcSNSMsgScrollDelay, WXHardCoderJNI.hcSNSMsgScrollCPU, WXHardCoderJNI.hcSNSMsgScrollIO, WXHardCoderJNI.hcSNSMsgScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSMsgScrollTimeout, 705, WXHardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI");
                    Log.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsMsgUI.this.gsi));
                }
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (aj.faT().ctM() > 0) {
                        aj.faT().ctN();
                    } else {
                        SnsMsgUI.this.EFR.cwh();
                    }
                    SnsMsgUI.this.EFR.onNotifyChange(null, null);
                    AppMethodBeat.o(203598);
                    return;
                }
                AppMethodBeat.o(203598);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        if (this.EFR.getCount() == 0) {
            this.list.setVisibility(8);
            this.poS.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.list.setVisibility(0);
            this.poS.setVisibility(8);
            enableOptionMenu(true);
        }
        if ((this.EFR.cwg() && aj.faT().ctM() == 0) || aj.faT().ctM() == aj.faT().feH()) {
            this.qdl.setVisibility(8);
        }
        if (this.EFR.cwg() && this.qdn) {
            this.list.removeFooterView(this.qdm);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(203599);
                Intent intent = new Intent();
                intent.putExtra("sns_cmd_list", SnsMsgUI.this.EqW);
                SnsMsgUI.this.setResult(-1, intent);
                SnsMsgUI.this.finish();
                AppMethodBeat.o(203599);
                return true;
            }
        });
        if (this.EFR.cwg() && this.qdn) {
            this.list.removeFooterView(this.qdm);
        }
        AppMethodBeat.o(98893);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        String str;
        AppMethodBeat.i(98894);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) contextMenuInfo;
        h hVar = (h) this.EFR.getItem(adapterContextMenuInfo.position);
        if (hVar == null) {
            AppMethodBeat.o(98894);
            return;
        }
        this.Emk = hVar.Emk;
        this.DRU = hVar.field_snsID;
        try {
            dzi dzi = (dzi) new dzi().parseFrom(hVar.field_curActionBuf);
            if (dzi != null) {
                as Kn = this.EBg.Kn(dzi.MKC);
                if (Kn != null) {
                    str = Kn.arJ();
                } else if (!Util.isNullOrNil(dzi.MYQ)) {
                    str = dzi.MYQ;
                } else {
                    str = dzi.MKC;
                }
                contextMenu.setHeaderTitle(Util.nullAsNil(str));
                if (hVar.field_isSilence == 0) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(R.string.fgg));
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(R.string.fgf));
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsMsgUI", e2, "", new Object[0]);
        }
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(R.string.tf));
        AppMethodBeat.o(98894);
    }

    private void a(h hVar) {
        boolean z;
        AppMethodBeat.i(179213);
        long j2 = hVar.field_snsID;
        if (hVar != null) {
            if (hVar.field_type == 1) {
                this.EGd++;
            } else if (hVar.field_type == 2) {
                this.EGe++;
            }
            if (this.EGg.containsKey(Integer.valueOf(hVar.Emk))) {
                this.EGg.put(Integer.valueOf(hVar.Emk), Integer.valueOf(this.EGg.get(Integer.valueOf(hVar.Emk)).intValue() + 1));
            } else {
                this.EGg.put(Integer.valueOf(hVar.Emk), 1);
            }
        }
        if ((hVar.field_commentflag & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i("MicroMsg.SnsMsgUI", "skip goToCommentDetail, comment.isSnsDelFlag");
            com.tencent.mm.ui.base.h.n(this, R.string.h8v, R.string.zb);
            AppMethodBeat.o(179213);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("INTENT_COMMENT_TYPE", hVar.field_type);
        if (hVar.field_type == 3 || hVar.field_type == 5) {
            intent.setClass(this, SnsStrangerCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", hVar.field_talker);
            try {
                intent.putExtra("INTENT_SOURCE", ((dzi) new dzi().parseFrom(hVar.field_curActionBuf)).xub);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsMsgUI", e2, "", new Object[0]);
            }
        } else {
            intent.setClass(this, SnsCommentDetailUI.class);
        }
        if (hVar.field_type != 7 && hVar.field_type != 8 && hVar.field_type != 16) {
            intent.putExtra("INTENT_SNSID", y.bp("sns_table_", j2));
        } else if (!WeChatBrands.Business.Entries.MomentAds.checkAvailable(getContext())) {
            AppMethodBeat.o(179213);
            return;
        } else {
            intent.putExtra("INTENT_SNSID", y.bp("ad_table_", j2));
            SnsInfo aQl = aj.faO().aQl(y.bp("ad_table_", j2));
            if (aQl == null) {
                Log.i("MicroMsg.SnsMsgUI", "sns id " + j2 + "was not exist!");
                if (hVar.field_type == 16) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 2);
                }
                AppMethodBeat.o(179213);
                return;
            }
            int i2 = g.aAh().azQ().getInt(14, 0);
            Log.i("MicroMsg.SnsMsgUI", "current client version %s, [%s, %s]", Integer.valueOf(i2), Integer.valueOf(aQl.getAdXml().clientMinVersion), Integer.valueOf(aQl.getAdXml().clientMaxVersion));
            if (i2 < aQl.getAdXml().clientMinVersion || (aQl.getAdXml().clientMaxVersion > 0 && i2 > aQl.getAdXml().clientMaxVersion)) {
                if (!Util.isNullOrNil(aQl.getAdXml().compatibleUrl)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", aQl.getAdXml().compatibleUrl);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra("needRedirect", false);
                    intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    com.tencent.mm.plugin.sns.c.a.jRt.i(intent2, this);
                    AppMethodBeat.o(179213);
                    return;
                }
                Log.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
                AppMethodBeat.o(179213);
                return;
            }
        }
        if (hVar.field_type == 2) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", hVar.field_commentSvrID);
        } else if (hVar.field_type == 8 || hVar.field_type == 16) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", hVar.field_commentSvrID);
        }
        startActivityForResult(intent, 1);
        AppMethodBeat.o(179213);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<h> {
        protected MMSlideDelView.f EGm;
        private int Eov;
        int gAZ;
        protected MMSlideDelView.g pkY;
        protected MMSlideDelView.c pkZ;
        protected MMSlideDelView.d plb = new MMSlideDelView.d() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.a.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.i(98874);
                if (z) {
                    ywx.add(mMSlideDelView);
                    AppMethodBeat.o(98874);
                    return;
                }
                ywx.remove(mMSlideDelView);
                AppMethodBeat.o(98874);
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final boolean ebn() {
                AppMethodBeat.i(98875);
                if (ywx.size() > 0) {
                    AppMethodBeat.o(98875);
                    return true;
                }
                AppMethodBeat.o(98875);
                return false;
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void ebo() {
                AppMethodBeat.i(98876);
                for (MMSlideDelView mMSlideDelView : ywx) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.gLa();
                    }
                }
                ywx.clear();
                AppMethodBeat.o(98876);
            }

            @Override // com.tencent.mm.ui.base.MMSlideDelView.d
            public final void ebp() {
                AppMethodBeat.i(98877);
                for (MMSlideDelView mMSlideDelView : ywx) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.gKZ();
                    }
                }
                ywx.clear();
                AppMethodBeat.o(98877);
            }
        };
        int qdp;
        private Set<MMSlideDelView> ywx = new HashSet();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ h a(h hVar, Cursor cursor) {
            AppMethodBeat.i(98887);
            h hVar2 = hVar;
            if (hVar2 == null) {
                hVar2 = new h();
                Log.d("MicroMsg.SnsMsgUI", "new SnsComment");
            }
            hVar2.convertFrom(cursor);
            AppMethodBeat.o(98887);
            return hVar2;
        }

        public a(Context context, h hVar) {
            super(context, hVar);
            AppMethodBeat.i(98880);
            this.Eov = at.fromDPToPix(context, 14);
            this.qdp = 10;
            this.gAZ = this.qdp;
            AppMethodBeat.o(98880);
        }

        @Override // com.tencent.mm.ui.s
        public final long getItemId(int i2) {
            AppMethodBeat.i(98881);
            long j2 = ((h) getItem(i2)).field_snsID;
            AppMethodBeat.o(98881);
            return j2;
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(98882);
            ebf();
            anp();
            AppMethodBeat.o(98882);
        }

        public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
            this.pkY = gVar;
        }

        public final void b(MMSlideDelView.f fVar) {
            this.EGm = fVar;
        }

        public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
            this.pkZ = cVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
        public final synchronized void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(98883);
            super.onNotifyChange(str, mStorageEventData);
            AppMethodBeat.o(98883);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(98884);
            if (aj.faT().ctM() <= 0 || SnsMsgUI.this.EFU) {
                this.gAZ = aj.faT().feH();
                setCursor(aj.faT().Zq(this.qdp));
            } else {
                setCursor(aj.faT().feG());
            }
            notifyDataSetChanged();
            AppMethodBeat.o(98884);
        }

        public final boolean cwg() {
            return this.qdp >= this.gAZ;
        }

        public final int cwh() {
            AppMethodBeat.i(98885);
            if (cwg()) {
                if (SnsMsgUI.this.qdm.getParent() != null) {
                    SnsMsgUI.this.list.removeFooterView(SnsMsgUI.this.qdm);
                }
                AppMethodBeat.o(98885);
                return 0;
            }
            this.qdp += 10;
            if (this.qdp <= this.gAZ) {
                AppMethodBeat.o(98885);
                return 10;
            }
            this.qdp = this.gAZ;
            int i2 = this.gAZ % 10;
            AppMethodBeat.o(98885);
            return i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0409  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x041b  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x04c2  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x04cd  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x04d3  */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x0514  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x053a  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x053d  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0540  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x0543  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0592  */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x0595  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0172  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018b  */
        /* JADX WARNING: Removed duplicated region for block: B:281:0x0fe8  */
        /* JADX WARNING: Removed duplicated region for block: B:287:0x102e  */
        /* JADX WARNING: Removed duplicated region for block: B:291:0x104f  */
        /* JADX WARNING: Removed duplicated region for block: B:292:0x1053  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x01ea  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x01ee  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0253  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x026b  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x02bd  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x02c0  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x02ea  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x030a  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x030d  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0345  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x035d  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0388  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x03f5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r21, android.view.View r22, android.view.ViewGroup r23) {
            /*
            // Method dump skipped, instructions count: 4308
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsMsgUI.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        private static int a(int i2, MMImageView mMImageView) {
            int i3 = R.raw.app_attach_file_icon_webpage;
            AppMethodBeat.i(163120);
            switch (i2) {
                case 1:
                    i3 = R.drawable.bxc;
                    break;
                case 2:
                    mMImageView.setImageDrawable(null);
                    i3 = -1;
                    break;
                case 4:
                case 42:
                    i3 = R.raw.app_attach_file_icon_music;
                    break;
                case 5:
                case 15:
                    i3 = R.raw.app_attach_file_icon_video;
                    break;
                case 6:
                    i3 = R.raw.app_attach_file_icon_location;
                    break;
                case 7:
                    i3 = R.drawable.bxc;
                    break;
                case 8:
                    mMImageView.setImageDrawable(null);
                    i3 = -1;
                    break;
            }
            AppMethodBeat.o(163120);
            return i3;
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsMsgUI$a$a  reason: collision with other inner class name */
        class C1731a {
            SnsAvatarImageView EGo;
            TextView EGp;
            ImageView EGq;
            TextView EGr;
            MMImageView EGs;
            ImageView EGt;
            EmojiStatusView EGu;
            long ece;
            TextView kib;
            View plg;
            TextView plh;
            TextView timeTv;

            C1731a() {
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(98895);
        Log.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(98895);
        } else if (intent == null || !intent.getBooleanExtra("result_finish", false)) {
            if (intent != null) {
                this.EqW.Yj(intent.getIntExtra("sns_gallery_op_id", 0));
            }
            AppMethodBeat.o(98895);
        } else {
            finish();
            AppMethodBeat.o(98895);
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
        AppMethodBeat.i(98896);
        this.EFR.notifyDataSetChanged();
        AppMethodBeat.o(98896);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(98897);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.EqW);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(98897);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(98897);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(98898);
        Log.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", qVar, Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar instanceof r) {
            if (this.EFX != null) {
                this.EFX.dismiss();
                this.EFX = null;
            }
            if (qVar != null) {
                r rVar = (r) qVar;
                if (rVar.DIr) {
                    SnsObject snsObject = ((ead) rVar.rr.iLL.iLR).MZy;
                    if (snsObject == null || snsObject.Id == 0) {
                        com.tencent.mm.ui.base.h.n(this, R.string.h8v, R.string.zb);
                    } else if (((r) qVar).DIs != null) {
                        a(((r) qVar).DIs);
                    }
                } else if (!this.EFS) {
                    this.EFS = true;
                    this.handler.postDelayed(this.EGb, 500);
                }
            }
        }
        if (qVar.getType() == 218) {
            if (((com.tencent.mm.plugin.sns.model.s) qVar).type != 12) {
                AppMethodBeat.o(98898);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                this.EFR.onNotifyChange(null, null);
                Toast.makeText(this, getString(R.string.fgj), 0).show();
            } else {
                Toast.makeText(this, getString(R.string.fgi), 0).show();
            }
            if (this.EFW != null) {
                this.EFW.dismiss();
                this.EFW = null;
            }
        }
        AppMethodBeat.o(98898);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
    }

    private static String b(h hVar) {
        AppMethodBeat.i(98900);
        if (hVar.field_parentID == 0) {
            String Jb = com.tencent.mm.plugin.sns.data.r.Jb(hVar.field_snsID);
            AppMethodBeat.o(98900);
            return Jb;
        }
        String Jb2 = com.tencent.mm.plugin.sns.data.r.Jb(hVar.field_parentID);
        AppMethodBeat.o(98900);
        return Jb2;
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, h hVar) {
        AppMethodBeat.i(98901);
        SnsInfo JJ = aj.faO().JJ(hVar.field_snsID);
        if (cl.aWB() - hVar.field_createTime < snsMsgUI.EFY || JJ == null || (JJ != null && JJ.isAd())) {
            snsMsgUI.a(hVar);
            AppMethodBeat.o(98901);
            return;
        }
        final r rVar = new r(hVar.field_snsID);
        rVar.DIr = true;
        rVar.DIs = hVar;
        snsMsgUI.EFX = com.tencent.mm.ui.base.h.a((Context) snsMsgUI, snsMsgUI.getContext().getResources().getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(203601);
                g.aAi();
                g.aAg().hqi.a(rVar);
                AppMethodBeat.o(203601);
            }
        });
        g.aAi();
        g.aAg().hqi.a(rVar, 0);
        AppMethodBeat.o(98901);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, int i2) {
        AppMethodBeat.i(203611);
        aj.faT().delete((long) i2);
        snsMsgUI.EFR.onNotifyChange(null, null);
        AppMethodBeat.o(203611);
    }

    static /* synthetic */ boolean X(SnsInfo snsInfo) {
        AppMethodBeat.i(203612);
        boolean z = false;
        if (snsInfo != null && snsInfo.getTypeFlag() == 7) {
            z = true;
        }
        AppMethodBeat.o(203612);
        return z;
    }

    static /* synthetic */ void m(SnsMsgUI snsMsgUI) {
        AppMethodBeat.i(203613);
        com.tencent.mm.ui.base.h.c(snsMsgUI, snsMsgUI.getString(R.string.fgh), "", snsMsgUI.getString(R.string.fgg), snsMsgUI.getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(98859);
                SnsMsgUI.a(SnsMsgUI.this, true);
                AppMethodBeat.o(98859);
            }
        }, null);
        AppMethodBeat.o(203613);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, boolean z) {
        AppMethodBeat.i(203614);
        eab eab = new eab();
        eab.MZw = z ? 1 : 0;
        final com.tencent.mm.plugin.sns.model.s sVar = new com.tencent.mm.plugin.sns.model.s(snsMsgUI.DRU, 12, eab);
        g.aAi();
        if (g.aAg().hqi.a(sVar, 0)) {
            if (snsMsgUI.EFW != null) {
                snsMsgUI.EFW.dismiss();
            }
            snsMsgUI.getString(R.string.zb);
            snsMsgUI.EFW = com.tencent.mm.ui.base.h.a((Context) snsMsgUI, snsMsgUI.getString(R.string.fgk), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsMsgUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(98858);
                    g.aAi();
                    g.aAg().hqi.a(sVar);
                    AppMethodBeat.o(98858);
                }
            });
            snsMsgUI.EFW.show();
        }
        AppMethodBeat.o(203614);
    }

    static /* synthetic */ void a(EmojiStatusView emojiStatusView, dzi dzi, SpannableStringBuilder spannableStringBuilder, TextView textView) {
        AppMethodBeat.i(203615);
        if (!Util.isNullOrNil(dzi.MYY) && dzi.MYY.get(0) != null) {
            EmojiInfo blk = bj.gCJ().OpN.blk(dzi.MYY.get(0).Md5);
            if (blk != null) {
                emojiStatusView.setVisibility(0);
                emojiStatusView.setEmojiInfo(blk);
            }
            if (Util.isNullOrNil(spannableStringBuilder.toString().trim())) {
                textView.setVisibility(8);
            }
        }
        AppMethodBeat.o(203615);
    }
}
