package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0005;<=>?B1\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020%H\u0002J.\u0010(\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0002J\u000e\u00102\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u00103\u001a\u00020%2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u0010\u00107\u001a\u00020%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u00108\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u00010\u0019J\u0006\u0010:\u001a\u00020%R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006@"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "Landroid/widget/LinearLayout;", "Landroid/widget/AdapterView$OnItemClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "color", "Landroid/support/annotation/ColorRes;", "inAnim", "", "<set-?>", "isExpanded", "()Z", "listView", "Landroid/widget/ListView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "mOnItemStateChanged", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "getMOnItemStateChanged", "()Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "setMOnItemStateChanged", "(Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;)V", "mainContainer", "Landroid/widget/FrameLayout;", "selectedItemName", "", "getSelectedItemName", "()Ljava/lang/String;", "directlyClose", "", "expand", "initView", "onItemClick", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "pushDown", "pushUp", "setColor", "setItems", "items", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "setListener", "setOnItemStateChanged", "onItemStateChanged", "triggerExpand", "Companion", "DropdownListAdapter", "DropdownListItem", "IOnListItemSelected", "OnItemStateChanged", "app_release"})
public final class DropdownListView extends LinearLayout implements AdapterView.OnItemClickListener {
    public static final a KtB = new a((byte) 0);
    e KtA;
    private d Ktx;
    private b Kty;
    private android.support.annotation.a Ktz;
    private ListView krb;
    boolean qkb;
    FrameLayout xpS;
    boolean xpW;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"})
    public interface d {
        void a(c cVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "", "onItemStateChanged", "", "expanded", "", "app_release"})
    public interface e {
    }

    static {
        AppMethodBeat.i(231043);
        AppMethodBeat.o(231043);
    }

    public DropdownListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
    }

    public DropdownListView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 8);
    }

    private DropdownListView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(231041);
        setOrientation(1);
        this.xpS = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = this.xpS;
        if (frameLayout == null) {
            p.hyc();
        }
        frameLayout.setVisibility(8);
        addView(this.xpS, layoutParams);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        Context context2 = getContext();
        p.g(context2, "context");
        frameLayout2.setBackgroundColor(context2.getResources().getColor(R.color.ac));
        frameLayout2.setOnClickListener(new f(this));
        FrameLayout frameLayout3 = this.xpS;
        if (frameLayout3 == null) {
            p.hyc();
        }
        frameLayout3.addView(frameLayout2, layoutParams2);
        RoundedCornerFrameLayout roundedCornerFrameLayout = new RoundedCornerFrameLayout(getContext());
        roundedCornerFrameLayout.s(0.0f, 0.0f, (float) at.fromDPToPix(getContext(), 8), (float) at.fromDPToPix(getContext(), 8));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 48;
        FrameLayout frameLayout4 = this.xpS;
        if (frameLayout4 == null) {
            p.hyc();
        }
        frameLayout4.addView(roundedCornerFrameLayout, layoutParams3);
        this.krb = new ListView(getContext());
        ListView listView = this.krb;
        if (listView == null) {
            p.hyc();
        }
        listView.setCacheColorHint(0);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            p.hyc();
        }
        listView2.setOnItemClickListener(this);
        roundedCornerFrameLayout.addView(this.krb, new RelativeLayout.LayoutParams(-1, -2));
        Context context3 = getContext();
        p.g(context3, "context");
        this.Kty = new b(context3);
        ListView listView3 = this.krb;
        if (listView3 == null) {
            p.hyc();
        }
        listView3.setAdapter((ListAdapter) this.Kty);
        AppMethodBeat.o(231041);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private /* synthetic */ DropdownListView(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2, (byte) 0);
        AppMethodBeat.i(231042);
        AppMethodBeat.o(231042);
    }

    public final void setListener(d dVar) {
        this.Ktx = dVar;
    }

    public final void setColor(android.support.annotation.a aVar) {
        AppMethodBeat.i(231036);
        p.h(aVar, "color");
        this.Ktz = aVar;
        AppMethodBeat.o(231036);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ DropdownListView KtG;

        f(DropdownListView dropdownListView) {
            this.KtG = dropdownListView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(231029);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/DropdownListView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.KtG.dSg();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231029);
        }
    }

    public final void setItems(List<c> list) {
        String str;
        AppMethodBeat.i(231037);
        p.h(list, "items");
        b bVar = this.Kty;
        if (bVar == null) {
            p.hyc();
        }
        p.h(list, "items");
        bVar.KtC = list;
        if (list.isEmpty()) {
            str = "";
        } else {
            str = list.get(0).name;
        }
        bVar.bfp(str);
        AppMethodBeat.o(231037);
    }

    public final e getMOnItemStateChanged() {
        return this.KtA;
    }

    public final void setMOnItemStateChanged(e eVar) {
        this.KtA = eVar;
    }

    public final void setOnItemStateChanged(e eVar) {
        this.KtA = eVar;
    }

    public final String getSelectedItemName() {
        AppMethodBeat.i(231038);
        b bVar = this.Kty;
        if (bVar == null) {
            p.hyc();
        }
        String str = bVar.KtD;
        if (str == null) {
            p.hyc();
        }
        AppMethodBeat.o(231038);
        return str;
    }

    public final void dSg() {
        boolean z;
        AppMethodBeat.i(231039);
        if (!this.qkb) {
            z = true;
        } else {
            z = false;
        }
        if (this.qkb == z) {
            Log.d("MicroMsg.DropdownListView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.qkb));
            AppMethodBeat.o(231039);
        } else if (this.xpW) {
            Log.d("MicroMsg.DropdownListView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.o(231039);
        } else if (this.qkb) {
            this.xpW = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dr);
            loadAnimation.setAnimationListener(new h(this));
            ListView listView = this.krb;
            if (listView == null) {
                p.hyc();
            }
            listView.startAnimation(loadAnimation);
            AppMethodBeat.o(231039);
        } else {
            this.xpW = true;
            FrameLayout frameLayout = this.xpS;
            if (frameLayout == null) {
                p.hyc();
            }
            frameLayout.setVisibility(0);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.dn);
            loadAnimation2.setAnimationListener(new g(this));
            ListView listView2 = this.krb;
            if (listView2 == null) {
                p.hyc();
            }
            listView2.startAnimation(loadAnimation2);
            AppMethodBeat.o(231039);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushDown$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"})
    public static final class g implements Animation.AnimationListener {
        final /* synthetic */ DropdownListView KtG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(DropdownListView dropdownListView) {
            this.KtG = dropdownListView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(231030);
            p.h(animation, "animation");
            AppMethodBeat.o(231030);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(231031);
            p.h(animation, "animation");
            AppMethodBeat.o(231031);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(231032);
            p.h(animation, "animation");
            this.KtG.qkb = true;
            this.KtG.xpW = false;
            if (this.KtG.getMOnItemStateChanged() != null && this.KtG.getMOnItemStateChanged() == null) {
                p.hyc();
            }
            AppMethodBeat.o(231032);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/pluginsdk/ui/tools/DropdownListView$pushUp$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"})
    public static final class h implements Animation.AnimationListener {
        final /* synthetic */ DropdownListView KtG;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(DropdownListView dropdownListView) {
            this.KtG = dropdownListView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(231033);
            p.h(animation, "animation");
            AppMethodBeat.o(231033);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(231034);
            p.h(animation, "animation");
            AppMethodBeat.o(231034);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(231035);
            p.h(animation, "animation");
            FrameLayout frameLayout = this.KtG.xpS;
            if (frameLayout == null) {
                p.hyc();
            }
            frameLayout.setVisibility(8);
            this.KtG.qkb = false;
            this.KtG.xpW = false;
            if (this.KtG.getMOnItemStateChanged() != null && this.KtG.getMOnItemStateChanged() == null) {
                p.hyc();
            }
            AppMethodBeat.o(231035);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(231040);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        p.h(view, "view");
        b bVar2 = this.Kty;
        if (bVar2 == null) {
            p.hyc();
        }
        c aiO = bVar2.aiO(i2);
        if (aiO == null) {
            Log.d("MicroMsg.DropdownListView", "get item failed:".concat(String.valueOf(i2)));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(231040);
            return;
        }
        if (this.Ktx != null) {
            d dVar = this.Ktx;
            if (dVar == null) {
                p.hyc();
            }
            dVar.a(aiO);
        }
        b bVar3 = this.Kty;
        if (bVar3 == null) {
            p.hyc();
        }
        bVar3.bfp(aiO.name);
        b bVar4 = this.Kty;
        if (bVar4 == null) {
            p.hyc();
        }
        bVar4.notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/DropdownListView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(231040);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "", "name", "", "iconResId", "", "iconColor", "type", "(Ljava/lang/String;III)V", "getIconColor", "()I", "setIconColor", "(I)V", "getIconResId", "setIconResId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getType", "setType", "app_release"})
    public static final class c {
        String name;
        int noe;
        int type;
        int uzt = R.color.FG_0;

        public c(String str, int i2, int i3) {
            p.h(str, "name");
            AppMethodBeat.i(231028);
            this.name = str;
            this.noe = i2;
            this.type = i3;
            AppMethodBeat.o(231028);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter;", "Landroid/widget/BaseAdapter;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listItems", "", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "selectItemName", "", "itemName", "selectedItemName", "getSelectedItemName", "()Ljava/lang/String;", "setSelectedItemName", "(Ljava/lang/String;)V", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setItems", "", "items", "Companion", "ViewHolder", "app_release"})
    public static final class b extends BaseAdapter {
        public static final a KtE = new a((byte) 0);
        List<c> KtC = new ArrayList();
        String KtD = "";
        private final Context mContext;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter$ViewHolder;", "", "()V", "iconIV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIV", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIV", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "line", "Landroid/view/View;", "getLine", "()Landroid/view/View;", "setLine", "(Landroid/view/View;)V", "nameTV", "Landroid/widget/TextView;", "getNameTV", "()Landroid/widget/TextView;", "setNameTV", "(Landroid/widget/TextView;)V", "selectedIV", "Landroid/widget/ImageView;", "getSelectedIV", "()Landroid/widget/ImageView;", "setSelectedIV", "(Landroid/widget/ImageView;)V", "app_release"})
        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.DropdownListView$b$b  reason: collision with other inner class name */
        static final class C2031b {
            View KtF;
            WeImageView hex;
            TextView kgE;
            ImageView xps;
        }

        static {
            AppMethodBeat.i(231027);
            AppMethodBeat.o(231027);
        }

        public b(Context context) {
            p.h(context, "mContext");
            AppMethodBeat.i(231026);
            this.mContext = context;
            AppMethodBeat.o(231026);
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(231024);
            c aiO = aiO(i2);
            AppMethodBeat.o(231024);
            return aiO;
        }

        public final void bfp(String str) {
            AppMethodBeat.i(231021);
            String nullAs = Util.nullAs(str, "");
            p.g(nullAs, "Util.nullAs(itemName, \"\")");
            this.KtD = nullAs;
            AppMethodBeat.o(231021);
        }

        public final int getCount() {
            AppMethodBeat.i(231022);
            int size = this.KtC.size();
            AppMethodBeat.o(231022);
            return size;
        }

        public final c aiO(int i2) {
            AppMethodBeat.i(231023);
            c cVar = this.KtC.get(i2);
            AppMethodBeat.o(231023);
            return cVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2031b bVar;
            AppMethodBeat.i(231025);
            p.h(viewGroup, "parent");
            Log.i("MicroMsg.DropdownListAdapter", "duanyi test getView:".concat(String.valueOf(i2)));
            c aiO = aiO(i2);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a08, viewGroup, false);
                C2031b bVar2 = new C2031b();
                bVar2.hex = (WeImageView) view.findViewById(R.id.e2f);
                bVar2.kgE = (TextView) view.findViewById(R.id.e38);
                bVar2.xps = (ImageView) view.findViewById(R.id.hiz);
                bVar2.KtF = view.findViewById(R.id.e2u);
                p.g(view, "convertView");
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.DropdownListView.DropdownListAdapter.ViewHolder");
                    AppMethodBeat.o(231025);
                    throw tVar;
                }
                bVar = (C2031b) tag;
            }
            if (p.j(this.KtD, aiO.name)) {
                ImageView imageView = bVar.xps;
                if (imageView == null) {
                    p.hyc();
                }
                imageView.setVisibility(0);
            } else {
                ImageView imageView2 = bVar.xps;
                if (imageView2 == null) {
                    p.hyc();
                }
                imageView2.setVisibility(4);
            }
            if (i2 < getCount() - 1) {
                View view2 = bVar.KtF;
                if (view2 == null) {
                    p.hyc();
                }
                view2.setVisibility(0);
            } else {
                View view3 = bVar.KtF;
                if (view3 == null) {
                    p.hyc();
                }
                view3.setVisibility(8);
            }
            WeImageView weImageView = bVar.hex;
            if (weImageView == null) {
                p.hyc();
            }
            weImageView.setImageDrawable(this.mContext.getResources().getDrawable(aiO.noe));
            WeImageView weImageView2 = bVar.hex;
            if (weImageView2 == null) {
                p.hyc();
            }
            weImageView2.setIconColor(this.mContext.getResources().getColor(aiO.uzt));
            TextView textView = bVar.kgE;
            if (textView == null) {
                p.hyc();
            }
            textView.setVisibility(0);
            TextView textView2 = bVar.kgE;
            if (textView2 == null) {
                p.hyc();
            }
            textView2.setText(aiO.name);
            AppMethodBeat.o(231025);
            return view;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListAdapter$Companion;", "", "()V", "TAG", "", "app_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
