package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> CKn = new HashMap();
    private String CKm = null;
    private ImageView CKo;
    private EditText CKp;
    protected Bitmap mBmp = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        AppMethodBeat.i(118348);
        confirmScanBankCardResultUI.eQH();
        AppMethodBeat.o(118348);
    }

    static {
        AppMethodBeat.i(118349);
        AppMethodBeat.o(118349);
    }

    public static void c(Bitmap bitmap, String str) {
        Context context;
        AppMethodBeat.i(118343);
        if (bitmap == null || bitmap.isRecycled() || Util.isNullOrNil(str)) {
            AppMethodBeat.o(118343);
            return;
        }
        Intent intent = new Intent();
        if (((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {
            context = ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).getCrossActivity();
        } else {
            context = null;
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
            intent.addFlags(268435456);
        }
        intent.setClass(context, ConfirmScanBankCardResultUI.class);
        intent.putExtra("_card_num_", str);
        String concat = "_image_cache_key_".concat(String.valueOf(str));
        CKn.put(concat, bitmap);
        intent.putExtra("_image_cache_key_", concat);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "startConfirm", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "startConfirm", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(118343);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(118344);
        super.onCreate(bundle);
        setMMTitle(R.string.ged);
        if (getIntent() == null) {
            Log.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            z = false;
        } else {
            this.CKm = getIntent().getStringExtra("_image_cache_key_");
            if (Util.isNullOrNil(this.CKm)) {
                Log.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                z = false;
            } else {
                this.mBmp = CKn.get(this.CKm);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    Log.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    z = false;
                } else {
                    z = true;
                }
            }
        }
        if (!z) {
            finish();
            AppMethodBeat.o(118344);
            return;
        }
        String stringExtra = getIntent().getStringExtra("_card_num_");
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            AppMethodBeat.o(118344);
            return;
        }
        this.CKo = (ImageView) findViewById(R.id.duq);
        this.CKp = (EditText) findViewById(R.id.bvj);
        this.CKo.setImageBitmap(this.mBmp);
        this.CKp.setText(stringExtra);
        findViewById(R.id.agg).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(118341);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ConfirmScanBankCardResultUI.this.CKp != null) {
                    String obj = ConfirmScanBankCardResultUI.this.CKp.getEditableText().toString();
                    if (Util.isNullOrNil(obj)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(118341);
                        return;
                    }
                    ConfirmScanBankCardResultUI.this.finish();
                    tf tfVar = new tf();
                    tfVar.dZF.action = 1;
                    tfVar.dZF.cardNum = obj;
                    tfVar.dZF.dZG = ConfirmScanBankCardResultUI.this.mBmp;
                    EventCenter.instance.publish(tfVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(118341);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(118342);
                ConfirmScanBankCardResultUI.b(ConfirmScanBankCardResultUI.this);
                AppMethodBeat.o(118342);
                return true;
            }
        });
        AppMethodBeat.o(118344);
    }

    private void eQH() {
        AppMethodBeat.i(118345);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(268435456);
        intent.setClass(this, ScanCardUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "goBackScan", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "goBackScan", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(118345);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(118346);
        eQH();
        AppMethodBeat.o(118346);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(118347);
        super.onDestroy();
        if (this.CKo != null) {
            this.CKo.setImageBitmap(null);
        }
        if (!Util.isNullOrNil(this.CKm)) {
            CKn.remove(this.CKm);
        }
        if (this.mBmp != null) {
            Log.i("MicroMsg.ConfirmScanBankCardResultUI", "bitmap recycle %s", this.mBmp.toString());
            this.mBmp.recycle();
        }
        AppMethodBeat.o(118347);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.w8;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
