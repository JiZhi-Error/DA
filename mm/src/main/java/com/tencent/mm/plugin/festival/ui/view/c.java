package com.tencent.mm.plugin.festival.ui.view;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.render.h;
import com.tencent.mm.plugin.festival.finder.bo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003ABCJ\u0017\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020(2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-H&J\u0018\u0010.\u001a\u00020(2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-H&J\b\u0010/\u001a\u00020(H&J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H&J\u0018\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u000206H&J\u0010\u00107\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-H&J\b\u00108\u001a\u00020(H&J\b\u00109\u001a\u00020(H&J!\u0010:\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010;\u001a\u00020\u0014H&¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020(2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-H&J\b\u0010>\u001a\u00020(H&J\b\u0010?\u001a\u00020(H&J\b\u0010@\u001a\u00020(H&R(\u0010\u0003\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\u00020\u0014X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0019\u001a\u00020\u0014X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u0018\u0010$\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract;", "DATA", "Lcom/tencent/mm/plugin/festival/finder/FestivalLiveCanvasOverlayElementsPluginBase$ElementsViewContract;", "adapter", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "getAdapter", "()Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;", "setAdapter", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;)V", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getDuration", "()I", "setDuration", "(I)V", "intervalBetweenItem", "getIntervalBetweenItem", "setIntervalBetweenItem", "isCyclePlay", "", "()Z", "setCyclePlay", "(Z)V", "isStarted", "isTouchEnabled", "setTouchEnabled", "onDanmakuAppearListener", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;", "getOnDanmakuAppearListener", "()Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;", "setOnDanmakuAppearListener", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;)V", "paddingVertical", "getPaddingVertical", "setPaddingVertical", "rowCount", "getRowCount", "setRowCount", "addFirst", "", "data", "(Ljava/lang/Object;)V", "addFirstAll", "dataList", "", "addLastAll", "clear", "dispatchClickEvent", "pointF", "Landroid/graphics/PointF;", "getDanmakuLocation", "vh", "rectF", "Landroid/graphics/RectF;", "getDataList", "mount", "pause", "remove", "immediate", "(Ljava/lang/Object;Z)V", "removeAll", "resume", "start", "unMount", "Adapter", "DanmakuComparable", "OnDanmakuAppearListener", "plugin-festival_release"})
public interface c<DATA> extends bo.a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$DanmakuComparable;", "DATA", "", "canCompare", "", "o", "(Ljava/lang/Object;)Z", "compareTo", "", "(Ljava/lang/Object;)J", "plugin-festival_release"})
    public interface b<DATA> {
        boolean gS(DATA data);

        long gT(DATA data);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;", "DATA", "", "onDanmakuAppear", "", "data", "(Ljava/lang/Object;)V", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.ui.view.c$c  reason: collision with other inner class name */
    public interface AbstractC1084c<DATA> {
        void dw(DATA data);
    }

    void ab(List<? extends DATA> list);

    void addFirst(DATA data);

    boolean e(PointF pointF);

    List<DATA> getDataList();

    void h(DATA data, boolean z);

    boolean isStarted();

    void kX(List<? extends DATA> list);

    void kY(List<? extends DATA> list);

    @Override // com.tencent.mm.plugin.festival.finder.bo.a
    void pause();

    @Override // com.tencent.mm.plugin.festival.finder.bo.a
    void resume();

    void setAdapter(a<? extends a.C1083a, DATA> aVar);

    void setDuration(int i2);

    void setPaddingVertical(int i2);

    void setRowCount(int i2);

    void setTouchEnabled(boolean z);

    void start();

    void unMount();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004:\u0001\u000eJ\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0002H&¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\fH&¢\u0006\u0002\u0010\r¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;", "VH", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "DATA", "", "onBindViewHolder", "", "viewHolder", "data", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;Ljava/lang/Object;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "ViewHolder", "plugin-festival_release"})
    public interface a<VH extends C1083a, DATA> {
        void a(VH vh, DATA data);

        VH r(ViewGroup viewGroup);

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "Lcom/tencent/mm/danmaku/render/ViewDanmakuRender$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "isLaidOut", "", "()Z", "getItemView", "()Landroid/view/View;", "lastTouchUpPoint", "Landroid/graphics/PointF;", "getLastTouchUpPoint", "()Landroid/graphics/PointF;", "plugin-festival_release"})
        /* renamed from: com.tencent.mm.plugin.festival.ui.view.c$a$a  reason: collision with other inner class name */
        public static class C1083a extends h.a {
            public final PointF UEZ;
            private final boolean UFI;
            public final View aus;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1083a(View view) {
                super(view);
                p.h(view, "itemView");
                AppMethodBeat.i(263432);
                this.aus = view;
                this.UFI = ath() > 0 && ati() > 0;
                kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
                float hYV = kotlin.g.b.l.hYV();
                kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
                this.UEZ = new PointF(hYV, kotlin.g.b.l.hYV());
                AppMethodBeat.o(263432);
            }
        }
    }
}
