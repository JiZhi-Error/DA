package com.tencent.mm.plugin.appbrand.menu.a;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

public final class d {

    public interface a {
        void K(View view, int i2);
    }

    public static final class b extends RecyclerView.a<a> {
        private final List<String> nfL;
        private final a nfM;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        @SuppressLint({"RecyclerView"})
        public final /* synthetic */ void a(a aVar, final int i2) {
            AppMethodBeat.i(134925);
            a aVar2 = aVar;
            aVar2.titleTv.setText(this.nfL.get(i2));
            aVar2.titleTv.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.menu.a.d.b.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(134922);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/menu/base/SecondaryMenuSheet$SecondaryMenuAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (b.this.nfM != null) {
                        b.this.nfM.K(view, i2);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/menu/base/SecondaryMenuSheet$SecondaryMenuAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(134922);
                }
            });
            AppMethodBeat.o(134925);
        }

        public b(List<String> list, a aVar) {
            AppMethodBeat.i(134923);
            this.nfL = new ArrayList(list);
            this.nfM = aVar;
            AppMethodBeat.o(134923);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(134924);
            int size = this.nfL.size();
            AppMethodBeat.o(134924);
            return size;
        }

        public class a extends RecyclerView.v {
            public TextView titleTv;

            public a(View view) {
                super(view);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(134926);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fj, viewGroup, false);
            a aVar = new a(inflate);
            aVar.titleTv = (TextView) inflate.findViewById(R.id.ipm);
            AppMethodBeat.o(134926);
            return aVar;
        }
    }
}
