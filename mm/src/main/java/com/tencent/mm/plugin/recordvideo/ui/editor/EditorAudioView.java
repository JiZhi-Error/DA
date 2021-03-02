package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.recordvideo.b.a.a;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.plugin.recordvideo.plugin.progress.HorizontalSubProgressBar;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView;
import com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.InsectRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public final class EditorAudioView extends InsectRelativeLayout {
    public static final b Ccr = new b((byte) 0);
    public static final String TAG = TAG;
    private boolean BNb;
    private boolean BNc;
    private final kotlin.f CbA;
    private final kotlin.f CbB;
    private final kotlin.f CbC;
    private final kotlin.f CbD;
    private final kotlin.f CbE;
    private final kotlin.f CbF;
    private final kotlin.f CbG;
    private final kotlin.f CbH;
    private final kotlin.f CbI;
    private final kotlin.f CbJ;
    private final kotlin.f CbK;
    private final kotlin.f CbL;
    private final kotlin.f CbM;
    private final kotlin.f CbN;
    private final kotlin.f CbO;
    private final kotlin.f CbP;
    private final kotlin.f CbQ;
    public final List<Float> CbR;
    private final List<kotlin.r<String, Long, Long>> CbS;
    private final List<Float> CbT;
    private final List<kotlin.r<String, Long, Long>> CbU;
    private boolean CbV;
    public long CbW;
    public long CbX;
    private long CbY;
    private long CbZ;
    private final View Cbf;
    public final RecyclerView Cbg;
    private final ImageView Cbh;
    private final ImageView Cbi;
    private final ImageView Cbj;
    public final View Cbk;
    private final View Cbl;
    private final View Cbm;
    private final kotlin.f Cbn;
    private final kotlin.f Cbo;
    private final kotlin.f Cbp;
    private final ImageView Cbq;
    private final View Cbr;
    private final EditorAudioSearchView Cbs;
    private final ViewGroup Cbt;
    private int Cbu;
    private int Cbv;
    private int Cbw;
    private final kotlin.f Cbx;
    private final kotlin.f Cby;
    private final kotlin.f Cbz;
    private String Cca;
    public int Ccb;
    public boolean Ccc;
    public c Ccd;
    public final com.tencent.mm.plugin.recordvideo.ui.a.a Cce;
    private int Ccf;
    private com.tencent.mm.plugin.recordvideo.model.audio.a Ccg;
    public boolean Cch;
    private LinkedList<AudioCacheInfo> Cci;
    private boolean Ccj;
    private boolean Cck;
    private boolean Ccl;
    private boolean Ccm;
    private boolean Ccn;
    private a Cco;
    private kotlin.g.a.b<? super Boolean, kotlin.x> Ccp;
    private final z Ccq;
    public boolean ipC;
    public boolean ipv;
    private com.tencent.mm.plugin.mmsight.model.a.c irD;
    private final kotlin.f udQ;
    private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> wJT;
    private com.tencent.mm.plugin.mmsight.model.a.p zvN;

    public interface a {
        void a(AudioCacheInfo audioCacheInfo);

        void b(AudioCacheInfo audioCacheInfo);

        void e(boolean z, List<? extends ckm> list);

        void oR(boolean z);

        void pauseAudio();
    }

    public interface c {
        void Ih(long j2);

        void PN();

        void eLX();

        void eLY();

        void eLZ();

        void eMa();
    }

    private final ViewGroup getAudioContainer() {
        AppMethodBeat.i(237664);
        ViewGroup viewGroup = (ViewGroup) this.CbB.getValue();
        AppMethodBeat.o(237664);
        return viewGroup;
    }

    private final LinearLayout getAudioTab() {
        AppMethodBeat.i(237661);
        LinearLayout linearLayout = (LinearLayout) this.Cby.getValue();
        AppMethodBeat.o(237661);
        return linearLayout;
    }

    private final View getAudioTabIndicator() {
        AppMethodBeat.i(237663);
        View view = (View) this.CbA.getValue();
        AppMethodBeat.o(237663);
        return view;
    }

    private final TextView getAudioTabText() {
        AppMethodBeat.i(237662);
        TextView textView = (TextView) this.Cbz.getValue();
        AppMethodBeat.o(237662);
        return textView;
    }

    private final View getCenterCloseGroup() {
        AppMethodBeat.i(237671);
        View view = (View) this.CbH.getValue();
        AppMethodBeat.o(237671);
        return view;
    }

    private final WeImageView getDeleteSubIcon() {
        AppMethodBeat.i(237678);
        WeImageView weImageView = (WeImageView) this.CbO.getValue();
        AppMethodBeat.o(237678);
        return weImageView;
    }

    private final ImageView getDoneIcon() {
        AppMethodBeat.i(237672);
        ImageView imageView = (ImageView) this.CbI.getValue();
        AppMethodBeat.o(237672);
        return imageView;
    }

    private final TextView getLyricsText() {
        AppMethodBeat.i(237659);
        TextView textView = (TextView) this.Cbp.getValue();
        AppMethodBeat.o(237659);
        return textView;
    }

    private final TextView getMuteMusicText() {
        AppMethodBeat.i(237657);
        TextView textView = (TextView) this.Cbn.getValue();
        AppMethodBeat.o(237657);
        return textView;
    }

    private final TextView getMuteOriginText() {
        AppMethodBeat.i(237658);
        TextView textView = (TextView) this.Cbo.getValue();
        AppMethodBeat.o(237658);
        return textView;
    }

    private final TextView getRecordBtnText() {
        AppMethodBeat.i(237675);
        TextView textView = (TextView) this.CbL.getValue();
        AppMethodBeat.o(237675);
        return textView;
    }

    private final ViewGroup getRecordContainer() {
        AppMethodBeat.i(237668);
        ViewGroup viewGroup = (ViewGroup) this.CbF.getValue();
        AppMethodBeat.o(237668);
        return viewGroup;
    }

    private final ViewGroup getRecordEntrance() {
        AppMethodBeat.i(237676);
        ViewGroup viewGroup = (ViewGroup) this.CbM.getValue();
        AppMethodBeat.o(237676);
        return viewGroup;
    }

    private final ImageView getRecordIcon() {
        AppMethodBeat.i(237674);
        ImageView imageView = (ImageView) this.CbK.getValue();
        AppMethodBeat.o(237674);
        return imageView;
    }

    private final LinearLayout getRecordTab() {
        AppMethodBeat.i(237665);
        LinearLayout linearLayout = (LinearLayout) this.CbC.getValue();
        AppMethodBeat.o(237665);
        return linearLayout;
    }

    private final View getRecordTabIndicator() {
        AppMethodBeat.i(237667);
        View view = (View) this.CbE.getValue();
        AppMethodBeat.o(237667);
        return view;
    }

    private final TextView getRecordTabText() {
        AppMethodBeat.i(237666);
        TextView textView = (TextView) this.CbD.getValue();
        AppMethodBeat.o(237666);
        return textView;
    }

    private final ViewGroup getTabContainer() {
        AppMethodBeat.i(237660);
        ViewGroup viewGroup = (ViewGroup) this.Cbx.getValue();
        AppMethodBeat.o(237660);
        return viewGroup;
    }

    private final View getTabSpace() {
        AppMethodBeat.i(237669);
        View view = (View) this.CbG.getValue();
        AppMethodBeat.o(237669);
        return view;
    }

    private final VideoTransPara getVideoParams() {
        AppMethodBeat.i(237680);
        VideoTransPara videoTransPara = (VideoTransPara) this.CbQ.getValue();
        AppMethodBeat.o(237680);
        return videoTransPara;
    }

    public final ImageView getCloseIcon() {
        AppMethodBeat.i(237670);
        ImageView imageView = (ImageView) this.udQ.getValue();
        AppMethodBeat.o(237670);
        return imageView;
    }

    public final MMEditorRecordButton getRecordControlButton() {
        AppMethodBeat.i(237677);
        MMEditorRecordButton mMEditorRecordButton = (MMEditorRecordButton) this.CbN.getValue();
        AppMethodBeat.o(237677);
        return mMEditorRecordButton;
    }

    public final TextView getRecordRemainTimeText() {
        AppMethodBeat.i(237679);
        TextView textView = (TextView) this.CbP.getValue();
        AppMethodBeat.o(237679);
        return textView;
    }

    public final HorizontalSubProgressBar getSubProgressBar() {
        AppMethodBeat.i(237673);
        HorizontalSubProgressBar horizontalSubProgressBar = (HorizontalSubProgressBar) this.CbJ.getValue();
        AppMethodBeat.o(237673);
        return horizontalSubProgressBar;
    }

    public static final class ad extends kotlin.g.b.q implements kotlin.g.a.b<LinkedList<clp>, kotlin.x> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(EditorAudioView editorAudioView) {
            super(1);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(LinkedList<clp> linkedList) {
            AppMethodBeat.i(75955);
            final LinkedList<clp> linkedList2 = linkedList;
            kotlin.g.b.p.h(linkedList2, LocaleUtil.ITALIAN);
            if (this.Ccs.Ccm) {
                Log.i(EditorAudioView.TAG, "EditorView has been destroyed, skip callback");
            } else {
                this.Ccs.Cch = !linkedList2.isEmpty();
                if (this.Ccs.Cch) {
                    c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                    com.tencent.mm.plugin.recordvideo.model.audio.c cVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
                    if (cVar != null) {
                        cVar.ulj = this.Ccs.getMusicRequestId();
                    }
                    this.Ccs.Cbs.setMRelatedRecId(this.Ccs.getMusicRequestId());
                    MMHandlerThread.postToMainThread(new Runnable(this) {
                        /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.ad.AnonymousClass1 */
                        final /* synthetic */ ad Ccv;

                        {
                            this.Ccv = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(75954);
                            this.Ccv.Ccs.eL(linkedList2);
                            AppMethodBeat.o(75954);
                        }
                    });
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(75955);
            return xVar;
        }
    }

    public static final /* synthetic */ void B(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237703);
        editorAudioView.eLW();
        AppMethodBeat.o(237703);
    }

    public static final /* synthetic */ void F(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237706);
        editorAudioView.eLV();
        AppMethodBeat.o(237706);
    }

    public static final /* synthetic */ void b(EditorAudioView editorAudioView, boolean z2) {
        AppMethodBeat.i(75970);
        editorAudioView.ty(z2);
        AppMethodBeat.o(75970);
    }

    public static final /* synthetic */ void c(EditorAudioView editorAudioView, boolean z2) {
        AppMethodBeat.i(75971);
        editorAudioView.setShowAudioPanel(z2);
        AppMethodBeat.o(75971);
    }

    public static final /* synthetic */ void d(EditorAudioView editorAudioView, boolean z2) {
        AppMethodBeat.i(75972);
        editorAudioView.tx(z2);
        AppMethodBeat.o(75972);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.mmsight.model.a.p l(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237698);
        com.tencent.mm.plugin.mmsight.model.a.p pVar = editorAudioView.zvN;
        if (pVar == null) {
            kotlin.g.b.p.btv("muxer");
        }
        AppMethodBeat.o(237698);
        return pVar;
    }

    public static final /* synthetic */ HorizontalSubProgressBar q(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237699);
        HorizontalSubProgressBar subProgressBar = editorAudioView.getSubProgressBar();
        AppMethodBeat.o(237699);
        return subProgressBar;
    }

    public static final /* synthetic */ MMEditorRecordButton r(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237700);
        MMEditorRecordButton recordControlButton = editorAudioView.getRecordControlButton();
        AppMethodBeat.o(237700);
        return recordControlButton;
    }

    public static final /* synthetic */ TextView s(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237701);
        TextView recordRemainTimeText = editorAudioView.getRecordRemainTimeText();
        AppMethodBeat.o(237701);
        return recordRemainTimeText;
    }

    public static final /* synthetic */ WeImageView t(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237702);
        WeImageView deleteSubIcon = editorAudioView.getDeleteSubIcon();
        AppMethodBeat.o(237702);
        return deleteSubIcon;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorAudioView(final Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(75968);
        this.Cbn = kotlin.g.ah(new o(this));
        this.Cbo = kotlin.g.ah(new p(this));
        this.Cbp = kotlin.g.ah(new n(this));
        this.Cbu = android.support.v4.content.b.n(context, R.color.act);
        this.Cbv = R.raw.popvideo_post_selected_origin;
        this.Cbx = kotlin.g.ah(new ah(this));
        this.Cby = kotlin.g.ah(new e(this));
        this.Cbz = kotlin.g.ah(new g(this));
        this.CbA = kotlin.g.ah(new f(this));
        this.CbB = kotlin.g.ah(new d(this));
        this.CbC = kotlin.g.ah(new w(this));
        this.CbD = kotlin.g.ah(new y(this));
        this.CbE = kotlin.g.ah(new x(this));
        this.CbF = kotlin.g.ah(new r(this));
        this.CbG = kotlin.g.ah(new ai(this));
        this.udQ = kotlin.g.ah(new i(this));
        this.CbH = kotlin.g.ah(new h(this));
        this.CbI = kotlin.g.ah(new k(this));
        this.CbJ = kotlin.g.ah(new ag(this));
        this.CbK = kotlin.g.ah(new u(this));
        this.CbL = kotlin.g.ah(new q(this));
        this.CbM = kotlin.g.ah(new t(this));
        this.CbN = kotlin.g.ah(new s(this));
        this.CbO = kotlin.g.ah(new j(this));
        this.CbP = kotlin.g.ah(new v(this));
        this.CbQ = kotlin.g.ah(aj.Ccy);
        this.CbR = new ArrayList();
        this.CbS = new ArrayList();
        this.CbT = new ArrayList();
        this.CbU = new ArrayList();
        this.Cca = "";
        this.Cci = new LinkedList<>();
        this.Ccn = true;
        this.wJT = new com.tencent.mm.vending.e.c<>();
        this.Ccq = new z(this);
        View.inflate(context, R.layout.bz_, this);
        View findViewById = findViewById(R.id.i79);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.story_audio_panel)");
        this.Cbf = findViewById;
        View findViewById2 = findViewById(R.id.iaf);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.story_esitor_search_btn)");
        this.Cbr = findViewById2;
        View findViewById3 = findViewById(R.id.i_2);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.story_editor_audio_recycler)");
        this.Cbg = (RecyclerView) findViewById3;
        View findViewById4 = findViewById(R.id.i_d);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.story_editor_audio_search_panel)");
        this.Cbs = (EditorAudioSearchView) findViewById4;
        View findViewById5 = findViewById(R.id.ibc);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.story_item_audio_search_icon)");
        this.Cbq = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.i_k);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.story_editor_audio_status_panel)");
        this.Cbt = (ViewGroup) findViewById6;
        this.Cbg.setLayoutManager(new LinearLayoutManager(0, false));
        this.Cce = new com.tencent.mm.plugin.recordvideo.ui.a.a();
        new ak().f(this.Cbg);
        this.Cbg.setAdapter(this.Cce);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, context.getResources().getDrawable(R.raw.icons_filled_search));
        stateListDrawable.addState(new int[0], ar.m(context, R.raw.icons_filled_search, com.tencent.mm.cb.a.n(context, R.color.act)));
        this.Cbq.setImageDrawable(stateListDrawable);
        this.Cce.rsD = new kotlin.g.a.m<Integer, AudioCacheInfo, kotlin.x>(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass1 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r2;
            }

            @Override // kotlin.g.a.m
            public final /* synthetic */ kotlin.x invoke(Integer num, AudioCacheInfo audioCacheInfo) {
                AppMethodBeat.i(75939);
                int intValue = num.intValue();
                AudioCacheInfo audioCacheInfo2 = audioCacheInfo;
                kotlin.g.b.p.h(audioCacheInfo2, "info");
                if (intValue != this.Ccs.Cce.getItemCount()) {
                    RecyclerView.LayoutManager layoutManager = this.Ccs.Cbg.getLayoutManager();
                    if (layoutManager == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                        AppMethodBeat.o(75939);
                        throw tVar;
                    }
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    int kt = linearLayoutManager.kt();
                    int kv = linearLayoutManager.kv();
                    int i2 = audioCacheInfo2.type;
                    AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                    if (i2 == AudioCacheInfo.BPi) {
                        RecyclerView recyclerView = this.Ccs.Cbg;
                        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(intValue, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$1", "invoke", "(ILcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$1", "invoke", "(ILcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                        EditorAudioView.a(this.Ccs, intValue);
                    } else if (kt <= intValue && kv >= intValue) {
                        EditorAudioView.a(this.Ccs, intValue);
                    } else {
                        RecyclerView recyclerView2 = this.Ccs.Cbg;
                        com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(intValue, new com.tencent.mm.hellhoundlib.b.a());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a3.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$1", "invoke", "(ILcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                        recyclerView2.smoothScrollToPosition(((Integer) a3.pG(0)).intValue());
                        com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$1", "invoke", "(ILcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    }
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(75939);
                return xVar;
            }
        };
        this.Cbg.a(this.Ccq);
        View findViewById7 = findViewById(R.id.i9z);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.story_…r_audio_mute_origin_icon)");
        this.Cbh = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.i9y);
        kotlin.g.b.p.g(findViewById8, "findViewById<View>(R.id.…editor_audio_mute_origin)");
        this.Cbk = findViewById8;
        this.Cbh.setImageDrawable(ar.m(context, this.Cbv, this.Cbw));
        this.Cbk.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass7 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75940);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.setMuteOrigin(!this.Ccs.getMuteOrigin());
                a callback = this.Ccs.getCallback();
                if (callback != null) {
                    callback.oR(this.Ccs.getMuteOrigin());
                }
                if (this.Ccs.getMuteOrigin()) {
                    this.Ccs.Cbh.setImageDrawable(ar.m(context, R.raw.ui_rescoures_checkbox_unselected, -1));
                } else {
                    this.Ccs.Cbh.setImageDrawable(ar.m(context, this.Ccs.Cbv, this.Ccs.Cbw));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75940);
            }
        });
        View findViewById9 = findViewById(R.id.i9t);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.story_editor_audio_lyrics_icon)");
        this.Cbj = (ImageView) findViewById9;
        View findViewById10 = findViewById(R.id.i9s);
        kotlin.g.b.p.g(findViewById10, "findViewById<View>(R.id.story_editor_audio_lyrics)");
        this.Cbm = findViewById10;
        View findViewById11 = findViewById(R.id.i9w);
        kotlin.g.b.p.g(findViewById11, "findViewById(R.id.story_…or_audio_mute_music_icon)");
        this.Cbi = (ImageView) findViewById11;
        View findViewById12 = findViewById(R.id.i9v);
        kotlin.g.b.p.g(findViewById12, "findViewById<View>(R.id.…_editor_audio_mute_music)");
        this.Cbl = findViewById12;
        this.Cbi.setImageDrawable(ar.m(context, this.Cbv, this.Cbw));
        this.Cbl.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass8 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75941);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EditorAudioView.d(this.Ccs, !this.Ccs.getWithMusic());
                if (!this.Ccs.getWithMusic()) {
                    a callback = this.Ccs.getCallback();
                    if (callback != null) {
                        callback.a(null);
                    }
                    this.Ccs.Cce.setSelection(null);
                    this.Ccs.Cbs.setSelection(null);
                    c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                    com.tencent.mm.plugin.recordvideo.model.audio.c cVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
                    if (cVar != null) {
                        cVar.BPx = false;
                        clo clo = new clo();
                        clo.MqO = cVar.BPv;
                        clo.MqP = 8;
                        clo.MqR = (int) Util.nowSecond();
                        cVar.BPy.add(clo);
                        Log.i(com.tencent.mm.plugin.recordvideo.model.audio.c.TAG, "record no bgm " + com.tencent.mm.plugin.recordvideo.model.audio.d.a(clo));
                    }
                    this.Ccs.Ccl = false;
                    this.Ccs.Cbj.setImageDrawable(ar.m(context, R.raw.ui_rescoures_checkbox_unselected, -1));
                } else if (this.Ccs.Ccf != -1) {
                    EditorAudioView.a(this.Ccs, this.Ccs.Ccf);
                } else {
                    EditorAudioSearchView editorAudioSearchView = this.Ccs.Cbs;
                    editorAudioSearchView.VS(editorAudioSearchView.CaW);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75941);
            }
        });
        this.Cbj.setImageDrawable(ar.m(context, R.raw.ui_rescoures_checkbox_unselected, -1));
        this.Cbm.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass9 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75942);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.tw(!this.Ccs.Ccl);
                com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.VI(20);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75942);
            }
        });
        getRecordIcon().setImageDrawable(ar.m(context, R.raw.icons_filled_mike, context.getResources().getColor(R.color.ag1)));
        getRecordEntrance().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass10 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(75943);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Context context = context;
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(75943);
                    throw tVar;
                }
                if (com.tencent.mm.pluginsdk.permission.b.a((Activity) context, "android.permission.RECORD_AUDIO", 84, "", "")) {
                    EditorAudioView.B(this.Ccs);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(75943);
            }
        });
        getRecordControlButton().VU(context.getResources().getColor(R.color.Orange));
        getRecordControlButton().setLongPressCallback(new MMEditorRecordButton.b(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass11 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.b
            public final void jK() {
                AppMethodBeat.i(237621);
                EditorAudioView.C(this.Ccs);
                AppMethodBeat.o(237621);
            }

            @Override // com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.b
            public final void cJI() {
                AppMethodBeat.i(237622);
                EditorAudioView.D(this.Ccs);
                AppMethodBeat.o(237622);
            }
        });
        getCloseIcon().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass12 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237623);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.getRecordResult().clear();
                this.Ccs.getRecordResult().addAll(this.Ccs.CbU);
                EditorAudioView.F(this.Ccs);
                EditorAudioView.q(this.Ccs).aJ(new ArrayList<>(this.Ccs.CbR));
                MMEditorRecordButton r = EditorAudioView.r(this.Ccs);
                Float f2 = (Float) kotlin.a.j.kv(this.Ccs.CbR);
                r.bi(f2 != null ? f2.floatValue() : 0.0f);
                if (this.Ccs.ipC) {
                    EditorAudioView.q(this.Ccs).eKU();
                }
                TextView s = EditorAudioView.s(this.Ccs);
                kotlin.g.b.p.g(s, "recordRemainTimeText");
                s.setVisibility(8);
                MMEditorRecordButton r2 = EditorAudioView.r(this.Ccs);
                kotlin.g.b.p.g(r2, "recordControlButton");
                r2.setVisibility(8);
                EditorAudioView.G(this.Ccs);
                EditorAudioView.H(this.Ccs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237623);
            }
        });
        getDoneIcon().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass13 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237624);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EditorAudioView.G(this.Ccs);
                EditorAudioView.H(this.Ccs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237624);
            }
        });
        getCenterCloseGroup().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass14 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237625);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.setShow(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237625);
            }
        });
        getAudioTab().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass2 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237616);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.VT(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237616);
            }
        });
        getRecordTab().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass3 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237617);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.VT(1);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237617);
            }
        });
        getCloseIcon().setImageDrawable(ar.m(context, R.raw.icons_outlined_close, context.getResources().getColor(R.color.ag1)));
        getDoneIcon().setImageDrawable(ar.m(context, R.raw.icons_outlined_done, context.getResources().getColor(R.color.Orange)));
        getDeleteSubIcon().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass4 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237618);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EditorAudioView.q(this.Ccs).rl(true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237618);
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass5 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237619);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.setShow(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237619);
            }
        });
        this.Cbr.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.AnonymousClass6 */
            final /* synthetic */ EditorAudioView Ccs;

            {
                this.Ccs = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(237620);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.Ccs.Cce.setSelection(null);
                a callback = this.Ccs.getCallback();
                if (callback != null) {
                    AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                    AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
                    audioCacheInfo.type = AudioCacheInfo.BPi;
                    callback.a(audioCacheInfo);
                }
                EditorAudioView.b(this.Ccs, true);
                EditorAudioView.c(this.Ccs, false);
                c.a aVar2 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c cVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
                if (cVar != null) {
                    clo clo = new clo();
                    clo.MqP = 14;
                    clo.MqR = (int) Util.nowSecond();
                    cVar.BPy.add(clo);
                    Log.i(com.tencent.mm.plugin.recordvideo.model.audio.c.TAG, "record enter search " + com.tencent.mm.plugin.recordvideo.model.audio.d.a(clo));
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKX().ahk();
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.eKY().ahO();
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.VI(17);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(237620);
            }
        });
        this.Cbf.setTranslationY(getResources().getDimension(R.dimen.akx));
        eLT();
        this.Cbs.setCallback(new l(this));
        AppMethodBeat.o(75968);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EditorAudioView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(75969);
        AppMethodBeat.o(75969);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(237697);
        AppMethodBeat.o(237697);
    }

    public final List<kotlin.r<String, Long, Long>> getRecordResult() {
        return this.CbS;
    }

    public final c getRecordCallback() {
        return this.Ccd;
    }

    public final void setRecordCallback(c cVar) {
        this.Ccd = cVar;
    }

    public final boolean getMuteOriginDefault() {
        return this.Ccj;
    }

    public final void setMuteOriginDefault(boolean z2) {
        this.Ccj = z2;
    }

    public final boolean getMuteOrigin() {
        return this.BNc;
    }

    public final void setMuteOrigin(boolean z2) {
        this.BNc = z2;
    }

    public final boolean getWithMusic() {
        return this.Cck;
    }

    public final void setWithMusic(boolean z2) {
        this.Cck = z2;
    }

    public final a getCallback() {
        return this.Cco;
    }

    public final void setCallback(a aVar) {
        this.Cco = aVar;
    }

    public static final class z extends RecyclerView.l {
        final /* synthetic */ EditorAudioView Ccs;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(237646);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(237646);
        }

        z(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(75950);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(75950);
                    throw tVar;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int kv = linearLayoutManager.kv();
                RecyclerView.a adapter = recyclerView.getAdapter();
                if (adapter == null) {
                    kotlin.g.b.p.hyc();
                }
                kotlin.g.b.p.g(adapter, "recyclerView.adapter!!");
                if (kv == adapter.getItemCount() - 1) {
                    EditorAudioView editorAudioView = this.Ccs;
                    RecyclerView.a adapter2 = recyclerView.getAdapter();
                    if (adapter2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    kotlin.g.b.p.g(adapter2, "recyclerView.adapter!!");
                    EditorAudioView.a(editorAudioView, adapter2.getItemCount() - 1);
                } else {
                    int ks = linearLayoutManager.ks();
                    EditorAudioView.a(this.Ccs, (linearLayoutManager.ku() + ks) / 2);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(75950);
        }
    }

    private final List<ckm> getLyricsItemInfos() {
        ArrayList<AudioCacheInfo.c> arrayList;
        AppMethodBeat.i(75956);
        AudioCacheInfo VR = this.Cce.VR(this.Ccf);
        ArrayList arrayList2 = new ArrayList();
        if (!(VR == null || (arrayList = VR.BOY) == null)) {
            for (T t2 : arrayList) {
                ckm ckm = new ckm();
                ckm.lyrics = t2.BPp;
                ckm.startTime = (long) t2.dvv;
                arrayList2.add(ckm);
            }
        }
        ArrayList arrayList3 = arrayList2;
        AppMethodBeat.o(75956);
        return arrayList3;
    }

    public final void tw(boolean z2) {
        AppMethodBeat.i(169943);
        this.Ccl = z2;
        List<ckm> lyricsItemInfos = getLyricsItemInfos();
        if (z2) {
            this.Cbj.setImageDrawable(ar.m(getContext(), this.Cbv, this.Cbw));
            a aVar = this.Cco;
            if (aVar != null) {
                aVar.e(true, lyricsItemInfos);
            }
            tx(true);
            aN(this.Ccf, false);
            AppMethodBeat.o(169943);
            return;
        }
        this.Cbj.setImageDrawable(ar.m(getContext(), R.raw.ui_rescoures_checkbox_unselected, -1));
        a aVar2 = this.Cco;
        if (aVar2 != null) {
            aVar2.e(false, lyricsItemInfos);
            AppMethodBeat.o(169943);
            return;
        }
        AppMethodBeat.o(169943);
    }

    public final void setPlayMusicWhenSearchFinish(boolean z2) {
        this.Ccn = z2;
    }

    public static /* synthetic */ void a(EditorAudioView editorAudioView, int i2) {
        AppMethodBeat.i(75960);
        editorAudioView.aN(i2, false);
        AppMethodBeat.o(75960);
    }

    public final void aN(int i2, boolean z2) {
        int i3 = 0;
        boolean z3 = true;
        AppMethodBeat.i(75959);
        if (z2 || this.Cce.va != i2) {
            this.Ccf = i2;
            AudioCacheInfo VR = this.Cce.VR(i2);
            if (VR != null) {
                int i4 = VR.type;
                AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                if (i4 == AudioCacheInfo.BPk) {
                    a aVar2 = this.Cco;
                    if (aVar2 != null) {
                        aVar2.a(VR);
                        AppMethodBeat.o(75959);
                        return;
                    }
                    AppMethodBeat.o(75959);
                    return;
                }
            }
            if (VR != null) {
                int i5 = VR.type;
                AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
                if (i5 == AudioCacheInfo.BPi) {
                    this.Cce.setSelection(null);
                    a aVar4 = this.Cco;
                    if (aVar4 != null) {
                        aVar4.a(VR);
                    }
                    ty(true);
                    setShowAudioPanel(false);
                    AppMethodBeat.o(75959);
                    return;
                }
            }
            this.Cce.setSelection(Integer.valueOf(i2));
            a aVar5 = this.Cco;
            if (aVar5 != null) {
                aVar5.a(VR);
            }
            tx(true);
            if (VR == null || !VR.BNb) {
                z3 = false;
            }
            if (this.BNb) {
                View view = this.Cbm;
                if (!z3) {
                    i3 = 4;
                }
                view.setVisibility(i3);
            }
            if (this.Ccl) {
                List<ckm> lyricsItemInfos = getLyricsItemInfos();
                a aVar6 = this.Cco;
                if (aVar6 != null) {
                    aVar6.e(z3, lyricsItemInfos);
                    AppMethodBeat.o(75959);
                    return;
                }
            }
        }
        AppMethodBeat.o(75959);
    }

    public static /* synthetic */ void a(EditorAudioView editorAudioView, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, boolean z2, int i2) {
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        Integer num17;
        AppMethodBeat.i(237681);
        if ((i2 & 16) != 0) {
            num4 = null;
        }
        if ((i2 & 32) != 0) {
            num5 = null;
        }
        if ((i2 & 64) != 0) {
            num6 = null;
        }
        if ((i2 & 128) != 0) {
            num13 = null;
        } else {
            num13 = num7;
        }
        if ((i2 & 256) != 0) {
            num14 = null;
        } else {
            num14 = num8;
        }
        if ((i2 & 512) != 0) {
            num15 = null;
        } else {
            num15 = num9;
        }
        if ((i2 & 1024) != 0) {
            num16 = null;
        } else {
            num16 = num10;
        }
        if ((i2 & 2048) != 0) {
            num17 = null;
        } else {
            num17 = num11;
        }
        if ((i2 & 4096) != 0) {
            num12 = null;
        }
        if ((i2 & 8192) != 0) {
            z2 = false;
        }
        View centerCloseGroup = editorAudioView.getCenterCloseGroup();
        kotlin.g.b.p.g(centerCloseGroup, "centerCloseGroup");
        centerCloseGroup.setVisibility(z2 ? 0 : 4);
        if (!(num4 == null || num4.intValue() == 0)) {
            editorAudioView.Cbu = android.support.v4.content.b.n(editorAudioView.getContext(), num4.intValue());
            editorAudioView.getMuteMusicText().setTextColor(editorAudioView.Cbu);
            editorAudioView.getMuteOriginText().setTextColor(editorAudioView.Cbu);
            editorAudioView.getLyricsText().setTextColor(editorAudioView.Cbu);
        }
        if (!(num6 == null || num6.intValue() == 0)) {
            editorAudioView.Cbw = android.support.v4.content.b.n(editorAudioView.getContext(), num6.intValue());
        }
        if (!(num5 == null || num5.intValue() == 0)) {
            editorAudioView.Cbv = num5.intValue();
        }
        editorAudioView.Cce.a(num13, num14, num15, num16, num17);
        if (!(num12 == null || num12.intValue() == 0)) {
            editorAudioView.Cbr.setBackground(com.tencent.mm.cb.a.l(editorAudioView.getContext(), num12.intValue()));
        }
        if (!editorAudioView.BNc) {
            editorAudioView.Cbh.setImageDrawable(ar.m(editorAudioView.getContext(), editorAudioView.Cbv, editorAudioView.Cbw));
        }
        if (editorAudioView.Cck) {
            editorAudioView.Cbi.setImageDrawable(ar.m(editorAudioView.getContext(), editorAudioView.Cbv, editorAudioView.Cbw));
        }
        if (editorAudioView.Ccl) {
            editorAudioView.Cbj.setImageDrawable(ar.m(editorAudioView.getContext(), editorAudioView.Cbv, editorAudioView.Cbw));
        }
        EditorAudioSearchView editorAudioSearchView = editorAudioView.Cbs;
        com.tencent.mm.plugin.recordvideo.ui.a.a aVar = editorAudioSearchView.CaV;
        if (aVar != null) {
            com.tencent.mm.plugin.recordvideo.ui.a.a.a(aVar, num14);
        }
        Button button = editorAudioSearchView.nAa;
        if (button != null) {
            if (!(num == null || num.intValue() == 0)) {
                button.setBackgroundResource(num.intValue());
            }
            if (!(num2 == null || num2.intValue() == 0 || !(button instanceof TextView))) {
                button.setTextColor(android.support.v4.content.b.n(button.getContext(), num2.intValue()));
            }
        }
        if (!(editorAudioSearchView.CaP == null || num3 == null || num3.intValue() == 0)) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                kotlin.g.b.p.g(declaredField, "TextView::class.java.get…eld(\"mCursorDrawableRes\")");
                declaredField.setAccessible(true);
                declaredField.set(editorAudioSearchView.CaP, num3);
                AppMethodBeat.o(237681);
                return;
            } catch (Exception e2) {
                Log.e(editorAudioSearchView.TAG, "fail to reset editView cursor style: " + editorAudioSearchView.CaP + ", " + num3);
            }
        }
        AppMethodBeat.o(237681);
    }

    public static /* synthetic */ void a(EditorAudioView editorAudioView, String str, ArrayList arrayList, long j2, long j3, boolean z2, com.tencent.mm.plugin.recordvideo.b.d dVar, boolean z3, int i2) {
        AppMethodBeat.i(237683);
        editorAudioView.a(str, (i2 & 2) != 0 ? new ArrayList() : arrayList, j2, j3, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? new com.tencent.mm.plugin.recordvideo.b.d() : dVar, (i2 & 64) != 0 ? false : z3);
        AppMethodBeat.o(237683);
    }

    private void a(String str, ArrayList<String> arrayList, long j2, long j3, boolean z2, com.tencent.mm.plugin.recordvideo.b.d dVar, boolean z3) {
        com.tencent.mm.plugin.recordvideo.model.audio.h gVar;
        boolean z4;
        AppMethodBeat.i(237682);
        kotlin.g.b.p.h(str, "videoPath");
        kotlin.g.b.p.h(arrayList, "imageList");
        kotlin.g.b.p.h(dVar, "config");
        if (z2) {
            dVar.BNd = false;
        }
        if (!Util.isNullOrNil(str)) {
            gVar = new com.tencent.mm.plugin.recordvideo.model.audio.h(this.wJT, str, j2, j3, dVar.BNf.ordinal());
        } else {
            gVar = new com.tencent.mm.plugin.recordvideo.model.audio.g(this.wJT, arrayList, dVar.BNf.ordinal());
        }
        this.Ccg = gVar;
        if (z3) {
            this.Ccg = null;
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar = this.Ccg;
        if (aVar != null) {
            aVar.callback = new ad(this);
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar2 = this.Ccg;
        if (aVar2 != null) {
            if (!dVar.BNa || !((a.C1638a) com.tencent.mm.plugin.recordvideo.b.a.a.BNL.aLT()).BNS) {
                z4 = false;
            } else {
                z4 = true;
            }
            aVar2.qdn = z4;
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar3 = this.Ccg;
        if (aVar3 != null) {
            aVar3.eJQ();
        }
        b(dVar);
        a(dVar);
        if (!this.Cch) {
            this.Cce.setSelection(-1);
            if (this.Cci.isEmpty()) {
                tx(false);
                AudioCacheInfo.a aVar4 = AudioCacheInfo.BPo;
                AudioCacheInfo audioCacheInfo = new AudioCacheInfo();
                audioCacheInfo.type = AudioCacheInfo.BPk;
                List<AudioCacheInfo> listOf = kotlin.a.j.listOf(audioCacheInfo);
                this.Cce.setSelection(-1);
                this.Cce.gj(listOf);
            } else {
                tx(true);
                this.Cce.gj(this.Cci);
                this.Cce.setSelection(0);
                a aVar5 = this.Cco;
                if (aVar5 != null) {
                    aVar5.a(this.Cci.getFirst());
                }
            }
        }
        eLS();
        AppMethodBeat.o(237682);
    }

    public final void eLS() {
        AppMethodBeat.i(237684);
        for (int childCount = this.Cbt.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Cbt.getChildAt(childCount);
            if (childCount != 0) {
                kotlin.g.b.p.g(childAt, "child");
                if (childAt.getVisibility() == 0 && (childAt instanceof LinearLayout)) {
                    ((LinearLayout) childAt).setGravity(8388613);
                    AppMethodBeat.o(237684);
                    return;
                }
            }
        }
        AppMethodBeat.o(237684);
    }

    public final void setLocalAudioList(List<AudioCacheInfo> list) {
        AppMethodBeat.i(237685);
        kotlin.g.b.p.h(list, "audioList");
        this.Cci.clear();
        this.Cci.addAll(list);
        AppMethodBeat.o(237685);
    }

    public final void setBackground(int i2) {
        AppMethodBeat.i(237686);
        this.Cbf.setBackgroundResource(i2);
        AppMethodBeat.o(237686);
    }

    public final void setMusicPlayer(com.google.android.exoplayer2.v vVar) {
        AppMethodBeat.i(75961);
        kotlin.g.b.p.h(vVar, "player");
        this.Cce.setMusicPlayer(vVar);
        this.Cbs.setMusicPlayer(vVar);
        AppMethodBeat.o(75961);
    }

    public final void back() {
        AppMethodBeat.i(237687);
        if (!this.Cbs.eLP()) {
            setShow(false);
        }
        AppMethodBeat.o(237687);
    }

    public final void eL(List<? extends clp> list) {
        AppMethodBeat.i(75962);
        kotlin.g.b.p.h(list, "audioList");
        ArrayList arrayList = new ArrayList(this.Cci);
        int i2 = 0;
        for (T t2 : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
            AudioCacheInfo a2 = AudioCacheInfo.a.a(t2, AudioCacheInfo.BPh);
            AudioCacheInfo.a aVar3 = AudioCacheInfo.BPo;
            a2.source = AudioCacheInfo.BPm;
            a2.position = i2;
            a2.BPd = getMusicRequestId();
            arrayList.add(a2);
            i2 = i3;
        }
        this.Cce.gj(arrayList);
        if (arrayList.size() > 0) {
            RecyclerView recyclerView = this.Cbg;
            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView", "addAudioList", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView", "addAudioList", "(Ljava/util/List;)V", "Undefined", "scrollToPosition", "(I)V");
            aN(0, false);
        }
        AppMethodBeat.o(75962);
    }

    public final ArrayList<AudioCacheInfo> getAllAudioCacheInfo() {
        return this.Cce.BZO;
    }

    public static final class l implements EditorAudioSearchView.a {
        final /* synthetic */ EditorAudioView Ccs;

        l(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.a
        public final void eLQ() {
            AppMethodBeat.i(75945);
            a callback = this.Ccs.getCallback();
            if (callback != null) {
                callback.pauseAudio();
                AppMethodBeat.o(75945);
                return;
            }
            AppMethodBeat.o(75945);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.a
        public final void b(AudioCacheInfo audioCacheInfo) {
            AppMethodBeat.i(75946);
            if (audioCacheInfo != null) {
                ArrayList arrayList = new ArrayList();
                AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                audioCacheInfo.type = AudioCacheInfo.BPh;
                AudioCacheInfo.a aVar2 = AudioCacheInfo.BPo;
                audioCacheInfo.source = AudioCacheInfo.BPn;
                arrayList.add(audioCacheInfo);
                com.tencent.mm.plugin.recordvideo.ui.a.a aVar3 = this.Ccs.Cce;
                ArrayList arrayList2 = arrayList;
                kotlin.g.b.p.h(arrayList2, "audios");
                aVar3.BZO.addAll(0, arrayList2);
                aVar3.notifyDataSetChanged();
                if (this.Ccs.Ccn) {
                    RecyclerView recyclerView = this.Ccs.Cbg;
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$initAudioSearchPanel$1", "onSearchAudioFinish", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$initAudioSearchPanel$1", "onSearchAudioFinish", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    EditorAudioView.a(this.Ccs, 0);
                } else {
                    this.Ccs.Cce.setSelection(0);
                    RecyclerView recyclerView2 = this.Ccs.Cbg;
                    com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, a3.axQ(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$initAudioSearchPanel$1", "onSearchAudioFinish", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                    recyclerView2.smoothScrollToPosition(((Integer) a3.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(recyclerView2, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView$initAudioSearchPanel$1", "onSearchAudioFinish", "(Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                }
                EditorAudioView.b(this.Ccs, false);
                EditorAudioView.c(this.Ccs, true);
                EditorAudioView.d(this.Ccs, true);
                a callback = this.Ccs.getCallback();
                if (callback != null) {
                    callback.b(audioCacheInfo);
                    AppMethodBeat.o(75946);
                    return;
                }
            }
            AppMethodBeat.o(75946);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.a
        public final void e(AudioCacheInfo audioCacheInfo) {
            a callback;
            AppMethodBeat.i(75947);
            if (audioCacheInfo != null) {
                int i2 = audioCacheInfo.type;
                AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
                if (i2 != AudioCacheInfo.BPj || (callback = this.Ccs.getCallback()) == null) {
                    AppMethodBeat.o(75947);
                    return;
                }
                callback.a(audioCacheInfo);
                AppMethodBeat.o(75947);
                return;
            }
            AppMethodBeat.o(75947);
        }

        @Override // com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioSearchView.a
        public final void eLR() {
            AppMethodBeat.i(75948);
            EditorAudioView.c(this.Ccs, true);
            EditorAudioView.b(this.Ccs, false);
            if (this.Ccs.getWithMusic()) {
                this.Ccs.aN(this.Ccs.Ccf, true);
            }
            AppMethodBeat.o(75948);
        }
    }

    private final void setShowAudioPanel(boolean z2) {
        AppMethodBeat.i(75963);
        if (z2) {
            this.Cbf.setVisibility(0);
            this.Cbf.animate().cancel();
            this.Cbf.animate().translationY(0.0f).start();
            AppMethodBeat.o(75963);
            return;
        }
        this.Cbf.animate().cancel();
        this.Cbf.animate().translationY((float) this.Cbf.getHeight()).withEndAction(new ac(this)).start();
        AppMethodBeat.o(75963);
    }

    public static final class ac implements Runnable {
        final /* synthetic */ EditorAudioView Ccs;

        ac(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        public final void run() {
            AppMethodBeat.i(75953);
            this.Ccs.Cbf.setVisibility(8);
            AppMethodBeat.o(75953);
        }
    }

    private final void tx(boolean z2) {
        AppMethodBeat.i(75964);
        if (!z2) {
            this.Cbi.setImageDrawable(ar.m(getContext(), R.raw.ui_rescoures_checkbox_unselected, -1));
        } else {
            this.Cbi.setImageDrawable(ar.m(getContext(), this.Cbv, this.Cbw));
        }
        this.Cck = z2;
        AppMethodBeat.o(75964);
    }

    private final void ty(boolean z2) {
        AppMethodBeat.i(75965);
        if (z2) {
            this.Cbs.setShow(true);
            AppMethodBeat.o(75965);
            return;
        }
        this.Cbs.setShow(false);
        AppMethodBeat.o(75965);
    }

    public final void setShow(boolean z2) {
        AppMethodBeat.i(75966);
        if (z2) {
            setVisibility(0);
            kotlin.g.a.b<? super Boolean, kotlin.x> bVar = this.Ccp;
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
            }
            this.Cbf.animate().cancel();
            this.Cbf.animate().translationY(0.0f).start();
            com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
            com.tencent.mm.plugin.recordvideo.model.a.eJP().post(new aa(this));
            AppMethodBeat.o(75966);
            return;
        }
        if (this.Ccc) {
            getCloseIcon().performClick();
        }
        if (this.Ccb == 1) {
            VT(0);
        }
        kotlin.g.a.b<? super Boolean, kotlin.x> bVar2 = this.Ccp;
        if (bVar2 != null) {
            bVar2.invoke(Boolean.FALSE);
        }
        this.Cbf.animate().cancel();
        this.Cbf.animate().translationY((float) this.Cbf.getHeight()).withEndAction(new ab(this)).start();
        AppMethodBeat.o(75966);
    }

    public static final class aa implements Runnable {
        final /* synthetic */ EditorAudioView Ccs;

        aa(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        public final void run() {
            com.tencent.mm.plugin.recordvideo.model.audio.a aVar;
            AppMethodBeat.i(75951);
            if (this.Ccs.Cch || (aVar = this.Ccs.Ccg) == null) {
                AppMethodBeat.o(75951);
                return;
            }
            aVar.cJk();
            AppMethodBeat.o(75951);
        }
    }

    public static final class ab implements Runnable {
        final /* synthetic */ EditorAudioView Ccs;

        ab(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        public final void run() {
            AppMethodBeat.i(75952);
            this.Ccs.setVisibility(8);
            AppMethodBeat.o(75952);
        }
    }

    public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, kotlin.x> bVar) {
        this.Ccp = bVar;
    }

    public final boolean bJw() {
        AppMethodBeat.i(237688);
        if (getVisibility() == 0 || this.Cbs.bJw()) {
            AppMethodBeat.o(237688);
            return true;
        }
        AppMethodBeat.o(237688);
        return false;
    }

    @Override // com.tencent.mm.ui.widget.InsectRelativeLayout
    public final boolean Gv(int i2) {
        AppMethodBeat.i(75967);
        View view = this.Cbf;
        if (view.getPaddingBottom() != i2) {
            view.post(new m(view, i2));
        }
        AppMethodBeat.o(75967);
        return true;
    }

    static final class m implements Runnable {
        final /* synthetic */ View Cct;
        final /* synthetic */ int Ccu;

        m(View view, int i2) {
            this.Cct = view;
            this.Ccu = i2;
        }

        public final void run() {
            AppMethodBeat.i(75949);
            this.Cct.setPadding(this.Cct.getPaddingLeft(), this.Cct.getPaddingTop(), this.Cct.getPaddingRight(), this.Ccu);
            this.Cct.requestLayout();
            AppMethodBeat.o(75949);
        }
    }

    public final void reset() {
        AppMethodBeat.i(237689);
        this.wJT.dead();
        this.wJT = new com.tencent.mm.vending.e.c<>();
        this.BNc = this.Ccj;
        if (this.BNc) {
            this.Cbh.setImageDrawable(ar.m(getContext(), R.raw.ui_rescoures_checkbox_unselected, -1));
        } else {
            this.Cbh.setImageDrawable(ar.m(getContext(), this.Cbv, this.Cbw));
        }
        this.Cck = false;
        this.Ccl = false;
        this.Cbi.setImageDrawable(ar.m(getContext(), this.Cbv, this.Cbw));
        this.Cbj.setImageDrawable(ar.m(getContext(), R.raw.ui_rescoures_checkbox_unselected, -1));
        this.Cbk.setVisibility(0);
        this.Cbl.setVisibility(0);
        if (this.BNb) {
            this.Cbm.setVisibility(0);
        } else {
            this.Cbm.setVisibility(8);
        }
        this.Cbs.reset();
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar = this.Ccg;
        if (aVar != null) {
            aVar.cancel = true;
        }
        this.Cch = false;
        AppMethodBeat.o(237689);
    }

    public final long getMusicRequestId() {
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar = this.Ccg;
        if (aVar != null) {
            return aVar.BOT;
        }
        return -1;
    }

    public final void destroy() {
        AppMethodBeat.i(237690);
        Log.i(TAG, "destroy");
        this.Ccm = true;
        this.wJT.dead();
        this.Cbs.reset();
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar = this.Ccg;
        if (aVar != null) {
            aVar.cancel = true;
        }
        com.tencent.mm.plugin.recordvideo.model.audio.a aVar2 = this.Ccg;
        if (aVar2 != null) {
            aVar2.callback = null;
            AppMethodBeat.o(237690);
            return;
        }
        AppMethodBeat.o(237690);
    }

    public final void eLT() {
        AppMethodBeat.i(237691);
        ViewGroup recordContainer = getRecordContainer();
        kotlin.g.b.p.g(recordContainer, "recordContainer");
        recordContainer.setVisibility(8);
        ViewGroup tabContainer = getTabContainer();
        kotlin.g.b.p.g(tabContainer, "tabContainer");
        tabContainer.setVisibility(8);
        AppMethodBeat.o(237691);
    }

    public final void VT(int i2) {
        AppMethodBeat.i(237692);
        this.Ccb = i2;
        if (i2 == 0) {
            TextView audioTabText = getAudioTabText();
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            audioTabText.setTextColor(context.getResources().getColor(R.color.ag2));
            View audioTabIndicator = getAudioTabIndicator();
            kotlin.g.b.p.g(audioTabIndicator, "audioTabIndicator");
            audioTabIndicator.setVisibility(0);
            ViewGroup audioContainer = getAudioContainer();
            kotlin.g.b.p.g(audioContainer, "audioContainer");
            audioContainer.setVisibility(0);
            TextView recordTabText = getRecordTabText();
            Context context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            recordTabText.setTextColor(context2.getResources().getColor(R.color.ag3));
            View recordTabIndicator = getRecordTabIndicator();
            kotlin.g.b.p.g(recordTabIndicator, "recordTabIndicator");
            recordTabIndicator.setVisibility(4);
            ViewGroup recordContainer = getRecordContainer();
            kotlin.g.b.p.g(recordContainer, "recordContainer");
            recordContainer.setVisibility(8);
            AppMethodBeat.o(237692);
            return;
        }
        TextView audioTabText2 = getAudioTabText();
        Context context3 = getContext();
        kotlin.g.b.p.g(context3, "context");
        audioTabText2.setTextColor(context3.getResources().getColor(R.color.ag3));
        View audioTabIndicator2 = getAudioTabIndicator();
        kotlin.g.b.p.g(audioTabIndicator2, "audioTabIndicator");
        audioTabIndicator2.setVisibility(4);
        ViewGroup audioContainer2 = getAudioContainer();
        kotlin.g.b.p.g(audioContainer2, "audioContainer");
        audioContainer2.setVisibility(8);
        TextView recordTabText2 = getRecordTabText();
        Context context4 = getContext();
        kotlin.g.b.p.g(context4, "context");
        recordTabText2.setTextColor(context4.getResources().getColor(R.color.ag2));
        View recordTabIndicator2 = getRecordTabIndicator();
        kotlin.g.b.p.g(recordTabIndicator2, "recordTabIndicator");
        recordTabIndicator2.setVisibility(0);
        ViewGroup recordContainer2 = getRecordContainer();
        kotlin.g.b.p.g(recordContainer2, "recordContainer");
        recordContainer2.setVisibility(0);
        AppMethodBeat.o(237692);
    }

    public final void tz(boolean z2) {
        AppMethodBeat.i(237693);
        if (z2) {
            eLW();
        }
        AppMethodBeat.o(237693);
    }

    private final void eLU() {
        int i2 = 0;
        AppMethodBeat.i(237694);
        this.CbR.clear();
        this.CbS.clear();
        if (!this.CbU.isEmpty()) {
            for (T t2 : this.CbU) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t3 = t2;
                float floatValue = (t3.second.floatValue() * 100.0f) / ((float) this.CbW);
                float floatValue2 = (t3.SWY.floatValue() * 100.0f) / ((float) this.CbW);
                if (floatValue2 <= 100.0f) {
                    this.CbR.add(Float.valueOf(floatValue2));
                    this.CbS.add(t3);
                    i2 = i3;
                } else {
                    if (floatValue <= 100.0f) {
                        this.CbR.add(Float.valueOf(100.0f));
                        this.CbS.add(t3);
                    }
                    i2 = i3;
                }
            }
        }
        AppMethodBeat.o(237694);
    }

    public final void eLV() {
        int i2 = 0;
        AppMethodBeat.i(237695);
        this.CbR.clear();
        if (!this.CbS.isEmpty()) {
            for (T t2 : this.CbS) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t3 = t2;
                float floatValue = (t3.second.floatValue() * 100.0f) / ((float) this.CbW);
                float floatValue2 = (t3.SWY.floatValue() * 100.0f) / ((float) this.CbW);
                if (floatValue2 <= 100.0f) {
                    this.CbR.add(Float.valueOf(floatValue2));
                    i2 = i3;
                } else {
                    if (floatValue <= 100.0f) {
                        this.CbR.add(Float.valueOf(100.0f));
                    }
                    i2 = i3;
                }
            }
        }
        getSubProgressBar().aJ(new ArrayList<>(this.CbR));
        AppMethodBeat.o(237695);
    }

    private final void eLW() {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(237696);
        this.Ccc = true;
        ViewGroup recordEntrance = getRecordEntrance();
        kotlin.g.b.p.g(recordEntrance, "recordEntrance");
        recordEntrance.setVisibility(8);
        MMEditorRecordButton recordControlButton = getRecordControlButton();
        kotlin.g.b.p.g(recordControlButton, "recordControlButton");
        recordControlButton.setVisibility(0);
        View recordTabIndicator = getRecordTabIndicator();
        kotlin.g.b.p.g(recordTabIndicator, "recordTabIndicator");
        recordTabIndicator.setVisibility(4);
        ImageView closeIcon = getCloseIcon();
        kotlin.g.b.p.g(closeIcon, "closeIcon");
        closeIcon.setVisibility(0);
        ImageView doneIcon = getDoneIcon();
        kotlin.g.b.p.g(doneIcon, "doneIcon");
        doneIcon.setVisibility(0);
        LinearLayout audioTab = getAudioTab();
        kotlin.g.b.p.g(audioTab, "audioTab");
        audioTab.setVisibility(8);
        View tabSpace = getTabSpace();
        kotlin.g.b.p.g(tabSpace, "tabSpace");
        tabSpace.setVisibility(8);
        this.CbT.clear();
        this.CbT.addAll(this.CbR);
        this.CbU.clear();
        this.CbU.addAll(this.CbS);
        eLU();
        if (!this.CbR.isEmpty()) {
            WeImageView deleteSubIcon = getDeleteSubIcon();
            kotlin.g.b.p.g(deleteSubIcon, "deleteSubIcon");
            deleteSubIcon.setVisibility(0);
            TextView recordRemainTimeText = getRecordRemainTimeText();
            kotlin.g.b.p.g(recordRemainTimeText, "recordRemainTimeText");
            recordRemainTimeText.setVisibility(0);
        }
        this.CbV = this.Cck;
        if (this.CbV) {
            this.Cbl.performClick();
        }
        float f2 = (float) this.CbW;
        Float f3 = (Float) kotlin.a.j.kv(this.CbR);
        this.CbX = (long) (((f3 != null ? f3.floatValue() : 0.0f) / 100.0f) * f2);
        c cVar = this.Ccd;
        if (cVar != null) {
            cVar.Ih(this.CbX);
        }
        if (this.CbX == this.CbW) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.ipC = z2;
        Log.d(TAG, "enterRecordPanel, curTimeMs:" + this.CbX + ", maxDurationMs:" + this.CbW);
        MMEditorRecordButton recordControlButton2 = getRecordControlButton();
        if (!this.ipC) {
            z3 = true;
        } else {
            z3 = false;
        }
        recordControlButton2.setTouchEnable(z3);
        if (this.ipC) {
            TextView recordRemainTimeText2 = getRecordRemainTimeText();
            kotlin.g.b.p.g(recordRemainTimeText2, "recordRemainTimeText");
            recordRemainTimeText2.setVisibility(8);
        }
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) (this.CbW - this.CbX)) / 1000.0f)}, 1));
        kotlin.g.b.p.g(format, "java.lang.String.format(this, *args)");
        TextView recordRemainTimeText3 = getRecordRemainTimeText();
        kotlin.g.b.p.g(recordRemainTimeText3, "recordRemainTimeText");
        recordRemainTimeText3.setText(getContext().getString(R.string.hwi, format));
        AppMethodBeat.o(237696);
    }

    public static final class ae implements c.a {
        final /* synthetic */ EditorAudioView Ccs;

        ae(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        @Override // com.tencent.mm.plugin.mmsight.model.a.c.a
        public final void aQY() {
            AppMethodBeat.i(237647);
            Log.d(EditorAudioView.TAG, "aacRecorder start");
            this.Ccs.ipv = true;
            this.Ccs.CbY = this.Ccs.CbX;
            c recordCallback = this.Ccs.getRecordCallback();
            if (recordCallback != null) {
                recordCallback.eLY();
                AppMethodBeat.o(237647);
                return;
            }
            AppMethodBeat.o(237647);
        }
    }

    public static final class af implements c.b {
        final /* synthetic */ EditorAudioView Ccs;

        af(EditorAudioView editorAudioView) {
            this.Ccs = editorAudioView;
        }

        @Override // com.tencent.mm.plugin.mmsight.model.a.c.b
        public final void aQX() {
            AppMethodBeat.i(237651);
            Log.d(EditorAudioView.TAG, "aacRecorder stop");
            EditorAudioView.l(this.Ccs).finish();
            this.Ccs.ipv = false;
            this.Ccs.CbZ = this.Ccs.CbX;
            if (this.Ccs.ipC) {
                this.Ccs.CbZ = this.Ccs.CbW;
                this.Ccs.CbR.add(Float.valueOf(100.0f));
                EditorAudioView.q(this.Ccs).aJ(new ArrayList<>(this.Ccs.CbR));
                EditorAudioView.q(this.Ccs).eKU();
                EditorAudioView.r(this.Ccs).bi(100.0f);
                EditorAudioView.s(this.Ccs).post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.af.AnonymousClass1 */
                    final /* synthetic */ af Ccx;

                    {
                        this.Ccx = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(237648);
                        TextView s = EditorAudioView.s(this.Ccx.Ccs);
                        kotlin.g.b.p.g(s, "recordRemainTimeText");
                        s.setVisibility(8);
                        AppMethodBeat.o(237648);
                    }
                });
            } else {
                this.Ccs.CbR.add(Float.valueOf((((float) this.Ccs.CbZ) * 100.0f) / ((float) this.Ccs.CbW)));
                EditorAudioView.q(this.Ccs).aJ(new ArrayList<>(this.Ccs.CbR));
                EditorAudioView.s(this.Ccs).post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.af.AnonymousClass2 */
                    final /* synthetic */ af Ccx;

                    {
                        this.Ccx = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(237649);
                        TextView s = EditorAudioView.s(this.Ccx.Ccs);
                        kotlin.g.b.p.g(s, "recordRemainTimeText");
                        s.setVisibility(0);
                        AppMethodBeat.o(237649);
                    }
                });
            }
            EditorAudioView.t(this.Ccs).post(new Runnable(this) {
                /* class com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView.af.AnonymousClass3 */
                final /* synthetic */ af Ccx;

                {
                    this.Ccx = r1;
                }

                public final void run() {
                    AppMethodBeat.i(237650);
                    WeImageView t = EditorAudioView.t(this.Ccx.Ccs);
                    kotlin.g.b.p.g(t, "deleteSubIcon");
                    t.setVisibility(0);
                    AppMethodBeat.o(237650);
                }
            });
            this.Ccs.getRecordResult().add(new kotlin.r<>(this.Ccs.Cca, Long.valueOf(this.Ccs.CbY), Long.valueOf(this.Ccs.CbZ)));
            c recordCallback = this.Ccs.getRecordCallback();
            if (recordCallback != null) {
                recordCallback.eLZ();
                AppMethodBeat.o(237651);
                return;
            }
            AppMethodBeat.o(237651);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237635);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.i9x);
            AppMethodBeat.o(237635);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237636);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.i_0);
            AppMethodBeat.o(237636);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237634);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.i9u);
            AppMethodBeat.o(237634);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(237653);
            ViewGroup viewGroup = (ViewGroup) this.Ccs.findViewById(R.id.ig5);
            AppMethodBeat.o(237653);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(237627);
            LinearLayout linearLayout = (LinearLayout) this.Ccs.findViewById(R.id.vn);
            AppMethodBeat.o(237627);
            return linearLayout;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237629);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.vq);
            AppMethodBeat.o(237629);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(237628);
            View findViewById = this.Ccs.findViewById(R.id.vo);
            AppMethodBeat.o(237628);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(237626);
            ViewGroup viewGroup = (ViewGroup) this.Ccs.findViewById(R.id.i78);
            AppMethodBeat.o(237626);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class w extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(237643);
            LinearLayout linearLayout = (LinearLayout) this.Ccs.findViewById(R.id.gxk);
            AppMethodBeat.o(237643);
            return linearLayout;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class y extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237645);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.gxm);
            AppMethodBeat.o(237645);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class x extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(237644);
            View findViewById = this.Ccs.findViewById(R.id.gxl);
            AppMethodBeat.o(237644);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(237638);
            ViewGroup viewGroup = (ViewGroup) this.Ccs.findViewById(R.id.icj);
            AppMethodBeat.o(237638);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ai extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ai(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(237654);
            View findViewById = this.Ccs.findViewById(R.id.vp);
            AppMethodBeat.o(237654);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(237631);
            ImageView imageView = (ImageView) this.Ccs.findViewById(R.id.b4d);
            AppMethodBeat.o(237631);
            return imageView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(237630);
            View findViewById = this.Ccs.findViewById(R.id.aq5);
            AppMethodBeat.o(237630);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(237633);
            ImageView imageView = (ImageView) this.Ccs.findViewById(R.id.bt5);
            AppMethodBeat.o(237633);
            return imageView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<HorizontalSubProgressBar> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ag(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ HorizontalSubProgressBar invoke() {
            AppMethodBeat.i(237652);
            HorizontalSubProgressBar horizontalSubProgressBar = (HorizontalSubProgressBar) this.Ccs.findViewById(R.id.dq0);
            AppMethodBeat.o(237652);
            return horizontalSubProgressBar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class u extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(237641);
            ImageView imageView = (ImageView) this.Ccs.findViewById(R.id.gwy);
            AppMethodBeat.o(237641);
            return imageView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class q extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237637);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.gwi);
            AppMethodBeat.o(237637);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(237640);
            ViewGroup viewGroup = (ViewGroup) this.Ccs.findViewById(R.id.gwu);
            AppMethodBeat.o(237640);
            return viewGroup;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class s extends kotlin.g.b.q implements kotlin.g.a.a<MMEditorRecordButton> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ MMEditorRecordButton invoke() {
            AppMethodBeat.i(237639);
            MMEditorRecordButton mMEditorRecordButton = (MMEditorRecordButton) this.Ccs.findViewById(R.id.gwq);
            AppMethodBeat.o(237639);
            return mMEditorRecordButton;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(237632);
            WeImageView weImageView = (WeImageView) this.Ccs.findViewById(R.id.bmi);
            AppMethodBeat.o(237632);
            return weImageView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class v extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ EditorAudioView Ccs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(EditorAudioView editorAudioView) {
            super(0);
            this.Ccs = editorAudioView;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(237642);
            TextView textView = (TextView) this.Ccs.findViewById(R.id.gxf);
            AppMethodBeat.o(237642);
            return textView;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class aj extends kotlin.g.b.q implements kotlin.g.a.a<VideoTransPara> {
        public static final aj Ccy = new aj();

        static {
            AppMethodBeat.i(237656);
            AppMethodBeat.o(237656);
        }

        aj() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ VideoTransPara invoke() {
            AppMethodBeat.i(237655);
            com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
            kotlin.g.b.p.g(baZ, "SubCoreVideoControl.getCore()");
            VideoTransPara bbf = baZ.bbf();
            AppMethodBeat.o(237655);
            return bbf;
        }
    }

    public final void a(com.tencent.mm.plugin.recordvideo.b.d dVar) {
        AppMethodBeat.i(75957);
        this.Ccj = dVar.BNc;
        this.BNc = this.Ccj;
        if (dVar.BNd) {
            this.Cbk.setVisibility(0);
            if (this.BNc) {
                this.Cbh.setImageDrawable(ar.m(getContext(), R.raw.ui_rescoures_checkbox_unselected, -1));
                AppMethodBeat.o(75957);
                return;
            }
            this.Cbh.setImageDrawable(ar.m(getContext(), this.Cbv, this.Cbw));
            AppMethodBeat.o(75957);
            return;
        }
        this.Cbk.setVisibility(8);
        AppMethodBeat.o(75957);
    }

    public final void b(com.tencent.mm.plugin.recordvideo.b.d dVar) {
        AppMethodBeat.i(75958);
        this.BNb = dVar.BNb && ((a.C1638a) com.tencent.mm.plugin.recordvideo.b.a.a.BNL.aLT()).BNP;
        if (this.BNb) {
            this.Cbm.setVisibility(0);
            AppMethodBeat.o(75958);
            return;
        }
        this.Cbm.setVisibility(8);
        AppMethodBeat.o(75958);
    }

    public static final /* synthetic */ void C(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237704);
        Log.d(TAG, "startRecording");
        editorAudioView.Cca = com.tencent.mm.plugin.sight.base.b.eVt() + '/' + UUID.randomUUID();
        editorAudioView.zvN = new com.tencent.mm.plugin.mmsight.model.a.j(editorAudioView.Cca);
        com.tencent.mm.plugin.mmsight.model.a.p pVar = editorAudioView.zvN;
        if (pVar == null) {
            kotlin.g.b.p.btv("muxer");
        }
        editorAudioView.irD = new com.tencent.mm.plugin.mmsight.model.a.h(44100, editorAudioView.getVideoParams().audioBitrate, editorAudioView.getVideoParams().audioChannelCount, pVar, false);
        com.tencent.mm.plugin.mmsight.model.a.c cVar = editorAudioView.irD;
        if (cVar == null) {
            kotlin.g.b.p.btv("aacRecorder");
        }
        cVar.rc(false);
        com.tencent.mm.plugin.mmsight.model.a.c cVar2 = editorAudioView.irD;
        if (cVar2 == null) {
            kotlin.g.b.p.btv("aacRecorder");
        }
        cVar2.H(0, "");
        com.tencent.mm.plugin.mmsight.model.a.c cVar3 = editorAudioView.irD;
        if (cVar3 == null) {
            kotlin.g.b.p.btv("aacRecorder");
        }
        cVar3.ejW();
        com.tencent.mm.plugin.mmsight.model.a.c cVar4 = editorAudioView.irD;
        if (cVar4 == null) {
            kotlin.g.b.p.btv("aacRecorder");
        }
        cVar4.a(new ae(editorAudioView));
        AppMethodBeat.o(237704);
    }

    public static final /* synthetic */ void D(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237705);
        Log.d(TAG, "stopRecording");
        com.tencent.mm.plugin.mmsight.model.a.c cVar = editorAudioView.irD;
        if (cVar == null) {
            kotlin.g.b.p.btv("aacRecorder");
        }
        cVar.a(new af(editorAudioView));
        AppMethodBeat.o(237705);
    }

    public static final /* synthetic */ void G(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237707);
        editorAudioView.Ccc = false;
        ViewGroup recordEntrance = editorAudioView.getRecordEntrance();
        kotlin.g.b.p.g(recordEntrance, "recordEntrance");
        recordEntrance.setVisibility(0);
        MMEditorRecordButton recordControlButton = editorAudioView.getRecordControlButton();
        kotlin.g.b.p.g(recordControlButton, "recordControlButton");
        recordControlButton.setVisibility(8);
        View recordTabIndicator = editorAudioView.getRecordTabIndicator();
        kotlin.g.b.p.g(recordTabIndicator, "recordTabIndicator");
        recordTabIndicator.setVisibility(0);
        ImageView closeIcon = editorAudioView.getCloseIcon();
        kotlin.g.b.p.g(closeIcon, "closeIcon");
        closeIcon.setVisibility(4);
        ImageView doneIcon = editorAudioView.getDoneIcon();
        kotlin.g.b.p.g(doneIcon, "doneIcon");
        doneIcon.setVisibility(4);
        LinearLayout audioTab = editorAudioView.getAudioTab();
        kotlin.g.b.p.g(audioTab, "audioTab");
        audioTab.setVisibility(0);
        View tabSpace = editorAudioView.getTabSpace();
        kotlin.g.b.p.g(tabSpace, "tabSpace");
        tabSpace.setVisibility(0);
        WeImageView deleteSubIcon = editorAudioView.getDeleteSubIcon();
        kotlin.g.b.p.g(deleteSubIcon, "deleteSubIcon");
        deleteSubIcon.setVisibility(8);
        TextView recordRemainTimeText = editorAudioView.getRecordRemainTimeText();
        kotlin.g.b.p.g(recordRemainTimeText, "recordRemainTimeText");
        recordRemainTimeText.setVisibility(8);
        if (editorAudioView.CbV) {
            editorAudioView.Cbl.performClick();
        }
        c cVar = editorAudioView.Ccd;
        if (cVar != null) {
            cVar.eLX();
            AppMethodBeat.o(237707);
            return;
        }
        AppMethodBeat.o(237707);
    }

    public static final /* synthetic */ void H(EditorAudioView editorAudioView) {
        AppMethodBeat.i(237708);
        if (!editorAudioView.CbS.isEmpty()) {
            TextView recordBtnText = editorAudioView.getRecordBtnText();
            kotlin.g.b.p.g(recordBtnText, "recordBtnText");
            recordBtnText.setText(editorAudioView.getContext().getString(R.string.hwe));
        } else {
            TextView recordBtnText2 = editorAudioView.getRecordBtnText();
            kotlin.g.b.p.g(recordBtnText2, "recordBtnText");
            recordBtnText2.setText(editorAudioView.getContext().getString(R.string.hwf));
        }
        c cVar = editorAudioView.Ccd;
        if (cVar != null) {
            cVar.eMa();
            AppMethodBeat.o(237708);
            return;
        }
        AppMethodBeat.o(237708);
    }
}
