package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.b.b.f;
import com.tencent.mm.plugin.game.media.GameVideoTagContainer;
import com.tencent.mm.plugin.game.media.a;
import com.tencent.mm.plugin.game.media.p;
import com.tencent.mm.plugin.game.media.preview.GameVideoView;
import com.tencent.mm.plugin.game.media.preview.c;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoPreviewUI extends MMActivity {
    private Context context;
    RecyclerView.l guX = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass2 */

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(41235);
            b bVar = new b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                int ks = ((LinearLayoutManager) recyclerView.getLayoutManager()).ks();
                Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "scroll position:%d", Integer.valueOf(ks));
                GameVideoPreviewUI.this.xDc = ks;
                GameVideoPreviewUI.a(GameVideoPreviewUI.this, ((a) recyclerView.getAdapter()).Og(ks));
                GameVideoPreviewUI.a(GameVideoPreviewUI.this, ks);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(41235);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(41236);
            b bVar = new b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$10", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(41236);
        }
    };
    private TextView gxs;
    private View hSw;
    private RecyclerView hak;
    private int source = 0;
    private TextView titleTv;
    private int xAD = 0;
    private GameVideoTagContainer xAR;
    private boolean xBd = false;
    private a xCY;
    private View xCZ;
    private View xDa;
    private View xDb;
    private int xDc = 0;
    private c xDd;
    private boolean xDe = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameVideoPreviewUI() {
        AppMethodBeat.i(41264);
        AppMethodBeat.o(41264);
    }

    static /* synthetic */ Map b(e eVar) {
        AppMethodBeat.i(204146);
        Map a2 = a(eVar);
        AppMethodBeat.o(204146);
        return a2;
    }

    static /* synthetic */ void h(GameVideoPreviewUI gameVideoPreviewUI) {
        AppMethodBeat.i(204144);
        gameVideoPreviewUI.exit();
        AppMethodBeat.o(204144);
    }

    static /* synthetic */ int i(GameVideoPreviewUI gameVideoPreviewUI) {
        AppMethodBeat.i(204145);
        int dUE = gameVideoPreviewUI.dUE();
        AppMethodBeat.o(204145);
        return dUE;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41265);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        d.rb(true);
        getWindow().setFormat(-3);
        this.context = this;
        this.titleTv = (TextView) findViewById(R.id.ir3);
        this.gxs = (TextView) findViewById(R.id.fti);
        this.xAR = (GameVideoTagContainer) findViewById(R.id.j6l);
        this.xCZ = findViewById(R.id.b4m);
        this.xDa = findViewById(R.id.hpl);
        this.xDb = findViewById(R.id.b_4);
        this.hSw = findViewById(R.id.epy);
        this.xDd = new c(this.context, this.hSw);
        this.hak = (RecyclerView) findViewById(R.id.dj4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        this.hak.setLayoutManager(linearLayoutManager);
        new ak().f(this.hak);
        this.hak.a(this.guX);
        this.xBd = getIntent().getBooleanExtra("game_straight_to_publish", false);
        this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("game_video_list");
        this.xDc = getIntent().getIntExtra("game_video_list_current_index", 0);
        final LinkedList linkedList = new LinkedList();
        if (!Util.isNullOrNil(byteArrayExtra)) {
            f fVar = new f();
            try {
                fVar.parseFrom(byteArrayExtra);
            } catch (IOException e2) {
            }
            linkedList.addAll(fVar.xuQ);
        }
        this.hak.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(41234);
                GameVideoPreviewUI.this.hak.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                GameVideoPreviewUI.this.xCY = new a();
                GameVideoPreviewUI.this.hak.setAdapter(GameVideoPreviewUI.this.xCY);
                GameVideoPreviewUI.this.xCY.dd(linkedList);
                GameVideoPreviewUI.a(GameVideoPreviewUI.this, ((a) GameVideoPreviewUI.this.hak.getAdapter()).Og(GameVideoPreviewUI.this.xDc));
                RecyclerView recyclerView = GameVideoPreviewUI.this.hak;
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(GameVideoPreviewUI.this.xDc, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$1", "onGlobalLayout", "()V", "Undefined", "scrollToPosition", "(I)V");
                GameVideoPreviewUI.a(GameVideoPreviewUI.this, GameVideoPreviewUI.this.xDc);
                AppMethodBeat.o(41234);
            }
        });
        findViewById(R.id.b_4).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(41238);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e Og = GameVideoPreviewUI.this.xCY.Og(GameVideoPreviewUI.this.xDc);
                if (Og != null) {
                    Bundle b2 = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.this.xDc);
                    b2.putBoolean("game_straight_to_publish", GameVideoPreviewUI.this.xBd);
                    if (s.YS(Og.videoPath)) {
                        ((g) com.tencent.mm.kernel.g.af(g.class)).a(GameVideoPreviewUI.this.context, GameVideoPreviewUI.this.source, Og.appId, Og.videoPath, null, null, 19722, b2, GameVideoPreviewUI.this.xAD);
                    } else {
                        ((g) com.tencent.mm.kernel.g.af(g.class)).a(GameVideoPreviewUI.this.context, GameVideoPreviewUI.this.source, Og.appId, null, Og.videoUrl, Og.xuM, 19722, b2, GameVideoPreviewUI.this.xAD);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41238);
            }
        });
        this.xCZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(41240);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.this.context, 8768, 0, 2, GameVideoPreviewUI.this.xAD, com.tencent.mm.game.report.b.a.c(GameVideoPreviewUI.this.source, null));
                View inflate = LayoutInflater.from(GameVideoPreviewUI.this.getContext()).inflate(R.layout.apm, (ViewGroup) null, false);
                final android.support.design.widget.a aVar = new android.support.design.widget.a(GameVideoPreviewUI.this.getContext());
                aVar.setContentView(inflate);
                ((Button) inflate.findViewById(R.id.dgn)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass5.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(41239);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        aVar.cancel();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(41239);
                    }
                });
                aVar.show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41240);
            }
        });
        this.xDa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(41241);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e Og = GameVideoPreviewUI.this.xCY.Og(GameVideoPreviewUI.this.xDc);
                if (Og != null) {
                    GameVideoPreviewUI.b(GameVideoPreviewUI.this, Og);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41241);
            }
        });
        findViewById(R.id.dj2).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(41242);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GameVideoPreviewUI.h(GameVideoPreviewUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41242);
            }
        });
        if (((p.a) getIntent().getSerializableExtra("game_video_preview_source")) == p.a.FROM_PUBLISH_GALLERY) {
            this.source = 7;
            this.xDa.setVisibility(8);
            this.xDb.setVisibility(0);
        } else {
            this.source = 6;
            this.xDa.setVisibility(0);
            this.xDb.setVisibility(8);
        }
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 1, this.xAD, com.tencent.mm.game.report.b.a.c(this.source, null));
        AppMethodBeat.o(41265);
    }

    private void exit() {
        AppMethodBeat.i(41266);
        com.tencent.mm.game.report.b.a.a(this, 8768, 0, 4, this.xAD, com.tencent.mm.game.report.b.a.c(this.source, null));
        finish();
        AppMethodBeat.o(41266);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(41267);
        super.onResume();
        GameVideoView Oj = Oj(this.xDc);
        if (Oj != null) {
            Oj.onUIResume();
        }
        com.tencent.mm.plugin.ball.f.f.e(true, true, true);
        AppMethodBeat.o(41267);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(41268);
        super.onPause();
        GameVideoView Oj = Oj(this.xDc);
        if (Oj != null) {
            Oj.onUIPause();
        }
        com.tencent.mm.plugin.ball.f.f.e(false, true, true);
        AppMethodBeat.o(41268);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(41269);
        if (this.hSw.getVisibility() == 0) {
            this.hSw.setVisibility(8);
            this.xDd.dUK();
            AppMethodBeat.o(41269);
            return;
        }
        super.onBackPressed();
        exit();
        AppMethodBeat.o(41269);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(41270);
        super.onDestroy();
        this.hak.b(this.guX);
        GameVideoView Oj = Oj(this.xDc);
        if (Oj != null) {
            Oj.onUIDestroy();
        }
        this.xDd.dUK();
        com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(41245);
                GameVideoView.dUH();
                AppMethodBeat.o(41245);
            }
        });
        AppMethodBeat.o(41270);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ImageView imageView;
        AppMethodBeat.i(41271);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 19722) {
            if (intent == null || i3 != -1) {
                GameVideoView Oj = Oj(this.xDc);
                if (Oj != null) {
                    if (Oj.xDC != null) {
                        Oj.xDC.edF = true;
                    }
                    RecyclerView.v ch = this.hak.ch(this.xDc);
                    if (ch instanceof a.C1401a) {
                        imageView = ((a.C1401a) ch).xDr;
                    } else {
                        imageView = null;
                    }
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                }
            } else {
                e Og = this.xCY.Og(this.xDc);
                if (Og != null) {
                    intent.putExtra("key_game_video_appid", Og.appId);
                    intent.putExtra("key_game_video_appname", Og.appName);
                }
                setResult(i3, intent);
                finish();
                AppMethodBeat.o(41271);
                return;
            }
        }
        AppMethodBeat.o(41271);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.at2;
    }

    private int dUE() {
        int i2 = this.xDc + 1;
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    private GameVideoView Oj(int i2) {
        AppMethodBeat.i(41272);
        RecyclerView.v ch = this.hak.ch(i2);
        if (ch instanceof a.C1401a) {
            GameVideoView gameVideoView = ((a.C1401a) ch).xDq;
            AppMethodBeat.o(41272);
            return gameVideoView;
        }
        AppMethodBeat.o(41272);
        return null;
    }

    private static Map a(e eVar) {
        AppMethodBeat.i(41273);
        HashMap hashMap = new HashMap();
        if (eVar == null) {
            AppMethodBeat.o(41273);
        } else {
            hashMap.put("videoid", eVar.psI);
            hashMap.put("origtime", Long.valueOf(eVar.duration));
            hashMap.put("origsize", Long.valueOf(eVar.size));
            AppMethodBeat.o(41273);
        }
        return hashMap;
    }

    public class a extends RecyclerView.a<C1401a> {
        private ArrayList<e> xDj = new ArrayList<>();

        public a() {
            AppMethodBeat.i(41255);
            AppMethodBeat.o(41255);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C1401a aVar) {
            AppMethodBeat.i(41261);
            C1401a aVar2 = aVar;
            super.a(aVar2);
            if (aVar2 != null) {
                Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "onViewRecycled");
                aVar2.xDq.stop();
            }
            AppMethodBeat.o(41261);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C1401a aVar, int i2) {
            AppMethodBeat.i(41262);
            final C1401a aVar2 = aVar;
            Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "onBindViewHolder scroll position:%d", Integer.valueOf(i2));
            final e eVar = this.xDj.get(i2);
            aVar2.qXq.setTag(eVar);
            if (eVar != null) {
                if (eVar.dLQ) {
                    com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(41248);
                            final Bitmap PF = d.PF(eVar.videoUrl);
                            if (PF != null) {
                                aVar2.xDr.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(41247);
                                        aVar2.xDs.setVisibility(8);
                                        aVar2.xDr.setImageBitmap(PF);
                                        Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "load thumb:%s", eVar.videoUrl);
                                        AppMethodBeat.o(41247);
                                    }
                                });
                            }
                            AppMethodBeat.o(41248);
                        }
                    });
                    AppMethodBeat.o(41262);
                    return;
                }
                c.a aVar3 = new c.a();
                aVar3.prefixPath = p.xCG;
                aVar3.jbf = true;
                q.bcV().a(eVar.xuM, aVar2.xDr, aVar3.bdv(), new h() {
                    /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass3 */

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view) {
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        return null;
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        AppMethodBeat.i(41250);
                        if (!(bVar == null || bVar.bitmap == null)) {
                            Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "load thumb:%s, from:%d", str, Integer.valueOf(bVar.from));
                            aVar2.xDs.post(new Runnable() {
                                /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(41249);
                                    aVar2.xDs.setVisibility(8);
                                    AppMethodBeat.o(41249);
                                }
                            });
                        }
                        AppMethodBeat.o(41250);
                    }
                });
            }
            AppMethodBeat.o(41262);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void k(C1401a aVar) {
            e eVar;
            AppMethodBeat.i(41260);
            final C1401a aVar2 = aVar;
            super.k(aVar2);
            Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "onViewAttachedToWindow");
            if (!(aVar2 == null || (eVar = (e) aVar2.qXq.getTag()) == null)) {
                aVar2.mEz.setVisibility(0);
                aVar2.xDq.c(false, eVar.videoUrl, (int) (eVar.duration / 1000));
                eVar.videoPath = aVar2.xDq.getLocalPath();
                aVar2.xDq.setVideoPreparedListener(new GameVideoView.a() {
                    /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.game.media.preview.GameVideoView.a
                    public final void tf() {
                        AppMethodBeat.i(41252);
                        aVar2.xDr.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(41251);
                                aVar2.mEz.setVisibility(8);
                                aVar2.xDr.setVisibility(8);
                                AppMethodBeat.o(41251);
                            }
                        }, 200);
                        AppMethodBeat.o(41252);
                    }
                });
                aVar2.xDq.start();
            }
            AppMethodBeat.o(41260);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void l(C1401a aVar) {
            AppMethodBeat.i(41259);
            final C1401a aVar2 = aVar;
            super.l(aVar2);
            Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "onViewDetachedFromWindow");
            if (aVar2 != null) {
                aVar2.xDq.stop();
                aVar2.xDr.post(new Runnable() {
                    /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(41253);
                        aVar2.xDr.setVisibility(0);
                        AppMethodBeat.o(41253);
                    }
                });
            }
            AppMethodBeat.o(41259);
        }

        public final void dd(List list) {
            AppMethodBeat.i(41256);
            if (Util.isNullOrNil(list)) {
                AppMethodBeat.o(41256);
                return;
            }
            this.xDj.addAll(list);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(41246);
                    a.this.atj.notifyChanged();
                    AppMethodBeat.o(41246);
                }
            }, 1000);
            AppMethodBeat.o(41256);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(259582);
            int size = this.xDj.size();
            AppMethodBeat.o(259582);
            return size;
        }

        /* renamed from: com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI$a$a  reason: collision with other inner class name */
        public class C1401a extends RecyclerView.v {
            public ProgressBar mEz;
            public View qXq;
            public GameVideoView xDq;
            public ImageView xDr;
            public ImageView xDs;

            public C1401a(View view) {
                super(view);
                AppMethodBeat.i(41254);
                this.qXq = view;
                this.xDq = (GameVideoView) view.findViewById(R.id.j6y);
                this.xDq.setVideoFooterView(new b(GameVideoPreviewUI.this.context));
                this.xDr = (ImageView) view.findViewById(R.id.ima);
                this.xDs = (ImageView) view.findViewById(R.id.j4c);
                this.mEz = (ProgressBar) view.findViewById(R.id.j59);
                AppMethodBeat.o(41254);
            }
        }

        public final e Og(int i2) {
            AppMethodBeat.i(41257);
            if (i2 >= this.xDj.size() || i2 < 0) {
                AppMethodBeat.o(41257);
                return null;
            }
            e eVar = this.xDj.get(i2);
            AppMethodBeat.o(41257);
            return eVar;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C1401a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(41263);
            C1401a aVar = new C1401a(LayoutInflater.from(GameVideoPreviewUI.this.context).inflate(R.layout.at4, viewGroup, false));
            AppMethodBeat.o(41263);
            return aVar;
        }
    }

    static /* synthetic */ void a(GameVideoPreviewUI gameVideoPreviewUI, e eVar) {
        AppMethodBeat.i(41274);
        if (eVar != null) {
            gameVideoPreviewUI.titleTv.setText(eVar.title);
            gameVideoPreviewUI.gxs.setText(eVar.appName);
            if (eVar.dLQ) {
                gameVideoPreviewUI.xAR.setVisibility(8);
                gameVideoPreviewUI.xCZ.setVisibility(8);
            } else {
                gameVideoPreviewUI.xAR.setData(eVar.xuO);
                gameVideoPreviewUI.xCZ.setVisibility(0);
            }
            com.tencent.mm.game.report.b.a.a(gameVideoPreviewUI, 8768, gameVideoPreviewUI.dUE(), 1, eVar.appId, gameVideoPreviewUI.xAD, com.tencent.mm.game.report.b.a.c(gameVideoPreviewUI.source, a(eVar)));
        }
        AppMethodBeat.o(41274);
    }

    static /* synthetic */ void a(GameVideoPreviewUI gameVideoPreviewUI, int i2) {
        AppMethodBeat.i(41275);
        if (i2 >= gameVideoPreviewUI.xCY.getItemCount() - 2 && gameVideoPreviewUI.xDe) {
            Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "pull next page");
            com.tencent.mm.plugin.game.media.a.a(new a.AbstractC1400a() {
                /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.game.media.a.AbstractC1400a
                public final void c(LinkedList<e> linkedList, boolean z) {
                    AppMethodBeat.i(41237);
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(Util.isNullOrNil(linkedList) ? 0 : linkedList.size());
                    objArr[1] = Boolean.valueOf(z);
                    Log.i("MicroMsg.Haowan.GameVideoPreviewUI", "data size:%d, hasNext:%b", objArr);
                    if (!Util.isNullOrNil(linkedList)) {
                        GameVideoPreviewUI.this.xCY.dd(linkedList);
                    }
                    GameVideoPreviewUI.this.xDe = z;
                    AppMethodBeat.o(41237);
                }
            });
        }
        AppMethodBeat.o(41275);
    }

    static /* synthetic */ Bundle b(GameVideoPreviewUI gameVideoPreviewUI, int i2) {
        AppMethodBeat.i(41276);
        Bundle bundle = new Bundle();
        GameVideoView Oj = gameVideoPreviewUI.Oj(i2);
        if (Oj != null) {
            bundle.putString("key_video_cache_path", Oj.getFilePath());
            bundle.putString("key_video_media_id", Oj.getMediaId());
        }
        AppMethodBeat.o(41276);
        return bundle;
    }

    static /* synthetic */ void b(GameVideoPreviewUI gameVideoPreviewUI, final e eVar) {
        AppMethodBeat.i(204143);
        com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e(gameVideoPreviewUI.context, 1, true);
        eVar2.HLX = new o.f() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(41243);
                mVar.a(2, GameVideoPreviewUI.this.context.getString(R.string.dsn), GameVideoPreviewUI.this.context.getString(R.string.dsm), R.raw.game_icon_share_wechat);
                AppMethodBeat.o(41243);
            }
        };
        eVar2.HLY = new o.g() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(41244);
                if (menuItem.getItemId() == 0) {
                    com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.this.context, 8768, GameVideoPreviewUI.i(GameVideoPreviewUI.this), 15, GameVideoPreviewUI.this.xAD, com.tencent.mm.game.report.b.a.c(GameVideoPreviewUI.this.source, GameVideoPreviewUI.b(eVar)));
                    c cVar = GameVideoPreviewUI.this.xDd;
                    cVar.a(eVar, new c.a() {
                        /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass1 */
                        final /* synthetic */ int val$requestCode = 19081;

                        @Override // com.tencent.mm.plugin.game.media.preview.c.a
                        public final void a(b bVar) {
                            AppMethodBeat.i(41330);
                            c.a(c.this, bVar, this.val$requestCode);
                            AppMethodBeat.o(41330);
                        }
                    });
                    AppMethodBeat.o(41244);
                } else if (menuItem.getItemId() == 1) {
                    com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.this.context, 8768, GameVideoPreviewUI.i(GameVideoPreviewUI.this), 14, GameVideoPreviewUI.this.xAD, com.tencent.mm.game.report.b.a.c(GameVideoPreviewUI.this.source, GameVideoPreviewUI.b(eVar)));
                    c cVar2 = GameVideoPreviewUI.this.xDd;
                    cVar2.a(eVar, new c.a() {
                        /* class com.tencent.mm.plugin.game.media.preview.c.AnonymousClass2 */
                        final /* synthetic */ int val$requestCode = 19081;

                        @Override // com.tencent.mm.plugin.game.media.preview.c.a
                        public final void a(b bVar) {
                            AppMethodBeat.i(41331);
                            c.b(c.this, bVar, this.val$requestCode);
                            AppMethodBeat.o(41331);
                        }
                    });
                    AppMethodBeat.o(41244);
                } else {
                    if (menuItem.getItemId() == 2) {
                        com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.this.context, 8768, GameVideoPreviewUI.i(GameVideoPreviewUI.this), 88, GameVideoPreviewUI.this.xAD, com.tencent.mm.game.report.b.a.c(GameVideoPreviewUI.this.source, GameVideoPreviewUI.b(eVar)));
                        Bundle b2 = GameVideoPreviewUI.b(GameVideoPreviewUI.this, GameVideoPreviewUI.this.xDc);
                        b2.putBoolean("game_straight_to_publish", GameVideoPreviewUI.this.xBd);
                        if (s.YS(eVar.videoPath)) {
                            ((g) com.tencent.mm.kernel.g.af(g.class)).a(GameVideoPreviewUI.this.context, GameVideoPreviewUI.this.source, eVar.appId, eVar.videoPath, null, null, 19722, b2, GameVideoPreviewUI.this.xAD);
                            AppMethodBeat.o(41244);
                            return;
                        }
                        ((g) com.tencent.mm.kernel.g.af(g.class)).a(GameVideoPreviewUI.this.context, GameVideoPreviewUI.this.source, eVar.appId, null, eVar.videoUrl, eVar.xuM, 19722, b2, GameVideoPreviewUI.this.xAD);
                    }
                    AppMethodBeat.o(41244);
                }
            }
        };
        eVar2.PGl = new e.b() {
            /* class com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.AnonymousClass10 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
            }
        };
        eVar2.dGm();
        AppMethodBeat.o(204143);
    }
}
