package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.b.a.hd;
import com.tencent.mm.g.b.a.he;
import com.tencent.mm.g.b.a.hf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEmojiSwitch;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.ax;
import com.tencent.mm.plugin.luckymoney.model.bf;
import com.tencent.mm.plugin.luckymoney.model.bg;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout;
import com.tencent.mm.plugin.luckymoney.ui.a;
import com.tencent.mm.plugin.luckymoney.ui.i;
import com.tencent.mm.plugin.luckymoney.ui.l;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.tavkit.component.TAVExporter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(35)
public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private String UXO;
    private String UXP;
    private int UXQ;
    private int UXR;
    private Set<String> UXS = new HashSet();
    private View agA;
    RecyclerView.l anE = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass1 */
        private boolean yQA = false;
        private boolean yQB;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(163710);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            if (recyclerView.getAdapter().getItemCount() == 0) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(163710);
                return;
            }
            switch (i2) {
                case 0:
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (linearLayoutManager.ku() == LuckyMoneyDetailUI.this.zds.size() || linearLayoutManager.ku() == recyclerView.getAdapter().getItemCount() - 1) {
                        if (!LuckyMoneyDetailUI.this.zbX.isProcessing()) {
                            LuckyMoneyDetailUI.this.mwr = false;
                        }
                        if (LuckyMoneyDetailUI.this.zci && !LuckyMoneyDetailUI.this.mwr) {
                            LuckyMoneyDetailUI.e(LuckyMoneyDetailUI.this);
                        }
                    }
                    this.yQA = false;
                    break;
                default:
                    this.yQA = true;
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(163710);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            boolean z;
            AppMethodBeat.i(163711);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            if (recyclerView.getAdapter().getItemCount() == 0 || !this.yQA) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(163711);
                return;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.ks() > 0) {
                z = true;
            } else {
                View findViewByPosition = linearLayoutManager.findViewByPosition(linearLayoutManager.ks());
                if (findViewByPosition != null) {
                    i4 = 0 - findViewByPosition.getTop();
                } else {
                    i4 = 0;
                }
                if (i4 > 100) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (this.yQB != z) {
                if (z) {
                    LuckyMoneyDetailUI.this.getResources().getDrawable(R.drawable.cbq);
                }
                this.yQB = z;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(163711);
        }
    };
    private int fs = 0;
    private String gAn;
    private long gof;
    private int gwE;
    private TextView jVn;
    private boolean mwr = false;
    private TextView nAB;
    private int qBv;
    private ImageView rIY;
    private d.a rbg = new d.a() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass23 */

        @Override // com.tencent.mm.plugin.emoji.model.d.a
        public final void a(final boolean z, final EmojiInfo emojiInfo) {
            AppMethodBeat.i(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass23.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
                    if (!(emojiInfo == null || LuckyMoneyDetailUI.this.rfq == null || !LuckyMoneyDetailUI.this.rfq.getMd5().equals(emojiInfo.getMd5()))) {
                        if (z) {
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "somethings success.");
                            LuckyMoneyDetailUI.this.rfq = k.getEmojiStorageMgr().OpN.blk(LuckyMoneyDetailUI.this.rfq.getMd5());
                            LuckyMoneyDetailUI.this.yUo.setVisibility(8);
                            LuckyMoneyDetailUI.this.yUm.setVisibility(0);
                            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.rfq);
                            AppMethodBeat.o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
                            return;
                        }
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "somethings error.");
                        LuckyMoneyDetailUI.this.yUo.setVisibility(8);
                        LuckyMoneyDetailUI.this.yUn.setVisibility(0);
                    }
                    AppMethodBeat.o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REQUEST);
                }
            });
            AppMethodBeat.o(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY);
        }
    };
    private String rcU;
    private View rfF;
    private EmojiInfo rfq;
    private Dialog tipDialog;
    private List<ad> yQe = new LinkedList();
    private boolean yQg = false;
    private int yQh;
    private TextView yQk;
    private ImageView yQt;
    private TextView yQu;
    private ImageView yQv;
    private View yQw;
    private View yQx;
    private SoundPool yRy;
    private com.tencent.mm.particles.b yTb = new com.tencent.mm.particles.b() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass12 */

        @Override // com.tencent.mm.particles.b
        public final com.tencent.mm.particles.a.b a(Random random) {
            AppMethodBeat.i(65527);
            switch (random.nextInt(8)) {
                case 0:
                    if (LuckyMoneyDetailUI.this.zdN == null) {
                        LuckyMoneyDetailUI.this.zdN = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.ccr);
                    }
                    com.tencent.mm.particles.a.a aVar = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdN);
                    AppMethodBeat.o(65527);
                    return aVar;
                case 1:
                    if (LuckyMoneyDetailUI.this.zdO == null) {
                        LuckyMoneyDetailUI.this.zdO = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.ccs);
                    }
                    com.tencent.mm.particles.a.a aVar2 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdO);
                    AppMethodBeat.o(65527);
                    return aVar2;
                case 2:
                    if (LuckyMoneyDetailUI.this.zdP == null) {
                        LuckyMoneyDetailUI.this.zdP = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.cct);
                    }
                    com.tencent.mm.particles.a.a aVar3 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdP);
                    AppMethodBeat.o(65527);
                    return aVar3;
                case 3:
                    if (LuckyMoneyDetailUI.this.zdI == null) {
                        LuckyMoneyDetailUI.this.zdI = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.ccm);
                    }
                    com.tencent.mm.particles.a.a aVar4 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdI);
                    AppMethodBeat.o(65527);
                    return aVar4;
                case 4:
                    if (LuckyMoneyDetailUI.this.zdJ == null) {
                        LuckyMoneyDetailUI.this.zdJ = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.ccn);
                    }
                    com.tencent.mm.particles.a.a aVar5 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdJ);
                    AppMethodBeat.o(65527);
                    return aVar5;
                case 5:
                    if (LuckyMoneyDetailUI.this.zdK == null) {
                        LuckyMoneyDetailUI.this.zdK = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.cco);
                    }
                    com.tencent.mm.particles.a.a aVar6 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdK);
                    AppMethodBeat.o(65527);
                    return aVar6;
                case 6:
                    if (LuckyMoneyDetailUI.this.zdL == null) {
                        LuckyMoneyDetailUI.this.zdL = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.ccp);
                    }
                    com.tencent.mm.particles.a.a aVar7 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdL);
                    AppMethodBeat.o(65527);
                    return aVar7;
                case 7:
                    if (LuckyMoneyDetailUI.this.zdM == null) {
                        LuckyMoneyDetailUI.this.zdM = LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (int) R.drawable.ccq);
                    }
                    com.tencent.mm.particles.a.a aVar8 = new com.tencent.mm.particles.a.a(LuckyMoneyDetailUI.this.zdM);
                    AppMethodBeat.o(65527);
                    return aVar8;
                default:
                    AppMethodBeat.o(65527);
                    return null;
            }
        }
    };
    private String yUc;
    private RelativeLayout yUl;
    private BaseEmojiView yUm;
    private TextView yUn;
    private LinearLayout yUo;
    private ProgressBar yUp;
    private String yUq;
    private int yVv = -1;
    private String yZG;
    private String yZH;
    private TextView yln;
    private int zbZ;
    private RecyclerView zcQ;
    private CdnImageView zcR;
    private View zcS;
    private ImageView zcT;
    private ViewGroup zcU;
    private View zcV;
    private View zcW;
    private View zcX;
    private TextView zcY;
    private TextView zcZ;
    private View zcg;
    private boolean zci = true;
    private int zcj;
    private String zck;
    private String zcl;
    private Map<String, Integer> zcn = new HashMap();
    private String zcp = "";
    private boolean zcq = false;
    private hd zdA;
    private he zdB;
    private int zdC = 0;
    private boolean zdD = false;
    private String zdE;
    private int zdF;
    private com.tencent.mm.plugin.wallet_core.utils.b zdG;
    private c zdH;
    private Bitmap zdI;
    private Bitmap zdJ;
    private Bitmap zdK;
    private Bitmap zdL;
    private Bitmap zdM;
    private Bitmap zdN;
    private Bitmap zdO;
    private Bitmap zdP;
    private boolean zdQ = false;
    private WxRecyclerAdapter zdR;
    private int zdS;
    private String zdT;
    private q zdU;
    private com.tencent.mm.plugin.luckymoney.hk.a.a zdV;
    private long zdW = 0;
    private View.OnClickListener zdX = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass9 */

        public final void onClick(final View view) {
            AppMethodBeat.i(65523);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            LuckyMoneyDetailUI.this.zdA = new hd();
            if (Util.isEqual(view.getId(), (int) R.id.f51)) {
                LuckyMoneyDetailUI.this.zdA.eEH = 1;
                LuckyMoneyDetailUI.this.zdA.bfK();
            }
            if (!Util.isEqual(LuckyMoneyDetailUI.this.zdy.yVJ, 0) || !Util.isEqual(view.getTag(), "nodelete")) {
                e eVar = new e((Context) LuckyMoneyDetailUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass9.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(258620);
                        String string = LuckyMoneyDetailUI.this.getString(R.string.eru);
                        if (!Util.isEqual(LuckyMoneyDetailUI.this.zdy.yVJ, 0)) {
                            mVar.kV(1, R.string.eqn);
                        } else {
                            string = LuckyMoneyDetailUI.this.getString(R.string.ep5);
                        }
                        mVar.d(2, string);
                        if (!Util.isEqual(view.getTag(), "nodelete")) {
                            mVar.a(3, LuckyMoneyDetailUI.this.getResources().getColor(R.color.z5), LuckyMoneyDetailUI.this.getContext().getString(R.string.eog));
                        }
                        AppMethodBeat.o(258620);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass9.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(258621);
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                        switch (menuItem.getItemId()) {
                            case 1:
                                com.tencent.mm.plugin.emojicapture.api.b.b(LuckyMoneyDetailUI.this, 5, LuckyMoneyDetailUI.this.gAn);
                                LuckyMoneyDetailUI.this.zdA = new hd();
                                LuckyMoneyDetailUI.this.zdA.eEH = 4;
                                LuckyMoneyDetailUI.this.zdA.bfK();
                                LuckyMoneyDetailUI.this.zdC = 1;
                                AppMethodBeat.o(258621);
                                return;
                            case 2:
                                LuckyMoneyDetailUI.G(LuckyMoneyDetailUI.this);
                                AppMethodBeat.o(258621);
                                return;
                            case 3:
                                LuckyMoneyDetailUI.this.rfq = null;
                                LuckyMoneyDetailUI.this.zdA = new hd();
                                LuckyMoneyDetailUI.this.zdA.eEH = 8;
                                LuckyMoneyDetailUI.this.zdA.bfK();
                                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 1);
                                break;
                        }
                        AppMethodBeat.o(258621);
                    }
                };
                LuckyMoneyDetailUI.this.zdA.eEH = 2;
                LuckyMoneyDetailUI.this.zdA.bfK();
                eVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65523);
                return;
            }
            LuckyMoneyDetailUI.G(LuckyMoneyDetailUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(65523);
        }
    };
    private int zdY = 3;
    private i zdZ = new i() {
        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass11 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            kb cGq;
            AppMethodBeat.i(258623);
            if (Util.isEqual(qVar.getType(), 697) && (qVar instanceof com.tencent.mm.plugin.emoji.f.e)) {
                com.tencent.mm.plugin.emoji.f.e eVar = (com.tencent.mm.plugin.emoji.f.e) qVar;
                if (i2 == 0 && i3 == 0 && (cGq = eVar.cGq()) != null && cGq.KOp != null && cGq.KOp.size() > 0 && Util.isEqual(cGq.KOp.get(0).Md5, LuckyMoneyDetailUI.this.rfq.getMd5())) {
                    LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, false);
                }
            }
            AppMethodBeat.o(258623);
        }
    };
    private ViewGroup zda;
    private RelativeLayout zdb;
    private int[] zdc;
    private ViewGroup zdd;
    private LinearLayout zde;
    private LinearLayout zdf;
    private LinearLayout zdg;
    private BaseEmojiView zdh;
    private RelativeLayout zdi;
    private ImageView zdj;
    private a zdk;
    private View zdl;
    private ImageView zdm;
    private View zdn;
    private ViewGroup zdo;
    private TextView zdp;
    private ImageView zdq;
    private EnvelopeAppBarLayout zdr;
    private ArrayList<a> zds = new ArrayList<>();
    private boolean zdt = false;
    private int zdu;
    private ChatFooterPanel zdv;
    private EmojiInfo zdw;
    private ViewGroup zdx;
    public LuckyMoneyEmojiSwitch zdy;
    private hf zdz;
    private int zea = 0;
    private int zeb = 0;
    private final int zec = 750;
    private final int zed = 240;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyDetailUI() {
        AppMethodBeat.i(65556);
        AppMethodBeat.o(65556);
    }

    static /* synthetic */ void H(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(258652);
        super.finish();
        AppMethodBeat.o(258652);
    }

    static /* synthetic */ View K(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(258653);
        View contentView = luckyMoneyDetailUI.getContentView();
        AppMethodBeat.o(258653);
        return contentView;
    }

    static /* synthetic */ View L(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(258654);
        View contentView = luckyMoneyDetailUI.getContentView();
        AppMethodBeat.o(258654);
        return contentView;
    }

    static /* synthetic */ int PS(int i2) {
        AppMethodBeat.i(163745);
        int PP = PP(i2);
        AppMethodBeat.o(163745);
        return PP;
    }

    static /* synthetic */ void a(LuckyMoneyDetailUI luckyMoneyDetailUI, int i2, String str) {
        AppMethodBeat.i(258645);
        luckyMoneyDetailUI.bF(i2, str);
        AppMethodBeat.o(258645);
    }

    static /* synthetic */ void a(LuckyMoneyDetailUI luckyMoneyDetailUI, String str) {
        AppMethodBeat.i(258649);
        luckyMoneyDetailUI.byj(str);
        AppMethodBeat.o(258649);
    }

    static /* synthetic */ void a(LuckyMoneyDetailUI luckyMoneyDetailUI, boolean z) {
        AppMethodBeat.i(213385);
        luckyMoneyDetailUI.qM(z);
        AppMethodBeat.o(213385);
    }

    static /* synthetic */ void b(LuckyMoneyDetailUI luckyMoneyDetailUI, int i2) {
        AppMethodBeat.i(258647);
        luckyMoneyDetailUI.PR(i2);
        AppMethodBeat.o(258647);
    }

    static /* synthetic */ void b(LuckyMoneyDetailUI luckyMoneyDetailUI, q qVar) {
        AppMethodBeat.i(258655);
        luckyMoneyDetailUI.a(qVar);
        AppMethodBeat.o(258655);
    }

    static /* synthetic */ void b(LuckyMoneyDetailUI luckyMoneyDetailUI, EmojiInfo emojiInfo) {
        AppMethodBeat.i(163744);
        luckyMoneyDetailUI.A(emojiInfo);
        AppMethodBeat.o(163744);
    }

    static /* synthetic */ int hWh() {
        AppMethodBeat.i(258648);
        int hWg = hWg();
        AppMethodBeat.o(258648);
        return hWg;
    }

    static /* synthetic */ void w(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(213386);
        luckyMoneyDetailUI.efU();
        AppMethodBeat.o(213386);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        int i2;
        bh aDy;
        int i3 = 1;
        AppMethodBeat.i(65557);
        h.q(this);
        customfixStatusbar(true);
        this.zbY = false;
        if (!getIntent().getBooleanExtra("key_anim_slide", false)) {
            overridePendingTransition(R.anim.dd, R.anim.bs);
        }
        try {
            super.onCreate(bundle);
            getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
            getWindow().setBackgroundDrawableResource(R.color.am);
            this.zdE = getIntent().getStringExtra("key_cropname");
            this.qBv = getIntent().getIntExtra("key_material_flag", 0);
            this.zdF = getIntent().getIntExtra("key_hk_flag", 0);
            this.gwE = getIntent().getIntExtra("key_from", 0);
            this.UXO = getIntent().getStringExtra("key_live_id");
            this.UXP = getIntent().getStringExtra("key_live_attach");
            this.UXQ = getIntent().getIntExtra("key_live_anchor_type", 0);
            getController().OGt = false;
            setActionbarColor(getResources().getColor(R.color.ac_));
            hideActionbarLine();
            this.zdD = getIntent().getBooleanExtra("key_lucky_money_can_received", false);
            try {
                this.zdG = com.tencent.mm.plugin.wallet_core.utils.b.bV(new JSONObject(getIntent().getStringExtra("key_lucky_intercept_win_after")));
            } catch (Exception e2) {
            }
            this.gAn = getIntent().getStringExtra("key_username");
            this.zbZ = getIntent().getIntExtra("scene_id", 1002);
            this.yUc = getIntent().getStringExtra("key_sendid");
            this.yUq = getIntent().getStringExtra("key_native_url");
            this.zcj = getIntent().getIntExtra("key_jump_from", 2);
            this.zcp = getIntent().getStringExtra("key_process_content");
            this.gof = getIntent().getLongExtra("key_msgid", 0);
            this.zdT = getIntent().getStringExtra("key_packet_id");
            this.yZG = getIntent().getStringExtra("key_detail_envelope_url");
            this.yZH = getIntent().getStringExtra("key_detail_envelope_md5");
            Log.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + Util.nullAsNil(this.yUc) + ", nativeurl=" + Util.nullAsNil(this.yUq) + ", jumpFrom=" + this.zcj + ", packetId: " + this.zdT);
            if (Util.isNullOrNil(this.yUc) && !Util.isNullOrNil(this.yUq)) {
                try {
                    this.yUc = Uri.parse(this.yUq).getQueryParameter("sendid");
                } catch (Exception e3) {
                }
            }
            try {
                this.rcU = getIntent().getStringExtra("key_detail_emoji_md5");
                this.zdu = getIntent().getIntExtra("key_detail_emoji_type", 0);
                if (!Util.isNullOrNil(this.rcU)) {
                    this.zdz = new hf();
                    this.zdz.eEH = 10;
                    this.zdz.bfK();
                }
                this.zdy = (LuckyMoneyEmojiSwitch) getIntent().getParcelableExtra("key_emoji_switch");
                if (this.zdy == null) {
                    this.zdy = new LuckyMoneyEmojiSwitch();
                }
                q aDn = com.tencent.mm.plugin.luckymoney.a.b.aDn(this.yUc);
                if (aDn != null) {
                    this.zdU = aDn;
                } else {
                    byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                    if (byteArrayExtra != null) {
                        this.zdU = (q) new q().parseFrom(byteArrayExtra);
                    } else {
                        finish();
                    }
                }
            } catch (Exception e4) {
                Log.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e4.getLocalizedMessage());
                finish();
            }
            initView();
            if (this.zdU == null) {
                Log.w("MicroMsg.LuckyMoneyDetailUI", "lucky detail is null!!");
                finish();
                AppMethodBeat.o(65557);
                return;
            }
            if (!(this.zdU == null || (aDy = bh.aDy(this.zdU.yVB)) == null || aDy.yUC == null)) {
                if (Util.isNullOrNil(this.zdT)) {
                    this.zdT = aDy.yUC.Lot;
                }
                if (Util.isNullOrNil(this.zdE)) {
                    this.zdE = aDy.yUC.MgB;
                }
            }
            if (ab.IN(this.gAn)) {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "fetch preview story");
                dls j2 = com.tencent.mm.plugin.luckymoney.a.b.j(Long.valueOf(this.gof));
                if (j2 != null) {
                    b(j2.MaT);
                }
            } else if (!Util.isNullOrNil(this.zdT)) {
                dlt aDo = com.tencent.mm.plugin.luckymoney.a.b.aDo(this.zdT);
                Object[] objArr = new Object[1];
                if (aDo != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.LuckyMoneyDetailUI", "has story info: %s", objArr);
                b(aDo);
            } else {
                b((dlt) null);
            }
            a(this.zdU);
            if (getIntent().getBooleanExtra("play_sound", false)) {
                l.a(this, l.a.NOTSET);
            }
            getIntent().getIntExtra("key_hk_flag", 0);
            if (!ab.IN(this.gAn)) {
                addIconOptionMenu(0, R.drawable.icon_lucky_money_records, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass27 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(65550);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(LuckyMoneyDetailUI.PS(LuckyMoneyDetailUI.this.yVv)), 0, 0, 0, 4);
                        Intent intent = new Intent();
                        intent.setClass(LuckyMoneyDetailUI.this.getContext(), LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 2);
                        intent.putExtra("key_username", LuckyMoneyDetailUI.this.gAn);
                        LuckyMoneyDetailUI luckyMoneyDetailUI = LuckyMoneyDetailUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyDetailUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        luckyMoneyDetailUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(65550);
                        return true;
                    }
                });
            }
            if (this.zcj == 4 || this.zcj == 2) {
                i2 = 1;
            } else if (this.zcj == 1 || this.zcj == 3) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            String str = this.gAn;
            com.tencent.mm.plugin.luckymoney.story.b.e eVar = new com.tencent.mm.plugin.luckymoney.story.b.e();
            eVar.field_send_id = this.yUc;
            boolean z2 = com.tencent.mm.plugin.luckymoney.b.a.eex().eew().get(eVar, new String[0]);
            Log.d("MicroMsg.LuckyMoneyDetailUI", "hasData： %s, sendid: %s", Boolean.valueOf(z2), this.yUc);
            if (z2) {
                if (eVar.field_open_count > 0) {
                    i3 = 2;
                }
                eVar.field_open_count++;
                com.tencent.mm.plugin.luckymoney.b.a.eex().eew().update(eVar, new String[0]);
            } else {
                i3 = 2;
            }
            com.tencent.mm.plugin.luckymoney.story.a.m(i2, str, i3);
            AppMethodBeat.o(65557);
        } catch (Exception e5) {
            Log.printErrStackTrace("MicroMsg.LuckyMoneyDetailUI", e5, "", new Object[0]);
            Toast.makeText(MMApplicationContext.getContext(), "inflate view failed", 0).show();
            AppMethodBeat.o(65557);
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean enableActivityAnimation() {
        return false;
    }

    @Override // android.support.v4.app.FragmentActivity
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        AppMethodBeat.i(65558);
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        TextView textView = (TextView) findViewById(R.id.d9);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.yl));
        }
        AppMethodBeat.o(65558);
        return onCreatePanelMenu;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(65559);
        super.onResume();
        this.zdW = Util.nowSecond();
        AppMethodBeat.o(65559);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(65560);
        super.onPause();
        com.tencent.mm.modelstat.d.m("LuckyMoneyDetailUI", this.zdW, Util.nowSecond());
        AppMethodBeat.o(65560);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(213384);
        if (i2 != 4) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213384);
            return onKeyUp;
        } else if (this.zdG == null) {
            boolean onKeyUp2 = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213384);
            return onKeyUp2;
        } else if (!c.a(this.zdG)) {
            boolean onKeyUp3 = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(213384);
            return onKeyUp3;
        } else {
            this.zdH.a(this.zdG, new c.a() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass28 */

                @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
                public final void a(cfl cfl) {
                    AppMethodBeat.i(213379);
                    if (cfl.action == 1) {
                        LuckyMoneyDetailUI.this.finish();
                        AppMethodBeat.o(213379);
                        return;
                    }
                    AppMethodBeat.o(213379);
                }
            });
            this.zdG = null;
            AppMethodBeat.o(213384);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65561);
        this.zdH = new c(this);
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass29 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(213381);
                if (LuckyMoneyDetailUI.this.zdG == null) {
                    LuckyMoneyDetailUI.this.finish();
                    AppMethodBeat.o(213381);
                } else if (!c.a(LuckyMoneyDetailUI.this.zdG)) {
                    LuckyMoneyDetailUI.this.finish();
                    AppMethodBeat.o(213381);
                } else {
                    LuckyMoneyDetailUI.this.zdH.a(LuckyMoneyDetailUI.this.zdG, new c.a() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass29.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wallet_core.utils.c.a
                        public final void a(cfl cfl) {
                            AppMethodBeat.i(213380);
                            if (cfl.action == 1) {
                                LuckyMoneyDetailUI.this.finish();
                                AppMethodBeat.o(213380);
                                return;
                            }
                            AppMethodBeat.o(213380);
                        }
                    });
                    LuckyMoneyDetailUI.this.zdG = null;
                    AppMethodBeat.o(213381);
                }
                return false;
            }
        }, R.drawable.icon_back);
        this.zcQ = (RecyclerView) findViewById(R.id.ezi);
        RecyclerView recyclerView = this.zcQ;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        this.agA = LayoutInflater.from(this).inflate(R.layout.b3n, (ViewGroup) this.zcQ, false);
        this.rfF = LayoutInflater.from(this).inflate(R.layout.b3l, (ViewGroup) this.zcQ, false);
        this.zdR = new WxRecyclerAdapter(new f() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass30 */

            @Override // com.tencent.mm.view.recyclerview.f
            public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                AppMethodBeat.i(213382);
                if (i2 == 2) {
                    b bVar = new b();
                    AppMethodBeat.o(213382);
                    return bVar;
                }
                AppMethodBeat.o(213382);
                return null;
            }
        }, this.zds, false);
        this.zdR.f(this.agA, 1, false);
        this.zcQ.setAdapter(this.zdR);
        this.zcQ.a(this.anE);
        this.yQt = (ImageView) this.agA.findViewById(R.id.ezm);
        this.yQu = (TextView) this.agA.findViewById(R.id.f03);
        this.zdn = this.agA.findViewById(R.id.f01);
        this.yQv = (ImageView) this.agA.findViewById(R.id.ez6);
        this.yln = (TextView) this.agA.findViewById(R.id.f06);
        this.yUl = (RelativeLayout) this.agA.findViewById(R.id.f0a);
        this.yUm = (BaseEmojiView) this.agA.findViewById(R.id.f07);
        this.yUn = (TextView) this.agA.findViewById(R.id.f4q);
        this.yUo = (LinearLayout) this.agA.findViewById(R.id.f1m);
        this.yUp = (ProgressBar) this.agA.findViewById(R.id.c0c);
        this.yQw = this.agA.findViewById(R.id.eyr);
        this.yQk = (TextView) this.agA.findViewById(R.id.eyq);
        this.zdo = (ViewGroup) this.agA.findViewById(R.id.f1d);
        this.zdp = (TextView) this.agA.findViewById(R.id.f1e);
        this.zdq = (ImageView) this.agA.findViewById(R.id.f1c);
        this.yQx = this.agA.findViewById(R.id.ez8);
        this.nAB = (TextView) this.agA.findViewById(R.id.ezz);
        this.zcR = (CdnImageView) this.agA.findViewById(R.id.ez7);
        this.jVn = (TextView) this.agA.findViewById(R.id.eyx);
        this.zcg = this.agA.findViewById(R.id.ezg);
        this.zcS = this.agA.findViewById(R.id.eyv);
        this.zcT = (ImageView) this.agA.findViewById(R.id.eyu);
        this.zde = (LinearLayout) this.agA.findViewById(R.id.f4x);
        this.zdf = (LinearLayout) this.agA.findViewById(R.id.f51);
        this.zdg = (LinearLayout) this.agA.findViewById(R.id.f54);
        this.zdh = (BaseEmojiView) this.agA.findViewById(R.id.f4y);
        this.zdi = (RelativeLayout) this.agA.findViewById(R.id.f53);
        this.zdj = (ImageView) this.agA.findViewById(R.id.f4z);
        this.zcU = (ViewGroup) this.agA.findViewById(R.id.eyz);
        this.zcV = this.agA.findViewById(R.id.eyy);
        this.zcW = this.agA.findViewById(R.id.ez0);
        this.zcX = this.agA.findViewById(R.id.ez1);
        this.zdb = (RelativeLayout) this.agA.findViewById(R.id.eyv);
        this.rIY = (ImageView) this.agA.findViewById(R.id.eyu);
        this.zdm = (ImageView) this.agA.findViewById(R.id.f56);
        this.zdd = (ViewGroup) findViewById(R.id.f0w);
        this.yUn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass31 */

            public final void onClick(View view) {
                AppMethodBeat.i(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(NativeProtocol.MESSAGE_GET_LOGIN_STATUS_REPLY);
            }
        });
        this.zdk = new a(this);
        this.zdl = getLayoutInflater().inflate(R.layout.b3s, (ViewGroup) null);
        this.zdk.setContentView(this.zdl, new ViewGroup.LayoutParams(-1, -1));
        this.zdl.findViewById(R.id.f0_).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass32 */

            public final void onClick(View view) {
                AppMethodBeat.i(65555);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65555);
            }
        });
        this.zdk.zbp = new a.AbstractC1468a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.luckymoney.ui.a.AbstractC1468a
            public final void efU() {
                AppMethodBeat.i(65516);
                LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(65516);
            }
        };
        this.zdx = (ViewGroup) this.zdl.findViewById(R.id.f0b);
        if (com.tencent.mm.pluginsdk.ui.chat.e.Knc == null) {
            Log.w("MicroMsg.LuckyMoneyDetailUI", "can't show correctly");
            finish();
            AppMethodBeat.o(65561);
            return;
        }
        this.zdv = com.tencent.mm.pluginsdk.ui.chat.e.Knc.eZ(getContext());
        this.zdv.setTalkerName(this.gAn);
        this.zdv.setShowSmiley(false);
        this.zdv.setShowSmiley(true);
        this.zcR.setUseSdcardCache(true);
        this.yUm.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(213355);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.LuckyMoneyDetailUI", "mEmoji click");
                g.aAi();
                if (!g.aAh().isSDCardAvailable()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213355);
                } else if (Util.isNullOrNil(LuckyMoneyDetailUI.this.rcU)) {
                    Log.e("MicroMsg.LuckyMoneyDetailUI", "mEmojiMd5 == null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213355);
                } else {
                    EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(LuckyMoneyDetailUI.this.rcU);
                    ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(LuckyMoneyDetailUI.this.gof);
                    if (aml == null || aml.NA()) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213355);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("custom_smiley_preview_md5", LuckyMoneyDetailUI.this.rcU);
                    intent.putExtra("custom_to_talker_name", Hb.field_talker);
                    if (!(aml.field_catalog == EmojiGroupInfo.VkP || aml.field_catalog == EmojiGroupInfo.VkO || aml.field_catalog == EmojiGroupInfo.VkN)) {
                        intent.putExtra("custom_smiley_preview_productid", aml.field_groupId);
                    }
                    intent.putExtra("msg_id", Hb.field_msgSvrId);
                    intent.putExtra("msg_content", Hb.field_content);
                    String str = Hb.field_talker;
                    if (ab.Eq(str)) {
                        str = bp.Ks(Hb.field_content);
                        intent.putExtra("room_id", LuckyMoneyDetailUI.this.gAn);
                    }
                    intent.putExtra("msg_sender", str);
                    intent.putExtra("scene", 30);
                    com.tencent.mm.br.c.b(LuckyMoneyDetailUI.this, "emoji", ".ui.CustomSmileyPreviewUI", intent, 1111);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(213355);
                }
            }
        });
        this.zdr = (EnvelopeAppBarLayout) findViewById(R.id.f0i);
        this.zdr.setActivityLifeCycle(this);
        AppMethodBeat.o(65561);
    }

    private void b(dlt dlt) {
        AppMethodBeat.i(163739);
        f(this.zdU);
        this.zdr.a(dlt, this.zdT, this.zdE, this.qBv, ab.IN(this.gAn));
        ((com.tencent.mm.plugin.luckymoney.a.a) g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(dlt, true);
        hWf();
        egh();
        AppMethodBeat.o(163739);
    }

    private void byj(final String str) {
        AppMethodBeat.i(258640);
        Log.i("MicroMsg.LuckyMoneyDetailUI", "sendEmoji emojiType :%s", Integer.valueOf(this.UXR));
        switch (this.UXR) {
            case 1:
                ((j) g.af(j.class)).c(this, this.gAn, str, getString(R.string.ery), new y.a() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass4 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                    public final void a(boolean z, String str, int i2) {
                        int i3 = 1;
                        AppMethodBeat.i(213357);
                        LuckyMoneyDetailUI.this.hideVKB();
                        LuckyMoneyDetailUI.this.zdA = new hd();
                        if (z) {
                            LuckyMoneyDetailUI.this.zdA.eEH = 5;
                            LuckyMoneyDetailUI.this.zdB = new he();
                            if (LuckyMoneyDetailUI.this.zdC == 0 || LuckyMoneyDetailUI.this.zdC == 2) {
                                i3 = 2;
                            } else if (LuckyMoneyDetailUI.this.zdC != 1) {
                                i3 = 0;
                            }
                            LuckyMoneyDetailUI.this.zdB.eLv = (long) i3;
                            LuckyMoneyDetailUI.this.zdB.bwA(str);
                            if (Util.isNullOrNil(str)) {
                                LuckyMoneyDetailUI.this.zdB.eLx = 1;
                            } else {
                                LuckyMoneyDetailUI.this.zdB.eLx = 2;
                            }
                            LuckyMoneyDetailUI.this.zdB.bfK();
                            LuckyMoneyDetailUI.bI(LuckyMoneyDetailUI.this.gAn, str, str);
                            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 3, str);
                            t.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(R.string.dzo), LuckyMoneyDetailUI.this.getContext(), 0, null);
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(213356);
                                    LuckyMoneyDetailUI.this.finish();
                                    AppMethodBeat.o(213356);
                                }
                            }, 500);
                        } else {
                            LuckyMoneyDetailUI.this.zdA.eEH = 6;
                        }
                        LuckyMoneyDetailUI.this.zdA.bfK();
                        AppMethodBeat.o(213357);
                    }
                });
                AppMethodBeat.o(258640);
                return;
            default:
                ((j) g.af(j.class)).a(this, this.gAn, this.zdw.getMd5(), getString(R.string.ery), new y.a() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass5 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                    public final void a(boolean z, String str, int i2) {
                        int i3 = 1;
                        AppMethodBeat.i(258616);
                        LuckyMoneyDetailUI.this.hideVKB();
                        LuckyMoneyDetailUI.this.zdA = new hd();
                        if (z) {
                            LuckyMoneyDetailUI.this.zdA.eEH = 5;
                            LuckyMoneyDetailUI.this.zdB = new he();
                            if (LuckyMoneyDetailUI.this.zdC == 0 || LuckyMoneyDetailUI.this.zdC == 2) {
                                if (!com.tencent.mm.plugin.emoji.h.b.y(LuckyMoneyDetailUI.this.zdw)) {
                                    i3 = com.tencent.mm.plugin.emoji.h.b.w(LuckyMoneyDetailUI.this.zdw) ? 3 : 2;
                                }
                            } else if (LuckyMoneyDetailUI.this.zdC != 1) {
                                i3 = 0;
                            }
                            LuckyMoneyDetailUI.this.zdB.eLv = (long) i3;
                            LuckyMoneyDetailUI.this.zdB.bwA(LuckyMoneyDetailUI.this.zdw.getMd5());
                            if (Util.isNullOrNil(str)) {
                                LuckyMoneyDetailUI.this.zdB.eLx = 1;
                            } else {
                                LuckyMoneyDetailUI.this.zdB.eLx = 2;
                            }
                            LuckyMoneyDetailUI.this.zdB.bfK();
                            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.gAn, str, LuckyMoneyDetailUI.this.zdw.getMd5());
                            LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, 3);
                            t.a(LuckyMoneyDetailUI.this.getContext().getResources().getString(R.string.dzo), LuckyMoneyDetailUI.this.getContext(), 0, null);
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(258615);
                                    LuckyMoneyDetailUI.this.finish();
                                    AppMethodBeat.o(258615);
                                }
                            }, 500);
                        } else {
                            LuckyMoneyDetailUI.this.zdA.eEH = 6;
                        }
                        LuckyMoneyDetailUI.this.zdA.bfK();
                        AppMethodBeat.o(258616);
                    }
                });
                AppMethodBeat.o(258640);
                return;
        }
    }

    private void efU() {
        AppMethodBeat.i(258641);
        com.tencent.mm.plugin.luckymoney.ui.a.b.a(this, this.zdv);
        this.zdk.dismiss();
        AppMethodBeat.o(258641);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(65564);
        super.onKeyboardStateChanged();
        Log.d("MicroMsg.LuckyMoneyDetailUI", "keyboard changed: %s", Integer.valueOf(keyboardState()));
        keyboardState();
        AppMethodBeat.o(65564);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(65565);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(65565);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        int i4 = 0;
        AppMethodBeat.i(65566);
        Log.i("MicroMsg.LuckyMoneyDetailUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
        if (qVar instanceof ao) {
            if (i2 == 0 && i3 == 0) {
                ao aoVar = (ao) qVar;
                q qVar2 = aoVar.yWT;
                this.zcp = aoVar.yXg;
                this.rcU = aoVar.yXh;
                this.zdu = aoVar.yXi;
                this.zdy = aoVar.yXj;
                this.zdU = qVar2;
                a(this.zdU);
                AppMethodBeat.o(65566);
                return true;
            }
            com.tencent.mm.ui.base.h.cD(this, str);
            AppMethodBeat.o(65566);
            return true;
        } else if (qVar instanceof ax) {
            if (i2 == 0 && i3 == 0) {
                this.yQg = false;
                ax axVar = (ax) qVar;
                if (this.yQe != null) {
                    while (true) {
                        if (i4 >= this.yQe.size()) {
                            break;
                        }
                        ad adVar = this.yQe.get(i4);
                        if (adVar.yVk.equalsIgnoreCase(axVar.yVk)) {
                            adVar.yWF = axVar.yPK;
                            this.zdR.atj.notifyChanged();
                            break;
                        }
                        i4++;
                    }
                }
                AppMethodBeat.o(65566);
                return true;
            }
            com.tencent.mm.ui.base.h.cD(this, str);
            AppMethodBeat.o(65566);
            return true;
        } else if (!(qVar instanceof bf)) {
            AppMethodBeat.o(65566);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
            AppMethodBeat.o(65566);
            return true;
        } else {
            com.tencent.mm.ui.base.h.cD(this, str);
            AppMethodBeat.o(65566);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(65567);
        switch (i2) {
            case 1:
                if (i3 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra)) {
                        if (this.zcl != null && this.zcl.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            doSceneProgress(new bf(stringExtra.replaceAll(",", "|"), this.yUc, "v1.0"));
                            break;
                        }
                    }
                }
                break;
            case 2:
                com.tencent.mm.plugin.luckymoney.a.d.xV(8);
                break;
            case 1111:
                if (i3 != -1) {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "go emoji capture failed!");
                    break;
                } else {
                    String str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("gif_md5");
                    }
                    if (Util.isNullOrNil(str)) {
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "md5 == null go emoji capture failed!");
                        break;
                    } else {
                        this.UXR = 2;
                        bF(2, str);
                        byj("");
                        efU();
                        break;
                    }
                }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(65567);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(65568);
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean b2 = ((RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper")).b(this, bundle, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(258622);
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    LuckyMoneyDetailUI.H(LuckyMoneyDetailUI.this);
                    AppMethodBeat.o(258622);
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b2) {
                super.finish();
            }
        } else {
            super.finish();
        }
        overridePendingTransition(R.anim.em, R.anim.er);
        AppMethodBeat.o(65568);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3o;
    }

    private void qM(boolean z) {
        AppMethodBeat.i(65569);
        Log.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle:%s", Boolean.TRUE);
        this.yUn.setVisibility(8);
        this.zeb = 1;
        if (z) {
            this.zdY = 3;
        } else {
            this.zdY--;
            if (this.zdY == 0) {
                Log.i("MicroMsg.LuckyMoneyDetailUI", "showEmoji() circle fail!");
                this.yUo.setVisibility(8);
                this.yUn.setVisibility(0);
                this.zeb = 2;
                AppMethodBeat.o(65569);
                return;
            }
        }
        this.rfq = k.getEmojiStorageMgr().OpN.blk(this.rcU);
        if (this.rfq == null) {
            this.rfq = new EmojiInfo();
            this.rfq.field_md5 = this.rcU;
            this.rfq.field_type = this.zdu;
        } else if (s.boW(this.rfq.hYx()) > 0 || this.rfq.NA() || this.rfq.hYm()) {
            this.yUm.setVisibility(0);
            A(this.rfq);
            AppMethodBeat.o(65569);
            return;
        }
        if (z) {
            this.yUm.setVisibility(8);
            this.yUo.setVisibility(0);
            k.cGd().rbg = this.rbg;
        }
        k.cGd().u(this.rfq);
        g.aAg().hqi.a(697, this.zdZ);
        AppMethodBeat.o(65569);
    }

    private void A(EmojiInfo emojiInfo) {
        AppMethodBeat.i(65570);
        this.zeb = 3;
        this.yUm.setEmojiInfo(emojiInfo);
        this.zdz = new hf();
        this.zdz.eEH = 11;
        this.zdz.bfK();
        AppMethodBeat.o(65570);
    }

    private boolean egg() {
        AppMethodBeat.i(65572);
        if (Util.isNullOrNil(this.rcU) || (!Util.isEqual(this.zdy.yVG, 1) && !Util.isEqual(this.zdy.yVH, 1))) {
            AppMethodBeat.o(65572);
            return false;
        }
        AppMethodBeat.o(65572);
        return true;
    }

    private void a(final q qVar) {
        boolean z;
        boolean z2;
        bh aDy;
        String str;
        AppMethodBeat.i(65573);
        if (qVar == null) {
            AppMethodBeat.o(65573);
            return;
        }
        boolean e2 = e(qVar);
        if (g(qVar)) {
            if (egg()) {
            }
        } else if (!e2) {
            egg();
        } else if (!egg()) {
        }
        if (egg()) {
            this.yUl.setVisibility(0);
            qM(true);
        } else {
            this.yUl.setVisibility(8);
        }
        if (!Util.isEqual(this.zdy.yVI, 0) && e(qVar) && this.zdD && qVar.yVv != 7) {
            this.zdf.setOnClickListener(this.zdX);
            this.zdf.setTag("nodelete");
            this.zdj.setOnClickListener(this.zdX);
            this.zdm.setOnClickListener(this.zdX);
            this.zdi.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(163720);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    LuckyMoneyDetailUI.this.zdA = new hd();
                    LuckyMoneyDetailUI.this.zdA.eEH = 7;
                    LuckyMoneyDetailUI.this.zdA.bfK();
                    LuckyMoneyDetailUI.this.UXR = LuckyMoneyDetailUI.hWh();
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "click mEmojiUseType：%s", Integer.valueOf(LuckyMoneyDetailUI.this.UXR));
                    switch (LuckyMoneyDetailUI.this.UXR) {
                        case 1:
                            LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_NORMAL_STRING, ""));
                            break;
                        default:
                            LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
                            break;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(163720);
                }
            });
            this.zdh.setOnClickListener(this.zdX);
            this.UXR = hWg();
            Log.i("MicroMsg.LuckyMoneyDetailUI", "init mEmojiUseType：%s", Integer.valueOf(this.UXR));
            switch (this.UXR) {
                case 1:
                    String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_NORMAL_STRING, "");
                    PR(1);
                    if (!Util.isNullOrNil(str2)) {
                        bF(2, str2);
                        break;
                    }
                    break;
                default:
                    String str3 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, "");
                    PR(1);
                    if (!Util.isNullOrNil(str3)) {
                        bF(2, str3);
                        break;
                    }
                    break;
            }
        } else {
            PR(0);
        }
        if (qVar.yVn == 1) {
            z = true;
        } else {
            z = false;
        }
        this.zci = z;
        if (qVar != null) {
            boolean z3 = (qVar.egZ == 3 || qVar.egZ == 2) && qVar.yVm == 1 && !this.zci && qVar.yVp == 1;
            boolean z4 = qVar.yVq != null && qVar.yVq.gGn == 1 && !Util.isNullOrNil(qVar.yVq.yUG);
            this.zcY = (TextView) this.rfF.findViewById(R.id.ezk);
            if (z3 || z4) {
                this.zcY.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass34 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(258636);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(LuckyMoneyDetailUI.PS(qVar.yVv)), 0, 0, 0, 3);
                        af.a((MMActivity) LuckyMoneyDetailUI.this, 1, false);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(258636);
                    }
                });
                if (z4) {
                    this.zcl = qVar.yVq.yUG;
                    this.zcY.setText(qVar.yVq.yUH);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(PP(qVar.yVv)), 0, 0, 0, 2);
                this.zcY.setVisibility(0);
            } else {
                this.zcY.setVisibility(8);
            }
            this.yVv = qVar.yVv;
            this.zcZ = (TextView) this.rfF.findViewById(R.id.ezh);
            this.zcZ.setVisibility(8);
            if (!this.zcq) {
                this.zdR.g(this.rfF, 3, false);
                this.zcq = true;
            }
        }
        if (this.fs == 0) {
            this.zck = qVar.yVk;
            String str4 = this.zck;
            if (qVar == null || qVar.egY != 0 || qVar.yVw == null || qVar.yVw.size() <= 0 || !qVar.yVw.get(0).yVk.equals(str4) || qVar.yVl == 1) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.yQg = false;
                this.zcU.setVisibility(8);
            } else {
                this.zcU.setVisibility(0);
                if (g(qVar) && !e(qVar)) {
                    this.zcV.setVisibility(8);
                    this.zcW.setVisibility(8);
                    this.zcX.setVisibility(8);
                }
            }
            this.yQh = qVar.yVv;
            if (qVar != null) {
                AppCompatActivity context = getContext();
                if (qVar.yVv == 2) {
                    this.yQt.setImageResource(R.drawable.cc2);
                    if (qVar.resourceId != 0) {
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + qVar.resourceId);
                        final jq jqVar = new jq();
                        jqVar.dOw.dOy = qVar.resourceId;
                        jqVar.callback = new Runnable() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass19 */

                            public final void run() {
                                AppMethodBeat.i(163733);
                                if (jqVar.dOx.dOz) {
                                    Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + jqVar.dOx.dOA);
                                    LuckyMoneyDetailUI.this.getContext();
                                    af.s(LuckyMoneyDetailUI.this.yQt, jqVar.dOx.dOA);
                                    AppMethodBeat.o(163733);
                                    return;
                                }
                                Log.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                                af.a(LuckyMoneyDetailUI.this.yQt, qVar.yVe, qVar.yVy);
                                AppMethodBeat.o(163733);
                            }
                        };
                        EventCenter.instance.asyncPublish(jqVar, Looper.myLooper());
                    } else {
                        af.a(this.yQt, qVar.yVe, qVar.yVy);
                    }
                } else if (ab.IN(this.gAn)) {
                    this.yQt.setImageResource(R.drawable.ct6);
                } else if (this.gwE == 3 && qVar.UXx == 1) {
                    this.yQt.setVisibility(8);
                } else {
                    af.a(this.yQt, qVar.yVe, qVar.yVy);
                }
                if (!Util.isNullOrNil(qVar.yVF)) {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "use union sendername");
                    String string = ab.IN(this.gAn) ? qVar.yVd + qVar.yVF : getString(R.string.eso, new Object[]{qVar.yVd + qVar.yVF});
                    this.yQu.setMaxWidth(((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() - BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 92.0f));
                    SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), string, this.yQu.getTextSize());
                    com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), qVar.yVd, this.yQu.getTextSize());
                    com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), qVar.yVF, this.yQu.getTextSize());
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b2);
                    spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#FA9D3B", new q.a() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass20 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                        public final void dF(View view) {
                            AppMethodBeat.i(258630);
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "SpanClick");
                            AppMethodBeat.o(258630);
                        }
                    }), string.lastIndexOf(qVar.yVF), string.lastIndexOf(qVar.yVF) + qVar.yVF.length(), 18);
                    this.yQu.setText(spannableStringBuilder);
                } else {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "use union normal name");
                    if (ab.IN(this.gAn)) {
                        str = qVar.yVd;
                    } else if (this.gwE != 3 || qVar.UXw) {
                        g.aAi();
                        as bjK = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(qVar.yVy);
                        if (bjK == null || Util.isNullOrNil(bjK.field_username)) {
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "do get contact: %s", qVar.yVy);
                            this.UXS.add(qVar.yVy);
                            ay.a.iDq.a(qVar.yVy, "", new ay.b.a() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass21 */

                                @Override // com.tencent.mm.model.ay.b.a
                                public final void p(final String str, boolean z) {
                                    AppMethodBeat.i(258632);
                                    Log.v("MicroMsg.LuckyMoneyParseHelper", "getContact suc, user: %s", str);
                                    if (z) {
                                        com.tencent.f.h.RTc.aW(new Runnable() {
                                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass21.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(258631);
                                                LuckyMoneyDetailUI.this.UXS.remove(str);
                                                qVar.yVd = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(qVar.yVy);
                                                af.a(LuckyMoneyDetailUI.this.getContext(), LuckyMoneyDetailUI.this.yQu, LuckyMoneyDetailUI.this.getString(R.string.eso, new Object[]{qVar.yVd}));
                                                AppMethodBeat.o(258631);
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(258632);
                                }
                            });
                            str = "";
                        } else {
                            str = getString(R.string.eso, new Object[]{qVar.yVd});
                        }
                    } else {
                        str = qVar.yVd;
                    }
                    this.yQu.setMaxWidth(((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() - BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 92.0f));
                    af.a(context, this.yQu, str);
                }
                af.a(context, this.yln, qVar.yPK);
                if (!Util.isNullOrNil(qVar.yPK)) {
                    this.yln.setVisibility(0);
                } else {
                    this.yln.setVisibility(8);
                }
                if (qVar.egY == 1) {
                    this.yQv.setVisibility(0);
                    this.yQv.setImageResource(R.raw.lucky_money_group_icon_new);
                } else if (qVar.egY == 2) {
                    if (!ab.IS(qVar.yVy)) {
                        com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                        iVar.username = qVar.yVy;
                        p.aYB().b(iVar);
                    }
                    this.yQv.setVisibility(0);
                    this.yQv.setImageResource(R.raw.lucky_money_f2f_record_icon);
                } else {
                    this.yQv.setVisibility(8);
                }
                if (!Util.isNullOrNil(qVar.yVu)) {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", qVar.yVu);
                    this.zdb.setVisibility(4);
                    af.o(this.rIY, qVar.yVu);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass22 */

                        public final void run() {
                            AppMethodBeat.i(65539);
                            LuckyMoneyDetailUI.T(LuckyMoneyDetailUI.this);
                            LuckyMoneyDetailUI.this.zdb.setVisibility(0);
                            AppMethodBeat.o(65539);
                        }
                    }, 500);
                } else {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                    this.zdb.setVisibility(8);
                }
                if (qVar.eha != 2 || this.zcj == 3) {
                    this.yQw.setVisibility(8);
                } else {
                    this.yQk.setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(((double) qVar.eht) / 100.0d));
                    this.yQw.setVisibility(0);
                }
                if (!Util.isNullOrNil(qVar.yVC)) {
                    this.zdo.setVisibility(0);
                    this.zdp.setText(qVar.yVC);
                    this.zdq.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass24 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(258633);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.d("MicroMsg.LuckyMoneyDetailUI", "click tips icon");
                            LuckyMoneyDetailUI.V(LuckyMoneyDetailUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(258633);
                        }
                    });
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.yQx.getLayoutParams();
                    if (marginLayoutParams != null) {
                        marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16);
                        this.yQx.setLayoutParams(marginLayoutParams);
                    }
                } else {
                    this.zdo.setVisibility(8);
                }
                if (!Util.isNullOrNil(qVar.yRP)) {
                    this.yQx.setVisibility(0);
                    this.nAB.setText(qVar.yRP);
                    if (ab.IN(this.gAn)) {
                        this.zcR.setVisibility(8);
                        this.agA.findViewById(R.id.f00).setVisibility(8);
                    } else if (qVar.yRN == 1) {
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "changeIconUrl: %s", qVar.yVA);
                        if (!Util.isNullOrNil(qVar.yVA)) {
                            this.zcR.setUrl(qVar.yVA);
                            this.zcR.setVisibility(0);
                        } else {
                            this.zcR.setVisibility(8);
                        }
                        this.nAB.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass25 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(213377);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                LuckyMoneyDetailUI.c(LuckyMoneyDetailUI.this, qVar);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(213377);
                            }
                        });
                    } else {
                        Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                    }
                } else {
                    Log.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                    this.yQx.setVisibility(8);
                }
                if (!Util.isNullOrNil(qVar.yVo)) {
                    this.jVn.setText(qVar.yVo);
                    this.zcU.setVisibility(0);
                    if (g(qVar) && !e(qVar)) {
                        this.zcV.setVisibility(8);
                        this.zcW.setVisibility(8);
                        this.zcX.setVisibility(8);
                    }
                } else {
                    this.jVn.setText((CharSequence) null);
                    this.zcU.setVisibility(8);
                }
            }
            if (qVar != null) {
                LinkedList<bg> linkedList = qVar.yVr;
                if (linkedList != null && linkedList.size() > 0) {
                    View findViewById = this.agA.findViewById(R.id.ezd);
                    View findViewById2 = this.agA.findViewById(R.id.eze);
                    View findViewById3 = this.agA.findViewById(R.id.ezf);
                    ViewGroup viewGroup = (ViewGroup) this.agA.findViewById(R.id.eza);
                    ViewGroup viewGroup2 = (ViewGroup) this.agA.findViewById(R.id.ezb);
                    ViewGroup viewGroup3 = (ViewGroup) this.agA.findViewById(R.id.ezc);
                    View findViewById4 = this.agA.findViewById(R.id.ez2);
                    View findViewById5 = this.agA.findViewById(R.id.ez3);
                    i.c cVar = new i.c();
                    cVar.textColor = getResources().getColor(R.color.yo);
                    if (linkedList.size() > 0) {
                        i.a(this, viewGroup, linkedList.get(0), cVar);
                        findViewById.setVisibility(0);
                    }
                    if (linkedList.size() > 1) {
                        i.a(this, viewGroup2, linkedList.get(1), cVar);
                        findViewById2.setVisibility(0);
                    }
                    if (linkedList.size() > 2) {
                        i.a(this, viewGroup3, linkedList.get(2), cVar);
                        findViewById3.setVisibility(0);
                    }
                    if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                        findViewById4.setVisibility(0);
                    }
                    if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                        findViewById5.setVisibility(0);
                    }
                    if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                        this.zcg.requestLayout();
                        this.zcg.setVisibility(0);
                    }
                }
                this.zda = (ViewGroup) this.rfF.findViewById(R.id.ez5);
                ViewGroup viewGroup4 = (ViewGroup) this.rfF.findViewById(R.id.k0q);
                i.c cVar2 = new i.c();
                cVar2.textColor = getResources().getColor(R.color.ad);
                cVar2.textSize = getResources().getDimensionPixelSize(R.dimen.hc);
                i.a(this, this.zda, qVar.yVs, cVar2);
                i.c cVar3 = new i.c();
                cVar3.textColor = getResources().getColor(R.color.Link);
                cVar3.textSize = getResources().getDimensionPixelSize(R.dimen.hc);
                if (!(qVar.yVB == null || ab.IN(this.gAn) || (aDy = bh.aDy(qVar.yVB)) == null || aDy.yXV == null)) {
                    cVar3.zgz = aDy.yUC;
                    if (cVar3.zgz == null) {
                        cVar3.zgz = new cbe();
                        cVar3.zgz.MgB = this.zdE;
                    }
                    i.a(this, this.zda, aDy.yXV, cVar3);
                    View findViewById6 = this.rfF.findViewById(R.id.k0p);
                    TextView textView = (TextView) this.rfF.findViewById(R.id.k0o);
                    textView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.hc));
                    if (Util.isNullOrNil(this.zdT) || this.zda.getVisibility() != 0) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zda.getLayoutParams();
                        layoutParams.width = -1;
                        this.zda.setLayoutParams(layoutParams);
                        findViewById6.setVisibility(8);
                        textView.setVisibility(8);
                    } else {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zda.getLayoutParams();
                        layoutParams2.width = -2;
                        this.zda.setLayoutParams(layoutParams2);
                        findViewById6.setVisibility(0);
                        textView.setVisibility(0);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(22302, 4);
                        textView.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass35 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(258637);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.LuckyMoneyDetailUI", "on click mFootOperComplaint");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22302, 5);
                                com.tencent.mm.wallet_core.ui.f.bn(LuckyMoneyDetailUI.this.getContext(), "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=73&msgId=" + LuckyMoneyDetailUI.this.zdT);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(258637);
                            }
                        });
                    }
                    String str5 = "";
                    if (aDy.yUC != null) {
                        str5 = aDy.yUC.Lot;
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16589, 1, aDy.yXV.content, this.zdE, str5, 0, com.tencent.mm.plugin.luckymoney.a.c.openId);
                }
                if (this.zda.getVisibility() == 0) {
                    viewGroup4.setVisibility(0);
                } else {
                    viewGroup4.setVisibility(8);
                }
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11701, Integer.valueOf(PP(qVar.yVv)), 0, 0, 0, 1);
        }
        LinkedList<ad> linkedList2 = qVar.yVw;
        if (linkedList2 != null) {
            for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                ad adVar = linkedList2.get(i2);
                if (!this.zcn.containsKey(adVar.yVk)) {
                    this.yQe.add(linkedList2.get(i2));
                    a aVar = new a();
                    aVar.zep = linkedList2.get(i2);
                    this.zds.add(aVar);
                    this.zcn.put(adVar.yVk, 1);
                }
            }
            this.fs += linkedList2.size();
            this.mwr = false;
            this.zdR.atj.notifyChanged();
        }
        if (qVar.egY == 2 && !Util.isNullOrNil(qVar.yVc)) {
            this.yRy = new SoundPool(2, 3, 0);
            this.zdc = new int[2];
            try {
                this.zdc[0] = this.yRy.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                this.zdc[1] = this.yRy.load(getResources().getAssets().openFd("whistle.m4a"), 0);
            } catch (IOException e3) {
                Log.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e3.getMessage());
            }
            this.yRy.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass17 */

                public final void onLoadComplete(SoundPool soundPool, int i2, int i3) {
                    AppMethodBeat.i(258628);
                    if (i3 == 0) {
                        if (i2 == LuckyMoneyDetailUI.this.zdc[0]) {
                            soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
                            AppMethodBeat.o(258628);
                            return;
                        } else if (i2 == LuckyMoneyDetailUI.this.zdc[1] && qVar.eht >= 19000) {
                            soundPool.play(i2, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    }
                    AppMethodBeat.o(258628);
                }
            });
            this.agA.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(258629);
                    LuckyMoneyDetailUI.this.zdd = (ViewGroup) LuckyMoneyDetailUI.this.findViewById(R.id.f0w);
                    ViewGroup viewGroup = LuckyMoneyDetailUI.this.zdd;
                    com.tencent.mm.particles.b bVar = LuckyMoneyDetailUI.this.yTb;
                    com.tencent.mm.particles.a aVar = new com.tencent.mm.particles.a(viewGroup);
                    com.tencent.mm.particles.c az = new com.tencent.mm.particles.c(viewGroup.getContext(), bVar, new com.tencent.mm.particles.d(-100, viewGroup.getHeight() / 2), viewGroup).G(600.0f, 150.0f).H(-1000.0f, 250.0f).ay(-200.0f).az(1500.0f);
                    az.jIV = 600.0f;
                    az.jIW = 300.0f;
                    com.tencent.mm.particles.c bkG = az.bkG();
                    bkG.jIy = com.tencent.mm.particles.e.bkO();
                    aVar.hRg = bkG.bkH().bkI();
                    aVar.G(100, 400);
                    ViewGroup viewGroup2 = LuckyMoneyDetailUI.this.zdd;
                    com.tencent.mm.particles.b bVar2 = LuckyMoneyDetailUI.this.yTb;
                    com.tencent.mm.particles.a aVar2 = new com.tencent.mm.particles.a(viewGroup2);
                    com.tencent.mm.particles.c az2 = new com.tencent.mm.particles.c(viewGroup2.getContext(), bVar2, new com.tencent.mm.particles.d(viewGroup2.getWidth() + 100, viewGroup2.getHeight() / 2), viewGroup2).G(-600.0f, 150.0f).H(-1000.0f, 250.0f).ay(200.0f).az(1500.0f);
                    az2.jIV = 600.0f;
                    az2.jIW = 300.0f;
                    com.tencent.mm.particles.c bkG2 = az2.bkG();
                    bkG2.jIy = com.tencent.mm.particles.e.bkO();
                    aVar2.hRg = bkG2.bkH().bkI();
                    aVar2.G(100, 400);
                    AppMethodBeat.o(258629);
                }
            }, 300);
        }
        if (!ab.IN(this.gAn)) {
            ae aVA = com.tencent.mm.plugin.wallet_core.model.t.fQE().aVA(this.yUq);
            if (aVA == null) {
                aVA = new ae();
            }
            aVA.field_mNativeUrl = this.yUq;
            aVA.field_receiveAmount = qVar.eht;
            aVA.field_receiveTime = System.currentTimeMillis();
            aVA.field_hbStatus = qVar.egZ;
            aVA.field_receiveStatus = qVar.eha;
            aVA.field_sendId = this.yUc;
            aVA.field_sender = this.gAn;
            if (aVA.field_receiveAmount > 0) {
                com.tencent.mm.plugin.wallet_core.model.t.fQE().a(aVA);
                if (aVA.field_hbType == 3) {
                    com.tencent.mm.plugin.luckymoney.b.a.eex().aDq(this.gAn);
                }
            }
        }
        egh();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(65573);
    }

    private void PR(int i2) {
        AppMethodBeat.i(65574);
        bF(i2, "");
        AppMethodBeat.o(65574);
    }

    private void bF(int i2, String str) {
        AppMethodBeat.i(65575);
        switch (i2) {
            case 0:
                this.zde.setVisibility(8);
                break;
            case 1:
                this.zde.setVisibility(0);
                this.zdf.setVisibility(0);
                this.zdg.setVisibility(8);
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, "");
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_NORMAL_STRING, "");
                break;
            case 2:
                Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState emojiType :%s", Integer.valueOf(this.UXR));
                switch (this.UXR) {
                    case 1:
                        String anj = com.tencent.mm.plugin.emoji.h.b.anj(str);
                        if (anj != null) {
                            this.zdh.setImageDrawable(com.tencent.mm.plugin.emoji.h.b.bxs(anj));
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_NORMAL_STRING, str);
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, "");
                            this.zde.setVisibility(0);
                            this.zdf.setVisibility(8);
                            this.zdg.setVisibility(0);
                            break;
                        } else {
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() emojiKey == null");
                            AppMethodBeat.o(65575);
                            return;
                        }
                    default:
                        if (!Util.isNullOrNil(str)) {
                            EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(str);
                            if (blk != null) {
                                this.zdw = blk;
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, this.zdw.getMd5());
                                g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_NORMAL_STRING, "");
                                this.zdh.setEmojiInfo(this.zdw);
                                this.zde.setVisibility(0);
                                this.zdf.setVisibility(8);
                                this.zdg.setVisibility(0);
                                break;
                            } else {
                                Log.i("MicroMsg.LuckyMoneyDetailUI", "exchangeThxEmojiState() temp == null");
                                AppMethodBeat.o(65575);
                                return;
                            }
                        }
                        break;
                }
        }
        if (ab.IN(this.gAn)) {
            this.zde.setVisibility(8);
        }
        AppMethodBeat.o(65575);
    }

    private boolean e(com.tencent.mm.plugin.luckymoney.model.q qVar) {
        if (qVar.eha != 2 || this.zcj == 3) {
            return false;
        }
        return true;
    }

    private void f(com.tencent.mm.plugin.luckymoney.model.q qVar) {
        AppMethodBeat.i(163740);
        if (qVar.yVB != null) {
            bh aDy = bh.aDy(qVar.yVB);
            if (!(!Util.isNullOrNil(this.zdT) || aDy == null || aDy.yUC == null)) {
                this.zdT = aDy.yUC.Lot;
            }
            this.yZG = getIntent().getStringExtra("key_detail_envelope_url");
            this.yZH = getIntent().getStringExtra("key_detail_envelope_md5");
            if (!(!Util.isNullOrNil(this.yZG) || aDy == null || aDy.yUC == null || aDy.yUC.MgC == null)) {
                this.yZG = aDy.yUC.MgC.MgV;
                this.yZH = aDy.yUC.MgC.MgY;
            }
            if (!Util.isNullOrNil(this.yZG)) {
                int i2 = 0;
                if (!(aDy == null || aDy.yUC == null)) {
                    i2 = aDy.yUC.subType;
                }
                this.zdr.aA(this.yZG, this.yZH, i2);
                if (!this.zdt) {
                    this.zdt = true;
                    com.tencent.mm.plugin.luckymoney.a.c.bC(3, this.yZG);
                }
            }
        }
        AppMethodBeat.o(163740);
    }

    private static boolean g(com.tencent.mm.plugin.luckymoney.model.q qVar) {
        if (qVar.yVm == 1) {
            return true;
        }
        return false;
    }

    private void hWf() {
        TextView textView;
        AppMethodBeat.i(258642);
        if (!Util.isNullOrNil(this.zdT) && this.zdT.startsWith("rpid_wxapp_") && this.rfF != null && (textView = (TextView) this.rfF.findViewById(R.id.k0r)) != null) {
            textView.setVisibility(0);
        }
        AppMethodBeat.o(258642);
    }

    private void egh() {
        AppMethodBeat.i(163741);
        Log.d("MicroMsg.LuckyMoneyDetailUI", "adjust footer");
        this.rfF.post(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass36 */

            public final void run() {
                AppMethodBeat.i(65549);
                if (LuckyMoneyDetailUI.this.isFinishing() || LuckyMoneyDetailUI.this.isDestroyed()) {
                    AppMethodBeat.o(65549);
                    return;
                }
                TextView textView = (TextView) LuckyMoneyDetailUI.this.rfF.findViewById(R.id.k0r);
                if (LuckyMoneyDetailUI.this.zda.getVisibility() == 8 && LuckyMoneyDetailUI.this.zcZ.getVisibility() == 8 && LuckyMoneyDetailUI.this.zcY.getVisibility() == 8 && textView.getVisibility() == 8) {
                    AppMethodBeat.o(65549);
                    return;
                }
                View findViewById = LuckyMoneyDetailUI.this.findViewById(R.id.ez4);
                if (LuckyMoneyDetailUI.this.rfF == null || findViewById == null) {
                    AppMethodBeat.o(65549);
                    return;
                }
                if (!LuckyMoneyDetailUI.this.zdQ) {
                    LuckyMoneyDetailUI.this.zdQ = true;
                    LuckyMoneyDetailUI.this.zdS = LuckyMoneyDetailUI.this.rfF.getHeight();
                }
                int height = findViewById.getHeight();
                LuckyMoneyDetailUI.this.rfF.getGlobalVisibleRect(new Rect());
                int top = LuckyMoneyDetailUI.this.rfF.getTop();
                int i2 = height - top;
                if (i2 > LuckyMoneyDetailUI.this.zdS) {
                    LuckyMoneyDetailUI.this.rfF.setMinimumHeight(i2);
                } else {
                    LuckyMoneyDetailUI.this.rfF.setMinimumHeight(LuckyMoneyDetailUI.this.zdS);
                }
                Log.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s diff:%s recordHeight:%s", Integer.valueOf(height), Integer.valueOf(i2), Integer.valueOf(top));
                AppMethodBeat.o(65549);
            }
        });
        AppMethodBeat.o(163741);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65577);
        super.onDestroy();
        if (this.zeb == 1 || this.zeb == 2) {
            this.zdz = new hf();
            this.zdz.eEH = 12;
            this.zdz.bfK();
        }
        if (this.yRy != null) {
            this.yRy.release();
            for (int i2 = 0; i2 < this.zdc.length; i2++) {
                this.yRy.unload(this.zdc[i2]);
            }
        }
        if (this.zdv != null) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "commentfooter release");
            this.zdv.onPause();
            this.zdv.goC();
            this.zdv.destroy();
        }
        k.cGd().rbg = null;
        com.tencent.mm.plugin.luckymoney.a.b.clear();
        com.tencent.mm.plugin.luckymoney.a.c.openId = null;
        com.tencent.mm.plugin.luckymoney.a.c.haD = null;
        com.tencent.mm.plugin.luckymoney.a.c.yOW = null;
        com.tencent.mm.plugin.luckymoney.a.c.iNV = null;
        com.tencent.mm.plugin.luckymoney.a.c.yOY = 0;
        com.tencent.mm.plugin.luckymoney.a.c.yOX = 0;
        com.tencent.mm.plugin.luckymoney.story.a.xV(1);
        g.aAg().hqi.b(697, this.zdZ);
        for (String str : this.UXS) {
            ay.a.iDq.JZ(str);
        }
        this.UXS.clear();
        AppMethodBeat.o(65577);
    }

    private static int PP(int i2) {
        if (i2 == 2) {
            return 13;
        }
        return 7;
    }

    private static int hWg() {
        AppMethodBeat.i(258643);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_NORMAL_STRING, "");
        if (!Util.isNullOrNil((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_LAST_THX_SEND_EMOJI_MD5_STRING, ""))) {
            AppMethodBeat.o(258643);
            return 2;
        } else if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(258643);
            return 1;
        } else {
            AppMethodBeat.o(258643);
            return 2;
        }
    }

    class b extends com.tencent.mm.view.recyclerview.e<a> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, a aVar, int i2, int i3, boolean z, List list) {
            AppMethodBeat.i(163738);
            final ad adVar = aVar.zep;
            if (LuckyMoneyDetailUI.this.yQh == 7) {
                hVar.mf(R.id.f4j, 8);
            } else {
                af.a((ImageView) hVar.Mn(R.id.f4j), adVar.yWE, adVar.userName);
            }
            if (Util.isNullOrNil(adVar.yWF)) {
                hVar.mf(R.id.f4i, 8);
            } else {
                af.a(LuckyMoneyDetailUI.this.getContext(), (TextView) hVar.Mn(R.id.f4i), adVar.yWF);
                hVar.mf(R.id.f4i, 0);
            }
            hVar.e(R.id.f4o, af.o(LuckyMoneyDetailUI.this.getContext(), Util.getLong(adVar.yWp, 0) * 1000));
            hVar.mf(R.id.f4o, 0);
            hVar.mf(R.id.f4p, 8);
            if (!Util.isNullOrNil(adVar.yWI)) {
                TextView textView = (TextView) hVar.Mn(R.id.f4n);
                SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(LuckyMoneyDetailUI.this.getContext(), adVar.yWD + adVar.yWI, textView.getTextSize());
                SpannableString b3 = com.tencent.mm.pluginsdk.ui.span.l.b(LuckyMoneyDetailUI.this.getContext(), adVar.yWD, textView.getTextSize());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(b2);
                spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q("#FA9D3B", new q.a() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                    public final void dF(View view) {
                        AppMethodBeat.i(213383);
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "nSpanClick");
                        AppMethodBeat.o(213383);
                    }
                }), b3.length(), b2.length(), 18);
                textView.setText(spannableStringBuilder);
            } else if (adVar.UXA) {
                hVar.e(R.id.f4n, "");
                final TextView textView2 = (TextView) hVar.Mn(R.id.f4n);
                Log.i("MicroMsg.LuckyMoneyDetailUI", "try get user contact: %s", adVar.userName);
                textView2.setTag(adVar.userName);
                LuckyMoneyDetailUI.this.UXS.add(adVar.userName);
                ay.a.iDq.a(adVar.userName, "", new ay.b.a() {
                    /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.b.AnonymousClass2 */

                    @Override // com.tencent.mm.model.ay.b.a
                    public final void p(final String str, boolean z) {
                        AppMethodBeat.i(258639);
                        Log.v("MicroMsg.LuckyMoneyParseHelper", "getContact suc, user: %s", str);
                        if (z) {
                            adVar.yWD = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(adVar.userName);
                            adVar.UXA = false;
                            com.tencent.f.h.RTc.aW(new Runnable() {
                                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.b.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(258638);
                                    LuckyMoneyDetailUI.this.UXS.remove(adVar.userName);
                                    if (textView2.getTag() != null) {
                                        if (str.equals((String) textView2.getTag())) {
                                            af.a(LuckyMoneyDetailUI.this.getContext(), textView2, adVar.yWD);
                                        }
                                    }
                                    AppMethodBeat.o(258638);
                                }
                            });
                        }
                        AppMethodBeat.o(258639);
                    }
                });
            } else {
                af.a(LuckyMoneyDetailUI.this.getContext(), (TextView) hVar.Mn(R.id.f4n), adVar.yWD);
            }
            hVar.e(R.id.f4h, LuckyMoneyDetailUI.this.getContext().getString(R.string.eri, new Object[]{com.tencent.mm.wallet_core.ui.f.formatMoney2f(((double) adVar.yWo) / 100.0d)}));
            if (!Util.isNullOrNil(adVar.yWH)) {
                hVar.e(R.id.f4m, adVar.yWH);
                hVar.mf(R.id.f4m, 0);
            } else {
                hVar.mf(R.id.f4m, 8);
            }
            if (Util.isNullOrNil(adVar.yWG)) {
                hVar.mf(R.id.f4k, 8);
                hVar.mf(R.id.f4l, 8);
                AppMethodBeat.o(163738);
                return;
            }
            hVar.e(R.id.f4l, adVar.yWG);
            if (LuckyMoneyDetailUI.this.yQh == 2) {
                ((ImageView) hVar.Mn(R.id.f4k)).setImageResource(R.drawable.cd2);
            } else {
                ((ImageView) hVar.Mn(R.id.f4k)).setImageResource(R.drawable.cbz);
            }
            hVar.mf(R.id.f4k, 0);
            hVar.mf(R.id.f4l, 0);
            AppMethodBeat.o(163738);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.b4c;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements com.tencent.mm.view.recyclerview.a {
        public ad zep;

        a() {
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(163737);
            long hashCode = (long) this.zep.yVk.hashCode();
            AppMethodBeat.o(163737);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 2;
        }
    }

    static /* synthetic */ void e(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        com.tencent.mm.ak.q aoVar;
        com.tencent.mm.ak.q aoVar2;
        AppMethodBeat.i(163742);
        luckyMoneyDetailUI.mwr = true;
        luckyMoneyDetailUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) luckyMoneyDetailUI.getContext(), 3, luckyMoneyDetailUI.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass15 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(258626);
                if (LuckyMoneyDetailUI.this.tipDialog != null && LuckyMoneyDetailUI.this.tipDialog.isShowing()) {
                    LuckyMoneyDetailUI.this.tipDialog.dismiss();
                }
                LuckyMoneyDetailUI.this.zbX.forceCancel();
                if (LuckyMoneyDetailUI.this.zdV != null) {
                    LuckyMoneyDetailUI.this.zdV.cancel();
                }
                if (LuckyMoneyDetailUI.K(LuckyMoneyDetailUI.this).getVisibility() == 8 || LuckyMoneyDetailUI.L(LuckyMoneyDetailUI.this).getVisibility() == 4) {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "user cancel & finish");
                    LuckyMoneyDetailUI.this.finish();
                }
                AppMethodBeat.o(258626);
            }
        });
        if (luckyMoneyDetailUI.zdF == 1) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "do get hk recordlist");
            luckyMoneyDetailUI.zdV = new com.tencent.mm.plugin.luckymoney.hk.a.a(luckyMoneyDetailUI.yUq, luckyMoneyDetailUI.yUc, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.getIntent().getIntExtra("key_hk_scene", 0));
            luckyMoneyDetailUI.zdV.aYI().b(new com.tencent.mm.vending.c.a<Object, c.a<bfb>>() {
                /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass16 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(c.a<bfb> aVar) {
                    AppMethodBeat.i(258627);
                    c.a<bfb> aVar2 = aVar;
                    if (aVar2 != null) {
                        Log.i("MicroMsg.LuckyMoneyDetailUI", "do query detail: errtype: %s, errcode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                        if (aVar2.errType == 0 && aVar2.errCode == 0) {
                            bfb bfb = (bfb) aVar2.iLC;
                            Log.i("MicroMsg.LuckyMoneyDetailUI", "do query detail: retcode: %s, retmsg: %s", Integer.valueOf(bfb.dDN), bfb.qwn);
                            if (bfb.dDN == 0) {
                                LuckyMoneyDetailUI.this.zdU = ac.a(bfb);
                                LuckyMoneyDetailUI.b(LuckyMoneyDetailUI.this, LuckyMoneyDetailUI.this.zdU);
                            } else {
                                com.tencent.mm.ui.base.h.cD(LuckyMoneyDetailUI.this.getContext(), bfb.qwn);
                                LuckyMoneyDetailUI.this.finish();
                            }
                        } else {
                            com.tencent.mm.ui.base.h.cD(LuckyMoneyDetailUI.this.getContext(), aVar2.errMsg);
                            LuckyMoneyDetailUI.this.finish();
                        }
                    }
                    AppMethodBeat.o(258627);
                    return null;
                }
            }).a(luckyMoneyDetailUI);
            AppMethodBeat.o(163742);
        } else if (luckyMoneyDetailUI.fs <= 0 || luckyMoneyDetailUI.yQe.size() <= 0 || luckyMoneyDetailUI.yQe.get(luckyMoneyDetailUI.yQe.size() - 1) == null) {
            luckyMoneyDetailUI.zcp = "";
            if (af.rQ(luckyMoneyDetailUI.zbZ)) {
                aoVar = new ap(luckyMoneyDetailUI.yUc, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.yUq, "v1.0", luckyMoneyDetailUI.zcp);
            } else if (luckyMoneyDetailUI.gwE == 3) {
                aoVar = new com.tencent.mm.plugin.luckymoney.model.a.d(luckyMoneyDetailUI.yUc, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.yUq, "v1.0", luckyMoneyDetailUI.zcp, luckyMoneyDetailUI.UXO, luckyMoneyDetailUI.UXP, luckyMoneyDetailUI.UXQ);
            } else {
                aoVar = new ao(luckyMoneyDetailUI.yUc, 11, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.yUq, "v1.0", luckyMoneyDetailUI.zcp);
            }
            luckyMoneyDetailUI.doSceneProgress(aoVar, false);
            AppMethodBeat.o(163742);
        } else {
            if (af.rQ(luckyMoneyDetailUI.zbZ)) {
                aoVar2 = new ap(luckyMoneyDetailUI.yUc, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.yUq, Util.getLong(luckyMoneyDetailUI.yQe.get(luckyMoneyDetailUI.yQe.size() - 1).yWp, 0), "v1.0", luckyMoneyDetailUI.zcp);
            } else if (luckyMoneyDetailUI.gwE == 3) {
                aoVar2 = new com.tencent.mm.plugin.luckymoney.model.a.d(luckyMoneyDetailUI.yUc, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.yUq, Util.getLong(luckyMoneyDetailUI.yQe.get(luckyMoneyDetailUI.yQe.size() - 1).yWp, 0), "v1.0", luckyMoneyDetailUI.zcp, luckyMoneyDetailUI.UXO, luckyMoneyDetailUI.UXP, luckyMoneyDetailUI.UXQ);
            } else {
                aoVar2 = new ao(luckyMoneyDetailUI.yUc, luckyMoneyDetailUI.fs, luckyMoneyDetailUI.yUq, Util.getLong(luckyMoneyDetailUI.yQe.get(luckyMoneyDetailUI.yQe.size() - 1).yWp, 0), "v1.0", luckyMoneyDetailUI.zcp);
            }
            luckyMoneyDetailUI.doSceneProgress(aoVar2, false);
            AppMethodBeat.o(163742);
        }
    }

    static /* synthetic */ Bitmap a(LuckyMoneyDetailUI luckyMoneyDetailUI, int i2) {
        AppMethodBeat.i(163743);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(luckyMoneyDetailUI.getResources(), i2), 28, 28, false);
        AppMethodBeat.o(163743);
        return createScaledBitmap;
    }

    static /* synthetic */ void bI(String str, String str2, String str3) {
        AppMethodBeat.i(258644);
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(str2 == null);
        objArr[2] = str3;
        Log.i("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() toUser:%s customTex:%s emojiMd5:%s", objArr);
        if (!TextUtils.isEmpty(str3)) {
            tw twVar = new tw();
            twVar.eaq.dkV = str;
            twVar.eaq.content = str3;
            twVar.eaq.type = ab.JG(str);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
            if (!TextUtils.isEmpty(str2)) {
                tw twVar2 = new tw();
                twVar2.eaq.dkV = str;
                twVar2.eaq.content = str2;
                twVar2.eaq.type = ab.JG(str);
                twVar2.eaq.flags = 0;
                EventCenter.instance.publish(twVar2);
            }
            AppMethodBeat.o(258644);
            return;
        }
        Log.e("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() failed!");
        AppMethodBeat.o(258644);
    }

    static /* synthetic */ void a(LuckyMoneyDetailUI luckyMoneyDetailUI, String str, String str2, String str3) {
        AppMethodBeat.i(258646);
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(str2 == null);
        objArr[2] = str3;
        Log.i("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() toUser:%s customTex:%s emojiMd5:%s", objArr);
        if (((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(luckyMoneyDetailUI, str, str3)) {
            Log.i("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() success!");
            if (!TextUtils.isEmpty(str2)) {
                tw twVar = new tw();
                twVar.eaq.dkV = str;
                twVar.eaq.content = str2;
                twVar.eaq.type = ab.JG(str);
                twVar.eaq.flags = 0;
                EventCenter.instance.publish(twVar);
                AppMethodBeat.o(258646);
                return;
            }
        } else {
            Log.e("MicroMsg.LuckyMoneyDetailUI", "doTransmitEmojiToFriend() failed!");
        }
        AppMethodBeat.o(258646);
    }

    static /* synthetic */ void E(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(258650);
        luckyMoneyDetailUI.byj("");
        AppMethodBeat.o(258650);
    }

    static /* synthetic */ void G(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        int i2;
        AppMethodBeat.i(258651);
        luckyMoneyDetailUI.zdC = 2;
        luckyMoneyDetailUI.zdA = new hd();
        luckyMoneyDetailUI.zdA.eEH = 3;
        luckyMoneyDetailUI.zdA.bfK();
        luckyMoneyDetailUI.zdk.show();
        if (!Util.isEqual(luckyMoneyDetailUI.zdy.yVJ, 0)) {
            i2 = ChatFooterPanel.KbM;
        } else {
            i2 = ChatFooterPanel.KbJ;
        }
        com.tencent.mm.plugin.luckymoney.ui.a.b.a(luckyMoneyDetailUI.zdx, luckyMoneyDetailUI.zdv, i2, new ac.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass7 */

            @Override // com.tencent.mm.api.ac.a
            public final void a(r rVar) {
                AppMethodBeat.i(258617);
                Log.i("MicroMsg.LuckyMoneyDetailUI", "[onSelectedEmoji] emojiInfo:%s", rVar);
                LuckyMoneyDetailUI.this.UXR = 2;
                LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2, rVar.getMd5());
                LuckyMoneyDetailUI.E(LuckyMoneyDetailUI.this);
                LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(258617);
            }

            @Override // com.tencent.mm.api.ac.a
            public final void onHide() {
                AppMethodBeat.i(258618);
                LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this);
                AppMethodBeat.o(258618);
            }
        });
        luckyMoneyDetailUI.zdv.setOnTextOperationListener(new ChatFooterPanel.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass8 */

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHD() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void eP(boolean z) {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void aHC() {
            }

            @Override // com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a
            public final void append(String str) {
                AppMethodBeat.i(258619);
                try {
                    Log.i("MicroMsg.LuckyMoneyDetailUI", "[onSelectedNormalEmoji] emojiInfo:%s", str);
                    LuckyMoneyDetailUI.this.UXR = 1;
                    LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, 2, str);
                    LuckyMoneyDetailUI.a(LuckyMoneyDetailUI.this, str);
                    LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this);
                    AppMethodBeat.o(258619);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.LuckyMoneyDetailUI", e2, "", new Object[0]);
                    AppMethodBeat.o(258619);
                }
            }
        });
        AppMethodBeat.o(258651);
    }

    static /* synthetic */ void T(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        AppMethodBeat.i(258656);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            int i2 = displayMetrics.widthPixels;
            double d2 = ((double) i2) / 750.0d;
            int i3 = (int) (240.0d * d2);
            Log.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", Integer.valueOf(i2), Double.valueOf(d2), Integer.valueOf(i3));
            luckyMoneyDetailUI.zdb.setLayoutParams(new LinearLayout.LayoutParams(luckyMoneyDetailUI.zdb.getLayoutParams().width, i3));
        }
        AppMethodBeat.o(258656);
    }

    static /* synthetic */ void V(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        boolean z;
        int indexOf;
        AppMethodBeat.i(258657);
        if (luckyMoneyDetailUI.zdU == null || luckyMoneyDetailUI.zdU.yVE == null) {
            AppMethodBeat.o(258657);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(luckyMoneyDetailUI.getContext()).inflate(R.layout.b3x, (ViewGroup) null);
        TextView textView = (TextView) viewGroup.findViewById(R.id.f1b);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.f1a);
        textView.setText(luckyMoneyDetailUI.zdU.yVE.title);
        com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) luckyMoneyDetailUI.getContext(), 16);
        Iterator<com.tencent.mm.plugin.luckymoney.model.g> it = luckyMoneyDetailUI.zdU.yVE.yUI.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            final com.tencent.mm.plugin.luckymoney.model.g next = it.next();
            if (!Util.isNullOrNil(next.title)) {
                TextView textView2 = new TextView(luckyMoneyDetailUI.getContext());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(next.title);
                if (!Util.isNullOrNil(next.desc) && (indexOf = next.title.indexOf(next.desc)) > 0) {
                    spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(new q.a() {
                        /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass13 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                        public final void dF(View view) {
                            AppMethodBeat.i(258624);
                            com.tencent.mm.wallet_core.ui.f.bn(LuckyMoneyDetailUI.this.getContext(), next.yUB);
                            AppMethodBeat.o(258624);
                        }
                    }), indexOf, next.desc.length() + indexOf, 18);
                    textView2.setClickable(true);
                    textView2.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(luckyMoneyDetailUI.getContext()));
                }
                textView2.setText(spannableStringBuilder);
                textView2.setTextSize(1, 14.0f);
                textView2.setTextColor(luckyMoneyDetailUI.getResources().getColor(R.color.u_));
                if (!z2) {
                    linearLayout.addView(textView2, marginLayoutParams);
                } else {
                    linearLayout.addView(textView2);
                }
                if (z2) {
                    z = false;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(luckyMoneyDetailUI.getContext(), 2, 0);
        gVar.T(luckyMoneyDetailUI.getResources().getString(R.string.w0));
        gVar.ape(1);
        gVar.QOT = new g.a() {
            /* class com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(258625);
                gVar.bMo();
                AppMethodBeat.o(258625);
            }
        };
        gVar.setCustomView(viewGroup);
        gVar.dGm();
        AppMethodBeat.o(258657);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI r10, com.tencent.mm.plugin.luckymoney.model.q r11) {
        /*
        // Method dump skipped, instructions count: 510
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.c(com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI, com.tencent.mm.plugin.luckymoney.model.q):void");
    }

    static /* synthetic */ void a(LuckyMoneyDetailUI luckyMoneyDetailUI, dhn dhn, Dialog dialog, String str) {
        boolean z = true;
        AppMethodBeat.i(258659);
        Log.i("MicroMsg.LuckyMoneyDetailUI", "goWalletLqtSaveFetchUI()");
        if (dialog != null) {
            dialog.dismiss();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (dhn.MLV != null && dhn.MLV.size() > 0) {
            Iterator<ahq> it = dhn.MLV.iterator();
            while (it.hasNext()) {
                ahq next = it.next();
                if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                    arrayList.add(String.format("%s||%s", next.title, next.yUB));
                }
            }
        }
        Intent intent = new Intent(luckyMoneyDetailUI, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fund_code", dhn.Mnl);
        intent.putExtra("lqt_account_type", dhn.yba);
        intent.putExtra("lqt_fund_spid", dhn.Mnk);
        intent.putExtra("lqt_save_fetch_mode", 1);
        intent.putExtra("lqt_is_show_protocol", dhn.egj == 1);
        if (dhn.MLU != 1) {
            z = false;
        }
        intent.putExtra("lqt_is_agree_protocol", z);
        intent.putExtra("operate_id", str);
        intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
        intent.putExtra("lqt_profile_wording", dhn.MLJ);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyDetailUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI", "goWalletLqtSaveFetchUI", "(Lcom/tencent/mm/protocal/protobuf/QryUsrFundDetailRes;Landroid/app/Dialog;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        luckyMoneyDetailUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI", "goWalletLqtSaveFetchUI", "(Lcom/tencent/mm/protocal/protobuf/QryUsrFundDetailRes;Landroid/app/Dialog;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(258659);
    }
}
