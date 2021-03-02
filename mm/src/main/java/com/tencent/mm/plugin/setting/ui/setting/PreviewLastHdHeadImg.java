package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;

public class PreviewLastHdHeadImg extends MMActivity implements View.OnClickListener {
    private Bitmap CZw;
    private TextView CZx;
    private ImageView dKU;
    private String dRr;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73941);
        customfixStatusbar(true);
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        initView();
        AppMethodBeat.o(73941);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ath;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73942);
        setMMTitle(R.string.gpn);
        setActionbarColor(getResources().getColor(R.color.ac_));
        setNavigationbarColor(getResources().getColor(R.color.BW_0));
        this.username = z.aTY();
        this.dRr = getIntent().getStringExtra("last_avatar_path");
        this.dKU = (ImageView) findViewById(R.id.dnq);
        this.CZw = BitmapUtil.getBitmapNative(this.dRr);
        this.CZx = (TextView) findViewById(R.id.j17);
        this.dKU.setImageBitmap(this.CZw);
        this.CZx.setOnClickListener(this);
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73939);
                e eVar = new e((Context) PreviewLastHdHeadImg.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(73937);
                        if (PreviewLastHdHeadImg.this.CZw != null) {
                            mVar.kV(0, R.string.dv6);
                        }
                        AppMethodBeat.o(73937);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(73938);
                        PreviewLastHdHeadImg.b(PreviewLastHdHeadImg.this);
                        AppMethodBeat.o(73938);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(73939);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73940);
                PreviewLastHdHeadImg.this.finish();
                AppMethodBeat.o(73940);
                return true;
            }
        });
        AppMethodBeat.o(73942);
    }

    private static boolean e(Bitmap bitmap, String str) {
        AppMethodBeat.i(73943);
        if (str != null && !str.equals("")) {
            try {
                BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, str, true);
                AppMethodBeat.o(73943);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.PreviewLastHdHeadImg", e2, "", new Object[0]);
                Log.e("MicroMsg.PreviewLastHdHeadImg", "saveBitmapToImage failed:" + e2.toString());
            }
        }
        AppMethodBeat.o(73943);
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.i(73944);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        String stringExtra = getIntent().getStringExtra("CropImage_OutputPath");
        if (stringExtra == null || !e(this.CZw, stringExtra)) {
            setResult(0);
            finish();
            a.a(this, "com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(73944);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_OutputPath", stringExtra);
        setResult(-1, intent);
        finish();
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/PreviewLastHdHeadImg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(73944);
    }

    static /* synthetic */ void b(PreviewLastHdHeadImg previewLastHdHeadImg) {
        AppMethodBeat.i(73945);
        p.a(previewLastHdHeadImg.getContext(), new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(256473);
                if (s.YS(PreviewLastHdHeadImg.this.dRr)) {
                    String str = AndroidMediaUtil.getSysCameraDirPath() + "hdImg_" + g.getMessageDigest(PreviewLastHdHeadImg.this.username.getBytes()) + System.currentTimeMillis() + ".jpg";
                    s.deleteFile(str);
                    s.nw(PreviewLastHdHeadImg.this.dRr, str);
                    AndroidMediaUtil.refreshMediaScanner(str, PreviewLastHdHeadImg.this.getContext());
                    Toast.makeText(PreviewLastHdHeadImg.this.getContext(), PreviewLastHdHeadImg.this.getContext().getString(R.string.dv7, new Object[]{AndroidMediaUtil.getSysCameraDirPath()}), 1).show();
                    AppMethodBeat.o(256473);
                    return;
                }
                Toast.makeText(PreviewLastHdHeadImg.this.getContext(), PreviewLastHdHeadImg.this.getContext().getString(R.string.gnn), 1).show();
                AppMethodBeat.o(256473);
            }
        }, new Runnable() {
            /* class com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(256474);
                Toast.makeText(PreviewLastHdHeadImg.this.getContext(), PreviewLastHdHeadImg.this.getContext().getString(R.string.gao), 1).show();
                AppMethodBeat.o(256474);
            }
        });
        AppMethodBeat.o(73945);
    }
}
