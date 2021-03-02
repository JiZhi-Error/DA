package com.tencent.mm.plugin.finder.megavideo.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "getLayoutId", "", "makeTimeString", "", "d", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class b extends e<bm> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, bm bmVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(248343);
        a(hVar, bmVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(248343);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public int getLayoutId() {
        return R.layout.agn;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(248341);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(248341);
    }

    private static String xt(int i2) {
        AppMethodBeat.i(248344);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(248344);
            return concat;
        }
        String str = String.valueOf(i2);
        AppMethodBeat.o(248344);
        return str;
    }

    public void a(h hVar, bm bmVar, int i2, int i3, boolean z, List<Object> list) {
        cnl cnl;
        LinkedList<cod> linkedList;
        cod cod;
        boolean z2;
        SpannableString c2;
        cnl cnl2;
        String str;
        cnl cnl3;
        AppMethodBeat.i(248342);
        p.h(hVar, "holder");
        p.h(bmVar, "item");
        cng cng = bmVar.tuP;
        if (cng == null || (cnl = cng.MtG) == null || (linkedList = cnl.media) == null || (cod = (cod) j.kt(linkedList)) == null) {
            AppMethodBeat.o(248342);
            return;
        }
        cjl a2 = com.tencent.mm.plugin.finder.storage.data.j.a(cod);
        ImageView imageView = (ImageView) hVar.Mn(R.id.imb);
        if (imageView != null) {
            k kVar = new k(a2, x.THUMB_IMAGE, null, null, 12);
            m mVar = m.uJa;
            d<o> djY = m.djY();
            m mVar2 = m.uJa;
            djY.a(kVar, imageView, m.a(m.a.TIMELINE));
        }
        TextView textView = (TextView) hVar.Mn(R.id.j4n);
        if (textView != null) {
            int i4 = a2.videoDuration;
            c cVar = c.vCb;
            if (((long) i4) >= ((long) c.drG()) * 1000) {
                i4 /= 1000;
            }
            textView.setText(xt(i4 / 60) + ":" + xt(i4 % 60));
        }
        TextView textView2 = (TextView) hVar.Mn(R.id.j4f);
        if (textView2 != null) {
            cng cng2 = bmVar.tuP;
            if (Util.isNullOrNil((cng2 == null || (cnl3 = cng2.MtG) == null) ? null : cnl3.description)) {
                Resources resources = textView2.getResources();
                Object[] objArr = new Object[1];
                Context context = textView2.getContext();
                FinderContact finderContact = bmVar.contact;
                objArr[0] = com.tencent.mm.pluginsdk.ui.span.l.c(context, finderContact != null ? finderContact.nickname : null);
                c2 = resources.getString(R.string.ezr, objArr);
            } else {
                Context context2 = hVar.getContext();
                cng cng3 = bmVar.tuP;
                c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context2, (cng3 == null || (cnl2 = cng3.MtG) == null || (str = cnl2.description) == null) ? "" : str);
            }
            textView2.setText(c2);
        }
        TextView textView3 = (TextView) hVar.Mn(R.id.j4w);
        if (textView3 != null) {
            String Lv = com.tencent.mm.plugin.finder.utils.k.Lv(bmVar.getFeedObject().likeCount);
            Context context3 = hVar.getContext();
            p.g(context3, "holder.context");
            textView3.setText(context3.getResources().getString(R.string.d0y, Lv));
        }
        TextView textView4 = (TextView) hVar.Mn(R.id.j4_);
        if (textView4 != null) {
            Context context4 = hVar.getContext();
            cng cng4 = bmVar.tuP;
            String f2 = com.tencent.mm.plugin.finder.utils.k.f(context4, (cng4 != null ? (long) cng4.iXu : 0) * 1000);
            if (!TextUtils.isEmpty(f2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                f2 = null;
            }
            textView4.setText("·" + f2);
            AppMethodBeat.o(248342);
            return;
        }
        AppMethodBeat.o(248342);
    }
}
