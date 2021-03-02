package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.model.i;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b extends d implements i.a {
    boolean AkV;
    MMHandler Aky = new MMHandler(Looper.getMainLooper());
    final int Anh = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 26);
    final int Ani = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 260);
    HashMap<Integer, View> Anj = new HashMap<>();
    i Ank = new i();
    int Anl;
    int count;
    int scene;

    public b(Context context, int i2, boolean z) {
        super(context);
        AppMethodBeat.i(63222);
        this.Ank.Akw = this;
        this.scene = i2;
        this.AkV = z;
        AppMethodBeat.o(63222);
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        return this.count;
    }

    @Override // com.tencent.mm.ui.base.d
    public final View a(View view, ViewGroup viewGroup, int i2) {
        a aVar;
        AppMethodBeat.i(63223);
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.bdv, viewGroup, false);
            aVar = new a();
            aVar.Ann = (MusicItemLayout) view.findViewById(R.id.fq5);
            aVar.Ant = (TextView) view.findViewById(R.id.fqa);
            aVar.Anv = (LyricView) view.findViewById(R.id.f5l);
            aVar.Ano = view.findViewById(R.id.iw);
            aVar.Anp = view.findViewById(R.id.ix);
            aVar.Anq = view.findViewById(R.id.iy);
            aVar.Ans = (CdnImageView) view.findViewById(R.id.iv);
            aVar.Anu = (TextView) view.findViewById(R.id.fql);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List<String> eua = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eua();
        int size = (i2 - 100000) % eua.size();
        if (size < 0) {
            size += eua.size();
        }
        Log.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", Integer.valueOf(size));
        com.tencent.mm.plugin.music.model.e.a aHW = o.euD().aHW(eua.get(size));
        this.Anj.put(Integer.valueOf(i2), view);
        aVar.b(aHW, false);
        AppMethodBeat.o(63223);
        return view;
    }

    @Override // com.tencent.mm.ui.base.d
    public final void Te(int i2) {
        AppMethodBeat.i(63224);
        this.Anj.remove(Integer.valueOf(i2));
        AppMethodBeat.o(63224);
    }

    @Override // com.tencent.mm.ui.base.d
    public final int evg() {
        AppMethodBeat.i(63225);
        int size = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eua().size();
        AppMethodBeat.o(63225);
        return size;
    }

    public final void av(final int i2, final long j2) {
        AppMethodBeat.i(63226);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.music.ui.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(63211);
                View view = b.this.Anj.get(Integer.valueOf(i2));
                if (view != null) {
                    ((a) view.getTag()).Anv.setCurrentTime(j2);
                }
                AppMethodBeat.o(63211);
            }
        });
        AppMethodBeat.o(63226);
    }

    @Override // com.tencent.mm.plugin.music.model.i.a
    public final void a(com.tencent.mm.plugin.music.model.e.a aVar, int[] iArr) {
        AppMethodBeat.i(63227);
        for (Map.Entry<Integer, View> entry : this.Anj.entrySet()) {
            a aVar2 = (a) entry.getValue().getTag();
            if (aVar2.AkC.field_musicId.equals(aVar.field_musicId)) {
                Log.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", aVar2.AkC.field_songName);
                int i2 = iArr[0];
                int i3 = iArr[1];
                aVar2.Ann.setBackgroundColor(i2);
                aVar2.Anv.setLyricColor(i3);
                aVar2.Ans.setBackgroundColor(i2);
                a.AnonymousClass1 r4 = new ShapeDrawable.ShaderFactory(i2) {
                    /* class com.tencent.mm.plugin.music.ui.b.a.AnonymousClass1 */
                    final /* synthetic */ int mkS;

                    {
                        this.mkS = r2;
                    }

                    public final Shader resize(int i2, int i3) {
                        AppMethodBeat.i(63212);
                        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) i3, new int[]{0, this.mkS}, new float[]{0.0f, 1.0f}, Shader.TileMode.REPEAT);
                        AppMethodBeat.o(63212);
                        return linearGradient;
                    }
                };
                PaintDrawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(r4);
                aVar2.Anp.setBackgroundDrawable(paintDrawable);
                a.AnonymousClass2 r42 = new ShapeDrawable.ShaderFactory((i2 & 16777215) | 1426063360) {
                    /* class com.tencent.mm.plugin.music.ui.b.a.AnonymousClass2 */
                    final /* synthetic */ int Anz;

                    {
                        this.Anz = r2;
                    }

                    public final Shader resize(int i2, int i3) {
                        AppMethodBeat.i(63213);
                        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) i3, new int[]{this.Anz, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.REPEAT);
                        AppMethodBeat.o(63213);
                        return linearGradient;
                    }
                };
                PaintDrawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(r42);
                aVar2.Anq.setBackgroundDrawable(paintDrawable2);
                aVar2.Ant.setTextColor(i3);
                aVar2.Anu.setTextColor(i3);
                ((MusicMainUI) this.context).l(aVar);
            }
        }
        AppMethodBeat.o(63227);
    }

    public class a {
        com.tencent.mm.plugin.music.model.e.a AkC;
        MusicItemLayout Ann;
        View Ano;
        View Anp;
        View Anq;
        CdnImageView Ans;
        TextView Ant;
        TextView Anu;
        LyricView Anv;
        boolean Anw;
        private Animation.AnimationListener Anx = new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.music.ui.b.a.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.Anw = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        private int mode = 1;

        public a() {
            AppMethodBeat.i(63217);
            AppMethodBeat.o(63217);
        }

        public final void b(com.tencent.mm.plugin.music.model.e.a aVar, boolean z) {
            AppMethodBeat.i(63218);
            if (aVar != null) {
                Log.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", aVar.field_songName);
                this.AkC = aVar;
                if (Util.isNullOrNil(aVar.field_songHAlbumUrl)) {
                    ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).a(aVar, b.this.AkV, true);
                }
                this.Ann.setTag(this);
                if ((!m.a(aVar) || b.this.scene == 3) && !Util.isNullOrNil(aVar.field_songSinger)) {
                    this.Anu.setText(aVar.field_songSinger);
                    this.Anu.setVisibility(0);
                } else {
                    this.Anu.setVisibility(8);
                }
                this.Ant.setText(aVar.field_songName);
                this.Ant.setTag(aVar.field_songName);
                this.Anv.setLyricObj(o.euD().a(aVar, b.this.AkV));
                if (!m.a(aVar) || b.this.AkV) {
                    this.Anv.setCurrentTime(1);
                }
                evi();
                b.this.Ank.a(aVar, this.Ans, b.this.context, z, b.this.AkV);
            }
            AppMethodBeat.o(63218);
        }

        public final boolean evh() {
            return this.mode == 2;
        }

        public final void evi() {
            AppMethodBeat.i(63219);
            if (this.Anw || this.mode == 1) {
                AppMethodBeat.o(63219);
                return;
            }
            com.tencent.mm.plugin.music.model.d.e.hu(3, b.this.scene);
            if (b.this.Anl == 0) {
                b.this.Anl = this.Ano.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.this.Anl);
                layoutParams.weight = 0.0f;
                this.Ano.setLayoutParams(layoutParams);
            }
            com.tencent.mm.plugin.music.model.d.e.Aly = true;
            com.tencent.mm.plugin.music.model.d.e.euL();
            this.mode = 1;
            this.Anw = true;
            C1540a aVar = new C1540a(this.Anv, b.this.Anh);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.Anx);
            this.Anv.startAnimation(aVar);
            AppMethodBeat.o(63219);
        }

        public final void evj() {
            AppMethodBeat.i(63220);
            if (this.Anw || this.mode == 2) {
                AppMethodBeat.o(63220);
                return;
            }
            com.tencent.mm.plugin.music.model.d.e.hu(2, b.this.scene);
            if (b.this.Anl == 0) {
                b.this.Anl = this.Ano.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.this.Anl);
                layoutParams.weight = 0.0f;
                this.Ano.setLayoutParams(layoutParams);
            }
            com.tencent.mm.plugin.music.model.d.e.Aly = true;
            com.tencent.mm.plugin.music.model.d.e.euL();
            this.mode = 2;
            this.Anw = true;
            C1540a aVar = new C1540a(this.Anv, b.this.Ani);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.Anx);
            this.Anv.startAnimation(aVar);
            AppMethodBeat.o(63220);
        }

        public final void evk() {
            AppMethodBeat.i(63221);
            com.tencent.mm.plugin.music.model.d.e.Aly = true;
            com.tencent.mm.plugin.music.model.d.e.euL();
            if (this.mode == 1) {
                evj();
                AppMethodBeat.o(63221);
                return;
            }
            evi();
            AppMethodBeat.o(63221);
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$a  reason: collision with other inner class name */
        public class C1540a extends Animation {
            final int AnA;
            final int targetHeight;
            View view;

            public C1540a(View view2, int i2) {
                AppMethodBeat.i(63214);
                this.view = view2;
                this.targetHeight = i2;
                this.AnA = view2.getHeight();
                AppMethodBeat.o(63214);
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                AppMethodBeat.i(63215);
                this.view.getLayoutParams().height = (int) (((float) this.AnA) + (((float) (this.targetHeight - this.AnA)) * f2));
                this.view.requestLayout();
                AppMethodBeat.o(63215);
            }

            public final void initialize(int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(63216);
                super.initialize(i2, i3, i4, i5);
                AppMethodBeat.o(63216);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        }
    }
}
