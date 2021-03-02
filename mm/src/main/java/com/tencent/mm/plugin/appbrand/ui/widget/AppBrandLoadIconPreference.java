package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ac.c;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference extends Preference {
    private String gAn;
    private b.h gCj;
    private int gCk;
    private int gCl;
    private int gCm;
    private int gCn = -1;
    private int gCo = -1;
    private Context mContext;
    private View mView = null;
    private ThreeDotsLoadingView nNl;
    private AppBrandNearbyShowcaseView ogf;
    private View ogg;
    private boolean ogh = false;
    private LinkedList<e> ogi = new LinkedList<>();

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(121074);
        cs(context);
        AppMethodBeat.o(121074);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(121075);
        cs(context);
        AppMethodBeat.o(121075);
    }

    private void cs(Context context) {
        AppMethodBeat.i(121076);
        setLayoutResource(R.layout.b8j);
        this.mContext = context;
        AppMethodBeat.o(121076);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(121077);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.gq, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(121077);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(121078);
        super.onBindView(view);
        this.gCk = a.fromDPToPix(this.mContext, 21);
        this.gCl = a.fromDPToPix(this.mContext, 11);
        this.gCm = a.fromDPToPix(this.mContext, 2);
        this.gCn = this.mContext.getResources().getColor(R.color.vl);
        this.ogg = view.findViewById(R.id.pc);
        this.nNl = (ThreeDotsLoadingView) view.findViewById(R.id.ph);
        this.ogf = (AppBrandNearbyShowcaseView) view.findViewById(R.id.pd);
        this.ogf.setIconSize(this.gCk + (this.gCm * 2));
        this.ogf.setIconGap(this.gCl);
        if (this.gAn == null || this.nNl == null) {
            Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
            AppMethodBeat.o(121078);
        } else if (this.ogh) {
            Log.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
            AppMethodBeat.o(121078);
        } else {
            this.ogh = true;
            cH(this.ogg);
            g(this.nNl, null);
            this.nNl.gZh();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121070);
                    AppBrandLoadIconPreference.a(AppBrandLoadIconPreference.this);
                    AppMethodBeat.o(121070);
                }
            });
            AppMethodBeat.o(121078);
        }
    }

    private static void g(View view, Runnable runnable) {
        AppMethodBeat.i(121079);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.o(121079);
    }

    private void cH(final View view) {
        AppMethodBeat.i(121080);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(121073);
                    view.setVisibility(8);
                    AppMethodBeat.o(121073);
                }
            }).start();
        }
        AppMethodBeat.o(121080);
    }

    static /* synthetic */ void a(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        AppMethodBeat.i(121081);
        c.reset();
        c.a(appBrandLoadIconPreference.gAn, new c.a() {
            /* class com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.ac.c.a
            public final void A(LinkedList<e> linkedList) {
                AppMethodBeat.i(121071);
                AppBrandLoadIconPreference.this.ogi = linkedList;
                AppBrandLoadIconPreference.b(AppBrandLoadIconPreference.this);
                AppMethodBeat.o(121071);
            }
        });
        AppMethodBeat.o(121081);
    }

    static /* synthetic */ void b(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        int i2 = 0;
        AppMethodBeat.i(121082);
        appBrandLoadIconPreference.nNl.gZi();
        appBrandLoadIconPreference.cH(appBrandLoadIconPreference.nNl);
        if (appBrandLoadIconPreference.ogi.size() > 0) {
            appBrandLoadIconPreference.ogf.setVisibility(0);
            appBrandLoadIconPreference.ogf.setIconLayerCount(Math.min(appBrandLoadIconPreference.ogi.size(), 3));
            final boolean z = appBrandLoadIconPreference.ogg.getVisibility() != 0;
            if (z) {
                appBrandLoadIconPreference.ogf.bZV();
            }
            if (appBrandLoadIconPreference.gCj == null) {
                appBrandLoadIconPreference.gCj = new a(appBrandLoadIconPreference.gCk, appBrandLoadIconPreference.gCm, appBrandLoadIconPreference.gCn);
            }
            while (i2 < appBrandLoadIconPreference.ogf.getChildCount()) {
                b.aXY().a(appBrandLoadIconPreference.ogf.zK(i2), appBrandLoadIconPreference.ogi.size() > i2 ? appBrandLoadIconPreference.ogi.get(i2).imagePath : null, com.tencent.mm.modelappbrand.a.a.aXX(), appBrandLoadIconPreference.gCj);
                i2++;
            }
            g(appBrandLoadIconPreference.ogg, new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(121072);
                    if (z && AppBrandLoadIconPreference.this.ogf != null) {
                        AppBrandLoadIconPreference.this.ogf.bZW();
                    }
                    AppMethodBeat.o(121072);
                }
            });
            AppMethodBeat.o(121082);
            return;
        }
        appBrandLoadIconPreference.ogf.setVisibility(8);
        AppMethodBeat.o(121082);
    }
}
