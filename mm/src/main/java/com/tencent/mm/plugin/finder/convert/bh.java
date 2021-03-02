package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0016JE\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "layoutResId", "", "scene", "(II)V", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;I)V", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showFinderMentionDialog", "context", "Landroid/content/Context;", "finderMention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
public abstract class bh<T extends com.tencent.mm.plugin.finder.model.a> extends e<T> {
    private final int scene;
    private final int tDB;

    public abstract void a(h hVar, T t);

    public bh(int i2, int i3) {
        this.tDB = i2;
        this.scene = i3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.tencent.mm.plugin.finder.convert.bh<T extends com.tencent.mm.plugin.finder.model.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        int i4;
        com.tencent.mm.plugin.finder.model.a aVar2 = (com.tencent.mm.plugin.finder.model.a) aVar;
        p.h(hVar, "holder");
        p.h(aVar2, "item");
        View Mn = hVar.Mn(R.id.in3);
        p.g(Mn, "holder.getView<TextView>(R.id.time_tv)");
        Context context = hVar.getContext();
        y yVar = y.vXH;
        ((TextView) Mn).setText(k.k(context, y.Lz(aVar2.uNF.field_createTime)));
        a(hVar, aVar2);
        View Mn2 = hVar.Mn(R.id.a2r);
        p.g(Mn2, "holder.getView<TextView>(R.id.before_split_tv)");
        TextView textView = (TextView) Mn2;
        if (aVar2.uNG) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        if (!aVar2.uNF.isOverlap()) {
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.cl);
            View Mn3 = hVar.Mn(R.id.x1);
            if (Mn3 != null) {
                Mn3.getLayoutParams().width = dimensionPixelSize;
                Mn3.getLayoutParams().height = dimensionPixelSize;
            }
        } else {
            Context context3 = hVar.getContext();
            p.g(context3, "holder.context");
            int dimensionPixelSize2 = context3.getResources().getDimensionPixelSize(R.dimen.cl);
            Context context4 = hVar.getContext();
            p.g(context4, "holder.context");
            int dimensionPixelSize3 = context4.getResources().getDimensionPixelSize(R.dimen.ci);
            View Mn4 = hVar.Mn(R.id.g7w);
            if (Mn4 != null) {
                Mn4.getLayoutParams().width = dimensionPixelSize2;
                Mn4.getLayoutParams().height = dimensionPixelSize2;
            }
            View Mn5 = hVar.Mn(R.id.g7t);
            if (Mn5 != null) {
                Mn5.getLayoutParams().width = dimensionPixelSize3;
                Mn5.getLayoutParams().height = dimensionPixelSize3;
            }
            View Mn6 = hVar.Mn(R.id.g7v);
            if (Mn6 != null) {
                Mn6.getLayoutParams().width = dimensionPixelSize3;
                Mn6.getLayoutParams().height = dimensionPixelSize3;
            }
        }
        ImageView imageView = (ImageView) hVar.Mn(R.id.ebr);
        if (imageView != null && (imageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            if (this.scene == 2) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                    layoutParams = null;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    Context context5 = hVar.getContext();
                    p.g(context5, "holder.context");
                    layoutParams2.setMargins(context5.getResources().getDimensionPixelOffset(R.dimen.cb), 0, 0, 0);
                }
            } else {
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                if (!(layoutParams3 instanceof LinearLayout.LayoutParams)) {
                    layoutParams3 = null;
                }
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                if (layoutParams4 != null) {
                    Context context6 = hVar.getContext();
                    p.g(context6, "holder.context");
                    layoutParams4.setMargins(context6.getResources().getDimensionPixelOffset(R.dimen.cb), 0, 0, 0);
                }
            }
        }
        TextView textView2 = (TextView) hVar.Mn(R.id.a2r);
        if (textView2 != null) {
            textView2.setTextSize(1, 14.0f);
        }
        if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            hVar.aus.setOnLongClickListener(new a(this, hVar, aVar2));
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return this.tDB;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class a implements View.OnLongClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ bh tES;
        final /* synthetic */ com.tencent.mm.plugin.finder.model.a tET;

        a(bh bhVar, h hVar, com.tencent.mm.plugin.finder.model.a aVar) {
            this.tES = bhVar;
            this.qhp = hVar;
            this.tET = aVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(243190);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMsgConvert$onBindViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            ao aoVar = this.tET.uNF;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("feedId", d.zs(aoVar.field_objectId));
            jSONObject.put("feedTime", Util.formatUnixTime(((long) aoVar.field_createTime) * 1000));
            jSONObject.put(ch.COL_USERNAME, aoVar.field_username);
            jSONObject.put("nickName", aoVar.field_nickname);
            jSONObject.put("id", d.zs(aoVar.field_id));
            FinderDebugUIC.a aVar = FinderDebugUIC.wvw;
            String jSONObject2 = jSONObject.toString();
            p.g(jSONObject2, "json.toString()");
            FinderDebugUIC.a.aG(context, jSONObject2);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderMsgConvert$onBindViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(243190);
            return true;
        }
    }
}
