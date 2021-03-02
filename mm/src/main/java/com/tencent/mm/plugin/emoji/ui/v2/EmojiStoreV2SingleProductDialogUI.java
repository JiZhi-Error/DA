package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.a.d;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    private EmojiInfo gWm;
    public String goe;
    private d jzT;
    private ProgressBar krF;
    private int mScene;
    private long rbH;
    private View rlK;
    private EmojiStatusView rlL;
    private ImageView rlM;
    private Button rlN;
    private Button rlO;
    private int rlP;
    private int rlQ;
    private DialogInterface.OnClickListener rlR = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.AnonymousClass1 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(109305);
            EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this);
            if (EmojiStoreV2SingleProductDialogUI.this.gWm != null) {
                h.INSTANCE.a(12787, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.mScene), 2, EmojiStoreV2SingleProductDialogUI.this.gWm.field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.rbH), EmojiStoreV2SingleProductDialogUI.this.gWm.field_designerID, EmojiStoreV2SingleProductDialogUI.this.gWm.field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.rlQ));
            }
            AppMethodBeat.o(109305);
        }
    };
    private DialogInterface.OnClickListener rlS = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.AnonymousClass2 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(109306);
            EmojiStoreV2SingleProductDialogUI.f(EmojiStoreV2SingleProductDialogUI.this);
            if (EmojiStoreV2SingleProductDialogUI.this.gWm != null) {
                h.INSTANCE.a(12787, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.mScene), 1, EmojiStoreV2SingleProductDialogUI.this.gWm.field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.rbH), EmojiStoreV2SingleProductDialogUI.this.gWm.field_designerID, EmojiStoreV2SingleProductDialogUI.this.gWm.field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.rlQ));
            }
            AppMethodBeat.o(109306);
        }
    };
    private View.OnClickListener rlT = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(109307);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EmojiStoreV2SingleProductDialogUI.this.jzT.setOnDismissListener(null);
            EmojiStoreV2SingleProductDialogUI.this.jzT.dismiss();
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(R.anim.dd, R.anim.di);
            a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2SingleProductDialogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109307);
        }
    };

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2SingleProductDialogUI() {
        AppMethodBeat.i(109310);
        AppMethodBeat.o(109310);
    }

    static /* synthetic */ void j(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.i(109318);
        emojiStoreV2SingleProductDialogUI.cHR();
        AppMethodBeat.o(109318);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        d hbn;
        AppMethodBeat.i(109311);
        overridePendingTransition(-1, -1);
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
        }
        this.rlP = getIntent().getIntExtra("add_source", 5);
        this.rlQ = getIntent().getIntExtra("entrance_scene", 0);
        this.mScene = getIntent().getIntExtra("scene", 0);
        this.rbH = getIntent().getLongExtra("searchID", 0);
        this.goe = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                ait ait = new ait();
                ait.parseFrom(byteArrayExtra);
                this.gWm = k.getEmojiStorageMgr().OpN.blk(ait.Md5);
                if (this.gWm == null) {
                    this.gWm = new EmojiInfo();
                    this.gWm.field_catalog = 84;
                    this.gWm.field_reserved4 |= EmojiInfo.Vll;
                    com.tencent.mm.plugin.emoji.h.b.a(ait, this.gWm);
                }
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e2, "", new Object[0]);
                setResult(0);
                finish();
            }
        } else {
            String stringExtra = getIntent().getStringExtra("extra_object_json");
            ait ait2 = new ait();
            try {
                i iVar = new i(stringExtra);
                ait2.Md5 = iVar.optString("Md5");
                this.gWm = k.getEmojiStorageMgr().OpN.blk(ait2.Md5);
                if (this.gWm == null) {
                    this.gWm = new EmojiInfo();
                    this.gWm.field_catalog = 84;
                    this.gWm.field_reserved4 |= EmojiInfo.Vll;
                }
                ait2.Url = iVar.optString("PreviewUrl");
                ait2.ThumbUrl = iVar.optString("ThumbUrl");
                ait2.AesKey = iVar.optString("AesKey");
                ait2.ProductID = iVar.optString("ProductID");
                ait2.ExternUrl = iVar.optString("ExternUrl");
                ait2.ExternMd5 = iVar.optString("ExternMd5");
                ait2.ActivityID = iVar.optString("ActivityID");
                com.tencent.mm.plugin.emoji.h.b.a(ait2, this.gWm);
            } catch (Exception e3) {
                setResult(0);
                finish();
            }
        }
        if (this.gWm == null) {
            setResult(0);
            finish();
        }
        this.rlK = aa.jQ(this).inflate(R.layout.a3d, (ViewGroup) null);
        this.krF = (ProgressBar) this.rlK.findViewById(R.id.br0);
        this.rlL = (EmojiStatusView) this.rlK.findViewById(R.id.bqy);
        this.rlM = (ImageView) this.rlK.findViewById(R.id.bqr);
        this.rlM.setOnClickListener(this.rlT);
        View view = this.rlK;
        if (isFinishing()) {
            hbn = null;
        } else {
            d.a aVar = new d.a(this);
            aVar.bon("");
            aVar.hs(view);
            aVar.Dk(true);
            hbn = aVar.hbn();
            hbn.show();
            com.tencent.mm.ui.base.h.a(this, hbn);
        }
        this.jzT = hbn;
        this.jzT.a(getString(R.string.yq), false, this.rlR);
        this.jzT.b(getString(R.string.h9), false, this.rlS);
        this.jzT.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(109308);
                EmojiStoreV2SingleProductDialogUI.this.setResult(0);
                EmojiStoreV2SingleProductDialogUI.this.finish();
                AppMethodBeat.o(109308);
            }
        });
        this.rlN = this.jzT.getButton(-1);
        this.rlO = this.jzT.getButton(-2);
        this.rlL.setVisibility(8);
        this.krF.setVisibility(0);
        this.rlO.setText(R.string.btw);
        this.rlN.setText(R.string.yq);
        this.rlO.setEnabled(false);
        this.rlO.setTextColor(getResources().getColor(R.color.u0));
        this.rlN.setEnabled(false);
        this.rlN.setTextColor(getResources().getColor(R.color.u0));
        this.rlL.setStatusListener(new EmojiStatusView.b() {
            /* class com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.AnonymousClass5 */

            @Override // com.tencent.mm.emoji.view.EmojiStatusView.b
            public final void po(int i2) {
                AppMethodBeat.i(109309);
                if (i2 == 1) {
                    EmojiStoreV2SingleProductDialogUI.this.rlL.setVisibility(0);
                    EmojiStoreV2SingleProductDialogUI.this.krF.setVisibility(8);
                    EmojiStoreV2SingleProductDialogUI.j(EmojiStoreV2SingleProductDialogUI.this);
                    EmojiStoreV2SingleProductDialogUI.this.rlN.setEnabled(true);
                    EmojiStoreV2SingleProductDialogUI.this.rlN.setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(R.color.g7));
                }
                AppMethodBeat.o(109309);
            }
        });
        this.rlL.setEmojiInfo(this.gWm);
        AppMethodBeat.o(109311);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        EmojiInfo blk;
        AppMethodBeat.i(109312);
        super.onResume();
        if (!(this.gWm == null || (blk = k.getEmojiStorageMgr().OpN.blk(this.gWm.field_md5)) == null)) {
            this.gWm = blk;
        }
        cHR();
        this.jzT.show();
        AppMethodBeat.o(109312);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109313);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001 && i3 == -1) {
            this.jzT.setOnDismissListener(null);
            this.jzT.dismiss();
            setResult(-1);
            finish();
            overridePendingTransition(R.anim.dd, 0);
        }
        AppMethodBeat.o(109313);
    }

    private void cHR() {
        AppMethodBeat.i(109314);
        if (this.gWm != null && this.gWm.field_catalog == EmojiGroupInfo.VkP) {
            this.rlO.setEnabled(false);
            this.rlO.setText(R.string.h9);
            this.rlO.setTextColor(getResources().getColor(R.color.u0));
            AppMethodBeat.o(109314);
        } else if (this.gWm == null || !this.gWm.hYi()) {
            this.rlO.setEnabled(false);
            this.rlO.setText(R.string.btw);
            this.rlO.setTextColor(getResources().getColor(R.color.u0));
            AppMethodBeat.o(109314);
        } else {
            this.rlO.setEnabled(true);
            this.rlO.setText(R.string.btw);
            this.rlO.setTextColor(getResources().getColor(R.color.g7));
            AppMethodBeat.o(109314);
        }
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(109315);
        super.onDestroy();
        this.jzT.setOnDismissListener(null);
        if (this.jzT.isShowing()) {
            this.jzT.dismiss();
        }
        AppMethodBeat.o(109315);
    }

    static /* synthetic */ void a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.i(109316);
        if (k.getEmojiStorageMgr().OpN.blk(emojiStoreV2SingleProductDialogUI.gWm.field_md5) == null) {
            Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "sendEmoji: db info is null");
            emojiStoreV2SingleProductDialogUI.gWm.field_catalog = EmojiInfo.VkQ;
            k.getEmojiStorageMgr().OpN.J(emojiStoreV2SingleProductDialogUI.gWm);
        }
        Intent intent = new Intent(emojiStoreV2SingleProductDialogUI, EmojiSendDialogUI.class);
        intent.putExtra("emoji_info", emojiStoreV2SingleProductDialogUI.gWm);
        emojiStoreV2SingleProductDialogUI.startActivityForResult(intent, 1001);
        emojiStoreV2SingleProductDialogUI.jzT.hide();
        AppMethodBeat.o(109316);
    }

    static /* synthetic */ void f(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        AppMethodBeat.i(109317);
        if (emojiStoreV2SingleProductDialogUI.gWm != null) {
            if (k.getEmojiStorageMgr().OpN.blk(emojiStoreV2SingleProductDialogUI.gWm.field_md5) == null) {
                Log.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "doAddAction: db info is null");
                emojiStoreV2SingleProductDialogUI.gWm.field_catalog = EmojiInfo.VkQ;
                k.getEmojiStorageMgr().OpN.J(emojiStoreV2SingleProductDialogUI.gWm);
            }
            k.cGf().a(emojiStoreV2SingleProductDialogUI, emojiStoreV2SingleProductDialogUI.gWm, emojiStoreV2SingleProductDialogUI.rlP, z.aTY());
        }
        AppMethodBeat.o(109317);
    }
}
