package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.media.a;
import com.tencent.mm.plugin.game.media.l;
import com.tencent.mm.plugin.game.media.p;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class m extends FrameLayout {
    private View GQ;
    private View gAy;
    private int mRequestCode;
    private int xAD;
    private l xBE;
    private ThreeDotsLoadingView xBF;
    private long xBG;
    private h xBq;
    private a xBt;
    private boolean xBu = true;

    static /* synthetic */ void a(m mVar, LinkedList linkedList, boolean z) {
        AppMethodBeat.i(204133);
        mVar.b(linkedList, z, false);
        AppMethodBeat.o(204133);
    }

    static /* synthetic */ void a(m mVar, Map map) {
        AppMethodBeat.i(204132);
        mVar.a(501, 41, map);
        AppMethodBeat.o(204132);
    }

    static /* synthetic */ void b(m mVar) {
        AppMethodBeat.i(41096);
        mVar.getDataFromNet();
        AppMethodBeat.o(41096);
    }

    public m(Context context, int i2) {
        super(context);
        AppMethodBeat.i(41087);
        this.mRequestCode = i2;
        a(0, 1, (Map) null);
        AppMethodBeat.o(41087);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(41088);
        super.onDetachedFromWindow();
        this.xBt.destroy();
        AppMethodBeat.o(41088);
    }

    public final void J(boolean z, int i2) {
        this.xBu = z;
        this.xAD = i2;
    }

    public final void setLocalAlbumInfos(JSONArray jSONArray) {
        AppMethodBeat.i(41089);
        this.xBt = new a();
        a.a(this.xBt);
        this.xBt.y(jSONArray);
        this.xBq = new h(getContext(), 8766, this.xAD);
        this.xBq.setBackgroundColor(-1);
        this.xBq.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.game.media.m.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(204131);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(204131);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(41076);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                if (m.this.xBq.Of(i2)) {
                    m.b(m.this);
                }
                a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(41076);
            }
        });
        this.xBq.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b() {
            /* class com.tencent.mm.plugin.game.media.m.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.b
            public final void Q(View view, int i2) {
                AppMethodBeat.i(41077);
                e Og = m.this.xBq.Og(i2);
                if (Og.xuJ || Og.xuK) {
                    AppMethodBeat.o(41077);
                } else if (!m.this.xBu) {
                    Intent intent = new Intent();
                    f fVar = new f();
                    fVar.xuQ = m.this.xBt.xzV;
                    int indexOf = fVar.xuQ.indexOf(Og);
                    try {
                        intent.putExtra("game_video_list", fVar.toByteArray());
                        intent.putExtra("game_video_list_current_index", indexOf);
                        intent.putExtra("game_video_has_next", m.this.xBt.hasNext());
                        intent.putExtra("game_video_preview_source", p.a.FROM_TAB_GALLERY);
                        intent.putExtra("game_haowan_source_scene_id", m.this.xAD);
                        c.b(m.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", intent, m.this.mRequestCode);
                        AppMethodBeat.o(41077);
                    } catch (IOException e2) {
                        AppMethodBeat.o(41077);
                    }
                } else if (Og.dLQ) {
                    ((g) com.tencent.mm.kernel.g.af(g.class)).a(m.this.getContext(), 6, Og.appId, Og.videoUrl, null, null, m.this.mRequestCode, null, m.this.xAD);
                    AppMethodBeat.o(41077);
                } else {
                    ((g) com.tencent.mm.kernel.g.af(g.class)).a(m.this.getContext(), 6, Og.appId, null, Og.videoUrl, Og.xuM, m.this.mRequestCode, null, m.this.xAD);
                    AppMethodBeat.o(41077);
                }
            }
        });
        this.xBE = new l(getContext());
        this.xBE.setPullDownEnabled(true);
        this.xBE.setNeedStay(true);
        this.xBE.setOnPullDownListener(new l.a() {
            /* class com.tencent.mm.plugin.game.media.m.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.game.media.l.a
            public final void bRR() {
                AppMethodBeat.i(41079);
                m.this.xBG = System.currentTimeMillis();
                m.this.xBF.gZh();
                m.this.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.game.media.m.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(41078);
                        m.this.xBE.bRQ();
                        AppMethodBeat.o(41078);
                    }
                }, 400);
                AppMethodBeat.o(41079);
            }

            @Override // com.tencent.mm.plugin.game.media.l.a
            public final void dUv() {
                AppMethodBeat.i(41080);
                if (m.this.xBG == 0) {
                    AppMethodBeat.o(41080);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - m.this.xBG;
                m.this.xBG = 0;
                HashMap hashMap = new HashMap();
                hashMap.put("loading_time", Long.valueOf(currentTimeMillis));
                m.a(m.this, hashMap);
                m.this.xBF.gZi();
                AppMethodBeat.o(41080);
            }
        });
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aok, (ViewGroup) this, false);
        this.xBF = (ThreeDotsLoadingView) inflate.findViewById(R.id.dii);
        this.xBE.l(inflate, this.xBq);
        addView(this.xBE, -1, -1);
        this.GQ = LayoutInflater.from(getContext()).inflate(R.layout.aoh, (ViewGroup) this, false);
        this.GQ.setVisibility(8);
        addView(this.GQ, -1, -1);
        this.gAy = LayoutInflater.from(getContext()).inflate(R.layout.aoj, (ViewGroup) this, false);
        this.gAy.setVisibility(8);
        addView(this.gAy, -1, -1);
        LinkedList<e> dTZ = this.xBt.dTZ();
        if (Util.isNullOrNil(dTZ)) {
            this.gAy.setVisibility(0);
            ((ThreeDotsLoadingView) this.gAy.findViewById(R.id.dh9)).gZh();
        } else {
            b(dTZ, false, true);
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.m.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(41081);
                    m.this.xBE.dUu();
                    AppMethodBeat.o(41081);
                }
            }, 0);
        }
        getDataFromNet();
        AppMethodBeat.o(41089);
    }

    private void dTO() {
        AppMethodBeat.i(41090);
        this.gAy.setVisibility(8);
        AppMethodBeat.o(41090);
    }

    private void bIo() {
        AppMethodBeat.i(41091);
        this.GQ.setVisibility(0);
        a(502, 1, (Map) null);
        AppMethodBeat.o(41091);
    }

    private void dUt() {
        AppMethodBeat.i(41092);
        this.GQ.setVisibility(8);
        AppMethodBeat.o(41092);
    }

    private void getDataFromNet() {
        AppMethodBeat.i(41093);
        this.xBt.b(new a.AbstractC1400a() {
            /* class com.tencent.mm.plugin.game.media.m.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.game.media.a.AbstractC1400a
            public final void c(final LinkedList<e> linkedList, final boolean z) {
                AppMethodBeat.i(41085);
                m.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.game.media.m.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(41084);
                        m.this.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.game.media.m.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(41083);
                                m.this.xBE.bRQ();
                                AppMethodBeat.o(41083);
                            }
                        }, 100);
                        m.a(m.this, linkedList, z);
                        AppMethodBeat.o(41084);
                    }
                });
                AppMethodBeat.o(41085);
            }
        });
        AppMethodBeat.o(41093);
    }

    private void b(LinkedList<e> linkedList, boolean z, boolean z2) {
        AppMethodBeat.i(41094);
        dTO();
        Log.i("MicroMsg.GameTabGalleryView", "setData, data is null : %b", Boolean.valueOf(Util.isNullOrNil(linkedList)));
        if (!Util.isNullOrNil(linkedList)) {
            dUt();
            if (a.dUf()) {
                a.dUe();
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.game.media.m.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(41086);
                        m.j(m.this);
                        AppMethodBeat.o(41086);
                    }
                }, 500);
            }
        } else {
            bIo();
        }
        this.xBq.b(linkedList, z, z2);
        AppMethodBeat.o(41094);
    }

    private void a(int i2, int i3, Map map) {
        AppMethodBeat.i(41095);
        if (map == null) {
            map = new HashMap();
        }
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8766, i2, i3, this.xAD, com.tencent.mm.game.report.b.a.c(6, map));
        AppMethodBeat.o(41095);
    }

    static /* synthetic */ void j(m mVar) {
        AppMethodBeat.i(204134);
        View inflate = LayoutInflater.from(mVar.getContext()).inflate(R.layout.aqj, (ViewGroup) mVar, false);
        final android.support.design.widget.a aVar = new android.support.design.widget.a(mVar.getContext());
        aVar.setContentView(inflate);
        com.tencent.mm.modelappbrand.a.b.aXY().a((ImageView) inflate.findViewById(R.id.dd0), HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2_) + "/wechatgame/product/cdn/null/photo_3x_a59269f6.png", (Drawable) null, (b.h) null);
        ((Button) inflate.findViewById(R.id.dd1)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.m.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(41082);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameTabGalleryView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                aVar.cancel();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameTabGalleryView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41082);
            }
        });
        aVar.show();
        mVar.a(503, 1, (Map) null);
        AppMethodBeat.o(204134);
    }
}
