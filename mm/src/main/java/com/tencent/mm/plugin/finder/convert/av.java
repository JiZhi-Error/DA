package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\"\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderLiveWeCoinHotConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setRankTv", "rankTv", "Landroid/widget/TextView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
public final class av extends e<am> {
    private final String TAG = "FinderLiveWeCoinHotConvert";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, am amVar, int i2, int i3, boolean z, List list) {
        Integer num;
        FinderContact finderContact;
        AppMethodBeat.i(243160);
        am amVar2 = amVar;
        p.h(hVar, "holder");
        p.h(amVar2, "item");
        if (i2 == 0) {
            RelativeLayout relativeLayout = (RelativeLayout) hVar.Mn(R.id.czf);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            TextView textView = (TextView) hVar.Mn(R.id.czg);
            if (textView != null) {
                Context context = hVar.getContext();
                p.g(context, "holder.context");
                Resources resources = context.getResources();
                y yVar = y.vXH;
                textView.setText(resources.getString(R.string.d0f, y.LT(amVar2.uOz)));
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.czc);
            if (textView2 != null) {
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                Resources resources2 = context2.getResources();
                y yVar2 = y.vXH;
                textView2.setText(resources2.getString(R.string.jc0, y.RN(amVar2.USw)));
            }
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) hVar.Mn(R.id.czf);
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) hVar.Mn(R.id.czj);
        if (textView3 != null) {
            avn avn = amVar2.uOA.uBm;
            avi avi = avn != null ? avn.LDK : null;
            int i4 = avi != null ? avi.LFV : 0;
            int i5 = avi != null ? avi.LFX : 0;
            int i6 = avn != null ? avn.LGi : 0;
            m mVar = m.vVH;
            m.hd(this.TAG, "setRankTv contact is empty:" + (avn == null) + ",position:" + i2 + ",badgeType:" + i4 + ",badgeLevel:" + i5 + ",rewardAmount:" + i6);
            if (i6 > 0) {
                int i7 = i2 + 1;
                textView3.setText(String.valueOf(i7));
                switch (i7) {
                    case 1:
                        Context context3 = MMApplicationContext.getContext();
                        p.g(context3, "MMApplicationContext.getContext()");
                        textView3.setTextColor(context3.getResources().getColor(R.color.pu));
                        textView3.setTextSize(1, 22.0f);
                        break;
                    case 2:
                        Context context4 = MMApplicationContext.getContext();
                        p.g(context4, "MMApplicationContext.getContext()");
                        textView3.setTextColor(context4.getResources().getColor(R.color.pw));
                        textView3.setTextSize(1, 22.0f);
                        break;
                    case 3:
                        Context context5 = MMApplicationContext.getContext();
                        p.g(context5, "MMApplicationContext.getContext()");
                        textView3.setTextColor(context5.getResources().getColor(R.color.pv));
                        textView3.setTextSize(1, 22.0f);
                        break;
                    default:
                        Context context6 = MMApplicationContext.getContext();
                        p.g(context6, "MMApplicationContext.getContext()");
                        textView3.setTextColor(context6.getResources().getColor(R.color.BW_100_Alpha_0_5));
                        textView3.setTextSize(1, 15.0f);
                        break;
                }
            } else {
                Log.e(this.TAG, "setRankTv contact is empty:" + (avn == null) + ",position:" + i2 + ",badgeType:" + i4 + ",badgeLevel:" + i5 + ",rewardAmount:" + i6);
            }
        }
        TextView textView4 = (TextView) hVar.Mn(R.id.cze);
        if (textView4 != null) {
            Context context7 = hVar.getContext();
            avn avn2 = amVar2.uOA.uBm;
            textView4.setText(com.tencent.mm.pluginsdk.ui.span.l.b(context7, (avn2 == null || (finderContact = avn2.contact) == null) ? null : finderContact.nickname, textView4.getTextSize()));
        }
        TextView textView5 = (TextView) hVar.Mn(R.id.czd);
        if (textView5 != null) {
            avn avn3 = amVar2.uOA.uBm;
            if (avn3 != null) {
                num = Integer.valueOf(avn3.LGi);
            } else {
                num = null;
            }
            textView5.setText(String.valueOf(num));
        }
        avn avn4 = amVar2.uOA.uBm;
        if ((avn4 != null ? avn4.Viq : 0) == 3) {
            WeImageView weImageView = (WeImageView) hVar.Mn(R.id.cme);
            if (weImageView != null) {
                weImageView.setVisibility(0);
                AppMethodBeat.o(243160);
                return;
            }
            AppMethodBeat.o(243160);
            return;
        }
        WeImageView weImageView2 = (WeImageView) hVar.Mn(R.id.cme);
        if (weImageView2 != null) {
            weImageView2.setVisibility(8);
            AppMethodBeat.o(243160);
            return;
        }
        AppMethodBeat.o(243160);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ag2;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243159);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.Mn(R.id.czj);
        ao.a(textView != null ? textView.getPaint() : null, 0.8f);
        AppMethodBeat.o(243159);
    }
}
