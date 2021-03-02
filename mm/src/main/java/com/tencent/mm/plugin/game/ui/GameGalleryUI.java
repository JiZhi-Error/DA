package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.game.report.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI extends MMActivity implements ViewPager.OnPageChangeListener {
    private String appId = "";
    private MMDotView oxc;
    private ViewPager riH;
    private int sQn = -1;
    private int xSP = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42151);
        super.onCreate(bundle);
        hideTitleView();
        this.riH = (ViewPager) findViewById(R.id.dfr);
        this.oxc = (MMDotView) findViewById(R.id.dfv);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            AppMethodBeat.o(42151);
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.sQn = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.xSP = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.riH.setAdapter(new a(this, stringArrayExtra));
        this.riH.setOnPageChangeListener(this);
        this.riH.setCurrentItem(intExtra, false);
        this.oxc.setInvertedStyle(true);
        this.oxc.setDotCount(stringArrayExtra.length);
        this.oxc.setSelectedDot(intExtra);
        if (intExtra == 0) {
            f.a(this, this.sQn, TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY, 1, 12, this.appId, this.xSP, null);
        }
        AppMethodBeat.o(42151);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aqi;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(42152);
        this.oxc.setSelectedDot(i2);
        f.a(this, this.sQn, TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY, i2 + 1, 12, this.appId, this.xSP, null);
        AppMethodBeat.o(42152);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    static class a extends q {
        Context mContext;
        private String[] xSQ = new String[0];
        private View[] xSR;

        public a(Context context, String[] strArr) {
            AppMethodBeat.i(42148);
            this.mContext = context;
            if (strArr != null) {
                this.xSQ = strArr;
            }
            this.xSR = new View[this.xSQ.length];
            AppMethodBeat.o(42148);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(42149);
            View view = this.xSR[i2];
            if (view == null) {
                View inflate = View.inflate(this.mContext, R.layout.aqk, null);
                this.xSR[i2] = inflate;
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.dfw);
                progressBar.setVisibility(0);
                com.tencent.mm.av.a.a bcV = com.tencent.mm.av.q.bcV();
                String str = this.xSQ[i2];
                c.a aVar = new c.a();
                aVar.jbe = true;
                bcV.a(str, (ImageView) inflate.findViewById(R.id.dfu), aVar.bdv(), new h() {
                    /* class com.tencent.mm.plugin.game.ui.GameGalleryUI.a.AnonymousClass1 */

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view) {
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final Bitmap a(String str, View view, b bVar) {
                        return null;
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view, b bVar) {
                        AppMethodBeat.i(42146);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.game.ui.GameGalleryUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(42145);
                                progressBar.setVisibility(8);
                                AppMethodBeat.o(42145);
                            }
                        });
                        AppMethodBeat.o(42146);
                    }
                });
                view = inflate;
            }
            viewGroup.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.game.ui.GameGalleryUI.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(42147);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ((MMActivity) a.this.mContext).finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(42147);
                }
            });
            AppMethodBeat.o(42149);
            return view;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(42150);
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(42150);
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            return this.xSQ.length;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }
}
