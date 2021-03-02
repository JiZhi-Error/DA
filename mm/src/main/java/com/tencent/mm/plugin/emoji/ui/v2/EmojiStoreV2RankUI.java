package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Bundle;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;

public class EmojiStoreV2RankUI extends BaseEmojiStoreUI {
    protected as rbN = new as();
    private boolean rkN = true;

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RankUI() {
        AppMethodBeat.i(109236);
        AppMethodBeat.o(109236);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109237);
        super.onCreate(bundle);
        h.INSTANCE.a(12740, 4, "", "", "", 5, 5);
        this.rbN.eql = 3;
        this.rew.rbN = this.rbN;
        long currentTimeMillis = System.currentTimeMillis();
        deu deu = new deu();
        deu.MJN = currentTimeMillis;
        this.rbN.eqk = currentTimeMillis;
        Log.i("MicroMsg.EmojiStoreV2RankUI", "initeData: %s", Long.valueOf(deu.MJN));
        try {
            this.reh = deu.toByteArray();
            AppMethodBeat.o(109237);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.EmojiStoreV2RankUI", e2, "", new Object[0]);
            AppMethodBeat.o(109237);
        }
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109238);
        super.initView();
        setMMTitle(R.string.buq);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI.AnonymousClass1 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(109234);
                if (i2 == 0) {
                    EmojiStoreV2RankUI.a(EmojiStoreV2RankUI.this);
                }
                AppMethodBeat.o(109234);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        AppMethodBeat.o(109238);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(int i2, int i3, String str, o oVar) {
        AppMethodBeat.i(109239);
        super.a(i2, i3, str, oVar);
        if (this.rkN) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RankUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(109235);
                    EmojiStoreV2RankUI.a(EmojiStoreV2RankUI.this);
                    AppMethodBeat.o(109235);
                }
            }, 300);
            this.rkN = false;
        }
        AppMethodBeat.o(109239);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(f fVar, int i2) {
        AppMethodBeat.i(109240);
        if (fVar == null) {
            Log.i("MicroMsg.EmojiStoreV2RankUI", "item is null.");
            AppMethodBeat.o(109240);
        } else if (fVar.qYk == f.a.cellset) {
            EmotionBannerSet emotionBannerSet = fVar.qYm;
            if (emotionBannerSet == null) {
                Log.i("MicroMsg.EmojiStoreV2RankUI", "banner set is null. do nothing");
                AppMethodBeat.o(109240);
                return;
            }
            k.a(getContext(), emotionBannerSet, false);
            AppMethodBeat.o(109240);
        } else {
            EmotionSummary emotionSummary = fVar.qYl;
            if (emotionSummary == null) {
                Log.i("MicroMsg.EmojiStoreV2RankUI", "summary is null. do nothing");
                AppMethodBeat.o(109240);
                return;
            }
            this.rbN.iz(String.valueOf(i2 + 1));
            this.rbN.ix(emotionSummary.ProductID);
            this.rbN.iy(emotionSummary.Introduce);
            this.rbN.eqm = 3;
            this.rbN.bfK();
            k.a(getContext(), emotionSummary, 5, fVar.mStatus, fVar.HH, getIntent().getStringExtra("to_talker_name"), 105, this.rbN);
            AppMethodBeat.o(109240);
        }
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final a cGJ() {
        AppMethodBeat.i(109241);
        com.tencent.mm.plugin.emoji.a.f fVar = new com.tencent.mm.plugin.emoji.a.f(getContext());
        AppMethodBeat.o(109241);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGQ() {
        return 10;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGH() {
        return 5;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGI() {
        return 105;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(EmojiStoreV2RankUI emojiStoreV2RankUI) {
        EmotionSummary emotionSummary;
        boolean z = true;
        AppMethodBeat.i(109242);
        try {
            int firstVisiblePosition = emojiStoreV2RankUI.mListView.getFirstVisiblePosition();
            int lastVisiblePosition = emojiStoreV2RankUI.mListView.getLastVisiblePosition();
            if (lastVisiblePosition - firstVisiblePosition <= 0) {
                AppMethodBeat.o(109242);
                return;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            while (firstVisiblePosition < lastVisiblePosition) {
                f FN = emojiStoreV2RankUI.rbD.getItem(firstVisiblePosition);
                if (!(FN == null || (emotionSummary = FN.qYl) == null)) {
                    if (!z) {
                        sb.append("#");
                        sb2.append("#");
                        sb3.append("#");
                    }
                    sb.append(emotionSummary.ProductID);
                    sb2.append(emotionSummary.Introduce);
                    sb3.append(firstVisiblePosition + 1);
                    z = false;
                }
                firstVisiblePosition++;
            }
            emojiStoreV2RankUI.rbN.eqm = 1;
            emojiStoreV2RankUI.rbN.ix(sb.toString());
            emojiStoreV2RankUI.rbN.iy(sb2.toString());
            emojiStoreV2RankUI.rbN.iz(sb3.toString());
            emojiStoreV2RankUI.rbN.bfK();
            AppMethodBeat.o(109242);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EmojiStoreV2RankUI", e2, "", new Object[0]);
            AppMethodBeat.o(109242);
        }
    }
}
