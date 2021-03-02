package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;

@i
public class FTSChattingConvUI extends FTSBaseUI implements View.OnClickListener {
    private as contact;
    private String wWS;
    private View xbj;
    private g xbk;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111891);
        super.onCreate(bundle);
        initView();
        c fTSImageLoader = ((n) g.ah(n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.dOn();
        }
        AppMethodBeat.o(111891);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(111892);
        super.initView();
        this.xbj = findViewById(R.id.hew);
        this.xbj.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dk8);
        getContext();
        recyclerView.setLayoutManager(new GridLayoutManager(3));
        recyclerView.a(new RecyclerView.h() {
            /* class com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.AnonymousClass1 */
            final int offset = ((int) FTSChattingConvUI.this.getResources().getDimension(R.dimen.k));
            Paint paint = new Paint(1);

            {
                AppMethodBeat.i(111883);
                AppMethodBeat.o(111883);
            }

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(111884);
                super.a(rect, view, recyclerView, sVar);
                rect.set(this.offset, this.offset, this.offset, this.offset);
                AppMethodBeat.o(111884);
            }

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(111885);
                super.a(canvas, recyclerView, sVar);
                this.paint.setColor(-2434342);
                this.paint.setStrokeWidth(1.0f);
                this.paint.setStyle(Paint.Style.FILL);
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (i2 == 1 || i2 == 4) {
                        canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.paint);
                        canvas.drawLine((float) (childAt.getRight() + this.offset), (float) childAt.getTop(), (float) (childAt.getRight() + this.offset), (float) childAt.getBottom(), this.paint);
                    } else if (i2 == 7) {
                        canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.paint);
                    }
                }
                AppMethodBeat.o(111885);
            }
        });
        recyclerView.setAdapter(new a());
        AppMethodBeat.o(111892);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111893);
        super.onResume();
        this.xbj.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.FTSChattingConvUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(111886);
                FTSChattingConvUI.this.xaN.getFtsEditText().awD();
                FTSChattingConvUI.this.xaN.getFtsEditText().awC();
                AppMethodBeat.o(111886);
            }
        }, 128);
        AppMethodBeat.o(111893);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPh() {
        AppMethodBeat.i(111894);
        this.wWS = getIntent().getStringExtra("detail_username");
        this.contact = ((l) g.af(l.class)).aSN().Kn(this.wWS);
        Log.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", this.wWS);
        AppMethodBeat.o(111894);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final d a(e eVar) {
        AppMethodBeat.i(111895);
        if (this.xbk == null) {
            this.xbk = new g(eVar, this.wWS);
        }
        g gVar = this.xbk;
        AppMethodBeat.o(111895);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.fts.ui.e, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        AppMethodBeat.i(111896);
        if (ab.Iw(this.wWS)) {
            ak(this.query, 10, aVar.position + 1);
            AppMethodBeat.o(111896);
            return;
        }
        ak(this.query, 11, aVar.position + 1);
        AppMethodBeat.o(111896);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPm() {
        AppMethodBeat.i(111897);
        super.dPm();
        this.xbj.setVisibility(0);
        AppMethodBeat.o(111897);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPk() {
        AppMethodBeat.i(111898);
        super.dPk();
        this.xbj.setVisibility(8);
        AppMethodBeat.o(111898);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPl() {
        AppMethodBeat.i(111899);
        super.dPl();
        this.xbj.setVisibility(8);
        AppMethodBeat.o(111899);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void dPj() {
        AppMethodBeat.i(111900);
        super.dPj();
        this.xbj.setVisibility(8);
        AppMethodBeat.o(111900);
    }

    private void pl(int i2) {
        AppMethodBeat.i(111901);
        if (ab.Iw(this.wWS)) {
            ah Ke = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.wWS);
            if (Ke.bax() != null) {
                if (i2 == 0) {
                    h.INSTANCE.a(14569, 0, 0, 1, 0, 0, 0, 0, Integer.valueOf(Ke.bax().size()), 1);
                    AppMethodBeat.o(111901);
                    return;
                }
                h.INSTANCE.a(14569, 0, 0, 0, 1, 0, 0, 0, Integer.valueOf(Ke.bax().size()), 1);
            }
            AppMethodBeat.o(111901);
        } else if (i2 == 0) {
            h.INSTANCE.a(14569, 0, 0, 1, 0, 0, 0, 0, 0, 0);
            AppMethodBeat.o(111901);
        } else {
            h.INSTANCE.a(14569, 0, 0, 0, 1, 0, 0, 0, 0, 0);
            AppMethodBeat.o(111901);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public final void ayM(String str) {
        int i2 = 1;
        AppMethodBeat.i(111902);
        super.ayM(str);
        boolean Iw = ab.Iw(this.wWS);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[9];
        objArr[0] = 0;
        objArr[1] = 1;
        objArr[2] = 0;
        objArr[3] = 0;
        objArr[4] = 0;
        objArr[5] = 0;
        objArr[6] = 0;
        objArr[7] = 0;
        if (!Iw) {
            i2 = 0;
        }
        objArr[8] = Integer.valueOf(i2);
        hVar.a(14569, objArr);
        AppMethodBeat.o(111902);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.an3;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.fts.ui.FTSBaseUI
    public void onDestroy() {
        AppMethodBeat.i(111903);
        super.onDestroy();
        this.xbk.finish();
        c fTSImageLoader = ((n) g.ah(n.class)).getFTSImageLoader();
        if (fTSImageLoader != null) {
            fTSImageLoader.dOl();
        }
        AppMethodBeat.o(111903);
    }

    public void onClick(View view) {
        Bundle bundle;
        Bundle bundle2 = null;
        AppMethodBeat.i(111904);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (!(view instanceof TextView)) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(111904);
            return;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        if (!ab.Iw(this.wWS)) {
            intValue++;
        }
        if (intValue == 0) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
            Intent intent = new Intent();
            intent.putExtra("from_scene", 1);
            intent.putExtra("RoomInfo_Id", this.wWS);
            intent.putExtra("title", getResources().getString(R.string.gfe));
            com.tencent.mm.br.c.f(this, "com.tencent.mm.chatroom.ui.SeeMemberRecordUI", intent);
        } else if (intValue == 1) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
            Intent intent2 = new Intent();
            intent2.putExtra("detail_username", this.wWS);
            com.tencent.mm.br.c.f(this, "com.tencent.mm.chatroom.ui.SelectDateUI", intent2);
            pl(0);
        } else if (intValue == 2) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
            Intent intent3 = new Intent();
            intent3.putExtra("kintent_talker", this.wWS);
            intent3.putExtra("key_media_type", 1);
            com.tencent.mm.br.c.f(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent3);
            pl(1);
        } else if (intValue == 3) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
            Intent intent4 = new Intent();
            intent4.putExtra("kintent_talker", this.wWS);
            intent4.putExtra("key_media_type", 2);
            if (Build.VERSION.SDK_INT < 21 || ao.isDarkMode()) {
                bundle = null;
            } else {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent4, bundle);
        } else if (intValue == 4) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
            Intent intent5 = new Intent();
            intent5.putExtra("kintent_talker", this.wWS);
            intent5.putExtra("key_media_type", 3);
            if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                bundle2 = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent5, bundle2);
        } else if (intValue == 5) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
            Intent intent6 = new Intent();
            intent6.putExtra("kintent_talker", this.wWS);
            intent6.putExtra("key_media_type", 4);
            if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                bundle2 = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent6, bundle2);
        } else if (intValue == 6) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
            Intent intent7 = new Intent();
            intent7.putExtra("kintent_talker", this.wWS);
            intent7.putExtra("key_media_type", 5);
            if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                bundle2 = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent7, bundle2);
        } else if (intValue == 7) {
            Log.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeAppBrandHistory");
            Intent intent8 = new Intent();
            intent8.putExtra("kintent_talker", this.wWS);
            intent8.putExtra("key_media_type", 6);
            if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                bundle2 = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            com.tencent.mm.br.c.c(this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent8, bundle2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSChattingConvUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(111904);
    }

    /* access modifiers changed from: package-private */
    public class a extends RecyclerView.a<b> {
        String[] xbm;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(b bVar, int i2) {
            AppMethodBeat.i(111888);
            b bVar2 = bVar;
            bVar2.vr.setTag(Integer.valueOf(i2));
            bVar2.vr.setText(this.xbm[i2]);
            AppMethodBeat.o(111888);
        }

        a() {
            AppMethodBeat.i(111887);
            if (!ab.Iw(FTSChattingConvUI.this.wWS)) {
                this.xbm = new String[7];
                this.xbm[0] = FTSChattingConvUI.this.getResources().getString(R.string.gfi);
                this.xbm[1] = FTSChattingConvUI.this.getResources().getString(R.string.gfk);
                this.xbm[2] = FTSChattingConvUI.this.getResources().getString(R.string.gfj);
                this.xbm[3] = FTSChattingConvUI.this.getResources().getString(R.string.gfo);
                this.xbm[4] = FTSChattingConvUI.this.getResources().getString(R.string.gfm);
                this.xbm[5] = FTSChattingConvUI.this.getResources().getString(R.string.gfn);
                this.xbm[6] = FTSChattingConvUI.this.getResources().getString(R.string.gfh);
                AppMethodBeat.o(111887);
                return;
            }
            this.xbm = new String[8];
            this.xbm[0] = FTSChattingConvUI.this.getResources().getString(R.string.gfl);
            this.xbm[1] = FTSChattingConvUI.this.getResources().getString(R.string.gfi);
            this.xbm[2] = FTSChattingConvUI.this.getResources().getString(R.string.gfk);
            this.xbm[3] = FTSChattingConvUI.this.getResources().getString(R.string.gfj);
            this.xbm[4] = FTSChattingConvUI.this.getResources().getString(R.string.gfo);
            this.xbm[5] = FTSChattingConvUI.this.getResources().getString(R.string.gfm);
            this.xbm[6] = FTSChattingConvUI.this.getResources().getString(R.string.gfn);
            this.xbm[7] = FTSChattingConvUI.this.getResources().getString(R.string.gfh);
            AppMethodBeat.o(111887);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            return this.xbm.length;
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(111889);
            b bVar = new b(LayoutInflater.from(FTSChattingConvUI.this.getContext()).inflate(R.layout.anc, (ViewGroup) null));
            AppMethodBeat.o(111889);
            return bVar;
        }
    }

    class b extends RecyclerView.v {
        TextView vr;

        public b(View view) {
            super(view);
            AppMethodBeat.i(111890);
            this.vr = (TextView) view.findViewById(R.id.ipm);
            this.vr.setOnClickListener(FTSChattingConvUI.this);
            AppMethodBeat.o(111890);
        }
    }

    private static void ak(String str, int i2, int i3) {
        AppMethodBeat.i(111905);
        String format = String.format("%s,%d,%d,%d,%d", str, Integer.valueOf(i2), 5, Integer.valueOf(i3), 0);
        Log.v("MicroMsg.FTS.FTSChattingConvUI", "reportClick: %s", format);
        h.INSTANCE.kvStat(13234, format);
        AppMethodBeat.o(111905);
    }
}
