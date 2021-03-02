package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI7;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget;", "", "filterPanelRoot", "Landroid/widget/LinearLayout;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "(Landroid/widget/LinearLayout;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "TAG", "", "UNCHOOSE_TAG", "tag", "tagContentTxtView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "gotoTagUI", "", "hasNextAction", "", "isReady", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateLiveNote", "refreshTagInfo", "plugin-finder_release"})
public final class n {
    private final String TAG = "Finder.FinderLiveTagWidget";
    private final g liveData;
    private String tag = "";
    private final TextView uHu = ((TextView) this.uHw.findViewById(R.id.cy_));
    private final String uHv;
    private final LinearLayout uHw;

    public n(LinearLayout linearLayout, g gVar) {
        p.h(linearLayout, "filterPanelRoot");
        p.h(gVar, "liveData");
        AppMethodBeat.i(248153);
        this.uHw = linearLayout;
        this.liveData = gVar;
        String string = this.uHw.getContext().getString(R.string.cxs);
        p.g(string, "filterPanelRoot.context.…g.finder_live_not_choose)");
        this.uHv = string;
        djO();
        this.uHw.setClickable(true);
        AppMethodBeat.o(248153);
    }

    public final void djO() {
        s dpl;
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(248150);
        LinkedList<axk> linkedList = this.liveData.uiw;
        if (linkedList == null) {
            AppMethodBeat.o(248150);
        } else if (linkedList.isEmpty()) {
            this.uHw.setVisibility(8);
            AppMethodBeat.o(248150);
        } else {
            this.uHw.setVisibility(0);
            k kVar = k.vkd;
            k.dpl().auS("");
            TextView textView = this.uHu;
            p.g(textView, "tagContentTxtView");
            textView.setText(this.uHw.getContext().getString(R.string.czl));
            axk axk = this.liveData.uix;
            if (axk != null) {
                String str4 = axk.qHk;
                if (!(str4 == null || str4.length() == 0)) {
                    axk axk2 = axk.LHU;
                    String str5 = axk2 != null ? axk2.qHk : null;
                    if (!(str5 == null || str5.length() == 0)) {
                        TextView textView2 = this.uHu;
                        p.g(textView2, "tagContentTxtView");
                        axk axk3 = axk.LHU;
                        if (axk3 == null || axk3.LHV != 1) {
                            axk axk4 = axk.LHU;
                            if (axk4 != null) {
                                str3 = axk4.qHk;
                            }
                            k kVar2 = k.vkd;
                            dpl = k.dpl();
                            if (str3 == null) {
                                str = "";
                                str2 = str3;
                            } else {
                                str = str3;
                                str2 = str3;
                            }
                        } else {
                            StringBuilder append = new StringBuilder().append(axk.qHk).append('-');
                            axk axk5 = axk.LHU;
                            if (axk5 != null) {
                                str3 = axk5.qHk;
                            }
                            String sb = append.append(str3).toString();
                            k kVar3 = k.vkd;
                            dpl = k.dpl();
                            str = sb;
                            str2 = sb;
                        }
                        dpl.auS(str);
                        textView2.setText(this.uHw.getContext().getString(R.string.czm, str2));
                    }
                }
                TextView textView3 = this.uHu;
                p.g(textView3, "tagContentTxtView");
                textView3.setText(this.uHw.getContext().getString(R.string.czl));
            }
            k kVar4 = k.vkd;
            s dpl2 = k.dpl();
            TextView textView4 = this.uHu;
            p.g(textView4, "tagContentTxtView");
            dpl2.setTag(textView4.getText().toString());
            this.uHw.setOnClickListener(new b(this));
            AppMethodBeat.o(248150);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$1$2"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ n uHz;

        b(n nVar) {
            this.uHz = nVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248149);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uHz.nF(false);
            a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveTagWidget$refreshTagInfo$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248149);
        }
    }

    public final void nF(boolean z) {
        ArrayList arrayList;
        Intent intent;
        ArrayList arrayList2;
        AppMethodBeat.i(248151);
        Intent intent2 = new Intent();
        intent2.setClass(this.uHw.getContext(), OccupyFinderUI7.class);
        LinkedList<axk> linkedList = this.liveData.uiw;
        if (linkedList != null) {
            LinkedList<axk> linkedList2 = linkedList;
            ArrayList arrayList3 = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next().toByteArray());
            }
            arrayList = arrayList3;
            intent = intent2;
        } else {
            arrayList = null;
            intent = intent2;
        }
        if (!(arrayList instanceof Serializable)) {
            arrayList2 = null;
        } else {
            arrayList2 = arrayList;
        }
        intent.putExtra("KEY_TAG_INFO", arrayList2);
        intent2.putExtra("KEY_HAS_NEXT_ACTION", z);
        Context context = this.uHw.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(248151);
            throw tVar;
        }
        ((Activity) context).startActivityForResult(intent2, 1003);
        AppMethodBeat.o(248151);
    }

    public final boolean isReady() {
        AppMethodBeat.i(248152);
        if (this.liveData.uix != null) {
            axk axk = this.liveData.uix;
            String str = axk != null ? axk.qHk : null;
            if (!(str == null || str.length() == 0)) {
                AppMethodBeat.o(248152);
                return true;
            }
        }
        AppMethodBeat.o(248152);
        return false;
    }
}
