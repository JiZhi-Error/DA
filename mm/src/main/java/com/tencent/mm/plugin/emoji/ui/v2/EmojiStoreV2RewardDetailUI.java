package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.af.h;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.protobuf.EmotionDonor;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI extends MMActivity implements AbsListView.OnScrollListener, i {
    private View agA;
    private MMHandler czp = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109244);
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2RewardDetailUI.this.rkW != null) {
                        EmojiStoreV2RewardDetailUI.this.rkW.setVisibility(8);
                        AppMethodBeat.o(109244);
                        return;
                    }
                    break;
                case 1002:
                    if (EmojiStoreV2RewardDetailUI.this.rkW != null) {
                        EmojiStoreV2RewardDetailUI.this.rkW.setVisibility(0);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(109244);
        }
    };
    private boolean isLoading = false;
    private ListView mListView;
    private String rcE;
    private String rcq;
    private int ree = -1;
    private GetEmotionRewardResponse rhu;
    private String rkP;
    private String rkQ;
    private ImageView rkR;
    private TextView rkS;
    private TextView rkT;
    private TextView rkU;
    private View rkV;
    private View rkW;
    private a rkX;
    private bmu rkY;
    private byte[] rkZ;
    private n rla;
    private MMLoadScrollView.a rlb = new MMLoadScrollView.a() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI.AnonymousClass2 */

        @Override // com.tencent.mm.ui.widget.MMLoadScrollView.a
        public final void cIe() {
            AppMethodBeat.i(109245);
            Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
            EmojiStoreV2RewardDetailUI.b(EmojiStoreV2RewardDetailUI.this);
            AppMethodBeat.o(109245);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RewardDetailUI() {
        AppMethodBeat.i(109253);
        AppMethodBeat.o(109253);
    }

    static /* synthetic */ void b(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
        AppMethodBeat.i(109262);
        emojiStoreV2RewardDetailUI.lA(true);
        AppMethodBeat.o(109262);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a38;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109254);
        super.onCreate(bundle);
        this.rcq = getIntent().getStringExtra("extra_id");
        this.rcE = getIntent().getStringExtra("extra_name");
        this.rkP = getIntent().getStringExtra("extra_iconurl");
        this.rkQ = getIntent().getStringExtra("name");
        initView();
        this.rhu = k.getEmojiStorageMgr().OpS.blu(this.rcq);
        cId();
        q.bcV().a(this.rkP, this.rkR, e.fQ(this.rcq, this.rkP));
        this.rkS.setText(this.rcE);
        this.rkT.setText(this.rkQ);
        if (this.rkY != null) {
            this.rkX.Z(this.rkY.Donors);
            this.rkX.rle = true;
        }
        if (this.rhu != null) {
            this.rkU.setText(getString(R.string.bv7, new Object[]{Integer.valueOf(this.rhu.DonorNum)}));
        }
        g.aAg().hqi.a(h.CTRL_INDEX, this);
        AppMethodBeat.o(109254);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109255);
        super.onPause();
        AppMethodBeat.o(109255);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109256);
        super.onDestroy();
        g.aAg().hqi.b(h.CTRL_INDEX, this);
        q.bcV().onScrollStateChanged(0);
        AppMethodBeat.o(109256);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109257);
        setMMTitle(R.string.bv6);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109246);
                EmojiStoreV2RewardDetailUI.this.finish();
                AppMethodBeat.o(109246);
                return false;
            }
        });
        this.agA = aa.jQ(getContext()).inflate(R.layout.a39, (ViewGroup) null);
        this.rkR = (ImageView) this.agA.findViewById(R.id.bnk);
        this.rkS = (TextView) this.agA.findViewById(R.id.gi7);
        this.rkT = (TextView) this.agA.findViewById(R.id.bnl);
        this.rkU = (TextView) this.agA.findViewById(R.id.h65);
        this.rkV = findViewById(R.id.h8v);
        this.mListView = (ListView) findViewById(R.id.doc);
        this.rkW = aa.jQ(getContext()).inflate(R.layout.a2q, (ViewGroup) null);
        this.rkW.setVisibility(8);
        this.mListView.addHeaderView(this.agA);
        this.mListView.addFooterView(this.rkW);
        this.rkX = new a(this);
        this.mListView.setAdapter((ListAdapter) this.rkX);
        this.mListView.setOnScrollListener(this);
        AppMethodBeat.o(109257);
    }

    private void cId() {
        AppMethodBeat.i(109258);
        this.rla = new n(this.rcq, this.rkZ);
        g.aAg().hqi.a(this.rla, 0);
        AppMethodBeat.o(109258);
    }

    private void lA(boolean z) {
        AppMethodBeat.i(109259);
        if (!this.isLoading && this.ree != 0) {
            cId();
            this.isLoading = true;
            if (z) {
                this.czp.sendEmptyMessageDelayed(1002, 200);
            }
        }
        AppMethodBeat.o(109259);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(109261);
        if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            if (this.ree == 0 || this.isLoading) {
                Log.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
                AppMethodBeat.o(109261);
                return;
            }
            lA(true);
            Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
            q.bcV().onScrollStateChanged(i2);
        }
        AppMethodBeat.o(109261);
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private Bitmap dku = null;
        private Context mContext;
        private int mNumColumns = 1;
        int omS;
        private int qXG;
        int rjH;
        private LinkedList<EmotionDonor> rld;
        boolean rle = false;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(109252);
            EmotionDonor Gb = Gb(i2);
            AppMethodBeat.o(109252);
            return Gb;
        }

        public a(Context context) {
            AppMethodBeat.i(109247);
            this.mContext = context;
            this.rjH = com.tencent.mm.cb.a.aG(EmojiStoreV2RewardDetailUI.this.getContext(), R.dimen.a25);
            int jn = com.tencent.mm.cb.a.jn(EmojiStoreV2RewardDetailUI.this.getContext()) - (com.tencent.mm.cb.a.aG(EmojiStoreV2RewardDetailUI.this.getContext(), R.dimen.hs) * 2);
            int i2 = this.rjH;
            int aG = com.tencent.mm.cb.a.aG(EmojiStoreV2RewardDetailUI.this.getContext(), R.dimen.i2);
            int i3 = jn / (i2 + aG);
            this.mNumColumns = (jn - (i3 * i2)) - (aG * (i3 + -1)) > i2 ? i3 + 1 : i3;
            this.qXG = com.tencent.mm.cb.a.jn(this.mContext);
            this.omS = (int) (((float) (this.qXG - (this.mNumColumns * this.rjH))) / (((float) this.mNumColumns) + 1.0f));
            try {
                this.dku = BackwardSupportUtil.BitmapFactory.decodeStream(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
                AppMethodBeat.o(109247);
            } catch (IOException e2) {
                Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", Util.getStack());
                AppMethodBeat.o(109247);
            }
        }

        public final void Z(LinkedList<EmotionDonor> linkedList) {
            AppMethodBeat.i(109248);
            if (this.rld == null) {
                this.rld = new LinkedList<>();
            }
            if (this.rle) {
                this.rld.clear();
                this.rle = false;
            }
            this.rld.addAll(linkedList);
            notifyDataSetChanged();
            AppMethodBeat.o(109248);
        }

        public final int getCount() {
            AppMethodBeat.i(109249);
            int size = this.rld == null ? 0 : this.rld.size();
            if (size > 0) {
                int ceil = (int) Math.ceil((double) (((float) size) / ((float) this.mNumColumns)));
                AppMethodBeat.o(109249);
                return ceil;
            }
            AppMethodBeat.o(109249);
            return size;
        }

        private EmotionDonor Gb(int i2) {
            int size;
            AppMethodBeat.i(109250);
            if (this.rld != null) {
                if (this.rld == null) {
                    size = 0;
                } else {
                    size = this.rld.size();
                }
                if (i2 < size) {
                    EmotionDonor emotionDonor = this.rld.get(i2);
                    AppMethodBeat.o(109250);
                    return emotionDonor;
                }
            }
            AppMethodBeat.o(109250);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0062 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r12v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r12v2, types: [android.widget.LinearLayout, android.view.View] */
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(109251);
            if (view == 0 || view.getTag() == null) {
                view = new LinearLayout(this.mContext);
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
                view.setBackgroundResource(R.drawable.b0w);
                view.setOrientation(0);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, this.omS);
                bVar = new b();
                bVar.qXM = view;
                view.setTag(bVar);
                for (int i3 = 0; i3 < this.mNumColumns; i3++) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.rjH, this.rjH);
                    layoutParams2.leftMargin = this.omS;
                    bVar.qXM.addView(new SquareImageView(this.mContext), i3, layoutParams2);
                }
            } else {
                bVar = (b) view.getTag();
            }
            for (int i4 = 0; i4 < this.mNumColumns; i4++) {
                int i5 = (this.mNumColumns * i2) + i4;
                SquareImageView squareImageView = (SquareImageView) bVar.qXM.getChildAt(i4);
                EmotionDonor Gb = Gb(i5);
                if (Gb != null) {
                    squareImageView.setVisibility(0);
                    if (!Util.isNullOrNil(Gb.HeadUrl)) {
                        q.bcV().a(Gb.HeadUrl, squareImageView, e.K(EmojiStoreV2RewardDetailUI.this.rcq, Gb.HeadUrl, this.rjH));
                    } else {
                        squareImageView.setImageBitmap(this.dku);
                    }
                } else {
                    squareImageView.setVisibility(8);
                }
            }
            AppMethodBeat.o(109251);
            return view;
        }
    }

    class b {
        LinearLayout qXM;

        b() {
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z = true;
        AppMethodBeat.i(109260);
        this.isLoading = false;
        if (this.rkW != null) {
            this.rkW.setVisibility(8);
            this.czp.removeMessages(1002);
            this.czp.sendEmptyMessageDelayed(1001, 200);
        }
        switch (qVar.getType()) {
            case h.CTRL_INDEX:
                n nVar = (n) qVar;
                if (i2 != 0 && i2 != 4) {
                    Log.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", Integer.valueOf(i2));
                    break;
                } else {
                    this.rkZ = nVar.rcY;
                    if (i3 == 0) {
                        this.ree = 0;
                        if (nVar.cGw() != null) {
                            this.rkX.Z(nVar.cGw().Donors);
                            AppMethodBeat.o(109260);
                            return;
                        }
                    } else if (i3 == 2) {
                        this.ree = 2;
                        if (nVar.cGw() != null) {
                            this.rkX.Z(nVar.cGw().Donors);
                        }
                        if (!(this.rkX == null || this.agA == null)) {
                            a aVar = this.rkX;
                            int i4 = aVar.omS + aVar.rjH;
                            int height = this.agA.getHeight();
                            int jo = com.tencent.mm.cb.a.jo(this);
                            Log.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", Integer.valueOf(i4), Integer.valueOf(height), Integer.valueOf(jo));
                            if (jo > (i4 * this.rkX.getCount()) + height) {
                                z = false;
                            }
                        }
                        if (!z) {
                            lA(false);
                            AppMethodBeat.o(109260);
                            return;
                        }
                    } else if (i3 == 3) {
                        this.ree = 1;
                        this.rkZ = null;
                        this.rkX.rle = true;
                        lA(false);
                        AppMethodBeat.o(109260);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(109260);
    }
}
