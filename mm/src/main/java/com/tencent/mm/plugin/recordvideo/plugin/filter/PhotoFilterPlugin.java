package com.tencent.mm.plugin.recordvideo.plugin.filter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rH\u0002J\u000e\u00105\u001a\u0002022\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002022\u0006\u0010'\u001a\u00020(J\u0010\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\u0016H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "defaultWeight", "", "getDefaultWeight", "()F", "itemViews", "", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "getItemViews", "()Ljava/util/List;", "lastSelectedIndex", "", "getLastSelectedIndex", "()I", "setLastSelectedIndex", "(I)V", "progressDescTv", "Landroid/widget/TextView;", "getProgressDescTv", "()Landroid/widget/TextView;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarLayout", "Landroid/view/ViewGroup;", "getSeekBarLayout", "()Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "weightMap", "", "getWeightMap", "()Ljava/util/Map;", "setWeightMap", "(Ljava/util/Map;)V", "onBackPress", "", "postFuncType", "", FirebaseAnalytics.b.INDEX, "colorWeight", "setPreImage", "bitmap", "Landroid/graphics/Bitmap;", "setStatus", "setVisibility", "visibility", "ViewHolder", "plugin-recordvideo_release"})
public final class PhotoFilterPlugin extends RelativeLayout implements t {
    private final List<a> BTk = new ArrayList();
    private final ViewGroup BTl;
    private final TextView BTm;
    private int BTn;
    private Map<Integer, Float> BTo = new LinkedHashMap();
    private final float BTp = 0.8f;
    private final String TAG = "MicroMsg.PhotoFilterPlugin";
    private final SeekBar oyP;
    private d wgr;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", FirebaseAnalytics.b.INDEX, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ PhotoFilterPlugin BTq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PhotoFilterPlugin photoFilterPlugin) {
            super(1);
            this.BTq = photoFilterPlugin;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            Float valueOf;
            AppMethodBeat.i(163454);
            int intValue = num.intValue();
            Log.i(this.BTq.getTAG(), "onSelect ".concat(String.valueOf(intValue)));
            if (intValue == 0) {
                this.BTq.getSeekBarLayout().setVisibility(4);
            } else {
                this.BTq.getSeekBarLayout().setVisibility(0);
            }
            if (this.BTq.getWeightMap().containsKey(Integer.valueOf(intValue))) {
                valueOf = this.BTq.getWeightMap().get(Integer.valueOf(intValue));
            } else {
                valueOf = Float.valueOf(this.BTq.getDefaultWeight());
            }
            SeekBar seekBar = this.BTq.getSeekBar();
            if (valueOf == null) {
                p.hyc();
            }
            seekBar.setProgress((int) (valueOf.floatValue() * 100.0f));
            PhotoFilterPlugin.a(this.BTq, intValue, valueOf.floatValue());
            for (T t : this.BTq.getItemViews()) {
                if (t.index != intValue) {
                    t.maskView.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(163454);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoFilterPlugin(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(163462);
        LayoutInflater.from(context).inflate(R.layout.bi1, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.hgw);
        p.g(findViewById, "findViewById(R.id.seekbar_layout)");
        this.BTl = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.cit);
        p.g(findViewById2, "findViewById(R.id.filter_seek_bar)");
        this.oyP = (SeekBar) findViewById2;
        View findViewById3 = findViewById(R.id.ciu);
        p.g(findViewById3, "findViewById(R.id.filter_seek_bar_desc)");
        this.BTm = (TextView) findViewById3;
        b bVar = new b(this);
        this.oyP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin.AnonymousClass1 */
            final /* synthetic */ PhotoFilterPlugin BTq;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.BTq = r1;
            }

            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                AppMethodBeat.i(163449);
                Log.d(this.BTq.getTAG(), "onProgressChanged ".concat(String.valueOf(i2)));
                this.BTq.getProgressDescTv().setText(new StringBuilder().append(i2).append('%').toString());
                AppMethodBeat.o(163449);
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                AppMethodBeat.i(163450);
                PhotoFilterPlugin photoFilterPlugin = this.BTq;
                int lastSelectedIndex = this.BTq.getLastSelectedIndex();
                if (seekBar == null) {
                    p.hyc();
                }
                PhotoFilterPlugin.a(photoFilterPlugin, lastSelectedIndex, ((float) seekBar.getProgress()) / 100.0f);
                AppMethodBeat.o(163450);
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.gba);
        com.tencent.mm.x.a aVar = com.tencent.mm.x.a.hiy;
        for (T t : com.tencent.mm.x.a.axh()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.bi0, (ViewGroup) linearLayout, false);
            linearLayout.addView(inflate);
            List<a> list = this.BTk;
            p.g(inflate, "itemView");
            list.add(new a(inflate, t.type, t.name, bVar));
        }
        AppMethodBeat.o(163462);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(237397);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(237397);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final List<a> getItemViews() {
        return this.BTk;
    }

    public final ViewGroup getSeekBarLayout() {
        return this.BTl;
    }

    public final SeekBar getSeekBar() {
        return this.oyP;
    }

    public final TextView getProgressDescTv() {
        return this.BTm;
    }

    public final int getLastSelectedIndex() {
        return this.BTn;
    }

    public final void setLastSelectedIndex(int i2) {
        this.BTn = i2;
    }

    public final Map<Integer, Float> getWeightMap() {
        return this.BTo;
    }

    public final void setWeightMap(Map<Integer, Float> map) {
        AppMethodBeat.i(163457);
        p.h(map, "<set-?>");
        this.BTo = map;
        AppMethodBeat.o(163457);
    }

    public final float getDefaultWeight() {
        return this.BTp;
    }

    public final void setStatus(d dVar) {
        AppMethodBeat.i(163458);
        p.h(dVar, "status");
        this.wgr = dVar;
        AppMethodBeat.o(163458);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ PhotoFilterPlugin BTq;
        final /* synthetic */ Bitmap cKG;

        c(PhotoFilterPlugin photoFilterPlugin, Bitmap bitmap) {
            this.BTq = photoFilterPlugin;
            this.cKG = bitmap;
        }

        public final void run() {
            AppMethodBeat.i(163456);
            for (T t : this.BTq.getItemViews()) {
                if (!t.BTt) {
                    com.tencent.mm.x.a aVar = com.tencent.mm.x.a.hiy;
                    com.tencent.mm.x.a.A(this.cKG);
                    int aH = com.tencent.mm.cb.a.aH(this.BTq.getContext(), R.dimen.cr);
                    int aH2 = com.tencent.mm.cb.a.aH(this.BTq.getContext(), R.dimen.cr);
                    if (this.cKG.getWidth() > this.cKG.getHeight()) {
                        aH = (int) ((((float) this.cKG.getWidth()) / ((float) this.cKG.getHeight())) * ((float) aH2));
                    } else if (this.cKG.getWidth() < this.cKG.getHeight()) {
                        aH2 = (int) ((((float) this.cKG.getHeight()) / ((float) this.cKG.getWidth())) * ((float) aH));
                    }
                    com.tencent.mm.x.a aVar2 = com.tencent.mm.x.a.hiy;
                    this.BTq.post(new a(t, com.tencent.mm.x.a.a(this.cKG, t.index, aH, aH2, this.BTq.getDefaultWeight())));
                }
            }
            AppMethodBeat.o(163456);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ a BTy;
            final /* synthetic */ Bitmap BTz;

            a(a aVar, Bitmap bitmap) {
                this.BTy = aVar;
                this.BTz = bitmap;
            }

            public final void run() {
                AppMethodBeat.i(163455);
                a aVar = this.BTy;
                Bitmap bitmap = this.BTz;
                p.h(bitmap, "bitmap");
                aVar.BTr.setImageBitmap(bitmap);
                aVar.BTt = true;
                AppMethodBeat.o(163455);
            }
        }
    }

    public final void setPreImage(Bitmap bitmap) {
        AppMethodBeat.i(163459);
        p.h(bitmap, "bitmap");
        h.RTc.aX(new c(this, bitmap));
        AppMethodBeat.o(163459);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(163460);
        super.setVisibility(i2);
        if (i2 == 0) {
            this.BTk.get(this.BTn).eKO();
        }
        AppMethodBeat.o(163460);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        AppMethodBeat.i(163461);
        if (getVisibility() == 0) {
            setVisibility(8);
            AppMethodBeat.o(163461);
            return true;
        }
        AppMethodBeat.o(163461);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\u0010\rJ\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R,\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder;", "", "effectLayout", "Landroid/view/View;", FirebaseAnalytics.b.INDEX, "", "effectName", "", "onSelect", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroid/view/View;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "effectIv", "Landroid/widget/ImageView;", "getEffectIv", "()Landroid/widget/ImageView;", "getEffectLayout", "()Landroid/view/View;", "getEffectName", "()Ljava/lang/String;", "effectTv", "Landroid/widget/TextView;", "getEffectTv", "()Landroid/widget/TextView;", "filtered", "", "getFiltered", "()Z", "setFiltered", "(Z)V", "getIndex", "()I", "maskView", "getMaskView", "getOnSelect", "()Lkotlin/jvm/functions/Function1;", "selected", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "unselected", "plugin-recordvideo_release"})
    public static final class a {
        final ImageView BTr;
        private final TextView BTs;
        boolean BTt;
        private final View BTu;
        private final String BTv;
        private final kotlin.g.a.b<Integer, x> BTw;
        final int index;
        final View maskView;

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.g.a.b<? super java.lang.Integer, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(View view, int i2, String str, kotlin.g.a.b<? super Integer, x> bVar) {
            p.h(view, "effectLayout");
            p.h(str, "effectName");
            p.h(bVar, "onSelect");
            AppMethodBeat.i(163453);
            this.BTu = view;
            this.index = i2;
            this.BTv = str;
            this.BTw = bVar;
            View findViewById = this.BTu.findViewById(R.id.gb_);
            p.g(findViewById, "effectLayout.findViewById(R.id.photo_effect_iv)");
            this.BTr = (ImageView) findViewById;
            View findViewById2 = this.BTu.findViewById(R.id.gbb);
            p.g(findViewById2, "effectLayout.findViewById(R.id.photo_effect_mask)");
            this.maskView = findViewById2;
            View findViewById3 = this.BTu.findViewById(R.id.gbc);
            p.g(findViewById3, "effectLayout.findViewByI….id.photo_effect_name_tv)");
            this.BTs = (TextView) findViewById3;
            this.BTu.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.recordvideo.plugin.filter.PhotoFilterPlugin.a.AnonymousClass1 */
                final /* synthetic */ a BTx;

                {
                    this.BTx = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(163451);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    this.BTx.eKO();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/filter/PhotoFilterPlugin$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(163451);
                }
            });
            this.BTs.setText(this.BTv);
            AppMethodBeat.o(163453);
        }

        public final void eKO() {
            AppMethodBeat.i(163452);
            this.maskView.setVisibility(8);
            this.BTw.invoke(Integer.valueOf(this.index));
            AppMethodBeat.o(163452);
        }
    }

    public static final /* synthetic */ void a(PhotoFilterPlugin photoFilterPlugin, int i2, float f2) {
        AppMethodBeat.i(163463);
        Log.i(photoFilterPlugin.TAG, "postFuncType " + i2 + ", " + f2);
        photoFilterPlugin.BTn = i2;
        photoFilterPlugin.BTo.put(Integer.valueOf(i2), Float.valueOf(f2));
        Bundle bundle = new Bundle();
        bundle.putInt("EDIT_FILTER_INDEX_INT", i2);
        bundle.putFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT", f2);
        d dVar = photoFilterPlugin.wgr;
        if (dVar != null) {
            dVar.a(d.c.BVU, bundle);
            AppMethodBeat.o(163463);
            return;
        }
        AppMethodBeat.o(163463);
    }
}
