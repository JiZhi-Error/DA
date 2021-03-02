package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.album.a;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import java.util.ArrayList;
import java.util.List;

public final class c extends RecyclerView.a<b> {
    List<a.d> ETw = new ArrayList();
    a ETx = null;

    public interface a {
        void cw(int i2, String str);
    }

    public c() {
        AppMethodBeat.i(99872);
        AppMethodBeat.o(99872);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(b bVar, int i2) {
        int i3;
        AppMethodBeat.i(99874);
        b bVar2 = bVar;
        cnb cnb = c.this.ETw.get(i2).ETo;
        Log.d("MicroMsg.SnsAlbumItemAdapter", "onBind position:%s, obj.Type:%s", Integer.valueOf(i2), Integer.valueOf(cnb.oUv));
        aj.faL().a(cnb, bVar2.ETy, bVar2.ETy.getContext().hashCode(), g.a.IMG_SCENE_SNSUSER, bp.gCW());
        C1736c cVar = new C1736c();
        cVar.ecf = c.this.ETw.get(i2).ecf;
        cVar.mediaId = cnb.Id;
        bVar2.ETy.setTag(cVar);
        ImageView imageView = bVar2.kc;
        if (cnb.oUv == 6) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        AppMethodBeat.o(99874);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(99873);
        int size = this.ETw.size();
        AppMethodBeat.o(99873);
        return size;
    }

    class b extends RecyclerView.v {
        public QDisFadeImageView ETy = null;
        public ImageView kc = null;

        public b(View view) {
            super(view);
            AppMethodBeat.i(99871);
            this.ETy = (QDisFadeImageView) view.findViewById(R.id.hwj);
            this.kc = (ImageView) view.findViewById(R.id.hwk);
            this.kc.setImageDrawable(this.kc.getContext().getResources().getDrawable(R.raw.shortvideo_play_btn));
            this.ETy.setScaleType(QImageView.a.CENTER_CROP);
            this.ETy.setOnClickListener(new View.OnClickListener(c.this) {
                /* class com.tencent.mm.plugin.sns.ui.album.c.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(99870);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!(view.getTag() == null || !(view.getTag() instanceof C1736c) || c.this.ETx == null)) {
                        c.this.ETx.cw(((C1736c) view.getTag()).ecf, ((C1736c) view.getTag()).mediaId);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumItemAdapter$SnsAlbumItemViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99870);
                }
            });
            AppMethodBeat.o(99871);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.c$c  reason: collision with other inner class name */
    class C1736c {
        public int ecf;
        public String mediaId;

        C1736c() {
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ b a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(99875);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bv5, viewGroup, false));
        AppMethodBeat.o(99875);
        return bVar;
    }
}
