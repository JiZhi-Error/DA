package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b;
import com.tencent.mm.plugin.textstatus.emoji.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\rH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeScrollView;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeViewHolder$IAlternativePyViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIEmojiSubTypeSelectListener", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiSubTypeSelectListener;", "typeName", "", "initView", "", "onSubTypeClick", "position", "itemView", "Landroid/view/View;", "setIEmojiSubTypeSelectListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "plugin-textstatus_release"})
public final class ImeEmojiSubTypeScrollView extends RecyclerView implements k.a {
    public static final a Vdf = new a((byte) 0);
    private b Vde;
    private String typeName;

    static {
        AppMethodBeat.i(258356);
        AppMethodBeat.o(258356);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImeEmojiSubTypeScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(258354);
        AppMethodBeat.o(258354);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImeEmojiSubTypeScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        int i4 = 0;
        p.h(context, "context");
        AppMethodBeat.i(258355);
        this.typeName = "emoji";
        switch (context.obtainStyledAttributes(attributeSet, b.a.ImeEmojiSubTypeScrollView, i2, 0).getInt(0, 1)) {
            case 1:
                this.typeName = "emoji";
                break;
            case 2:
                this.typeName = "kaoemoji";
                break;
        }
        Log.d("WxIme.ImeEmojiSubTypeScrollView", "initView");
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        m mVar = m.Vdq;
        Context context2 = getContext();
        p.g(context2, "context");
        linearLayoutManager.ca(m.dn(context2, this.typeName).size());
        linearLayoutManager.setItemPrefetchEnabled(true);
        setLayoutManager(linearLayoutManager);
        m mVar2 = m.Vdq;
        String byr = m.byr(this.typeName);
        m mVar3 = m.Vdq;
        Context context3 = getContext();
        p.g(context3, "context");
        Iterator<j> it = m.dn(context3, this.typeName).iterator();
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
            } else if (p.j(it.next().typeName, byr)) {
                i3 = i4;
            } else {
                i4++;
            }
        }
        String str = this.typeName;
        m mVar4 = m.Vdq;
        Context context4 = getContext();
        p.g(context4, "context");
        setAdapter(new i(str, m.dn(context4, this.typeName), i3, this));
        m mVar5 = m.Vdq;
        Context context5 = getContext();
        p.g(context5, "context");
        setItemViewCacheSize(m.dn(context5, this.typeName).size());
        Log.d("WxIme.ImeEmojiSubTypeScrollView", "init " + this.typeName + ' ' + byr + ' ' + i3);
        AppMethodBeat.o(258355);
    }

    public final void setIEmojiSubTypeSelectListener(b bVar) {
        AppMethodBeat.i(258352);
        p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.Vde = bVar;
        AppMethodBeat.o(258352);
    }

    @Override // com.tencent.mm.plugin.textstatus.emoji.k.a
    public final void r(int i2, View view) {
        AppMethodBeat.i(258353);
        p.h(view, "itemView");
        Log.d("WxIme.ImeEmojiSubTypeScrollView", "onSubTypeClick ".concat(String.valueOf(i2)));
        b bVar = this.Vde;
        if (bVar != null) {
            bVar.q(i2, view);
            AppMethodBeat.o(258353);
            return;
        }
        AppMethodBeat.o(258353);
    }
}
