package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI extends MMActivity {
    private String Kbn;
    private b Kbo;
    private String gwF;
    private String mRa;
    private int mType;
    private String mWording;
    private int rxv;

    /* access modifiers changed from: package-private */
    public interface b {
        void bo(Intent intent);

        String goA();

        String goB();

        String goy();

        int goz();

        void h(int i2, int i3, Intent intent);

        void iy(Context context);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        b bVar = null;
        AppMethodBeat.i(128842);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        Log.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", Integer.valueOf(this.mType));
        this.mRa = Util.nullAs(getIntent().getStringExtra("Kusername"), (String) null);
        this.gwF = Util.nullAs(getIntent().getStringExtra("Kvertify_key"), (String) null);
        this.Kbn = Util.nullAs(getIntent().getStringExtra("KVoiceHelpUrl"), (String) null);
        this.mWording = Util.nullAs(getIntent().getStringExtra("KVoiceHelpWording"), (String) null);
        this.rxv = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            bVar = new c(this, (byte) 0);
        } else if (this.mType == 1) {
            bVar = new a(this, (byte) 0);
        } else {
            Log.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.Kbo = bVar;
        if (this.Kbo == null || Util.isNullOrNil(this.mRa) || Util.isNullOrNil(this.gwF)) {
            Log.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            AppMethodBeat.o(128842);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.a51);
        if (!Util.isNullOrNil(this.mWording)) {
            textView.setText(this.mWording);
        } else {
            textView.setText(this.Kbo.goB());
        }
        setMMTitle(this.Kbo.goy());
        ((ImageView) findViewById(R.id.a4z)).setImageResource(this.Kbo.goz());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.BioHelperUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128828);
                BioHelperUI.this.finish();
                AppMethodBeat.o(128828);
                return true;
            }
        });
        this.Kbo.bo(getIntent());
        Button button = (Button) findViewById(R.id.a52);
        button.setText(this.Kbo.goA());
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.BioHelperUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(128829);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/BioHelperUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BioHelperUI.this.Kbo.iy(BioHelperUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/BioHelperUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128829);
            }
        });
        findViewById(R.id.a50).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.BioHelperUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(128830);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/BioHelperUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", new StringBuilder(BioHelperUI.this.Kbn).toString());
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                com.tencent.mm.br.c.b(BioHelperUI.this, "webview", ".ui.tools.WebViewUI", intent);
                BioHelperUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/BioHelperUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128830);
            }
        });
        AppMethodBeat.o(128842);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ja;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(128843);
        super.onActivityResult(i2, i3, intent);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.BioHelperUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        this.Kbo.h(i2, i3, intent);
        AppMethodBeat.o(128843);
    }

    class c implements b {
        private int mScene;

        private c() {
        }

        /* synthetic */ c(BioHelperUI bioHelperUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final void bo(Intent intent) {
            AppMethodBeat.i(128836);
            if (intent == null) {
                AppMethodBeat.o(128836);
                return;
            }
            this.mScene = intent.getIntExtra("kscene_type", 73);
            AppMethodBeat.o(128836);
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final String goy() {
            AppMethodBeat.i(128837);
            String string = BioHelperUI.this.getString(R.string.age);
            AppMethodBeat.o(128837);
            return string;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final int goz() {
            return R.drawable.bvh;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final String goA() {
            AppMethodBeat.i(128838);
            String string = BioHelperUI.this.getString(R.string.agd);
            AppMethodBeat.o(128838);
            return string;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final String goB() {
            AppMethodBeat.i(128839);
            String string = BioHelperUI.this.getString(R.string.ag_);
            AppMethodBeat.o(128839);
            return string;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final void iy(Context context) {
            AppMethodBeat.i(128840);
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.mScene);
            intent.putExtra("Kusername", BioHelperUI.this.mRa);
            intent.putExtra("Kvertify_key", BioHelperUI.this.gwF);
            com.tencent.mm.br.c.b(context, "voiceprint", ".ui.VoiceLoginUI", intent, 1024);
            AppMethodBeat.o(128840);
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final void h(int i2, int i3, Intent intent) {
            int i4 = 0;
            AppMethodBeat.i(128841);
            if (i3 == -1) {
                if (i2 == 1024 && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
                    if (!Util.isNullOrNil(stringExtra)) {
                        i4 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i4);
                    Log.d("MicroMsg.BioHelperUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d", objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", BioHelperUI.this.rxv);
                    BioHelperUI.this.setResult(-1, intent2);
                }
                BioHelperUI.this.finish();
            }
            AppMethodBeat.o(128841);
        }
    }

    class a implements b {
        private a() {
        }

        /* synthetic */ a(BioHelperUI bioHelperUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final void bo(Intent intent) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final String goy() {
            AppMethodBeat.i(128831);
            String string = BioHelperUI.this.getString(R.string.aga);
            AppMethodBeat.o(128831);
            return string;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final int goz() {
            return R.drawable.c6h;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final String goA() {
            AppMethodBeat.i(128832);
            String string = BioHelperUI.this.getString(R.string.agb);
            AppMethodBeat.o(128832);
            return string;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final String goB() {
            AppMethodBeat.i(128833);
            String string = BioHelperUI.this.getString(R.string.ag9);
            AppMethodBeat.o(128833);
            return string;
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final void iy(Context context) {
            AppMethodBeat.i(128834);
            Intent intent = new Intent();
            intent.putExtra("k_user_name", BioHelperUI.this.mRa);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_ticket", BioHelperUI.this.gwF);
            com.tencent.mm.br.c.b(BioHelperUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", intent, (int) TXLiteAVCode.EVT_CAMERA_CLOSE);
            AppMethodBeat.o(128834);
        }

        @Override // com.tencent.mm.pluginsdk.ui.BioHelperUI.b
        public final void h(int i2, int i3, Intent intent) {
            int i4 = 0;
            AppMethodBeat.i(128835);
            if (i3 == 2 && intent != null) {
                BioHelperUI.this.finish();
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(Util.isNullOrNil(stringExtra));
                if (!Util.isNullOrNil(stringExtra)) {
                    i4 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i4);
                Log.i("MicroMsg.BioHelperUI", "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", objArr);
            }
            AppMethodBeat.o(128835);
        }
    }
}
