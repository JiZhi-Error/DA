package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.ap;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public abstract class f extends a implements View.OnClickListener {
    FragmentActivity mActivity;
    private WeImageView obA = ((WeImageView) this.oby.findViewById(R.id.dt5));
    private View obB;
    private ImageView obC;
    private MMAnimateView obD;
    private TextView obE;
    private View obF = this.oby.findViewById(R.id.gy4);
    protected ajs obG;
    private ViewGroup oby;
    private ImageView obz = ((ImageView) this.oby.findViewById(R.id.nu));

    /* access modifiers changed from: protected */
    public abstract String getTitle();

    static /* synthetic */ void a(f fVar, ajs ajs, ap.d dVar, Bitmap bitmap, byte[] bArr) {
        boolean z = fVar.obB.getVisibility() != 0;
        switch (dVar) {
            case TYPE_NULL:
                fVar.obB.setVisibility(8);
                fVar.obD.stop();
                return;
            case TYPE_ICON_WORDING:
                if (bitmap != null && !TextUtils.isEmpty(ajs.dQx)) {
                    fVar.obB.setVisibility(0);
                    fVar.obC.setVisibility(0);
                    fVar.obE.setVisibility(0);
                    fVar.obD.setVisibility(8);
                    fVar.obC.setImageBitmap(bitmap);
                    fVar.obE.setText(ajs.dQx);
                    fVar.obD.stop();
                    if (z) {
                        fVar.bYs();
                        return;
                    }
                    return;
                }
                return;
            case TYPE_ICON_WORDING_ICON2:
                if (bitmap != null && bArr != null && bArr.length != 0 && !TextUtils.isEmpty(ajs.dQx)) {
                    fVar.obB.setVisibility(0);
                    fVar.obC.setVisibility(0);
                    fVar.obE.setVisibility(0);
                    fVar.obD.setVisibility(0);
                    fVar.obC.setImageBitmap(bitmap);
                    fVar.obE.setText(ajs.dQx);
                    fVar.obD.g(bArr, "");
                    fVar.obD.start();
                    if (z) {
                        fVar.bYs();
                        return;
                    }
                    return;
                }
                return;
            case TYPE_WORDING:
                if (!TextUtils.isEmpty(ajs.dQx)) {
                    fVar.obB.setVisibility(0);
                    fVar.obC.setVisibility(8);
                    fVar.obE.setVisibility(0);
                    fVar.obD.setVisibility(8);
                    fVar.obD.stop();
                    fVar.obE.setText(ajs.dQx);
                    if (z) {
                        fVar.bYs();
                        return;
                    }
                    return;
                }
                return;
            case TYPE_WORDING_ICON:
                if (bArr != null && bArr.length != 0 && !TextUtils.isEmpty(ajs.dQx)) {
                    fVar.obB.setVisibility(0);
                    fVar.obC.setVisibility(8);
                    fVar.obE.setVisibility(0);
                    fVar.obD.setVisibility(0);
                    fVar.obE.setText(ajs.dQx);
                    fVar.obD.g(bArr, "");
                    fVar.obD.start();
                    if (z) {
                        fVar.bYs();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    f(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        this.mActivity = fragmentActivity;
        this.oby = (ViewGroup) LayoutInflater.from(fragmentActivity).inflate(R.layout.f1, viewGroup, false);
        this.oby.setOnClickListener(this);
        ((TextView) this.oby.findViewById(R.id.ipm)).setText(getTitle());
        if (this.obA != null) {
            a(this.obA);
        }
        this.obB = this.oby.findViewById(R.id.hra);
        this.obC = (ImageView) this.oby.findViewById(R.id.hrb);
        this.obD = (MMAnimateView) this.oby.findViewById(R.id.hrc);
        this.obE = (TextView) this.oby.findViewById(R.id.hrd);
    }

    /* access modifiers changed from: protected */
    public final FragmentActivity getActivity() {
        return this.mActivity;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public void bSx() {
        setViewEnable(true);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onDetached() {
        this.obD.stop();
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public void onResume() {
        b(this.obG);
        this.obD.resume();
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void onPause() {
        this.obD.pause();
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final View bYp() {
        return this.oby;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void zu(int i2) {
        if (this.obz != null) {
            this.obz.setVisibility(i2);
        }
        TextView textView = (TextView) this.oby.findViewById(R.id.ipm);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.oby.getResources().getDimensionPixelOffset(R.dimen.q2);
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.recents.a
    public final void zv(int i2) {
        this.oby.setBackgroundResource(i2);
    }

    public void onClick(View view) {
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherListHeaderFolderEntrance", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    }

    public final void iR(boolean z) {
        Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showRedDot] showRedDot == ".concat(String.valueOf(z)));
        this.obF.setVisibility(z ? 0 : 8);
    }

    public final void b(final ajs ajs) {
        if (ajs != null) {
            this.obG = ajs;
            final ap.d wb = ap.d.wb(ajs.xGz);
            if (wb != null) {
                Log.i("AppBrandLauncherListHeaderFolderEntrance", "[showShowCaseView]  wording=" + ajs.dQx + " icon_url=" + ajs.qGB + " icon_url2=" + ajs.Lth);
                new a(ajs.qGB, ajs.Lth, new a.AbstractC0809a() {
                    /* class com.tencent.mm.plugin.appbrand.ui.recents.f.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.ui.recents.f.a.AbstractC0809a
                    public final void b(final Bitmap bitmap, final byte[] bArr) {
                        int i2 = 0;
                        AppMethodBeat.i(180392);
                        StringBuilder append = new StringBuilder("[LoadShowcaseImageTask#onLoadDone]  bitmap == null ").append(bitmap == null).append(" rightImageBytes length=");
                        if (bArr != null) {
                            i2 = bArr.length;
                        }
                        Log.i("AppBrandLauncherListHeaderFolderEntrance", append.append(i2).toString());
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.ui.recents.f.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(180391);
                                f.a(f.this, ajs, wb, bitmap, bArr);
                                AppMethodBeat.o(180391);
                            }
                        });
                        AppMethodBeat.o(180392);
                    }
                }).start();
            }
        }
    }

    private void bYs() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.obB, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(30L);
        ofFloat.start();
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private final AtomicInteger counter = new AtomicInteger();
        Bitmap imageBitmap = null;
        private final String obN;
        private final String obO;
        private final AbstractC0809a obP;
        byte[] obQ = null;

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.f$a$a  reason: collision with other inner class name */
        public interface AbstractC0809a {
            void b(Bitmap bitmap, byte[] bArr);
        }

        public a(String str, String str2, AbstractC0809a aVar) {
            AppMethodBeat.i(180397);
            this.obN = str;
            this.obO = str2;
            this.obP = aVar;
            if (!TextUtils.isEmpty(str)) {
                bYu();
            }
            if (!TextUtils.isEmpty(str2)) {
                bYu();
            }
            if (this.counter.get() == 0) {
                aVar.b(null, null);
            }
            AppMethodBeat.o(180397);
        }

        /* access modifiers changed from: package-private */
        public final void bYt() {
            AppMethodBeat.i(180398);
            if (this.counter.decrementAndGet() == 0 && this.obP != null) {
                this.obP.b(this.imageBitmap, this.obQ);
            }
            AppMethodBeat.o(180398);
        }

        private void bYu() {
            AppMethodBeat.i(180399);
            this.counter.incrementAndGet();
            AppMethodBeat.o(180399);
        }

        public final void start() {
            AppMethodBeat.i(180400);
            if (!TextUtils.isEmpty(this.obN)) {
                afw(this.obN);
            }
            if (!TextUtils.isEmpty(this.obO)) {
                afx(this.obO);
            }
            AppMethodBeat.o(180400);
        }

        private void afw(String str) {
            AppMethodBeat.i(180401);
            com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.f.a.AnonymousClass1 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(180394);
                    a.this.imageBitmap = bitmap;
                    a.this.bYt();
                    AppMethodBeat.o(180394);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(180395);
                    a.this.bYt();
                    AppMethodBeat.o(180395);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    return "LoadShowcaseImageTask";
                }
            }, str, (b.h) null);
            AppMethodBeat.o(180401);
        }

        private void afx(String str) {
            AppMethodBeat.i(180402);
            com.tencent.mm.modelappbrand.a.b.aXY().a(str, new b.j() {
                /* class com.tencent.mm.plugin.appbrand.ui.recents.f.a.AnonymousClass2 */

                @Override // com.tencent.mm.modelappbrand.a.b.j
                public final void aj(byte[] bArr) {
                    AppMethodBeat.i(180396);
                    a.this.obQ = bArr;
                    a.this.bYt();
                    AppMethodBeat.o(180396);
                }
            });
            AppMethodBeat.o(180402);
        }
    }
}
