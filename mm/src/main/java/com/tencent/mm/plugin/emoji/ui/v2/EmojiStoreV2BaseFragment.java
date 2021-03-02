package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class EmojiStoreV2BaseFragment extends MMFragment implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, i, h.a, j.a, j.b, k.a, MStorage.IOnStorageChange, MMPullDownView.c, MMPullDownView.d, MMPullDownView.e {
    private View GQ;
    private MMHandler czp = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109135);
            EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
            switch (message.what) {
                case 131074:
                    if (emojiStoreV2BaseFragment.rbD != null) {
                        emojiStoreV2BaseFragment.rbD.notifyDataSetChanged();
                        AppMethodBeat.o(109135);
                        return;
                    }
                    break;
                case 131075:
                    if (emojiStoreV2BaseFragment.rbD == null || message.getData() == null) {
                        AppMethodBeat.o(109135);
                        return;
                    }
                    String string = message.getData().getString("product_id");
                    if (string != null) {
                        emojiStoreV2BaseFragment.rbD.dd(string, message.getData().getInt("progress"));
                        AppMethodBeat.o(109135);
                        return;
                    }
                    break;
                case 131076:
                    if (emojiStoreV2BaseFragment.rbD == null || message.getData() == null) {
                        AppMethodBeat.o(109135);
                        return;
                    }
                    String string2 = message.getData().getString("product_id");
                    if (string2 != null) {
                        emojiStoreV2BaseFragment.rbD.dc(string2, message.getData().getInt("status"));
                        AppMethodBeat.o(109135);
                        return;
                    }
                    break;
                case 131077:
                    if (emojiStoreV2BaseFragment.rdY != null) {
                        emojiStoreV2BaseFragment.rdY.cHN();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(109135);
        }
    };
    protected long iOB;
    private ProgressDialog jZH;
    private ActionBar mActionBar;
    private a mActionBarHelper;
    protected ListView mListView;
    private boolean mwr;
    com.tencent.mm.plugin.emoji.a.a.a rbD;
    protected as rbN = new as();
    EmojiStoreVpHeader rdY;
    private boolean reA = false;
    private LinkedList<EmotionBanner> reB = new LinkedList<>();
    private LinkedList<EmotionBannerSet> reC = new LinkedList<>();
    private MMPullDownView reb;
    private TextView rec;
    private int ree = -1;
    private View reg;
    private byte[] reh;
    private final int rel = 131074;
    private final int rem = 131075;
    private final int ren = 131076;
    private final String reo = "product_id";
    private final String rep = "progress";
    private final String rer = "status";
    private o res;
    private int reu;
    private g rev;
    private j rew;
    private IListener rey = new IListener<dp>() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass3 */

        {
            AppMethodBeat.i(161094);
            this.__eventId = dp.class.getName().hashCode();
            AppMethodBeat.o(161094);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dp dpVar) {
            c cVar;
            AppMethodBeat.i(109136);
            dp dpVar2 = dpVar;
            if (dpVar2 != null) {
                EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
                String str = dpVar2.dGC.productId;
                int i2 = dpVar2.dGC.status;
                int i3 = dpVar2.dGC.progress;
                String str2 = dpVar2.dGC.dGD;
                Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
                if (!(emojiStoreV2BaseFragment.rbD == null || (cVar = emojiStoreV2BaseFragment.rbD.qXZ) == null)) {
                    if (i2 == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i3);
                        obtain.what = 131075;
                        emojiStoreV2BaseFragment.l(obtain);
                    } else {
                        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", Integer.valueOf(i2));
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt("status", i2);
                        obtain2.what = 131076;
                        emojiStoreV2BaseFragment.l(obtain2);
                    }
                    f amb = cVar.amb(str);
                    if (amb != null) {
                        amb.qYo = str2;
                    }
                }
            }
            AppMethodBeat.o(109136);
            return false;
        }
    };
    private com.tencent.mm.plugin.emoji.f.h rez;
    private final int rjL = 131077;
    public EmojiStoreV2HotBarView rjM;
    private boolean rjN = false;
    private boolean rjO = false;
    private boolean rjP = false;
    private MenuItem.OnMenuItemClickListener rjQ = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass4 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(109137);
            EmojiStoreV2BaseFragment.this.thisActivity().finish();
            AppMethodBeat.o(109137);
            return false;
        }
    };

    public abstract com.tencent.mm.plugin.emoji.a.a.a cGJ();

    public abstract int cGQ();

    public abstract boolean cHZ();

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.mActionBar = ((AppCompatActivity) thisActivity()).getSupportActionBar();
        View inflate = aa.jQ(getContext()).inflate(R.layout.bc, (ViewGroup) null);
        this.mActionBarHelper = new a(inflate);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View findViewById = inflate.findViewById(R.id.h9_);
        if (findViewById != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.leftMargin = at.fromDPToPix(getContext(), 36);
            findViewById.setLayoutParams(marginLayoutParams);
        }
        this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.mActionBar.gt();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.gs();
        this.mActionBar.gu();
        this.mActionBar.setCustomView(inflate);
        this.mActionBar.show();
        a aVar = this.mActionBarHelper;
        aVar.jVO.setText(R.string.btv);
        if (com.tencent.mm.cb.a.jk(aVar.jVO.getContext())) {
            aVar.jVO.setTextSize(0, com.tencent.mm.cb.a.ji(aVar.jVO.getContext()) * ((float) com.tencent.mm.cb.a.aH(aVar.jVO.getContext(), R.dimen.f3058c)));
        }
        this.mActionBarHelper.setClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(109138);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!EmojiStoreV2BaseFragment.this.isScreenEnable()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(109138);
                    return;
                }
                if (EmojiStoreV2BaseFragment.this.rjQ != null) {
                    EmojiStoreV2BaseFragment.this.rjQ.onMenuItemClick(null);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109138);
            }
        });
        showOptionMenu(true);
        addIconOptionMenu(0, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109139);
                Intent intent = new Intent();
                intent.setClass(EmojiStoreV2BaseFragment.this.thisActivity(), EmojiMineUI.class);
                EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = EmojiStoreV2BaseFragment.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(emojiStoreV2BaseFragment, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                emojiStoreV2BaseFragment.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(emojiStoreV2BaseFragment, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(109139);
                return false;
            }
        });
        EventCenter.instance.addListener(this.rey);
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(this);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.rjP = true;
        this.rbD = cGJ();
        this.rbD.qYa = this;
        this.GQ = findViewById(R.id.c2g);
        this.rec = (TextView) this.GQ.findViewById(R.id.c2p);
        this.reg = getActivityLayoutInflater().inflate(R.layout.a2q, (ViewGroup) null);
        this.reg.setVisibility(8);
        this.rdY = new EmojiStoreVpHeader(getContext());
        this.mListView = (ListView) findViewById(16908298);
        this.mListView.addHeaderView(this.rdY);
        if (!cHZ()) {
            this.rjM = new EmojiStoreV2HotBarView(getContext());
            this.rjM.setDesignerEmojiViewVisibility(8);
            this.rjM.setDesignerCatalogViewPadding(false);
            this.mListView.addHeaderView(this.rjM);
        }
        this.mListView.addFooterView(this.reg);
        this.mListView.setAdapter((ListAdapter) this.rbD);
        if (cHZ()) {
            this.mListView.setOnItemClickListener(this);
        } else {
            ((h) this.rbD).qXI = this;
        }
        this.mListView.setOnScrollListener(this);
        this.mListView.setLongClickable(false);
        this.mListView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.rbD.qXY = this.mListView;
        this.reb = (MMPullDownView) findViewById(R.id.ep2);
        if (this.reb != null) {
            this.reb.setTopViewVisible(false);
            this.reb.setAtTopCallBack(this);
            this.reb.setOnBottomLoadDataListener(this);
            this.reb.setAtBottomCallBack(this);
            this.reb.setBottomViewVisible(false);
            this.reb.setIsBottomShowAll(false);
            this.reb.setIsReturnSuperDispatchWhenCancel(true);
        }
        if (this.rjN) {
            cHT();
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onStart() {
        super.onStart();
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        super.onResume();
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        com.tencent.mm.kernel.g.aAg().hqi.a(411, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(v2helper.EMethodSetNgStrength, this);
        if (this.rjN) {
            if (this.czp != null) {
                this.czp.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.rbD == null || this.rbD.qXZ == null)) {
                this.rbD.qXZ.cFq();
                this.rbD.refreshView();
            }
            if (((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(208900, Boolean.FALSE)).booleanValue()) {
                cGa();
                com.tencent.mm.kernel.g.aAh().azQ().set(208900, Boolean.FALSE);
            }
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void setUserVisibleHint(boolean z) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", Boolean.valueOf(z));
        super.setUserVisibleHint(z);
        this.rjN = z;
        if (!this.rjO && this.rjP) {
            cHT();
        } else if (z) {
            cHU();
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.aAg().hqi.b(411, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(v2helper.EMethodSetNgStrength, this);
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.rdY != null) {
            this.rdY.cHO();
        }
        if (this.czp != null) {
            this.czp.removeMessages(131077);
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onStop() {
        super.onStop();
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        super.onDestroy();
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.rbD != null) {
            this.rbD.clear();
            this.rbD = null;
        }
        if (this.rdY != null) {
            this.rdY.cHO();
            this.rdY.clear();
        }
        EventCenter.instance.removeListener(this.rey);
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(this);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onDetach() {
        super.onDetach();
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void cHT() {
        this.rjO = true;
        this.iOB = System.currentTimeMillis();
        deu deu = new deu();
        deu.MJN = this.iOB;
        this.rbN.eqk = this.iOB;
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "initeData: %s", Long.valueOf(deu.MJN));
        try {
            this.reh = deu.toByteArray();
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2BaseFragment", e2, "", new Object[0]);
        }
        cHV();
        this.reu = thisActivity().getIntent().getIntExtra("preceding_scence", 5);
        if (!cHW() || this.czp == null) {
            lw(true);
        } else {
            this.czp.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(109140);
                    EmojiStoreV2BaseFragment.this.lw(false);
                    AppMethodBeat.o(109140);
                }
            }, 3000);
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(109141);
                EmojiStoreV2BaseFragment.this.cHU();
                AppMethodBeat.o(109141);
            }
        }, 500);
    }

    /* access modifiers changed from: protected */
    public void cHU() {
    }

    private void cHV() {
        this.rew = new j();
        this.rew.owO = thisActivity();
        this.rew.rbF = this;
        this.rew.rbD = this.rbD;
        if (cHZ()) {
            this.rew.rbG = 1;
        } else {
            this.rew.rbG = 2;
        }
        this.rew.rbJ = this;
    }

    private boolean cHW() {
        int i2;
        int i3;
        int i4;
        GetEmotionListResponse akx = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.akx(cGQ());
        g a2 = o.a(akx);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(cGQ());
        objArr[1] = Integer.valueOf(akx == null ? 0 : akx.EmotionCount);
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache type: %d, size: %d ", objArr);
        if (a2 == null || a2.rbt.size() <= 0) {
            return false;
        }
        this.reA = true;
        this.GQ.setVisibility(8);
        this.reb.setVisibility(0);
        a(this.ree, a2);
        if (akx != null) {
            i4 = akx.CellSetList == null ? 0 : akx.CellSetList.size();
            i3 = akx.TopHotNum;
            i2 = akx.RecentHotNum;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", Integer.valueOf(i3), Integer.valueOf(cGQ()));
        if (this.rbD != null && cHZ()) {
            this.rbD.FK(i4 + i3);
            this.rbD.FL(i2);
        }
        cGP();
        return true;
    }

    public final void lw(boolean z) {
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", Boolean.valueOf(z), Boolean.valueOf(cHX()));
        if (!z) {
            cHX();
        }
        bq(this.reh);
        cGS();
    }

    private void bq(byte[] bArr) {
        int cGQ = cGQ();
        int i2 = this.reu;
        if (bArr != null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", bArr.toString());
            this.res = new o(cGQ, bArr, i2);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.res = new o(cGQ, i2);
    }

    private void cGS() {
        com.tencent.mm.kernel.g.aAg().hqi.a(this.res, 0);
    }

    private static boolean cHX() {
        ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_STORE_LAST_REFRESH_TIME_LONG, (Object) 0L)).longValue();
        return true;
    }

    private void a(int i2, g gVar) {
        boolean z;
        boolean z2;
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        switch (i2) {
            case -1:
                this.rev = gVar;
                z = true;
                z2 = true;
                break;
            case 0:
                this.rev = gVar;
                z = false;
                z2 = false;
                break;
            case 1:
                this.rev = gVar;
                z = false;
                z2 = true;
                break;
            case 2:
                if (this.rev == null) {
                    this.rev = new g();
                }
                this.rev.FX(gVar.rbs);
                this.rev.dg(gVar.rbt);
                z = false;
                z2 = true;
                break;
            default:
                z = false;
                z2 = false;
                break;
        }
        if (this.rev != null) {
            this.rev.cFZ();
        }
        K(z2, z);
    }

    private void cGP() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.rbD.qXZ, this);
    }

    private void K(boolean z, boolean z2) {
        if (this.rev != null && z) {
            if (z2) {
                cHY();
            }
            if (this.rbD != null) {
                this.rbD.b(this.rev);
            }
        }
    }

    private void cHY() {
        if (this.rev == null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
            return;
        }
        this.reB = (LinkedList) this.rev.rbv;
        this.reC = (LinkedList) this.rev.rbw;
        if (this.reB != null) {
            this.rdY.d(this.reB, this.reC);
        } else if (this.rev.rbu != null) {
            this.reB = new LinkedList<>();
            this.reB.add(this.rev.rbu);
            this.rdY.d(this.reB, this.reC);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        o oVar;
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        int type = qVar.getType();
        switch (type) {
            case 411:
                if ((qVar instanceof o) && (oVar = (o) qVar) != null && oVar.mType == cGQ()) {
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    if (!(oVar == null || oVar.cGx() == null)) {
                        if (this.rbD.cFm() <= 0 && cHZ()) {
                            if (oVar.cGx().CellSetList == null) {
                                i4 = 0;
                            } else {
                                i4 = oVar.cGx().CellSetList.size();
                            }
                            this.rbD.FM(i4);
                        }
                        i5 = oVar.cGx().TopHotNum;
                        i6 = oVar.cGx().RecentHotNum;
                    }
                    Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(type), Integer.valueOf(oVar.mType));
                    if (this.rbD != null && this.rbD.cFl() <= 0 && cHZ()) {
                        com.tencent.mm.plugin.emoji.a.a.a aVar = this.rbD;
                        aVar.FK(i5 + aVar.cFm());
                        this.rbD.FL(i6);
                    }
                    b(i2, i3, qVar);
                    if (cHZ()) {
                        if (!(oVar.cGx() == null || oVar.cGx().CellSetList == null || oVar.cGx().CellSetList.size() <= 0)) {
                            for (int i7 = 0; i7 < oVar.cGx().CellSetList.size(); i7++) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13223, 0, Integer.valueOf(oVar.cGx().CellSetList.get(i7).ID), oVar.cGx().CellSetList.get(i7).Title, 0);
                            }
                        }
                        if (oVar.cGx().RecentHotNum > 0 && oVar.cGx().EmotionList != null && oVar.cGx().EmotionList.size() > oVar.cGx().TopHotNum + oVar.cGx().RecentHotNum) {
                            for (int i8 = 0; i8 < oVar.cGx().RecentHotNum; i8++) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13223, 0, oVar.cGx().EmotionList.get(oVar.cGx().TopHotNum + i8).ProductID, oVar.cGx().EmotionList.get(oVar.cGx().TopHotNum + i8).PackName, 1);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                Log.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.e
    public final boolean cAj() {
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        lx(true);
        return true;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.d
    public final boolean cAk() {
        return false;
    }

    @Override // com.tencent.mm.ui.base.MMPullDownView.c
    public final boolean cAl() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3, q qVar) {
        boolean z;
        this.mwr = false;
        this.reg.setVisibility(8);
        if (i2 == 0 || i2 == 4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.GQ.setVisibility(8);
            this.reb.setVisibility(0);
            o oVar = (o) qVar;
            g a2 = o.a(oVar.cGx());
            this.reh = oVar.rcY;
            if (i3 == 0) {
                GetEmotionListResponse cGx = oVar.cGx();
                a(this.ree, a2);
                d(cGx);
                this.ree = 0;
            } else if (i3 == 2) {
                GetEmotionListResponse cGx2 = oVar.cGx();
                a(this.ree, a2);
                cGP();
                d(cGx2);
                this.ree = 2;
            } else if (i3 == 3) {
                a(this.ree, a2);
                this.ree = 1;
            } else {
                this.GQ.setVisibility(0);
                this.reb.setVisibility(8);
                this.rec.setText(R.string.buh);
            }
        } else if (!this.reA) {
            this.GQ.setVisibility(0);
            this.reb.setVisibility(8);
            this.rec.setText(R.string.bui);
        }
    }

    private void d(final GetEmotionListResponse getEmotionListResponse) {
        if (this.ree == -1) {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass10 */

                public final void run() {
                    int i2 = 0;
                    AppMethodBeat.i(109142);
                    if (getEmotionListResponse != null) {
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(getEmotionListResponse == null ? 0 : getEmotionListResponse.EmotionCount);
                        if (!(getEmotionListResponse == null || getEmotionListResponse.ReqBuf == null)) {
                            i2 = getEmotionListResponse.ReqBuf.computeSize();
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = Integer.valueOf(EmojiStoreV2BaseFragment.this.cGQ());
                        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d", objArr);
                        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a(EmojiStoreV2BaseFragment.this.cGQ(), getEmotionListResponse);
                    }
                    AppMethodBeat.o(109142);
                }
            });
        }
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.a
    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        boolean z;
        if (aVar.cFc() == 9) {
            amY(getString(R.string.zi));
        }
        this.rew.rbN = this.rbN;
        j jVar = this.rew;
        if (!cHZ() || !e.cFX().rbn) {
            z = false;
        } else {
            z = true;
        }
        jVar.rbO = z;
        if (!cHZ()) {
            this.rew.rbG = 2;
        } else if (aVar.mPosition >= 0 && aVar.mPosition < this.rbD.cFk()) {
            this.rew.rbG = 3;
        } else if (aVar.mPosition < this.rbD.cFk() || aVar.mPosition >= this.rbD.cFl() + this.rbD.cFk()) {
            this.rew.rbG = 1;
        } else {
            this.rew.rbG = 19;
        }
        this.rew.a(aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        int headerViewsCount = i2 - this.mListView.getHeaderViewsCount();
        if (headerViewsCount < 0 || headerViewsCount >= this.rbD.getCount()) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            return;
        }
        f FN = this.rbD.getItem(headerViewsCount);
        a(FN, headerViewsCount);
        if (cHZ() && this.rbD.cFl() > 0 && headerViewsCount >= this.rbD.cFk() && headerViewsCount < this.rbD.cFk() + this.rbD.cFl() && FN.qYl != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13223, 1, FN.qYl.ProductID, FN.qYl.PackName, 1, 0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2BaseFragment", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    }

    @Override // com.tencent.mm.plugin.emoji.a.h.a
    public final void FP(int i2) {
        if (i2 >= 0 && i2 < ((h) this.rbD).cFo()) {
            a(this.rbD.getItem(i2), i2);
        }
    }

    private void a(f fVar, int i2) {
        int i3 = 1;
        boolean z = false;
        if (fVar == null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.qYk == f.a.cellset) {
            EmotionBannerSet emotionBannerSet = fVar.qYm;
            if (emotionBannerSet == null) {
                Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                com.tencent.mm.plugin.emoji.e.k.a(getContext(), emotionBannerSet, false);
            }
        } else {
            EmotionSummary emotionSummary = fVar.qYl;
            if (emotionSummary == null) {
                Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            if (cHZ() && e.cFX().rbn) {
                z = true;
            }
            this.rbN.iz(String.valueOf(i2 + 1));
            this.rbN.ix(emotionSummary.ProductID);
            this.rbN.iy(z ? emotionSummary.ExptDesc : emotionSummary.Introduce);
            this.rbN.eqm = 3;
            this.rbN.bfK();
            if (!cHZ()) {
                i3 = 2;
            } else if (i2 >= 0 && i2 < this.rbD.cFk()) {
                i3 = 3;
            } else if (i2 >= this.rbD.cFk() && i2 < this.rbD.cFl() + this.rbD.cFk()) {
                i3 = 19;
            }
            com.tencent.mm.plugin.emoji.e.k.a(getContext(), emotionSummary, i3, fVar.mStatus, fVar.HH, thisActivity().getIntent().getStringExtra("to_talker_name"), 5, this.rbN);
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.ree == 0 || this.mwr) {
                Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
                return;
            } else {
                lx(true);
                Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
            }
        }
        if (i2 == 0) {
            cHU();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        super.onActivityResult(i2, i3, intent);
        if (this.rew != null) {
            this.rew.onActivityResult(i2, i3, intent);
        } else {
            Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    private void lx(boolean z) {
        if (this.mwr) {
            Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.mwr = true;
        if (z) {
            this.reg.setVisibility(0);
        }
        bq(this.reh);
        cGS();
        Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            amY(getString(R.string.a06));
        }
    }

    public final void l(Message message) {
        if (this.czp != null) {
            this.czp.sendMessage(message);
        }
    }

    private void amY(String str) {
        if (isFinishing()) {
            Log.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        FragmentActivity thisActivity = thisActivity();
        getString(R.string.zb);
        this.jZH = com.tencent.mm.ui.base.h.a((Context) thisActivity, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2BaseFragment.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    @Override // com.tencent.mm.pluginsdk.model.k.a
    public final void Y(ArrayList<com.tencent.mm.pluginsdk.model.q> arrayList) {
        Log.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.rbD != null) {
            if (this.czp != null) {
                this.czp.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a(arrayList, this.rbD.qXZ);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.czp != null) {
            this.czp.sendEmptyMessageDelayed(131074, 50);
        }
    }

    public final void cIa() {
        if (this.mListView != null && this.rbD != null && cHZ()) {
            this.rbD.refreshView();
        }
    }

    @Override // com.tencent.mm.ui.MMFragment
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.rdY != null) {
            this.rdY.requestLayout();
        }
        setRequestedOrientation(1);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void d(String str, String str2, String str3, String str4, String str5) {
        this.rez = new com.tencent.mm.plugin.emoji.f.h(str, str2, str3, null, str5);
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rez, 0);
    }

    @Override // com.tencent.mm.plugin.emoji.model.j.b
    public final void cGa() {
        this.reh = null;
        this.ree = -1;
        lx(false);
    }
}
