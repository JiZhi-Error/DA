package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class i extends BaseAdapter {
    int Ve;
    private Context mContext;
    int xGR;
    private aa xQe;

    public i(Context context) {
        this.mContext = context;
    }

    public final void a(aa aaVar) {
        AppMethodBeat.i(41981);
        this.xQe = aaVar;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(41980);
                i.this.notifyDataSetChanged();
                AppMethodBeat.o(41980);
            }
        });
        AppMethodBeat.o(41981);
    }

    public final int getCount() {
        AppMethodBeat.i(41982);
        if (this.xQe == null) {
            AppMethodBeat.o(41982);
            return 0;
        }
        int size = this.xQe.xHa.size();
        AppMethodBeat.o(41982);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(41983);
        aa.a aVar = this.xQe.xHa.get(i2);
        AppMethodBeat.o(41983);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    class a {
        public ImageView keC;
        public TextView uGh;
        public TextView xQg;
        public TextView xQh;
        public TextView xQi;
        GameDetailRankLikeView xQj;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(41984);
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.Ve, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.xQg = (TextView) inflate.findViewById(R.id.der);
            aVar.keC = (ImageView) inflate.findViewById(R.id.deo);
            aVar.uGh = (TextView) inflate.findViewById(R.id.deq);
            aVar.xQh = (TextView) inflate.findViewById(R.id.det);
            aVar.xQi = (TextView) inflate.findViewById(R.id.des);
            aVar.xQj = (GameDetailRankLikeView) inflate.findViewById(R.id.dep);
            aVar.xQj.setSourceScene(this.xGR);
            x((ViewGroup) inflate);
            inflate.setTag(aVar);
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        aa.a aVar2 = (aa.a) getItem(i2);
        aVar.xQg.setText(new StringBuilder().append(aVar2.xHb).toString());
        a.b.a(aVar.keC, aVar2.dWq, 0.5f, false);
        as Kn = ((l) g.af(l.class)).aSN().Kn(aVar2.dWq);
        if (Kn != null) {
            aVar.uGh.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, Kn.arJ(), aVar.uGh.getTextSize())));
        } else {
            aVar.uGh.setText("");
        }
        if (Util.isNullOrNil(aVar2.tag)) {
            aVar.xQh.setVisibility(8);
        } else {
            aVar.xQh.setVisibility(0);
            aVar.xQh.setText(aVar2.tag);
        }
        if (!Util.isNullOrNil(aVar2.xHe)) {
            aVar.xQi.setText(aVar2.xHe);
            aVar.xQj.setVisibility(8);
        } else {
            aVar.xQi.setText(new StringBuilder().append(aVar2.wXd).toString());
            GameDetailRankLikeView gameDetailRankLikeView = aVar.xQj;
            aa aaVar = this.xQe;
            gameDetailRankLikeView.xQk = aaVar;
            gameDetailRankLikeView.mAppId = aaVar.mAppId;
            gameDetailRankLikeView.xQl = aaVar.xHa.get(i2);
            gameDetailRankLikeView.rb();
            aVar.xQj.setVisibility(0);
        }
        AppMethodBeat.o(41984);
        return view;
    }

    private void x(ViewGroup viewGroup) {
        AppMethodBeat.i(41985);
        viewGroup.setClipChildren(false);
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                x((ViewGroup) childAt);
            }
        }
        AppMethodBeat.o(41985);
    }
}
