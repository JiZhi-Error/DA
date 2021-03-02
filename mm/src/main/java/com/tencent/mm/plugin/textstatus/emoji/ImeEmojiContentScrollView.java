package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.textstatus.g.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u0013H\u0016R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mm/plugin/textstatus/emoji/IEmojiContentViewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "emojiList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getEmojiList", "()Ljava/util/ArrayList;", "mKeyboardActionListener", "Lcom/tencent/mm/plugin/textstatus/emoji/IKeyboardActionListener;", "recentSelectedListener", "Lcom/tencent/mm/plugin/textstatus/emoji/OnEmojiRecentSelectedListener;", "getRecentSelectedListener", "()Lcom/tencent/mm/plugin/textstatus/emoji/OnEmojiRecentSelectedListener;", "setRecentSelectedListener", "(Lcom/tencent/mm/plugin/textstatus/emoji/OnEmojiRecentSelectedListener;)V", "initView", "", "onEmojiClick", "emojiStr", "", "setOnKeyboardActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "plugin-textstatus_release"})
public final class ImeEmojiContentScrollView extends RecyclerView implements a {
    public static final a VcL = new a((byte) 0);
    private final ArrayList<j> VcI;
    private l VcJ;
    private c VcK;

    static {
        AppMethodBeat.i(258326);
        AppMethodBeat.o(258326);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final ArrayList<j> getEmojiList() {
        return this.VcI;
    }

    public final l getRecentSelectedListener() {
        return this.VcJ;
    }

    public final void setRecentSelectedListener(l lVar) {
        this.VcJ = lVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImeEmojiContentScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(258324);
        AppMethodBeat.o(258324);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImeEmojiContentScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(258325);
        this.VcI = new ArrayList<>();
        initView();
        AppMethodBeat.o(258325);
    }

    private void initView() {
        AppMethodBeat.i(258322);
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("WxIme.ImeEmojiContentScrollView", "initView ".concat(String.valueOf(currentTimeMillis)));
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        ArrayList<j> arrayList = this.VcI;
        m mVar = m.Vdq;
        Context context = getContext();
        p.g(context, "context");
        arrayList.addAll(m.dn(context, "emoji"));
        Context context2 = getContext();
        p.g(context2, "context");
        setAdapter(new d(context2, this.VcI, this));
        m mVar2 = m.Vdq;
        String byr = m.byr("emoji");
        Iterator<j> it = this.VcI.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (p.j(it.next().typeName, byr)) {
                break;
            } else {
                i2++;
            }
        }
        com.tencent.mm.hellhoundlib.b.a a2 = c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(this, a2.axQ(), "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
        scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/emoji/ImeEmojiContentScrollView", "initView", "()V", "Undefined", "scrollToPosition", "(I)V");
        Log.i("WxIme.ImeEmojiContentScrollView", "initView " + currentTimeMillis + ' ' + (System.currentTimeMillis() - currentTimeMillis) + ' ' + hashCode());
        AppMethodBeat.o(258322);
    }

    @Override // com.tencent.mm.plugin.textstatus.emoji.a
    public final void byp(String str) {
        AppMethodBeat.i(258323);
        p.h(str, "emojiStr");
        Log.d("WxIme.ImeEmojiContentScrollView", "onEmojiClick ".concat(String.valueOf(str)));
        new ac().content = str;
        c cVar = this.VcK;
        if (cVar != null) {
            cVar.byq(str);
            AppMethodBeat.o(258323);
            return;
        }
        AppMethodBeat.o(258323);
    }

    public final void setOnKeyboardActionListener(c cVar) {
        this.VcK = cVar;
    }
}
