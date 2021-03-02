package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.c;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class EmojiMineUI extends BaseEmojiStoreUI implements View.OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private ViewGroup qgZ;
    private View rfJ;
    private TextView rfK;
    private ViewGroup rgu;
    private ViewGroup rgv;
    private ViewGroup rgw;
    private ViewGroup rgx;
    private TextView rgy;

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a2s;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(108936);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("10931", 0);
        h.INSTANCE.kvStat(10931, String.valueOf(intExtra));
        Log.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", Integer.valueOf(intExtra));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiMineUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108934);
                EmojiMineUI.this.finish();
                AppMethodBeat.o(108934);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.btn), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiMineUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(108935);
                ArrayList<EmojiGroupInfo> gES = k.getEmojiStorageMgr().OpO.gES();
                ArrayList arrayList = new ArrayList();
                Iterator<EmojiGroupInfo> it = gES.iterator();
                while (it.hasNext()) {
                    EmojiGroupInfo next = it.next();
                    if (next.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() <= 1) {
                    com.tencent.mm.ui.base.h.n(EmojiMineUI.this.getContext(), R.string.br_, R.string.zb);
                    AppMethodBeat.o(108935);
                } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                    EmojiMineUI.a(EmojiMineUI.this);
                    AppMethodBeat.o(108935);
                } else {
                    Intent intent = new Intent();
                    intent.setClass(EmojiMineUI.this, EmojiSortUI.class);
                    EmojiMineUI emojiMineUI = EmojiMineUI.this;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(emojiMineUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    emojiMineUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(emojiMineUI, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(108935);
                }
                return true;
            }
        });
        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_UPLODD_FINISH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            com.tencent.mm.plugin.emoji.c.a.lq(true);
        }
        h.INSTANCE.idkeyStat(406, 3, 1, false);
        h.INSTANCE.idkeyStat(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
        h.INSTANCE.a(12740, 4, "", "", "", 24, 24);
        AppMethodBeat.o(108936);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(108937);
        setMMTitle(R.string.gog);
        super.initView();
        this.rfJ = findViewById(R.id.ifp);
        this.rfK = (TextView) this.rfJ.findViewById(R.id.ifo);
        this.rfK.setText(R.string.bwe);
        if (k.cGg().rds.rdC) {
            k.cGg();
            if (BKGLoaderManager.cGF()) {
                this.rfJ.setVisibility(0);
                fC(TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC, 3000);
                this.mListView.setOnScrollListener(null);
                AppMethodBeat.o(108937);
            }
        }
        this.rfJ.setVisibility(8);
        this.mListView.setOnScrollListener(null);
        AppMethodBeat.o(108937);
    }

    public void onClick(View view) {
        AppMethodBeat.i(108938);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view == this.rgv) {
            FZ(0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108938);
        } else if (view == this.rgx) {
            Intent intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108938);
        } else if (view == this.rgw) {
            FZ(1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108938);
        } else {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108938);
        }
    }

    private boolean FZ(int i2) {
        AppMethodBeat.i(108939);
        Intent intent = new Intent();
        intent.setClass(this, EmojiCustomUI.class);
        intent.putExtra("key_emoji_panel_type", i2);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108939);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGN() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final com.tencent.mm.plugin.emoji.a.a.a cGJ() {
        AppMethodBeat.i(108940);
        c cVar = new c(getContext());
        AppMethodBeat.o(108940);
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGQ() {
        return 8;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int bp(byte[] bArr) {
        AppMethodBeat.i(108941);
        int bp = super.bp(bArr);
        AppMethodBeat.o(108941);
        return bp;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(108942);
        super.onItemClick(adapterView, view, i2 - 1, j2);
        AppMethodBeat.o(108942);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(108943);
        if (str != null && str.equals("event_update_group")) {
            cHg();
            fC(131074, 50);
        }
        AppMethodBeat.o(108943);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void i(String str, int i2, int i3, String str2) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGY() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void cGK() {
        AppMethodBeat.i(108944);
        this.qgZ = (ViewGroup) View.inflate(getContext(), R.layout.a1y, null);
        this.rgy = (TextView) this.qgZ.findViewById(R.id.ips);
        this.rgy.setText(R.string.goi);
        this.rgy.setVisibility(8);
        this.mListView.addHeaderView(this.qgZ, null, false);
        this.rgu = (ViewGroup) View.inflate(getContext(), R.layout.a1v, null);
        this.rgv = (ViewGroup) this.qgZ.findViewById(R.id.fen);
        this.rgw = (ViewGroup) this.qgZ.findViewById(R.id.c0f);
        this.rgx = (ViewGroup) this.rgu.findViewById(R.id.feo);
        ((TextView) this.rgv.findViewById(16908310)).setText(R.string.bs1);
        ((TextView) this.rgx.findViewById(16908310)).setText(R.string.bst);
        ((TextView) this.rgw.findViewById(R.id.c0h)).setText(R.string.brt);
        this.rgx.findViewById(R.id.be9).setBackgroundResource(R.drawable.qd);
        this.rgv.setOnClickListener(this);
        this.rgx.setOnClickListener(this);
        this.rgw.setOnClickListener(this);
        this.mListView.addFooterView(this.rgu, null, false);
        AppMethodBeat.o(108944);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGX() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGV() {
        boolean z = true;
        AppMethodBeat.i(108945);
        if (this.rbD != null) {
            this.rbD.notifyDataSetChanged();
            this.reA = true;
            this.GQ.setVisibility(8);
        } else {
            z = false;
        }
        cGZ();
        AppMethodBeat.o(108945);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void c(GetEmotionListResponse getEmotionListResponse) {
        AppMethodBeat.i(108946);
        super.c(getEmotionListResponse);
        AppMethodBeat.o(108946);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void a(boolean z, com.tencent.mm.plugin.emoji.model.g gVar, boolean z2, boolean z3) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final boolean cGM() {
        return false;
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI, com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity
    public final void k(Message message) {
        AppMethodBeat.i(108947);
        if (message.what == 8001 && this.rfJ != null) {
            this.rfJ.setVisibility(8);
        }
        super.k(message);
        AppMethodBeat.o(108947);
    }

    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final void cGZ() {
        AppMethodBeat.i(108948);
        if (this.qgZ != null) {
            if (this.rbD == null || this.rbD.isEmpty()) {
                this.rgy.setVisibility(8);
            } else {
                this.rgy.setVisibility(0);
                AppMethodBeat.o(108948);
                return;
            }
        }
        AppMethodBeat.o(108948);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGH() {
        return 24;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI
    public final int cGI() {
        return 7;
    }

    static /* synthetic */ void a(EmojiMineUI emojiMineUI) {
        AppMethodBeat.i(108949);
        com.tencent.mm.ui.base.h.a(emojiMineUI, emojiMineUI.getString(R.string.btt), "", emojiMineUI.getString(R.string.bts), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiMineUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(108949);
    }
}
