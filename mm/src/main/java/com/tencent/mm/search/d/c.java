package com.tencent.mm.search.d;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/search/ui/SimilarEmojiView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "dialog", "Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "(Landroid/content/Context;Lcom/tencent/mm/search/ui/SimilarEmojiDialog;)V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "dataManager", "Lcom/tencent/mm/search/data/ISimilarEmojiManager;", "getDialog", "()Lcom/tencent/mm/search/ui/SimilarEmojiDialog;", "enableSos", "", "recyclerView", "Lcom/tencent/mm/emoji/panel/EmojiPanelRecyclerView;", "loadData", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onClick", "v", "Landroid/view/View;", "release", "Companion", "plugin-emojisdk_release"})
public final class c extends RelativeLayout implements View.OnClickListener {
    public static final a NJL = new a((byte) 0);
    a INF = new a();
    com.tencent.mm.search.data.a NJJ = new com.tencent.mm.search.data.c();
    private final b NJK;
    boolean NJm = true;
    private EmojiPanelRecyclerView rgQ;

    static {
        AppMethodBeat.i(105883);
        AppMethodBeat.o(105883);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, b bVar) {
        super(context, null, 0);
        p.h(context, "context");
        AppMethodBeat.i(105882);
        this.NJK = bVar;
        this.NJJ.awy();
        setBackgroundColor(context.getResources().getColor(R.color.ac_));
        View inflate = LayoutInflater.from(context).inflate(R.layout.bta, (ViewGroup) this, true);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(105882);
            throw tVar;
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        relativeLayout.findViewById(R.id.b4g).setOnClickListener(this);
        View findViewById = relativeLayout.findViewById(R.id.c0_);
        p.g(findViewById, "parent.findViewById(R.id.emoji_list)");
        this.rgQ = (EmojiPanelRecyclerView) findViewById;
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        gridLayoutManager.a(new GridLayoutManager.b(this) {
            /* class com.tencent.mm.search.d.c.AnonymousClass1 */
            final /* synthetic */ c NJM;

            {
                this.NJM = r1;
            }

            @Override // android.support.v7.widget.GridLayoutManager.b
            public final int bX(int i2) {
                AppMethodBeat.i(105878);
                switch (this.NJM.INF.getItemViewType(i2)) {
                    case 100:
                    case 101:
                    case 105:
                    case 106:
                        int ki = gridLayoutManager.ki();
                        AppMethodBeat.o(105878);
                        return ki;
                    case 102:
                    case 103:
                    case 104:
                    default:
                        AppMethodBeat.o(105878);
                        return 1;
                }
            }
        });
        this.rgQ.setLayoutManager(gridLayoutManager);
        this.rgQ.setItemViewCacheSize(0);
        this.rgQ.setAdapter(this.INF);
        this.rgQ.avQ();
        this.rgQ.setScene(1);
        this.rgQ.setEmojiPopupType(3);
        this.INF.haK = new com.tencent.mm.search.b.b(ChatFooterPanel.KbC);
        AppMethodBeat.o(105882);
    }

    public final b getDialog() {
        return this.NJK;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/search/ui/SimilarEmojiView$Companion;", "", "()V", "SCENE_SimilarEmojiView", "", "TAG", "", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    static final class b implements i {
        final /* synthetic */ c NJM;
        final /* synthetic */ SimilarEmojiQueryModel NJN;

        b(c cVar, SimilarEmojiQueryModel similarEmojiQueryModel) {
            this.NJM = cVar;
            this.NJN = similarEmojiQueryModel;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(105880);
            if ((qVar instanceof com.tencent.mm.search.data.b) && i2 == 0 && i3 == 0) {
                com.tencent.mm.bw.a aYK = ((com.tencent.mm.search.data.b) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiResponse");
                    AppMethodBeat.o(105880);
                    throw tVar;
                }
                LinkedList<dkt> linkedList = ((dld) aYK).LVc;
                p.g(linkedList, "(rr.responseProtoBuf as …PanelEmojiResponse).Emoji");
                final LinkedList<dkt> linkedList2 = linkedList;
                Log.i("MicroMsg.SimilarEmoji", "get response success: " + linkedList2.size());
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.search.d.c.b.AnonymousClass1 */
                    final /* synthetic */ b NJO;

                    {
                        this.NJO = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(105879);
                        this.NJO.NJM.INF.setData(linkedList2);
                        if (this.NJO.NJN.gau()) {
                            com.tencent.mm.kernel.b.a ah = g.ah(d.class);
                            p.g(ah, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
                            EmojiInfo aml = ((d) ah).getEmojiMgr().aml(this.NJO.NJN.emojiMD5);
                            a aVar = this.NJO.NJM.INF;
                            p.g(aml, "head");
                            aVar.F(aml);
                        } else {
                            a.a(this.NJO.NJM.INF);
                        }
                        a aVar2 = this.NJO.NJM.INF;
                        aVar2.NJB = !linkedList2.isEmpty();
                        if (linkedList2.isEmpty()) {
                            this.NJO.NJM.INF.gxC();
                        }
                        if (this.NJO.NJM.NJm) {
                            this.NJO.NJM.INF.H(new EmojiInfo());
                        }
                        this.NJO.NJM.INF.notifyDataSetChanged();
                        ArrayList arrayList = new ArrayList();
                        List<dkt> list = linkedList2;
                        ArrayList arrayList2 = new ArrayList(j.a(list, 10));
                        for (dkt dkt : list) {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            com.tencent.mm.plugin.emoji.h.b.a(dkt.MOJ, emojiInfo);
                            if ((dkt.type & 1) == 0) {
                                emojiInfo.Vlo = 1;
                            }
                            if ((dkt.type & 1) == 0 && (dkt.type & 16) == 0) {
                                emojiInfo.Vln = 1;
                            }
                            emojiInfo.field_catalog = EmojiInfo.VkQ;
                            emojiInfo.field_groupId = dkt.MOJ.ProductID;
                            arrayList2.add(emojiInfo);
                        }
                        ArrayList arrayList3 = arrayList2;
                        int size = arrayList3.size() >= 8 ? 8 : arrayList3.size();
                        arrayList.addAll(arrayList3.subList(0, size));
                        com.tencent.mm.search.c.b bVar = com.tencent.mm.search.c.b.NJx;
                        com.tencent.mm.search.c.b.b(arrayList, (long) size);
                        AppMethodBeat.o(105879);
                    }
                });
                AppMethodBeat.o(105880);
                return;
            }
            Log.e("MicroMsg.SimilarEmoji", "get response fail. errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            this.NJM.INF.setData(new ArrayList());
            if (this.NJN.gau()) {
                com.tencent.mm.kernel.b.a ah = g.ah(d.class);
                p.g(ah, "plugin<IPluginEmoji>(IPluginEmoji::class.java)");
                EmojiInfo aml = ((d) ah).getEmojiMgr().aml(this.NJN.emojiMD5);
                a aVar = this.NJM.INF;
                p.g(aml, "head");
                aVar.F(aml);
            } else {
                a.a(this.NJM.INF);
            }
            this.NJM.INF.gxC();
            if (this.NJM.NJm) {
                this.NJM.INF.H(new EmojiInfo());
            }
            this.NJM.INF.notifyDataSetChanged();
            AppMethodBeat.o(105880);
        }
    }

    public final void onClick(View view) {
        b bVar;
        AppMethodBeat.i(105881);
        com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
        bVar2.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (!(valueOf == null || valueOf.intValue() != R.id.b4g || (bVar = this.NJK) == null)) {
            bVar.cancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/search/ui/SimilarEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(105881);
    }
}
