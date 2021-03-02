package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter {
    private Context mContext;
    private int mNumColumns;
    private int omS;
    private int opk;
    private int qXG;
    List<ait> qXp;
    private boolean rnf;
    private LinearLayout.LayoutParams rng;
    private LinearLayout.LayoutParams rnh;
    AbstractC0964a rni;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.a$a  reason: collision with other inner class name */
    public interface AbstractC0964a {
        void FP(int i2);
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(109420);
        ait Gg = Gg(i2);
        AppMethodBeat.o(109420);
        return Gg;
    }

    public a(Context context) {
        AppMethodBeat.i(109414);
        this.mNumColumns = 3;
        this.rnf = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.qXG = com.tencent.mm.cb.a.jn(this.mContext);
        this.opk = this.mContext.getResources().getDimensionPixelSize(R.dimen.a2a);
        this.omS = (int) (((float) (this.qXG - (this.mNumColumns * this.opk))) / (((float) this.mNumColumns) + 1.0f));
        AppMethodBeat.o(109414);
    }

    public final void ad(List<ait> list) {
        AppMethodBeat.i(109415);
        if (this.qXp == null) {
            this.qXp = new ArrayList();
        } else {
            this.qXp.clear();
        }
        this.qXp = list;
        notifyDataSetChanged();
        AppMethodBeat.o(109415);
    }

    private int getRealCount() {
        AppMethodBeat.i(109416);
        if (this.qXp == null) {
            AppMethodBeat.o(109416);
            return 0;
        }
        int size = this.qXp.size();
        AppMethodBeat.o(109416);
        return size;
    }

    public final int getCount() {
        AppMethodBeat.i(109417);
        if (this.qXp == null) {
            AppMethodBeat.o(109417);
            return 0;
        }
        int ceil = (int) Math.ceil((double) (((float) this.qXp.size()) / ((float) this.mNumColumns)));
        AppMethodBeat.o(109417);
        return ceil;
    }

    public final ait Gg(int i2) {
        AppMethodBeat.i(109418);
        if (i2 < 0 || i2 >= getRealCount()) {
            AppMethodBeat.o(109418);
            return null;
        } else if (this.qXp == null) {
            AppMethodBeat.o(109418);
            return null;
        } else {
            ait ait = this.qXp.get(i2);
            AppMethodBeat.o(109418);
            return ait;
        }
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(109419);
        if (view == null || view.getTag() == null) {
            view = aa.jQ(this.mContext).inflate(R.layout.a3f, (ViewGroup) null);
            bVar = new b();
            bVar.qXM = (LinearLayout) view.findViewById(R.id.e22);
            bVar.qXM.setPadding(0, this.omS, 0, 0);
            view.setTag(bVar);
            for (int i3 = 0; i3 < this.mNumColumns; i3++) {
                this.rnh = new LinearLayout.LayoutParams(-2, -2);
                this.rnh.leftMargin = this.omS;
                this.rng = new LinearLayout.LayoutParams(this.opk, this.opk);
                PaddingImageView paddingImageView = new PaddingImageView(this.mContext);
                LinearLayout.LayoutParams layoutParams = this.rng;
                paddingImageView.addView(paddingImageView.cIN, layoutParams);
                paddingImageView.addView(paddingImageView.rnd, layoutParams);
                bVar.qXM.addView(paddingImageView, i3, this.rnh);
            }
        } else {
            bVar = (b) view.getTag();
        }
        for (int i4 = 0; i4 < this.mNumColumns; i4++) {
            final int i5 = (this.mNumColumns * i2) + i4;
            final PaddingImageView paddingImageView2 = (PaddingImageView) bVar.qXM.getChildAt(i4);
            if (i5 <= getRealCount() - 1) {
                ait Gg = Gg(i5);
                if (Gg != null) {
                    if (!Util.isNullOrNil(Gg.ThumbUrl)) {
                        com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
                        q.bcV().a(Gg.ThumbUrl, paddingImageView2.getImageView(), e.a(com.tencent.mm.emoji.e.a.EX(Gg.Md5), this.opk, new Object[0]));
                    } else if (!Util.isNullOrNil(Gg.Url)) {
                        com.tencent.mm.emoji.e.a aVar2 = com.tencent.mm.emoji.e.a.hdT;
                        k.cGc().a(Gg.Url, paddingImageView2.getImageView(), e.a(EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", Gg.Md5), this.opk, new Object[0]));
                    } else {
                        Log.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                    }
                    paddingImageView2.setClickable(true);
                    paddingImageView2.getImageViewFG().setBackgroundResource(R.drawable.emoji_grid_item_seq_fg);
                    paddingImageView2.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.emoji.ui.v2.a.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(109413);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (a.this.rni != null) {
                                a.this.rni.FP(i5);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/PreViewListGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(109413);
                        }
                    });
                } else {
                    paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                    q.bcV().loadImage("", paddingImageView2.getImageView());
                    Log.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
            } else {
                paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                q.bcV().loadImage("", paddingImageView2.getImageView());
                paddingImageView2.setClickable(false);
                paddingImageView2.setOnClickListener(null);
            }
        }
        AppMethodBeat.o(109419);
        return view;
    }

    class b {
        LinearLayout qXM;

        b() {
        }
    }
}
