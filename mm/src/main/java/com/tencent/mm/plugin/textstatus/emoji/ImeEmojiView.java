package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.emoji.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020,H\u0016J\u0012\u00100\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00010#H\u0016J\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiSubTypeSelectListener;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "currentEmojiType", "", "deleteContainerRv", "getDeleteContainerRv", "()Landroid/widget/RelativeLayout;", "deleteContainerRv$delegate", "Lkotlin/Lazy;", "emojiContentContainerRv", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView;", "getEmojiContentContainerRv", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView;", "emojiContentContainerRv$delegate", "emojiSubTypeContainerRv", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeScrollView;", "getEmojiSubTypeContainerRv", "()Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeScrollView;", "emojiSubTypeContainerRv$delegate", "imeEmojiPagerScrllHelper", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/textstatus/emoji/IKeyboardActionListener;", "pageSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/OnEmojiRecentSelectedListener;", "initView", "", "onClick", "v", "Landroid/view/View;", "onEmojiSubTypeClick", "position", "itemView", "setOnKeyboardActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTabSelected", "groupIndex", "Companion", "plugin-textstatus_release"})
public final class ImeEmojiView extends RelativeLayout implements View.OnClickListener, b {
    public static final a Vdn = new a((byte) 0);
    private final l VcJ;
    private c VcK;
    private String Vdh;
    private final kotlin.f Vdi;
    private final kotlin.f Vdj;
    private final kotlin.f Vdk;
    private final h Vdl;
    private final h.a Vdm;

    static {
        AppMethodBeat.i(258372);
        AppMethodBeat.o(258372);
    }

    private final RelativeLayout getDeleteContainerRv() {
        AppMethodBeat.i(258366);
        RelativeLayout relativeLayout = (RelativeLayout) this.Vdk.getValue();
        AppMethodBeat.o(258366);
        return relativeLayout;
    }

    private final ImeEmojiContentScrollView getEmojiContentContainerRv() {
        AppMethodBeat.i(258365);
        ImeEmojiContentScrollView imeEmojiContentScrollView = (ImeEmojiContentScrollView) this.Vdj.getValue();
        AppMethodBeat.o(258365);
        return imeEmojiContentScrollView;
    }

    private final ImeEmojiSubTypeScrollView getEmojiSubTypeContainerRv() {
        AppMethodBeat.i(258364);
        ImeEmojiSubTypeScrollView imeEmojiSubTypeScrollView = (ImeEmojiSubTypeScrollView) this.Vdi.getValue();
        AppMethodBeat.o(258364);
        return imeEmojiSubTypeScrollView;
    }

    public static final /* synthetic */ ImeEmojiContentScrollView a(ImeEmojiView imeEmojiView) {
        AppMethodBeat.i(258373);
        ImeEmojiContentScrollView emojiContentContainerRv = imeEmojiView.getEmojiContentContainerRv();
        AppMethodBeat.o(258373);
        return emojiContentContainerRv;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ImeEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImeEmojiView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private ImeEmojiView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(258371);
        this.Vdh = "emoji";
        this.Vdi = g.ah(new d(this));
        this.Vdj = g.ah(new c(this));
        this.Vdk = g.ah(new b(this));
        this.Vdl = new h();
        this.Vdm = new e(this);
        this.VcJ = new f(this);
        Log.d("WxIme.ImeEmojiView", "initView");
        aa.jQ(getContext()).inflate(R.layout.cfw, (ViewGroup) this, true);
        getEmojiSubTypeContainerRv().setIEmojiSubTypeSelectListener(this);
        getEmojiContentContainerRv().setRecentSelectedListener(this.VcJ);
        this.Vdl.VcY = this.Vdm;
        this.Vdl.f(getEmojiContentContainerRv());
        getDeleteContainerRv().setOnClickListener(this);
        AppMethodBeat.o(258371);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView$pageSelectedListener$1", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-textstatus_release"})
    public static final class e implements h.a {
        final /* synthetic */ ImeEmojiView Vdo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(ImeEmojiView imeEmojiView) {
            this.Vdo = imeEmojiView;
        }

        @Override // com.tencent.mm.plugin.textstatus.emoji.h.a
        public final void onPageSelected(int i2) {
            AppMethodBeat.i(258363);
            if (i2 < 0 || i2 >= ImeEmojiView.a(this.Vdo).getEmojiList().size()) {
                AppMethodBeat.o(258363);
                return;
            }
            this.Vdo.setTabSelected(i2);
            AppMethodBeat.o(258363);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView$recentSelectedListener$1", "Lcom/tencent/mm/plugin/textstatus/emoji/OnEmojiRecentSelectedListener;", "onSelecte", "", "typeName", "", "plugin-textstatus_release"})
    public static final class f implements l {
        final /* synthetic */ ImeEmojiView Vdo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(ImeEmojiView imeEmojiView) {
            this.Vdo = imeEmojiView;
        }
    }

    public final void setOnKeyboardActionListener(c cVar) {
        AppMethodBeat.i(258367);
        this.VcK = cVar;
        ImeEmojiContentScrollView emojiContentContainerRv = getEmojiContentContainerRv();
        if (emojiContentContainerRv != null) {
            emojiContentContainerRv.setOnKeyboardActionListener(cVar);
            AppMethodBeat.o(258367);
            return;
        }
        AppMethodBeat.o(258367);
    }

    public final void setTabSelected(int i2) {
        AppMethodBeat.i(258368);
        Log.i("WxIme.ImeEmojiView", "setTabSelected: %s", Integer.valueOf(i2));
        m mVar = m.Vdq;
        Context context = getContext();
        p.g(context, "context");
        ArrayList<j> dn = m.dn(context, this.Vdh);
        if (i2 >= 0 && i2 < dn.size()) {
            RecyclerView.a adapter = getEmojiSubTypeContainerRv().getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.emoji.ImeEmojiSubTypeAdapter");
                AppMethodBeat.o(258368);
                throw tVar;
            }
            i iVar = (i) adapter;
            Context context2 = getContext();
            p.g(context2, "context");
            p.h(context2, "context");
            Log.i("WxIme.ImeEmojiSubTypeAdapter", "setSelection: %s", Integer.valueOf(i2));
            if (iVar.va != i2) {
                iVar.ci(iVar.va);
                iVar.va = i2;
                iVar.ci(iVar.va);
                m mVar2 = m.Vdq;
                String str = iVar.typeName;
                m mVar3 = m.Vdq;
                m.iC(str, m.dn(context2, iVar.typeName).get(i2).typeName);
            }
            ImeEmojiSubTypeScrollView emojiSubTypeContainerRv = getEmojiSubTypeContainerRv();
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(emojiSubTypeContainerRv, a2.axQ(), "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
            emojiSubTypeContainerRv.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(emojiSubTypeContainerRv, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView", "setTabSelected", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(258368);
    }

    @Override // com.tencent.mm.plugin.textstatus.emoji.b
    public final void q(int i2, View view) {
        AppMethodBeat.i(258369);
        p.h(view, "itemView");
        setTabSelected(i2);
        ImeEmojiContentScrollView emojiContentContainerRv = getEmojiContentContainerRv();
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(emojiContentContainerRv, a2.axQ(), "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        emojiContentContainerRv.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(emojiContentContainerRv, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView", "onEmojiSubTypeClick", "(ILandroid/view/View;)V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(258369);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(258370);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        c cVar = this.VcK;
        if (cVar != null) {
            cVar.hXo();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(258370);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeScrollView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<ImeEmojiSubTypeScrollView> {
        final /* synthetic */ ImeEmojiView Vdo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ImeEmojiView imeEmojiView) {
            super(0);
            this.Vdo = imeEmojiView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImeEmojiSubTypeScrollView invoke() {
            AppMethodBeat.i(258362);
            ImeEmojiSubTypeScrollView imeEmojiSubTypeScrollView = (ImeEmojiSubTypeScrollView) this.Vdo.findViewById(R.id.juo);
            AppMethodBeat.o(258362);
            return imeEmojiSubTypeScrollView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<ImeEmojiContentScrollView> {
        final /* synthetic */ ImeEmojiView Vdo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ImeEmojiView imeEmojiView) {
            super(0);
            this.Vdo = imeEmojiView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImeEmojiContentScrollView invoke() {
            AppMethodBeat.i(258361);
            ImeEmojiContentScrollView imeEmojiContentScrollView = (ImeEmojiContentScrollView) this.Vdo.findViewById(R.id.jul);
            AppMethodBeat.o(258361);
            return imeEmojiContentScrollView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ ImeEmojiView Vdo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ImeEmojiView imeEmojiView) {
            super(0);
            this.Vdo = imeEmojiView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(258360);
            RelativeLayout relativeLayout = (RelativeLayout) this.Vdo.findViewById(R.id.jtm);
            AppMethodBeat.o(258360);
            return relativeLayout;
        }
    }
}
