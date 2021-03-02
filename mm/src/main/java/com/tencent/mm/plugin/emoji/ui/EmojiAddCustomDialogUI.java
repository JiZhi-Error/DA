package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.ca.a;
import com.tencent.mm.emoji.d.d;
import com.tencent.mm.g.a.Cdo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.tools.b.b;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements i {
    private ProgressDialog jZH;
    private String lAl;
    private Context mContext;
    private int mScene;
    private boolean pto;
    private String rfp;
    private EmojiInfo rfq;
    private boolean rfr;
    private d rfs;
    private com.tencent.mm.ui.widget.a.d rft;
    private com.tencent.mm.ui.widget.a.d rfu;
    private c<a> rfv;
    private Runnable rfw = new Runnable() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(108829);
            EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(R.string.bw3));
            AppMethodBeat.o(108829);
        }
    };

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiAddCustomDialogUI() {
        AppMethodBeat.i(108842);
        AppMethodBeat.o(108842);
    }

    static /* synthetic */ void b(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(240171);
        emojiAddCustomDialogUI.cHe();
        AppMethodBeat.o(240171);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108843);
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
        }
        this.mContext = this;
        this.rfv = new c<>();
        this.lAl = getIntent().getStringExtra("extra_id");
        this.mScene = getIntent().getIntExtra("extra_scence", -1);
        this.rfp = getIntent().getStringExtra("extra_username");
        if (getIntent().getBooleanExtra("extra_current", false) && this.rfp == null) {
            this.rfp = z.aTY();
        }
        this.pto = getIntent().getBooleanExtra("extra_move_to_top", true);
        this.rfr = getIntent().getBooleanExtra("key_is_selfie", false);
        if (Util.isNullOrNil(this.lAl)) {
            Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            setResult(1);
            finish();
        }
        this.rfq = k.getEmojiStorageMgr().OpN.blk(this.lAl);
        g.aAg().hqi.a(v2helper.EMethodSetNgStrength, this);
        MMHandlerThread.postToMainThreadDelayed(this.rfw, 300);
        Context context = this.mContext;
        EmojiInfo emojiInfo = this.rfq;
        if (context == null) {
            Log.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
            AppMethodBeat.o(108843);
        } else if (emojiInfo == null) {
            Log.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
            AppMethodBeat.o(108843);
        } else {
            com.tencent.mm.emoji.b.k kVar = com.tencent.mm.emoji.b.k.gXr;
            if (com.tencent.mm.emoji.b.k.getKV().getBoolean("custom_full", false)) {
                Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
                cGW();
                cHe();
                h.INSTANCE.a(10431, Integer.valueOf(this.mScene), this.rfq.getMd5(), this.rfq.field_designerID, this.rfq.field_groupId, 1, 2, Integer.valueOf(this.rfq.field_size), this.rfp, this.rfq.field_activityid);
                AppMethodBeat.o(108843);
            } else if (emojiInfo.field_catalog == EmojiInfo.VkW || Util.isNullOrNil(emojiInfo.field_groupId) || Util.isEqual(emojiInfo.field_groupId, "capture") || (!Util.isNullOrNil(emojiInfo.field_groupId) && ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amq(emojiInfo.field_groupId))) {
                v(emojiInfo);
                AppMethodBeat.o(108843);
            } else {
                g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.h(emojiInfo.field_groupId, (byte) 0), 0);
                AppMethodBeat.o(108843);
            }
        }
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(108844);
        g.aAg().hqi.b(v2helper.EMethodSetNgStrength, this);
        MMHandlerThread.removeRunnable(this.rfw);
        super.onDestroy();
        this.rfv.dead();
        if (this.rfs != null) {
            this.rfs.hdF = null;
        }
        AppMethodBeat.o(108844);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(108845);
        if (qVar.getType() == 423) {
            if (!(qVar instanceof com.tencent.mm.plugin.emoji.f.h)) {
                AppMethodBeat.o(108845);
                return;
            }
            com.tencent.mm.plugin.emoji.f.h hVar = (com.tencent.mm.plugin.emoji.f.h) qVar;
            if (hVar == null || Util.isNullOrNil(hVar.rcD) || this.rfq == null || Util.isNullOrNil(this.rfq.field_groupId) || !this.rfq.field_groupId.equalsIgnoreCase(hVar.rcD)) {
                Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
            } else if (i2 == 0 && i3 == 0) {
                v(this.rfq);
                AppMethodBeat.o(108845);
                return;
            } else if (i3 == 4) {
                cGW();
                if (this.mScene == 0) {
                    final String str2 = this.rfq.field_groupId;
                    if (!isFinishing()) {
                        this.rfu = com.tencent.mm.ui.base.h.c(this, getString(R.string.br4), "", true);
                        this.rfu.b(R.string.sz, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(240159);
                                EmojiAddCustomDialogUI.this.finish();
                                AppMethodBeat.o(240159);
                            }
                        });
                        this.rfu.a(R.string.br6, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(240160);
                                Intent intent = new Intent();
                                intent.setClass(EmojiAddCustomDialogUI.this, EmojiStoreDetailUI.class);
                                intent.putExtra("extra_id", str2);
                                intent.putExtra("preceding_scence", 20);
                                EmojiAddCustomDialogUI emojiAddCustomDialogUI = EmojiAddCustomDialogUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(emojiAddCustomDialogUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                emojiAddCustomDialogUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(emojiAddCustomDialogUI, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                EmojiAddCustomDialogUI.this.finish();
                                AppMethodBeat.o(240160);
                            }
                        });
                    }
                    AppMethodBeat.o(108845);
                    return;
                }
                amW(getString(R.string.br4));
                AppMethodBeat.o(108845);
                return;
            } else if (i3 == 8) {
                cGW();
                amW(getString(R.string.br3));
                AppMethodBeat.o(108845);
                return;
            } else if (i3 == 9) {
                cGW();
                amW(getString(R.string.br2));
                AppMethodBeat.o(108845);
                return;
            } else if (i3 == -2) {
                cGW();
                amW(getString(R.string.br5));
                AppMethodBeat.o(108845);
                return;
            } else {
                cGW();
                amW(getString(R.string.br1));
                AppMethodBeat.o(108845);
                return;
            }
        }
        AppMethodBeat.o(108845);
    }

    private static void cHd() {
        AppMethodBeat.i(108846);
        Cdo doVar = new Cdo();
        doVar.dGz.type = 1;
        EventCenter.instance.publish(doVar);
        if (!doVar.dGA.dGB) {
            dyv gFr = k.getEmojiStorageMgr().OpQ.gFr();
            if (gFr != null) {
                Iterator<dyw> it = gFr.MYx.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    dyw next = it.next();
                    if (next.ProductID.equals(String.valueOf(EmojiGroupInfo.VkO))) {
                        next.xuA = 0;
                        break;
                    }
                }
            }
            k.getEmojiStorageMgr().OpQ.a(gFr);
            com.tencent.mm.ca.a.gvc();
            a.b bVar = com.tencent.mm.ca.a.NCN;
            a.b.bhD(String.valueOf(EmojiGroupInfo.VkO));
        }
        AppMethodBeat.o(108846);
    }

    private void v(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108847);
        Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiInfo.getMd5());
        com.tencent.mm.emoji.sync.a aVar = new com.tencent.mm.emoji.sync.a(0, arrayList);
        aVar.iLA = true;
        aVar.aYI().a(this.rfv).b(new com.tencent.mm.vending.c.a<Void, c.a<il>>() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<il> aVar) {
                AppMethodBeat.i(240164);
                Void a2 = a(aVar);
                AppMethodBeat.o(240164);
                return a2;
            }

            private Void a(c.a<il> aVar) {
                AppMethodBeat.i(240163);
                int i2 = aVar.errType;
                int i3 = aVar.errCode;
                if (i3 == -434) {
                    Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                    com.tencent.mm.emoji.b.k kVar = com.tencent.mm.emoji.b.k.gXr;
                    com.tencent.mm.emoji.b.k.dZ(true);
                    g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                    EmojiAddCustomDialogUI.this.cGW();
                    EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
                    h.INSTANCE.a(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.mScene), EmojiAddCustomDialogUI.this.rfq.getMd5(), EmojiAddCustomDialogUI.this.rfq.field_designerID, EmojiAddCustomDialogUI.this.rfq.field_groupId, 1, 2, Integer.valueOf(EmojiAddCustomDialogUI.this.rfq.field_size), EmojiAddCustomDialogUI.this.rfp, EmojiAddCustomDialogUI.this.rfq.field_activityid);
                } else if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                    il ilVar = (il) aVar.iLC;
                    if (ilVar == null || ilVar.KMA == null || ilVar.KMA.size() <= 0) {
                        EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this, null);
                    } else {
                        Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", Integer.valueOf(ilVar.KMA.size()));
                        EmojiAddCustomDialogUI.f(EmojiAddCustomDialogUI.this);
                    }
                } else {
                    EmojiAddCustomDialogUI.g(EmojiAddCustomDialogUI.this);
                }
                Void r0 = QZL;
                AppMethodBeat.o(240163);
                return r0;
            }
        });
        AppMethodBeat.o(108847);
    }

    private void cHe() {
        AppMethodBeat.i(108848);
        if (isFinishing()) {
            AppMethodBeat.o(108848);
            return;
        }
        this.rft = com.tencent.mm.ui.base.h.a(this.mContext, (int) R.string.bwq, (int) R.string.ty, (int) R.string.buo, (int) R.string.sz, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(240168);
                Intent intent = new Intent();
                h.INSTANCE.a(11596, 3);
                intent.setClass(EmojiAddCustomDialogUI.this.mContext, EmojiCustomUI.class);
                intent.putExtra("key_emoji_panel_type", 0);
                EmojiAddCustomDialogUI emojiAddCustomDialogUI = EmojiAddCustomDialogUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(emojiAddCustomDialogUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                emojiAddCustomDialogUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(emojiAddCustomDialogUI, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(240168);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(108840);
                EmojiAddCustomDialogUI.this.setResult(3);
                EmojiAddCustomDialogUI.this.finish();
                AppMethodBeat.o(108840);
            }
        });
        if (this.rft != null) {
            this.rft.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass12 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(240169);
                    EmojiAddCustomDialogUI.this.setResult(3);
                    EmojiAddCustomDialogUI.this.finish();
                    AppMethodBeat.o(240169);
                }
            });
        }
        AppMethodBeat.o(108848);
    }

    private void amW(String str) {
        AppMethodBeat.i(108849);
        if (isFinishing()) {
            AppMethodBeat.o(108849);
            return;
        }
        this.rfu = com.tencent.mm.ui.base.h.c(this, str, "", true);
        this.rfu.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(240158);
                EmojiAddCustomDialogUI.this.setResult(1);
                EmojiAddCustomDialogUI.this.finish();
                AppMethodBeat.o(240158);
            }
        });
        AppMethodBeat.o(108849);
    }

    /* access modifiers changed from: protected */
    public final void cGW() {
        AppMethodBeat.i(108850);
        MMHandlerThread.removeRunnable(this.rfw);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(108850);
    }

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        AppMethodBeat.i(108851);
        if (!emojiAddCustomDialogUI.isFinishing()) {
            emojiAddCustomDialogUI.getString(R.string.zb);
            emojiAddCustomDialogUI.jZH = com.tencent.mm.ui.base.h.a((Context) emojiAddCustomDialogUI, str, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        AppMethodBeat.o(108851);
    }

    static /* synthetic */ void f(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(240172);
        Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
        if (emojiAddCustomDialogUI.rfs != null) {
            emojiAddCustomDialogUI.rfs.hdF = null;
        }
        b bnW = b.bnW(emojiAddCustomDialogUI.rfq.hYx());
        bnW.mSize = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(emojiAddCustomDialogUI.rfq, emojiAddCustomDialogUI.rfr);
        bnW.aop(com.tencent.mm.n.c.aqo()).a(new b.a() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.tools.b.b.a
            public final void a(b bVar) {
                AppMethodBeat.i(240166);
                EmojiAddCustomDialogUI emojiAddCustomDialogUI = EmojiAddCustomDialogUI.this;
                com.tencent.mm.emoji.d.h hVar = com.tencent.mm.emoji.d.h.hdL;
                emojiAddCustomDialogUI.rfs = com.tencent.mm.emoji.d.h.a(EmojiAddCustomDialogUI.this.rfq, EmojiAddCustomDialogUI.this.rfr, new d.a() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass9.AnonymousClass1 */

                    @Override // com.tencent.mm.emoji.d.d.a
                    public final void A(int i2, String str) {
                        AppMethodBeat.i(240165);
                        if (i2 == 0) {
                            EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this, str);
                            AppMethodBeat.o(240165);
                        } else if (i2 == 2) {
                            EmojiAddCustomDialogUI.i(EmojiAddCustomDialogUI.this);
                            AppMethodBeat.o(240165);
                        } else if (i2 == 3) {
                            EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
                            AppMethodBeat.o(240165);
                        } else {
                            EmojiAddCustomDialogUI.g(EmojiAddCustomDialogUI.this);
                            AppMethodBeat.o(240165);
                        }
                    }
                });
                AppMethodBeat.o(240166);
            }

            @Override // com.tencent.mm.ui.tools.b.b.a
            public final void cHf() {
                AppMethodBeat.i(240167);
                EmojiAddCustomDialogUI.this.cGW();
                EmojiAddCustomDialogUI.i(EmojiAddCustomDialogUI.this);
                h.INSTANCE.a(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.mScene), EmojiAddCustomDialogUI.this.rfq.getMd5(), EmojiAddCustomDialogUI.this.rfq.field_designerID, EmojiAddCustomDialogUI.this.rfq.field_groupId, 1, 1, Integer.valueOf(EmojiAddCustomDialogUI.this.rfq.field_size), EmojiAddCustomDialogUI.this.rfp, EmojiAddCustomDialogUI.this.rfq.field_activityid);
                AppMethodBeat.o(240167);
            }
        });
        AppMethodBeat.o(240172);
    }

    static /* synthetic */ void b(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        AppMethodBeat.i(240173);
        if (str != null && !str.equals(emojiAddCustomDialogUI.rfq.getMd5())) {
            emojiAddCustomDialogUI.rfq = k.getEmojiStorageMgr().OpN.blk(str);
        }
        Log.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (emojiAddCustomDialogUI.rfq.field_catalog != EmojiInfo.VkW) {
            emojiAddCustomDialogUI.rfq.field_catalog = EmojiInfo.VkW;
            com.tencent.mm.emoji.decode.a.aum().a(emojiAddCustomDialogUI.rfq, false);
            emojiAddCustomDialogUI.rfq.field_reserved3 = k.getEmojiStorageMgr().OpN.gFo() + 1;
            k.getEmojiStorageMgr().OpN.L(emojiAddCustomDialogUI.rfq);
            h.INSTANCE.a(10431, Integer.valueOf(emojiAddCustomDialogUI.mScene), emojiAddCustomDialogUI.rfq.getMd5(), emojiAddCustomDialogUI.rfq.field_designerID, emojiAddCustomDialogUI.rfq.field_groupId, 0, 0, Integer.valueOf(emojiAddCustomDialogUI.rfq.field_size), emojiAddCustomDialogUI.rfp, emojiAddCustomDialogUI.rfq.field_activityid);
        }
        if (emojiAddCustomDialogUI.pto) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(emojiAddCustomDialogUI.rfq.getMd5());
            k.getEmojiStorageMgr().OpN.x(0, arrayList);
        }
        String hYy = emojiAddCustomDialogUI.rfq.hYy();
        if (!Util.isNullOrNil(emojiAddCustomDialogUI.rfq.field_thumbUrl) && !s.YS(hYy)) {
            c.a aVar = new c.a();
            aVar.fullPath = hYy;
            aVar.jbf = true;
            aVar.jbd = false;
            com.tencent.mm.av.q.bcV().a(emojiAddCustomDialogUI.rfq.field_thumbUrl, (ImageView) null, aVar.bdv());
        }
        cHd();
        emojiAddCustomDialogUI.cGW();
        emojiAddCustomDialogUI.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(240162);
                com.tencent.mm.ui.base.h.cD(EmojiAddCustomDialogUI.this.mContext, MMApplicationContext.getContext().getString(R.string.h9));
                AppMethodBeat.o(240162);
            }
        });
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("activityId", emojiAddCustomDialogUI.rfq.field_activityid);
        emojiAddCustomDialogUI.setResult(-1, intent);
        emojiAddCustomDialogUI.finish();
        AppMethodBeat.o(240173);
    }

    static /* synthetic */ void g(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(240174);
        Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        emojiAddCustomDialogUI.cGW();
        emojiAddCustomDialogUI.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(240161);
                com.tencent.mm.ui.base.h.cD(EmojiAddCustomDialogUI.this.mContext, MMApplicationContext.getContext().getString(R.string.br1));
                AppMethodBeat.o(240161);
            }
        });
        h.INSTANCE.a(10431, Integer.valueOf(emojiAddCustomDialogUI.mScene), emojiAddCustomDialogUI.rfq.getMd5(), emojiAddCustomDialogUI.rfq.field_designerID, emojiAddCustomDialogUI.rfq.field_groupId, 1, 3, Integer.valueOf(emojiAddCustomDialogUI.rfq.field_size), emojiAddCustomDialogUI.rfp, emojiAddCustomDialogUI.rfq.field_activityid);
        emojiAddCustomDialogUI.setResult(1);
        emojiAddCustomDialogUI.finish();
        AppMethodBeat.o(240174);
    }

    static /* synthetic */ void i(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(240175);
        if (!emojiAddCustomDialogUI.isFinishing()) {
            emojiAddCustomDialogUI.rft = com.tencent.mm.ui.base.h.a(emojiAddCustomDialogUI.mContext, emojiAddCustomDialogUI.mContext.getString(R.string.bs2), "", emojiAddCustomDialogUI.getString(R.string.e2u), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(240170);
                    EmojiAddCustomDialogUI.this.setResult(2);
                    EmojiAddCustomDialogUI.this.finish();
                    AppMethodBeat.o(240170);
                }
            });
        }
        AppMethodBeat.o(240175);
    }
}
