package com.tencent.mm.plugin.vlog.ui.fake;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/SimpleFrameRetriever;", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-vlog_release"})
public final class VLogFakePlayActivity extends MMActivity {
    public static final a GFP = new a((byte) 0);
    private f GFO;
    private VideoCompositionPlayView wbi;
    private EffectManager wbk = new EffectManager();

    static {
        AppMethodBeat.i(191132);
        AppMethodBeat.o(191132);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ VLogFakePlayActivity GFQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(VLogFakePlayActivity vLogFakePlayActivity) {
            super(1);
            this.GFQ = vLogFakePlayActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(191130);
            final boolean booleanValue = bool.booleanValue();
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity.b.AnonymousClass1 */
                final /* synthetic */ b GFR;

                {
                    this.GFR = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(191129);
                    Toast.makeText(this.GFR.GFQ, "export over " + booleanValue, 0).show();
                    x xVar = x.SXb;
                    AppMethodBeat.o(191129);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(191130);
            return xVar;
        }
    }

    public VLogFakePlayActivity() {
        AppMethodBeat.i(191131);
        AppMethodBeat.o(191131);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110878);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        com.tencent.mm.plugin.mmsight.d.rb(true);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("composition_proto");
        acn acn = new acn();
        try {
            acn.parseFrom(byteArrayExtra);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
        }
        ac d2 = i.d(acn, this.wbk);
        new com.tencent.mm.plugin.vlog.model.f().a(acn, new b(this));
        Rect rect = new Rect();
        dlh dlh = acn.Gxw.Lnm;
        p.g(dlh, "compositionInfo.outputConfig.originRect");
        i.a(dlh, rect);
        d2.q(rect);
        e eVar = e.BKp;
        LinkedList<jn> linkedList = acn.Gxx.Lna;
        p.g(linkedList, "compositionInfo.editData.baseItemData");
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a2 = e.a(linkedList, context);
        LinkedList<Integer> linkedList2 = acn.Gxx.LmZ.Msu;
        p.g(linkedList2, "compositionInfo.editData.drawingRect.values");
        LinkedList<Integer> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        Iterator<T> it = linkedList3.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf((float) it.next().intValue()));
        }
        float[] t = j.t((Collection<Float>) arrayList);
        dlh dlh2 = acn.Gxx.Lnc;
        if (dlh2 != null) {
            LinkedList<Integer> linkedList4 = dlh2.Msu;
            p.g(linkedList4, "rectProto.values");
            LinkedList<Integer> linkedList5 = linkedList4;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList5, 10));
            Iterator<T> it2 = linkedList5.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf((float) it2.next().intValue()));
            }
            j.t((Collection<Float>) arrayList2);
        }
        this.GFO = new f(t, a2, acn.Gxw.xlg, acn.Gxw.xlh);
        f fVar = this.GFO;
        if (fVar == null) {
            p.hyc();
        }
        d2.O(fVar);
        f fVar2 = this.GFO;
        if (fVar2 != null) {
            fVar2.start();
        }
        this.wbi = (VideoCompositionPlayView) findViewById(R.id.j8s);
        VideoCompositionPlayView videoCompositionPlayView = this.wbi;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) (videoCompositionPlayView != null ? videoCompositionPlayView.getLayoutParams() : null);
        if (layoutParams != null) {
            layoutParams.dimensionRatio = String.valueOf((((float) rect.width()) * 1.0f) / ((float) rect.height()));
            VideoCompositionPlayView videoCompositionPlayView2 = this.wbi;
            if (videoCompositionPlayView2 != null) {
                videoCompositionPlayView2.setLayoutParams(layoutParams);
            }
        }
        VideoCompositionPlayView videoCompositionPlayView3 = this.wbi;
        if (videoCompositionPlayView3 != null) {
            videoCompositionPlayView3.a(d2.getComposition());
            AppMethodBeat.o(110878);
            return;
        }
        AppMethodBeat.o(110878);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(110882);
        super.onDestroy();
        f fVar = this.GFO;
        if (fVar != null) {
            fVar.destroy();
        }
        this.wbk.destroy();
        AppMethodBeat.o(110882);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c66;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/fake/VLogFakePlayActivity$Companion;", "", "()V", "KEY_COMPOSITION_PROTO", "", "TAG", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
