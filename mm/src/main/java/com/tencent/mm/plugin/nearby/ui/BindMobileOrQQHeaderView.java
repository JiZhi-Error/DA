package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class BindMobileOrQQHeaderView extends LinearLayout {
    private TextView AzH;
    private a AzI;
    private View.OnClickListener AzJ;
    private WeImageView ubT;

    public enum a {
        Mobile,
        UploadContact;

        public static a valueOf(String str) {
            AppMethodBeat.i(89800);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(89800);
            return aVar;
        }

        static {
            AppMethodBeat.i(89801);
            AppMethodBeat.o(89801);
        }
    }

    public BindMobileOrQQHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(89802);
        this.AzJ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(89797);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 7);
                MMWizardActivity.ay(BindMobileOrQQHeaderView.this.getContext(), intent);
                if (g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
                    g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).result = "1";
                    f.KW(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89797);
            }
        };
        bh(context);
        AppMethodBeat.o(89802);
    }

    public BindMobileOrQQHeaderView(Context context) {
        super(context);
        AppMethodBeat.i(89803);
        this.AzJ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.BindMobileOrQQHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(89797);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.setClass(BindMobileOrQQHeaderView.this.getContext(), BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 7);
                MMWizardActivity.ay(BindMobileOrQQHeaderView.this.getContext(), intent);
                if (g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
                    g.aWT().KR(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).result = "1";
                    f.KW(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/BindMobileOrQQHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89797);
            }
        };
        this.AzI = a.Mobile;
        bh(context);
        AppMethodBeat.o(89803);
    }

    private void bh(Context context) {
        AppMethodBeat.i(89804);
        View inflate = View.inflate(context, R.layout.bey, this);
        this.AzH = (TextView) inflate.findViewById(R.id.fug);
        this.ubT = (WeImageView) inflate.findViewById(R.id.ftz);
        switch (this.AzI) {
            case Mobile:
                setOnClickListener(this.AzJ);
                this.ubT.setImageResource(R.raw.icons_outlined_cellphone);
                AppMethodBeat.o(89804);
                return;
            case UploadContact:
                setOnClickListener(this.AzJ);
                this.ubT.setImageResource(R.raw.icons_outlined_contacts);
                break;
        }
        AppMethodBeat.o(89804);
    }
}
