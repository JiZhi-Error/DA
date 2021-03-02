package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class n {
    android.support.design.widget.a Edb;
    private int Edc = -1;
    private int Edd = -1;
    private boolean Ede = false;
    private boolean Edf = false;
    public a Edg;
    public String gIx = "";
    private View jBN;
    private Context mContext;
    public String mTitle = "";
    public String rcG = "";

    public interface a {
        void fdt();

        void fdu();
    }

    public n(Context context, m mVar, String str, String str2, String str3, boolean z, boolean z2) {
        boolean z3;
        AppMethodBeat.i(96483);
        this.gIx = str;
        this.mTitle = str2;
        this.rcG = str3;
        this.mContext = context;
        this.Ede = z;
        this.Edf = z2;
        if (!(mVar == null || mVar.getView() == null)) {
            this.Edb = new android.support.design.widget.a(context);
            this.Edb.setCanceledOnTouchOutside(true);
            this.jBN = View.inflate(context, R.layout.bu_, null);
            if (this.jBN == null) {
                Log.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
                AppMethodBeat.o(96483);
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.jBN.findViewById(R.id.b9w);
            View view = mVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.Edc = (int) mVar.fdk().DZk;
            this.Edd = (int) mVar.fdk().DZl;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.Edc == Integer.MAX_VALUE || this.Edd == Integer.MAX_VALUE) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                layoutParams.width = this.Edc;
                layoutParams.height = this.Edd;
            }
            linearLayout.addView(view, layoutParams);
            ((TextView) this.jBN.findViewById(R.id.ab9)).setText(str2);
            View findViewById = this.jBN.findViewById(R.id.b4_);
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(96478);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    n.this.Edb.cancel();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96478);
                }
            });
            View findViewById2 = this.jBN.findViewById(R.id.ab2);
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(96479);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    n.this.Edb.cancel();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(96479);
                }
            });
            if (!this.Edf) {
                findViewById2.setVisibility(8);
            }
            if (this.Ede) {
                findViewById.setVisibility(8);
            }
            final ImageView imageView = (ImageView) this.jBN.findViewById(R.id.ip8);
            imageView.setVisibility(8);
            if (!Util.isNullOrNil(str3)) {
                Bitmap kD = h.kD("adId", str3);
                if (kD != null) {
                    imageView.setImageBitmap(kD);
                    imageView.setVisibility(0);
                    AppMethodBeat.o(96483);
                    return;
                }
                h.a(str3, 0, new f.a() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWN() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWO() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void aNH(String str) {
                        AppMethodBeat.i(96480);
                        try {
                            imageView.setImageBitmap(BitmapUtil.decodeFile(str));
                            imageView.setVisibility(0);
                            AppMethodBeat.o(96480);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AdLandingPageBottomSheet", "%s" + Util.stackTraceToString(e2));
                            AppMethodBeat.o(96480);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(96483);
    }

    public final void dGm() {
        AppMethodBeat.i(96484);
        if (this.jBN == null || this.Edb == null) {
            AppMethodBeat.o(96484);
            return;
        }
        this.Edb.getWindow().setFlags(8, 8);
        this.Edb.getWindow().addFlags(131200);
        if (this.Edg != null) {
            this.Edb.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.AnonymousClass4 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(96481);
                    n.this.Edg.fdt();
                    AppMethodBeat.o(96481);
                }
            });
            this.Edb.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(96482);
                    n.this.Edg.fdu();
                    AppMethodBeat.o(96482);
                }
            });
        }
        this.Edb.setContentView(this.jBN);
        BottomSheetBehavior.l((View) this.jBN.getParent()).J(ap.ha(this.mContext)[1]);
        this.Edb.show();
        AppMethodBeat.o(96484);
    }

    public final void bMo() {
        AppMethodBeat.i(96485);
        if (this.Edb != null) {
            this.Edb.dismiss();
        }
        AppMethodBeat.o(96485);
    }
}
