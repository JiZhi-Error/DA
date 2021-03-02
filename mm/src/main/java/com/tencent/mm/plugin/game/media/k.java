package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.media.a;
import com.tencent.mm.plugin.game.media.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class k extends FrameLayout {
    private View GQ;
    private View gAy;
    private boolean gOZ;
    private View jBN;
    private View pyo;
    private int xAD = 0;
    private boolean xBc = false;
    private boolean xBd = false;
    private h xBq;
    private boolean xBr;
    private View xBs;
    private a xBt;
    private boolean xBu = true;
    e xBv;

    static /* synthetic */ void a(k kVar, LinkedList linkedList, boolean z) {
        AppMethodBeat.i(204126);
        kVar.b(linkedList, z, false);
        AppMethodBeat.o(204126);
    }

    static /* synthetic */ void b(k kVar) {
        AppMethodBeat.i(41060);
        kVar.getDataFromNet();
        AppMethodBeat.o(41060);
    }

    public k(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(41050);
        super.onDetachedFromWindow();
        this.xBt.destroy();
        AppMethodBeat.o(41050);
    }

    public final void dUl() {
        AppMethodBeat.i(41051);
        if (!this.gOZ) {
            h(0, new HashMap());
        }
        this.gOZ = true;
        AppMethodBeat.o(41051);
    }

    public final void c(boolean z, boolean z2, boolean z3, int i2) {
        AppMethodBeat.i(204124);
        this.xBu = z;
        this.xBc = z2;
        if (this.xBc && this.pyo != null) {
            this.pyo.setVisibility(8);
        }
        this.xBd = z3;
        this.xAD = i2;
        AppMethodBeat.o(204124);
    }

    public final void setLocalAlbumInfos(JSONArray jSONArray) {
        AppMethodBeat.i(41052);
        this.xBt = new a();
        a.a(this.xBt);
        this.xBt.y(jSONArray);
        this.jBN = LayoutInflater.from(getContext()).inflate(R.layout.aqm, (ViewGroup) this, true);
        this.pyo = this.jBN.findViewById(R.id.dfs);
        if (!this.xBc) {
            this.pyo.setVisibility(0);
        } else {
            this.pyo.setVisibility(8);
        }
        this.jBN.findViewById(R.id.dhc).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.k.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(204121);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("key_game_haowan_text", true);
                ((Activity) k.this.getContext()).setResult(-1, intent);
                ((Activity) k.this.getContext()).finish();
                a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(204121);
            }
        });
        this.xBq = new h(getContext(), 8762, this.xAD);
        this.xBq.setBackgroundColor(getResources().getColor(R.color.afz));
        this.xBq.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.game.media.k.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(204120);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(204120);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(41045);
                b bVar = new b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                if (k.this.xBq.Of(i2)) {
                    k.b(k.this);
                }
                a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(41045);
            }
        });
        this.xBq.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.b() {
            /* class com.tencent.mm.plugin.game.media.k.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.b
            public final void Q(View view, int i2) {
                AppMethodBeat.i(41046);
                e Og = k.this.xBq.Og(i2);
                if (Og.xuJ || Og.xuK) {
                    AppMethodBeat.o(41046);
                    return;
                }
                k.this.xBv = Og;
                if (k.this.xBu) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("game_straight_to_publish", k.this.xBd);
                    if (Og.dLQ) {
                        ((g) com.tencent.mm.kernel.g.af(g.class)).a(k.this.getContext(), 7, Og.appId, Og.videoUrl, null, null, k.this.hashCode() & 65535, bundle, k.this.xAD);
                        AppMethodBeat.o(41046);
                        return;
                    }
                    ((g) com.tencent.mm.kernel.g.af(g.class)).a(k.this.getContext(), 7, Og.appId, null, Og.videoUrl, Og.xuM, k.this.hashCode() & 65535, bundle, k.this.xAD);
                    AppMethodBeat.o(41046);
                    return;
                }
                Intent intent = new Intent();
                f fVar = new f();
                fVar.xuQ = k.this.xBt.xzV;
                int indexOf = fVar.xuQ.indexOf(Og);
                try {
                    intent.putExtra("game_video_list", fVar.toByteArray());
                    intent.putExtra("game_video_list_current_index", indexOf);
                    intent.putExtra("game_video_has_next", k.this.xBt.hasNext());
                    intent.putExtra("game_video_preview_source", p.a.FROM_PUBLISH_GALLERY);
                    intent.putExtra("game_straight_to_publish", k.this.xBd);
                    intent.putExtra("game_haowan_source_scene_id", k.this.xAD);
                    c.b(k.this.getContext(), "game", ".media.preview.GameVideoPreviewUI", intent, k.this.hashCode() & 65535);
                    AppMethodBeat.o(41046);
                } catch (IOException e2) {
                    AppMethodBeat.o(41046);
                }
            }
        });
        em(this.xBq);
        this.GQ = LayoutInflater.from(getContext()).inflate(R.layout.aoh, (ViewGroup) this, false);
        this.GQ.setVisibility(8);
        em(this.GQ);
        this.xBr = a.dUh();
        Log.d("MicroMsg.GameHaoWanGalleryView", "first enter : %b", Boolean.valueOf(this.xBr));
        if (this.xBr) {
            this.xBs = LayoutInflater.from(getContext()).inflate(R.layout.aoi, (ViewGroup) this.xBq, false);
            ((ImageView) this.xBs.findViewById(R.id.dg5)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.game.media.k.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(41047);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    k.this.xBs.setVisibility(8);
                    a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(41047);
                }
            });
            h hVar = this.xBq;
            hVar.xAE.xAJ.add(this.xBs);
            h(503, null);
        }
        this.gAy = LayoutInflater.from(getContext()).inflate(R.layout.aoj, (ViewGroup) this, false);
        this.gAy.setVisibility(8);
        em(this.gAy);
        LinkedList<e> dTZ = this.xBt.dTZ();
        if (Util.isNullOrNil(dTZ)) {
            this.gAy.setVisibility(0);
        } else {
            b(dTZ, false, true);
        }
        getDataFromNet();
        AppMethodBeat.o(41052);
    }

    private void em(View view) {
        AppMethodBeat.i(204125);
        ((ViewGroup) this.jBN.findViewById(R.id.dck)).addView(view, -1, -1);
        AppMethodBeat.o(204125);
    }

    private void dTO() {
        AppMethodBeat.i(41053);
        this.gAy.setVisibility(8);
        AppMethodBeat.o(41053);
    }

    private void bIo() {
        AppMethodBeat.i(41054);
        this.GQ.setVisibility(0);
        h(502, null);
        AppMethodBeat.o(41054);
    }

    private void dUt() {
        AppMethodBeat.i(41055);
        this.GQ.setVisibility(8);
        AppMethodBeat.o(41055);
    }

    private void b(LinkedList<e> linkedList, boolean z, boolean z2) {
        AppMethodBeat.i(41056);
        dTO();
        if (!Util.isNullOrNil(linkedList)) {
            dUt();
            if (this.xBr) {
                Log.d("MicroMsg.GameHaoWanGalleryView", "data not null, appid : %d", linkedList.get(0).appId);
                a.dUg();
            }
        } else {
            bIo();
            ((GamePublishGalleryUI) getContext()).dUs();
        }
        this.xBq.b(linkedList, z, z2);
        AppMethodBeat.o(41056);
    }

    private void getDataFromNet() {
        AppMethodBeat.i(41057);
        System.currentTimeMillis();
        this.xBt.b(new a.AbstractC1400a() {
            /* class com.tencent.mm.plugin.game.media.k.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.game.media.a.AbstractC1400a
            public final void c(final LinkedList<e> linkedList, final boolean z) {
                AppMethodBeat.i(204123);
                if (((Activity) k.this.getContext()).isFinishing()) {
                    AppMethodBeat.o(204123);
                    return;
                }
                k.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.game.media.k.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(204122);
                        k.a(k.this, linkedList, z);
                        AppMethodBeat.o(204122);
                    }
                });
                AppMethodBeat.o(204123);
            }
        });
        AppMethodBeat.o(41057);
    }

    static void dUn() {
        AppMethodBeat.i(41058);
        a.Od(1);
        AppMethodBeat.o(41058);
    }

    private void h(int i2, Map map) {
        AppMethodBeat.i(41059);
        if (map == null) {
            map = new HashMap();
        }
        com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8762, i2, 1, this.xAD, com.tencent.mm.game.report.b.a.c(7, map));
        AppMethodBeat.o(41059);
    }
}
