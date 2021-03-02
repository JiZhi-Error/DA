package com.tencent.mm.plugin.recordvideo.ui.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView;
import com.tencent.mm.plugin.recordvideo.ui.editor.MusicLrcView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

public final class a extends RecyclerView.a<C1655a> {
    public static final b BZW = new b((byte) 0);
    private static final String TAG = TAG;
    public final ArrayList<AudioCacheInfo> BZO = new ArrayList<>();
    public String BZP;
    private int BZQ = R.drawable.fp;
    private int BZR = R.raw.finder_bgm_gif_first_page;
    private int BZS = R.color.a_a;
    private int BZT = R.color.a_h;
    private int BZU = R.color.a_c;
    private v BZV;
    public m<? super Integer, ? super AudioCacheInfo, x> rsD;
    public int va = -1;

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(75892);
        AppMethodBeat.o(75892);
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [android.support.v7.widget.RecyclerView$v, com.tencent.mm.plugin.recordvideo.ui.a.a$a] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C1655a a(ViewGroup viewGroup, int i2) {
        RecyclerView.v vVar;
        AppMethodBeat.i(75890);
        p.h(viewGroup, "parent");
        AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
        if (i2 == AudioCacheInfo.BPi) {
            View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.c0g, viewGroup, false);
            p.g(inflate, "MMLayoutInflater.getInfl…_entrance, parent, false)");
            vVar = (C1655a) new e(this, inflate);
        } else {
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            if (i2 == AudioCacheInfo.BPj) {
                View inflate2 = aa.jQ(viewGroup.getContext()).inflate(R.layout.c0i, viewGroup, false);
                p.g(inflate2, "MMLayoutInflater.getInfl…ch_result, parent, false)");
                vVar = (C1655a) new g(this, inflate2);
            } else {
                AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
                if (i2 == AudioCacheInfo.BPk) {
                    View inflate3 = aa.jQ(viewGroup.getContext()).inflate(R.layout.c0f, viewGroup, false);
                    p.g(inflate3, "MMLayoutInflater.getInfl…o_loading, parent, false)");
                    vVar = (C1655a) new c(this, inflate3);
                } else {
                    AudioCacheInfo.a aVar4 = AudioCacheInfo.BPo;
                    if (i2 == AudioCacheInfo.BPl) {
                        View inflate4 = aa.jQ(viewGroup.getContext()).inflate(R.layout.c0h, viewGroup, false);
                        p.g(inflate4, "MMLayoutInflater.getInfl…h_loading, parent, false)");
                        vVar = (C1655a) new f(this, inflate4);
                    } else {
                        View inflate5 = aa.jQ(viewGroup.getContext()).inflate(R.layout.c0e, viewGroup, false);
                        p.g(inflate5, "MMLayoutInflater.getInfl…tem_audio, parent, false)");
                        vVar = (C1655a) new d(this, inflate5);
                    }
                }
            }
        }
        RecyclerView.v vVar2 = vVar;
        AppMethodBeat.o(75890);
        return vVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (r1 == com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.BPj) goto L_0x0040;
     */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.plugin.recordvideo.ui.a.a.C1655a r6, int r7) {
        /*
            r5 = this;
            r4 = 75891(0x12873, float:1.06346E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.plugin.recordvideo.ui.a.a$a r6 = (com.tencent.mm.plugin.recordvideo.ui.a.a.C1655a) r6
            java.lang.String r0 = "holder"
            kotlin.g.b.p.h(r6, r0)
            int r0 = r6.lS()
            com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo r0 = r5.VR(r0)
            com.tencent.mm.plugin.recordvideo.model.audio.i$a r1 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL
            com.tencent.mm.plugin.recordvideo.model.audio.i r1 = com.tencent.mm.plugin.recordvideo.model.audio.i.eKl()
            r1.c(r0)
            com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo r0 = r5.VR(r7)
            if (r0 != 0) goto L_0x0028
            kotlin.g.b.p.hyc()
        L_0x0028:
            boolean r1 = r0.aXa
            if (r1 != 0) goto L_0x005b
            int r1 = r0.type
            com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo$a r2 = com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.BPo
            int r2 = com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.eJW()
            if (r1 == r2) goto L_0x0040
            int r1 = r0.type
            com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo$a r2 = com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.BPo
            int r2 = com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo.eJY()
            if (r1 != r2) goto L_0x005b
        L_0x0040:
            com.tencent.mm.plugin.recordvideo.model.audio.i$a r1 = com.tencent.mm.plugin.recordvideo.model.audio.i.BPL
            com.tencent.mm.plugin.recordvideo.model.audio.i r1 = com.tencent.mm.plugin.recordvideo.model.audio.i.eKl()
            android.view.View r2 = r6.aus
            java.lang.String r3 = "holder.itemView"
            kotlin.g.b.p.g(r2, r3)
            android.content.Context r2 = r2.getContext()
            java.lang.String r3 = "holder.itemView.context"
            kotlin.g.b.p.g(r2, r3)
            com.tencent.mm.plugin.recordvideo.model.audio.i.a(r1, r2, r0)
        L_0x005b:
            r6.a(r7, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.a.a.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    static {
        AppMethodBeat.i(75893);
        AppMethodBeat.o(75893);
    }

    public final void gj(List<AudioCacheInfo> list) {
        AppMethodBeat.i(75883);
        p.h(list, "audios");
        this.BZO.clear();
        this.BZO.addAll(list);
        this.va = -1;
        notifyDataSetChanged();
        AppMethodBeat.o(75883);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void gk(java.util.List<com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo> r8) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.a.a.gk(java.util.List):void");
    }

    public final void setSelection(Integer num) {
        AppMethodBeat.i(75885);
        if (num == null) {
            ci(this.va);
            this.va = -1;
            ci(this.va);
            AppMethodBeat.o(75885);
            return;
        }
        ci(this.va);
        this.va = num.intValue();
        ci(this.va);
        AppMethodBeat.o(75885);
    }

    public final void setMusicPlayer(v vVar) {
        AppMethodBeat.i(75886);
        p.h(vVar, "player");
        this.BZV = vVar;
        AppMethodBeat.o(75886);
    }

    public final AudioCacheInfo VR(int i2) {
        AppMethodBeat.i(75887);
        AudioCacheInfo audioCacheInfo = (AudioCacheInfo) j.L(this.BZO, i2);
        AppMethodBeat.o(75887);
        return audioCacheInfo;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(75888);
        int size = this.BZO.size();
        AppMethodBeat.o(75888);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(75889);
        AudioCacheInfo VR = VR(i2);
        if (VR != null) {
            int i3 = VR.type;
            AppMethodBeat.o(75889);
            return i3;
        }
        AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
        int i4 = AudioCacheInfo.BPh;
        AppMethodBeat.o(75889);
        return i4;
    }

    /* renamed from: com.tencent.mm.plugin.recordvideo.ui.a.a$a */
    public class C1655a extends RecyclerView.v {
        final /* synthetic */ a BZX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1655a(a aVar, final View view) {
            super(view);
            p.h(view, "itemView");
            this.BZX = aVar;
            AppMethodBeat.i(75875);
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.ui.a.a.C1655a.AnonymousClass1 */
                final /* synthetic */ C1655a BZY;

                {
                    this.BZY = r1;
                }

                public final void onClick(View view) {
                    m<? super Integer, ? super AudioCacheInfo, x> mVar;
                    AppMethodBeat.i(75873);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    int lR = this.BZY.lR();
                    AudioCacheInfo VR = this.BZY.BZX.VR(lR);
                    if (!(VR == null || (mVar = this.BZY.BZX.rsD) == null)) {
                        mVar.invoke(Integer.valueOf(lR), VR);
                    }
                    view.requestFocus();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/adapter/RecommendMusicAdapter$BaseViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(75873);
                }
            });
            AppMethodBeat.o(75875);
        }

        public void a(int i2, AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(75874);
            p.h(audioCacheInfo, "info");
            AppMethodBeat.o(75874);
        }
    }

    public final class d extends C1655a {
        final /* synthetic */ a BZX;
        private final MusicLrcView BZZ;
        private final AudioWaveView Caa;
        private final View rtV;
        private final WeImageView wjf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.BZX = aVar;
            AppMethodBeat.i(75878);
            View findViewById = view.findViewById(R.id.ib_);
            p.g(findViewById, "itemView.findViewById(R.…story_item_audio_loading)");
            this.rtV = findViewById;
            View findViewById2 = view.findViewById(R.id.iba);
            p.g(findViewById2, "itemView.findViewById(R.…story_item_audio_preview)");
            this.wjf = (WeImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.ibj);
            p.g(findViewById3, "itemView.findViewById(R.id.story_item_audio_title)");
            this.BZZ = (MusicLrcView) findViewById3;
            View findViewById4 = view.findViewById(R.id.jjb);
            p.g(findViewById4, "itemView.findViewById(R.id.waveView)");
            this.Caa = (AudioWaveView) findViewById4;
            AppMethodBeat.o(75878);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.a.a.C1655a
        public final void a(int i2, AudioCacheInfo audioCacheInfo) {
            String str;
            boolean z = true;
            AppMethodBeat.i(75877);
            p.h(audioCacheInfo, "info");
            View view = this.aus;
            p.g(view, "itemView");
            View view2 = this.aus;
            p.g(view2, "itemView");
            view.setBackground(com.tencent.mm.cb.a.l(view2.getContext(), this.BZX.BZQ));
            View view3 = this.aus;
            p.g(view3, "itemView");
            ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
            if (layoutParams != null) {
                View view4 = this.aus;
                p.g(view4, "itemView");
                int jn = com.tencent.mm.cb.a.jn(view4.getContext());
                View view5 = this.aus;
                p.g(view5, "itemView");
                layoutParams.width = jn - com.tencent.mm.cb.a.fromDPToPix(view5.getContext(), 80);
            }
            View view6 = this.aus;
            p.g(view6, "itemView");
            view6.setEnabled(true);
            boolean z2 = i2 == this.BZX.va;
            View view7 = this.aus;
            p.g(view7, "itemView");
            view7.setSelected(z2);
            Log.i(a.TAG, "LogStory: ".concat(String.valueOf(z2)));
            this.Caa.setVisibility(0);
            AudioWaveView audioWaveView = this.Caa;
            View view8 = this.aus;
            p.g(view8, "itemView");
            ColorStateList m = com.tencent.mm.cb.a.m(view8.getContext(), this.BZX.BZT);
            p.g(m, "ResourceHelper.getColorS…ntext, recWaveColorResId)");
            audioWaveView.setColor(m);
            this.Caa.setShow(z2);
            View view9 = this.aus;
            p.g(view9, "itemView");
            Drawable l = com.tencent.mm.cb.a.l(view9.getContext(), this.BZX.BZR);
            View view10 = this.aus;
            p.g(view10, "itemView");
            ColorStateList m2 = com.tencent.mm.cb.a.m(view10.getContext(), this.BZX.BZS);
            this.wjf.setImageDrawable(l);
            this.wjf.setIconColor(m2.getColorForState(this.wjf.getDrawableState(), 0));
            this.wjf.setVisibility(0);
            MusicLrcView musicLrcView = this.BZZ;
            View view11 = this.aus;
            p.g(view11, "itemView");
            musicLrcView.setTextColor(com.tencent.mm.cb.a.m(view11.getContext(), this.BZX.BZU));
            ArrayList<AudioCacheInfo.c> arrayList = audioCacheInfo.BOY;
            if (arrayList != null && !arrayList.isEmpty()) {
                z = false;
            }
            if (z) {
                MusicLrcView musicLrcView2 = this.BZZ;
                if (audioCacheInfo.BOZ.isEmpty()) {
                    str = audioCacheInfo.BPc;
                } else {
                    str = audioCacheInfo.BPc + " - " + Util.listToString(audioCacheInfo.BOZ, ",");
                }
                musicLrcView2.setText(str);
                this.BZZ.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.BZZ.setMarqueeRepeatLimit(-1);
                MusicLrcView.a(this.BZZ, false);
            } else {
                MusicLrcView.a(this.BZZ, audioCacheInfo.BOY);
                this.BZZ.setEllipsize(null);
                MusicLrcView.a(this.BZZ, z2);
            }
            this.BZZ.setVisibility(0);
            this.rtV.setVisibility(8);
            AppMethodBeat.o(75877);
        }
    }

    public final class g extends C1655a {
        final /* synthetic */ a BZX;
        private final WeImageView Cab;
        private final TextView Cac;
        private final MusicLrcView Cad;
        private final int Cae;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.BZX = aVar;
            AppMethodBeat.i(75882);
            View findViewById = view.findViewById(R.id.ibe);
            p.g(findViewById, "itemView.findViewById(R.…audio_search_result_icon)");
            this.Cab = (WeImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.ibg);
            p.g(findViewById2, "itemView.findViewById(R.…udio_search_result_title)");
            this.Cac = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.ibf);
            p.g(findViewById3, "itemView.findViewById(R.…_audio_search_result_tip)");
            this.Cad = (MusicLrcView) findViewById3;
            this.Cae = com.tencent.mm.cb.a.n(view.getContext(), R.color.acr);
            AppMethodBeat.o(75882);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.a.a.C1655a
        public final void a(int i2, AudioCacheInfo audioCacheInfo) {
            String str;
            AppMethodBeat.i(75881);
            p.h(audioCacheInfo, "info");
            boolean z = i2 == this.BZX.va;
            View view = this.aus;
            p.g(view, "itemView");
            view.setSelected(z);
            View view2 = this.aus;
            p.g(view2, "itemView");
            Drawable l = com.tencent.mm.cb.a.l(view2.getContext(), this.BZX.BZR);
            View view3 = this.aus;
            p.g(view3, "itemView");
            ColorStateList m = com.tencent.mm.cb.a.m(view3.getContext(), R.color.a_a);
            this.Cab.setImageDrawable(l);
            this.Cab.setIconColor(m.getColorForState(this.Cab.getDrawableState(), 0));
            if (audioCacheInfo.BOZ.isEmpty()) {
                str = audioCacheInfo.BPc;
            } else {
                str = audioCacheInfo.BPc + " - " + Util.listToString(audioCacheInfo.BOZ, ",");
            }
            TextView textView = this.Cac;
            MusicLrcView.a aVar = MusicLrcView.Cee;
            textView.setText(MusicLrcView.a.a(str, this.BZX.BZP, this.Cae));
            this.Cad.f(audioCacheInfo.BOY, this.BZX.BZP);
            MusicLrcView.a(this.Cad, z);
            AppMethodBeat.o(75881);
        }
    }

    public static /* synthetic */ void a(a aVar, Integer num) {
        AppMethodBeat.i(237573);
        aVar.a(null, num, null, null, null);
        AppMethodBeat.o(237573);
    }

    public final void a(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        AppMethodBeat.i(237572);
        if (!(num == null || num.intValue() == 0)) {
            this.BZQ = num.intValue();
        }
        if (!(num2 == null || num2.intValue() == 0)) {
            this.BZR = num2.intValue();
        }
        if (!(num3 == null || num3.intValue() == 0)) {
            this.BZS = num3.intValue();
        }
        if (!(num4 == null || num4.intValue() == 0)) {
            this.BZT = num4.intValue();
        }
        if (!(num5 == null || num5.intValue() == 0)) {
            this.BZU = num5.intValue();
        }
        AppMethodBeat.o(237572);
    }

    public final class e extends C1655a {
        final /* synthetic */ a BZX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.BZX = aVar;
            AppMethodBeat.i(75879);
            AppMethodBeat.o(75879);
        }
    }

    public final class c extends C1655a {
        final /* synthetic */ a BZX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.BZX = aVar;
            AppMethodBeat.i(75876);
            AppMethodBeat.o(75876);
        }
    }

    public final class f extends C1655a {
        final /* synthetic */ a BZX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar, View view) {
            super(aVar, view);
            p.h(view, "itemView");
            this.BZX = aVar;
            AppMethodBeat.i(75880);
            AppMethodBeat.o(75880);
        }
    }
}
