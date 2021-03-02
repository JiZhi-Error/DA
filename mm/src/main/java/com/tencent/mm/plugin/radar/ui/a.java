package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.ui.RadarSpecialGridView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\bH&J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0011R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "", "mGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "mContext", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "count", "", "getCount", "()I", "mColumn", "getMContext", "()Landroid/content/Context;", "getMGridView", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "fillDataToTable", "", "getChanged", "", "position", "getItem", "getView", "Landroid/view/View;", "convertView", "makeRow", "Landroid/widget/TableRow;", "notifyDataChanged", "Companion", "plugin-radar_release"})
public abstract class a {
    public static final C1624a Bzr = new C1624a((byte) 0);
    private static final String TAG = TAG;
    private int Bzp = 3;
    final RadarSpecialGridView Bzq;
    private final Context mContext;

    public abstract View ao(View view, int i2);

    public abstract int getCount();

    public a(RadarSpecialGridView radarSpecialGridView, Context context) {
        p.h(radarSpecialGridView, "mGridView");
        p.h(context, "mContext");
        this.Bzq = radarSpecialGridView;
        this.mContext = context;
    }

    public final void cax() {
        TableRow tableRow;
        if (this.Bzp == 0) {
            Log.e(TAG, "column is 0, pls check!");
            return;
        }
        int count = getCount();
        for (int i2 = 0; i2 < count; i2++) {
            int i3 = i2 / this.Bzp;
            int childCount = this.Bzq.getMTable().getChildCount();
            if (childCount > i3) {
                View childAt = this.Bzq.getMTable().getChildAt((childCount - 1) - i3);
                if (childAt == null) {
                    throw new t("null cannot be cast to non-null type android.widget.TableRow");
                }
                tableRow = (TableRow) childAt;
            } else {
                TableRow tableRow2 = new TableRow(this.mContext);
                tableRow2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.Bzq.getMTable().addView(tableRow2, 0);
                tableRow = tableRow2;
            }
            int i4 = i2 % this.Bzp;
            int childCount2 = tableRow.getChildCount();
            boolean z = childCount2 <= i4;
            View view = null;
            int i5 = (childCount2 - 1) - i4;
            if (!z) {
                view = tableRow.getChildAt(i5);
            }
            View ao = ao(view, i2);
            if (z) {
                tableRow.addView(ao, 0);
            } else if (ao != view) {
                tableRow.removeViewAt(i5);
                tableRow.addView(ao, i5);
            }
            ao.setOnClickListener(new b(this, i2));
        }
        Log.v(TAG, "mTable rows count : " + this.Bzq.getMTable().getChildCount());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ a Bzs;
        final /* synthetic */ int gUj;

        b(a aVar, int i2) {
            this.Bzs = aVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138585);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/GridDataAdapter$fillDataToTable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            RadarSpecialGridView.a onItemClickListener = this.Bzs.Bzq.getOnItemClickListener();
            if (onItemClickListener != null) {
                int i2 = this.gUj;
                p.g(view, "v");
                onItemClickListener.b(i2, view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/GridDataAdapter$fillDataToTable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(138585);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.a$a  reason: collision with other inner class name */
    public static final class C1624a {
        private C1624a() {
        }

        public /* synthetic */ C1624a(byte b2) {
            this();
        }
    }
}
