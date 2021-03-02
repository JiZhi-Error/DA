package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;

public class ProfileMobilePhoneView extends ProfileItemView {
    public String KcI;
    public String KcJ;
    public String[] KcK;
    public LinearLayout KcT;
    public boolean KcU;
    private Context mContext;
    public TextView mPa;
    private View.OnClickListener zHh;

    public ProfileMobilePhoneView(Context context, View.OnClickListener onClickListener) {
        super(context, null);
        this.KcU = false;
        this.zHh = onClickListener;
        this.mContext = context;
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.KcU = false;
        this.mContext = context;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public int getLayout() {
        return R.layout.bjj;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final void init() {
        AppMethodBeat.i(31240);
        this.mPa = (TextView) findViewById(R.id.gad);
        this.KcT = (LinearLayout) findViewById(R.id.gac);
        for (int i2 = 0; i2 < 5; i2++) {
            this.KcT.getChildAt(i2).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(31234);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ProfileMobilePhoneView.a(ProfileMobilePhoneView.this, ((TextView) view).getText().toString());
                    ProfileMobilePhoneView.this.zHh.onClick(view);
                    a.a(this, "com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31234);
                }
            });
        }
        AppMethodBeat.o(31240);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean aj(as asVar) {
        this.rjX = asVar;
        return true;
    }

    public final void my(String str, String str2) {
        AppMethodBeat.i(31241);
        Log.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", str, str2);
        this.KcI = str;
        this.KcJ = str2;
        eEV();
        AppMethodBeat.o(31241);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean eEV() {
        int i2;
        int i3;
        AppMethodBeat.i(31242);
        if (this.mPa != null) {
            ViewGroup.LayoutParams layoutParams = this.mPa.getLayoutParams();
            layoutParams.width = com.tencent.mm.cb.a.aG(getContext(), R.dimen.em);
            this.mPa.setLayoutParams(layoutParams);
        }
        if (this.KcT == null) {
            AppMethodBeat.o(31242);
        } else {
            if (Util.isNullOrNil(this.KcI) || !Util.isPhoneNumber(this.KcI).booleanValue()) {
                if (this.KcI != null && !Util.isPhoneNumber(this.KcI).booleanValue()) {
                    Log.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", this.KcI);
                }
                i2 = 0;
                i3 = 0;
            } else {
                View childAt = this.KcT.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.KcI);
                }
                i2 = 1;
                i3 = 1;
            }
            if (!Util.isNullOrNil(this.KcJ)) {
                this.KcK = com.tencent.mm.contact.a.a(this.rjX, this.KcJ);
                if (this.KcK != null) {
                    setVisibility(0);
                    while (i3 < this.KcK.length + i2) {
                        View childAt2 = this.KcT.getChildAt(i3);
                        if (childAt2 != null) {
                            childAt2.setVisibility(0);
                            ((TextView) childAt2).setText(this.KcK[i3 - i2]);
                        }
                        i3++;
                    }
                    i3 = i3;
                }
            }
            while (i3 < 5) {
                this.KcT.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i2 != 1 && Util.isNullOrNil(this.KcJ)) {
                setVisibility(8);
            }
            AppMethodBeat.o(31242);
        }
        return false;
    }

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        AppMethodBeat.i(31243);
        e eVar = new e(profileMobilePhoneView.getContext(), false, 1);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(232187);
                mVar.b(0, ProfileMobilePhoneView.this.getResources().getString(R.string.baf), R.raw.bottomsheet_icon_transmit);
                mVar.b(1, ProfileMobilePhoneView.this.getResources().getString(R.string.t_), R.raw.bottomsheet_icon_moment);
                AppMethodBeat.o(232187);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(232188);
                if (i2 == 0) {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(WebView.SCHEME_TEL + str));
                    try {
                        Context context = ProfileMobilePhoneView.this.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        a.a(context, "com/tencent/mm/pluginsdk/ui/ProfileMobilePhoneView$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(232188);
                    } catch (ActivityNotFoundException e2) {
                        Log.e("MicroMsg.ProfileMobilePhoneView", "ActivityNotFoundException!");
                        AppMethodBeat.o(232188);
                    }
                } else {
                    if (i2 == 1) {
                        ClipboardHelper.setText(ProfileMobilePhoneView.this.getContext(), null, str);
                        Toast.makeText(ProfileMobilePhoneView.this.getContext(), ProfileMobilePhoneView.this.getResources().getString(R.string.ta), 0).show();
                    }
                    AppMethodBeat.o(232188);
                }
            }
        };
        eVar.dGm();
        AppMethodBeat.o(31243);
    }
}
