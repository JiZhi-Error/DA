package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v4.graphics.drawable.d;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001QB\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00104\u001a\u00020,2\u0006\u00105\u001a\u000203J\u0016\u00106\u001a\u00020,2\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010308J\u0006\u00109\u001a\u00020,J\u001e\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u00020,J\u0010\u0010?\u001a\u0004\u0018\u0001032\u0006\u0010@\u001a\u00020\nJ\b\u0010A\u001a\u00020\nH\u0016J\u0006\u0010B\u001a\u00020\u0017J\u0010\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u0005H\u0016J\u0018\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020+H\u0016J\u0018\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020K2\u0006\u0010;\u001a\u00020\nH\u0016J\u000e\u0010L\u001a\u00020,2\u0006\u00105\u001a\u000203J$\u0010M\u001a\u00020,2\u001c\u0010N\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010*J\u000e\u0010O\u001a\u00020,2\u0006\u0010;\u001a\u00020\nJ\u000e\u0010P\u001a\u00020,2\u0006\u00105\u001a\u000203R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010&\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR$\u0010)\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u00101\u001a\b\u0012\u0004\u0012\u000203028\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroid/view/View$OnClickListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/support/v7/widget/RecyclerView;Landroid/content/Context;)V", "bitmapHeight", "", "getBitmapHeight", "()I", "setBitmapHeight", "(I)V", "bitmapWidth", "getBitmapWidth", "setBitmapWidth", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isAttachWaitSmooth", "", "isLoadingAdded", "()Z", "setLoadingAdded", "(Z)V", "mCurrentHeight", "", "getMCurrentHeight", "()F", "setMCurrentHeight", "(F)V", "mCurrentIndex", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mMaxCount", "getMMaxCount", "setMMaxCount", "mOnItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "add", "bitmap", "addAll", "bitmapList", "", "addLoadingFooter", "applyCurrentThumbnail", FirebaseAnalytics.b.INDEX, "w", "h", "clear", "getItem", "position", "getItemCount", "isEmpty", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "onClick", "v", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "remove", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "switchToPage", "updateThumbNail", "Companion", "plugin-multitalk_release"})
public final class b extends RecyclerView.a<d> implements View.OnClickListener {
    private static final float radius = ((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2));
    public static final float zYI = ((float) f.zSu);
    public static final float zYJ = ((float) f.zSs);
    public static final float zYK = ((float) f.zSm);
    public static final a zYL = new a((byte) 0);
    private Context context;
    public int mMaxCount = -1;
    private RecyclerView mRecyclerView;
    public int rmJ = -1;
    public CopyOnWriteArrayList<Bitmap> zXD = new CopyOnWriteArrayList<>();
    public int zYB = -1;
    public int zYC = -1;
    public float zYD = zYI;
    public float zYE = zYJ;
    public boolean zYF;
    public m<? super View, ? super Integer, x> zYG;
    private boolean zYH;

    public b(RecyclerView recyclerView, Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(240078);
        this.mRecyclerView = recyclerView;
        this.context = context2;
        AppMethodBeat.o(240078);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ d a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(240073);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bdb, viewGroup, false);
        inflate.setOnClickListener(this);
        p.g(inflate, "thumbView");
        d dVar = new d(inflate);
        AppMethodBeat.o(240073);
        return dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(d dVar, int i2) {
        boolean z;
        AppMethodBeat.i(240076);
        d dVar2 = dVar;
        p.h(dVar2, "holder");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) this.zYD, (int) this.zYE);
        ImageView imageView = dVar2.zYN;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
        WeImageView weImageView = dVar2.zYM;
        if (weImageView != null) {
            weImageView.setLayoutParams(layoutParams);
        }
        if (this.rmJ != i2) {
            ImageView imageView2 = dVar2.zYN;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else {
            ImageView imageView3 = dVar2.zYN;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
        if (this.zYH) {
            this.zYH = false;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(this.rmJ, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "onBindViewHolder", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "onBindViewHolder", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
            }
        }
        if (!this.zXD.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z && i2 < this.zXD.size()) {
            android.support.v4.graphics.drawable.b a3 = d.a(this.context.getResources(), this.zXD.get(i2));
            p.g(a3, "RoundedBitmapDrawableFac… thumbnailList[position])");
            Paint paint = a3.getPaint();
            p.g(paint, "drawable.paint");
            paint.setAntiAlias(true);
            a3.setCornerRadius(radius);
            WeImageView weImageView2 = dVar2.zYM;
            if (weImageView2 != null) {
                weImageView2.setBackground(a3);
            }
        }
        WeImageView weImageView3 = dVar2.zYM;
        if (weImageView3 != null) {
            weImageView3.setClipToOutline(true);
        }
        WeImageView weImageView4 = dVar2.zYM;
        if (weImageView4 != null) {
            weImageView4.setOutlineProvider(new e(radius));
        }
        ImageView imageView4 = dVar2.zYN;
        if (imageView4 != null) {
            imageView4.setClipToOutline(true);
        }
        ImageView imageView5 = dVar2.zYN;
        if (imageView5 != null) {
            imageView5.setOutlineProvider(new e(radius));
        }
        View view = dVar2.aus;
        p.g(view, "holder.itemView");
        view.setTag(Integer.valueOf(i2));
        View view2 = dVar2.aus;
        p.g(view2, "holder.itemView");
        view2.setClipToOutline(true);
        View view3 = dVar2.aus;
        p.g(view3, "holder.itemView");
        view3.setOutlineProvider(new e(radius));
        AppMethodBeat.o(240076);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter$Companion;", "", "()V", "MAX_HEIGHT", "", "MAX_WIDTH", "MIN_WIDTH", "radius", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(240079);
        AppMethodBeat.o(240079);
    }

    public final void RB(int i2) {
        AppMethodBeat.i(240072);
        this.rmJ = i2;
        notifyDataSetChanged();
        AppMethodBeat.o(240072);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(240074);
        int size = this.zXD.size();
        AppMethodBeat.o(240074);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void b(RecyclerView recyclerView) {
        AppMethodBeat.i(240075);
        p.h(recyclerView, "recyclerView");
        super.b(recyclerView);
        this.zYH = true;
        AppMethodBeat.o(240075);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(240077);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.h(view, "v");
        m<? super View, ? super Integer, x> mVar = this.zYG;
        if (mVar != null) {
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(240077);
                throw tVar;
            }
            mVar.invoke(view, (Integer) tag);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240077);
    }
}
