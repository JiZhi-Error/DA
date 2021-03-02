package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.protobuf.GetEmotionRewardResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(109263);
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (Util.isNullOrNil(str) || !s.YS(str)) {
                        Log.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                        break;
                    } else {
                        EmojiStoreV2RewardThanksUI.this.rlf.setImageFilePath(str);
                        EmojiStoreV2RewardThanksUI.this.rlf.setScaleType(ImageView.ScaleType.FIT_XY);
                        if (EmojiStoreV2RewardThanksUI.this.rlk != null && EmojiStoreV2RewardThanksUI.this.rlk.isRunning()) {
                            EmojiStoreV2RewardThanksUI.this.rlk.stop();
                            AppMethodBeat.o(109263);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(109263);
        }
    };
    private String rcq;
    private GetEmotionRewardResponse rhu;
    private EmojiStoreV2RewardBannerView rlf;
    private View rlg;
    private MMCopiableTextView rlh;
    private TextView rli;
    private TextView rlj;
    private AnimationDrawable rlk;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2RewardThanksUI() {
        AppMethodBeat.i(109266);
        AppMethodBeat.o(109266);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a3b;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109267);
        super.onCreate(bundle);
        this.rcq = getIntent().getStringExtra("extra_id");
        initView();
        this.rhu = k.getEmojiStorageMgr().OpS.blu(this.rcq);
        if (this.rhu == null) {
            this.rlf.setBackgroundDrawable(getResources().getDrawable(R.drawable.t_));
            this.rlf.setImageDrawable(this.rlk);
            this.rlf.setScaleType(ImageView.ScaleType.CENTER);
            this.rlk.start();
        } else if (this.rhu.Reward == null || Util.isNullOrNil(this.rhu.Reward.LsL)) {
            this.rlf.setBackgroundDrawable(getResources().getDrawable(R.drawable.t_));
            this.rlf.setImageDrawable(this.rlk);
            this.rlf.setScaleType(ImageView.ScaleType.CENTER);
            this.rlk.start();
        } else {
            final String str = this.rhu.Reward.LsM;
            a aVar = a.hdT;
            final String j2 = EmojiLogic.j(a.awt(), this.rcq, str);
            if (s.YS(j2)) {
                this.rlf.setImageFilePath(j2);
                this.rlf.setScaleType(ImageView.ScaleType.FIT_XY);
                if (this.rlk != null && this.rlk.isRunning()) {
                    this.rlk.stop();
                }
            } else {
                q.bcV().a(str, this.rlf, e.k(this.rcq, str, new Object[0]), new com.tencent.mm.av.a.c.k() {
                    /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.AnonymousClass3 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(109265);
                        if (!Util.isNullOrNil(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = j2;
                            EmojiStoreV2RewardThanksUI.this.mHandler.sendMessage(message);
                        }
                        AppMethodBeat.o(109265);
                    }
                });
                this.rlf.setBackgroundDrawable(getResources().getDrawable(R.drawable.t_));
                this.rlf.setImageDrawable(this.rlk);
                this.rlf.setScaleType(ImageView.ScaleType.CENTER);
                this.rlk.start();
            }
        }
        if (this.rhu == null || this.rhu.Reward == null) {
            this.rlg.setVisibility(8);
            AppMethodBeat.o(109267);
            return;
        }
        this.rlg.setVisibility(0);
        Util.isNullOrNil(this.rhu.Reward.LsO);
        this.rlh.setVisibility(0);
        this.rlh.setText(R.string.bvk);
        this.rli.setVisibility(8);
        this.rlj.setVisibility(8);
        AppMethodBeat.o(109267);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109268);
        if (this.rlk != null && this.rlk.isRunning()) {
            this.rlk.stop();
        }
        super.onDestroy();
        AppMethodBeat.o(109268);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109269);
        setMMTitle(R.string.bvj);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardThanksUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109264);
                EmojiStoreV2RewardThanksUI.this.finish();
                AppMethodBeat.o(109264);
                return false;
            }
        });
        this.rlf = (EmojiStoreV2RewardBannerView) findViewById(R.id.ila);
        this.rlf.setScale(1.0f);
        this.rlg = findViewById(R.id.f5s);
        this.rlh = (MMCopiableTextView) findViewById(R.id.f5u);
        this.rli = (TextView) findViewById(R.id.f5r);
        this.rlj = (TextView) findViewById(R.id.f5t);
        this.rlk = (AnimationDrawable) getResources().getDrawable(R.drawable.emoji_doge_loading);
        AppMethodBeat.o(109269);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
